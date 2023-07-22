package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.CuentabancariaDao;
import net.royal.erp.core.servicio.CuentabancariaServicio;

import net.royal.erp.core.dominio.Cuentabancaria;
import net.royal.erp.core.dominio.CuentabancariaPk;

@Service (value = "BeanServicioCuentabancaria")
public class CuentabancariaServicioImpl extends GenericoServicioImpl implements CuentabancariaServicio {

	private CuentabancariaDao dao;

	private static Log LOGGER = LogFactory.getLog(CuentabancariaServicioImpl.class);

	@Autowired
	public void setDao(CuentabancariaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
