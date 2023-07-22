package net.royal.erp.asistencia.dao;

import java.util.Date;

import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcion;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcionPk;
import net.royal.framework.web.dao.GenericoDao;

// TODO: Auto-generated Javadoc
/**
 * The Interface AsEmpleadoexcepcionDao.
 */
public interface AsEmpleadoexcepcionDao extends
		GenericoDao<AsEmpleadoexcepcion, AsEmpleadoexcepcionPk> {
	
	
/**
 * Obtener tiene programacion.
 *
 * @param parEmpleado the par empleado
 * @param parFecha the par fecha
 * @power-builder f_get_tiene_reprogramacion
 * @return the integer
 */
public Integer obtenerTieneProgramacion(Integer parEmpleado,Date parFecha);
}
