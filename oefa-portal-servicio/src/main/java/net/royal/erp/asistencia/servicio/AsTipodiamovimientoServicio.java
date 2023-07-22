package net.royal.erp.asistencia.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

public interface AsTipodiamovimientoServicio extends GenericoServicio {

	public List obtenerMaxHoraInicioMaxHoraFin(Integer tipodia);
	
	public List obtenerHoraInicioFlagDiaAnterior(Integer tipodia);
	
	public List obtenerHoraFin(Integer tipodia);
	
	public List obtenerMaxIntervaloAcceso(Integer tipodia);
	
	public List obtenerIntervaloRefrigerio(Integer tipodia);
	
	public List listar(Integer tipodia);
	
}
