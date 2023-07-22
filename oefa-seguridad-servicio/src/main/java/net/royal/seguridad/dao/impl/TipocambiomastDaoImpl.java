package net.royal.seguridad.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.seguridad.dao.ExchangerateDao;
import net.royal.seguridad.dao.ParametrosmastDao;
import net.royal.seguridad.dao.TipocambiomastDao;
import net.royal.seguridad.dominio.Exchangerate;
import net.royal.seguridad.dominio.Tipocambiomast;
import net.royal.seguridad.dominio.TipocambiomastPk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("tipocambiomastDaoImplSeguridad")
public class TipocambiomastDaoImpl extends
		GenericoDaoImpl<Tipocambiomast, TipocambiomastPk> implements
		TipocambiomastDao {

	private static Log LOGGER = LogFactory.getLog(Tipocambiomast.class);

	private ParametrosmastDao parametrosmastDao;
	private ExchangerateDao exchangerateDao;

	public TipocambiomastDaoImpl() {
		super("seguridad.tipocambiomast");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public BigDecimal obtenerFactor(Date fecha, String rateType) {
		Tipocambiomast tipocambiomast = null;
		BigDecimal rate = null;
		BigDecimal wFactorcomprasbs = null;
		BigDecimal wFactorventasbs = null;

		// == 1 =================================
		if (rateType.equals("P") || rateType.equals("C")
				|| rateType.equals("V") || rateType.equals("CS")
				|| rateType.equals("VS")) {
			String rateDaily = parametrosmastDao.obtenerValorCadena("999999",
					"SY", "RATEDAILY");
			if (rateDaily == null)
				rateDaily = "";
			if (rateDaily.equals("S")) {
				tipocambiomast = this.obtenerTipoCambio(fecha, "EX", "LO");
				if (!UValidador.esNulo(tipocambiomast)) {
					if (rateType.length() == 0) {
						rate = tipocambiomast.getFactor();
					} else {
						if (rateType.equals("P")) {
							rate = tipocambiomast.getFactorpromedio();
						}
						if (rateType.equals("C")) {
							rate = tipocambiomast.getFactorcompra();
						}
						if (rateType.equals("V")) {
							rate = tipocambiomast.getFactorventa();
						}
						if (rateType.equals("CS")) {
							rate = tipocambiomast.getFactorcomprasbs();
						}
						if (rateType.equals("VS")) {
							rate = tipocambiomast.getFactorventasbs();
						}
					}
				}
				return rate;
			}
		}
		// == 2 =================================
		// exchangerate
		if (rateType.equals("S") || rateType.equals("T")) {
			Exchangerate exchangerate = exchangerateDao
					.obtenerPorPeriodo(fecha);
			if (exchangerate != null) {
				wFactorcomprasbs = exchangerate.getSbsrate();
				wFactorventasbs = exchangerate.getSbsrate();
			}
		} else {
			tipocambiomast = this.obtenerTipoCambioMaximo(fecha, "EX", "LO");
			wFactorcomprasbs = tipocambiomast.getFactorcomprasbs();
			wFactorventasbs = tipocambiomast.getFactorventasbs();
		}

		// == 3 =================================
		if (rateType.length() == 0) {
			rate = tipocambiomast.getFactor();
		} else {
			if (rateType.equals("P")) {
				rate = tipocambiomast.getFactorpromedio();
			}
			if (rateType.equals("C")) {
				rate = tipocambiomast.getFactorcompra();
			}
			if (rateType.equals("V")) {
				rate = tipocambiomast.getFactorventa();
			}
			if (rateType.equals("VS")) {
				rate = tipocambiomast.getFactorventasbs();
			}
			if (rateType.equals("CS")) {
				rate = tipocambiomast.getFactorcomprasbs();
			}
			if (rateType.equals("S")) {
				rate = wFactorventasbs;
			}
			if (rateType.equals("T")) {
				rate = wFactorcomprasbs;
			}
		}

		return rate;
	}

	public Tipocambiomast obtenerTipoCambioMaximo(Date fecha,
			String monedaCodigo, String monedaCambioCodigo) {
		Tipocambiomast tipo = null;
		Criteria cri = this.getCriteria();

		cri.add(Restrictions.eq("pk.monedacodigo", monedaCodigo));
		cri.add(Restrictions.eq("pk.monedacambiocodigo", monedaCambioCodigo));
		cri.add(Restrictions.le("pk.fechacambio", fecha));
		cri.addOrder(Order.desc("pk.fechacambio"));
		cri.setMaxResults(1);

		List<Tipocambiomast> list = this.listarPorCriterios(cri);

		if (list == null)
			return null;
		if (list.size() != 1)
			return null;
		return list.get(0);
	}

	public Tipocambiomast obtenerTipoCambio(Date fecha, String monedaCodigo,
			String monedaCambioCodigo) {
		String fechaCadena = null;
		fechaCadena = UFechaHora.formatearFecha(fecha, "yyyyMMdd");

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.monedacodigo", monedaCodigo));
		cri.add(Restrictions.eq("pk.monedacambiocodigo", monedaCambioCodigo));
		cri.add(Restrictions.eq("fechacambiostring", fechaCadena));
		List<Tipocambiomast> list = this.listarPorCriterios(cri);

		if (list == null)
			return null;
		if (list.size() != 1)
			return null;
		return list.get(0);
	}

	@Autowired
	public void setParametrosmastDao(ParametrosmastDao parametrosmastDao) {
		this.parametrosmastDao = parametrosmastDao;
	}

	@Autowired
	public void setExchangerateDao(ExchangerateDao exchangerateDao) {
		this.exchangerateDao = exchangerateDao;
	}

}
