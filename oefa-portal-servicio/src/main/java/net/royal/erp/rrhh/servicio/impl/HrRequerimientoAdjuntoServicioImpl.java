package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dao.HrRequerimientoAdjuntoDao;
import net.royal.erp.rrhh.dominio.HrRequerimientoAdjunto;
import net.royal.erp.rrhh.servicio.HrRequerimientoAdjuntoServicio;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioHrRequerimientoAdjuntoServicio")
public class HrRequerimientoAdjuntoServicioImpl extends GenericoServicioImpl
		implements HrRequerimientoAdjuntoServicio {

	private HrRequerimientoAdjuntoDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrRequerimientoAdjuntoServicioImpl.class);

	@Autowired
	public void setDao(HrRequerimientoAdjuntoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrRequerimientoAdjunto> obtenerListadoArchivos(
			String requerimiento, String compania) {
		Criteria criteria = dao.getCriteria();
		criteria.add(Restrictions.eq("pk.requerimiento", requerimiento));
		criteria.add(Restrictions.eq("pk.companyowner", compania));
		criteria.addOrder(Order.asc("pk.secuencia"));

		return dao.listarPorCriterios(criteria);
	}

	@Override
	@Transactional
	public void eliminarArchivosAdjuntos(String requerimiento, String compania) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();

		parametros.add(new ParametroPersistenciaGenerico("p_requerimiento",
				String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("p_compania",
				String.class, compania));

		dao.ejecutarPorQuery("hrrequerimientoadjunto.eliminarArchivo",
				parametros);

	}

}
