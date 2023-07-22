package net.royal.erp.planilla.servicio;

import java.util.Date;

import net.royal.framework.web.servicio.GenericoServicio;

public interface PrCalendarioferiadosServicio extends GenericoServicio {
	
	public Boolean esFeriado(Date date) throws Exception;
	
	public Date agregarFechasHabiles(Date date, Integer dias) throws Exception;

}
