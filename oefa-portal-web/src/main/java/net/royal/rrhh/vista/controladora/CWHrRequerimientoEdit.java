package net.royal.rrhh.vista.controladora;

import java.io.File;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.UploadedFile;

import net.royal.alfresco.ws.ContenidoECMBean;
import net.royal.alfresco.ws.RptaWsBean;
import net.royal.asistencia.vista.controladora.CwWhDocumentoArchivoList;
import net.royal.asistencia.vista.conversion.CVTDtoCompania;
import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CBindingController;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDwPrEmpleadoSelect;
import net.royal.erp.asistencia.dominio.AsTipohorario;
import net.royal.erp.asistencia.symast.dominio.dto.DtoDwMaMiscelaneosdetalleSelect;
import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.contabilidad.dominio.AcCostcentermstPk;
import net.royal.erp.contabilidad.dominio.AcSucursal;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.EmpleadomastPk;
import net.royal.erp.core.dominio.MaMiscelaneosdetallePk;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.core.dominio.Personamast;
import net.royal.erp.core.dominio.PersonamastPk;
import net.royal.erp.planilla.dominio.PrFuentefinanciamiento;
import net.royal.erp.planilla.dominio.dto.DtoMetaPresupuestal;
import net.royal.erp.presupuesto.dominio.BuNivelserviciomst;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrCargosmast;
import net.royal.erp.rrhh.dominio.HrGradosalariomast;
import net.royal.erp.rrhh.dominio.HrGradosalariomastPk;
import net.royal.erp.rrhh.dominio.HrMotivocese;
import net.royal.erp.rrhh.dominio.HrOrganigrama;
import net.royal.erp.rrhh.dominio.HrPosicionempresa;
import net.royal.erp.rrhh.dominio.HrPosicionempresaPk;
import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.erp.rrhh.dominio.HrPuestoempresaPk;
import net.royal.erp.rrhh.dominio.HrRequerimiento;
import net.royal.erp.rrhh.dominio.HrRequerimientoAdjunto;
import net.royal.erp.rrhh.dominio.HrRequerimientoPk;
import net.royal.erp.rrhh.dominio.HrRequerimientofuncas;
import net.royal.erp.rrhh.dominio.HrRequerimientofuncasdet;
import net.royal.erp.rrhh.dominio.HrRequerimientofunprac;
import net.royal.erp.rrhh.dominio.HrRequerimientoobservacion;
import net.royal.erp.rrhh.dominio.HrRequerimientoobservacionPk;
import net.royal.erp.rrhh.dominio.HrRequerimientoreemplazo;
import net.royal.erp.rrhh.dominio.HrTipocontrato;
import net.royal.erp.rrhh.dominio.HrTipocontratoPk;
import net.royal.erp.rrhh.dominio.HrTipotrabajador;
import net.royal.erp.rrhh.dominio.HrTipotrabajadorPk;
import net.royal.erp.rrhh.dominio.dto.DtoDWHrTipoContratoSelect;
import net.royal.erp.rrhh.dominio.dto.DtoDddWMaHrGradoSalairalMastSelect;
import net.royal.erp.rrhh.dominio.dto.DtoDwOrganigramaOcupados;
import net.royal.erp.rrhh.dominio.dto.DtoHrEmpleadoReclutamientoSelect;
import net.royal.erp.rrhh.dominio.dto.DtoHrRequerimientoSeguimiento;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoEdit;
import net.royal.erp.rrhh.hrrep.dominio.dto.DtoDWHrPosicionesHijosAllSelect;
import net.royal.erp.rrhh.prmast.dominio.dto.DtoDwMaPrTipoplantillaSelect;
import net.royal.erp.sistema.dominio.dto.DtoDwMaCompanyownerSelect;
import net.royal.erp.sistema.dominio.dto.DtoDwWhDocumentoarchivoList;
import net.royal.framework.correo.constante.ConstanteCorreo.tipo_destino;
import net.royal.framework.correo.dominio.CorreoAdjuntoCore;
import net.royal.framework.correo.dominio.CorreoCore;
import net.royal.framework.correo.dominio.CorreoDestinoCore;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.core.UString;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.framework.web.dominio.UsuarioActual;
//import net.royal.rrhh.CVTDtoCompania;
import net.royal.rrhh.CwHrPuestosEdit;
import net.royal.rrhh.CwHrPuestosSelect;
import net.royal.rrhh.CwPrEmpleadoSelect;
//import net.royal.rrhh.CwWhDocumentoArchivoList;
import net.royal.rrhh.vista.conversion.CVTDtoMotivoSolicitud;
import net.royal.rrhh.vista.conversion.CVTDtoTipoPlanilla;
import net.royal.rrhh.vista.opciones.OWHrRequerimientoEdit;
import net.royal.rrhh.vista.paginacion.PwHrRequerimientoreemplazo;
import net.royal.seguridad.constante.ConstanteSeguridad;
import pe.gob.oefa.ws.alfresco.service.UOsinergminAlfresco;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CWHrRequerimientoEdit extends CBaseBean implements UIMantenimientoController {

	private List<DtoDwMaCompanyownerSelect> companyOwners;
	private List<DtoDwMaPrTipoplantillaSelect> dwc_tipoplanilla;
	private OWHrRequerimientoEdit opciones;

	private HashMap<String, Object> ivKeyRequerimiento;
	private String title;
	private List<DtoDwMaMiscelaneosdetalleSelect> dwc_linea_2;
	private List<DtoDwMaMiscelaneosdetalleSelect> dwc_motivo;
	private List<DtoDwMaMiscelaneosdetalleSelect> dwc_nivel1;
	private List<DtoDwMaMiscelaneosdetalleSelect> dwc_nivel2;
	private List<DtoDwMaMiscelaneosdetalleSelect> dwc_nivel3;
	private List<DtoDwMaMiscelaneosdetalleSelect> dwc_nivel4;
	private List<DtoDddWMaHrGradoSalairalMastSelect> dwc_linea;
	private List<DtoDWHrTipoContratoSelect> dwc_tipocontrato;
	private List<DtoDWHrPosicionesHijosAllSelect> dwc_unidad;

	private DtoDwHrRequerimientoEdit dw_requerimiento;
	private DtoDwHrRequerimientoEdit dw_requerimiento_backup;
	private List<HrRequerimientofuncas> dw_funcionescas;
	private HrRequerimientofuncas dw_funcionescasregistro;
	private List<HrRequerimientofuncasdet> dw_funcionescas_det;
	private HrRequerimientofuncasdet dw_funcionescasdetregistro;
	private HrRequerimientofunprac dw_funcionesprac;

	private Integer iv_motivo, tabArchivos;
	private String iv_vendornum;
	private Integer iv_VALMINAPR;
	private boolean ib_filtrar;

	private List<HrPuestoempresa> lstHrPuestoEmpresa;
	private List<HrCargosmast> lstHrCargosMast;
	private List<AcSucursal> lstSucursal;
	private List<DtoHrEmpleadoReclutamientoSelect> lstHrEmpleadoReclutamiento;

	private List<HrRequerimientoreemplazo> dw_reqadicional;
	private HrRequerimientoreemplazo dw_reqadicionalregistro;
	private ListDataModel<HrRequerimientoreemplazo> dw_reqadicionallist;
	private List<DtoHrRequerimientoSeguimiento> dw_reqseguimientolist;
	private String iv_tipopuesto;
	private HrRequerimientoobservacion dw_adicionales;

	private String iv_estado;
	private List<HrTipotrabajador> lstTipoTrabajador;

	private String nombreArchivoPDF;
	private String destinatariosEnvioCorreo;

	// Reemplazo
	private List<HrMotivocese> lstMotivoCese;

	private List<AsTipohorario> lstTipoHorario;

	private List<HrRequerimientoAdjunto> lstArchivosAdjuntos;
	private UploadedFile fileUpload;
	private HrRequerimientoAdjunto bean;

	private String requerimiento;
	private String compania;
	private Integer secuencia;
	private HrRequerimientoAdjunto archivoSeleccionado;
	private Boolean mostrarReporte;
	private String key;
	private String ws;

	private List<DtoMetaPresupuestal> lstMetas;
	private List<PrFuentefinanciamiento> fuentesFinanciamiento;

	private Boolean isrequiereperiodoprueba;

	private String archivoActual, archivoNuevo;

	private Boolean mostrarEnviar;
	private Boolean accionEnvio;

	private static final String[] MOTIVOS_VALIDAR = { "1", "8", "4", "10" };
	private static final int[] REQUISITOS_VALIDAR = { 0, 2 };

	public static CWHrRequerimientoEdit getInstance() {
		return UFaces.evaluateExpressionGet("#{cWHrRequerimientoEdit}", CWHrRequerimientoEdit.class);
	}

	public CWHrRequerimientoEdit() {
		this.PANTALLA_LISTADO = "hr_requerimiento_edit";
	}

	public String imprimirRepor() throws Exception {

		HrPosicionempresaPk pk = new HrPosicionempresaPk();
		pk.setCodigoposicion(dw_requerimiento.getCodigoposicionsolicitante().intValue());
		pk.setCompanyowner(dw_requerimiento.getCompanyowner());

		HrPosicionempresa hrposicionempresa = (HrPosicionempresa) this.getFacRrhh().getHrPosicionempresaServicio()
				.obtenerPorId(pk, false);

		String pathPrincipal;
		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
				.getRealPath("/");

		Map<String, Object> parametrosReport = new HashMap<String, Object>();

		parametrosReport.put("PAR_REQUERIMIENTO", (String) ivKeyRequerimiento.get("requerimiento"));
		parametrosReport.put("PAR_COMPANIA", (String) ivKeyRequerimiento.get("companyowner"));
		parametrosReport.put("DETALLE", hrposicionempresa.getDescripcion());
		parametrosReport.put("CONVOCATORIA", dw_requerimiento.getConvocatoria());

		File archivo = new File(pathPrincipal + File.separator + "erp" + File.separator + "rrhh" + File.separator
				+ File.separator + "recursos" + File.separator + File.separator + "reportes" + File.separator
				+ File.separator + "perfilpuesto" + File.separator + File.separator + "dw_hr_reporte_funcas.jasper");

		nombreArchivoPDF = getFacAsistencia().getAsAutorizacionServicio().ejecutarReporteIReport(archivo.getPath(),
				parametrosReport);

		CBindingController.getInstance().setNombreArchivoTemporal(nombreArchivoPDF);

		return "pantallaReporteVistaExterna";
	}

	@SuppressWarnings("unchecked")
	@Override
	public String iniciarControladora() throws Exception {
		LOGGER.debug("CWHrRequerimientoEdit.wfOpen()");
		tabArchivos = 0;
		lstArchivosAdjuntos = new ArrayList<HrRequerimientoAdjunto>();
		mostrarReporte = false;
		mostrarEnviar = (Boolean) ivKeyRequerimiento.get("Enviar");

		accionEnvio = false;
		isrequiereperiodoprueba = false;

		inicializarFiltrosListado();

		inicializarDatosMantenimiento();

		setIndiceActivoTabMantenimiento(0);

		if (UValidador.esNulo(ivKeyRequerimiento)) {
			ivKeyRequerimiento = new HashMap<>();
		}

		if (UValidador.esListaVacia(companyOwners)) {
			companyOwners = getFacCore().getCompanyownerServicio()
					.DwMaCompanyownerSelect(getUsuarioActual().getCompaniaSocioCodigo());

			CVTDtoCompania.lista = companyOwners;
		}

		String retorno = null;

		retorno = this.PANTALLA_LISTADO;
		if (wfOpen() != 0) {
			retorno = UConstante.NAVIGATIONCASE_BIENVENIDA;
		}

		// por defecto el tipo de trabajador cargará en blanco
		// REQ ELKA 17-11-2015

		String accion = (String) ivKeyRequerimiento.get("Action");
		if (UValidador.esNulo(accion))
			accion = "";

		if ("AGREGAR".equals(accion)) {
			dw_requerimiento.setTipotrabajador("02");
		}

		cargarObjetoSelector();

		dw_requerimiento_backup = new DtoDwHrRequerimientoEdit();

		mostarReporte();

		this.archivoActual = StringUtils.EMPTY;
		this.archivoNuevo = StringUtils.EMPTY;
		if (!UValidador.esNulo(dw_requerimiento.getRutasustento()))
			this.archivoActual = dw_requerimiento.getRutasustento();

		this.configurarPuestoPorDefecto();

		return retorno;
	}

	private void configurarPuestoPorDefecto() {
		Integer puestoDefault = this.getFacCore().getParametrosmastServicio()
				.obtenerValorInteger(new ParametrosmastPk("HR", "999999", "COPUEREQUE"));

		if (!UValidador.esNulo(puestoDefault)) {
			HrPuestoempresa hrPuesto = (HrPuestoempresa) this.getFacRrhh().getHrPuestoempresaServicio()
					.obtenerPorId(new HrPuestoempresaPk(puestoDefault), false);
			if (!UValidador.esNulo(hrPuesto))
				this.cargarPuestoSeleccionado(hrPuesto);
		}
	}

	private Integer wfOpen() throws Exception {
		LOGGER.debug("CWHrRequerimientoEdit.wfOpen()");

		dwc_nivel1 = this.getFacAsistencia().getAS().getSymastDatawindow().DwMaMiscelaneosdetalleSelect("HR",
				"NIVELIDIOM", "999999");
		dwc_nivel2 = this.getFacAsistencia().getAS().getSymastDatawindow().DwMaMiscelaneosdetalleSelect("HR",
				"NIVELIDIOM", "999999");
		dwc_nivel3 = this.getFacAsistencia().getAS().getSymastDatawindow().DwMaMiscelaneosdetalleSelect("HR",
				"NIVELIDIOM", "999999");
		dwc_nivel4 = this.getFacAsistencia().getAS().getSymastDatawindow().DwMaMiscelaneosdetalleSelect("HR",
				"NIVELIDIOM", "999999");

		if (getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm("HR",
				getUsuarioActual().getLoginUsuario().toUpperCase())) {
			opciones.setIshabilitarcbver1(true);
			opciones.setIshabilitarcbver2(true);
		} else {
			opciones.setIshabilitarcbver1(false);
			opciones.setIshabilitarcbver2(false);
		}

		iv_vendornum = this.getFacAsistencia().getAS().getSycommFuncion().FSqlReadParametrosmastS("AC", "999999",
				"VENDORNUM");
		iv_VALMINAPR = this.getFacAsistencia().getAS().getSycommFuncion().FSqlReadParametrosmastN("HR", "999999",
				"VALMINAPR");

		dwc_motivo = this.getFacAsistencia().getAS().getSymastDatawindow().DwMaMiscelaneosdetalleSelect("HR",
				"MOTIVOREQ", "999999");
		CVTDtoMotivoSolicitud.lista = dwc_motivo;

		dwc_linea_2 = this.getFacAsistencia().getAS().getSymastDatawindow().DwMaMiscelaneosdetalleSelect("HR",
				"CARGLINEAC", "999999");

		dwc_tipocontrato = this.getFacRrhh().getHr().getHrprocDatawindow().dWHrTipoContratoSelect();

		this.title = ((String) ivKeyRequerimiento.get("Action")).substring(0, 1).toUpperCase()
				+ ((String) ivKeyRequerimiento.get("Action")).substring(1).toLowerCase() + "  " + this.title;

		switch ((String) ivKeyRequerimiento.get("Action")) {
		case ConstanteRrhh.ACCION_AGREGAR:
			wfSetupNew();
			break;
		case ConstanteRrhh.ACCION_VER:
		case ConstanteRrhh.ACCION_MODIFICAR:
		case ConstanteRrhh.ACCION_REVISAR:
		case ConstanteRrhh.ACCION_APROBAR:
		case ConstanteRrhh.ACCION_APROBAROAD:
		case ConstanteRrhh.ACCION_RECHAZAR:
		case ConstanteRrhh.ACCION_CONTRATAR:
		case ConstanteRrhh.ACCION_TERMINAR:
		case ConstanteRrhh.ACCION_EVALUAR:
		case ConstanteRrhh.ACCION_INGRESAR:
			if (wfOpenRetrieve() != 0)
				return -1;

			break;
		default:
			break;
		}

		opciones.setIshabilitarmotivorechazo(false);

		if (!UValidador.esNulo(dw_requerimiento.getCodigopuesto())) {
			HrPuestoempresaPk pkfind = new HrPuestoempresaPk();
			pkfind.setCodigopuesto(dw_requerimiento.getCodigopuesto().intValue());
			HrPuestoempresa objfind = (HrPuestoempresa) getFacRrhh().getHrPuestoempresaServicio().obtenerPorId(pkfind);

			if (!UValidador.esNulo(objfind)) {
				iv_tipopuesto = objfind.getFlagpuestopracticante();
			}

		}

		opciones.setIshabilitartabfuncionescas(false);
		opciones.setIsmostrartabfuncionescas(false);

		if (UValidador.estaVacio(iv_tipopuesto)) {
			iv_tipopuesto = ConstanteRrhh.TIPO_PUESTO_T;
		}

		if (iv_tipopuesto.equals(ConstanteRrhh.TIPO_PUESTO_C) || iv_tipopuesto.equals(ConstanteRrhh.TIPO_PUESTO_P)) {
			opciones.setIshabilitartabfuncionescas(true);
			opciones.setIsmostrartabfuncionescas(true);
			if (iv_tipopuesto.equals(ConstanteRrhh.TIPO_PUESTO_P)) {
				opciones.setIshabilitartabfuncionesprac(true);
				opciones.setIsmostrartabfuncionesprac(true);
			}
		}

		wfTipocontratofechas(dw_requerimiento.getTipoplanilla());

		return 0;
	}

	private void wfTipocontratofechas(String par_tipoplanilla) {
		String w_tipotrabajador, w_flagvencimiento = ConstanteRrhh.TIPO_NO;
		Object[] tipoPlanillaPerfilObj;

		tipoPlanillaPerfilObj = this.getFacRrhh().getHr().getHrprocDatawindow()
				.obtenerTipoTrabajadorPlanillaPerfil(par_tipoplanilla);
		w_tipotrabajador = (String) tipoPlanillaPerfilObj[0];

		dw_requerimiento.setTipotrabajador(w_tipotrabajador);
		w_tipotrabajador = dw_requerimiento.getTipocontrato();

		if (!UValidador.estaVacio(w_tipotrabajador)) {
			opciones.setIshabilitarfechadesde(true);

			HrTipocontratoPk pkfind = new HrTipocontratoPk();
			pkfind.setTipocontrato(w_tipotrabajador);

			HrTipocontrato objfind = (HrTipocontrato) getFacRrhh().getHrTipocontratoServicio().obtenerPorId(pkfind);

			if (!UValidador.esNulo(objfind)) {
				w_flagvencimiento = objfind.getFlagfechavencimiento();
			}

			if (w_flagvencimiento.equals(ConstanteRrhh.TIPO_SI)) {
				opciones.setIshabilitarfechahasta(true);
			} else {
				opciones.setIshabilitarfechahasta(false);
				dw_requerimiento.setFechahasta(null);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private Integer wfOpenRetrieve() throws Exception {
		BigDecimal ll_codigopuesto, w_codigounidad;
		String ls_familia, ls_Motivo;
		Integer ll_EsAdmin;

		if (getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm("HR",
				getUsuarioActual().getLoginUsuario().toUpperCase())) {
			ll_EsAdmin = 1;
		} else {
			ll_EsAdmin = 0;
		}

		dw_requerimiento = this.getFacRrhh().getHr().getHrprocDatawindow().DwHrRequerimientoEdit(
				(String) ivKeyRequerimiento.get("companyowner"), (String) ivKeyRequerimiento.get("requerimiento"));

		HrRequerimientoPk pk = new HrRequerimientoPk();
		pk.setCompanyowner((String) ivKeyRequerimiento.get("companyowner"));
		pk.setRequerimiento((String) ivKeyRequerimiento.get("requerimiento"));

		HrRequerimiento objfind = (HrRequerimiento) getFacRrhh().getHrRequerimientoServicio().obtenerPorId(pk);

		if (!UValidador.esNulo(objfind)) {
			if (!UValidador.esNulo(objfind.getSustento()) || !UValidador.estaVacio(objfind.getUuidalfresco())) {
				dw_requerimiento.setDocumento(objfind.getSustento());
				opciones.setIsmostrarver(true);
			}
		}

		dw_funcionescas = getFacRrhh().getHrRequerimientofuncasServicio().listarRequerimientoFuncas(
				getUsuarioActual().getCompaniaSocioCodigo(), (String) ivKeyRequerimiento.get("requerimiento"));

		if (!UValidador.esListaVacia(dw_funcionescas)) {
			for (HrRequerimientofuncas obj : dw_funcionescas) {
				if (obj.getPk().getSecuencia().equals(1)) {
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}
				if (obj.getPk().getSecuencia().equals(2)) {
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}
				if (obj.getPk().getSecuencia().equals(3)) {
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}
				if (obj.getPk().getSecuencia().equals(4)) {
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}
				if (obj.getPk().getSecuencia().equals(5)) {
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}
				if (obj.getPk().getSecuencia().equals(6)) {
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}
				if (obj.getPk().getSecuencia().equals(7)) {
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}
				if (obj.getPk().getSecuencia().equals(8)) {
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}
				if (obj.getPk().getSecuencia().equals(9)) {
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}
			}
		}

		dw_funcionescas_det = getFacRrhh().getHrRequerimientofuncasdetServicio().listarRequerimientoFuncasDet(
				getUsuarioActual().getCompaniaSocioCodigo(), (String) ivKeyRequerimiento.get("requerimiento"));

		List data = getFacRrhh().getHrRequerimientofunpracServicio().listarRequerimientoFunPrac(
				getUsuarioActual().getCompaniaSocioCodigo(), (String) ivKeyRequerimiento.get("requerimiento"));

		if (!UValidador.esListaVacia(data)) {
			dw_funcionesprac = (HrRequerimientofunprac) data.get(0);
			dw_funcionesprac.setAuxiliarisflagexcel(
					dw_funcionesprac.getFlagexcel().equals(ConstanteRrhh.TIPO_SI) ? true : false);
			dw_funcionesprac
					.setAuxiliarisflagword(dw_funcionesprac.getFlagword().equals(ConstanteRrhh.TIPO_SI) ? true : false);
			dw_funcionesprac.setAuxiliarisflagpowerpoint(
					dw_funcionesprac.getFlagpowerpoint().equals(ConstanteRrhh.TIPO_SI) ? true : false);
			dw_funcionesprac
					.setAuxiliarisflagotro(dw_funcionesprac.getFlagotro().equals(ConstanteRrhh.TIPO_SI) ? true : false);

			dw_funcionesprac.setAuxiliarisflagindispensableidioma(
					dw_funcionesprac.getFlagindispensableidioma().equals("S") ? true : false);
			dw_funcionesprac.setAuxiliarisflagingles(
					dw_funcionesprac.getFlagingles().equals(ConstanteRrhh.TIPO_SI) ? true : false);

			dw_funcionesprac.setAuxiliarisflagotroidioma(
					dw_funcionesprac.getFlagotroidioma().equals(ConstanteRrhh.TIPO_SI) ? true : false);

			dw_funcionesprac.setAuxiliarisflagexperiencia(
					dw_funcionesprac.getFlagexperiencia().equals(ConstanteRrhh.TIPO_SI) ? true : false);
		}

		ll_codigopuesto = dw_requerimiento.getCodigopuesto();

		String[] linCat;
		linCat = this.getFacRrhh().getHr().getHrprocDatawindow().obtenerCategoriaFuncional(ll_codigopuesto);
		ls_familia = linCat[1];
		LOGGER.debug("ls_familia " + ls_familia);

		dwc_linea = this.getFacRrhh().getHr().getHrprocDatawindow().DddWMaHrGradoSalairalMastSelect(null);
		dwc_linea_2 = this.getFacAsistencia().getAS().getSymastDatawindow().DwMaMiscelaneosdetalleSelect("HR",
				"CARGLINEAC", "999999");

		w_codigounidad = dw_requerimiento.getCodigoposicionsolicitante();

		dwc_unidad = getFacRrhh().getHrOrganigramaServicio().sp_hr_posicionempresa_hijosall(w_codigounidad,
				dw_requerimiento.getTipoplanilla());

		ls_Motivo = dw_requerimiento.getMotivo();
		DtoDwMaMiscelaneosdetalleSelect find = null;
		for (DtoDwMaMiscelaneosdetalleSelect m : dwc_motivo) {
			if (m.getCodigoelemento().equals(ls_Motivo)) {
				find = m;
				break;
			}
		}

		if (!UValidador.esNulo(find)) {
			if (find.getValornumerico().compareTo(BigDecimal.ONE) == 0) {
				opciones.setIshabilitartabreqadicionales(true);
			} else {
				opciones.setIshabilitartabreqadicionales(false);
			}
		}

		HrRequerimientoobservacionPk pkfindad = new HrRequerimientoobservacionPk();
		pkfindad.setCompanyowner((String) ivKeyRequerimiento.get("companyowner"));
		pkfindad.setRequerimiento((String) ivKeyRequerimiento.get("requerimiento"));

		dw_adicionales = (HrRequerimientoobservacion) getFacRrhh().getHrRequerimientoobservacionServicio()
				.obtenerPorId(pkfindad);

		dw_reqadicional = getFacRrhh().getHrRequerimientoreemplazoServicio().listarReuqerimientoReemplazo(
				(String) ivKeyRequerimiento.get("companyowner"), (String) ivKeyRequerimiento.get("requerimiento"));
		cargarSaldoReqAdicionales();

		dw_reqadicional = cargarDatosReqAdicional(dw_reqadicional);

		dw_reqadicionallist = new PwHrRequerimientoreemplazo(dw_reqadicional);

		BigDecimal ll_codigopuesto_eval;
		ll_codigopuesto_eval = getFacCore().getEmpleadomastServicio()
				.obtenerCodigoCargo(getUsuarioActual().getIdPersona());

		if (UValidador.esNulo(ll_codigopuesto_eval))
			ll_codigopuesto_eval = BigDecimal.ZERO;

		Boolean issisadm = getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm("HR",
				getUsuarioActual().getLoginUsuario().toUpperCase());

		switch ((String) ivKeyRequerimiento.get("Action")) {
		case ConstanteRrhh.ACCION_VER:
			if (!issisadm) {
				opciones.setIshabilitarcbver1(true);
				opciones.setIshabilitarcbver2(true);
				ib_filtrar = false;
			}
			break;
		}

		iv_estado = dw_requerimiento.getEstado();

		opciones.setIshabilitarcompania(false);

		dw_reqseguimientolist = getFacRrhh().getHrRequerimientoServicio()
				.listarSeguimiento(dw_requerimiento.getRequerimiento());

		switch ((String) ivKeyRequerimiento.get("Action")) {
		case ConstanteRrhh.ACCION_VER:
		case ConstanteRrhh.ACCION_APROBAR:
		case ConstanteRrhh.ACCION_APROBAROAD:
		case ConstanteRrhh.ACCION_RECHAZAR:
		case ConstanteRrhh.ACCION_TERMINAR:
		case ConstanteRrhh.ACCION_CONTRATAR:
		case ConstanteRrhh.ACCION_REVISAR:
			// dw_requerimiento.enabled = false
			opciones.setIshabilitarbpuesto(false);
			opciones.setIshabilitarbempsolicitante(false);
			opciones.setIshabilitarbcodigojefe(false);

			opciones.setIshabilitardwfuncionescas(false);
			opciones.setIshabilitardwfuncionescasdet(false);
			opciones.setIshabilitarcbagregarfuncas(false);
			opciones.setIshabilitarcbeliminarfuncas(false);
			opciones.setIshabilitarcbagregarfuncasdet(false);
			opciones.setIshabilitarcbeliminarfuncasdet(false);
			opciones.setIshabilitarcbescoger(false);
			opciones.setIshabilitarcbcopiar(false);

			opciones.setIsmostrarcbagregarfuncas(false);
			opciones.setIsmostrarcbeditarfuncas(false);
			opciones.setIsmostrarcbeliminarfuncas(false);
			opciones.setIsmostrarcbagregarfuncasdet(false);
			opciones.setIsmostrarcbeliminarfuncasdet(false);
			opciones.setIsmostrarcbescoger(false);

			opciones.setIshabilitardwrequerimiento(false);
			opciones.setIshabilitarempleadoresponsable(false);
			opciones.setIshabilitartiporeclutamiento(false);

			opciones.setIshabilitardwfuncionesprac(false);

			break;
		case ConstanteRrhh.ACCION_MODIFICAR:
			opciones.setIshabilitardwfuncionesprac(true);
			break;
		}

		if (iv_estado.equals("PR") || iv_estado.equals("RE") || iv_estado.equals("RV")) {
		}

		if ((iv_estado.equals("EV") || iv_estado.equals("AP"))
				&& ((String) ivKeyRequerimiento.get("Action")).equals("MODIFICAR")) {

			opciones.setIshabilitarremuneracionreferencialbruto(true);
			opciones.setIshabilitarremuneracionreferencialneto(true);
			opciones.setIshabilitarcorreoelectronico(true);
			opciones.setIshabilitarflagtarjetapersonal(true);
			opciones.setIshabilitargrupocorreoelectronico(true);
			opciones.setIshabilitarflagaccesointernet(true);
			opciones.setIshabilitarperfiladicional(true);
		}

		opciones.setIshabilitardwadicionales(false);
		if (((String) ivKeyRequerimiento.get("Action")).equals("AGREGAR")) {
			opciones.setIshabilitardwadicionales(true);
		}

		MaMiscelaneosdetallePk pkfind = new MaMiscelaneosdetallePk();
		pkfind.setAplicacioncodigo("HR");
		pkfind.setCodigoelemento(dw_requerimiento.getCodigopuesto() + "");
		pkfind.setCodigotabla("PUESTOSCAS");
		pkfind.setCompania("999999");

		if (!UValidador.esNulo(getFacCore().getMaMiscelaneosdetalleServicio().obtenerPorId(pkfind))) {
			opciones.setIsmostrartabfuncionescas(true);
		}

		if (((String) ivKeyRequerimiento.get("Action")).equals(ConstanteRrhh.ACCION_AGREGAR)
				|| ((String) ivKeyRequerimiento.get("Action")).equals(ConstanteRrhh.ACCION_MODIFICAR)) {
			opciones.setIshabilitarbnivelservicio(true);
			if (iv_estado.equals("PR")) {
				opciones.setIshabilitardwfuncionescas(true);
				opciones.setIshabilitardwfuncionescasdet(true);
				opciones.setIshabilitardwfuncionesprac(true);
			} else {
				opciones.setIshabilitardwfuncionescas(false);
				opciones.setIshabilitardwfuncionescasdet(false);
			}
		} else {
			opciones.setIshabilitarbnivelservicio(false);
			opciones.setIshabilitardwfuncionescas(false);
			opciones.setIshabilitardwfuncionescasdet(false);
		}

		if (((String) ivKeyRequerimiento.get("Action")).equals(ConstanteRrhh.ACCION_MODIFICAR)) {
			if (iv_estado.equals("PR")) {
				opciones.setIshabilitartiporeclutamiento(false);
			}
		}

		wfValidaMotivo(dw_requerimiento.getMotivo());

		opciones.setIshabilitarnumerosolicitud(false);

		cargarrequiereprueba();

		opciones.setIshabilitarmesesprueba(true);
		if (iv_estado.equals("AP") && ((String) ivKeyRequerimiento.get("Action")).equals("MODIFICAR")) {
			opciones.setIshabilitarmesesprueba(false);
		}

		return 0;
	}

	private void cargarSaldoReqAdicionales() throws Exception {
		// TODO Auto-generated method stub
		if (!UValidador.esListaVacia(dw_reqadicional)) {
			for (HrRequerimientoreemplazo obj : dw_reqadicional) {
				obj.setAuxiliarsueldo(obtenerSueldoEmpleado(BigDecimal.valueOf(obj.getPk().getEmpleado())));
			}
		}

	}

	private List<HrRequerimientoreemplazo> cargarDatosReqAdicional(List<HrRequerimientoreemplazo> lista) {
		// TODO Auto-generated method stub

		if (!UValidador.esListaVacia(lista)) {

			for (HrRequerimientoreemplazo obj : lista) {
				// MOTIVO
				for (HrMotivocese obj1 : lstMotivoCese) {
					if (obj1.getPk().getMotivo().equals(obj.getMotivocese())) {
						obj.setAuxiliarmotivo(obj1.getDescripcion());
					}
				}

				// PUESTO
				for (HrPuestoempresa obj2 : lstHrPuestoEmpresa) {
					if (obj2.getPk().getCodigopuesto().equals(obj.getCodigopuesto())) {
						obj.setAuxiliarpuesto(obj2.getDescripcion());
					}
				}

				// EMPLEADO
				PersonamastPk pk = new PersonamastPk();
				pk.setPersona(obj.getPk().getEmpleado());

				Personamast objfind = (Personamast) getFacCore().getPersonamastServicio().obtenerPorId(pk);

				obj.setAuxiliarempleado(objfind.getNombrecompleto());
			}
		}

		return lista;
	}

	private void wfSetTipocontrato(String tipocontrato) {

		HrTipocontratoPk pkfind = new HrTipocontratoPk();
		pkfind.setTipocontrato(tipocontrato);
		HrTipocontrato objfind = (HrTipocontrato) getFacRrhh().getHrTipocontratoServicio().obtenerPorId(pkfind);

		if (UValidador.esNulo(objfind)) {
			setMessageError("No se han definido tipos de contrato");
			return;
		}

		opciones.setIshabilitarfechadesde(true);

		if (objfind.getFlagfechavencimiento().equals(ConstanteRrhh.TIPO_SI)) {
			opciones.setIshabilitarfechahasta(true);
		} else {
			opciones.setIshabilitarfechahasta(false);
			dw_requerimiento.setFechahasta(null);
		}

	}

	@SuppressWarnings("unchecked")
	private void wfSetupNew() throws SQLException {
		dw_requerimiento.setFechasolicitud(new Date());
		dw_requerimiento.setEstado("PR");
		dw_requerimiento.setCompanyowner(getUsuarioActual().getCompaniaSocioCodigo());
		dw_requerimiento.setTipoplanilla("EC");
		dw_requerimiento.setTipocontrato("07");
		dw_requerimiento.setMotivo("1");
		wfValidaMotivo("1");
		dw_requerimiento.setNumerosolicitado(BigDecimal.ONE);
		dw_requerimiento.setNumeropendiente(BigDecimal.ONE);

		opciones.setIshabilitarfechadesde(true);
		opciones.setIshabilitarfechahasta(true);
		opciones.setIshabilitarrutadocumento(true);
		opciones.setIsmostrarver(false);

		dw_adicionales.getPk().setCompanyowner(getUsuarioActual().getCompaniaSocioCodigo());
		dw_adicionales.setAdjuntainformes(ConstanteRrhh.TIPO_NO);
		dw_adicionales.setAdjuntadocpersonales(ConstanteRrhh.TIPO_NO);

		if (ivKeyRequerimiento.get("Action").equals(ConstanteRrhh.ACCION_AGREGAR)) {
			opciones.setIsmostrartiporeclutamiento(false);
		}

		cargarrequiereprueba();

		// Colocar datos del solicitante
		BigDecimal empleado, posicion;
		String w_centrocostos;
		Object[] dSol = this.getFacRrhh().getHr().getHrprocDatawindow()
				.obtenerDatosSolicitante(getUsuarioActual().getLoginUsuario().toUpperCase());
		empleado = (BigDecimal) dSol[0];
		posicion = (BigDecimal) dSol[1];
		w_centrocostos = (String) dSol[2];

		if (UValidador.esNulo(w_centrocostos)) {
			w_centrocostos = getUsuarioActual().getCentroCostosCodigo();
		}

		dw_requerimiento.setEmpleadosolicitante(empleado);
		dw_requerimiento.setCodigoposicionsolicitante(posicion);
		dw_requerimiento.setCentrocosto(w_centrocostos);

		if (!UValidador.estaVacio(w_centrocostos)) {
			AcCostcentermstPk pkfind = new AcCostcentermstPk();
			pkfind.setCostcenter(w_centrocostos);

			AcCostcentermst objfind = (AcCostcentermst) getFacContabilidad().getAcCostcentermstServicio()
					.obtenerPorId(pkfind);

			if (!UValidador.esNulo(objfind)) {
				dw_requerimiento.setCentrocostonombre(objfind.getLocalname());
			}
		}

		BigDecimal ll_empleado;
		ll_empleado = this.getFacAsistencia().getAS().getHrcommonFuncion()
				.FGetEmpleadoXUsuario(getUsuarioActual().getLoginUsuario().toUpperCase());

		dw_requerimiento.setEmpleadosolicitante(ll_empleado);

		BigDecimal cargo, codigoUnidad;
		BigDecimal[] coCa;

		coCa = this.getFacRrhh().getHr().getHrprocDatawindow().obtenerCodigoUnidadCargo(ll_empleado);
		codigoUnidad = coCa[0];
		cargo = coCa[1];

		dw_requerimiento.setCodigoposicionsolicitante(codigoUnidad);
		dw_requerimiento.setCodigopuestosolicitante(cargo);

		dwc_unidad = getFacRrhh().getHrOrganigramaServicio().sp_hr_posicionempresa_hijosall(codigoUnidad,
				dw_requerimiento.getTipoplanilla());

		opciones.setIshabilitartabcandidatos(false);
		opciones.setIshabilitartabevaluaciones(false);
		opciones.setIshabilitartabcomparativo(false);
		opciones.setIshabilitartabreqadicionales(false);
		opciones.setIshabilitartabaprobacion(false);

		opciones.setIshabilitardwadicionales(false);
		opciones.setIshabilitarempleadoresponsable(false);
		opciones.setIshabilitarmesesprueba(true);

		wfValidaMotivo(dw_requerimiento.getMotivo());

	}

	private void wfValidaMotivo(String par_motivo) {
		DtoDwMaMiscelaneosdetalleSelect ll_find = null;

		LOGGER.debug("par_motivo " + par_motivo);

		for (DtoDwMaMiscelaneosdetalleSelect m : dwc_motivo) {
			if (m.getCodigoelemento().equals(par_motivo)) {
				ll_find = m;
				break;
			}
		}

		if (!UValidador.esNulo(ll_find)) {
			iv_motivo = ll_find.getValornumerico().intValue();
			LOGGER.debug("boolean 1 " + opciones.getIsmostrartabfuncionescas());

			opciones.setIshabilitartabreqadicionales(false);

			switch (iv_motivo) {
			case 1:
				// if
				// (ivKeyRequerimiento.get("Action").equals(ConstanteRrhh.ACCION_AGREGAR))
				// {
				getWebControlContext().actualizar("dgReemplazoInfo");
				getWebControlContext().ejecutar("PF('popReemplazoInfo').show();");
				// }

				opciones.setIshabilitartabreqadicionales(true);
				opciones.setIshabilitardesnuevocurso(false);

				break;

			case 2:
				opciones.setIshabilitardesnuevocurso(true);
				break;
			case 3:
				opciones.setIshabilitardesnuevocurso(true);
				opciones.setIshabilitartabfuncionescas(true);
				opciones.setIsmostrartabfuncionescas(true);

				break;
			default:
				opciones.setIshabilitardesnuevocurso(false);
				break;
			}
		}

		if (ivKeyRequerimiento.get("Action").equals(ConstanteRrhh.ACCION_VER)) {
			opciones.setIshabilitardwrequerimiento(false);
		}

	}

	private void wfValidaMotivoTab(String par_motivo) {
		DtoDwMaMiscelaneosdetalleSelect ll_find = null;

		LOGGER.debug("par_motivo " + par_motivo);

		for (DtoDwMaMiscelaneosdetalleSelect m : dwc_motivo) {
			if (m.getCodigoelemento().equals(par_motivo)) {
				ll_find = m;
				break;
			}
		}

		if (!UValidador.esNulo(ll_find)) {
			iv_motivo = ll_find.getValornumerico().intValue();
			LOGGER.debug("boolean 1 " + opciones.getIsmostrartabfuncionescas());
			opciones.setIshabilitartabreqadicionales(false);
			switch (iv_motivo) {
			case 1:
				opciones.setIshabilitartabreqadicionales(true);
				opciones.setIshabilitardesnuevocurso(false);
				break;

			case 2:
				opciones.setIshabilitardesnuevocurso(true);
				break;
			case 3:
				opciones.setIshabilitardesnuevocurso(true);
				opciones.setIshabilitartabfuncionescas(true);
				opciones.setIsmostrartabfuncionescas(true);

				break;
			default:
				opciones.setIshabilitardesnuevocurso(false);
				break;
			}
		}

		if (ivKeyRequerimiento.get("Action").equals(ConstanteRrhh.ACCION_VER)) {
			if (!tabArchivos.equals(4))
				opciones.setIshabilitardwrequerimiento(false);
		}

	}

	private void cargarObjetoSelector() {
		for (DtoDWHrTipoContratoSelect tc : dwc_tipocontrato) {
			if (tc.getTipocontrato().equals(dw_requerimiento.getTipocontrato())) {
				dw_requerimiento.setTipocontratoDto(tc);
				break;
			}
		}

		for (DtoDwMaMiscelaneosdetalleSelect ms : dwc_motivo) {
			if (ms.getCodigoelemento().equals(dw_requerimiento.getMotivo())) {
				dw_requerimiento.setMotivoDto(ms);
				break;
			}
		}

		for (DtoDwMaPrTipoplantillaSelect tp : dwc_tipoplanilla) {
			if (tp.getTipoplanilla().equals(dw_requerimiento.getTipoplanilla())) {
				dw_requerimiento.setTipoplanillaDto(tp);
				break;
			}
		}

		HrTipotrabajadorPk pkfind = new HrTipotrabajadorPk();
		pkfind.setTipotrabajador(dw_requerimiento.getTipotrabajador());

		HrTipotrabajador tipoTrabajador = (HrTipotrabajador) getFacRrhh().getHrTipotrabajadorServicio()
				.obtenerPorId(pkfind);

		if (!UValidador.esNulo(tipoTrabajador)) {
			if (tipoTrabajador.getEstado().equals(ConstanteRrhh.ACTIVIDAD_ESTADO_APROBADO)) {
				dw_requerimiento.setTipotrabajadornombre(tipoTrabajador.getDescripcionlocal());
			}
		}

		dw_requerimiento.setPersonanombrecompleto(this.getFacAsistencia().getAS().getSycommFuncion()
				.FSqlGetPersonaNombrecompleto(UValidador.esNulo(dw_requerimiento.getEmpleadosolicitante()) ? null
						: dw_requerimiento.getEmpleadosolicitante().intValue()));

		dw_requerimiento.setNombrepuestocomntario(this.getFacAsistencia().getAS().getHrcommonFuncion()
				.FSqlGetNombrePuestoComentario(UValidador.esNulo(dw_requerimiento.getCodigopuesto()) ? null
						: dw_requerimiento.getCodigopuesto().intValue()));

		dw_requerimiento.setPersonanombrecompletojefe(this.getFacAsistencia().getAS().getSycommFuncion()
				.FSqlGetPersonaNombrecompleto(UValidador.esNulo(dw_requerimiento.getCodigojefe()) ? null
						: dw_requerimiento.getCodigojefe().intValue()));

		dw_requerimiento.setNombrenivelservicio(this.getFacRrhh().getHr().getCommodityFuncion().FNombreNivelServicio(
				dw_requerimiento.getCompanyowner(), UValidador.esNulo(dw_requerimiento.getNivelservicio()) ? null
						: dw_requerimiento.getNivelservicio().intValue()));

		dw_requerimiento.setPagomaximo(this.getFacRrhh().getHr().getHrrepusFuncion()
				.FSqlGetMaximNivelsalarial(dw_requerimiento.getLineacarrera(), 1));

		dw_requerimiento.setPagominimo(this.getFacRrhh().getHr().getHrrepusFuncion()
				.FSqlGetMaximNivelsalarial(dw_requerimiento.getLineacarrera(), 2));

		obtenerCentroCostoNombre(dw_requerimiento.getCentrocosto());

	}

	@Override
	public String buscar() throws Exception {
		List<HrRequerimientoAdjunto> lstTemporal = new ArrayList<HrRequerimientoAdjunto>();

		for (int i = 0; i < lstArchivosAdjuntos.size(); i++) {
			HrRequerimientoAdjunto obj = lstArchivosAdjuntos.get(i);
			if (obj.getEliminado().equals(ConstanteRrhh.TIPO_NO)) {
				lstTemporal.add(obj);
			}
		}

		lstArchivosAdjuntos.clear();

		if (!UValidador.esListaVacia(lstTemporal)) {
			lstArchivosAdjuntos.addAll(lstTemporal);
		}

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

		if (!validar()) {
			return null;
		}

		dw_requerimiento.setUltimafechamodif(new Date());
		dw_requerimiento.setUltimousuario(getUsuarioActual().getLoginUsuario().toUpperCase());

		ivKeyRequerimiento.put("requerimiento", dw_requerimiento.getRequerimiento());
		ivKeyRequerimiento.put("companyowner", dw_requerimiento.getCompanyowner());

		dw_adicionales.getPk().setRequerimiento(dw_requerimiento.getRequerimiento());
		dw_adicionales.getPk().setCompanyowner(dw_requerimiento.getCompanyowner());

		if (((String) ivKeyRequerimiento.get("Action")).equals(ConstanteRrhh.ACCION_AGREGAR)) {
			for (DtoDwMaMiscelaneosdetalleSelect obj : dwc_motivo) {
				if (dw_requerimiento.getMotivo().equals(obj.getCodigoelemento())) {
					dw_requerimiento.setEstado("SG");
					break;
				}
			}
		}

		dwrequerimientoupdate();
		dwadicionalesupdate();
		dwreqadicionalesupdate();
		dwfuncionescasupdate();
		dwfuncionescasdetupdate();
		dwfuncionespracupdate();
		dwAdjuntos();

		// Enviar Correo
		// envioCorreo();

		if (((String) ivKeyRequerimiento.get("Action")).equals(ConstanteRrhh.ACCION_AGREGAR)
				|| ((String) ivKeyRequerimiento.get("Action")).equals(ConstanteRrhh.ACCION_MODIFICAR)) {

			wfActualizaBlob((String) ivKeyRequerimiento.get("requerimiento"),
					(String) ivKeyRequerimiento.get("companyowner"));
		}

		destinatariosEnvioCorreo = "El correo se envío con éxito a: " + destinatariosEnvioCorreo;
		if (UValidador.estaVacio(destinatariosEnvioCorreo)) {
			destinatariosEnvioCorreo = "No se envío el Correo";
		}

		String retorno = "whrrequerimientolist";
		String accion = "modificó";
		if (((String) ivKeyRequerimiento.get("Action")).equals(ConstanteRrhh.ACCION_AGREGAR)) {

			getWebControlContext().actualizar("dgEnvioCorreoEstado");
			// getWebControlContext().ejecutar("PF('popEnvioCorreoEstado').show()");
			accion = "registró";
			// retorno = null;
		}

		setMessageSuccess(
				"Se " + accion + " el requerimiento " + dw_requerimiento.getRequerimiento() + " correctamente.", true);

		CwHrRequerimientoList.getInstance().buscar();
		mostarReporte();

		return retorno;
	}

	public String enviar() throws Exception {

		if (!validar()) {
			return null;
		}

		accionEnvio = true;

		dw_requerimiento.setUltimafechamodif(new Date());
		dw_requerimiento.setUltimousuario(getUsuarioActual().getLoginUsuario().toUpperCase());
		dw_requerimiento.setFlagEnviado("S");

		ivKeyRequerimiento.put("requerimiento", dw_requerimiento.getRequerimiento());
		ivKeyRequerimiento.put("companyowner", dw_requerimiento.getCompanyowner());

		dw_adicionales.getPk().setRequerimiento(dw_requerimiento.getRequerimiento());
		dw_adicionales.getPk().setCompanyowner(dw_requerimiento.getCompanyowner());

		if (((String) ivKeyRequerimiento.get("Action")).equals(ConstanteRrhh.ACCION_AGREGAR)) {
			for (DtoDwMaMiscelaneosdetalleSelect obj : dwc_motivo) {
				if (dw_requerimiento.getMotivo().equals(obj.getCodigoelemento())) {
					dw_requerimiento.setEstado("PR");
					break;
				}
			}
		}

		dwrequerimientoupdate();
		dwadicionalesupdate();
		dwreqadicionalesupdate();
		dwfuncionescasupdate();
		dwfuncionescasdetupdate();
		dwfuncionespracupdate();
		dwAdjuntos();

		// Enviar Correo
		// envioCorreo();
		// enviar
		if (mostrarEnviar) {
			getFacRrhh().getHrRequerimientoServicio()
					.registrarDocAprobacion(getUsuarioActual().getLoginUsuario().toUpperCase(), dw_requerimiento);
		}

		if (((String) ivKeyRequerimiento.get("Action")).equals(ConstanteRrhh.ACCION_AGREGAR)
				|| ((String) ivKeyRequerimiento.get("Action")).equals(ConstanteRrhh.ACCION_MODIFICAR)) {

			wfActualizaBlob((String) ivKeyRequerimiento.get("requerimiento"),
					(String) ivKeyRequerimiento.get("companyowner"));
		}

		if (mostrarEnviar) {
			envioCorreoEnvio();
		}

		destinatariosEnvioCorreo = "El correo se envío con éxito a: " + destinatariosEnvioCorreo;
		if (UValidador.estaVacio(destinatariosEnvioCorreo)) {
			destinatariosEnvioCorreo = "No se envío el Correo";
		}

		String retorno = "whrrequerimientolist";
		String accion = "modificó";
		if (((String) ivKeyRequerimiento.get("Action")).equals(ConstanteRrhh.ACCION_AGREGAR)) {

			getWebControlContext().actualizar("dgEnvioCorreoEstado");
			// getWebControlContext().ejecutar("PF('popEnvioCorreoEstado').show()");
			accion = "registró";
			// retorno = null;
		}
		// enviar
		if (mostrarEnviar) {
			accion = "envió";
		}

		setMessageSuccess(
				"Se " + accion + " el requerimiento " + dw_requerimiento.getRequerimiento() + " correctamente. ", true);

		CwHrRequerimientoList.getInstance().buscar();
		mostarReporte();

		return retorno;
	}

	public void dwAdjuntos() {
		if (UValidador.esNulo(requerimiento)) {
			requerimiento = dw_requerimiento.getRequerimiento();
			compania = dw_requerimiento.getCompanyowner();
		}

		getFacRrhh().getHrRequerimientoAdjuntoServicio().eliminarArchivosAdjuntos(requerimiento, compania);

		for (HrRequerimientoAdjunto obj : lstArchivosAdjuntos) {
			if (obj.getEliminado().equals(ConstanteRrhh.TIPO_NO)) {

				switch (obtenerParametroModoArchivo()) {
				case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

					if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
						this.setMessageError("No se encontraron los parametros key o ws");
						return;
					}

					if (UValidador.estaVacio(obj.getUuidalfresco())) {
						try {
							LOGGER.debug("Archivo a guardar " + obj.getRuta());
							RptaWsBean respuestaws = getuOsinergminAlfresco().registrarDocumento(obj.getRuta(),
									UOsinergminAlfresco.RUTA_REQUERIMIENTO + obj.getPk().getRequerimiento(),
									new File(obj.getRutaArchivo()));
							LOGGER.debug(respuestaws);
							if (respuestaws.getCodMsg().equalsIgnoreCase("ok")) {
								obj.setUuidalfresco(respuestaws.getUuid());
								UFile.borrarArchivoTemporal(obj.getRutaArchivo());
							} else {
								this.setMessageError(respuestaws.getCadMsg());
								return;
							}
						} catch (Exception e) {
							this.setMessageError(e.getMessage());
							return;
						}
					}
				}

				obj.getPk().setRequerimiento(requerimiento);
				obj.getPk().setCompanyowner(compania);
				getFacRrhh().getHrRequerimientoAdjuntoServicio().registrar(obj);

			}
		}

	}

	public String verPuesto() throws Exception {

		if (UValidador.esNulo(dw_requerimiento.getCodigopuesto())) {
			dw_requerimiento.setCodigopuesto(BigDecimal.ZERO);
		}

		if (UValidador.esCero(dw_requerimiento.getCodigopuesto().intValue())) {
			setMessageError("Seleccione el Puesto del Solicitante");
			return null;
		}

		CwHrPuestosEdit.getInstance().setPantallaReferencia("hr_requerimiento_edit");
		CwHrPuestosEdit.getInstance().setCodigopuesto(dw_requerimiento.getCodigopuesto().intValue());
		CwHrPuestosEdit.getInstance().iniciarControladora();

		return "w_hr_puestos_edit";
	}

	private void envioCorreo() throws Exception {
		String w_nombresolicitante, w_nombrecargo = "", w_area, w_tipocontrato, w_sucursal;
		Date w_FechaHasta, w_FechaDesde;
		String w_motivo, w_mensaje;
		destinatariosEnvioCorreo = "";
		String asunto = "", titulo = "", texto = "";

		if (((String) ivKeyRequerimiento.get("Action")).equals(ConstanteRrhh.ACCION_AGREGAR)
				|| ((String) ivKeyRequerimiento.get("Action")).equals(ConstanteRrhh.ACCION_REVISAR)) {

			if (((String) ivKeyRequerimiento.get("Action")).equals(ConstanteRrhh.ACCION_AGREGAR)) {
				asunto = "SIA - Nuevo Requerimiento de Personal";
				titulo = "SIA - Nuevo Requerimiento de Personal";
				texto = "Se ha creado el siguiente Requerimiento de Personal";
			} else if (((String) ivKeyRequerimiento.get("Action")).equals(ConstanteRrhh.ACCION_REVISAR)) {
				asunto = "SIA - Revisión de Requerimiento de Personal";
				titulo = "SIA - Revisión de Requerimiento de Personal";
				texto = "Se ha revisado el siguiente Requerimiento de Personal";
			}

			// PERSONA
			PersonamastPk pkfind = new PersonamastPk();
			pkfind.setPersona(dw_requerimiento.getEmpleadosolicitante().intValue());

			Personamast objfind = (Personamast) getFacCore().getPersonamastServicio().obtenerPorId(pkfind);

			w_nombresolicitante = objfind.getNombrecompleto();
			//

			// PUESTO EMPRESA
			HrPuestoempresaPk pkfind2 = new HrPuestoempresaPk();
			pkfind2.setCodigopuesto(UValidador.esNulo(dw_requerimiento.getCodigopuesto()) ? null
					: dw_requerimiento.getCodigopuesto().intValue());

			HrPuestoempresa objfind2 = (HrPuestoempresa) getFacRrhh().getHrPuestoempresaServicio()
					.obtenerPorId(pkfind2);

			if (!UValidador.esNulo(objfind2)) {
				w_nombrecargo = objfind2.getDescripcion();
			}
			//

			// POSICION EMPRESA
			if (UValidador.esCero(dw_requerimiento.getCodigoposicionsolicitante().compareTo(BigDecimal.valueOf(-1)))) {
				w_area = "ORGCHART TOP";
			} else {
				HrPosicionempresaPk pkfind3 = new HrPosicionempresaPk();
				pkfind3.setCompanyowner(dw_requerimiento.getCompanyowner());
				pkfind3.setCodigoposicion(dw_requerimiento.getCodigoposicionsolicitante().intValue());

				HrPosicionempresa objfind3 = (HrPosicionempresa) getFacRrhh().getHrPosicionempresaServicio()
						.obtenerPorId(pkfind3);

				w_area = objfind3.getDescripcion();
			}

			if (UValidador.esNulo(w_area)) {
				w_area = "";
			}
			//

			// FECHA VIGENCIA
			w_FechaDesde = dw_adicionales.getIniciovigencia();
			w_FechaHasta = dw_adicionales.getFinvigencia();
			//

			// Sucursal
			w_sucursal = this.getFacContabilidad().getAcSucursalServicio()
					.obtenerNombreSucursal(dw_requerimiento.getSucursal());

			// TIPO CONTRATO
			HrTipocontratoPk pkfind4 = new HrTipocontratoPk();
			pkfind4.setTipocontrato(dw_requerimiento.getTipocontrato());

			HrTipocontrato objfind4 = (HrTipocontrato) getFacRrhh().getHrTipocontratoServicio().obtenerPorId(pkfind4);

			w_tipocontrato = objfind4.getDescripcion();

			HashMap<String, Object> flujonuevo = getFacRrhh().getHrCorreoflujoServicio().flujoProcesoCorreoNuevo(1, 1,
					dw_requerimiento.getEmpleadosolicitante().intValue(), ConstanteRrhh.TIPO_NO,
					dw_requerimiento.getMotivo(), dw_requerimiento.getEmpleadosolicitante().intValue(),
					getUsuarioActual().getCompaniaSocioCodigo());

			w_motivo = getFacCore().getMaMiscelaneosdetalleServicio().obtenerDescripcionMiscelaneosXParam("999999",
					"HR", "MOTIVOREQ", dw_requerimiento.getMotivo());

			if (!UValidador.estaVacio(dw_requerimiento.getDesnuevocurso())) {
				w_motivo = w_motivo.trim() + "-" + dw_requerimiento.getDesnuevocurso().trim();
			}

			if (!(Boolean) flujonuevo.get("registrado")) {
				setMessageWarn(
						"Usuario no registrado en el flujo de correos. (Proceso = Selección, Acción = Solicitud, Usuario = "
								+ getUsuarioActual().getLoginUsuario().toUpperCase() + ", Motivo = " + w_motivo + ")");
				return;
			}

			String vigencia1 = UFechaHora.convertirFechaCadena(w_FechaDesde, "dd/MM/yyyy");
			String vigencia2 = UFechaHora.convertirFechaCadena(w_FechaHasta, "dd/MM/yyyy");

			String rutaCompleta = null;

			rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//requerimiento_personal.html");
			LOGGER.debug(rutaCompleta);
			w_mensaje = UFile.obtenerContenidoFile(rutaCompleta);
			LOGGER.debug(w_mensaje);
			w_mensaje = w_mensaje.replace("[REQUE]", dw_requerimiento.getRequerimiento());
			w_mensaje = w_mensaje.replace("[SOLICITA]", UString.cambiarCaracteresEspecialesHTML(w_nombresolicitante));
			w_mensaje = w_mensaje.replace("[FECHA]",
					UFechaHora.convertirFechaCadena(dw_requerimiento.getFechasolicitud(), "dd/MM/yyyy"));
			w_mensaje = w_mensaje.replace("[VIGENCIA1]", UValidador.esNulo(vigencia1) ? "" : vigencia1);
			w_mensaje = w_mensaje.replace("[VIGENCIA2]", UValidador.esNulo(vigencia2) ? "" : vigencia2);
			w_mensaje = w_mensaje.replace("[PUESTO]", UString.cambiarCaracteresEspecialesHTML(w_nombrecargo));
			w_mensaje = w_mensaje.replace("[AREA]",
					UValidador.esNulo(w_area) ? "" : UString.cambiarCaracteresEspecialesHTML(w_area));
			w_mensaje = w_mensaje.replace("[TIPO]",
					UValidador.esNulo(w_tipocontrato) ? "" : UString.cambiarCaracteresEspecialesHTML(w_tipocontrato));
			w_mensaje = w_mensaje.replace("[MOTIVO]",
					UValidador.esNulo(w_motivo) ? "" : UString.cambiarCaracteresEspecialesHTML(w_motivo));
			w_mensaje = w_mensaje.replace("[SUCURSAL]",
					(UValidador.esNulo(w_sucursal) ? "" : UString.cambiarCaracteresEspecialesHTML(w_sucursal)));
			w_mensaje = w_mensaje.replace("[TITULO]", titulo);
			w_mensaje = w_mensaje.replace("[TEXTO]", texto);

			// CORREO REMITENTE
			Empleadomast remitente = getFacCore().getEmpleadomastServicio()
					.obtenerPorCodigoUsuario(getUsuarioActual().getLoginUsuario().toUpperCase());

			String ls_remitente = remitente.getCorreointerno();

			if ((boolean) flujonuevo.get("registrado")) {
				// ENVIAMOS EL CORREO
				Boolean isconfiguradocorreo = getFacSeguridad().getCorreoServicio().configurarCorreo();

				if (!isconfiguradocorreo) {
					setMessageError("No se ha configurado el Perfil del Correo. Consulte al Administrador");
					return;
				}

				// Configuramos el objetos de correo
				CorreoCore correo = new CorreoCore();
				correo.setAsunto(asunto);
				correo.setCuerpoCorreo(w_mensaje.getBytes());

				String destinos = (String) flujonuevo.get("destinatario");
				destinatariosEnvioCorreo = destinatariosEnvioCorreo + destinos;
				if (!UValidador.estaVacio(destinos)) {
					List<String> lstDestinos = new ArrayList<String>(Arrays.asList(destinos.split(";")));
					List<CorreoDestinoCore> lstCorreoDestino = new ArrayList<>();
					for (String destino : lstDestinos) {
						CorreoDestinoCore obj = new CorreoDestinoCore();
						obj.setCorreoDestino(destino);
						obj.setDestino(tipo_destino.TO);
						lstCorreoDestino.add(obj);
					}

					// Agregamos la cc como destino
					if (!UValidador.estaVacio((String) flujonuevo.get("copia"))) {
						CorreoDestinoCore obj = new CorreoDestinoCore();
						obj.setCorreoDestino((String) flujonuevo.get("copia"));
						obj.setDestino(tipo_destino.CC);
						lstCorreoDestino.add(obj);
					}

					correo.setListaCorreoDestino(lstCorreoDestino);
					correo.setRemitente(ls_remitente);

					// ADJUNTO
					if (!UValidador.esNulo(dw_requerimiento.getDocumento())) {
						CorreoAdjuntoCore correoadjunto = new CorreoAdjuntoCore();
						correoadjunto.setNombreArchivo(dw_requerimiento.getRutasustento());
						correoadjunto.setArchivoAdjunto(dw_requerimiento.getDocumento());

						correo.getListaCorreoAdjunto().add(correoadjunto);

					}

					getFacSeguridad().getCorreoServicio().enviarCorreo(correo);

				}

			}
		}

	}

	private void envioCorreoEnvio() throws Exception {
		String w_nombresolicitante, w_nombrecargo = "", w_area;
		String w_mensaje;
		destinatariosEnvioCorreo = "";
		String asunto = "", titulo = "", texto = "";

		asunto = "SIA - Envío de Requerimiento de Personal";
		titulo = "SIA - Envío de Requerimiento de Personal";
		texto = "Se ha enviado el Requerimiento de Personal " + dw_requerimiento.getRequerimiento() + ": ";

		// obtenemos los usuarios
		List<UsuarioActual> lstUsuarios = getFacRrhh().getHrRequerimientoServicio().obtenerUsuariosEnvio();
		if (UValidador.esListaVacia(lstUsuarios)) {
			return;
		}

		// PERSONA
		PersonamastPk pkfind = new PersonamastPk();
		pkfind.setPersona(dw_requerimiento.getEmpleadosolicitante().intValue());

		Personamast objfind = (Personamast) getFacCore().getPersonamastServicio().obtenerPorId(pkfind);

		w_nombresolicitante = objfind.getNombrecompleto();
		//

		// PUESTO EMPRESA
		HrPuestoempresaPk pkfind2 = new HrPuestoempresaPk();
		pkfind2.setCodigopuesto(UValidador.esNulo(dw_requerimiento.getCodigopuesto()) ? null
				: dw_requerimiento.getCodigopuesto().intValue());

		HrPuestoempresa objfind2 = (HrPuestoempresa) getFacRrhh().getHrPuestoempresaServicio().obtenerPorId(pkfind2);

		if (!UValidador.esNulo(objfind2)) {
			w_nombrecargo = objfind2.getDescripcion();
			if (!UValidador.estaVacio(dw_requerimiento.getDescripcionpuestoinformativo())) {
				w_nombrecargo = w_nombrecargo + " - " + dw_requerimiento.getDescripcionpuestoinformativo();
			}
		}
		//

		// POSICION EMPRESA
		if (UValidador.esCero(dw_requerimiento.getCodigoposicionsolicitante().compareTo(BigDecimal.valueOf(-1)))) {
			w_area = "ORGCHART TOP";
		} else {
			HrPosicionempresaPk pkfind3 = new HrPosicionempresaPk();
			pkfind3.setCompanyowner(dw_requerimiento.getCompanyowner());
			pkfind3.setCodigoposicion(dw_requerimiento.getCodigoposicionsolicitante().intValue());

			HrPosicionempresa objfind3 = (HrPosicionempresa) getFacRrhh().getHrPosicionempresaServicio()
					.obtenerPorId(pkfind3);

			w_area = objfind3.getDescripcion();
		}

		if (UValidador.esNulo(w_area)) {
			w_area = "";
		}
		//

		String rutaCompleta = null;

		rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//requerimiento_personal_envio.html");
		LOGGER.debug(rutaCompleta);
		w_mensaje = UFile.obtenerContenidoFile(rutaCompleta);
		LOGGER.debug(w_mensaje);
		w_mensaje = w_mensaje.replace("[SOLICITA]", UString.cambiarCaracteresEspecialesHTML(w_nombresolicitante));
		w_mensaje = w_mensaje.replace("[FECHA]",
				UFechaHora.convertirFechaCadena(dw_requerimiento.getFechasolicitud(), "dd/MM/yyyy"));
		w_mensaje = w_mensaje.replace("[PUESTO]", UString.cambiarCaracteresEspecialesHTML(w_nombrecargo));
		w_mensaje = w_mensaje.replace("[AREA]",
				UValidador.esNulo(w_area) ? "" : UString.cambiarCaracteresEspecialesHTML(w_area));
		w_mensaje = w_mensaje.replace("[TITULO]", titulo);
		w_mensaje = w_mensaje.replace("[TEXTO]", texto);

		// CORREO REMITENTE
		Empleadomast remitente = getFacCore().getEmpleadomastServicio()
				.obtenerPorCodigoUsuario(getUsuarioActual().getLoginUsuario().toUpperCase());

		String ls_remitente = remitente.getCorreointerno();

		// ENVIAMOS EL CORREO
		Boolean isconfiguradocorreo = getFacSeguridad().getCorreoServicio().configurarCorreo();

		if (!isconfiguradocorreo) {
			setMessageError("No se ha configurado el Perfil del Correo. Consulte al Administrador");
			return;
		}

		// Configuramos el objetos de correo
		CorreoCore correo = new CorreoCore();
		correo.setAsunto(asunto);
		correo.setCuerpoCorreo(w_mensaje.getBytes());

		String destinos = "";
		if (!UValidador.esListaVacia(lstUsuarios)) {
			for (UsuarioActual obj : lstUsuarios) {
				destinos = destinos + obj.getCorreoInterno() + ";";
			}
		}

		destinatariosEnvioCorreo = destinatariosEnvioCorreo + destinos;
		if (!UValidador.estaVacio(destinos)) {
			List<String> lstDestinos = new ArrayList<String>(Arrays.asList(destinos.split(";")));
			List<CorreoDestinoCore> lstCorreoDestino = new ArrayList<>();
			for (String destino : lstDestinos) {
				CorreoDestinoCore obj = new CorreoDestinoCore();
				obj.setCorreoDestino(destino);
				obj.setDestino(tipo_destino.TO);
				lstCorreoDestino.add(obj);
			}

			correo.setListaCorreoDestino(lstCorreoDestino);
			correo.setRemitente(ls_remitente);

			// ADJUNTO
			if (!UValidador.esNulo(dw_requerimiento.getDocumento())) {
				CorreoAdjuntoCore correoadjunto = new CorreoAdjuntoCore();
				correoadjunto.setNombreArchivo(dw_requerimiento.getRutasustento());
				correoadjunto.setArchivoAdjunto(dw_requerimiento.getDocumento());

				correo.getListaCorreoAdjunto().add(correoadjunto);

			}

			getFacSeguridad().getCorreoServicio().enviarCorreo(correo);

		}

	}

	public String actualizarArchivo() throws Exception {
		wfActualizaBlob(dw_requerimiento.getRequerimiento(), dw_requerimiento.getCompanyowner());
		setMessageSuccess("Se actualizó el documento del requerimiento " + dw_requerimiento.getRequerimiento()
				+ " correctamente.", true);

		CwHrRequerimientoList.getInstance().buscar();
		return "whrrequerimientolist";
	}

	private void wfActualizaBlob(String requerimiento, String compania) {

		if (UValidador.esNulo(dw_requerimiento.getDocumento())) {
			return;
		}

		HrRequerimientoPk pk = new HrRequerimientoPk();
		pk.setCompanyowner(compania);
		pk.setRequerimiento(requerimiento);

		HrRequerimiento registro = (HrRequerimiento) getFacRrhh().getHrRequerimientoServicio().obtenerPorId(pk);
		registro.setRutasustento(dw_requerimiento.getRutasustento());
		registro.setRuta(dw_requerimiento.getRuta());

		if (!UValidador.esNulo(registro)) {
			registro.setSustento(dw_requerimiento.getDocumento());
			switch (obtenerParametroModoArchivo()) {
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

				if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
					this.setMessageError("No se encontraron los parametros key o ws");
					return;
				}

				// if (!UValidador.estaVacio(registro.getUuidalfresco())) {
				// try {
				// ContenidoECMBean respuestaconsulta =
				// UOefaAlfresco.obtenerDocumento(registro.getUuidalfresco(),
				// key);
				// LOGGER.debug(respuestaconsulta);
				// if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
				// LOGGER.debug("Se encontro el archivo");
				// UOefaAlfresco.eliminarDocumento(registro.getUuidalfresco(),
				// key);
				// LOGGER.debug("Se elimino el archivo");
				// }
				// } catch (Exception e) {
				// LOGGER.debug(e.getMessage());
				// this.setMessageError(
				// "Ocurrio un error al comunicarse con el ws\n no se pudo
				// guardar el archivo");
				// return;
				// }
				// }
				if (!UValidador.estaVacio(registro.getRutasustento()) && !UValidador.esNulo(registro.getSustento())) {
					try {
						LOGGER.debug("Archivo a guardar " + registro.getRutasustento());
						RptaWsBean respuestaws = getuOsinergminAlfresco().registrarDocumento(
								registro.getRutasustento(), UOsinergminAlfresco.RUTA_REQUERIMIENTO
										+ registro.getPk().getRequerimiento() + "/" + "SUSTENTO",
								new File(registro.getRuta()));
						LOGGER.debug(respuestaws);
						System.gc();
						if (respuestaws.getCodMsg().equalsIgnoreCase("ok")) {
							registro.setSustento(null);
							registro.setUuidalfresco(respuestaws.getUuid());
						} else {
							this.setMessageError(respuestaws.getCadMsg());
							return;
						}
					} catch (Exception e) {
						this.setMessageError(e.getMessage());
						return;
					}
				}

			}

			getFacRrhh().getHrRequerimientoServicio().actualizar(registro);

		}
	}

	public void dwrequerimientoupdate() {

		HrRequerimiento objins = new HrRequerimiento();
		objins.getPk().setCompanyowner(dw_requerimiento.getCompanyowner());
		objins.getPk().setRequerimiento(dw_requerimiento.getRequerimiento());

		objins.setEmpleadosolicitante(dw_requerimiento.getEmpleadosolicitante().intValue());
		objins.setCodigoposicionsolicitante(UValidador.esNulo(dw_requerimiento.getCodigoposicionsolicitante()) ? null
				: dw_requerimiento.getCodigoposicionsolicitante().intValue());
		objins.setCodigopuesto(UValidador.esNulo(dw_requerimiento.getCodigopuesto()) ? null
				: dw_requerimiento.getCodigopuesto().intValue());
		objins.setFechasolicitud(dw_requerimiento.getFechasolicitud());
		objins.setMotivo(dw_requerimiento.getMotivo());
		objins.setTipocontrato(dw_requerimiento.getTipocontrato());
		objins.setFechadesde(dw_requerimiento.getFechadesde());
		objins.setFechahasta(dw_requerimiento.getFechahasta());
		objins.setPerfiladicional(dw_requerimiento.getPerfiladicional());
		objins.setUnidadnegocio(dw_requerimiento.getUnidadnegocio());
		objins.setNumerosolicitado(dw_requerimiento.getNumerosolicitado().intValue());
		objins.setNumeropendiente(dw_requerimiento.getNumeropendiente().intValue());
		objins.setEstado(dw_requerimiento.getEstado());
		objins.setUltimoUsuario(getUsuarioActual().getLoginUsuario().toUpperCase());
		objins.setUltimaFechaModif(new Date());
		objins.setRequerimientonumero(dw_requerimiento.getRequerimientonumero());
		objins.setUnidadreplicacion(dw_requerimiento.getUnidadreplicacion());
		objins.setClasificacion(dw_requerimiento.getClasificacion());
		objins.setTiporequermiento(dw_requerimiento.getTiporequerimiento());
		objins.setCentrocosto(dw_requerimiento.getCentrocosto());
		objins.setFechafinrequerimiento(dw_requerimiento.getFechafinrequerimiento());
		objins.setAfe(dw_requerimiento.getAfe());
		objins.setRemuneracionreferencialbruto(dw_requerimiento.getRemuneracionreferencialbruto());
		objins.setRemuneracionreferencialneto(dw_requerimiento.getRemuneracionreferencialneto());
		objins.setCorreoelectronico(dw_requerimiento.getCorreoelectronico());
		objins.setFlagtarjetapersonal(dw_requerimiento.getFlagtarjetapersonal());
		objins.setGrupocorreoelectronico(dw_requerimiento.getGrupocorreoelectronico());
		objins.setFlagaccesointernet(dw_requerimiento.getFlagaccesointernet());
		objins.setDisphorariodia(dw_requerimiento.getDisphorariodia());
		objins.setDisphorariohoraflag(dw_requerimiento.getDisphorariohoraflag());
		objins.setDisphorariohora(dw_requerimiento.getDisphorariohora());
		objins.setDispviajetipo(dw_requerimiento.getDispviajetipo());
		objins.setDispviajelugarflag(dw_requerimiento.getDispviajelugarflag());
		objins.setDispviajelugar(dw_requerimiento.getDispviajelugar());
		objins.setTipotrabajador(dw_requerimiento.getTipotrabajador());
		objins.setTipoplanilla(dw_requerimiento.getTipoplanilla());
		objins.setTipohorario(dw_requerimiento.getTipohorario().intValue());
		objins.setDeptoorganizacion(dw_requerimiento.getDeptoorganizacion());
		objins.setCategoria(dw_requerimiento.getCategoria());
		objins.setAccesoCorreo(dw_requerimiento.getIsaccesocorreo() ? ConstanteRrhh.TIPO_SI : ConstanteRrhh.TIPO_NO);
		objins.setAccesoInternet(
				dw_requerimiento.getIsaccesointernet() ? ConstanteRrhh.TIPO_SI : ConstanteRrhh.TIPO_NO);
		objins.setAccesoSii(dw_requerimiento.getIsaccesosii() ? ConstanteRrhh.TIPO_SI : ConstanteRrhh.TIPO_NO);
		objins.setAccesoOtros(dw_requerimiento.getIsaccesootros() ? ConstanteRrhh.TIPO_SI : ConstanteRrhh.TIPO_NO);
		objins.setAccesoTelefono(
				dw_requerimiento.getIsaccesotelefono() ? ConstanteRrhh.TIPO_SI : ConstanteRrhh.TIPO_NO);
		objins.setAccesoCelular(dw_requerimiento.getIsaccesocelular() ? ConstanteRrhh.TIPO_SI : ConstanteRrhh.TIPO_NO);
		objins.setAccesoOficina(dw_requerimiento.getIsaccesooficina() ? ConstanteRrhh.TIPO_SI : ConstanteRrhh.TIPO_NO);
		objins.setAccesoPc(dw_requerimiento.getIsaccesopc() ? ConstanteRrhh.TIPO_SI : ConstanteRrhh.TIPO_NO);
		objins.setAccesoOtrossistemas(
				dw_requerimiento.getIsaccesootrossistemas() ? ConstanteRrhh.TIPO_SI : ConstanteRrhh.TIPO_NO);
		objins.setAccesoOtrossistemascomentario(dw_requerimiento.getAcceso_otrossistemascomentario());
		objins.setObservaciones(dw_requerimiento.getObservaciones());
		objins.setIncrementocomentario(dw_requerimiento.getIncrementocomentario());
		objins.setLineacarrera(dw_requerimiento.getLineacarrera());
		objins.setAccesoOtroscomentario(dw_requerimiento.getAcceso_otroscomentario());
		objins.setCodigopuestosolicitante(dw_requerimiento.getCodigopuestosolicitante().intValue());
		objins.setCodigojefe(dw_requerimiento.getCodigojefe().intValue());
		objins.setLineacarrera2(dw_requerimiento.getLineacarrera_2());
		objins.setDesnuevocurso(dw_requerimiento.getDesnuevocurso());
		objins.setCodigopuestonuevo(dw_requerimiento.getCodigopuestonuevo().intValue());
		objins.setNumeroconcurso(dw_requerimiento.getNumeroconcurso());
		objins.setNivelservicio(dw_requerimiento.getNivelservicio().intValue());
		objins.setCertificacionnumero(dw_requerimiento.getCertificacionnumero());
		objins.setCompromisonumero(dw_requerimiento.getCompromisonumero());
		objins.setMontoapagar(dw_requerimiento.getMontoapagar());
		objins.setMotivorechazo(dw_requerimiento.getMotivorechazo());
		objins.setSucursal(dw_requerimiento.getSucursal());
		objins.setFechaconvocatoria(dw_requerimiento.getFechaconvocatoria());
		objins.setFlagtipocontrato(dw_requerimiento.getFlagtipocontrato());
		objins.setRutasustento(dw_requerimiento.getRutasustento());
		objins.setCodigoproceso(dw_requerimiento.getCodigoproceso());
		objins.setNumeroproceso(dw_requerimiento.getNumeroproceso());
		objins.setNumerosolicitud(dw_requerimiento.getNumerosolicitud());
		objins.setUuidalfresco(dw_requerimiento.getUuidalfresco());
		objins.setReferenciafiscal01(dw_requerimiento.getReferenciafiscal01());
		objins.setProceso(dw_requerimiento.getProceso());
		objins.setFuentefinanciamiento(dw_requerimiento.getFuentefinanciamiento());
		objins.setTemaevaluacionconocimiento(dw_requerimiento.getTemaevaluacionconocimiento());
		objins.setFlagEnviado(dw_requerimiento.getFlagEnviado());
		objins.setDescripcionpuestoinformativo(dw_requerimiento.getDescripcionpuestoinformativo());
		objins.setCreacionUsuario(getUsuarioActual().getCodigoUsuario());

		LOGGER.debug(dw_requerimiento.getUuidalfresco());

		if (accionEnvio) {
			objins.setEstado("PR");
		} else {
			if (((String) ivKeyRequerimiento.get("Action")).equals(ConstanteRrhh.ACCION_AGREGAR)) {

				String codigoValor2 = getFacCore().getMaMiscelaneosdetalleServicio().obtenerValorCodigo2("HR", "999999",
						"MOTIVOREQ", objins.getMotivo());

				if (UValidador.estaVacio(codigoValor2)) {
					codigoValor2 = "N";
				}

				if (codigoValor2.equals("S")) {
					objins.setEstado("SG");
				}
			}

		}

		objins.setMesesprueba(dw_requerimiento.getMesesprueba());

		if (!UValidador.esNulo(this.dw_requerimiento.getRutasustento()))
			this.archivoNuevo = this.dw_requerimiento.getRutasustento();

		if (!this.archivoActual.equals(this.archivoNuevo))
			switch (obtenerParametroModoArchivo()) {
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:
				try {
					RptaWsBean resp = getuOsinergminAlfresco().registrarDocumento(objins.getRutasustento(),
							"SELECCION/" + objins.getPk().getRequerimiento(), new File(dw_requerimiento.getRuta()));
					objins.setUuidalfresco(resp.getUuid());
					LOGGER.error(resp.getCadMsg());
				} catch (RemoteException e) {
					e.printStackTrace();
				}

				break;
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_BD:
				objins.setSustento(null);
			}

		getFacRrhh().getHrRequerimientoServicio().registrarOactualizar(objins);
		System.gc();
	}

	public void dwadicionalesupdate() {
		HrRequerimientoobservacionPk pkdel = new HrRequerimientoobservacionPk();
		pkdel.setCompanyowner(dw_requerimiento.getCompanyowner());
		pkdel.setRequerimiento(dw_requerimiento.getRequerimiento());

		HrRequerimientoobservacion objdel = (HrRequerimientoobservacion) getFacRrhh()
				.getHrRequerimientoobservacionServicio().obtenerPorId(pkdel);

		if (!UValidador.esNulo(objdel)) {
			getFacRrhh().getHrRequerimientoobservacionServicio().eliminar(objdel);
		}

		HrRequerimientoobservacion objins = new HrRequerimientoobservacion();
		objins = dw_adicionales;

		objins.getPk().setCompanyowner(dw_requerimiento.getCompanyowner());
		objins.getPk().setRequerimiento(dw_requerimiento.getRequerimiento());

		getFacRrhh().getHrRequerimientoobservacionServicio().registrar(objins);

	}

	public void dwreqadicionalesupdate() {

		getFacRrhh().getHrRequerimientoreemplazoServicio().eliminarRequerimientoReemplazo(
				dw_requerimiento.getCompanyowner(), dw_requerimiento.getRequerimiento());

		if (!opciones.getIshabilitartabreqadicionales()) {
			return;
		}

		if (!UValidador.esListaVacia(dw_reqadicional)) {
			for (HrRequerimientoreemplazo obj : dw_reqadicional) {
				obj.getPk().setCompanyowner(dw_requerimiento.getCompanyowner());
				obj.getPk().setRequerimiento(dw_requerimiento.getRequerimiento());
				getFacRrhh().getHrRequerimientoreemplazoServicio().registrar(obj);
			}
		}
	}

	private void dwfuncionescasupdate() {
		// TODO Auto-generated method stub

		getFacRrhh().getHrRequerimientofuncasServicio().eliminarporCampos(dw_requerimiento.getCompanyowner(),
				dw_requerimiento.getRequerimiento());

		if (!opciones.getIsmostrartabfuncionescas()) {
			return;
		}

		if (!UValidador.esListaVacia(dw_funcionescas)) {
			for (HrRequerimientofuncas obj : dw_funcionescas) {
				obj.setUltimaFechaModif(new Date());
				obj.setUltimoUsuario(getUsuarioActual().getLoginUsuario().toUpperCase());
				getFacRrhh().getHrRequerimientofuncasServicio().registrar(obj);
			}
		}
	}

	private void dwfuncionescasdetupdate() {

		// TODO Auto-generated method stub

		getFacRrhh().getHrRequerimientofuncasdetServicio().eliminarporCampos(dw_requerimiento.getCompanyowner(),
				dw_requerimiento.getRequerimiento());

		if (!opciones.getIsmostrartabfuncionescas()) {
			return;
		}

		if (!UValidador.esListaVacia(dw_funcionescas_det)) {
			for (HrRequerimientofuncasdet obj : dw_funcionescas_det) {
				obj.setUltimaFechaModif(new Date());
				obj.setUltimoUsuario(getUsuarioActual().getLoginUsuario().toUpperCase());
				getFacRrhh().getHrRequerimientofuncasdetServicio().registrar(obj);
			}
		}
	}

	private void dwfuncionespracupdate() {

		// TODO Auto-generated method stub
		if (!UValidador.estaVacio(dw_funcionesprac)) {
			dw_funcionesprac.getPk().setCompanyowner((String) ivKeyRequerimiento.get("companyowner"));
			dw_funcionesprac.getPk().setRequerimiento((String) ivKeyRequerimiento.get("requerimiento"));
			dw_funcionesprac.setFlagexcel(
					dw_funcionesprac.getAuxiliarisflagexcel() ? ConstanteRrhh.TIPO_SI : ConstanteRrhh.TIPO_NO);
			dw_funcionesprac.setFlagword(
					dw_funcionesprac.getAuxiliarisflagword() ? ConstanteRrhh.TIPO_SI : ConstanteRrhh.TIPO_NO);
			dw_funcionesprac.setFlagpowerpoint(
					dw_funcionesprac.getAuxiliarisflagpowerpoint() ? ConstanteRrhh.TIPO_SI : ConstanteRrhh.TIPO_NO);
			dw_funcionesprac.setFlagotro(
					dw_funcionesprac.getAuxiliarisflagotro() ? ConstanteRrhh.TIPO_SI : ConstanteRrhh.TIPO_NO);
			dw_funcionesprac.setOtroinformatica(
					dw_funcionesprac.getAuxiliarisflagotro() ? dw_funcionesprac.getOtroinformatica() : null);

			dw_funcionesprac.setFlagindispensableidioma(dw_funcionesprac.getAuxiliarisflagindispensableidioma()
					? ConstanteRrhh.TIPO_SI : ConstanteRrhh.TIPO_NO);
			dw_funcionesprac.setFlagingles(
					dw_funcionesprac.getAuxiliarisflagingles() ? ConstanteRrhh.TIPO_SI : ConstanteRrhh.TIPO_NO);

			dw_funcionesprac.setFlagotroidioma(
					dw_funcionesprac.getAuxiliarisflagotroidioma() ? ConstanteRrhh.TIPO_SI : ConstanteRrhh.TIPO_NO);
			dw_funcionesprac.setOtroidioma(
					dw_funcionesprac.getAuxiliarisflagotroidioma() ? dw_funcionesprac.getOtroidioma() : null);

			dw_funcionesprac.setFlagexperiencia(
					dw_funcionesprac.getAuxiliarisflagexperiencia() ? ConstanteRrhh.TIPO_SI : ConstanteRrhh.TIPO_NO);
			dw_funcionesprac.setTiempoexperiencia(
					dw_funcionesprac.getAuxiliarisflagexperiencia() ? dw_funcionesprac.getTiempoexperiencia() : null);

			dw_funcionesprac.setUltimaFechaModif(new Date());
			dw_funcionesprac.setUltimoUsuario(getUsuarioActual().getLoginUsuario().toUpperCase());

			getFacRrhh().getHrRequerimientofunpracServicio().eliminar(dw_funcionesprac);

			if (!opciones.getIshabilitartabfuncionesprac()) {
				return;
			}

			getFacRrhh().getHrRequerimientofunpracServicio().registrar(dw_funcionesprac);
		}
	}

	public String nuevoRequerimientoAdicional() {

		setAccionPantalla(accion_solicitada.NUEVO);

		dw_reqadicionalregistro = new HrRequerimientoreemplazo();
		dw_reqadicionalregistro.getPk().setEmpleado(null);
		dw_reqadicionalregistro.getPk().setCompanyowner(dw_requerimiento.getCompanyowner());
		dw_reqadicionalregistro.getPk().setRequerimiento(dw_requerimiento.getRequerimiento());
		dw_reqadicionalregistro.setFechainicio(new Date());

		return "w_requerimiento_reemplazo_mantenimiento";
	}

	public void onTabChange(TabChangeEvent event) throws Exception {
		switch (event.getTab().getId()) {
		case "tRequerimiento":
			setIndiceActivoTabMantenimiento(0);
			if (!UValidador.esNulo(dw_requerimiento.getMotivo())) {
				wfValidaMotivoTab(dw_requerimiento.getMotivo());
			}
			tabArchivos = 0;
			break;
		case "tReemplazo":
			setIndiceActivoTabMantenimiento(1);
			tabArchivos = 1;
			getWebControlContext().actualizar("frmWHrRequerimientoEdit:tvWHrRequerimientoEdit:tReemplazo");
			break;
		case "tPerfil":
			setIndiceActivoTabMantenimiento(2);
			nuevoFuncionesCas();
			tabArchivos = 2;
			break;
		case "tPracticante":
			setIndiceActivoTabMantenimiento(3);
			tabArchivos = 3;
			break;
		case "tArchivos":
			setIndiceActivoTabMantenimiento(4);
			opciones.setIshabilitardwrequerimiento(true);
			tabArchivos = 4;
			buscar();
			break;
		case "tSeguimiento":
			setIndiceActivoTabMantenimiento(5);
			tabArchivos = 5;
			break;

		default:
			setIndiceActivoTabMantenimiento(0);
		}

	}

	public void onRowSelectReemplazo(SelectEvent event) {
		dw_reqadicionalregistro = (HrRequerimientoreemplazo) event.getObject();
		LOGGER.debug("dw_reqadicionalregistro " + dw_reqadicionalregistro);
	}

	public String editarRequerimientoAdicional() {

		setAccionPantalla(accion_solicitada.EDITAR);

		if (UValidador.esListaVacia(dw_reqadicional)) {
			setMessageError("Debe seleccionar un registro.");
			return null;
		}

		return "w_requerimiento_reemplazo_mantenimiento";
	}

	public String eliminarRequerimientoAdicional() {
		if (UValidador.esListaVacia(dw_reqadicional)) {
			setMessageError("Debe seleccionar un registro.");
			return null;
		}
		for (int i = 0; i < dw_reqadicional.size(); i++) {
			HrRequerimientoreemplazo obj = dw_reqadicional.get(i);
			if (obj.getPk().getEmpleado().equals(dw_reqadicionalregistro.getPk().getEmpleado())) {
				dw_reqadicional.remove(i);
				i--;
				break;
			}
		}

		dw_reqadicionallist = new PwHrRequerimientoreemplazo(dw_reqadicional);

		return null;
	}

	public String agregarRequerimientoAdicional() {

		Integer find = 0;
		for (HrRequerimientoreemplazo obj : dw_reqadicional) {
			if (!obj.getPk().equals(dw_reqadicionalregistro.getPk())) {
				if (obj.getPk().getEmpleado().equals(dw_reqadicionalregistro.getPk().getEmpleado())) {
					find++;
					break;
				}
			}
		}

		if (find > 0) {
			setMessageError("El empleado ya fue seleccionado");
			return null;
		}

		// MOTIVO
		for (HrMotivocese obj : lstMotivoCese) {
			if (obj.getPk().getMotivo().equals(dw_reqadicionalregistro.getMotivocese())) {
				dw_reqadicionalregistro.setAuxiliarmotivo(obj.getDescripcion());
			}
		}

		// PUESTO
		for (HrPuestoempresa obj : lstHrPuestoEmpresa) {
			if (obj.getPk().getCodigopuesto().equals(dw_reqadicionalregistro.getCodigopuesto())) {
				dw_reqadicionalregistro.setAuxiliarpuesto(obj.getDescripcion());
			}
		}

		if (getAccionPantalla().equals(accion_solicitada.NUEVO)) {
			dw_reqadicional.add(dw_reqadicionalregistro);
		}

		if (getAccionPantalla().equals(accion_solicitada.EDITAR)) {
			for (HrRequerimientoreemplazo obj : dw_reqadicional) {
				if (obj.getPk().getEmpleado().equals(dw_reqadicionalregistro.getPk().getEmpleado())) {
					obj = dw_reqadicionalregistro;
					break;
				}
			}
		}

		dw_reqadicionallist = new PwHrRequerimientoreemplazo(dw_reqadicional);

		setIndiceActivoTabMantenimiento(1);

		return "hr_requerimiento_edit";
	}

	public String agregarFuncionesCas() {

		if (getAccionPantalla().equals(accion_solicitada.NUEVO)) {
			dw_funcionescas.add(dw_funcionescasregistro);
		}

		if (getAccionPantalla().equals(accion_solicitada.EDITAR)) {
			for (HrRequerimientofuncas obj : dw_funcionescas) {
				if (obj.getPk().getSecuencia().equals(dw_funcionescasregistro.getPk().getSecuencia())) {
					obj = dw_funcionescasregistro;
					break;
				}
			}
		}

		getWebControlContext().ejecutar("PF('popFuncionesCasMantenimiento').hide()");

		getWebControlContext().actualizar(
				"frmWHrRequerimientoEdit:tvWHrRequerimientoEdit:frmWHrRequerimientoPerfilPuesto:tblFuncionesCas");
		return null;
	}

	public String nuevoFuncionesCas() {

		setAccionPantalla(accion_solicitada.NUEVO);
		opciones.setIsmostrarcbagregarfuncas(true);

		if (iv_tipopuesto.equals("C") && UValidador.esListaVacia(dw_funcionescas)) {
			Integer indice = 1;

			while (indice <= 9) {
				HrRequerimientofuncas obj = new HrRequerimientofuncas();
				obj.getPk().setCompanyowner(dw_requerimiento.getCompanyowner());
				obj.getPk().setRequerimiento(dw_requerimiento.getRequerimiento());
				obj.getPk().setSecuencia(indice);

				if (indice.equals(1)) {
					obj.setFunciondescripcion("Formación Académica");
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}
				if (indice.equals(2)) {
					obj.setFunciondescripcion("Cursos y/o programas de especialización");
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}
				if (indice.equals(3)) {
					obj.setFunciondescripcion("Conocimientos Técnicos");
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}
				if (indice.equals(4)) {
					obj.setFunciondescripcion("Conocimientos de Ofimatica");
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}
				if (indice.equals(5)) {
					obj.setFunciondescripcion("Conocimientos de Idiomas");
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}
				if (indice.equals(6)) {
					obj.setFunciondescripcion("Experiencia General");
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}
				if (indice.equals(7)) {
					obj.setFunciondescripcion("Experiencia Especifica");
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}
				if (indice.equals(8)) {
					obj.setFunciondescripcion("Habilidades o Competencias");
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}
				if (indice.equals(9)) {
					obj.setFunciondescripcion("Requisitos Adicionales o Certificaciones");
					obj.setAuxTipoRequisito("Requisito Mínimo");
				}

				dw_funcionescas.add(obj);

				indice++;
			}

			opciones.setIsmostrarcbagregarfuncas(false);

			getWebControlContext()
					.actualizar("frmWHrRequerimientoEdit:tvWHrRequerimientoEdit:frmWHrRequerimientoPerfilPuesto");

			return null;
		}

		Integer w_secuencia = 0;

		for (int k = 0; k < dw_funcionescas.size(); k++) {
			if (dw_funcionescas.get(k).getPk().getSecuencia() > w_secuencia) {
				w_secuencia = dw_funcionescas.get(k).getPk().getSecuencia();
			}
		}

		w_secuencia++;

		// if (dw_funcionescas.size() < 10) {
		// dw_funcionescasregistro = new HrRequerimientofuncas();
		// dw_funcionescasregistro.getPk().setSecuencia(w_secuencia);
		// dw_funcionescasregistro.getPk().setCompanyowner(dw_requerimiento.getCompanyowner());
		// dw_funcionescasregistro.getPk().setRequerimiento(dw_requerimiento.getRequerimiento());
		// } else {
		// setMessageError("Solo se puede agregar 9 Perfiles de Puesto");
		// return null;
		// }

		// getWebControlContext().actualizar("dgFuncionesCasMantenimiento");
		// getWebControlContext().ejecutar("PF('popFuncionesCasMantenimiento').show()");

		return null;
	}

	public String editarFuncionesCas() {

		LOGGER.debug("editarFuncionesCas()");
		setAccionPantalla(accion_solicitada.EDITAR);

		getWebControlContext().actualizar("dgFuncionesCasMantenimiento");
		getWebControlContext().ejecutar("PF('popFuncionesCasMantenimiento').show()");

		return null;
	}

	public String eliminarFuncionesCas() {
		LOGGER.debug("eliminarFuncionesCas()");

		for (int i = 0; i < dw_funcionescas.size(); i++) {
			HrRequerimientofuncas obj = dw_funcionescas.get(i);
			if (obj.getPk().getSecuencia().equals(dw_funcionescasregistro.getPk().getSecuencia())) {
				dw_funcionescas.remove(i);
				break;
			}
		}

		if (iv_tipopuesto.equals("C")) {
			if (UValidador.esListaVacia(dw_funcionescas)) {
				opciones.setIsmostrarcbagregarfuncas(true);
			}
		}

		return null;
	}

	public String agregarFuncionesCasDet() {

		if (getAccionPantalla().equals(accion_solicitada.NUEVO)) {
			dw_funcionescas_det.add(dw_funcionescasdetregistro);
		}

		if (getAccionPantalla().equals(accion_solicitada.EDITAR)) {
			for (HrRequerimientofuncasdet obj : dw_funcionescas_det) {
				if (obj.getPk().getSecuencia().equals(dw_funcionescasdetregistro.getPk().getSecuencia())) {
					obj = dw_funcionescasdetregistro;
					break;
				}
			}
		}

		getWebControlContext().ejecutar("PF('popFuncionesCasDetMantenimiento').hide()");

		getWebControlContext().actualizar(
				"frmWHrRequerimientoEdit:tvWHrRequerimientoEdit:frmWHrRequerimientoPerfilPuesto:tblFuncionesCasDet");
		return null;
	}

	public String nuevoFuncionesCasDet() {

		setAccionPantalla(accion_solicitada.NUEVO);

		Integer w_secuencia = 0;

		for (int k = 0; k < dw_funcionescas_det.size(); k++) {
			if (dw_funcionescas_det.get(k).getPk().getSecuencia() > w_secuencia) {
				w_secuencia = dw_funcionescas_det.get(k).getPk().getSecuencia();
			}
		}

		w_secuencia++;

		dw_funcionescasdetregistro = new HrRequerimientofuncasdet();
		dw_funcionescasdetregistro.getPk().setSecuencia(w_secuencia);
		dw_funcionescasdetregistro.getPk().setCompanyowner(dw_requerimiento.getCompanyowner());
		dw_funcionescasdetregistro.getPk().setRequerimiento(dw_requerimiento.getRequerimiento());

		getWebControlContext().actualizar("dgFuncionesCasDetMantenimiento");
		getWebControlContext().ejecutar("PF('popFuncionesCasDetMantenimiento').show()");

		return null;
	}

	public String editarArchivo() {
		// bean.setDocumento(archivoSeleccionado.getDocumento());
		bean.setFecha(new Date());
		bean.setRuta(archivoSeleccionado.getRuta());
		bean.getPk().setCompanyowner(archivoSeleccionado.getPk().getCompanyowner());
		bean.getPk().setSecuencia(archivoSeleccionado.getPk().getSecuencia());
		bean.getPk().setRequerimiento(archivoSeleccionado.getPk().getRequerimiento());

		getWebControlContext().ejecutar("PF('popAgregarDocumento').show();");
		getWebControlContext().ejecutar("dgAgregarDocumento");

		return null;
	}

	public String eliminarArchivo() throws Exception {
		for (HrRequerimientoAdjunto obj : lstArchivosAdjuntos) {
			if (obj.getPk().getSecuencia().equals(archivoSeleccionado.getPk().getSecuencia()))
				obj.setEliminado(ConstanteRrhh.TIPO_SI);
		}

		getWebControlContext().actualizar("frmWHrRequerimientoEdit:tvWHrRequerimientoEdit:dtArchivos");
		buscar();
		return null;
	}

	public String editarFuncionesCasDet() {

		LOGGER.debug("editarFuncionesCasDet()");
		setAccionPantalla(accion_solicitada.EDITAR);

		getWebControlContext().actualizar("dgFuncionesCasDetMantenimiento");
		getWebControlContext().ejecutar("PF('popFuncionesCasDetMantenimiento').show()");

		return null;
	}

	public String eliminarFuncionesCasDet() {
		LOGGER.debug("eliminarFuncionesCasDet()");
		for (int i = 0; i < dw_funcionescas_det.size(); i++) {
			HrRequerimientofuncasdet obj = dw_funcionescas_det.get(i);
			if (obj.getPk().getSecuencia().equals(dw_funcionescasdetregistro.getPk().getSecuencia())) {
				dw_funcionescas_det.remove(i);
				break;
			}
		}

		return null;
	}

	@Override
	public String salir() throws Exception {
		return null;
	}

	public String irReemplazo() {
		setIndiceActivoTabMantenimiento(1);
		return "hr_requerimiento_edit";
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean validar() throws Exception {
		Integer w_codigopuesto;
		Integer w_numempleados;
		String lv_companyowner = null, lv_unidadreplicacion;
		Integer lv_correlativo;

		Boolean error = false;

		if (UValidador.esNulo(dw_requerimiento.getMontoapagar())) {
			dw_requerimiento.setMontoapagar(BigDecimal.ZERO);
		}

		if (UValidador.esNulo(dw_requerimiento.getFechasolicitud())) {
			setMessageError("El campo Fecha Solicitud es Obligatorio");
			error = true;
		}

		if (UValidador.esNulo(dw_requerimiento.getCodigoposicionsolicitante())) {
			setMessageError("El campo Posición donde se Trabaja es obligatorio");
			error = true;
		}

		// OSINERGMIN REQ-WEB-RS1 21/07/2023
		if (UValidador.estaVacio(dw_requerimiento.getDescripcionpuestoinformativo())) {
			setMessageError("El campo Plaza solicitada es obligatorio");
			error = true;
		}

		if (UValidador.estaVacio(dw_requerimiento.getCentrocosto())) {
			setMessageError("El campo Centro de Costo es obligatorio");
			error = true;
		}

		if (UValidador.estaVacio(dw_requerimiento.getTipoplanilla())) {
			setMessageError("El campo Tipo de Planilla es Obligatorio");
			error = true;
		}

		if (UValidador.estaVacio(dw_requerimiento.getTipocontrato())) {
			setMessageError("El campo Tipo de Contrato es obligatorio");
			error = true;
		}

		// if (opciones.getIshabilitarfechadesde()) {
		// if (UValidador.esNulo(dw_requerimiento.getFechadesde())) {
		// setMessageError("La Fecha de Inicio del Contrato es obligatorio");
		// error = true;
		// }
		// }
		//
		// if (opciones.getIshabilitarfechahasta()) {
		// if (UValidador.esNulo(dw_requerimiento.getFechahasta())) {
		// setMessageError("La Fecha Hasta del Contrato es obligatorio");
		// error = true;
		// }
		// }

		if (UValidador.estaVacio(dw_requerimiento.getTipotrabajador())) {
			setMessageError("El campo Tipo Trabajador es obligatorio");
			error = true;
		}

		if (UValidador.esCero(dw_requerimiento.getNivelservicio().intValue())) {
			setMessageError("El campo Nivel de Servicio es obligatorio");
			error = true;
		}

		if (UValidador.estaVacio(dw_requerimiento.getSucursal())) {
			setMessageError("El campo Sucursal es obligatorio");
			error = true;
		}

		if (UValidador.estaVacio(dw_requerimiento.getMotivo())) {
			setMessageError("EL campo Motivo de la Solicitud es obligatorio");
			error = true;
		}

		// OSINERGMIN REQ-WEB-RS1 21/07/2023
		// if (UValidador.estaVacio(dw_requerimiento.getFuentefinanciamiento()))
		// {
		// setMessageError("El campo fuente de financiamiento es obligatorio.");
		// error = true;
		// }

		// OSINERGMIN REQ-WEB-RS1 21/07/2023
		// if (UValidador.estaVacio(dw_requerimiento.getReferenciafiscal01())) {
		// setMessageError("El campo meta es obligatorio.");
		// error = true;
		// }

		// OSINERGMIN REQ-WEB-RS1 03/07/2023
		// if
		// (UValidador.estaVacio(dw_requerimiento.getTemaevaluacionconocimiento()))
		// {
		// setMessageError("El campo Temas para la evaluación de conocimiento es
		// obligatorio.");
		// error = true;
		// }

		// OSINERGMIN REQ-WEB-RS1 21/07/2023
		// if (UValidador.estaVacio(dw_requerimiento.getObservaciones())) {
		// setMessageError("El campo Justificación del Servicio es
		// obligatorio.");
		// error = true;
		// }

		// OSINERGMIN REQ-WEB-RS2 03/07/2023
		// if (ArrayUtils.contains(MOTIVOS_VALIDAR,
		// dw_requerimiento.getMotivo()))
		// if (!UValidador.esListaVacia(dw_funcionescas)) {
		// for (int i = 0; i < dw_funcionescas.size(); i++) {
		// HrRequerimientofuncas funciones = dw_funcionescas.get(i);
		// // if (ArrayUtils.contains(REQUISITOS_VALIDAR, i))
		// if (UValidador.estaVacio(funciones.getFuncioncomentarios())) {
		// setMessageError("Todos los requisitos del perfil del puesto son
		// requeridos.");
		// error = true;
		// break;
		// }
		// }
		// }

		// OSINERGMIN REQ-WEB-RS2 03/07/2023
		// if (!UValidador.esNulo(dw_requerimiento.getPagominimo())
		// && !UValidador.esNulo(dw_requerimiento.getPagomaximo())) {
		// if (!UValidador.esNulo(dw_requerimiento.getMontoapagar())) {
		// BigDecimal min = dw_requerimiento.getPagominimo();
		// BigDecimal max = dw_requerimiento.getPagomaximo();
		// BigDecimal pago = dw_requerimiento.getMontoapagar();
		//
		// if (pago.compareTo(min) < 0 || pago.compareTo(max) > 0) {
		// setMessageError("El monto a pagar debe estar dentro del rango
		// salarial.");
		// error = true;
		// }
		// }
		// }

		// si es envío validamos el jefe inmediato y el documento
		if (mostrarEnviar) {
			if (UValidador.esCero(dw_requerimiento.getCodigojefe().intValue())) {
				setMessageError("El campo jefe inmediato es obligatorio.");
				error = true;
			}
			// if (UValidador.estaVacio(dw_requerimiento.getRutasustento())) {
			// setMessageError("El campo sustento es obligatorio.");
			// error = true;
			// }
		}

		if (error) {
			return false;
		}

		switch ((String) ivKeyRequerimiento.get("Action")) {
		case "AGREGAR":
			lv_companyowner = dw_requerimiento.getCompanyowner();
			lv_unidadreplicacion = getUsuarioActual().getUnidadReplicacionCodigo();

			lv_correlativo = getFacRrhh().getHrRequerimientoServicio().obtenerMaximoRequerimiento(lv_companyowner,
					lv_unidadreplicacion);

			LOGGER.debug("lv_correlativo " + lv_correlativo);

			Formatter fmt = new Formatter();
			fmt.format("%06d", lv_correlativo + 1);

			ivKeyRequerimiento.put("requerimiento", lv_unidadreplicacion + fmt.toString());
			ivKeyRequerimiento.put("companyowner", lv_companyowner);
			dw_requerimiento.setRequerimiento((String) ivKeyRequerimiento.get("requerimiento"));
			dw_requerimiento.setUnidadreplicacion(lv_unidadreplicacion);
			dw_requerimiento.setRequerimientonumero(lv_correlativo.toString());

			break;

		default:
			ivKeyRequerimiento.put("requerimiento", dw_requerimiento.getRequerimiento());
			ivKeyRequerimiento.put("companyowner", dw_requerimiento.getCompanyowner());
		}

		if (!UValidador.esListaVacia(dw_funcionescas)) {
			for (HrRequerimientofuncas obj : dw_funcionescas) {
				obj.getPk().setRequerimiento((String) ivKeyRequerimiento.get("requerimiento"));
			}
		}

		Integer funcasDiasMinimo = getFacCore().getParametrosmastServicio()
				.obtenerValorInteger(new ParametrosmastPk("HR", "999999", "FUNCASDIAS"));

		String funcasDiasString = getFacCore().getParametrosmastServicio()
				.obtenerValorExplicacion(new ParametrosmastPk("HR", "999999", "FUNCASDIAS"));

		Integer funcasDiasMaximo = 0;

		if (!UValidador.estaVacio(funcasDiasMaximo)) {
			funcasDiasMaximo = Integer.parseInt(funcasDiasString);
		}

		// if (dw_requerimiento.getTipoplanilla().equals("EC")) {
		// if (dw_funcionescas_det.size() < funcasDiasMinimo) {
		// setMessageError("Se debe ingresar " + funcasDiasMinimo + " funciones
		// del puesto como mínimo");
		// return false;
		// }
		// if (dw_funcionescas_det.size() > funcasDiasMaximo) {
		// setMessageError("Se debe ingresar " + funcasDiasMaximo + " funciones
		// del puesto como máximo");
		// return false;
		// }
		// }

		Integer fila = 1;
		if (!UValidador.esListaVacia(dw_funcionescas_det)) {
			for (HrRequerimientofuncasdet obj : dw_funcionescas_det) {
				obj.getPk().setRequerimiento((String) ivKeyRequerimiento.get("requerimiento"));
				obj.getPk().setSecuencia(fila);
				fila += 1;
			}
		}

		if (!UValidador.esNulo(dw_adicionales)) {
			if (!UValidador.esNulo(dw_adicionales.getIniciovigencia())
					&& !UValidador.esNulo(dw_adicionales.getFinvigencia())) {
				if (dw_adicionales.getIniciovigencia().after(dw_adicionales.getFinvigencia())) {
					setMessageError("La fecha fin de vigencia debe ser mayor a la fecha inicial");
					return false;
				}
			}
		}

		if (!UValidador.esListaVacia(dwc_motivo)) {
			for (DtoDwMaMiscelaneosdetalleSelect obj : dwc_motivo) {
				if (obj.getCodigoelemento().equals(dw_requerimiento.getMotivo())) {
					iv_motivo = obj.getValornumerico().intValue();

					if (!iv_motivo.equals(2)) {
						if (UValidador.esNulo(dw_requerimiento.getCodigopuesto())) {
							setMessageError("Especifique el puesto");
							setIndiceActivoTabMantenimiento(0);
							return false;
						}
					}
				}
			}
		}

		switch ((String) ivKeyRequerimiento.get("Action")) {
		case "AGREGAR":
			w_codigopuesto = UValidador.esNulo(dw_requerimiento.getCodigopuesto()) ? null
					: dw_requerimiento.getCodigopuesto().intValue();

			Integer li_ano;
			String ls_ocupantes = null, ls_ocupante;
			BigDecimal total = BigDecimal.valueOf(0.0);

			li_ano = getFacCore().getParametrosmastServicio()
					.obtenerValorInteger(new ParametrosmastPk("HR", "999999", "ORGAN_YEAR"));

			List<DtoDwOrganigramaOcupados> ds_organigrama_ocupados = getFacRrhh().getHr().getHrOracleDatawindows()
					.DwOrganigramaOcupados(lv_companyowner, li_ano,
							UValidador.esNulo(w_codigopuesto) ? null : w_codigopuesto.toString());

			if (!UValidador.esListaVacia(ds_organigrama_ocupados)) {
				for (DtoDwOrganigramaOcupados obj : ds_organigrama_ocupados) {
					ls_ocupante = obj.getNombrecompleto();
					ls_ocupantes = ls_ocupantes + "	.-" + ls_ocupante;
					total.add(obj.getCantidad());
				}
			}

			w_numempleados = total.intValue();
			if (UValidador.esNulo(w_numempleados)) {
				w_numempleados = 0;
			}

			List<HrOrganigrama> listfind = getFacRrhh().getHrOrganigramaServicio().listarOrganigrama(lv_companyowner,
					li_ano, w_codigopuesto);

			if (!UValidador.esListaVacia(listfind)) {

				if (UValidador.esNulo(listfind.get(0).getNumeroestandar())) {
					listfind.get(0).setNumeroestandar(0);
				}
			}

			// ...Seleccionar el puesto
			HrPuestoempresa objfindpe = getFacRrhh().getHrPuestoempresaServicio()
					.obtenerPuestoEmpresaporCodigo(w_codigopuesto);

			if (!UValidador.esNulo(objfindpe)) {
				if (UValidador.esNulo(objfindpe.getDescripcion())) {
					objfindpe.setDescripcion("");
				}
			}

			if (!UValidador.esListaVacia(listfind)) {
				if (w_numempleados >= listfind.get(0).getNumeroestandar()) {
					if (listfind.get(0).getNumeroestandar() > 0) {
						setMessageWarn("Plaza cubierta por: " + ls_ocupantes);
					}
				}
			}

			break;
		}

		// HrTipocontratoPk pkfind = new HrTipocontratoPk();
		// pkfind.setTipocontrato(dw_requerimiento.getTipocontrato());
		//
		// String flagvencimiento = ((HrTipocontrato)
		// getFacRrhh().getHrTipocontratoServicio().obtenerPorId(pkfind))
		// .getFlagfechavencimiento();
		// if (UValidador.estaVacio(flagvencimiento)) {
		// flagvencimiento = ConstanteRrhh.TIPO_NO;
		// }
		//
		// if (UValidador.esNulo(dw_requerimiento.getFechahasta()) &&
		// flagvencimiento.equals(ConstanteRrhh.TIPO_SI)) {
		// setMessageError("La fecha de fin del contrato es requerido.");
		// setIndiceActivoTabMantenimiento(0);
		// return false;
		// }
		//
		// if
		// (dw_requerimiento.getFechadesde().before(dw_requerimiento.getFechasolicitud()))
		// {
		// setMessageError("La fecha de inicio del contrato no puede ser menor a
		// la fecha de solicitud.");
		// setIndiceActivoTabMantenimiento(0);
		// return false;
		// }
		//
		// if (!UValidador.esNulo(dw_requerimiento.getFechahasta())
		// && !UValidador.esNulo(dw_requerimiento.getFechadesde())) {
		// if
		// (dw_requerimiento.getFechadesde().after(dw_requerimiento.getFechahasta()))
		// {
		// setMessageError("La fecha de inicio del contrato no puede ser menor a
		// la fecha hasta.");
		// setIndiceActivoTabMantenimiento(0);
		// return false;
		// }
		// }

		if (((String) ivKeyRequerimiento.get("Action")).equals("AGREGAR")) {
			Integer numproceso = getFacRrhh().getHrRequerimientoServicio().secuenciaNextEval();

			dw_requerimiento.setNivelaprobacion(BigDecimal.ZERO);
			dw_requerimiento.setCodigoproceso("RS");
			dw_requerimiento.setNumeroproceso(BigDecimal.valueOf(numproceso));
		}
		
		// OSINERGMIN REQ-WEB-RS2 21/07/2023
//		if (dw_requerimiento.getTipoplanilla().equals("EC")
//				&& UValidador.estaVacio(dw_requerimiento.getObservaciones())) {
//			setMessageError("La Justificación de Servicio es requerida.");
//			return false;
//		}

		return true;
	}

	@Override
	public String prepararDatosMantenimiento() throws Exception {
		return null;
	}

	@Override
	public String prepararDatosListado() throws Exception {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {

		String w_companiasocio = null, w_cc;
		Integer ll_persona, w_codigounidad, w_cargo;

		w_companiasocio = dw_requerimiento.getCompanyowner();

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarPuestosSelect")) {

			HrPuestoempresa registroseleccionadoexterno = (HrPuestoempresa) (mensajeControllerGenerico.getParametros()
					.get("puestos"));

			this.cargarPuestoSeleccionado(registroseleccionadoexterno);

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarPrEmpleado")) {

			DtoDwPrEmpleadoSelect dtoEmpleado = (DtoDwPrEmpleadoSelect) mensajeControllerGenerico.getParametros()
					.get("prempleado");

			ll_persona = dtoEmpleado.getPersona().intValue();

			LOGGER.debug("this.getNombreTipoBusqueda() " + this.getNombreTipoBusqueda());

			if (!UValidador.estaVacio(this.getNombreTipoBusqueda())) {
				if (this.getNombreTipoBusqueda().equals("jefe")) {
					dw_requerimiento.setCodigojefe(BigDecimal.valueOf(ll_persona));
					dw_requerimiento.setPersonanombrecompletojefe(dtoEmpleado.getNombrecompleto());
					return null;
				}
				if (this.getNombreTipoBusqueda().equals("empleadoReemplazo")) {
					dw_reqadicionalregistro.getPk().setEmpleado(ll_persona);
					dw_reqadicionalregistro.setAuxiliarempleado(dtoEmpleado.getNombrecompleto());

					EmpleadomastPk pk = new EmpleadomastPk();
					pk.setCompaniasocio(dtoEmpleado.getCompaniasocio());
					pk.setEmpleado(dtoEmpleado.getEmpleado().intValue());

					Empleadomast objfind = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(pk);

					dw_reqadicionalregistro.setCodigopuesto(objfind.getCodigocargo());
					dw_reqadicionalregistro.setMotivocese(objfind.getMotivocese());

					dw_reqadicionalregistro.setAuxiliarsueldo(
							obtenerSueldoEmpleado(BigDecimal.valueOf(dw_reqadicionalregistro.getPk().getEmpleado())));

					dw_requerimiento.setMontoapagar(dw_reqadicionalregistro.getAuxiliarsueldo());

					return null;
				}

			}

			dw_requerimiento.setEmpleadosolicitante(new BigDecimal(ll_persona));
			dw_requerimiento.setPersonanombrecompleto(dtoEmpleado.getNombrecompleto());
			BigDecimal[] coCa;

			coCa = this.getFacRrhh().getHr().getHrprocDatawindow().obtenerCodigoUnidadCargo(new BigDecimal(ll_persona));
			w_codigounidad = UValidador.esNulo(coCa[0]) ? null : coCa[0].intValue();
			w_cargo = UValidador.esNulo(coCa[1]) ? null : coCa[1].intValue();
			dw_requerimiento.setCodigoposicionsolicitante(
					UValidador.esNulo(w_codigounidad) ? null : new BigDecimal(w_codigounidad));
			dw_requerimiento.setCodigopuestosolicitante(UValidador.esNulo(w_cargo) ? null : new BigDecimal(w_cargo));

			// BUSCA TIPO DE PLANILLA PARA EL ORGANIGRAMA
			String w_tipoplanillasolicitante, w_ccsolicitante;
			String[] obj = this.getFacRrhh().getHr().getHrprocDatawindow().obtenerTipoPlanillaCentroCosto(ll_persona);
			w_tipoplanillasolicitante = obj[0];
			w_ccsolicitante = obj[1];

			dwc_unidad = getFacRrhh().getHrOrganigramaServicio()
					.sp_hr_posicionempresa_hijosall(BigDecimal.valueOf(w_codigounidad), w_tipoplanillasolicitante);

			if (this.getFacAsistencia().getAS().getSycommFuncion().FSqlReadParametrosmastS("HR", "999999", "TIPPLANCAS")
					.equals(w_tipoplanillasolicitante)) {
				w_cc = w_ccsolicitante;
			} else {
				w_cc = this.getFacRrhh().getHr().getHrprocDatawindow().obtenerCentroCostoXUnidadCompania(w_codigounidad,
						w_companiasocio);
			}

			LOGGER.debug("centro costo " + w_cc);

			obtenerCentroCostoNombre(w_cc);

			LOGGER.debug("centro costo " + dw_requerimiento.getCentrocostonombre());

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarNivelServicio")) {

			BuNivelserviciomst bunivelservicio = (BuNivelserviciomst) mensajeControllerGenerico.getParametros()
					.get("nivel");
			dw_requerimiento.setNivelservicio(BigDecimal.valueOf(bunivelservicio.getPk().getNivelservicio()));
			dw_requerimiento.setNombrenivelservicio(bunivelservicio.getDescripcion());

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("cargarDocumento")) {
			DtoDwWhDocumentoarchivoList documento = (DtoDwWhDocumentoarchivoList) mensajeControllerGenerico
					.getParametros().get("documento");

			dw_requerimiento.setRutasustento(documento.getArchivo());
			dw_requerimiento.setDocumento(UFile.obtenerArregloByte(documento.getRuta()));
			dw_requerimiento.setRuta(documento.getRuta());
			System.gc();

			opciones.setIsmostrarver(false);
		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("cargarArchivo")) {
			DtoDwWhDocumentoarchivoList documento = (DtoDwWhDocumentoarchivoList) mensajeControllerGenerico
					.getParametros().get("documento");
			bean = new HrRequerimientoAdjunto();

			bean.setRuta("");
			Integer tamaño = lstArchivosAdjuntos.size();
			Integer secuenTemp = 0;

			if (!tamaño.equals(0))
				secuenTemp = lstArchivosAdjuntos.get(tamaño - 1).getPk().getSecuencia();

			secuencia = secuenTemp + 1;

			if (!secuenTemp.equals(0)) {
				if (secuenTemp > secuencia) {
					secuencia = secuenTemp + 1;
				}
			}

			bean.setRuta(documento.getArchivo());
			bean.setRutaArchivo(documento.getRuta());
			bean.setEliminado(ConstanteRrhh.TIPO_NO);
			bean.setFecha(new Date());
			bean.getPk().setSecuencia(secuencia);
			bean.getPk().setCompanyowner(compania);
			bean.getPk().setRequerimiento(requerimiento);

			lstArchivosAdjuntos.add(bean);

			getWebControlContext().actualizar("frmWHrRequerimientoEdit:tvWHrRequerimientoEdit:dtArchivos");

		}

		return null;
	}

	private void cargarPuestoSeleccionado(HrPuestoempresa registroseleccionadoexterno) {
		String ls_lineacarrera, ls_familia, ls_grado;

		if (wfTipoPlanilaPuesto(registroseleccionadoexterno.getPk().getCodigopuesto()).equals(-1)) {
			setMessageError("El puesto no coincide con el tipo de planilla");
			return;
		}

		dw_requerimiento.setCodigopuesto(BigDecimal.valueOf(registroseleccionadoexterno.getPk().getCodigopuesto()));

		String descripcion = null;
		if (!UValidador.estaVacio(registroseleccionadoexterno.getComentarios())) {
			descripcion = (UValidador.esNulo(registroseleccionadoexterno.getCodigocap()) ? ""
					: registroseleccionadoexterno.getCodigocap()) + "-" + registroseleccionadoexterno.getDescripcion()
					+ " (" + registroseleccionadoexterno.getComentarios() + ")";
		} else {
			descripcion = (UValidador.esNulo(registroseleccionadoexterno.getCodigocap()) ? ""
					: registroseleccionadoexterno.getCodigocap()) + "-" + registroseleccionadoexterno.getDescripcion();
		}

		dw_requerimiento.setNombrepuestocomntario(descripcion);

		LOGGER.debug("mensaje " + descripcion);

		HrPuestoempresaPk pkfind = new HrPuestoempresaPk();
		pkfind.setCodigopuesto(dw_requerimiento.getCodigopuesto().intValue());

		HrPuestoempresa objfind = (HrPuestoempresa) getFacRrhh().getHrPuestoempresaServicio().obtenerPorId(pkfind);

		iv_tipopuesto = objfind.getFlagpuestopracticante();
		ls_lineacarrera = objfind.getLineacarrera();
		ls_familia = objfind.getCategoriafuncional();
		ls_grado = objfind.getGradosalario();

		opciones.setIsmostrartabfuncionescas(false);
		opciones.setIshabilitartabfuncionescas(false);
		opciones.setIsmostrartabfuncionesprac(false);
		opciones.setIshabilitartabfuncionesprac(false);

		if (UValidador.estaVacio(iv_tipopuesto)) {
			iv_tipopuesto = ConstanteRrhh.TIPO_PUESTO_T;
		}

		if (iv_tipopuesto.equals(ConstanteRrhh.TIPO_PUESTO_C) || iv_tipopuesto.equals(ConstanteRrhh.TIPO_PUESTO_P)) {
			opciones.setIshabilitartabfuncionescas(true);
			opciones.setIsmostrartabfuncionescas(true);
			if (iv_tipopuesto.equals(ConstanteRrhh.TIPO_PUESTO_P)) {
				opciones.setIshabilitartabfuncionesprac(true);
				opciones.setIsmostrartabfuncionesprac(true);
			}
		}

		LOGGER.debug("ls_familia " + ls_familia);

		dwc_linea = this.getFacRrhh().getHr().getHrprocDatawindow().DddWMaHrGradoSalairalMastSelect(null);
		dwc_linea_2 = this.getFacAsistencia().getAS().getSymastDatawindow().DwMaMiscelaneosdetalleSelect("HR",
				"CARGLINEAC", "999999");

		dw_requerimiento.setCategoria(ls_familia);
		dw_requerimiento.setLineacarrera(ls_grado);
		dw_requerimiento.setLineacarrera_2(ls_lineacarrera);

		obtenerMaximoMinimoLineaCarrera(dw_requerimiento.getLineacarrera(), 1);
		obtenerMaximoMinimoLineaCarrera(dw_requerimiento.getLineacarrera(), 2);

		wfValidaMotivo(dw_requerimiento.getMotivo());
	}

	public String buscarJefeInmediato() throws Exception {
		LOGGER.debug("dw_requerimiento " + dw_requerimiento);
		return CwPrEmpleadoSelect.getInstance().iniciarControladora();
	}

	private void obtenerCentroCostoNombre(String w_cc) {
		if (!UValidador.estaVacio(w_cc)) {
			dw_requerimiento.setCentrocosto(w_cc);
			AcCostcentermstPk pkfind = new AcCostcentermstPk();
			pkfind.setCostcenter(w_cc);

			AcCostcentermst objfind = (AcCostcentermst) getFacContabilidad().getAcCostcentermstServicio()
					.obtenerPorId(pkfind);

			if (!UValidador.esNulo(objfind)) {
				dw_requerimiento.setCentrocostonombre(objfind.getLocalname());
			}
		}
	}

	private String obtenerUnidadNombre() {

		String posicionnombre = "";

		if (!UValidador.esListaVacia(dwc_unidad)
				&& !UValidador.esNulo(dw_requerimiento.getCodigoposicionsolicitante())) {
			for (DtoDWHrPosicionesHijosAllSelect obj : dwc_unidad) {
				if (obj.getCodigoposicion().equals(dw_requerimiento.getCodigoposicionsolicitante().intValue())) {
					posicionnombre = obj.getDescripcion();
					break;
				}
			}
		}

		return posicionnombre;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		Integer anio = UFechaHora.obtenerFechaParte(new Date(), "YY");

		lstMetas = getFacRrhh().getHrRequerimientoServicio()
				.obtenermetapresupuestal(getUsuarioActual().getCompaniaSocioCodigo(), anio.toString());

		fuentesFinanciamiento = this.getFacPlanilla().getPrFuentefinanciamientoServicio()
				.listarPorAnioCompania(anio.toString(), getUsuarioActual().getCompaniaSocioCodigo());

		return null;
	}

	private void mostarReporte() {
		String requerimiento = (String) ivKeyRequerimiento.get("requerimiento");
		String compania = (String) ivKeyRequerimiento.get("companyowner");

		HrRequerimiento cantReque = this.getFacRrhh().getHrRequerimientoServicio().obtenerRequerimiento(requerimiento,
				compania);

		if (UValidador.esNulo(cantReque)) {
			mostrarReporte = false;
		} else {
			mostrarReporte = true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public String inicializarDatosMantenimiento() throws Exception {

		secuencia = 0;
		requerimiento = (String) ivKeyRequerimiento.get("requerimiento");
		compania = (String) ivKeyRequerimiento.get("companyowner");

		// cuando trae la lista realiza la configuracion a todos en NO
		List<HrRequerimientoAdjunto> lstTemporal = getFacRrhh().getHrRequerimientoAdjuntoServicio()
				.obtenerListadoArchivos(requerimiento, compania);

		for (HrRequerimientoAdjunto obj : lstTemporal) {
			obj.setEliminado(ConstanteRrhh.TIPO_NO);
			lstArchivosAdjuntos.add(obj);
		}

		dw_requerimiento = new DtoDwHrRequerimientoEdit();
		dw_requerimiento.setCorreoelectronico(ConstanteRrhh.TIPO_NO);
		dw_requerimiento.setFlagtarjetapersonal(ConstanteRrhh.TIPO_NO);
		dw_requerimiento.setFlagaccesointernet(ConstanteRrhh.TIPO_NO);
		dw_requerimiento.setIsaccesocorreo(false);
		dw_requerimiento.setIsaccesointernet(false);
		dw_requerimiento.setIsaccesosii(false);
		dw_requerimiento.setIsaccesootros(false);
		dw_requerimiento.setProceso(new BigDecimal(1));
		dw_requerimiento.setIsaccesotelefono(false);
		dw_requerimiento.setIsaccesocelular(false);
		dw_requerimiento.setIsaccesooficina(false);
		dw_requerimiento.setIsaccesopc(false);
		dw_requerimiento.setIsaccesootrossistemas(false);
		dw_requerimiento.setMontoapagar(BigDecimal.ZERO);
		dw_requerimiento.setFlagtipocontrato(ConstanteRrhh.TIPO_CONT_R);
		dw_requerimiento.setTiporequerimiento("C");
		dw_requerimiento.setTipohorario(BigDecimal.valueOf(3));
		dw_requerimiento.setTipotrabajador("02");
		dw_requerimiento.setNivelservicio(BigDecimal.valueOf(115));
		dw_requerimiento.setFlagEnviado("N");

		opciones = new OWHrRequerimientoEdit();
		opciones.setIshabilitarbpuesto(true);
		opciones.setIshabilitarbempsolicitante(true);
		opciones.setIshabilitarbcodigojefe(true);
		opciones.setIshabilitarbnivelservicio(true);
		opciones.setIshabilitardwrequerimiento(true);
		opciones.setIsmostrarcbagregarfuncas(true);
		opciones.setIsmostrarcbeditarfuncas(true);

		dw_reqadicional = new ArrayList<>();
		dw_reqadicionallist = new PwHrRequerimientoreemplazo(dw_reqadicional);
		dw_adicionales = new HrRequerimientoobservacion();
		dw_funcionescas = new ArrayList<HrRequerimientofuncas>();
		dw_funcionescas_det = new ArrayList<HrRequerimientofuncasdet>();
		dw_funcionesprac = new HrRequerimientofunprac();

		dw_reqadicionalregistro = new HrRequerimientoreemplazo();
		dw_funcionescasregistro = new HrRequerimientofuncas();
		dw_funcionescasdetregistro = new HrRequerimientofuncasdet();

		if (UValidador.esListaVacia(lstHrPuestoEmpresa)) {
			lstHrPuestoEmpresa = this.getFacRrhh().getHrPuestoempresaServicio().listarPuestoEmpresa();
		}

		if (UValidador.esListaVacia(lstHrCargosMast)) {
			lstHrCargosMast = this.getFacRrhh().getHrCargosmastServicio().ListarCargosmast();
		}

		if (UValidador.esListaVacia(lstSucursal)) {
			lstSucursal = this.getFacContabilidad().getAcSucursalServicio().obtenerLista("", "");
		}

		if (UValidador.esListaVacia(lstHrEmpleadoReclutamiento)) {
			lstHrEmpleadoReclutamiento = getFacRrhh().getHr().getHrmastDatawindow().dwHrEmpleadoReclutamientoSelect();
		}

		if (UValidador.esListaVacia(lstMotivoCese)) {
			lstMotivoCese = (List<HrMotivocese>) getFacRrhh().getHrMotivoceseServicio().listarTodos();
		}

		if (UValidador.esListaVacia(lstTipoTrabajador)) {
			lstTipoTrabajador = getFacRrhh().getHrTipotrabajadorServicio().listarTipoTrabajadorActivo();
		}
		if (UValidador.esListaVacia(lstTipoHorario)) {
			lstTipoHorario = getFacAsistencia().getAsTipohorarioServicio().listarTipoHorarioOrden();
		}

		dwc_tipoplanilla = this.getFacRrhh().getHr().getPrmastDatawindow().dwMaPrTipoplantillaSelect();
		CVTDtoTipoPlanilla.lista = dwc_tipoplanilla;

		setIndiceActivoTabMantenimiento(0);

		iv_tipopuesto = "";

		return null;
	}

	public String seleccionarPuestoSolicitado() throws Exception {

		LOGGER.debug("seleccionarPuestoSolicitado()");

		CwHrPuestosSelect.getInstance().iniciarControladora();

		return null;
	}

	public String cambiarTab() {
		this.setIndiceActivoTabMantenimiento(1);

		getWebControlContext().actualizar("frmWHrRequerimientoEdit:tvWHrRequerimientoEdit");

		return null;
	}

	public String verArchivo() throws Exception {
		String archivo = dw_requerimiento.getRutasustento();
		archivo = archivo.replace("°", "");

		if (!UValidador.esNulo(dw_requerimiento.getUuidalfresco())) {
			switch (obtenerParametroModoArchivo()) {
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

				if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
					this.setMessageError("No se encontraron los parametros key o ws");
					return null;
				}

				try {
					ContenidoECMBean respuestaconsulta = getuOsinergminAlfresco()
							.obtenerDocumento(dw_requerimiento.getUuidalfresco());
					LOGGER.debug(respuestaconsulta);
					if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
						LOGGER.debug("Se encontro el archivo");
						new UFile().cargarArchivoXByte(respuestaconsulta.getContenidoFile(), archivo, "temporaloefa");
					}
				} catch (Exception e) {
					LOGGER.debug(e.getMessage());
					this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
					return null;
				}
				break;
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_BD:
				if (!UValidador.esNulo(dw_requerimiento.getDocumento())) {
					new UFile().cargarArchivoXByte(dw_requerimiento.getDocumento(), archivo, "temporal");

				}
			}
		} else {
			setMessageError("No ha seleccionado ningún archivo");
			return null;
		}

		setSessionValue("nombrearchivo", archivo);

		return "documentos";
	}

	public String verDocumento() throws Exception {

		String archivo = archivoSeleccionado.getRuta();
		if (!UValidador.esNulo(archivoSeleccionado.getUuidalfresco())) {
			switch (obtenerParametroModoArchivo()) {
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

				if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
					this.setMessageError("No se encontraron los parametros key o ws");
					return null;
				}

				try {
					ContenidoECMBean respuestaconsulta = getuOsinergminAlfresco()
							.obtenerDocumento(archivoSeleccionado.getUuidalfresco());
					LOGGER.debug(respuestaconsulta);
					if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
						LOGGER.debug("Se encontro el archivo");
						new UFile().cargarArchivoXByte(respuestaconsulta.getContenidoFile(), archivo, "temporaloefa");
					}
				} catch (Exception e) {
					LOGGER.debug(e.getMessage());
					this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
					return null;
				}
			}
		} else {
			if (!UValidador.esNulo(archivoSeleccionado.getRutaArchivo())) {
				new UFile().cargarArchivoXByte(UFile.obtenerArregloByte(archivoSeleccionado.getRutaArchivo()), archivo,
						"temporaloefa");
			} else {
				setMessageError("No ha seleccionado ningún archivo");
				return null;
			}
		}

		setSessionValue("nombrearchivo", archivo);

		return "documentos";
	}

	public void valueChangeMotivo(ValueChangeEvent event) {
		if (UValidador.esNulo(event)) {
			return;
		}
		if (UValidador.esNulo(event.getNewValue())) {
			return;
		}
		dw_requerimiento.setMotivo((String) event.getNewValue());

		wfValidaMotivo(dw_requerimiento.getMotivo());
	}

	public String guardarDatosTemporal() {
		LOGGER.debug("guardarDatosTemporal()");
		if (!UValidador.esNulo(dw_requerimiento.getMotivo())) {
			wfValidaMotivoTab(dw_requerimiento.getMotivo());
		}
		return null;
	}

	public void validarVacante(FacesContext context, UIComponent component, Object value) {
		if (UValidador.esNulo(value) || UValidador.esCero(((BigDecimal) value).intValue())) {
			FacesMessage message = new FacesMessage("Especifique el número de personas solicitado para el puesto");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);

			throw new ValidatorException(message);
		}
	}

	// solicito ELKA 8/09/2016
	// public void validarMonto(FacesContext context, UIComponent component,
	// Object value) {
	//
	// BigDecimal valor = BigDecimal.ZERO;
	// if (!UValidador.esNulo(value)) {
	// valor = (BigDecimal) value;
	// }
	//
	// if ((valor.compareTo(dw_requerimiento.getPagomaximo())) == 1
	// || (valor.compareTo(dw_requerimiento.getPagominimo())) == -1) {
	// FacesMessage message = new FacesMessage("El monto no se encuentra dentro
	// del rango establecido.");
	// message.setSeverity(FacesMessage.SEVERITY_ERROR);
	//
	// throw new ValidatorException(message);
	// }
	// }

	public void validarDetalleMotivo(FacesContext context, UIComponent component, Object value) {
		if (UValidador.estaVacio(value) && UValidador.esNulo(iv_motivo)) {
			FacesMessage message = new FacesMessage("Especifique el detalle del motivo de solicitud");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);

			throw new ValidatorException(message);
		}
	}

	public void valueChangeRangoRemunerativo(ValueChangeEvent event) {
		if (UValidador.esNulo(event)) {
			return;
		}

		if (UValidador.esNulo(event.getNewValue())) {
			return;
		}

		dw_requerimiento.setLineacarrera((String) event.getNewValue());

		obtenerMaximoMinimoLineaCarrera(dw_requerimiento.getLineacarrera(), 1);
		obtenerMaximoMinimoLineaCarrera(dw_requerimiento.getLineacarrera(), 2);

	}

	public void valueChangePlanilla(ValueChangeEvent event) {
		if (UValidador.esNulo(event)) {
			return;
		}
		if (UValidador.esNulo(event.getNewValue())) {
			return;
		}

		wfTipocontratofechas((String) event.getNewValue());

		Integer codpuesto = null;
		if (!UValidador.esNulo(dw_requerimiento.getCodigopuesto())) {
			codpuesto = dw_requerimiento.getCodigopuesto().intValue();
		}

		if (wfTipoPlanilaPuesto(codpuesto).equals(-1)) {
			dw_requerimiento.setCodigopuesto(BigDecimal.ZERO);
			dw_requerimiento.setNombrepuestocomntario("NO ESPECIFICADO");
			setMessageError("El puesto no coincide con el tipo de planilla");
			return;
		}

	}

	public void valueChangeTipoContrato(ValueChangeEvent event) {
		if (UValidador.esNulo(event)) {
			return;
		}

		if (UValidador.esNulo(event.getNewValue())) {
			return;
		}

		dw_requerimiento.setTipocontrato((String) event.getNewValue());

		cargarrequiereprueba();

		wfTipocontratofechas(dw_requerimiento.getTipoplanilla());

	}

	private void cargarrequiereprueba() {
		isrequiereperiodoprueba = false;

		HrTipocontrato obj = new HrTipocontrato();
		obj.getPk().setTipocontrato(dw_requerimiento.getTipocontrato());
		obj = (HrTipocontrato) getFacRrhh().getHrTipocontratoServicio().obtenerPorId(obj.getPk());
		if (!UValidador.esNulo(obj)) {
			if (obj.getTieneperiodoprueba().equals("S")) {
				isrequiereperiodoprueba = true;
			}
		}
	}

	private void obtenerMaximoMinimoLineaCarrera(String grado, Integer tipo) {

		LOGGER.debug("grado " + grado);

		HrGradosalariomastPk pkfind = new HrGradosalariomastPk();
		pkfind.setGradosalario(grado);

		HrGradosalariomast objfind = (HrGradosalariomast) getFacRrhh().getHrGradosalariomastServicio()
				.obtenerPorId(pkfind);

		if (UValidador.esNulo(objfind)) {
			return;
		}

		if (tipo.equals(1)) {
			dw_requerimiento.setPagomaximo(objfind.getSalariomaximo());
		}
		if (tipo.equals(2)) {
			dw_requerimiento.setPagominimo(objfind.getSalariominimo());
		}
	}

	public void limpiarEmpleado() {
		dw_reqadicionalregistro.getPk().setEmpleado(null);
		dw_reqadicionalregistro.setAuxiliarempleado(null);
	}

	public String nuevoArchivo() throws Exception {
		CwWhDocumentoArchivoList.getInstance().nuevo();
		return null;
	}

	private Integer wfTipoPlanilaPuesto(Integer puesto) {
		String tipoplanilla;

		HrPuestoempresaPk pkfind = new HrPuestoempresaPk();
		pkfind.setCodigopuesto(puesto);

		HrPuestoempresa objfind = (HrPuestoempresa) getFacRrhh().getHrPuestoempresaServicio().obtenerPorId(pkfind,
				false);

		if (!UValidador.esNulo(objfind)) {
			tipoplanilla = objfind.getFlagpuestopracticante();

			if (!UValidador.estaVacio(tipoplanilla)) {
				if (tipoplanilla.equals("EC")) {
					if (dw_requerimiento.getTipoplanilla().equals("EC")) {
						return 1;
					} else {
						return -1;
					}
				}
				if (tipoplanilla.equals("A")) {
					if (dw_requerimiento.getTipoplanilla().equals("EM")) {
						return 1;
					} else {
						return -1;
					}
				}
				if (tipoplanilla.equals("P")) {
					if (dw_requerimiento.getTipoplanilla().equals("PR")) {
						return 1;
					} else {
						return -1;
					}
				}
			}

		}

		return 1;
	}

	private BigDecimal obtenerSueldoEmpleado(BigDecimal empleado) throws Exception {

		String concepto;

		concepto = getFacCore().getParametrosmastServicio()
				.obtenerValorCadena(new ParametrosmastPk("HR", "999999", "COINHABBAS"));

		BigDecimal saldo = getFacRrhh().getHr().getHrrepusFuncion().FHrGetSueldo(empleado, concepto);

		return saldo;

	}

	public void activarTab(String tab) {
		if (tab.equals("0")) {

		}
	}

	private String obtenerParametroModoArchivo() {
		String modo = ConstanteSeguridad.PARAMETRO_MODOARCHIVO_BD;
		ParametrosmastPk pk = new ParametrosmastPk("HR", "999999", "MODOARCHIV");
		String param = this.getFacCore().getParametrosmastServicio().obtenerValorCadena(pk);
		if (!UValidador.estaVacio(param)) {
			modo = param;
		} else {
			this.setMessageInfo("No se encontró el parámetro MODOARCHIV. Se tomó valor por defecto");
		}

		key = this.getFacCore().getParametrosmastServicio()
				.obtenerValorExplicacion(new ParametrosmastPk("SP", "999999", "KEYALFRESC"));
		ws = this.getFacCore().getParametrosmastServicio()
				.obtenerValorExplicacion(new ParametrosmastPk("SP", "999999", "WSALFRESCO"));
		return modo;
	}

	public List<DtoDwMaMiscelaneosdetalleSelect> getDwc_linea_2() {
		return dwc_linea_2;
	}

	public void setDwc_linea_2(List<DtoDwMaMiscelaneosdetalleSelect> dwc_linea_2) {
		this.dwc_linea_2 = dwc_linea_2;
	}

	public List<DtoDwMaMiscelaneosdetalleSelect> getDwc_motivo() {
		return dwc_motivo;
	}

	public void setDwc_motivo(List<DtoDwMaMiscelaneosdetalleSelect> dwc_motivo) {
		this.dwc_motivo = dwc_motivo;
	}

	public List<DtoDddWMaHrGradoSalairalMastSelect> getDwc_linea() {
		return dwc_linea;
	}

	public void setDwc_linea(List<DtoDddWMaHrGradoSalairalMastSelect> dwc_linea) {
		this.dwc_linea = dwc_linea;
	}

	public DtoDwHrRequerimientoEdit getDw_requerimiento() {
		return dw_requerimiento;
	}

	public void setDw_requerimiento(DtoDwHrRequerimientoEdit dw_requerimiento) {
		this.dw_requerimiento = dw_requerimiento;
	}

	public List<DtoDWHrTipoContratoSelect> getDwc_tipocontrato() {
		return dwc_tipocontrato;
	}

	public void setDwc_tipocontrato(List<DtoDWHrTipoContratoSelect> dwc_tipocontrato) {
		this.dwc_tipocontrato = dwc_tipocontrato;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getIv_motivo() {
		return iv_motivo;
	}

	public void setIv_motivo(Integer iv_motivo) {
		this.iv_motivo = iv_motivo;
	}

	public List<DtoDwMaMiscelaneosdetalleSelect> getDwc_nivel1() {
		return dwc_nivel1;
	}

	public void setDwc_nivel1(List<DtoDwMaMiscelaneosdetalleSelect> dwc_nivel1) {
		this.dwc_nivel1 = dwc_nivel1;
	}

	public List<DtoDwMaMiscelaneosdetalleSelect> getDwc_nivel2() {
		return dwc_nivel2;
	}

	public void setDwc_nivel2(List<DtoDwMaMiscelaneosdetalleSelect> dwc_nivel2) {
		this.dwc_nivel2 = dwc_nivel2;
	}

	public List<DtoDwMaMiscelaneosdetalleSelect> getDwc_nivel3() {
		return dwc_nivel3;
	}

	public void setDwc_nivel3(List<DtoDwMaMiscelaneosdetalleSelect> dwc_nivel3) {
		this.dwc_nivel3 = dwc_nivel3;
	}

	public List<DtoDwMaMiscelaneosdetalleSelect> getDwc_nivel4() {
		return dwc_nivel4;
	}

	public void setDwc_nivel4(List<DtoDwMaMiscelaneosdetalleSelect> dwc_nivel4) {
		this.dwc_nivel4 = dwc_nivel4;
	}

	public List<DtoDWHrPosicionesHijosAllSelect> getDwc_unidad() {
		return dwc_unidad;
	}

	public void setDwc_unidad(List<DtoDWHrPosicionesHijosAllSelect> dwc_unidad) {
		this.dwc_unidad = dwc_unidad;
	}

	public String getIv_vendornum() {
		return iv_vendornum;
	}

	public void setIv_vendornum(String iv_vendornum) {
		this.iv_vendornum = iv_vendornum;
	}

	public Integer getIv_VALMINAPR() {
		return iv_VALMINAPR;
	}

	public void setIv_VALMINAPR(Integer iv_VALMINAPR) {
		this.iv_VALMINAPR = iv_VALMINAPR;
	}

	public List<DtoDwMaCompanyownerSelect> getCompanyOwners() {
		return companyOwners;
	}

	public void setCompanyOwners(List<DtoDwMaCompanyownerSelect> companyOwners) {
		this.companyOwners = companyOwners;
	}

	public List<DtoDwMaPrTipoplantillaSelect> getDwc_tipoplanilla() {
		return dwc_tipoplanilla;
	}

	public void setDwc_tipoplanilla(List<DtoDwMaPrTipoplantillaSelect> dwc_tipoplanilla) {
		this.dwc_tipoplanilla = dwc_tipoplanilla;
	}

	public boolean isIb_filtrar() {
		return ib_filtrar;
	}

	public void setIb_filtrar(boolean ib_filtrar) {
		this.ib_filtrar = ib_filtrar;
	}

	/**
	 * @return the lstHrPuestoEmpresa
	 */
	public List<HrPuestoempresa> getLstHrPuestoEmpresa() {
		return lstHrPuestoEmpresa;
	}

	/**
	 * @param lstHrPuestoEmpresa
	 *            the lstHrPuestoEmpresa to set
	 */
	public void setLstHrPuestoEmpresa(List<HrPuestoempresa> lstHrPuestoEmpresa) {
		this.lstHrPuestoEmpresa = lstHrPuestoEmpresa;
	}

	/**
	 * @return the lstHrCargosMast
	 */
	public List<HrCargosmast> getLstHrCargosMast() {
		return lstHrCargosMast;
	}

	/**
	 * @param lstHrCargosMast
	 *            the lstHrCargosMast to set
	 */
	public void setLstHrCargosMast(List<HrCargosmast> lstHrCargosMast) {
		this.lstHrCargosMast = lstHrCargosMast;
	}

	/**
	 * @return the lstSucursal
	 */
	public List<AcSucursal> getLstSucursal() {
		return lstSucursal;
	}

	/**
	 * @param lstSucursal
	 *            the lstSucursal to set
	 */
	public void setLstSucursal(List<AcSucursal> lstSucursal) {
		this.lstSucursal = lstSucursal;
	}

	/**
	 * @return the lstHrEmpleadoReclutamiento
	 */
	public List<DtoHrEmpleadoReclutamientoSelect> getLstHrEmpleadoReclutamiento() {
		return lstHrEmpleadoReclutamiento;
	}

	/**
	 * @param lstHrEmpleadoReclutamiento
	 *            the lstHrEmpleadoReclutamiento to set
	 */
	public void setLstHrEmpleadoReclutamiento(List<DtoHrEmpleadoReclutamientoSelect> lstHrEmpleadoReclutamiento) {
		this.lstHrEmpleadoReclutamiento = lstHrEmpleadoReclutamiento;
	}

	/**
	 * @return the dw_reqadicional
	 */
	public List<HrRequerimientoreemplazo> getDw_reqadicional() {
		return dw_reqadicional;
	}

	/**
	 * @param dw_reqadicional
	 *            the dw_reqadicional to set
	 */
	public void setDw_reqadicional(List<HrRequerimientoreemplazo> dw_reqadicional) {
		this.dw_reqadicional = dw_reqadicional;
	}

	/**
	 * @return the dw_funcionescas_det
	 */
	public List<HrRequerimientofuncasdet> getDw_funcionescas_det() {
		return dw_funcionescas_det;
	}

	/**
	 * @param dw_funcionescas_det
	 *            the dw_funcionescas_det to set
	 */
	public void setDw_funcionescas_det(List<HrRequerimientofuncasdet> dw_funcionescas_det) {
		this.dw_funcionescas_det = dw_funcionescas_det;
	}

	/**
	 * @return the dw_adicionales
	 */
	public HrRequerimientoobservacion getDw_adicionales() {
		return dw_adicionales;
	}

	/**
	 * @param dw_adicionales
	 *            the dw_adicionales to set
	 */
	public void setDw_adicionales(HrRequerimientoobservacion dw_adicionales) {
		this.dw_adicionales = dw_adicionales;
	}

	/**
	 * @return the dw_funcionesprac
	 */
	public HrRequerimientofunprac getDw_funcionesprac() {
		return dw_funcionesprac;
	}

	/**
	 * @param dw_funcionesprac
	 *            the dw_funcionesprac to set
	 */
	public void setDw_funcionesprac(HrRequerimientofunprac dw_funcionesprac) {
		this.dw_funcionesprac = dw_funcionesprac;
	}

	/**
	 * @return the opciones
	 */
	public OWHrRequerimientoEdit getOpciones() {
		return opciones;
	}

	/**
	 * @param opciones
	 *            the opciones to set
	 */
	public void setOpciones(OWHrRequerimientoEdit opciones) {
		this.opciones = opciones;
	}

	/**
	 * @return the ivKeyRequerimiento
	 */
	public HashMap<String, Object> getIvKeyRequerimiento() {
		return ivKeyRequerimiento;
	}

	/**
	 * @param ivKeyRequerimiento
	 *            the ivKeyRequerimiento to set
	 */
	public void setIvKeyRequerimiento(HashMap<String, Object> ivKeyRequerimiento) {
		this.ivKeyRequerimiento = ivKeyRequerimiento;
	}

	/**
	 * @return the dw_funcionescas
	 */
	public List<HrRequerimientofuncas> getDw_funcionescas() {
		return dw_funcionescas;
	}

	/**
	 * @param dw_funcionescas
	 *            the dw_funcionescas to set
	 */
	public void setDw_funcionescas(List<HrRequerimientofuncas> dw_funcionescas) {
		this.dw_funcionescas = dw_funcionescas;
	}

	/**
	 * @return the dw_reqadicionallist
	 */
	public ListDataModel<HrRequerimientoreemplazo> getDw_reqadicionallist() {
		return dw_reqadicionallist;
	}

	/**
	 * @param dw_reqadicionallist
	 *            the dw_reqadicionallist to set
	 */
	public void setDw_reqadicionallist(ListDataModel<HrRequerimientoreemplazo> dw_reqadicionallist) {
		this.dw_reqadicionallist = dw_reqadicionallist;
	}

	/**
	 * @return the dw_reqadicionalregistro
	 */
	public HrRequerimientoreemplazo getDw_reqadicionalregistro() {
		return dw_reqadicionalregistro;
	}

	/**
	 * @param dw_reqadicionalregistro
	 *            the dw_reqadicionalregistro to set
	 */
	public void setDw_reqadicionalregistro(HrRequerimientoreemplazo dw_reqadicionalregistro) {
		this.dw_reqadicionalregistro = dw_reqadicionalregistro;
	}

	/**
	 * @return the lstMotivoCese
	 */
	public List<HrMotivocese> getLstMotivoCese() {
		return lstMotivoCese;
	}

	/**
	 * @param lstMotivoCese
	 *            the lstMotivoCese to set
	 */
	public void setLstMotivoCese(List<HrMotivocese> lstMotivoCese) {
		this.lstMotivoCese = lstMotivoCese;
	}

	/**
	 * @return the dw_funcionescasregistro
	 */
	public HrRequerimientofuncas getDw_funcionescasregistro() {
		return dw_funcionescasregistro;
	}

	/**
	 * @param dw_funcionescasregistro
	 *            the dw_funcionescasregistro to set
	 */
	public void setDw_funcionescasregistro(HrRequerimientofuncas dw_funcionescasregistro) {
		this.dw_funcionescasregistro = dw_funcionescasregistro;
	}

	/**
	 * @return the dw_funcionescasdetregistro
	 */
	public HrRequerimientofuncasdet getDw_funcionescasdetregistro() {
		return dw_funcionescasdetregistro;
	}

	/**
	 * @param dw_funcionescasdetregistro
	 *            the dw_funcionescasdetregistro to set
	 */
	public void setDw_funcionescasdetregistro(HrRequerimientofuncasdet dw_funcionescasdetregistro) {
		this.dw_funcionescasdetregistro = dw_funcionescasdetregistro;
	}

	/**
	 * @return the lstTipoTrabajador
	 */
	public List<HrTipotrabajador> getLstTipoTrabajador() {
		return lstTipoTrabajador;
	}

	/**
	 * @param lstTipoTrabajador
	 *            the lstTipoTrabajador to set
	 */
	public void setLstTipoTrabajador(List<HrTipotrabajador> lstTipoTrabajador) {
		this.lstTipoTrabajador = lstTipoTrabajador;
	}

	/**
	 * @return the destinatariosEnvioCorreo
	 */
	public String getDestinatariosEnvioCorreo() {
		return destinatariosEnvioCorreo;
	}

	/**
	 * @param destinatariosEnvioCorreo
	 *            the destinatariosEnvioCorreo to set
	 */
	public void setDestinatariosEnvioCorreo(String destinatariosEnvioCorreo) {
		this.destinatariosEnvioCorreo = destinatariosEnvioCorreo;
	}

	/**
	 * @return the lstTipoHorario
	 */
	public List<AsTipohorario> getLstTipoHorario() {
		return lstTipoHorario;
	}

	/**
	 * @param lstTipoHorario
	 *            the lstTipoHorario to set
	 */
	public void setLstTipoHorario(List<AsTipohorario> lstTipoHorario) {
		this.lstTipoHorario = lstTipoHorario;
	}

	public List<HrRequerimientoAdjunto> getLstArchivosAdjuntos() {
		return lstArchivosAdjuntos;
	}

	public void setLstArchivosAdjuntos(List<HrRequerimientoAdjunto> lstArchivosAdjuntos) {
		this.lstArchivosAdjuntos = lstArchivosAdjuntos;
	}

	public UploadedFile getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(UploadedFile fileUpload) {
		this.fileUpload = fileUpload;
	}

	public HrRequerimientoAdjunto getBean() {
		return bean;
	}

	public void setBean(HrRequerimientoAdjunto bean) {
		this.bean = bean;
	}

	public HrRequerimientoAdjunto getArchivoSeleccionado() {
		return archivoSeleccionado;
	}

	public void setArchivoSeleccionado(HrRequerimientoAdjunto archivoSeleccionado) {
		this.archivoSeleccionado = archivoSeleccionado;
	}

	public Boolean getMostrarReporte() {
		return mostrarReporte;
	}

	public void setMostrarReporte(Boolean mostrarReporte) {
		this.mostrarReporte = mostrarReporte;
	}

	public List<DtoMetaPresupuestal> getLstMetas() {
		return lstMetas;
	}

	public void setLstMetas(List<DtoMetaPresupuestal> lstMetas) {
		this.lstMetas = lstMetas;
	}

	public Boolean getIsrequiereperiodoprueba() {
		return isrequiereperiodoprueba;
	}

	public void setIsrequiereperiodoprueba(Boolean isrequiereperiodoprueba) {
		this.isrequiereperiodoprueba = isrequiereperiodoprueba;
	}

	public List<PrFuentefinanciamiento> getFuentesFinanciamiento() {
		return fuentesFinanciamiento;
	}

	public void setFuentesFinanciamiento(List<PrFuentefinanciamiento> fuentesFinanciamiento) {
		this.fuentesFinanciamiento = fuentesFinanciamiento;
	}

	public Boolean getMostrarEnviar() {
		return mostrarEnviar;
	}

	public void setMostrarEnviar(Boolean mostrarEnviar) {
		this.mostrarEnviar = mostrarEnviar;
	}

	public Boolean getAccionEnvio() {
		return accionEnvio;
	}

	public void setAccionEnvio(Boolean accionEnvio) {
		this.accionEnvio = accionEnvio;
	}

	public List<DtoHrRequerimientoSeguimiento> getDw_reqseguimientolist() {
		return dw_reqseguimientolist;
	}

	public void setDw_reqseguimientolist(List<DtoHrRequerimientoSeguimiento> dw_reqseguimientolist) {
		this.dw_reqseguimientolist = dw_reqseguimientolist;
	}

}
