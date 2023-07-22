package net.royal.erp.planilla.servicio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.royal.erp.planilla.dominio.PrVacacionesprogramadas;
import net.royal.erp.planilla.dominio.dto.DtoDwPrVacacionesProgramadas;
import net.royal.erp.planilla.dominio.dto.DtoPrVacacionPeriodo;
import net.royal.erp.planilla.dominio.dto.DtoPrVacacionUtilizacion;
import net.royal.erp.planilla.dominio.dto.DtoPrVacacionesprogramadas;
import net.royal.framework.web.servicio.GenericoServicio;

public interface PrVacacionesprogramadasServicio extends GenericoServicio {

	public BigDecimal obtenerMaximoVacacionesProgramadas(Integer empleado, String periodo);

	public List<PrVacacionesprogramadas> listarVacacionesProgramadas(Integer empleado, String periodoasistencia,
			Date fechainicio, Date fechafin);

	public List<PrVacacionesprogramadas> listarVacacionesEjecutadas(Integer empleado, String periodoasistencia,
			Date fechainicio, Date fechafin);

	public Integer contarVacacionesUtilizacion(Integer empleado, Date fechainicio, Date fechafin);

	/**
	 * Listar reporte programadas.
	 *
	 * @powerbuilder dw_pr_vacaciones_programadas
	 * @param estado
	 *            the estado
	 * @param ano
	 *            the ano
	 * @param empleado
	 *            the empleado
	 * @param compania
	 *            the compania
	 * @param tipoplanilla
	 *            the tipoplanilla
	 * @return the list
	 */
	public List<DtoDwPrVacacionesProgramadas> listarReporteProgramadas(String estado, String ano, Integer empleado,
			String compania, String tipoplanilla);

	public List<DtoPrVacacionPeriodo> obtenerPendientesNroPeriodoPorEmpleado(Integer empleado, Date fecha,
			Date fechainiOriginal, Date fechafinOriginal, String accion, String concepto);

	public List<DtoPrVacacionesprogramadas> obtenerDiasUitlesPorEmpleado(Integer empleado);

	public List<DtoPrVacacionPeriodo> obtenerDerechoPorEmpleado(Integer empleado, Integer periodo);

	public void eliminarVacacionPago(Integer empleado, Date fechainicio, Date fechafin);

	public void sinEfectoVacacionUtilizacion(Integer empleado, String compania, Date fecha, Date Fechafin);

	public void sinEfectoVacacionProgramda(Integer empleado, String periodo, Date fecha, Date Fechafin);

	public List<DtoPrVacacionPeriodo> listarVacacionPeriodo(Integer empleado);

	public List<DtoPrVacacionUtilizacion> listarVacacionUtilizacion(Integer empleado, Integer periodo);

}
