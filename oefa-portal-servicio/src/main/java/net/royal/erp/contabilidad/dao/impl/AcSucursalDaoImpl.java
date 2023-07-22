package net.royal.erp.contabilidad.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import net.royal.erp.contabilidad.dao.AcSucursalDao;
import net.royal.erp.contabilidad.dominio.AcSucursal;
import net.royal.erp.contabilidad.dominio.AcSucursalPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@Repository
public class AcSucursalDaoImpl extends GenericoDaoImpl<AcSucursal, AcSucursalPk> implements AcSucursalDao {

	private static Log LOGGER = LogFactory.getLog(AcSucursalDaoImpl.class);

	public AcSucursalDaoImpl() {
		super("acsucursal");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<AcSucursal> obtenerLista(String tipo, String valor) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));

		if (tipo.equals("S")) {
			cri.add(Restrictions.eq("pk.sucursal", valor));
			cri.addOrder(Order.asc("pk.sucursal"));
		} else if (tipo.equals("D")) {
			if (!UValidador.esNulo(valor)) {

				cri.add(Restrictions.sqlRestriction(" UPPER(DESCRIPCIONLOCAL) LIKE '" + valor.trim() + "%' "));
				cri.addOrder(Order.asc("descripcionlocal"));
			}
		} else {
			LOGGER.debug("no entra a  ninguna condicion");
		}

		List result = this.listarPorCriterios(cri);
		return result;
	}

	/**
	 * f_sql_read_sucursal_name
	 */
	@Override
	public String obtenerNombreSucursal(String par_sucursal) {
		LOGGER.debug("test de sycommon.f_sql_read_sucursal_name");

		String sucursal = par_sucursal;

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));
		cri.add(Restrictions.eq("pk.sucursal", par_sucursal));

		List<AcSucursal> result = this.listarPorCriterios(cri);
		if (!UValidador.esListaVacia(result)) {
			sucursal = result.get(0).getDescripcionlocal();
		}

		return sucursal;

	}

	@Override
	public List<AcSucursal> listarSucursalesActivas() {
		return this.listarPorCriterios(this.getCriteria().add(Restrictions.eq("estado", "A")));
	}

	@Override
	public List<AcSucursal> listarSucursalSeguridad(String todo, String... sucursales) {
		Criteria cri = this.getCriteria();
		if (!UValidador.validarFlag(todo)) {
			cri.add(Restrictions.in("pk.sucursal", sucursales));
		}
		return this.listarPorCriterios(cri);
	}

}
