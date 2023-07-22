package net.royal.erp.asistencia.servicio;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

public interface AsPeriodoServicio extends GenericoServicio {

	public Integer obtenerMaximoPeriodoPlanilla();

	public Integer obtenerCantidad();

	public List obtenerRangoFechas(String periodo);

	public Integer obtenerCantidadPorEmpleado(Integer empleado, Date fecha,
			Date fechafin);

	public Integer obtenerCantidadPorEmpleadoNoAdmin(Integer empleado,
			Date fecha, Date fechafin);

	/**
	 * f_calculate_period_first_and_last_day
	 */
	public List calcularperiodoRango(String par_period) throws ParseException;

	public Date[] obtenerFechasActivas(String flgadmin) throws ParseException;
}
