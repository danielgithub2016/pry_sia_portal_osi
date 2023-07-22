package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.UltimonumeropagoDao;
import net.royal.erp.core.servicio.UltimonumeropagoServicio;

import net.royal.erp.core.dominio.Ultimonumeropago;
import net.royal.erp.core.dominio.UltimonumeropagoPk;

@Service (value = "BeanServicioUltimonumeropago")
public class UltimonumeropagoServicioImpl extends GenericoServicioImpl implements UltimonumeropagoServicio {

	private UltimonumeropagoDao dao;

	private static Log LOGGER = LogFactory.getLog(UltimonumeropagoServicioImpl.class);

	@Autowired
	public void setDao(UltimonumeropagoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
