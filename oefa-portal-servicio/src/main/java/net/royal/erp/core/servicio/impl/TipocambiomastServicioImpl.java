package net.royal.erp.core.servicio.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.royal.erp.core.dao.TipocambiomastDao;
import net.royal.erp.core.servicio.TipocambiomastServicio;
import net.royal.framework.web.dominio.MensajeUsuario;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioTipocambiomast")
public class TipocambiomastServicioImpl extends GenericoServicioImpl implements
		TipocambiomastServicio {

	private TipocambiomastDao dao;

	private static Log LOGGER = LogFactory
			.getLog(TipocambiomastServicioImpl.class);

	@Autowired
	public void setDao(TipocambiomastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
