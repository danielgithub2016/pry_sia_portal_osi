package net.royal.erp.asistencia.servicio;

import net.royal.erp.asistencia.dominio.AsCarnetidentificacion;
import net.royal.framework.web.servicio.GenericoServicio;

public interface AsCarnetidentificacionServicio extends GenericoServicio {

	public String obtenerMaximoComportamientoSobretiempo(Integer empleado);

	public String obtenerMaximoCodigoCarnet(Integer empleado);

	public String obtenerCodigoCarnet(Integer empleado);

	public Integer obtenerMaximoEmpleadoXCarnet(String w_carnet);

	public String obtenerMaximoCodigoCarnetActivo(Integer empleado);

	public AsCarnetidentificacion obtenerPorEmplado(Integer empleado);

}
