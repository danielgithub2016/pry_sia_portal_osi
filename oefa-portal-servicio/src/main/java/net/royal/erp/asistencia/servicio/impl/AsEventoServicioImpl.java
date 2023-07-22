package net.royal.erp.asistencia.servicio.impl;

import java.util.List;

import net.royal.erp.asistencia.dao.AsEventoDao;
import net.royal.erp.asistencia.dominio.AsEvento;
import net.royal.erp.asistencia.servicio.AsEventoServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsEvento")
public class AsEventoServicioImpl extends GenericoServicioImpl implements
		AsEventoServicio {

	private AsEventoDao dao;

	private static Log LOGGER = LogFactory.getLog(AsEventoServicioImpl.class);

	@Autowired
	public void setDao(AsEventoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public AsEvento listarPorConceptoAcceso(String conceptoacceso) {
		// TODO Auto-generated method stub

		AsEvento resultado = null;
		Criteria cri = dao.getCriteria();
		cri.add(Restrictions.eq("conceptoacceso", conceptoacceso));

		List<AsEvento> data = dao.listarPorCriterios(cri);

		if (!UValidador.esListaVacia(data)) {
			resultado = data.get(0);
		}
		return resultado;
	}

}
