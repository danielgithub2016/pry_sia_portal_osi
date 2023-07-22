package net.royal.asistencia.vista.controladora;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;

import org.primefaces.event.SelectEvent;

import net.royal.alfresco.ws.ContenidoECMBean;
import net.royal.alfresco.ws.RptaWsBean;
import net.royal.asistencia.vista.opciones.OwAsAutorizacionPreprocesoHextraEdit;
import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CComunSession;
import net.royal.comun.vista.controladora.Constante;
import net.royal.erp.asistencia.ascommon.dominio.dto.DtoDwAsEventoUseridActivo;
import net.royal.erp.asistencia.ascommon.dominio.dto.DtoWAsAutorizacionHorasDisponibles;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAsistenciaCompensacionEdit;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAsistenciaHextraEdit;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAutorizacionPreprocesoHextra;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAutorizacionPreprocesoHextraeditV2;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAutorizacionPreprocesoOrdenes;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAutorizacionPreprocesoTipodia;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsMarcasEmpleado;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwCambioHorarioExcepcion;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwMaPrCalendarioferiadosProcesoSarg;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDddwAsConceptoaccesoSelectPre;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDddwAsEmpleadosmastSelectCarnets;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDddwAsTempusTerminal;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDddwAsTipodiaasistenciaSelect;
import net.royal.erp.asistencia.asoracle.dominio.dto.DtoDddwAsTipohorarioSelect;
import net.royal.erp.asistencia.asoracle.dominio.dto.DtoDwAsEmpleadoSelectMultiple;
import net.royal.erp.asistencia.asoracle.dominio.dto.DtoDwFiltroTerminal;
import net.royal.erp.asistencia.dominio.AsArea;
import net.royal.erp.asistencia.dominio.AsAutorizacion;
import net.royal.erp.asistencia.dominio.AsAutorizacionPk;
import net.royal.erp.asistencia.dominio.AsAutorizacionfecha;
import net.royal.erp.asistencia.dominio.AsCarnetidentificacion;
import net.royal.erp.asistencia.dominio.AsConceptoacceso;
import net.royal.erp.asistencia.dominio.AsConceptoaccesoPk;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcion;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcionPk;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepciondetalle;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepciondetallePk;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcionsolicitud;
import net.royal.erp.asistencia.dominio.AsEvento;
import net.royal.erp.asistencia.dominio.dto.DtoAsAutorizacion;
import net.royal.erp.asistencia.dominio.dto.DtoAsConceptoacceso;
import net.royal.erp.asistencia.dominio.dto.DtoAsTipodiamovimiento;
import net.royal.erp.asistencia.dominio.dto.DtoPermisosEnCompensacion;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.EmpleadomastPk;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.core.dominio.Personamast;
import net.royal.erp.core.dominio.PersonamastPk;
import net.royal.erp.planilla.dominio.PrProcesoperiodo;
import net.royal.erp.planilla.dominio.PrVacacionesprogramadas;
import net.royal.erp.planilla.dominio.dto.DtoPrVacacionPeriodo;
import net.royal.erp.sistema.dominio.dto.DtoDwWhDocumentoarchivoList;
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
import net.royal.seguridad.constante.ConstanteSeguridad;
import net.royal.seguridad.dominio.Seguridadperfilusuario;
import net.royal.seguridad.dominio.Usuario;
import net.royal.seguridad.dominio.UsuarioPk;
import pe.gob.oefa.ws.alfresco.service.UOsinergminAlfresco;

/*import net.royal.seguridad.correo.dominio.Correo;
 import net.royal.seguridad.correo.dominio.CorreoAdjunto;
 import net.royal.seguridad.correo.dominio.CorreoDestino;*/

@ManagedBean
@SessionScoped
public class CwAsAutorizacionPreprocesoHextraEdit extends CBaseBean implements UIMantenimientoController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String conceptoacceso, conceptoaccesooriginal;
	private Integer empleado;
	private Date fecha, fechaoriginal;
	private Date fechadesdeoriginal;

	private String conceptoOmisionMarcado, conceptoCambioHorario;
	private String conceptoPermanenciaMotivoPersonal, conceptoAutorizacionSobretiempo;

	private DtoDwAsAutorizacionPreprocesoHextraeditV2 dw_1;
	private List<DtoDddwAsEmpleadosmastSelectCarnets> dddw_as_empleadosmast_select_carnets;
	private DtoDwFiltroTerminal dw_filtraterminal;
	private List<DtoDwAsMarcasEmpleado> dw_2;
	private List<DtoDwMaPrCalendarioferiadosProcesoSarg> dw_feriados;
	private List<DtoDddwAsTempusTerminal> an_terminal;

	private List<DtoDwAsAutorizacionPreprocesoOrdenes> dw_detail;
	private OwAsAutorizacionPreprocesoHextraEdit opciones;
	private List<DtoDddwAsConceptoaccesoSelectPre> dwc_ConceptoAcceso;
	private List<DtoDddwAsConceptoaccesoSelectPre> dwc_ConceptoAccesoFiltrado;
	private List<DtoDddwAsTipohorarioSelect> dwc_tipohorario;
	private Boolean ib_elimina;

	private List<DtoDwAsAsistenciaCompensacionEdit> dw_compensacion;
	private List<DtoDwAsAsistenciaHextraEdit> dw_diascompensados;
	private String conceptoSeleccionado;
	private String horasSumadas;
	private Boolean verHistorialVacaciones;
	private int diasLicPer;
	private Boolean flgDiaSiguiente;
	
	/**
	 * @return Boolean Permite continuar con el método validar(), decisión del
	 *         usuario.
	 */
	private Boolean validarfechas;

	// variables de validacion
	Date fechaval;
	String w_CategoriaAutorizacion;
	int ll_terminal;
	Boolean ib_esferiado;
	Integer filaencontrada = -1;
	String fechaparaferiado;
	Date fechafin;
	String ls_desde1, ls_hasta1;
	Date hasta;
	Integer empleadoval, count;
	String conceptoaccesoval;
	Date desde;
	Date ldt_tempd, ldt_temph;
	long ll_d_1, ll_h_1;
	long ll_d_2, ll_h_2;
	Integer ll_val_01, ll_val_02;
	Date ld_temporal;
	Date tl_desde, tl_hasta;
	String ls_EXPRESADOEN = null;
	Date ldt_horainicio = null, ldt_horafin = null;
	Integer w_tipodia;
	String ls_INTERVALOACCESO = null;
	Date ldt_desde_horario, ldt_hasta_horario;
	Date ldt_desde_ingreso, ldt_hasta_ingreso = null;
	String ls_FlagDiaAnt = "";

	Integer w_fila;
	String w_intervaloacceso;
	Date ld_hora_entrada_t1, ld_hora_salida_t1;
	String ls_similares, ls_similares_2 = null, ls_similares_3 = null, ls_similares_2_all = null, ls_similares_4 = null,
			ls_similares_5 = null, ls_similares_6 = null, ls_similares_7 = null, ls_similares_8 = null;

	Date fechafin2;
	Integer CampoHorasVisible;

	String Estado;

	Integer fila, filas;
	Integer year, veces = null;
	Date fechalicencia = null;
	Date ldt_fecha_hora_salida;
	Date ld_hora_salida_t;
	String w_mensaje;
	Integer ll_find;
	private String w_tipocontrato;
	private Integer ll_horasprac;
	private Date w_horainicio;
	private Date w_horafin;

	private BigDecimal w_diftiempo;
	// private BigDecimal horasSeleccionadas;

	private BigDecimal w_ttotal;
	private Integer w_count;

	// variables de validacion fin

	private DtoWAsAutorizacionHorasDisponibles dw_horas;
	private List<DtoDwCambioHorarioExcepcion> dw_horario;
	private DtoDwCambioHorarioExcepcion dw_horarioregistro;

	private List<DtoDddwAsTipodiaasistenciaSelect> lstTipoDia;

	private BigDecimal totalhorastrabajo;
	private BigDecimal totalhorasrefrigerio;
	private BigDecimal totalhorashorario;

	private String totalhorastrabajodescripcion;
	private String totalhorasrefrigeriodescripcion;
	private String totalhorashorariodescripcion;

	private String iv_tipoautorizacion;

	private List<DtoDwAsEventoUseridActivo> dw_eventos;

	private Boolean enviarCorreo;

	private String accion;

	private Boolean ishorariodiasiguiente;

	private String mensajelicencia;

	private String key;
	private String ws;

	private BigDecimal totalsaldoactual;
	private String totalsaldoactualhor;

	// listado de licencias sin goce
	private List<DtoAsAutorizacion> licencias;

	private Boolean iscambioonceptoevento;

	private Date fechainiOriginal, fechafinOriginal;

	private List<PrProcesoperiodo> lstPeriodosPlanilla;

	// mostrar datos de dia y hora
	private String diferenciaDia;
	private String diferenciaHora;

	private Date desdeGlobal;
	private Date hastaGlobal;

	private boolean blDeclaracionjurada;
	private boolean blVerDeclaracionjurada;

	private Date fechaRecuperacionIni;
	private Date fechaRecuperacionFin;
	private BigDecimal diascompensa;

	/*
	 * objectstartevent
	 */
	@Override
	public String iniciarControladora() throws Exception {
		// TODO Auto-generated method stub
		validarfechas = false;
		ib_elimina = false;
		verHistorialVacaciones = false;
		flgDiaSiguiente = false;

		dw_diascompensados = new ArrayList<>();

		accion = CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from();

		if (UValidador.esNulo(dw_1)) {
			dw_1 = new DtoDwAsAutorizacionPreprocesoHextraeditV2();
		}

		dw_filtraterminal = new DtoDwFiltroTerminal();
		dw_horario = new ArrayList<>();
		dw_horarioregistro = new DtoDwCambioHorarioExcepcion();
		dwc_ConceptoAcceso = new ArrayList<>();
		dwc_ConceptoAccesoFiltrado = new ArrayList<DtoDddwAsConceptoaccesoSelectPre>();
		opciones = new OwAsAutorizacionPreprocesoHextraEdit(true, true, true, true, true, true, true, true, true, true,
				true, true, true, true, true, false, true, true, true, true, true, true, true, false, false, false,
				false, false, false, false);
		opciones.setIshabilitarlugar(true);
		opciones.setIsmostrarDesdeRecupera(false);
		opciones.setIsmostrarHastaRecupera(false);
		opciones.setIsmostrarPeriodoPlanilla(false);
		opciones.setIsmostrarAutorizaRecupera(false);

		inicializarFiltrosListado();

		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
			fechainiOriginal = null;
			fechafinOriginal = null;
			nuevo();
		}
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
			fechainiOriginal = dw_1.getFecha();
			fechafinOriginal = dw_1.getFechafin();
			editar();
		}
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Browse")) {
			opciones.setIshabilitarok(false);
			opciones.setIshabilitarconcepto(false);
			opciones.setIshabilitarfecha(false);
			opciones.setIshabilitarfechafin(false);
			opciones.setIshabilitardesde1(false);
			opciones.setIshabilitarhasta1(false);
			opciones.setIshabilitarobservaciones(false);
			opciones.setIshabilitarnroresolucion(false);
			opciones.setIshabilitarverarchivo(false);
			opciones.setIsmostrarcbinsertar(false);
			opciones.setIsmostrarcbeliminar(false);
			opciones.setIshabilitarlugar(false);
			editar();
			setPantallaTituloReferente("Ver");
		}

		if (!UValidador.esNulo(dw_1)) {
			fechaoriginal = dw_1.getFecha();
			fechadesdeoriginal = dw_1.getDesde1();
			conceptoaccesooriginal = dw_1.getConceptoacceso();
		} else {
			return null;
		}

		conceptoOmisionMarcado = getFacCore().getParametrosmastServicio()
				.obtenerValorCadena(new ParametrosmastPk("AS", "999999", "CONCOMIMAR"));

		conceptoCambioHorario = getFacCore().getParametrosmastServicio()
				.obtenerValorCadena(new ParametrosmastPk("AS", "999999", "CONCCAMHOR"));

		conceptoPermanenciaMotivoPersonal = getFacCore().getParametrosmastServicio()
				.obtenerValorCadena(new ParametrosmastPk("AS", "999999", "CONPERMPMP"));

		conceptoAutorizacionSobretiempo = getFacCore().getParametrosmastServicio()
				.obtenerValorCadena(new ParametrosmastPk("AS", "999999", "CONCAUTSOB"));

		// Terminal
		dw_filtraterminal.setAllterminal("N");
		opciones.setIshabilitarterminal(true);

		// Es SYSADM //ROYAL
		if (getFacSeguridad().getSeguridadautorizacionesServicio()
				.tieneAccesoSysAdm(getUsuarioActual().getAplicacionCodigo(), getUsuarioActual().getCodigoUsuario())) {
			opciones.setIshabilitarempleado(true);
			opciones.setIshabilitarempleadodescripcion(true);
		}

		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
			if (dw_1.getEstado().equals("A") || dw_1.getEstado().equals("P")) {
				opciones.setIshabilitarcb1(false);
				opciones.setIshabilitardweventos(false);
				opciones.setIshabilitardesde1(false);
				opciones.setIshabilitarhasta1(false);
				opciones.setIshabilitarcomportamiento(false);
				opciones.setIshabilitarfecha(false);
				opciones.setIshabilitarfechafin(false);
				opciones.setIshabilitarobservaciones(false);
				opciones.setIshabilitarconcepto(false);
			}
		}

		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
			opciones.setIshabilitarcb1(false);
			opciones.setIshabilitarempleado(true);

			if (dw_1.getFecha().before(new Date()) && dw_1.getEstado().equals("S") || dw_1.getEstado().equals("R")) {
				// opciones.setIshabilitarfecha(false);
				ib_elimina = false;
			}

			if (dw_1.getConceptoacceso().equals("CHOR")) {
				opciones.setIshabilitarfechafin(false);
			}

			if (dw_1.getConceptoacceso().equals("02")) {
				opciones.setIshabilitarfechafin(true);
			}

			// REQ ANGELA: EL ADMINISTRADOR PUEDE CAMBIAR LOS HORARIOS O
			// CUALQUIER USUARIO SI EL CAMBIO DE HORARIO NO SE REGISTRO ANTES DE
			// LA FECHA ACTUAL
			if (getFacSeguridad().getSeguridadautorizacionesServicio()
					.tieneAccesoSysAdm(getUsuarioActual().getAplicacionCodigo(), getUsuarioActual().getCodigoUsuario())
					|| !(UFechaHora.obtenerFechaHoraInicioDiaDate(dw_1.getFecha())
							.before(UFechaHora.obtenerFechaHoraInicioDiaDate(new Date())))) {
				opciones.setIshabilitarfecha(true);
				opciones.setIshabilitarfechafin(true);
			}
			if (dw_1.getEstado().equals("A")) {
				opciones.setIshabilitarfecha(false);
				opciones.setIshabilitarfechafin(false);
			}
		}

		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
			if (!UValidador.esListaVacia(dw_detail)) {
				dw_detail.remove(0);
			}
			opciones.setIsmostrardwhorario(false);
		}

		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Delete")) {
			ib_elimina = true;
			eliminar();
		}

		// **************************************************************

		cargarEventos();

		if (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
			// obtenemos las horas compensadas
			if (dw_1.getCategoriaautorizacion().equals("COMP")) {
				List data = getFacAsistencia().getAS().getAsmainDatawindow()
						.DwAsAsistenciaHextraEditModif(dw_1.getEmpleado(), dw_1.getFecha());

				dw_diascompensados = data;

				// para setear la seleccion en true
				if (!UValidador.esListaVacia(dw_diascompensados)) {
					for (DtoDwAsAsistenciaHextraEdit objmod : dw_diascompensados) {
						objmod.setCantidadhor(obtenerHorasAcumuladas(objmod.getCantidadreal()));
						objmod.setCompensadohor(obtenerHorasAcumuladas(objmod.getCantidad()));
						objmod.setDiferenciahor(obtenerHorasAcumuladas(objmod.getDiferencia()));
						if (objmod.getSeleccion().equals(UConstante.CONSTANTE_OPCION_SI)) {
							objmod.setIsseleccionado(true);
						}
					}
				}
				opciones.setIsmostrardiascompensados(true);
			}
		}

		if (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
			// mostrar el evento si es que no tiene acceso
			// la solicitud no podrá cambiar el evento
			Boolean existe = false;
			if (!UValidador.esListaVacia(dw_eventos)) {
				for (DtoDwAsEventoUseridActivo obj : dw_eventos) {
					if (obj.getConceptoacceso().equals(dw_1.getCategoriaautorizacion())) {
						existe = true;
						// if es OMI2 lo mostramos
						if ("OMI2".equals(dw_1.getConceptoacceso())) {
							obj.setNombrelargo("Marcación por Aplicativo");
						}

						break;
					}
				}
			}
			if (!existe) {
				AsEvento objne = getFacAsistencia().getAsEventoServicio()
						.listarPorConceptoAcceso(dw_1.getCategoriaautorizacion());

				if (!UValidador.esNulo(objne)) {
					DtoDwAsEventoUseridActivo nuevo = new DtoDwAsEventoUseridActivo();
					nuevo.setConceptoacceso(objne.getConceptoacceso());
					nuevo.setIdevento(BigDecimal.valueOf(objne.getPk().getIdevento()));
					nuevo.setOrden(BigDecimal.valueOf(objne.getOrden()));
					nuevo.setNombrelargo(objne.getNombreLargo());
					nuevo.setEstado(objne.getEstado());

					dw_eventos.add(0, nuevo);

					opciones.setIshabilitardweventos(false);
				}

			}

		}

		dw_2 = new ArrayList<DtoDwAsMarcasEmpleado>();
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void cargarEventos() {
		// TODO Auto-generated method stub
		Integer[] iv_estado = new Integer[2];
		// Integer ll_maxid = getFacAsistencia().getAsEventousuarioServicio()
		// .obtenerMaximoIdEvento(getUsuarioActual().getCodigoUsuario());
		// Boolean isadmin =
		// getFacSeguridad().getSeguridadautorizacionesServicio()
		// .tieneAccesoSysAdm(getUsuarioActual().getAplicacionCodigo(),
		// getUsuarioActual().getCodigoUsuario());

		// Boolean isreponsablearea = false;

		// Si el empleado es jefe de area o administrador cargamos sus datos por
		// separado y no como filtro.
		// AsArea area = getFacAsistencia().getAsAreaServicio()
		// .obtenerAreaEmpleadoResponsable(getUsuarioActual().getIdPersona());
		// if (!UValidador.esNulo(area)) {
		// isreponsablearea = true;
		// }

		// if (UValidador.esNulo(ll_maxid)) {
		// ll_maxid = 0;
		// }
		//
		// if (ll_maxid.equals(9999)) {
		// iv_estado[0] = 1;
		// iv_estado[1] = 0;
		// } else if (!isadmin) {
		// iv_estado[0] = 1;
		// iv_estado[1] = 7;
		// } else {
		iv_estado[0] = 1;
		iv_estado[1] = 0;
		// }

		// TODO ObtenerEventos
		dw_eventos = new ArrayList<DtoDwAsEventoUseridActivo>();
		List data = getFacAsistencia().getAS().getAscommonDatawindow()
				.DwAsEventoUseridActivo(getUsuarioActual().getCodigoUsuario(), iv_estado);
		if (!UValidador.esListaVacia(data)) {
			dw_eventos = data;
		}

		if (!UValidador.esListaVacia(dw_eventos)) {
			Integer indice = 0;
			for (DtoDwAsEventoUseridActivo obj : dw_eventos) {
				obj.setIndice(indice);
				indice++;
			}
		}

		// Si no es administrador ni jefe de area eliminamos la autorizacion de
		// sobretiempo.
		// if (!isadmin && !isreponsablearea) {
		// for (int i = 0; i < dw_eventos.size(); i++) {
		// DtoDwAsEventoUseridActivo obj = dw_eventos.get(i);
		// if (obj.getIdevento().intValue() == 2) {
		// dw_eventos.remove(i);
		// break;
		// }
		// }
		// }
	}

	@Override
	public String buscar() throws Exception {
		return null;
	}

	/*
	 * wf_setup_new()
	 */
	@Override
	public String nuevo() throws Exception {
		enviarCorreo = false;
		blDeclaracionjurada = false;
		// TODO Auto-generated method stub
		setPantallaTituloReferente("Agregar");
		dw_1.setEstado("S");
		dw_1.setEstadoai("S");

		if (CwAsAutorizacionPreprocesoAprobacion.getInstance().getFlagOrigenSolicitud().equals("A")) {
			dw_1.setEstado("A");
			dw_1.setEstadoai("A");
		}

		dw_1.setRefrigerio("S");
		dw_1.setMandatario("N");
		dw_1.setComportamientosobretiempo("C");
		dw_1.setSolicitadopor(getUsuarioActual().getLoginUsuario().toUpperCase());
		dw_1.setSolicitadopornombre(obtenerNombreUsuario(dw_1.getSolicitadopor()));
		dw_1.setFechasolicitud(new Date());
		dw_1.setFecha(new Date());
		dw_1.setFechafin(UFechaHora.obtenerFechaHoraFinDia(new Date()));
		dw_1.setDesde1(UFechaHora.obtenerFechaHoraInicioDiaDate(new Date()));
		dw_1.setHasta1(UFechaHora.obtenerFechaHoraInicioDiaDate(new Date()));

		diferenciaDia = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1 + "";
		keyhorainicio();
		return null;
	}

	@Override
	public String editar() throws Exception {
		// TODO Auto-generated method stub
		enviarCorreo = false;
		setPantallaTituloReferente("Modificar");
		diferenciaDia = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1 + "";
		keyhorainicio();
		return null;
	}

	@Override
	public String ver() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar() throws Exception {
		// TODO Auto-generated method stub
		setPantallaTituloReferente("Eliminar");
		opciones.setIshabilitarempleado(false);
		opciones.setIshabilitarcb1(false);
		opciones.setIshabilitarempleadodescripcion(false);
		opciones.setIshabilitardweventos(false);
		opciones.setIshabilitarfecha(false);
		opciones.setIshabilitarfechafin(false);
		opciones.setIshabilitardesde1(false);
		opciones.setIshabilitarhasta1(false);
		opciones.setIshabilitarcomportamiento(false);
		opciones.setIshabilitarobservaciones(false);
		opciones.setIshabilitarverarchivo(false);
		opciones.setIshabilitarnroresolucion(false);
		opciones.setIshabilitarconcepto(false);
		opciones.setIsmostrarcbinsertar(false);
		opciones.setIsmostrarcbeliminar(false);
		return null;
	}

	@Override
	public String inactivar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ejecutar(String accion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * objectstartevent w_master_edit
	 */
	@Override
	public String guardar() throws Exception {
		// TODO Auto-generated method stub
		Integer before_update_new = 1;
		Integer before_update = 1;

		// Si esta aprobado debe rechazar para poder modificar
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
			if (dw_1.getEstado().equals("A")) {
				setMessageError("No se puede Modificar en este estado. Debe Rechazar y generar una nueva Solicitud",
						null);
				return null;
			}
		}

		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Delete")) {
			try {
				if (UValidador.esCero(wf_update())) {
					return null;
				}
			} catch (Exception e) {
				setMessageError("No se pudo eliminar la papeleta");
				return null;
			}
		} else {
			// try {
			if (!validar()) {
				return null;
			}

			if (validarfechas) {
				return null;
			}

			if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
				before_update_new = wf_before_update_new();
			} else {
				before_update = wf_before_update();
			}

			if (before_update == 1 && before_update_new == 1) {
				if (UValidador.esCero(wf_update())) {
					return null;
				}
			}
			// } catch (Exception e) {
			// setMessageError("No se pudo grabar la papeleta");
			// return null;
			// }
		}

		if (UValidador.esNulo(enviarCorreo)) {
			enviarCorreo = false;
		}

		if (dw_1.getEstado().equals("S")
				&& (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")
						|| enviarCorreo)) {
			enviarCorreo();
		}

		enviarCorreo();

		if (!UValidador.esNulo(notificarlicenciasingoce())) {
			if (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Delete")) {
				if ("A".equals(dw_1.getEstado())) {
					setMessageSuccess("Se registró la autorización correctamente", true);
				}
				if ("S".equals(dw_1.getEstado())) {
					setMessageSuccess("Se registró la solicitud correctamente", true);
				}
			}
			CwAsAutorizacionPreprocesoAprobacion.getInstance().iniciarControladora();
			return "w_as_autorizacion_preproceso_aprobacion";
		}

		return null;

	}

	private String enviarCorreo() throws Exception {

		if (getFacSeguridad().getSeguridadautorizacionesServicio()
				.tieneAccesoSysAdm(getUsuarioActual().getAplicacionCodigo(), getUsuarioActual().getCodigoUsuario())) {
			return null;
		}

		String mensaje = "";
		String rutaCompleta = null;
		String colaborador = null;
		String concepto = null;
		List<CorreoDestinoCore> destinos = new ArrayList<>();
		String destinatarior1 = null;
		String destinatarior2 = null;
		String destinatarior3 = null;
		String destinatarior4 = null;
		String destinatario5 = null;
		String fechaini = null;
		String fechater = null;
		String mensajefecha = "";
		Integer diasresta = 0;
		String mensajehoras = "";
		String lugar = "";
		String mensajefechaprog = "";
		String mensajehorasprog = "";
		String mensajerazonrecupera = "";

		fechaini = UFechaHora.convertirFechaCadena(dw_1.getFecha(), "dd/MM/yyyy");
		fechater = UFechaHora.convertirFechaCadena(dw_1.getFechafin(), "dd/MM/yyyy");

		if ("VACA".equals(dw_1.getConceptoacceso()) || "ADEL".equals(dw_1.getConceptoacceso())
				|| "FRAD".equals(dw_1.getConceptoacceso())) {
			diasresta = UFechaHora.obtenerDiferenciaDias(dw_1.getFecha(), dw_1.getFechafin()) + 1;
		} else {
			diasresta = getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(dw_1.getFecha(), dw_1.getFechafin());
		}

		// SI ES CAMBIO DE HORARIO TOMAMOS LA PRIMERA Y ULTIMA FECHA
		if (!UValidador.esListaVacia(dw_horario)) {
			fechaini = UFechaHora.convertirFechaCadena(dw_horario.get(0).getFecha(), "dd/MM/yyyy");
			fechater = UFechaHora.convertirFechaCadena(dw_horario.get(dw_horario.size() - 1).getFecha(), "dd/MM/yyyy");
			diasresta = UFechaHora.obtenerDiferenciaDias(dw_horario.get(0).getFecha(),
					dw_horario.get(dw_horario.size() - 1).getFecha()) + 1;
		}

		mensajefecha = " desde el " + fechaini + " hasta el " + fechater;
		if (dw_1.getConceptoacceso().equals("OMIS")) {
			mensajefecha = " para el día " + fechaini;
		}

		if (!UValidador.esListaVacia(dw_horario)) {
			if (dw_horario.size() == 1) {
				mensajefecha = " para el día " + fechaini;
			}
		}

		if (UValidador.esCero(diasresta - 1)) {
			if (dw_1.getConceptoacceso().equals("OMIS")) {
				mensajehoras = ", a las " + UFechaHora.convertirFechaCadena(dw_1.getDesde1(), "HH:mm");
			} else {
				mensajehoras = ", de " + UFechaHora.convertirFechaCadena(dw_1.getDesde1(), "HH:mm") + " a "
						+ UFechaHora.convertirFechaCadena(dw_1.getHasta1(), "HH:mm");
			}

		} else {
			mensajehoras = "";
		}

		// Si es una compensacion de sobretiempo definimos el lugar
		if (dw_1.getCategoriaautorizacion().equals("SOBR")) {
			if (!UValidador.estaVacio(dw_1.getTipoautorizacion())) {
				if (dw_1.getTipoautorizacion().equals("D")) {
					lugar = "Lugar : DENTRO de la Institución.";
				}
				if (dw_1.getTipoautorizacion().equals("F")) {
					lugar = "Lugar : FUERA de la Institución.";
				}
			}
		}
		// DESTINATARIO
		// VERIFICAMOS SI EL EMPLEADO ES APROBADOR
		AsArea area = getFacAsistencia().getAsAreaServicio().obtenerArea(dw_1.getEmpleado(),
				getUsuarioActual().getCompaniaSocioCodigo());

		Boolean isresponsable = false;
		Integer empleado1 = 0;
		String flgempleado1 = "N";
		Integer empleado2 = 0;
		String flgempleado2 = "N";
		Integer empleado3 = 0;
		String flgempleado3 = "N";
		Integer empleado4 = 0;
		String flgempleado4 = "N";

		if (!UValidador.esNulo(area)) {

			// Verificamos si la papeleta es para un responsable.
			if (dw_1.getEmpleado().equals(area.getEmpleadoresponsable())
					|| dw_1.getEmpleado().equals(area.getEmpleadoresponsable2())
					|| dw_1.getEmpleado().equals(area.getEmpleadoresponsable3())
					|| dw_1.getEmpleado().equals(area.getEmpleadoresponsable4())) {
				isresponsable = true;
			}

			if (isresponsable) {
				// le envia correo a su aprobador y a los administradores
				if (dw_1.getEmpleado().equals(area.getEmpleadoresponsable())) {
					empleado1 = area.getEmpleadoaprobador();
					flgempleado1 = area.getFlagcorreoaprobador1();
				}
				if (dw_1.getEmpleado().equals(area.getEmpleadoresponsable2())) {
					empleado2 = area.getEmpleadoaprobador2();
					flgempleado2 = area.getFlagcorreoaprobador2();
				}
				if (dw_1.getEmpleado().equals(area.getEmpleadoresponsable3())) {
					empleado3 = area.getEmpleadoaprobador3();
					flgempleado3 = area.getFlagcorreoaprobador3();
				}
				if (dw_1.getEmpleado().equals(area.getEmpleadoresponsable4())) {
					empleado4 = area.getEmpleadoaprobador4();
					flgempleado4 = area.getFlagcorreoaprobador4();
				}
			} else {
				// le envia correo a todos los responsables
				empleado1 = area.getEmpleadoresponsable();
				flgempleado1 = area.getFlagcorreoresponsable1();
				empleado2 = area.getEmpleadoresponsable2();
				flgempleado2 = area.getFlagcorreoresponsable2();
				empleado3 = area.getEmpleadoresponsable3();
				flgempleado3 = area.getFlagcorreoresponsable3();
				empleado4 = area.getEmpleadoresponsable4();
				flgempleado4 = area.getFlagcorreoresponsable4();

			}

			// DESTINATARIO 1
			if (flgempleado1.equals(UConstante.CONSTANTE_OPCION_SI)) {
				Empleadomast emple1 = new Empleadomast();
				emple1.getPk().setEmpleado(empleado1);
				emple1.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
				emple1 = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(emple1.getPk());
				if (!UValidador.esNulo(emple1)) {
					destinatarior1 = emple1.getCorreointerno();
					LOGGER.debug("destinatario1 " + destinatarior1);
				}
			}

			// DESTINATARIO 2
			if (flgempleado2.equals(UConstante.CONSTANTE_OPCION_SI)) {
				Empleadomast emple2 = new Empleadomast();
				emple2.getPk().setEmpleado(empleado2);
				emple2.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
				emple2 = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(emple2.getPk());
				if (!UValidador.esNulo(emple2)) {
					destinatarior2 = emple2.getCorreointerno();
					LOGGER.debug("destinatario2 " + destinatarior2);
				}
			}

			// DESTINATARIO 3
			if (flgempleado3.equals(UConstante.CONSTANTE_OPCION_SI)) {
				Empleadomast emple3 = new Empleadomast();
				emple3.getPk().setEmpleado(empleado3);
				emple3.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
				emple3 = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(emple3.getPk());
				if (!UValidador.esNulo(emple3)) {
					destinatarior3 = emple3.getCorreointerno();
					LOGGER.debug("destinatario3 " + destinatarior3);
				}
			}

			// DESTINATARIO 4
			if (flgempleado4.equals(UConstante.CONSTANTE_OPCION_SI)) {
				Empleadomast emple4 = new Empleadomast();
				emple4.getPk().setEmpleado(empleado4);
				emple4.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
				emple4 = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(emple4.getPk());
				if (!UValidador.esNulo(emple4)) {
					destinatarior4 = emple4.getCorreointerno();
					LOGGER.debug("destinatario4 " + destinatarior4);
				}
			}
		}

		// DESTINATARIO EMPLEADO
		Empleadomast empleado = new Empleadomast();
		empleado.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
		empleado.getPk().setEmpleado(dw_1.getEmpleado().intValue());
		empleado = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(empleado.getPk());
		if (!UValidador.esNulo(empleado)) {
			destinatario5 = empleado.getCorreointerno();
			LOGGER.debug("destinatario " + destinatario5);
		}

		if (!UValidador.estaVacio(destinatarior1)) {
			destinos.add(new CorreoDestinoCore(destinatarior1));
		}
		if (!UValidador.estaVacio(destinatarior2)) {
			destinos.add(new CorreoDestinoCore(destinatarior2));
		}
		if (!UValidador.estaVacio(destinatarior3)) {
			destinos.add(new CorreoDestinoCore(destinatarior3));
		}
		if (!UValidador.estaVacio(destinatarior4)) {
			destinos.add(new CorreoDestinoCore(destinatarior4));
		}

		// Para concepto 34
		if ((dw_1.getConceptoacceso().equals("34")
				|| dw_1.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_LICENCIA_EXAMEN_ONCO))
				&& "A".equals(dw_1.getEstado())) {
			if (!UValidador.estaVacio(destinatario5)) {
				destinos.add(new CorreoDestinoCore(destinatario5));
			}
		}

		// EMPLEADO
		colaborador = getFacCore().getPersonamastServicio()
				.obtenerNombrePersona(BigDecimal.valueOf(dw_1.getEmpleado()));

		// CONCEPTO
		AsConceptoacceso obj = new AsConceptoacceso();
		obj.getPk().setConceptoacceso(dw_1.getConceptoacceso());
		obj = (AsConceptoacceso) getFacAsistencia().getAsConceptoaccesoServicio().obtenerPorId(obj.getPk());
		if (!UValidador.esNulo(obj)) {
			concepto = obj.getDescripcionlocal();
		}

		// Si es un concepto por resolucion 044 agregamos mensaje adicional;
		if ((dw_1.getConceptoacceso().equals("34")) && "A".equals(dw_1.getEstado())) {
			rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//solicitud_resolucion044.html");
			mensajehoras = " máximo " + obj.getNumerohorasmesesrestriccion() + " horas ";
			mensajefecha = " para el día " + UFechaHora.convertirFechaCadena(dw_1.getFecha(), "dd/MM/yyyy");
			mensajehorasprog = "" + obj.getCantidadminutosminimo() + " minutos ";
			mensajefechaprog = UFechaHora.convertirFechaCadena(dw_1.getDesderecupera(), "dd/MM/yyyy") + " hasta el día "
					+ UFechaHora.convertirFechaCadena(dw_1.getHastarecupera(), "dd/MM/yyyy");
		}
		if (dw_1.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_LICENCIA_EXAMEN_ONCO)
				&& "A".equals(dw_1.getEstado())) {
			rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//solicitud_leyoncologica.html");
			mensajehoras = " máximo " + obj.getNumerohorasmesesrestriccion() + " horas ";
			mensajefecha = " para el día " + UFechaHora.convertirFechaCadena(dw_1.getFecha(), "dd/MM/yyyy");
			mensajehorasprog = "" + obj.getCantidadminutosminimo() + " minutos ";
			mensajefechaprog = UFechaHora.convertirFechaCadena(dw_1.getDesderecupera(), "dd/MM/yyyy") + " hasta el día "
					+ UFechaHora.convertirFechaCadena(dw_1.getHastarecupera(), "dd/MM/yyyy");
		} else if ((dw_1.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_GESTION_PERSOSNAL)
				|| dw_1.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_AMOR_SALUD)
				|| dw_1.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_CONTROL_NINO)
				|| dw_1.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_MEJOR_MAMA)
				|| dw_1.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_MEJOR_PAPA)
				|| dw_1.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_RECIEN_CASADOS)
				|| dw_1.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_VIERNES_VERANO))) {
			if (dw_1.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_VIERNES_VERANO)) {
				mensajerazonrecupera = " a razón de 1 hora por día";
			}
			// se envía al empleado
			destinos.add(new CorreoDestinoCore(destinatario5));
			rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//solicitud_compensables.html");
			mensajefechaprog = UFechaHora.convertirFechaCadena(fechaRecuperacionIni, "dd/MM/yyyy") + " hasta el día "
					+ UFechaHora.convertirFechaCadena(fechaRecuperacionFin, "dd/MM/yyyy");
		} else {
			rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//solicitud_asistencia.html");
		}
		LOGGER.debug(rutaCompleta);
		mensaje = UFile.obtenerContenidoFile(rutaCompleta);
		LOGGER.debug(mensaje);
		mensaje = mensaje.replace("[EMPLEADO]", UString.cambiarCaracteresEspecialesHTML(colaborador));
		mensaje = mensaje.replace("[CONCEPTO]", UString.cambiarCaracteresEspecialesHTML(concepto));
		mensaje = mensaje.replace("[MENSAJE_FECHA]", UString.cambiarCaracteresEspecialesHTML(mensajefecha));
		mensaje = mensaje.replace("[MENSAJE_HORA]", UString.cambiarCaracteresEspecialesHTML(mensajehoras));
		mensaje = mensaje.replace("[LUGAR]", UString.cambiarCaracteresEspecialesHTML(lugar));
		mensaje = mensaje.replace("[DIFERENCIA_DIAS]",
				UString.cambiarCaracteresEspecialesHTML(UValidador.esCero(diasresta) ? "" : " Días: " + (diasresta)));
		mensaje = mensaje.replace("[MENSAJE_FECHA_PROG]", UString.cambiarCaracteresEspecialesHTML(mensajefechaprog));
		mensaje = mensaje.replace("[MENSAJE_HORA_PROG]", UString.cambiarCaracteresEspecialesHTML(mensajehorasprog));
		mensaje = mensaje.replace("[MENSAJE_1]",
				"Conforme a lo indicado en su solicitud y de acuerdo a lo indicado en el RIS, se aprueba su permiso de ");
		mensaje = mensaje.replace("[MENSAJE_2]",
				" asimismo se le indica que dichas horas serán compensadas desde el día ");
		mensaje = mensaje.replace("[MENSAJE_3]", " a razón de mínimo ");
		mensaje = mensaje.replace("[MENSAJE_4]", mensajerazonrecupera);

		mensaje = mensaje.replace("[MENSAJE_5]",
				"Conforme a lo indicado en su solicitud y de acuerdo a la Ley N° 31479, se aprueba su licencia ");
		mensaje = mensaje.replace("[MENSAJE_6]",
				" asimismo se le indica que las ocho (08) horas serán compensadas desde el día ");

		// ENVIO
		Boolean isconfiguradocorreo = getFacSeguridad().getCorreoServicio().configurarCorreo();

		if (isconfiguradocorreo) {
			CorreoCore correo = new CorreoCore();
			correo.setListaCorreoDestino(destinos);
			correo.setAsunto("Solicitud de Asistencia");
			correo.setCuerpoCorreo(mensaje.getBytes());

			if (!UValidador.esListaVacia(destinos)) {
				getFacSeguridad().getCorreoServicio().enviarCorreo(correo);
			}
		}
		return null;
	}

	private Integer wf_update() throws Exception {
		Boolean w_primero = false;
		Date w_fecha_autorizacion;
		Integer w_empleado = null, w_TipoHorario;
		Date w_fecha = null, w_fechafin, w_desde1, w_hasta1;
		String w_refrigerio, w_periodo, w_mandatorio, w_observacion, w_autorizadopor = null, w_ultimousuario, w_ruta,
				w_resolucion;
		Date w_ultimafechamodif;
		String w_solicitadoPor;
		String w_estado, w_Corrido;
		String w_comportamientoSobretiempo;
		Date w_fechaSolicitud;
		String w_categoriaAutorizacion;
		Integer aprobadores[] = new Integer[1];
		Boolean existe = false;
		String aprobadopor, rechazadopor = null;
		Date fechaaprobacion, fecharechazo = null;
		Date ldt_desde = null, ldt_hasta = null;
		Date w_fecharesolucion = null;
		BigDecimal w_cantidad, w_cantidadreal, w_diferencia, w_resto;

		iv_tipoautorizacion = dw_1.getTipoautorizacion();

		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Delete")) {
			LOGGER.debug("dw_1.getDesde1()" + dw_1.getDesde1());
			getFacAsistencia().getAsAccesosdiariosServicio().eliminarAccesosDiarios(dw_1.getEmpleado(), dw_1.getFecha(),
					dw_1.getConceptoacceso(), dw_1.getDesde1());

			getFacAsistencia().getAsAutorizacionServicio().eliminarAutorizacion(dw_1.getEmpleado(), dw_1.getFecha(),
					dw_1.getConceptoacceso(), dw_1.getDesde1());

			getFacAsistencia().getAsAutorizacionServicio().eliminarAutorizacionFecha(dw_1.getEmpleado(),
					UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), dw_1.getDesde1()));

			getFacAsistencia().getAsEmpleadoexcepcionServicio().eliminarEmpleadoExcepcionSolicitud(dw_1.getEmpleado(),
					dw_1.getFecha());

			setMessageSuccess(getMessageProperty("generico_eliminar_varios"), true);

			eliminarAlfresco();

			return 1;

		} else {
			w_empleado = dw_1.getEmpleado();
			w_fecha = dw_1.getFecha();
			w_fechafin = dw_1.getFechafin();
			w_desde1 = dw_1.getDesde1();
			w_hasta1 = dw_1.getHasta1();
			w_categoriaAutorizacion = dw_1.getCategoriaautorizacion();

			if (w_categoriaAutorizacion.equals("OMIS")) {
				w_hasta1 = w_desde1;
				w_fechafin = w_fecha;
			}

			w_periodo = dw_1.getPeriodo();
			w_refrigerio = dw_1.getRefrigerio();
			w_mandatorio = dw_1.getMandatario();
			w_observacion = dw_1.getObservacion();
			w_fechaSolicitud = dw_1.getFechasolicitud();
			w_fecha_autorizacion = dw_1.getFechasolicitud();
			w_solicitadoPor = dw_1.getSolicitadopor();
			w_TipoHorario = dw_1.getTipohorario();
			w_ruta = dw_1.getRutadocumento();
			w_resolucion = dw_1.getNroresolucion();
			w_fecharesolucion = dw_1.getFecharesolucion();
			w_autorizadopor = dw_1.getAutorizadopor();

			w_ultimousuario = getUsuarioActual().getLoginUsuario().toUpperCase();
			w_ultimafechamodif = new Date();
			w_comportamientoSobretiempo = dw_1.getComportamientosobretiempo();
			w_estado = dw_1.getEstado();

			w_Corrido = dw_1.getCorrido();
			if (UValidador.estaVacio(w_Corrido)) {
				w_Corrido = "N";
			}

			aprobadores[0] = getFacAsistencia().getAsAreaServicio().obtenerEmpleadoResponsable(w_empleado);

			if (!UValidador.esNulo(w_desde1)) {
				w_primero = true;
			}

			if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
				AsAutorizacion objfind = new AsAutorizacion();
				objfind.getPk().setConceptoacceso(this.conceptoacceso);
				objfind.getPk().setDesde(w_desde1);
				objfind.getPk().setFecha(w_fecha);
				objfind.getPk().setEmpleado(BigDecimal.valueOf(w_empleado));

				objfind = (AsAutorizacion) getFacAsistencia().getAsAutorizacionServicio().obtenerPorId(objfind.getPk());

				if (!UValidador.esNulo(objfind)) {
					existe = true;
				}

				// evita guardar un registro modificado con los mismos datos de
				// uno ya existente
				if (existe && (!UValidador.esCero(this.fechaoriginal.compareTo(w_fecha))
						|| !UValidador.esCero(this.fechadesdeoriginal.compareTo(w_desde1))
						|| !this.conceptoaccesooriginal.equals(this.conceptoacceso))) {
					if (!dw_1.getConceptoacceso().equals("CHOR")) {
						setMessageError("Ya existe el registro");
						return 0;
					}
				}

				if (existe || !UValidador.esCero(this.fechaoriginal.compareTo(w_fecha))
						|| !UValidador.esCero(this.fechadesdeoriginal.compareTo(w_desde1))
						|| !this.conceptoaccesooriginal.equals(this.conceptoacceso)) {

					AsAutorizacionPk pkdel = new AsAutorizacionPk();
					pkdel.setConceptoacceso(this.conceptoaccesooriginal);
					pkdel.setDesde(this.fechadesdeoriginal);
					pkdel.setFecha(this.fechaoriginal);
					pkdel.setEmpleado(BigDecimal.valueOf(w_empleado));
					AsAutorizacion objdel = (AsAutorizacion) getFacAsistencia().getAsAutorizacionServicio()
							.obtenerPorId(pkdel, false);

					// En caso sea una compensación de sobretiempo, y se esté
					// modifcando por otro concepto, debemos eliminarlo.
					if (dw_1.getConceptoacceso().equals("04") || dw_1.getConceptoacceso().equals("05")) {
						getFacAsistencia().getAsAutorizacionServicio().eliminarAutorizacionFecha(dw_1.getEmpleado(),
								UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), this.fechadesdeoriginal));
					}

					if (!UValidador.esNulo(objdel)) {
						if (objdel.getSobretiempoposicion().equals("1")) {
							getFacAsistencia().getAsAutorizacionServicio().eliminar(objdel);
						}
					}

				}

				// INSERTAR AUTORIZACION
				AsAutorizacion objins = new AsAutorizacion();
				objins.getPk().setConceptoacceso(dw_1.getConceptoacceso());
				objins.getPk().setDesde(w_desde1);
				objins.getPk().setFecha(w_fecha);
				objins.getPk().setEmpleado(BigDecimal.valueOf(w_empleado));
				objins.setHasta(w_hasta1);
				objins.setRefrigerio(w_refrigerio);
				objins.setPeriodo(w_periodo);
				objins.setMandatorio(w_mandatorio);
				objins.setObservacion(w_observacion);
				objins.setSolicitadopor(w_solicitadoPor);
				objins.setFechasolicitud(w_fechaSolicitud);
				objins.setUltimoUsuario(w_ultimousuario);
				objins.setUltimaFechaModif(new Date());
				objins.setSobretiempoposicion("1");
				objins.setComportamientosobretiempo(w_comportamientoSobretiempo);
				objins.setEstado(w_estado);
				objins.setCategoriaautorizacion(w_categoriaAutorizacion);
				objins.setTipohorario(BigDecimal.valueOf(w_TipoHorario));
				objins.setFlagcorrido(w_Corrido);
				objins.setRutadocumento(w_ruta);
				objins.setTipoautorizacion(this.iv_tipoautorizacion);
				objins.setNroresolucion(w_resolucion);
				objins.setFecharesolucion(w_fecharesolucion);
				objins.setDesderecupera(dw_1.getDesderecupera());
				objins.setHastarecupera(dw_1.getHastarecupera());
				objins.setPeriodoplanilla(dw_1.getPeriodoplanilla());
				objins.setNombrearchivodj(dw_1.getNombrearchivodj());
				objins.setUuidalfresco(dw_1.getUuidalfresco());

				getFacAsistencia().getAsAutorizacionServicio().registrar(objins);

				// ACTUALIZAR AUTORIZACION
				if (w_primero) {

					AsAutorizacionPk pkupd = new AsAutorizacionPk();
					pkupd.setConceptoacceso(this.conceptoacceso);
					pkupd.setDesde(w_desde1);
					pkupd.setFecha(w_fecha);
					pkupd.setEmpleado(BigDecimal.valueOf(w_empleado));
					AsAutorizacion objupd = (AsAutorizacion) getFacAsistencia().getAsAutorizacionServicio()
							.obtenerPorId(pkupd, false);

					if (!UValidador.esNulo(objupd)) {

						objupd.setFechafin(w_fechafin);
						objupd.setHasta(w_hasta1);
						objupd.setRefrigerio(w_refrigerio);
						objupd.setPeriodo(w_periodo);
						objupd.setMandatorio(w_mandatorio);
						objupd.setTipohorario(BigDecimal.valueOf(w_TipoHorario));
						objupd.setObservacion(w_observacion);
						objupd.setUltimoUsuario(w_ultimousuario);
						objupd.setUltimaFechaModif(w_ultimafechamodif);
						objupd.setAutorizadopor(w_autorizadopor);
						objupd.setFechaautorizacion(w_fecha_autorizacion);
						objupd.setRutadocumento(w_ruta);
						objupd.setNroresolucion(w_resolucion);
						objupd.setFecharesolucion(w_fecharesolucion);
						objupd.setTipoautorizacion(iv_tipoautorizacion);
						objupd.setDesderecupera(dw_1.getDesderecupera());
						objupd.setHastarecupera(dw_1.getHastarecupera());
						objupd.setPeriodoplanilla(dw_1.getPeriodoplanilla());
						objupd.setNombrearchivodj(dw_1.getNombrearchivodj());

						getFacAsistencia().getAsAutorizacionServicio().actualizar(objupd);
					}

				}

			}

			if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {

				// Si ya existe la fecha, no insertar
				existe = false;
				AsAutorizacion objfind = new AsAutorizacion();
				objfind.getPk().setConceptoacceso(this.conceptoacceso);
				objfind.getPk().setDesde(w_desde1);
				objfind.getPk().setFecha(w_fecha);
				objfind.getPk().setEmpleado(BigDecimal.valueOf(w_empleado));

				objfind = (AsAutorizacion) getFacAsistencia().getAsAutorizacionServicio().obtenerPorId(objfind.getPk());

				if (!UValidador.esNulo(objfind)) {
					existe = true;
				}

				if (existe) {
					if (!dw_1.getConceptoacceso().equals("CHOR")) {
						setMessageError("Ya existe el registro");
						return 0;
					}
				}

				aprobadopor = getUsuarioActual().getLoginUsuario().toUpperCase();
				fechaaprobacion = w_fechaSolicitud;
				w_fecha_autorizacion = fechaaprobacion;

				if (dw_1.getEstadoai().equals("S")) {
					fechaaprobacion = null;
					fecharechazo = null;
					w_estado = "S";
					aprobadopor = "";
					rechazadopor = "";
					w_fecha_autorizacion = fechaaprobacion;
				} else if (dw_1.getEstadoai().equals("A")) {
					w_estado = "A";
				} else {
					w_estado = "A";
				}

				if (w_estado.equals("A") && w_categoriaAutorizacion.equals("OMIS")) {
					wf_Insertar_Marca(w_empleado, UFechaHora.obtenerFechaCompuesta(w_fecha, w_desde1), "");
				}

				if (w_primero) {
					if (this.conceptoacceso.equals("04") && w_categoriaAutorizacion.equals("COMP")) {
						@SuppressWarnings("rawtypes")
						List data = getFacAsistencia().getAS().getAsrepusFuncion()
								.FAsAutorizacionPreprocesoTipodia2(empleado, fecha);

						if (!UValidador.esListaVacia(data)) {
							ldt_desde = (Date) data.get(0);
							ldt_hasta = (Date) data.get(1);
						}

						if (!UValidador.esNulo(ldt_desde)) {
							w_desde1 = UFechaHora.obtenerFechaCompuesta(w_desde1, ldt_desde);
						}
						if (!UValidador.esNulo(ldt_hasta)) {
							w_hasta1 = UFechaHora.obtenerFechaCompuesta(w_hasta1, ldt_hasta);
						}
						if (!UValidador.esNulo(ldt_desde) && !UValidador.esNulo(ldt_hasta)) {
							if (w_desde1.after(w_hasta1)) {
								w_hasta1 = UFechaHora.obtenerFechaCompuesta(UFechaHora.obtenerFechaMasdias(w_hasta1, 1),
										w_hasta1);
							}
						}
					}

					AsAutorizacion registro = new AsAutorizacion();
					registro.getPk().setEmpleado(BigDecimal.valueOf(w_empleado));
					registro.getPk().setFecha(w_fecha);
					registro.getPk().setConceptoacceso(dw_1.getConceptoacceso());
					registro.getPk().setDesde(w_desde1);
					registro.setFechafin(w_fechafin);
					registro.setHasta(w_hasta1);
					registro.setRefrigerio(w_refrigerio);
					registro.setPeriodo(w_periodo);
					registro.setMandatorio(w_mandatorio);
					registro.setObservacion(w_observacion);
					registro.setSolicitadopor(w_solicitadoPor);
					registro.setFechasolicitud(w_fechaSolicitud);
					registro.setAutorizadopor(aprobadopor);
					registro.setFechaautorizacion(w_fecha_autorizacion);
					registro.setRechazadopor(rechazadopor);
					registro.setFecharechazo(fecharechazo);
					registro.setVisadopor(aprobadopor);
					registro.setFechavisado(fechaaprobacion);
					registro.setUltimoUsuario(w_ultimousuario);
					registro.setUltimaFechaModif(w_ultimafechamodif);
					registro.setSobretiempoposicion("1");
					registro.setEstado(w_estado);
					registro.setComportamientosobretiempo(w_comportamientoSobretiempo);
					registro.setCategoriaautorizacion(w_categoriaAutorizacion);
					registro.setTipohorario(BigDecimal.valueOf(UValidador.esNulo(w_TipoHorario) ? 0 : w_TipoHorario));
					registro.setFlagcorrido(w_Corrido);
					registro.setRutadocumento(w_ruta);
					registro.setNombrearchivodj(dw_1.getNombrearchivodj());
					registro.setTipoautorizacion(iv_tipoautorizacion);
					registro.setNroresolucion(w_resolucion);
					registro.setFecharesolucion(w_fecharesolucion);
					registro.setDesderecupera(dw_1.getDesderecupera());
					registro.setHastarecupera(dw_1.getHastarecupera());

					if (UConstante.CONSTANTE_CONCEPTO_GESTION_PERSOSNAL.equalsIgnoreCase(dw_1.getConceptoacceso())
							|| UConstante.CONSTANTE_CONCEPTO_AMOR_SALUD.equalsIgnoreCase(dw_1.getConceptoacceso())
							|| UConstante.CONSTANTE_CONCEPTO_CONTROL_NINO.equalsIgnoreCase(dw_1.getConceptoacceso())
							|| UConstante.CONSTANTE_CONCEPTO_MEJOR_MAMA.equalsIgnoreCase(dw_1.getConceptoacceso())
							|| UConstante.CONSTANTE_CONCEPTO_MEJOR_PAPA.equalsIgnoreCase(dw_1.getConceptoacceso())
							|| UConstante.CONSTANTE_CONCEPTO_RECIEN_CASADOS.equalsIgnoreCase(dw_1.getConceptoacceso())
							|| UConstante.CONSTANTE_CONCEPTO_TIEMPO_FAMILIA.equalsIgnoreCase(dw_1.getConceptoacceso())
							|| UConstante.CONSTANTE_CONCEPTO_VIERNES_VERANO
									.equalsIgnoreCase(dw_1.getConceptoacceso())) {

						if (UConstante.CONSTANTE_CONCEPTO_VIERNES_VERANO.equalsIgnoreCase(dw_1.getConceptoacceso())) {
							fechaRecuperacionIni = UFechaHora.anadirDiasAFechas(dw_1.getFecha(), 3);
							fechaRecuperacionFin = UFechaHora.anadirDiasAFechas(fechaRecuperacionIni, 3);
							registro.setDesderecupera(fechaRecuperacionIni);
							registro.setHastarecupera(fechaRecuperacionFin);
						} else {
							DtoPermisosEnCompensacion dtoPermisosEnCompensacion = obtenerPermisosCompensacion(
									dw_1.getEmpleado().intValue(), dw_1.getFechafin(), diascompensa.intValue());

							fechaRecuperacionIni = dtoPermisosEnCompensacion.getDesderecupera();
							fechaRecuperacionFin = dtoPermisosEnCompensacion.getHastarecupera();
							registro.setDesderecupera(fechaRecuperacionIni);
							registro.setHastarecupera(fechaRecuperacionFin);
						}
					}

					registro.setPeriodoplanilla(dw_1.getPeriodoplanilla());

					getFacAsistencia().getAsAutorizacionServicio().registrar(registro);

					// URA 18/08/2015 Insertando en la tabla de programación
					if (w_estado.equals("A") && this.conceptoacceso.equals("VACA")) {
						String w_periodovac;
						Integer w_ano;
						Integer w_dias;
						BigDecimal w_secuencia;

						w_periodovac = UFechaHora.obtenerFechaParte(w_fecha, "YY") + ""
								+ ((UFechaHora.obtenerFechaParte(w_fecha, "MM")) > 9
										? UFechaHora.obtenerFechaParte(w_fecha, "MM")
										: "0" + UFechaHora.obtenerFechaParte(w_fecha, "MM"));
						w_ano = UFechaHora.obtenerFechaParte(w_fecha, "YY");
						w_dias = UFechaHora.obtenerDiasTranscurridos(w_fechafin, w_fecha) + 1;

						w_secuencia = getFacPlanilla().getPrVacacionesprogramadasServicio()
								.obtenerMaximoVacacionesProgramadas(w_empleado, w_periodovac);
						if (UValidador.esNulo(w_secuencia)) {
							w_secuencia = BigDecimal.ONE;
						}

						// INSERTAMOS LAS VACACIONES PROGRAMADAS
						PrVacacionesprogramadas vacaciones = new PrVacacionesprogramadas();
						vacaciones.getPk().setNumeroperiodo(BigDecimal.valueOf(1));
						vacaciones.getPk().setEmpleado(BigDecimal.valueOf(w_empleado));
						vacaciones.getPk().setSecuencia(w_secuencia);
						vacaciones.getPk().setEstadovacacion(BigDecimal.ZERO);
						vacaciones.getPk().setPeriodo(w_periodovac);
						vacaciones.setDiaspago(w_dias);
						vacaciones.setFechainicio(w_fecha);
						vacaciones.setFechafin(w_fechafin);
						vacaciones.setEstado("A");
						vacaciones.setObservacionorigen("Programado desde Web");
						vacaciones.setAnovacacion(w_ano);
						vacaciones.setPeriodoasistencia(w_periodo);
						vacaciones.setTipoutilizacion("R");
						vacaciones.setUltimoUsuario(getUsuarioActual().getLoginUsuario().toUpperCase());
						vacaciones.setUltimaFechaModif(new Date());

						getFacPlanilla().getPrVacacionesprogramadasServicio().registrar(vacaciones);

					}
				}

			}

			// Grabando el BLOB en la base de datos
			if (!wf_actualiza_blob(w_empleado, w_fecha, this.conceptoacceso, w_desde1)) {
				return 0;
			}

			if (!wf_actualiza_blob_dj(w_empleado, w_fecha, this.conceptoacceso, w_desde1)) {
				return 0;
			}

			dwhorarioupdate();

			if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")
					|| CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
							.equalsIgnoreCase("Update")) {
				// Total de horas a Compensar
				w_horainicio = dw_1.getDesde1();
				w_horafin = dw_1.getHasta1();

				// Si la compensación es por día, tomamos la hora inicio y fin
				// del orario del empleado
				if ("04".equals(dw_1.getConceptoacceso())) {
					w_horainicio = this.desdeGlobal;
					w_horafin = this.hastaGlobal;
				}

				w_diftiempo = wf_diftiempo(w_horainicio, w_horafin).divide(BigDecimal.valueOf(3600), 2,
						BigDecimal.ROUND_HALF_UP);

				w_diftiempo = w_diftiempo.subtract(obtenerHorasRefrigerio());
				Integer diastrans = (UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1);

				w_diftiempo = w_diftiempo.multiply(new BigDecimal(diastrans)).setScale(2, BigDecimal.ROUND_HALF_UP);
				w_ttotal = w_diftiempo;

				// validar un posible nullpointerexception
				if (UValidador.esNulo(w_ttotal)) {
					w_ttotal = BigDecimal.ZERO;
				}

				if (!UValidador.esListaVacia(dw_diascompensados)) {
					for (DtoDwAsAsistenciaHextraEdit obj : dw_diascompensados) {
						LOGGER.debug("SELECCIONADO::" + obj.getIsseleccionado());

						if (obj.getIsseleccionado()) {
							// if (UValidador.esCero(w_ttotal.intValue())) {
							// break;
							// }

							if (w_ttotal.compareTo(BigDecimal.ZERO) == 0) {
								break;
							}

							w_fecha = obj.getFecha();
							w_fechafin = dw_1.getFecha();
							w_cantidad = obj.getCantidad();
							w_cantidadreal = obj.getDiferencia();
							w_diferencia = obj.getDiferencia();

							LOGGER.debug("w_fecha::" + w_fecha);
							LOGGER.debug("w_fechafin::" + w_fechafin);
							LOGGER.debug("w_cantidad::" + w_cantidad);
							LOGGER.debug("w_cantidadreal::" + w_cantidadreal);
							LOGGER.debug("w_diferencia::" + w_diferencia);

							LOGGER.debug("w_ttotal::" + w_ttotal);

							if (w_ttotal.compareTo(w_diferencia) == 1
									&& Math.abs((w_ttotal.subtract(w_diferencia)).doubleValue()) > 0.01) {
								w_ttotal = w_ttotal.subtract(w_diferencia);
								w_cantidad = w_diferencia;
								w_resto = BigDecimal.ZERO;
							} else {
								w_cantidad = w_ttotal;
								w_resto = w_diferencia.subtract(w_ttotal).setScale(2, BigDecimal.ROUND_HALF_UP);
								w_ttotal = BigDecimal.ZERO;
							}

							// insertamos la autorizacion fecha
							AsAutorizacionfecha objinsert = new AsAutorizacionfecha();
							objinsert.getPk().setEmpleado(dw_1.getEmpleado());
							objinsert.getPk().setFecha(w_fecha);
							objinsert.getPk().setFechasolicitud(w_fechafin);
							objinsert.getPk().setDesde(UFechaHora.obtenerFechaCompuesta(w_fechafin, dw_1.getDesde1()));
							objinsert.setHasta(UFechaHora.obtenerFechaCompuesta(dw_1.getFechafin(), dw_1.getHasta1()));
							objinsert.setCantidad(w_cantidad);
							objinsert.setCantidadreal(w_cantidadreal);
							objinsert.setDiferencia(w_resto);
							objinsert.setEstado(UConstante.CONSTANTE_ESTADO_ACTIVO);
							objinsert.setUltimoUsuario(getUsuarioActual().getCodigoUsuario());
							objinsert.setUltimaFechaModif(new Date());

							getFacAsistencia().getAsAutorizacionfechaServicio().registrar(objinsert);
						}
					}
				}

			}

			return 1;
		}

	}

	private void eliminarAlfresco() {
		// TODO Auto-generated method stub

		switch (obtenerParametroModoArchivo()) {
		case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

			if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
				this.setMessageError("No se encontraron los parametros key o ws");
				return;
			}

//			if (!UValidador.estaVacio(dw_1.getUuidalfresco())) {
//				try {
//					ContenidoECMBean respuestaconsulta = getuOsinergminAlfresco().obtenerDocumento(dw_1.getUuidalfresco());
//					LOGGER.debug(respuestaconsulta);
//					if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
//						LOGGER.debug("Se encontro el archivo");
//						getuOsinergminAlfresco().eliminarDocumento(dw_1.getUuidalfresco(), key);
//						LOGGER.debug("Se elimino el archivo");
//					}
//				} catch (Exception e) {
//					LOGGER.debug(e.getMessage());
//					this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
//					return;
//				}
//			}
		}
	}

	private BigDecimal wf_diftiempo(Date par_fechainicio, Date par_fechafin) {
		Integer w_segundos, w_dias;

		w_segundos = UFechaHora.obtenerSegundosTranscurridos(par_fechafin, par_fechainicio);
		w_dias = UFechaHora.obtenerDiasTranscurridos(par_fechafin, par_fechainicio);

		w_segundos = w_segundos + w_dias * 3600 * 24;

		return BigDecimal.valueOf(w_segundos);
	}

	private Integer dwhorarioupdate() throws Exception {

		// Eliminamos
		if (!UValidador.esListaVacia(dw_horario)) {

			// ELIMINAMOS
			List<AsEmpleadoexcepcionsolicitud> horarios = getFacAsistencia().getAsEmpleadoexcepcionsolicitudServicio()
					.listarEmpleadoExcepcionSolicitud(dw_horario.get(0).getEmpleado(),
							dw_horario.get(0).getFechasolicitud());

			if (!UValidador.esListaVacia(horarios)) {
				for (AsEmpleadoexcepcionsolicitud objdel : horarios) {
					getFacAsistencia().getAsEmpleadoexcepcionsolicitudServicio().eliminar(objdel);
				}
			}

			// INSERTAMOS
			for (DtoDwCambioHorarioExcepcion obj : dw_horario) {
				AsEmpleadoexcepcionsolicitud solicitud = new AsEmpleadoexcepcionsolicitud();
				solicitud.getPk().setEmpleado(obj.getEmpleado());
				solicitud.getPk().setFechasolicitud(UFechaHora
						.convertirCadenaFecha(UFechaHora.convertirFechaCadena(obj.getFechasolicitud()), "dd/MM/yyyy"));
				solicitud.getPk().setFecha(obj.getFecha());
				solicitud.getPk().setFechahasta(obj.getFechahasta());
				solicitud.setDescripcion(obj.getDescripcion());
				solicitud.setIntervaloacceso(obj.getIntervaloacceso());
				solicitud.setTipodia(obj.getTipodia().intValue());
				solicitud.setEstado(obj.getEstado());
				solicitud.setUltimoUsuario(getUsuarioActual().getLoginUsuario().toUpperCase());
				solicitud.setUltimaFechaModif(new Date());

				getFacAsistencia().getAsEmpleadoexcepcionsolicitudServicio().registrar(solicitud);
			}

		}

		if (CwAsAutorizacionPreprocesoAprobacion.getInstance().getFlagOrigenSolicitud().equals("A")
				&& dw_1.getEstado().equals("A")) {
			// aprobamos la solicitud en caso sea una autorizacion
			// para generar la excepxion en empleados
			guardarEmpleadoExcepcion();
		}

		return 0;
	}

	private boolean wf_actualiza_blob(Integer par_empleado, Date par_fecha, String par_concepto, Date par_desde) {

		AsAutorizacionPk pk = new AsAutorizacionPk();
		pk.setEmpleado(BigDecimal.valueOf(par_empleado));
		pk.setFecha(par_fecha);
		pk.setDesde(par_desde);
		pk.setConceptoacceso(par_concepto);

		AsAutorizacion registro = (AsAutorizacion) getFacAsistencia().getAsAutorizacionServicio().obtenerPorId(pk,
				false);

		if (!UValidador.esNulo(registro)) {
			// registro.setSustento(dw_requerimiento.getDocumento());
			switch (obtenerParametroModoArchivo()) {
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

				if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
					this.setMessageError("No se encontraron los parametros key o ws");
					return false;
				}

//				if (!UValidador.estaVacio(registro.getUuidalfresco())) {
//					try {
//						if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
//								.equalsIgnoreCase("Add")) {
//							ContenidoECMBean respuestaconsulta = getuOsinergminAlfresco()
//									.obtenerDocumento(registro.getUuidalfresco());
//							LOGGER.debug(respuestaconsulta);
//							if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
//								LOGGER.debug("Se encontro el archivo");
//								getuOsinergminAlfresco().eliminarDocumento(registro.getUuidalfresco(), key);
//								LOGGER.debug("Se elimino el archivo");
//							}
//						}
//					} catch (Exception e) {
//						LOGGER.debug(e.getMessage());
//						this.setMessageError(
//								"Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
//						return false;
//					}
//				}
				if (!UValidador.estaVacio(registro.getRutadocumento())) {
					try {
						LOGGER.debug("Archivo a guardar " + registro.getRutadocumento());
						RptaWsBean respuestaws = getuOsinergminAlfresco().registrarDocumento(registro.getRutadocumento(),
								getuOsinergminAlfresco().RUTA_ASISTENCIA + registro.getPk().getEmpleado() + "/" + "SUSTENTO",
								new File(dw_1.getRutacompleta()));
						LOGGER.debug(respuestaws);
						if (respuestaws.getCodMsg().equalsIgnoreCase("ok")) {
							// registro.setSustento(null);
							registro.setUuidalfresco(respuestaws.getUuid());
							getFacAsistencia().getAsAutorizacionServicio().actualizar(registro);
							return true;
						} else {
							this.setMessageError(respuestaws.getCadMsg());
							return false;
						}
					} catch (Exception e) {
						if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
								.equalsIgnoreCase("Add")) {
							eliminarPorErrorEnArchivo();
						}

						this.setMessageError(
								"Ocurrió un error al grabar el archivo. Por favor revisar el nombre del documento");
						return false;
					}
				}

			}

		} else {
			this.setMessageError("No se encontró la solicitud para actualizar el documento");
			return false;
		}

		return true;
	}

	private void eliminarPorErrorEnArchivo() {
		// TODO Auto-generated method stub
		getFacAsistencia().getAsAccesosdiariosServicio().eliminarAccesosDiarios(dw_1.getEmpleado(), dw_1.getFecha(),
				dw_1.getConceptoacceso(), dw_1.getDesde1());

		getFacAsistencia().getAsAutorizacionServicio().eliminarAutorizacion(dw_1.getEmpleado(), dw_1.getFecha(),
				dw_1.getConceptoacceso(), dw_1.getDesde1());

		getFacAsistencia().getAsAutorizacionServicio().eliminarAutorizacionFecha(dw_1.getEmpleado(),
				UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), dw_1.getDesde1()));

		getFacAsistencia().getAsEmpleadoexcepcionServicio().eliminarEmpleadoExcepcionSolicitud(dw_1.getEmpleado(),
				dw_1.getFecha());

	}

	private boolean wf_actualiza_blob_dj(Integer par_empleado, Date par_fecha, String par_concepto, Date par_desde) {

		AsAutorizacionPk pk = new AsAutorizacionPk();
		pk.setEmpleado(BigDecimal.valueOf(par_empleado));
		pk.setFecha(par_fecha);
		pk.setDesde(par_desde);
		pk.setConceptoacceso(par_concepto);

		AsAutorizacion registro = (AsAutorizacion) getFacAsistencia().getAsAutorizacionServicio().obtenerPorId(pk,
				false);

		if (!UValidador.esNulo(registro)) {
			// registro.setSustento(dw_requerimiento.getDocumento());
			switch (obtenerParametroModoArchivo()) {
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

				if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
					this.setMessageError("No se encontraron los parametros key o ws");
					return false;
				}

//				if (!UValidador.estaVacio(registro.getUuiddj())) {
//					try {
//						if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
//								.equalsIgnoreCase("Add")) {
//							ContenidoECMBean respuestaconsulta = getuOsinergminAlfresco().obtenerDocumento(registro.getUuiddj());
//							LOGGER.debug(respuestaconsulta);
//							if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
//								LOGGER.debug("Se encontro el archivo");
//								getuOsinergminAlfresco().eliminarDocumento(registro.getUuiddj(), key);
//								LOGGER.debug("Se elimino el archivo");
//							}
//						}
//					} catch (Exception e) {
//						LOGGER.debug(e.getMessage());
//						this.setMessageError(
//								"Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
//						return false;
//					}
//				}
				if (!UValidador.estaVacio(registro.getNombrearchivodj())) {
					try {
						RptaWsBean respuestaws = getuOsinergminAlfresco().registrarDocumento(registro.getNombrearchivodj(),
								getuOsinergminAlfresco().RUTA_ASISTENCIA + registro.getPk().getEmpleado() + "/" + "SUSTENTO_DJ",
								new File(dw_1.getRutacompletadj()));
						System.gc();
						LOGGER.debug(respuestaws);
						if (respuestaws.getCodMsg().equalsIgnoreCase("ok")) {
							// registro.setSustento(null);
							registro.setUuiddj(respuestaws.getUuid());
							getFacAsistencia().getAsAutorizacionServicio().actualizar(registro);
							return true;
						} else {
							this.setMessageError(respuestaws.getCadMsg());
							return false;
						}
					} catch (Exception e) {
						if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
								.equalsIgnoreCase("Add")) {
							eliminarPorErrorEnArchivo();
						}

						this.setMessageError(
								"Ocurrió un error al grabar el archivo. Por favor revisar el nombre del documento");
						return false;
					}
				}

			}

		} else {
			this.setMessageError("No se encontró la solicitud para actualizar el documento");
			return false;
		}
		return true;
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

	private void wf_Insertar_Marca(Integer par_empleado, Date par_fecha, String par_aprobador) {
		String carnet;
		Integer secuencia;
		Integer anio, mes, dia;
		String observacion;

		anio = UFechaHora.obtenerFechaParte(par_fecha, "YY");
		mes = UFechaHora.obtenerFechaParte(par_fecha, "MM");
		dia = UFechaHora.obtenerFechaParte(par_fecha, "DD");

		observacion = "Vía Autorización";

		secuencia = getFacAsistencia().getAsAccesosdiariosServicio().obtenerMaximoSecuencia(par_empleado, par_fecha);

		carnet = getFacAsistencia().getAsCarnetidentificacionServicio().obtenerMaximoCodigoCarnet(par_empleado);

		getFacAsistencia().getAsAccesosdiariosServicio().insertarAccesosDiarios(carnet, par_fecha, secuencia,
				par_empleado, observacion, anio, mes, dia, getUsuarioActual().getLoginUsuario().toUpperCase());
	}

	private Integer wf_before_update_new() {
		return 1;
	}

	private Integer wf_before_update() throws Exception {
		return 1;
	}

	@Override
	public String salir() throws Exception {
		// TODO Auto-generated method stub
		CwAsAutorizacionPreprocesoAprobacion.getInstance().iniciarControladora();
		return "wasautorizacionpreprocesoaprobacion";
	}

	// TODO SIGED validaciones SIGED
	private boolean validacionesSIGED() {

		Boolean retorno = true;

		if (dw_1.getCategoriaautorizacion().equals("PSIG")) {

			// validamos que no existe otros permisos con estos
			// datos en estado Solicitado

			if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
				count = getFacAsistencia().getAsAutorizacionServicio().contarPermisosSIGED(dw_1.getEmpleado(),
						dw_1.getConceptoacceso());
				if (count > 0) {
					setMessageError("Existen permisos en estado solicitado para este tipo de concepto.");

					retorno = false;
				}
			}

		}

		return retorno;
	}

	/*
	 * wf_validate()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Boolean validar() throws Exception {
		// TODO Auto-generated method stub

		ll_horasprac = 0;

		// la fecha fin debe tener la ultima hora del dia
		dw_1.setFechafin(UFechaHora.obtenerFechaHoraFinDia(dw_1.getFechafin()));

		dw_feriados = getFacAsistencia().getAS().getAsmainDatawindow().DwMaPrCalendarioferiadosProcesoSarg();

		w_CategoriaAutorizacion = dw_1.getCategoriaautorizacion();

		if (UValidador.esNulo(dw_1.getEmpleado())) {
			setMessageError("Primero debe seleccionar un empleado");
			return false;
		}

		if (UValidador.estaVacio(dw_1.getCategoriaautorizacion())) {
			setMessageError("Debe ingresar un evento");
			return false;
		}

		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")
				|| CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
						.equalsIgnoreCase("Update")) {

			Integer count = 0;

			if (getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
					getUsuarioActual().getAplicacionCodigo(), getUsuarioActual().getCodigoUsuario())) {
				// validamos el perodo activo
				count = getFacAsistencia().getAsPeriodoServicio().obtenerCantidadPorEmpleado(dw_1.getEmpleado(),
						dw_1.getFecha(), opciones.getIsmostrarfechafin() ? dw_1.getFechafin() : dw_1.getFecha());
			} else {
				count = getFacAsistencia().getAsPeriodoServicio().obtenerCantidadPorEmpleadoNoAdmin(dw_1.getEmpleado(),
						dw_1.getFecha(), opciones.getIsmostrarfechafin() ? dw_1.getFechafin() : dw_1.getFecha());
			}
			if (UValidador.esCero(count)) {
				setMessageError(
						"La autorización se produce en un periodo cerrado o no existe periodo declarado para el tipo de planilla del trabajador.");
				return false;
			}

			// validacion omision de marcado
			if (dw_1.getConceptoacceso().equals("OMIS")) {
				Integer maxPermitido = 0;

				maxPermitido = getFacCore().getParametrosmastServicio()
						.obtenerValorInteger(new ParametrosmastPk("AS", "999999", "NVECMAXOMI"));

				if (UValidador.esNulo(maxPermitido)) {
					maxPermitido = 0;
				}

				Integer cantOmision = getFacAsistencia().getAsAutorizacionServicio()
						.contarOmisionxMes(dw_1.getEmpleado(), dw_1.getFecha());

				if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
					if (cantOmision + 1 > maxPermitido) {
						setMessageError("La cantidad de veces de Omisión del Mes esta superando la cantidad máxima: "
								+ maxPermitido + "");
						return false;
					}
				}

				if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
						.equalsIgnoreCase("Update")) {
					// Puede darse el caso que a un registro se le cambie de
					// fecha
					if (dw_1.getFecha().getTime() != fechaoriginal.getTime()) {
						cantOmision = cantOmision + 1;
					}

					if (cantOmision > maxPermitido) {
						setMessageError("La cantidad de veces de Omisión del Mes esta superando la cantidad máxima: "
								+ maxPermitido + "");
						return false;
					}
				}
			}

			int cantmaxima = 0;
			int cantregistra = 0;
			int diasmax = 0;
			String flgCantidaddiasmaximo = "";

			for (DtoDddwAsConceptoaccesoSelectPre obj : dwc_ConceptoAcceso) {
				if (obj.getConceptoacceso().equals(dw_1.getConceptoacceso())) {
					cantmaxima = obj.getCantmaxanio().intValue();
					diasmax = obj.getCantidaddiasmaximo().intValue();
					flgCantidaddiasmaximo = obj.getFlagdiasmaximo();
					break;
				}
			}

			if ("S".equals(flgCantidaddiasmaximo) && diasmax < getFacAsistencia().getAS().getAsmainFuncion()
					.FDiasHabiles(dw_1.getFecha(), dw_1.getFechafin())) {
				setMessageError(
						"No puede generar esta papeleta por que no respeta la cantidad permitida de días: " + diasmax);
				return false;
			}

			if ("101".equals(dw_1.getConceptoacceso())) {
				cantregistra = getFacAsistencia().getAsAutorizacionServicio().contarCantidadDiasPorConcepto(
						dw_1.getEmpleado(), dw_1.getConceptoacceso(),
						UFechaHora.obtenerPrimerDiaAnioFecha(dw_1.getFecha()),
						UFechaHora.obtenerUltimoDiaAnioFecha(dw_1.getFechafin()), fechaoriginal);

				cantregistra = cantregistra + UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha())
						+ 1;

				if (cantregistra > diasmax) {
					setMessageError("No puede generar esta papeleta por que no respeta la cantidad permitida de días: "
							+ diasmax);
					return false;
				}
			}

			for (DtoDddwAsConceptoaccesoSelectPre obj : dwc_ConceptoAcceso) {
				if (obj.getConceptoacceso().equals(dw_1.getConceptoacceso())) {
					cantmaxima = obj.getCantmaxanio().intValue();
					break;
				}
			}
			// validamos que las papeletas generadas en el año sean
			// menor o igual a la cantidad máxima
			cantregistra = getFacAsistencia().getAsAutorizacionServicio().contarCantidadEnfechasPorConcepto(
					dw_1.getEmpleado(), dw_1.getConceptoacceso(), UFechaHora.obtenerPrimerDiaAnioFecha(dw_1.getFecha()),
					UFechaHora.obtenerUltimoDiaAnioFecha(dw_1.getFechafin()), fechaoriginal);
			cantregistra = cantregistra + 1;
			if (!UValidador.esCero(cantmaxima)) {
				if (cantregistra > cantmaxima) {
					setMessageError(
							"No puede generar esta papeleta por que superaría la cantidad máxima permitida por año: "
									+ cantmaxima);
					return false;
				}
			}

			// validamos las licencias del empleado
			count = getFacAsistencia().getAsAutorizacionServicio().contarvalidalicenciasempleado(dw_1.getEmpleado(),
					dw_1.getFecha(), opciones.getIsmostrarfechafin() ? dw_1.getFechafin() : dw_1.getFecha());
			if (count > 0) {
				setMessageError("El Empleado se encuentra de Licencia en las fechas indicadas.");
				return false;
			}

			// obtenemos el maximo periodo de vacaciones del empleado
			Integer periodomax = getFacAsistencia().getAsAutorizacionServicio()
					.contarmaximoperiodovacaciones(dw_1.getEmpleado());

			// validamos las vacaciones del empleado
			count = getFacAsistencia().getAsAutorizacionServicio().contarvalidavacacionesempleado(dw_1.getEmpleado(),
					dw_1.getFecha(), opciones.getIsmostrarfechafin() ? dw_1.getFechafin() : dw_1.getFecha(),
					periodomax);
			if (count > 0) {
				setMessageError("El Empleado se encuentra de vacaciones en las fechas indicadas.");
				return false;
			}

		}

		// -----------------------------------------------------------------------
		// Validaciones Por el tipo de concepto seleccionado
		// -----------------------------------------------------------------------

		String valpapehoy = getFacCore().getParametrosmastServicio()
				.obtenerValorCadena(new ParametrosmastPk("AS", "999999", "VALPAPEHOY"));
		if (UValidador.esNulo(valpapehoy)) {
			valpapehoy = Constante.CONSTANTE_OPCION_NO;
		}

		if (!getFacSeguridad().getSeguridadautorizacionesServicio()
				.tieneAccesoSysAdm(getUsuarioActual().getAplicacionCodigo(), getUsuarioActual().getCodigoUsuario())
				&& valpapehoy.equals(Constante.CONSTANTE_OPCION_SI)) {

			// leer los permisos de concepto acceso

			LOGGER.debug("dw_1.getConceptoacceso() " + dw_1.getConceptoacceso());

			AsConceptoaccesoPk pkfind = new AsConceptoaccesoPk();
			pkfind.setConceptoacceso(dw_1.getConceptoacceso());

			AsConceptoacceso objfind = (AsConceptoacceso) getFacAsistencia().getAsConceptoaccesoServicio()
					.obtenerPorId(pkfind, false);
			if (!UValidador.esNulo(objfind)) {

				if (objfind.getFlagtopedias().equals("N") && objfind.getFlagfechainferior().equals("N")
						&& !objfind.getPk().getConceptoacceso().equals("OMIS")) {

					// REQ ANGELA

					if ((new Date().after(UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(),
							opciones.getIsmostrardesde1() ? dw_1.getDesde1()
									: UFechaHora.obtenerFechaHoraFinDia(new Date())))
							&& !dw_1.getCategoriaautorizacion().equals("SOBR"))
							|| (new Date().after(UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(),
									UFechaHora.obtenerFechaHoraFinDia(new Date())))
									&& (dw_1.getCategoriaautorizacion().equals("SOBR")
											|| dw_1.getCategoriaautorizacion().equals("VACA")))) {

						w_mensaje = "";

						if (w_CategoriaAutorizacion.equals("COMP")) {
							w_mensaje = "una Compensación de Sobretiempo";
						}
						if (w_CategoriaAutorizacion.equals("OMIS")) {
							w_mensaje = "una Omisión de Marcado";
						}
						if (w_CategoriaAutorizacion.equals("SOBR")) {
							w_mensaje = "una Autorización de Sobretiempo ";
						}
						if (w_CategoriaAutorizacion.equals("VACA")) {
							w_mensaje = "Vacaciones ";
						}
						if (w_CategoriaAutorizacion.equals("OTRO")) {
							w_mensaje = "un Permiso ";
						}

						setMessageError("No se puede realizar " + (UValidador.estaVacio(w_mensaje)
								? ("una(s) " + objfind.getDescripcionlocal()) : w_mensaje)
								+ " con una fecha y hora inferior a la actual.");
						return false;
					}
				} else {
					if (objfind.getFlagtienetopediasfi().equals("S") && objfind.getFlagfechainferior().equals("S")) {
						w_count = getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(dw_1.getFechafin(),
								new Date());
						LOGGER.debug("w_count " + w_count);
						if (w_count > objfind.getCantidadtopediasfi()) {
							setMessageError("El máximo de días para regularizar una papeleta de ("
									+ objfind.getDescripcionlocal() + ") es " + objfind.getCantidadtopediasfi());
							return false;
						}
					}
				}
			}
		}

		if (!validacionesSIGED()) {
			return false;
		}

		// URA 14/07/2015 valida si es viernes el cual debe incluir fin de
		// semana
		if (dw_1.getConceptoacceso().equals("VACA")) {
			if (!validarVacaciones()) {
				return false;
			}
		}

		// URA 26/02/2019 valida ADELANTO DE VACACIONES
		// semana
		if ("ADEL".equals(dw_1.getConceptoacceso())) {
			if (!validarAdelantoVacaciones()) {
				return false;
			}
		}

		if ("FRAD".equals(dw_1.getConceptoacceso())) {
			if (!validarFraccionamientoDiaVacaciones()) {
				return false;
			}
		}

		if ("FRAH".equals(dw_1.getConceptoacceso())) {
			if (!validarFraccionamientoHoraVacaciones()) {
				return false;
			}
		}

		// en caso de cambio de horario debe ingresar el horario
		if (dw_1.getConceptoacceso().equals("CHOR")) {
			if (UValidador.esListaVacia(dw_horario)) {
				setMessageError("Debe agregar las fechas del cambio de horario.");
				return false;
			}
		}

		w_tipocontrato = "";
		if (!UValidador.esListaVacia(dw_horario)) {
			w_tipocontrato = getFacCore().getEmpleadomastServicio().obtenerTipoContrato(dw_1.getEmpleado());

			if (w_tipocontrato.equals("08")) {
				ll_horasprac = getFacCore().getParametrosmastServicio()
						.obtenerValorInteger(new ParametrosmastPk("AS", "999999", "HORAPRAPRE"));
			}
			if (w_tipocontrato.equals("09")) {
				ll_horasprac = getFacCore().getParametrosmastServicio()
						.obtenerValorInteger(new ParametrosmastPk("AS", "999999", "HORAPRAPRO"));
			}

			LOGGER.debug("totalhorastrabajo " + totalhorastrabajo);
			LOGGER.debug("ll_horasprac " + ll_horasprac);

			if (!UValidador.esCero(ll_horasprac)) {
				if (!UValidador.esCero(totalhorastrabajo.compareTo(BigDecimal.valueOf(ll_horasprac)))) {
					setMessageError("La cantidad de horas debe ser de " + ll_horasprac);
					return false;
				}
			}
		}

		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")
				|| CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
						.equalsIgnoreCase("Update")) {

			ll_find = null;
			for (int i = 0; i < dwc_ConceptoAccesoFiltrado.size(); i++) {
				if (dwc_ConceptoAccesoFiltrado.get(i).getConceptoacceso().equals(dw_1.getConceptoacceso())) {
					ll_find = i;
				}
			}

			if (!UValidador.esNulo(ll_find)) {
				DtoDddwAsConceptoaccesoSelectPre objfind = dwc_ConceptoAccesoFiltrado.get(ll_find);
				// if
				// (!getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
				// getUsuarioActual().getAplicacionCodigo(),
				// getUsuarioActual().getCodigoUsuario())) {
				if ("S".equals(objfind.getFlaghorasmaximo())) {
					w_horainicio = UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), dw_1.getDesde1());
					w_horafin = UFechaHora.obtenerFechaCompuesta(dw_1.getFechafin(), dw_1.getHasta1());
					w_diftiempo = wf_diftiempo(w_horainicio, w_horafin).divide(BigDecimal.valueOf(3600), 2,
							RoundingMode.HALF_DOWN);
					// no tomar en cuenta el refrigerio
					w_diftiempo = w_diftiempo.subtract(obtenerHorasRefrigerio());

					if (w_diftiempo.compareTo(objfind.getCantidadhorasmaximo()) == 1) {
						setMessageError("No puede asignar una papeleta mayor a " + objfind.getCantidadhorasmaximo()
								+ " horas para este concepto.");
						return false;
					}
				}
				if ("S".equals(objfind.getFlaghorasminimo())) {
					w_horainicio = UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), dw_1.getDesde1());
					w_horafin = UFechaHora.obtenerFechaCompuesta(dw_1.getFechafin(), dw_1.getHasta1());
					w_diftiempo = wf_diftiempo(w_horainicio, w_horafin).divide(BigDecimal.valueOf(3600), 2,
							RoundingMode.HALF_DOWN);
					// no tomar en cuenta el refrigerio
					w_diftiempo = w_diftiempo.subtract(obtenerHorasRefrigerio());

					if (w_diftiempo.compareTo(objfind.getCantidadhorasminimo()) == -1) {
						setMessageError("No puede asignar una papeleta menor a " + objfind.getCantidadhorasminimo()
								+ " horas para este concepto.");
						return false;
					}
				}
				if ("S".equals(objfind.getFlagminutosminimo())) {
					w_horainicio = UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), dw_1.getDesde1());
					w_horafin = UFechaHora.obtenerFechaCompuesta(dw_1.getFechafin(), dw_1.getHasta1());
					w_diftiempo = wf_diftiempo(w_horainicio, w_horafin).divide(BigDecimal.valueOf(3600), 2,
							RoundingMode.HALF_DOWN);
					// no tomar en cuenta el refrigerio
					w_diftiempo = w_diftiempo.subtract(obtenerHorasRefrigerio());

					if (w_diftiempo.compareTo(objfind.getCantidadminutosminimo().divide(new BigDecimal(60.0), 2,
							RoundingMode.HALF_DOWN)) == -1) {
						setMessageError("No puede asignar una papeleta menor a " + objfind.getCantidadminutosminimo()
								+ " minutos para este concepto.");
						return false;
					}
				}

				// validaos la vigencia del conpceto
				if (objfind.getAnolimite().intValue() < UFechaHora.obtenerFechaParte(dw_1.getFecha(), "YY")) {
					setMessageError("Este concepto sólo estuvo vigente hasta el año "
							+ objfind.getAnolimite().intValue() + ", por favor cambiar la fecha de inicio.");
					return false;
				}

				if (objfind.getFlagarchivo().equals("S") && !"ADFR".equals(dw_1.getCategoriaautorizacion())) {
					if (UValidador.estaVacio(dw_1.getRutacompleta())) {
						setMessageError("Debe adjuntar el archivo para poder grabar");
						return false;
					}
				}

			}
			// }

		}

		if (dw_1.getCategoriaautorizacion().equals("OMIS")) {
			dw_1.setConceptoacceso(conceptoOmisionMarcado);
			dw_1.setFechafin(UFechaHora.obtenerFechaHoraFinDia(dw_1.getFecha()));
		}

		if (dw_1.getCategoriaautorizacion().equals("CHOR")) {
			dw_1.setConceptoacceso(conceptoCambioHorario);
		}
		if (dw_1.getCategoriaautorizacion().equals("PMP")) {
			dw_1.setConceptoacceso(conceptoPermanenciaMotivoPersonal);
		}

		if (dw_1.getCategoriaautorizacion().equals("SOBR")) {
			dw_1.setConceptoacceso(conceptoAutorizacionSobretiempo);
		}

		this.conceptoacceso = dw_1.getConceptoacceso();

		if (dw_1.getFecha().after(dw_1.getFechafin())) {
			setMessageError("La fecha FINAL NO puede ser menor que la INICIAL");
			return false;
		}

		//
		// fechaval = UFechaHora.obtenerFechaHoraInicioDia(dw_1.getFecha());
		// dw_1.setFecha(fechaval);

		// URH 05/02/2019 VALIDACIÓN DE CUPONERAS
		if (!validarCuponeras()) {
			return false;
		}

		// validación de viernes de verano
		if ("86".equals(dw_1.getConceptoacceso())) {
			if (!validarViernesVerano()) {
				return false;
			} else {
				// empieza a recuperar el siguiente lunes
				dw_1.setDesderecupera(UFechaHora.anadirDiasAFechas(dw_1.getFecha(), 3));
				dw_1.setHastarecupera(UFechaHora.anadirDiasAFechas(dw_1.getFecha(), 6));
			}
		}

		if (dw_1.getFecha().after(UFechaHora.obtenerFechaMasdias(new Date(), 365))) {
			getWebControlContext().actualizar("dgAvisoSiNo");
			getWebControlContext().ejecutar("PF('popAvisoSiNo').show()");
			validarfechas = false;
			return false;
		}

		if (dw_1.getFechafin().after(UFechaHora.obtenerFechaMasdias(new Date(), 365))) {
			getWebControlContext().actualizar("dgAvisoSiNo");
			getWebControlContext().ejecutar("PF('popAvisoSiNo').show()");
			validarfechas = false;
			return false;
		}

		// continua en:
		return validarDespuesdeFechas();
	}

	private boolean validarViernesVerano() throws Exception {

		Date fechaHasta = null;

		for (DtoDddwAsConceptoaccesoSelectPre obj : dwc_ConceptoAcceso) {
			if (obj.getConceptoacceso().equals(dw_1.getConceptoacceso())) {
				fechaHasta = obj.getFechaLimite();
				break;
			}
		}

		if (UFechaHora.obtenerNumeroDiaSemana(dw_1.getFecha()) != 6) {
			setMessageError("El permiso de Viernes de verano, es aplicable para los días viernes");
			return false;
		}

		if (fechaHasta != null) {
			if (dw_1.getFecha().getTime() > fechaHasta.getTime()) {
				setMessageError("El permiso de Viernes de verano, tiene vigencia hasta el "
						+ UFechaHora.convertirFechaCadena(fechaHasta, "dd/MM/yyyy"));
				return false;
			}
		}

		return true;
	}

	private boolean validarCuponeras() throws Exception {
		// TODO Auto-generated method stub

		AsConceptoacceso asConceptoacceso = (AsConceptoacceso) getFacAsistencia().getAsConceptoaccesoServicio()
				.obtenerPorId(new AsConceptoaccesoPk(dw_1.getConceptoacceso()));

		if (!UValidador.esNulo(asConceptoacceso)) {
			// REQ 2021 ACTIVACIÓN TICKETS
			// VALIDAR QUE SEA 2 DIAS ANTES (CONFIGURABLE)
			if ("S".equals(asConceptoacceso.getFlagdiasanticipacion())) {
				Integer diasHabiles = getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(new Date(),
						dw_1.getFecha());
				if (diasHabiles < asConceptoacceso.getDiasanticipacion().intValue()) {
					setMessageError("Para solicitar " + asConceptoacceso.getDescripcionlocal()
							+ " estas deben generarse con " + asConceptoacceso.getDiasanticipacion().intValue()
							+ " días hábiles de anticipación.");
					return false;
				}
			}

			if ("S".equals(asConceptoacceso.getFlagticket())) {
				int cant = getFacAsistencia().getAsAutorizacionServicio().contarEnfechasPorTicket(dw_1.getEmpleado(),
						dw_1.getConceptoacceso(), dw_1.getFecha(), dw_1.getFechafin(), fechaoriginal);
				if (cant > 0) {
					setMessageError("No puede haber más de un ticket de la felicidad el mismo día");
					return false;
				}
			}

		}

		// tiempo para celebrar con la familia
		if ("83".equals(dw_1.getConceptoacceso())) {

			int horasmaximo = 99;
			int horasregistra = 0;
			for (DtoDddwAsConceptoaccesoSelectPre obj : dwc_ConceptoAcceso) {
				if (obj.getConceptoacceso().equals(dw_1.getConceptoacceso())) {
					if ("S".equals(obj.getFlaghorasmaximoanio())) {
						horasmaximo = obj.getCantidadhorasmaximoanio().intValue();
						break;
					}
				}
			}
			// validamos que las papeletas generadas en el año sean
			// menor o igual a la cantidad máxima
			horasregistra = getFacAsistencia().getAsAutorizacionServicio().contarHorasEnfechasPorConcepto(
					dw_1.getEmpleado(), dw_1.getConceptoacceso(), UFechaHora.obtenerPrimerDiaAnioFecha(dw_1.getFecha()),
					UFechaHora.obtenerUltimoDiaAnioFecha(dw_1.getFechafin()), fechaoriginal);
			// solo es 4 u 8 horas
			if (horasregistra > 4 && horasregistra < 8) {
				horasregistra = 4;
			}
			if (horasregistra > 8) {
				horasregistra = 8;
			}

			BigDecimal horasSolicita = wf_diftiempo(dw_1.getDesde1(), dw_1.getHasta1())
					.divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_DOWN).subtract(obtenerHorasRefrigerio());

			horasregistra = horasregistra + horasSolicita.intValue();
			if (horasregistra > horasmaximo) {
				setMessageError(
						"No puede generar esta papeleta por que superaría la cantidad de horas máxima permitida por año: "
								+ horasmaximo);
				return false;
			}

			// validamos si tiene HIJO o conyuges CUMPLIENDO AÑOS EN FECHA DE
			// INICIO
			Integer cantidadDependientes = getFacAsistencia().getAsAutorizacionServicio()
					.contarHijosConyugueCumpleanios(dw_1.getEmpleado(), dw_1.getFecha());
			if (UValidador.esCero(cantidadDependientes)) {
				if (!blDeclaracionjurada) {
					setMessageError(
							"No puede generar esta papeleta por que no registra un dependiente hijo o conyugue que cumpla años en la fecha indicada. Por favor cargue la declaración jurada");
					blDeclaracionjurada = true;
					return false;
				} else {
					if (UValidador.estaVacio(dw_1.getNombrearchivodj())) {
						setMessageError("Debe adjuntar la declaración jurada para poder grabar");
						return false;
					}
				}
			}

			BigDecimal horasAcumuladas = wf_diftiempo(dw_1.getDesde1(), dw_1.getHasta1())
					.divide(BigDecimal.valueOf(3600), 2, BigDecimal.ROUND_HALF_UP);
			horasAcumuladas = horasAcumuladas.subtract(obtenerHorasRefrigerio());

			if (horasAcumuladas.intValue() != 4 && horasAcumuladas.intValue() != 8) {
				setMessageError("No puede generar esta papeleta por que las horas permitidas son 4 o 8");
				return false;
			}
		}

		// control del niño sano
		if ("84".equals(dw_1.getConceptoacceso())) {
			// validamos si tiene HIJO o conyuges CUMPLIENDO AÑOS EN FECHA DE
			// INICIO
			Integer cantidadDependientes = getFacAsistencia().getAsAutorizacionServicio()
					.contarHijosMeses(dw_1.getEmpleado(), dw_1.getFecha(), 6);
			if (UValidador.esCero(cantidadDependientes)) {
				setMessageError(
						"No puede generar esta papeleta por que no registra un dependiente hijo menor o igual a 6 meses de nacido");
				return false;
			}
			int horasmaximo = 99;
			int horasregistra = 0;
			for (DtoDddwAsConceptoaccesoSelectPre obj : dwc_ConceptoAcceso) {
				if (obj.getConceptoacceso().equals(dw_1.getConceptoacceso())) {
					if ("S".equals(obj.getFlaghorasmaximoanio())) {
						horasmaximo = obj.getCantidadhorasmaximoanio().intValue();
						break;
					}
				}
			}
			// validamos que las papeletas generadas en el año sean
			// menor o igual a la cantidad máxima
			horasregistra = getFacAsistencia().getAsAutorizacionServicio().contarHorasEnfechasPorConcepto(
					dw_1.getEmpleado(), dw_1.getConceptoacceso(), UFechaHora.obtenerPrimerDiaAnioFecha(dw_1.getFecha()),
					UFechaHora.obtenerUltimoDiaAnioFecha(dw_1.getFechafin()), fechaoriginal);

			// solo es 4 u 8 horas
			if (horasregistra > 4 && horasregistra < 8) {
				horasregistra = 4;
			}
			if (horasregistra > 8) {
				horasregistra = 8;
			}

			BigDecimal horasSolicita = wf_diftiempo(dw_1.getDesde1(), dw_1.getHasta1())
					.divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_DOWN).subtract(obtenerHorasRefrigerio());

			horasregistra = horasregistra + horasSolicita.intValue();
			if (horasregistra > horasmaximo) {
				setMessageError(
						"No puede generar esta papeleta por que superaría la cantidad de horas máxima permitida por año: "
								+ horasmaximo);
				return false;
			}

		}

		// disfrutando un momento de amor y salud
		if ("85".equals(dw_1.getConceptoacceso())) {
			// validamos si tiene HIJO o conyuges CUMPLIENDO AÑOS EN FECHA DE
			// INICIO
			Integer cantidadDependientes = getFacAsistencia().getAsAutorizacionServicio()
					.contarPadresAbuelos(dw_1.getEmpleado());

			if (UValidador.esCero(cantidadDependientes)) {
				if (!blDeclaracionjurada) {
					setMessageError(
							"No puede generar esta papeleta por que no registra un dependiente padre, madre o abuelos. Por favor cargue la declaración jurada");
					blDeclaracionjurada = true;
					return false;
				} else {
					if (UValidador.estaVacio(dw_1.getNombrearchivodj())) {
						setMessageError("Debe adjuntar la declaración jurada para poder grabar");
						return false;
					}
				}
			}
			int horasmaximo = 99;
			int horasregistra = 0;
			for (DtoDddwAsConceptoaccesoSelectPre obj : dwc_ConceptoAcceso) {
				if (obj.getConceptoacceso().equals(dw_1.getConceptoacceso())) {
					if ("S".equals(obj.getFlaghorasmaximoanio())) {
						horasmaximo = obj.getCantidadhorasmaximoanio().intValue();
						break;
					}
				}
			}
			// validamos que las papeletas generadas en el año sean
			// menor o igual a la cantidad máxima
			horasregistra = getFacAsistencia().getAsAutorizacionServicio().contarHorasEnfechasPorConcepto(
					dw_1.getEmpleado(), dw_1.getConceptoacceso(), UFechaHora.obtenerPrimerDiaAnioFecha(dw_1.getFecha()),
					UFechaHora.obtenerUltimoDiaAnioFecha(dw_1.getFechafin()), fechaoriginal);
			// solo es 4 u 8 horas
			if (horasregistra > 4 && horasregistra < 8) {
				horasregistra = 4;
			}
			if (horasregistra > 8) {
				horasregistra = 8;
			}
			BigDecimal horasSolicita = wf_diftiempo(dw_1.getDesde1(), dw_1.getHasta1())
					.divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_DOWN).subtract(obtenerHorasRefrigerio());

			horasregistra = horasregistra + horasSolicita.intValue();
			if (horasregistra > horasmaximo) {
				setMessageError(
						"No puede generar esta papeleta por que superaría la cantidad de horas máxima permitida por año: "
								+ horasmaximo);
				return false;
			}

			BigDecimal horasAcumuladas = wf_diftiempo(dw_1.getDesde1(), dw_1.getHasta1())
					.divide(BigDecimal.valueOf(3600), 2, BigDecimal.ROUND_HALF_UP);
			horasAcumuladas = horasAcumuladas.subtract(obtenerHorasRefrigerio());

			if (horasAcumuladas.intValue() != 4 && horasAcumuladas.intValue() != 8) {
				setMessageError("No puede generar esta papeleta por que las horas permitidas son 4 o 8");
				return false;
			}
		}

		// dia del padre
		if ("06".equals(dw_1.getConceptoacceso())) {
			Personamast per = getFacCore().getPersonamastServicio().obtenerporPersona(dw_1.getEmpleado());
			if (UValidador.esNulo(per)) {
				per = new Personamast();
			}

			if (UConstante.CONSTANTE_SEXO_FEMENINO.equals(per.getSexo())) {
				setMessageError("No puede generar esta papeleta por que el empleado debe tener sexo masculino.");
				return false;
			}

			// validamos si tiene hijo
			Integer cantidadHijos = getFacAsistencia().getAsAutorizacionServicio().contarHijos(dw_1.getEmpleado());
			if (UValidador.esCero(cantidadHijos)) {
				setMessageError(
						"No puede generar esta papeleta por que no registra un dependiente hijo en el sistema.");
				return false;
			} else {
				Date fechabase = UFechaHora.convertirCadenaFecha("01/06/" + UFechaHora.obtenerAnio(), "dd/MM/yyyy");
				Date fechaLim = UFechaHora.obtenerUltimoDiaMesFecha(
						UFechaHora.convertirCadenaFecha("01/06/" + UFechaHora.obtenerAnio(), "dd/MM/yyyy"));
				if (!(dw_1.getFecha().getTime() >= fechabase.getTime()
						&& dw_1.getFecha().getTime() <= fechaLim.getTime())) {
					setMessageError("No puede generar esta papeleta por que no está dentro del mes de Junio. (Del "
							+ UFechaHora.convertirFechaCadena(fechabase, "dd/MM/yyyy") + " al "
							+ UFechaHora.convertirFechaCadena(fechaLim, "dd/MM/yyyy") + ")");
					return false;
				} else {
					// int cantmaxima = 0;
					// int cantregistra = 0;
					// for (DtoDddwAsConceptoaccesoSelectPre obj :
					// dwc_ConceptoAcceso) {
					// if
					// (obj.getConceptoacceso().equals(dw_1.getConceptoacceso()))
					// {
					// cantmaxima = obj.getCantmaxanio().intValue();
					// break;
					// }
					// }

				}

			}
		}

		// dia de la madre
		if ("19".equals(dw_1.getConceptoacceso())) {
			Personamast per = getFacCore().getPersonamastServicio().obtenerporPersona(dw_1.getEmpleado());
			if (UValidador.esNulo(per)) {
				per = new Personamast();
			}

			if (UConstante.CONSTANTE_SEXO_MASCULINO.equals(per.getSexo())) {
				setMessageError("No puede generar esta papeleta por que el empleado debe tener sexo femenino.");
				return false;
			}

			// validamos si tiene hijo
			Integer cantidadHijos = getFacAsistencia().getAsAutorizacionServicio().contarHijos(dw_1.getEmpleado());
			if (UValidador.esCero(cantidadHijos)) {
				setMessageError(
						"No puede generar esta papeleta por que no registra un dependiente hijo en el sistema.");
				return false;
			} else {
				// validamos que la fecha este en la semana del 2do domingo de
				// mayo
				// Date fechabase =
				// UFechaHora.obtenerPrimerDiaAnioMesSemanaFecha(
				// UFechaHora.obtenerFechaParte(dw_1.getFecha(), "YY"), 4, 2,
				// 1);
				// Date fechaLim = UFechaHora.anadirDiasAFechas(fechabase, 4);
				// if (!(UFechaHora.obtenerTime(dw_1.getFecha(), "dd/MM/yyyy")
				// >= UFechaHora.obtenerTime(fechabase,
				// "dd/MM/yyyy")
				// && UFechaHora.obtenerTime(dw_1.getFecha(), "dd/MM/yyyy") <=
				// UFechaHora.obtenerTime(fechaLim,
				// "dd/MM/yyyy"))) {
				//
				// setMessageError(
				// "No puede generar esta papeleta por que no está dentro de la
				// segunda semana del mes de mayo. (Del "
				// + UFechaHora.convertirFechaCadena(fechabase, "dd/MM/yyyy") +
				// " al "
				// + UFechaHora.convertirFechaCadena(fechaLim, "dd/MM/yyyy") +
				// ")");
				// return false;
				// validamos que la solicitud sea en todo el mes de mayo
				Date fechabase = UFechaHora.convertirCadenaFecha("01/05/" + UFechaHora.obtenerAnio(), "dd/MM/yyyy");
				Date fechaLim = UFechaHora.obtenerUltimoDiaMesFecha(
						UFechaHora.convertirCadenaFecha("01/05/" + UFechaHora.obtenerAnio(), "dd/MM/yyyy"));
				if (!(dw_1.getFecha().getTime() >= fechabase.getTime()
						&& dw_1.getFecha().getTime() <= fechaLim.getTime())) {
					setMessageError("No puede generar esta papeleta por que no está dentro del mes de Mayo. (Del "
							+ UFechaHora.convertirFechaCadena(fechabase, "dd/MM/yyyy") + " al "
							+ UFechaHora.convertirFechaCadena(fechaLim, "dd/MM/yyyy") + ")");
					return false;
				} else {
					// int cantmaxima = 0;
					// int cantregistra = 0;
					// for (DtoDddwAsConceptoaccesoSelectPre obj :
					// dwc_ConceptoAcceso) {
					// if
					// (obj.getConceptoacceso().equals(dw_1.getConceptoacceso()))
					// {
					// cantmaxima = obj.getCantmaxanio().intValue();
					// break;
					// }
					// }

				}

			}
		}

		// cumpleaños hijo
		if ("72".equals(dw_1.getConceptoacceso()))

		{

			// validamos si tiene HIJO CUMPLIENDO AÑOS EN FECHA DE INICIO
			Integer cantidadHijos = getFacAsistencia().getAsAutorizacionServicio()
					.contarHijosCumpleanios(dw_1.getEmpleado(), dw_1.getFecha());
			if (UValidador.esCero(cantidadHijos)) {
				setMessageError(
						"No puede generar esta papeleta por que no registra un dependiente hijo que cumpla años en la fecha indicada.");
				return false;
			} else {
				// int cantmaxima = 0;
				// int cantregistra = 0;
				// for (DtoDddwAsConceptoaccesoSelectPre obj :
				// dwc_ConceptoAcceso) {
				// if (obj.getConceptoacceso().equals(dw_1.getConceptoacceso()))
				// {
				// cantmaxima = obj.getCantmaxanio().intValue();
				// break;
				// }
				// }

			}
		}

		// almuerzo con la familia
		if ("73".equals(dw_1.getConceptoacceso())) {

			// validamosque el registro este en el horario 12:30 15:00
			String horainicio = UFechaHora.convertirFechaCadena(dw_1.getDesde1(), "HHmm");
			String horafin = UFechaHora.convertirFechaCadena(dw_1.getHasta1(), "HHmm");
			if (!(Integer.parseInt(horainicio) >= 1230 && Integer.parseInt(horainicio) <= 1500
					&& Integer.parseInt(horafin) >= 1230 && Integer.parseInt(horafin) <= 1500)) {
				setMessageError(
						"No puede generar esta papeleta porque el horario debe estar entre las 12:30 y 15:00 horas.");
				return false;
			} else {
				// int cantmaxima = 0;
				// int cantregistra = 0;
				// for (DtoDddwAsConceptoaccesoSelectPre obj :
				// dwc_ConceptoAcceso) {
				// if (obj.getConceptoacceso().equals(dw_1.getConceptoacceso()))
				// {
				// cantmaxima = obj.getCantmaxanio().intValue();
				// break;
				// }
				// }
			}
		}

		// tarde libre
		if ("74".equals(dw_1.getConceptoacceso())) {

			// validamosque el registro inicie en el horario 13:00
			String horainicio = UFechaHora.convertirFechaCadena(dw_1.getDesde1(), "HHmm");
			if (!(Integer.parseInt(horainicio) >= 1300)) {
				setMessageError("No puede generar esta papeleta porque el horario debe iniciar a las 13:00 horas.");
				return false;
			} else {
				int cantmaxima = 0;
				int cantregistra = 0;
				for (DtoDddwAsConceptoaccesoSelectPre obj : dwc_ConceptoAcceso) {
					if (obj.getConceptoacceso().equals(dw_1.getConceptoacceso())) {
						cantmaxima = obj.getCantmaxanio().intValue();
						break;
					}
				}
				// validamos que las papeletas generadas en el año sean
				// menor o igual a la cantidad máxima
				cantregistra = getFacAsistencia().getAsAutorizacionServicio().contarCantidadEnfechasPorConcepto(
						dw_1.getEmpleado(), dw_1.getConceptoacceso(),
						UFechaHora.obtenerPrimerDiaAnioFecha(dw_1.getFecha()),
						UFechaHora.obtenerUltimoDiaAnioFecha(dw_1.getFechafin()), fechaoriginal);
				cantregistra = cantregistra + 1;
				if (cantregistra > cantmaxima) {
					setMessageError(
							"No puede generar esta papeleta por que superaría la cantidad máxima permitida por año: "
									+ cantmaxima);
					return false;
				}
			}
		}

		// gestión de personal
		if ("75".equals(dw_1.getConceptoacceso())) {

			// validamosque el registro este en el horario 12:30 15:00

			int cantmaxima = 0;
			int cantregistra = 0;

			for (DtoDddwAsConceptoaccesoSelectPre obj : dwc_ConceptoAcceso) {
				if (obj.getConceptoacceso().equals(dw_1.getConceptoacceso())) {
					cantmaxima = obj.getCantmaxanio().intValue();
					break;
				}
			}

			// if ("S".equals(flgCantidaddiasmaximo)
			// && diasmax >
			// UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(),
			// dw_1.getFecha()) + 1) {
			// setMessageError(
			// "No puede generar esta papeleta por que superaría la cantidad
			// máxima permitida de días: "
			// + diasmax);
			// return false;
			// }

			BigDecimal horasAcumuladas = wf_diftiempo(dw_1.getDesde1(), dw_1.getHasta1())
					.divide(BigDecimal.valueOf(3600), 2, BigDecimal.ROUND_HALF_UP);
			horasAcumuladas = horasAcumuladas.subtract(obtenerHorasRefrigerio());

			if (horasAcumuladas.intValue() != 4 && horasAcumuladas.intValue() != 8) {
				setMessageError("No puede generar esta papeleta por que las horas permitidas son 4 o 8");
				return false;
			}

			int horasmaximo = 0;
			int horasregistra = 0;
			for (DtoDddwAsConceptoaccesoSelectPre obj : dwc_ConceptoAcceso) {
				if (obj.getConceptoacceso().equals(dw_1.getConceptoacceso())) {
					if ("S".equals(obj.getFlaghorasmaximoanio())) {
						horasmaximo = obj.getCantidadhorasmaximoanio().intValue();
						break;
					}
				}
			}
			// validamos que las papeletas generadas en el año sean
			// menor o igual a la cantidad máxima
			horasregistra = getFacAsistencia().getAsAutorizacionServicio().contarHorasEnfechasPorConcepto(
					dw_1.getEmpleado(), dw_1.getConceptoacceso(), UFechaHora.obtenerPrimerDiaAnioFecha(dw_1.getFecha()),
					UFechaHora.obtenerUltimoDiaAnioFecha(dw_1.getFechafin()), fechaoriginal);
			// solo es 4 u 8 horas
			if (horasregistra > 4 && horasregistra < 8) {
				horasregistra = 4;
			}
			if (horasregistra > 8) {
				horasregistra = 8;
			}

			horasregistra = horasregistra + wf_diftiempo(dw_1.getDesde1(), dw_1.getHasta1())
					.divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_DOWN).subtract(obtenerHorasRefrigerio())
					.intValue();
			if (horasregistra > horasmaximo) {
				setMessageError(
						"No puede generar esta papeleta por que superaría la cantidad de horas máxima permitida por año: "
								+ horasmaximo);
				return false;
			}

			// validamos que las papeletas generadas en el año sean
			// menor o igual a la cantidad máxima
			cantregistra = getFacAsistencia().getAsAutorizacionServicio().contarCantidadEnfechasPorConcepto(
					dw_1.getEmpleado(), dw_1.getConceptoacceso(), UFechaHora.obtenerPrimerDiaAnioFecha(dw_1.getFecha()),
					UFechaHora.obtenerUltimoDiaAnioFecha(dw_1.getFechafin()), fechaoriginal);
			cantregistra = cantregistra + 1;
			if (cantregistra > cantmaxima) {
				setMessageError(
						"No puede generar esta papeleta por que superaría la cantidad máxima permitida por año: "
								+ cantmaxima);
				return false;
			}
		}

		// recién casado
		if ("76".equals(dw_1.getConceptoacceso())) {

			// validamosque el registro este en el horario 12:30 15:00

			int cantmaxima = 0;
			int cantregistra = 0;
			int diasmax = 0;
			String flgCantidaddiasmaximo = "";

			for (DtoDddwAsConceptoaccesoSelectPre obj : dwc_ConceptoAcceso) {
				if (obj.getConceptoacceso().equals(dw_1.getConceptoacceso())) {
					cantmaxima = obj.getCantmaxanio().intValue();
					diasmax = obj.getCantidaddiasmaximo().intValue();
					flgCantidaddiasmaximo = obj.getFlagdiasmaximo();
					break;
				}
			}

			if ("S".equals(flgCantidaddiasmaximo) && diasmax < getFacAsistencia().getAS().getAsmainFuncion()
					.FDiasHabiles(dw_1.getFecha(), dw_1.getFechafin())) {
				setMessageError(
						"No puede generar esta papeleta por que no respeta la cantidad permitida de días: " + diasmax);
				return false;
			}

			// validamos que las papeletas generadas en el año sean
			// menor o igual a la cantidad máxima
			cantregistra = getFacAsistencia().getAsAutorizacionServicio().contarCantidadEnfechasPorConcepto(
					dw_1.getEmpleado(), dw_1.getConceptoacceso(), UFechaHora.obtenerPrimerDiaAnioFecha(dw_1.getFecha()),
					UFechaHora.obtenerUltimoDiaAnioFecha(dw_1.getFechafin()), fechaoriginal);
			cantregistra = cantregistra + 1;
			if (cantregistra > cantmaxima) {
				setMessageError(
						"No puede generar esta papeleta por que superaría la cantidad máxima permitida por año: "
								+ cantmaxima);
				return false;
			}
		}

		// aniverario bodas
		if ("77".equals(dw_1.getConceptoacceso())) {

			// validamosque el registro este en el horario 12:30 15:00
			int cantmaxima = 0;
			int cantregistra = 0;

			for (DtoDddwAsConceptoaccesoSelectPre obj : dwc_ConceptoAcceso) {
				if (obj.getConceptoacceso().equals(dw_1.getConceptoacceso())) {
					cantmaxima = obj.getCantmaxanio().intValue();
					break;
				}
			}

			// validamos que las papeletas generadas en el año sean
			// menor o igual a la cantidad máxima
			cantregistra = getFacAsistencia().getAsAutorizacionServicio().contarCantidadEnfechasPorConcepto(
					dw_1.getEmpleado(), dw_1.getConceptoacceso(), UFechaHora.obtenerPrimerDiaAnioFecha(dw_1.getFecha()),
					UFechaHora.obtenerUltimoDiaAnioFecha(dw_1.getFechafin()), fechaoriginal);
			cantregistra = cantregistra + 1;
			if (cantregistra > cantmaxima) {
				setMessageError(
						"No puede generar esta papeleta por que superaría la cantidad máxima permitida por año: "
								+ cantmaxima);
				return false;
			}
		}
		return true;
	}

	private boolean validarFraccionamientoHoraVacaciones() throws Exception {

		BigDecimal w_diftiempo = wf_diftiempo(dw_1.getDesde1(), dw_1.getHasta1()).divide(BigDecimal.valueOf(3600), 2,
				BigDecimal.ROUND_HALF_UP);

		w_diftiempo = w_diftiempo.subtract(obtenerHorasRefrigerio());

		// 1. Validando si existe papeleta en la misma fecha (validar en calidad
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")
				|| CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
						.equalsIgnoreCase("Update")) {
			w_count = getFacAsistencia().getAsAutorizacionServicio().obtenerCantidadPapeletaFechas(
					BigDecimal.valueOf(dw_1.getEmpleado()), dw_1.getFecha(), dw_1.getFechafin(), fechainiOriginal,
					fechafinOriginal);

			if (w_count > 0) {
				setMessageError("Ya existe otra papeleta dentro de las fechas indicadas.");
				return false;
			}
		}

		// 2. Verificando si tiene saldo acumulado
		BigDecimal pendientes = BigDecimal.ZERO;
		BigDecimal periodo = BigDecimal.ZERO;
		BigDecimal programados = BigDecimal.ZERO;
		BigDecimal utilizados = BigDecimal.ZERO;
		BigDecimal solicitados = BigDecimal.ZERO;
		BigDecimal fraccionadosdias = BigDecimal.ZERO;
		BigDecimal fraccionadoshoras = BigDecimal.ZERO;
		BigDecimal adelantos = BigDecimal.ZERO;

		List<DtoPrVacacionPeriodo> val1 = null;

		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
			val1 = getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(
					dw_1.getEmpleado(), dw_1.getFecha(), fechainiOriginal, fechafinOriginal, "M",
					dw_1.getConceptoacceso());
		}
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
			val1 = getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(
					dw_1.getEmpleado(), dw_1.getFecha(), fechainiOriginal, fechafinOriginal, "N",
					dw_1.getConceptoacceso());
		}

		if (!UValidador.esListaVacia(val1)) {
			pendientes = val1.get(0).getPendientes();
			periodo = val1.get(0).getNroperiodo();
			programados = val1.get(0).getProgramados();
			utilizados = val1.get(0).getUtilizados();
			solicitados = val1.get(0).getSolicitados();
			fraccionadosdias = val1.get(0).getFraccionadosdias();
			fraccionadoshoras = val1.get(0).getFraccionadoshoras();
			adelantos = val1.get(0).getAdelantos();
			// guardamos el periodo actual en la autorización
			dw_1.setPeriodo(periodo.toString());
		}

		// si editamos no se debe considerar los dias solicitados en el momento
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
			if (UValidador.esNulo(pendientes)) {
				pendientes = BigDecimal.ZERO;
			}
		}

		if (pendientes.multiply(BigDecimal.valueOf(8)).compareTo(w_diftiempo) == -1) {
			setMessageError(
					"No puede agregar una papeleta por Fraccionamiento de vacaciones porque las horas indicadas es mayor al saldo disponible: "
							+ "Pendientes: " + pendientes + ", " + "Vacaciones solicitadas: " + solicitados + ", "
							+ "Vacaciones programadas: " + programados + ", " + "Vacaciones utilizadas: " + utilizados
							+ ", " + "Fraccionamiento días: " + fraccionadosdias + ", " + "Fraccionamiento horas: "
							+ fraccionadoshoras + ", " + "Vacaciones adelantos: " + adelantos
							+ ". Por favor de consultar a URH.");

			return false;
		}

		// 3. Incluir fines de semana
		if (UFechaHora.obtenerNumeroDiaSemana(dw_1.getFecha()) != 7) {
			if (UFechaHora.obtenerNumeroDiaSemana(dw_1.getFechafin()).equals(6)
					|| UFechaHora.obtenerNumeroDiaSemana(dw_1.getFechafin()).equals(7)) {
				if (w_diftiempo.compareTo(new BigDecimal(8.0)) != -1) {
					setMessageError(
							"La hora hasta no es correcta, para los días viernes debe ser menor a 8 horas. Caso contrario registre un fraccionamiento de vacaciones por día.");
					return false;
				}
			}
		}

		// 4. minimo 5 dias habiles con anticipación para el registro
		AsConceptoacceso obj = (AsConceptoacceso) getFacAsistencia().getAsConceptoaccesoServicio()
				.obtenerPorId(new AsConceptoaccesoPk(dw_1.getConceptoacceso()));

		if (!UValidador.esNulo(obj)) {
			if ("S".equals(obj.getFlagdiasanticipacion())) {
				Integer diasHabiles = getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(new Date(),
						dw_1.getFecha());
				if (diasHabiles < obj.getDiasanticipacion().intValue()) {
					setMessageError("Para fraccionar vacaciones estas deben generarse con "
							+ obj.getDiasanticipacion().intValue() + " días hábiles de anticipación.");
					return false;
				}
			}
		}

		// 5. máximo 7 días habiles en el periodo actual
		@SuppressWarnings("unchecked")
		// horas fraccionamiento
		List<DtoAsAutorizacion> listaVacaciones = getFacAsistencia().getAsAutorizacionServicio()
				.listarSolicitudesPeriodo(dw_1.getEmpleado(), dw_1.getConceptoacceso(), fechainiOriginal,
						fechafinOriginal, periodo);

		// días fraccionamiento
		List<DtoAsAutorizacion> listaVacaciones2 = getFacAsistencia().getAsAutorizacionServicio()
				.listarSolicitudesPeriodo(dw_1.getEmpleado(), "FRAD", fechainiOriginal, fechafinOriginal, periodo);

		BigDecimal horasv = BigDecimal.ZERO;
		Integer diasv = 0;

		if (!UValidador.esListaVacia(listaVacaciones)) {
			for (DtoAsAutorizacion objVaca : listaVacaciones) {
				// acumulando las horas de vacaciones solo 56 horas
				horasv = horasv.add(wf_diftiempo(objVaca.getDesde(), objVaca.getHasta())
						.divide(BigDecimal.valueOf(3600), 2, BigDecimal.ROUND_HALF_UP));
			}
		}

		if (!UValidador.esListaVacia(listaVacaciones2)) {
			for (DtoAsAutorizacion objVaca : listaVacaciones2) {
				// acumulando las horas de vacaciones solo 56 horas
				diasv = diasv + getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(objVaca.getFecha(),
						objVaca.getFechahasta());

			}
		}

		horasv = horasv.add(w_diftiempo).add(BigDecimal.valueOf(diasv * 8));

		if (horasv.compareTo(BigDecimal.valueOf(56)) == 1) {
			setMessageError("La cantidad de horas acumuladas en el periodo serían " + horasv
					+ ". Lo cuál supería la cantidad máxima de horas para fraccionamiento de vacaciones: " + 56);
			return false;
		}

		return true;
	}

	private boolean validarFraccionamientoDiaVacaciones() throws Exception {

		Integer wdifdia = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1;

		// 1. Validando si existe papeleta en la misma fecha (validar en calidad
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")
				|| CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
						.equalsIgnoreCase("Update")) {
			w_count = getFacAsistencia().getAsAutorizacionServicio().obtenerCantidadPapeletaFechas(
					BigDecimal.valueOf(dw_1.getEmpleado()), dw_1.getFecha(), dw_1.getFechafin(), fechainiOriginal,
					fechafinOriginal);

			if (w_count > 0) {
				setMessageError("Ya existe otra papeleta dentro de las fechas indicadas.");
				return false;
			}
		}

		// 2. Verificando si tiene saldo acumulado
		BigDecimal pendientes = BigDecimal.ZERO;
		BigDecimal periodo = BigDecimal.ZERO;
		BigDecimal programados = BigDecimal.ZERO;
		BigDecimal utilizados = BigDecimal.ZERO;
		BigDecimal solicitados = BigDecimal.ZERO;
		BigDecimal fraccionadosdias = BigDecimal.ZERO;
		BigDecimal fraccionadoshoras = BigDecimal.ZERO;
		BigDecimal adelantos = BigDecimal.ZERO;

		List<DtoPrVacacionPeriodo> val1 = null;

		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
			val1 = getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(
					dw_1.getEmpleado(), dw_1.getFecha(), fechainiOriginal, fechafinOriginal, "M",
					dw_1.getConceptoacceso());
		}
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
			val1 = getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(
					dw_1.getEmpleado(), dw_1.getFecha(), fechainiOriginal, fechafinOriginal, "N",
					dw_1.getConceptoacceso());
		}

		if (!UValidador.esListaVacia(val1)) {
			pendientes = val1.get(0).getPendientes();
			periodo = val1.get(0).getNroperiodo();
			programados = val1.get(0).getProgramados();
			utilizados = val1.get(0).getUtilizados();
			solicitados = val1.get(0).getSolicitados();
			fraccionadosdias = val1.get(0).getFraccionadosdias();
			fraccionadoshoras = val1.get(0).getFraccionadoshoras();
			adelantos = val1.get(0).getAdelantos();
			// guardamos el periodo actual en la autorización
			dw_1.setPeriodo(periodo.toString());
		}

		// si editamos no se debe considerar los dias solicitados en el momento
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
			if (UValidador.esNulo(pendientes)) {
				pendientes = BigDecimal.ZERO;
			}
		}

		if (pendientes.compareTo(BigDecimal.valueOf(wdifdia)) == -1) {

			setMessageError(
					"No puede agregar una papeleta por Fraccionamiento de Vacaciones porque los días indicados es mayor a los días pendientes:  "
							+ "Pendientes: " + pendientes + ", " + "Vacaciones solicitadas: " + solicitados + ", "
							+ "Vacaciones programadas: " + programados + ", " + "Vacaciones utilizadas: " + utilizados
							+ ", " + "Fraccionamiento días: " + fraccionadosdias + ", " + "Fraccionamiento horas: "
							+ fraccionadoshoras + ", " + "Vacaciones adelantadas: " + adelantos
							+ ". Por favor de consultar a URH.");

			return false;
		}

		// 3. Incluir fines de semana
		if (UFechaHora.obtenerNumeroDiaSemana(dw_1.getFecha()) != 7) {
			if (UFechaHora.obtenerNumeroDiaSemana(dw_1.getFechafin()).equals(6)
					|| UFechaHora.obtenerNumeroDiaSemana(dw_1.getFechafin()).equals(7)) {
				setMessageError("La fecha final no es correcta, debe incluir los días de fin de semana");
				return false;
			}
		}

		// 4. minimo 5 dias habiles con anticipación para el registro
		AsConceptoacceso obj = (AsConceptoacceso) getFacAsistencia().getAsConceptoaccesoServicio()
				.obtenerPorId(new AsConceptoaccesoPk(dw_1.getConceptoacceso()));

		if (!UValidador.esNulo(obj)) {
			if ("S".equals(obj.getFlagdiasanticipacion())) {
				Integer diasHabiles = getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(new Date(),
						dw_1.getFecha());
				if (diasHabiles < obj.getDiasanticipacion().intValue()) {
					setMessageError("Para fraccionar vacaciones estas deben generarse con "
							+ obj.getDiasanticipacion().intValue() + " días hábiles de anticipación.");
					return false;
				}
			}
		}

		// 5. máximo 7 días habiles en el periodo actual
		@SuppressWarnings("unchecked")
		List<DtoAsAutorizacion> listaVacaciones = getFacAsistencia().getAsAutorizacionServicio()
				.listarSolicitudesPeriodo(dw_1.getEmpleado(), dw_1.getConceptoacceso(), fechainiOriginal,
						fechafinOriginal, periodo);
		List<DtoAsAutorizacion> listaVacaciones2 = getFacAsistencia().getAsAutorizacionServicio()
				.listarSolicitudesPeriodo(dw_1.getEmpleado(), "FRAH", fechainiOriginal, fechafinOriginal, periodo);

		double diasv = 0;
		BigDecimal horasv = BigDecimal.ZERO;
		// Integer diasnv = 0;

		if (!UValidador.esListaVacia(listaVacaciones)) {
			for (DtoAsAutorizacion objVaca : listaVacaciones) {
				// acumulando los dias de vavcaciones solo 22 días hábiles
				diasv = diasv + getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(objVaca.getFecha(),
						objVaca.getFechahasta());
			}
		}

		if (!UValidador.esListaVacia(listaVacaciones2)) {
			for (DtoAsAutorizacion objVaca : listaVacaciones2) {
				// acumulando las horas de vacaciones solo 56 horas
				horasv = horasv.add(wf_diftiempo(objVaca.getDesde(), objVaca.getHasta())
						.divide(BigDecimal.valueOf(3600), 2, BigDecimal.ROUND_HALF_UP));
			}
		}

		diasv = diasv + getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(dw_1.getFecha(), dw_1.getFechafin());
		diasv = diasv + horasv.divide(BigDecimal.valueOf(8)).doubleValue();

		if (diasv > 7) {
			setMessageError("La cantidad de días hábiles acumuladas en el periodo serían " + diasv
					+ ". Lo cuál supería la cantidad máxima de días hábiles para fraccionamiento de vacaciones: " + 7);
			return false;
		}

		return true;
	}

	private boolean validarAdelantoVacaciones() throws Exception {

		Integer wdifdia = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1;

		// 1. Validando si existe papeleta en la misma fecha (validar en calidad
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")
				|| CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
						.equalsIgnoreCase("Update")) {
			w_count = getFacAsistencia().getAsAutorizacionServicio().obtenerCantidadPapeletaFechas(
					BigDecimal.valueOf(dw_1.getEmpleado()), dw_1.getFecha(), dw_1.getFechafin(), fechainiOriginal,
					fechafinOriginal);

			if (w_count > 0) {
				setMessageError("Ya existe otra papeleta dentro de las fechas indicadas.");
				return false;
			}

		}

		// 2. Verificando si tiene saldo acumulado
		BigDecimal pendientes = BigDecimal.ZERO;
		BigDecimal periodo = BigDecimal.ZERO;
		String flgperiodovalido = "";
		BigDecimal programados = BigDecimal.ZERO;
		BigDecimal utilizados = BigDecimal.ZERO;
		BigDecimal solicitados = BigDecimal.ZERO;
		BigDecimal fraccionadosdias = BigDecimal.ZERO;
		BigDecimal fraccionadoshoras = BigDecimal.ZERO;
		BigDecimal adelantos = BigDecimal.ZERO;

		List<DtoPrVacacionPeriodo> val1 = null;

		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
			val1 = getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(
					dw_1.getEmpleado(), dw_1.getFecha(), fechainiOriginal, fechafinOriginal, "M",
					dw_1.getConceptoacceso());
		}
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
			val1 = getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(
					dw_1.getEmpleado(), dw_1.getFecha(), fechainiOriginal, fechafinOriginal, "N",
					dw_1.getConceptoacceso());
		}

		if (!UValidador.esListaVacia(val1)) {
			pendientes = val1.get(0).getPendientesadelanto();
			periodo = val1.get(0).getNroperiodo();
			flgperiodovalido = val1.get(0).getFlgperiodovalido();
			programados = val1.get(0).getProgramados();
			utilizados = val1.get(0).getUtilizados();
			solicitados = val1.get(0).getSolicitados();
			fraccionadosdias = val1.get(0).getFraccionadosdias();
			fraccionadoshoras = val1.get(0).getFraccionadoshoras();
			adelantos = val1.get(0).getAdelantos();
			// guardamos el periodo actual en la autorización
			dw_1.setPeriodo(periodo.toString());
		}

		// si editamos no se debe considerar los dias solicitados en el momento
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
			if (UValidador.esNulo(pendientes)) {
				pendientes = BigDecimal.ZERO;
			}
		}

		if (!"S".equals(flgperiodovalido)) {
			if (wdifdia.intValue() < 7) {
				setMessageError(
						"Fecha de inicio incorrecta para adelanto de vacaciones. Por favor solicite un fraccionamiento de vacaciones.");
				return false;
			} else {
				setMessageError(
						"Fecha de inicio incorrecta para adelanto de vacaciones. Por favor solicite vacaciones ordinarias.");
				return false;
			}
		}

		if (pendientes.compareTo(BigDecimal.valueOf(wdifdia)) == -1) {
			setMessageError(
					"No puede agregar una papeleta por Adelanto de Vacaciones porque los días indicados es mayor a los días pendientes: "
							+ "Pendientes: " + pendientes + ", " + "Vacaciones solicitadas: " + solicitados + ", "
							+ "Vacaciones programadas: " + programados + ", " + "Vacaciones utilizadas: " + utilizados
							+ ", " + "Fraccionamiento días: " + fraccionadosdias + ", " + "Fraccionamiento horas: "
							+ fraccionadoshoras + ", " + "Vacaciones adelantadas: " + adelantos
							+ ". Por favor de consultar a URH.");

			return false;
		}

		// 3. Incluir fines de semana
		if (UFechaHora.obtenerNumeroDiaSemana(dw_1.getFecha()) != 7) {

			if (UFechaHora.obtenerNumeroDiaSemana(dw_1.getFechafin()).equals(6)
					|| UFechaHora.obtenerNumeroDiaSemana(dw_1.getFechafin()).equals(7)) {
				setMessageError("La fecha final no es correcta, debe incluir los días de fin de semana");
				return false;
			}
		}

		// 4. minimo 5 dias habiles con anticipación para el registro
		AsConceptoacceso obj = (AsConceptoacceso) getFacAsistencia().getAsConceptoaccesoServicio()
				.obtenerPorId(new AsConceptoaccesoPk(dw_1.getConceptoacceso()));

		if (!UValidador.esNulo(obj)) {
			if ("S".equals(obj.getFlagdiasanticipacion())) {
				Integer diasHabiles = getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(new Date(),
						dw_1.getFecha());
				if (diasHabiles < obj.getDiasanticipacion().intValue()) {
					setMessageError("Para adelantar vacaciones estas deben generarse con "
							+ obj.getDiasanticipacion().intValue() + " días hábiles de anticipación.");
					return false;
				}
			}
		}

		// 5. Si tiene menos de un mes de empleado no puede solicitar
		Empleadomast empleado = getFacCore().getEmpleadomastServicio().obtenerEmpleadoMast(dw_1.getEmpleado());
		if (!UValidador.esNulo(empleado)) {
			if (UFechaHora.obtenerDiferenciaMeses(empleado.getFechaingreso(), new Date()) < 1) {
				setMessageError("Para adelantar vacaciones el empleado debe tener más de un mes en la entidad. ");
				return false;
			}
		}

		// 6. máximo 22 días habiles en el periodo actual
		@SuppressWarnings("unchecked")
		List<DtoAsAutorizacion> listaVacaciones = getFacAsistencia().getAsAutorizacionServicio()
				.listarSolicitudesPeriodo(dw_1.getEmpleado(), dw_1.getConceptoacceso(), fechainiOriginal,
						fechafinOriginal, periodo);

		Integer diasv = 0;
		// Integer diasnv = 0;

		if (!UValidador.esListaVacia(listaVacaciones)) {
			for (DtoAsAutorizacion objVaca : listaVacaciones) {
				// acumulando los dias de vavcaciones solo 22 días hábiles
				diasv = diasv + getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(objVaca.getFecha(),
						objVaca.getFechahasta());
				// diasnv = diasnv +
				// (UFechaHora.obtenerDiasTranscurridos(objVaca.getFechahasta(),
				// objVaca.getFecha()) + 1)
				// - diasv;
			}

			diasv = diasv
					+ getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(dw_1.getFecha(), dw_1.getFechafin());

			if (diasv > 22) {
				setMessageError("La cantidad de días hábiles acumuladas en el periodo serían " + diasv
						+ ". Lo cuál supería la cantidad máxima de días hábiles para adelanto de vacaciones: " + 22);
				return false;
			}
		}

		return true;
	}

	private boolean validarVacaciones() throws Exception {
		if (!getFacSeguridad().getSeguridadautorizacionesServicio()
				.tieneAccesoSysAdm(getUsuarioActual().getAplicacionCodigo(), getUsuarioActual().getCodigoUsuario())) {

		}

		Integer wdifdia = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1;
		if (wdifdia <= 6) {
			setMessageError("El periodo vacacional debe ser de un mínimo de 7 días.");
			return false;
		}

		if (UFechaHora.obtenerNumeroDiaSemana(dw_1.getFecha()) != 7) {

			if (UFechaHora.obtenerNumeroDiaSemana(dw_1.getFechafin()).equals(6)
					|| UFechaHora.obtenerNumeroDiaSemana(dw_1.getFechafin()).equals(7)) {
				setMessageError("La fecha final no es correcta, debe incluir los días de fin de semana");
				return false;
			}
		}

		// Validando si existe papeleta en la misma fecha (validar en calidad
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")
				|| CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
						.equalsIgnoreCase("Update")) {
			w_count = getFacAsistencia().getAsAutorizacionServicio().obtenerCantidadPapeletaFechas(
					BigDecimal.valueOf(dw_1.getEmpleado()), dw_1.getFecha(), dw_1.getFechafin(), fechainiOriginal,
					fechafinOriginal);

			if (w_count > 0) {
				setMessageError("Ya existe otra papeleta dentro de las fechas indicadas.");
				return false;
			}

		}

		// Verificando si tiene acumulado
		BigDecimal pendientes = BigDecimal.ZERO;
		Integer periodo = 0;
		Integer count = 0;
		Integer dias = 0;
		BigDecimal derecho = BigDecimal.ZERO;
		BigDecimal programados = BigDecimal.ZERO;
		BigDecimal utilizados = BigDecimal.ZERO;
		BigDecimal solicitados = BigDecimal.ZERO;
		BigDecimal adelantos = BigDecimal.ZERO;
		BigDecimal fraccionadosdias = BigDecimal.ZERO;
		BigDecimal fraccionadoshoras = BigDecimal.ZERO;

		List<DtoPrVacacionPeriodo> val1 = null;

		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
			val1 = getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(
					dw_1.getEmpleado(), dw_1.getFecha(), fechainiOriginal, fechafinOriginal, "M",
					dw_1.getConceptoacceso());
		}
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
			val1 = getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(
					dw_1.getEmpleado(), dw_1.getFecha(), fechainiOriginal, fechafinOriginal, "N",
					dw_1.getConceptoacceso());
		}

		if (!UValidador.esListaVacia(val1)) {
			pendientes = val1.get(0).getPendientes();
			programados = val1.get(0).getProgramados();
			utilizados = val1.get(0).getUtilizados();
			solicitados = val1.get(0).getSolicitados();
			fraccionadosdias = val1.get(0).getFraccionadosdias();
			fraccionadoshoras = val1.get(0).getFraccionadoshoras();
			adelantos = val1.get(0).getAdelantos();
		}

		// si editamos no se debe considerar los dias solicitados en el momento
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
			// int diasactuales =
			// UFechaHora.obtenerDiasTranscurridos(fechafinOriginal,
			// fechainiOriginal);
			if (UValidador.esNulo(pendientes)) {
				pendientes = BigDecimal.ZERO;
			}
			// pendientes =
			// pendientes.subtract(BigDecimal.valueOf(diasactuales));
		}

		if (pendientes.compareTo(BigDecimal.valueOf(wdifdia)) == -1) {
			setMessageError(
					"No puede agregar una papeleta por Vacaciones porque los días indicados es mayor a los días pendientes: "
							+ "Pendientes: " + pendientes + ", " + "Vacaciones solicitadas: " + solicitados + ", "
							+ "Vacaciones programadas: " + programados + ", " + "Vacaciones utilizadas: " + utilizados
							+ ", " + "Fraccionamiento días: " + fraccionadosdias + ", " + "Fraccionamiento horas: "
							+ fraccionadoshoras + ", " + "Vacaciones adelantadas: " + adelantos
							+ ". Por favor de consultar a URH.");
			return false;
		}

		// if (pendientes.intValue() > wdifdia) {
		// List<DtoPrVacacionesprogramadas> val2 =
		// getFacPlanilla().getPrVacacionesprogramadasServicio()
		// .obtenerDiasUitlesPorEmpleado(dw_1.getEmpleado());
		// if (!UValidador.esListaVacia(val2)) {
		// periodo = val2.get(0).getNumeroperiodo().intValue();
		// count = val2.get(0).getDiasutiles().intValue();
		// dias = val2.get(0).getDiasutilizacion().intValue();
		// }
		//
		// if (dias.equals(30)) {
		// periodo = periodo + 1;
		//
		// List<DtoPrVacacionPeriodo> val3 =
		// getFacPlanilla().getPrVacacionesprogramadasServicio()
		// .obtenerDerechoPorEmpleado(dw_1.getEmpleado(), periodo);
		// if (!UValidador.esListaVacia(val3)) {
		// derecho = val3.get(0).getDerecho();
		// }
		//
		// if (derecho.equals(BigDecimal.ZERO)) {
		// setMessageError(
		// "No puede agregar una papeleta por Vacaciones porque no tiene derecho
		// para salir, favor de consultar a URH.");
		// return false;
		// }
		//
		// if (wdifdia > derecho.intValue()) {
		// setMessageError("La cantidad de días supera el derecho acumulado
		// hasta el momento.");
		// return false;
		// }
		//
		// } else {
		// // Si es mayor a 30 no debe pasar
		// if (dias > 30) {
		//
		// setMessageError("No puede grabar la papeleta porque superó los 30
		// días del periodo actual.");
		// return false;
		// }
		// // Verificar si cumple los los 30 días incluyedo el intervalo de
		// // fechas
		// if ((wdifdia + dias) == 30) {
		// // Cuantos fines de semana tendría
		// Integer existe = UFechaHora.contarFinesDeSemanas(dw_1.getFecha(),
		// dw_1.getFechafin());
		// Integer suma = count + existe;
		//
		// if (suma < 8) {
		// setMessageError("Para grabar la papeleta debe tener 2 fines de
		// semana.");
		// return false;
		// }
		// }
		// }
		// }

		return validarVacaciones2();
	}

	private boolean validarVacaciones2() throws Exception {

		BigDecimal derechoano = BigDecimal.valueOf(30);

		if (getUsuarioActual().getTipoPlanilla().equals("PR") || getUsuarioActual().getTipoPlanilla().equals("SG")) {
			derechoano = getFacCore().getParametrosmastServicio()
					.obtenerValorDecimal(new ParametrosmastPk("PR", "999999", "DIAVACPRAC"));
		}
		if (getUsuarioActual().getTipoPlanilla().equals("EC")) {
			derechoano = getFacCore().getParametrosmastServicio()
					.obtenerValorDecimal(new ParametrosmastPk("PR", "999999", "DIASVACCAS"));
		}

		if (getUsuarioActual().getTipoPlanilla().equals("EM")) {
			derechoano = getFacCore().getParametrosmastServicio()
					.obtenerValorDecimal(new ParametrosmastPk("PR", "999999", "DIASVAC728"));
		}

		// if (UValidador.esCero(derechoano.compareTo(BigDecimal.ZERO))) {
		// setMessageError("El Tipo de Planilla no tiene definido dias de
		// vacaciones ("
		// + getUsuarioActual().getTipoPlanilla() + ") - Favor revisar
		// parámetros.");
		// return false;
		// }

		// if (UFechaHora.obtenerFechaParte(dw_1.getFecha(), "MM") <=
		// UFechaHora.obtenerFechaParte(new Date(), "MM")
		// && UFechaHora.obtenerFechaParte(dw_1.getFecha(), "YY") ==
		// UFechaHora.obtenerFechaParte(new Date(),
		// "YY")) {
		// setMessageError("El periodo vacacional debe ser posterior al mes
		// actual.");
		// return false;
		// }
		//

		if (dw_1.getFecha().before(new Date()) || ((dw_1.getFecha().getYear() <= new Date().getYear()
				&& dw_1.getFecha().getMonth() <= new Date().getMonth())
				|| (dw_1.getFecha().getYear() < new Date().getYear()
						&& dw_1.getFecha().getMonth() > new Date().getMonth()))) {
			setMessageError("El periodo vacacional debe ser posterior al mes actual.");
			return false;
		}

		// No se puede reprogramar una papeleta con fecha de inicio menor al mes
		// actual
		if ("S".equals(getFacCore().getParametrosmastServicio()
				.obtenerValorCadena(new ParametrosmastPk("AS", "999999", "PROGMESACT")))) {
			if ("S".equals(getFacCore().getParametrosmastServicio()
					.obtenerValorCadena(new ParametrosmastPk("AS", "999999", "PROGTODMES")))) {
				if (UFechaHora.obtenerTime(dw_1.getFecha(), "dd/MM/yyyy") < UFechaHora
						.obtenerTime(UFechaHora.obtenerPrimerDiaMesFecha(new Date()), "dd/MM/yyyy")) {
					setMessageError("La fecha de inicio de vacaciones debe ser apartir del mes actual");
					return false;
				}
			} else {
				if (UFechaHora.obtenerTime(dw_1.getFecha(), "dd/MM/yyyy") < UFechaHora.obtenerTime(new Date(),
						"dd/MM/yyyy")) {
					setMessageError("La fecha de inicio de vacaciones debe ser mayor a la fecha actual.");
					return false;
				}
			}

		} else {
			if (dw_1.getFecha().before(new Date()) || ((dw_1.getFecha().getYear() <= new Date().getYear()
					&& dw_1.getFecha().getMonth() <= new Date().getMonth())
					|| (dw_1.getFecha().getYear() < new Date().getYear()
							&& dw_1.getFecha().getMonth() > new Date().getMonth()))) {
				setMessageError("La fecha de inicio de vacaciones debe ser posterior al mes actual.");
				return false;
			}
		}

		Integer wdifdia = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1;
		int diasfds = UFechaHora.contarFinesDeSemanas(dw_1.getFecha(), dw_1.getFechafin());

		if (UFechaHora.obtenerFechaParte(dw_1.getFecha(), "YY")
				.equals(UFechaHora.obtenerFechaParte(dw_1.getFechafin(), "YY"))) {

			if (wdifdia > derechoano.intValue()) {
				setMessageError("El empleado tipo " + getUsuarioActual().getTipoPlanilla()
						+ " No puede programar más de " + derechoano.intValue() + " días en el Año o Periodo Actual.");
				return false;
			}

			if (wdifdia > 30) {
				setMessageError("No puede programar más de 30 días en el Año o Periodo");
				return false;
			} else {

				if (getUsuarioActual().getTipoPlanilla().equals("PR")) {
					if (wdifdia > 6 && wdifdia < 9) {
						if (diasfds < 2) {
							setMessageError("Las vacaciones de Practicantes deben incluir 2 días de fin de semana.");
							return false;
						}
					} else if (wdifdia == 15) {
						if (diasfds < 4) {
							setMessageError("Las vacaciones de Practicantes deben incluir 4 días de fin de semana.");
							return false;
						}
					} else {
						setMessageError("Las vacaciones de Practicantes no cumplen con las condiciones especificadas.");
						return false;
					}
				} else {
					if (wdifdia > 6 && wdifdia < 10) {
						if (diasfds < 2) {
							setMessageError("Las vacaciones deben incluir 2 días de fin de semana.");
							return false;
						}
					} else if (wdifdia > 13 && wdifdia < 17) {
						if (diasfds < 4) {
							setMessageError("Las vacaciones deben incluir 4 días de fin de semana.");
							return false;
						}
					} else if (wdifdia > 20 && wdifdia < 24) {
						if (diasfds < 6) {
							setMessageError("Las vacaciones deben incluir 6 días de fin de semana.");
							return false;
						}
					} else if (wdifdia > 29 && wdifdia < 31) {
						if (diasfds < 8) {
							setMessageError("Las vacaciones deben incluir 8 días de fin de semana.");
							return false;
						}
					} else {
						setMessageError("Las vacaciones no cumplen con los días reglamentados");
						return false;
					}

				}

			}
		} else {
			if (wdifdia > 30) {
				setMessageError("No puede programar más de 30 días en el Año o Periodo");
				return false;
			} else {

				if (getUsuarioActual().getTipoPlanilla().equals("PR")) {
					if (wdifdia > 6 && wdifdia < 9) {
						if (diasfds < 2) {
							setMessageError("Las vacaciones de Practicantes deben incluir 2 días de fin de semana.");
							return false;
						}
					} else if (wdifdia == 15) {
						if (diasfds < 4) {
							setMessageError("Las vacaciones de Practicantes deben incluir 4 días de fin de semana.");
							return false;
						}
					} else {
						setMessageError("Las vacaciones de Practicantes no cumplen con las condiciones especificadas.");
						return false;
					}
				} else {
					if (wdifdia > 6 && wdifdia < 10) {
						if (diasfds < 2) {
							setMessageError("Las vacaciones deben incluir 2 días de fin de semana.");
							return false;
						}
					} else if (wdifdia > 13 && wdifdia < 17) {
						if (diasfds < 4) {
							setMessageError("Las vacaciones deben incluir 4 días de fin de semana.");
							return false;
						}
					} else if (wdifdia > 20 && wdifdia < 24) {
						if (diasfds < 6) {
							setMessageError("Las vacaciones deben incluir 6 días de fin de semana.");
							return false;
						}
					} else if (wdifdia > 29 && wdifdia < 31) {
						if (diasfds < 8) {
							setMessageError("Las vacaciones deben incluir 8 días de fin de semana.");
							return false;
						}
					} else {
						setMessageError("Las vacaciones no cumplen con los días reglamentados.");
						return false;
					}

				}
			}
		}

		return true;
	}

	// este metodo sera llamado sde popup aviso
	public String validarFechaFin() throws Exception {
		if (validarfechas) {
			if (dw_1.getFechafin().after(UFechaHora.obtenerFechaMasdias(new Date(), 365))) {
				getWebControlContext().actualizar("dgAvisoSiNo");
				getWebControlContext().ejecutar("PF('popAvisoSiNo').show()");
				validarfechas = false;
			}
		} else {
			validarfechas = validarDespuesdeFechas();
		}

		// if (!UValidador.esCero(wf_update())) {
		// CwAsAutorizacionReprogramacionVacaciones.getInstance().buscar();
		// }

		// getWebControlContext().ejecutar("PF('popNuevaAutorizacion').hide()");
		getWebControlContext().ejecutar("PF('popAvisoSiNo').hide()");

		return null;

	}

	/*
	 * wf_validate()
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Boolean validarDespuesdeFechas() throws Exception {

		tl_desde = dw_1.getDesde1();
		tl_hasta = dw_1.getHasta1();

		List<DtoDwAsAutorizacionPreprocesoTipodia> lds_tipodia = new ArrayList<DtoDwAsAutorizacionPreprocesoTipodia>();

		if (!UValidador.esNulo(dw_1.getFechafin()) && !UValidador.esNulo(tl_desde) && !UValidador.esNulo(tl_hasta)) {
			if ((tl_desde.after(tl_hasta) && UValidador.esCero(UFechaHora.obtenerFechaHoraInicioDiaDate(dw_1.getFecha())
					.compareTo(UFechaHora.obtenerFechaHoraInicioDiaDate(dw_1.getFechafin()))))
					&& opciones.getIsmostrardesde1() && opciones.getIsmostrarhasta1()) {
				if (!ishorariodiasiguiente) {
					setMessageError("La hora inicial debe ser menor a la hora final.");
					return false;
				}
			}
		}

		dw_1.setDesde1(UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), tl_desde));
		dw_1.setHasta1(UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), tl_hasta));

		CampoHorasVisible = (opciones.getIsmostrardesde1() && opciones.getIshabilitardesde1()) ? 1 : 0; // 1=visible;
		if (!UValidador.esNulo(tl_desde) && !UValidador.esNulo(tl_hasta)) {
			if ((UValidador.esCero(tl_desde.compareTo(tl_hasta)) && !w_CategoriaAutorizacion.equals("OMIS"))
					&& CampoHorasVisible == 1) {
				// cuando es autorizacion no se debe validar esto
				if (!w_CategoriaAutorizacion.equals("SOBR")) {
					setMessageError("La hora inicial debe ser distinta a la hora final.");
					return false;
				}
			}
		}

		tl_desde = dw_1.getDesde2();
		tl_hasta = dw_1.getHasta2();

		dw_1.setDesde2(UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), tl_desde));
		dw_1.setHasta2(UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), tl_hasta));

		empleadoval = dw_1.getEmpleado();
		conceptoaccesoval = dw_1.getConceptoacceso();

		List data = getFacAsistencia().getAsConceptoaccesoServicio().obtenerExpresadoen(conceptoaccesoval);

		if (!UValidador.esListaVacia(data)) {
			ls_EXPRESADOEN = ((DtoAsConceptoacceso) data.get(0)).getExpresadoen();
		}

		if (UValidador.estaVacio(ls_EXPRESADOEN)) {
			ls_EXPRESADOEN = "H";
		}

		if (UValidador.estaVacio(conceptoaccesoval)) {
			setMessageError("Debe ingresar un concepto de acceso");
			return false;
		}

		// Fecha
		fechaval = dw_1.getFecha();
		fechafin = dw_1.getFechafin();

		// Hora
		desde = dw_1.getDesde1();
		hasta = dw_1.getHasta1();

		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")
				|| CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
						.equalsIgnoreCase("Update")) {
			ld_temporal = fechaval;

			while (ld_temporal.before(fechafin)) {

				ldt_tempd = UFechaHora.obtenerFechaCompuesta(ld_temporal, desde);
				ldt_temph = UFechaHora.obtenerFechaCompuesta(ld_temporal, hasta);

				ll_val_01 = 10000000;
				ll_val_02 = 1000;

				ls_desde1 = opciones.getIsmostrardesde1() ? "1" : "0";
				ls_hasta1 = opciones.getIsmostrarhasta1() ? "1" : "0";

				// la cantidad de ceros lo toma de ll_val_01 y ll_val_02
				String suma1 = UFechaHora.obtenerFechaParte(ldt_tempd, "YY") + "0000000000";

				if (ls_desde1.equals("1")) {

					ll_d_1 = (long) (Long.valueOf(suma1)
							+ UFechaHora.obtenerFechaParte(ldt_tempd, "MM") * ll_val_01 * 10
							+ UFechaHora.obtenerFechaParte(ldt_tempd, "DD") * 1000000);

					LOGGER.debug("ll_d_1 " + ll_d_1);

					ll_d_2 = UFechaHora.obtenerFechaParte(ldt_tempd, "HH") * 10000
							+ UFechaHora.obtenerFechaParte(ldt_tempd, "MI") * 100
							+ UFechaHora.obtenerFechaParte(ldt_tempd, "SS");
				} else {
					ll_d_1 = (long) (Long.valueOf(suma1)
							+ UFechaHora.obtenerFechaParte(ldt_tempd, "MM") * ll_val_01 * 10
							+ UFechaHora.obtenerFechaParte(ldt_tempd, "DD") * 1000000);

					ll_d_2 = 0 * 10000 + 0 * 100 + 0;
				}

				if (ls_hasta1.equals("1")) {
					ll_h_1 = (long) (Long.valueOf(suma1)
							+ UFechaHora.obtenerFechaParte(ldt_temph, "MM") * ll_val_01 * 10
							+ UFechaHora.obtenerFechaParte(ldt_temph, "DD") * 1000000);

					ll_h_2 = UFechaHora.obtenerFechaParte(ldt_temph, "HH") * 10000
							+ UFechaHora.obtenerFechaParte(ldt_temph, "MI") * 100
							+ UFechaHora.obtenerFechaParte(ldt_temph, "SS");
				} else if (ls_desde1.equals("1")) {
					ll_h_1 = (long) (Long.valueOf(suma1)
							+ UFechaHora.obtenerFechaParte(ldt_tempd, "MM") * ll_val_01 * 10
							+ UFechaHora.obtenerFechaParte(ldt_tempd, "DD") * 1000000);

					ll_h_2 = UFechaHora.obtenerFechaParte(ldt_tempd, "HH") * 10000
							+ UFechaHora.obtenerFechaParte(ldt_tempd, "MI") * 100
							+ UFechaHora.obtenerFechaParte(ldt_tempd, "SS");
				} else {
					ll_h_1 = (long) (Long.valueOf(suma1)
							+ UFechaHora.obtenerFechaParte(ldt_temph, "MM") * ll_val_01 * 10
							+ UFechaHora.obtenerFechaParte(ldt_temph, "DD") * 1000000);

					ll_h_2 = 23 * 10000 + 59 * 100 + 59;
				}

				// Regla
				if (w_CategoriaAutorizacion.equals("SOBR")) {
					ls_similares = "PMP";
					ls_similares_2_all = "S";
				} else if (w_CategoriaAutorizacion.equals("PMP")) {
					ls_similares = "SOBR";
					ls_similares_2_all = "S";
				} else if (w_CategoriaAutorizacion.equals("COMP")) {
					if (conceptoaccesoval.equals("01")) {
						ls_similares = "OTRO";
						ls_similares_2 = "04";
						ls_similares_3 = "05";
						ls_similares_4 = "02";
						ls_similares_5 = "21";
						ls_similares_6 = "03";
						ls_similares_7 = "CMED";
						ls_similares_8 = "18";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("02")) {
						ls_similares = "OTRO";
						ls_similares_2 = "04";
						ls_similares_3 = "01";
						ls_similares_4 = "05";
						ls_similares_5 = "21";
						ls_similares_6 = "03";
						ls_similares_7 = "CMED";
						ls_similares_8 = "18";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("03")) {
						ls_similares = "OTRO";
						ls_similares_2 = "04";
						ls_similares_3 = "01";
						ls_similares_4 = "02";
						ls_similares_5 = "21";
						ls_similares_6 = "05";
						ls_similares_7 = "CMED";
						ls_similares_8 = "18";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("04")) {
						ls_similares = "OTRO";
						ls_similares_2 = "05";
						ls_similares_3 = "01";
						ls_similares_4 = "02";
						ls_similares_5 = "21";
						ls_similares_6 = "03";
						ls_similares_7 = "CMED";
						ls_similares_8 = "18";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("05")) {
						ls_similares = "OTRO";
						ls_similares_2 = "04";
						ls_similares_3 = "01";
						ls_similares_4 = "02";
						ls_similares_5 = "21";
						ls_similares_6 = "03";
						ls_similares_7 = "CMED";
						ls_similares_8 = "18";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("18")) {
						ls_similares = "OTRO";
						ls_similares_2 = "04";
						ls_similares_3 = "01";
						ls_similares_4 = "02";
						ls_similares_5 = "21";
						ls_similares_6 = "05";
						ls_similares_7 = "03";
						ls_similares_8 = "CMED";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("19")) {
						ls_similares = "OTRO";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("21")) {
						ls_similares = "OTRO";
						ls_similares_2 = "04";
						ls_similares_3 = "01";
						ls_similares_4 = "02";
						ls_similares_5 = "05";
						ls_similares_6 = "03";
						ls_similares_7 = "CMED";
						ls_similares_8 = "18";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("23")) {
						ls_similares = "OTRO";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("33")) {
						ls_similares = "OTRO";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("CMED")) {
						ls_similares = "OTRO";
						ls_similares_2 = "04";
						ls_similares_3 = "01";
						ls_similares_4 = "02";
						ls_similares_5 = "21";
						ls_similares_6 = "05";
						ls_similares_7 = "03";
						ls_similares_8 = "18";
						ls_similares_2_all = "N";
					} else {
						ls_similares = w_CategoriaAutorizacion;
						ls_similares_2_all = "S";
					}
				} else if (w_CategoriaAutorizacion.equals("OTRO")) {
					if (conceptoaccesoval.equals("01")) {
						ls_similares = "COMP";
						ls_similares_2 = "04";
						ls_similares_3 = "05";
						ls_similares_4 = "02";
						ls_similares_5 = "21";
						ls_similares_6 = "03";
						ls_similares_7 = "CMED";
						ls_similares_8 = "18";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("02")) {
						ls_similares = "COMP";
						ls_similares_2 = "04";
						ls_similares_3 = "01";
						ls_similares_4 = "05";
						ls_similares_5 = "21";
						ls_similares_6 = "03";
						ls_similares_7 = "CMED";
						ls_similares_8 = "18";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("03")) {
						ls_similares = "COMP";
						ls_similares_2 = "04";
						ls_similares_3 = "01";
						ls_similares_4 = "02";
						ls_similares_5 = "21";
						ls_similares_6 = "05";
						ls_similares_7 = "CMED";
						ls_similares_8 = "18";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("04")) {
						ls_similares = "COMP";
						ls_similares_2 = "05";
						ls_similares_3 = "01";
						ls_similares_4 = "02";
						ls_similares_5 = "21";
						ls_similares_6 = "03";
						ls_similares_7 = "CMED";
						ls_similares_8 = "18";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("05")) {
						ls_similares = "COMP";
						ls_similares_2 = "04";
						ls_similares_3 = "01";
						ls_similares_4 = "02";
						ls_similares_5 = "21";
						ls_similares_6 = "03";
						ls_similares_7 = "CMED";
						ls_similares_8 = "18";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("07")) {
						ls_similares = "COMP";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("08")) {
						ls_similares = "COMP";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("14")) {
						ls_similares = "COMP";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("15")) {
						ls_similares = "COMP";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("21")) {
						ls_similares = "COMP";
						ls_similares_2 = "04";
						ls_similares_3 = "01";
						ls_similares_4 = "02";
						ls_similares_5 = "05";
						ls_similares_6 = "03";
						ls_similares_7 = "CMED";
						ls_similares_8 = "18";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("18")) {
						ls_similares = "COMP";
						ls_similares_2 = "04";
						ls_similares_3 = "01";
						ls_similares_4 = "02";
						ls_similares_5 = "21";
						ls_similares_6 = "05";
						ls_similares_7 = "03";
						ls_similares_8 = "CMED";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("19")) {
						ls_similares = "COMP";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("22")) {
						ls_similares = "COMP";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("24")) {
						ls_similares = "COMP";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("25")) {
						ls_similares = "COMP";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("26")) {
						ls_similares = "COMP";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("28")) {
						ls_similares = "COMP";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("29")) {
						ls_similares = "COMP";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("30")) {
						ls_similares = "COMP";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("CMED")) {
						ls_similares = "COMP";
						ls_similares_2 = "04";
						ls_similares_3 = "01";
						ls_similares_4 = "02";
						ls_similares_5 = "21";
						ls_similares_6 = "05";
						ls_similares_7 = "03";
						ls_similares_8 = "18";
						ls_similares_2_all = "N";
					} else if (conceptoaccesoval.equals("INAS")) {
						ls_similares = "COMP";
						ls_similares_2_all = "N";
					} else {
						ls_similares = w_CategoriaAutorizacion;
						ls_similares_2_all = "S";
					}

				}

				else {
					ls_similares = w_CategoriaAutorizacion;
					ls_similares_2_all = "S";
				}

				if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
						.equalsIgnoreCase("Update")) {

					count = getFacAsistencia().getAsAutorizacionServicio().obtenercantidadedicion(empleadoval, ll_d_1,
							ll_h_1, ll_d_2, ll_h_2, conceptoaccesoval, ls_similares_2, ls_similares_3, ls_similares_4,
							ls_similares_5, ls_similares_6, ls_similares_7, ls_similares_8, ls_similares_2_all,
							w_CategoriaAutorizacion, ls_similares, fechaoriginal, conceptoacceso, fechadesdeoriginal);

					if (count > 0) {
						if (!dw_1.getConceptoacceso().equals("CHOR")) {
							setMessageError("Registro ingresado con los mismos datos");
							return false;
						}
					}
				}

				if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
					count = getFacAsistencia().getAsAutorizacionServicio().obtenercantidad(empleadoval, ll_d_1, ll_h_1,
							ll_d_2, ll_h_2, conceptoaccesoval, ls_similares_2, ls_similares_3, ls_similares_4,
							ls_similares_5, ls_similares_6, ls_similares_7, ls_similares_8, ls_similares_2_all,
							w_CategoriaAutorizacion, ls_similares);
					if (count > 0) {
						if (!dw_1.getConceptoacceso().equals("CHOR")) {
							setMessageError("Registro ingresado con los mismos datos");
							return false;
						}
					}
				}

				w_tipodia = getFacAsistencia().getAS().getAsrepusFuncion().FSqlDevuelveHorario(empleadoval, ldt_tempd);

				if (UValidador.esNulo(w_tipodia)) {
					w_tipodia = 0;
				}

				List data1 = getFacAsistencia().getAsTipodiamovimientoServicio()
						.obtenerHoraInicioFlagDiaAnterior(w_tipodia);
				if (!UValidador.esListaVacia(data1)) {
					ldt_horainicio = ((DtoAsTipodiamovimiento) data1.get(0)).getHorainicio();
					ls_FlagDiaAnt = ((DtoAsTipodiamovimiento) data1.get(0)).getFlagdiaant();
				}

				List data2 = getFacAsistencia().getAsTipodiamovimientoServicio().obtenerHoraFin(w_tipodia);
				if (!UValidador.esListaVacia(data2)) {
					ldt_horafin = ((DtoAsTipodiamovimiento) data2.get(0)).getHorafin();
					// si la hora de fin es a la meda noche le
					// aumentamos un dia para que sea mayor
					if (!UValidador.esNulo(ldt_horafin)) {
						if (ldt_horafin.getHours() == 0 && ldt_horafin.getMinutes() == 0
								&& ldt_horafin.getSeconds() == 0) {
							ldt_horafin = UFechaHora.obtenerFechaHoraFinDia(ldt_horafin);
						}
					}

				}

				List data3 = getFacAsistencia().getAsTipodiamovimientoServicio().obtenerMaxIntervaloAcceso(w_tipodia);
				if (!UValidador.esListaVacia(data3)) {
					ls_INTERVALOACCESO = ((DtoAsTipodiamovimiento) data3.get(0)).getIntervaloacceso();
				}

				if (!UValidador.esCero(w_tipodia)) {

					// validamos
					if (UValidador.esNulo(ls_FlagDiaAnt)) {
						ls_FlagDiaAnt = "N";
					}

					if (ls_FlagDiaAnt.equals("S")) {
						ldt_desde_horario = UFechaHora
								.obtenerFechaCompuesta(UFechaHora.obtenerFechaMasdias(ldt_tempd, -1), ldt_horainicio);
					} else {
						ldt_desde_horario = UFechaHora.obtenerFechaCompuesta(ldt_tempd, ldt_horainicio);
					}

					if (ls_FlagDiaAnt.equals("S")) {
						if ((UFechaHora.obtenerFechaParte(ldt_horainicio, "HH") * 100 + UFechaHora.obtenerFechaParte(
								ldt_horainicio, "MI")) > (UFechaHora.obtenerFechaParte(ldt_horafin, "HH") * 100
										+ UFechaHora.obtenerFechaParte(ldt_horafin, "MI"))) {
							ldt_hasta_horario = UFechaHora.obtenerFechaCompuesta(ldt_temph, ldt_horafin);
						} else {
							ldt_hasta_horario = UFechaHora
									.obtenerFechaCompuesta(UFechaHora.obtenerFechaMasdias(ldt_temph, -1), ldt_horafin);
						}
					} else {
						if ((UFechaHora.obtenerFechaParte(ldt_horainicio, "HH") * 100 + UFechaHora.obtenerFechaParte(
								ldt_horainicio, "MI")) > (UFechaHora.obtenerFechaParte(ldt_horafin, "HH") * 100
										+ UFechaHora.obtenerFechaParte(ldt_horafin, "MI"))) {
							ldt_hasta_horario = UFechaHora
									.obtenerFechaCompuesta(UFechaHora.obtenerFechaMasdias(ldt_temph, -1), ldt_horafin);
						} else {
							ldt_hasta_horario = UFechaHora.obtenerFechaCompuesta(ldt_temph, ldt_horafin);
						}
					}

					ldt_desde_ingreso = UFechaHora.obtenerFechaCompuesta(ldt_tempd, ldt_tempd);

					if ((UFechaHora.obtenerFechaParte(ldt_tempd, "HH") * 100 + UFechaHora.obtenerFechaParte(ldt_tempd,
							"MI")) > (UFechaHora.obtenerFechaParte(ldt_temph, "HH") * 100
									+ UFechaHora.obtenerFechaParte(ldt_temph, "MI"))) {
						ldt_hasta_ingreso = UFechaHora
								.obtenerFechaCompuesta(UFechaHora.obtenerFechaMasdias(ldt_temph, 1), ldt_temph);
					} else {
						ldt_hasta_ingreso = UFechaHora.obtenerFechaCompuesta(ldt_temph, ldt_temph);
					}

					// variables alternas
					String sumadeshor = UFechaHora.obtenerFechaParte(ldt_desde_horario, "YY") + "0000000000";
					String sumahashor = UFechaHora.obtenerFechaParte(ldt_hasta_horario, "YY") + "0000000000";
					String sumadesing = UFechaHora.obtenerFechaParte(ldt_desde_ingreso, "YY") + "0000000000";
					String sumahasing = UFechaHora.obtenerFechaParte(ldt_hasta_ingreso, "YY") + "0000000000";

					ll_d_1 = (long) (Long.valueOf(sumadeshor)
							+ UFechaHora.obtenerFechaParte(ldt_desde_horario, "MM") * ll_val_01 * 10
							+ UFechaHora.obtenerFechaParte(ldt_desde_horario, "DD") * 1000000
							+ UFechaHora.obtenerFechaParte(ldt_desde_horario, "HH") * 10000
							+ UFechaHora.obtenerFechaParte(ldt_desde_horario, "MI") * 100
							+ UFechaHora.obtenerFechaParte(ldt_desde_horario, "SS"));

					ll_h_1 = (long) (Long.valueOf(sumahashor)
							+ UFechaHora.obtenerFechaParte(ldt_hasta_horario, "MM") * ll_val_01 * 10
							+ UFechaHora.obtenerFechaParte(ldt_hasta_horario, "DD") * 1000000
							+ UFechaHora.obtenerFechaParte(ldt_hasta_horario, "HH") * 10000
							+ UFechaHora.obtenerFechaParte(ldt_hasta_horario, "MI") * 100
							+ UFechaHora.obtenerFechaParte(ldt_hasta_horario, "SS"));

					ll_d_2 = (long) (Long.valueOf(sumadesing)
							+ UFechaHora.obtenerFechaParte(ldt_desde_ingreso, "MM") * ll_val_01 * 10
							+ UFechaHora.obtenerFechaParte(ldt_desde_ingreso, "DD") * 1000000
							+ UFechaHora.obtenerFechaParte(ldt_desde_ingreso, "HH") * 10000
							+ UFechaHora.obtenerFechaParte(ldt_desde_ingreso, "MI") * 100
							+ UFechaHora.obtenerFechaParte(ldt_desde_ingreso, "SS"));

					ll_h_2 = (long) (Long.valueOf(sumahasing)
							+ UFechaHora.obtenerFechaParte(ldt_hasta_ingreso, "MM") * ll_val_01 * 10
							+ UFechaHora.obtenerFechaParte(ldt_hasta_ingreso, "DD") * 1000000
							+ UFechaHora.obtenerFechaParte(ldt_hasta_ingreso, "HH") * 10000
							+ UFechaHora.obtenerFechaParte(ldt_hasta_ingreso, "MI") * 100
							+ UFechaHora.obtenerFechaParte(ldt_hasta_ingreso, "SS"));

					if (w_CategoriaAutorizacion.equals("PMP")) {
						if (((ll_d_2 > ll_d_1 && ll_d_2 < ll_h_1) || (ll_h_2 > ll_d_1 && ll_d_2 < ll_h_1))
								&& (ls_INTERVALOACCESO != "SOBR")) {
							setMessageError("Una permanencia por motivos personales debe estar fuera del horario "
									+ UFechaHora.convertirFechaCadena(ldt_desde_horario, "HH:mm") + "	"
									+ UFechaHora.convertirFechaCadena(ldt_hasta_horario, "HH:mm"));
							return false;
						}
					}

					if (!w_CategoriaAutorizacion.equals("OMIS")
							&& (!w_CategoriaAutorizacion.equals("OTRO") || !conceptoaccesoval.equals("VACA"))
							&& !w_CategoriaAutorizacion.equals("PMP") && !w_CategoriaAutorizacion.equals("SOBR")) {
						if (UValidador.esCero(UFechaHora.obtenerFechaParte(ldt_desde_horario, "HH"))
								&& UValidador.esCero(UFechaHora.obtenerFechaParte(ldt_desde_horario, "MI"))
								&& UValidador.esCero(UFechaHora.obtenerFechaParte(ldt_hasta_horario, "HH"))
								&& UValidador.esCero(UFechaHora.obtenerFechaParte(ldt_hasta_horario, "MI"))) {
							setMessageError("No tiene horario asignado para ese día.");
							return false;
						}
					}
				}

				if (w_CategoriaAutorizacion.equals("COMP")) {
					if (ll_d_2 >= ll_d_1 && ll_h_2 <= ll_h_1) {
					} else {
						// cuando es compensación por día (04) no debería
						// considerar las horas
						if (!"04".equals(dw_1.getConceptoacceso())) {
							setMessageError("Una compensación de sobretiempo debe estar dentro del horario " + "	"
									+ (UValidador.estaVacio(UFechaHora.convertirFechaCadena(ldt_desde_horario, "HH:mm"))
											? ""
											: UFechaHora.convertirFechaCadena(ldt_desde_horario, "HH:mm"))
									+ "	"
									+ (UValidador.estaVacio(UFechaHora.convertirFechaCadena(ldt_hasta_horario, "HH:mm"))
											? "" : UFechaHora.convertirFechaCadena(ldt_hasta_horario, "HH:mm")));
							return false;
						}
					}
				}

				if (w_CategoriaAutorizacion.equals("OTRO")) {
					if (ll_d_2 >= ll_d_1 && ll_h_2 <= ll_h_1) {
					} else {
						if (ls_EXPRESADOEN.equals("H")) {
							if (UValidador.esNulo(ldt_horainicio)) {
								ldt_horainicio = UFechaHora.convertirCadenaFecha("01/01/1990", "dd/MM/yyyy");
							}

							if (UValidador.esNulo(ldt_horafin)) {
								ldt_horafin = UFechaHora.convertirCadenaFecha("01/01/1990", "dd/MM/yyyy");
							}
							if (ldt_horainicio.after(ldt_horafin) && desde.before(ldt_horafin)
									&& !hasta.after(ldt_horafin) && !ldt_horainicio.before(desde)) {
							} else {
								if (!conceptoaccesoval.equals("CHOR")) {

									// no se debe incluir ni sabado ni
									// doimngo
									if (!(UFechaHora.obtenerNumeroDiaSemana(ld_temporal).equals(1)
											|| UFechaHora.obtenerNumeroDiaSemana(ld_temporal).equals(7))) {
										setMessageError("Estos eventos deben estar dentro del horario " + "	"
												+ (UValidador.esNulo(ldt_desde_horario) ? ""
														: UFechaHora.convertirFechaCadena(ldt_desde_horario, "HH:mm"))
												+ "	" + (UValidador.esNulo(ldt_hasta_horario) ? ""
														: UFechaHora.convertirFechaCadena(ldt_hasta_horario, "HH:mm")));
										return false;
									}

								}
							}

						}
					}
				}

				AsConceptoacceso objCon = new AsConceptoacceso();
				objCon.getPk().setConceptoacceso(dw_1.getConceptoacceso());

				objCon = (AsConceptoacceso) getFacAsistencia().getAsConceptoaccesoServicio()
						.obtenerPorId(objCon.getPk());

				// no puede solicitar licencia con goce 34 si es que tiene
				// horas autorizadas
				if (!UValidador.esNulo(objCon)) {
					if ("S".equals(objCon.getFlagnumerosrestriccion())
							&& UValidador.esNulo(objCon.getFechainiciorestriccion())) {
						// validacion horas y meses maximo
						BigDecimal horas = objCon.getNumerohorasmesesrestriccion();
						BigDecimal meses = objCon.getCantidadmesesrestriccion();

						if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
								.equalsIgnoreCase("Update")) {
							if (UValidador.esNulo(fechainiOriginal)) {
								fechainiOriginal = dw_1.getFecha();
							}
							if (UValidador.esNulo(fechafinOriginal)) {
								fechafinOriginal = dw_1.getFechafin();
							}
						}

						if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
								.equalsIgnoreCase("Add")) {
							fechainiOriginal = UFechaHora.convertirCadenaFecha("01/01/1900", "dd/MM/yyyy");
							fechafinOriginal = UFechaHora.convertirCadenaFecha("01/01/1900", "dd/MM/yyyy");
						}

						BigDecimal horasConRes = getFacAsistencia().getAsAutorizacionServicio().sumarConRes(
								dw_1.getEmpleado(), dw_1.getConceptoacceso(), dw_1.getFecha(),
								UFechaHora.addMesesToDate(dw_1.getFecha(), meses.intValue()), fechainiOriginal,
								fechafinOriginal);

						BigDecimal w_diftiempo = wf_diftiempo(dw_1.getDesde1(), dw_1.getHasta1())
								.divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_DOWN);
						// no tomar en cuenta el refrigerio
						w_diftiempo = w_diftiempo.subtract(obtenerHorasRefrigerio());

						if ((horasConRes.add(w_diftiempo)).compareTo(horas) == 1) {
							setMessageError("Se está superando la cantidad máximas de horas permitidas (" + horas
									+ ") en el periodo: " + UFechaHora.convertirFechaCadena(dw_1.getFecha(), "MM") + "-"
									+ UFechaHora.convertirFechaCadena(dw_1.getFecha(), "yyyy"));
							return false;
						}
					}

					// if ("34".equals(objCon.getPk().getConceptoacceso())) {
					// BigDecimal horasSobretiempo =
					// getFacAsistencia().getAsAutorizacionServicio()
					// .obtenerHorasSobreTiempoAutorizado(dw_1.getEmpleado());
					// if (horasSobretiempo.compareTo(BigDecimal.ZERO) == 1)
					// {
					// setMessageError("El empleado cuenta con horas Extras
					// Acumuladas.");
					// return false;
					// }
					// double ll_cantidadhorasregistro =
					// UFechaHora.obtenerDiferenciaSegundos(dw_1.getHasta1(),
					// dw_1.getDesde1()) / 3600.0;
					//
					// if (ll_cantidadhorasregistro < 0.5) {
					// setMessageError("El permiso no debe ser menor de 30
					// minutos.");
					// return false;
					// }

					// }

					if (w_CategoriaAutorizacion.equals("SOBR") && conceptoaccesoval.equals("PAHE")) {

						objCon = new AsConceptoacceso();
						objCon.getPk().setConceptoacceso("PAHE");

						objCon = (AsConceptoacceso) getFacAsistencia().getAsConceptoaccesoServicio()
								.obtenerPorId(objCon.getPk());

						fechaparaferiado = UFechaHora.convertirFechaCadena(ld_temporal, "DDMMYYYY");
						for (int i = 0; i < dw_feriados.size(); i++) {
							DtoDwMaPrCalendarioferiadosProcesoSarg obj = dw_feriados.get(i);
							if (obj.getEstado().equals(UConstante.CONSTANTE_ESTADO_ACTIVO)
									&& obj.getFechamesdia().equals(fechaparaferiado)) {
								filaencontrada = i;
							}
						}
						if (filaencontrada >= 0) {
							ib_esferiado = true;
						} else {
							ib_esferiado = false;
						}

						if (!ib_esferiado) {
							lds_tipodia = getFacAsistencia().getAS().getAsmainDatawindow()
									.DwAsAutorizacionPreprocesoTipodia(w_tipodia);

							ld_hora_entrada_t1 = null;
							ld_hora_salida_t1 = null;
							Date auxhora = null;
							for (w_fila = 0; w_fila < lds_tipodia.size(); w_fila++) {
								w_intervaloacceso = lds_tipodia.get(w_fila).getIntervaloacceso();
								auxhora = lds_tipodia.get(w_fila).getHorainicio();

								// if (ld_hora_entrada_t1 == null) {
								ld_hora_entrada_t1 = auxhora;
								// } else {
								// if (auxhora.getTime() <
								// ld_hora_entrada_t1.getTime()) {
								// ld_hora_entrada_t1 = auxhora;
								// }
								// }

								auxhora = lds_tipodia.get(w_fila).getHorafin();

								// if (ld_hora_salida_t1 == null) {
								ld_hora_salida_t1 = auxhora;
								// } else {
								// if (auxhora.getTime() >
								// ld_hora_salida_t1.getTime()) {
								// ld_hora_salida_t1 = auxhora;
								// }
								// }

								if (UValidador.estaVacio(w_intervaloacceso)) {
									w_intervaloacceso = "";
								}

								if (!w_intervaloacceso.equals("FUER") && !w_intervaloacceso.equals("SOBR")) {
									if (!(UFechaHora.obtenerFechaParte(dw_1.getDesde1(), "HH") < UFechaHora
											.obtenerFechaParte(ld_hora_salida_t1, "HH"))
											|| !(UFechaHora.obtenerFechaParte(dw_1.getHasta1(), "HH") > UFechaHora
													.obtenerFechaParte(ld_hora_entrada_t1, "HH"))) {
									} else {
										setMessageError("El rango establecido debe estar fuera del rango "
												+ UFechaHora.convertirFechaCadena(ld_hora_entrada_t1, "HH:mm") + " - "
												+ UFechaHora.convertirFechaCadena(ld_hora_salida_t1, "HH:mm") + ".");
										return false;
									}
								}

							}

						}

						// -----------------------------ACT HOCR 20180223
						// ----------------------------------//
						String ls_FlagNumerosRestriccion = null, ls_fechainiciorestriccion, ls_desderegistro_yyyymm;
						BigDecimal ll_CantidadMesesRestriccion = null, ll_NumeroHorasMesesRestriccion = null,
								ll_CantidadMesesRestriccionCAS = BigDecimal.ZERO;
						double ll_cantidadhorasregistro;
						Date ld_FechaInicioRestriccion = null, ld_fechaingreso = null, ld_fechacorte = null,
								ld_fechainiciobase, ld_fecharegistro, ld_fechainiciotemp;
						Date ld_fechainiciosemestre, ld_fechafinsemestre;
						Date ld_desderegistro, ld_hastaregistro;
						BigDecimal ll_cantidadhoras_hhee;
						// double ll_segundosafter;
						String ls_desde1x, ls_hasta1x, ls_desderegistro_yyyymmDD;
						BigDecimal ll_minutarthhee, ll_minutarthhee2;
						ld_fecharegistro = dw_1.getFecha();
						ld_desderegistro = dw_1.getDesde1();
						ls_desderegistro_yyyymm = UFechaHora.convertirFechaCadena(ld_desderegistro, "YYYYMM");
						ls_desderegistro_yyyymmDD = UFechaHora.convertirFechaCadena(ld_desderegistro, "yyyyMMdd");
						ld_hastaregistro = dw_1.getHasta1();
						BigDecimal ll_cantidadiasfechas;
						BigDecimal ldc_bloquesmeses;
						int ll_bloquesmeses;
						int ll_cantidadbloques;

						if (UFechaHora.convertirFechaCadena(ld_desderegistro, "HH:mm:ss").trim().equals("00:00:00")
								&& UFechaHora.convertirFechaCadena(ld_hastaregistro, "HH:mm:ss").trim()
										.equals("00:00:00")) {
							setMessageError("Para la autorización de Horas Extras, No es valido estas horas.");
							this.opciones.setIsmostrardesde1(true);
							this.opciones.setIsmostrarhasta1(true);

							return false;
						}

						// VALIDAMOS SI EL EMPLEADO ESTÁ EXONERADO
						AsCarnetidentificacion asCarnetidentificacion = getFacAsistencia()
								.getAsCarnetidentificacionServicio().obtenerPorEmplado(dw_1.getEmpleado());
						if (!UValidador.esNulo(asCarnetidentificacion)) {
							if (!"S".equals(asCarnetidentificacion.getFlgexonerasobr())) {
								// verificamos las horas extras por área
								AsArea area = getFacAsistencia().getAsAreaServicio().obtenerArea(
										getUsuarioActual().getIdPersona(), getUsuarioActual().getCompaniaSocioCodigo());
								if ("S".equals(area.getFlagexondirectiva())) {
									// validamos la cantidad de horas extras
									// generadas al mes
									Date fechalimite1 = dw_1.getFecha();
									Date fechalimite2 = dw_1.getFechafin();
									ll_NumeroHorasMesesRestriccion = BigDecimal.valueOf(area.getnNroHoras().intValue());

									fechalimite1 = UFechaHora.obtenerPrimerDiaMesFecha(fechalimite1);
									fechalimite2 = UFechaHora.obtenerUltimoDiaMesFecha(fechalimite2);

									ll_CantidadMesesRestriccionCAS = getFacAsistencia().getAsAutorizacionServicio()
											.obtenerHorasSobreTiempo(dw_1.getEmpleado(), fechalimite1, fechalimite2);

									if (UValidador.esNulo(ll_CantidadMesesRestriccionCAS)) {
										ll_CantidadMesesRestriccionCAS = BigDecimal.ZERO;
									}

									ll_cantidadhorasregistro = UFechaHora.obtenerDiferenciaSegundos(
											UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), ld_desderegistro),
											UFechaHora.obtenerFechaCompuesta(dw_1.getFechafin(), ld_hastaregistro))
											/ 3600.0;

									// int dias =
									// UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(),
									// dw_1.getFecha());

									ll_minutarthhee = getFacAsistencia().getAsAutorizacionServicio()
											.obtenerMinutosSobreTiempo(dw_1.getEmpleado(), fechalimite1, fechalimite2);

									if (ll_minutarthhee == null) {
										ll_minutarthhee = BigDecimal.ZERO;
									}

									ll_minutarthhee = (ll_minutarthhee.divide(new BigDecimal(60.0), 2,
											BigDecimal.ROUND_HALF_UP));

									// finalmente
									if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
											.equalsIgnoreCase("Add")) {
										ll_minutarthhee2 = getFacAsistencia().getAsAutorizacionServicio()
												.obtenerMinutosSobreTiempo2(dw_1.getEmpleado(), fechalimite1);

										if (UValidador.esNulo(ll_minutarthhee2)) {
											ll_minutarthhee2 = BigDecimal.ZERO;
										}

										ll_minutarthhee2 = ll_minutarthhee2.divide(new BigDecimal(60.0), 2,
												BigDecimal.ROUND_HALF_UP);

										if (UValidador.esNulo(ll_CantidadMesesRestriccionCAS)) {
											ll_CantidadMesesRestriccionCAS = BigDecimal.ZERO;
										}
										if (UValidador.esNulo(ll_cantidadhorasregistro)) {
											ll_cantidadhorasregistro = 0.0;
										}

										if ((ll_CantidadMesesRestriccionCAS
												.add(new BigDecimal(ll_cantidadhorasregistro)).subtract(ll_minutarthhee)
												.subtract(ll_minutarthhee2))
														.compareTo(ll_NumeroHorasMesesRestriccion) == 1) {

											BigDecimal hhees = (ll_CantidadMesesRestriccionCAS
													.add(new BigDecimal(ll_cantidadhorasregistro))
													.subtract(ll_minutarthhee)).setScale(2, RoundingMode.HALF_UP);

											setMessageError("'Las Horas Extras serían: " + f_cent2sexTexto(hhees)
													+ ". Las cuales estan superando la cantidad maxima: "
													+ ll_NumeroHorasMesesRestriccion + " horas, en el periodo: "
													+ UFechaHora.convertirFechaCadena(fechalimite1, "dd/MM/yyyy")
													+ " al "
													+ UFechaHora.convertirFechaCadena(fechalimite2, "dd/MM/yyyy"));
											return false;

										}

									}

									if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
											.equalsIgnoreCase("Update")) {
										ll_cantidadhoras_hhee = getFacAsistencia().getAsAutorizacionServicio()
												.obtenerHorasSobreTiempo2(dw_1.getEmpleado(),
														ls_desderegistro_yyyymmDD);

										if (UValidador.esNulo(ll_cantidadhoras_hhee)) {
											ll_cantidadhoras_hhee = BigDecimal.ZERO;
										}

										BigDecimal hhees = ll_CantidadMesesRestriccionCAS
												.subtract(ll_cantidadhoras_hhee)
												.add(new BigDecimal(ll_cantidadhorasregistro))
												.subtract(ll_minutarthhee);
										hhees = hhees.setScale(2, RoundingMode.HALF_DOWN);

										if ((ll_CantidadMesesRestriccionCAS.subtract(ll_cantidadhoras_hhee)
												.add(new BigDecimal(ll_cantidadhorasregistro))
												.subtract(ll_minutarthhee))
														.compareTo(ll_NumeroHorasMesesRestriccion) == 1) {
											setMessageError("'Las Horas Extras serían: "
													+ f_cent2sexTexto(hhees.setScale(2, RoundingMode.HALF_UP))
													+ ". Las cuales estan superando la cantidad maxima: "
													+ ll_NumeroHorasMesesRestriccion + " horas, en el periodo: "
													+ UFechaHora.convertirFechaCadena(fechalimite1, "dd/mm/yyyy")
													+ " al "
													+ UFechaHora.convertirFechaCadena(fechalimite2, "dd/MM/yyyy"));
											return false;
										}
									}

								} else {
									ll_cantidadhorasregistro = UFechaHora.obtenerDiferenciaSegundos(
											UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), ld_desderegistro),
											UFechaHora.obtenerFechaCompuesta(dw_1.getFechafin(), ld_hastaregistro))
											/ 3600.0;

									// int dias =
									// UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(),
									// dw_1.getFecha());
									// ll_cantidadhorasregistro =
									// ll_cantidadhorasregistro * (dias + 1);

									if (!UValidador.esNulo(objCon)) {
										ls_FlagNumerosRestriccion = objCon.getFlagnumerosrestriccion();
										ll_CantidadMesesRestriccion = objCon.getCantidadmesesrestriccion();
										ll_NumeroHorasMesesRestriccion = objCon.getNumerohorasmesesrestriccion();
										ld_FechaInicioRestriccion = objCon.getFechainiciorestriccion();
									}

									if (UValidador.estaVacio(ls_FlagNumerosRestriccion)) {
										ls_FlagNumerosRestriccion = "N";
									}

									if (ls_FlagNumerosRestriccion.equals("S")) {

										ls_fechainiciorestriccion = UFechaHora
												.convertirFechaCadena(ld_FechaInicioRestriccion, "YYYYMM");

										if (ll_CantidadMesesRestriccion.intValue() > 0) {
											ld_fecharegistro = dw_1.getFecha();
											ld_fechacorte = ld_FechaInicioRestriccion;

											Empleadomast emp = (Empleadomast) getFacCore().getEmpleadomastServicio()
													.obtenerPorId(new EmpleadomastPk(dw_1.getEmpleado(),
															getUsuarioActual().getCompaniaSocioCodigo()));

											if (!UValidador.esNulo(emp)) {
												ld_fechaingreso = emp.getFechaingreso();
											}

											if (ld_fechaingreso.getTime() > ld_fechacorte.getTime()) {
												ld_fechainiciobase = ld_fechaingreso;
											} else {
												ld_fechainiciobase = ld_fechacorte;
											}
											ld_fechainiciotemp = ld_fechainiciobase;

											ll_cantidadiasfechas = BigDecimal
													.valueOf(UFechaHora.obtenerDiasTranscurridos(ld_fecharegistro,
															ld_fechainiciotemp) + 1);

											ldc_bloquesmeses = (ll_cantidadiasfechas.divide(
													ll_CantidadMesesRestriccion.multiply(BigDecimal.valueOf(30)), 2,
													BigDecimal.ROUND_HALF_UP));

											if (ldc_bloquesmeses
													.subtract(BigDecimal.valueOf(ldc_bloquesmeses.intValue()))
													.equals(BigDecimal.ZERO)) {
												ll_bloquesmeses = ldc_bloquesmeses.intValue();
											} else {
												ll_bloquesmeses = ldc_bloquesmeses.intValue() + 1;
											}

											ll_cantidadbloques = 1;

											do {
												ld_fechainiciotemp = UFechaHora.addMesesToDate(ld_fechainiciotemp,
														ll_CantidadMesesRestriccion.intValue());
												ll_cantidadbloques++;
											} while (ll_cantidadbloques < ll_bloquesmeses);

											// -------------------------ACT HOCR
											// 20181017
											// ------------------------//

											ld_fechainiciobase = UFechaHora.addMesesToDate(ld_fecharegistro,
													-1 * ll_CantidadMesesRestriccion.intValue());
											ld_fechainiciosemestre = ld_fechainiciotemp;
											ld_fechafinsemestre = UFechaHora.addMesesToDate(ld_fechainiciosemestre,
													ll_CantidadMesesRestriccion.intValue());
											// Restamos un día
											ld_fechafinsemestre = UFechaHora.anadirDiasAFechas(ld_fechafinsemestre, -1);

											ll_CantidadMesesRestriccionCAS = getFacAsistencia()
													.getAsAutorizacionServicio()
													.obtenerHorasSobreTiempo(dw_1.getEmpleado(), ld_fechainiciosemestre,
															ld_fechafinsemestre);
											ll_minutarthhee = getFacAsistencia().getAsAutorizacionServicio()
													.obtenerMinutosSobreTiempo(dw_1.getEmpleado(),
															ld_fechainiciosemestre, ld_fechafinsemestre);

											if (ll_minutarthhee == null) {
												ll_minutarthhee = BigDecimal.ZERO;
											}

											ll_minutarthhee = (ll_minutarthhee.divide(new BigDecimal(60.0), 2,
													BigDecimal.ROUND_HALF_UP));

											if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
													.equalsIgnoreCase("Add")) {
												ll_minutarthhee2 = getFacAsistencia().getAsAutorizacionServicio()
														.obtenerMinutosSobreTiempo2(dw_1.getEmpleado(),
																ld_fecharegistro);

												if (UValidador.esNulo(ll_minutarthhee2)) {
													ll_minutarthhee2 = BigDecimal.ZERO;
												}

												ll_minutarthhee2 = ll_minutarthhee2.divide(new BigDecimal(60.0), 2,
														BigDecimal.ROUND_HALF_UP);

												if (UValidador.esNulo(ll_CantidadMesesRestriccionCAS)) {
													ll_CantidadMesesRestriccionCAS = BigDecimal.ZERO;
												}
												if (UValidador.esNulo(ll_cantidadhorasregistro)) {
													ll_cantidadhorasregistro = 0.0;
												}

												BigDecimal hhees = (ll_CantidadMesesRestriccionCAS
														.add(new BigDecimal(ll_cantidadhorasregistro))
														.subtract(ll_minutarthhee).subtract(ll_minutarthhee2))
																.setScale(2, RoundingMode.HALF_UP);

												if ((ll_CantidadMesesRestriccionCAS
														.add(new BigDecimal(ll_cantidadhorasregistro))
														.subtract(ll_minutarthhee).subtract(ll_minutarthhee2))
																.compareTo(ll_NumeroHorasMesesRestriccion) == 1) {
													setMessageError(
															"'Las Horas Extras serían: " + f_cent2sexTexto(hhees)
																	+ ". Las cuales estan superando la cantidad máxima: "
																	+ ll_NumeroHorasMesesRestriccion
																	+ " horas, en el semestre: "
																	+ UFechaHora.convertirFechaCadena(
																			ld_fechainiciosemestre, "dd/MM/yyyy")
																	+ " al " + UFechaHora.convertirFechaCadena(
																			ld_fechafinsemestre, "dd/MM/yyyy"));
													return false;

												}

											}

											if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
													.equalsIgnoreCase("Update")) {
												ll_cantidadhoras_hhee = getFacAsistencia().getAsAutorizacionServicio()
														.obtenerHorasSobreTiempo2(dw_1.getEmpleado(),
																ls_desderegistro_yyyymmDD);

												if (UValidador.esNulo(ll_cantidadhoras_hhee)) {
													ll_cantidadhoras_hhee = BigDecimal.ZERO;
												}

												BigDecimal hhees = ll_CantidadMesesRestriccionCAS
														.subtract(ll_cantidadhoras_hhee)
														.add(new BigDecimal(ll_cantidadhorasregistro))
														.subtract(ll_minutarthhee);
												hhees = hhees.setScale(2, RoundingMode.HALF_DOWN);

												if ((ll_CantidadMesesRestriccionCAS.subtract(ll_cantidadhoras_hhee)
														.add(new BigDecimal(ll_cantidadhorasregistro))
														.subtract(ll_minutarthhee))
																.compareTo(ll_NumeroHorasMesesRestriccion) == 1) {
													setMessageError("'Las Horas Extras serían: "
															+ f_cent2sexTexto(hhees.setScale(2, RoundingMode.HALF_UP))
															+ ". Las cuales estan superando la cantidad maxima: "
															+ ll_NumeroHorasMesesRestriccion
															+ " horas, en el semestre: "
															+ UFechaHora.convertirFechaCadena(ld_fechainiciosemestre,
																	"dd/mm/yyyy")
															+ " al " + UFechaHora.convertirFechaCadena(
																	ld_fechafinsemestre, "dd/MM/yyyy"));
													return false;
												}
											}
										}

									}
								}
							}
						}

					}

				}
				ld_temporal = UFechaHora.obtenerFechaHoraInicioDia(UFechaHora.obtenerFechaMasdias(ld_temporal, 1));

				// Si es el concepto 34 habilitamos la fecha de recuperacion
				// desde y
				// periodo de descuento
				if ((UConstante.CONSTANTE_CONCEPTO_RESOLUCION_0044.equals(dw_1.getConceptoacceso())
						|| UConstante.CONSTANTE_CONCEPTO_LICENCIA_EXAMEN_ONCO.equals(dw_1.getConceptoacceso()))
						&& "A".equals(dw_1.getEstado())) {
					// El concepto 34 solo puede ser aprobado por el perfil
					// AS06
					boolean flgAprueba34 = false;
					List<Seguridadperfilusuario> perfiles = getFacSeguridad().getSeguridadperfilusuarioServicio()
							.listarPerfilActivoXUsuario(getUsuarioActual().getCodigoUsuario());
					if (!UValidador.esListaVacia(perfiles)) {
						for (Seguridadperfilusuario per : perfiles) {
							if (UConstante.CONSTANTE_PERFIL_APROB_RESOLUCION_0044
									.equalsIgnoreCase(per.getPk().getPerfil())) {
								flgAprueba34 = true;
							}
						}
					}
					if (!(flgAprueba34)) {
						Usuario objUsu = (Usuario) getFacSeguridad().getUsuarioServicio()
								.obtenerPorId(new UsuarioPk(UConstante.CONSTANTE_PERFIL_APROB_RESOLUCION_0044));
						setMessageError(
								"Para procesar este concepto debe tener asigando el perfil " + objUsu.getNombre());
						return false;
					}

				}

			}

		}

		// Si esta Rechazado preguntar si se quiere iniciar nuevamente la
		// solicitud
		Estado = dw_1.getEstado();
		if (Estado.equals("R"))

		{
			enviarCorreo = true;
			getWebControlContext().actualizar("dgNuevaSolicitud");
			getWebControlContext().ejecutar("PF('popNuevaSolicitud').show()");
			return false;
		}

		if (Estado.equals("A"))

		{
			if (dw_1.getConceptoacceso().equals("34")
					|| dw_1.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_LICENCIA_EXAMEN_ONCO)) {
				enviarCorreo = true;
			}
		}

		return

		validarPosNuevaSolicitud();

	}

	public String nuevaSolicitud() throws Exception {
		dw_1.setEstado("S");

		if (validarPosNuevaSolicitud()) {
			wf_update();
			CwAsAutorizacionPreprocesoAprobacion.getInstance().iniciarControladora();
		} else {
			// en ocaciones antes de grabar muestra la ventana de intervalos.
			return null;
		}

		if (UValidador.esNulo(enviarCorreo)) {
			enviarCorreo = false;
		}

		if (!UValidador.estaVacio(CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from())) {
			if ((dw_1.getEstado().equals("S")
					&& CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add"))
					|| enviarCorreo) {
				enviarCorreo();
			}
		}

		// getWebControlContext().ejecutar("PF('popNuevaSolicitud').hide();");

		return "w_as_autorizacion_preproceso_aprobacion";
	}

	public Boolean validarPosNuevaSolicitud() throws Exception {

		// Abrir ventana de intervalos de fechas si es que se ingresó una fecha
		// HASTA mayor a la fecha DESDE
		if (UFechaHora.obtenerFechaHoraInicioDiaDate(dw_1.getFechafin())
				.after(UFechaHora.obtenerFechaHoraInicioDiaDate(dw_1.getFecha()))) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, "listarOcurrencias");
			param.put("str_parametros1", dw_1.getFecha());
			param.put("str_parametros2", dw_1.getFechafin());
			param.put("str_parametros3", dw_1.getDesde1());
			param.put("str_parametros4", dw_1.getHasta1());

			if (dw_1.getConceptoacceso().equals("CHOR")) {
				param.put("str_parametros5", dw_horario);
			}

			MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
			mensajeGenerico.setParametros(param);
			CwAsAutorizacionPreprocesoHextraMsg.getInstance().mensaje(mensajeGenerico);

			return false;
		}

		return validarDespuesdeIntervalos();
	}

	/*
	 * wf_validate()
	 */
	public Boolean validarDespuesdeIntervalos() throws Exception {

		// Valida la fecha establecida este en un rango superior a l fecha hasta
		if (w_CategoriaAutorizacion.equals("SOBR")) {
			ldt_fecha_hora_salida = getFacAsistencia().getAS().getAsrepusFuncion()
					.FAsAutorizacionPreprocesoTipodia(empleadoval, fechaval);

			if (!UValidador.esNulo(ldt_fecha_hora_salida)) {
				ld_hora_salida_t = ldt_fecha_hora_salida;
				if (!(dw_1.getHasta1().after(ld_hora_salida_t))) {
					setMessageError("La hora fin establecida debe ser mayor a "
							+ UFechaHora.convertirFechaCadena(ld_hora_salida_t, "HH:mm"));
					return false;
				}
			}
		}

		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")
				|| CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
						.equalsIgnoreCase("Update")) {

			if (w_CategoriaAutorizacion.equals("COMP")) {
				if (UValidador.esListaVacia(dw_diascompensados)) {
					setMessageError("Debe generar la Asistencia para realizar la compensación.");
					return false;
				}
			}

			if (UValidador.esListaVacia(dw_diascompensados)) {
				return true;
			}

			Integer w_seleccionados = 0;

			String w_Saldo_Selec_HHMM = null;
			String w_Compensacion_HHMM = null;
			BigDecimal sumadiferencianumero = BigDecimal.ZERO;
			BigDecimal saldohorasganadas = BigDecimal.ZERO;

			if (w_CategoriaAutorizacion.equals("COMP")) {

				for (int i = 0; i < dw_diascompensados.size(); i++) {
					DtoDwAsAsistenciaHextraEdit obj = dw_diascompensados.get(i);
					sumadiferencianumero = sumadiferencianumero.add(obj.getDiferencia());
					if (obj.getIsseleccionado()) {
						saldohorasganadas = saldohorasganadas.add(obj.getDiferencia());
						w_seleccionados++;
					}
				}

				if (UValidador.esCero(w_seleccionados)) {
					setMessageError("Debe seleccionar por lo menos un registro para compensar.");
					return false;
				}

				w_horainicio = dw_1.getDesde1();
				w_horafin = dw_1.getHasta1();

				// Si la compensación es por día, tomamos la hora inicio y fin
				// del orario del empleado
				if ("04".equals(dw_1.getConceptoacceso())) {
					w_horainicio = this.desdeGlobal;
					w_horafin = this.hastaGlobal;
				}

				w_diftiempo = wf_diftiempo(w_horainicio, w_horafin).divide(BigDecimal.valueOf(3600), 2,
						BigDecimal.ROUND_HALF_UP);
				w_diftiempo = w_diftiempo.subtract(obtenerHorasRefrigerio());

				// multiplicacmos por los dias
				Integer dias = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1;
				w_diftiempo = w_diftiempo.multiply(new BigDecimal(dias));

				w_Saldo_Selec_HHMM = obtenerHorasAcumuladas(saldohorasganadas);
				w_Compensacion_HHMM = obtenerHorasAcumuladas(w_diftiempo);

				if (w_diftiempo.compareTo(saldohorasganadas) == 1
						&& Math.abs((w_diftiempo.subtract(saldohorasganadas)).doubleValue()) > 0.01) {
					setMessageError("No puede asignar una compensación de " + w_Compensacion_HHMM + " (hh:mm) con "
							+ w_Saldo_Selec_HHMM + " (hh:mm)");
					return false;
				}

				Date fechahora = UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), w_horainicio);
				Integer existe = getFacAsistencia().getAsAutorizacionfechaServicio()
						.obtenercantidadAutorizacionFecha(dw_1.getEmpleado(), fechahora);

				if (existe > 0) {
					setMessageError("Ya existe una compensación con la fecha ingresada.");
					return false;
				}
			}

			// URA 20/05/2015 Validando que la fecha de compensacion no super el
			// máximo permitido
			// for (int j = 0; j < dw_diascompensados.size(); j++) {
			// DtoDwAsAsistenciaHextraEdit obj = dw_diascompensados.get(j);
			// if (obj.getIsseleccionado()) {
			// if (dw_1.getFecha().after(obj.getFechamaxima())) {
			// setMessageError("La fecha de compensación no puede ser mayor a la
			// fecha máximo permitido en la fila "
			// + (j + 1));
			// return false;
			// }
			// }
			// }

		}

		return true;
	}

	public BigDecimal getW_diftiempo() {
		return w_diftiempo;
	}

	public void setW_diftiempo(BigDecimal w_diftiempo) {
		this.w_diftiempo = w_diftiempo;
	}

	public void sumarHoras() {
		Integer w_seleccionados = 0;
		BigDecimal sumadiferencianumero = BigDecimal.ZERO;
		BigDecimal saldohorasganadas = BigDecimal.ZERO;

		for (int i = 0; i < dw_diascompensados.size(); i++) {
			DtoDwAsAsistenciaHextraEdit obj = dw_diascompensados.get(i);
			sumadiferencianumero = sumadiferencianumero.add(obj.getDiferencia());
			if (obj.getIsseleccionado()) {
				saldohorasganadas = saldohorasganadas.add(obj.getDiferencia());
				w_seleccionados++;
			}
		}

		horasSumadas = obtenerHorasAcumuladas(saldohorasganadas);
	}

	public String guardarDesdeIntervalos() throws Exception {
		if (validarDespuesdeIntervalos()) {
			if (!UValidador.esCero(wf_update())) {
				if (dw_1.getEstado().equals("S") && (CComunSession.getInstance().getSyroyal().StrGlobal()
						.getGv_coming_from().equalsIgnoreCase("Add") || enviarCorreo)) {
					enviarCorreo();
				}

				if (!UValidador.esNulo(notificarlicenciasingoce())) {
					if (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
							.equalsIgnoreCase("Delete")) {
						if ("A".equals(dw_1.getEstado())) {
							setMessageSuccess("Se registró la autorización correctamente", true);
						}
						if ("S".equals(dw_1.getEstado())) {
							setMessageSuccess("Se registró la solicitud correctamente", true);
						}
					}
					CwAsAutorizacionPreprocesoAprobacion.getInstance().iniciarControladora();
					return "w_as_autorizacion_preproceso_aprobacion";
				} else {
					// si se muestra el mensaje de licencia ocultamos este popup
					// de
					// intervalos
					getWebControlContext().ejecutar("PF('popIntervalosAutorizacion').hide()");
				}
			}
		}

		return null;

	}

	@SuppressWarnings("unchecked")
	private String notificarlicenciasingoce() throws Exception {
		// TODO Auto-generated method stub
		// SI ES UNA LICENCIA SIN GOZE MOSTRAMO EL MENSAJE
		if (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Delete")) {
			if (dw_1.getConceptoacceso().equals("14")) {
				Integer diasmax = getFacCore().getParametrosmastServicio()
						.obtenerValorInteger(new ParametrosmastPk("AS", "999999", "NDIAMAXLIC"));
				if (UValidador.esNulo(diasmax)) {
					diasmax = 0;
				}

				licencias = getFacAsistencia().getAsAutorizacionServicio().listarLicenciasSinGoce(dw_1.getEmpleado());

				Integer cantlic = 0;
				if (!UValidador.esListaVacia(licencias)) {
					for (DtoAsAutorizacion obj : licencias) {
						// acumulando los dias de licencia solo días hábiles
						Integer dias = getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(obj.getFecha(),
								obj.getFechahasta());
						cantlic = cantlic + dias;
						obj.setVeces(dias);
					}
				}

				LOGGER.debug("cantlic " + cantlic);
				LOGGER.debug("diasmax " + diasmax);

				if (cantlic >= diasmax) {
					mensajelicencia = "Usted ha alcanzado el máximo de " + diasmax + " licencia(s) en este año.";
					getWebControlContext().actualizar("dgAlertaLicencia");
					getWebControlContext().ejecutar("PF('popAlertaLicencia').show()");
					return null;
				}
			}
		}

		return "w_as_autorizacion_preproceso_aprobacion";

	}

	@Override
	public String prepararDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String prepararDatosListado() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {
		// TODO Auto-generated method stub
		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("edicionAutorizacion")) {

			ishorariodiasiguiente = false;
			iscambioonceptoevento = false;
			conceptoSeleccionado = null;

			DtoDwAsAutorizacionPreprocesoHextra objext = (DtoDwAsAutorizacionPreprocesoHextra) mensajeControllerGenerico
					.getParametros().get("autorizacion");

			if (!UValidador.esNulo(objext)) {
				AsAutorizacionPk pk = new AsAutorizacionPk();
				pk.setEmpleado(objext.getEmpleado());
				pk.setFecha(objext.getFecha());
				pk.setDesde(objext.getDesde1());
				pk.setConceptoacceso(objext.getConceptoacceso());

				AsAutorizacion obj = (AsAutorizacion) getFacAsistencia().getAsAutorizacionServicio().obtenerPorId(pk,
						false);

				dw_1 = new DtoDwAsAutorizacionPreprocesoHextraeditV2();

				if (!UValidador.esNulo(obj)) {
					dw_1.setEmpleado(obj.getPk().getEmpleado().intValue());
					dw_1.setFecha(obj.getPk().getFecha());
					dw_1.setFechafin(obj.getFechafin());
					dw_1.setConceptoacceso(obj.getPk().getConceptoacceso());
					dw_1.setCategoriaautorizacion(obj.getCategoriaautorizacion());
					dw_1.setComportamientosobretiempo(obj.getComportamientosobretiempo());
					dw_1.setEstadoai(objext.getEstadoai());
					dw_1.setDesde1(obj.getPk().getDesde());
					dw_1.setDesde2(objext.getDesde2());
					dw_1.setHasta1(obj.getHasta());
					dw_1.setHasta2(objext.getHasta2());
					dw_1.setPuesto(objext.getPuestodes());
					dw_1.setCentrocosto(objext.getCentrocostodes());
					dw_1.setPeriodo(obj.getPeriodo());
					dw_1.setEmpleadonombre(objext.getNombrecompleto());
					dw_1.setEstado(obj.getEstado());
					dw_1.setFechaautorizacion(obj.getFechaautorizacion());
					dw_1.setFechasolicitud(obj.getFechasolicitud());
					dw_1.setSolicitadopor(obj.getSolicitadopor());
					dw_1.setAutorizadopor(obj.getAutorizadopor());

					dw_1.setAprobadoJefePor(obj.getAprobadoJefePor());
					dw_1.setFechaAprobadoJefe(obj.getFechaAprobadoJefe());
					dw_1.setAprobadoJefePorNombre(obtenerNombreUsuario(obj.getAprobadoJefePor()));
					dw_1.setFlagAprobadoJefe(obj.getFlagAprobadoJefe());

					dw_1.setObservacion(obj.getObservacion());
					dw_1.setNroresolucion(obj.getNroresolucion());
					dw_1.setFecharesolucion(obj.getFecharesolucion());
					dw_1.setMandatario(obj.getMandatorio());
					dw_1.setRefrigerio(obj.getRefrigerio());
					dw_1.setTerminal(obj.getTerminal().intValue());
					dw_1.setTipohorario(obj.getTipohorario().intValue());
					dw_1.setUltimousuario(obj.getUltimoUsuario());
					dw_1.setUltimafechamodif(obj.getUltimaFechaModif());
					dw_1.setRutadocumento(obj.getRutadocumento());

					String pathPrincipal;
					pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext()
							.getContext()).getRealPath("/");
					dw_1.setRutacompleta(
							pathPrincipal + File.separator + "temporaloefa" + File.separator + dw_1.getRutadocumento());
					dw_1.setRutacompletadj(pathPrincipal + File.separator + "temporaloefa" + File.separator
							+ dw_1.getNombrearchivodj());

					dw_1.setUuidalfresco(obj.getUuidalfresco());
					dw_1.setNombrearchivodj(obj.getNombrearchivodj());
					dw_1.setUuiddj(obj.getUuiddj());
					dw_1.setTienearchivo(false);
					dw_1.setTipoautorizacion(obj.getTipoautorizacion());
					dw_1.setRechazadopor(obj.getRechazadopor());
					dw_1.setFecharechazo(obj.getFecharechazo());

					dw_1.setSolicitadopornombre(obtenerNombreUsuario(dw_1.getSolicitadopor()));
					dw_1.setAutorizadopornombre(obtenerNombreUsuario(dw_1.getAutorizadopor()));
					dw_1.setRechazadopornombre(obtenerNombreUsuario(dw_1.getRechazadopor()));
					dw_1.setUltimousuarionombre(obtenerNombreUsuario(dw_1.getUltimousuario()));
					dw_1.setDesderecupera(obj.getDesderecupera());
					dw_1.setHastarecupera(obj.getHastarecupera());
					dw_1.setPeriodoplanilla(obj.getPeriodoplanilla());

					if (!UValidador.estaVacio(dw_1.getRutadocumento())) {
						dw_1.setTienearchivo(true);
						// blDeclaracionjurada = true;
					}
					if (!UValidador.estaVacio(dw_1.getNombrearchivodj())) {
						blDeclaracionjurada = true;
						blVerDeclaracionjurada = true;
					}
				}

				iniciarControladora();

				cargarInfoEmpleado(dw_1.getEmpleado(), dw_1.getEmpleadonombre());

				cargarEvento(dw_1.getCategoriaautorizacion());
				cargarConceptoAcceso(dw_1.getConceptoacceso());

				validateTipoAutorizacion(dw_1.getTipoautorizacion());
				// SI ES CAMBIO DE HORARIO CARGAMOS LOS HORARIOS
				if (dw_1.getConceptoacceso().equals("CHOR")) {
					List<AsEmpleadoexcepcionsolicitud> horarios = getFacAsistencia()
							.getAsEmpleadoexcepcionsolicitudServicio()
							.listarEmpleadoExcepcionSolicitud(dw_1.getEmpleado(), dw_1.getFecha());

					if (!UValidador.esListaVacia(horarios)) {
						Integer secuencia = 0;
						for (AsEmpleadoexcepcionsolicitud objh : horarios) {
							DtoDwCambioHorarioExcepcion hor = new DtoDwCambioHorarioExcepcion();
							hor.setEmpleado(objh.getPk().getEmpleado());
							hor.setFecha(objh.getPk().getFecha());
							hor.setFechahasta(objh.getPk().getFechahasta());
							hor.setFechasolicitud(objh.getPk().getFechasolicitud());
							hor.setDescripcion(objh.getDescripcion());
							hor.setIntervaloacceso(objh.getIntervaloacceso());
							hor.setTipodia(BigDecimal.valueOf(objh.getTipodia()));
							hor.setEstado(objh.getEstado());
							hor.setSecuencia(secuencia);

							for (DtoDddwAsTipodiaasistenciaSelect tipdia : lstTipoDia) {
								if (UValidador.esCero(tipdia.getTipodia().compareTo(hor.getTipodia()))) {
									hor.setHoras(tipdia.getSuma());
									hor.setHorasdescripcion(obtenerHorasAcumuladas(hor.getHoras()));
									hor.setHorasrefrigerio(tipdia.getSumarefrigerio());
									hor.setHorasrefrigeriodescripcion(obtenerHorasAcumuladas(hor.getHorasrefrigerio()));
									hor.setHorainicio(tipdia.getHorainicio());
									hor.setHorafin(tipdia.getHorafin());
									break;
								}
							}

							// traemos el dia de la semana (Nombre)
							Integer diasemana = UFechaHora.obtenerNumeroDiaSemana(hor.getFecha());
							LOGGER.debug("diasemana " + diasemana);
							String nombre = UFechaHora.obtenerDiaEnCadena(diasemana);
							LOGGER.debug("nombre " + nombre);
							hor.setDianombre(nombre);

							dw_horario.add(hor);
							secuencia++;

						}

						calcularTotalHorasHorario();

					}
				}

				if (dw_1.getCategoriaautorizacion().equals("COMP")) {
					cargarDiasCompensados();
				}

			}

			else {
				dw_1 = new DtoDwAsAutorizacionPreprocesoHextraeditV2();
				iniciarControladora();
				cargarInfoEmpleado(getUsuarioActual().getIdPersona(), getUsuarioActual().getNombreCompleto());
			}

			// TODO SIGED obtener la informacion para la actualizacion
			// *********************************************************

			// *********************************************************

		}

		// TODO SIGED funcion para cargar los empleados a las funciones y Roles

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarEmpleado")) {

			DtoDwAsEmpleadoSelectMultiple dtoEmpleado = (DtoDwAsEmpleadoSelectMultiple) mensajeControllerGenerico
					.getParametros().get("empleado");

			dw_1.setCategoriaautorizacion(null);
			dw_1.setConceptoacceso(null);
			conceptoSeleccionado = null;

			// *********************************************************

			cargarInfoEmpleado(dtoEmpleado.getPersona().intValue(), dtoEmpleado.getNombrecompleto());

			if (!UValidador.estaVacio(dw_1.getCategoriaautorizacion())) {
				cargarEvento(dw_1.getCategoriaautorizacion());
				cargarConceptoAcceso(dw_1.getConceptoacceso());
			}

			getWebControlContext().actualizar("wasautorizacionpreprocesohextraedit:segundaSeccion");
		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("cargarDocumento")) {
			DtoDwWhDocumentoarchivoList documento = (DtoDwWhDocumentoarchivoList) mensajeControllerGenerico
					.getParametros().get("documento");

			dw_1.setRutadocumento(UFile.remplazarCaracteresEspeciales(documento.getArchivo()));
			dw_1.setRutacompleta(documento.getRuta());
			// dw_1.setArchivodata(documento.getArchivodata());

			opciones.setIsmostrarver(true);
		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("cargarDj")) {
			DtoDwWhDocumentoarchivoList documento = (DtoDwWhDocumentoarchivoList) mensajeControllerGenerico
					.getParametros().get("documento");

			dw_1.setNombrearchivodj(UFile.remplazarCaracteresEspeciales(documento.getArchivo()));
			dw_1.setRutacompletadj(documento.getRuta());
			// dw_1.setArchivodata(documento.getArchivodata());

			blVerDeclaracionjurada = true;
		}

		return null;
	}

	private void cargarDiasCompensados() {
		// TODO Auto-generated method stub
		opciones.setIsmostrardiascompensados(true);

	}

	@SuppressWarnings("rawtypes")
	private void cargarInfoEmpleado(Integer persona, String nombre) throws Exception {
		// TODO Auto-generated method stub
		dw_1.setEmpleado(persona);
		dw_1.setEmpleadonombre(nombre);
		dw_1.setPeriodo(getFacAsistencia().getAS().getAsmainFuncion().FAsPeriodoactivo(persona));
		dw_1.setPuesto(getFacAsistencia().getAS().getAscommonFuncion().FSelectDescripcionPuesto(persona));

		dw_1.setCentrocosto(getFacAsistencia().getAS().getAscommonFuncion().FSqlCentroCostoEmpleado(persona));

		dw_1.setComportamientosobretiempo(
				getFacAsistencia().getAsCarnetidentificacionServicio().obtenerMaximoComportamientoSobretiempo(persona));

		List data = getFacAsistencia().getAS().getAsmainDatawindow().WAsAutorizacionHorasDisponibles(persona,
				new Date());

		if (!UValidador.esListaVacia(data)) {
			dw_horas = (DtoWAsAutorizacionHorasDisponibles) data.get(0);
		} else {
			dw_horas = new DtoWAsAutorizacionHorasDisponibles();
			dw_horas.setSaldoinicial(BigDecimal.valueOf(0.0));
		}
		dw_horas.setCompute1(obtenerHorasAcumuladas(dw_horas.getSaldoinicial().setScale(2, RoundingMode.HALF_UP)));

		// limpiamos el horario
		dw_horario = new ArrayList<DtoDwCambioHorarioExcepcion>();

		wf_poner_fecha_fin();

	}

	private String obtenerHorasAcumuladas(BigDecimal saldoinicial) {
		// TODO Auto-generated method stub
		BigDecimal sexagesimal, decimales;
		Integer enteros;

		sexagesimal = f_cent2sex(saldoinicial);
		BigDecimal cal1 = sexagesimal.subtract(BigDecimal.valueOf(sexagesimal.intValue())).setScale(2,
				RoundingMode.HALF_EVEN);

		decimales = cal1.multiply(BigDecimal.valueOf(100));

		enteros = sexagesimal.intValue();

		if (UValidador.esCero(decimales.compareTo(BigDecimal.valueOf(60)))) {
			enteros = enteros + 1;
			decimales = BigDecimal.valueOf(0.0);
		}

		if (UValidador.esNulo(enteros) && UValidador.esNulo(decimales)) {
			return "";
		} else if (UValidador.esCero(enteros) && UValidador.esCero(decimales.intValue())) {
			return "00:00";
		} else {
			String signo = enteros >= 0 ? "" : "-";
			return signo + ((enteros < 10 && enteros > -10) ? ("0" + Math.abs(enteros)) : Math.abs(enteros)) + ":"
					+ ((decimales.intValue() < 10) ? ("0" + decimales.intValue()) : decimales.intValue());
		}
	}

	private BigDecimal obtenerHorasRefrigerio() throws Exception {
		// TODO Auto-generated method stub
		// no se considera el refrigerio en la diferencia.
		BigDecimal difref = BigDecimal.ZERO;

		Integer tipodia = getFacAsistencia().getAS().getAsrepusFuncion().FSqlDevuelveHorario(dw_1.getEmpleado(),
				UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), dw_1.getDesde1()));

		if (UValidador.esNulo(tipodia)) {
			tipodia = 0;
		}

		LOGGER.debug("tipodia " + tipodia);

		// traemos el horario de refrigerio
		List horario = getFacAsistencia().getAsTipodiamovimientoServicio().obtenerIntervaloRefrigerio(tipodia);

		if (UValidador.esListaVacia(horario)) {
			return difref;
		}

		// SI EL REFRIGERIO ESTA DENTRO DEL INTERVALO DE HORAS NO LO TOMAMOS
		// EN CUENTA
		Date horaini = ((DtoAsTipodiamovimiento) horario.get(0)).getHorainicio();
		Date horafin = ((DtoAsTipodiamovimiento) horario.get(0)).getHorafin();

		Date desde = dw_1.getDesde1();
		Date hasta = dw_1.getHasta1();
		if ("04".equals(dw_1.getConceptoacceso())) {
			desde = this.desdeGlobal;
			hasta = this.hastaGlobal;
		}

		if (desde.before(UFechaHora.obtenerFechaCompuesta(desde, horaini))
				&& hasta.after(UFechaHora.obtenerFechaCompuesta(hasta, horafin))) {
			difref = wf_diftiempo(horaini, horafin).divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_DOWN);
		} else if (desde.before(UFechaHora.obtenerFechaCompuesta(desde, horaini))
				&& hasta.after(UFechaHora.obtenerFechaCompuesta(hasta, horaini))) {
			difref = wf_diftiempo(UFechaHora.obtenerFechaCompuesta(hasta, horaini), hasta)
					.divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_DOWN);
		} else if (desde.before(UFechaHora.obtenerFechaCompuesta(desde, horafin))
				&& hasta.after(UFechaHora.obtenerFechaCompuesta(dw_1.getHasta1(), horafin))) {
			difref = wf_diftiempo(desde, UFechaHora.obtenerFechaCompuesta(desde, horafin))
					.divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_DOWN);
		}

		// Si el horario de intervalo es mayor a 1 hora solodebe descontar una
		// hora de refrigerio
		if (difref.compareTo(BigDecimal.ONE) != -1) {
			difref = BigDecimal.ONE;
			// si la diferencia quitandole el refrigerio es menor a 4 horas se
			// debe quedar en 4 horas y solo devolvemos el horario d refrigerio
			// necesario para que se quede en 4 horas
			BigDecimal difconrefrigerio = wf_diftiempo(desde, hasta)
					.divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_DOWN).subtract(difref);
			BigDecimal difsinrefrigerio = wf_diftiempo(desde, hasta).divide(BigDecimal.valueOf(3600), 2,
					RoundingMode.HALF_DOWN);
			if (difconrefrigerio.compareTo(new BigDecimal(4)) == -1) {
				difref = difsinrefrigerio.subtract(new BigDecimal(4));
				if (difref.compareTo(BigDecimal.ZERO) == -1) {
					difref = BigDecimal.ZERO;
				}
			}
		} else {
			difref = BigDecimal.ZERO;
		}

		// difref =
		// wf_diftiempo(UFechaHora.obtenerFechaCompuesta(dw_1.getDesde1(),
		// horaini),
		// UFechaHora.obtenerFechaCompuesta(dw_1.getDesde1(),
		// horafin)).divide(BigDecimal.valueOf(3600), 2,
		// RoundingMode.HALF_DOWN);

		return difref;
	}

	private BigDecimal f_cent2sex(BigDecimal par_cent) {
		BigDecimal decimales;
		BigDecimal valor;
		valor = par_cent;
		decimales = valor.subtract(BigDecimal.valueOf(valor.intValue()));

		BigDecimal cal1 = decimales.divide(BigDecimal.valueOf(10)).multiply(BigDecimal.valueOf(6));

		return BigDecimal.valueOf(valor.intValue()).add(cal1);
	}

	private String f_cent2sexTexto(BigDecimal par_cent) {
		String result = "";
		BigDecimal decimales;
		BigDecimal valor;
		valor = par_cent;
		decimales = valor.subtract(BigDecimal.valueOf(valor.intValue()));

		BigDecimal cal1 = decimales.divide(BigDecimal.valueOf(10)).multiply(BigDecimal.valueOf(6));

		// BigDecimal pre = BigDecimal.valueOf(valor.intValue()).add(cal1);

		result = valor.intValue() + ":" + cal1.multiply(BigDecimal.valueOf(100)).setScale(0, RoundingMode.HALF_UP);

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String inicializarFiltrosListado() throws Exception {
		// TODO Auto-generated method stub
		dddw_as_empleadosmast_select_carnets = getFacAsistencia().getAS().getAsmastDatawindow()
				.DddwAsEmpleadosmastSelectCarnets();

		dw_detail = new ArrayList<DtoDwAsAutorizacionPreprocesoOrdenes>();

		dwc_tipohorario = getFacAsistencia().getAS().getAsoracleDatawindow().DddwAsTipohorarioSelect();

		an_terminal = getFacAsistencia().getAS().getAsmastDatawindow().DddwAsTempusTerminal();

		boolean esadmin = this.getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm("AS",
				this.getUsuarioActual().getCodigoUsuario().toUpperCase());

		dwc_ConceptoAcceso = getFacAsistencia().getAS().getAsmastDatawindow()
				.DddwAsConceptoaccesoSelectPre(esadmin ? "S" : "N", getUsuarioActual().getLoginUsuario().toUpperCase());

		dwc_ConceptoAccesoFiltrado.addAll(dwc_ConceptoAcceso);

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public static CwAsAutorizacionPreprocesoHextraEdit getInstance() {
		return UFaces.evaluateExpressionGet("#{cwAsAutorizacionPreprocesoHextraEdit}",
				CwAsAutorizacionPreprocesoHextraEdit.class);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void wf_poner_fecha_fin() throws Exception {
		Date desde, hasta;
		Integer tipodia;

		desde = UFechaHora.obtenerFechaHoraInicioDiaDate(dw_1.getFecha());
		hasta = UFechaHora.obtenerFechaHoraFinDia(dw_1.getFechafin());

		List data = getFacAsistencia().getAS().getAsmainDatawindow().DwAsMarcasEmpleado(dw_1.getEmpleado(),
				UFechaHora.convertirCadenaFecha(UFechaHora.convertirFechaCadena(desde), "dd/MM/yyyy"),
				UFechaHora.convertirCadenaFecha(
						UFechaHora.convertirFechaCadena(UFechaHora.obtenerFechaMasdias(hasta, 1)), "dd/MM/yyyy"));

		dw_2 = new ArrayList<DtoDwAsMarcasEmpleado>();
		if (!UValidador.esListaVacia(data)) {
			dw_2 = data;
		}

		// Horario en una fecha
		tipodia = getFacAsistencia().getAS().getAsrepusFuncion().FSqlDevuelveHorario(dw_1.getEmpleado(),
				UFechaHora.convertirCadenaFecha(UFechaHora.convertirFechaCadena(desde), "dd/MM/yyyy"));
		List data2 = getFacAsistencia().getAsTipodiamovimientoServicio().obtenerMaxHoraInicioMaxHoraFin(tipodia);

		if (!UValidador.esListaVacia(data2)) {
			desde = ((DtoAsTipodiamovimiento) data2.get(0)).getHorainicio();
			hasta = ((DtoAsTipodiamovimiento) data2.get(0)).getHorafin();
			this.desdeGlobal = desde;
			this.hastaGlobal = hasta;
			if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
				// dw_1.setDesde1(desde);
				// dw_1.setHasta1(hasta);
				dw_1.setDesde1(UFechaHora.obtenerFechaHoraInicioDiaDate(new Date()));
				dw_1.setHasta1(UFechaHora.obtenerFechaHoraInicioDiaDate(new Date()));
			}

			// significa que el horario es de un dia para otro
			ishorariodiasiguiente = false;
			// solo compramos las horas
			if (!UValidador.esNulo(desde)) {
				if (UFechaHora.obtenerFechaCompuesta(desde, desde)
						.after(UFechaHora.obtenerFechaCompuesta(desde, hasta))) {
					ishorariodiasiguiente = true;
				}
			}
		}
		String del = UFechaHora.convertirFechaCadena(desde, "HH:mm");
		String al = UFechaHora.convertirFechaCadena(hasta, "HH:mm");

		opciones.setSt_tipodia("Horario : " + UFechaHora.convertirFechaCadena(dw_1.getFecha(), "dd/MM/yyyy") + " "
				+ (UValidador.esNulo(del) ? " " : del) + " al " + (UValidador.esNulo(al) ? " " : al));

		if (!UValidador.esNulo(conceptoSeleccionado)) {
			if (!dw_1.getCategoriaautorizacion().equals("PSIG")) {
				cargarConceptoAcceso(conceptoSeleccionado);
			}

		}

		fijarHorarioPorConcepto(dw_1.getConceptoacceso());

	}

	public void fijarHorarioPorConcepto(String concepto) throws Exception {
		if (UConstante.CONSTANTE_CONCEPTO_VIERNES_VERANO.equals(concepto)) {
			if (!UValidador.esNulo(dw_1.getFecha())) {
				Date horasalida = getFacAsistencia().getAsAutorizacionServicio()
						.obtenerHorarioEmpleado(dw_1.getEmpleado(), dw_1.getFecha(), "F");
				String horsalida = UFechaHora.convertirFechaCadena(horasalida, "HH:mm:ss");

				dw_1.setHasta1(UFechaHora.obtenerFechaCompuesta(dw_1.getFechafin(),
						UFechaHora.convertirCadenaFecha(horsalida, "HH:mm:ss")));
				dw_1.setDesde1(UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(),
						UFechaHora.convertirCadenaFecha(
								UFechaHora.convertirFechaCadena(UFechaHora.addHorasToDate(horasalida, -4), "HH:mm:ss"),
								"HH:mm:ss")));

				opciones.setIshabilitardesde1(false);
				opciones.setIshabilitarhasta1(false);
				String horentrada = UFechaHora.convertirFechaCadena(
						UFechaHora.addHorasToDate(horasalida, -(4 + obtenerHorasRefrigerio().intValue())), "HH:mm:ss");
				dw_1.setDesde1(UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(),
						UFechaHora.convertirCadenaFecha(horentrada, "HH:mm:ss")));
				keyhorainicio();
			}
		}
	}

	public void valueChangeDiaSiguiente() throws Exception {
		// flgDiaSiguiente = (Boolean) event.getNewValue();

		if (flgDiaSiguiente) {
			dw_1.setFechafin(UFechaHora.anadirDiasAFechas(dw_1.getFecha(), 1));
			getWebControlContext().actualizar("wasautorizacionpreprocesohextraedit:cldal");
		} else {
			dw_1.setFechafin(dw_1.getFecha());
			getWebControlContext().actualizar("wasautorizacionpreprocesohextraedit:cldal");
		}
	}

	// TODO CUANDO CAMBIA EL EVENTO
	public void valueChangeEventEvento(ValueChangeEvent event) throws Exception {
		verHistorialVacaciones = false;
		blDeclaracionjurada = false;
		blVerDeclaracionjurada = false;
		String idevento = (String) event.getNewValue();
		dw_1.setCategoriaautorizacion(idevento);
		dw_1.setConceptoacceso(null);
		cargarEvento(idevento);

		if ("VACA".equals(dw_1.getConceptoacceso()) || "ADEL".equals(dw_1.getConceptoacceso())
				|| "FRAD".equals(dw_1.getConceptoacceso())) {
			diferenciaDia = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1 + "";
		} else {
			diferenciaDia = getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(dw_1.getFecha(),
					dw_1.getFechafin()) + "";
		}

	}

	// TODO categoria autorizacion
	public void cargarEvento(String idevento) throws Exception {

		dw_diascompensados = new ArrayList<>();
		opciones.setIsmostrardiascompensados(false);
		// por defecto cargamos el horario del empleado
		// si es una edicion carga el horario de la papeleta
		if (UValidador.estaVacio(idevento)) {
			return;
		}

		LOGGER.debug("idevento " + idevento);

		if (UValidador.esNulo(dw_1.getEmpleado()) || UValidador.esCero(dw_1.getEmpleado())) {
			dw_1.setCategoriaautorizacion(null);
			setMessageError("Debe seleccionar al empleado antes de asignar un evento");
			return;
		}

		if (!idevento.equals("OTROS")) {
			dw_horario = new ArrayList<DtoDwCambioHorarioExcepcion>();
			opciones.setIsmostrardwhorario(false);
			opciones.setIsmostrarsttitulo(false);
			opciones.setIsmostrarcbinsertar(false);
			opciones.setIsmostrarcbeliminar(false);
		}

		opciones.setIsmostrarnroresolucion(false);
		opciones.setIsmostrarrutadocumento(false);
		opciones.setIsmostrarver(false);
		opciones.setIshabilitarfechafin(true);

		if (idevento.equals("COMP")) {
			// dw_1.setConceptoacceso("COMP");
			dwc_ConceptoAccesoFiltrado.clear();
			for (DtoDddwAsConceptoaccesoSelectPre obj : dwc_ConceptoAcceso) {
				if (obj.getFlagcompensa().equals("S")) {
					dwc_ConceptoAccesoFiltrado.add(obj);
				}
			}
			if (!UValidador.esListaVacia(dwc_ConceptoAccesoFiltrado)) {
				if (UValidador.esNulo(dw_1.getConceptoacceso())) {
					dw_1.setConceptoacceso(dwc_ConceptoAccesoFiltrado.get(0).getConceptoacceso());
				}
			}

			opciones.setIsmostrardwhoras(true);

		}

		else if (idevento.equals("OTRO")) {
			dwc_ConceptoAccesoFiltrado.clear();
			for (DtoDddwAsConceptoaccesoSelectPre obj : dwc_ConceptoAcceso) {
				if (obj.getFlagotrospermisos().equals("S")) {
					dwc_ConceptoAccesoFiltrado.add(obj);
				}
			}

			opciones.setIsmostrardwhoras(false);
			opciones.setIsmostrardwcompensacion(false);
			opciones.setIsmostrarsttitulo(false);
		}

		else if (idevento.equals("OMIS")) {
			if (!dw_1.getConceptoacceso().equals("OMI2")) {
				dw_1.setConceptoacceso("OMIS");
			}
			opciones.setIsmostrartde(false);
			opciones.setIsmostrardwhoras(false);
			opciones.setIsmostrardwcompensacion(false);
			opciones.setIsmostrarsttitulo(false);

			if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
				// nuevo cambio 24/01/2019
				dw_1.setDesde1(null);
			}
		}

		if (idevento.equals("SOBR")) {
			dw_1.setConceptoacceso("PAHE");
			opciones.setIsmostrardwhoras(false);
			opciones.setIsmostrardwcompensacion(false);
			opciones.setIsmostrarsttitulo(false);
			opciones.setIshabilitarfechafin(false);
			// opciones.setIshabilitardesde1(false); // REQ: 6
		}

		if (!idevento.equals("ADFR")) {
			dw_horario = new ArrayList<DtoDwCambioHorarioExcepcion>();
			opciones.setIsmostrardwhorario(false);
			opciones.setIsmostrarsttitulo(false);
			opciones.setIsmostrarcbinsertar(false);
			opciones.setIsmostrarcbeliminar(false);
		}

		if (idevento.equals("VACA")) {
			verHistorialVacaciones = true;
			dw_1.setConceptoacceso("VACA");
			CHistorialVacaciones.getInstance().setEmpleado(dw_1.getEmpleado());
			CHistorialVacaciones.getInstance().iniciarControladora();
		}

		wf_Refrescar_Visibilidad_Hora();

		// SE DEBE EVITAR GUARDAR CAMPOS QUE NO PERTENECEN AL EVENTO
		if (!idevento.equals("OTRO")) {
			AsConceptoaccesoPk pkfind = new AsConceptoaccesoPk();
			pkfind.setConceptoacceso(idevento);
			AsConceptoacceso objfind = (AsConceptoacceso) getFacAsistencia().getAsConceptoaccesoServicio()
					.obtenerPorId(pkfind);
			if (!UValidador.esNulo(objfind)) {
				if (objfind.getFlagarchivo().equals("N")) {
					dw_1.setArchivodata(null);
					dw_1.setRutadocumento(null);
				}
				if (objfind.getFlagtieneresolucion().equals("N")) {
					dw_1.setNroresolucion(null);
					dw_1.setFecharesolucion(null);
				}
			}
		}
		this.conceptoacceso = dw_1.getConceptoacceso();
		conceptoSeleccionado = dw_1.getConceptoacceso();

	}

	public void valuechangedConceptoAcceso(ValueChangeEvent event) throws Exception {
		if (UValidador.esNulo(event.getNewValue())) {
			return;
		}
		blDeclaracionjurada = false;
		blVerDeclaracionjurada = false;
		iscambioonceptoevento = true;
		conceptoSeleccionado = (String) event.getNewValue();
		cargarConceptoAcceso(conceptoSeleccionado);

		if ("VACA".equals(dw_1.getConceptoacceso()) || "ADEL".equals(dw_1.getConceptoacceso())
				|| "FRAD".equals(dw_1.getConceptoacceso())) {
			diferenciaDia = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1 + "";
		} else {
			diferenciaDia = getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(dw_1.getFecha(),
					dw_1.getFechafin()) + "";
		}
	}

	@SuppressWarnings("unchecked")
	public void cargarConceptoAcceso(String concepto) throws Exception {
		dw_diascompensados = new ArrayList<>();
		totalsaldoactual = BigDecimal.ZERO;
		totalsaldoactualhor = "00:00";
		horasSumadas = "";

		Integer w_dlv = null;
		Integer w_dfs = null;

		if (!concepto.equals("CHOR")) {
			dw_horario = new ArrayList<DtoDwCambioHorarioExcepcion>();
			opciones.setIsmostrardwhorario(false);
			opciones.setIsmostrarsttitulo(false);
			opciones.setIsmostrarcbinsertar(false);
			opciones.setIsmostrarcbeliminar(false);
		}

		dw_1.setConceptoacceso(concepto);
		Integer ll_find = null;

		for (int i = 0; i < dwc_ConceptoAccesoFiltrado.size(); i++) {
			DtoDddwAsConceptoaccesoSelectPre obj = dwc_ConceptoAccesoFiltrado.get(i);
			if (obj.getConceptoacceso().equals(concepto)) {
				ll_find = i;
				diascompensa = dwc_ConceptoAccesoFiltrado.get(i).getDiascompensa();
			}
		}

		if (!UValidador.esNulo(ll_find)) {
			if (dwc_ConceptoAccesoFiltrado.get(ll_find).getFlagarchivo().equals("S")
					|| !UValidador.estaVacio(dw_1.getUuidalfresco())) {
				if (!dw_1.getCategoriaautorizacion().equals("VACA")
						&& !(dw_1.getCategoriaautorizacion().equals("ADFR") && "S".equals(dw_1.getEstado()))) {
					opciones.setIsmostrarseleccionar(true);
					opciones.setIsmostrarrutadocumento(true);
					if (!UValidador.estaVacio(dw_1.getRutadocumento())) {
						opciones.setIsmostrarver(true);
					}
					opciones.setIsmostrartarchivo(true);
				}

			} else {
				opciones.setIsmostrarseleccionar(false);
				opciones.setIsmostrarver(false);
				opciones.setIsmostrarrutadocumento(false);
				opciones.setIsmostrartarchivo(false);
				dw_1.setArchivodata(null);
				dw_1.setRutadocumento(null);
			}

			// RESOLUCION
			if (dwc_ConceptoAccesoFiltrado.get(ll_find).getFlagtieneresolucion().equals("S")) {
				opciones.setIsmostrarnroresolucion(true);
			} else {
				opciones.setIsmostrarnroresolucion(false);
				dw_1.setNroresolucion(null);
				dw_1.setFecharesolucion(null);
			}
		}

		if (concepto.equals("CHOR")) {

			if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
			}

			opciones.setIsmostrardwhorario(true);
			opciones.setIsmostrarsttitulo(true);
			if (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Browse")) {
				opciones.setIsmostrarcbinsertar(true);
				opciones.setIsmostrarcbeliminar(true);
			}

			// cargamos el combo de tipo dia para los horarios
			lstTipoDia = getFacAsistencia().getAS().getAsmastDatawindow().DddwAsTipodiaasistenciaSelect();
		}

		if (dw_1.getCategoriaautorizacion().equals("COMP") && (!CComunSession.getInstance().getSyroyal().StrGlobal()
				.getGv_coming_from().equalsIgnoreCase("Delete"))) {

			String concepto1, concepto2;

			w_dlv = getFacCore().getParametrosmastServicio()
					.obtenerValorInteger(new ParametrosmastPk("AS", "999999", "NDIACOMPLV"));

			String confercomp = getFacCore().getParametrosmastServicio()
					.obtenerValorCadena(new ParametrosmastPk("AS", "999999", "CONFERCOMP"));
			if (UValidador.estaVacio(confercomp)) {
				confercomp = "";
			}

			if (confercomp.equals(dw_1.getConceptoacceso())) {
				concepto1 = "HNAU";
				concepto2 = "HNAU";
			} else {
				concepto1 = "HAUT";
				concepto2 = "HGAN";
			}

			Date w_fechainicio = wf_rangofechas(1, dw_1.getFecha(), w_dlv);

			Date w_fechafinal = wf_rangofechas(2, dw_1.getFecha(), 0);
			List data = new ArrayList<>();

			if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Browse")) {
				data = getFacAsistencia().getAS().getAsmainDatawindow()
						.DwAsAsistenciaHextraEditModif(dw_1.getEmpleado(), dw_1.getFecha());

				dw_diascompensados = data;
				if (!UValidador.esListaVacia(dw_diascompensados)) {
					for (DtoDwAsAsistenciaHextraEdit objmod : dw_diascompensados) {
						objmod.setCantidadhor(obtenerHorasAcumuladas(objmod.getCantidadreal()));
						objmod.setCompensadohor(obtenerHorasAcumuladas(objmod.getCantidad()));
						objmod.setDiferenciahor(obtenerHorasAcumuladas(objmod.getDiferencia()));
						totalsaldoactual = totalsaldoactual.add(objmod.getDiferencia());
						if (objmod.getSeleccion().equals(UConstante.CONSTANTE_OPCION_SI)) {
							objmod.setIsseleccionado(true);
						}
					}
					totalsaldoactualhor = obtenerHorasAcumuladas(totalsaldoactual);
				}

			} else {
				data = getFacAsistencia().getAS().getAsmainDatawindow().DwAsAsistenciaHextraEdit(dw_1.getEmpleado(),
						UFechaHora.obtenerFechaHoraInicioDiaDate(w_fechainicio),
						UFechaHora.obtenerFechaHoraFinDia(w_fechafinal), concepto1, concepto2, w_dfs, w_dlv);

				dw_diascompensados = data;

				if (UValidador.esListaVacia(dw_diascompensados)) {
				} else {
					for (DtoDwAsAsistenciaHextraEdit obj : dw_diascompensados) {
						obj.setCantidadhor(obtenerHorasAcumuladas(obj.getCantidad()));
						obj.setCompensadohor(obtenerHorasAcumuladas(obj.getCompensado()));
						obj.setDiferenciahor(obtenerHorasAcumuladas(obj.getDiferencia()));
						totalsaldoactual = totalsaldoactual.add(obj.getDiferencia());

					}
					totalsaldoactualhor = obtenerHorasAcumuladas(totalsaldoactual);
				}
			}

			opciones.setIsmostrardiascompensados(true);
		}

		// si es concepto de un un dia "flagUnDia" ocultanos la fecha de fin
		// salvo autorización de sobretiempo
		if (!"PAHE".equals(concepto)) {
			opciones.setIshabilitarfechafin(true);
			AsConceptoacceso objfind = (AsConceptoacceso) getFacAsistencia().getAsConceptoaccesoServicio()
					.obtenerPorId(new AsConceptoaccesoPk(concepto));
			if (!UValidador.esNulo(objfind)) {
				if ("S".equals(objfind.getFlagUnDia())) {
					opciones.setIshabilitarfechafin(false);
				}
			}
		}

		// si es almuerzo con la familia, colocamos los intervalos por defecto
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
			if ("73".equals(concepto)) {
				dw_1.setDesde1(UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(),
						UFechaHora.convertirCadenaFecha("12:30:00", "HH:mm:ss")));
				dw_1.setHasta1(UFechaHora.obtenerFechaCompuesta(dw_1.getFechafin(),
						UFechaHora.convertirCadenaFecha("15:00:00", "HH:mm:ss")));
				keyhorainicio();
			} else if ("86".equals(concepto)) {

				if (!UValidador.esNulo(dw_1.getFecha())) {
					Date horasalida = getFacAsistencia().getAsAutorizacionServicio()
							.obtenerHorarioEmpleado(dw_1.getEmpleado(), dw_1.getFecha(), "F");
					String horsalida = UFechaHora.convertirFechaCadena(horasalida, "HH:mm:ss");

					dw_1.setHasta1(UFechaHora.obtenerFechaCompuesta(dw_1.getFechafin(),
							UFechaHora.convertirCadenaFecha(horsalida, "HH:mm:ss")));
					dw_1.setDesde1(
							UFechaHora
									.obtenerFechaCompuesta(dw_1.getFecha(),
											UFechaHora.convertirCadenaFecha(
													UFechaHora.convertirFechaCadena(
															UFechaHora.addHorasToDate(horasalida, -4), "HH:mm:ss"),
													"HH:mm:ss")));

					opciones.setIshabilitardesde1(false);
					opciones.setIshabilitarhasta1(false);
					String horentrada = UFechaHora.convertirFechaCadena(
							UFechaHora.addHorasToDate(horasalida, -(4 + obtenerHorasRefrigerio().intValue())),
							"HH:mm:ss");
					dw_1.setDesde1(UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(),
							UFechaHora.convertirCadenaFecha(horentrada, "HH:mm:ss")));
					keyhorainicio();
				}

			} else {
				dw_1.setDesde1(UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(),
						UFechaHora.convertirCadenaFecha("00:00:00", "HH:mm:ss")));
				dw_1.setHasta1(UFechaHora.obtenerFechaCompuesta(dw_1.getFechafin(),
						UFechaHora.convertirCadenaFecha("00:00:00", "HH:mm:ss")));
				keyhorainicio();
			}
		}

		if (UConstante.CONSTANTE_CONCEPTO_RESOLUCION_0044.equals(concepto)
				|| UConstante.CONSTANTE_CONCEPTO_LICENCIA_EXAMEN_ONCO.equals(dw_1.getConceptoacceso())) {
			Empleadomast emp = (Empleadomast) getFacCore().getEmpleadomastServicio()
					.obtenerPorId(new EmpleadomastPk(dw_1.getEmpleado(), getUsuarioActual().getCompaniaSocioCodigo()));

			if (!UValidador.esNulo(emp)) {
				String tipoplanilla = emp.getTipoplanilla();
				lstPeriodosPlanilla = getFacPlanilla().getPrProcesoperiodoServicio()
						.listarPeriodosXPlanilla(tipoplanilla);
			}
			diasLicPer = getFacCore().getParametrosmastServicio()
					.obtenerValorInteger(new ParametrosmastPk("AS", "999999", "MAXDIARCLI")) + 1;
		}

		wf_Refrescar_Visibilidad_Hora();
	}

	private Date wf_rangofechas(Integer pardato, Date fecha, Integer par_dias) throws Exception {
		if (pardato == 1) {
			return UFechaHora.obtenerFechaMasMeses(fecha, -par_dias);
		}
		if (pardato == 2) {
			return UFechaHora.convertirCadenaFecha(UFechaHora.convertirFechaCadena(fecha), "dd/MM/yyyy");
		}
		return null;
	}

	private void guardarEmpleadoExcepcion() {
		// TODO Auto-generated method stub
		List<AsEmpleadoexcepcionsolicitud> horarios = getFacAsistencia().getAsEmpleadoexcepcionsolicitudServicio()
				.listarEmpleadoExcepcionSolicitud(dw_1.getEmpleado(), dw_1.getFecha());

		if (!UValidador.esListaVacia(horarios)) {

			// EN CASO SE REAPRUEBE UNA SOLICITUD
			// -ELIMINAR
			for (AsEmpleadoexcepcionsolicitud objhor : horarios) {
				AsEmpleadoexcepcionPk pkdel = new AsEmpleadoexcepcionPk();
				pkdel.setEmpleado(dw_1.getEmpleado());
				pkdel.setFecha(objhor.getPk().getFecha());
				pkdel.setFechahasta(objhor.getPk().getFecha());

				AsEmpleadoexcepcion objdel = (AsEmpleadoexcepcion) getFacAsistencia().getAsEmpleadoexcepcionServicio()
						.obtenerPorId(pkdel, false);

				if (!UValidador.esNulo(objdel)) {
					getFacAsistencia().getAsEmpleadoexcepcionServicio().eliminar(objdel);
				}

				AsEmpleadoexcepciondetallePk pkdetdel = new AsEmpleadoexcepciondetallePk();
				pkdetdel.setEmpleado(dw_1.getEmpleado());
				pkdetdel.setFecha(objhor.getPk().getFecha());
				pkdetdel.setIntervaloacceso(objhor.getIntervaloacceso());
				pkdetdel.setSecuencia(1);

				AsEmpleadoexcepciondetalle objdetdel = (AsEmpleadoexcepciondetalle) getFacAsistencia()
						.getAsEmpleadoexcepciondetalleServicio().obtenerPorId(pkdetdel, false);

				if (!UValidador.esNulo(objdetdel)) {
					getFacAsistencia().getAsEmpleadoexcepciondetalleServicio().eliminar(objdetdel);
				}

			}

			for (AsEmpleadoexcepcionsolicitud objhor : horarios) {
				AsEmpleadoexcepcion objinsempex = new AsEmpleadoexcepcion();
				objinsempex.getPk().setEmpleado(dw_1.getEmpleado());
				objinsempex.getPk().setFecha(objhor.getPk().getFecha());
				objinsempex.getPk().setFechahasta(objhor.getPk().getFecha());
				objinsempex.setDescripcion(objhor.getDescripcion());
				objinsempex.setDomingo("S");
				objinsempex.setLunes("S");
				objinsempex.setMartes("S");
				objinsempex.setMiercoles("S");
				objinsempex.setJueves("S");
				objinsempex.setViernes("S");
				objinsempex.setSabado("S");
				objinsempex.setEstado("A");
				objinsempex.setUltimoUsuario(getUsuarioActual().getCodigoUsuario());
				objinsempex.setUltimaFechaModif(new Date());

				getFacAsistencia().getAsEmpleadoexcepcionServicio().registrar(objinsempex);

				// REGISTRAMOS EL DETALLE

				AsEmpleadoexcepciondetalle objinsempexdet = new AsEmpleadoexcepciondetalle();
				objinsempexdet.getPk().setEmpleado(dw_1.getEmpleado());
				objinsempexdet.getPk().setFecha(objhor.getPk().getFecha());
				objinsempexdet.getPk().setIntervaloacceso(objhor.getIntervaloacceso());
				objinsempexdet.getPk().setSecuencia(1);
				objinsempexdet.setTipodia(objhor.getTipodia());

				getFacAsistencia().getAsEmpleadoexcepciondetalleServicio().registrar(objinsempexdet);
			}
		}
	}

	public void valuechangedHorarioTipoDia(ValueChangeEvent event) {
		BigDecimal tipodia = (BigDecimal) event.getNewValue();

		if (UValidador.esCero(tipodia.intValue())) {
			dw_horarioregistro.setTipodia(BigDecimal.ZERO);
			dw_horarioregistro.setDescripcion("(Ninguno)");
			dw_horarioregistro.setHorasdescripcion("00:00");
			dw_horarioregistro.setHorasrefrigeriodescripcion("00:00");
		}

		for (DtoDddwAsTipodiaasistenciaSelect obj : lstTipoDia) {
			if (UValidador.esCero(obj.getTipodia().compareTo(tipodia))) {
				dw_horarioregistro.setDescripcion(obj.getDescripcionlocal());
				dw_horarioregistro.setHoras(obj.getSuma());
				dw_horarioregistro.setHorasrefrigerio(obj.getSumarefrigerio());
				dw_horarioregistro.setHorainicio(obj.getHorainicio());
				dw_horarioregistro.setHorafin(obj.getHorafin());

				if (UValidador.esCero(dw_horarioregistro.getHoras().intValue())) {
					dw_horarioregistro.setHorasdescripcion("00:00");
				} else {
					dw_horarioregistro.setHorasdescripcion(obtenerHorasAcumuladas(dw_horarioregistro.getHoras()));
				}

				if (UValidador.esCero(dw_horarioregistro.getHorasrefrigerio().intValue())) {
					dw_horarioregistro.setHorasrefrigeriodescripcion("00:00");
				} else {
					dw_horarioregistro.setHorasrefrigeriodescripcion(
							obtenerHorasAcumuladas(dw_horarioregistro.getHorasrefrigerio()));
				}

				break;
			}
		}

	}

	public void valuechangeFecha(SelectEvent event) throws Exception {

		if (UValidador.esNulo(event)) {
			return;
		}

		Date fecha = (Date) event.getObject();

		dw_1.setFecha(fecha);
		dw_1.setFechafin(UFechaHora.obtenerFechaHoraFinDia(fecha));

		eliminarHorariosFueraRango(1);

		wf_poner_fecha_fin();

		if ("OMIS".equals(dw_1.getCategoriaautorizacion())) {
			if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
				// nuevo cambio 24/01/2019
				dw_1.setDesde1(null);
			}
		}

		diferenciaDia = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1 + "";

		if (flgDiaSiguiente) {
			dw_1.setFechafin(UFechaHora.obtenerFechaHoraFinDia(UFechaHora.anadirDiasAFechas(fecha, 1)));
		}

	}

	public void valuechangeFechaFin(SelectEvent event) throws Exception {

		if (UValidador.esNulo(event)) {
			return;
		}

		Date fecha = (Date) event.getObject();
		dw_1.setFechafin(UFechaHora.obtenerFechaHoraFinDia(fecha));

		eliminarHorariosFueraRango(2);

		wf_poner_fecha_fin();

		if ("VACA".equals(dw_1.getConceptoacceso()) || "ADEL".equals(dw_1.getConceptoacceso())
				|| "FRAD".equals(dw_1.getConceptoacceso())) {
			diferenciaDia = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1 + "";
		} else {
			diferenciaDia = getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(dw_1.getFecha(),
					dw_1.getFechafin()) + "";
		}

	}

	public void valuechangeFechaRecupera(SelectEvent event) throws Exception {

		if (UValidador.esNulo(event)) {
			return;
		}
		Date fecha = (Date) event.getObject();
		dw_1.setDesderecupera(fecha);
		dw_1.setHastarecupera(UFechaHora.obtenerFechaMasdias(dw_1.getDesderecupera(), diasLicPer - 1));

	}

	public void keyfechainicioRecupera() throws Exception {
		dw_1.setHastarecupera(UFechaHora.obtenerFechaMasdias(dw_1.getDesderecupera(), diasLicPer - 1));
	}

	public void valuechangeTipoAutorizacion(ValueChangeEvent event) throws Exception {

		if (UValidador.esNulo(event)) {
			return;
		}

		String tipo = (String) event.getNewValue();
		dw_1.setTipoautorizacion(tipo);

		validateTipoAutorizacion(tipo);

	}

	private void validateTipoAutorizacion(String tipo) throws Exception {

		if (UValidador.estaVacio(tipo)) {
			return;
		}

		// opciones.setIsmostrardesde1(true);
		// opciones.setIsmostrarhasta1(true);
		// if (tipo.equals("D")) {
		// opciones.setIsmostrardesde1(false);
		// opciones.setIsmostrarhasta1(false);
		// }
	}

	public void keyfechainicio() throws Exception {

		dw_1.setFechafin(dw_1.getFecha());

		eliminarHorariosFueraRango(1);

		wf_poner_fecha_fin();

		if ("OMIS".equals(dw_1.getCategoriaautorizacion())) {
			if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
				// nuevo cambio 24/01/2019
				dw_1.setDesde1(null);
			}
		}

		diferenciaDia = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1 + "";

	}

	// public void mostraHoras(SelectEvent event) throws Exception {
	//
	// w_horainicio = dw_1.getDesde1();
	// w_horafin = dw_1.getHasta1();
	//
	// horasSeleccionadas = BigDecimal.ZERO;
	// horasSeleccionadas = wf_diftiempo(w_horainicio,
	// w_horafin).divide(BigDecimal.valueOf(3600), 2,
	// BigDecimal.ROUND_HALF_UP);
	//
	// horasSeleccionadas =
	// horasSeleccionadas.subtract(obtenerHorasRefrigerio());
	// Integer diastrans =
	// (UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha())
	// + 1);
	//
	// horasSeleccionadas = horasSeleccionadas.multiply(new
	// BigDecimal(diastrans)).setScale(2,
	// BigDecimal.ROUND_HALF_UP);
	// }

	public void keyfechafin() throws Exception {
		// eliminarHorariosFueraRango(2);
		//
		// wf_poner_fecha_fin();
		if ("VACA".equals(dw_1.getConceptoacceso()) || "ADEL".equals(dw_1.getConceptoacceso())
				|| "FRAD".equals(dw_1.getConceptoacceso())) {
			diferenciaDia = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1 + "";
		} else {
			diferenciaDia = getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(dw_1.getFecha(),
					dw_1.getFechafin()) + "";
		}

	}

	public void keyhorainicio() throws Exception {

		if ("OMIS".equals(dw_1.getConceptoacceso())) {
			return;
		}

		double horas = UFechaHora.obtenerDiferenciaSegundos(dw_1.getDesde1(), dw_1.getHasta1()) / 3600.0;
		if (horas < 0.0) {
			horas = 0.0;
		}
		horas = new BigDecimal(horas).subtract(obtenerHorasRefrigerio()).doubleValue();
		diferenciaHora = obtenerHorasAcumuladas(BigDecimal.valueOf(horas));

	}

	public void keyhorafin() throws Exception {

		double horas = UFechaHora.obtenerDiferenciaSegundos(dw_1.getDesde1(), dw_1.getHasta1()) / 3600.0;
		if (horas < 0.0) {
			horas = 0.0;
		}
		horas = new BigDecimal(horas).subtract(obtenerHorasRefrigerio()).doubleValue();
		diferenciaHora = obtenerHorasAcumuladas(BigDecimal.valueOf(horas));

	}

	public void validarfechainicio(FacesContext context, UIComponent component, Object value) {
		if (UValidador.esNulo(value)) {
			FacesMessage message = new FacesMessage("El campo fecha del es requerida");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);

			throw new ValidatorException(message);
		}

		try {
			dw_1.setFecha((Date) value);
		} catch (Exception e) {
			return;
		}
	}

	public void validarfechafin(FacesContext context, UIComponent component, Object value) {
		if (UValidador.esNulo(value)) {
			FacesMessage message = new FacesMessage("El campo fecha al es requerida");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);

			throw new ValidatorException(message);
		}

		try {
			dw_1.setFechafin((Date) value);
		} catch (Exception e) {
			return;
		}
	}

	@SuppressWarnings("rawtypes")
	private void wf_Refrescar_Visibilidad_Hora() throws Exception {
		if (dw_1.getCategoriaautorizacion().equals("COMP") || dw_1.getCategoriaautorizacion().equals("OTRO")
				|| dw_1.getCategoriaautorizacion().equals("VACA") || dw_1.getCategoriaautorizacion().equals("SOBR")
				|| dw_1.getCategoriaautorizacion().equals("ADFR")) {
			dwc_ConceptoAccesoFiltrado.clear();
			dwc_ConceptoAccesoFiltrado.addAll(dwc_ConceptoAcceso);

			if (dw_1.getCategoriaautorizacion().equals("COMP")) {
				dwc_ConceptoAccesoFiltrado.clear();
				for (DtoDddwAsConceptoaccesoSelectPre obj : dwc_ConceptoAcceso) {
					if (obj.getFlagcompensa().equals("S")) {
						dwc_ConceptoAccesoFiltrado.add(obj);
					}
				}
			}
			if (dw_1.getCategoriaautorizacion().equals("OTRO")) {
				dwc_ConceptoAccesoFiltrado.clear();
				for (DtoDddwAsConceptoaccesoSelectPre obj : dwc_ConceptoAcceso) {
					if (obj.getFlagotrospermisos().equals("S")) {
						dwc_ConceptoAccesoFiltrado.add(obj);
					}
				}
			}

			if (dw_1.getCategoriaautorizacion().equals("ADFR")) {
				dwc_ConceptoAccesoFiltrado.clear();
				for (DtoDddwAsConceptoaccesoSelectPre obj : dwc_ConceptoAcceso) {
					if (obj.getFlagvacaciones().equals("S")) {
						dwc_ConceptoAccesoFiltrado.add(obj);
					}
				}
			}

			if (!UValidador.esListaVacia(dwc_ConceptoAccesoFiltrado)) {
				String ls_conceptoacceso;
				Integer ll_find = null;

				ls_conceptoacceso = dw_1.getConceptoacceso(); // el concepto
																// acceso
																// seleccionado
				for (int i = 0; i < dwc_ConceptoAccesoFiltrado.size(); i++) {
					DtoDddwAsConceptoaccesoSelectPre obj = dwc_ConceptoAccesoFiltrado.get(i);
					if (obj.getConceptoacceso().equals(ls_conceptoacceso)) {
						ll_find = i;
					}
				}

				if (!UValidador.esNulo(ll_find)) {
					if (dwc_ConceptoAccesoFiltrado.get(ll_find).getExpresadoen().equals("D") && iscambioonceptoevento) {
						opciones.setIsmostrartextohora1(false);
						opciones.setIsmostrartextohora2(false);
						opciones.setIsmostrartde(false);
						opciones.setIsmostrarta(false);
						opciones.setIsmostrardesde1(false);
						opciones.setIsmostrarhasta1(false);

						Integer ll_empleado;
						Date ldt_fecha;
						Date ldt_desde = null, ldt_hasta = null;
						ll_empleado = dw_1.getEmpleado();
						ldt_fecha = dw_1.getFecha();

						List data = getFacAsistencia().getAS().getAsrepusFuncion()
								.FAsAutorizacionPreprocesoTipodia2(ll_empleado, ldt_fecha);

						if (!UValidador.esListaVacia(data)) {
							ldt_desde = (Date) data.get(0);
							ldt_hasta = (Date) data.get(1);
						}

						if (!UValidador.esNulo(ldt_desde)) {
							dw_1.setDesde1(ldt_desde);
						}
						if (!UValidador.esNulo(ldt_hasta)) {
							dw_1.setHasta1(ldt_hasta);
						}

						keyhorainicio();
						iscambioonceptoevento = false;
					} else {
						opciones.setIsmostrartextohora1(true);
						opciones.setIsmostrartextohora2(true);
						opciones.setIsmostrartde(true);
						opciones.setIsmostrarta(true);
						opciones.setIsmostrardesde1(false);
						opciones.setIsmostrarhasta1(false);
						if (!dw_1.getCategoriaautorizacion().equals("VACA")) {
							if (!dwc_ConceptoAccesoFiltrado.get(ll_find).getExpresadoen().equals("D")) {
								opciones.setIsmostrardesde1(true);
								opciones.setIsmostrarhasta1(true);
							}
						}

					}
				} else {
					if (dw_1.getCategoriaautorizacion().equals("VACA")) {
						opciones.setIsmostrartextohora1(false);
						opciones.setIsmostrartextohora2(false);
						opciones.setIsmostrartde(false);
						opciones.setIsmostrarta(false);
						opciones.setIsmostrardesde1(false);
						opciones.setIsmostrarhasta1(false);
					} else {
						if (dw_1.getCategoriaautorizacion().equals("SOBR")
								|| dw_1.getCategoriaautorizacion().equals("COMP")) {
							opciones.setIsmostrartextohora1(true);
							opciones.setIsmostrartextohora2(true);
							opciones.setIsmostrartde(true);
							opciones.setIsmostrarta(true);
							opciones.setIsmostrardesde1(true);
							opciones.setIsmostrarhasta1(true);
						}
					}
				}
			}

		} else if (dw_1.getCategoriaautorizacion().equals("OMIS")) {
			opciones.setIsmostrartextohora1(true);
			opciones.setIsmostrartextohora2(true);
			opciones.setIsmostrartde(true);
			opciones.setIsmostrarta(false);
			opciones.setIsmostrardesde1(true);
			opciones.setIsmostrarhasta1(false);
		} else if (dw_1.getCategoriaautorizacion().equals("PSIG")) {
			opciones.setIsmostrartextohora1(false);
			opciones.setIsmostrartextohora2(false);
			opciones.setIsmostrartde(false);
			opciones.setIsmostrarta(false);
			opciones.setIsmostrardesde1(false);
			opciones.setIsmostrarhasta1(false);
		} else {
			opciones.setIsmostrartextohora1(true);
			opciones.setIsmostrartextohora2(true);
			opciones.setIsmostrartde(true);
			opciones.setIsmostrarta(true);
			opciones.setIsmostrardesde1(true);
			opciones.setIsmostrarhasta1(true);
		}
	}

	private void eliminarHorariosFueraRango(Integer maxmin) {
		if (dw_1.getConceptoacceso().equals("CHOR")) {
			if (!UValidador.esListaVacia(dw_horario)) {
				for (int i = 0; i < dw_horario.size(); i++) {
					DtoDwCambioHorarioExcepcion obj = dw_horario.get(i);
					obj.setFechasolicitud(dw_1.getFecha());
					if (maxmin.equals(1)) { // fecha inicio
						if (obj.getFecha().before(dw_1.getFecha()) || obj.getFecha().after(dw_1.getFechafin())) {
							dw_horario.remove(i);
							i--;
						}
					}
					if (maxmin.equals(2)) { // fecha fin
						if (obj.getFecha().after(dw_1.getFechafin())) {
							dw_horario.remove(i);
							i--;
						}
					}
				}
			}
		}

	}

	public void validarEmpleado(FacesContext context, UIComponent component, Object value) {
		if (UValidador.esNulo(value) || UValidador.esCero((Integer) value)) {
			FacesMessage message = new FacesMessage("Debe seleccionar al Empleado antes de asignar el evento");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);

			throw new ValidatorException(message);
		}
	}

	public void limpiarEmpleado() {
		dw_1.setEmpleado(null);
		dw_1.setEmpleadonombre(null);
		dw_1.setPuesto(null);
		dw_1.setCentrocosto(null);
	}

	public String nuevoHorario() throws Exception {

		setAccionPantalla(accion_solicitada.NUEVO);

		dw_horarioregistro = new DtoDwCambioHorarioExcepcion();

		Integer secuencia = 0;

		for (int k = 0; k < dw_horario.size(); k++) {
			if (dw_horario.get(k).getSecuencia() > secuencia) {
				secuencia = dw_horario.get(k).getSecuencia();
			}
		}

		secuencia++;

		dw_horarioregistro.setSecuencia(secuencia);
		dw_horarioregistro.setFecha(dw_1.getFecha());
		dw_horarioregistro.setTipodia(null);
		dw_horarioregistro.setHoras(BigDecimal.valueOf(0.0));
		dw_horarioregistro.setDescripcion(null);
		dw_horarioregistro.setEmpleado(dw_1.getEmpleado());
		dw_horarioregistro.setFechasolicitud(dw_1.getFecha());
		dw_horarioregistro.setFechahasta(UFechaHora.obtenerFechaHoraFinDia(dw_1.getFecha()));
		dw_horarioregistro.setIntervaloacceso("TRAB");
		dw_horarioregistro.setEstado("A");
		dw_horarioregistro.setUltimousuario(getUsuarioActual().getLoginUsuario().toUpperCase());
		dw_horarioregistro.setUltimafecha(new Date());

		getWebControlContext().actualizar("dgHorarioMantenimiento");
		getWebControlContext().ejecutar("PF('popHorarioMantenimiento').show()");

		return null;
	}

	public void valuechangeHora(SelectEvent event) throws Exception {

		if (UValidador.esNulo(event)) {
			return;
		}

		Date fecha = (Date) event.getObject();

		dw_1.setDesde1(fecha);

		double horas = UFechaHora.obtenerDiferenciaSegundos(dw_1.getDesde1(), dw_1.getHasta1()) / 3600.0;
		if (horas < 0.0) {
			horas = 0.0;
		}
		horas = new BigDecimal(horas).subtract(obtenerHorasRefrigerio()).doubleValue();
		diferenciaHora = obtenerHorasAcumuladas(BigDecimal.valueOf(horas));

	}

	public void valuechangeHoraFin(SelectEvent event) throws Exception {

		if (UValidador.esNulo(event)) {
			return;
		}

		Date fecha = (Date) event.getObject();

		dw_1.setHasta1(fecha);

		double horas = UFechaHora.obtenerDiferenciaSegundos(dw_1.getDesde1(), dw_1.getHasta1()) / 3600.0;
		if (horas < 0.0) {
			horas = 0.0;
		}
		horas = new BigDecimal(horas).subtract(obtenerHorasRefrigerio()).doubleValue();
		diferenciaHora = obtenerHorasAcumuladas(BigDecimal.valueOf(horas));

	}

	public String editarHorario() {

		setAccionPantalla(accion_solicitada.EDITAR);

		getWebControlContext().actualizar("dgHorarioMantenimiento");
		getWebControlContext().ejecutar("PF('popHorarioMantenimiento').show()");

		return null;
	}

	public String copiarHorario() {
		if (!UValidador.esListaVacia(dw_horario)) {
			dw_horarioregistro = dw_horario.get(dw_horario.size() - 1);

			// el objcopia sera el que tenga la fecha mayor
			Date maxfecha = dw_horarioregistro.getFecha();
			for (DtoDwCambioHorarioExcepcion hor : dw_horario) {
				if (hor.getFecha().after(maxfecha)) {
					dw_horarioregistro = hor;
				}
			}

			Integer secuencia = 0;

			for (int k = 0; k < dw_horario.size(); k++) {
				if (dw_horario.get(k).getSecuencia() > secuencia) {
					secuencia = dw_horario.get(k).getSecuencia();
				}
			}

			secuencia++;

			DtoDwCambioHorarioExcepcion objcopia = new DtoDwCambioHorarioExcepcion();

			objcopia.setSecuencia(secuencia);
			objcopia.setDescripcion(dw_horarioregistro.getDescripcion());
			objcopia.setEmpleado(dw_horarioregistro.getEmpleado());
			objcopia.setEstado(dw_horarioregistro.getEstado());
			objcopia.setFechahasta(dw_horarioregistro.getFechahasta());
			objcopia.setFechasolicitud(dw_horarioregistro.getFechasolicitud());
			objcopia.setFecha(dw_horarioregistro.getFecha());
			objcopia.setHoras(dw_horarioregistro.getHoras());
			objcopia.setHorasdescripcion(dw_horarioregistro.getHorasdescripcion());
			objcopia.setHorasrefrigerio(dw_horarioregistro.getHorasrefrigerio());
			objcopia.setHorasrefrigeriodescripcion(dw_horarioregistro.getHorasrefrigeriodescripcion());
			objcopia.setIntervaloacceso(dw_horarioregistro.getIntervaloacceso());
			objcopia.setTipodia(dw_horarioregistro.getTipodia());

			objcopia.setFecha(UFechaHora.obtenerFechaMasdias(objcopia.getFecha(), 1));

			if (objcopia.getFecha().after(dw_1.getFechafin())) {
				setMessageError("No puede copiar la fecha, sobrepasaría la fecha fin de la Autorización");
				return null;
			}

			Integer diasemana = UFechaHora.obtenerNumeroDiaSemana(objcopia.getFecha());
			String nombre = UFechaHora.obtenerDiaEnCadena(diasemana);
			objcopia.setDianombre(nombre);

			dw_horario.add(objcopia);

			calcularTotalHorasHorario();

		}

		return null;
	}

	public String insertarHorario() {

		// Validando las fechas
		for (int i = 0; i < dw_horario.size(); i++) {
			if (!dw_horario.get(i).getSecuencia().equals(dw_horarioregistro.getSecuencia())) {
				if (UValidador.esCero(UFechaHora.obtenerDiasTranscurridos(dw_horario.get(i).getFecha(),
						dw_horarioregistro.getFecha()))) {
					setMessageError("Ya existe una fecha igual, verifique por favor.");
					return null;
				}
			}
		}

		Integer diasemana = UFechaHora.obtenerNumeroDiaSemana(dw_horarioregistro.getFecha());
		LOGGER.debug("diasemana " + diasemana);
		String nombre = UFechaHora.obtenerDiaEnCadena(diasemana);
		LOGGER.debug("nombre " + nombre);

		dw_horarioregistro.setDianombre(nombre);
		dw_horarioregistro.setFechahasta(dw_horarioregistro.getFecha());

		if (getAccionPantalla().equals(accion_solicitada.NUEVO)) {
			dw_horario.add(dw_horarioregistro);
		}

		if (getAccionPantalla().equals(accion_solicitada.EDITAR)) {
			for (DtoDwCambioHorarioExcepcion obj : dw_horario) {
				if (obj.getSecuencia().equals(dw_horarioregistro.getSecuencia())) {
					obj = dw_horarioregistro;
					break;
				}
			}
		}

		calcularTotalHorasHorario();

		getWebControlContext().actualizar("wasautorizacionpreprocesohextraedit:tblHorario");
		getWebControlContext().ejecutar("PF('popHorarioMantenimiento').hide()");

		return null;
	}

	public String eliminarHorario() {
		for (int i = 0; i < dw_horario.size(); i++) {
			DtoDwCambioHorarioExcepcion obj = dw_horario.get(i);
			if (obj.getSecuencia().equals(dw_horarioregistro.getSecuencia())) {
				dw_horario.remove(i);
				i--;
			}
		}

		calcularTotalHorasHorario();
		return null;
	}

	private void calcularTotalHorasHorario() {
		totalhorashorario = new BigDecimal(0.0);
		totalhorastrabajo = new BigDecimal(0.0);
		totalhorasrefrigerio = new BigDecimal(0.0);

		for (DtoDwCambioHorarioExcepcion obj : dw_horario) {
			totalhorastrabajo = totalhorastrabajo.add(obj.getHoras());
			totalhorasrefrigerio = totalhorasrefrigerio.add(obj.getHorasrefrigerio());
		}

		totalhorashorario = totalhorashorario.add(totalhorastrabajo).add(totalhorasrefrigerio);

		totalhorashorariodescripcion = obtenerHorasAcumuladas(totalhorashorario);
		totalhorastrabajodescripcion = obtenerHorasAcumuladas(totalhorastrabajo);
		totalhorasrefrigeriodescripcion = obtenerHorasAcumuladas(totalhorasrefrigerio);
	}

	public void verDocumento() throws Exception {

		String archivo = dw_1.getRutadocumento();

		archivo = UFile.remplazarTildes(archivo);

		if (!UValidador.esNulo(dw_1.getUuidalfresco())) {
			switch (obtenerParametroModoArchivo()) {
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

				if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
					this.setMessageError("No se encontraron los parametros key o ws");
					return;
				}

				try {
					ContenidoECMBean respuestaconsulta = getuOsinergminAlfresco().obtenerDocumento(dw_1.getUuidalfresco());
					LOGGER.debug(respuestaconsulta);
					if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
						LOGGER.debug("Se encontro el archivo");
						UFile.descargarArchivo(respuestaconsulta.getContenidoFile(), archivo);
						// new
						// UFile().cargarArchivoXByte(respuestaconsulta.getContenidoFile(),
						// archivo, "temporaloefa");
						System.gc();
					}
				} catch (Exception e) {
					LOGGER.debug(e.getMessage());
					this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
					return;
				}
			}
		} else {
			if (!UValidador.esNulo(dw_1.getRutadocumento())) {
			} else {
				setMessageError("No ha seleccionado ningún archivo");
				return;
			}
		}

		// setSessionValue("nombrearchivo", archivo);

		return;
	}

	public void verDocumentoDj() throws Exception {

		String archivo = dw_1.getNombrearchivodj();

		archivo = UFile.remplazarTildes(archivo);

		if (!UValidador.esNulo(dw_1.getUuiddj())) {
			switch (obtenerParametroModoArchivo()) {
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

				if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
					this.setMessageError("No se encontraron los parametros key o ws");
					return;
				}

				try {
					ContenidoECMBean respuestaconsulta = getuOsinergminAlfresco().obtenerDocumento(dw_1.getUuiddj());
					LOGGER.debug(respuestaconsulta);
					if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
						LOGGER.debug("Se encontro el archivo");
						UFile.descargarArchivo(respuestaconsulta.getContenidoFile(), archivo);
						System.gc();
					}
				} catch (Exception e) {
					LOGGER.debug(e.getMessage());
					this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
					return;
				}
			}
		} else {
			if (!UValidador.esNulo(dw_1.getNombrearchivodj())) {
				// new UFile().cargarArchivoXByte(UFile
				// .obtenerArregloByte(dw_1
				// .getRutadocumento()), archivo, "temporaloefa");
			} else {
				setMessageError("No ha seleccionado ningún archivo");
				return;
			}
		}

		// setSessionValue("nombrearchivo", archivo);

		return;
	}

	public String empleadoKeyEvent() throws Exception {

		LOGGER.debug("dw_1.getEmpleado() " + dw_1.getEmpleado());

		if (UValidador.esNulo(dw_1.getEmpleado())) {
			return null;
		}

		Integer w_sid = getUsuarioActual().getUniqueIdInteger();
		LOGGER.debug("w_sid == " + w_sid);

		List empleados = getFacAsistencia().getAS().getAsoracleDatawindow().DwAsEmpleadoSelectMultiple(w_sid,
				dw_1.getEmpleado().toString(), null);

		if (UValidador.esListaVacia(empleados)) {
			setMessageError("El empleado esta cesado o no existe.");
			limpiarEmpleado();
			return null;
		}

		DtoDwAsEmpleadoSelectMultiple emp = (DtoDwAsEmpleadoSelectMultiple) empleados.get(0);

		if (UValidador.estaVacio(emp.getEstado())) {
			emp.setEstado("");
		}

		if (!emp.getEstado().equals("A")) {
			setMessageError("El empleado esta cesado o no existe.");
		}

		PersonamastPk pkfindp = new PersonamastPk();
		pkfindp.setPersona(emp.getPersona().intValue());

		Personamast objfindp = (Personamast) getFacCore().getPersonamastServicio().obtenerPorId(pkfindp, false);

		cargarInfoEmpleado(emp.getPersona().intValue(), objfindp.getNombrecompleto());

		if (!UValidador.estaVacio(dw_1.getCategoriaautorizacion())) {
			cargarEvento(dw_1.getCategoriaautorizacion());
			cargarConceptoAcceso(dw_1.getConceptoacceso());
		}

		return null;

	}

	public String obtenerNombreUsuario(String usuario) {
		String nombre = null;

		if (!UValidador.estaVacio(usuario)) {
			Usuario user = (Usuario) getFacSeguridad().getUsuarioServicio()
					.obtenerPorId(new UsuarioPk(usuario.toUpperCase()));
			if (!UValidador.esNulo(user)) {
				nombre = user.getNombre() + " " + user.getPk().getUsuario();
			}

		}
		return nombre;
	}

	public String guardardesdelicencia() throws Exception {
		if (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Delete")) {
			if ("A".equals(dw_1.getEstado())) {
				setMessageSuccess("Se registró la autorización correctamente", true);
			}
			if ("S".equals(dw_1.getEstado())) {
				setMessageSuccess("Se registró la solicitud correctamente", true);
			}
		}
		CwAsAutorizacionPreprocesoAprobacion.getInstance().iniciarControladora();
		return "w_as_autorizacion_preproceso_aprobacion";
	}

	private DtoPermisosEnCompensacion obtenerPermisosCompensacion(Integer empleado, Date finpermiso,
			Integer diasCopensa) throws Exception {
		// TODO Auto-generated method stub
		Integer anio = UFechaHora.obtenerAnio();
		DtoPermisosEnCompensacion obj = new DtoPermisosEnCompensacion();
		List<DtoPermisosEnCompensacion> datos = getFacAsistencia().getAsAutorizacionServicio()
				.listarPermisosCompensacion(empleado, anio);

		if (!UValidador.esListaVacia(datos)) {
			for (DtoPermisosEnCompensacion row : datos) {
				if (wf_diftiempo(row.getDesde(), row.getHasta())
						.subtract(obtenerHorasViernesVerano(empleado, row.getDesderecupera(), row.getHastarecupera()))
						.compareTo(row.getHorascompensadas()) == 1) {
					obj.setDesderecupera(UFechaHora.anadirDiasAFechas(row.getHastarecupera(), 1));
					// si es menor a la fecha actual, el inicio es la fecha
					// actual
					if (obj.getDesderecupera().getTime() < new Date().getTime()) {
						obj.setDesderecupera(new Date());
					}
					obj.setHastarecupera(UFechaHora.anadirDiasAFechas(obj.getDesderecupera(), diasCopensa.intValue()));
				} else {
					obj.setDesderecupera(UFechaHora.anadirDiasAFechas(finpermiso, 1));
					if (obj.getDesderecupera().getTime() < new Date().getTime()) {
						obj.setDesderecupera(new Date());
					}
					obj.setHastarecupera(UFechaHora.anadirDiasAFechas(obj.getDesderecupera(), diasCopensa));
				}
			}
		} else {
			obj.setDesderecupera(UFechaHora.anadirDiasAFechas(finpermiso, 1));
			if (obj.getDesderecupera().getTime() < new Date().getTime()) {
				obj.setDesderecupera(new Date());
			}
			obj.setHastarecupera(UFechaHora.anadirDiasAFechas(obj.getDesderecupera(), diasCopensa));
		}

		return obj;
	}

	private BigDecimal obtenerHorasViernesVerano(Integer empleado, Date desde, Date hasta) throws Exception {
		// TODO Auto-generated method stub
		BigDecimal retorno = BigDecimal.ZERO;

		List<DtoPermisosEnCompensacion> lista = getFacAsistencia().getAsAutorizacionServicio()
				.listarPermisosViernesVerano(empleado, desde, hasta);

		if (!UValidador.esListaVacia(lista)) {
			for (DtoPermisosEnCompensacion obj : lista) {
				if (obj.getDesderecupera().getTime() >= desde.getTime()
						&& obj.getHastarecupera().getTime() <= hasta.getTime()) {
					retorno = retorno.add(new BigDecimal(
							UFechaHora.obtenerDiasTranscurridos(obj.getHastarecupera(), obj.getDesderecupera()) + 1));
				} else if (obj.getDesderecupera().getTime() >= desde.getTime()
						&& obj.getHastarecupera().getTime() > hasta.getTime()) {
					retorno = retorno.add(
							new BigDecimal(UFechaHora.obtenerDiasTranscurridos(hasta, obj.getDesderecupera()) + 1));
				} else if (obj.getDesderecupera().getTime() < desde.getTime()
						&& obj.getHastarecupera().getTime() <= hasta.getTime()) {
					retorno = retorno.add(
							new BigDecimal(UFechaHora.obtenerDiasTranscurridos(obj.getHastarecupera(), desde) + 1));
				}
			}
		}

		return retorno;
	}

	/**
	 * @return the dw_1
	 */
	public DtoDwAsAutorizacionPreprocesoHextraeditV2 getDw_1() {
		return dw_1;
	}

	/**
	 * @param dw_1
	 *            the dw_1 to set
	 */
	public void setDw_1(DtoDwAsAutorizacionPreprocesoHextraeditV2 dw_1) {
		this.dw_1 = dw_1;
	}

	/**
	 * @return the dddw_as_empleadosmast_select_carnets
	 */
	public List<DtoDddwAsEmpleadosmastSelectCarnets> getDddw_as_empleadosmast_select_carnets() {
		return dddw_as_empleadosmast_select_carnets;
	}

	/**
	 * @param dddw_as_empleadosmast_select_carnets
	 *            the dddw_as_empleadosmast_select_carnets to set
	 */
	public void setDddw_as_empleadosmast_select_carnets(
			List<DtoDddwAsEmpleadosmastSelectCarnets> dddw_as_empleadosmast_select_carnets) {
		this.dddw_as_empleadosmast_select_carnets = dddw_as_empleadosmast_select_carnets;
	}

	/**
	 * @return the dw_filtraterminal
	 */
	public DtoDwFiltroTerminal getDw_filtraterminal() {
		return dw_filtraterminal;
	}

	/**
	 * @param dw_filtraterminal
	 *            the dw_filtraterminal to set
	 */
	public void setDw_filtraterminal(DtoDwFiltroTerminal dw_filtraterminal) {
		this.dw_filtraterminal = dw_filtraterminal;
	}

	/**
	 * @return the opciones
	 */
	public OwAsAutorizacionPreprocesoHextraEdit getOpciones() {
		return opciones;
	}

	/**
	 * @param opciones
	 *            the opciones to set
	 */
	public void setOpciones(OwAsAutorizacionPreprocesoHextraEdit opciones) {
		this.opciones = opciones;
	}

	/**
	 * @return the dw_2
	 */
	public List<DtoDwAsMarcasEmpleado> getDw_2() {
		return dw_2;
	}

	/**
	 * @param dw_2
	 *            the dw_2 to set
	 */
	public void setDw_2(List<DtoDwAsMarcasEmpleado> dw_2) {
		this.dw_2 = dw_2;
	}

	/**
	 * @return the validarfechas
	 */
	public Boolean getValidarfechas() {
		return validarfechas;
	}

	/**
	 * @param validarfechas
	 *            the validarfechas to set
	 */
	public void setValidarfechas(Boolean validarfechas) {
		this.validarfechas = validarfechas;
	}

	/**
	 * @return the dwc_ConceptoAcceso
	 */
	public List<DtoDddwAsConceptoaccesoSelectPre> getDwc_ConceptoAcceso() {
		return dwc_ConceptoAcceso;
	}

	/**
	 * @param dwc_ConceptoAcceso
	 *            the dwc_ConceptoAcceso to set
	 */
	public void setDwc_ConceptoAcceso(List<DtoDddwAsConceptoaccesoSelectPre> dwc_ConceptoAcceso) {
		this.dwc_ConceptoAcceso = dwc_ConceptoAcceso;
	}

	/**
	 * @return the dwc_tipohorario
	 */
	public List<DtoDddwAsTipohorarioSelect> getDwc_tipohorario() {
		return dwc_tipohorario;
	}

	/**
	 * @param dwc_tipohorario
	 *            the dwc_tipohorario to set
	 */
	public void setDwc_tipohorario(List<DtoDddwAsTipohorarioSelect> dwc_tipohorario) {
		this.dwc_tipohorario = dwc_tipohorario;
	}

	/**
	 * @return the an_terminal
	 */
	public List<DtoDddwAsTempusTerminal> getAn_terminal() {
		return an_terminal;
	}

	/**
	 * @param an_terminal
	 *            the an_terminal to set
	 */
	public void setAn_terminal(List<DtoDddwAsTempusTerminal> an_terminal) {
		this.an_terminal = an_terminal;
	}

	/**
	 * @return the dwc_ConceptoAccesoFiltrado
	 */
	public List<DtoDddwAsConceptoaccesoSelectPre> getDwc_ConceptoAccesoFiltrado() {
		return dwc_ConceptoAccesoFiltrado;
	}

	/**
	 * @param dwc_ConceptoAccesoFiltrado
	 *            the dwc_ConceptoAccesoFiltrado to set
	 */
	public void setDwc_ConceptoAccesoFiltrado(List<DtoDddwAsConceptoaccesoSelectPre> dwc_ConceptoAccesoFiltrado) {
		this.dwc_ConceptoAccesoFiltrado = dwc_ConceptoAccesoFiltrado;
	}

	/**
	 * @return the dw_horas
	 */
	public DtoWAsAutorizacionHorasDisponibles getDw_horas() {
		return dw_horas;
	}

	/**
	 * @param dw_horas
	 *            the dw_horas to set
	 */
	public void setDw_horas(DtoWAsAutorizacionHorasDisponibles dw_horas) {
		this.dw_horas = dw_horas;
	}

	/**
	 * @return the dw_horario
	 */
	public List<DtoDwCambioHorarioExcepcion> getDw_horario() {
		return dw_horario;
	}

	/**
	 * @param dw_horario
	 *            the dw_horario to set
	 */
	public void setDw_horario(List<DtoDwCambioHorarioExcepcion> dw_horario) {
		this.dw_horario = dw_horario;
	}

	/**
	 * @return the dw_horarioregistro
	 */
	public DtoDwCambioHorarioExcepcion getDw_horarioregistro() {
		return dw_horarioregistro;
	}

	/**
	 * @param dw_horarioregistro
	 *            the dw_horarioregistro to set
	 */
	public void setDw_horarioregistro(DtoDwCambioHorarioExcepcion dw_horarioregistro) {
		this.dw_horarioregistro = dw_horarioregistro;
	}

	/**
	 * @return the lstTipoDia
	 */
	public List<DtoDddwAsTipodiaasistenciaSelect> getLstTipoDia() {
		return lstTipoDia;
	}

	/**
	 * @param lstTipoDia
	 *            the lstTipoDia to set
	 */
	public void setLstTipoDia(List<DtoDddwAsTipodiaasistenciaSelect> lstTipoDia) {
		this.lstTipoDia = lstTipoDia;
	}

	/**
	 * @return the totalhorashorario
	 */
	public BigDecimal getTotalhorashorario() {
		return totalhorashorario;
	}

	/**
	 * @param totalhorashorario
	 *            the totalhorashorario to set
	 */
	public void setTotalhorashorario(BigDecimal totalhorashorario) {
		this.totalhorashorario = totalhorashorario;
	}

	/**
	 * @return the dw_compensacion
	 */
	public List<DtoDwAsAsistenciaCompensacionEdit> getDw_compensacion() {
		return dw_compensacion;
	}

	/**
	 * @param dw_compensacion
	 *            the dw_compensacion to set
	 */
	public void setDw_compensacion(List<DtoDwAsAsistenciaCompensacionEdit> dw_compensacion) {
		this.dw_compensacion = dw_compensacion;
	}

	/**
	 * @return the ib_elimina
	 */
	public Boolean getIb_elimina() {
		return ib_elimina;
	}

	/**
	 * @param ib_elimina
	 *            the ib_elimina to set
	 */
	public void setIb_elimina(Boolean ib_elimina) {
		this.ib_elimina = ib_elimina;
	}

	/**
	 * @return the totalhorashorariodescripcion
	 */
	public String getTotalhorashorariodescripcion() {
		return totalhorashorariodescripcion;
	}

	/**
	 * @param totalhorashorariodescripcion
	 *            the totalhorashorariodescripcion to set
	 */
	public void setTotalhorashorariodescripcion(String totalhorashorariodescripcion) {
		this.totalhorashorariodescripcion = totalhorashorariodescripcion;
	}

	/**
	 * @return the totalhorastrabajo
	 */
	public BigDecimal getTotalhorastrabajo() {
		return totalhorastrabajo;
	}

	/**
	 * @param totalhorastrabajo
	 *            the totalhorastrabajo to set
	 */
	public void setTotalhorastrabajo(BigDecimal totalhorastrabajo) {
		this.totalhorastrabajo = totalhorastrabajo;
	}

	/**
	 * @return the totalhorasrefrigerio
	 */
	public BigDecimal getTotalhorasrefrigerio() {
		return totalhorasrefrigerio;
	}

	/**
	 * @param totalhorasrefrigerio
	 *            the totalhorasrefrigerio to set
	 */
	public void setTotalhorasrefrigerio(BigDecimal totalhorasrefrigerio) {
		this.totalhorasrefrigerio = totalhorasrefrigerio;
	}

	/**
	 * @return the totalhorastrabajodescripcion
	 */
	public String getTotalhorastrabajodescripcion() {
		return totalhorastrabajodescripcion;
	}

	/**
	 * @param totalhorastrabajodescripcion
	 *            the totalhorastrabajodescripcion to set
	 */
	public void setTotalhorastrabajodescripcion(String totalhorastrabajodescripcion) {
		this.totalhorastrabajodescripcion = totalhorastrabajodescripcion;
	}

	/**
	 * @return the totalhorasrefrigeriodescripcion
	 */
	public String getTotalhorasrefrigeriodescripcion() {
		return totalhorasrefrigeriodescripcion;
	}

	/**
	 * @param totalhorasrefrigeriodescripcion
	 *            the totalhorasrefrigeriodescripcion to set
	 */
	public void setTotalhorasrefrigeriodescripcion(String totalhorasrefrigeriodescripcion) {
		this.totalhorasrefrigeriodescripcion = totalhorasrefrigeriodescripcion;
	}

	/**
	 * @return the dw_eventos
	 */
	public List<DtoDwAsEventoUseridActivo> getDw_eventos() {
		return dw_eventos;
	}

	/**
	 * @param dw_eventos
	 *            the dw_eventos to set
	 */
	public void setDw_eventos(List<DtoDwAsEventoUseridActivo> dw_eventos) {
		this.dw_eventos = dw_eventos;
	}

	public List<DtoDwAsAsistenciaHextraEdit> getDw_diascompensados() {
		return dw_diascompensados;
	}

	public void setDw_diascompensados(List<DtoDwAsAsistenciaHextraEdit> dw_diascompensados) {
		this.dw_diascompensados = dw_diascompensados;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getMensajelicencia() {
		return mensajelicencia;
	}

	public void setMensajelicencia(String mensajelicencia) {
		this.mensajelicencia = mensajelicencia;
	}

	public BigDecimal getTotalsaldoactual() {
		return totalsaldoactual;
	}

	public void setTotalsaldoactual(BigDecimal totalsaldoactual) {
		this.totalsaldoactual = totalsaldoactual;
	}

	public String getTotalsaldoactualhor() {
		return totalsaldoactualhor;
	}

	public void setTotalsaldoactualhor(String totalsaldoactualhor) {
		this.totalsaldoactualhor = totalsaldoactualhor;
	}

	public List<DtoAsAutorizacion> getLicencias() {
		return licencias;
	}

	public void setLicencias(List<DtoAsAutorizacion> licencias) {
		this.licencias = licencias;
	}

	public String getHorasSumadas() {
		return horasSumadas;
	}

	public void setHorasSumadas(String horasSumadas) {
		this.horasSumadas = horasSumadas;
	}
	//
	// public BigDecimal getHorasSeleccionadas() {
	// return horasSeleccionadas;
	// }
	//
	// public void setHorasSeleccionadas(BigDecimal horasSeleccionadas) {
	// this.horasSeleccionadas = horasSeleccionadas;
	// }

	public Boolean getVerHistorialVacaciones() {
		return verHistorialVacaciones;
	}

	public void setVerHistorialVacaciones(Boolean verHistorialVacaciones) {
		this.verHistorialVacaciones = verHistorialVacaciones;
	}

	public List<PrProcesoperiodo> getLstPeriodosPlanilla() {
		return lstPeriodosPlanilla;
	}

	public void setLstPeriodosPlanilla(List<PrProcesoperiodo> lstPeriodosPlanilla) {
		this.lstPeriodosPlanilla = lstPeriodosPlanilla;
	}

	public String getDiferenciaDia() {
		return diferenciaDia;
	}

	public void setDiferenciaDia(String diferenciaDia) {
		this.diferenciaDia = diferenciaDia;
	}

	public String getDiferenciaHora() {
		return diferenciaHora;
	}

	public void setDiferenciaHora(String diferenciaHora) {
		this.diferenciaHora = diferenciaHora;
	}

	public Boolean getFlgDiaSiguiente() {
		return flgDiaSiguiente;
	}

	public void setFlgDiaSiguiente(Boolean flgDiaSiguiente) {
		this.flgDiaSiguiente = flgDiaSiguiente;
	}

	public Boolean getIscambioonceptoevento() {
		return iscambioonceptoevento;
	}

	public void setIscambioonceptoevento(Boolean iscambioonceptoevento) {
		this.iscambioonceptoevento = iscambioonceptoevento;
	}

	public boolean isBlDeclaracionjurada() {
		return blDeclaracionjurada;
	}

	public void setBlDeclaracionjurada(boolean blDeclaracionjurada) {
		this.blDeclaracionjurada = blDeclaracionjurada;
	}

	public boolean isBlVerDeclaracionjurada() {
		return blVerDeclaracionjurada;
	}

	public void setBlVerDeclaracionjurada(boolean blVerDeclaracionjurada) {
		this.blVerDeclaracionjurada = blVerDeclaracionjurada;
	}


	
}
