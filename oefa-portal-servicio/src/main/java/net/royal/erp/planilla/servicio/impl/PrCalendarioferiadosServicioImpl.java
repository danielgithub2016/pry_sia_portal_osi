package net.royal.erp.planilla.servicio.impl;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.planilla.dao.PrCalendarioferiadosDao;
import net.royal.erp.planilla.servicio.PrCalendarioferiadosServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service (value = "BeanServicioPrCalendarioferiados")
public class PrCalendarioferiadosServicioImpl extends GenericoServicioImpl implements PrCalendarioferiadosServicio {

	private PrCalendarioferiadosDao dao;

	private static Log LOGGER = LogFactory.getLog(PrCalendarioferiadosServicioImpl.class);

	@Autowired
	public void setDao(PrCalendarioferiadosDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Boolean esFeriado(Date date) throws Exception {
		return dao.esFeriado(date);
	}

	@Override
	public Date agregarFechasHabiles(Date date, Integer dias) throws Exception {
		return dao.agregarFechasHabiles(date, dias);
	}

}
