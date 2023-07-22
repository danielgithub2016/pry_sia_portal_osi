package net.royal.erp.asistencia.servicio;

import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcion;
import net.royal.framework.web.servicio.GenericoServicio;

public interface AsEmpleadoexcepciondetalleServicio extends GenericoServicio {

	public Integer obtenertipodiadescanso(Integer empleado, Date fecha);


}
