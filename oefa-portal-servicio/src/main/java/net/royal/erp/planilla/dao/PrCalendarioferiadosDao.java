package net.royal.erp.planilla.dao;

import java.util.Date;

import net.royal.erp.planilla.dominio.PrCalendarioferiados;
import net.royal.erp.planilla.dominio.PrCalendarioferiadosPk;
import net.royal.framework.web.dao.GenericoDao;

public interface PrCalendarioferiadosDao extends GenericoDao<PrCalendarioferiados, PrCalendarioferiadosPk> {
	
	public Boolean esFeriado(Date date) throws Exception;
	
	public Date agregarFechasHabiles(Date date, Integer dias) throws Exception;

}
