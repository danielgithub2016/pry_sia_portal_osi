package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.AfetypemstDao;
import net.royal.erp.core.servicio.AfetypemstServicio;

import net.royal.erp.core.dominio.Afetypemst;
import net.royal.erp.core.dominio.AfetypemstPk;

@Service(value = "BeanServicioAfetypemst")
public class AfetypemstServicioImpl extends GenericoServicioImpl implements
		AfetypemstServicio {

	private AfetypemstDao dao;

	private static Log LOGGER = LogFactory.getLog(AfetypemstServicioImpl.class);

	@Autowired
	public void setDao(AfetypemstDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public List<Afetypemst> listarTipoProyecto(){
		return dao.listarTipoProyecto();
	}
}
