package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.PaisDao;
import net.royal.erp.core.servicio.PaisServicio;

import net.royal.erp.core.dominio.Pais;
import net.royal.erp.core.dominio.PaisPk;

@Service (value = "BeanServicioPais")
public class PaisServicioImpl extends GenericoServicioImpl implements PaisServicio {

	private PaisDao dao;

	private static Log LOGGER = LogFactory.getLog(PaisServicioImpl.class);

	@Autowired
	public void setDao(PaisDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<Pais> ListarPaisesxEstado() {
		
		return dao.ListarPaisesxEstado();
	}

}
