package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.BancoDao;
import net.royal.erp.core.servicio.BancoServicio;

import net.royal.erp.core.dominio.Banco;
import net.royal.erp.core.dominio.BancoPk;

@Service (value = "BeanServicioBanco")
public class BancoServicioImpl extends GenericoServicioImpl implements BancoServicio {

	private BancoDao dao;

	private static Log LOGGER = LogFactory.getLog(BancoServicioImpl.class);

	@Autowired
	public void setDao(BancoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
