package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

import net.royal.erp.rrhh.dominio.HrEvaluacionarea;
import net.royal.erp.rrhh.dominio.HrEvaluacionareaPk;
import net.royal.erp.rrhh.dominio.dto.DtoHrEvaluacion;

public interface HrEvaluacionServicio extends GenericoServicio {

	public List<DtoHrEvaluacion> listarDescripcion();
}
