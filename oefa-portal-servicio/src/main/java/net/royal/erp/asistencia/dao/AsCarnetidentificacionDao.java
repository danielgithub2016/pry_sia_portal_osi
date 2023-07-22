package net.royal.erp.asistencia.dao;

import net.royal.erp.asistencia.dominio.AsCarnetidentificacion;
import net.royal.erp.asistencia.dominio.AsCarnetidentificacionPk;
import net.royal.framework.web.dao.GenericoDao;

public interface AsCarnetidentificacionDao extends
		GenericoDao<AsCarnetidentificacion, AsCarnetidentificacionPk> {

	public String obtenerMaximoCodigoCarnet(Integer w_empleado);
	
	public Integer obtenerMaximoEmpleadoXCarnet(String w_carnet);
	
	public String obtenerMaximoComportamientoSobretiempo(Integer empleado);
	
	public String obtenerMaximoCodigoCarnetActivo(Integer w_empleado);
}
