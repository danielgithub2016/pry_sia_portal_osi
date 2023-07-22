package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.dto.DtoHrEncuestapreguntavalores;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrEncuestapreguntavaloresServicio extends GenericoServicio {
	public List<DtoHrEncuestapreguntavalores> listarValores(Integer secuencia,
			String tipoEncuesta);
}
