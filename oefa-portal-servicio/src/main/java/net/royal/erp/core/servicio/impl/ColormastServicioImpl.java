package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.ColormastDao;
import net.royal.erp.core.servicio.ColormastServicio;

import net.royal.erp.core.dominio.Colormast;
import net.royal.erp.core.dominio.ColormastPk;

@Service(value = "BeanServicioColormast")
public class ColormastServicioImpl extends GenericoServicioImpl implements
		ColormastServicio {

	private ColormastDao dao;

	private static Log LOGGER = LogFactory.getLog(ColormastServicioImpl.class);

	@Autowired
	public void setDao(ColormastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
