package net.royal.erp.asistencia.servicio;

import java.util.Date;

import net.royal.framework.web.servicio.GenericoServicio;

public interface AsAutorizacionfechaServicio extends GenericoServicio {

	public Integer obtenercantidadAutorizacionFecha(Integer empleado,
			Date desde);

}
