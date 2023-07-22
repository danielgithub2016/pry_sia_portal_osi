package net.royal.rrhh.desempenio.vista.controladora;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.axiom.om.util.Base64;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.ToggleEvent;

import net.royal.erp.asistencia.symast.dominio.dto.DtoDwMaMiscelaneosdetalleSelect;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.core.dominio.Personamast;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacionmejora;
import net.royal.erp.rrhh.dominio.HrEmpleadofuncion;
import net.royal.erp.rrhh.dominio.HrEmpleadometas;
import net.royal.erp.rrhh.dominio.HrEvaluacionempleado;
import net.royal.erp.rrhh.dominio.HrEvaluacionempleadoPk;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodo;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodoPk;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodocriterio;
import net.royal.erp.rrhh.dominio.HrFactoresevaluacion;
import net.royal.erp.rrhh.dominio.HrFactoresevaluacionPk;
import net.royal.erp.rrhh.dominio.HrFactorvalor;
import net.royal.erp.rrhh.dominio.HrTipoevaluador;
import net.royal.erp.rrhh.dominio.HrTipoevaluadorPk;
import net.royal.erp.rrhh.dominio.dto.DtoDDesempenocomparativoP;
import net.royal.erp.rrhh.dominio.dto.DtoDwHrEvaluacionperiodoListEvaluar;
import net.royal.erp.rrhh.dominio.dto.DtoHRFactoresEvaluacion;
import net.royal.erp.rrhh.dominio.dto.DtoHrDetalleEvaluacion;
import net.royal.erp.rrhh.dominio.dto.DtoHrDetalleEvaluacionGrafico;
import net.royal.erp.rrhh.dominio.dto.OwHrEvaluacionempleadoEdit;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwFuncionesXEmpleado;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacionDetailP;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacionEdit;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwMetasEmpleado;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.framework.web.dominio.MensajeUsuario;
import net.royal.rrhh.requerimientos.converter.CVTMiscelaneosdetalleSelect;

/**
 * The Class CwHrEvaluacionempleadoEdit.
 * 
 * @author nunezh
 * @powerbuilder w_hr_evaluacionempleado_edit
 */
@SuppressWarnings({ "serial", "unchecked" })
@SessionScoped
@ManagedBean
public class CwHrEvaluacionempleadoEdit extends CwHrEvaluacionempleadoEditMaestra implements UIMantenimientoController {

	private String eventname, msj;
	private StrPass strpass;

	private List<DtoDwHrEvaluacionperiodoListEvaluar> dw_list;
	private String ivAction, ivCompania, ivMode, isTipoCodigo;
	private Integer ivEmpleado, ivResponsable, ivEmpleadoevaluador, ivSecuencia, alto, altoGrafico;
	private List<HrEvaluacionperiodocriterio> idsTabs;
	private OwHrEvaluacionempleadoEdit opciones;
	private String fotografiaBase64;
	private String gvUsarPersonaAnt;
	private List<HrDetalleevaluacionmejora> dsCopia;
	private String formOrigen;
	private DtoDwHrEvaluacionperiodoListEvaluar registroSeleccionadoExterno;
	private Boolean verSalvar, verCompletar;
	private Date fechaevalfin;

	public static CwHrEvaluacionempleadoEdit getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrEvaluacionempleadoEdit}", CwHrEvaluacionempleadoEdit.class);
	}

	public CwHrEvaluacionempleadoEdit() {
		this.PANTALLA_LISTADO = "whrevaluacionempleadoedit";
	}

	@Override
	public String iniciarControladora() throws Exception {

		CwHrEvaluacionempleadoEditSesion.getInstance().inicializarListas();

		opciones = new OwHrEvaluacionempleadoEdit();
		gvUsarPersonaAnt = this.getFacCore().getParametrosmastServicio()
				.obtenerValorCadena(new ParametrosmastPk("HR", "999999", "PERSONAANT"));

		/*
		 * obtener los permisos para aprobar
		 */

		verSalvar = getFacSeguridad().getSeguridadautorizacionesServicio().tieneAcceso("HR", "GRUP20", "CON001",
				getUsuarioActual().getCodigoUsuario());

		verCompletar = getFacSeguridad().getSeguridadautorizacionesServicio().tieneAcceso("HR", "GRUP20", "CON003",
				getUsuarioActual().getCodigoUsuario());

		opciones.setIv_eliminar(false);

		return inicializarAcciones();
	}

	/**
	 * @powerbuilder ObjectStartEvent.
	 *
	 * @return navigation case
	 * @throws Exception
	 */
	public String inicializarAcciones() throws Exception {
		switch (eventname) {
		case "opened":
			opciones.setP9_visible(true);
			opciones.setP1_visible(true);
			opciones.setP11_visible(true);
			alto = 225;
			altoGrafico = 230;
			wfOpen();
			uePostOpen();
			return this.PANTALLA_LISTADO;

		default:
			break;
		}
		return null;
	}

	public void cambiarTamano(ToggleEvent event) {
		String estado = event.getVisibility().name();
		if (estado.equals(ConstanteRrhh.ESTADO_PANEL_VISIBLE)) {
			alto = 225;
			altoGrafico = 230;
		} else {
			alto = 340;
			altoGrafico = 345;
		}

		getWebControlContext().actualizar("frmEvaluacionEmpleado:tvDatos:tblDetalle");
		getWebControlContext().actualizar("frmEvaluacionEmpleado:tvDatos:tblGrafico");
	}

	private void uePostOpen() throws Exception {
		// Cambio 24-12-2015 | Feliz Navidad
		Date wfechaevalini = null, wfechaevalfin = null, wfechacierreini = null, wfechacierrefin = null, wfecha;
		wfecha = new Date();
		HrEvaluacionperiodo per = (HrEvaluacionperiodo) this.getFacRrhh().getHrEvaluacionperiodoServicio()
				.obtenerPorId(new HrEvaluacionperiodoPk(ivCompania, ivSecuencia));
		LOGGER.debug(ivCompania + "\n" + ivSecuencia);
		if (!UValidador.esNulo(per)) {
			wfechaevalini = per.getFechaevalinicio();

			if (!UValidador.esNulo(wfechaevalini))
				wfechaevalini = UFechaHora.obtenerFechaHoraInicioDia(wfechaevalini);

			wfechaevalfin = per.getFechaevalfin();

			if (!UValidador.esNulo(wfechaevalfin))
				wfechaevalfin = UFechaHora.obtenerFechaHoraFinDia(wfechaevalfin);

			wfechacierreini = UFechaHora.anadirDiasAFechas(per.getFechaevalfin(), 1);

			if (!UValidador.esNulo(wfechacierreini))
				wfechacierreini = UFechaHora.obtenerFechaHoraInicioDia(wfechacierreini);

			wfechacierrefin = per.getFechacierreeval();

			if (!UValidador.esNulo(wfechacierrefin))
				wfechacierrefin = UFechaHora.obtenerFechaHoraFinDia(wfechacierrefin);
		}
		//

		if (!UValidador.esListaVacia(idsTabs)) {
			HrEvaluacionperiodocriterio idstabs = idsTabs.get(0);

			// Incidentes Críticos
			if (idstabs.getFlagincidentescriticos().equals(ConstanteRrhh.TIPO_SI)) {
				opciones.setP3_visible(true);
				this.setIndiceActivoTabMantenimiento(1);
			} else {
				opciones.setP3_visible(false);
				this.setIndiceActivoTabMantenimiento(0);
			}

			// Funciones
			if (idstabs.getFlagfunciones().equals(ConstanteRrhh.TIPO_SI)) {
				opciones.setP11_visible(true);
			} else {
				opciones.setP11_visible(false);
			}

			// Fortalezas y Debilidades
			if (idstabs.getFlagdesempeno().equals(ConstanteRrhh.TIPO_SI)) {
				opciones.setP5_visible(true);
			} else {
				opciones.setP5_visible(false);
			}

			// Metas y/o Compromisos
			if (idstabs.getFlagmetas().equals(ConstanteRrhh.TIPO_SI)) {
				opciones.setP6_visible(true);
			} else {
				opciones.setP6_visible(false);
			}

			// Revisión de Metas
			if (idstabs.getFlagrevisionmetas().equals(ConstanteRrhh.TIPO_SI)) {
				opciones.setP8_visible(true);
			} else {
				opciones.setP8_visible(false);
			}

			// Potencial
			if (idstabs.getFlagpotencial().equals(ConstanteRrhh.TIPO_SI)) {
				opciones.setP9_visible(true);
			} else {
				opciones.setP9_visible(false);
			}

			// Consideraciones del Potencial
			if (idstabs.getFlagrevisionpotencial().equals(ConstanteRrhh.TIPO_SI)) {
				opciones.setP10_visible(true);
			} else {
				opciones.setP10_visible(false);
			}

			// Conceptual
			if (idstabs.getFlagconceptual().equals(ConstanteRrhh.TIPO_SI)) {
				opciones.setP2_visible(true);
			} else {
				opciones.setP2_visible(false);
			}

			// Necesidades de Capacitación
			if (idstabs.getFlagnecesidadcapacita().equals(ConstanteRrhh.TIPO_SI)) {
				opciones.setP7_visible(true);
			} else {
				opciones.setP7_visible(false);
			}

			// De Campo
			if (idstabs.getFlagdecampo().equals(ConstanteRrhh.TIPO_SI)) {
				opciones.setP12_visible(true);
			} else {
				opciones.setP12_visible(false);
			}

			// Revisión del Avance de Compromiso
			if (idstabs.getFlagrevision().equals(ConstanteRrhh.TIPO_SI)) {
				opciones.setP16_visible(true);
			} else {
				opciones.setP16_visible(false);
			}

			// Competencias
			if (idstabs.getFlagdesempeno2().equals(ConstanteRrhh.TIPO_SI)) {
				opciones.setP1_visible(true);

			} else {
				opciones.setP1_visible(false);
			}

			// Comentarios
			if (idstabs.getFlagcomentarios().equals(ConstanteRrhh.TIPO_SI)) {
				opciones.setP17_visible(true);
			} else {
				opciones.setP17_visible(false);
			}

			// Mejora
			if (idstabs.getFlagmejora().equals(ConstanteRrhh.TIPO_SI)) {
				opciones.setP18_visible(true);
			} else {
				opciones.setP18_visible(false);
			}

			if (wfecha.after(wfechaevalini) && wfecha.before(wfechaevalfin)) {
				opciones.setP1_visible(true);
				opciones.setDw1_disable(false);
			}

			// Validación de Fechas
			if (wfecha.after(wfechacierreini) && wfecha.before(wfechacierrefin)) {
				opciones.setDw1_disable(true);
				// iv_bloqueo_fechacierre = 'S'
				// RESULTADOS
				opciones.setP19_visible(true);

				// Mejora
				if (UValidador.validarFlag(idstabs.getFlagmejora())) {
					opciones.setP18_visible(true);
				} else {
					opciones.setP18_visible(false);
				}

				// Necesidades de Capacitación
				if (UValidador.validarFlag(idstabs.getFlagnecesidadcapacita())) {
					opciones.setP7_visible(true);
				} else {
					opciones.setP7_visible(false);
				}

				this.setIndiceActivoTabMantenimiento(0);

				// tab_1.p6.cb_calificacionmetas.enabled = false
				opciones.setDw6_disable(true);

				// Revisión de Metas
				if (UValidador.validarFlag(idstabs.getFlagrevisionmetas())) {
					opciones.setP8_visible(true);
				} else
					opciones.setP8_visible(false);

			} else {
				opciones.setP19_visible(false);
				opciones.setP18_visible(false);
				opciones.setP7_visible(false);
				// iv_bloqueo_fechacierre = 'N'
			}

			if (wfecha.after(wfechacierrefin)) {
				switch (ivAction) {
				case "VER":
					opciones.setP19_visible(true);
					opciones.setDw1_disable(true);
					opciones.setDw6_disable(true);
					opciones.setDw8_disable(true);
					opciones.setDwcompromisomejora_disable(true);
					this.setBloqueofechacierre(false);

					// Necesidades de Capacitación
					if (UValidador.validarFlag(idstabs.getFlagnecesidadcapacita())) {
						opciones.setP7_visible(true);
						opciones.setDw7_disable(true);
					} else
						opciones.setP7_visible(false);

					// Revisión de Metas
					if (UValidador.validarFlag(idstabs.getFlagrevisionmetas())) {
						opciones.setP8_visible(true);
						opciones.setDw8_disable(true);
					} else {
						opciones.setP8_visible(false);
					}
					// Metas y/o Compromisos
					if (UValidador.validarFlag(idstabs.getFlagmetas())) {
						opciones.setP6_visible(true);
						opciones.setDw6_disable(true);
					} else {
						opciones.setP6_visible(false);
					}
					// Mejora
					if (UValidador.validarFlag(idstabs.getFlagmejora())) {
						opciones.setP18_visible(true);
						opciones.setDwcompromisomejora_disable(true);
					} else {
						opciones.setP18_visible(false);
					}
					break;
				}
			}

		}

	}

	public String wfPending() throws Exception {

		// RichardG 2009-01-14
		opciones.setIsEstadoDefault(ConstanteRrhh.TIPO_ESTADO_EN_EVALUACION);// En
																				// Evaluación
		if (wfUpdate(ConstanteRrhh.SALVAR).equals(1)) {
			StrPass str = new StrPass();
			str.getS()[1] = ivCompania;
			str.getD()[1] = ivSecuencia;

			CWHrEvaluacionperiodoListEvaluar.getInstance().setStrpass(str);
			CWHrEvaluacionperiodoListEvaluar.getInstance().setEventname("opened");
			CWHrEvaluacionperiodoListEvaluar.getInstance().iniciarControladora();

			return "whrevaluacionperiodolistevaluar";
		}

		return null;
	}

	public String wfUpdateCompletar() throws Exception {
		if (wfUpdate(ConstanteRrhh.COMPLETAR).equals(1)) {
			StrPass str = new StrPass();
			str.getS()[1] = ivCompania;
			str.getD()[1] = ivSecuencia;

			CWHrEvaluacionperiodoListEvaluar.getInstance().setStrpass(str);
			CWHrEvaluacionperiodoListEvaluar.getInstance().setEventname("opened");
			CWHrEvaluacionperiodoListEvaluar.getInstance().iniciarControladora();

			return "whrevaluacionperiodolistevaluar";
		}

		return null;
	}

	public Integer wfUpdate(Integer tipoGrabacion) {
		Integer retorno;// = wfValidate();

		List<MensajeUsuario> mensajes = getFacRrhh().getHrEvaluacionempleadoServicio().validarTodaEvaluacion(
				this.getDw_evaluacion(), opciones, strpass, ivAction, this.getDw1(), this.getDw9(), this.getDw3(),
				this.getDw5(), this.getDw10(), this.getDw6(), this.getDw7(), tipoGrabacion);

		retorno = mensajes.size() > 0 ? -1 : 1;

		this.setListaMensajeUsuario(mensajes);

		if (!retorno.equals(1)) {
			this.mostrarMensajesUsuario();
			return retorno;

		}
		// ACTUALIZAR EL PUNTAJE TOTAL:
		if (!UValidador.esNulo(this.getDw_evaluacion())) {
			if (!UValidador.esNulo(this.getDw1())) {
				if (this.getDw1().size() > 0) {
					this.getDw_evaluacion().setTotalpuntos(CwHrDetalleEvaluacion.getInstance().getCantCalificacion());
				} else {
					this.getDw_evaluacion().setTotalpuntos(new BigDecimal(0));
				}
			}

		}

		if (!UValidador.esNulo(this.getDw11())) {
			if (this.getDw11().size() > 0) {
				this.getDw_evaluacion().setTotalpuntosfuncion(this.getDw11totalcalificacion());
			} else {
				this.getDw_evaluacion().setTotalpuntosfuncion(new BigDecimal(0));
			}
		}

		if (!UValidador.esNulo(this.getDw9())) {
			if (this.getDw9().size() > 0) {
				this.getDw_evaluacion().setTotalpuntospotencial(this.getDw9totalpuntospotencial());
			} else {
				this.getDw_evaluacion().setTotalpuntospotencial(new BigDecimal(0));
			}
		}

		if (!UValidador.esNulo(this.getDw6())) {
			if (this.getDw6().size() > 0) {
				this.getDw_evaluacion().setTotalpuntosmetas(this.getDw6totalcalificacion());
			} else {
				this.getDw_evaluacion().setTotalpuntosmetas(new BigDecimal(0));
			}
		}

		if (UValidador.esNulo(this.getDw_evaluacion().getTotalpuntos())) {
			this.getDw_evaluacion().setTotalpuntos(new BigDecimal(0));
		}

		if (UValidador.esNulo(this.getDw_evaluacion().getTotalpuntosfuncion())) {
			this.getDw_evaluacion().setTotalpuntosfuncion(new BigDecimal(0));
		}

		if (UValidador.esNulo(this.getDw_evaluacion().getTotalpuntospotencial())) {
			this.getDw_evaluacion().setTotalpuntospotencial(new BigDecimal(0));
		}

		if (UValidador.esNulo(this.getDw_evaluacion().getTotalpuntosmetas())) {
			this.getDw_evaluacion().setTotalpuntosmetas(new BigDecimal(0));
		}

		// RichardG 2009-01-14
		this.getDw_evaluacion().setEstado(opciones.getIsEstadoDefault());
		this.getDw_evaluacion().setFechaevaluacion(new Date());
		this.getDw_evaluacion().setUltimafechamodif(new Date());
		this.getDw_evaluacion().setUltimousuario(getUsuarioActual().getCodigoUsuario());

		StrPass valoresaEnviar;
		valoresaEnviar = new StrPass();

		valoresaEnviar.getLo()[1] = ivEmpleado;
		valoresaEnviar.getLo()[2] = ivSecuencia;
		valoresaEnviar.getLo()[3] = ivEmpleadoevaluador;
		valoresaEnviar.getS()[1] = ivCompania;
		valoresaEnviar.getS()[2] = opciones.getIsEstadoDefault();
		valoresaEnviar.getS()[3] = strpass.getS()[6];

		getFacRrhh().getHrEvaluacionempleadoServicio().grabarTodaEvaluacion(this.getDw_evaluacion(), valoresaEnviar,
				this.getDw1(), this.getDw3(), this.getDw5(), this.getDw6(), this.getDw7(), this.getDw9(),
				this.getDw10(), this.getDw11(), this.getDwcampo(), this.getDwrevision(), this.getDwcomentario(),
				this.getDwcompromisomejora(), getUsuarioActual());

		getFacRrhh().getHrDetalleevaluacionmejoraServicio().grabarDetalleMejora(this.getDwcompromisomejora());

		return 1;
	}

	@SuppressWarnings("unchecked")
	private void wfOpen() throws Exception {
		String lsTipoeval = null, lsEstado, lvPath, wExtension, lsPersonaAnt, mensaje = "";

		opciones.setIb_evaluar(true);
		Integer llCodigo;

		if (strpass.getS().length > 0) {
			ivAction = strpass.getS()[1];
			ivCompania = strpass.getS()[2];
			ivEmpleado = strpass.getD()[1];

			ivResponsable = strpass.getD()[2];
			ivEmpleadoevaluador = strpass.getD()[4];
			ivSecuencia = strpass.getD()[3];
			ivMode = strpass.getS()[3];

			if (ivMode.equals(ConstanteRrhh.TIPO_MODO_UNO)) {
				opciones.setDwevaluacioncodigosupervisor_disable(true);
				opciones.setDwevaluacioncodigoempleado_disable(true);
			}

			// [...]

			isTipoCodigo = strpass.getS()[4];
		}

		dw_list = strpass.getPo()[1];

		HrEvaluacionempleadoPk pkEvalemp = new HrEvaluacionempleadoPk();
		pkEvalemp.setCompanyowner(ivCompania);
		pkEvalemp.setSecuenciaeval(ivSecuencia);
		pkEvalemp.setEmpleadoevaluador(ivEmpleadoevaluador);
		pkEvalemp.setEmpleado(ivEmpleado);

		HrEvaluacionempleado evalEmp = (HrEvaluacionempleado) this.getFacRrhh().getHrEvaluacionempleadoServicio()
				.obtenerPorId(pkEvalemp);

		if (!UValidador.esNulo(evalEmp)) {
			lsTipoeval = evalEmp.getTipoevaluador();
		}

		idsTabs = this.getFacRrhh().getHrEvaluacionperiodocriterioServicio()
				.listarPorCompaniaSecuenciaTipoEval(ivCompania, ivSecuencia, lsTipoeval);

		switch (ivAction) {
		case "VER":
		case "MODIFICAR":
			this.setDw_evaluacion(this.getFacRrhh().getHr().getHrothersDatawindow()
					.dwHrEmpleadoevaluacionEdit(ivEmpleado, ivSecuencia, ivEmpleadoevaluador));

			if (UValidador.esNulo(this.getDw_evaluacion()))
				this.setDw_evaluacion(new DtoDwHrEmpleadoevaluacionEdit());

			if (ivAction.equals("MODIFICAR")) {
				if (!this.getDw_evaluacion().getTipoevaluador().equals(ConstanteRrhh.TIPO_EVALUADOR_UNO)) {
					opciones.setCbseguimiento_visible(false);
				}
			}

			opciones.setDwevaluacionperiodo_disable(true);

			lsEstado = registroSeleccionadoExterno.getEstado();

			if (lsEstado.equals(ConstanteRrhh.TIPO_ESTADO_PREPARACION)) {
				if (opciones.isP9_visible() || opciones.isP1_visible() || opciones.isP19_visible())
					mensaje = wfCopyPlantilla();
				if (!UValidador.estaVacio(mensaje)) {
					setMessageError(mensaje);
					break;
				}

				if (opciones.isP11_visible())
					wfCopyFuncionPuesto();
				if (opciones.isP6_visible())
					wfCopyMetas();

				CwHrRevisionMetasObjetivos.getInstance().setCompanyowner(ivCompania);
				CwHrRevisionMetasObjetivos.getInstance().setEmpleado(ivEmpleado);
				CwHrRevisionMetasObjetivos.getInstance().setEmpleadoevaluador(ivEmpleadoevaluador);
				CwHrRevisionMetasObjetivos.getInstance().setSecuenciaeval(ivSecuencia);
				CwHrRevisionMetasObjetivos.getInstance().iniciarControladora();
			} else {
				if (ConstanteRrhh.TIPO_ESTADO_REVISADO.equals(this.getDw_evaluacion().getTipoevaluador())) {
					HrEvaluacionempleadoPk pk = new HrEvaluacionempleadoPk();
					pk.setCompanyowner(ivCompania);
					pk.setSecuenciaeval(ivSecuencia);
					pk.setEmpleado(ivEmpleado);
					pk.setEmpleadoevaluador(ivEmpleadoevaluador);

					this.setDw_evaluacion(this.getFacRrhh().getHr().getHrothersDatawindow()
							.dwHrEmpleadoevaluacionEdit(ivEmpleado, ivSecuencia, ivEmpleadoevaluador));

					LOGGER.debug(this.getDw_evaluacion());

					CwHrDetalleEvaluacion.getInstance().setStrpass(strpass);
					CwHrDetalleEvaluacion.getInstance().buscar();
					LOGGER.debug(this.getDw1());

					// dw15 retrieve ---> nuevo controlador
					// dw15_P retrieve ---> nuevo controlador
					// dw2 retrieve ---> nuevo controlador

					CwHrPotencial.getInstance().setCompanyowner(ivCompania);
					CwHrPotencial.getInstance().setEmpleado(ivEmpleado);
					CwHrPotencial.getInstance().setEmpleadoevaluador(ivEmpleadoevaluador);
					CwHrPotencial.getInstance().setSecuenciaeval(ivSecuencia);
					CwHrPotencial.getInstance().iniciarControladora();

					CwHrRevisionMetasObjetivos.getInstance().setCompanyowner(ivCompania);
					CwHrRevisionMetasObjetivos.getInstance().setEmpleado(ivEmpleado);
					CwHrRevisionMetasObjetivos.getInstance().setEmpleadoevaluador(ivEmpleadoevaluador);
					CwHrRevisionMetasObjetivos.getInstance().setSecuenciaeval(ivSecuencia);
					CwHrRevisionMetasObjetivos.getInstance().iniciarControladora();

					if (UValidador.esListaVacia(this.getDw8()))
						this.setDw8(new ArrayList<HrEmpleadometas>());
					if (!UValidador.esListaVacia(this.getDw6()))
						this.getDw8().addAll(this.getDw6());

					CwHrFunciones.getInstance().setCompanyowner(ivCompania);
					CwHrFunciones.getInstance().setEmpleado(ivEmpleado);
					CwHrFunciones.getInstance().setEmpleadoevaluador(ivEmpleadoevaluador);
					CwHrFunciones.getInstance().setSecuenciaeval(ivSecuencia);
					CwHrFunciones.getInstance().iniciarControladora();
				} else {

					CwHrDetalleEvaluacion.getInstance().setStrpass(strpass);
					CwHrDetalleEvaluacion.getInstance().buscar();
					LOGGER.debug(this.getDw1());
					// dw1 retrieve ---> nuevo controlador
					// dw15 retrieve ---> nuevo controlador
					// dw15_P retrieve ---> nuevo controlador
					// dw2 retrieve ---> nuevo controlador

					CwHrPotencial.getInstance().setCompanyowner(ivCompania);
					CwHrPotencial.getInstance().setEmpleado(ivEmpleado);
					CwHrPotencial.getInstance().setEmpleadoevaluador(ivEmpleadoevaluador);
					CwHrPotencial.getInstance().setSecuenciaeval(ivSecuencia);
					CwHrPotencial.getInstance().iniciarControladora();

					CwHrRevisionMetasObjetivos.getInstance().setCompanyowner(ivCompania);
					CwHrRevisionMetasObjetivos.getInstance().setEmpleado(ivEmpleado);
					CwHrRevisionMetasObjetivos.getInstance().setEmpleadoevaluador(ivEmpleadoevaluador);
					CwHrRevisionMetasObjetivos.getInstance().setSecuenciaeval(ivSecuencia);
					CwHrRevisionMetasObjetivos.getInstance().iniciarControladora();
					if (UValidador.esListaVacia(this.getDw8()))
						this.setDw8(new ArrayList<HrEmpleadometas>());
					if (!UValidador.esListaVacia(this.getDw6()))
						this.getDw8().addAll(this.getDw6());

					CwHrFunciones.getInstance().setCompanyowner(ivCompania);
					CwHrFunciones.getInstance().setEmpleado(ivEmpleado);
					CwHrFunciones.getInstance().setEmpleadoevaluador(ivEmpleadoevaluador);
					CwHrFunciones.getInstance().setSecuenciaeval(ivSecuencia);
					CwHrFunciones.getInstance().iniciarControladora();
				}
			}

			CwHrCompromisoMejora.getInstance().setCompanyowner(ivCompania);
			CwHrCompromisoMejora.getInstance().setEmpleado(ivEmpleado);
			CwHrCompromisoMejora.getInstance().setEmpleadoevaluador(ivEmpleadoevaluador);
			CwHrCompromisoMejora.getInstance().setSecuenciaeval(ivSecuencia);
			CwHrCompromisoMejora.getInstance().iniciarControladora();

			// dw_16 retrieve ---> nuevo controlador
			// dw_16P retrieve ---> nuevo controlador

			recuperarFoto(ivEmpleado);

			CwHrIncidentesCriticos.getInstance().setCompanyowner(ivCompania);
			CwHrIncidentesCriticos.getInstance().setEmpleado(ivEmpleado);
			CwHrIncidentesCriticos.getInstance().setEmpleadoevaluador(ivEmpleadoevaluador);
			CwHrIncidentesCriticos.getInstance().setSecuenciaeval(ivSecuencia);
			CwHrIncidentesCriticos.getInstance().setFechaInicio(this.getDw_evaluacion().getFechainicio());
			CwHrIncidentesCriticos.getInstance().setFechaevalfin(fechaevalfin);

			CwHrIncidentesCriticos.getInstance().iniciarControladora();

			// dw_5 child ---> nuevo controlador
			List<DtoDwMaMiscelaneosdetalleSelect> lstTipo = this.getFacAsistencia().getAS().getSymastDatawindow()
					.DwMaMiscelaneosdetalleSelect("HR", "EVAFORDEB", "999999");
			CVTMiscelaneosdetalleSelect.lista = lstTipo;

			if (lstTipo.size() <= 0)
				this.setMessageError(
						"Fortalezas y Debilidades','Falta misceláneo EVAFORDEB [Cía.: 999999] para el Tipo Fortaleza/Debilidad");

			// dw_5 retrieve ---> nuevo controlador
			CwHrFortalezasDebilidades.getInstance().setEmpleado(ivEmpleado);
			CwHrFortalezasDebilidades.getInstance().setEmpleadoevaluador(ivEmpleadoevaluador);
			CwHrFortalezasDebilidades.getInstance().setCompania(ivCompania);
			CwHrFortalezasDebilidades.getInstance().setSecuenciaeval(ivSecuencia);
			CwHrFortalezasDebilidades.getInstance().setLstTipo(lstTipo);
			CwHrFortalezasDebilidades.getInstance().iniciarControladora();

			CwHrNecesidadesCapacitacion.getInstance().setEmpleado(ivEmpleado);
			CwHrNecesidadesCapacitacion.getInstance().setEmpleadoevaluador(ivEmpleadoevaluador);
			CwHrNecesidadesCapacitacion.getInstance().setCompania(ivCompania);
			CwHrNecesidadesCapacitacion.getInstance().setSecuenciaeval(ivSecuencia);
			CwHrNecesidadesCapacitacion.getInstance().iniciarControladora();

			CwHrConsideracionesPotencial.getInstance().setCompanyowner(ivCompania);
			CwHrConsideracionesPotencial.getInstance().setEmpleado(ivEmpleado);
			CwHrConsideracionesPotencial.getInstance().setEvaluador(ivEmpleadoevaluador);
			CwHrConsideracionesPotencial.getInstance().setSecuenciaeval(ivSecuencia);
			CwHrConsideracionesPotencial.getInstance().iniciarControladora();

			CwHrRevisionAvanceCompromisoMejora.getInstance().setEmpleado(ivEmpleado);
			CwHrRevisionAvanceCompromisoMejora.getInstance().setEmpleadoevaluador(ivEmpleadoevaluador);
			CwHrRevisionAvanceCompromisoMejora.getInstance().setCompanyowner(ivCompania);
			CwHrRevisionAvanceCompromisoMejora.getInstance().setSecuenciaeval(ivSecuencia);
			CwHrRevisionAvanceCompromisoMejora.getInstance().iniciarControladora();

			CwHrComentarios.getInstance().setEmpleado(ivEmpleado);
			CwHrComentarios.getInstance().setEmpleadoevaluador(ivEmpleadoevaluador);
			CwHrComentarios.getInstance().setCompanyowner(ivCompania);
			CwHrComentarios.getInstance().setSecuenciaeval(ivSecuencia);
			CwHrComentarios.getInstance().iniciarControladora();

			// dw_19 retrieve ---> nuevo controlador
			this.setDwcampo_child(this.getFacAsistencia().getAS().getSymastDatawindow()
					.DwMaMiscelaneosdetalleSelect("HR", "EVACAMPO", "999999"));

			if (this.getDwcampo_child().size() <= 0)
				this.setMessageError("Falta misceláneo EVACAMPO [Cía.: 999999] para el Tipo Evaluacion de Campo");
			CwHrEvaluacionCampo.getInstance().setEmpleado(ivEmpleado);
			CwHrEvaluacionCampo.getInstance().setEmpleadoevaluador(ivEmpleadoevaluador);
			CwHrEvaluacionCampo.getInstance().setCompanyowner(ivCompania);
			CwHrEvaluacionCampo.getInstance().setSecuenciaeval(ivSecuencia);
			CwHrEvaluacionCampo.getInstance().iniciarControladora();

			// wfCampoPreguntas(); en evaluacion de campo ---> nuevo controlador

			if (ivAction.equals("MODIFICAR")) {
				opciones.setDwevaluacionjefeorgano_disable(true);
				opciones.setDwevaluacioncomentariorevisor_disable(true);

				//
				opciones.setP11cbagregarfuncion_disable(true);
				opciones.setP11cbeliminarfuncion_disable(true);
			} else if (ivAction.equals("VER")) {
				opciones.setDwevaluacion_disable(true);
				opciones.setDw1_disable(true);
				opciones.setDw2_disable(true);
				opciones.setDw3_disable(true);
				opciones.setDw5_disable(true);
				opciones.setDw6_disable(true);
				opciones.setDw7_disable(true);
				opciones.setDw8_disable(true);
				opciones.setDw9_disable(true);
				opciones.setDw10_disable(true);
				opciones.setDw11_disable(true);
				opciones.setDwcampo_disable(true);
				opciones.setDw19_disable(true);
				opciones.setDwcomentario_disable(true);
				opciones.setDwcompromisomejora_disable(true);

				opciones.setP5cbagregar_disable(true);
				opciones.setP5cbeliminar_disable(true);

				opciones.setP1cb1_disable(true);
				opciones.setP1cb2_disable(true);
				opciones.setP1cbimprimir_disable(true);

				opciones.setP7cbagregacapacita_disable(true);
				opciones.setP7cbeliminacapacita_disable(true);
				opciones.setP7cbseleccionar(true);
				opciones.setP10cbagregaconsidera_disable(true);
				opciones.setP11cbagregarfuncion_disable(true);
				opciones.setP11cbeliminarfuncion_disable(true);
				opciones.setP11cbcalificacionfunciones_disable(true);

				opciones.setP12cbagregarcampo_disable(true);
				opciones.setP12cbeliminarcampo_disable(true);

				opciones.setP16cb4_disable(true);
				opciones.setP16cb5_disable(true);

				opciones.setP1cbimprimir_disable(false);
				opciones.setP1cb1_disable(false);

				if ((ConstanteRrhh.TIPO_ESTADO_REVISADO).equals(strpass.getS()[6])
						&& !(ConstanteRrhh.TIPO_ESTADO_REVISADO).equals(strpass.getS()[5])) {
					opciones.setDwevaluacionjefeorgano_disable(false);
					opciones.setDwevaluacioncomentariorevisor_disable(false);
				}
			}
			// foto
			recuperarFoto(ivEmpleado);

			// sinfoto

			if (gvUsarPersonaAnt.equals(ConstanteRrhh.TIPO_SI)) {
				Personamast p = (Personamast) this.getFacCore().getPersonamastServicio()
						.obtenerPorId(new net.royal.erp.core.dominio.PersonamastPk(ivEmpleado));

				lsPersonaAnt = p.getPersonaant();
				this.getDw_evaluacion().setCodigoempleado(lsPersonaAnt);
				this.getDw_evaluacion().setEmpleado(new BigDecimal(lsPersonaAnt));

				llCodigo = this.getDw_evaluacion().getEmpleadoevaluador().intValue();

				p = (Personamast) this.getFacCore().getPersonamastServicio()
						.obtenerPorId(new net.royal.erp.core.dominio.PersonamastPk(llCodigo));

				lsPersonaAnt = p.getPersonaant();
				this.getDw_evaluacion().setCodigoevaluador(lsPersonaAnt);
				this.getDw_evaluacion().setEmpleadoevaluador(new BigDecimal(lsPersonaAnt));
				ivEmpleado = Integer.parseInt(lsPersonaAnt);

				if (UValidador.esNulo(this.getDw_evaluacion().getEmpleadosupervisor())
						|| this.getDw_evaluacion().getEmpleadosupervisor().compareTo(BigDecimal.ZERO) == 0) {
					Empleadomast e = this.getFacCore().getEmpleadomastServicio()
							.obtenerPorCodigoUsuario(this.getUsuarioActual().getCodigoUsuario());
					this.getDw_evaluacion().setEmpleadosupervisor(new BigDecimal(e.getPk().getEmpleado()));
				}
				this.getDw_evaluacion().setCodigosupervisor(this.getDw_evaluacion().getEmpleadosupervisor().toString());

				llCodigo = this.getDw_evaluacion().getEmpleadogerente().intValue();
				p = (Personamast) this.getFacCore().getPersonamastServicio()
						.obtenerPorId(new net.royal.erp.core.dominio.PersonamastPk(llCodigo));
				lsPersonaAnt = p.getPersonaant();
				this.getDw_evaluacion().setCodigogerente(lsPersonaAnt);
				this.getDw_evaluacion().setEmpleadogerente(new BigDecimal(llCodigo));

			} else {
				this.getDw_evaluacion().setCodigoempleado(ivEmpleado.toString());
				this.getDw_evaluacion().setEmpleado(new BigDecimal(ivEmpleado));
				llCodigo = this.getDw_evaluacion().getEmpleadoevaluador().intValue();
				this.getDw_evaluacion().setCodigoevaluador(llCodigo.toString());
				this.getDw_evaluacion().setEmpleadoevaluador(new BigDecimal(llCodigo));

				if (UValidador.esNulo(this.getDw_evaluacion().getEmpleadosupervisor())
						|| this.getDw_evaluacion().getEmpleadosupervisor().compareTo(BigDecimal.ZERO) == 0) {
					Empleadomast e = this.getFacCore().getEmpleadomastServicio()
							.obtenerPorCodigoUsuario(this.getUsuarioActual().getCodigoUsuario());
					this.getDw_evaluacion().setEmpleadosupervisor(new BigDecimal(e.getPk().getEmpleado()));
				}

				llCodigo = this.getDw_evaluacion().getEmpleadosupervisor().intValue();
				this.getDw_evaluacion().setCodigosupervisor(llCodigo.toString());
				this.getDw_evaluacion().setEmpleadosupervisor(new BigDecimal(llCodigo));

				llCodigo = UValidador.esNulo(this.getDw_evaluacion().getEmpleadogerente()) ? null
						: this.getDw_evaluacion().getEmpleadogerente().intValue();
				this.getDw_evaluacion().setCodigogerente(UValidador.esNulo(llCodigo) ? null : llCodigo.toString());
				this.getDw_evaluacion()
						.setEmpleadogerente(UValidador.esNulo(llCodigo) ? null : new BigDecimal(llCodigo));

				// -----------------//
				this.getDw_evaluacion().setEmpleadonombre(this.getFacAsistencia().getAS().getSycommFuncion()
						.FSqlGetPersonaNombrecompleto(this.getDw_evaluacion().getEmpleado().intValue()));

				this.getDw_evaluacion()
						.setPuestonombre(this.getFacCore().getEmpleadomastServicio().obtenerNombreCargoEmpleado(
								this.getDw_evaluacion().getEmpleado().intValue(),
								this.getDw_evaluacion().getCompanyowner()));

				this.getDw_evaluacion().setEvaluadornombre(this.getFacAsistencia().getAS().getSycommFuncion()
						.FSqlGetPersonaNombrecompleto(this.getDw_evaluacion().getEmpleadoevaluador().intValue()));

				this.getDw_evaluacion()
						.setPuestoevalnombre(this.getFacCore().getEmpleadomastServicio().obtenerNombreCargoEmpleado(
								this.getDw_evaluacion().getEmpleadoevaluador().intValue(),
								this.getDw_evaluacion().getCompanyowner()));

				this.getDw_evaluacion().setEntidadnombre(this.getUsuarioActual().getCompaniaSocioNombre());

				HrTipoevaluadorPk pk = new HrTipoevaluadorPk();
				pk.setTipoevaluador(this.getDw_evaluacion().getTipoevaluador());
				HrTipoevaluador te = (HrTipoevaluador) this.getFacRrhh().getHrTipoevaluadorServicio().obtenerPorId(pk);
				this.getDw_evaluacion().setTipoevaluadornombre(te.getDescripcion());

			}

			break;

		case "AGREGAR":
			Date fechaDesde, fechaHasta;
			this.setDw_evaluacion(new DtoDwHrEmpleadoevaluacionEdit());

			HrEvaluacionperiodo ep = (HrEvaluacionperiodo) this.getFacRrhh().getHrEvaluacionperiodoServicio()
					.obtenerPorId(new HrEvaluacionperiodoPk(ivCompania, ivSecuencia));
			fechaDesde = ep.getFechainicio();
			fechaHasta = ep.getFechafin();

			this.getDw_evaluacion().setEmpleado(new BigDecimal(ivEmpleado));
			this.getDw_evaluacion().setCodigoempleado(ivEmpleado.toString());

			this.getDw_evaluacion().setEmpleadoevaluador(new BigDecimal(ivResponsable));
			this.getDw_evaluacion().setCodigoevaluador(ivResponsable.toString());
			this.getDw_evaluacion().setCompanyowner(ivCompania);
			this.getDw_evaluacion().setFechaevaluacion(new Date());
			this.getDw_evaluacion().setUnidadreplicacion(ConstanteRrhh.UNIDAD_REPLICACION);
			this.getDw_evaluacion().setSecuenciaeval(new BigDecimal(ivSecuencia));
			this.getDw_evaluacion().setFechainicio(fechaDesde);
			this.getDw_evaluacion().setFechafin(fechaHasta);

			String lvCompania, lvCentroCostos;

			Empleadomast e = this.getFacCore().getEmpleadomastServicio().obtenerEmpleadoMast(ivEmpleado);
			lvCompania = e.getPk().getCompaniasocio();
			lvCentroCostos = e.getCentrocostos();

			this.getDw_evaluacion().setCentrocostos(lvCentroCostos);

			CwHrIncidentesCriticos.getInstance().setCompanyowner(ivCompania);
			CwHrIncidentesCriticos.getInstance().setEmpleado(ivEmpleado);
			CwHrIncidentesCriticos.getInstance().setEmpleadoevaluador(ivEmpleadoevaluador);
			CwHrIncidentesCriticos.getInstance().setSecuenciaeval(ivSecuencia);
			CwHrIncidentesCriticos.getInstance().setFechaInicio(this.getDw_evaluacion().getFechainicio());
			CwHrIncidentesCriticos.getInstance().iniciarControladora();

			this.getDw_evaluacion().setCodigosupervisor(this.getDw_evaluacion().getEmpleadosupervisor().toString());
			// dw19 retrieve ---> nuevo controlador
			break;
		}

		recuperarFoto(ivEmpleado);

		// this.setIndiceActivoTabMantenimiento(1);

	}

	public void wfCopyMetas() {
		if (UValidador.esNulo(this.getDw8()))
			this.setDw8(new ArrayList<HrEmpleadometas>());
		if (UValidador.esNulo(this.getDw6()))
			this.setDw6(new ArrayList<HrEmpleadometas>());

		if (!UValidador.esListaVacia(this.getDw6()))
			this.getDw8().addAll(this.getDw6());

		Integer wEmpleado, wSecuenciaeval;
		String wCompania;
		// -----------------------Act HOCR 20110310 --------------------//
		if (idsTabs.size() > 0) {
		} else
			return;

		// -----------------------Act HOCR 20110310 --------------------//
		if (idsTabs.get(0).getFlagmetas().equals("S")) {
		} else
			return;

		Integer wResp;
		if (!UValidador.esNulo(this.getDw_evaluacion())) {
			if (this.getDw6().size() > 0) {
				if (opciones.isIv_eliminar()) {
					while (this.getDw6().size() > 0) {
						this.getDw6().remove(0);
					}
					wResp = 1;
				} else {
					wResp = 2;
				}
			} else {
				wResp = 1;
			}

			if (wResp == 1) {

				List<DtoDwMetasEmpleado> wDsMetasTemporal;
				List<DtoDwMetasEmpleado> wDsMetas;
				wCompania = this.getDw_evaluacion().getCompanyowner().substring(0, 6);

				wEmpleado = this.getDw_evaluacion().getEmpleado().intValue();
				wSecuenciaeval = this.getDw_evaluacion().getSecuenciaeval().intValue();

				wDsMetasTemporal = new ArrayList<DtoDwMetasEmpleado>();

				wDsMetasTemporal = this.getFacRrhh().getHr().getHrothersDatawindow().dWMetasEmpleado(wEmpleado);

				wDsMetas = new ArrayList<DtoDwMetasEmpleado>();
				for (DtoDwMetasEmpleado obj : wDsMetasTemporal) {
					if (obj.getSecuenciaEval().compareTo(new BigDecimal(wSecuenciaeval)) == 0
							&& obj.getEstado().equals("A")) {
						wDsMetas.add(obj);
					}
				}

				for (DtoDwMetasEmpleado m : wDsMetas) {
					HrEvaluacionperiodo evaped = this.getFacRrhh().getHrEvaluacionperiodoServicio()
							.obtenerXSecuenciaEvalCompania(ivSecuencia, wCompania);

					HrEmpleadometas bean = new HrEmpleadometas();
					bean.getPk().setCompanyowner(ivCompania);
					bean.setDescripcion(m.getDescripcion());
					bean.setPeriodo(evaped.getPeriodo());
					bean.getPk().setEmpleado(ivEmpleado);
					bean.getPk().setEmpleadoevaluador(ivEmpleadoevaluador);
					bean.getPk().setSecuenciaeval(ivSecuencia);
					bean.getPk().setSecuencia(m.getSecuencia().intValue());
					bean.setFactorparticipacion(m.getFactorparticipacion());

					this.getDw6().add(bean);
				}

			}
		}
	}

	private void wfCopyFuncionPuesto() {
		// -----------------------Act HOCR 20110310 --------------------//
		if (idsTabs.size() > 0) {
		} else
			return;
		// -----------------------Act HOCR 20110310 --------------------//

		if (idsTabs.get(0).getFlagfunciones().equals("S")) {
		} else
			return;

		if (UValidador.esNulo(this.getDw11()))
			this.setDw11(new ArrayList<HrEmpleadofuncion>());

		Integer wResp;
		if (!UValidador.esNulo(this.getDw_evaluacion())) {
			if (this.getDw11().size() > 0) {
				if (opciones.isIv_eliminar()) {
					while (this.getDw11().size() > 0) {
						this.getDw11().remove(0);
					}
					wResp = 1;
				} else {
					wResp = 2;
				}
			} else {
				wResp = 1;
			}
			if (wResp == 1) {

				List<DtoDwFuncionesXEmpleado> wDsFuncionesTemporal;
				List<DtoDwFuncionesXEmpleado> wDsFunciones;
				Integer wEmpleado, wSecuenciaeval;
				String wCompania, wFuncion;
				wCompania = this.getDw_evaluacion().getCompanyowner().substring(0, 6);

				wEmpleado = this.getDw_evaluacion().getEmpleado().intValue();
				wSecuenciaeval = this.getDw_evaluacion().getSecuenciaeval().intValue();

				wDsFuncionesTemporal = new ArrayList<DtoDwFuncionesXEmpleado>();
				wDsFuncionesTemporal = this.getFacRrhh().getHr().getHrothersDatawindow()
						.dWFuncionesXEmpleado(wEmpleado);

				wDsFunciones = new ArrayList<DtoDwFuncionesXEmpleado>();
				for (DtoDwFuncionesXEmpleado obj : wDsFuncionesTemporal) {
					if (obj.getSecuenciaEval().compareTo(new BigDecimal(wSecuenciaeval)) == 0
							&& obj.getEstado().equals("A")) {
						wDsFunciones.add(obj);
					}
				}

				for (int i = 0; i < wDsFunciones.size(); i++) {
					wFuncion = this.getFacCore().getMaMiscelaneosdetalleServicio().obtenerDescripcionMiscelaneosXParam(
							wCompania, "HR", "FUNCIONES", wDsFunciones.get(i).getFuncion());
					if (UValidador.estaVacio(wFuncion)) {
						wFuncion = this.getFacCore().getMaMiscelaneosdetalleServicio()
								.obtenerDescripcionMiscelaneosXParam("999999", "HR", "FUNCIONES",
										wDsFunciones.get(i).getFuncion());
					}
					HrEmpleadofuncion bean = new HrEmpleadofuncion();
					bean.getPk().setCompanyowner(ivCompania);
					bean.getPk().setEmpleado(wEmpleado);
					bean.getPk().setSecuenciaeval(wSecuenciaeval);
					bean.getPk().setSecuencia(i);
					bean.setFuncion(wDsFunciones.get(i).getComentarios());
					bean.setAlcanzado(BigDecimal.ZERO);
					bean.setComentarios("");
					bean.getPk().setEmpleadoevaluador(ivEmpleadoevaluador);
					bean.setFactorparticipacion(wDsFunciones.get(i).getFactorparticipacion());
					this.getDw11().add(bean);
				}
			}
		}
	}

	public String wfCopyPlantilla() throws Exception {
		Integer w_insertrow_dw_15, w_insertrow_dw_15_p, m, n, w_row, w_rowcount, ll_rowcount, lv_empleado,
				lv_secuenciaEval;
		String w_FlagPonderar, lv_companyowner, w_plantillaEvaluacion, w_plantillaPotencial, w_flagdesempenio,
				w_flagpotencial, w_flagconceptual, msj = "";
		Integer w_resp1 = 0, w_resp2 = 0, w_resp3 = 0;
		BigDecimal lv_ordenplantilla, w_factor;

		if (UValidador.esNulo(this.getDw_evaluacion())) {
			return null;
		}

		// ----------aCT HOCR 20110310 -----//
		if (idsTabs.size() > 0) {
		} else {
			return null;
		}

		// ----------aCT HOCR 20110310 -----//
		w_flagdesempenio = idsTabs.get(0).getFlagdesempeno2();
		w_flagpotencial = idsTabs.get(0).getFlagpotencial();
		w_flagconceptual = idsTabs.get(0).getFlagconceptual();

		lv_empleado = this.getDw_evaluacion().getEmpleado().intValue();
		lv_secuenciaEval = this.getDw_evaluacion().getSecuenciaeval().intValue();
		lv_companyowner = this.getDw_evaluacion().getCompanyowner();

		/*
		 * reemplazan a la funcion wf_sql_get_plantilla_cargo
		 */
		w_plantillaEvaluacion = wfGetPlantilla(ivCompania, ivSecuencia, ConstanteRrhh.TIPO_PLANTILLA_D, lv_empleado)
				.toString();
		w_plantillaPotencial = wfGetPlantilla(ivCompania, ivSecuencia, ConstanteRrhh.TIPO_PLANTILLA_P, lv_empleado)
				.toString();

		if (w_flagpotencial.equals(ConstanteRrhh.TIPO_SI)) {
			if (this.getDw9().size() > 0) {
				if (opciones.isIv_eliminar()) {
					getFacRrhh().getHrDetalleevaluacionServicio().eliminarevaluacion(ivCompania, ivSecuencia,
							ivEmpleado, ivEmpleadoevaluador, ConstanteRrhh.TIPO_DETALLEEVALUACION_F);

					this.getDw9().clear();
					this.getDw15p().clear();
				} else {
					w_resp1 = ConstanteRrhh.TIPO_RESPUESTA_DOS;
				}
			} else {
				w_resp1 = ConstanteRrhh.TIPO_RESPUESTA_UNO;
			}

		}

		/*
		 * realizamos la busqueda para actualizar el dw_1
		 */
		CwHrDetalleEvaluacion.getInstance().setStrpass(strpass);
		CwHrDetalleEvaluacion.getInstance().buscar();
		LOGGER.debug(this.getDw1());

		if (w_flagdesempenio.equals(ConstanteRrhh.TIPO_SI)) {
			if (this.getDw1().size() > 0) {
				if (opciones.isIv_eliminar()) {

					getFacRrhh().getHrDetalleevaluacionServicio().eliminarevaluacion(ivCompania, ivSecuencia,
							ivEmpleado, ivEmpleadoevaluador, ConstanteRrhh.TIPO_DETALLEEVALUACION_N);

					getFacRrhh().getHrDetalleevaluacionmejoraServicio().eliminarDetalleEvaluacionMejora(ivCompania,
							ivEmpleado, ivSecuencia, ivEmpleadoevaluador);

					this.setDw1(new ArrayList<DtoHrDetalleEvaluacion>());
					// dw15.reset();
					w_resp2 = ConstanteRrhh.TIPO_RESPUESTA_UNO;
				} else {
					w_resp2 = ConstanteRrhh.TIPO_RESPUESTA_DOS;
				}
			} else {
				w_resp2 = ConstanteRrhh.TIPO_RESPUESTA_UNO;
			}
		}

		if (w_flagconceptual.equals(ConstanteRrhh.TIPO_SI)) {
			// NO SE HACE ESTE PROCESO EL TAB dw_2 no se usa
		}

		if (w_flagdesempenio.equals(ConstanteRrhh.TIPO_SI)) {
			if (UValidador.estaVacio(w_plantillaEvaluacion)) {
				msj = "Aviso, Plantilla Desempeño no asignada al puesto";
				return msj;
			}

		}

		if (w_flagpotencial.equals(ConstanteRrhh.TIPO_SI)) {
			if (UValidador.estaVacio(w_plantillaPotencial)) {
				msj = "Aviso, Plantilla Potencial no asignada al puesto";
				return msj;
			}
		}

		List<DtoHRFactoresEvaluacion> ds_factores = getFacRrhh().getHrFactoresevaluacionServicio()
				.obtenerFactoresEvaluacion(w_plantillaPotencial);

		if (ds_factores.size() > 0) {
			for (DtoHRFactoresEvaluacion objfactor : ds_factores) {
				lv_ordenplantilla = objfactor.getOrdenplantilla();
				if (objfactor.getFlagpotencial().equals(ConstanteRrhh.TIPO_SI)) {
					if (w_resp1.equals(1)) {
						w_factor = objfactor.getFactor();

						List<HrFactorvalor> ds_factores_val = getFacRrhh().getHrFactorvalorServicio()
								.obtenerLista(w_factor.intValue());
						w_rowcount = ds_factores_val.size();
						DtoDDesempenocomparativoP dw_15_p = new DtoDDesempenocomparativoP();
						dw_15_p.setValorrequerido(objfactor.getValorrequerido());
						dw_15_p.setValorminimoesperado(objfactor.getValorminimoesperado());
						dw_15_p.setOrdenfactor(lv_ordenplantilla);

						DtoDwHrEmpleadoevaluacionDetailP dtodw_9 = new DtoDwHrEmpleadoevaluacionDetailP();

						for (HrFactorvalor dsFactoresTemp : ds_factores_val) {
							dtodw_9.setFactorvalor_des(dsFactoresTemp.getDescripcion());
							dtodw_9.setValor(dsFactoresTemp.getValor());
							dtodw_9.setValorhasta(dsFactoresTemp.getValorhasta());
							dtodw_9.setExplicacion(dsFactoresTemp.getExplicacion());
							dtodw_9.setExplicacion_factor(objfactor.getExplicacion_factor());

							dtodw_9.setSecuenciaeval(new BigDecimal(lv_secuenciaEval));
							dtodw_9.setCompanyowner(lv_companyowner);
							dtodw_9.setEmpleado(new BigDecimal(lv_empleado));
							dtodw_9.setFactor(w_factor);
							dtodw_9.setTipo(ConstanteRrhh.TIPO_DETALLEEVALUACION_F);
							dtodw_9.setOrdenfactor(lv_ordenplantilla);
							dtodw_9.setPlantilla(w_plantillaPotencial);
							dtodw_9.setFactor_des(objfactor.getDescripcion_factor());
							dtodw_9.setEmpleadoevaluador(new BigDecimal(ivEmpleadoevaluador));

							this.getDw9().add(dtodw_9);
						}

					}
				}
				// dw_9.sort()
			}
		}

		ds_factores = null;
		ds_factores = getFacRrhh().getHrFactoresevaluacionServicio().obtenerFactoresEvaluacion(w_plantillaEvaluacion);

		if (ds_factores.size() > 0) {
			m = 0;

			LOGGER.debug("TAMAÑO GRAFICO::" + CwHrDetalleEvaluacion.getInstance().getDwGrafico().size());
			CwHrDetalleEvaluacion.getInstance().getDwGrafico().clear();
			for (DtoHRFactoresEvaluacion objfactor : ds_factores) {
				m++;
				lv_ordenplantilla = objfactor.getOrdenplantilla();

				if (objfactor.getFlagconcepto().equals(ConstanteRrhh.TIPO_NO)) {
					if (objfactor.getFlagcompetencia().equals(ConstanteRrhh.TIPO_SI)) {
						if (w_resp2.equals(1)) {
							w_factor = objfactor.getFactor();
							DtoHrDetalleEvaluacion dtodw1 = new DtoHrDetalleEvaluacion();

							// CwHrDetalleEvaluacion.getInstance().getDwGrafico()
							// .clear();

							// ...
							// w_insertrow_dw_15_p = dw_15_p.insertrow(0)
							DtoHrDetalleEvaluacionGrafico dtoGrafico = new DtoHrDetalleEvaluacionGrafico();

							dtoGrafico.setDescripcion2(objfactor.getDescripcion_factor());
							dtoGrafico.setDescripcion(objfactor.getDescripcionarea());
							dtoGrafico.setArea(objfactor.getArea());
							dtoGrafico.setValorrequerido(objfactor.getValorrequerido());
							dtoGrafico.setValorminimoesperado(objfactor.getValorminimoesperado());
							dtoGrafico.setFactor(w_factor);
							dtoGrafico.setOrdenfactor(lv_ordenplantilla);

							LOGGER.debug("SIZE::" + CwHrDetalleEvaluacion.getInstance().getDwGrafico().size());
							CwHrDetalleEvaluacion.getInstance().getDwGrafico().add(dtoGrafico);

							dtodw1.setExplicacionfactor(objfactor.getExplicacion_factor());
							dtodw1.setSecuencia(new BigDecimal(m));
							dtodw1.setSecuenciaeval(new BigDecimal(lv_secuenciaEval));
							dtodw1.setCompanyowner(lv_companyowner);
							dtodw1.setEmpleado(new BigDecimal(lv_empleado));
							dtodw1.setFactor(w_factor);
							dtodw1.setTipo(ConstanteRrhh.TIPO_NO);
							dtodw1.setPlantilla(w_plantillaEvaluacion);
							dtodw1.setArea(objfactor.getArea());
							dtodw1.setFactor_des(objfactor.getDescripcion_factor());
							dtodw1.setEmpleadoevaluador(new BigDecimal(ivEmpleadoevaluador));
							dtodw1.setCompetencias(objfactor.getDescripcionarea());
							// /////////////////////ACT///////2009-04-06//////////////
							dtodw1.setValorcompetencia(objfactor.getCf_minimo());
							dtodw1.setValorhastacompetencia(objfactor.getCf_maximo());
							dtodw1.setOrdenplantilla(lv_ordenplantilla);
							// /////////////////////////////////////////////////////////////

							List<DtoHRFactoresEvaluacion> ds_factoresValores = getFacRrhh()
									.getHrFactoresevaluacionServicio().obtenerValoresEvaluacion(w_plantillaEvaluacion);
							if (ds_factoresValores.size() > 0) {
								for (DtoHRFactoresEvaluacion objtValores : ds_factoresValores) {
									dtodw1.setValorcompetencia(objtValores.getCf_minimo());
									dtodw1.setValorhastacompetencia(objtValores.getCf_maximo());
								}
							} else {
								dtodw1.setValorcompetencia(new BigDecimal(0));
								dtodw1.setValorhastacompetencia(new BigDecimal(0));
							}

							if (objfactor.getFlagconcepto().equals(ConstanteRrhh.TIPO_FLAG_CONCEPTO_C)) {
								if (w_resp3.equals(ConstanteRrhh.TIPO_RESPUESTA_UNO)) {
									// NO SE HACE ESTE PROCESO EL TAB dw_2 no se
									// usa
								}
							}

							this.getDw1().add(dtodw1);
						}

					}
				}

			}

		}

		CwHrDetalleEvaluacion.getInstance().llenarGrillas();
		return msj;

	}

	private String wfGetPlantilla(String iv_compania, Integer iv_secuencia, String as_tipoplantilla,
			Integer al_empleado) {

		return this.getFacRrhh().getHrFactoresevaluacionplantillaServicio().obtenerPlantillaEmpleado(iv_compania,
				iv_secuencia, as_tipoplantilla, al_empleado);
	}

	private void recuperarFoto(Integer empleado) {
		Empleadomast e = this.getFacCore().getEmpleadomastServicio().obtenerEmpleadoMast(empleado);
		if (!UValidador.esNulo(e)) {
			if (!UValidador.esNulo(e.getFotografia()))
				fotografiaBase64 = Base64.encode(e.getFotografia());
			else
				fotografiaBase64 = null;
		}
	}

	public void selectionChanged(TabChangeEvent event) {

		if (!UValidador.esNulo(event.getTab())) {

			switch (event.getTab().getId()) {
			case "tab15":
				BigDecimal wCalificacion, wFactor;
				Integer wExiste = 0;
				dsCopia = new ArrayList<HrDetalleevaluacionmejora>();

				if (this.getDwcompromisomejora().size() > 0) {
					dsCopia.addAll(this.getDwcompromisomejora());
				}

				this.getDwcompromisomejora().clear();

				for (DtoHrDetalleEvaluacion de : this.getDw1()) {
					// si es nulo no se compara
					wCalificacion = UValidador.esNulo(de.getCalificacion()) ? BigDecimal.TEN : de.getCalificacion();
					wFactor = UValidador.esNulo(de.getFactor()) ? BigDecimal.ZERO : de.getFactor();

					if (wCalificacion.compareTo(new BigDecimal(3)) == -1
							|| wCalificacion.compareTo(new BigDecimal(3)) == 0) {

						for (HrDetalleevaluacionmejora dem : this.getDwcompromisomejora()) {
							if (dem.getPk().getEmpleado().equals(ivEmpleado)
									&& dem.getPk().getEmpleadoevaluador().equals(ivEmpleadoevaluador)
									&& dem.getFactor().equals(wFactor.intValue())) {
								wExiste = 1;
							} else {
								wExiste = 0;
							}
						}

						if (wExiste == 0) {
							this.getDwcompromisomejora().add(new HrDetalleevaluacionmejora());
							Integer wNuevafila = this.getDwcompromisomejora().size() - 1;
							this.getDwcompromisomejora().get(wNuevafila).getPk().setCompanyowner(ivCompania);
							this.getDwcompromisomejora().get(wNuevafila).getPk().setSecuenciaeval(ivSecuencia);
							this.getDwcompromisomejora().get(wNuevafila).getPk().setEmpleado(ivEmpleado);
							this.getDwcompromisomejora().get(wNuevafila).getPk()
									.setEmpleadoevaluador(ivEmpleadoevaluador);
							this.getDwcompromisomejora().get(wNuevafila).getPk().setSecuencia(wNuevafila + 1);
							this.getDwcompromisomejora().get(wNuevafila).getPk().setTipo(de.getTipo());
							this.getDwcompromisomejora().get(wNuevafila).setFactor(wFactor.intValue());
							this.getDwcompromisomejora().get(wNuevafila).setDescripcion(de.getFactor_des());
							this.getDwcompromisomejora().get(wNuevafila).setCalificacion(wCalificacion);

							for (HrDetalleevaluacionmejora dsc : dsCopia) {
								if (dsc.getPk().getEmpleado().equals(ivEmpleado)
										&& dsc.getPk().getEmpleadoevaluador().equals(ivEmpleadoevaluador)
										&& dsc.getFactor().equals(wFactor.intValue())) {
									this.getDwcompromisomejora().get(wNuevafila)
											.setValorrequerido(dsc.getValorrequerido());
									this.getDwcompromisomejora().get(wNuevafila).setComentarios(dsc.getComentarios());
								}
							}

							for (DtoHrDetalleEvaluacion dsc : this.getDw1()) {
								if (new BigDecimal(ivEmpleado).equals(dsc.getEmpleado())
										&& new BigDecimal(ivEmpleadoevaluador).equals(dsc.getEmpleadoevaluador())
										&& wFactor.equals(dsc.getFactor())) {
									BigDecimal wValorRequeridoFactor = null;
									HrFactoresevaluacion fe = (HrFactoresevaluacion) this.getFacRrhh()
											.getHrFactoresevaluacionServicio().obtenerPorId(new HrFactoresevaluacionPk(
													UValidador.esNulo(wFactor) ? null : wFactor.intValue()));
									if (!UValidador.esNulo(fe))
										wValorRequeridoFactor = UValidador.esNulo(fe.getValorrequerido()) ? null
												: new BigDecimal(fe.getValorrequerido());
									this.getDwcompromisomejora().get(wNuevafila)
											.setValorrequerido(wValorRequeridoFactor);
								}
							}
						}

					}
				}
				getWebControlContext().actualizar("frmEvaluacionEmpleado:tvDatos:dtCompromiso");
				break;
			case "p16":
				this.getWebControlContext().ejecutar("filterTable();");
				this.getWebControlContext()
						.actualizar("frmEvaluacionEmpleado:tvDatos:dtRevisionAvanceCompromisoMejora");
				break;
			}
		}
	}

	@Override
	public String buscar() throws Exception {

		return null;
	}

	@Override
	public String nuevo() throws Exception {

		return null;
	}

	@Override
	public String editar() throws Exception {

		return null;
	}

	@Override
	public String ver() throws Exception {

		return null;
	}

	@Override
	public String eliminar() throws Exception {

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
		return "whrevaluacionperiodolistevaluar";
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
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {

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

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public StrPass getStrpass() {
		return strpass;
	}

	public void setStrpass(StrPass strpass) {
		this.strpass = strpass;
	}

	public String getFotografiaBase64() {
		return fotografiaBase64;
	}

	public void setFotografiaBase64(String fotografiaBase64) {
		this.fotografiaBase64 = fotografiaBase64;
	}

	public OwHrEvaluacionempleadoEdit getOpciones() {
		return opciones;
	}

	public void setOpciones(OwHrEvaluacionempleadoEdit opciones) {
		this.opciones = opciones;
	}

	public String getIvAction() {
		return ivAction;
	}

	public void setIvAction(String ivAction) {
		this.ivAction = ivAction;
	}

	public String getFormOrigen() {
		return formOrigen;
	}

	public void setFormOrigen(String formOrigen) {
		this.formOrigen = formOrigen;
	}

	public DtoDwHrEvaluacionperiodoListEvaluar getRegistroSeleccionadoExterno() {
		return registroSeleccionadoExterno;
	}

	public void setRegistroSeleccionadoExterno(DtoDwHrEvaluacionperiodoListEvaluar registroSeleccionadoExterno) {
		this.registroSeleccionadoExterno = registroSeleccionadoExterno;
	}

	public Boolean getVerSalvar() {
		return verSalvar;
	}

	public void setVerSalvar(Boolean verSalvar) {
		this.verSalvar = verSalvar;
	}

	public Boolean getVerCompletar() {
		return verCompletar;
	}

	public void setVerCompletar(Boolean verCompletar) {
		this.verCompletar = verCompletar;
	}

	public Integer getAlto() {
		return alto;
	}

	public void setAlto(Integer alto) {
		this.alto = alto;
	}

	public Integer getAltoGrafico() {
		return altoGrafico;
	}

	public void setAltoGrafico(Integer altoGrafico) {
		this.altoGrafico = altoGrafico;
	}

	public Date getFechaevalfin() {
		return fechaevalfin;
	}

	public void setFechaevalfin(Date fechaevalfin) {
		this.fechaevalfin = fechaevalfin;
	}

}
