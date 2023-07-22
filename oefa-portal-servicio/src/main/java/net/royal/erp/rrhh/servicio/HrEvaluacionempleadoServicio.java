package net.royal.erp.rrhh.servicio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import net.royal.erp.rrhh.dominio.HrDetalleevaluacion;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacionmejora;
import net.royal.erp.rrhh.dominio.HrEmpleadocomentarios;
import net.royal.erp.rrhh.dominio.HrEmpleadoconsiderapotencial;
import net.royal.erp.rrhh.dominio.HrEmpleadodesempeno;
import net.royal.erp.rrhh.dominio.HrEmpleadofuncion;
import net.royal.erp.rrhh.dominio.HrEmpleadometas;
import net.royal.erp.rrhh.dominio.HrEmpleadorevision;
import net.royal.erp.rrhh.dominio.HrEvaluacionempleado;
import net.royal.erp.rrhh.dominio.HrEvaluacionempleadoPk;
import net.royal.erp.rrhh.dominio.dto.DtoHrDetalleEvaluacion;
import net.royal.erp.rrhh.dominio.dto.OwHrEvaluacionempleadoEdit;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacionDetailP;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacionEdit;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadonecesidadcapacitaEdit;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrIncidentecriticoList;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.dominio.MensajeUsuario;
import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrEvaluacionempleadoServicio extends GenericoServicio {

	/**
	 * @powerbuilder updateSuelto - objectStartEvent
	 * @powerbuilder w_hr_evaluacionperiodo_list_evaluar
	 * @param empleado
	 * @param secuenciaeval
	 */
	@Transactional
	public void actualizaEvaluacionEmpleado(Integer empleado,
			Integer secuenciaeval);

	/**
	 * Obtiene por pk, con la peculiaridad de que la búsqueda se hace por un <br>
	 * empleado evaluador <strong>diferente</strong> al recibido como parámetro.
	 *
	 * @powerbuilder consulta 'suelta' en <strong>wf_open</strong> de
	 *               <strong>horacle.w_hr_evaluacionempleado_edit</strong>
	 * @author nunezh
	 * @param pk
	 *            clase pk
	 * @return objeto <strong>HrEvaluacionempleado</strong>
	 */
	public HrEvaluacionempleado obtenerPorPkEvaluadorDiferente(
			HrEvaluacionempleadoPk pk);

	public Integer obtenerCantEmpleado(BigDecimal iv_empleado,
			BigDecimal lv_Secuencia);

	public void grabarEvaluacionEmpleado(String estado, Date wFecha,
			BigDecimal wPuntaje, Integer ivEmpleado, Integer ivSecuencia,
			String tipoEvaluador, String companyowner, Integer empleadoevaluador);

	public void grabarEvaluacionCompleta(
			DtoDwHrEmpleadoevaluacionEdit evaluacion);

	public void grabarTodaEvaluacion(
			DtoDwHrEmpleadoevaluacionEdit dw_evaluacion, StrPass strpass,
			List<DtoHrDetalleEvaluacion> dw1,
			List<DtoDwHrIncidentecriticoList> dw3,
			List<HrEmpleadodesempeno> dw5, List<HrEmpleadometas> dw6,
			List<DtoDwHrEmpleadonecesidadcapacitaEdit> dw7,
			List<DtoDwHrEmpleadoevaluacionDetailP> dw9,
			List<HrEmpleadoconsiderapotencial> dw10,
			List<HrEmpleadofuncion> dw11, List<HrDetalleevaluacion> dwCampo,
			List<HrEmpleadorevision> dwrevision,
			List<HrEmpleadocomentarios> dwComentario,
			List<HrDetalleevaluacionmejora> dwCompromisomejora,
			UsuarioActual usuario);

	public List<MensajeUsuario> validarTodaEvaluacion(
			DtoDwHrEmpleadoevaluacionEdit dw_evaluacion,
			OwHrEvaluacionempleadoEdit opciones, StrPass strpass,
			String ivAction, List<DtoHrDetalleEvaluacion> dw1,
			List<DtoDwHrEmpleadoevaluacionDetailP> dw9,
			List<DtoDwHrIncidentecriticoList> dw3,
			List<HrEmpleadodesempeno> dw5,
			List<HrEmpleadoconsiderapotencial> dw10, List<HrEmpleadometas> dw6,
			List<DtoDwHrEmpleadonecesidadcapacitaEdit> dw7,
			Integer tipoGrabacion);

}
