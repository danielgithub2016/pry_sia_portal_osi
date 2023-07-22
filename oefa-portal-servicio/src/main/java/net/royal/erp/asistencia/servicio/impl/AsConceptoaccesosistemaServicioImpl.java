package net.royal.erp.asistencia.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.asistencia.dao.AsConceptoaccesosistemaDao;
import net.royal.erp.asistencia.servicio.AsConceptoaccesosistemaServicio;

import net.royal.erp.asistencia.dominio.AsConceptoaccesosistema;
import net.royal.erp.asistencia.dominio.AsConceptoaccesosistemaPk;

@Service(value = "BeanServicioAsConceptoaccesosistema")
public class AsConceptoaccesosistemaServicioImpl extends GenericoServicioImpl
		implements AsConceptoaccesosistemaServicio {

	private AsConceptoaccesosistemaDao dao;

	private static Log LOGGER = LogFactory
			.getLog(AsConceptoaccesosistemaServicioImpl.class);

	@Autowired
	public void setDao(AsConceptoaccesosistemaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
