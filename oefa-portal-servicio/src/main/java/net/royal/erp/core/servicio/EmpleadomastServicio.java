package net.royal.erp.core.servicio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.royal.erp.asistencia.dominio.dto.DtoAsPeriodo;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsAsistenciadiariaRpt;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001Empleado;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001Faltadia;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001Licencias;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001MarcaNew;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001ReporteOficialMinisterio;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001Sobretiempo;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001Vacacion;
import net.royal.erp.asistencia.dominio.dto.DtoFiltrosGenericos;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.dto.DtoEmpleadomast;
import net.royal.erp.core.dominio.dto.DtoPersonamast;
import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.servicio.GenericoServicio;

import org.springframework.transaction.annotation.Transactional;

public interface EmpleadomastServicio extends GenericoServicio {

	public Integer obtenerMaximoEmpleado(String userid);

	public Integer obtenerSolicitadoPor(String userid);

	public String obtenerSucursal(Integer empleado);

	public Integer obtenerUsuarioMaximo(String codigoUsuario);

	public Empleadomast obtenerEmpleadoMast(Integer p_empleado);

	public List<DtoPersonamast> obtenerPersonaReclutamiento();

	/**
	 * @powerbuilder wf_next_screen - selectSuelto <br>
	 *               hrproc.f_sql_get_areaopertiva <br>
	 *               w_hr_evaluacionperiodo_list_evaluar <br>
	 *               wf_retrieve_evaluador <br>
	 *               f_get_empleadoxusuario
	 * @param codigoUsuario
	 * @author nunezh
	 * @return
	 */
	public Empleadomast obtenerPorCodigoUsuario(String codigoUsuario);

	public String obtenerTipoContrato(Integer empleado);

	/**
	 * Obtener nombre cargo empleado.
	 *
	 * @powerbuilder hrothers.f_sql_get_cargodesc_empleado
	 * @author nunezh
	 * @param par_empleado
	 *            the par_empleado
	 * @param par_compania
	 *            the par_compania
	 * @return the string
	 */
	public String obtenerNombreCargoEmpleado(Integer par_empleado, String par_compania);

	public List listardwList(String sb);

	public List listarEmpleadoEval(String sb);

	public BigDecimal obtenerCodigoCargo(Integer empleado);

	public List<DtoDwAsRep001Empleado> listarEmpleadosReporteAsistencia(String todos, String empleado, Integer sid,
			String user, String compania, String centrocosto, String sucursal, String categoria, String tipoplanilla,
			Integer area, Integer cargo);

	public List<DtoDwAsRep001MarcaNew> listarEmpleadosReporteAsistenciaMarca(String todos, String empleado, Integer sid,
			String user, Date fechadesde, Date fechahasta);

	public List<DtoDwAsRep001Sobretiempo> listarEmpleadosReporteAsistenciaSobretiempo(String todos, String empleado,
			Integer sid, String user, Date fechadesde, Date fechahasta);

	public List<DtoDwAsRep001Faltadia> listarEmpleadosReporteAsistenciaFaltadia(String todos, String empleado,
			Integer sid, String user, Date fechadesde, Date fechahasta);

	public List<DtoDwAsRep001Vacacion> listarEmpleadosReporteAsistenciaVacacion(String todos, String empleado,
			Integer sid, String user, Date fechadesde, Date fechahasta);

	public List<DtoDwAsRep001Licencias> listarEmpleadosReporteAsistenciaLicencias(String todos, String empleado,
			Integer sid, String user);

	public List<DtoDwAsAsistenciadiariaRpt> listarReporteAsistenciaCasiDetallada(Integer empleado, Date desde,
			Date hasta, Integer sid, String user);

	@Transactional
	public List<DtoDwAsRep001ReporteOficialMinisterio> obtenerListaReporteAsistencia(UsuarioActual usuario,
			DtoFiltrosGenericos filtro) throws Exception;

	public List<DtoAsPeriodo> obtenerInasistencias(Integer empleado);

	public ParametroPaginacion listarActivosArea(ParametroPaginacion parametros);

	public List<DtoEmpleadomast> listarActivosArea(HashMap<String, Object> parametros);
}
