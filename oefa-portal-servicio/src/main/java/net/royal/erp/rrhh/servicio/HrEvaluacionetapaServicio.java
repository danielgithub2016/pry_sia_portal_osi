package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwRequerimientoevaletapasEdit;
import net.royal.framework.web.servicio.GenericoServicio;

/**
 * The Interface HrEvaluacionetapaServicio.
 */
public interface HrEvaluacionetapaServicio extends GenericoServicio {
	
	/**
	 * Listar etapa por evaluacion.
	 *
	 * @powerbuilder dw_hr_requerimientoevaletapas_edit
	 * @param requerimiento the requerimiento
	 * @param companyowner the companyowner
	 * @return the list
	 */
	public List<DtoDwRequerimientoevaletapasEdit> listarEtapaPorEvaluacion(String requerimiento, String companyowner);
}
