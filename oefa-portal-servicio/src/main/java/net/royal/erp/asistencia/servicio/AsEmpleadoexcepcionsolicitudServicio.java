package net.royal.erp.asistencia.servicio;

import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcionsolicitud;
import net.royal.framework.web.servicio.GenericoServicio;

public interface AsEmpleadoexcepcionsolicitudServicio extends GenericoServicio {

	public List<AsEmpleadoexcepcionsolicitud> listarEmpleadoExcepcionSolicitud(Integer p_empleado,
			Date p_fechasolicitud);
	
}
