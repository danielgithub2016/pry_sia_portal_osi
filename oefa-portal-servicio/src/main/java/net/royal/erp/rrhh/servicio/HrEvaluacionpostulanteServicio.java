package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoevalentrevistaEditB;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoevalpostEdit2;
import net.royal.framework.web.servicio.GenericoServicio;

/**
 * The Interface HrEvaluacionpostulanteServicio.
 */
public interface HrEvaluacionpostulanteServicio extends GenericoServicio {

	/**
	 * Lista etapas por evaluacion.
	 * 
	 * @powerbuilder dw_hr_requerimientoevalentrevista_edit
	 * @param companyowner
	 *            the companyowner
	 * @param requerimiento
	 *            the requerimiento
	 * @return the list
	 */
	public List<DtoDwHrRequerimientoevalentrevistaEditB> listaEtapasPorEvaluacion(String companyowner,
			String requerimiento);

	/**
	 * Lista resumen etapa por evaluacion.
	 *
	 * @powerbuilder dw_hr_requerimientoevalpostedit_edit_2
	 * @param companyowner the companyowner
	 * @param requerimiento the requerimiento
	 * @return the list
	 */
	public List<DtoDwHrRequerimientoevalpostEdit2> listaResumenEtapaPorEvaluacion(String companyowner,
			String requerimiento);
}
