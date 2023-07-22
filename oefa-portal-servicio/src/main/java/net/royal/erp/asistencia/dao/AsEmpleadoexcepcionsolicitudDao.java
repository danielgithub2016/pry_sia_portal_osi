package net.royal.erp.asistencia.dao;

import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcionsolicitud;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcionsolicitudPk;
import net.royal.framework.web.dao.GenericoDao;

public interface AsEmpleadoexcepcionsolicitudDao
		extends
		GenericoDao<AsEmpleadoexcepcionsolicitud, AsEmpleadoexcepcionsolicitudPk> {

	/**
	 * @powerbuilder dw_cambio_horario_excepcion
	 * @return lista
	 */
	public List<AsEmpleadoexcepcionsolicitud> listarEmpleadoExcepcionSolicitud(Integer p_empleado,
			Date p_fechasolicitud);
}
