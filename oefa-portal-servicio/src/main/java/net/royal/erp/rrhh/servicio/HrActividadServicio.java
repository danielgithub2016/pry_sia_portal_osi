package net.royal.erp.rrhh.servicio;

import java.util.Date;
import java.util.List;

import net.royal.erp.rrhh.dominio.dto.DtoHrActividad;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrActividadServicio extends GenericoServicio {
	public List<DtoHrActividad> listarHrActividad(String flg_publicacion,
			Date fecha_actual, String estado,Integer empleado);
}
