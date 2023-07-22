package net.royal.erp.planilla.servicio;

import java.util.Date;
import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

import net.royal.erp.planilla.dominio.PrProcesoperiodo;

public interface PrProcesoperiodoServicio extends GenericoServicio {
	public List<PrProcesoperiodo> listarPeriodosXPlanilla(String planilla);
	@SuppressWarnings("rawtypes")
	public List listarProcesoXPlanillaPeriodo(String planilla, String periodo);
	
	public Date obtenerFechaPagoBoleta(String periodo, String planilla, String proceso);
}
