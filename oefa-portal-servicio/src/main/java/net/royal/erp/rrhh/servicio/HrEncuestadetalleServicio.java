package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.dto.DtoHrEncuestadetalle;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrEncuestadetalleServicio extends GenericoServicio {
	public List<DtoHrEncuestadetalle> listarDetalle(Integer secuencia,
			String tipoEncuesta);
}
