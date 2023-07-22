package net.royal.erp.core.dao.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.core.dao.ParametrosmastDao;
import net.royal.erp.core.dominio.Parametrosmast;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.MensajeUsuario.tipo_mensaje;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ParametrosmastDaoImpl extends GenericoDaoImpl<Parametrosmast, ParametrosmastPk>
		implements ParametrosmastDao {

	private static Log LOGGER = LogFactory.getLog(Parametrosmast.class);

	public ParametrosmastDaoImpl() {
		super("parametrosmast");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public String obtenerValorCadena(String parametroclave) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.parametroclave", parametroclave));
		cri.add(Restrictions.eq("estado", "A"));

		List<Parametrosmast> list = this.listarPorCriterios(cri);

		if (list == null)
			return null;
		if (list.size() != 1)
			return null;

		return list.get(0).getTexto();
	}

	@Override
	public String obtenerValorCadena(ParametrosmastPk pk) {

		Parametrosmast par = this.obtenerParametroActivo(pk);

		if (par == null)
			return null;

		return par.getTexto();
	}

	@Override
	public Integer obtenerValorInteger(ParametrosmastPk pk) {
		Parametrosmast par = this.obtenerParametroActivo(pk);

		if (par == null)
			return null;

		return par.getNumero();
	}

	@Override
	public BigDecimal obtenerValorDecimal(ParametrosmastPk pk) {
		Parametrosmast par = this.obtenerParametroActivo(pk);

		if (par == null)
			return null;

		return new BigDecimal(par.getNumero());
	}

	private Parametrosmast obtenerParametroActivo(ParametrosmastPk pk) {

		if (pk == null)
			return null;

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companiacodigo", pk.getCompaniacodigo()));
		cri.add(Restrictions.eq("pk.aplicacioncodigo", pk.getAplicacioncodigo()));
		cri.add(Restrictions.eq("pk.parametroclave", pk.getParametroclave()));
		cri.add(Restrictions.eq("estado", "A"));

		List<Parametrosmast> list = this.listarPorCriterios(cri);

		if (list == null)
			return null;
		if (list.size() != 1)
			return null;

		return list.get(0);
	}

	@Override
	public String obtenerValorDescripcion(ParametrosmastPk pk) {
		Parametrosmast par = this.obtenerParametroActivo(pk);
		if (par == null)
			return "";
		return par.getDescripcionparametro();
	}

	/**
	 * f_calculate_igv_difference
	 */

	@Override
	public String calcularIGVDiferencia(BigDecimal par_montoafecto, BigDecimal par_montoigv,
			BigDecimal str_global_gvigv) {

		LOGGER.debug("test de syfinan.f_calculate_igv_difference");

		BigDecimal w_igv;
		Integer w_difference;
		String mensaje = "";

		w_difference = obtenerValorInteger(new ParametrosmastPk("AP", "999999", "IGVDIFF"));

		w_igv = par_montoafecto.multiply(str_global_gvigv).setScale(2, RoundingMode.HALF_UP);
		w_igv = w_igv.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);

		Integer resulIGV = Math.abs(w_igv.subtract(par_montoigv).intValue());

		if (resulIGV > w_difference) {
			mensaje = "Error en IGV, El IGV ingresado excede al calculado por el Sistema = " + w_igv
					+ " en un monto mayor al permitido = " + w_difference;
		}
		return mensaje;
	}

	@Override
	public String obtenerValorExplicacion(ParametrosmastPk pk) {
		Parametrosmast obj = obtenerPorId(pk, false);
		if (!UValidador.esNulo(obj))
			return obj.getExplicacion();
		return null;
	}

}
