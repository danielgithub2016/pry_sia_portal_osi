package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.MaMiscelaneosheaderDao;
import net.royal.erp.core.servicio.MaMiscelaneosheaderServicio;

import net.royal.erp.core.dominio.MaMiscelaneosheader;
import net.royal.erp.core.dominio.MaMiscelaneosheaderPk;

@Service (value = "BeanServicioMaMiscelaneosheader")
public class MaMiscelaneosheaderServicioImpl extends GenericoServicioImpl implements MaMiscelaneosheaderServicio {

	private MaMiscelaneosheaderDao dao;

	private static Log LOGGER = LogFactory.getLog(MaMiscelaneosheaderServicioImpl.class);

	@Autowired
	public void setDao(MaMiscelaneosheaderDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
