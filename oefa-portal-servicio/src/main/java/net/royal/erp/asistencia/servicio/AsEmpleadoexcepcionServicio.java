package net.royal.erp.asistencia.servicio;

import java.util.Date;

import net.royal.framework.web.servicio.GenericoServicio;

public interface AsEmpleadoexcepcionServicio extends GenericoServicio {

	public void eliminarEmpleadoExcepcionSolicitud(Integer par_empleado, Date par_fecha);
}
