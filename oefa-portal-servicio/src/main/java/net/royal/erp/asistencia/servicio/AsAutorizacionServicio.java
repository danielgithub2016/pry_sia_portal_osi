package net.royal.erp.asistencia.servicio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.dominio.dto.DtoAsAutorizacion;
import net.royal.erp.asistencia.dominio.dto.DtoPermisosEnCompensacion;
import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.servicio.GenericoServicio;

public interface AsAutorizacionServicio extends GenericoServicio {

	public void generarAsistenciaOnomastico() throws Exception;

	public Integer obtenercantidad(Integer empleado, long ll_d_1, long ll_h_1, long ll_d_2, long ll_h_2,
			String conceptoacceso, String ls_similares_2, String ls_similares_3, String ls_similares_4,
			String ls_similares_5, String ls_similares_6, String ls_similares_7, String ls_similares_8,
			String ls_similares_2_all, String w_CategoriaAutorizacion, String ls_similares);

	public Integer obtenercantidad2(Integer empleado, Date fecha, String conceptoacceso, Date desde);

	public Integer obtenercantidad3(Integer empleado, Date fecha, String conceptoacceso, Date desde);

	public List obtenerFechaVeces(Integer empleado, Integer p_year, Date p_fecha);

	public void eliminarAutorizacion(Integer empleado, Date fecha, String conceptoacceso, Date fechadesde);

	public void eliminarAutorizacionFecha(Integer empleado, Date fecha);

	public Integer obtenerEmpleado(Integer empleado, Date desde1, Date fecha, String conceptoacceso);

	public void eliminarAutorizacion2(Integer empleado, Date fechaoriginal, Date fechadesdeoriginal,
			String conceptoaccesooriginal);

	public void insertarAutorizacion(Integer empleado, Date fecha, String conceptoacceso, Date desde1, Date hasta1,
			String refrigerio, String periodo, String mandatario, String observacion, String solicitadopor,
			Date fechasolicitud, String ultimousuario, Date ultimafechamodificacion, Integer sobretiempo, String estado,
			String comportmientosobretiempo, String categoriaautorizacion, Integer tipohorario, String flagcorrido,
			String ruta, String tipoautorizacion, String resolucion);

	public void insertarAutorizacion2(Integer empleado, Date fecha, String conceptoacceso, Date desde1, Date hasta1,
			String refrigerio, String periodo, String mandatario, String observacion, String solicitadopor,
			Date fechasolicitud, String ultimousuario, Date ultimafechamodificacion, String estado,
			String comportmientosobretiempo, String categoriaautorizacion, Integer tipohorario, String flagcorrido,
			Integer terminal);

	public void actualizarAutorizacion(Date fecha, Date fechafin, Date desde1, Date hasta1, String refrigerio,
			String periodo, String mandatario, Integer tipohorario, String observacion, String autorizadopor,
			String ultimousuario, Date ultimafechamodificacion, String ruta, String resolucion, Integer empleado,
			Date fecha2, Date fechadesde, String conceptoacceso);

	public Integer obtenerEmpleado2(Integer empleado, Date fecha, Date desde1, String conceptoacceso);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asmain.f_as_autorizacion_cambio_horario
	 */
	public Integer autorizarCambioHorario(UsuarioActual usuarioActual, Integer empleado, Date fecha, Date fechaFin,
			Integer tipoHorario);

	public Integer obtenerCantidadPapeletaFechas(BigDecimal empleado, Date fecha, Date fechahasta,
			Date fechainiOriginal, Date fechafinOriginal);

	public BigDecimal contarEmpleadosFeriadosHoras(Date fechadesde, Date fechahasta, String flgperiodo,
			String adicionales, Integer sid, String tipo);

	public List listarLicenciasSinGoce(Integer empleado);

	public Integer obtenercantidadedicion(Integer empleado, long ll_d_1, long ll_h_1, long ll_d_2, long ll_h_2,
			String conceptoacceso, String ls_similares_2, String ls_similares_3, String ls_similares_4,
			String ls_similares_5, String ls_similares_6, String ls_similares_7, String ls_similares_8,
			String ls_similares_2_all, String w_CategoriaAutorizacion, String ls_similares, Date fecha, String concepto,
			Date desde);

	public Date obtenermaximodesde(Integer empleado, Date fecha);

	public Integer contarvalidalicenciasempleado(Integer empleado, Date fechainicio, Date fechafin);

	public Integer contarPermisosSIGED(Integer empleado, String concepto);

	public Integer contarPermisosFechasSIGED(Integer empleado, String concepto, Date fechainicio, Date fechafin,
			Date fechainioriginal, Date fechafinoriginal) throws Exception;

	public Integer contarvalidavacacionesempleado(Integer empleado, Date fechainicio, Date fechafin,
			Integer maxperiodo);

	public Integer contarmaximoperiodovacaciones(Integer empleado);

	public Integer contarOmisionxMes(Integer empleado, Date fecha) throws Exception;

	public BigDecimal obtenerHorasSobreTiempo(Integer empleado, Date fechainicio, Date fechafin) throws Exception;

	public BigDecimal obtenerHorasSobreTiempo3(Integer empleado, Date fechainicio, Date fechafin) throws Exception;

	public BigDecimal obtenerMinutosSobreTiempo(Integer empleado, Date fecha, Date fechafin) throws Exception;

	public BigDecimal obtenerMinutosSobreTiempo2(Integer empleado, Date desde) throws Exception;

	public BigDecimal obtenerHorasSobreTiempo2(Integer empleado, String desde) throws Exception;

	public Integer contarLicencias(Integer empleado, Date fecha, Date fechafin);

	public BigDecimal obtenerHorasSobreTiempoAutorizado(Integer empleado) throws Exception;

	public BigDecimal sumarConRes(Integer empleado, String concepto, Date fechaini, Date fechafin, Date fechainiOrig,
			Date fechafinOrig) throws Exception;

	public Integer contarHijos(Integer empleado) throws Exception;

	public Integer contarPadresAbuelos(Integer empleado) throws Exception;

	public Integer contarHijosCumpleanios(Integer empleado, Date fecha) throws Exception;

	public Integer contarHijosMeses(Integer empleado, Date fecha, Integer meses) throws Exception;

	public Integer contarHijosConyugueCumpleanios(Integer empleado, Date fecha) throws Exception;

	public Integer contarCantidadEnfechasPorConcepto(Integer empleado, String concepto, Date fechaini, Date fechafin,
			Date fechaoriginal) throws Exception;

	public Integer contarCantidadDiasPorConcepto(Integer empleado, String concepto, Date fechaini, Date fechafin,
			Date fechaoriginal) throws Exception;

	public Integer contarHorasEnfechasPorConcepto(Integer empleado, String concepto, Date fechaini, Date fechafin,
			Date fechaoriginal) throws Exception;

	public Integer contarEnfechasPorTicket(Integer empleado, String concepto, Date fechaini, Date fechafin,
			Date fechaoriginal) throws Exception;

	public List listarSolicitudesPeriodo(Integer empleado, String concepto, Date fechainioriginal,
			Date fechafinoriginal, BigDecimal periodoactual);

	public BigDecimal obtenerHoraGanadas(Integer empleado, Date fechainicio, Date fechafin) throws Exception;

	public List<DtoPermisosEnCompensacion> listarPermisosCompensacion(Integer empleado, Integer anio) throws Exception;

	public List<DtoPermisosEnCompensacion> listarPermisosViernesVerano(Integer empleado, Date desde, Date hasta)
			throws Exception;

	public Date obtenerHorarioEmpleado(Integer empleado, Date fecha, String tipo) throws Exception;

	public List<DtoAsAutorizacion> obtenerlicenciasempleadoPorFecha(Integer empleado, Date fechainicio, Date fechafin);

	public List<DtoAsAutorizacion> obtenervacacionesempleadoPorFecha(Integer empleado, Date fechainicio, Date fechafin,
			Integer maxperiodo);

	public Integer contarSolicitudIngressoSST(String codigousuario, Date fecha) throws Exception;
}
