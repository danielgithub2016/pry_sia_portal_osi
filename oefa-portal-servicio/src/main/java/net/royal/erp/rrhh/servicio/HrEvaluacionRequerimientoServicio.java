package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.dto.DtoHrEvaluacionRequirimiento;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrEvaluacionRequerimientoServicio extends GenericoServicio {

	public List<DtoHrEvaluacionRequirimiento> listarDescripcion();
}
