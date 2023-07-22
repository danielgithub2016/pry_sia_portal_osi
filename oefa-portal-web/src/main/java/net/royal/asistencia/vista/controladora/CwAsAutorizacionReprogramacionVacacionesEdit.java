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
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.core.dominio.Personamast;
import net.royal.erp.core.dominio.PersonamastPk;
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
import net.royal.seguridad.dominio.Usuario;
import net.royal.seguridad.dominio.UsuarioPk;
import pe.gob.oefa.ws.alfresco.service.UOefaAlfresco;

/*import net.royal.seguridad.correo.dominio.Correo;
 import net.royal.seguridad.correo.dominio.CorreoAdjunto;
 import net.royal.seguridad.correo.dominio.CorreoDestino;*/

@ManagedBean
@SessionScoped
public class CwAsAutorizacionReprogramacionVacacionesEdit extends CBaseBean implements UIMantenimientoController {

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

	private Date fechainiOriginal, fechafinOriginal;

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

	private Boolean verHistorialVacaciones;

	// mostrar datos de dia y hora
	private String diferenciaDia;
	private String diferenciaHora;

	/*
	 * objectstartevent
	 */
	@Override
	public String iniciarControladora() throws Exception {
		// TODO Auto-generated method stub
		verHistorialVacaciones = false;
		validarfechas = false;
		ib_elimina = false;

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

		inicializarFiltrosListado();

		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
			nuevo();
		}
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
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
			fechainiOriginal = dw_1.getFecha();
			fechafinOriginal = dw_1.getFechafin();
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

		// Es SYSADM //OEFA
		if (getFacSeguridad().getSeguridadautorizacionesServicio()
				.tieneAccesoSysAdm(getUsuarioActual().getAplicacionCodigo(), getUsuarioActual().getCodigoUsuario())) {
			opciones.setIshabilitarempleado(true);
			opciones.setIshabilitarempleadodescripcion(true);
		}

		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Delete")) {
			ib_elimina = true;
			eliminar();
		}

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

		iv_estado[0] = 1;
		iv_estado[1] = 0;

		dw_eventos = new ArrayList<DtoDwAsEventoUseridActivo>();
		List data = getFacAsistencia().getAS().getAscommonDatawindow()
				.DwAsEventoUseridActivo(getUsuarioActual().getCodigoUsuario(), iv_estado);
		if (!UValidador.esListaVacia(data)) {
			dw_eventos = data;
		}
		// Solo dejamos vacaciones
		for (int i = 0; i < dw_eventos.size(); i++) {
			DtoDwAsEventoUseridActivo obj = dw_eventos.get(i);
			if (obj.getIdevento().intValue() != 4) {
				dw_eventos.remove(i);
				i--;
			}
		}

		if (!UValidador.esListaVacia(dw_eventos)) {
			Integer indice = 0;
			for (DtoDwAsEventoUseridActivo obj : dw_eventos) {
				obj.setIndice(indice);
				indice++;
			}
		}

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
		// TODO Auto-generated method stub
		setPantallaTituloReferente("Agregar");
		dw_1.setEstado("S");
		dw_1.setEstadoai("S");

		if (CwAsAutorizacionReprogramacionVacaciones.getInstance().getFlagOrigenSolicitud().equals("A")) {
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

		return null;
	}

	@Override
	public String editar() throws Exception {
		// TODO Auto-generated method stub
		enviarCorreo = false;
		setPantallaTituloReferente("Modificar");
		diferenciaDia = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1 + "";
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
			try {
				if (!validar()) {
					return null;
				}

				if (validarfechas) {
					return null;
				}

				if (UValidador.esCero(wf_update())) {
					return null;
				}
			} catch (Exception e) {
				setMessageError("No se pudo grabar la papeleta");
				return null;
			}
		}

		if (UValidador.esNulo(enviarCorreo)) {
			enviarCorreo = false;
		}

		if (enviarCorreo) {
			enviarCorreo();
		}

		return null;

	}

	private String enviarCorreo() throws Exception {

		// REQ 03/04/2018 usuario GH en caso sea una reprogramación siempre debe
		// enviar correo.
		// if (getFacSeguridad().getSeguridadautorizacionesServicio()
		// .tieneAccesoSysAdm(getUsuarioActual().getAplicacionCodigo(),
		// getUsuarioActual().getCodigoUsuario())) {
		// return null;
		// }

		String mensaje = "";
		String rutaCompleta = null;
		String colaborador = null;
		List<CorreoDestinoCore> destinos = new ArrayList<>();
		String destinatarior1 = null;
		String destinatarior2 = null;
		String destinatarior3 = null;
		String destinatarior4 = null;
		String fechaini = null;
		String fechater = null;
		String mensajefecha = null;
		Integer diasresta = 0;
		String mensajehoras = null;
		String lugar = "";

		fechaini = UFechaHora.convertirFechaCadena(dw_1.getFecha(), "dd/MM/yyyy");
		fechater = UFechaHora.convertirFechaCadena(dw_1.getFechafin(), "dd/MM/yyyy");

		diasresta = UFechaHora.obtenerDiferenciaDias(dw_1.getFecha(), dw_1.getFechafin());

		mensajefecha = " desde el " + fechaini + " hasta el " + fechater;

		if (UValidador.esCero(diasresta)) {
			if (dw_1.getConceptoacceso().equals("OMIS")) {
				mensajehoras = ", a las " + UFechaHora.convertirFechaCadena(dw_1.getDesde1(), "HH:mm");
			} else {
				mensajehoras = ", de " + UFechaHora.convertirFechaCadena(dw_1.getDesde1(), "HH:mm") + " a "
						+ UFechaHora.convertirFechaCadena(dw_1.getHasta1(), "HH:mm");
			}

		} else {
			mensajehoras = "";
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

		// EMPLEADO
		colaborador = getFacCore().getPersonamastServicio()
				.obtenerNombrePersona(BigDecimal.valueOf(dw_1.getEmpleado()));

		// CONCEPTO
		// AsConceptoacceso obj = new AsConceptoacceso();
		// obj.getPk().setConceptoacceso(dw_1.getConceptoacceso());
		// obj = (AsConceptoacceso)
		// getFacAsistencia().getAsConceptoaccesoServicio().obtenerPorId(obj.getPk());
		// if (!UValidador.esNulo(obj)) {
		// concepto = obj.getDescripcionlocal();
		// }

		rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//solicitud_reprogramacion_vacas.html");
		LOGGER.debug(rutaCompleta);
		mensaje = UFile.obtenerContenidoFile(rutaCompleta);
		LOGGER.debug(mensaje);
		mensaje = mensaje.replace("[EMPLEADO]", UString.cambiarCaracteresEspecialesHTML(colaborador));
		mensaje = mensaje.replace("[MENSAJE_FECHA]", UString.cambiarCaracteresEspecialesHTML(mensajefecha));
		mensaje = mensaje.replace("[MENSAJE_HORA]", UString.cambiarCaracteresEspecialesHTML(mensajehoras));
		mensaje = mensaje.replace("[LUGAR]", UString.cambiarCaracteresEspecialesHTML(lugar));
		mensaje = mensaje.replace("[DIFERENCIA_DIAS]", UString.cambiarCaracteresEspecialesHTML(
				UValidador.esCero(diasresta) ? "" : " Total de Días: " + (diasresta + 1)));

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
		Date w_fecharesolucion = null;

		iv_tipoautorizacion = dw_1.getTipoautorizacion();

		w_empleado = dw_1.getEmpleado();
		w_fecha = dw_1.getFecha();
		w_fechafin = dw_1.getFechafin();
		w_desde1 = dw_1.getDesde1();
		w_hasta1 = dw_1.getHasta1();
		w_categoriaAutorizacion = dw_1.getCategoriaautorizacion();

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

			int cant = getFacAsistencia().getAsAutorizacionServicio().obtenercantidad3(w_empleado, w_fecha,
					conceptoacceso, w_desde1);

			if (cant > 0) {
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

				if (!UValidador.esNulo(objdel)) {
					w_count = getFacPlanilla().getPrVacacionesprogramadasServicio().contarVacacionesUtilizacion(
							objdel.getPk().getEmpleado().intValue(), objdel.getPk().getFecha(), objdel.getFechafin());

					if (!UValidador.esCero(w_count)) {
						setMessageError(
								"No puede Reprogramar las Vacaciones porque se encuentran ejecutada en el aplicativo de Planillas");
						return 0;
					}

				}

				objdel.setFlagreprogramado("S");
				getFacAsistencia().getAsAutorizacionServicio().actualizar(objdel);

			}

			// INSERTAR AUTORIZACION
			AsAutorizacion objins = new AsAutorizacion();
			objins.getPk().setConceptoacceso(this.conceptoacceso);
			objins.getPk().setDesde(w_desde1);
			objins.getPk().setFecha(w_fecha);
			objins.getPk().setEmpleado(BigDecimal.valueOf(w_empleado));
			objins.setFechafin(w_fechafin);
			objins.setHasta(w_hasta1);
			objins.setRefrigerio(w_refrigerio);
			objins.setPeriodo(w_periodo);
			objins.setMandatorio(w_mandatorio);
			objins.setObservacion("(Reprogramación de Vacaciones : "
					+ UFechaHora.convertirFechaCadena(fechainiOriginal, "dd/MM/yyyy") + " a "
					+ UFechaHora.convertirFechaCadena(fechafinOriginal, "dd/MM/yyyy") + ")" + w_observacion);
			objins.setSolicitadopor(w_solicitadoPor);
			objins.setFechasolicitud(w_fechaSolicitud);
			objins.setUltimoUsuario(w_ultimousuario);
			objins.setUltimaFechaModif(new Date());
			objins.setSobretiempoposicion("1");
			objins.setComportamientosobretiempo(w_comportamientoSobretiempo);
			objins.setEstado("S");
			objins.setCategoriaautorizacion(w_categoriaAutorizacion);
			objins.setTipohorario(BigDecimal.valueOf(w_TipoHorario));
			objins.setFlagcorrido(w_Corrido);
			objins.setRutadocumento(w_ruta);
			objins.setTipoautorizacion(this.iv_tipoautorizacion);
			objins.setNroresolucion(w_resolucion);
			objins.setFecharesolucion(w_fecharesolucion);
			objins.setFlagreprogramado("S");
			objins.setDesdeanterior(this.fechadesdeoriginal);
			objins.setFechaanterior(this.fechaoriginal);

			getFacAsistencia().getAsAutorizacionServicio().registrar(objins);

			// ACTUALIZAR AUTORIZACION
			// if (w_primero) {
			//
			// AsAutorizacionPk pkupd = new AsAutorizacionPk();
			// pkupd.setConceptoacceso(this.conceptoacceso);
			// pkupd.setDesde(w_desde1);
			// pkupd.setFecha(w_fecha);
			// pkupd.setEmpleado(BigDecimal.valueOf(w_empleado));
			// AsAutorizacion objupd = (AsAutorizacion)
			// getFacAsistencia().getAsAutorizacionServicio()
			// .obtenerPorId(pkupd, false);
			//
			// if (!UValidador.esNulo(objupd)) {
			//
			// objupd.setFechafin(w_fechafin);
			// objupd.setHasta(w_hasta1);
			// objupd.setRefrigerio(w_refrigerio);
			// objupd.setPeriodo(w_periodo);
			// objupd.setMandatorio(w_mandatorio);
			// objupd.setTipohorario(BigDecimal.valueOf(w_TipoHorario));
			// objupd.setObservacion(w_observacion);
			// objupd.setUltimoUsuario(w_ultimousuario);
			// objupd.setUltimaFechaModif(w_ultimafechamodif);
			// objupd.setAutorizadopor(w_autorizadopor);
			// objupd.setFechaautorizacion(w_fecha_autorizacion);
			// objupd.setRutadocumento(w_ruta);
			// objupd.setNroresolucion(w_resolucion);
			// objupd.setFecharesolucion(w_fecharesolucion);
			// objupd.setTipoautorizacion(iv_tipoautorizacion);
			//
			// getFacAsistencia().getAsAutorizacionServicio().actualizar(objupd);
			// }
			//
			// }
		}

		return 1;
	}

	private BigDecimal wf_diftiempo(Date par_fechainicio, Date par_fechafin) {
		Integer w_segundos, w_dias;

		w_segundos = UFechaHora.obtenerSegundosTranscurridos(par_fechafin, par_fechainicio);
		w_dias = UFechaHora.obtenerDiasTranscurridos(par_fechafin, par_fechainicio);

		w_segundos = w_segundos + w_dias * 3600 * 24;

		return BigDecimal.valueOf(w_segundos);
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

	@Override
	public String salir() throws Exception {
		// TODO Auto-generated method stub
		CwAsAutorizacionReprogramacionVacaciones.getInstance().buscar();
		return "wasreprogramacionvacaciones";
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
						"La Reprogramación se produce en un periodo cerrado o no existe periodo declarado para el tipo de planilla del trabajador.");
				return false;
			}

			// validamos que la reprogramacion sea la misma cantidad de dias
			int diasorigen = UFechaHora.obtenerDiasTranscurridos(fechafinOriginal, fechainiOriginal);
			int diasReprog = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha());

			if (diasorigen != diasReprog) {
				setMessageError("La Reprogramación debe tener la misma cantidad de días que el original "
						+ (diasorigen + 1) + ".");
				return false;
			}

			// validamos las licencias del empleado

			if (UValidador.esNulo(notificarlicencias())) {
				return false;
			}

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

					Date fec1 = UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), opciones.getIsmostrardesde1()
							? dw_1.getDesde1() : UFechaHora.obtenerFechaHoraFinDia(new Date()));

					Date fec2 = UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(),
							UFechaHora.obtenerFechaHoraFinDia(new Date()));

					if ((UFechaHora.obtenerFechaMasdias(new Date(), -1).after(fec1)
							&& !dw_1.getCategoriaautorizacion().equals("SOBR"))
							|| (UFechaHora.obtenerFechaMasdias(new Date(), -1).after(fec2)
									&& (dw_1.getCategoriaautorizacion().equals("SOBR")
											|| dw_1.getCategoriaautorizacion().equals("VACA")))) {

						if ("S".equals(getFacCore().getParametrosmastServicio()
								.obtenerValorCadena(new ParametrosmastPk("AS", "999999", "PROGTODMES")))) {
							if (UFechaHora.obtenerTime(dw_1.getFecha(), "dd/MM/yyyy") < UFechaHora
									.obtenerTime(UFechaHora.obtenerPrimerDiaMesFecha(new Date()), "dd/MM/yyyy")) {
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

								setMessageError(
										"No se puede realizar "
												+ (UValidador.estaVacio(w_mensaje)
														? ("una(s) " + objfind.getDescripcionlocal()) : w_mensaje)
												+ " con una fecha y hora inferior a la actual.");
								return false;
							}
						} else {
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

							setMessageError(
									"No se puede realizar "
											+ (UValidador.estaVacio(w_mensaje)
													? ("una(s) " + objfind.getDescripcionlocal()) : w_mensaje)
											+ " con una fecha y hora inferior a la actual.");
							return false;
						}

					}
				} else {
					if (objfind.getFlagtienetopediasfi().equals("S") && objfind.getFlagfechainferior().equals("S")) {
						w_count = getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(dw_1.getFechafin(),
								new Date());
						LOGGER.debug("w_count " + w_count);
						if (w_count > objfind.getCantidadtopediasfi()) {
							setMessageError("El máximo de días que puede agregar la papeleta es de "
									+ objfind.getCantidadtopediasfi() + " días para este concepto.");
							return false;
						}
					}
				}
			}
		}

		// URA 14/07/2015 valida si es viernes el cual debe incluir fin de
		// semana
		if (dw_1.getConceptoacceso().equals("VACA")) {
			if (!validarVacaciones()) {
				return false;
			}
		}

		w_tipocontrato = "";

		this.conceptoacceso = dw_1.getConceptoacceso();

		if (dw_1.getFecha().after(dw_1.getFechafin())) {
			setMessageError("La fecha FINAL NO puede ser menor que la INICIAL");
			return false;
		}

		// fechaval = UFechaHora.obtenerFechaHoraInicioDia(dw_1.getFecha());
		// dw_1.setFecha(fechaval);

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

	private boolean validarVacaciones() throws Exception {

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
		
		// Validando si existe papeleta en la misma fecha
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
			w_count = getFacAsistencia().getAsAutorizacionServicio().obtenerCantidadPapeletaFechas(
					BigDecimal.valueOf(dw_1.getEmpleado()), dw_1.getFecha(), dw_1.getFechafin(), fechainiOriginal,
					fechafinOriginal);

			if (w_count > 0) {
				setMessageError("Ya existe otra papeleta dentro de las fechas indicadas.");
				return false;
			}

		}

		BigDecimal derechoano = new BigDecimal(30);

		// No se puede reprogramar una papeleta con fecha de inicio menor al mes
		// actual
		if ("S".equals(getFacCore().getParametrosmastServicio()
				.obtenerValorCadena(new ParametrosmastPk("AS", "999999", "PROGMESACT")))) {
			if ("S".equals(getFacCore().getParametrosmastServicio()
					.obtenerValorCadena(new ParametrosmastPk("AS", "999999", "PROGTODMES")))) {
				if (UFechaHora.obtenerTime(dw_1.getFecha(), "dd/MM/yyyy") < UFechaHora
						.obtenerTime(UFechaHora.obtenerPrimerDiaMesFecha(new Date()), "dd/MM/yyyy")) {
					setMessageError("La fecha de inicio de reprogramación debe ser apartir del mes actual");
					return false;
				}
			} else {
				if (UFechaHora.obtenerTime(dw_1.getFecha(), "dd/MM/yyyy") < UFechaHora.obtenerTime(new Date(),
						"dd/MM/yyyy")) {
					setMessageError("La fecha de inicio de reprogramación debe ser mayor a la fecha actual.");
					return false;
				}
			}

		} else {
			if (dw_1.getFecha().before(new Date()) || ((dw_1.getFecha().getYear() <= new Date().getYear()
					&& dw_1.getFecha().getMonth() <= new Date().getMonth())
					|| (dw_1.getFecha().getYear() < new Date().getYear()
							&& dw_1.getFecha().getMonth() > new Date().getMonth()))) {
				setMessageError("La fecha de inicio de reprogramación debe ser posterior al mes actual.");
				return false;
			}
		}

		if (getUsuarioActual().getTipoPlanilla().equals("PR") || getUsuarioActual().getTipoPlanilla().equals("SG")) {
			derechoano = getFacCore().getParametrosmastServicio()
					.obtenerValorDecimal(new ParametrosmastPk("PR", "999999", "DIAVACPRAC"));
		}
		if (getUsuarioActual().getTipoPlanilla().equals("EC")) {
			derechoano = getFacCore().getParametrosmastServicio()
					.obtenerValorDecimal(new ParametrosmastPk("PR", "999999", "DIASVACCAS"));
		}

		if (UValidador.esCero(derechoano.compareTo(BigDecimal.ZERO))) {
			setMessageError("El Tipo de Planilla no tiene definido dias de vacaciones ("
					+ getUsuarioActual().getTipoPlanilla() + ") - Favor revisar parámetros.");
			return false;
		}

		// if (UFechaHora.obtenerFechaParte(dw_1.getFecha(), "MM") <
		// UFechaHora.obtenerFechaParte(new Date(), "MM")
		// && UFechaHora.obtenerFechaParte(dw_1.getFecha(), "YY") ==
		// UFechaHora.obtenerFechaParte(new Date(),
		// "YY")) {
		// setMessageError("El periodo vacacional debe ser posterior al mes
		// actual.");
		// return false;
		// }

		// Verificando si tiene acumulado
//		BigDecimal pendientes = BigDecimal.ZERO;
//		Integer periodo = 0;
//		Integer count = 0;
//		Integer dias = 0;
//		BigDecimal derecho = BigDecimal.ZERO;

//		List<DtoPrVacacionPeriodo> val1 = null;
//
//		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
//			val1 = getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(
//					dw_1.getEmpleado(), dw_1.getFecha(), fechainiOriginal, fechafinOriginal, "M",
//					dw_1.getConceptoacceso());
//		}
//		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
//			val1 = getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(
//					dw_1.getEmpleado(), dw_1.getFecha(), fechainiOriginal, fechafinOriginal, "N",
//					dw_1.getConceptoacceso());
//		}
//
//		if (!UValidador.esListaVacia(val1)) {
//			pendientes = val1.get(0).getPendientes();
//		}
//
//		// si editamos no se debe considerar los dias solicitados en el momento
//		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
//			// int diasactuales =
//			// UFechaHora.obtenerDiasTranscurridos(fechafinOriginal,
//			// fechainiOriginal);
//			if (UValidador.esNulo(pendientes)) {
//				pendientes = BigDecimal.ZERO;
//			}
//			// pendientes =
//			// pendientes.subtract(BigDecimal.valueOf(diasactuales));
//		}
//
		wdifdia = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1;
		int diasfds = UFechaHora.contarFinesDeSemanas(dw_1.getFecha(), dw_1.getFechafin());
//
//		if (pendientes.intValue() < wdifdia) {
//			setMessageError(
//					"No puede agregar una papeleta por Vacaciones porque los días indicados es mayor a los días pendientes.");
//			return false;
//		}

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
						setMessageError("Las vacaciones no cumplen con los días reglamentados.");
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

				ls_similares = w_CategoriaAutorizacion;
				ls_similares_2_all = "S";

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

				ld_temporal = UFechaHora.obtenerFechaHoraInicioDia(UFechaHora.obtenerFechaMasdias(ld_temporal, 1));

			}
		}

		return validarPosNuevaSolicitud();

	}

	public String nuevaSolicitud() throws Exception {
		dw_1.setEstado("S");
		if (validarPosNuevaSolicitud()) {
			wf_update();
			CwAsAutorizacionReprogramacionVacaciones.getInstance().buscar();
		} else {
			// en ocaciones antes de grabar muestra la ventana de intervalos.
			return null;
		}

		if (UValidador.esNulo(enviarCorreo)) {
			enviarCorreo = false;
		}

		if (!UValidador.estaVacio(CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from())) {
			if (dw_1.getEstado().equals("S")
					&& (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")
							|| enviarCorreo)) {
				enviarCorreo();
			}
		}

		// getWebControlContext().ejecutar("PF('popNuevaSolicitud').hide();");

		return "wasreprogramacionvacaciones";
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

			// se selecciona un registro
			// if (!UValidador.esNulo(indiceseleccionauno) && w_seleccionados ==
			// 1) {
			// if (w_diftiempo.compareTo(dw_diascompensados.get(
			// indiceseleccionauno).getDiferencia()) == 1) {
			// setMessageError("Las Horas a compensar no puede ser mayor al
			// registro seleccionado.");
			// return false;
			// }
			// }

			// URA 19/05/2015 validando si no se esta repitiendo la misma fecha

			// String fecha = UFechaHora.convertirFechaCadena(dw_1.getFecha(),
			// "yyyyMMdd");
			Date fechahora = UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), dw_1.getDesde1());
			Integer existe = getFacAsistencia().getAsAutorizacionfechaServicio()
					.obtenercantidadAutorizacionFecha(dw_1.getEmpleado(), fechahora);

			if (existe > 0) {
				setMessageError("Ya existe una compensación con la fecha ingresada.");
				return false;
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
				if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")
						|| enviarCorreo) {
					enviarCorreo();
				}

				// if (!UValidador.esNulo(notificarlicencias())) {
				// if
				// (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()
				// .equalsIgnoreCase("Delete")) {
				// setMessageSuccess("Se registró la Reprogramación
				// correctamente", true);
				// }
				// CwAsAutorizacionReprogramacionVacaciones.getInstance().buscar();
				// return "wasreprogramacionvacaciones";
				// } else {
				// // si se muestra el mensaje de licencia ocultamos este popup
				// // de
				// // intervalos
				//

				// CwAsAutorizacionReprogramacionVacaciones.getInstance().buscar();
				getWebControlContext().ejecutar("PF('popIntervalosAutorizacion').hide()");
				getWebControlContext().ejecutar("PF('popMensajeConsideracion').show()");
				// return "wasreprogramacionvacaciones";
				// }
			}
		}

		return null;

	}

	public String listarReprogramaciones() throws Exception {
		CwAsAutorizacionReprogramacionVacaciones.getInstance().buscar();
		getWebControlContext().ejecutar("PF('popMensajeConsideracion').hide()");
		return "wasreprogramacionvacaciones";

	}

	private String notificarlicencias() throws Exception {
		// TODO Auto-generated method stub
		// SI ES UNA LICENCIA SIN GOZE MOSTRAMO EL MENSAJE
		if (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Delete")) {

			Integer cantlicencias = getFacAsistencia().getAsAutorizacionServicio().contarLicencias(dw_1.getEmpleado(),
					dw_1.getFecha(), dw_1.getFechafin());

			if (cantlicencias > 0) {
				mensajelicencia = "El Empleado se encuentra de Licencia en las fechas indicadas.";
				setMessageError(mensajelicencia);
				return null;
			}
		}

		return "wasreprogramacionvacaciones";

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

					dw_1.setUuidalfresco(obj.getUuidalfresco());
					dw_1.setTienearchivo(false);
					dw_1.setTipoautorizacion(obj.getTipoautorizacion());
					dw_1.setRechazadopor(obj.getRechazadopor());
					dw_1.setFecharechazo(obj.getFecharechazo());

					dw_1.setSolicitadopornombre(obtenerNombreUsuario(dw_1.getSolicitadopor()));
					dw_1.setAutorizadopornombre(obtenerNombreUsuario(dw_1.getAutorizadopor()));
					dw_1.setRechazadopornombre(obtenerNombreUsuario(dw_1.getRechazadopor()));
					dw_1.setUltimousuarionombre(obtenerNombreUsuario(dw_1.getUltimousuario()));

					if (!UValidador.estaVacio(dw_1.getRutadocumento())) {
						dw_1.setTienearchivo(true);
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

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarEmpleado")) {

			DtoDwAsEmpleadoSelectMultiple dtoEmpleado = (DtoDwAsEmpleadoSelectMultiple) mensajeControllerGenerico
					.getParametros().get("empleado");

			if (dtoEmpleado.getEstadoempleado().equals(1)) {
				setMessageError("El empleado esta cesado o no existe.");
				return null;
			}

			cargarInfoEmpleado(dtoEmpleado.getPersona().intValue(), dtoEmpleado.getNombrecompleto());

			if (!UValidador.estaVacio(dw_1.getCategoriaautorizacion())) {
				cargarEvento(dw_1.getCategoriaautorizacion());
				cargarConceptoAcceso(dw_1.getConceptoacceso());
			}

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("cargarDocumento")) {
			DtoDwWhDocumentoarchivoList documento = (DtoDwWhDocumentoarchivoList) mensajeControllerGenerico
					.getParametros().get("documento");

			dw_1.setRutadocumento(documento.getArchivo());
			dw_1.setRutacompleta(documento.getRuta());
			// dw_1.setArchivodata(documento.getArchivodata());

			opciones.setIsmostrarver(true);
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

		if (dw_1.getDesde1().before(UFechaHora.obtenerFechaCompuesta(dw_1.getDesde1(), horaini))
				&& dw_1.getHasta1().after(UFechaHora.obtenerFechaCompuesta(dw_1.getHasta1(), horafin))) {
			difref = wf_diftiempo(horaini, horafin).divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_DOWN);
		} else if (dw_1.getDesde1().before(UFechaHora.obtenerFechaCompuesta(dw_1.getDesde1(), horaini))
				&& dw_1.getHasta1().after(UFechaHora.obtenerFechaCompuesta(dw_1.getHasta1(), horaini))) {
			difref = wf_diftiempo(UFechaHora.obtenerFechaCompuesta(dw_1.getHasta1(), horaini), dw_1.getHasta1())
					.divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_DOWN);
		} else if (dw_1.getDesde1().before(UFechaHora.obtenerFechaCompuesta(dw_1.getDesde1(), horafin))
				&& dw_1.getHasta1().after(UFechaHora.obtenerFechaCompuesta(dw_1.getHasta1(), horafin))) {
			difref = wf_diftiempo(dw_1.getDesde1(), UFechaHora.obtenerFechaCompuesta(dw_1.getDesde1(), horafin))
					.divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_DOWN);
		}

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

	public static CwAsAutorizacionReprogramacionVacacionesEdit getInstance() {
		return UFaces.evaluateExpressionGet("#{cwAsAutorizacionReprogramacionVacacionesEdit}",
				CwAsAutorizacionReprogramacionVacacionesEdit.class);
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
			cargarConceptoAcceso(conceptoSeleccionado);
		}

	}

	public void valueChangeEventEvento(ValueChangeEvent event) throws Exception {

		String idevento = (String) event.getNewValue();
		dw_1.setCategoriaautorizacion(idevento);
		cargarEvento(idevento);

	}

	// categoria autorizacion
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
		}

		if (idevento.equals("SOBR")) {
			dw_1.setConceptoacceso("PAHE");
			opciones.setIsmostrardwhoras(false);
			opciones.setIsmostrardwcompensacion(false);
			opciones.setIsmostrarsttitulo(false);
			// opciones.setIshabilitardesde1(false); // REQ: 6
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

	}

	public void valuechangedConceptoAcceso(ValueChangeEvent event) throws Exception {
		if (UValidador.esNulo(event.getNewValue())) {
			return;
		}
		iscambioonceptoevento = true;
		conceptoSeleccionado = (String) event.getNewValue();
		cargarConceptoAcceso(conceptoSeleccionado);
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
			}
		}

		if (!UValidador.esNulo(ll_find)) {
			if (dwc_ConceptoAccesoFiltrado.get(ll_find).getFlagarchivo().equals("S")) {
				opciones.setIsmostrarseleccionar(true);
				opciones.setIsmostrarrutadocumento(true);

				if (!UValidador.estaVacio(dw_1.getRutadocumento())) {
					opciones.setIsmostrarver(true);
				}

				opciones.setIsmostrartarchivo(true);
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

		dw_1.setFechafin(fecha);

		wf_poner_fecha_fin();

		diferenciaDia = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1 + "";

	}

	public void valuechangeFechaFin(SelectEvent event) throws Exception {

		if (UValidador.esNulo(event)) {
			return;
		}

		Date fecha = (Date) event.getObject();
		dw_1.setFechafin(UFechaHora.obtenerFechaHoraFinDia(fecha));

		eliminarHorariosFueraRango(2);

		dw_1.setFechafin(fecha);

		wf_poner_fecha_fin();

		diferenciaDia = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1 + "";

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

		opciones.setIsmostrardesde1(true);
		opciones.setIsmostrarhasta1(true);
		if (tipo.equals("D")) {
			opciones.setIsmostrardesde1(true);
			opciones.setIsmostrarhasta1(true);
		}
	}

	public void keyfechainicio() throws Exception {

		dw_1.setFechafin(dw_1.getFecha());

		eliminarHorariosFueraRango(1);

		wf_poner_fecha_fin();

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
		eliminarHorariosFueraRango(2);

		wf_poner_fecha_fin();

		diferenciaDia = UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(), dw_1.getFecha()) + 1 + "";

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
				|| dw_1.getCategoriaautorizacion().equals("VACA") || dw_1.getCategoriaautorizacion().equals("SOBR")) {
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

						iscambioonceptoevento = false;
					} else {
						opciones.setIsmostrartextohora1(true);
						opciones.setIsmostrartextohora2(true);
						opciones.setIsmostrartde(true);
						opciones.setIsmostrarta(true);
						opciones.setIsmostrardesde1(true);
						opciones.setIsmostrarhasta1(true);
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

	public String verDocumento() throws Exception {

		String archivo = dw_1.getRutadocumento();
		if (!UValidador.esNulo(dw_1.getUuidalfresco())) {
			switch (obtenerParametroModoArchivo()) {
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

				if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
					this.setMessageError("No se encontraron los parametros key o ws");
					return null;
				}

				try {
					ContenidoECMBean respuestaconsulta = UOefaAlfresco.obtenerDocumento(dw_1.getUuidalfresco(), key);
					LOGGER.debug(respuestaconsulta);
					if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
						LOGGER.debug("Se encontro el archivo");
						new UFile().cargarArchivoXByte(respuestaconsulta.getContenidoFile(), archivo, "temporaloefa");
						System.gc();
					}
				} catch (Exception e) {
					LOGGER.debug(e.getMessage());
					this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
					return null;
				}
			}
		} else {
			if (!UValidador.esNulo(dw_1.getRutadocumento())) {
				// new UFile().cargarArchivoXByte(UFile
				// .obtenerArregloByte(dw_1
				// .getRutadocumento()), archivo, "temporaloefa");
			} else {
				setMessageError("No ha seleccionado ningún archivo");
				return null;
			}
		}

		setSessionValue("nombrearchivo", archivo);

		return "documentos";
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
			setMessageSuccess("Se registró la Reprogramación correctamente", true);
		}
		CwAsAutorizacionReprogramacionVacaciones.getInstance().buscar();
		return "wasreprogramacionvacaciones";
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

}
