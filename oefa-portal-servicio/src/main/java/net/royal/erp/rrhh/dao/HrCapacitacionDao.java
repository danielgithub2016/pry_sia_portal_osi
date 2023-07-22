package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrCapacitacion;
import net.royal.erp.rrhh.dominio.HrCapacitacionPk;
import net.royal.erp.rrhh.dominio.dto.DtoHrCapacitacion;
import net.royal.framework.web.dao.GenericoDao;

// TODO: Auto-generated Javadoc
/**
 * The Interface HrCapacitacionDao.
 */
public interface HrCapacitacionDao extends
		GenericoDao<HrCapacitacion, HrCapacitacionPk> {

	/**
	 * TAB NECESIDADES DE CAPACITACION.
	 *
	 * @param curso the curso
	 * @param anioplan the anioplan
	 * @return the list
	 */
	public HrCapacitacion obtenerCapacitacionxparam(Integer curso, Integer anioplan);

	/**
	 * TAB de NECESIDADES DE CAPACITACION.
	 *
	 * @param w_capacitacion the w_capacitacion
	 * @return the list
	 */
	public HrCapacitacion obtenerAnioPlanxParam(String w_capacitacion);
	
	
	
	/**
	 * Listar por anio plan.
	 *
	 *@author nunezh
	 * @param anioPlan the anio plan
	 * @return the list
	 */
	public List<HrCapacitacion> listarPorAnioPlan(Integer anioPlan);
	
	public List<DtoHrCapacitacion> listarCapacitacionPublicadas(String tipoRegistro,String nombreCurso);
	
}
