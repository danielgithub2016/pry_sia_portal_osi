package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.TipopagoDao;
import net.royal.erp.core.servicio.TipopagoServicio;

import net.royal.erp.core.dominio.Tipopago;
import net.royal.erp.core.dominio.TipopagoPk;

@Service(value = "BeanServicioTipopago")
public class TipopagoServicioImpl extends GenericoServicioImpl implements
		TipopagoServicio {

	private TipopagoDao dao;

	private static Log LOGGER = LogFactory.getLog(TipopagoServicioImpl.class);

	@Autowired
	public void setDao(TipopagoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public List listarTipoPago(){
		return dao.listarTipoPago();
	}
}
