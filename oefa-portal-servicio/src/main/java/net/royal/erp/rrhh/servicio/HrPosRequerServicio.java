package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientopostEdit;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrPosRequerServicio extends GenericoServicio {

	public Integer obtenerCantidadPostulantes(String requerimiento, String compania);
	
	public Integer obtenerRequerimiento(String requerimiento, String compania);

	/**
	 * Lista postulantes candidatos.
	 *
	 * @param companyowner the companyowner
	 * @param requerimiento the requerimiento
	 * @param codigopuesto the codigopuesto
	 * @param validacion1 the validacion1
	 * @return the list
	 * @powerbuilder dw_hr_requerimientopost_edit
	 */
	public List<DtoDwHrRequerimientopostEdit> listaPostulantesCandidatos(String companyowner, String requerimiento,
			Integer codigopuesto,String validacion1);

	/**
	 * Obtener etapa actual.
	 *
	 * @param requerimiento the requerimiento
	 * @param commpanyowner the commpanyowner
	 * @return the integer
	 */
	public Integer obtenerEtapaActual(String requerimiento, String commpanyowner);
}
