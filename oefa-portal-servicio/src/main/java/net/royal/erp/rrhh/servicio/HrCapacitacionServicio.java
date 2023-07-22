package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrCapacitacion;
import net.royal.erp.rrhh.dominio.HrEmpleadocapacitacion;
import net.royal.erp.rrhh.dominio.dto.DtoHrCapacitacion;
import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrCapacitacionServicio extends GenericoServicio {

	/**
	 * Obtener capacitacionxparam.
	 *
	 * @param curso the curso
	 * @param anioplan the anioplan
	 * @return the hr capacitacion
	 */
	public HrCapacitacion obtenerCapacitacionxparam(Integer curso, Integer anioplan);

	/**
	 * Obtener anio planx param.
	 *
	 * @param w_capacitacion the w_capacitacion
	 * @return the hr capacitacion
	 */
	public HrCapacitacion obtenerAnioPlanxParam(String w_capacitacion);

	/**
	 * Listar por anio plan.
	 *
	 * @author nunezh
	 * @powerbuilder dw_hr_evaluacion_capacitacion_edit <br>
	 *               dw17
	 * @param anioPlan            the anio plan
	 * @return the list
	 */
	public List<HrCapacitacion> listarPorAnioPlan(Integer anioPlan);

	/**
	 * Listar capacitacion publicada.
	 *
	 * @param paginacion the paginacion
	 * @return the parametro paginacion
	 */
	public ParametroPaginacion listarCapacitacionPublicada(ParametroPaginacion paginacion);
	
	/**
	 * Listar capacitacion documento pendiente.
	 *
	 * @param paginacion the paginacion
	 * @return the parametro paginacion
	 */
	public ParametroPaginacion listarCapacitacionDocumentoPendiente(ParametroPaginacion paginacion);
	
	
	public List<DtoHrCapacitacion> listarCapacitacionPublicadas(String tipoRegistro,String nombreCurso);
	
	
}
