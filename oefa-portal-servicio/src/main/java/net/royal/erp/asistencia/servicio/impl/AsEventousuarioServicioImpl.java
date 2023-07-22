package net.royal.erp.asistencia.servicio.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.royal.erp.asistencia.dao.AsEventousuarioDao;
import net.royal.erp.asistencia.servicio.AsEventousuarioServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsEventousuario")
public class AsEventousuarioServicioImpl extends GenericoServicioImpl implements
		AsEventousuarioServicio {

	private AsEventousuarioDao dao;

	private static Log LOGGER = LogFactory
			.getLog(AsEventousuarioServicioImpl.class);

	@Autowired
	public void setDao(AsEventousuarioDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Integer obtenerMaximoIdEvento(String userid) {
		// TODO Auto-generated method stub
		Criteria cri = dao.getCriteria();
		cri.add(Restrictions.eq("pk.userid", userid));

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("pk.idevento"));

		cri.setProjection(proj);

		List lista = dao.listarPorCriterios(cri);

		if (UValidador.esListaVacia(lista))
			return null;

		return (Integer) lista.get(0);
		
	}

}
