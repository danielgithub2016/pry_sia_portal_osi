package net.royal.rrhh.desempenio.vista.controladora;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import net.royal.comun.vista.controladora.CBindingController;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrEmpleadometas;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodo;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadonecesidadcapacitaEdit;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.controladora.UIMantenimientoController.accion_solicitada;
import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.sf.jasperreports.engine.JRException;

/**
 * The Class CwHrRevisionMetasObjetivos.
 * 
 * @author nunezh
 * @powerbuilder TAB en <strong>w_hr_evaluacionempleado_edit : p6 | dw_6
 *               </strong>
 */
@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CwHrRevisionMetasObjetivos extends
		CwHrEvaluacionempleadoEditMaestra implements UIMantenimientoController {

	private HrEmpleadometas registroSeleccionado;
	private String companyowner;
	private Integer empleado, secuenciaeval, empleadoevaluador;
	private BigDecimal sumCalificacion;

	public static CwHrRevisionMetasObjetivos getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrRevisionMetasObjetivos}",
				CwHrRevisionMetasObjetivos.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		this.inicializarFiltrosListado();
		this.buscar();
		return null;
	}

	@Override
	public String buscar() throws Exception {

		LOGGER.debug(companyowner);

		List<HrEmpleadometas> dw61 = this
				.getFacRrhh()
				.getHrEmpleadometasServicio()
				.ListarEmpleadoMetasporParametros(companyowner, empleado,
						secuenciaeval, empleadoevaluador);

		if (!UValidador.esListaVacia(dw61)) {
			if (UValidador.esNulo(this.getDw6())) {
				this.setDw6(new ArrayList<HrEmpleadometas>());
			}

			this.getDw6().clear();
			this.getDw6().addAll(dw61);
		}

		if (UValidador.esNulo(this.getDw6()))
			this.setDw6(new ArrayList<HrEmpleadometas>());

		for (HrEmpleadometas em : this.getDw6()) {
			em.setEliminado(ConstanteRrhh.TIPO_NO);
		}

		calcularTotal();

		return null;
	}

	public String mostrarReporte() throws Exception {
		Map<String, Object> mapaReporte = new HashMap<String, Object>();

		String pathPrincipal = UAplicacion.getRealPath();
		try {

			mapaReporte.put("par_empleado", empleado);
			mapaReporte.put("par_secuenciaeval", secuenciaeval);
			mapaReporte.put("par_evaluador", empleadoevaluador);

			File archivo = new File(pathPrincipal + File.separator + "erp"
					+ File.separator + "rrhh" + File.separator + File.separator
					+ "recursos" + File.separator + "reportes" + File.separator
					+ "desempenio" + File.separator + "revision_metas_obj"
					+ File.separator + "dw_hr_empleadometas_print.jasper");

			String reporteArchivoPDF = getFacAsistencia()
					.getAsAutorizacionServicio().ejecutarReporteIReport(
							archivo.getPath(), mapaReporte);

			CBindingController.getInstance().setNombreArchivoTemporal(
					reporteArchivoPDF);
		} catch (JRException ex) {
			ex.printStackTrace();
		}

		return "pantallaReporteVistaExterna";

	}

	private void calcularTotal() {
		sumCalificacion = BigDecimal.ZERO;
		BigDecimal cantidad = UValidador.esNulo(this.getDw6()) ? BigDecimal.ONE
				: new BigDecimal(this.getDw6().size());
		for (HrEmpleadometas em : this.getDw6()) {
			sumCalificacion = sumCalificacion.add(UValidador.esNulo(em
					.getCalificacion()) ? BigDecimal.ZERO : em
					.getCalificacion());
		}

		if (cantidad.compareTo(BigDecimal.ZERO) == 0)
			cantidad = BigDecimal.ONE;


		this.setDw6totalcalificacion(sumCalificacion.divide(cantidad, 2,
				RoundingMode.HALF_UP));

	}

	@Override
	public String nuevo() throws Exception {

		this.setAccionPantalla(accion_solicitada.NUEVO);
		Integer llMaximaSecuencia;
		String wsPeriodo;
		llMaximaSecuencia = 0;

		LOGGER.debug(companyowner);

		if (UValidador.esNulo(this.getDw6()))
			this.setDw6(new ArrayList<HrEmpleadometas>());

		for (HrEmpleadometas em : this.getDw6()) {
			if (em.getPk().getSecuencia() > llMaximaSecuencia)
				llMaximaSecuencia = em.getPk().getSecuencia();
		}

		if (!UValidador.esNulo(this.getDw_evaluacion())) {
			HrEvaluacionperiodo evaped = this.getFacRrhh()
					.getHrEvaluacionperiodoServicio()
					.obtenerXSecuenciaEvalCompania(secuenciaeval, companyowner);
			wsPeriodo = evaped.getPeriodo();

			HrEmpleadometas bean = new HrEmpleadometas();
			bean.setDescripcion("");
			bean.setPeriodo(wsPeriodo);
			bean.getPk().setCompanyowner(companyowner);
			bean.getPk().setEmpleado(empleado);
			bean.getPk().setSecuenciaeval(secuenciaeval);
			bean.getPk().setSecuencia(llMaximaSecuencia + 1);
			bean.getPk().setEmpleadoevaluador(empleadoevaluador);
			bean.setFactorparticipacion(BigDecimal.ZERO);
			bean.setEliminado(ConstanteRrhh.TIPO_NO);

			registroSeleccionado = bean;
		}
		calcularTotal();
		CwHrRevisionAvanceCompromisoMejora.getInstance().insertarRegistro();
		;

		Map<String, Object> param = new HashMap<String, Object>();
		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
				"agregarObjetivos");
		param.put("registroSeleccionado", registroSeleccionado);

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);

		CwHrRevisionMetasObjetivosSelector.getInstance().mensaje(
				mensajeGenerico);

		return null;
	}

	@Override
	public String editar() throws Exception {
		this.setAccionPantalla(accion_solicitada.EDITAR);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
				"editarObjetivos");
		param.put("registroSeleccionado", registroSeleccionado);

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);

		CwHrRevisionMetasObjetivosSelector.getInstance().mensaje(
				mensajeGenerico);

		return null;
	}

	@Override
	public String ver() throws Exception {

		return null;
	}

	@Override
	public String eliminar() throws Exception {
		if (UValidador.esNulo(registroSeleccionado))
			return null;

		for (HrEmpleadometas em : this.getDw6()) {
			if (em.getPk().getSecuencia() == registroSeleccionado.getPk()
					.getSecuencia()) {
				em.setEliminado(ConstanteRrhh.TIPO_SI);
				break;
			}
		}

		for (int i = 0; i < this.getDw6().size(); i++) {
			if (this.getDw6().get(i).getEliminado().equals(ConstanteRrhh.TIPO_NO)) {
				registroSeleccionado = this.getDw6().get(i);
			}
		}

		if (!UValidador.esListaVacia(this.getDw6()))
			CwHrEvaluacionempleadoEdit.getInstance().wfCopyMetas();

		return null;
	}

	@Override
	public String inactivar() throws Exception {

		return null;
	}

	@Override
	public String ejecutar(String accion) throws Exception {

		return null;
	}

	@Override
	public String guardar() throws Exception {
		return null;
	}

	@Override
	public String salir() throws Exception {

		return null;
	}

	@Override
	public Boolean validar() throws Exception {

		return null;
	}

	@Override
	public String prepararDatosMantenimiento() throws Exception {

		return null;
	}

	@Override
	public String prepararDatosListado() throws Exception {

		return null;
	}

	@Override
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico)
			throws Exception {

		if (mensajeControllerGenerico.getParametros()
				.get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("insertObjetivosMetas")) {

			calcularTotal();
			registroSeleccionado = (HrEmpleadometas) mensajeControllerGenerico
					.getParametros().get("registroSeleccionado");
			if (this.getAccionPantalla().equals(accion_solicitada.NUEVO)) {
				if (!(sumCalificacion.add(
						registroSeleccionado.getCalificacion()).compareTo(
						new BigDecimal(100)) == 1)) {
					this.getDw6().add(registroSeleccionado);
					this.getWebControlContext().actualizar(
							"frmEvaluacionEmpleado:tvDatos:dtRevMetasObj");
				} else {
					FacesContext context = FacesContext.getCurrentInstance();
					context.getExternalContext().getFlash()
							.setKeepMessages(true);
					context.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"La suma de calificaciones no puede ser mayor a 100",
									"La suma de calificaciones no puede ser mayor a 100"));
				}
			} else {
				if ((sumCalificacion.compareTo(new BigDecimal(100)) == 1)) {
					registroSeleccionado.setCalificacion(registroSeleccionado
							.getCalificacionAnt());

					FacesContext context = FacesContext.getCurrentInstance();
					context.getExternalContext().getFlash()
							.setKeepMessages(true);
					context.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"La suma de calificaciones no puede ser mayor a 100",
									"La suma de calificaciones no puede ser mayor a 100"));
				}
				calcularTotal();
			}
		}

		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {

		return null;
	}

	public HrEmpleadometas getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(HrEmpleadometas registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public Integer getSecuenciaeval() {
		return secuenciaeval;
	}

	public void setSecuenciaeval(Integer secuenciaeval) {
		this.secuenciaeval = secuenciaeval;
	}

	public Integer getEmpleadoevaluador() {
		return empleadoevaluador;
	}

	public void setEmpleadoevaluador(Integer empleadoevaluador) {
		this.empleadoevaluador = empleadoevaluador;
	}

}
