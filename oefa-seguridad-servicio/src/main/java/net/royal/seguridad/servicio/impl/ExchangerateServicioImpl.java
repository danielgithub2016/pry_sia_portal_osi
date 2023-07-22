package net.royal.seguridad.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.ExchangerateDao;
import net.royal.seguridad.dominio.Exchangerate;
import net.royal.seguridad.dominio.ExchangeratePk;
import net.royal.seguridad.servicio.ExchangerateServicio;

@Service (value = "BeanServicioExchangerateSeguridad")
public class ExchangerateServicioImpl extends GenericoServicioImpl implements ExchangerateServicio {

	private ExchangerateDao dao;

	private static Log LOGGER = LogFactory.getLog(ExchangerateServicioImpl.class);

	@Autowired
	@Qualifier("exchangerateDaoImplSeguridad")
	public void setDao(ExchangerateDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
