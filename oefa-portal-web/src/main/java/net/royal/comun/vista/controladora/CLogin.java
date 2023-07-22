package net.royal.comun.vista.controladora;

import java.util.Date;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import net.royal.asistencia.asmain.vista.controladora.CwAsMarcar;
import net.royal.asistencia.vista.controladora.CwAsAutorizacionPreprocesoAprobacion;
import net.royal.asistencia.vista.controladora.CwAsAutorizacionPreprocesoAprobacionSIGED;
import net.royal.asistencia.vista.controladora.CwAsAutorizacionPreprocesoHextraEdit;
import net.royal.asistencia.vista.controladora.CwAsAutorizacionReprogramacionVacaciones;
import net.royal.asistencia.vista.controladora.CwAsRep001ReporteMarcaEmpleado;
import net.royal.asistencia.vista.controladora.CwAsRep001ReporteOficialMinisterio;
import net.royal.asistencia.vista.controladora.CwAsReporteCompensacionHoras;
import net.royal.asistencia.vista.controladora.CwReporteSaldoFeriado;
import net.royal.erp.alfresco.dominio.dto.DtoParametros;
import net.royal.erp.mantenimiento.factory.FactoryErpMantenimiento;
import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.seguridad.AesEncryption;
import net.royal.framework.web.seguridad.EncriptadorMarca;
import net.royal.marcainterna.pcoefa.dominio.MvcPcOefaToken;
import net.royal.planilla.vista.controladora.CCertificado4ta5ta;
import net.royal.planilla.vista.controladora.CCertificadoCTSList;
import net.royal.planilla.vista.controladora.CConsultaBoletasEmpleado;
import net.royal.planilla.vista.controladora.CwPrVacacionesReporte;
import net.royal.rrhh.candidatos.vista.controladora.CwHrRequerimientoCandidatosList;
import net.royal.rrhh.desempenio.vista.controladora.CwHrEvaluacionPeriodoList;
import net.royal.rrhh.empleado.ficha.vista.controladora.CEmpCursos;
import net.royal.rrhh.vista.controladora.CHrActividad;
import net.royal.rrhh.vista.controladora.CHrAdmPostulantes;
import net.royal.rrhh.vista.controladora.CHrCapacitacionPublica;
import net.royal.rrhh.vista.controladora.CHrEncuesta;
import net.royal.rrhh.vista.controladora.CHrEntrevistaCAS;
import net.royal.rrhh.vista.controladora.CHrEvaluacionesCAS;
import net.royal.rrhh.vista.controladora.CHrEvaluacionesCEU;
import net.royal.rrhh.vista.controladora.CHrEvaluacionesFIFA;
import net.royal.rrhh.vista.controladora.CwHrRequerimientoList;
import net.royal.seguridad.constante.ConstanteSeguridad;
import net.royal.seguridad.factory.FactoryErpSeguridad;

@ManagedBean
@SessionScoped
public class CLogin extends net.royal.seguridad.vista.controladora.ULoginGenericoControladora {

	private static final Logger LOGGER = Logger.getLogger(CLogin.class);
	private String codigoConcepto, navigationCase;
	private DtoOpcion opcion;
	private String versionPortalServicio;
	private String versionPortalWeb;
	private String versionSeguridadServicio;
	private DtoParametros paramurl;
	private Boolean blMenu;

	public void init() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Map params = externalContext.getRequestParameterMap();

		if (UValidador.esNulo(paramurl)) {
			paramurl = new DtoParametros();
		}

		if (!paramurl.isMantener()) {
			paramurl = new DtoParametros();
			paramurl.setProceso(new String(
					UValidador.estaVacio((String) params.get("p_proceso")) ? "" : (String) params.get("p_proceso")));
			paramurl.setUuid(new String(
					UValidador.estaVacio((String) params.get("p_dato")) ? "" : (String) params.get("p_dato")));

			try {
				if (!UValidador.estaVacio(paramurl)) {
					if (!UValidador.estaVacio(paramurl.getUuid())) {
						paramurl.setUuid(paramurl.getUuid().replace(" ", "+"));
						// paramurl.setUuid(AesEncryption.encriptar(paramurl.getUuid()));

						if (ConstanteSeguridad.PROCESO_MARCACION_FROM_OEFA.equals(paramurl.getProceso())) {

							// si no existe token en estado C en bd mostrar
							// mensaje
							// "ruta inválida"
							MvcPcOefaToken mvcPcOefaToken = CwAsMarcar.getInstance().getFacMantenimiento()
									.getMvcPcOefaTokenServicio().obtenerPorToken(paramurl.getUuid());

							if (UValidador.estaVacio(mvcPcOefaToken)) {
								paramurl.setUuid(null);
								paramurl.setProceso(null);
								// setMessageWarn("Url inválida");
								return;
							}

							if (!"C".equals(mvcPcOefaToken.getTx_estado())) {
								paramurl.setUuid(null);
								paramurl.setProceso(null);
								// setMessageWarn("Url inválida");
								return;
							}

							mvcPcOefaToken.setTx_estado("T");
							mvcPcOefaToken.setTx_codigo_usuario_modificacion(
									mvcPcOefaToken.getTx_codigo_usuario_modificacion());
							mvcPcOefaToken.setFe_fecha_modificacion(new Date());
							CwAsMarcar.getInstance().getFacMantenimiento().getMvcPcOefaTokenServicio()
									.actualizar(mvcPcOefaToken);

						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public CLogin() {
		versionPortalWeb = "1.0";
		versionPortalServicio = "1.0";
		opcion = new DtoOpcion();
	}

	private void setVariablesGlobales() {
		UsuarioActual usuarioActual = (UsuarioActual) UAplicacion
				.getSessionValue(UConstante.SESION_USUARIOACTUALDOMINIO);

		CComunSession.syroyal().StrGlobal().setGv_application(usuarioActual.getAplicacionCodigo());

		CComunSession.syroyal().StrGlobal().setGv_database(usuarioActual.getPreferenciasDataBase());
		CComunSession.syroyal().StrGlobal().setGv_unidadreplicacion(usuarioActual.getUnidadReplicacionCodigo());
		CComunSession.syroyal().StrGlobal().setGv_empresa(usuarioActual.getPreferenciasEmpresa());
		CComunSession.syroyal().StrGlobal().setGv_seguridad(usuarioActual.getTipoSeguridad());
		CComunSession.syroyal().StrGlobal().setGv_pais(usuarioActual.getPaisCodigo());
		CComunSession.syroyal().StrGlobal().setGv_companyowner(usuarioActual.getCompaniaSocioCodigo());
		CComunSession.syroyal().StrGlobal().setGv_userid(usuarioActual.getLoginUsuario().toUpperCase());

		// comprobar
		CComunSession.syroyal().StrGlobal().setGv_centrocostos(usuarioActual.getCentroCostosCodigo());
		CComunSession.syroyal().StrGlobal().setGv_unidadnegocio(usuarioActual.getUnidadNegocioCodigo());
		CComunSession.syroyal().StrGlobal().setGv_sucursal(usuarioActual.getSucursalCodigo());
		CComunSession.syroyal().StrGlobal().setGv_vendor(usuarioActual.getIdPersona());
		CComunSession.syroyal().StrGlobal().setGv_period_voucher(usuarioActual.getPeriodoContableActual());
		CComunSession.syroyal().StrGlobal().setGv_origen(usuarioActual.getAlmacenCodigo());
		CComunSession.syroyal().StrGlobal().setGv_esfiscal(usuarioActual.getEsFiscal());
		CComunSession.syroyal().StrGlobal().setGv_cierrediario(usuarioActual.getCierreDiario());
		CComunSession.syroyal().StrGlobal().setGv_secuneg(usuarioActual.getSeguridadPorUnidadNegocio());
		CComunSession.syroyal().StrGlobal().setGv_plancontable(usuarioActual.getPlanContable());
		CComunSession.syroyal().StrGlobal().setGv_igv(usuarioActual.getImportePorcentajeIgv());
		CComunSession.syroyal().StrGlobal().setGv_companyprotected(usuarioActual.getCompaniaProtegida());
		CComunSession.syroyal().StrGlobal().setGv_ledgergroup(usuarioActual.getContabilidadPorDefecto());
		CComunSession.syroyal().StrGlobal().setGv_sid(usuarioActual.getUniqueIdInteger());
		CComunSession.syroyal().StrGlobal().setGv_rate(usuarioActual.getTipoCambioDelDia());
		CComunSession.syroyal().StrGlobal().setGv_responsable_empleado(usuarioActual.getIdResponsableEmpleado());

		CComunSession.syroyal().StrGlobal().setGv_anio(UFechaHora.obtenerFechaParte(new Date(), "YY") + "");
		LOGGER.debug("valid periodo contable");
		LOGGER.debug(usuarioActual.getPeriodoContableActual());
		LOGGER.debug(CComunSession.syroyal().StrGlobal().getGv_period_voucher());

	}

	private void variableEntorno(String codigoAplicacion) {
		String periodoContable;
		periodoContable = this.getFacSeguridad().getAplicacionesmastServicio().obtenerPeriodoContable(codigoAplicacion);
		LOGGER.debug("variable de entorno");
		LOGGER.debug("periodo contable:" + UValidador.obtenerValorCadenaSinNulo(periodoContable));
		LOGGER.debug("codigo aplicacion:" + UValidador.obtenerValorCadenaSinNulo(codigoAplicacion));
		CComunSession.syroyal().StrGlobal().setGv_period_voucher(periodoContable);
		CComunSession.syroyal().StrGlobal().setGv_application(codigoAplicacion);

		UsuarioActual usuarioActual = (UsuarioActual) UAplicacion
				.getSessionValue(UConstante.SESION_USUARIOACTUALDOMINIO);

		usuarioActual.setAplicacionCodigo(codigoAplicacion);
		usuarioActual.setPeriodoContableActual(periodoContable);
		UAplicacion.setSessionValue(UConstante.SESION_USUARIOACTUALDOMINIO, usuarioActual);
	}

	@Override
	public String ingresar() throws Exception {

		LOGGER.debug("ingresando al login base 1.0");

		LOGGER.debug("antes de ingresar");
		String pantalla = super.ingresar();

		LOGGER.debug("pantalla:" + pantalla);

		if (pantalla == null)
			return null;

		if (pantalla.equals(UConstante.NAVIGATIONCASE_LOGIN)) {
			paramurl.setMantener(true);
			LOGGER.debug("quedandome en el error");
			return null;
		}

		if (pantalla.equals(UConstante.NAVIGATIONCASE_BIENVENIDA)) {
			paramurl.setMantener(false);
			LOGGER.debug("entrando al popup");

			this.getOpcion().setEstiloSPGRUP01CON001(this.autorizacionConceptoStyleDisplay("SPGRUP01CON001"));
			this.getOpcion().setEstiloSPGRUP01CON002(this.autorizacionConceptoStyleDisplay("SPGRUP01CON002"));
			this.getOpcion().setEstiloSPGRUP01CON003(this.autorizacionConceptoStyleDisplay("SPGRUP01CON003"));

			this.getOpcion().setEstiloSPGRUP02CON001(this.autorizacionConceptoStyleDisplay("SPGRUP02CON001"));

			this.getOpcion().setEstiloSPGRUP03CON001(this.autorizacionConceptoStyleDisplay("SPGRUP03CON001"));
			this.getOpcion().setEstiloSPGRUP03CON002(this.autorizacionConceptoStyleDisplay("SPGRUP03CON002"));

			this.getOpcion().setEstiloSPGRUP04CON001(this.autorizacionConceptoStyleDisplay("SPGRUP04CON001"));
			this.getOpcion().setEstiloSPGRUP04CON002(this.autorizacionConceptoStyleDisplay("SPGRUP04CON002"));
			this.getOpcion().setEstiloSPGRUP04CON003(this.autorizacionConceptoStyleDisplay("SPGRUP04CON003"));
			this.getOpcion().setEstiloSPGRUP04CON004(this.autorizacionConceptoStyleDisplay("SPGRUP04CON004"));
			this.getOpcion().setEstiloSPGRUP04CON005(this.autorizacionConceptoStyleDisplay("SPGRUP04CON005"));
			this.getOpcion().setEstiloSPGRUP04CON006(this.autorizacionConceptoStyleDisplay("SPGRUP04CON006"));
			this.getOpcion().setEstiloSPGRUP04CON007(this.autorizacionConceptoStyleDisplay("SPGRUP04CON007"));
			this.getOpcion().setEstiloSPGRUP04CON009(this.autorizacionConceptoStyleDisplay("SPGRUP04CON009"));
			this.getOpcion().setEstiloSPGRUP04CON010(this.autorizacionConceptoStyleDisplay("SPGRUP04CON010"));
			this.getOpcion().setEstiloSPGRUP04CON011(this.autorizacionConceptoStyleDisplay("SPGRUP04CON011"));

			this.getOpcion().setEstiloSPGRUP05CON001(this.autorizacionConceptoStyleDisplay("SPGRUP05CON001"));
			this.getOpcion().setEstiloSPGRUP05CON002(this.autorizacionConceptoStyleDisplay("SPGRUP05CON002"));
			this.getOpcion().setEstiloSPGRUP05CON003(this.autorizacionConceptoStyleDisplay("SPGRUP05CON003"));
			this.getOpcion().setEstiloSPGRUP05CON004(this.autorizacionConceptoStyleDisplay("SPGRUP05CON004"));
			this.getOpcion().setEstiloSPGRUP05CON005(this.autorizacionConceptoStyleDisplay("SPGRUP05CON005"));
			this.getOpcion().setEstiloSPGRUP05CON006(this.autorizacionConceptoStyleDisplay("SPGRUP05CON006"));
			this.getOpcion().setEstiloSPGRUP05CON007(this.autorizacionConceptoStyleDisplay("SPGRUP05CON007"));
			this.getOpcion().setEstiloSPGRUP05CON008(this.autorizacionConceptoStyleDisplay("SPGRUP05CON008"));
			this.getOpcion().setEstiloSPGRUP05CON009(this.autorizacionConceptoStyleDisplay("SPGRUP05CON009"));
			this.getOpcion().setEstiloSPGRUP05CON010(this.autorizacionConceptoStyleDisplay("SPGRUP05CON010"));
			this.getOpcion().setEstiloSPGRUP05CON011(this.autorizacionConceptoStyleDisplay("SPGRUP05CON011"));
			this.getOpcion().setEstiloSPGRUP05CON012(this.autorizacionConceptoStyleDisplay("SPGRUP05CON012"));
			this.getOpcion().setEstiloSPGRUP05CON013(this.autorizacionConceptoStyleDisplay("SPGRUP05CON013"));

			this.getOpcion().setEstiloSPGRUP06CON001(this.autorizacionConceptoStyleDisplay("SPGRUP06CON001"));
			this.getOpcion().setEstiloSPGRUP06CON002(this.autorizacionConceptoStyleDisplay("SPGRUP06CON002"));
			this.getOpcion().setEstiloSPGRUP06CON003(this.autorizacionConceptoStyleDisplay("SPGRUP06CON003"));
			this.getOpcion().setEstiloSPGRUP06CON004(this.autorizacionConceptoStyleDisplay("SPGRUP06CON004"));

			setVariablesGlobales();

			// Acceso directo cuponeras
			if (ConstanteSeguridad.CUPONERA_CUMPLE_HIJOS.equals(paramurl.getProceso())) {
				CwAsAutorizacionPreprocesoAprobacion.getInstance().setFlagOrigenSolicitud("S");
				pantalla = CwAsAutorizacionPreprocesoAprobacion.getInstance().nuevo();
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setCategoriaautorizacion("OTRO");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setConceptoacceso("72");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().setIscambioonceptoevento(true);
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().cargarConceptoAcceso("72");
			}
			if (ConstanteSeguridad.CUPONERA_RECIEN_CASADOS.equals(paramurl.getProceso())) {
				CwAsAutorizacionPreprocesoAprobacion.getInstance().setFlagOrigenSolicitud("S");
				pantalla = CwAsAutorizacionPreprocesoAprobacion.getInstance().nuevo();
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setCategoriaautorizacion("OTRO");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setConceptoacceso("76");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().setIscambioonceptoevento(true);
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().cargarConceptoAcceso("76");
			}
			if (ConstanteSeguridad.CUPONERA_ALMUERZO_FAMILIA.equals(paramurl.getProceso())) {
				CwAsAutorizacionPreprocesoAprobacion.getInstance().setFlagOrigenSolicitud("S");
				pantalla = CwAsAutorizacionPreprocesoAprobacion.getInstance().nuevo();
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setCategoriaautorizacion("OTRO");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setConceptoacceso("73");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().setIscambioonceptoevento(true);
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().cargarConceptoAcceso("73");
			}
			if (ConstanteSeguridad.CUPONERA_ANIVERSARIO_BODAS.equals(paramurl.getProceso())) {
				CwAsAutorizacionPreprocesoAprobacion.getInstance().setFlagOrigenSolicitud("S");
				pantalla = CwAsAutorizacionPreprocesoAprobacion.getInstance().nuevo();
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setCategoriaautorizacion("OTRO");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setConceptoacceso("77");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().setIscambioonceptoevento(true);
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().cargarConceptoAcceso("77");
			}
			if (ConstanteSeguridad.CUPONERA_DIA_PADRE.equals(paramurl.getProceso())) {
				CwAsAutorizacionPreprocesoAprobacion.getInstance().setFlagOrigenSolicitud("S");
				pantalla = CwAsAutorizacionPreprocesoAprobacion.getInstance().nuevo();
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setCategoriaautorizacion("OTRO");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setConceptoacceso("06");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().setIscambioonceptoevento(true);
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().cargarConceptoAcceso("06");
			}
			if (ConstanteSeguridad.CUPONERA_DIA_MADRE.equals(paramurl.getProceso())) {
				CwAsAutorizacionPreprocesoAprobacion.getInstance().setFlagOrigenSolicitud("S");
				pantalla = CwAsAutorizacionPreprocesoAprobacion.getInstance().nuevo();
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setCategoriaautorizacion("OTRO");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setConceptoacceso("19");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().setIscambioonceptoevento(true);
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().cargarConceptoAcceso("19");
			}
			if (ConstanteSeguridad.CUPONERA_GESTION_PERSONAL.equals(paramurl.getProceso())) {
				CwAsAutorizacionPreprocesoAprobacion.getInstance().setFlagOrigenSolicitud("S");
				pantalla = CwAsAutorizacionPreprocesoAprobacion.getInstance().nuevo();
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setCategoriaautorizacion("OTRO");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setConceptoacceso("75");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().setIscambioonceptoevento(true);
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().cargarConceptoAcceso("75");
			}
			if (ConstanteSeguridad.CUPONERA_TARDE_LIBRE.equals(paramurl.getProceso())) {
				CwAsAutorizacionPreprocesoAprobacion.getInstance().setFlagOrigenSolicitud("S");
				pantalla = CwAsAutorizacionPreprocesoAprobacion.getInstance().nuevo();
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setCategoriaautorizacion("OTRO");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setConceptoacceso("74");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().setIscambioonceptoevento(true);
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().cargarConceptoAcceso("74");
			}
			if (ConstanteSeguridad.CUPONERA_AMOR_SALUD.equals(paramurl.getProceso())) {
				CwAsAutorizacionPreprocesoAprobacion.getInstance().setFlagOrigenSolicitud("S");
				pantalla = CwAsAutorizacionPreprocesoAprobacion.getInstance().nuevo();
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setCategoriaautorizacion("OTRO");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setConceptoacceso("85");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().setIscambioonceptoevento(true);
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().cargarConceptoAcceso("85");
			}
			if (ConstanteSeguridad.CUPONERA_CONTROL_NINO.equals(paramurl.getProceso())) {
				CwAsAutorizacionPreprocesoAprobacion.getInstance().setFlagOrigenSolicitud("S");
				pantalla = CwAsAutorizacionPreprocesoAprobacion.getInstance().nuevo();
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setCategoriaautorizacion("OTRO");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setConceptoacceso("84");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().setIscambioonceptoevento(true);
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().cargarConceptoAcceso("84");
			}
			if (ConstanteSeguridad.CUPONERA_TIEMPO_FAMILIA.equals(paramurl.getProceso())) {
				CwAsAutorizacionPreprocesoAprobacion.getInstance().setFlagOrigenSolicitud("S");
				pantalla = CwAsAutorizacionPreprocesoAprobacion.getInstance().nuevo();
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setCategoriaautorizacion("OTRO");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setConceptoacceso("83");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().setIscambioonceptoevento(true);
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().cargarConceptoAcceso("83");
			}
			if (ConstanteSeguridad.CUPONERA_VIERNES_VERANO.equals(paramurl.getProceso())) {
				CwAsAutorizacionPreprocesoAprobacion.getInstance().setFlagOrigenSolicitud("S");
				pantalla = CwAsAutorizacionPreprocesoAprobacion.getInstance().nuevo();
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setCategoriaautorizacion("OTRO");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().getDw_1().setConceptoacceso("86");
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().setIscambioonceptoevento(true);
				CwAsAutorizacionPreprocesoHextraEdit.getInstance().cargarConceptoAcceso("86");
			}

			blMenu = true;
			if (!UValidador.estaVacio(paramurl.getProceso())) {
				if (ConstanteSeguridad.PROCESO_MARCACION_FROM_OEFA.equals(paramurl.getProceso())) {
					setSessionValue(ConstanteSeguridad.PROCESO_MARCACION_FROM_OEFA, paramurl.getUuid());
					blMenu = false;
					return CwAsMarcar.getInstance().iniciarControladora();
				}
			}

			return pantalla;
		}

		return null;
	}

	public String ejecutarMenu() throws Exception {
		UsuarioActual usuarioActual = (UsuarioActual) UAplicacion
				.getSessionValue(UConstante.SESION_USUARIOACTUALDOMINIO);

		if (UValidador.esNulo(usuarioActual)) {
			return UConstante.NAVIGATIONCASE_LOGIN;
		}

		return this.ejecutarMenu(codigoConcepto, navigationCase);
	}

	@Override
	public String ejecutarMenu(String pCodigoConcepto, String pNavigationCase) throws Exception {

		pNavigationCase = super.ejecutarMenu(pCodigoConcepto, pNavigationCase);

		if (pCodigoConcepto.equals("SPGRUP04CON011")) {
			this.variableEntorno("AS");
			CwAsAutorizacionPreprocesoAprobacionSIGED.getInstance().setFlagOrigenSolicitud("A");
			pNavigationCase = CwAsAutorizacionPreprocesoAprobacionSIGED.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		if (pCodigoConcepto.equals("SPGRUP04CON010")) {

			LOGGER.debug("SPGRUP04CON003 - Estamos en el Solicitudes...");

			this.variableEntorno("AS");
			CwAsAutorizacionPreprocesoAprobacionSIGED.getInstance().setFlagOrigenSolicitud("S");

			LOGGER.debug("Antes del iniciarControladora()");

			pNavigationCase = CwAsAutorizacionPreprocesoAprobacionSIGED.getInstance().iniciarControladora();
			LOGGER.debug("Despues del iniciarControladora()");

			return pNavigationCase;
		}

		if (pCodigoConcepto.equals("SPGRUP04CON001")) {
			this.variableEntorno("AS");
			CwAsAutorizacionPreprocesoAprobacion.getInstance().setFlagOrigenSolicitud("A");
			pNavigationCase = CwAsAutorizacionPreprocesoAprobacion.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		if (pCodigoConcepto.equals("SPGRUP04CON002")) {
			this.variableEntorno("AS");
			pNavigationCase = CwAsMarcar.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		if (pCodigoConcepto.equals("SPGRUP04CON003")) {

			LOGGER.debug("SPGRUP04CON003 - Estamos en el Solicitudes...");

			this.variableEntorno("AS");
			CwAsAutorizacionPreprocesoAprobacion.getInstance().setFlagOrigenSolicitud("S");

			LOGGER.debug("Antes del iniciarControladora()");

			pNavigationCase = CwAsAutorizacionPreprocesoAprobacion.getInstance().iniciarControladora();
			LOGGER.debug("Despues del iniciarControladora()");

			return pNavigationCase;
		}

		if (pCodigoConcepto.equals("SPGRUP04CON004")) {
			this.variableEntorno("AS");
			pNavigationCase = CwAsRep001ReporteOficialMinisterio.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		if (pCodigoConcepto.equals("SPGRUP04CON005")) {
			this.variableEntorno("AS");
			pNavigationCase = CwAsRep001ReporteMarcaEmpleado.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		// Feriados Compensados
		if (pCodigoConcepto.equals("SPGRUP04CON006")) {
			this.variableEntorno("AS");
			pNavigationCase = CwReporteSaldoFeriado.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		// Horas Compensadas
		if (pCodigoConcepto.equals("SPGRUP04CON007")) {
			this.variableEntorno("AS");
			pNavigationCase = CwReporteSaldoFeriado.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		// Horas Compensadas
		if (pCodigoConcepto.equals("SPGRUP04CON008")) {
			this.variableEntorno("AS");
			CwAsAutorizacionReprogramacionVacaciones.getInstance().setFlagOrigenSolicitud("S");
			pNavigationCase = CwAsAutorizacionReprogramacionVacaciones.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		// Horas Compensadas
		if (pCodigoConcepto.equals("SPGRUP04CON009")) {
			this.variableEntorno("AS");
			pNavigationCase = CwAsReporteCompensacionHoras.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		// ** RRHH **///
		if (pCodigoConcepto.equals("SPGRUP05CON001")) {
			// req de personal
			this.variableEntorno("HR");
			pNavigationCase = CwHrRequerimientoList.getInstance().iniciarControladora();
			return pNavigationCase;
		}
		if (pCodigoConcepto.equals("SPGRUP05CON002")) {
			this.variableEntorno("HR");
			pNavigationCase = CwHrRequerimientoCandidatosList.getInstance().iniciarControladora();
			return pNavigationCase;
		}
		if (pCodigoConcepto.equals("SPGRUP05CON003")) {
			this.variableEntorno("HR");
			LOGGER.debug("SPGRUP05CON003 - EVALUACION DESEMPEÑO");
			CwHrEvaluacionPeriodoList.getInstance().setEventname("opened");
			pNavigationCase = CwHrEvaluacionPeriodoList.getInstance().iniciarControladora();
			return pNavigationCase;
		}
		if (pCodigoConcepto.equals("SPGRUP05CON004")) {
			this.variableEntorno("HR");
			pNavigationCase = CHrEncuesta.getInstance().iniciarControladora();
			return pNavigationCase;
		}
		if (pCodigoConcepto.equals("SPGRUP05CON005")) {
			this.variableEntorno("HR");
			pNavigationCase = CHrActividad.getInstance().iniciarControladora();
			return pNavigationCase;
		}
		if (pCodigoConcepto.equals("SPGRUP05CON006")) {
			this.variableEntorno("HR");// cursos
			pNavigationCase = CEmpCursos.getInstance().iniciarControladora();
			return pNavigationCase;
		}
		if (pCodigoConcepto.equals("SPGRUP05CON007")) {
			this.variableEntorno("HR");// materiales
			pNavigationCase = CEmpCursos.getInstance().iniciarControladora();
			return pNavigationCase;
		}
		if (pCodigoConcepto.equals("SPGRUP05CON008")) {
			this.variableEntorno("HR");// capacitaciones publicas
			pNavigationCase = CHrCapacitacionPublica.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		if (pCodigoConcepto.equals("SPGRUP05CON009")) {
			this.variableEntorno("HR");// Evaluaciones CAS
			pNavigationCase = CHrEvaluacionesCAS.getInstance().iniciarControladora();
			return pNavigationCase;
		}
		if (pCodigoConcepto.equals("SPGRUP05CON010")) {
			this.variableEntorno("HR");// Entrevista CAS
			pNavigationCase = CHrEntrevistaCAS.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		if (pCodigoConcepto.equals("SPGRUP05CON011")) {
			this.variableEntorno("HR");// Entrevistas CAS
			pNavigationCase = CHrEvaluacionesCEU.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		if (pCodigoConcepto.equals("SPGRUP05CON012")) {
			this.variableEntorno("HR");// Entrevistas CAS
			pNavigationCase = CHrEvaluacionesCEU.getInstance().iniciarControladoraSala();
			return pNavigationCase;
		}

		if (pCodigoConcepto.equals("SPGRUP05CON013")) {
			this.variableEntorno("HR");// Adm postulantes
			pNavigationCase = CHrAdmPostulantes.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		if (pCodigoConcepto.equals("SPGRUP05CON014")) {
			this.variableEntorno("HR");// Evaluaciones FIFA
			pNavigationCase = CHrEvaluacionesFIFA.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		if (pCodigoConcepto.equals("SPGRUP05CON015")) {
			this.variableEntorno("HR");// Evaluaciones FIFA salas
			pNavigationCase = CHrEvaluacionesFIFA.getInstance().iniciarControladoraSala();
			return pNavigationCase;
		}

		// ** PLANILLAS **///
		if (pCodigoConcepto.equals("SPGRUP06CON001")) {
			this.variableEntorno("PR");
			pNavigationCase = CConsultaBoletasEmpleado.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		if (pCodigoConcepto.equals("SPGRUP06CON002")) {
			this.variableEntorno("PR");
			pNavigationCase = CCertificado4ta5ta.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		if (pCodigoConcepto.equals("SPGRUP06CON003")) {
			this.variableEntorno("PR");
			pNavigationCase = CwPrVacacionesReporte.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		if (pCodigoConcepto.equals("SPGRUP06CON004")) {
			this.variableEntorno("PR");
			pNavigationCase = CCertificadoCTSList.getInstance().iniciarControladora();
			return pNavigationCase;
		}

		if (pCodigoConcepto.equals("PRUEBA01")) {
			pNavigationCase = "prueba01";
			return pNavigationCase;
		}

		if (pCodigoConcepto.equals("INICIO")) {
			return UConstante.NAVIGATIONCASE_BIENVENIDA;
		}

		return pNavigationCase;
	}

	public void onIdle() {
		getWebControlContext().ejecutar("PF('popTimeOut').show()");
	}

	public String getCodigoConcepto() {
		return codigoConcepto;
	}

	public void setCodigoConcepto(String codigoConcepto) {
		this.codigoConcepto = codigoConcepto;
	}

	public String getNavigationCase() {
		return navigationCase;
	}

	public void setNavigationCase(String navigationCase) {
		this.navigationCase = navigationCase;
	}

	public DtoOpcion getOpcion() {
		return opcion;
	}

	public void setOpcion(DtoOpcion opcion) {
		this.opcion = opcion;
	}

	public String getVersionPortalServicio() {
		return this.versionPortalServicio;
	}

	public void setVersionPortalServicio(String versionPortalServicio) {
		this.versionPortalServicio = versionPortalServicio;
	}

	public String getVersionPortalWeb() {
		return versionPortalWeb;
	}

	public void setVersionPortalWeb(String versionPortalWeb) {
		this.versionPortalWeb = versionPortalWeb;
	}

	public String getVersionSeguridadServicio() {
		return ConstanteSeguridad.VERSION;
	}

	public void setVersionSeguridadServicio(String versionSeguridadServicio) {
		this.versionSeguridadServicio = versionSeguridadServicio;
	}

	public Boolean getBlMenu() {
		return blMenu;
	}

	public void setBlMenu(Boolean blMenu) {
		this.blMenu = blMenu;
	}

}
