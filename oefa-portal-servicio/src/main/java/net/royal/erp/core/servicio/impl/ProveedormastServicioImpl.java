package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.ProveedormastDao;
import net.royal.erp.core.servicio.ProveedormastServicio;
import net.royal.erp.core.dominio.Proveedormast;
import net.royal.erp.core.dominio.ProveedormastPk;

@Service (value = "BeanServicioProveedormast")
public class ProveedormastServicioImpl extends GenericoServicioImpl implements ProveedormastServicio {

	private ProveedormastDao dao;

	private static Log LOGGER = LogFactory.getLog(ProveedormastServicioImpl.class);

	@Autowired
	public void setDao(ProveedormastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Proveedormast obtenerProveedor(Integer proveedor) {
		return dao.obtenerProveedor(proveedor);
	}

}
