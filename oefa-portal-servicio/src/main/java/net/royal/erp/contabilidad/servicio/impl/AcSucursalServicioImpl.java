package net.royal.erp.contabilidad.servicio.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.contabilidad.dao.AcSucursalDao;
import net.royal.erp.contabilidad.dominio.AcSucursal;
import net.royal.erp.contabilidad.servicio.AcSucursalServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanAcSucursalServicio")
public class AcSucursalServicioImpl extends GenericoServicioImpl implements AcSucursalServicio {

	private AcSucursalDao dao;

	private static Log LOGGER = LogFactory.getLog(AcSucursalServicioImpl.class);

	@Autowired
	public void setDao(AcSucursalDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<AcSucursal> obtenerLista(String tipo, String valor) {
		return dao.obtenerLista(tipo, valor);
	}

	@Override
	public String obtenerNombreSucursal(String par_sucursal) {
		return dao.obtenerNombreSucursal(par_sucursal);
	}

	@Override
	public List DwMaAcSucursalSelect(String par_sucursal) {
		Criteria criteria = dao.getCriteria();
		criteria.add(Restrictions.eq("estado", "A"));
		if (!UValidador.esNulo(par_sucursal))
			criteria.add(Restrictions.eq("pk.sucursal", par_sucursal));

		return dao.listarPorCriterios(criteria);
	}

	@Override
	public List<AcSucursal> listarSucursalesActivas() {
		return dao.listarSucursalesActivas();
	}

	@Override
	public List<AcSucursal> listarSucursalSeguridad(String todo, String... sucursales) {
		return dao.listarSucursalSeguridad(todo, sucursales);
	}

}
