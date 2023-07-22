// 
// Decompiled by Procyon v0.5.36
// 

package net.royal.asistencia.vista.controladora;

import net.royal.erp.core.dominio.PersonamastPk;
import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import org.primefaces.event.SelectEvent;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepciondetalle;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepciondetallePk;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcion;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcionPk;
import net.royal.erp.asistencia.dominio.dto.DtoCargoSIGED;
import net.royal.erp.asistencia.dominio.dto.DtoAreaSIGED;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.http.HttpEntity;
import java.util.Collections;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UConstante;
import net.royal.erp.asistencia.dominio.dto.DtoAdministrativoSIGED;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.JsonParseException;
import javax.faces.event.ValueChangeEvent;
import net.royal.framework.web.core.UFaces;
import net.royal.erp.sistema.dominio.dto.DtoDwWhDocumentoarchivoList;
import java.util.Collection;
import java.io.File;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAutorizacionPreprocesoHextra;
import java.util.Map;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import java.util.HashMap;
import net.royal.erp.asistencia.dominio.AsCarnetidentificacion;
import net.royal.seguridad.dominio.UsuarioPk;
import net.royal.seguridad.dominio.Usuario;
import net.royal.seguridad.dominio.Seguridadperfilusuario;
import net.royal.erp.core.dominio.EmpleadomastPk;
import net.royal.erp.asistencia.dominio.dto.DtoAsTipodiamovimiento;
import net.royal.erp.asistencia.dominio.dto.DtoAsConceptoacceso;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAutorizacionPreprocesoTipodia;
import net.royal.erp.planilla.dominio.dto.DtoPrVacacionesprogramadas;
import net.royal.erp.planilla.dominio.dto.DtoPrVacacionPeriodo;
import net.royal.erp.core.dominio.Personamast;
import java.math.RoundingMode;
import net.royal.erp.asistencia.dominio.AsConceptoaccesoPk;
import net.royal.alfresco.ws.RptaWsBean;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcionsolicitud;
import net.royal.alfresco.ws.ContenidoECMBean;
import pe.gob.oefa.ws.alfresco.service.UOefaAlfresco;
import net.royal.erp.asistencia.asoracle.dominio.dto.DtoDwAsEmpleadoSelectMultiple;
import net.royal.erp.asistencia.dominio.AsDetallesigedPk;
import net.royal.erp.asistencia.dominio.AsDetallesiged;
import net.royal.erp.asistencia.dominio.dto.DtoPermisosEnCompensacion;
import net.royal.erp.asistencia.dominio.AsAutorizacionfecha;
import net.royal.erp.planilla.dominio.PrVacacionesprogramadas;
import net.royal.erp.asistencia.dominio.AsAutorizacionPk;
import net.royal.erp.asistencia.dominio.AsAutorizacion;
import java.text.SimpleDateFormat;
import net.royal.erp.asistencia.dominio.AsArea;
import net.royal.framework.correo.dominio.CorreoCore;
import net.royal.framework.web.core.UString;
import net.royal.framework.web.core.UFile;
import net.royal.erp.asistencia.dominio.AsConceptoacceso;
import java.io.Serializable;
import net.royal.framework.correo.dominio.CorreoDestinoCore;
import net.royal.erp.asistencia.dominio.AsEvento;
import java.util.Iterator;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.framework.web.core.UFechaHora;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.framework.web.core.UValidador;
import net.royal.comun.vista.controladora.CComunSession;
import java.util.ArrayList;
import net.royal.erp.asistencia.dominio.dto.DtoBandejaSIGED;
import net.royal.erp.asistencia.dominio.dto.DtoEmpleadoSIGED;
import net.royal.erp.asistencia.dominio.dto.DtoPerfilSIGED;
import net.royal.erp.asistencia.dominio.dto.DtoCargoDetalleSIGED;
import net.royal.erp.asistencia.dominio.dto.DtoAreaDetalleSIGED;
import net.royal.erp.asistencia.dominio.dto.DtoTablaNuevaBandeja;
import net.royal.erp.planilla.dominio.PrProcesoperiodo;
import net.royal.erp.asistencia.dominio.dto.DtoAsAutorizacion;
import net.royal.erp.asistencia.ascommon.dominio.dto.DtoDwAsEventoUseridActivo;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDddwAsTipodiaasistenciaSelect;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwCambioHorarioExcepcion;
import net.royal.erp.asistencia.ascommon.dominio.dto.DtoWAsAutorizacionHorasDisponibles;
import java.math.BigDecimal;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAsistenciaHextraEdit;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAsistenciaCompensacionEdit;
import net.royal.erp.asistencia.asoracle.dominio.dto.DtoDddwAsTipohorarioSelect;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDddwAsConceptoaccesoSelectPre;
import net.royal.asistencia.vista.opciones.OwAsAutorizacionPreprocesoHextraEdit;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAutorizacionPreprocesoOrdenes;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDddwAsTempusTerminal;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwMaPrCalendarioferiadosProcesoSarg;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsMarcasEmpleado;
import net.royal.erp.asistencia.asoracle.dominio.dto.DtoDwFiltroTerminal;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDddwAsEmpleadosmastSelectCarnets;
import java.util.List;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAutorizacionPreprocesoHextraeditV2;
import java.util.Date;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.comun.vista.controladora.CBaseBean;

@ManagedBean
@SessionScoped
public class CwAsAutorizacionPreprocesoHextraEditSIGED extends CBaseBean implements UIMantenimientoController
{
    private static long serialVersionUID = 1L;
    private String conceptoacceso;
    private String conceptoaccesooriginal;
    private Integer empleado;
    private Date fecha;
    private Date fechaoriginal;
    private Date fechadesdeoriginal;
    private String conceptoOmisionMarcado;
    private String conceptoCambioHorario;
    private String conceptoPermanenciaMotivoPersonal;
    private String conceptoAutorizacionSobretiempo;
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
    private String flgAllEmpleado;
    private Boolean validarfechas;
    Date fechaval;
    String w_CategoriaAutorizacion;
    int ll_terminal;
    Boolean ib_esferiado;
    Integer filaencontrada;
    String fechaparaferiado;
    Date fechafin;
    String ls_desde1;
    String ls_hasta1;
    Date hasta;
    Integer empleadoval;
    Integer count;
    String conceptoaccesoval;
    Date desde;
    Date ldt_tempd;
    Date ldt_temph;
    long ll_d_1;
    long ll_h_1;
    long ll_d_2;
    long ll_h_2;
    Integer ll_val_01;
    Integer ll_val_02;
    Date ld_temporal;
    Date tl_desde;
    Date tl_hasta;
    String ls_EXPRESADOEN;
    Date ldt_horainicio;
    Date ldt_horafin;
    Integer w_tipodia;
    String ls_INTERVALOACCESO;
    Date ldt_desde_horario;
    Date ldt_hasta_horario;
    Date ldt_desde_ingreso;
    Date ldt_hasta_ingreso;
    String ls_FlagDiaAnt;
    Integer w_fila;
    String w_intervaloacceso;
    Date ld_hora_entrada_t1;
    Date ld_hora_salida_t1;
    String ls_similares;
    String ls_similares_2;
    String ls_similares_3;
    String ls_similares_2_all;
    String ls_similares_4;
    String ls_similares_5;
    String ls_similares_6;
    String ls_similares_7;
    String ls_similares_8;
    Date fechafin2;
    Integer CampoHorasVisible;
    String Estado;
    Integer fila;
    Integer filas;
    Integer year;
    Integer veces;
    Date fechalicencia;
    Date ldt_fecha_hora_salida;
    Date ld_hora_salida_t;
    String w_mensaje;
    Integer ll_find;
    private String w_tipocontrato;
    private Integer ll_horasprac;
    private Date w_horainicio;
    private Date w_horafin;
    private BigDecimal w_diftiempo;
    private BigDecimal w_ttotal;
    private Integer w_count;
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
    private List<DtoAsAutorizacion> licencias;
    private Boolean iscambioonceptoevento;
    private Date fechainiOriginal;
    private Date fechafinOriginal;
    private List<PrProcesoperiodo> lstPeriodosPlanilla;
    private String diferenciaDia;
    private String diferenciaHora;
    private Date desdeGlobal;
    private Date hastaGlobal;
    private boolean blDeclaracionjurada;
    private boolean blVerDeclaracionjurada;
    private Date fechaRecuperacionIni;
    private Date fechaRecuperacionFin;
    private BigDecimal diascompensa;
    private Integer idEmpleadoTemporal;
    private String empleadoTemporalNombre;
    private DtoTablaNuevaBandeja nuevaBandeja;
    private Boolean verDatosactivacionTemporal;
    private String usuarioRed;
    private Boolean verAsignacionFuncion;
    private Boolean verAsignacionRol;
    private Boolean verAsignacionRolJefe;
    private Boolean verAsignacionRolAsistente;
    private Boolean verNuevaBandeja;
    private Boolean verActivacionTemporal;
    private Boolean verConfigurarPerfil;
    private List<DtoAreaDetalleSIGED> listaAreasSIGED;
    private List<DtoCargoDetalleSIGED> listaCargosSIGED;
    private List<DtoPerfilSIGED> listaPerfilesSIGED;
    private String cargoUsuarioSeleccionado;
    private String estadoEmpleado;
    private DtoEmpleadoSIGED empleadoNuevaBandeja;
    private DtoEmpleadoSIGED empleadoAsistenteArea;
    private DtoEmpleadoSIGED empleadoJefeArea;
    private Boolean mostarEtiquetaCesado;
    private Boolean puedeEditarPermisosSIGED;
    private Boolean verFechas;
    private String infoLicenciaVacaciones;
    private Integer periodomax;
    private BigDecimal empleadoSeleccion;
    private BigDecimal empleadoSeleccionPerm;
    private BigDecimal idCargoSiged;
    private BigDecimal idCargoSiged2;
    private List<DtoBandejaSIGED> cargosSiged;
    private BigDecimal idAreaSigedaux;
    private BigDecimal idCargoSigedaux;
    private String cargoaaSel;
    private String cargojaSel;
    private String cargoaaPermSel;
    
    public CwAsAutorizacionPreprocesoHextraEditSIGED() {
        this.filaencontrada = -1;
        this.ls_EXPRESADOEN = null;
        this.ldt_horainicio = null;
        this.ldt_horafin = null;
        this.ls_INTERVALOACCESO = null;
        this.ldt_hasta_ingreso = null;
        this.ls_FlagDiaAnt = "";
        this.ls_similares_2 = null;
        this.ls_similares_3 = null;
        this.ls_similares_2_all = null;
        this.ls_similares_4 = null;
        this.ls_similares_5 = null;
        this.ls_similares_6 = null;
        this.ls_similares_7 = null;
        this.ls_similares_8 = null;
        this.veces = null;
        this.fechalicencia = null;
    }
    
    public String iniciarControladora() throws Exception {
        this.validarfechas = false;
        this.ib_elimina = false;
        this.verHistorialVacaciones = false;
        this.flgDiaSiguiente = false;
        this.flgAllEmpleado = "N";
        this.verAsignacionFuncion = false;
        this.verAsignacionRol = false;
        this.verAsignacionRolJefe = false;
        this.verAsignacionRolAsistente = false;
        this.verNuevaBandeja = false;
        this.verActivacionTemporal = false;
        this.verConfigurarPerfil = false;
        this.verDatosactivacionTemporal = false;
        this.idEmpleadoTemporal = null;
        this.empleadoTemporalNombre = null;
        this.puedeEditarPermisosSIGED = false;
        this.verFechas = true;
        this.dw_diascompensados = new ArrayList<DtoDwAsAsistenciaHextraEdit>();
        this.nuevaBandeja = new DtoTablaNuevaBandeja();
        this.empleadoJefeArea = new DtoEmpleadoSIGED();
        this.empleadoAsistenteArea = new DtoEmpleadoSIGED();
        this.accion = CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from();
        if (UValidador.esNulo((Object)this.dw_1)) {
            this.dw_1 = new DtoDwAsAutorizacionPreprocesoHextraeditV2();
        }
        this.dw_filtraterminal = new DtoDwFiltroTerminal();
        this.dw_horario = new ArrayList<DtoDwCambioHorarioExcepcion>();
        this.dw_horarioregistro = new DtoDwCambioHorarioExcepcion();
        this.dwc_ConceptoAcceso = new ArrayList<DtoDddwAsConceptoaccesoSelectPre>();
        this.dwc_ConceptoAccesoFiltrado = new ArrayList<DtoDddwAsConceptoaccesoSelectPre>();
        (this.opciones = new OwAsAutorizacionPreprocesoHextraEdit(Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false))).setIshabilitarlugar(Boolean.valueOf(true));
        this.opciones.setIsmostrarDesdeRecupera(Boolean.valueOf(false));
        this.opciones.setIsmostrarHastaRecupera(Boolean.valueOf(false));
        this.opciones.setIsmostrarPeriodoPlanilla(Boolean.valueOf(false));
        this.opciones.setIsmostrarAutorizaRecupera(Boolean.valueOf(false));
        this.inicializarFiltrosListado();
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
            this.fechainiOriginal = null;
            this.fechafinOriginal = null;
            this.nuevo();
        }
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
            this.fechainiOriginal = this.dw_1.getFecha();
            this.fechafinOriginal = this.dw_1.getFechafin();
            this.editar();
        }
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Browse")) {
            this.opciones.setIshabilitarok(Boolean.valueOf(false));
            this.opciones.setIshabilitarconcepto(Boolean.valueOf(false));
            this.opciones.setIshabilitarfecha(Boolean.valueOf(false));
            this.opciones.setIshabilitarfechafin(Boolean.valueOf(false));
            this.opciones.setIshabilitardesde1(Boolean.valueOf(false));
            this.opciones.setIshabilitarhasta1(Boolean.valueOf(false));
            this.opciones.setIshabilitarobservaciones(Boolean.valueOf(false));
            this.opciones.setIshabilitarnroresolucion(Boolean.valueOf(false));
            this.opciones.setIshabilitarverarchivo(Boolean.valueOf(false));
            this.opciones.setIsmostrarcbinsertar(Boolean.valueOf(false));
            this.opciones.setIsmostrarcbeliminar(Boolean.valueOf(false));
            this.opciones.setIshabilitarlugar(Boolean.valueOf(false));
            this.editar();
            this.setPantallaTituloReferente("Ver");
        }
        if (!UValidador.esNulo((Object)this.dw_1)) {
            this.fechaoriginal = this.dw_1.getFecha();
            this.fechadesdeoriginal = this.dw_1.getDesde1();
            this.conceptoaccesooriginal = this.dw_1.getConceptoacceso();
            this.conceptoOmisionMarcado = this.getFacCore().getParametrosmastServicio().obtenerValorCadena(new ParametrosmastPk("AS", "999999", "CONCOMIMAR"));
            this.conceptoCambioHorario = this.getFacCore().getParametrosmastServicio().obtenerValorCadena(new ParametrosmastPk("AS", "999999", "CONCCAMHOR"));
            this.conceptoPermanenciaMotivoPersonal = this.getFacCore().getParametrosmastServicio().obtenerValorCadena(new ParametrosmastPk("AS", "999999", "CONPERMPMP"));
            this.conceptoAutorizacionSobretiempo = this.getFacCore().getParametrosmastServicio().obtenerValorCadena(new ParametrosmastPk("AS", "999999", "CONCAUTSOB"));
            this.dw_filtraterminal.setAllterminal("N");
            this.opciones.setIshabilitarterminal(Boolean.valueOf(true));
            if (this.getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(this.getUsuarioActual().getAplicacionCodigo(), this.getUsuarioActual().getCodigoUsuario())) {
                this.opciones.setIshabilitarempleado(Boolean.valueOf(true));
                this.opciones.setIshabilitarempleadodescripcion(Boolean.valueOf(true));
            }
            if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update") && (this.dw_1.getEstado().equals("A") || this.dw_1.getEstado().equals("P"))) {
                this.opciones.setIshabilitarcb1(Boolean.valueOf(false));
                this.opciones.setIshabilitardweventos(Boolean.valueOf(false));
                this.opciones.setIshabilitardesde1(Boolean.valueOf(false));
                this.opciones.setIshabilitarhasta1(Boolean.valueOf(false));
                this.opciones.setIshabilitarcomportamiento(Boolean.valueOf(false));
                this.opciones.setIshabilitarfecha(Boolean.valueOf(false));
                this.opciones.setIshabilitarfechafin(Boolean.valueOf(false));
                this.opciones.setIshabilitarobservaciones(Boolean.valueOf(false));
                this.opciones.setIshabilitarconcepto(Boolean.valueOf(false));
            }
            if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
                this.opciones.setIshabilitarcb1(Boolean.valueOf(false));
                this.opciones.setIshabilitarempleado(Boolean.valueOf(true));
                if ((this.dw_1.getFecha().before(new Date()) && this.dw_1.getEstado().equals("S")) || this.dw_1.getEstado().equals("R")) {
                    this.ib_elimina = false;
                }
                if (this.dw_1.getConceptoacceso().equals("CHOR")) {
                    this.opciones.setIshabilitarfechafin(Boolean.valueOf(false));
                }
                if (this.dw_1.getConceptoacceso().equals("02")) {
                    this.opciones.setIshabilitarfechafin(Boolean.valueOf(true));
                }
                if (this.getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(this.getUsuarioActual().getAplicacionCodigo(), this.getUsuarioActual().getCodigoUsuario()) || !UFechaHora.obtenerFechaHoraInicioDiaDate(this.dw_1.getFecha()).before(UFechaHora.obtenerFechaHoraInicioDiaDate(new Date()))) {
                    this.opciones.setIshabilitarfecha(Boolean.valueOf(true));
                    this.opciones.setIshabilitarfechafin(Boolean.valueOf(true));
                }
                if (this.dw_1.getEstado().equals("A")) {
                    this.opciones.setIshabilitarfecha(Boolean.valueOf(false));
                    this.opciones.setIshabilitarfechafin(Boolean.valueOf(false));
                }
            }
            if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
                if (!UValidador.esListaVacia((List)this.dw_detail)) {
                    this.dw_detail.remove(0);
                }
                this.opciones.setIsmostrardwhorario(Boolean.valueOf(false));
            }
            if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Delete")) {
                this.ib_elimina = true;
                this.eliminar();
            }
            if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
                this.usuarioRed = this.getUsuarioActual().getCodigoUsuario();
                DtoTablaNuevaBandeja nuevaBandeja = this.getFacCore().getPersonamastServicio().obtenerDatosParaNuevaBandeja(this.usuarioRed);
                this.cargoUsuarioSeleccionado = nuevaBandeja.getEsJefe();
                this.estadoEmpleado = nuevaBandeja.getEstadoempleado();
                this.empleadoNuevaBandeja = this.obtenerBandejasPorEmpleado(this.getUsuarioActual().getCodigoUsuario(), true);
            }
            else {
                Empleadomast empleado = this.getFacCore().getEmpleadomastServicio().obtenerEmpleadoMast(this.dw_1.getEmpleado());
                this.usuarioRed = empleado.getCodigousuario();
                DtoTablaNuevaBandeja nuevaBandeja2 = this.getFacCore().getPersonamastServicio().obtenerDatosParaNuevaBandeja(this.usuarioRed);
                this.cargoUsuarioSeleccionado = nuevaBandeja2.getEsJefe();
                this.estadoEmpleado = nuevaBandeja2.getEstadoempleado();
                this.empleadoNuevaBandeja = this.obtenerBandejasPorEmpleado(empleado.getCodigousuario(), true);
            }
            if (!this.estadoEmpleado.equals("0")) {
                this.mostarEtiquetaCesado = true;
            }
            else {
                this.mostarEtiquetaCesado = false;
            }
            this.cargarEventos();
            if (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add") && this.dw_1.getCategoriaautorizacion().equals("COMP")) {
                List data = this.getFacAsistencia().getAS().getAsmainDatawindow().DwAsAsistenciaHextraEditModif(this.dw_1.getEmpleado(), this.dw_1.getFecha());
                this.dw_diascompensados = (List<DtoDwAsAsistenciaHextraEdit>)data;
                if (!UValidador.esListaVacia((List)this.dw_diascompensados)) {
                    for (DtoDwAsAsistenciaHextraEdit objmod : this.dw_diascompensados) {
                        objmod.setCantidadhor(this.obtenerHorasAcumuladas(objmod.getCantidadreal()));
                        objmod.setCompensadohor(this.obtenerHorasAcumuladas(objmod.getCantidad()));
                        objmod.setDiferenciahor(this.obtenerHorasAcumuladas(objmod.getDiferencia()));
                        if (objmod.getSeleccion().equals("S")) {
                            objmod.setIsseleccionado(Boolean.valueOf(true));
                        }
                    }
                }
                this.opciones.setIsmostrardiascompensados(Boolean.valueOf(true));
            }
            if (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
                Boolean existe = false;
                if (!UValidador.esListaVacia((List)this.dw_eventos)) {
                    for (DtoDwAsEventoUseridActivo obj : this.dw_eventos) {
                        if (obj.getConceptoacceso().equals(this.dw_1.getCategoriaautorizacion())) {
                            existe = true;
                            if ("OMI2".equals(this.dw_1.getConceptoacceso())) {
                                obj.setNombrelargo("Marcaci\u00f3n por Aplicativo");
                                break;
                            }
                            break;
                        }
                    }
                }
                if (!existe) {
                    AsEvento objne = this.getFacAsistencia().getAsEventoServicio().listarPorConceptoAcceso(this.dw_1.getCategoriaautorizacion());
                    if (!UValidador.esNulo((Object)objne)) {
                        DtoDwAsEventoUseridActivo nuevo = new DtoDwAsEventoUseridActivo();
                        nuevo.setConceptoacceso(objne.getConceptoacceso());
                        nuevo.setIdevento(BigDecimal.valueOf(objne.getPk().getIdevento()));
                        nuevo.setOrden(BigDecimal.valueOf(objne.getOrden()));
                        nuevo.setNombrelargo(objne.getNombreLargo());
                        nuevo.setEstado(objne.getEstado());
                        this.dw_eventos.add(0, nuevo);
                        this.opciones.setIshabilitardweventos(Boolean.valueOf(false));
                    }
                }
            }
            this.dw_2 = new ArrayList<DtoDwAsMarcasEmpleado>();
            return null;
        }
        return null;
    }
    
    private Integer obtenerPeriodoVacaMax(Integer empleado) {
        Integer periodo = this.getFacAsistencia().getAsAutorizacionServicio().contarmaximoperiodovacaciones(empleado);
        return periodo;
    }
    
    private void cargarEventos() {
        Integer[] iv_estado = { 1, 0 };
        this.dw_eventos = new ArrayList<DtoDwAsEventoUseridActivo>();
        List data = this.getFacAsistencia().getAS().getAscommonDatawindow().DwAsEventoUseridActivoSIGED(this.getUsuarioActual().getCodigoUsuario(), iv_estado);
        if (!UValidador.esListaVacia(data)) {
            this.dw_eventos = (List<DtoDwAsEventoUseridActivo>)data;
        }
        if (!UValidador.esListaVacia((List)this.dw_eventos)) {
            Integer indice = 0;
            for (DtoDwAsEventoUseridActivo obj : this.dw_eventos) {
                obj.setIndice(indice);
                ++indice;
            }
        }
    }
    
    public String buscar() throws Exception {
        return null;
    }
    
    public String nuevo() throws Exception {
        this.enviarCorreo = false;
        this.blDeclaracionjurada = false;
        this.setPantallaTituloReferente("Agregar");
        this.dw_1.setEstado("S");
        this.dw_1.setEstadoai("S");
        if (CwAsAutorizacionPreprocesoAprobacionSIGED.getInstance().getFlagOrigenSolicitud().equals("A")) {
            this.dw_1.setEstado("A");
            this.dw_1.setEstadoai("A");
        }
        this.dw_1.setRefrigerio("S");
        this.dw_1.setMandatario("N");
        this.dw_1.setComportamientosobretiempo("C");
        this.dw_1.setSolicitadopor(this.getUsuarioActual().getLoginUsuario().toUpperCase());
        this.dw_1.setSolicitadopornombre(this.obtenerNombreUsuario(this.dw_1.getSolicitadopor()));
        this.dw_1.setFechasolicitud(new Date());
        this.dw_1.setFecha(new Date());
        this.dw_1.setFechafin(UFechaHora.obtenerFechaHoraFinDia(new Date()));
        this.dw_1.setDesde1(UFechaHora.obtenerFechaHoraInicioDiaDate(new Date()));
        this.dw_1.setHasta1(UFechaHora.obtenerFechaHoraInicioDiaDate(new Date()));
        this.diferenciaDia = new StringBuilder(String.valueOf(UFechaHora.obtenerDiasTranscurridos(this.dw_1.getFechafin(), this.dw_1.getFecha()) + 1)).toString();
        this.keyhorainicio();
        return null;
    }
    
    public String editar() throws Exception {
        this.enviarCorreo = false;
        this.setPantallaTituloReferente("Modificar");
        this.diferenciaDia = new StringBuilder(String.valueOf(UFechaHora.obtenerDiasTranscurridos(this.dw_1.getFechafin(), this.dw_1.getFecha()) + 1)).toString();
        this.keyhorainicio();
        return null;
    }
    
    public String ver() throws Exception {
        return null;
    }
    
    public String eliminar() throws Exception {
        this.setPantallaTituloReferente("Eliminar");
        this.opciones.setIshabilitarempleado(Boolean.valueOf(false));
        this.opciones.setIshabilitarcb1(Boolean.valueOf(false));
        this.opciones.setIshabilitarempleadodescripcion(Boolean.valueOf(false));
        this.opciones.setIshabilitardweventos(Boolean.valueOf(false));
        this.opciones.setIshabilitarfecha(Boolean.valueOf(false));
        this.opciones.setIshabilitarfechafin(Boolean.valueOf(false));
        this.opciones.setIshabilitardesde1(Boolean.valueOf(false));
        this.opciones.setIshabilitarhasta1(Boolean.valueOf(false));
        this.opciones.setIshabilitarcomportamiento(Boolean.valueOf(false));
        this.opciones.setIshabilitarobservaciones(Boolean.valueOf(false));
        this.opciones.setIshabilitarverarchivo(Boolean.valueOf(false));
        this.opciones.setIshabilitarnroresolucion(Boolean.valueOf(false));
        this.opciones.setIshabilitarconcepto(Boolean.valueOf(false));
        this.opciones.setIsmostrarcbinsertar(Boolean.valueOf(false));
        this.opciones.setIsmostrarcbeliminar(Boolean.valueOf(false));
        return null;
    }
    
    public String inactivar() throws Exception {
        return null;
    }
    
    public String ejecutar(String accion) throws Exception {
        return null;
    }
    
    public String guardar() throws Exception {
        Integer before_update_new = 1;
        Integer before_update = 1;
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update") && this.dw_1.getEstado().equals("A")) {
            this.setMessageError("No se puede Modificar en este estado. Debe Rechazar y generar una nueva Solicitud", (String)null);
            return null;
        }
        Label_0186: {
            if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Delete")) {
                try {
                    if (UValidador.esCero(this.wf_update())) {
                        return null;
                    }
                    break Label_0186;
                }
                catch (Exception e) {
                    this.setMessageError("No se pudo eliminar la papeleta");
                    return null;
                }
            }
            if (!this.validar()) {
                return null;
            }
            if (this.validarfechas) {
                return null;
            }
            if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
                before_update_new = this.wf_before_update_new();
            }
            else {
                before_update = this.wf_before_update();
            }
            if (before_update == 1 && before_update_new == 1 && UValidador.esCero(this.wf_update())) {
                return null;
            }
        }
        if (UValidador.esNulo((Object)this.enviarCorreo)) {
            this.enviarCorreo = false;
        }
        if (this.dw_1.getEstado().equals("S") && (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add") || this.enviarCorreo)) {
            this.enviarCorreo();
        }
        this.enviarCorreo();
        if (!UValidador.esNulo((Object)this.notificarlicenciasingoce())) {
            if (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Delete")) {
                if ("A".equals(this.dw_1.getEstado())) {
                    this.setMessageSuccess("Se registr\u00f3 la autorizaci\u00f3n correctamente", Boolean.valueOf(true));
                }
                if ("S".equals(this.dw_1.getEstado())) {
                    this.setMessageSuccess("Se registr\u00f3 la solicitud correctamente", Boolean.valueOf(true));
                }
            }
            CwAsAutorizacionPreprocesoAprobacionSIGED.getInstance().iniciarControladora();
            return "wasautorizacionpreprocesoaprobacionSIGED";
        }
        return null;
    }
    
    private String enviarCorreo() throws Exception {
        if (this.getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(this.getUsuarioActual().getAplicacionCodigo(), this.getUsuarioActual().getCodigoUsuario())) {
            return null;
        }
        String mensaje = "";
        String rutaCompleta = null;
        String colaborador = null;
        String concepto = null;
        List<CorreoDestinoCore> destinos = new ArrayList<CorreoDestinoCore>();
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
        fechaini = UFechaHora.convertirFechaCadena(this.dw_1.getFecha(), "dd/MM/yyyy");
        fechater = UFechaHora.convertirFechaCadena(this.dw_1.getFechafin(), "dd/MM/yyyy");
        if ("VACA".equals(this.dw_1.getConceptoacceso()) || "ADEL".equals(this.dw_1.getConceptoacceso()) || "FRAD".equals(this.dw_1.getConceptoacceso())) {
            diasresta = UFechaHora.obtenerDiferenciaDias(this.dw_1.getFecha(), this.dw_1.getFechafin()) + 1;
        }
        else {
            diasresta = this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(this.dw_1.getFecha(), this.dw_1.getFechafin());
        }
        if (!UValidador.esListaVacia((List)this.dw_horario)) {
            fechaini = UFechaHora.convertirFechaCadena(this.dw_horario.get(0).getFecha(), "dd/MM/yyyy");
            fechater = UFechaHora.convertirFechaCadena(this.dw_horario.get(this.dw_horario.size() - 1).getFecha(), "dd/MM/yyyy");
            diasresta = UFechaHora.obtenerDiferenciaDias(this.dw_horario.get(0).getFecha(), this.dw_horario.get(this.dw_horario.size() - 1).getFecha()) + 1;
        }
        mensajefecha = " desde el " + fechaini + " hasta el " + fechater;
        if (this.dw_1.getConceptoacceso().equals("OMIS")) {
            mensajefecha = " para el d\u00eda " + fechaini;
        }
        if (!UValidador.esListaVacia((List)this.dw_horario) && this.dw_horario.size() == 1) {
            mensajefecha = " para el d\u00eda " + fechaini;
        }
        if (UValidador.esCero(Integer.valueOf(diasresta - 1))) {
            if (this.dw_1.getConceptoacceso().equals("OMIS")) {
                mensajehoras = ", a las " + UFechaHora.convertirFechaCadena(this.dw_1.getDesde1(), "HH:mm");
            }
            else {
                mensajehoras = ", de " + UFechaHora.convertirFechaCadena(this.dw_1.getDesde1(), "HH:mm") + " a " + UFechaHora.convertirFechaCadena(this.dw_1.getHasta1(), "HH:mm");
            }
        }
        else {
            mensajehoras = "";
        }
        if (this.dw_1.getCategoriaautorizacion().equals("SOBR") && !UValidador.estaVacio(this.dw_1.getTipoautorizacion())) {
            if (this.dw_1.getTipoautorizacion().equals("D")) {
                lugar = "Lugar : DENTRO de la Instituci\u00f3n.";
            }
            if (this.dw_1.getTipoautorizacion().equals("F")) {
                lugar = "Lugar : FUERA de la Instituci\u00f3n.";
            }
        }
        AsArea area = this.getFacAsistencia().getAsAreaServicio().obtenerArea(this.dw_1.getEmpleado(), this.getUsuarioActual().getCompaniaSocioCodigo());
        Boolean isresponsable = false;
        Integer empleado1 = 0;
        String flgempleado1 = "N";
        Integer empleado2 = 0;
        String flgempleado2 = "N";
        Integer empleado3 = 0;
        String flgempleado3 = "N";
        Integer empleado4 = 0;
        String flgempleado4 = "N";
        if (!UValidador.esNulo((Object)area)) {
            if (this.dw_1.getEmpleado().equals(area.getEmpleadoresponsable()) || this.dw_1.getEmpleado().equals(area.getEmpleadoresponsable2()) || this.dw_1.getEmpleado().equals(area.getEmpleadoresponsable3()) || this.dw_1.getEmpleado().equals(area.getEmpleadoresponsable4())) {
                isresponsable = true;
            }
            if (isresponsable) {
                if (this.dw_1.getEmpleado().equals(area.getEmpleadoresponsable())) {
                    empleado1 = area.getEmpleadoaprobador();
                    flgempleado1 = area.getFlagcorreoaprobador1();
                }
                if (this.dw_1.getEmpleado().equals(area.getEmpleadoresponsable2())) {
                    empleado2 = area.getEmpleadoaprobador2();
                    flgempleado2 = area.getFlagcorreoaprobador2();
                }
                if (this.dw_1.getEmpleado().equals(area.getEmpleadoresponsable3())) {
                    empleado3 = area.getEmpleadoaprobador3();
                    flgempleado3 = area.getFlagcorreoaprobador3();
                }
                if (this.dw_1.getEmpleado().equals(area.getEmpleadoresponsable4())) {
                    empleado4 = area.getEmpleadoaprobador4();
                    flgempleado4 = area.getFlagcorreoaprobador4();
                }
            }
            else {
                empleado1 = area.getEmpleadoresponsable();
                flgempleado1 = area.getFlagcorreoresponsable1();
                empleado2 = area.getEmpleadoresponsable2();
                flgempleado2 = area.getFlagcorreoresponsable2();
                empleado3 = area.getEmpleadoresponsable3();
                flgempleado3 = area.getFlagcorreoresponsable3();
                empleado4 = area.getEmpleadoresponsable4();
                flgempleado4 = area.getFlagcorreoresponsable4();
            }
            if (flgempleado1.equals("S")) {
                Empleadomast emple1 = new Empleadomast();
                emple1.getPk().setEmpleado(empleado1);
                emple1.getPk().setCompaniasocio(this.getUsuarioActual().getCompaniaSocioCodigo());
                emple1 = (Empleadomast)this.getFacCore().getEmpleadomastServicio().obtenerPorId((Serializable)emple1.getPk());
                if (!UValidador.esNulo((Object)emple1)) {
                    destinatarior1 = emple1.getCorreointerno();
                    CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("destinatario1 " + destinatarior1));
                }
            }
            if (flgempleado2.equals("S")) {
                Empleadomast emple2 = new Empleadomast();
                emple2.getPk().setEmpleado(empleado2);
                emple2.getPk().setCompaniasocio(this.getUsuarioActual().getCompaniaSocioCodigo());
                emple2 = (Empleadomast)this.getFacCore().getEmpleadomastServicio().obtenerPorId((Serializable)emple2.getPk());
                if (!UValidador.esNulo((Object)emple2)) {
                    destinatarior2 = emple2.getCorreointerno();
                    CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("destinatario2 " + destinatarior2));
                }
            }
            if (flgempleado3.equals("S")) {
                Empleadomast emple3 = new Empleadomast();
                emple3.getPk().setEmpleado(empleado3);
                emple3.getPk().setCompaniasocio(this.getUsuarioActual().getCompaniaSocioCodigo());
                emple3 = (Empleadomast)this.getFacCore().getEmpleadomastServicio().obtenerPorId((Serializable)emple3.getPk());
                if (!UValidador.esNulo((Object)emple3)) {
                    destinatarior3 = emple3.getCorreointerno();
                    CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("destinatario3 " + destinatarior3));
                }
            }
            if (flgempleado4.equals("S")) {
                Empleadomast emple4 = new Empleadomast();
                emple4.getPk().setEmpleado(empleado4);
                emple4.getPk().setCompaniasocio(this.getUsuarioActual().getCompaniaSocioCodigo());
                emple4 = (Empleadomast)this.getFacCore().getEmpleadomastServicio().obtenerPorId((Serializable)emple4.getPk());
                if (!UValidador.esNulo((Object)emple4)) {
                    destinatarior4 = emple4.getCorreointerno();
                    CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("destinatario4 " + destinatarior4));
                }
            }
        }
        Empleadomast empleado5 = new Empleadomast();
        empleado5.getPk().setCompaniasocio(this.getUsuarioActual().getCompaniaSocioCodigo());
        empleado5.getPk().setEmpleado(Integer.valueOf((int)this.dw_1.getEmpleado()));
        empleado5 = (Empleadomast)this.getFacCore().getEmpleadomastServicio().obtenerPorId((Serializable)empleado5.getPk());
        if (!UValidador.esNulo((Object)empleado5)) {
            destinatario5 = empleado5.getCorreointerno();
            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("destinatario " + destinatario5));
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
        if (this.dw_1.getConceptoacceso().equals("34") && "A".equals(this.dw_1.getEstado()) && !UValidador.estaVacio(destinatario5)) {
            destinos.add(new CorreoDestinoCore(destinatario5));
        }
        if (this.dw_1.getConceptoacceso().equals("98")) {
            "S".equals(this.dw_1.getEstado());
        }
        colaborador = this.getFacCore().getPersonamastServicio().obtenerNombrePersona(BigDecimal.valueOf(this.dw_1.getEmpleado()));
        AsConceptoacceso obj = new AsConceptoacceso();
        obj.getPk().setConceptoacceso(this.dw_1.getConceptoacceso());
        obj = (AsConceptoacceso)this.getFacAsistencia().getAsConceptoaccesoServicio().obtenerPorId((Serializable)obj.getPk());
        if (!UValidador.esNulo((Object)obj)) {
            concepto = obj.getDescripcionlocal();
        }
        if (this.dw_1.getConceptoacceso().equals("34") && "A".equals(this.dw_1.getEstado())) {
            rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//solicitud_resolucion044.html");
            mensajehoras = " m\u00e1ximo " + obj.getNumerohorasmesesrestriccion() + " horas ";
            mensajefecha = " para el d\u00eda " + UFechaHora.convertirFechaCadena(this.dw_1.getFecha(), "dd/MM/yyyy");
            mensajehorasprog = obj.getCantidadminutosminimo() + " minutos ";
            mensajefechaprog = String.valueOf(UFechaHora.convertirFechaCadena(this.dw_1.getDesderecupera(), "dd/MM/yyyy")) + " hasta el d\u00eda " + UFechaHora.convertirFechaCadena(this.dw_1.getHastarecupera(), "dd/MM/yyyy");
        }
        else if (this.dw_1.getConceptoacceso().equals("75") || this.dw_1.getConceptoacceso().equals("85") || this.dw_1.getConceptoacceso().equals("84") || this.dw_1.getConceptoacceso().equals("19") || this.dw_1.getConceptoacceso().equals("06") || this.dw_1.getConceptoacceso().equals("76") || this.dw_1.getConceptoacceso().equals("86")) {
            if (this.dw_1.getConceptoacceso().equals("86")) {
                mensajerazonrecupera = " a raz\u00f3n de 1 hora por d\u00eda";
            }
            destinos.add(new CorreoDestinoCore(destinatario5));
            rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//solicitud_compensables.html");
            mensajefechaprog = String.valueOf(UFechaHora.convertirFechaCadena(this.fechaRecuperacionIni, "dd/MM/yyyy")) + " hasta el d\u00eda " + UFechaHora.convertirFechaCadena(this.fechaRecuperacionFin, "dd/MM/yyyy");
        }
        else {
            rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//solicitud_asistencia.html");
        }
        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)rutaCompleta);
        mensaje = UFile.obtenerContenidoFile(rutaCompleta);
        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)mensaje);
        mensaje = mensaje.replace("[EMPLEADO]", UString.cambiarCaracteresEspecialesHTML(colaborador));
        mensaje = mensaje.replace("[CONCEPTO]", UString.cambiarCaracteresEspecialesHTML(concepto));
        mensaje = mensaje.replace("[MENSAJE_FECHA]", UString.cambiarCaracteresEspecialesHTML(mensajefecha));
        mensaje = mensaje.replace("[MENSAJE_HORA]", UString.cambiarCaracteresEspecialesHTML(mensajehoras));
        mensaje = mensaje.replace("[LUGAR]", UString.cambiarCaracteresEspecialesHTML(lugar));
        mensaje = mensaje.replace("[DIFERENCIA_DIAS]", UString.cambiarCaracteresEspecialesHTML(UValidador.esCero(diasresta) ? "" : (" D\u00edas: " + diasresta)));
        mensaje = mensaje.replace("[MENSAJE_FECHA_PROG]", UString.cambiarCaracteresEspecialesHTML(mensajefechaprog));
        mensaje = mensaje.replace("[MENSAJE_HORA_PROG]", UString.cambiarCaracteresEspecialesHTML(mensajehorasprog));
        mensaje = mensaje.replace("[MENSAJE_1]", "Conforme a lo indicado en su carta y de acuerdo a la Resoluci\u00f3n de Gerencia General N° 044-2018-OEFA/GEG, se aprueba su permiso de ");
        mensaje = mensaje.replace("[MENSAJE_2]", " asimismo se le indica que dichas horas ser\u00e1n compensadas desde el d\u00eda ");
        mensaje = mensaje.replace("[MENSAJE_3]", " a raz\u00f3n de m\u00ednimo ");
        mensaje = mensaje.replace("[MENSAJE_4]", mensajerazonrecupera);
        Boolean isconfiguradocorreo = this.getFacSeguridad().getCorreoServicio().configurarCorreo();
        if (isconfiguradocorreo) {
            CorreoCore correo = new CorreoCore();
            correo.setListaCorreoDestino((List)destinos);
            correo.setAsunto("Solicitud de Asistencia");
            correo.setCuerpoCorreo(mensaje.getBytes());
            if (!UValidador.esListaVacia((List)destinos)) {
                this.getFacSeguridad().getCorreoServicio().enviarCorreo(correo);
            }
        }
        return null;
    }
    
    private Integer wf_update() throws Exception {
        Boolean w_primero = false;
        Integer w_empleado = null;
        Date w_fecha = null;
        String w_autorizadopor = null;
        Integer[] aprobadores = { null };
        Boolean existe = false;
        String rechazadopor = null;
        Date fecharechazo = null;
        Date ldt_desde = null;
        Date ldt_hasta = null;
        Date w_fecharesolucion = null;
        this.iv_tipoautorizacion = this.dw_1.getTipoautorizacion();
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Delete")) {
            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("dw_1.getDesde1()" + this.dw_1.getDesde1()));
            this.getFacAsistencia().getAsAccesosdiariosServicio().eliminarAccesosDiarios(this.dw_1.getEmpleado(), this.dw_1.getFecha(), this.dw_1.getConceptoacceso(), this.dw_1.getDesde1());
            this.getFacAsistencia().getAsAutorizacionServicio().eliminarAutorizacion(this.dw_1.getEmpleado(), this.dw_1.getFecha(), this.dw_1.getConceptoacceso(), this.dw_1.getDesde1());
            this.getFacAsistencia().getAsAutorizacionServicio().eliminarAutorizacionFecha(this.dw_1.getEmpleado(), UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), this.dw_1.getDesde1()));
            this.getFacAsistencia().getAsEmpleadoexcepcionServicio().eliminarEmpleadoExcepcionSolicitud(this.dw_1.getEmpleado(), this.dw_1.getFecha());
            this.setMessageSuccess(getMessageProperty("generico_eliminar_varios"), Boolean.valueOf(true));
            this.eliminarSIGED(this.dw_1.getFecha(), this.dw_1.getFechafin(), this.dw_1.getConceptoacceso());
            this.eliminarAlfresco();
            return 1;
        }
        w_empleado = this.dw_1.getEmpleado();
        w_fecha = this.dw_1.getFecha();
        Date w_fechafin = this.dw_1.getFechafin();
        Date w_desde1 = this.dw_1.getDesde1();
        Date w_hasta1 = this.dw_1.getHasta1();
        String w_categoriaAutorizacion = this.dw_1.getCategoriaautorizacion();
        if (w_categoriaAutorizacion.equals("OMIS")) {
            w_hasta1 = w_desde1;
            w_fechafin = w_fecha;
        }
        String w_periodo = this.dw_1.getPeriodo();
        String w_refrigerio = this.dw_1.getRefrigerio();
        String w_mandatorio = this.dw_1.getMandatario();
        String w_observacion = this.dw_1.getObservacion();
        Date w_fechaSolicitud = this.dw_1.getFechasolicitud();
        Date w_fecha_autorizacion = this.dw_1.getFechasolicitud();
        String w_solicitadoPor = this.dw_1.getSolicitadopor();
        Integer w_TipoHorario = this.dw_1.getTipohorario();
        String w_ruta = this.dw_1.getRutadocumento();
        String w_resolucion = this.dw_1.getNroresolucion();
        w_fecharesolucion = this.dw_1.getFecharesolucion();
        w_autorizadopor = this.dw_1.getAutorizadopor();
        String w_ultimousuario = this.getUsuarioActual().getLoginUsuario().toUpperCase();
        Date w_ultimafechamodif = new Date();
        String w_comportamientoSobretiempo = this.dw_1.getComportamientosobretiempo();
        String w_estado = this.dw_1.getEstado();
        if (this.dw_1.getConceptoacceso().equals("99")) {
            w_estado = "A";
            this.dw_1.setEstadoai("A");
        }
        String w_Corrido = this.dw_1.getCorrido();
        if (UValidador.estaVacio(w_Corrido)) {
            w_Corrido = "N";
        }
        aprobadores[0] = this.getFacAsistencia().getAsAreaServicio().obtenerEmpleadoResponsable(w_empleado);
        if (!UValidador.esNulo((Object)w_desde1)) {
            w_primero = true;
        }
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
            if (this.conceptoacceso.equals("97")) {
                String date_s = new SimpleDateFormat("dd/MM/yyyy").format(w_desde1);
                String date_b = new SimpleDateFormat("dd/MM/yyyy").format(w_fecha);
                w_desde1 = new SimpleDateFormat("dd/MM/yyyy").parse(date_s);
                w_fecha = new SimpleDateFormat("dd/MM/yyyy").parse(date_b);
            }
            AsAutorizacion objfind = new AsAutorizacion();
            objfind.getPk().setConceptoacceso(this.conceptoacceso);
            objfind.getPk().setDesde(w_desde1);
            objfind.getPk().setFecha(w_fecha);
            objfind.getPk().setEmpleado(BigDecimal.valueOf(w_empleado));
            objfind = (AsAutorizacion)this.getFacAsistencia().getAsAutorizacionServicio().obtenerPorId((Serializable)objfind.getPk());
            if (!UValidador.esNulo((Object)objfind)) {
                existe = true;
            }
            if (existe && (!UValidador.esCero(Integer.valueOf(this.fechaoriginal.compareTo(w_fecha))) || !UValidador.esCero(Integer.valueOf(this.fechadesdeoriginal.compareTo(w_desde1))) || !this.conceptoaccesooriginal.equals(this.conceptoacceso)) && !this.dw_1.getConceptoacceso().equals("CHOR")) {
                this.setMessageError("Ya existe el registro");
                return 0;
            }
            if (existe || !UValidador.esCero(Integer.valueOf(this.fechaoriginal.compareTo(w_fecha))) || !UValidador.esCero(Integer.valueOf(this.fechadesdeoriginal.compareTo(w_desde1))) || !this.conceptoaccesooriginal.equals(this.conceptoacceso)) {
                AsAutorizacionPk pkdel = new AsAutorizacionPk();
                pkdel.setConceptoacceso(this.conceptoaccesooriginal);
                pkdel.setDesde(this.fechadesdeoriginal);
                pkdel.setFecha(this.fechaoriginal);
                pkdel.setEmpleado(BigDecimal.valueOf(w_empleado));
                AsAutorizacion objdel = (AsAutorizacion)this.getFacAsistencia().getAsAutorizacionServicio().obtenerPorId((Serializable)pkdel, false);
                if (this.dw_1.getConceptoacceso().equals("04") || this.dw_1.getConceptoacceso().equals("05")) {
                    this.getFacAsistencia().getAsAutorizacionServicio().eliminarAutorizacionFecha(this.dw_1.getEmpleado(), UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), this.fechadesdeoriginal));
                }
                if (!UValidador.esNulo((Object)objdel) && objdel.getSobretiempoposicion().equals("1")) {
                    this.getFacAsistencia().getAsAutorizacionServicio().eliminar((Object)objdel);
                }
            }
            AsAutorizacion objins = new AsAutorizacion();
            objins.getPk().setConceptoacceso(this.dw_1.getConceptoacceso());
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
            objins.setDesderecupera(this.dw_1.getDesderecupera());
            objins.setHastarecupera(this.dw_1.getHastarecupera());
            objins.setPeriodoplanilla(this.dw_1.getPeriodoplanilla());
            objins.setNombrearchivodj(this.dw_1.getNombrearchivodj());
            this.getFacAsistencia().getAsAutorizacionServicio().registrar((Object)objins);
            if (w_primero) {
                AsAutorizacionPk pkupd = new AsAutorizacionPk();
                pkupd.setConceptoacceso(this.conceptoacceso);
                pkupd.setDesde(w_desde1);
                pkupd.setFecha(w_fecha);
                pkupd.setEmpleado(BigDecimal.valueOf(w_empleado));
                AsAutorizacion objupd = (AsAutorizacion)this.getFacAsistencia().getAsAutorizacionServicio().obtenerPorId((Serializable)pkupd, false);
                if (!UValidador.esNulo((Object)objupd)) {
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
                    objupd.setTipoautorizacion(this.iv_tipoautorizacion);
                    objupd.setDesderecupera(this.dw_1.getDesderecupera());
                    objupd.setHastarecupera(this.dw_1.getHastarecupera());
                    objupd.setPeriodoplanilla(this.dw_1.getPeriodoplanilla());
                    objupd.setNombrearchivodj(this.dw_1.getNombrearchivodj());
                    this.getFacAsistencia().getAsAutorizacionServicio().actualizar((Object)objupd);
                }
            }
            this.actualizarSIGED(this.fechadesdeoriginal, this.fechafinOriginal, this.conceptoaccesooriginal);
        }
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
            if (this.conceptoacceso.equals("97")) {
                String date_s = new SimpleDateFormat("dd/MM/yyyy").format(w_desde1);
                String date_b = new SimpleDateFormat("dd/MM/yyyy").format(w_fecha);
                w_desde1 = new SimpleDateFormat("dd/MM/yyyy").parse(date_s);
                w_fecha = new SimpleDateFormat("dd/MM/yyyy").parse(date_b);
            }
            existe = false;
            AsAutorizacion objfind = new AsAutorizacion();
            objfind.getPk().setConceptoacceso(this.conceptoacceso);
            objfind.getPk().setDesde(w_desde1);
            objfind.getPk().setFecha(w_fecha);
            objfind.getPk().setEmpleado(BigDecimal.valueOf(w_empleado));
            objfind = (AsAutorizacion)this.getFacAsistencia().getAsAutorizacionServicio().obtenerPorId((Serializable)objfind.getPk());
            if (!UValidador.esNulo((Object)objfind)) {
                existe = true;
            }
            if (existe && !this.dw_1.getConceptoacceso().equals("CHOR")) {
                this.setMessageError("Ya existe el registro");
                return 0;
            }
            String aprobadopor = this.getUsuarioActual().getLoginUsuario().toUpperCase();
            Date fechaaprobacion = w_fecha_autorizacion = w_fechaSolicitud;
            if (this.dw_1.getEstadoai().equals("S")) {
                fechaaprobacion = null;
                fecharechazo = null;
                w_estado = "S";
                aprobadopor = "";
                rechazadopor = "";
                w_fecha_autorizacion = fechaaprobacion;
            }
            else if (this.dw_1.getEstadoai().equals("A")) {
                w_estado = "A";
            }
            else {
                w_estado = "A";
            }
            if (w_estado.equals("A") && w_categoriaAutorizacion.equals("OMIS")) {
                this.wf_Insertar_Marca(w_empleado, UFechaHora.obtenerFechaCompuesta(w_fecha, w_desde1), "");
            }
            if (w_primero) {
                if (this.conceptoacceso.equals("04") && w_categoriaAutorizacion.equals("COMP")) {
                    List data = this.getFacAsistencia().getAS().getAsrepusFuncion().FAsAutorizacionPreprocesoTipodia2(this.empleado, this.fecha);
                    if (!UValidador.esListaVacia(data)) {
                        ldt_desde = (Date) data.get(0);
                        ldt_hasta = (Date) data.get(1);
                    }
                    if (!UValidador.esNulo((Object)ldt_desde)) {
                        w_desde1 = UFechaHora.obtenerFechaCompuesta(w_desde1, ldt_desde);
                    }
                    if (!UValidador.esNulo((Object)ldt_hasta)) {
                        w_hasta1 = UFechaHora.obtenerFechaCompuesta(w_hasta1, ldt_hasta);
                    }
                    if (!UValidador.esNulo((Object)ldt_desde) && !UValidador.esNulo((Object)ldt_hasta) && w_desde1.after(w_hasta1)) {
                        w_hasta1 = UFechaHora.obtenerFechaCompuesta(UFechaHora.obtenerFechaMasdias(w_hasta1, Integer.valueOf(1)), w_hasta1);
                    }
                }
                AsAutorizacion registro = new AsAutorizacion();
                registro.getPk().setEmpleado(BigDecimal.valueOf(w_empleado));
                registro.getPk().setFecha(w_fecha);
                registro.getPk().setConceptoacceso(this.dw_1.getConceptoacceso());
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
                registro.setTipohorario(BigDecimal.valueOf(UValidador.esNulo((Object)w_TipoHorario) ? 0 : w_TipoHorario));
                registro.setFlagcorrido(w_Corrido);
                registro.setRutadocumento(w_ruta);
                registro.setNombrearchivodj(this.dw_1.getNombrearchivodj());
                registro.setTipoautorizacion(this.iv_tipoautorizacion);
                registro.setNroresolucion(w_resolucion);
                registro.setFecharesolucion(w_fecharesolucion);
                registro.setDesderecupera(this.dw_1.getDesderecupera());
                registro.setHastarecupera(this.dw_1.getHastarecupera());
                if ("75".equalsIgnoreCase(this.dw_1.getConceptoacceso()) || "85".equalsIgnoreCase(this.dw_1.getConceptoacceso()) || "84".equalsIgnoreCase(this.dw_1.getConceptoacceso()) || "19".equalsIgnoreCase(this.dw_1.getConceptoacceso()) || "06".equalsIgnoreCase(this.dw_1.getConceptoacceso()) || "76".equalsIgnoreCase(this.dw_1.getConceptoacceso()) || "83".equalsIgnoreCase(this.dw_1.getConceptoacceso()) || "86".equalsIgnoreCase(this.dw_1.getConceptoacceso())) {
                    if ("86".equalsIgnoreCase(this.dw_1.getConceptoacceso())) {
                        this.fechaRecuperacionIni = UFechaHora.anadirDiasAFechas(this.dw_1.getFecha(), 3);
                        this.fechaRecuperacionFin = UFechaHora.anadirDiasAFechas(this.fechaRecuperacionIni, 3);
                        registro.setDesderecupera(this.fechaRecuperacionIni);
                        registro.setHastarecupera(this.fechaRecuperacionFin);
                    }
                    else {
                        DtoPermisosEnCompensacion dtoPermisosEnCompensacion = this.obtenerPermisosCompensacion((int)this.dw_1.getEmpleado(), this.dw_1.getFechafin(), this.diascompensa.intValue());
                        this.fechaRecuperacionIni = dtoPermisosEnCompensacion.getDesderecupera();
                        this.fechaRecuperacionFin = dtoPermisosEnCompensacion.getHastarecupera();
                        registro.setDesderecupera(this.fechaRecuperacionIni);
                        registro.setHastarecupera(this.fechaRecuperacionFin);
                    }
                }
                registro.setPeriodoplanilla(this.dw_1.getPeriodoplanilla());
                this.getFacAsistencia().getAsAutorizacionServicio().registrar((Object)registro);
                if (w_estado.equals("A") && this.conceptoacceso.equals("VACA")) {
                    String w_periodovac = new StringBuilder().append(UFechaHora.obtenerFechaParte(w_fecha, "YY")).append((UFechaHora.obtenerFechaParte(w_fecha, "MM") > 9) ? UFechaHora.obtenerFechaParte(w_fecha, "MM") : ("0" + UFechaHora.obtenerFechaParte(w_fecha, "MM"))).toString();
                    Integer w_ano = UFechaHora.obtenerFechaParte(w_fecha, "YY");
                    Integer w_dias = UFechaHora.obtenerDiasTranscurridos(w_fechafin, w_fecha) + 1;
                    BigDecimal w_secuencia = this.getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerMaximoVacacionesProgramadas(w_empleado, w_periodovac);
                    if (UValidador.esNulo((Object)w_secuencia)) {
                        w_secuencia = BigDecimal.ONE;
                    }
                    PrVacacionesprogramadas vacaciones = new PrVacacionesprogramadas();
                    vacaciones.getPk().setNumeroperiodo(BigDecimal.valueOf(1L));
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
                    vacaciones.setUltimoUsuario(this.getUsuarioActual().getLoginUsuario().toUpperCase());
                    vacaciones.setUltimaFechaModif(new Date());
                    this.getFacPlanilla().getPrVacacionesprogramadasServicio().registrar((Object)vacaciones);
                }
            }
            this.guardarDatosSIGED();
            if (this.conceptoacceso.equals("VACA")) {
                this.guardarFuncionesORolesSIGED();
            }
        }
        if (!this.wf_actualiza_blob(w_empleado, w_fecha, this.conceptoacceso, w_desde1)) {
            return 0;
        }
        if (!this.wf_actualiza_blob_dj(w_empleado, w_fecha, this.conceptoacceso, w_desde1)) {
            return 0;
        }
        this.dwhorarioupdate();
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add") || CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
            this.w_horainicio = this.dw_1.getDesde1();
            this.w_horafin = this.dw_1.getHasta1();
            if ("04".equals(this.dw_1.getConceptoacceso())) {
                this.w_horainicio = this.desdeGlobal;
                this.w_horafin = this.hastaGlobal;
            }
            this.w_diftiempo = this.wf_diftiempo(this.w_horainicio, this.w_horafin).divide(BigDecimal.valueOf(3600L), 2, 4);
            this.w_diftiempo = this.w_diftiempo.subtract(this.obtenerHorasRefrigerio());
            Integer diastrans = UFechaHora.obtenerDiasTranscurridos(this.dw_1.getFechafin(), this.dw_1.getFecha()) + 1;
            this.w_diftiempo = this.w_diftiempo.multiply(new BigDecimal(diastrans)).setScale(2, 4);
            this.w_ttotal = this.w_diftiempo;
            if (UValidador.esNulo((Object)this.w_ttotal)) {
                this.w_ttotal = BigDecimal.ZERO;
            }
            if (!UValidador.esListaVacia((List)this.dw_diascompensados)) {
                for (DtoDwAsAsistenciaHextraEdit obj : this.dw_diascompensados) {
                    CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("SELECCIONADO::" + obj.getIsseleccionado()));
                    if (obj.getIsseleccionado()) {
                        if (this.w_ttotal.compareTo(BigDecimal.ZERO) == 0) {
                            break;
                        }
                        w_fecha = obj.getFecha();
                        w_fechafin = this.dw_1.getFecha();
                        BigDecimal w_cantidad = obj.getCantidad();
                        BigDecimal w_cantidadreal = obj.getDiferencia();
                        BigDecimal w_diferencia = obj.getDiferencia();
                        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("w_fecha::" + w_fecha));
                        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("w_fechafin::" + w_fechafin));
                        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("w_cantidad::" + w_cantidad));
                        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("w_cantidadreal::" + w_cantidadreal));
                        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("w_diferencia::" + w_diferencia));
                        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("w_ttotal::" + this.w_ttotal));
                        BigDecimal w_resto;
                        if (this.w_ttotal.compareTo(w_diferencia) == 1 && Math.abs(this.w_ttotal.subtract(w_diferencia).doubleValue()) > 0.01) {
                            this.w_ttotal = this.w_ttotal.subtract(w_diferencia);
                            w_cantidad = w_diferencia;
                            w_resto = BigDecimal.ZERO;
                        }
                        else {
                            w_cantidad = this.w_ttotal;
                            w_resto = w_diferencia.subtract(this.w_ttotal).setScale(2, 4);
                            this.w_ttotal = BigDecimal.ZERO;
                        }
                        AsAutorizacionfecha objinsert = new AsAutorizacionfecha();
                        objinsert.getPk().setEmpleado(this.dw_1.getEmpleado());
                        objinsert.getPk().setFecha(w_fecha);
                        objinsert.getPk().setFechasolicitud(w_fechafin);
                        objinsert.getPk().setDesde(UFechaHora.obtenerFechaCompuesta(w_fechafin, this.dw_1.getDesde1()));
                        objinsert.setHasta(UFechaHora.obtenerFechaCompuesta(this.dw_1.getFechafin(), this.dw_1.getHasta1()));
                        objinsert.setCantidad(w_cantidad);
                        objinsert.setCantidadreal(w_cantidadreal);
                        objinsert.setDiferencia(w_resto);
                        objinsert.setEstado("A");
                        objinsert.setUltimoUsuario(this.getUsuarioActual().getCodigoUsuario());
                        objinsert.setUltimaFechaModif(new Date());
                        this.getFacAsistencia().getAsAutorizacionfechaServicio().registrar((Object)objinsert);
                    }
                }
            }
        }
        return 1;
    }
    
    private void guardarFuncionesORolesSIGED() {
        if (UValidador.esListaVacia(this.empleadoNuevaBandeja.getBandejas())) {
            return;
        }
        Integer linea = 1;
        for (DtoBandejaSIGED bandeja : this.empleadoNuevaBandeja.getBandejas()) {
            AsDetallesiged asDetallesiged = new AsDetallesiged();
            asDetallesiged.getPk().setConceptoacceso(this.dw_1.getConceptoacceso());
            asDetallesiged.getPk().setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
            asDetallesiged.getPk().setFechadesde(this.dw_1.getFecha());
            asDetallesiged.getPk().setFechahasta(this.dw_1.getFechafin());
            asDetallesiged.getPk().setSecuencia(new BigDecimal(linea));
            asDetallesiged.setIdcargo(new BigDecimal(bandeja.getIdCargo()));
            asDetallesiged.setIdarea(new BigDecimal(bandeja.getIdArea()));
            asDetallesiged.setIdpersona(new BigDecimal(bandeja.getIdPersona()));
            asDetallesiged.setIdempleadosia(bandeja.getIdPersonaSIA());
            asDetallesiged.setEstado("S");
            asDetallesiged.setUltimaFechaModif(new Date());
            asDetallesiged.setUltimoUsuario(this.getUsuarioActual().getCodigoUsuario());
            this.getFacAsistencia().getAsDetallesigedServicio().registrar((Object)asDetallesiged);
            ++linea;
        }
    }
    
    private void actualizarSIGED(Date w_fechaDesde, Date w_fechahasta, String concepto) throws Exception {
        if (this.dw_1.getCategoriaautorizacion().equals("PSIG")) {
            if (this.dw_1.getConceptoacceso().equals("95") || this.dw_1.getConceptoacceso().equals("94") || this.dw_1.getConceptoacceso().equals("97")) {
                for (DtoBandejaSIGED bandeja : this.empleadoNuevaBandeja.getBandejas()) {
                    AsDetallesigedPk pk = new AsDetallesigedPk();
                    pk.setConceptoacceso(concepto);
                    pk.setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                    pk.setFechadesde(w_fechaDesde);
                    pk.setFechahasta(w_fechahasta);
                    pk.setSecuencia(bandeja.getSecuencia());
                    AsDetallesiged asDetallesiged = (AsDetallesiged)this.getFacAsistencia().getAsDetallesigedServicio().obtenerPorId((Serializable)pk, false);
                    if (!UValidador.esNulo((Object)asDetallesiged)) {
                        this.getFacAsistencia().getAsDetallesigedServicio().eliminar((Object)asDetallesiged);
                    }
                }
            }
            if (this.dw_1.getConceptoacceso().equals("98")) {
                for (DtoPerfilSIGED perfiles : this.listaPerfilesSIGED) {
                    AsDetallesigedPk pk = new AsDetallesigedPk();
                    pk.setConceptoacceso(concepto);
                    pk.setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                    pk.setFechadesde(w_fechaDesde);
                    pk.setFechahasta(((boolean)this.opciones.getIsmostrarfechafin()) ? w_fechahasta : w_fechaDesde);
                    pk.setSecuencia(perfiles.getSecuencia());
                    AsDetallesiged asDetallesiged = (AsDetallesiged)this.getFacAsistencia().getAsDetallesigedServicio().obtenerPorId((Serializable)pk, false);
                    if (!UValidador.esNulo((Object)asDetallesiged)) {
                        this.getFacAsistencia().getAsDetallesigedServicio().eliminar((Object)asDetallesiged);
                    }
                }
            }
            if (this.dw_1.getConceptoacceso().equals("96")) {
                AsDetallesigedPk pk2 = new AsDetallesigedPk();
                pk2.setConceptoacceso(concepto);
                pk2.setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                pk2.setFechadesde(w_fechaDesde);
                pk2.setFechahasta(w_fechahasta);
                pk2.setSecuencia(this.nuevaBandeja.getSecuencia());
                AsDetallesiged asDetallesiged2 = (AsDetallesiged)this.getFacAsistencia().getAsDetallesigedServicio().obtenerPorId((Serializable)pk2, false);
                if (!UValidador.esNulo((Object)asDetallesiged2)) {
                    this.getFacAsistencia().getAsDetallesigedServicio().eliminar((Object)asDetallesiged2);
                }
            }
            if (this.dw_1.getConceptoacceso().equals("xx")) {
                AsDetallesigedPk pk2 = new AsDetallesigedPk();
                pk2.setConceptoacceso(concepto);
                pk2.setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                pk2.setFechadesde(w_fechaDesde);
                pk2.setFechahasta(w_fechahasta);
                pk2.setSecuencia(BigDecimal.ONE);
                AsDetallesiged asDetallesiged2 = (AsDetallesiged)this.getFacAsistencia().getAsDetallesigedServicio().obtenerPorId((Serializable)pk2, false);
                if (!UValidador.esNulo((Object)asDetallesiged2)) {
                    this.getFacAsistencia().getAsDetallesigedServicio().eliminar((Object)asDetallesiged2);
                }
            }
            if (this.dw_1.getConceptoacceso().equals("99")) {
                AsDetallesigedPk pk2 = new AsDetallesigedPk();
                pk2.setConceptoacceso(concepto);
                pk2.setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                pk2.setFechadesde(w_fechaDesde);
                pk2.setFechahasta(w_fechahasta);
                pk2.setSecuencia(BigDecimal.ONE);
                AsDetallesiged asDetallesiged2 = (AsDetallesiged)this.getFacAsistencia().getAsDetallesigedServicio().obtenerPorId((Serializable)pk2, false);
                if (!UValidador.esNulo((Object)asDetallesiged2)) {
                    this.getFacAsistencia().getAsDetallesigedServicio().eliminar((Object)asDetallesiged2);
                }
            }
            this.guardarDatosSIGED();
        }
        if (this.dw_1.getConceptoacceso().equals("VACA")) {
            for (DtoBandejaSIGED bandeja : this.empleadoNuevaBandeja.getBandejas()) {
                AsDetallesigedPk pk = new AsDetallesigedPk();
                pk.setConceptoacceso(concepto);
                pk.setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                pk.setFechadesde(w_fechaDesde);
                pk.setFechahasta(w_fechahasta);
                pk.setSecuencia(bandeja.getSecuencia());
                AsDetallesiged asDetallesiged = (AsDetallesiged)this.getFacAsistencia().getAsDetallesigedServicio().obtenerPorId((Serializable)pk, false);
                if (!UValidador.esNulo((Object)asDetallesiged)) {
                    this.getFacAsistencia().getAsDetallesigedServicio().eliminar((Object)asDetallesiged);
                }
            }
            this.guardarFuncionesORolesSIGED();
        }
    }
    
    private void guardarDatosSIGED() throws Exception {
        if (this.dw_1.getCategoriaautorizacion().equals("PSIG")) {
            if (this.dw_1.getConceptoacceso().equals("95") || this.dw_1.getConceptoacceso().equals("97")) {
                Integer linea = 1;
                for (DtoBandejaSIGED bandeja : this.empleadoNuevaBandeja.getBandejas()) {
                    AsDetallesiged asDetallesiged = new AsDetallesiged();
                    asDetallesiged.getPk().setConceptoacceso(this.dw_1.getConceptoacceso());
                    asDetallesiged.getPk().setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                    asDetallesiged.getPk().setFechadesde(this.dw_1.getFecha());
                    asDetallesiged.getPk().setFechahasta(this.dw_1.getFechafin());
                    asDetallesiged.getPk().setSecuencia(new BigDecimal(linea));
                    asDetallesiged.setIdcargo(new BigDecimal(bandeja.getIdCargo()));
                    asDetallesiged.setIdarea(new BigDecimal(bandeja.getIdArea()));
                    asDetallesiged.setIdpersona(new BigDecimal(bandeja.getIdPersona()));
                    asDetallesiged.setEstado("S");
                    asDetallesiged.setIdempleadosia(bandeja.getIdPersonaSIA());
                    asDetallesiged.setUltimaFechaModif(new Date());
                    asDetallesiged.setUltimoUsuario(this.getUsuarioActual().getCodigoUsuario());
                    this.getFacAsistencia().getAsDetallesigedServicio().registrar((Object)asDetallesiged);
                    ++linea;
                }
            }
            if (this.dw_1.getConceptoacceso().equals("94")) {
                Integer linea = 1;
                for (DtoBandejaSIGED bandeja : this.empleadoNuevaBandeja.getBandejas()) {
                    AsDetallesiged asDetallesiged = new AsDetallesiged();
                    asDetallesiged.getPk().setConceptoacceso(this.dw_1.getConceptoacceso());
                    asDetallesiged.getPk().setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                    asDetallesiged.getPk().setFechadesde(this.dw_1.getFecha());
                    asDetallesiged.getPk().setFechahasta(this.dw_1.getFechafin());
                    asDetallesiged.getPk().setSecuencia(new BigDecimal(linea));
                    asDetallesiged.setIdcargo(new BigDecimal(bandeja.getIdCargo()));
                    asDetallesiged.setIdarea(new BigDecimal(bandeja.getIdArea()));
                    asDetallesiged.setIdpersona(new BigDecimal(bandeja.getIdPersona()));
                    Empleadomast emp = this.getFacCore().getEmpleadomastServicio().obtenerEmpleadoMast(Integer.valueOf(bandeja.getIdPersonaSIA().intValue()));
                    DtoEmpleadoSIGED obj = this.obtenerBandejasPorEmpleado(emp.getCodigousuario(), true);
                    asDetallesiged.setIdpersona2(this.obtenerIdPersonaHijoBandeja(obj.getBandejas(), new BigDecimal(bandeja.getIdArea()), bandeja.getIdCargoaux()));
                    if (bandeja.getBlJefe()) {
                        asDetallesiged.setFlgjefe("S");
                        asDetallesiged.setIdpersona3(new BigDecimal(bandeja.getIdPersonaaux()));
                    }
                    asDetallesiged.setEstado("S");
                    asDetallesiged.setIdempleadosia(bandeja.getIdPersonaSIA());
                    asDetallesiged.setUltimaFechaModif(new Date());
                    asDetallesiged.setUltimoUsuario(this.getUsuarioActual().getCodigoUsuario());
                    this.getFacAsistencia().getAsDetallesigedServicio().registrar((Object)asDetallesiged);
                    ++linea;
                }
            }
            if (this.dw_1.getConceptoacceso().equals("96")) {
                AsDetallesiged asDetallesiged2 = new AsDetallesiged();
                asDetallesiged2.getPk().setConceptoacceso(this.dw_1.getConceptoacceso());
                asDetallesiged2.getPk().setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                asDetallesiged2.getPk().setFechadesde(this.dw_1.getFecha());
                asDetallesiged2.getPk().setFechahasta(this.dw_1.getFechafin());
                asDetallesiged2.getPk().setSecuencia(new BigDecimal(1));
                asDetallesiged2.setEstado("S");
                asDetallesiged2.setIdcargo(this.nuevaBandeja.getIdCargoSIGED());
                asDetallesiged2.setIdarea(this.nuevaBandeja.getIdAreaSIGED());
                asDetallesiged2.setIdpersona(new BigDecimal(this.empleadoNuevaBandeja.getIdPersona()));
                asDetallesiged2.setUltimaFechaModif(new Date());
                asDetallesiged2.setUltimoUsuario(this.getUsuarioActual().getCodigoUsuario());
                this.getFacAsistencia().getAsDetallesigedServicio().registrar((Object)asDetallesiged2);
            }
            if (this.dw_1.getConceptoacceso().equals("98")) {
                Integer linea = 1;
                for (DtoPerfilSIGED perfil : this.listaPerfilesSIGED) {
                    if (perfil.getPerfilSeleccionado() && !perfil.getPerfilSeleccionadoLectura()) {
                        AsDetallesiged asDetallesiged = new AsDetallesiged();
                        asDetallesiged.getPk().setConceptoacceso(this.dw_1.getConceptoacceso());
                        asDetallesiged.getPk().setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                        asDetallesiged.getPk().setFechadesde(this.dw_1.getFecha());
                        asDetallesiged.getPk().setFechahasta(((boolean)this.opciones.getIsmostrarfechafin()) ? this.dw_1.getFechafin() : this.dw_1.getFecha());
                        asDetallesiged.getPk().setSecuencia(new BigDecimal(linea));
                        asDetallesiged.setEstado("S");
                        asDetallesiged.setIdpersona(new BigDecimal(this.empleadoNuevaBandeja.getIdPersona()));
                        asDetallesiged.setIdperfil(new BigDecimal(perfil.getIdPerfil()));
                        asDetallesiged.setUltimaFechaModif(new Date());
                        asDetallesiged.setUltimoUsuario(this.getUsuarioActual().getCodigoUsuario());
                        this.getFacAsistencia().getAsDetallesigedServicio().registrar((Object)asDetallesiged);
                        ++linea;
                    }
                }
            }
            if (this.dw_1.getConceptoacceso().equals("xx")) {
                AsDetallesiged asDetallesiged2 = new AsDetallesiged();
                asDetallesiged2.getPk().setConceptoacceso(this.dw_1.getConceptoacceso());
                asDetallesiged2.getPk().setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                asDetallesiged2.getPk().setFechadesde(this.dw_1.getFecha());
                asDetallesiged2.getPk().setFechahasta(this.dw_1.getFechafin());
                asDetallesiged2.getPk().setSecuencia(new BigDecimal(1));
                asDetallesiged2.setEstado("S");
                asDetallesiged2.setIdcargo(this.nuevaBandeja.getIdCargoSIGED());
                asDetallesiged2.setIdarea(this.nuevaBandeja.getIdAreaSIGED());
                asDetallesiged2.setIdpersona(new BigDecimal(this.empleadoNuevaBandeja.getIdPersona()));
                asDetallesiged2.setFlgjefe("S");
                asDetallesiged2.setUltimaFechaModif(new Date());
                asDetallesiged2.setUltimoUsuario(this.getUsuarioActual().getCodigoUsuario());
                this.getFacAsistencia().getAsDetallesigedServicio().registrar((Object)asDetallesiged2);
            }
            if (this.dw_1.getConceptoacceso().equals("99")) {
                AsDetallesiged asDetallesiged2 = new AsDetallesiged();
                asDetallesiged2.getPk().setConceptoacceso(this.dw_1.getConceptoacceso());
                asDetallesiged2.getPk().setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                asDetallesiged2.getPk().setFechadesde(this.dw_1.getFecha());
                asDetallesiged2.getPk().setFechahasta(this.dw_1.getFechafin());
                asDetallesiged2.getPk().setSecuencia(new BigDecimal(1));
                asDetallesiged2.setEstado("A");
                asDetallesiged2.setIdcargo((BigDecimal)null);
                asDetallesiged2.setIdarea(this.nuevaBandeja.getIdAreaSIGED());
                DtoDwAsEmpleadoSelectMultiple asEmpleadoSelectMultiple = this.obtenerEmpleadoRolAsistenteSiged();
                DtoEmpleadoSIGED dtoEmpleadoSIGED = this.obtenerDetallePorEmpleadoSIA(asEmpleadoSelectMultiple.getCodigoUsuarioEmpleado());
                asDetallesiged2.setIdpersona(this.obtenerIdPersonaHijoBandeja(dtoEmpleadoSIGED.getBandejas(), this.nuevaBandeja.getIdAreaSIGED(), this.idCargoSiged));
                asDetallesiged2.setIdempleadosia(asEmpleadoSelectMultiple.getPersona());
                asEmpleadoSelectMultiple = this.obtenerEmpleadoRolAsistentePermanenteSiged();
                if (!UValidador.estaVacio(asEmpleadoSelectMultiple.getCodigoUsuarioEmpleado())) {
                    dtoEmpleadoSIGED = this.obtenerDetallePorEmpleadoSIA(asEmpleadoSelectMultiple.getCodigoUsuarioEmpleado());
                    asDetallesiged2.setIdpersona2(this.obtenerIdPersonaHijoBandeja(dtoEmpleadoSIGED.getBandejas(), this.nuevaBandeja.getIdAreaSIGED(), this.idCargoSiged2));
                    asDetallesiged2.setIdempleadosia2(asEmpleadoSelectMultiple.getPersona());
                    asDetallesiged2.setFlgasistentepermanente("S");
                }
                else {
                    asDetallesiged2.setIdpersona2(new BigDecimal(this.empleadoAsistenteArea.getIdPersona()));
                }
                asDetallesiged2.setFlgestadosiged("N");
                asDetallesiged2.setFlgasistente("S");
                asDetallesiged2.setUltimaFechaModif(new Date());
                asDetallesiged2.setUltimoUsuario(this.getUsuarioActual().getCodigoUsuario());
                asDetallesiged2.setUltimaFechaModifSiged(new Date());
                asDetallesiged2.setUltimoUsuarioSiged("SYSTEM");
                this.getFacAsistencia().getAsDetallesigedServicio().registrar((Object)asDetallesiged2);
            }
        }
    }
    
    private BigDecimal obtenerIdPersonaHijoBandeja(List<DtoBandejaSIGED> bandejas, BigDecimal idArea, BigDecimal idCargo) {
        BigDecimal retorno = null;
        if (!UValidador.esNulo((Object)bandejas)) {
            for (DtoBandejaSIGED obj : bandejas) {
                if (obj.getIdArea() == idArea.intValue() && obj.getIdCargo() == idCargo.intValue()) {
                    retorno = new BigDecimal(obj.getIdPersona());
                    break;
                }
            }
        }
        return retorno;
    }
    
    private void eliminarSIGED(Date w_fechaDesde, Date w_fechahasta, String concepto) {
        if (this.dw_1.getCategoriaautorizacion().equals("PSIG")) {
            if (this.dw_1.getConceptoacceso().equals("95") || this.dw_1.getConceptoacceso().equals("94") || this.dw_1.getConceptoacceso().equals("97")) {
                this.empleadoNuevaBandeja = this.getFacAsistencia().getAsDetallesigedServicio().obtenerBandejas(this.empleadoNuevaBandeja, this.dw_1);
                for (DtoBandejaSIGED bandeja : this.empleadoNuevaBandeja.getBandejas()) {
                    AsDetallesigedPk pk = new AsDetallesigedPk();
                    pk.setConceptoacceso(concepto);
                    pk.setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                    pk.setFechadesde(w_fechaDesde);
                    pk.setFechahasta(w_fechahasta);
                    pk.setSecuencia(bandeja.getSecuencia());
                    AsDetallesiged asDetallesiged = (AsDetallesiged)this.getFacAsistencia().getAsDetallesigedServicio().obtenerPorId((Serializable)pk, false);
                    if (!UValidador.esNulo((Object)asDetallesiged)) {
                        this.getFacAsistencia().getAsDetallesigedServicio().eliminar((Object)asDetallesiged);
                    }
                }
            }
            if (this.dw_1.getConceptoacceso().equals("98")) {
                try {
                    this.listaPerfilesSIGED = this.obtenerPerfilesSIGED();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                for (DtoPerfilSIGED perfiles : this.listaPerfilesSIGED) {
                    AsDetallesigedPk pk = new AsDetallesigedPk();
                    pk.setConceptoacceso(concepto);
                    pk.setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                    pk.setFechadesde(w_fechaDesde);
                    pk.setFechahasta(((boolean)this.opciones.getIsmostrarfechafin()) ? w_fechahasta : w_fechaDesde);
                    pk.setSecuencia(perfiles.getSecuencia());
                    AsDetallesiged asDetallesiged = (AsDetallesiged)this.getFacAsistencia().getAsDetallesigedServicio().obtenerPorId((Serializable)pk, false);
                    if (!UValidador.esNulo((Object)asDetallesiged)) {
                        this.getFacAsistencia().getAsDetallesigedServicio().eliminar((Object)asDetallesiged);
                    }
                }
            }
            if (this.dw_1.getConceptoacceso().equals("96")) {
                try {
                    this.obtenerNuevasBandejas();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                AsDetallesigedPk pk2 = new AsDetallesigedPk();
                pk2.setConceptoacceso(concepto);
                pk2.setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                pk2.setFechadesde(w_fechaDesde);
                pk2.setFechahasta(w_fechahasta);
                pk2.setSecuencia(this.nuevaBandeja.getSecuencia());
                AsDetallesiged asDetallesiged2 = (AsDetallesiged)this.getFacAsistencia().getAsDetallesigedServicio().obtenerPorId((Serializable)pk2, false);
                if (!UValidador.esNulo((Object)asDetallesiged2)) {
                    this.getFacAsistencia().getAsDetallesigedServicio().eliminar((Object)asDetallesiged2);
                }
            }
            if (this.dw_1.getConceptoacceso().equals("xx")) {
                AsDetallesigedPk pk2 = new AsDetallesigedPk();
                pk2.setConceptoacceso(concepto);
                pk2.setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                pk2.setFechadesde(w_fechaDesde);
                pk2.setFechahasta(w_fechahasta);
                pk2.setSecuencia(BigDecimal.ONE);
                AsDetallesiged asDetallesiged2 = (AsDetallesiged)this.getFacAsistencia().getAsDetallesigedServicio().obtenerPorId((Serializable)pk2, false);
                if (!UValidador.esNulo((Object)asDetallesiged2)) {
                    this.getFacAsistencia().getAsDetallesigedServicio().eliminar((Object)asDetallesiged2);
                }
            }
            if (this.dw_1.getConceptoacceso().equals("99")) {
                AsDetallesigedPk pk2 = new AsDetallesigedPk();
                pk2.setConceptoacceso(concepto);
                pk2.setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                pk2.setFechadesde(w_fechaDesde);
                pk2.setFechahasta(w_fechahasta);
                pk2.setSecuencia(BigDecimal.ONE);
                AsDetallesiged asDetallesiged2 = (AsDetallesiged)this.getFacAsistencia().getAsDetallesigedServicio().obtenerPorId((Serializable)pk2, false);
                if (!UValidador.esNulo((Object)asDetallesiged2)) {
                    this.getFacAsistencia().getAsDetallesigedServicio().eliminar((Object)asDetallesiged2);
                }
            }
        }
    }
    
    private void eliminarAlfresco() {
        String obtenerParametroModoArchivo;
        switch (obtenerParametroModoArchivo = this.obtenerParametroModoArchivo()) {
            case "AL": {
                if (UValidador.estaVacio(this.key) || UValidador.estaVacio(this.ws)) {
                    this.setMessageError("No se encontraron los parametros key o ws");
                    return;
                }
                if (!UValidador.estaVacio(this.dw_1.getUuidalfresco())) {
                    try {
                        ContenidoECMBean respuestaconsulta = UOefaAlfresco.obtenerDocumento(this.dw_1.getUuidalfresco(), this.key);
                        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)respuestaconsulta);
                        if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
                            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)"Se encontro el archivo");
                            UOefaAlfresco.eliminarDocumento(this.dw_1.getUuidalfresco(), this.key);
                            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)"Se elimino el archivo");
                        }
                    }
                    catch (Exception e) {
                        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)e.getMessage());
                        this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
                        return;
                    }
                    break;
                }
                break;
            }
            default:
                break;
        }
    }
    
    private BigDecimal wf_diftiempo(Date par_fechainicio, Date par_fechafin) {
        Integer w_segundos = UFechaHora.obtenerSegundosTranscurridos(par_fechafin, par_fechainicio);
        Integer w_dias = UFechaHora.obtenerDiasTranscurridos(par_fechafin, par_fechainicio);
        w_segundos += w_dias * 3600 * 24;
        return BigDecimal.valueOf(w_segundos);
    }
    
    private Integer dwhorarioupdate() throws Exception {
        if (!UValidador.esListaVacia((List)this.dw_horario)) {
            List<AsEmpleadoexcepcionsolicitud> horarios = (List<AsEmpleadoexcepcionsolicitud>)this.getFacAsistencia().getAsEmpleadoexcepcionsolicitudServicio().listarEmpleadoExcepcionSolicitud(this.dw_horario.get(0).getEmpleado(), this.dw_horario.get(0).getFechasolicitud());
            if (!UValidador.esListaVacia((List)horarios)) {
                for (AsEmpleadoexcepcionsolicitud objdel : horarios) {
                    this.getFacAsistencia().getAsEmpleadoexcepcionsolicitudServicio().eliminar((Object)objdel);
                }
            }
            for (DtoDwCambioHorarioExcepcion obj : this.dw_horario) {
                AsEmpleadoexcepcionsolicitud solicitud = new AsEmpleadoexcepcionsolicitud();
                solicitud.getPk().setEmpleado(obj.getEmpleado());
                solicitud.getPk().setFechasolicitud(UFechaHora.convertirCadenaFecha(UFechaHora.convertirFechaCadena(obj.getFechasolicitud()), "dd/MM/yyyy"));
                solicitud.getPk().setFecha(obj.getFecha());
                solicitud.getPk().setFechahasta(obj.getFechahasta());
                solicitud.setDescripcion(obj.getDescripcion());
                solicitud.setIntervaloacceso(obj.getIntervaloacceso());
                solicitud.setTipodia(Integer.valueOf(obj.getTipodia().intValue()));
                solicitud.setEstado(obj.getEstado());
                solicitud.setUltimoUsuario(this.getUsuarioActual().getLoginUsuario().toUpperCase());
                solicitud.setUltimaFechaModif(new Date());
                this.getFacAsistencia().getAsEmpleadoexcepcionsolicitudServicio().registrar((Object)solicitud);
            }
        }
        if (CwAsAutorizacionPreprocesoAprobacionSIGED.getInstance().getFlagOrigenSolicitud().equals("A") && this.dw_1.getEstado().equals("A")) {
            this.guardarEmpleadoExcepcion();
        }
        return 0;
    }
    
    private boolean wf_actualiza_blob(Integer par_empleado, Date par_fecha, String par_concepto, Date par_desde) {
        AsAutorizacionPk pk = new AsAutorizacionPk();
        pk.setEmpleado(BigDecimal.valueOf(par_empleado));
        pk.setFecha(par_fecha);
        pk.setDesde(par_desde);
        pk.setConceptoacceso(par_concepto);
        AsAutorizacion registro = (AsAutorizacion)this.getFacAsistencia().getAsAutorizacionServicio().obtenerPorId((Serializable)pk, false);
        if (!UValidador.esNulo((Object)registro)) {
            String obtenerParametroModoArchivo;
            switch (obtenerParametroModoArchivo = this.obtenerParametroModoArchivo()) {
                case "AL": {
                    if (UValidador.estaVacio(this.key) || UValidador.estaVacio(this.ws)) {
                        this.setMessageError("No se encontraron los parametros key o ws");
                        return false;
                    }
                    if (!UValidador.estaVacio(registro.getUuidalfresco())) {
                        try {
                            if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
                                ContenidoECMBean respuestaconsulta = UOefaAlfresco.obtenerDocumento(registro.getUuidalfresco(), this.key);
                                CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)respuestaconsulta);
                                if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
                                    CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)"Se encontro el archivo");
                                    UOefaAlfresco.eliminarDocumento(registro.getUuidalfresco(), this.key);
                                    CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)"Se elimino el archivo");
                                }
                            }
                        }
                        catch (Exception e) {
                            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)e.getMessage());
                            this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
                            return false;
                        }
                    }
                    if (!UValidador.estaVacio(registro.getRutadocumento())) {
                        try {
                            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("Archivo a guardar " + registro.getRutadocumento()));
                            RptaWsBean respuestaws = UOefaAlfresco.registrarDocumento(registro.getRutadocumento(), "WEB/SOLICITUD_ASISTENCIA/" + registro.getPk().getEmpleado() + "/" + "SUSTENTO", UFile.obtenerArregloByte(this.dw_1.getRutacompleta()), this.key);
                            System.gc();
                            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)respuestaws);
                            if (respuestaws.getCodMsg().equalsIgnoreCase("ok")) {
                                registro.setUuidalfresco(respuestaws.getUuid());
                                this.getFacAsistencia().getAsAutorizacionServicio().actualizar((Object)registro);
                                return true;
                            }
                            this.setMessageError(respuestaws.getCadMsg());
                            return false;
                        }
                        catch (Exception e) {
                            if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
                                this.eliminarPorErrorEnArchivo();
                            }
                            this.setMessageError("Ocurri\u00f3 un error al grabar el archivo. Por favor revisar el nombre del documento");
                            return false;
                        }
                    }
                    break;
                }
                default:
                    break;
            }
            return true;
        }
        this.setMessageError("No se encontr\u00f3 la solicitud para actualizar el documento");
        return false;
    }
    
    private boolean wf_actualiza_blob_dj(Integer par_empleado, Date par_fecha, String par_concepto, Date par_desde) {
        AsAutorizacionPk pk = new AsAutorizacionPk();
        pk.setEmpleado(BigDecimal.valueOf(par_empleado));
        pk.setFecha(par_fecha);
        pk.setDesde(par_desde);
        pk.setConceptoacceso(par_concepto);
        AsAutorizacion registro = (AsAutorizacion)this.getFacAsistencia().getAsAutorizacionServicio().obtenerPorId((Serializable)pk, false);
        if (!UValidador.esNulo((Object)registro)) {
            String obtenerParametroModoArchivo;
            switch (obtenerParametroModoArchivo = this.obtenerParametroModoArchivo()) {
                case "AL": {
                    if (UValidador.estaVacio(this.key) || UValidador.estaVacio(this.ws)) {
                        this.setMessageError("No se encontraron los parametros key o ws");
                        return false;
                    }
                    if (!UValidador.estaVacio(registro.getUuiddj())) {
                        try {
                            ContenidoECMBean respuestaconsulta = UOefaAlfresco.obtenerDocumento(registro.getUuiddj(), this.key);
                            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)respuestaconsulta);
                            if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
                                CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)"Se encontro el archivo");
                                UOefaAlfresco.eliminarDocumento(registro.getUuiddj(), this.key);
                                CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)"Se elimino el archivo");
                            }
                        }
                        catch (Exception e) {
                            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)e.getMessage());
                            this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
                            return false;
                        }
                    }
                    if (!UValidador.estaVacio(registro.getNombrearchivodj())) {
                        try {
                            RptaWsBean respuestaws = UOefaAlfresco.registrarDocumento(registro.getNombrearchivodj(), "WEB/SOLICITUD_ASISTENCIA/" + registro.getPk().getEmpleado() + "/" + "SUSTENTO_DJ", UFile.obtenerArregloByte(this.dw_1.getRutacompletadj()), this.key);
                            System.gc();
                            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)respuestaws);
                            if (respuestaws.getCodMsg().equalsIgnoreCase("ok")) {
                                registro.setUuiddj(respuestaws.getUuid());
                                return true;
                            }
                            this.setMessageError(respuestaws.getCadMsg());
                            return false;
                        }
                        catch (Exception e) {
                            this.setMessageError("Ocurri\u00f3 un error al grabar el archivo. Por favor revisar el nombre del documento");
                            return false;
                        }
                    }
                    break;
                }
                default:
                    break;
            }
            this.getFacAsistencia().getAsAutorizacionServicio().actualizar((Object)registro);
            return true;
        }
        this.setMessageError("No se encontr\u00f3 la solicitud para actualizar el documento");
        return false;
    }
    
    private String obtenerParametroModoArchivo() {
        String modo = "BD";
        ParametrosmastPk pk = new ParametrosmastPk("HR", "999999", "MODOARCHIV");
        String param = this.getFacCore().getParametrosmastServicio().obtenerValorCadena(pk);
        if (!UValidador.estaVacio(param)) {
            modo = param;
        }
        else {
            this.setMessageInfo("No se encontr\u00f3 el par\u00e1metro MODOARCHIV. Se tom\u00f3 valor por defecto");
        }
        this.key = this.getFacCore().getParametrosmastServicio().obtenerValorExplicacion(new ParametrosmastPk("SP", "999999", "KEYALFRESC"));
        this.ws = this.getFacCore().getParametrosmastServicio().obtenerValorExplicacion(new ParametrosmastPk("SP", "999999", "WSALFRESCO"));
        return modo;
    }
    
    private void wf_Insertar_Marca(Integer par_empleado, Date par_fecha, String par_aprobador) {
        Integer anio = UFechaHora.obtenerFechaParte(par_fecha, "YY");
        Integer mes = UFechaHora.obtenerFechaParte(par_fecha, "MM");
        Integer dia = UFechaHora.obtenerFechaParte(par_fecha, "DD");
        String observacion = "V\u00eda Autorizaci\u00f3n";
        Integer secuencia = this.getFacAsistencia().getAsAccesosdiariosServicio().obtenerMaximoSecuencia(par_empleado, par_fecha);
        String carnet = this.getFacAsistencia().getAsCarnetidentificacionServicio().obtenerMaximoCodigoCarnet(par_empleado);
        this.getFacAsistencia().getAsAccesosdiariosServicio().insertarAccesosDiarios(carnet, par_fecha, secuencia, par_empleado, observacion, anio, mes, dia, this.getUsuarioActual().getLoginUsuario().toUpperCase());
    }
    
    private Integer wf_before_update_new() {
        return 1;
    }
    
    private Integer wf_before_update() throws Exception {
        return 1;
    }
    
    public String salir() throws Exception {
        CwAsAutorizacionPreprocesoAprobacionSIGED.getInstance().iniciarControladora();
        return "wasautorizacionpreprocesoaprobacionSIGED";
    }
    
    private boolean validacionesSIGED() throws Exception {
        Boolean retorno = true;
        if (this.dw_1.getCategoriaautorizacion().equals("PSIG")) {
            if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
                this.count = this.getFacAsistencia().getAsAutorizacionServicio().contarPermisosSIGED(this.dw_1.getEmpleado(), this.dw_1.getConceptoacceso());
                if (this.count > 0) {
                    this.setMessageError("Existen permisos en estado solicitado para este tipo de concepto.");
                    retorno = false;
                }
            }
            if (this.dw_1.getConceptoacceso().equals("95") || this.dw_1.getConceptoacceso().equals("94") || this.dw_1.getConceptoacceso().equals("97")) {
                for (DtoBandejaSIGED bandeja : this.empleadoNuevaBandeja.getBandejas()) {
                    if (UValidador.esNulo((Object)bandeja.getIdPersonaSIA())) {
                        this.setMessageError("En el Area :" + bandeja.getArea() + " Con el Cargo: " + bandeja.getCargo() + " Es obligatorio ingresar un responsable.");
                        retorno = false;
                    }
                    else {
                        if (this.dw_1.getConceptoacceso().equals("94") && bandeja.getBlJefe() && bandeja.getIdCargoaux() == null) {
                            this.setMessageError("En el Area :" + bandeja.getArea() + " Con el Cargo: " + bandeja.getCargo() + " el colaborador seleccionado no tiene cargos en el area");
                            retorno = false;
                        }
                        this.count = this.getFacAsistencia().getAsAutorizacionServicio().contarvalidalicenciasempleado(Integer.valueOf(bandeja.getIdPersonaSIA().intValue()), this.dw_1.getFecha(), ((boolean)this.opciones.getIsmostrarfechafin()) ? this.dw_1.getFechafin() : this.dw_1.getFecha());
                        if (this.count > 0) {
                            this.setMessageError("En el Area :" + bandeja.getArea() + " Con el Cargo: " + bandeja.getCargo() + " El Empleado se encuentra de Licencia en las fechas indicadas.");
                            retorno = false;
                        }
                        Integer periodomax = this.getFacAsistencia().getAsAutorizacionServicio().contarmaximoperiodovacaciones(this.dw_1.getEmpleado());
                        this.count = this.getFacAsistencia().getAsAutorizacionServicio().contarvalidavacacionesempleado(Integer.valueOf(bandeja.getIdPersonaSIA().intValue()), this.dw_1.getFecha(), ((boolean)this.opciones.getIsmostrarfechafin()) ? this.dw_1.getFechafin() : this.dw_1.getFecha(), periodomax);
                        if (this.count <= 0) {
                            continue;
                        }
                        this.setMessageError("En el Area :" + bandeja.getArea() + " Con el Cargo: " + bandeja.getCargo() + " El Empleado se encuentra de vacaciones en las fechas indicadas.");
                        retorno = false;
                    }
                }
            }
            if (this.dw_1.getConceptoacceso().equals("98")) {
                boolean sel = false;
                for (DtoPerfilSIGED perfil : this.listaPerfilesSIGED) {
                    if (perfil.getPerfilSeleccionado() && !perfil.getPerfilSeleccionadoLectura()) {
                        sel = true;
                    }
                }
                if (!sel) {
                    this.setMessageError("Debe seleccionar al menos un perfil Siged");
                    retorno = false;
                }
            }
            if (this.dw_1.getConceptoacceso().equals("xx") && !this.empleadoNuevaBandeja.getBljefe() && !this.empleadoNuevaBandeja.getBlasistente()) {
                this.setMessageError("Debe seleccionar al menos un rol Siged");
                retorno = false;
            }
            if (this.dw_1.getConceptoacceso().equals("99")) {
                if (UValidador.esNulo((Object)this.obtenerEmpleadoRolAsistenteSiged().getPersona())) {
                    this.setMessageError("Debe seleccionar un empleado para rol asistente Siged");
                    retorno = false;
                }
                if (UValidador.esNulo((Object)this.idCargoSiged)) {
                    this.setMessageError("El colaborador asignado como asistente no tiene cargos en el area Siged seleecionada");
                    retorno = false;
                }
            }
        }
        return retorno;
    }
    
    public Boolean validar() throws Exception {
        this.ll_horasprac = 0;
        this.dw_1.setFechafin(UFechaHora.obtenerFechaHoraFinDia(this.dw_1.getFechafin()));
        this.dw_feriados = (List<DtoDwMaPrCalendarioferiadosProcesoSarg>)this.getFacAsistencia().getAS().getAsmainDatawindow().DwMaPrCalendarioferiadosProcesoSarg();
        this.w_CategoriaAutorizacion = this.dw_1.getCategoriaautorizacion();
        if (UValidador.esNulo((Object)this.dw_1.getEmpleado())) {
            this.setMessageError("Primero debe seleccionar un empleado");
            return false;
        }
        if (UValidador.estaVacio(this.dw_1.getCategoriaautorizacion())) {
            this.setMessageError("Debe ingresar un evento");
            return false;
        }
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add") || CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
            Integer count = 0;
            if (this.dw_1.getConceptoacceso().equals("OMIS")) {
                Integer maxPermitido = 0;
                maxPermitido = this.getFacCore().getParametrosmastServicio().obtenerValorInteger(new ParametrosmastPk("AS", "999999", "NVECMAXOMI"));
                if (UValidador.esNulo((Object)maxPermitido)) {
                    maxPermitido = 0;
                }
                Integer cantOmision = this.getFacAsistencia().getAsAutorizacionServicio().contarOmisionxMes(this.dw_1.getEmpleado(), this.dw_1.getFecha());
                if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add") && cantOmision + 1 > maxPermitido) {
                    this.setMessageError("La cantidad de veces de Omisi\u00f3n del Mes esta superando la cantidad m\u00e1xima: " + maxPermitido);
                    return false;
                }
                if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
                    if (this.dw_1.getFecha().getTime() != this.fechaoriginal.getTime()) {
                        ++cantOmision;
                    }
                    if (cantOmision > maxPermitido) {
                        this.setMessageError("La cantidad de veces de Omisi\u00f3n del Mes esta superando la cantidad m\u00e1xima: " + maxPermitido);
                        return false;
                    }
                }
            }
            int cantmaxima = 0;
            int cantregistra = 0;
            for (DtoDddwAsConceptoaccesoSelectPre obj : this.dwc_ConceptoAcceso) {
                if (obj.getConceptoacceso().equals(this.dw_1.getConceptoacceso())) {
                    cantmaxima = obj.getCantmaxanio().intValue();
                    break;
                }
            }
            cantregistra = this.getFacAsistencia().getAsAutorizacionServicio().contarCantidadEnfechasPorConcepto(this.dw_1.getEmpleado(), this.dw_1.getConceptoacceso(), UFechaHora.obtenerPrimerDiaAnioFecha(this.dw_1.getFecha()), UFechaHora.obtenerUltimoDiaAnioFecha(this.dw_1.getFechafin()), this.fechaoriginal);
            ++cantregistra;
            if (!UValidador.esCero(Integer.valueOf(cantmaxima)) && cantregistra > cantmaxima) {
                this.setMessageError("No puede generar esta papeleta por que superar\u00eda la cantidad m\u00e1xima permitida por a\u00f1o: " + cantmaxima);
                return false;
            }
            if (!"94".equals(this.dw_1.getConceptoacceso()) && !"95".equals(this.dw_1.getConceptoacceso()) && !"99".equals(this.dw_1.getConceptoacceso()) && !"97".equals(this.dw_1.getConceptoacceso())) {
                count = this.getFacAsistencia().getAsAutorizacionServicio().contarvalidalicenciasempleado(this.dw_1.getEmpleado(), this.dw_1.getFecha(), ((boolean)this.opciones.getIsmostrarfechafin()) ? this.dw_1.getFechafin() : this.dw_1.getFecha());
                if (count > 0) {
                    this.setMessageError("El Empleado se encuentra de Licencia en las fechas indicadas.");
                    return false;
                }
                Integer periodomax = this.getFacAsistencia().getAsAutorizacionServicio().contarmaximoperiodovacaciones(this.dw_1.getEmpleado());
                count = this.getFacAsistencia().getAsAutorizacionServicio().contarvalidavacacionesempleado(this.dw_1.getEmpleado(), this.dw_1.getFecha(), ((boolean)this.opciones.getIsmostrarfechafin()) ? this.dw_1.getFechafin() : this.dw_1.getFecha(), periodomax);
                if (count > 0) {
                    this.setMessageError("El Empleado se encuentra de vacaciones en las fechas indicadas.");
                    return false;
                }
            }
            else if ("97".equals(this.dw_1.getConceptoacceso()) && !this.estadoEmpleado.equals("2")) {
                count = this.getFacAsistencia().getAsAutorizacionServicio().contarvalidalicenciasempleado(this.dw_1.getEmpleado(), new Date(), new Date());
                if (count == 0) {
                    Integer periodomax = this.getFacAsistencia().getAsAutorizacionServicio().contarmaximoperiodovacaciones(this.dw_1.getEmpleado());
                    count = this.getFacAsistencia().getAsAutorizacionServicio().contarvalidavacacionesempleado(this.dw_1.getEmpleado(), new Date(), new Date(), periodomax);
                    if (count == 0) {
                        this.setMessageError("El Empleado no se encuentra de vacaciones ni de licencia.");
                        return false;
                    }
                }
            }
        }
        String valpapehoy = this.getFacCore().getParametrosmastServicio().obtenerValorCadena(new ParametrosmastPk("AS", "999999", "VALPAPEHOY"));
        if (UValidador.esNulo((Object)valpapehoy)) {
            valpapehoy = "N";
        }
        if (!this.getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(this.getUsuarioActual().getAplicacionCodigo(), this.getUsuarioActual().getCodigoUsuario()) && valpapehoy.equals("S")) {
            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("dw_1.getConceptoacceso() " + this.dw_1.getConceptoacceso()));
            AsConceptoaccesoPk pkfind = new AsConceptoaccesoPk();
            pkfind.setConceptoacceso(this.dw_1.getConceptoacceso());
            AsConceptoacceso objfind = (AsConceptoacceso)this.getFacAsistencia().getAsConceptoaccesoServicio().obtenerPorId((Serializable)pkfind, false);
            if (!UValidador.esNulo((Object)objfind)) {
                if (objfind.getFlagtopedias().equals("N") && objfind.getFlagfechainferior().equals("N") && !objfind.getPk().getConceptoacceso().equals("OMIS")) {
                    if ((new Date().after(UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), ((boolean)this.opciones.getIsmostrardesde1()) ? this.dw_1.getDesde1() : UFechaHora.obtenerFechaHoraFinDia(new Date()))) && !this.dw_1.getCategoriaautorizacion().equals("SOBR")) || (new Date().after(UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), UFechaHora.obtenerFechaHoraFinDia(new Date()))) && (this.dw_1.getCategoriaautorizacion().equals("SOBR") || this.dw_1.getCategoriaautorizacion().equals("VACA")))) {
                        this.w_mensaje = "";
                        if (this.w_CategoriaAutorizacion.equals("COMP")) {
                            this.w_mensaje = "una Compensaci\u00f3n de Sobretiempo";
                        }
                        if (this.w_CategoriaAutorizacion.equals("OMIS")) {
                            this.w_mensaje = "una Omisi\u00f3n de Marcado";
                        }
                        if (this.w_CategoriaAutorizacion.equals("SOBR")) {
                            this.w_mensaje = "una Autorizaci\u00f3n de Sobretiempo ";
                        }
                        if (this.w_CategoriaAutorizacion.equals("VACA")) {
                            this.w_mensaje = "Vacaciones ";
                        }
                        if (this.w_CategoriaAutorizacion.equals("OTRO")) {
                            this.w_mensaje = "un Permiso ";
                        }
                        this.setMessageError("No se puede realizar " + (UValidador.estaVacio(this.w_mensaje) ? ("una(s) " + objfind.getDescripcionlocal()) : this.w_mensaje) + " con una fecha y hora inferior a la actual.");
                        return false;
                    }
                }
                else if (objfind.getFlagtienetopediasfi().equals("S") && objfind.getFlagfechainferior().equals("S")) {
                    this.w_count = this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(this.dw_1.getFechafin(), new Date());
                    CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("w_count " + this.w_count));
                    if (this.w_count > objfind.getCantidadtopediasfi()) {
                        this.setMessageError("El m\u00e1ximo de d\u00edas para regularizar una papeleta de (" + objfind.getDescripcionlocal() + ") es " + objfind.getCantidadtopediasfi());
                        return false;
                    }
                }
            }
        }
        if (!this.validacionesSIGED()) {
            return false;
        }
        if (this.dw_1.getConceptoacceso().equals("VACA") && !this.validarVacaciones()) {
            return false;
        }
        if ("ADEL".equals(this.dw_1.getConceptoacceso()) && !this.validarAdelantoVacaciones()) {
            return false;
        }
        if ("FRAD".equals(this.dw_1.getConceptoacceso()) && !this.validarFraccionamientoDiaVacaciones()) {
            return false;
        }
        if ("FRAH".equals(this.dw_1.getConceptoacceso()) && !this.validarFraccionamientoHoraVacaciones()) {
            return false;
        }
        if (this.dw_1.getConceptoacceso().equals("CHOR") && UValidador.esListaVacia((List)this.dw_horario)) {
            this.setMessageError("Debe agregar las fechas del cambio de horario.");
            return false;
        }
        this.w_tipocontrato = "";
        if (!UValidador.esListaVacia((List)this.dw_horario)) {
            this.w_tipocontrato = this.getFacCore().getEmpleadomastServicio().obtenerTipoContrato(this.dw_1.getEmpleado());
            if (this.w_tipocontrato.equals("08")) {
                this.ll_horasprac = this.getFacCore().getParametrosmastServicio().obtenerValorInteger(new ParametrosmastPk("AS", "999999", "HORAPRAPRE"));
            }
            if (this.w_tipocontrato.equals("09")) {
                this.ll_horasprac = this.getFacCore().getParametrosmastServicio().obtenerValorInteger(new ParametrosmastPk("AS", "999999", "HORAPRAPRO"));
            }
            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("totalhorastrabajo " + this.totalhorastrabajo));
            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("ll_horasprac " + this.ll_horasprac));
            if (!UValidador.esCero(this.ll_horasprac) && !UValidador.esCero(Integer.valueOf(this.totalhorastrabajo.compareTo(BigDecimal.valueOf(this.ll_horasprac))))) {
                this.setMessageError("La cantidad de horas debe ser de " + this.ll_horasprac);
                return false;
            }
        }
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add") || CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
            this.ll_find = null;
            for (int i = 0; i < this.dwc_ConceptoAccesoFiltrado.size(); ++i) {
                if (this.dwc_ConceptoAccesoFiltrado.get(i).getConceptoacceso().equals(this.dw_1.getConceptoacceso())) {
                    this.ll_find = i;
                }
            }
            if (!UValidador.esNulo((Object)this.ll_find)) {
                DtoDddwAsConceptoaccesoSelectPre objfind2 = this.dwc_ConceptoAccesoFiltrado.get(this.ll_find);
                if ("S".equals(objfind2.getFlaghorasmaximo())) {
                    this.w_horainicio = UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), this.dw_1.getDesde1());
                    this.w_horafin = UFechaHora.obtenerFechaCompuesta(this.dw_1.getFechafin(), this.dw_1.getHasta1());
                    this.w_diftiempo = this.wf_diftiempo(this.w_horainicio, this.w_horafin).divide(BigDecimal.valueOf(3600L), 2, RoundingMode.HALF_DOWN);
                    this.w_diftiempo = this.w_diftiempo.subtract(this.obtenerHorasRefrigerio());
                    if (this.w_diftiempo.compareTo(objfind2.getCantidadhorasmaximo()) == 1) {
                        this.setMessageError("No puede asignar una papeleta mayor a " + objfind2.getCantidadhorasmaximo() + " horas para este concepto.");
                        return false;
                    }
                }
                if ("S".equals(objfind2.getFlaghorasminimo())) {
                    this.w_horainicio = UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), this.dw_1.getDesde1());
                    this.w_horafin = UFechaHora.obtenerFechaCompuesta(this.dw_1.getFechafin(), this.dw_1.getHasta1());
                    this.w_diftiempo = this.wf_diftiempo(this.w_horainicio, this.w_horafin).divide(BigDecimal.valueOf(3600L), 2, RoundingMode.HALF_DOWN);
                    this.w_diftiempo = this.w_diftiempo.subtract(this.obtenerHorasRefrigerio());
                    if (this.w_diftiempo.compareTo(objfind2.getCantidadhorasminimo()) == -1) {
                        this.setMessageError("No puede asignar una papeleta menor a " + objfind2.getCantidadhorasminimo() + " horas para este concepto.");
                        return false;
                    }
                }
                if ("S".equals(objfind2.getFlagminutosminimo())) {
                    this.w_horainicio = UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), this.dw_1.getDesde1());
                    this.w_horafin = UFechaHora.obtenerFechaCompuesta(this.dw_1.getFechafin(), this.dw_1.getHasta1());
                    this.w_diftiempo = this.wf_diftiempo(this.w_horainicio, this.w_horafin).divide(BigDecimal.valueOf(3600L), 2, RoundingMode.HALF_DOWN);
                    this.w_diftiempo = this.w_diftiempo.subtract(this.obtenerHorasRefrigerio());
                    if (this.w_diftiempo.compareTo(objfind2.getCantidadminutosminimo().divide(new BigDecimal(60.0), 2, RoundingMode.HALF_DOWN)) == -1) {
                        this.setMessageError("No puede asignar una papeleta menor a " + objfind2.getCantidadminutosminimo() + " minutos para este concepto.");
                        return false;
                    }
                }
                if (objfind2.getAnolimite().intValue() < UFechaHora.obtenerFechaParte(this.dw_1.getFecha(), "YY")) {
                    this.setMessageError("Este concepto s\u00f3lo estuvo vigente hasta el a\u00f1o " + objfind2.getAnolimite().intValue() + ", por favor cambiar la fecha de inicio.");
                    return false;
                }
                if (objfind2.getFlagarchivo().equals("S") && !"ADFR".equals(this.dw_1.getCategoriaautorizacion()) && UValidador.estaVacio(this.dw_1.getRutacompleta())) {
                    this.setMessageError("Debe adjuntar el archivo para poder grabar");
                    return false;
                }
            }
        }
        if (this.dw_1.getCategoriaautorizacion().equals("OMIS")) {
            this.dw_1.setConceptoacceso(this.conceptoOmisionMarcado);
            this.dw_1.setFechafin(UFechaHora.obtenerFechaHoraFinDia(this.dw_1.getFecha()));
        }
        if (this.dw_1.getCategoriaautorizacion().equals("CHOR")) {
            this.dw_1.setConceptoacceso(this.conceptoCambioHorario);
        }
        if (this.dw_1.getCategoriaautorizacion().equals("PMP")) {
            this.dw_1.setConceptoacceso(this.conceptoPermanenciaMotivoPersonal);
        }
        if (this.dw_1.getCategoriaautorizacion().equals("SOBR")) {
            this.dw_1.setConceptoacceso(this.conceptoAutorizacionSobretiempo);
        }
        this.conceptoacceso = this.dw_1.getConceptoacceso();
        if (this.dw_1.getFecha().after(this.dw_1.getFechafin())) {
            this.setMessageError("La fecha NO puede ser menor que la INICIAL");
            return false;
        }
        if (!this.validarCuponeras()) {
            return false;
        }
        if ("86".equals(this.dw_1.getConceptoacceso())) {
            if (!this.validarViernesVerano()) {
                return false;
            }
            this.dw_1.setDesderecupera(UFechaHora.anadirDiasAFechas(this.dw_1.getFecha(), 3));
            this.dw_1.setHastarecupera(UFechaHora.anadirDiasAFechas(this.dw_1.getFecha(), 6));
        }
        if (this.dw_1.getFecha().after(UFechaHora.obtenerFechaMasdias(new Date(), Integer.valueOf(365)))) {
            this.getWebControlContext().actualizar("dgAvisoSiNo");
            this.getWebControlContext().ejecutar("PF('popAvisoSiNo').show()");
            this.validarfechas = false;
            return false;
        }
        if (this.dw_1.getFechafin().after(UFechaHora.obtenerFechaMasdias(new Date(), Integer.valueOf(365)))) {
            this.getWebControlContext().actualizar("dgAvisoSiNo");
            this.getWebControlContext().ejecutar("PF('popAvisoSiNo').show()");
            this.validarfechas = false;
            return false;
        }
        return this.validarDespuesdeFechas();
    }
    
    private boolean validarViernesVerano() throws Exception {
        Date fechaHasta = null;
        for (DtoDddwAsConceptoaccesoSelectPre obj : this.dwc_ConceptoAcceso) {
            if (obj.getConceptoacceso().equals(this.dw_1.getConceptoacceso())) {
                fechaHasta = obj.getFechaLimite();
                break;
            }
        }
        if (UFechaHora.obtenerNumeroDiaSemana(this.dw_1.getFecha()) != 6) {
            this.setMessageError("El permiso de Viernes de verano, es aplicable para los d\u00edas viernes");
            return false;
        }
        if (fechaHasta != null && this.dw_1.getFecha().getTime() > fechaHasta.getTime()) {
            this.setMessageError("El permiso de Viernes de verano, tiene vigencia hasta el " + UFechaHora.convertirFechaCadena(fechaHasta, "dd/MM/yyyy"));
            return false;
        }
        return true;
    }
    
    private boolean validarCuponeras() throws Exception {
        AsConceptoacceso asConceptoacceso = (AsConceptoacceso)this.getFacAsistencia().getAsConceptoaccesoServicio().obtenerPorId((Serializable)new AsConceptoaccesoPk(this.dw_1.getConceptoacceso()));
        if (!UValidador.esNulo((Object)asConceptoacceso)) {
            if ("S".equals(asConceptoacceso.getFlagdiasanticipacion())) {
                Integer diasHabiles = this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(new Date(), this.dw_1.getFecha());
                if (diasHabiles < asConceptoacceso.getDiasanticipacion().intValue()) {
                    this.setMessageError("Para solicitar " + asConceptoacceso.getDescripcionlocal() + " estas deben generarse con " + asConceptoacceso.getDiasanticipacion().intValue() + " d\u00edas h\u00e1biles de anticipaci\u00f3n.");
                    return false;
                }
            }
            if ("S".equals(asConceptoacceso.getFlagticket())) {
                int cant = this.getFacAsistencia().getAsAutorizacionServicio().contarEnfechasPorTicket(this.dw_1.getEmpleado(), this.dw_1.getConceptoacceso(), this.dw_1.getFecha(), this.dw_1.getFechafin(), this.fechaoriginal);
                if (cant > 0) {
                    this.setMessageError("No puede haber m\u00e1s de un ticket de la felicidad el mismo d\u00eda");
                    return false;
                }
            }
        }
        if ("83".equals(this.dw_1.getConceptoacceso())) {
            int horasmaximo = 99;
            int horasregistra = 0;
            for (DtoDddwAsConceptoaccesoSelectPre obj : this.dwc_ConceptoAcceso) {
                if (obj.getConceptoacceso().equals(this.dw_1.getConceptoacceso()) && "S".equals(obj.getFlaghorasmaximoanio())) {
                    horasmaximo = obj.getCantidadhorasmaximoanio().intValue();
                    break;
                }
            }
            horasregistra = this.getFacAsistencia().getAsAutorizacionServicio().contarHorasEnfechasPorConcepto(this.dw_1.getEmpleado(), this.dw_1.getConceptoacceso(), UFechaHora.obtenerPrimerDiaAnioFecha(this.dw_1.getFecha()), UFechaHora.obtenerUltimoDiaAnioFecha(this.dw_1.getFechafin()), this.fechaoriginal);
            if (horasregistra > 4 && horasregistra < 8) {
                horasregistra = 4;
            }
            if (horasregistra > 8) {
                horasregistra = 8;
            }
            BigDecimal horasSolicita = this.wf_diftiempo(this.dw_1.getDesde1(), this.dw_1.getHasta1()).divide(BigDecimal.valueOf(3600L), 2, RoundingMode.HALF_DOWN).subtract(this.obtenerHorasRefrigerio());
            horasregistra += horasSolicita.intValue();
            if (horasregistra > horasmaximo) {
                this.setMessageError("No puede generar esta papeleta por que superar\u00eda la cantidad de horas m\u00e1xima permitida por a\u00f1o: " + horasmaximo);
                return false;
            }
            Integer cantidadDependientes = this.getFacAsistencia().getAsAutorizacionServicio().contarHijosConyugueCumpleanios(this.dw_1.getEmpleado(), this.dw_1.getFecha());
            if (UValidador.esCero(cantidadDependientes)) {
                if (!this.blDeclaracionjurada) {
                    this.setMessageError("No puede generar esta papeleta por que no registra un dependiente hijo o conyugue que cumpla a\u00f1os en la fecha indicada. Por favor cargue la declaraci\u00f3n jurada");
                    this.blDeclaracionjurada = true;
                    return false;
                }
                if (UValidador.estaVacio(this.dw_1.getNombrearchivodj())) {
                    this.setMessageError("Debe adjuntar la declaraci\u00f3n jurada para poder grabar");
                    return false;
                }
            }
            BigDecimal horasAcumuladas = this.wf_diftiempo(this.dw_1.getDesde1(), this.dw_1.getHasta1()).divide(BigDecimal.valueOf(3600L), 2, 4);
            horasAcumuladas = horasAcumuladas.subtract(this.obtenerHorasRefrigerio());
            if (horasAcumuladas.intValue() != 4 && horasAcumuladas.intValue() != 8) {
                this.setMessageError("No puede generar esta papeleta por que las horas permitidas son 4 o 8");
                return false;
            }
        }
        if ("84".equals(this.dw_1.getConceptoacceso())) {
            Integer cantidadDependientes2 = this.getFacAsistencia().getAsAutorizacionServicio().contarHijosMeses(this.dw_1.getEmpleado(), this.dw_1.getFecha(), Integer.valueOf(6));
            if (UValidador.esCero(cantidadDependientes2)) {
                this.setMessageError("No puede generar esta papeleta por que no registra un dependiente hijo menor o igual a 6 meses de nacido");
                return false;
            }
            int horasmaximo2 = 99;
            int horasregistra2 = 0;
            for (DtoDddwAsConceptoaccesoSelectPre obj2 : this.dwc_ConceptoAcceso) {
                if (obj2.getConceptoacceso().equals(this.dw_1.getConceptoacceso()) && "S".equals(obj2.getFlaghorasmaximoanio())) {
                    horasmaximo2 = obj2.getCantidadhorasmaximoanio().intValue();
                    break;
                }
            }
            horasregistra2 = this.getFacAsistencia().getAsAutorizacionServicio().contarHorasEnfechasPorConcepto(this.dw_1.getEmpleado(), this.dw_1.getConceptoacceso(), UFechaHora.obtenerPrimerDiaAnioFecha(this.dw_1.getFecha()), UFechaHora.obtenerUltimoDiaAnioFecha(this.dw_1.getFechafin()), this.fechaoriginal);
            if (horasregistra2 > 4 && horasregistra2 < 8) {
                horasregistra2 = 4;
            }
            if (horasregistra2 > 8) {
                horasregistra2 = 8;
            }
            BigDecimal horasSolicita2 = this.wf_diftiempo(this.dw_1.getDesde1(), this.dw_1.getHasta1()).divide(BigDecimal.valueOf(3600L), 2, RoundingMode.HALF_DOWN).subtract(this.obtenerHorasRefrigerio());
            horasregistra2 += horasSolicita2.intValue();
            if (horasregistra2 > horasmaximo2) {
                this.setMessageError("No puede generar esta papeleta por que superar\u00eda la cantidad de horas m\u00e1xima permitida por a\u00f1o: " + horasmaximo2);
                return false;
            }
        }
        if ("85".equals(this.dw_1.getConceptoacceso())) {
            Integer cantidadDependientes2 = this.getFacAsistencia().getAsAutorizacionServicio().contarPadresAbuelos(this.dw_1.getEmpleado());
            if (UValidador.esCero(cantidadDependientes2)) {
                if (!this.blDeclaracionjurada) {
                    this.setMessageError("No puede generar esta papeleta por que no registra un dependiente padre, madre o abuelos. Por favor cargue la declaraci\u00f3n jurada");
                    this.blDeclaracionjurada = true;
                    return false;
                }
                if (UValidador.estaVacio(this.dw_1.getNombrearchivodj())) {
                    this.setMessageError("Debe adjuntar la declaraci\u00f3n jurada para poder grabar");
                    return false;
                }
            }
            int horasmaximo2 = 99;
            int horasregistra2 = 0;
            for (DtoDddwAsConceptoaccesoSelectPre obj2 : this.dwc_ConceptoAcceso) {
                if (obj2.getConceptoacceso().equals(this.dw_1.getConceptoacceso()) && "S".equals(obj2.getFlaghorasmaximoanio())) {
                    horasmaximo2 = obj2.getCantidadhorasmaximoanio().intValue();
                    break;
                }
            }
            horasregistra2 = this.getFacAsistencia().getAsAutorizacionServicio().contarHorasEnfechasPorConcepto(this.dw_1.getEmpleado(), this.dw_1.getConceptoacceso(), UFechaHora.obtenerPrimerDiaAnioFecha(this.dw_1.getFecha()), UFechaHora.obtenerUltimoDiaAnioFecha(this.dw_1.getFechafin()), this.fechaoriginal);
            if (horasregistra2 > 4 && horasregistra2 < 8) {
                horasregistra2 = 4;
            }
            if (horasregistra2 > 8) {
                horasregistra2 = 8;
            }
            BigDecimal horasSolicita2 = this.wf_diftiempo(this.dw_1.getDesde1(), this.dw_1.getHasta1()).divide(BigDecimal.valueOf(3600L), 2, RoundingMode.HALF_DOWN).subtract(this.obtenerHorasRefrigerio());
            horasregistra2 += horasSolicita2.intValue();
            if (horasregistra2 > horasmaximo2) {
                this.setMessageError("No puede generar esta papeleta por que superar\u00eda la cantidad de horas m\u00e1xima permitida por a\u00f1o: " + horasmaximo2);
                return false;
            }
            BigDecimal horasAcumuladas = this.wf_diftiempo(this.dw_1.getDesde1(), this.dw_1.getHasta1()).divide(BigDecimal.valueOf(3600L), 2, 4);
            horasAcumuladas = horasAcumuladas.subtract(this.obtenerHorasRefrigerio());
            if (horasAcumuladas.intValue() != 4 && horasAcumuladas.intValue() != 8) {
                this.setMessageError("No puede generar esta papeleta por que las horas permitidas son 4 o 8");
                return false;
            }
        }
        if ("06".equals(this.dw_1.getConceptoacceso())) {
            Personamast per = this.getFacCore().getPersonamastServicio().obtenerporPersona(this.dw_1.getEmpleado());
            if (UValidador.esNulo((Object)per)) {
                per = new Personamast();
            }
            if ("F".equals(per.getSexo())) {
                this.setMessageError("No puede generar esta papeleta por que el empleado debe tener sexo masculino.");
                return false;
            }
            Integer cantidadHijos = this.getFacAsistencia().getAsAutorizacionServicio().contarHijos(this.dw_1.getEmpleado());
            if (UValidador.esCero(cantidadHijos)) {
                this.setMessageError("No puede generar esta papeleta por que no registra un dependiente hijo en el sistema.");
                return false;
            }
            Date fechabase = UFechaHora.convertirCadenaFecha("01/06/" + UFechaHora.obtenerAnio(), "dd/MM/yyyy");
            Date fechaLim = UFechaHora.obtenerUltimoDiaMesFecha(UFechaHora.convertirCadenaFecha("01/06/" + UFechaHora.obtenerAnio(), "dd/MM/yyyy"));
            if (this.dw_1.getFecha().getTime() < fechabase.getTime() || this.dw_1.getFecha().getTime() > fechaLim.getTime()) {
                this.setMessageError("No puede generar esta papeleta por que no est\u00e1 dentro del mes de Junio. (Del " + UFechaHora.convertirFechaCadena(fechabase, "dd/MM/yyyy") + " al " + UFechaHora.convertirFechaCadena(fechaLim, "dd/MM/yyyy") + ")");
                return false;
            }
        }
        if ("19".equals(this.dw_1.getConceptoacceso())) {
            Personamast per = this.getFacCore().getPersonamastServicio().obtenerporPersona(this.dw_1.getEmpleado());
            if (UValidador.esNulo((Object)per)) {
                per = new Personamast();
            }
            if ("M".equals(per.getSexo())) {
                this.setMessageError("No puede generar esta papeleta por que el empleado debe tener sexo femenino.");
                return false;
            }
            Integer cantidadHijos = this.getFacAsistencia().getAsAutorizacionServicio().contarHijos(this.dw_1.getEmpleado());
            if (UValidador.esCero(cantidadHijos)) {
                this.setMessageError("No puede generar esta papeleta por que no registra un dependiente hijo en el sistema.");
                return false;
            }
            Date fechabase = UFechaHora.convertirCadenaFecha("01/05/" + UFechaHora.obtenerAnio(), "dd/MM/yyyy");
            Date fechaLim = UFechaHora.obtenerUltimoDiaMesFecha(UFechaHora.convertirCadenaFecha("01/05/" + UFechaHora.obtenerAnio(), "dd/MM/yyyy"));
            if (this.dw_1.getFecha().getTime() < fechabase.getTime() || this.dw_1.getFecha().getTime() > fechaLim.getTime()) {
                this.setMessageError("No puede generar esta papeleta por que no est\u00e1 dentro del mes de Mayo. (Del " + UFechaHora.convertirFechaCadena(fechabase, "dd/MM/yyyy") + " al " + UFechaHora.convertirFechaCadena(fechaLim, "dd/MM/yyyy") + ")");
                return false;
            }
        }
        if ("72".equals(this.dw_1.getConceptoacceso())) {
            Integer cantidadHijos2 = this.getFacAsistencia().getAsAutorizacionServicio().contarHijosCumpleanios(this.dw_1.getEmpleado(), this.dw_1.getFecha());
            if (UValidador.esCero(cantidadHijos2)) {
                this.setMessageError("No puede generar esta papeleta por que no registra un dependiente hijo que cumpla a\u00f1os en la fecha indicada.");
                return false;
            }
        }
        if ("73".equals(this.dw_1.getConceptoacceso())) {
            String horainicio = UFechaHora.convertirFechaCadena(this.dw_1.getDesde1(), "HHmm");
            String horafin = UFechaHora.convertirFechaCadena(this.dw_1.getHasta1(), "HHmm");
            if (Integer.parseInt(horainicio) < 1230 || Integer.parseInt(horainicio) > 1500 || Integer.parseInt(horafin) < 1230 || Integer.parseInt(horafin) > 1500) {
                this.setMessageError("No puede generar esta papeleta porque el horario debe estar entre las 12:30 y 15:00 horas.");
                return false;
            }
        }
        if ("74".equals(this.dw_1.getConceptoacceso())) {
            String horainicio = UFechaHora.convertirFechaCadena(this.dw_1.getDesde1(), "HHmm");
            if (Integer.parseInt(horainicio) < 1300) {
                this.setMessageError("No puede generar esta papeleta porque el horario debe iniciar a las 13:00 horas.");
                return false;
            }
            int cantmaxima = 0;
            int cantregistra = 0;
            for (DtoDddwAsConceptoaccesoSelectPre obj2 : this.dwc_ConceptoAcceso) {
                if (obj2.getConceptoacceso().equals(this.dw_1.getConceptoacceso())) {
                    cantmaxima = obj2.getCantmaxanio().intValue();
                    break;
                }
            }
            cantregistra = this.getFacAsistencia().getAsAutorizacionServicio().contarCantidadEnfechasPorConcepto(this.dw_1.getEmpleado(), this.dw_1.getConceptoacceso(), UFechaHora.obtenerPrimerDiaAnioFecha(this.dw_1.getFecha()), UFechaHora.obtenerUltimoDiaAnioFecha(this.dw_1.getFechafin()), this.fechaoriginal);
            if (++cantregistra > cantmaxima) {
                this.setMessageError("No puede generar esta papeleta por que superar\u00eda la cantidad m\u00e1xima permitida por a\u00f1o: " + cantmaxima);
                return false;
            }
        }
        if ("75".equals(this.dw_1.getConceptoacceso())) {
            int cantmaxima2 = 0;
            int cantregistra2 = 0;
            for (DtoDddwAsConceptoaccesoSelectPre obj : this.dwc_ConceptoAcceso) {
                if (obj.getConceptoacceso().equals(this.dw_1.getConceptoacceso())) {
                    cantmaxima2 = obj.getCantmaxanio().intValue();
                    break;
                }
            }
            BigDecimal horasAcumuladas2 = this.wf_diftiempo(this.dw_1.getDesde1(), this.dw_1.getHasta1()).divide(BigDecimal.valueOf(3600L), 2, 4);
            horasAcumuladas2 = horasAcumuladas2.subtract(this.obtenerHorasRefrigerio());
            if (horasAcumuladas2.intValue() != 4 && horasAcumuladas2.intValue() != 8) {
                this.setMessageError("No puede generar esta papeleta por que las horas permitidas son 4 o 8");
                return false;
            }
            int horasmaximo3 = 0;
            int horasregistra3 = 0;
            for (DtoDddwAsConceptoaccesoSelectPre obj3 : this.dwc_ConceptoAcceso) {
                if (obj3.getConceptoacceso().equals(this.dw_1.getConceptoacceso()) && "S".equals(obj3.getFlaghorasmaximoanio())) {
                    horasmaximo3 = obj3.getCantidadhorasmaximoanio().intValue();
                    break;
                }
            }
            horasregistra3 = this.getFacAsistencia().getAsAutorizacionServicio().contarHorasEnfechasPorConcepto(this.dw_1.getEmpleado(), this.dw_1.getConceptoacceso(), UFechaHora.obtenerPrimerDiaAnioFecha(this.dw_1.getFecha()), UFechaHora.obtenerUltimoDiaAnioFecha(this.dw_1.getFechafin()), this.fechaoriginal);
            if (horasregistra3 > 4 && horasregistra3 < 8) {
                horasregistra3 = 4;
            }
            if (horasregistra3 > 8) {
                horasregistra3 = 8;
            }
            horasregistra3 += this.wf_diftiempo(this.dw_1.getDesde1(), this.dw_1.getHasta1()).divide(BigDecimal.valueOf(3600L), 2, RoundingMode.HALF_DOWN).subtract(this.obtenerHorasRefrigerio()).intValue();
            if (horasregistra3 > horasmaximo3) {
                this.setMessageError("No puede generar esta papeleta por que superar\u00eda la cantidad de horas m\u00e1xima permitida por a\u00f1o: " + horasmaximo3);
                return false;
            }
            cantregistra2 = this.getFacAsistencia().getAsAutorizacionServicio().contarCantidadEnfechasPorConcepto(this.dw_1.getEmpleado(), this.dw_1.getConceptoacceso(), UFechaHora.obtenerPrimerDiaAnioFecha(this.dw_1.getFecha()), UFechaHora.obtenerUltimoDiaAnioFecha(this.dw_1.getFechafin()), this.fechaoriginal);
            if (++cantregistra2 > cantmaxima2) {
                this.setMessageError("No puede generar esta papeleta por que superar\u00eda la cantidad m\u00e1xima permitida por a\u00f1o: " + cantmaxima2);
                return false;
            }
        }
        if ("76".equals(this.dw_1.getConceptoacceso())) {
            int cantmaxima2 = 0;
            int cantregistra2 = 0;
            int diasmax = 0;
            String flgCantidaddiasmaximo = "";
            for (DtoDddwAsConceptoaccesoSelectPre obj4 : this.dwc_ConceptoAcceso) {
                if (obj4.getConceptoacceso().equals(this.dw_1.getConceptoacceso())) {
                    cantmaxima2 = obj4.getCantmaxanio().intValue();
                    diasmax = obj4.getCantidaddiasmaximo().intValue();
                    flgCantidaddiasmaximo = obj4.getFlagdiasmaximo();
                    break;
                }
            }
            if ("S".equals(flgCantidaddiasmaximo) && diasmax < this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(this.dw_1.getFecha(), this.dw_1.getFechafin())) {
                this.setMessageError("No puede generar esta papeleta por que no respeta la cantidad permitida de d\u00edas: " + diasmax);
                return false;
            }
            if ("S".equals(flgCantidaddiasmaximo) && diasmax > this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(this.dw_1.getFecha(), this.dw_1.getFechafin())) {
                this.setMessageError("No puede generar esta papeleta por que no respeta la cantidad permitida de d\u00edas: " + diasmax);
                return false;
            }
            cantregistra2 = this.getFacAsistencia().getAsAutorizacionServicio().contarCantidadEnfechasPorConcepto(this.dw_1.getEmpleado(), this.dw_1.getConceptoacceso(), UFechaHora.obtenerPrimerDiaAnioFecha(this.dw_1.getFecha()), UFechaHora.obtenerUltimoDiaAnioFecha(this.dw_1.getFechafin()), this.fechaoriginal);
            if (++cantregistra2 > cantmaxima2) {
                this.setMessageError("No puede generar esta papeleta por que superar\u00eda la cantidad m\u00e1xima permitida por a\u00f1o: " + cantmaxima2);
                return false;
            }
        }
        if ("77".equals(this.dw_1.getConceptoacceso())) {
            int cantmaxima2 = 0;
            int cantregistra2 = 0;
            for (DtoDddwAsConceptoaccesoSelectPre obj : this.dwc_ConceptoAcceso) {
                if (obj.getConceptoacceso().equals(this.dw_1.getConceptoacceso())) {
                    cantmaxima2 = obj.getCantmaxanio().intValue();
                    break;
                }
            }
            cantregistra2 = this.getFacAsistencia().getAsAutorizacionServicio().contarCantidadEnfechasPorConcepto(this.dw_1.getEmpleado(), this.dw_1.getConceptoacceso(), UFechaHora.obtenerPrimerDiaAnioFecha(this.dw_1.getFecha()), UFechaHora.obtenerUltimoDiaAnioFecha(this.dw_1.getFechafin()), this.fechaoriginal);
            if (++cantregistra2 > cantmaxima2) {
                this.setMessageError("No puede generar esta papeleta por que superar\u00eda la cantidad m\u00e1xima permitida por a\u00f1o: " + cantmaxima2);
                return false;
            }
        }
        return true;
    }
    
    private boolean validarFraccionamientoHoraVacaciones() throws Exception {
        BigDecimal w_diftiempo = this.wf_diftiempo(this.dw_1.getDesde1(), this.dw_1.getHasta1()).divide(BigDecimal.valueOf(3600L), 2, 4);
        w_diftiempo = w_diftiempo.subtract(this.obtenerHorasRefrigerio());
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add") || CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
            this.w_count = this.getFacAsistencia().getAsAutorizacionServicio().obtenerCantidadPapeletaFechas(BigDecimal.valueOf(this.dw_1.getEmpleado()), this.dw_1.getFecha(), this.dw_1.getFechafin(), this.fechainiOriginal, this.fechafinOriginal);
            if (this.w_count > 0) {
                this.setMessageError("Ya existe otra papeleta dentro de las fechas indicadas.");
                return false;
            }
        }
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
            val1 = (List<DtoPrVacacionPeriodo>)this.getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(this.dw_1.getEmpleado(), this.dw_1.getFecha(), this.fechainiOriginal, this.fechafinOriginal, "M", this.dw_1.getConceptoacceso());
        }
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
            val1 = (List<DtoPrVacacionPeriodo>)this.getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(this.dw_1.getEmpleado(), this.dw_1.getFecha(), this.fechainiOriginal, this.fechafinOriginal, "N", this.dw_1.getConceptoacceso());
        }
        if (!UValidador.esListaVacia((List)val1)) {
            pendientes = val1.get(0).getPendientes();
            periodo = val1.get(0).getNroperiodo();
            programados = val1.get(0).getProgramados();
            utilizados = val1.get(0).getUtilizados();
            solicitados = val1.get(0).getSolicitados();
            fraccionadosdias = val1.get(0).getFraccionadosdias();
            fraccionadoshoras = val1.get(0).getFraccionadoshoras();
            adelantos = val1.get(0).getAdelantos();
            this.dw_1.setPeriodo(periodo.toString());
        }
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update") && UValidador.esNulo((Object)pendientes)) {
            pendientes = BigDecimal.ZERO;
        }
        if (pendientes.multiply(BigDecimal.valueOf(8L)).compareTo(w_diftiempo) == -1) {
            this.setMessageError("No puede agregar una papeleta por Fraccionamiento de vacaciones porque las horas indicadas es mayor al saldo disponible: Pendientes: " + pendientes + ", " + "Vacaciones solicitadas: " + solicitados + ", " + "Vacaciones programadas: " + programados + ", " + "Vacaciones utilizadas: " + utilizados + ", " + "Fraccionamiento d\u00edas: " + fraccionadosdias + ", " + "Fraccionamiento horas: " + fraccionadoshoras + ", " + "Vacaciones adelantos: " + adelantos + ". Por favor de consultar a URH.");
            return false;
        }
        if (UFechaHora.obtenerNumeroDiaSemana(this.dw_1.getFecha()) != 7 && (UFechaHora.obtenerNumeroDiaSemana(this.dw_1.getFechafin()).equals(6) || UFechaHora.obtenerNumeroDiaSemana(this.dw_1.getFechafin()).equals(7)) && w_diftiempo.compareTo(new BigDecimal(8.0)) != -1) {
            this.setMessageError("La hora hasta no es correcta, para los d\u00edas viernes debe ser menor a 8 horas. Caso contrario registre un fraccionamiento de vacaciones por d\u00eda.");
            return false;
        }
        AsConceptoacceso obj = (AsConceptoacceso)this.getFacAsistencia().getAsConceptoaccesoServicio().obtenerPorId((Serializable)new AsConceptoaccesoPk(this.dw_1.getConceptoacceso()));
        if (!UValidador.esNulo((Object)obj) && "S".equals(obj.getFlagdiasanticipacion())) {
            Integer diasHabiles = this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(new Date(), this.dw_1.getFecha());
            if (diasHabiles < obj.getDiasanticipacion().intValue()) {
                this.setMessageError("Para fraccionar vacaciones estas deben generarse con " + obj.getDiasanticipacion().intValue() + " d\u00edas h\u00e1biles de anticipaci\u00f3n.");
                return false;
            }
        }
        List<DtoAsAutorizacion> listaVacaciones = (List<DtoAsAutorizacion>)this.getFacAsistencia().getAsAutorizacionServicio().listarSolicitudesPeriodo(this.dw_1.getEmpleado(), this.dw_1.getConceptoacceso(), this.fechainiOriginal, this.fechafinOriginal, periodo);
        List<DtoAsAutorizacion> listaVacaciones2 = (List<DtoAsAutorizacion>)this.getFacAsistencia().getAsAutorizacionServicio().listarSolicitudesPeriodo(this.dw_1.getEmpleado(), "FRAD", this.fechainiOriginal, this.fechafinOriginal, periodo);
        BigDecimal horasv = BigDecimal.ZERO;
        Integer diasv = 0;
        if (!UValidador.esListaVacia((List)listaVacaciones)) {
            for (DtoAsAutorizacion objVaca : listaVacaciones) {
                horasv = horasv.add(this.wf_diftiempo(objVaca.getDesde(), objVaca.getHasta()).divide(BigDecimal.valueOf(3600L), 2, 4));
            }
        }
        if (!UValidador.esListaVacia((List)listaVacaciones2)) {
            for (DtoAsAutorizacion objVaca : listaVacaciones2) {
                diasv += this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(objVaca.getFecha(), objVaca.getFechahasta());
            }
        }
        horasv = horasv.add(w_diftiempo).add(BigDecimal.valueOf(diasv * 8));
        if (horasv.compareTo(BigDecimal.valueOf(56L)) == 1) {
            this.setMessageError("La cantidad de horas acumuladas en el periodo ser\u00edan " + horasv + ". Lo cu\u00e1l super\u00eda la cantidad m\u00e1xima de horas para fraccionamiento de vacaciones: " + 56);
            return false;
        }
        return true;
    }
    
    private boolean validarFraccionamientoDiaVacaciones() throws Exception {
        Integer wdifdia = UFechaHora.obtenerDiasTranscurridos(this.dw_1.getFechafin(), this.dw_1.getFecha()) + 1;
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add") || CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
            this.w_count = this.getFacAsistencia().getAsAutorizacionServicio().obtenerCantidadPapeletaFechas(BigDecimal.valueOf(this.dw_1.getEmpleado()), this.dw_1.getFecha(), this.dw_1.getFechafin(), this.fechainiOriginal, this.fechafinOriginal);
            if (this.w_count > 0) {
                this.setMessageError("Ya existe otra papeleta dentro de las fechas indicadas.");
                return false;
            }
        }
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
            val1 = (List<DtoPrVacacionPeriodo>)this.getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(this.dw_1.getEmpleado(), this.dw_1.getFecha(), this.fechainiOriginal, this.fechafinOriginal, "M", this.dw_1.getConceptoacceso());
        }
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
            val1 = (List<DtoPrVacacionPeriodo>)this.getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(this.dw_1.getEmpleado(), this.dw_1.getFecha(), this.fechainiOriginal, this.fechafinOriginal, "N", this.dw_1.getConceptoacceso());
        }
        if (!UValidador.esListaVacia((List)val1)) {
            pendientes = val1.get(0).getPendientes();
            periodo = val1.get(0).getNroperiodo();
            programados = val1.get(0).getProgramados();
            utilizados = val1.get(0).getUtilizados();
            solicitados = val1.get(0).getSolicitados();
            fraccionadosdias = val1.get(0).getFraccionadosdias();
            fraccionadoshoras = val1.get(0).getFraccionadoshoras();
            adelantos = val1.get(0).getAdelantos();
            this.dw_1.setPeriodo(periodo.toString());
        }
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update") && UValidador.esNulo((Object)pendientes)) {
            pendientes = BigDecimal.ZERO;
        }
        if (pendientes.compareTo(BigDecimal.valueOf(wdifdia)) == -1) {
            this.setMessageError("No puede agregar una papeleta por Fraccionamiento de Vacaciones porque los d\u00edas indicados es mayor a los d\u00edas pendientes:  Pendientes: " + pendientes + ", " + "Vacaciones solicitadas: " + solicitados + ", " + "Vacaciones programadas: " + programados + ", " + "Vacaciones utilizadas: " + utilizados + ", " + "Fraccionamiento d\u00edas: " + fraccionadosdias + ", " + "Fraccionamiento horas: " + fraccionadoshoras + ", " + "Vacaciones adelantadas: " + adelantos + ". Por favor de consultar a URH.");
            return false;
        }
        if (UFechaHora.obtenerNumeroDiaSemana(this.dw_1.getFecha()) != 7 && (UFechaHora.obtenerNumeroDiaSemana(this.dw_1.getFechafin()).equals(6) || UFechaHora.obtenerNumeroDiaSemana(this.dw_1.getFechafin()).equals(7))) {
            this.setMessageError("La fecha no es correcta, debe incluir los d\u00edas de fin de semana");
            return false;
        }
        AsConceptoacceso obj = (AsConceptoacceso)this.getFacAsistencia().getAsConceptoaccesoServicio().obtenerPorId((Serializable)new AsConceptoaccesoPk(this.dw_1.getConceptoacceso()));
        if (!UValidador.esNulo((Object)obj) && "S".equals(obj.getFlagdiasanticipacion())) {
            Integer diasHabiles = this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(new Date(), this.dw_1.getFecha());
            if (diasHabiles < obj.getDiasanticipacion().intValue()) {
                this.setMessageError("Para fraccionar vacaciones estas deben generarse con " + obj.getDiasanticipacion().intValue() + " d\u00edas h\u00e1biles de anticipaci\u00f3n.");
                return false;
            }
        }
        List<DtoAsAutorizacion> listaVacaciones = (List<DtoAsAutorizacion>)this.getFacAsistencia().getAsAutorizacionServicio().listarSolicitudesPeriodo(this.dw_1.getEmpleado(), this.dw_1.getConceptoacceso(), this.fechainiOriginal, this.fechafinOriginal, periodo);
        List<DtoAsAutorizacion> listaVacaciones2 = (List<DtoAsAutorizacion>)this.getFacAsistencia().getAsAutorizacionServicio().listarSolicitudesPeriodo(this.dw_1.getEmpleado(), "FRAH", this.fechainiOriginal, this.fechafinOriginal, periodo);
        double diasv = 0.0;
        BigDecimal horasv = BigDecimal.ZERO;
        if (!UValidador.esListaVacia((List)listaVacaciones)) {
            for (DtoAsAutorizacion objVaca : listaVacaciones) {
                diasv += this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(objVaca.getFecha(), objVaca.getFechahasta());
            }
        }
        if (!UValidador.esListaVacia((List)listaVacaciones2)) {
            for (DtoAsAutorizacion objVaca : listaVacaciones2) {
                horasv = horasv.add(this.wf_diftiempo(objVaca.getDesde(), objVaca.getHasta()).divide(BigDecimal.valueOf(3600L), 2, 4));
            }
        }
        diasv += this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(this.dw_1.getFecha(), this.dw_1.getFechafin());
        diasv += horasv.divide(BigDecimal.valueOf(8L)).doubleValue();
        if (diasv > 7.0) {
            this.setMessageError("La cantidad de d\u00edas h\u00e1biles acumuladas en el periodo ser\u00edan " + diasv + ". Lo cu\u00e1l super\u00eda la cantidad m\u00e1xima de d\u00edas h\u00e1biles para fraccionamiento de vacaciones: " + 7);
            return false;
        }
        return true;
    }
    
    private boolean validarAdelantoVacaciones() throws Exception {
        Integer wdifdia = UFechaHora.obtenerDiasTranscurridos(this.dw_1.getFechafin(), this.dw_1.getFecha()) + 1;
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add") || CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
            this.w_count = this.getFacAsistencia().getAsAutorizacionServicio().obtenerCantidadPapeletaFechas(BigDecimal.valueOf(this.dw_1.getEmpleado()), this.dw_1.getFecha(), this.dw_1.getFechafin(), this.fechainiOriginal, this.fechafinOriginal);
            if (this.w_count > 0) {
                this.setMessageError("Ya existe otra papeleta dentro de las fechas indicadas.");
                return false;
            }
        }
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
            val1 = (List<DtoPrVacacionPeriodo>)this.getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(this.dw_1.getEmpleado(), this.dw_1.getFecha(), this.fechainiOriginal, this.fechafinOriginal, "M", this.dw_1.getConceptoacceso());
        }
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
            val1 = (List<DtoPrVacacionPeriodo>)this.getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(this.dw_1.getEmpleado(), this.dw_1.getFecha(), this.fechainiOriginal, this.fechafinOriginal, "N", this.dw_1.getConceptoacceso());
        }
        if (!UValidador.esListaVacia((List)val1)) {
            pendientes = val1.get(0).getPendientesadelanto();
            periodo = val1.get(0).getNroperiodo();
            flgperiodovalido = val1.get(0).getFlgperiodovalido();
            programados = val1.get(0).getProgramados();
            utilizados = val1.get(0).getUtilizados();
            solicitados = val1.get(0).getSolicitados();
            fraccionadosdias = val1.get(0).getFraccionadosdias();
            fraccionadoshoras = val1.get(0).getFraccionadoshoras();
            adelantos = val1.get(0).getAdelantos();
            this.dw_1.setPeriodo(periodo.toString());
        }
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update") && UValidador.esNulo((Object)pendientes)) {
            pendientes = BigDecimal.ZERO;
        }
        if (!"S".equals(flgperiodovalido)) {
            if (wdifdia < 7) {
                this.setMessageError("Fecha de inicio incorrecta para adelanto de vacaciones. Por favor solicite un fraccionamiento de vacaciones.");
                return false;
            }
            this.setMessageError("Fecha de inicio incorrecta para adelanto de vacaciones. Por favor solicite vacaciones ordinarias.");
            return false;
        }
        else {
            if (pendientes.compareTo(BigDecimal.valueOf(wdifdia)) == -1) {
                this.setMessageError("No puede agregar una papeleta por Adelanto de Vacaciones porque los d\u00edas indicados es mayor a los d\u00edas pendientes: Pendientes: " + pendientes + ", " + "Vacaciones solicitadas: " + solicitados + ", " + "Vacaciones programadas: " + programados + ", " + "Vacaciones utilizadas: " + utilizados + ", " + "Fraccionamiento d\u00edas: " + fraccionadosdias + ", " + "Fraccionamiento horas: " + fraccionadoshoras + ", " + "Vacaciones adelantadas: " + adelantos + ". Por favor de consultar a URH.");
                return false;
            }
            if (UFechaHora.obtenerNumeroDiaSemana(this.dw_1.getFecha()) != 7 && (UFechaHora.obtenerNumeroDiaSemana(this.dw_1.getFechafin()).equals(6) || UFechaHora.obtenerNumeroDiaSemana(this.dw_1.getFechafin()).equals(7))) {
                this.setMessageError("La fecha no es correcta, debe incluir los d\u00edas de fin de semana");
                return false;
            }
            AsConceptoacceso obj = (AsConceptoacceso)this.getFacAsistencia().getAsConceptoaccesoServicio().obtenerPorId((Serializable)new AsConceptoaccesoPk(this.dw_1.getConceptoacceso()));
            if (!UValidador.esNulo((Object)obj) && "S".equals(obj.getFlagdiasanticipacion())) {
                Integer diasHabiles = this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(new Date(), this.dw_1.getFecha());
                if (diasHabiles < obj.getDiasanticipacion().intValue()) {
                    this.setMessageError("Para adelantar vacaciones estas deben generarse con " + obj.getDiasanticipacion().intValue() + " d\u00edas h\u00e1biles de anticipaci\u00f3n.");
                    return false;
                }
            }
            Empleadomast empleado = this.getFacCore().getEmpleadomastServicio().obtenerEmpleadoMast(this.dw_1.getEmpleado());
            if (!UValidador.esNulo((Object)empleado) && UFechaHora.obtenerDiferenciaMeses(empleado.getFechaingreso(), new Date()) < 1) {
                this.setMessageError("Para adelantar vacaciones el empleado debe tener m\u00e1s de un mes en la entidad. ");
                return false;
            }
            List<DtoAsAutorizacion> listaVacaciones = (List<DtoAsAutorizacion>)this.getFacAsistencia().getAsAutorizacionServicio().listarSolicitudesPeriodo(this.dw_1.getEmpleado(), this.dw_1.getConceptoacceso(), this.fechainiOriginal, this.fechafinOriginal, periodo);
            Integer diasv = 0;
            if (!UValidador.esListaVacia((List)listaVacaciones)) {
                for (DtoAsAutorizacion objVaca : listaVacaciones) {
                    diasv += this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(objVaca.getFecha(), objVaca.getFechahasta());
                }
                diasv += this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(this.dw_1.getFecha(), this.dw_1.getFechafin());
                if (diasv > 22) {
                    this.setMessageError("La cantidad de d\u00edas h\u00e1biles acumuladas en el periodo ser\u00edan " + diasv + ". Lo cu\u00e1l super\u00eda la cantidad m\u00e1xima de d\u00edas h\u00e1biles para adelanto de vacaciones: " + 22);
                    return false;
                }
            }
            return true;
        }
    }
    
    private boolean validarVacaciones() throws Exception {
        this.getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(this.getUsuarioActual().getAplicacionCodigo(), this.getUsuarioActual().getCodigoUsuario());
        Integer wdifdia = UFechaHora.obtenerDiasTranscurridos(this.dw_1.getFechafin(), this.dw_1.getFecha()) + 1;
        if (wdifdia <= 6) {
            this.setMessageError("El periodo vacacional debe ser de un m\u00ednimo de 7 d\u00edas.");
            return false;
        }
        if (UFechaHora.obtenerNumeroDiaSemana(this.dw_1.getFecha()) != 7 && (UFechaHora.obtenerNumeroDiaSemana(this.dw_1.getFechafin()).equals(6) || UFechaHora.obtenerNumeroDiaSemana(this.dw_1.getFechafin()).equals(7))) {
            this.setMessageError("La fecha no es correcta, debe incluir los d\u00edas de fin de semana");
            return false;
        }
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add") || CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
            this.w_count = this.getFacAsistencia().getAsAutorizacionServicio().obtenerCantidadPapeletaFechas(BigDecimal.valueOf(this.dw_1.getEmpleado()), this.dw_1.getFecha(), this.dw_1.getFechafin(), this.fechainiOriginal, this.fechafinOriginal);
            if (this.w_count > 0) {
                this.setMessageError("Ya existe otra papeleta dentro de las fechas indicadas.");
                return false;
            }
        }
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
            val1 = (List<DtoPrVacacionPeriodo>)this.getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(this.dw_1.getEmpleado(), this.dw_1.getFecha(), this.fechainiOriginal, this.fechafinOriginal, "M", this.dw_1.getConceptoacceso());
        }
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
            val1 = (List<DtoPrVacacionPeriodo>)this.getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerPendientesNroPeriodoPorEmpleado(this.dw_1.getEmpleado(), this.dw_1.getFecha(), this.fechainiOriginal, this.fechafinOriginal, "N", this.dw_1.getConceptoacceso());
        }
        if (!UValidador.esListaVacia((List)val1)) {
            pendientes = val1.get(0).getPendientes();
            programados = val1.get(0).getProgramados();
            utilizados = val1.get(0).getUtilizados();
            solicitados = val1.get(0).getSolicitados();
            fraccionadosdias = val1.get(0).getFraccionadosdias();
            fraccionadoshoras = val1.get(0).getFraccionadoshoras();
            adelantos = val1.get(0).getAdelantos();
        }
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update") && UValidador.esNulo((Object)pendientes)) {
            pendientes = BigDecimal.ZERO;
        }
        if (pendientes.compareTo(BigDecimal.valueOf(wdifdia)) == -1) {
            this.setMessageError("No puede agregar una papeleta por Vacaciones porque los d\u00edas indicados es mayor a los d\u00edas pendientes: Pendientes: " + pendientes + ", " + "Vacaciones solicitadas: " + solicitados + ", " + "Vacaciones programadas: " + programados + ", " + "Vacaciones utilizadas: " + utilizados + ", " + "Fraccionamiento d\u00edas: " + fraccionadosdias + ", " + "Fraccionamiento horas: " + fraccionadoshoras + ", " + "Vacaciones adelantadas: " + adelantos + ". Por favor de consultar a URH.");
            return false;
        }
        if (pendientes.intValue() > wdifdia) {
            List<DtoPrVacacionesprogramadas> val2 = (List<DtoPrVacacionesprogramadas>)this.getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerDiasUitlesPorEmpleado(this.dw_1.getEmpleado());
            if (!UValidador.esListaVacia((List)val2)) {
                periodo = val2.get(0).getNumeroperiodo().intValue();
                count = val2.get(0).getDiasutiles().intValue();
                dias = val2.get(0).getDiasutilizacion().intValue();
            }
            if (dias.equals(30)) {
                ++periodo;
                List<DtoPrVacacionPeriodo> val3 = (List<DtoPrVacacionPeriodo>)this.getFacPlanilla().getPrVacacionesprogramadasServicio().obtenerDerechoPorEmpleado(this.dw_1.getEmpleado(), periodo);
                if (!UValidador.esListaVacia((List)val3)) {
                    derecho = val3.get(0).getDerecho();
                }
                if (derecho.equals(BigDecimal.ZERO)) {
                    this.setMessageError("No puede agregar una papeleta por Vacaciones porque no tiene derecho para salir, favor de consultar a URH.");
                    return false;
                }
                if (wdifdia > derecho.intValue()) {
                    this.setMessageError("La cantidad de d\u00edas supera el derecho acumulado hasta el momento.");
                    return false;
                }
            }
            else {
                if (dias > 30) {
                    this.setMessageError("No puede grabar la papeleta porque super\u00f3 los 30 d\u00edas del periodo actual.");
                    return false;
                }
                if (wdifdia + dias == 30) {
                    Integer existe = UFechaHora.contarFinesDeSemanas(this.dw_1.getFecha(), this.dw_1.getFechafin());
                    Integer suma = count + existe;
                    if (suma < 8) {
                        this.setMessageError("Para grabar la papeleta debe tener 2 fines de semana.");
                        return false;
                    }
                }
            }
        }
        return this.validarVacaciones2();
    }
    
    private boolean validarVacaciones2() throws Exception {
        BigDecimal derechoano = BigDecimal.valueOf(30L);
        if (this.getUsuarioActual().getTipoPlanilla().equals("PR") || this.getUsuarioActual().getTipoPlanilla().equals("SG")) {
            derechoano = this.getFacCore().getParametrosmastServicio().obtenerValorDecimal(new ParametrosmastPk("PR", "999999", "DIAVACPRAC"));
        }
        if (this.getUsuarioActual().getTipoPlanilla().equals("EC")) {
            derechoano = this.getFacCore().getParametrosmastServicio().obtenerValorDecimal(new ParametrosmastPk("PR", "999999", "DIASVACCAS"));
        }
        if (this.getUsuarioActual().getTipoPlanilla().equals("EM")) {
            derechoano = this.getFacCore().getParametrosmastServicio().obtenerValorDecimal(new ParametrosmastPk("PR", "999999", "DIASVAC728"));
        }
        if ("S".equals(this.getFacCore().getParametrosmastServicio().obtenerValorCadena(new ParametrosmastPk("AS", "999999", "PROGMESACT")))) {
            if ("S".equals(this.getFacCore().getParametrosmastServicio().obtenerValorCadena(new ParametrosmastPk("AS", "999999", "PROGTODMES")))) {
                if (UFechaHora.obtenerTime(this.dw_1.getFecha(), "dd/MM/yyyy") < UFechaHora.obtenerTime(UFechaHora.obtenerPrimerDiaMesFecha(new Date()), "dd/MM/yyyy")) {
                    this.setMessageError("La fecha de inicio de vacaciones debe ser apartir del mes actual");
                    return false;
                }
            }
            else if (UFechaHora.obtenerTime(this.dw_1.getFecha(), "dd/MM/yyyy") < UFechaHora.obtenerTime(new Date(), "dd/MM/yyyy")) {
                this.setMessageError("La fecha de inicio de vacaciones debe ser mayor a la fecha actual.");
                return false;
            }
        }
        else if (this.dw_1.getFecha().before(new Date()) || (this.dw_1.getFecha().getYear() <= new Date().getYear() && this.dw_1.getFecha().getMonth() <= new Date().getMonth()) || (this.dw_1.getFecha().getYear() < new Date().getYear() && this.dw_1.getFecha().getMonth() > new Date().getMonth())) {
            this.setMessageError("La fecha de inicio de vacaciones debe ser posterior al mes actual.");
            return false;
        }
        Integer wdifdia = UFechaHora.obtenerDiasTranscurridos(this.dw_1.getFechafin(), this.dw_1.getFecha()) + 1;
        int diasfds = UFechaHora.contarFinesDeSemanas(this.dw_1.getFecha(), this.dw_1.getFechafin());
        if (UFechaHora.obtenerFechaParte(this.dw_1.getFecha(), "YY").equals(UFechaHora.obtenerFechaParte(this.dw_1.getFechafin(), "YY"))) {
            if (wdifdia > derechoano.intValue()) {
                this.setMessageError("El empleado tipo " + this.getUsuarioActual().getTipoPlanilla() + " No puede programar m\u00e1s de " + derechoano.intValue() + " d\u00edas en el A\u00f1o o Periodo Actual.");
                return false;
            }
            if (wdifdia > 30) {
                this.setMessageError("No puede programar m\u00e1s de 30 d\u00edas en el A\u00f1o o Periodo");
                return false;
            }
            if (this.getUsuarioActual().getTipoPlanilla().equals("PR")) {
                if (wdifdia > 6 && wdifdia < 9) {
                    if (diasfds < 2) {
                        this.setMessageError("Las vacaciones de Practicantes deben incluir 2 d\u00edas de fin de semana.");
                        return false;
                    }
                }
                else {
                    if (wdifdia != 15) {
                        this.setMessageError("Las vacaciones de Practicantes no cumplen con las condiciones especificadas.");
                        return false;
                    }
                    if (diasfds < 4) {
                        this.setMessageError("Las vacaciones de Practicantes deben incluir 4 d\u00edas de fin de semana.");
                        return false;
                    }
                }
            }
            else if (wdifdia > 6 && wdifdia < 10) {
                if (diasfds < 2) {
                    this.setMessageError("Las vacaciones deben incluir 2 d\u00edas de fin de semana.");
                    return false;
                }
            }
            else if (wdifdia > 13 && wdifdia < 17) {
                if (diasfds < 4) {
                    this.setMessageError("Las vacaciones deben incluir 4 d\u00edas de fin de semana.");
                    return false;
                }
            }
            else if (wdifdia > 20 && wdifdia < 24) {
                if (diasfds < 6) {
                    this.setMessageError("Las vacaciones deben incluir 6 d\u00edas de fin de semana.");
                    return false;
                }
            }
            else {
                if (wdifdia <= 29 || wdifdia >= 31) {
                    this.setMessageError("Las vacaciones no cumplen con los d\u00edas reglamentados");
                    return false;
                }
                if (diasfds < 8) {
                    this.setMessageError("Las vacaciones deben incluir 8 d\u00edas de fin de semana.");
                    return false;
                }
            }
        }
        else {
            if (wdifdia > 30) {
                this.setMessageError("No puede programar m\u00e1s de 30 d\u00edas en el A\u00f1o o Periodo");
                return false;
            }
            if (this.getUsuarioActual().getTipoPlanilla().equals("PR")) {
                if (wdifdia > 6 && wdifdia < 9) {
                    if (diasfds < 2) {
                        this.setMessageError("Las vacaciones de Practicantes deben incluir 2 d\u00edas de fin de semana.");
                        return false;
                    }
                }
                else {
                    if (wdifdia != 15) {
                        this.setMessageError("Las vacaciones de Practicantes no cumplen con las condiciones especificadas.");
                        return false;
                    }
                    if (diasfds < 4) {
                        this.setMessageError("Las vacaciones de Practicantes deben incluir 4 d\u00edas de fin de semana.");
                        return false;
                    }
                }
            }
            else if (wdifdia > 6 && wdifdia < 10) {
                if (diasfds < 2) {
                    this.setMessageError("Las vacaciones deben incluir 2 d\u00edas de fin de semana.");
                    return false;
                }
            }
            else if (wdifdia > 13 && wdifdia < 17) {
                if (diasfds < 4) {
                    this.setMessageError("Las vacaciones deben incluir 4 d\u00edas de fin de semana.");
                    return false;
                }
            }
            else if (wdifdia > 20 && wdifdia < 24) {
                if (diasfds < 6) {
                    this.setMessageError("Las vacaciones deben incluir 6 d\u00edas de fin de semana.");
                    return false;
                }
            }
            else {
                if (wdifdia <= 29 || wdifdia >= 31) {
                    this.setMessageError("Las vacaciones no cumplen con los d\u00edas reglamentados.");
                    return false;
                }
                if (diasfds < 8) {
                    this.setMessageError("Las vacaciones deben incluir 8 d\u00edas de fin de semana.");
                    return false;
                }
            }
        }
        return true;
    }
    
    public String validarFechaFin() throws Exception {
        if (this.validarfechas) {
            if (this.dw_1.getFechafin().after(UFechaHora.obtenerFechaMasdias(new Date(), Integer.valueOf(365)))) {
                this.getWebControlContext().actualizar("dgAvisoSiNo");
                this.getWebControlContext().ejecutar("PF('popAvisoSiNo').show()");
                this.validarfechas = false;
            }
        }
        else {
            this.validarfechas = this.validarDespuesdeFechas();
        }
        this.getWebControlContext().ejecutar("PF('popAvisoSiNo').hide()");
        return null;
    }
    
    public Boolean validarDespuesdeFechas() throws Exception {
        this.tl_desde = this.dw_1.getDesde1();
        this.tl_hasta = this.dw_1.getHasta1();
        List<DtoDwAsAutorizacionPreprocesoTipodia> lds_tipodia = new ArrayList<DtoDwAsAutorizacionPreprocesoTipodia>();
        if (!UValidador.esNulo((Object)this.dw_1.getFechafin()) && !UValidador.esNulo((Object)this.tl_desde) && !UValidador.esNulo((Object)this.tl_hasta) && this.tl_desde.after(this.tl_hasta) && UValidador.esCero(Integer.valueOf(UFechaHora.obtenerFechaHoraInicioDiaDate(this.dw_1.getFecha()).compareTo(UFechaHora.obtenerFechaHoraInicioDiaDate(this.dw_1.getFechafin())))) && this.opciones.getIsmostrardesde1() && this.opciones.getIsmostrarhasta1() && !this.ishorariodiasiguiente) {
            this.setMessageError("La hora inicial debe ser menor a la hora final.");
            return false;
        }
        this.dw_1.setDesde1(UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), this.tl_desde));
        this.dw_1.setHasta1(UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), this.tl_hasta));
        this.CampoHorasVisible = ((this.opciones.getIsmostrardesde1() && this.opciones.getIshabilitardesde1()) ? 1 : 0);
        if (!UValidador.esNulo((Object)this.tl_desde) && !UValidador.esNulo((Object)this.tl_hasta) && UValidador.esCero(Integer.valueOf(this.tl_desde.compareTo(this.tl_hasta))) && !this.w_CategoriaAutorizacion.equals("OMIS") && this.CampoHorasVisible == 1 && !this.w_CategoriaAutorizacion.equals("SOBR")) {
            this.setMessageError("La hora inicial debe ser distinta a la hora final.");
            return false;
        }
        this.tl_desde = this.dw_1.getDesde2();
        this.tl_hasta = this.dw_1.getHasta2();
        this.dw_1.setDesde2(UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), this.tl_desde));
        this.dw_1.setHasta2(UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), this.tl_hasta));
        this.empleadoval = this.dw_1.getEmpleado();
        this.conceptoaccesoval = this.dw_1.getConceptoacceso();
        List data = this.getFacAsistencia().getAsConceptoaccesoServicio().obtenerExpresadoen(this.conceptoaccesoval);
        if (!UValidador.esListaVacia(data)) {
        	ls_EXPRESADOEN = ((DtoAsConceptoacceso) data.get(0)).getExpresadoen();
        }
        if (UValidador.estaVacio(this.ls_EXPRESADOEN)) {
            this.ls_EXPRESADOEN = "H";
        }
        if (UValidador.estaVacio(this.conceptoaccesoval)) {
            this.setMessageError("Debe ingresar un concepto de acceso");
            return false;
        }
        this.fechaval = this.dw_1.getFecha();
        this.fechafin = this.dw_1.getFechafin();
        this.desde = this.dw_1.getDesde1();
        this.hasta = this.dw_1.getHasta1();
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add") || CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
            this.ld_temporal = this.fechaval;
            while (this.ld_temporal.before(this.fechafin)) {
                this.ldt_tempd = UFechaHora.obtenerFechaCompuesta(this.ld_temporal, this.desde);
                this.ldt_temph = UFechaHora.obtenerFechaCompuesta(this.ld_temporal, this.hasta);
                this.ll_val_01 = 10000000;
                this.ll_val_02 = 1000;
                this.ls_desde1 = (this.opciones.getIsmostrardesde1() ? "1" : "0");
                this.ls_hasta1 = (this.opciones.getIsmostrarhasta1() ? "1" : "0");
                String suma1 = UFechaHora.obtenerFechaParte(this.ldt_tempd, "YY") + "0000000000";
                if (this.ls_desde1.equals("1")) {
                    this.ll_d_1 = Long.valueOf(suma1) + UFechaHora.obtenerFechaParte(this.ldt_tempd, "MM") * this.ll_val_01 * 10 + UFechaHora.obtenerFechaParte(this.ldt_tempd, "DD") * 1000000;
                    CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("ll_d_1 " + this.ll_d_1));
                    this.ll_d_2 = UFechaHora.obtenerFechaParte(this.ldt_tempd, "HH") * 10000 + UFechaHora.obtenerFechaParte(this.ldt_tempd, "MI") * 100 + UFechaHora.obtenerFechaParte(this.ldt_tempd, "SS");
                }
                else {
                    this.ll_d_1 = Long.valueOf(suma1) + UFechaHora.obtenerFechaParte(this.ldt_tempd, "MM") * this.ll_val_01 * 10 + UFechaHora.obtenerFechaParte(this.ldt_tempd, "DD") * 1000000;
                    this.ll_d_2 = 0L;
                }
                if (this.ls_hasta1.equals("1")) {
                    this.ll_h_1 = Long.valueOf(suma1) + UFechaHora.obtenerFechaParte(this.ldt_temph, "MM") * this.ll_val_01 * 10 + UFechaHora.obtenerFechaParte(this.ldt_temph, "DD") * 1000000;
                    this.ll_h_2 = UFechaHora.obtenerFechaParte(this.ldt_temph, "HH") * 10000 + UFechaHora.obtenerFechaParte(this.ldt_temph, "MI") * 100 + UFechaHora.obtenerFechaParte(this.ldt_temph, "SS");
                }
                else if (this.ls_desde1.equals("1")) {
                    this.ll_h_1 = Long.valueOf(suma1) + UFechaHora.obtenerFechaParte(this.ldt_tempd, "MM") * this.ll_val_01 * 10 + UFechaHora.obtenerFechaParte(this.ldt_tempd, "DD") * 1000000;
                    this.ll_h_2 = UFechaHora.obtenerFechaParte(this.ldt_tempd, "HH") * 10000 + UFechaHora.obtenerFechaParte(this.ldt_tempd, "MI") * 100 + UFechaHora.obtenerFechaParte(this.ldt_tempd, "SS");
                }
                else {
                    this.ll_h_1 = Long.valueOf(suma1) + UFechaHora.obtenerFechaParte(this.ldt_temph, "MM") * this.ll_val_01 * 10 + UFechaHora.obtenerFechaParte(this.ldt_temph, "DD") * 1000000;
                    this.ll_h_2 = 235959L;
                }
                if (this.w_CategoriaAutorizacion.equals("SOBR")) {
                    this.ls_similares = "PMP";
                    this.ls_similares_2_all = "S";
                }
                else if (this.w_CategoriaAutorizacion.equals("PMP")) {
                    this.ls_similares = "SOBR";
                    this.ls_similares_2_all = "S";
                }
                else if (this.w_CategoriaAutorizacion.equals("COMP")) {
                    if (this.conceptoaccesoval.equals("01")) {
                        this.ls_similares = "OTRO";
                        this.ls_similares_2 = "04";
                        this.ls_similares_3 = "05";
                        this.ls_similares_4 = "02";
                        this.ls_similares_5 = "21";
                        this.ls_similares_6 = "03";
                        this.ls_similares_7 = "CMED";
                        this.ls_similares_8 = "18";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("02")) {
                        this.ls_similares = "OTRO";
                        this.ls_similares_2 = "04";
                        this.ls_similares_3 = "01";
                        this.ls_similares_4 = "05";
                        this.ls_similares_5 = "21";
                        this.ls_similares_6 = "03";
                        this.ls_similares_7 = "CMED";
                        this.ls_similares_8 = "18";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("03")) {
                        this.ls_similares = "OTRO";
                        this.ls_similares_2 = "04";
                        this.ls_similares_3 = "01";
                        this.ls_similares_4 = "02";
                        this.ls_similares_5 = "21";
                        this.ls_similares_6 = "05";
                        this.ls_similares_7 = "CMED";
                        this.ls_similares_8 = "18";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("04")) {
                        this.ls_similares = "OTRO";
                        this.ls_similares_2 = "05";
                        this.ls_similares_3 = "01";
                        this.ls_similares_4 = "02";
                        this.ls_similares_5 = "21";
                        this.ls_similares_6 = "03";
                        this.ls_similares_7 = "CMED";
                        this.ls_similares_8 = "18";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("05")) {
                        this.ls_similares = "OTRO";
                        this.ls_similares_2 = "04";
                        this.ls_similares_3 = "01";
                        this.ls_similares_4 = "02";
                        this.ls_similares_5 = "21";
                        this.ls_similares_6 = "03";
                        this.ls_similares_7 = "CMED";
                        this.ls_similares_8 = "18";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("18")) {
                        this.ls_similares = "OTRO";
                        this.ls_similares_2 = "04";
                        this.ls_similares_3 = "01";
                        this.ls_similares_4 = "02";
                        this.ls_similares_5 = "21";
                        this.ls_similares_6 = "05";
                        this.ls_similares_7 = "03";
                        this.ls_similares_8 = "CMED";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("19")) {
                        this.ls_similares = "OTRO";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("21")) {
                        this.ls_similares = "OTRO";
                        this.ls_similares_2 = "04";
                        this.ls_similares_3 = "01";
                        this.ls_similares_4 = "02";
                        this.ls_similares_5 = "05";
                        this.ls_similares_6 = "03";
                        this.ls_similares_7 = "CMED";
                        this.ls_similares_8 = "18";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("23")) {
                        this.ls_similares = "OTRO";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("33")) {
                        this.ls_similares = "OTRO";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("CMED")) {
                        this.ls_similares = "OTRO";
                        this.ls_similares_2 = "04";
                        this.ls_similares_3 = "01";
                        this.ls_similares_4 = "02";
                        this.ls_similares_5 = "21";
                        this.ls_similares_6 = "05";
                        this.ls_similares_7 = "03";
                        this.ls_similares_8 = "18";
                        this.ls_similares_2_all = "N";
                    }
                    else {
                        this.ls_similares = this.w_CategoriaAutorizacion;
                        this.ls_similares_2_all = "S";
                    }
                }
                else if (this.w_CategoriaAutorizacion.equals("OTRO")) {
                    if (this.conceptoaccesoval.equals("01")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2 = "04";
                        this.ls_similares_3 = "05";
                        this.ls_similares_4 = "02";
                        this.ls_similares_5 = "21";
                        this.ls_similares_6 = "03";
                        this.ls_similares_7 = "CMED";
                        this.ls_similares_8 = "18";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("02")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2 = "04";
                        this.ls_similares_3 = "01";
                        this.ls_similares_4 = "05";
                        this.ls_similares_5 = "21";
                        this.ls_similares_6 = "03";
                        this.ls_similares_7 = "CMED";
                        this.ls_similares_8 = "18";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("03")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2 = "04";
                        this.ls_similares_3 = "01";
                        this.ls_similares_4 = "02";
                        this.ls_similares_5 = "21";
                        this.ls_similares_6 = "05";
                        this.ls_similares_7 = "CMED";
                        this.ls_similares_8 = "18";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("04")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2 = "05";
                        this.ls_similares_3 = "01";
                        this.ls_similares_4 = "02";
                        this.ls_similares_5 = "21";
                        this.ls_similares_6 = "03";
                        this.ls_similares_7 = "CMED";
                        this.ls_similares_8 = "18";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("05")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2 = "04";
                        this.ls_similares_3 = "01";
                        this.ls_similares_4 = "02";
                        this.ls_similares_5 = "21";
                        this.ls_similares_6 = "03";
                        this.ls_similares_7 = "CMED";
                        this.ls_similares_8 = "18";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("07")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("08")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("14")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("15")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("21")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2 = "04";
                        this.ls_similares_3 = "01";
                        this.ls_similares_4 = "02";
                        this.ls_similares_5 = "05";
                        this.ls_similares_6 = "03";
                        this.ls_similares_7 = "CMED";
                        this.ls_similares_8 = "18";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("18")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2 = "04";
                        this.ls_similares_3 = "01";
                        this.ls_similares_4 = "02";
                        this.ls_similares_5 = "21";
                        this.ls_similares_6 = "05";
                        this.ls_similares_7 = "03";
                        this.ls_similares_8 = "CMED";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("19")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("22")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("24")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("25")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("26")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("28")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("29")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("30")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("CMED")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2 = "04";
                        this.ls_similares_3 = "01";
                        this.ls_similares_4 = "02";
                        this.ls_similares_5 = "21";
                        this.ls_similares_6 = "05";
                        this.ls_similares_7 = "03";
                        this.ls_similares_8 = "18";
                        this.ls_similares_2_all = "N";
                    }
                    else if (this.conceptoaccesoval.equals("INAS")) {
                        this.ls_similares = "COMP";
                        this.ls_similares_2_all = "N";
                    }
                    else {
                        this.ls_similares = this.w_CategoriaAutorizacion;
                        this.ls_similares_2_all = "S";
                    }
                }
                else {
                    this.ls_similares = this.w_CategoriaAutorizacion;
                    this.ls_similares_2_all = "S";
                }
                if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
                    this.count = this.getFacAsistencia().getAsAutorizacionServicio().obtenercantidadedicion(this.empleadoval, this.ll_d_1, this.ll_h_1, this.ll_d_2, this.ll_h_2, this.conceptoaccesoval, this.ls_similares_2, this.ls_similares_3, this.ls_similares_4, this.ls_similares_5, this.ls_similares_6, this.ls_similares_7, this.ls_similares_8, this.ls_similares_2_all, this.w_CategoriaAutorizacion, this.ls_similares, this.fechaoriginal, this.conceptoacceso, this.fechadesdeoriginal);
                    if (this.count > 0 && !this.dw_1.getConceptoacceso().equals("CHOR")) {
                        this.setMessageError("Registro ingresado con los mismos datos");
                        return false;
                    }
                }
                if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
                    this.count = this.getFacAsistencia().getAsAutorizacionServicio().obtenercantidad(this.empleadoval, this.ll_d_1, this.ll_h_1, this.ll_d_2, this.ll_h_2, this.conceptoaccesoval, this.ls_similares_2, this.ls_similares_3, this.ls_similares_4, this.ls_similares_5, this.ls_similares_6, this.ls_similares_7, this.ls_similares_8, this.ls_similares_2_all, this.w_CategoriaAutorizacion, this.ls_similares);
                    if (this.count > 0 && !this.dw_1.getConceptoacceso().equals("CHOR")) {
                        this.setMessageError("Registro ingresado con los mismos datos");
                        return false;
                    }
                }
                this.w_tipodia = this.getFacAsistencia().getAS().getAsrepusFuncion().FSqlDevuelveHorario(this.empleadoval, this.ldt_tempd);
                if (UValidador.esNulo((Object)this.w_tipodia)) {
                    this.w_tipodia = 0;
                }
                List data2 = this.getFacAsistencia().getAsTipodiamovimientoServicio().obtenerHoraInicioFlagDiaAnterior(this.w_tipodia);
                if (!UValidador.esListaVacia(data2)) {
                	ldt_horainicio = ((DtoAsTipodiamovimiento) data2.get(0)).getHorainicio();
					ls_FlagDiaAnt = ((DtoAsTipodiamovimiento) data2.get(0)).getFlagdiaant();
                }
                List data3 = this.getFacAsistencia().getAsTipodiamovimientoServicio().obtenerHoraFin(this.w_tipodia);
                if (!UValidador.esListaVacia(data3)) {
                    this.ldt_horafin = ((DtoAsTipodiamovimiento) data3.get(0)).getHorafin();
                    if (!UValidador.esNulo((Object)this.ldt_horafin) && this.ldt_horafin.getHours() == 0 && this.ldt_horafin.getMinutes() == 0 && this.ldt_horafin.getSeconds() == 0) {
                        this.ldt_horafin = UFechaHora.obtenerFechaHoraFinDia(this.ldt_horafin);
                    }
                }
                List data4 = this.getFacAsistencia().getAsTipodiamovimientoServicio().obtenerMaxIntervaloAcceso(this.w_tipodia);
                if (!UValidador.esListaVacia(data4)) {
                    this.ls_INTERVALOACCESO = ((DtoAsTipodiamovimiento)data4.get(0)).getIntervaloacceso();
                }
                if (!UValidador.esCero(this.w_tipodia)) {
                    if (UValidador.esNulo((Object)this.ls_FlagDiaAnt)) {
                        this.ls_FlagDiaAnt = "N";
                    }
                    if (this.ls_FlagDiaAnt.equals("S")) {
                        this.ldt_desde_horario = UFechaHora.obtenerFechaCompuesta(UFechaHora.obtenerFechaMasdias(this.ldt_tempd, Integer.valueOf(-1)), this.ldt_horainicio);
                    }
                    else {
                        this.ldt_desde_horario = UFechaHora.obtenerFechaCompuesta(this.ldt_tempd, this.ldt_horainicio);
                    }
                    if (this.ls_FlagDiaAnt.equals("S")) {
                        if (UFechaHora.obtenerFechaParte(this.ldt_horainicio, "HH") * 100 + UFechaHora.obtenerFechaParte(this.ldt_horainicio, "MI") > UFechaHora.obtenerFechaParte(this.ldt_horafin, "HH") * 100 + UFechaHora.obtenerFechaParte(this.ldt_horafin, "MI")) {
                            this.ldt_hasta_horario = UFechaHora.obtenerFechaCompuesta(this.ldt_temph, this.ldt_horafin);
                        }
                        else {
                            this.ldt_hasta_horario = UFechaHora.obtenerFechaCompuesta(UFechaHora.obtenerFechaMasdias(this.ldt_temph, Integer.valueOf(-1)), this.ldt_horafin);
                        }
                    }
                    else if (UFechaHora.obtenerFechaParte(this.ldt_horainicio, "HH") * 100 + UFechaHora.obtenerFechaParte(this.ldt_horainicio, "MI") > UFechaHora.obtenerFechaParte(this.ldt_horafin, "HH") * 100 + UFechaHora.obtenerFechaParte(this.ldt_horafin, "MI")) {
                        this.ldt_hasta_horario = UFechaHora.obtenerFechaCompuesta(UFechaHora.obtenerFechaMasdias(this.ldt_temph, Integer.valueOf(-1)), this.ldt_horafin);
                    }
                    else {
                        this.ldt_hasta_horario = UFechaHora.obtenerFechaCompuesta(this.ldt_temph, this.ldt_horafin);
                    }
                    this.ldt_desde_ingreso = UFechaHora.obtenerFechaCompuesta(this.ldt_tempd, this.ldt_tempd);
                    if (UFechaHora.obtenerFechaParte(this.ldt_tempd, "HH") * 100 + UFechaHora.obtenerFechaParte(this.ldt_tempd, "MI") > UFechaHora.obtenerFechaParte(this.ldt_temph, "HH") * 100 + UFechaHora.obtenerFechaParte(this.ldt_temph, "MI")) {
                        this.ldt_hasta_ingreso = UFechaHora.obtenerFechaCompuesta(UFechaHora.obtenerFechaMasdias(this.ldt_temph, Integer.valueOf(1)), this.ldt_temph);
                    }
                    else {
                        this.ldt_hasta_ingreso = UFechaHora.obtenerFechaCompuesta(this.ldt_temph, this.ldt_temph);
                    }
                    String sumadeshor = UFechaHora.obtenerFechaParte(this.ldt_desde_horario, "YY") + "0000000000";
                    String sumahashor = UFechaHora.obtenerFechaParte(this.ldt_hasta_horario, "YY") + "0000000000";
                    String sumadesing = UFechaHora.obtenerFechaParte(this.ldt_desde_ingreso, "YY") + "0000000000";
                    String sumahasing = UFechaHora.obtenerFechaParte(this.ldt_hasta_ingreso, "YY") + "0000000000";
                    this.ll_d_1 = Long.valueOf(sumadeshor) + UFechaHora.obtenerFechaParte(this.ldt_desde_horario, "MM") * this.ll_val_01 * 10 + UFechaHora.obtenerFechaParte(this.ldt_desde_horario, "DD") * 1000000 + UFechaHora.obtenerFechaParte(this.ldt_desde_horario, "HH") * 10000 + UFechaHora.obtenerFechaParte(this.ldt_desde_horario, "MI") * 100 + UFechaHora.obtenerFechaParte(this.ldt_desde_horario, "SS");
                    this.ll_h_1 = Long.valueOf(sumahashor) + UFechaHora.obtenerFechaParte(this.ldt_hasta_horario, "MM") * this.ll_val_01 * 10 + UFechaHora.obtenerFechaParte(this.ldt_hasta_horario, "DD") * 1000000 + UFechaHora.obtenerFechaParte(this.ldt_hasta_horario, "HH") * 10000 + UFechaHora.obtenerFechaParte(this.ldt_hasta_horario, "MI") * 100 + UFechaHora.obtenerFechaParte(this.ldt_hasta_horario, "SS");
                    this.ll_d_2 = Long.valueOf(sumadesing) + UFechaHora.obtenerFechaParte(this.ldt_desde_ingreso, "MM") * this.ll_val_01 * 10 + UFechaHora.obtenerFechaParte(this.ldt_desde_ingreso, "DD") * 1000000 + UFechaHora.obtenerFechaParte(this.ldt_desde_ingreso, "HH") * 10000 + UFechaHora.obtenerFechaParte(this.ldt_desde_ingreso, "MI") * 100 + UFechaHora.obtenerFechaParte(this.ldt_desde_ingreso, "SS");
                    this.ll_h_2 = Long.valueOf(sumahasing) + UFechaHora.obtenerFechaParte(this.ldt_hasta_ingreso, "MM") * this.ll_val_01 * 10 + UFechaHora.obtenerFechaParte(this.ldt_hasta_ingreso, "DD") * 1000000 + UFechaHora.obtenerFechaParte(this.ldt_hasta_ingreso, "HH") * 10000 + UFechaHora.obtenerFechaParte(this.ldt_hasta_ingreso, "MI") * 100 + UFechaHora.obtenerFechaParte(this.ldt_hasta_ingreso, "SS");
                    if (this.w_CategoriaAutorizacion.equals("PMP") && ((this.ll_d_2 > this.ll_d_1 && this.ll_d_2 < this.ll_h_1) || (this.ll_h_2 > this.ll_d_1 && this.ll_d_2 < this.ll_h_1)) && this.ls_INTERVALOACCESO != "SOBR") {
                        this.setMessageError("Una permanencia por motivos personales debe estar fuera del horario " + UFechaHora.convertirFechaCadena(this.ldt_desde_horario, "HH:mm") + "\t" + UFechaHora.convertirFechaCadena(this.ldt_hasta_horario, "HH:mm"));
                        return false;
                    }
                    if (!this.w_CategoriaAutorizacion.equals("OMIS") && (!this.w_CategoriaAutorizacion.equals("OTRO") || !this.conceptoaccesoval.equals("VACA")) && !this.w_CategoriaAutorizacion.equals("PMP") && !this.w_CategoriaAutorizacion.equals("SOBR") && UValidador.esCero(UFechaHora.obtenerFechaParte(this.ldt_desde_horario, "HH")) && UValidador.esCero(UFechaHora.obtenerFechaParte(this.ldt_desde_horario, "MI")) && UValidador.esCero(UFechaHora.obtenerFechaParte(this.ldt_hasta_horario, "HH")) && UValidador.esCero(UFechaHora.obtenerFechaParte(this.ldt_hasta_horario, "MI"))) {
                        this.setMessageError("No tiene horario asignado para ese d\u00eda.");
                        return false;
                    }
                }
                if (this.w_CategoriaAutorizacion.equals("COMP") && (this.ll_d_2 < this.ll_d_1 || this.ll_h_2 > this.ll_h_1) && !"04".equals(this.dw_1.getConceptoacceso())) {
                    this.setMessageError("Una compensaci\u00f3n de sobretiempo debe estar dentro del horario \t" + (UValidador.estaVacio(UFechaHora.convertirFechaCadena(this.ldt_desde_horario, "HH:mm")) ? "" : UFechaHora.convertirFechaCadena(this.ldt_desde_horario, "HH:mm")) + "\t" + (UValidador.estaVacio(UFechaHora.convertirFechaCadena(this.ldt_hasta_horario, "HH:mm")) ? "" : UFechaHora.convertirFechaCadena(this.ldt_hasta_horario, "HH:mm")));
                    return false;
                }
                if (this.w_CategoriaAutorizacion.equals("OTRO") && (this.ll_d_2 < this.ll_d_1 || this.ll_h_2 > this.ll_h_1) && this.ls_EXPRESADOEN.equals("H")) {
                    if (UValidador.esNulo((Object)this.ldt_horainicio)) {
                        this.ldt_horainicio = UFechaHora.convertirCadenaFecha("01/01/1990", "dd/MM/yyyy");
                    }
                    if (UValidador.esNulo((Object)this.ldt_horafin)) {
                        this.ldt_horafin = UFechaHora.convertirCadenaFecha("01/01/1990", "dd/MM/yyyy");
                    }
                    if ((!this.ldt_horainicio.after(this.ldt_horafin) || !this.desde.before(this.ldt_horafin) || this.hasta.after(this.ldt_horafin) || this.ldt_horainicio.before(this.desde)) && !this.conceptoaccesoval.equals("CHOR") && !UFechaHora.obtenerNumeroDiaSemana(this.ld_temporal).equals(1) && !UFechaHora.obtenerNumeroDiaSemana(this.ld_temporal).equals(7)) {
                        this.setMessageError("Estos eventos deben estar dentro del horario \t" + (UValidador.esNulo((Object)this.ldt_desde_horario) ? "" : UFechaHora.convertirFechaCadena(this.ldt_desde_horario, "HH:mm")) + "\t" + (UValidador.esNulo((Object)this.ldt_hasta_horario) ? "" : UFechaHora.convertirFechaCadena(this.ldt_hasta_horario, "HH:mm")));
                        return false;
                    }
                }
                AsConceptoacceso objCon = new AsConceptoacceso();
                objCon.getPk().setConceptoacceso(this.dw_1.getConceptoacceso());
                objCon = (AsConceptoacceso)this.getFacAsistencia().getAsConceptoaccesoServicio().obtenerPorId((Serializable)objCon.getPk());
                if (!UValidador.esNulo((Object)objCon)) {
                    if ("S".equals(objCon.getFlagnumerosrestriccion()) && UValidador.esNulo((Object)objCon.getFechainiciorestriccion())) {
                        BigDecimal horas = objCon.getNumerohorasmesesrestriccion();
                        BigDecimal meses = objCon.getCantidadmesesrestriccion();
                        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
                            if (UValidador.esNulo((Object)this.fechainiOriginal)) {
                                this.fechainiOriginal = this.dw_1.getFecha();
                            }
                            if (UValidador.esNulo((Object)this.fechafinOriginal)) {
                                this.fechafinOriginal = this.dw_1.getFechafin();
                            }
                        }
                        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
                            this.fechainiOriginal = UFechaHora.convertirCadenaFecha("01/01/1900", "dd/MM/yyyy");
                            this.fechafinOriginal = UFechaHora.convertirCadenaFecha("01/01/1900", "dd/MM/yyyy");
                        }
                        BigDecimal horasConRes = this.getFacAsistencia().getAsAutorizacionServicio().sumarConRes(this.dw_1.getEmpleado(), this.dw_1.getConceptoacceso(), this.dw_1.getFecha(), UFechaHora.addMesesToDate(this.dw_1.getFecha(), meses.intValue()), this.fechainiOriginal, this.fechafinOriginal);
                        BigDecimal w_diftiempo = this.wf_diftiempo(this.dw_1.getDesde1(), this.dw_1.getHasta1()).divide(BigDecimal.valueOf(3600L), 2, RoundingMode.HALF_DOWN);
                        w_diftiempo = w_diftiempo.subtract(this.obtenerHorasRefrigerio());
                        if (horasConRes.add(w_diftiempo).compareTo(horas) == 1) {
                            this.setMessageError("Se est\u00e1 superando la cantidad m\u00e1ximas de horas permitidas (" + horas + ") en el periodo: " + UFechaHora.convertirFechaCadena(this.dw_1.getFecha(), "MM") + "-" + UFechaHora.convertirFechaCadena(this.dw_1.getFecha(), "yyyy"));
                            return false;
                        }
                    }
                    if (this.w_CategoriaAutorizacion.equals("SOBR") && this.conceptoaccesoval.equals("PAHE")) {
                        objCon = new AsConceptoacceso();
                        objCon.getPk().setConceptoacceso("PAHE");
                        objCon = (AsConceptoacceso)this.getFacAsistencia().getAsConceptoaccesoServicio().obtenerPorId((Serializable)objCon.getPk());
                        this.fechaparaferiado = UFechaHora.convertirFechaCadena(this.ld_temporal, "DDMMYYYY");
                        for (int i = 0; i < this.dw_feriados.size(); ++i) {
                            DtoDwMaPrCalendarioferiadosProcesoSarg obj = this.dw_feriados.get(i);
                            if (obj.getEstado().equals("A") && obj.getFechamesdia().equals(this.fechaparaferiado)) {
                                this.filaencontrada = i;
                            }
                        }
                        if (this.filaencontrada >= 0) {
                            this.ib_esferiado = true;
                        }
                        else {
                            this.ib_esferiado = false;
                        }
                        if (!this.ib_esferiado) {
                            lds_tipodia = (List<DtoDwAsAutorizacionPreprocesoTipodia>)this.getFacAsistencia().getAS().getAsmainDatawindow().DwAsAutorizacionPreprocesoTipodia(this.w_tipodia);
                            this.ld_hora_entrada_t1 = null;
                            this.ld_hora_salida_t1 = null;
                            Date auxhora = null;
                            this.w_fila = 0;
                            while (this.w_fila < lds_tipodia.size()) {
                                this.w_intervaloacceso = lds_tipodia.get(this.w_fila).getIntervaloacceso();
                                auxhora = lds_tipodia.get(this.w_fila).getHorainicio();
                                this.ld_hora_entrada_t1 = auxhora;
                                auxhora = lds_tipodia.get(this.w_fila).getHorafin();
                                this.ld_hora_salida_t1 = auxhora;
                                if (UValidador.estaVacio(this.w_intervaloacceso)) {
                                    this.w_intervaloacceso = "";
                                }
                                if (!this.w_intervaloacceso.equals("FUER") && !this.w_intervaloacceso.equals("SOBR") && UFechaHora.obtenerFechaParte(this.dw_1.getDesde1(), "HH") < UFechaHora.obtenerFechaParte(this.ld_hora_salida_t1, "HH") && UFechaHora.obtenerFechaParte(this.dw_1.getHasta1(), "HH") > UFechaHora.obtenerFechaParte(this.ld_hora_entrada_t1, "HH")) {
                                    this.setMessageError("El rango establecido debe estar fuera del rango " + UFechaHora.convertirFechaCadena(this.ld_hora_entrada_t1, "HH:mm") + " - " + UFechaHora.convertirFechaCadena(this.ld_hora_salida_t1, "HH:mm") + ".");
                                    return false;
                                }
                                ++this.w_fila;
                            }
                        }
                        String ls_FlagNumerosRestriccion = null;
                        BigDecimal ll_CantidadMesesRestriccion = null;
                        BigDecimal ll_NumeroHorasMesesRestriccion = null;
                        BigDecimal ll_CantidadMesesRestriccionCAS = BigDecimal.ZERO;
                        Date ld_FechaInicioRestriccion = null;
                        Date ld_fechaingreso = null;
                        Date ld_fechacorte = null;
                        Date ld_fecharegistro = this.dw_1.getFecha();
                        Date ld_desderegistro = this.dw_1.getDesde1();
                        String ls_desderegistro_yyyymm = UFechaHora.convertirFechaCadena(ld_desderegistro, "YYYYMM");
                        String ls_desderegistro_yyyymmDD = UFechaHora.convertirFechaCadena(ld_desderegistro, "yyyyMMdd");
                        Date ld_hastaregistro = this.dw_1.getHasta1();
                        if (UFechaHora.convertirFechaCadena(ld_desderegistro, "HH:mm:ss").trim().equals("00:00:00") && UFechaHora.convertirFechaCadena(ld_hastaregistro, "HH:mm:ss").trim().equals("00:00:00")) {
                            this.setMessageError("Para la autorizaci\u00f3n de Horas Extras, No es valido estas horas.");
                            this.opciones.setIsmostrardesde1(Boolean.valueOf(true));
                            this.opciones.setIsmostrarhasta1(Boolean.valueOf(true));
                            return false;
                        }
                        AsCarnetidentificacion asCarnetidentificacion = this.getFacAsistencia().getAsCarnetidentificacionServicio().obtenerPorEmplado(this.dw_1.getEmpleado());
                        if (!UValidador.esNulo((Object)asCarnetidentificacion) && !"S".equals(asCarnetidentificacion.getFlgexonerasobr())) {
                            AsArea area = this.getFacAsistencia().getAsAreaServicio().obtenerArea(this.getUsuarioActual().getIdPersona(), this.getUsuarioActual().getCompaniaSocioCodigo());
                            if ("S".equals(area.getFlagexondirectiva())) {
                                Date fechalimite1 = this.dw_1.getFecha();
                                Date fechalimite2 = this.dw_1.getFechafin();
                                ll_NumeroHorasMesesRestriccion = BigDecimal.valueOf(area.getnNroHoras());
                                fechalimite1 = UFechaHora.obtenerPrimerDiaMesFecha(fechalimite1);
                                fechalimite2 = UFechaHora.obtenerUltimoDiaMesFecha(fechalimite2);
                                ll_CantidadMesesRestriccionCAS = this.getFacAsistencia().getAsAutorizacionServicio().obtenerHorasSobreTiempo(this.dw_1.getEmpleado(), fechalimite1, fechalimite2);
                                if (UValidador.esNulo((Object)ll_CantidadMesesRestriccionCAS)) {
                                    ll_CantidadMesesRestriccionCAS = BigDecimal.ZERO;
                                }
                                double ll_cantidadhorasregistro = UFechaHora.obtenerDiferenciaSegundos(UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), ld_desderegistro), UFechaHora.obtenerFechaCompuesta(this.dw_1.getFechafin(), ld_hastaregistro)) / 3600.0;
                                BigDecimal ll_minutarthhee = this.getFacAsistencia().getAsAutorizacionServicio().obtenerMinutosSobreTiempo(this.dw_1.getEmpleado(), fechalimite1, fechalimite2);
                                if (ll_minutarthhee == null) {
                                    ll_minutarthhee = BigDecimal.ZERO;
                                }
                                ll_minutarthhee = ll_minutarthhee.divide(new BigDecimal(60.0), 2, 4);
                                if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
                                    BigDecimal ll_minutarthhee2 = this.getFacAsistencia().getAsAutorizacionServicio().obtenerMinutosSobreTiempo2(this.dw_1.getEmpleado(), fechalimite1);
                                    if (UValidador.esNulo((Object)ll_minutarthhee2)) {
                                        ll_minutarthhee2 = BigDecimal.ZERO;
                                    }
                                    ll_minutarthhee2 = ll_minutarthhee2.divide(new BigDecimal(60.0), 2, 4);
                                    if (UValidador.esNulo((Object)ll_CantidadMesesRestriccionCAS)) {
                                        ll_CantidadMesesRestriccionCAS = BigDecimal.ZERO;
                                    }
                                    if (UValidador.esNulo((Object)ll_cantidadhorasregistro)) {
                                        ll_cantidadhorasregistro = 0.0;
                                    }
                                    if (ll_CantidadMesesRestriccionCAS.add(new BigDecimal(ll_cantidadhorasregistro)).subtract(ll_minutarthhee).subtract(ll_minutarthhee2).compareTo(ll_NumeroHorasMesesRestriccion) == 1) {
                                        BigDecimal hhees = ll_CantidadMesesRestriccionCAS.add(new BigDecimal(ll_cantidadhorasregistro)).subtract(ll_minutarthhee).setScale(2, RoundingMode.HALF_UP);
                                        this.setMessageError("'Las Horas Extras ser\u00edan: " + this.f_cent2sexTexto(hhees) + ". Las cuales estan superando la cantidad maxima: " + ll_NumeroHorasMesesRestriccion + " horas, en el periodo: " + UFechaHora.convertirFechaCadena(fechalimite1, "dd/MM/yyyy") + " al " + UFechaHora.convertirFechaCadena(fechalimite2, "dd/MM/yyyy"));
                                        return false;
                                    }
                                }
                                if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
                                    BigDecimal ll_cantidadhoras_hhee = this.getFacAsistencia().getAsAutorizacionServicio().obtenerHorasSobreTiempo2(this.dw_1.getEmpleado(), ls_desderegistro_yyyymmDD);
                                    if (UValidador.esNulo((Object)ll_cantidadhoras_hhee)) {
                                        ll_cantidadhoras_hhee = BigDecimal.ZERO;
                                    }
                                    BigDecimal hhees = ll_CantidadMesesRestriccionCAS.subtract(ll_cantidadhoras_hhee).add(new BigDecimal(ll_cantidadhorasregistro)).subtract(ll_minutarthhee);
                                    hhees = hhees.setScale(2, RoundingMode.HALF_DOWN);
                                    if (ll_CantidadMesesRestriccionCAS.subtract(ll_cantidadhoras_hhee).add(new BigDecimal(ll_cantidadhorasregistro)).subtract(ll_minutarthhee).compareTo(ll_NumeroHorasMesesRestriccion) == 1) {
                                        this.setMessageError("'Las Horas Extras ser\u00edan: " + this.f_cent2sexTexto(hhees.setScale(2, RoundingMode.HALF_UP)) + ". Las cuales estan superando la cantidad maxima: " + ll_NumeroHorasMesesRestriccion + " horas, en el periodo: " + UFechaHora.convertirFechaCadena(fechalimite1, "dd/mm/yyyy") + " al " + UFechaHora.convertirFechaCadena(fechalimite2, "dd/MM/yyyy"));
                                        return false;
                                    }
                                }
                            }
                            else {
                                double ll_cantidadhorasregistro = UFechaHora.obtenerDiferenciaSegundos(UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), ld_desderegistro), UFechaHora.obtenerFechaCompuesta(this.dw_1.getFechafin(), ld_hastaregistro)) / 3600.0;
                                if (!UValidador.esNulo((Object)objCon)) {
                                    ls_FlagNumerosRestriccion = objCon.getFlagnumerosrestriccion();
                                    ll_CantidadMesesRestriccion = objCon.getCantidadmesesrestriccion();
                                    ll_NumeroHorasMesesRestriccion = objCon.getNumerohorasmesesrestriccion();
                                    ld_FechaInicioRestriccion = objCon.getFechainiciorestriccion();
                                }
                                if (UValidador.estaVacio(ls_FlagNumerosRestriccion)) {
                                    ls_FlagNumerosRestriccion = "N";
                                }
                                if (ls_FlagNumerosRestriccion.equals("S")) {
                                    String ls_fechainiciorestriccion = UFechaHora.convertirFechaCadena(ld_FechaInicioRestriccion, "YYYYMM");
                                    if (ll_CantidadMesesRestriccion.intValue() > 0) {
                                        ld_fecharegistro = this.dw_1.getFecha();
                                        ld_fechacorte = ld_FechaInicioRestriccion;
                                        Empleadomast emp = (Empleadomast)this.getFacCore().getEmpleadomastServicio().obtenerPorId((Serializable)new EmpleadomastPk(this.dw_1.getEmpleado(), this.getUsuarioActual().getCompaniaSocioCodigo()));
                                        if (!UValidador.esNulo((Object)emp)) {
                                            ld_fechaingreso = emp.getFechaingreso();
                                        }
                                        Date ld_fechainiciobase;
                                        if (ld_fechaingreso.getTime() > ld_fechacorte.getTime()) {
                                            ld_fechainiciobase = ld_fechaingreso;
                                        }
                                        else {
                                            ld_fechainiciobase = ld_fechacorte;
                                        }
                                        Date ld_fechainiciotemp = ld_fechainiciobase;
                                        BigDecimal ll_cantidadiasfechas = BigDecimal.valueOf(UFechaHora.obtenerDiasTranscurridos(ld_fecharegistro, ld_fechainiciotemp) + 1);
                                        BigDecimal ldc_bloquesmeses = ll_cantidadiasfechas.divide(ll_CantidadMesesRestriccion.multiply(BigDecimal.valueOf(30L)), 2, 4);
                                        int ll_bloquesmeses;
                                        if (ldc_bloquesmeses.subtract(BigDecimal.valueOf(ldc_bloquesmeses.intValue())).equals(BigDecimal.ZERO)) {
                                            ll_bloquesmeses = ldc_bloquesmeses.intValue();
                                        }
                                        else {
                                            ll_bloquesmeses = ldc_bloquesmeses.intValue() + 1;
                                        }
                                        int ll_cantidadbloques = 1;
                                        do {
                                            ld_fechainiciotemp = UFechaHora.addMesesToDate(ld_fechainiciotemp, ll_CantidadMesesRestriccion.intValue());
                                        } while (++ll_cantidadbloques < ll_bloquesmeses);
                                        ld_fechainiciobase = UFechaHora.addMesesToDate(ld_fecharegistro, -1 * ll_CantidadMesesRestriccion.intValue());
                                        Date ld_fechainiciosemestre = ld_fechainiciotemp;
                                        Date ld_fechafinsemestre = UFechaHora.addMesesToDate(ld_fechainiciosemestre, ll_CantidadMesesRestriccion.intValue());
                                        ld_fechafinsemestre = UFechaHora.anadirDiasAFechas(ld_fechafinsemestre, -1);
                                        ll_CantidadMesesRestriccionCAS = this.getFacAsistencia().getAsAutorizacionServicio().obtenerHorasSobreTiempo(this.dw_1.getEmpleado(), ld_fechainiciosemestre, ld_fechafinsemestre);
                                        BigDecimal ll_minutarthhee = this.getFacAsistencia().getAsAutorizacionServicio().obtenerMinutosSobreTiempo(this.dw_1.getEmpleado(), ld_fechainiciosemestre, ld_fechafinsemestre);
                                        if (ll_minutarthhee == null) {
                                            ll_minutarthhee = BigDecimal.ZERO;
                                        }
                                        ll_minutarthhee = ll_minutarthhee.divide(new BigDecimal(60.0), 2, 4);
                                        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
                                            BigDecimal ll_minutarthhee2 = this.getFacAsistencia().getAsAutorizacionServicio().obtenerMinutosSobreTiempo2(this.dw_1.getEmpleado(), ld_fecharegistro);
                                            if (UValidador.esNulo((Object)ll_minutarthhee2)) {
                                                ll_minutarthhee2 = BigDecimal.ZERO;
                                            }
                                            ll_minutarthhee2 = ll_minutarthhee2.divide(new BigDecimal(60.0), 2, 4);
                                            if (UValidador.esNulo((Object)ll_CantidadMesesRestriccionCAS)) {
                                                ll_CantidadMesesRestriccionCAS = BigDecimal.ZERO;
                                            }
                                            if (UValidador.esNulo((Object)ll_cantidadhorasregistro)) {
                                                ll_cantidadhorasregistro = 0.0;
                                            }
                                            BigDecimal hhees2 = ll_CantidadMesesRestriccionCAS.add(new BigDecimal(ll_cantidadhorasregistro)).subtract(ll_minutarthhee).subtract(ll_minutarthhee2).setScale(2, RoundingMode.HALF_UP);
                                            if (ll_CantidadMesesRestriccionCAS.add(new BigDecimal(ll_cantidadhorasregistro)).subtract(ll_minutarthhee).subtract(ll_minutarthhee2).compareTo(ll_NumeroHorasMesesRestriccion) == 1) {
                                                this.setMessageError("'Las Horas Extras ser\u00edan: " + this.f_cent2sexTexto(hhees2) + ". Las cuales estan superando la cantidad m\u00e1xima: " + ll_NumeroHorasMesesRestriccion + " horas, en el semestre: " + UFechaHora.convertirFechaCadena(ld_fechainiciosemestre, "dd/MM/yyyy") + " al " + UFechaHora.convertirFechaCadena(ld_fechafinsemestre, "dd/MM/yyyy"));
                                                return false;
                                            }
                                        }
                                        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
                                            BigDecimal ll_cantidadhoras_hhee = this.getFacAsistencia().getAsAutorizacionServicio().obtenerHorasSobreTiempo2(this.dw_1.getEmpleado(), ls_desderegistro_yyyymmDD);
                                            if (UValidador.esNulo((Object)ll_cantidadhoras_hhee)) {
                                                ll_cantidadhoras_hhee = BigDecimal.ZERO;
                                            }
                                            BigDecimal hhees2 = ll_CantidadMesesRestriccionCAS.subtract(ll_cantidadhoras_hhee).add(new BigDecimal(ll_cantidadhorasregistro)).subtract(ll_minutarthhee);
                                            hhees2 = hhees2.setScale(2, RoundingMode.HALF_DOWN);
                                            if (ll_CantidadMesesRestriccionCAS.subtract(ll_cantidadhoras_hhee).add(new BigDecimal(ll_cantidadhorasregistro)).subtract(ll_minutarthhee).compareTo(ll_NumeroHorasMesesRestriccion) == 1) {
                                                this.setMessageError("'Las Horas Extras ser\u00edan: " + this.f_cent2sexTexto(hhees2.setScale(2, RoundingMode.HALF_UP)) + ". Las cuales estan superando la cantidad maxima: " + ll_NumeroHorasMesesRestriccion + " horas, en el semestre: " + UFechaHora.convertirFechaCadena(ld_fechainiciosemestre, "dd/mm/yyyy") + " al " + UFechaHora.convertirFechaCadena(ld_fechafinsemestre, "dd/MM/yyyy"));
                                                return false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                this.ld_temporal = UFechaHora.obtenerFechaHoraInicioDia(UFechaHora.obtenerFechaMasdias(this.ld_temporal, Integer.valueOf(1)));
                if (!"34".equals(this.dw_1.getConceptoacceso()) || !"A".equals(this.dw_1.getEstado())) {
                    continue;
                }
                boolean flgAprueba34 = false;
                List<Seguridadperfilusuario> perfiles = (List<Seguridadperfilusuario>)this.getFacSeguridad().getSeguridadperfilusuarioServicio().listarPerfilActivoXUsuario(this.getUsuarioActual().getCodigoUsuario());
                if (!UValidador.esListaVacia((List)perfiles)) {
                    for (Seguridadperfilusuario per : perfiles) {
                        if ("AS09".equalsIgnoreCase(per.getPk().getPerfil())) {
                            flgAprueba34 = true;
                        }
                    }
                }
                if (!flgAprueba34) {
                    Usuario objUsu = (Usuario)this.getFacSeguridad().getUsuarioServicio().obtenerPorId((Serializable)new UsuarioPk("AS09"));
                    this.setMessageError("Para procesar este concepto debe tener asigando el perfil " + objUsu.getNombre());
                    return false;
                }
            }
        }
        this.Estado = this.dw_1.getEstado();
        if (this.Estado.equals("R")) {
            this.enviarCorreo = true;
            this.getWebControlContext().actualizar("dgNuevaSolicitud");
            this.getWebControlContext().ejecutar("PF('popNuevaSolicitud').show()");
            return false;
        }
        if (this.Estado.equals("A") && this.dw_1.getConceptoacceso().equals("34")) {
            this.enviarCorreo = true;
        }
        return this.validarPosNuevaSolicitud();
    }
    
    public String nuevaSolicitud() throws Exception {
        this.dw_1.setEstado("S");
        if (this.validarPosNuevaSolicitud()) {
            this.wf_update();
            CwAsAutorizacionPreprocesoAprobacionSIGED.getInstance().iniciarControladora();
            if (UValidador.esNulo((Object)this.enviarCorreo)) {
                this.enviarCorreo = false;
            }
            if (!UValidador.estaVacio(CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from()) && ((this.dw_1.getEstado().equals("S") && CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) || this.enviarCorreo)) {
                this.enviarCorreo();
            }
            return "wasautorizacionpreprocesoaprobacionSIGED";
        }
        return null;
    }
    
    public Boolean validarPosNuevaSolicitud() throws Exception {
        if (!this.opciones.getIsmostrarfechafin()) {
            return true;
        }
        if (UFechaHora.obtenerFechaHoraInicioDiaDate(this.dw_1.getFechafin()).after(UFechaHora.obtenerFechaHoraInicioDiaDate(this.dw_1.getFecha()))) {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("busqueda_nombreTipoBusqueda", "listarOcurrencias");
            param.put("str_parametros1", this.dw_1.getFecha());
            param.put("str_parametros2", this.dw_1.getFechafin());
            param.put("str_parametros3", this.dw_1.getDesde1());
            param.put("str_parametros4", this.dw_1.getHasta1());
            if (this.dw_1.getConceptoacceso().equals("CHOR")) {
                param.put("str_parametros5", this.dw_horario);
            }
            MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
            mensajeGenerico.setParametros((Map)param);
            CwAsAutorizacionPreprocesoHextraMsgSIGED.getInstance().mensaje(mensajeGenerico);
            return false;
        }
        return this.validarDespuesdeIntervalos();
    }
    
    public Boolean validarDespuesdeIntervalos() throws Exception {
        if (this.w_CategoriaAutorizacion.equals("SOBR")) {
            this.ldt_fecha_hora_salida = this.getFacAsistencia().getAS().getAsrepusFuncion().FAsAutorizacionPreprocesoTipodia(this.empleadoval, this.fechaval);
            if (!UValidador.esNulo((Object)this.ldt_fecha_hora_salida)) {
                this.ld_hora_salida_t = this.ldt_fecha_hora_salida;
                if (!this.dw_1.getHasta1().after(this.ld_hora_salida_t)) {
                    this.setMessageError("La hora fin establecida debe ser mayor a " + UFechaHora.convertirFechaCadena(this.ld_hora_salida_t, "HH:mm"));
                    return false;
                }
            }
        }
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add") || CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
            if (this.w_CategoriaAutorizacion.equals("COMP") && UValidador.esListaVacia((List)this.dw_diascompensados)) {
                this.setMessageError("Debe generar la Asistencia para realizar la compensaci\u00f3n.");
                return false;
            }
            if (UValidador.esListaVacia((List)this.dw_diascompensados)) {
                return true;
            }
            Integer w_seleccionados = 0;
            String w_Saldo_Selec_HHMM = null;
            String w_Compensacion_HHMM = null;
            BigDecimal sumadiferencianumero = BigDecimal.ZERO;
            BigDecimal saldohorasganadas = BigDecimal.ZERO;
            if (this.w_CategoriaAutorizacion.equals("COMP")) {
                for (int i = 0; i < this.dw_diascompensados.size(); ++i) {
                    DtoDwAsAsistenciaHextraEdit obj = this.dw_diascompensados.get(i);
                    sumadiferencianumero = sumadiferencianumero.add(obj.getDiferencia());
                    if (obj.getIsseleccionado()) {
                        saldohorasganadas = saldohorasganadas.add(obj.getDiferencia());
                        ++w_seleccionados;
                    }
                }
                if (UValidador.esCero(w_seleccionados)) {
                    this.setMessageError("Debe seleccionar por lo menos un registro para compensar.");
                    return false;
                }
                this.w_horainicio = this.dw_1.getDesde1();
                this.w_horafin = this.dw_1.getHasta1();
                if ("04".equals(this.dw_1.getConceptoacceso())) {
                    this.w_horainicio = this.desdeGlobal;
                    this.w_horafin = this.hastaGlobal;
                }
                this.w_diftiempo = this.wf_diftiempo(this.w_horainicio, this.w_horafin).divide(BigDecimal.valueOf(3600L), 2, 4);
                this.w_diftiempo = this.w_diftiempo.subtract(this.obtenerHorasRefrigerio());
                Integer dias = UFechaHora.obtenerDiasTranscurridos(this.dw_1.getFechafin(), this.dw_1.getFecha()) + 1;
                this.w_diftiempo = this.w_diftiempo.multiply(new BigDecimal(dias));
                w_Saldo_Selec_HHMM = this.obtenerHorasAcumuladas(saldohorasganadas);
                w_Compensacion_HHMM = this.obtenerHorasAcumuladas(this.w_diftiempo);
                if (this.w_diftiempo.compareTo(saldohorasganadas) == 1 && Math.abs(this.w_diftiempo.subtract(saldohorasganadas).doubleValue()) > 0.01) {
                    this.setMessageError("No puede asignar una compensaci\u00f3n de " + w_Compensacion_HHMM + " (hh:mm) con " + w_Saldo_Selec_HHMM + " (hh:mm)");
                    return false;
                }
                Date fechahora = UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), this.w_horainicio);
                Integer existe = this.getFacAsistencia().getAsAutorizacionfechaServicio().obtenercantidadAutorizacionFecha(this.dw_1.getEmpleado(), fechahora);
                if (existe > 0) {
                    this.setMessageError("Ya existe una compensaci\u00f3n con la fecha ingresada.");
                    return false;
                }
            }
        }
        return true;
    }
    
    public BigDecimal getW_diftiempo() {
        return this.w_diftiempo;
    }
    
    public void setW_diftiempo(BigDecimal w_diftiempo) {
        this.w_diftiempo = w_diftiempo;
    }
    
    public void sumarHoras() {
        Integer w_seleccionados = 0;
        BigDecimal sumadiferencianumero = BigDecimal.ZERO;
        BigDecimal saldohorasganadas = BigDecimal.ZERO;
        for (int i = 0; i < this.dw_diascompensados.size(); ++i) {
            DtoDwAsAsistenciaHextraEdit obj = this.dw_diascompensados.get(i);
            sumadiferencianumero = sumadiferencianumero.add(obj.getDiferencia());
            if (obj.getIsseleccionado()) {
                saldohorasganadas = saldohorasganadas.add(obj.getDiferencia());
                ++w_seleccionados;
            }
        }
        this.horasSumadas = this.obtenerHorasAcumuladas(saldohorasganadas);
    }
    
    public String guardarDesdeIntervalos() throws Exception {
        if (this.validarDespuesdeIntervalos() && !UValidador.esCero(this.wf_update())) {
            if (this.dw_1.getEstado().equals("S") && (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add") || this.enviarCorreo)) {
                this.enviarCorreo();
            }
            if (!UValidador.esNulo((Object)this.notificarlicenciasingoce())) {
                if (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Delete")) {
                    if ("A".equals(this.dw_1.getEstado())) {
                        this.setMessageSuccess("Se registr\u00f3 la autorizaci\u00f3n correctamente", Boolean.valueOf(true));
                    }
                    if ("S".equals(this.dw_1.getEstado())) {
                        this.setMessageSuccess("Se registr\u00f3 la solicitud correctamente", Boolean.valueOf(true));
                    }
                }
                CwAsAutorizacionPreprocesoAprobacionSIGED.getInstance().iniciarControladora();
                return "wasautorizacionpreprocesoaprobacionSIGED";
            }
            this.getWebControlContext().ejecutar("PF('popIntervalosAutorizacionSIGED').hide()");
        }
        return null;
    }
    
    private String notificarlicenciasingoce() throws Exception {
        if (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Delete") && this.dw_1.getConceptoacceso().equals("14")) {
            Integer diasmax = this.getFacCore().getParametrosmastServicio().obtenerValorInteger(new ParametrosmastPk("AS", "999999", "NDIAMAXLIC"));
            if (UValidador.esNulo((Object)diasmax)) {
                diasmax = 0;
            }
            this.licencias = (List<DtoAsAutorizacion>)this.getFacAsistencia().getAsAutorizacionServicio().listarLicenciasSinGoce(this.dw_1.getEmpleado());
            Integer cantlic = 0;
            if (!UValidador.esListaVacia((List)this.licencias)) {
                for (DtoAsAutorizacion obj : this.licencias) {
                    Integer dias = this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(obj.getFecha(), obj.getFechahasta());
                    cantlic += dias;
                    obj.setVeces(dias);
                }
            }
            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("cantlic " + cantlic));
            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("diasmax " + diasmax));
            if (cantlic >= diasmax) {
                this.mensajelicencia = "Usted ha alcanzado el m\u00e1ximo de " + diasmax + " licencia(s) en este a\u00f1o.";
                this.getWebControlContext().actualizar("dgAlertaLicencia");
                this.getWebControlContext().ejecutar("PF('popAlertaLicencia').show()");
                return null;
            }
        }
        return "wasautorizacionpreprocesoaprobacionSIGED";
    }
    
    public String prepararDatosMantenimiento() throws Exception {
        return null;
    }
    
    public String prepararDatosListado() throws Exception {
        return null;
    }
    
    public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {
        if (mensajeControllerGenerico.getParametros().get("busqueda_nombreTipoBusqueda").equals("edicionAutorizacion")) {
            this.ishorariodiasiguiente = false;
            this.iscambioonceptoevento = false;
            this.conceptoSeleccionado = null;
            DtoDwAsAutorizacionPreprocesoHextra objext = (DtoDwAsAutorizacionPreprocesoHextra)mensajeControllerGenerico.getParametros().get("autorizacion");
            if (!UValidador.esNulo((Object)objext)) {
                AsAutorizacionPk pk = new AsAutorizacionPk();
                pk.setEmpleado(objext.getEmpleado());
                pk.setFecha(objext.getFecha());
                pk.setDesde(objext.getDesde1());
                pk.setConceptoacceso(objext.getConceptoacceso());
                AsAutorizacion obj = (AsAutorizacion)this.getFacAsistencia().getAsAutorizacionServicio().obtenerPorId((Serializable)pk, false);
                this.dw_1 = new DtoDwAsAutorizacionPreprocesoHextraeditV2();
                if (!UValidador.esNulo((Object)obj)) {
                    this.dw_1.setEmpleado(Integer.valueOf(obj.getPk().getEmpleado().intValue()));
                    this.dw_1.setFecha(obj.getPk().getFecha());
                    this.dw_1.setFechafin(obj.getFechafin());
                    this.dw_1.setConceptoacceso(obj.getPk().getConceptoacceso());
                    this.dw_1.setCategoriaautorizacion(obj.getCategoriaautorizacion());
                    this.dw_1.setComportamientosobretiempo(obj.getComportamientosobretiempo());
                    this.dw_1.setEstadoai(objext.getEstadoai());
                    this.dw_1.setDesde1(obj.getPk().getDesde());
                    this.dw_1.setDesde2(objext.getDesde2());
                    this.dw_1.setHasta1(obj.getHasta());
                    this.dw_1.setHasta2(objext.getHasta2());
                    this.dw_1.setPuesto(objext.getPuestodes());
                    this.dw_1.setCentrocosto(objext.getCentrocostodes());
                    this.dw_1.setPeriodo(obj.getPeriodo());
                    this.dw_1.setEmpleadonombre(objext.getNombrecompleto());
                    this.dw_1.setEstado(obj.getEstado());
                    this.dw_1.setFechaautorizacion(obj.getFechaautorizacion());
                    this.dw_1.setFechasolicitud(obj.getFechasolicitud());
                    this.dw_1.setSolicitadopor(obj.getSolicitadopor());
                    this.dw_1.setAutorizadopor(obj.getAutorizadopor());
                    this.dw_1.setAprobadoJefePor(obj.getAprobadoJefePor());
                    this.dw_1.setFechaAprobadoJefe(obj.getFechaAprobadoJefe());
                    this.dw_1.setAprobadoJefePorNombre(this.obtenerNombreUsuario(obj.getAprobadoJefePor()));
                    this.dw_1.setFlagAprobadoJefe(obj.getFlagAprobadoJefe());
                    this.dw_1.setObservacion(obj.getObservacion());
                    this.dw_1.setNroresolucion(obj.getNroresolucion());
                    this.dw_1.setFecharesolucion(obj.getFecharesolucion());
                    this.dw_1.setMandatario(obj.getMandatorio());
                    this.dw_1.setRefrigerio(obj.getRefrigerio());
                    this.dw_1.setTerminal(Integer.valueOf(obj.getTerminal().intValue()));
                    this.dw_1.setTipohorario(Integer.valueOf(obj.getTipohorario().intValue()));
                    this.dw_1.setUltimousuario(obj.getUltimoUsuario());
                    this.dw_1.setUltimafechamodif(obj.getUltimaFechaModif());
                    this.dw_1.setRutadocumento(obj.getRutadocumento());
                    String pathPrincipal = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/");
                    this.dw_1.setRutacompleta(String.valueOf(pathPrincipal) + File.separator + "temporaloefa" + File.separator + this.dw_1.getRutadocumento());
                    this.dw_1.setRutacompletadj(String.valueOf(pathPrincipal) + File.separator + "temporaloefa" + File.separator + this.dw_1.getNombrearchivodj());
                    this.dw_1.setUuidalfresco(obj.getUuidalfresco());
                    this.dw_1.setNombrearchivodj(obj.getNombrearchivodj());
                    this.dw_1.setUuiddj(obj.getUuiddj());
                    this.dw_1.setTienearchivo(false);
                    this.dw_1.setTipoautorizacion(obj.getTipoautorizacion());
                    this.dw_1.setRechazadopor(obj.getRechazadopor());
                    this.dw_1.setFecharechazo(obj.getFecharechazo());
                    this.dw_1.setSolicitadopornombre(this.obtenerNombreUsuario(this.dw_1.getSolicitadopor()));
                    this.dw_1.setAutorizadopornombre(this.obtenerNombreUsuario(this.dw_1.getAutorizadopor()));
                    this.dw_1.setRechazadopornombre(this.obtenerNombreUsuario(this.dw_1.getRechazadopor()));
                    this.dw_1.setUltimousuarionombre(this.obtenerNombreUsuario(this.dw_1.getUltimousuario()));
                    this.dw_1.setDesderecupera(obj.getDesderecupera());
                    this.dw_1.setHastarecupera(obj.getHastarecupera());
                    this.dw_1.setPeriodoplanilla(obj.getPeriodoplanilla());
                    if (!UValidador.estaVacio(this.dw_1.getRutadocumento())) {
                        this.dw_1.setTienearchivo(true);
                    }
                    if (!UValidador.estaVacio(this.dw_1.getNombrearchivodj())) {
                        this.blDeclaracionjurada = true;
                        this.blVerDeclaracionjurada = true;
                    }
                }
                this.iniciarControladora();
                this.cargarInfoEmpleado(this.dw_1.getEmpleado(), this.dw_1.getEmpleadonombre());
                this.cargarEvento(this.dw_1.getCategoriaautorizacion());
                this.cargarConceptoAcceso(this.dw_1.getConceptoacceso());
                this.validateTipoAutorizacion(this.dw_1.getTipoautorizacion());
                if (this.dw_1.getConceptoacceso().equals("CHOR")) {
                    List<AsEmpleadoexcepcionsolicitud> horarios = (List<AsEmpleadoexcepcionsolicitud>)this.getFacAsistencia().getAsEmpleadoexcepcionsolicitudServicio().listarEmpleadoExcepcionSolicitud(this.dw_1.getEmpleado(), this.dw_1.getFecha());
                    if (!UValidador.esListaVacia((List)horarios)) {
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
                            for (DtoDddwAsTipodiaasistenciaSelect tipdia : this.lstTipoDia) {
                                if (UValidador.esCero(Integer.valueOf(tipdia.getTipodia().compareTo(hor.getTipodia())))) {
                                    hor.setHoras(tipdia.getSuma());
                                    hor.setHorasdescripcion(this.obtenerHorasAcumuladas(hor.getHoras()));
                                    hor.setHorasrefrigerio(tipdia.getSumarefrigerio());
                                    hor.setHorasrefrigeriodescripcion(this.obtenerHorasAcumuladas(hor.getHorasrefrigerio()));
                                    hor.setHorainicio(tipdia.getHorainicio());
                                    hor.setHorafin(tipdia.getHorafin());
                                    break;
                                }
                            }
                            Integer diasemana = UFechaHora.obtenerNumeroDiaSemana(hor.getFecha());
                            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("diasemana " + diasemana));
                            String nombre = UFechaHora.obtenerDiaEnCadena((int)diasemana);
                            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("nombre " + nombre));
                            hor.setDianombre(nombre);
                            this.dw_horario.add(hor);
                            ++secuencia;
                        }
                        this.calcularTotalHorasHorario();
                    }
                }
                if (this.dw_1.getCategoriaautorizacion().equals("COMP")) {
                    this.cargarDiasCompensados();
                }
            }
            else {
                this.dw_1 = new DtoDwAsAutorizacionPreprocesoHextraeditV2();
                this.iniciarControladora();
                this.cargarInfoEmpleado(this.getUsuarioActual().getIdPersona(), this.getUsuarioActual().getNombreCompleto());
            }
            if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update")) {
                this.puedeEditarPermisosSIGED = false;
            }
            if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Browse")) {
                this.puedeEditarPermisosSIGED = true;
            }
            if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Update") || CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Browse")) {
                if ("94".equals(this.dw_1.getConceptoacceso()) || "95".equals(this.dw_1.getConceptoacceso()) || "97".equals(this.dw_1.getConceptoacceso())) {
                    this.empleadoNuevaBandeja = this.getFacAsistencia().getAsDetallesigedServicio().obtenerBandejas(this.empleadoNuevaBandeja, this.dw_1);
                }
                if ("98".equals(this.dw_1.getConceptoacceso())) {
                    this.listaPerfilesSIGED = this.obtenerPerfilesSIGED();
                    AsDetallesigedPk pk2 = new AsDetallesigedPk();
                    pk2.setConceptoacceso(this.dw_1.getConceptoacceso());
                    pk2.setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                    pk2.setFechadesde(this.dw_1.getFecha());
                    pk2.setFechahasta(((boolean)this.opciones.getIsmostrarfechafin()) ? this.dw_1.getFechafin() : this.dw_1.getFecha());
                    List<AsDetallesiged> detalleRegistrado = (List<AsDetallesiged>)this.getFacAsistencia().getAsDetallesigedServicio().listaDetalleSiged(pk2);
                    for (AsDetallesiged detalleguardado : detalleRegistrado) {
                        for (DtoPerfilSIGED perfiles : this.listaPerfilesSIGED) {
                            if (detalleguardado.getIdperfil().intValue() == perfiles.getIdPerfil()) {
                                perfiles.setPerfilSeleccionado(Boolean.valueOf(true));
                                perfiles.setSecuencia(detalleguardado.getPk().getSecuencia());
                            }
                        }
                    }
                }
                if ("96".equals(this.dw_1.getConceptoacceso())) {
                    this.obtenerNuevasBandejas();
                    AsDetallesigedPk pk2 = new AsDetallesigedPk();
                    pk2.setConceptoacceso(this.dw_1.getConceptoacceso());
                    pk2.setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                    pk2.setFechadesde(this.dw_1.getFecha());
                    pk2.setFechahasta(this.dw_1.getFechafin());
                    List<AsDetallesiged> detalleRegistrado = (List<AsDetallesiged>)this.getFacAsistencia().getAsDetallesigedServicio().listaDetalleSiged(pk2);
                    for (AsDetallesiged detalleguardado : detalleRegistrado) {
                        for (DtoAreaDetalleSIGED areas : this.listaAreasSIGED) {
                            if (areas.getIdArea() == detalleguardado.getIdarea().intValue()) {
                                this.nuevaBandeja.setIdAreaSIGED(detalleguardado.getIdarea());
                                this.nuevaBandeja.setSecuencia(detalleguardado.getPk().getSecuencia());
                                this.nuevaBandeja.setIdCargoSIGED(detalleguardado.getIdcargo());
                            }
                        }
                    }
                    this.listaCargosSIGED.addAll(this.obtenerCargos(this.nuevaBandeja.getIdAreaSIGED().intValue()));
                }
                if (this.dw_1.getConceptoacceso().equals("VACA")) {
                    this.empleadoNuevaBandeja = this.getFacAsistencia().getAsDetallesigedServicio().obtenerBandejas(this.empleadoNuevaBandeja, this.dw_1);
                    if ("01".equals(this.cargoUsuarioSeleccionado)) {
                        this.verAsignacionFuncion = true;
                        this.flgAllEmpleado = "S";
                    }
                    if ("02".equals(this.cargoUsuarioSeleccionado)) {
                        this.verAsignacionRol = true;
                        this.flgAllEmpleado = "S";
                    }
                }
            }
        }
        if (mensajeControllerGenerico.getParametros().get("busqueda_nombreTipoBusqueda").equals("cargarEmpleadoFuncionSIGED")) {
            DtoDwAsEmpleadoSelectMultiple dtoEmpleado = (DtoDwAsEmpleadoSelectMultiple)mensajeControllerGenerico.getParametros().get("empleado");
            Integer indiceModificado = dtoEmpleado.getIndiceModificado();
            Boolean asignarTodos = dtoEmpleado.getAsignarTodos();
            DtoEmpleadoSIGED empleado = this.obtenerBandejasPorEmpleado(dtoEmpleado.getCodigoUsuarioEmpleado(), true);
            if (!UValidador.esNulo((Object)empleado)) {
                if (asignarTodos) {
                    for (DtoBandejaSIGED bandeja : this.empleadoNuevaBandeja.getBandejas()) {
                        bandeja.setNombrePersonaSIA(dtoEmpleado.getNombrecompleto());
                        bandeja.setIdPersonaSIA(dtoEmpleado.getPersona());
                        bandeja.setIdPersonaaux(bandeja.getIdPersona());
                        bandeja.setIdPersona(empleado.getIdPersona());
                    }
                }
                else {
                    this.empleadoNuevaBandeja.getBandejas().get(indiceModificado).setNombrePersonaSIA(dtoEmpleado.getNombrecompleto());
                    this.empleadoNuevaBandeja.getBandejas().get(indiceModificado).setIdPersonaSIA(dtoEmpleado.getPersona());
                    this.empleadoNuevaBandeja.getBandejas().get(indiceModificado).setIdPersonaaux(this.empleadoNuevaBandeja.getBandejas().get(indiceModificado).getIdPersona());
                    this.empleadoNuevaBandeja.getBandejas().get(indiceModificado).setIdPersona(empleado.getIdPersona());
                }
            }
        }
        if (mensajeControllerGenerico.getParametros().get("busqueda_nombreTipoBusqueda").equals("agregarEmpleado")) {
            DtoDwAsEmpleadoSelectMultiple dtoEmpleado = (DtoDwAsEmpleadoSelectMultiple)mensajeControllerGenerico.getParametros().get("empleado");
            this.estadoEmpleado = dtoEmpleado.getEstadoempleado();
            this.usuarioRed = dtoEmpleado.getCodigoUsuarioEmpleado();
            DtoTablaNuevaBandeja nuevaBandeja = this.getFacCore().getPersonamastServicio().obtenerDatosParaNuevaBandeja(this.usuarioRed);
            this.cargoUsuarioSeleccionado = nuevaBandeja.getEsJefe();
            this.verAsignacionFuncion = false;
            this.verConfigurarPerfil = false;
            this.verActivacionTemporal = false;
            this.verNuevaBandeja = false;
            this.verAsignacionRol = false;
            this.verAsignacionRolJefe = false;
            this.verAsignacionRolAsistente = false;
            this.dw_1.setCategoriaautorizacion((String)null);
            this.dw_1.setConceptoacceso((String)null);
            this.conceptoSeleccionado = null;
            this.empleadoNuevaBandeja = this.obtenerBandejasPorEmpleado(dtoEmpleado.getCodigoUsuarioEmpleado(), true);
            if (!this.estadoEmpleado.equals("0")) {
                this.mostarEtiquetaCesado = true;
            }
            else {
                this.mostarEtiquetaCesado = false;
            }
            this.cargarInfoEmpleado(dtoEmpleado.getPersona().intValue(), dtoEmpleado.getNombrecompleto());
            if (!UValidador.estaVacio(this.dw_1.getCategoriaautorizacion())) {
                this.cargarEvento(this.dw_1.getCategoriaautorizacion());
                this.cargarConceptoAcceso(this.dw_1.getConceptoacceso());
            }
            this.getWebControlContext().actualizar("wasautorizacionpreprocesohextraedit:segundaSeccion");
            this.periodomax = this.obtenerPeriodoVacaMax(this.dw_1.getEmpleado());
        }
        if (mensajeControllerGenerico.getParametros().get("busqueda_nombreTipoBusqueda").equals("cargarDocumento")) {
            DtoDwWhDocumentoarchivoList documento = (DtoDwWhDocumentoarchivoList)mensajeControllerGenerico.getParametros().get("documento");
            this.dw_1.setRutadocumento(UFile.remplazarCaracteresEspeciales(documento.getArchivo()));
            this.dw_1.setRutacompleta(documento.getRuta());
            this.opciones.setIsmostrarver(Boolean.valueOf(true));
        }
        if (mensajeControllerGenerico.getParametros().get("busqueda_nombreTipoBusqueda").equals("cargarDj")) {
            DtoDwWhDocumentoarchivoList documento = (DtoDwWhDocumentoarchivoList)mensajeControllerGenerico.getParametros().get("documento");
            this.dw_1.setNombrearchivodj(UFile.remplazarCaracteresEspeciales(documento.getArchivo()));
            this.dw_1.setRutacompletadj(documento.getRuta());
            this.blVerDeclaracionjurada = true;
        }
        return null;
    }
    
    private void cargarDiasCompensados() {
        this.opciones.setIsmostrardiascompensados(Boolean.valueOf(true));
    }
    
    private void cargarInfoEmpleado(Integer persona, String nombre) throws Exception {
        this.dw_1.setEmpleado(persona);
        this.dw_1.setEmpleadonombre(nombre);
        this.dw_1.setPeriodo(this.getFacAsistencia().getAS().getAsmainFuncion().FAsPeriodoactivo(persona));
        this.dw_1.setPuesto(this.getFacAsistencia().getAS().getAscommonFuncion().FSelectDescripcionPuesto(persona));
        this.dw_1.setCentrocosto(this.getFacAsistencia().getAS().getAscommonFuncion().FSqlCentroCostoEmpleado(persona));
        this.dw_1.setComportamientosobretiempo(this.getFacAsistencia().getAsCarnetidentificacionServicio().obtenerMaximoComportamientoSobretiempo(persona));
        List data = this.getFacAsistencia().getAS().getAsmainDatawindow().WAsAutorizacionHorasDisponibles(persona, new Date());
        if (!UValidador.esListaVacia(data)) {
        	this.dw_horas = (DtoWAsAutorizacionHorasDisponibles) data.get(0);
        }
        else {
            (this.dw_horas = new DtoWAsAutorizacionHorasDisponibles()).setSaldoinicial(BigDecimal.valueOf(0.0));
        }
        this.dw_horas.setCompute1(this.obtenerHorasAcumuladas(this.dw_horas.getSaldoinicial().setScale(2, RoundingMode.HALF_UP)));
        this.dw_horario = new ArrayList<DtoDwCambioHorarioExcepcion>();
        this.wf_poner_fecha_fin();
        this.periodomax = this.obtenerPeriodoVacaMax(this.dw_1.getEmpleado());
    }
    
    private String obtenerHorasAcumuladas(BigDecimal saldoinicial) {
        BigDecimal sexagesimal = this.f_cent2sex(saldoinicial);
        BigDecimal cal1 = sexagesimal.subtract(BigDecimal.valueOf(sexagesimal.intValue())).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal decimales = cal1.multiply(BigDecimal.valueOf(100L));
        Integer enteros = sexagesimal.intValue();
        if (UValidador.esCero(Integer.valueOf(decimales.compareTo(BigDecimal.valueOf(60L))))) {
            ++enteros;
            decimales = BigDecimal.valueOf(0.0);
        }
        if (UValidador.esNulo((Object)enteros) && UValidador.esNulo((Object)decimales)) {
            return "";
        }
        if (UValidador.esCero(enteros) && UValidador.esCero(Integer.valueOf(decimales.intValue()))) {
            return "00:00";
        }
        String signo = (enteros >= 0) ? "" : "-";
        return String.valueOf(signo) + ((enteros < 10 && enteros > -10) ? ("0" + Math.abs(enteros)) : Integer.valueOf(Math.abs(enteros))) + ":" + ((decimales.intValue() < 10) ? ("0" + decimales.intValue()) : Integer.valueOf(decimales.intValue()));
    }
    
    private BigDecimal obtenerHorasRefrigerio() throws Exception {
        BigDecimal difref = BigDecimal.ZERO;
        Integer tipodia = this.getFacAsistencia().getAS().getAsrepusFuncion().FSqlDevuelveHorario(this.dw_1.getEmpleado(), UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), this.dw_1.getDesde1()));
        if (UValidador.esNulo((Object)tipodia)) {
            tipodia = 0;
        }
        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("tipodia " + tipodia));
        List horario = this.getFacAsistencia().getAsTipodiamovimientoServicio().obtenerIntervaloRefrigerio(tipodia);
        if (UValidador.esListaVacia(horario)) {
            return difref;
        }
    	Date horaini = ((DtoAsTipodiamovimiento) horario.get(0)).getHorainicio();
		Date horafin = ((DtoAsTipodiamovimiento) horario.get(0)).getHorafin();
        Date desde = this.dw_1.getDesde1();
        Date hasta = this.dw_1.getHasta1();
        if ("04".equals(this.dw_1.getConceptoacceso())) {
            desde = this.desdeGlobal;
            hasta = this.hastaGlobal;
        }
        if (desde.before(UFechaHora.obtenerFechaCompuesta(desde, horaini)) && hasta.after(UFechaHora.obtenerFechaCompuesta(hasta, horafin))) {
            difref = this.wf_diftiempo(horaini, horafin).divide(BigDecimal.valueOf(3600L), 2, RoundingMode.HALF_DOWN);
        }
        else if (desde.before(UFechaHora.obtenerFechaCompuesta(desde, horaini)) && hasta.after(UFechaHora.obtenerFechaCompuesta(hasta, horaini))) {
            difref = this.wf_diftiempo(UFechaHora.obtenerFechaCompuesta(hasta, horaini), hasta).divide(BigDecimal.valueOf(3600L), 2, RoundingMode.HALF_DOWN);
        }
        else if (desde.before(UFechaHora.obtenerFechaCompuesta(desde, horafin)) && hasta.after(UFechaHora.obtenerFechaCompuesta(this.dw_1.getHasta1(), horafin))) {
            difref = this.wf_diftiempo(desde, UFechaHora.obtenerFechaCompuesta(desde, horafin)).divide(BigDecimal.valueOf(3600L), 2, RoundingMode.HALF_DOWN);
        }
        if (difref.compareTo(BigDecimal.ONE) != -1) {
            difref = BigDecimal.ONE;
            BigDecimal difconrefrigerio = this.wf_diftiempo(desde, hasta).divide(BigDecimal.valueOf(3600L), 2, RoundingMode.HALF_DOWN).subtract(difref);
            BigDecimal difsinrefrigerio = this.wf_diftiempo(desde, hasta).divide(BigDecimal.valueOf(3600L), 2, RoundingMode.HALF_DOWN);
            if (difconrefrigerio.compareTo(new BigDecimal(4)) == -1) {
                difref = difsinrefrigerio.subtract(new BigDecimal(4));
                if (difref.compareTo(BigDecimal.ZERO) == -1) {
                    difref = BigDecimal.ZERO;
                }
            }
        }
        else {
            difref = BigDecimal.ZERO;
        }
        return difref;
    }
    
    private BigDecimal f_cent2sex(BigDecimal par_cent) {
        BigDecimal valor = par_cent;
        BigDecimal decimales = valor.subtract(BigDecimal.valueOf(valor.intValue()));
        BigDecimal cal1 = decimales.divide(BigDecimal.valueOf(10L)).multiply(BigDecimal.valueOf(6L));
        return BigDecimal.valueOf(valor.intValue()).add(cal1);
    }
    
    private String f_cent2sexTexto(BigDecimal par_cent) {
        String result = "";
        BigDecimal valor = par_cent;
        BigDecimal decimales = valor.subtract(BigDecimal.valueOf(valor.intValue()));
        BigDecimal cal1 = decimales.divide(BigDecimal.valueOf(10L)).multiply(BigDecimal.valueOf(6L));
        result = String.valueOf(valor.intValue()) + ":" + cal1.multiply(BigDecimal.valueOf(100L)).setScale(0, RoundingMode.HALF_UP);
        return result;
    }
    
    public String inicializarFiltrosListado() throws Exception {
        this.dddw_as_empleadosmast_select_carnets = (List<DtoDddwAsEmpleadosmastSelectCarnets>)this.getFacAsistencia().getAS().getAsmastDatawindow().DddwAsEmpleadosmastSelectCarnets();
        this.dw_detail = new ArrayList<DtoDwAsAutorizacionPreprocesoOrdenes>();
        this.dwc_tipohorario = (List<DtoDddwAsTipohorarioSelect>)this.getFacAsistencia().getAS().getAsoracleDatawindow().DddwAsTipohorarioSelect();
        this.an_terminal = (List<DtoDddwAsTempusTerminal>)this.getFacAsistencia().getAS().getAsmastDatawindow().DddwAsTempusTerminal();
        boolean esadmin = this.getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm("AS", this.getUsuarioActual().getCodigoUsuario().toUpperCase());
        this.dwc_ConceptoAcceso = (List<DtoDddwAsConceptoaccesoSelectPre>)this.getFacAsistencia().getAS().getAsmastDatawindow().DddwAsConceptoaccesoSelectPreSiged(esadmin ? "S" : "N", this.getUsuarioActual().getLoginUsuario().toUpperCase());
        this.dwc_ConceptoAccesoFiltrado.addAll(this.dwc_ConceptoAcceso);
        return null;
    }
    
    public String inicializarDatosMantenimiento() throws Exception {
        return null;
    }
    
    public static CwAsAutorizacionPreprocesoHextraEditSIGED getInstance() {
        return (CwAsAutorizacionPreprocesoHextraEditSIGED)UFaces.evaluateExpressionGet("#{cwAsAutorizacionPreprocesoHextraEditSIGED}", (Class)CwAsAutorizacionPreprocesoHextraEditSIGED.class);
    }
    
    private void wf_poner_fecha_fin() throws Exception {
        Date desde = UFechaHora.obtenerFechaHoraInicioDiaDate(this.dw_1.getFecha());
        Date hasta = UFechaHora.obtenerFechaHoraFinDia(this.dw_1.getFechafin());
        List data = this.getFacAsistencia().getAS().getAsmainDatawindow().DwAsMarcasEmpleado(this.dw_1.getEmpleado(), UFechaHora.convertirCadenaFecha(UFechaHora.convertirFechaCadena(desde), "dd/MM/yyyy"), UFechaHora.convertirCadenaFecha(UFechaHora.convertirFechaCadena(UFechaHora.obtenerFechaMasdias(hasta, Integer.valueOf(1))), "dd/MM/yyyy"));
        this.dw_2 = new ArrayList<DtoDwAsMarcasEmpleado>();
        if (!UValidador.esListaVacia(data)) {
            this.dw_2 = (List<DtoDwAsMarcasEmpleado>)data;
        }
        Integer tipodia = this.getFacAsistencia().getAS().getAsrepusFuncion().FSqlDevuelveHorario(this.dw_1.getEmpleado(), UFechaHora.convertirCadenaFecha(UFechaHora.convertirFechaCadena(desde), "dd/MM/yyyy"));
        List data2 = this.getFacAsistencia().getAsTipodiamovimientoServicio().obtenerMaxHoraInicioMaxHoraFin(tipodia);
        if (!UValidador.esListaVacia(data2)) {
        	desde = ((DtoAsTipodiamovimiento) data2.get(0)).getHorainicio();
			hasta = ((DtoAsTipodiamovimiento) data2.get(0)).getHorafin();
            this.desdeGlobal = desde;
            this.hastaGlobal = hasta;
            if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
                this.dw_1.setDesde1(UFechaHora.obtenerFechaHoraInicioDiaDate(new Date()));
                this.dw_1.setHasta1(UFechaHora.obtenerFechaHoraInicioDiaDate(new Date()));
            }
            this.ishorariodiasiguiente = false;
            if (!UValidador.esNulo((Object)desde) && UFechaHora.obtenerFechaCompuesta(desde, desde).after(UFechaHora.obtenerFechaCompuesta(desde, hasta))) {
                this.ishorariodiasiguiente = true;
            }
        }
        String del = UFechaHora.convertirFechaCadena(desde, "HH:mm");
        String al = UFechaHora.convertirFechaCadena(hasta, "HH:mm");
        this.opciones.setSt_tipodia("Horario : " + UFechaHora.convertirFechaCadena(this.dw_1.getFecha(), "dd/MM/yyyy") + " " + (UValidador.esNulo((Object)del) ? " " : del) + " al " + (UValidador.esNulo((Object)al) ? " " : al));
        if (!UValidador.esNulo((Object)this.conceptoSeleccionado) && !this.dw_1.getCategoriaautorizacion().equals("PSIG")) {
            this.cargarConceptoAcceso(this.conceptoSeleccionado);
        }
    }
    
    public void valueChangeDiaSiguiente() throws Exception {
        if (this.flgDiaSiguiente) {
            this.dw_1.setFechafin(UFechaHora.anadirDiasAFechas(this.dw_1.getFecha(), 1));
            this.getWebControlContext().actualizar("wasautorizacionpreprocesohextraedit:cldal");
        }
        else {
            this.dw_1.setFechafin(this.dw_1.getFecha());
            this.getWebControlContext().actualizar("wasautorizacionpreprocesohextraedit:cldal");
        }
    }
    
    public void valueChangeEventEvento(ValueChangeEvent event) throws Exception {
        this.verHistorialVacaciones = false;
        this.blDeclaracionjurada = false;
        this.blVerDeclaracionjurada = false;
        String idevento = (String)event.getNewValue();
        this.dw_1.setCategoriaautorizacion(idevento);
        this.dw_1.setConceptoacceso((String)null);
        this.cargarEvento(idevento);
        if ("VACA".equals(this.dw_1.getConceptoacceso()) || "ADEL".equals(this.dw_1.getConceptoacceso()) || "FRAD".equals(this.dw_1.getConceptoacceso())) {
            this.diferenciaDia = new StringBuilder(String.valueOf(UFechaHora.obtenerDiasTranscurridos(this.dw_1.getFechafin(), this.dw_1.getFecha()) + 1)).toString();
        }
        else {
            this.diferenciaDia = new StringBuilder().append(this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(this.dw_1.getFecha(), this.dw_1.getFechafin())).toString();
        }
    }
    
    public void cargarEvento(String idevento) throws Exception {
        this.verAsignacionFuncion = false;
        this.verAsignacionRol = false;
        this.verAsignacionRolJefe = false;
        this.verAsignacionRolAsistente = false;
        this.verNuevaBandeja = false;
        this.verActivacionTemporal = false;
        this.verConfigurarPerfil = false;
        this.dw_diascompensados = new ArrayList<DtoDwAsAsistenciaHextraEdit>();
        this.opciones.setIsmostrardiascompensados(Boolean.valueOf(false));
        if (UValidador.estaVacio(idevento)) {
            return;
        }
        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("idevento " + idevento));
        if (UValidador.esNulo((Object)this.dw_1.getEmpleado()) || UValidador.esCero(this.dw_1.getEmpleado())) {
            this.dw_1.setCategoriaautorizacion((String)null);
            this.setMessageError("Debe seleccionar al empleado antes de asignar un evento");
            return;
        }
        if (!idevento.equals("OTROS")) {
            this.dw_horario = new ArrayList<DtoDwCambioHorarioExcepcion>();
            this.opciones.setIsmostrardwhorario(Boolean.valueOf(false));
            this.opciones.setIsmostrarsttitulo(Boolean.valueOf(false));
            this.opciones.setIsmostrarcbinsertar(Boolean.valueOf(false));
            this.opciones.setIsmostrarcbeliminar(Boolean.valueOf(false));
        }
        this.opciones.setIsmostrarnroresolucion(Boolean.valueOf(false));
        this.opciones.setIsmostrarrutadocumento(Boolean.valueOf(false));
        this.opciones.setIsmostrarver(Boolean.valueOf(false));
        this.opciones.setIshabilitarfechafin(Boolean.valueOf(true));
        if (idevento.equals("COMP")) {
            this.dwc_ConceptoAccesoFiltrado.clear();
            for (DtoDddwAsConceptoaccesoSelectPre obj : this.dwc_ConceptoAcceso) {
                if (obj.getFlagcompensa().equals("S")) {
                    this.dwc_ConceptoAccesoFiltrado.add(obj);
                }
            }
            if (!UValidador.esListaVacia((List)this.dwc_ConceptoAccesoFiltrado) && UValidador.esNulo((Object)this.dw_1.getConceptoacceso())) {
                this.dw_1.setConceptoacceso(this.dwc_ConceptoAccesoFiltrado.get(0).getConceptoacceso());
            }
            this.opciones.setIsmostrardwhoras(Boolean.valueOf(true));
        }
        else if (idevento.equals("OTRO")) {
            this.dwc_ConceptoAccesoFiltrado.clear();
            for (DtoDddwAsConceptoaccesoSelectPre obj : this.dwc_ConceptoAcceso) {
                if (obj.getFlagotrospermisos().equals("S")) {
                    this.dwc_ConceptoAccesoFiltrado.add(obj);
                }
            }
            this.opciones.setIsmostrardwhoras(Boolean.valueOf(false));
            this.opciones.setIsmostrardwcompensacion(Boolean.valueOf(false));
            this.opciones.setIsmostrarsttitulo(Boolean.valueOf(false));
        }
        else if (idevento.equals("PSIG")) {
            this.actualizarConceptos();
        }
        else if (idevento.equals("OMIS")) {
            if (!this.dw_1.getConceptoacceso().equals("OMI2")) {
                this.dw_1.setConceptoacceso("OMIS");
            }
            this.opciones.setIsmostrartde(Boolean.valueOf(false));
            this.opciones.setIsmostrardwhoras(Boolean.valueOf(false));
            this.opciones.setIsmostrardwcompensacion(Boolean.valueOf(false));
            this.opciones.setIsmostrarsttitulo(Boolean.valueOf(false));
            this.opciones.setIsmostrarfechafin(Boolean.valueOf(false));
            if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
                this.dw_1.setDesde1((Date)null);
            }
        }
        if (idevento.equals("SOBR")) {
            this.dw_1.setConceptoacceso("PAHE");
            this.opciones.setIsmostrardwhoras(Boolean.valueOf(false));
            this.opciones.setIsmostrardwcompensacion(Boolean.valueOf(false));
            this.opciones.setIsmostrarsttitulo(Boolean.valueOf(false));
            this.opciones.setIshabilitarfechafin(Boolean.valueOf(false));
        }
        if (!idevento.equals("ADFR")) {
            this.dw_horario = new ArrayList<DtoDwCambioHorarioExcepcion>();
            this.opciones.setIsmostrardwhorario(Boolean.valueOf(false));
            this.opciones.setIsmostrarsttitulo(Boolean.valueOf(false));
            this.opciones.setIsmostrarcbinsertar(Boolean.valueOf(false));
            this.opciones.setIsmostrarcbeliminar(Boolean.valueOf(false));
        }
        if (idevento.equals("VACA")) {
            this.verHistorialVacaciones = true;
            this.dw_1.setConceptoacceso("VACA");
            CHistorialVacaciones.getInstance().setEmpleado(this.dw_1.getEmpleado());
            CHistorialVacaciones.getInstance().iniciarControladora();
            if ("01".equals(this.cargoUsuarioSeleccionado)) {
                this.obtenerBandejas(true);
                this.verAsignacionFuncion = true;
                this.flgAllEmpleado = "S";
            }
            if ("02".equals(this.cargoUsuarioSeleccionado)) {
                this.obtenerBandejas(true);
                this.verAsignacionRol = true;
                this.flgAllEmpleado = "S";
            }
        }
        this.wf_Refrescar_Visibilidad_Hora();
        if (!idevento.equals("OTRO")) {
            AsConceptoaccesoPk pkfind = new AsConceptoaccesoPk();
            pkfind.setConceptoacceso(idevento);
            AsConceptoacceso objfind = (AsConceptoacceso)this.getFacAsistencia().getAsConceptoaccesoServicio().obtenerPorId((Serializable)pkfind);
            if (!UValidador.esNulo((Object)objfind)) {
                if (objfind.getFlagarchivo().equals("N")) {
                    this.dw_1.setArchivodata((byte[])null);
                    this.dw_1.setRutadocumento((String)null);
                }
                if (objfind.getFlagtieneresolucion().equals("N")) {
                    this.dw_1.setNroresolucion((String)null);
                    this.dw_1.setFecharesolucion((Date)null);
                }
            }
        }
        this.conceptoacceso = this.dw_1.getConceptoacceso();
        this.conceptoSeleccionado = this.dw_1.getConceptoacceso();
    }
    
    private void actualizarConceptos() {
        this.dwc_ConceptoAccesoFiltrado.clear();
        for (DtoDddwAsConceptoaccesoSelectPre obj : this.dwc_ConceptoAcceso) {
            if ("01".equals(this.cargoUsuarioSeleccionado)) {
                String conceptoacceso;
                switch (conceptoacceso = obj.getConceptoacceso()) {
                    case "94": {
                        if (this.estadoEmpleado.equals("0")) {
                            this.dwc_ConceptoAccesoFiltrado.add(obj);
                            break;
                        }
                        break;
                    }
                    case "96": {
                        if (this.estadoEmpleado.equals("0")) {
                            this.dwc_ConceptoAccesoFiltrado.add(obj);
                            break;
                        }
                        break;
                    }
                    case "97": {
                        this.dwc_ConceptoAccesoFiltrado.add(obj);
                        break;
                    }
                    case "98": {
                        if (this.estadoEmpleado.equals("0")) {
                            this.dwc_ConceptoAccesoFiltrado.add(obj);
                            break;
                        }
                        break;
                    }
                    case "99": {
                        if (this.estadoEmpleado.equals("0")) {
                            this.dwc_ConceptoAccesoFiltrado.add(obj);
                            break;
                        }
                        break;
                    }
                    case "xx": {
                        if (this.estadoEmpleado.equals("0")) {
                            this.dwc_ConceptoAccesoFiltrado.add(obj);
                            break;
                        }
                        break;
                    }
                    default:
                        break;
                }
            }
            if ("02".equals(this.cargoUsuarioSeleccionado)) {
                String conceptoacceso2;
                switch (conceptoacceso2 = obj.getConceptoacceso()) {
                    case "95": {
                        if (this.estadoEmpleado.equals("0")) {
                            this.dwc_ConceptoAccesoFiltrado.add(obj);
                            break;
                        }
                        break;
                    }
                    case "96": {
                        if (this.estadoEmpleado.equals("0")) {
                            this.dwc_ConceptoAccesoFiltrado.add(obj);
                            break;
                        }
                        break;
                    }
                    case "97": {
                        this.dwc_ConceptoAccesoFiltrado.add(obj);
                        break;
                    }
                    case "98": {
                        if (this.estadoEmpleado.equals("0")) {
                            this.dwc_ConceptoAccesoFiltrado.add(obj);
                            break;
                        }
                        break;
                    }
                    case "xx": {
                        if (this.estadoEmpleado.equals("0")) {
                            this.dwc_ConceptoAccesoFiltrado.add(obj);
                            break;
                        }
                        break;
                    }
                    default:
                        break;
                }
            }
            if ("03".equals(this.cargoUsuarioSeleccionado)) {
                String conceptoacceso3;
                switch (conceptoacceso3 = obj.getConceptoacceso()) {
                    case "94": {
                        if (this.estadoEmpleado.equals("0")) {
                            this.dwc_ConceptoAccesoFiltrado.add(obj);
                            break;
                        }
                        break;
                    }
                    case "95": {
                        if (this.estadoEmpleado.equals("0")) {
                            this.dwc_ConceptoAccesoFiltrado.add(obj);
                            break;
                        }
                        break;
                    }
                    case "96": {
                        if (this.estadoEmpleado.equals("0")) {
                            this.dwc_ConceptoAccesoFiltrado.add(obj);
                            break;
                        }
                        break;
                    }
                    case "97": {
                        this.dwc_ConceptoAccesoFiltrado.add(obj);
                        break;
                    }
                    case "98": {
                        if (this.estadoEmpleado.equals("0")) {
                            this.dwc_ConceptoAccesoFiltrado.add(obj);
                            break;
                        }
                        break;
                    }
                    case "99": {
                        if (this.estadoEmpleado.equals("0")) {
                            this.dwc_ConceptoAccesoFiltrado.add(obj);
                            break;
                        }
                        break;
                    }
                    case "xx": {
                        if (this.estadoEmpleado.equals("0")) {
                            this.dwc_ConceptoAccesoFiltrado.add(obj);
                            break;
                        }
                        break;
                    }
                    default:
                        break;
                }
            }
            if ("00".equals(this.cargoUsuarioSeleccionado) || UValidador.estaVacio(this.cargoUsuarioSeleccionado)) {
                String conceptoacceso4;
                switch ((conceptoacceso4 = obj.getConceptoacceso()).hashCode()) {
                    case 1821: {
                        if (!conceptoacceso4.equals("96")) {
                            continue;
                        }
                        if (this.estadoEmpleado.equals("0")) {
                            this.dwc_ConceptoAccesoFiltrado.add(obj);
                            continue;
                        }
                        continue;
                    }
                    case 1822: {
                        if (!conceptoacceso4.equals("97")) {
                            continue;
                        }
                        this.dwc_ConceptoAccesoFiltrado.add(obj);
                        continue;
                    }
                    case 1823: {
                        if (!conceptoacceso4.equals("98")) {
                            continue;
                        }
                        if (this.estadoEmpleado.equals("0")) {
                            this.dwc_ConceptoAccesoFiltrado.add(obj);
                            continue;
                        }
                        continue;
                    }
                    default: {
                        continue;
                    }
                }
            }
        }
        this.opciones.setIsmostrardwhoras(Boolean.valueOf(false));
        this.opciones.setIsmostrardwcompensacion(Boolean.valueOf(false));
        this.opciones.setIsmostrarsttitulo(Boolean.valueOf(false));
    }
    
    public void valuechangedConceptoAcceso(ValueChangeEvent event) throws Exception {
        if (UValidador.esNulo(event.getNewValue())) {
            return;
        }
        this.blDeclaracionjurada = false;
        this.blVerDeclaracionjurada = false;
        this.iscambioonceptoevento = true;
        this.cargarConceptoAcceso(this.conceptoSeleccionado = (String)event.getNewValue());
        if ("VACA".equals(this.dw_1.getConceptoacceso()) || "ADEL".equals(this.dw_1.getConceptoacceso()) || "FRAD".equals(this.dw_1.getConceptoacceso())) {
            this.diferenciaDia = new StringBuilder(String.valueOf(UFechaHora.obtenerDiasTranscurridos(this.dw_1.getFechafin(), this.dw_1.getFecha()) + 1)).toString();
        }
        else {
            this.diferenciaDia = new StringBuilder().append(this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(this.dw_1.getFecha(), this.dw_1.getFechafin())).toString();
        }
    }
    
    public void cargarConceptoAcceso(String concepto) throws Exception {
        this.verFechas = true;
        this.dw_diascompensados = new ArrayList<DtoDwAsAsistenciaHextraEdit>();
        this.totalsaldoactual = BigDecimal.ZERO;
        this.totalsaldoactualhor = "00:00";
        this.horasSumadas = "";
        this.verAsignacionFuncion = false;
        this.verAsignacionRol = false;
        this.verAsignacionRolJefe = false;
        this.verAsignacionRolAsistente = false;
        this.verNuevaBandeja = false;
        this.verActivacionTemporal = false;
        this.verConfigurarPerfil = false;
        Integer w_dlv = null;
        Integer w_dfs = null;
        if (!concepto.equals("CHOR")) {
            this.dw_horario = new ArrayList<DtoDwCambioHorarioExcepcion>();
            this.opciones.setIsmostrardwhorario(Boolean.valueOf(false));
            this.opciones.setIsmostrarsttitulo(Boolean.valueOf(false));
            this.opciones.setIsmostrarcbinsertar(Boolean.valueOf(false));
            this.opciones.setIsmostrarcbeliminar(Boolean.valueOf(false));
        }
        this.dw_1.setConceptoacceso(concepto);
        Integer ll_find = null;
        for (int i = 0; i < this.dwc_ConceptoAccesoFiltrado.size(); ++i) {
            DtoDddwAsConceptoaccesoSelectPre obj = this.dwc_ConceptoAccesoFiltrado.get(i);
            if (obj.getConceptoacceso().equals(concepto)) {
                ll_find = i;
                this.diascompensa = this.dwc_ConceptoAccesoFiltrado.get(i).getDiascompensa();
            }
        }
        if (!UValidador.esNulo((Object)ll_find)) {
            if (this.dwc_ConceptoAccesoFiltrado.get(ll_find).getFlagarchivo().equals("S") || !UValidador.estaVacio(this.dw_1.getUuidalfresco())) {
                if (!this.dw_1.getCategoriaautorizacion().equals("VACA") && (!this.dw_1.getCategoriaautorizacion().equals("ADFR") || !"S".equals(this.dw_1.getEstado()))) {
                    this.opciones.setIsmostrarseleccionar(Boolean.valueOf(true));
                    this.opciones.setIsmostrarrutadocumento(Boolean.valueOf(true));
                    if (!UValidador.estaVacio(this.dw_1.getRutadocumento())) {
                        this.opciones.setIsmostrarver(Boolean.valueOf(true));
                    }
                    this.opciones.setIsmostrartarchivo(Boolean.valueOf(true));
                }
            }
            else {
                this.opciones.setIsmostrarseleccionar(Boolean.valueOf(false));
                this.opciones.setIsmostrarver(Boolean.valueOf(false));
                this.opciones.setIsmostrarrutadocumento(Boolean.valueOf(false));
                this.opciones.setIsmostrartarchivo(Boolean.valueOf(false));
                this.dw_1.setArchivodata((byte[])null);
                this.dw_1.setRutadocumento((String)null);
            }
            if (this.dwc_ConceptoAccesoFiltrado.get(ll_find).getFlagtieneresolucion().equals("S")) {
                this.opciones.setIsmostrarnroresolucion(Boolean.valueOf(true));
            }
            else {
                this.opciones.setIsmostrarnroresolucion(Boolean.valueOf(false));
                this.dw_1.setNroresolucion((String)null);
                this.dw_1.setFecharesolucion((Date)null);
            }
        }
        if (concepto.equals("CHOR")) {
            CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add");
            this.opciones.setIsmostrardwhorario(Boolean.valueOf(true));
            this.opciones.setIsmostrarsttitulo(Boolean.valueOf(true));
            if (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Browse")) {
                this.opciones.setIsmostrarcbinsertar(Boolean.valueOf(true));
                this.opciones.setIsmostrarcbeliminar(Boolean.valueOf(true));
            }
            this.lstTipoDia = (List<DtoDddwAsTipodiaasistenciaSelect>)this.getFacAsistencia().getAS().getAsmastDatawindow().DddwAsTipodiaasistenciaSelect();
        }
        if (this.dw_1.getCategoriaautorizacion().equals("COMP") && !CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Delete")) {
            w_dlv = this.getFacCore().getParametrosmastServicio().obtenerValorInteger(new ParametrosmastPk("AS", "999999", "NDIACOMPLV"));
            String confercomp = this.getFacCore().getParametrosmastServicio().obtenerValorCadena(new ParametrosmastPk("AS", "999999", "CONFERCOMP"));
            if (UValidador.estaVacio(confercomp)) {
                confercomp = "";
            }
            String concepto2;
            String concepto3;
            if (confercomp.equals(this.dw_1.getConceptoacceso())) {
                concepto2 = "HNAU";
                concepto3 = "HNAU";
            }
            else {
                concepto2 = "HAUT";
                concepto3 = "HGAN";
            }
            Date w_fechainicio = this.wf_rangofechas(1, this.dw_1.getFecha(), w_dlv);
            Date w_fechafinal = wf_rangofechas(2, dw_1.getFecha(), 0);
            
            Date w_fecha= this.wf_rangofechas(2, this.dw_1.getFecha(), 0);
            List data = new ArrayList();
            if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Browse")) {
                data = this.getFacAsistencia().getAS().getAsmainDatawindow().DwAsAsistenciaHextraEditModif(this.dw_1.getEmpleado(), this.dw_1.getFecha());
                this.dw_diascompensados = (List<DtoDwAsAsistenciaHextraEdit>)data;
                if (!UValidador.esListaVacia((List)this.dw_diascompensados)) {
                    for (DtoDwAsAsistenciaHextraEdit objmod : this.dw_diascompensados) {
                        objmod.setCantidadhor(this.obtenerHorasAcumuladas(objmod.getCantidadreal()));
                        objmod.setCompensadohor(this.obtenerHorasAcumuladas(objmod.getCantidad()));
                        objmod.setDiferenciahor(this.obtenerHorasAcumuladas(objmod.getDiferencia()));
                        this.totalsaldoactual = this.totalsaldoactual.add(objmod.getDiferencia());
                        if (objmod.getSeleccion().equals("S")) {
                            objmod.setIsseleccionado(Boolean.valueOf(true));
                        }
                    }
                    this.totalsaldoactualhor = this.obtenerHorasAcumuladas(this.totalsaldoactual);
                }
            }
            else {
                data = this.getFacAsistencia().getAS().getAsmainDatawindow().DwAsAsistenciaHextraEdit(this.dw_1.getEmpleado(), UFechaHora.obtenerFechaHoraInicioDiaDate(w_fechainicio), UFechaHora.obtenerFechaHoraFinDia(w_fechafinal), concepto2, concepto3, w_dfs, w_dlv);
                this.dw_diascompensados = (List<DtoDwAsAsistenciaHextraEdit>)data;
                if (!UValidador.esListaVacia((List)this.dw_diascompensados)) {
                    for (DtoDwAsAsistenciaHextraEdit obj2 : this.dw_diascompensados) {
                        obj2.setCantidadhor(this.obtenerHorasAcumuladas(obj2.getCantidad()));
                        obj2.setCompensadohor(this.obtenerHorasAcumuladas(obj2.getCompensado()));
                        obj2.setDiferenciahor(this.obtenerHorasAcumuladas(obj2.getDiferencia()));
                        this.totalsaldoactual = this.totalsaldoactual.add(obj2.getDiferencia());
                    }
                    this.totalsaldoactualhor = this.obtenerHorasAcumuladas(this.totalsaldoactual);
                }
            }
            this.opciones.setIsmostrardiascompensados(Boolean.valueOf(true));
        }
        if (!"PAHE".equals(concepto)) {
            this.opciones.setIshabilitarfechafin(Boolean.valueOf(true));
            AsConceptoacceso objfind = (AsConceptoacceso)this.getFacAsistencia().getAsConceptoaccesoServicio().obtenerPorId((Serializable)new AsConceptoaccesoPk(concepto));
            if (!UValidador.esNulo((Object)objfind) && "S".equals(objfind.getFlagUnDia())) {
                this.opciones.setIshabilitarfechafin(Boolean.valueOf(false));
            }
        }
        if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
            if ("73".equals(concepto)) {
                this.dw_1.setDesde1(UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), UFechaHora.convertirCadenaFecha("12:30:00", "HH:mm:ss")));
                this.dw_1.setHasta1(UFechaHora.obtenerFechaCompuesta(this.dw_1.getFechafin(), UFechaHora.convertirCadenaFecha("15:00:00", "HH:mm:ss")));
                this.keyhorainicio();
            }
            else if ("86".equals(concepto)) {
                if (!UValidador.esNulo((Object)this.dw_1.getFecha())) {
                    Date horasalida = this.getFacAsistencia().getAsAutorizacionServicio().obtenerHorarioEmpleado(this.dw_1.getEmpleado(), this.dw_1.getFecha(), "F");
                    String horsalida = UFechaHora.convertirFechaCadena(horasalida, "HH:mm:ss");
                    this.dw_1.setHasta1(UFechaHora.obtenerFechaCompuesta(this.dw_1.getFechafin(), UFechaHora.convertirCadenaFecha(horsalida, "HH:mm:ss")));
                    this.dw_1.setDesde1(UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), UFechaHora.convertirCadenaFecha(UFechaHora.convertirFechaCadena(UFechaHora.addHorasToDate(horasalida, -4), "HH:mm:ss"), "HH:mm:ss")));
                    this.opciones.setIshabilitardesde1(Boolean.valueOf(false));
                    this.opciones.setIshabilitarhasta1(Boolean.valueOf(false));
                    String horentrada = UFechaHora.convertirFechaCadena(UFechaHora.addHorasToDate(horasalida, -(4 + this.obtenerHorasRefrigerio().intValue())), "HH:mm:ss");
                    this.dw_1.setDesde1(UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), UFechaHora.convertirCadenaFecha(horentrada, "HH:mm:ss")));
                    this.keyhorainicio();
                }
            }
            else {
                this.dw_1.setDesde1(UFechaHora.obtenerFechaCompuesta(this.dw_1.getFecha(), UFechaHora.convertirCadenaFecha("00:00:00", "HH:mm:ss")));
                this.dw_1.setHasta1(UFechaHora.obtenerFechaCompuesta(this.dw_1.getFechafin(), UFechaHora.convertirCadenaFecha("00:00:00", "HH:mm:ss")));
                this.keyhorainicio();
            }
        }
        if ("34".equals(concepto)) {
            Empleadomast emp = (Empleadomast)this.getFacCore().getEmpleadomastServicio().obtenerPorId((Serializable)new EmpleadomastPk(this.dw_1.getEmpleado(), this.getUsuarioActual().getCompaniaSocioCodigo()));
            if (!UValidador.esNulo((Object)emp)) {
                String tipoplanilla = emp.getTipoplanilla();
                this.lstPeriodosPlanilla = (List<PrProcesoperiodo>)this.getFacPlanilla().getPrProcesoperiodoServicio().listarPeriodosXPlanilla(tipoplanilla);
            }
            this.diasLicPer = this.getFacCore().getParametrosmastServicio().obtenerValorInteger(new ParametrosmastPk("AS", "999999", "MAXDIARCLI")) + 1;
        }
        if ("94".equals(concepto)) {
            this.obtenerBandejas(true);
            this.verFechas = true;
            this.verAsignacionFuncion = true;
            this.opciones.setIsmostrarfechafin(Boolean.valueOf(true));
            this.flgAllEmpleado = "S";
        }
        if ("95".equals(concepto)) {
            this.obtenerBandejas(true);
            this.verAsignacionRol = true;
            this.verFechas = true;
            this.opciones.setIsmostrarfechafin(Boolean.valueOf(true));
            this.flgAllEmpleado = "S";
        }
        if ("96".equals(concepto)) {
            this.obtenerNuevasBandejas();
            this.verNuevaBandeja = true;
            this.verFechas = true;
            this.opciones.setIsmostrarfechafin(Boolean.valueOf(false));
        }
        if ("97".equals(concepto)) {
            this.obtenerBandejas(false);
            this.verActivacionTemporal = true;
            this.flgAllEmpleado = "S";
            this.verFechas = false;
            this.infoLicenciaVacaciones = "";
            if (!this.estadoEmpleado.equals("2")) {
                this.infoLicenciaVacaciones = this.obtenerLicenciaRangoTexto(this.dw_1.getEmpleado(), new Date(), new Date());
                if (UValidador.estaVacio(this.infoLicenciaVacaciones)) {
                    this.infoLicenciaVacaciones = this.obtenerVacacionesRangoTexto(this.dw_1.getEmpleado(), new Date(), new Date(), UValidador.esNulo((Object)this.periodomax) ? this.obtenerPeriodoVacaMax(this.dw_1.getEmpleado()) : this.periodomax);
                }
                if (UValidador.estaVacio(this.infoLicenciaVacaciones)) {
                    this.infoLicenciaVacaciones = "El Empleado no se encuentra de vacaciones ni de licencia.";
                }
            }
        }
        if ("98".equals(concepto)) {
            this.obtenerBandejas(true);
            this.listaPerfilesSIGED = this.obtenerPerfilesSIGED();
            this.verConfigurarPerfil = true;
            this.verFechas = true;
            this.opciones.setIsmostrarfechafin(Boolean.valueOf(false));
        }
        if ("xx".equals(concepto)) {
            this.empleadoNuevaBandeja.setBljefe(Boolean.valueOf(true));
            this.obtenerAreasSIGED();
            this.verFechas = true;
            this.verAsignacionRolJefe = true;
            this.flgAllEmpleado = "S";
            if (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
                this.nuevaBandeja = new DtoTablaNuevaBandeja();
                AsDetallesigedPk pk = new AsDetallesigedPk();
                pk.setConceptoacceso(concepto);
                pk.setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                pk.setFechadesde(this.dw_1.getFecha());
                pk.setFechahasta(this.dw_1.getFechafin());
                pk.setSecuencia(BigDecimal.ONE);
                AsDetallesiged asDetallesiged = (AsDetallesiged)this.getFacAsistencia().getAsDetallesigedServicio().obtenerPorId((Serializable)pk, false);
                if (!UValidador.esNulo((Object)asDetallesiged)) {
                    this.nuevaBandeja.setIdAreaSIGED(asDetallesiged.getIdarea());
                    this.mostrarJefeAsistenteSegunArea(this.nuevaBandeja.getIdAreaSIGED().intValue());
                    if (UValidador.esNulo((Object)this.empleadoNuevaBandeja)) {
                        this.empleadoNuevaBandeja = new DtoEmpleadoSIGED();
                    }
                    this.empleadoNuevaBandeja.setBljefe(Boolean.valueOf(true));
                    if (!UValidador.estaVacio(asDetallesiged.getFlgasistente())) {
                        this.empleadoNuevaBandeja.setBlasistente(Boolean.valueOf(asDetallesiged.getFlgasistente().equals("S")));
                    }
                }
            }
        }
        if ("99".equals(concepto)) {
            this.verFechas = true;
            this.verAsignacionRolAsistente = true;
            this.mostrarEmpleadosRolAsistenteSiged();
            this.obtenerAreasDeJefeSIGED();
            if (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
                AsDetallesigedPk pk = new AsDetallesigedPk();
                pk.setConceptoacceso(concepto);
                pk.setEmpleado(new BigDecimal(this.dw_1.getEmpleado()));
                pk.setFechadesde(this.dw_1.getFecha());
                pk.setFechahasta(this.dw_1.getFechafin());
                pk.setSecuencia(BigDecimal.ONE);
                AsDetallesiged asDetallesiged = (AsDetallesiged)this.getFacAsistencia().getAsDetallesigedServicio().obtenerPorId((Serializable)pk, false);
                if (!UValidador.esNulo((Object)asDetallesiged)) {
                    this.nuevaBandeja.setIdAreaSIGED(asDetallesiged.getIdarea());
                    this.mostrarJefeAsistenteSegunArea(this.nuevaBandeja.getIdAreaSIGED().intValue());
                    this.seleccionarEmpleadosistenteSiged(asDetallesiged.getIdempleadosia());
                    this.empleadoSeleccion = asDetallesiged.getIdempleadosia();
                    if (!UValidador.esNulo((Object)asDetallesiged.getIdempleadosia2())) {
                        this.seleccionarEmpleadosistentePermSiged(asDetallesiged.getIdempleadosia2());
                        this.empleadoSeleccionPerm = asDetallesiged.getIdempleadosia2();
                    }
                }
            }
        }
        this.wf_Refrescar_Visibilidad_Hora();
    }
    
    public String buscarEmpleadosRolAsistente() throws Exception {
        CwAsEmpleadoSelect.getInstance().setFlgTodos("N");
        CwAsEmpleadoSelect.getInstance().buscar();
        if (!UValidador.esNulo((Object)this.empleadoSeleccion)) {
            List<DtoDwAsEmpleadoSelectMultiple> lstEmpleados = (List<DtoDwAsEmpleadoSelectMultiple>)CwAsEmpleadoSelect.getInstance().getDw_list();
            if (!UValidador.esListaVacia((List)lstEmpleados)) {
                for (DtoDwAsEmpleadoSelectMultiple obj : lstEmpleados) {
                    if (UValidador.esCero(Integer.valueOf(obj.getPersona().compareTo(this.empleadoSeleccion)))) {
                        obj.setBlasistentesiged(Boolean.valueOf(true));
                    }
                    else {
                        obj.setBlasistentesiged(Boolean.valueOf(false));
                    }
                }
            }
        }
        if (!UValidador.esNulo((Object)this.empleadoSeleccionPerm)) {
            List<DtoDwAsEmpleadoSelectMultiple> lstEmpleados = (List<DtoDwAsEmpleadoSelectMultiple>)CwAsEmpleadoSelect.getInstance().getDw_list();
            if (!UValidador.esListaVacia((List)lstEmpleados)) {
                for (DtoDwAsEmpleadoSelectMultiple obj : lstEmpleados) {
                    if (UValidador.esCero(Integer.valueOf(obj.getPersona().compareTo(this.empleadoSeleccionPerm)))) {
                        obj.setBlasistentepermsiged(Boolean.valueOf(true));
                    }
                    else {
                        obj.setBlasistentepermsiged(Boolean.valueOf(false));
                    }
                }
            }
        }
        return null;
    }
    
    public void cambiarEmpleadoJefeSeleccion() throws Exception {
        if (!UValidador.esNulo((Object)this.empleadoSeleccion)) {
            this.seleccionarEmpleadoJefeSiged(this.empleadoSeleccion);
        }
    }
    
    public void cambiarEmpleadoSeleccion() throws Exception {
        if (!UValidador.esNulo((Object)this.empleadoSeleccion)) {
            this.seleccionarEmpleadosistenteSiged(this.empleadoSeleccion);
        }
    }
    
    public void cambiarEmpleadoSeleccionPerm() throws Exception {
        if (!UValidador.esNulo((Object)this.empleadoSeleccionPerm)) {
            this.seleccionarEmpleadosistentePermSiged(this.empleadoSeleccionPerm);
        }
    }
    
    private void obtenerNuevasBandejas() throws JsonParseException, JsonMappingException, IOException {
        this.listaAreasSIGED = new ArrayList<DtoAreaDetalleSIGED>();
        this.listaCargosSIGED = new ArrayList<DtoCargoDetalleSIGED>();
        this.nuevaBandeja = this.getFacCore().getPersonamastServicio().obtenerDatosParaNuevaBandeja(this.usuarioRed);
        this.listaAreasSIGED.addAll(this.obtenerAreas());
    }
    
    private void obtenerAreasSIGED() throws JsonParseException, JsonMappingException, IOException {
        (this.listaAreasSIGED = new ArrayList<DtoAreaDetalleSIGED>()).addAll(this.obtenerAreas());
    }
    
    private void obtenerAreasDeJefeSIGED() throws Exception {
        this.listaAreasSIGED = new ArrayList<DtoAreaDetalleSIGED>();
        List<DtoAreaDetalleSIGED> retorno = this.obtenerAreas();
        if (!UValidador.esListaVacia(this.empleadoNuevaBandeja.getAdministrativo())) {
            for (DtoAdministrativoSIGED obj : this.empleadoNuevaBandeja.getAdministrativo()) {
                if (obj.getEsJefe() == 1 && !UValidador.esListaVacia((List)retorno)) {
                    for (DtoAreaDetalleSIGED objdet : retorno) {
                        if (obj.getIdArea().toString().equals(objdet.getIdArea().toString())) {
                            this.listaAreasSIGED.add(objdet);
                            break;
                        }
                    }
                }
            }
        }
        if (!UValidador.esListaVacia((List)this.listaAreasSIGED) && this.listaAreasSIGED.size() == 1) {
            this.nuevaBandeja.setIdAreaSIGED(new BigDecimal(this.listaAreasSIGED.get(0).getIdArea()));
            this.mostrarJefeAsistenteSegunArea(this.nuevaBandeja.getIdAreaSIGED().intValue());
        }
    }
    
    public void obtenerCargosSegunArea(ValueChangeEvent event) throws JsonParseException, JsonMappingException, IOException {
        BigDecimal area = (BigDecimal)event.getNewValue();
        Integer idArea = area.intValue();
        (this.listaCargosSIGED = new ArrayList<DtoCargoDetalleSIGED>()).addAll(this.obtenerCargos(idArea));
    }
    
    public void mostrarJefeAsistenteSegunArea(ValueChangeEvent event) throws Exception {
        BigDecimal area = (BigDecimal)event.getNewValue();
        Integer idArea = area.intValue();
        this.mostrarJefeAsistenteSegunArea(idArea);
    }
    
    public void mostrarJefeAsistenteSegunArea(Integer idArea) throws Exception {
        DtoAreaDetalleSIGED dtoAreaDetalleSIGED = this.obtenerAreaSIGED(idArea);
        this.empleadoJefeArea = new DtoEmpleadoSIGED();
        this.empleadoAsistenteArea = new DtoEmpleadoSIGED();
        if (!UValidador.esNulo((Object)dtoAreaDetalleSIGED)) {
            if (!UValidador.esNulo((Object)dtoAreaDetalleSIGED.getIdPersonaJa())) {
                this.empleadoJefeArea.setIdPersona(dtoAreaDetalleSIGED.getIdPersonaJa());
            }
            if (!UValidador.esNulo((Object)dtoAreaDetalleSIGED.getIdPersonaAa())) {
                this.empleadoAsistenteArea.setIdPersona(dtoAreaDetalleSIGED.getIdPersonaAa());
            }
        }
    }
    
    public DtoAreaDetalleSIGED obtenerAreaSIGED(Integer idArea) {
        DtoAreaDetalleSIGED retorno = null;
        if (!UValidador.esListaVacia((List)this.listaAreasSIGED)) {
            for (DtoAreaDetalleSIGED obj : this.listaAreasSIGED) {
                if (obj.getIdArea().toString().equals(idArea.toString())) {
                    retorno = obj;
                    break;
                }
            }
        }
        return retorno;
    }
    
    private DtoEmpleadoSIGED obtenerDetallePorEmpleadoSIGED(Integer idPersona) throws JsonParseException, JsonMappingException, IOException {
        String token = this.obtenerToken();
        DtoEmpleadoSIGED empleadoSeleccionado = new DtoEmpleadoSIGED();
        String url = String.valueOf(UAplicacion.getServletContext().getInitParameter("URL_OBTENER_DETALLE")) + idPersona;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept((List)Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", token);
        HttpEntity request = new HttpEntity((MultiValueMap)headers);
        ResponseEntity<String> response = (ResponseEntity<String>)restTemplate.exchange(url, HttpMethod.GET, request, (Class)String.class, new Object[0]);
        if (response.getStatusCode() == HttpStatus.OK) {
            if (UValidador.esNulo(response.getBody())) {
                empleadoSeleccionado = null;
            }
            else {
                System.out.println("Request Successful.");
                empleadoSeleccionado = (DtoEmpleadoSIGED)new ObjectMapper().readValue((String)response.getBody(), (Class)DtoEmpleadoSIGED.class);
            }
        }
        else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }
        return empleadoSeleccionado;
    }
    
    private DtoEmpleadoSIGED obtenerDetallePorEmpleadoSIA(String usuario) throws JsonParseException, JsonMappingException, IOException {
        String token = this.obtenerToken();
        DtoEmpleadoSIGED empleadoSeleccionado = new DtoEmpleadoSIGED();
        String url = String.valueOf(UAplicacion.getServletContext().getInitParameter("URL_OBTENER_BANDEJAS")) + usuario;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept((List)Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", token);
        HttpEntity request = new HttpEntity((MultiValueMap)headers);
        ResponseEntity<String> response = (ResponseEntity<String>)restTemplate.exchange(url, HttpMethod.GET, request, (Class)String.class, new Object[0]);
        if (response.getStatusCode() == HttpStatus.OK) {
            if (UValidador.esNulo(response.getBody())) {
                empleadoSeleccionado = null;
            }
            else {
                System.out.println("Request Successful.");
                empleadoSeleccionado = (DtoEmpleadoSIGED)new ObjectMapper().readValue((String)response.getBody(), (Class)DtoEmpleadoSIGED.class);
            }
        }
        else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }
        return empleadoSeleccionado;
    }
    
    private DtoEmpleadoSIGED obtenerBandejasPorEmpleado(String UsuarioRed, boolean blSoloActivos) throws JsonParseException, JsonMappingException, IOException {
        String token = this.obtenerToken();
        DtoEmpleadoSIGED empleadoSeleccionado = new DtoEmpleadoSIGED();
        if (UString.estaVacio(UsuarioRed)) {
            this.setMessageError("El Empleado Seleccionado no cuenta con usuario de red");
            return null;
        }
        String url = String.valueOf(UAplicacion.getServletContext().getInitParameter("URL_OBTENER_BANDEJAS")) + UsuarioRed;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept((List)Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", token);
        HttpEntity request = new HttpEntity((MultiValueMap)headers);
        ResponseEntity<String> response = (ResponseEntity<String>)restTemplate.exchange(url, HttpMethod.GET, request, (Class)String.class, new Object[0]);
        if (response.getStatusCode() == HttpStatus.OK) {
            if (UValidador.esNulo(response.getBody())) {
                this.setMessageError("No se ha encontrado Datos para el usuario " + UsuarioRed + " en el Servicio SIGED");
                return null;
            }
            System.out.println("Request Successful.");
            empleadoSeleccionado = (DtoEmpleadoSIGED)new ObjectMapper().readValue((String)response.getBody(), (Class)DtoEmpleadoSIGED.class);
            if (blSoloActivos && !UValidador.esNulo((Object)empleadoSeleccionado) && !UValidador.esListaVacia(empleadoSeleccionado.getBandejas())) {
                List<DtoBandejaSIGED> bandejaNueva = new ArrayList<DtoBandejaSIGED>();
                for (DtoBandejaSIGED obj : empleadoSeleccionado.getBandejas()) {
                    if ("A".equals(obj.getEstado())) {
                        bandejaNueva.add(obj);
                    }
                }
                empleadoSeleccionado.getBandejas().clear();
                empleadoSeleccionado.setBandejas((List)bandejaNueva);
            }
        }
        else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }
        return empleadoSeleccionado;
    }
    private List<DtoPerfilSIGED> obtenerPerfilesSIGED() throws JsonParseException, JsonMappingException, IOException {

		String token = obtenerToken();
		List<DtoPerfilSIGED> perfilesSIGED = new ArrayList<>();

		// request url
		String url = UAplicacion.getServletContext().getInitParameter(UConstante.URL_OBTENER_PERFILES);
		// create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// create headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", token);

		HttpEntity request = new HttpEntity(headers);

		// make an HTTP GET request with headers
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

		// check response
		if (response.getStatusCode() == HttpStatus.OK) {

			if (UValidador.esNulo(response.getBody())) {
				setMessageError("No se ha encontrado Perfiles en el Servicio SIGED");
				return null;
			}

			System.out.println("Request Successful.");
			perfilesSIGED = new ObjectMapper().readValue(response.getBody(), new TypeReference<List<DtoPerfilSIGED>>() {
			});

		} else {
			System.out.println("Request Failed");
			System.out.println(response.getStatusCode());
		}

		// TODO SIGED Recorrer los Perfiles Actuales del empleado seleccionado
		Boolean tienePerfiles = true;
		if (UValidador.esListaVacia(empleadoNuevaBandeja.getPerfiles())) {
			tienePerfiles = false;
		}

		if (tienePerfiles && !UValidador.esListaVacia(perfilesSIGED)) {

			for (DtoPerfilSIGED perfiles : perfilesSIGED) {
				perfiles.setPerfilSeleccionadoLectura(false);
				perfiles.setPerfilSeleccionado(false);
				for (DtoPerfilSIGED perfilActual : empleadoNuevaBandeja.getPerfiles()) {
					if (perfilActual.getIdPerfil() == perfiles.getIdPerfil()) {
						perfiles.setPerfilSeleccionado(true);
						perfiles.setPerfilSeleccionadoLectura(true);
					}
				}
			}
		}

		return perfilesSIGED;
	}
    
    private void obtenerBandejas(boolean blSoloActivos) throws JsonParseException, JsonMappingException, IOException {
        String token = this.obtenerToken();
        String url = String.valueOf(UAplicacion.getServletContext().getInitParameter("URL_OBTENER_BANDEJAS")) + this.usuarioRed;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept((List)Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", token);
        HttpEntity request = new HttpEntity((MultiValueMap)headers);
        ResponseEntity<String> response = (ResponseEntity<String>)restTemplate.exchange(url, HttpMethod.GET, request, (Class)String.class, new Object[0]);
        if (response.getStatusCode() == HttpStatus.OK) {
            if (UValidador.esNulo(response.getBody())) {
                this.setMessageError("No se ha encontrado Bandejas para el usuario " + this.usuarioRed + " en el Servicio SIGED");
                return;
            }
            System.out.println("Request Successful.");
            this.empleadoNuevaBandeja = (DtoEmpleadoSIGED)new ObjectMapper().readValue((String)response.getBody(), (Class)DtoEmpleadoSIGED.class);
            if (blSoloActivos && !UValidador.esNulo((Object)this.empleadoNuevaBandeja) && !UValidador.esListaVacia(this.empleadoNuevaBandeja.getBandejas())) {
                List<DtoBandejaSIGED> bandejaNueva = new ArrayList<DtoBandejaSIGED>();
                for (DtoBandejaSIGED obj : this.empleadoNuevaBandeja.getBandejas()) {
                    if ("A".equals(obj.getEstado())) {
                        bandejaNueva.add(obj);
                    }
                }
                this.empleadoNuevaBandeja.getBandejas().clear();
                this.empleadoNuevaBandeja.setBandejas((List)bandejaNueva);
                if (this.dw_1.getConceptoacceso().equals("94") && !UValidador.esListaVacia(this.empleadoNuevaBandeja.getAdministrativo())) {
                    for (DtoAdministrativoSIGED obj2 : this.empleadoNuevaBandeja.getAdministrativo()) {
                        for (DtoBandejaSIGED objdet : this.empleadoNuevaBandeja.getBandejas()) {
                            if (obj2.getIdArea().toString().equals(objdet.getIdArea().toString())) {
                                objdet.setEsJefe(obj2.getEsJefe());
                            }
                        }
                    }
                }
            }
        }
        else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }
    }
    
    private String obtenerToken() throws JsonParseException, JsonMappingException, IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept((List)Collections.singletonList(MediaType.APPLICATION_JSON));
        String username = UAplicacion.getServletContext().getInitParameter("USUARIO_TOKEN");
        String clave = UAplicacion.getServletContext().getInitParameter("CLAVE_TOKEN");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", username);
        map.put("password", clave);
        HttpEntity<Map<String, Object>> entity = (HttpEntity<Map<String, Object>>)new HttpEntity((Object)map, (MultiValueMap)headers);
        String url = UAplicacion.getServletContext().getInitParameter("URL_OBTENER_TOKEN");
        ResponseEntity<String> response = (ResponseEntity<String>)restTemplate.postForEntity(url, (Object)entity, (Class)String.class, new Object[0]);
        JsonNode retorno = new ObjectMapper().readTree((String)response.getBody());
        String token = retorno.get("token").asText();
        return token;
    }
    
    private List<DtoAreaDetalleSIGED> obtenerAreas() throws JsonParseException, JsonMappingException, IOException {
        RestTemplate restTemplate = new RestTemplate();
        DtoAreaSIGED retornoArea = new DtoAreaSIGED();
        String token = this.obtenerToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept((List)Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", token);
        HttpEntity request = new HttpEntity((MultiValueMap)headers);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nombre", null);
        map.put("idArea", null);
        HttpEntity<Map<String, Object>> entity = (HttpEntity<Map<String, Object>>)new HttpEntity((Object)map, (MultiValueMap)headers);
        String url = UAplicacion.getServletContext().getInitParameter("URL_OBTENER_AREAS");
        ResponseEntity<String> response = (ResponseEntity<String>)restTemplate.postForEntity(url, (Object)entity, (Class)String.class, new Object[0]);
        if (response.getStatusCode() == HttpStatus.OK) {
            if (UValidador.esNulo(response.getBody())) {
                this.setMessageError("No se ha encontrado Areas para el usuario " + this.usuarioRed + " en el Servicio SIGED");
                return null;
            }
            System.out.println("Request Successful.");
            retornoArea = (DtoAreaSIGED)new ObjectMapper().readValue((String)response.getBody(), (Class)DtoAreaSIGED.class);
        }
        else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }
        if (!UValidador.esNulo((Object)retornoArea)) {
            return (List<DtoAreaDetalleSIGED>)retornoArea.getAreas();
        }
        return null;
    }
    
    private List<DtoCargoDetalleSIGED> obtenerCargos(Integer idArea) throws JsonParseException, JsonMappingException, IOException {
        RestTemplate restTemplate = new RestTemplate();
        DtoCargoSIGED retornoCargo = new DtoCargoSIGED();
        List<DtoCargoDetalleSIGED> listaCargos = new ArrayList<DtoCargoDetalleSIGED>();
        String token = this.obtenerToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept((List)Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", token);
        HttpEntity request = new HttpEntity((MultiValueMap)headers);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nombre", null);
        map.put("area", idArea);
        HttpEntity<Map<String, Object>> entity = (HttpEntity<Map<String, Object>>)new HttpEntity((Object)map, (MultiValueMap)headers);
        String url = UAplicacion.getServletContext().getInitParameter("URL_OBTENER_CARGOS");
        ResponseEntity<String> response = (ResponseEntity<String>)restTemplate.postForEntity(url, (Object)entity, (Class)String.class, new Object[0]);
        if (response.getStatusCode() == HttpStatus.OK) {
            if (UValidador.esNulo(response.getBody())) {
                this.setMessageError("No se ha encontrado Cargos para el usuario " + this.usuarioRed + " en el Servicio SIGED");
                return null;
            }
            System.out.println("Request Successful.");
            retornoCargo = (DtoCargoSIGED)new ObjectMapper().readValue((String)response.getBody(), (Class)DtoCargoSIGED.class);
            if (!UValidador.esListaVacia(retornoCargo.getList())) {
                for (DtoCargoDetalleSIGED cargos : retornoCargo.getList()) {
                    listaCargos.add(cargos);
                }
            }
        }
        else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }
        return listaCargos;
    }
    
    private Date wf_rangofechas(Integer pardato, Date fecha, Integer par_dias) throws Exception {
        if (pardato == 1) {
            return UFechaHora.obtenerFechaMasMeses(fecha, Integer.valueOf(-par_dias));
        }
        if (pardato == 2) {
            return UFechaHora.convertirCadenaFecha(UFechaHora.convertirFechaCadena(fecha), "dd/MM/yyyy");
        }
        return null;
    }
    
    private void guardarEmpleadoExcepcion() {
        List<AsEmpleadoexcepcionsolicitud> horarios = (List<AsEmpleadoexcepcionsolicitud>)this.getFacAsistencia().getAsEmpleadoexcepcionsolicitudServicio().listarEmpleadoExcepcionSolicitud(this.dw_1.getEmpleado(), this.dw_1.getFecha());
        if (!UValidador.esListaVacia((List)horarios)) {
            for (AsEmpleadoexcepcionsolicitud objhor : horarios) {
                AsEmpleadoexcepcionPk pkdel = new AsEmpleadoexcepcionPk();
                pkdel.setEmpleado(this.dw_1.getEmpleado());
                pkdel.setFecha(objhor.getPk().getFecha());
                pkdel.setFechahasta(objhor.getPk().getFecha());
                AsEmpleadoexcepcion objdel = (AsEmpleadoexcepcion)this.getFacAsistencia().getAsEmpleadoexcepcionServicio().obtenerPorId((Serializable)pkdel, false);
                if (!UValidador.esNulo((Object)objdel)) {
                    this.getFacAsistencia().getAsEmpleadoexcepcionServicio().eliminar((Object)objdel);
                }
                AsEmpleadoexcepciondetallePk pkdetdel = new AsEmpleadoexcepciondetallePk();
                pkdetdel.setEmpleado(this.dw_1.getEmpleado());
                pkdetdel.setFecha(objhor.getPk().getFecha());
                pkdetdel.setIntervaloacceso(objhor.getIntervaloacceso());
                pkdetdel.setSecuencia(Integer.valueOf(1));
                AsEmpleadoexcepciondetalle objdetdel = (AsEmpleadoexcepciondetalle)this.getFacAsistencia().getAsEmpleadoexcepciondetalleServicio().obtenerPorId((Serializable)pkdetdel, false);
                if (!UValidador.esNulo((Object)objdetdel)) {
                    this.getFacAsistencia().getAsEmpleadoexcepciondetalleServicio().eliminar((Object)objdetdel);
                }
            }
            for (AsEmpleadoexcepcionsolicitud objhor : horarios) {
                AsEmpleadoexcepcion objinsempex = new AsEmpleadoexcepcion();
                objinsempex.getPk().setEmpleado(this.dw_1.getEmpleado());
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
                objinsempex.setUltimoUsuario(this.getUsuarioActual().getCodigoUsuario());
                objinsempex.setUltimaFechaModif(new Date());
                this.getFacAsistencia().getAsEmpleadoexcepcionServicio().registrar((Object)objinsempex);
                AsEmpleadoexcepciondetalle objinsempexdet = new AsEmpleadoexcepciondetalle();
                objinsempexdet.getPk().setEmpleado(this.dw_1.getEmpleado());
                objinsempexdet.getPk().setFecha(objhor.getPk().getFecha());
                objinsempexdet.getPk().setIntervaloacceso(objhor.getIntervaloacceso());
                objinsempexdet.getPk().setSecuencia(Integer.valueOf(1));
                objinsempexdet.setTipodia(objhor.getTipodia());
                this.getFacAsistencia().getAsEmpleadoexcepciondetalleServicio().registrar((Object)objinsempexdet);
            }
        }
    }
    
    public void valuechangedHorarioTipoDia(ValueChangeEvent event) {
        BigDecimal tipodia = (BigDecimal)event.getNewValue();
        if (UValidador.esCero(Integer.valueOf(tipodia.intValue()))) {
            this.dw_horarioregistro.setTipodia(BigDecimal.ZERO);
            this.dw_horarioregistro.setDescripcion("(Ninguno)");
            this.dw_horarioregistro.setHorasdescripcion("00:00");
            this.dw_horarioregistro.setHorasrefrigeriodescripcion("00:00");
        }
        for (DtoDddwAsTipodiaasistenciaSelect obj : this.lstTipoDia) {
            if (UValidador.esCero(Integer.valueOf(obj.getTipodia().compareTo(tipodia)))) {
                this.dw_horarioregistro.setDescripcion(obj.getDescripcionlocal());
                this.dw_horarioregistro.setHoras(obj.getSuma());
                this.dw_horarioregistro.setHorasrefrigerio(obj.getSumarefrigerio());
                this.dw_horarioregistro.setHorainicio(obj.getHorainicio());
                this.dw_horarioregistro.setHorafin(obj.getHorafin());
                if (UValidador.esCero(Integer.valueOf(this.dw_horarioregistro.getHoras().intValue()))) {
                    this.dw_horarioregistro.setHorasdescripcion("00:00");
                }
                else {
                    this.dw_horarioregistro.setHorasdescripcion(this.obtenerHorasAcumuladas(this.dw_horarioregistro.getHoras()));
                }
                if (UValidador.esCero(Integer.valueOf(this.dw_horarioregistro.getHorasrefrigerio().intValue()))) {
                    this.dw_horarioregistro.setHorasrefrigeriodescripcion("00:00");
                    break;
                }
                this.dw_horarioregistro.setHorasrefrigeriodescripcion(this.obtenerHorasAcumuladas(this.dw_horarioregistro.getHorasrefrigerio()));
                break;
            }
        }
    }
    
    public void valuechangeFecha(SelectEvent event) throws Exception {
        if (UValidador.esNulo((Object)event)) {
            return;
        }
        Date fecha = (Date)event.getObject();
        this.dw_1.setFecha(fecha);
        this.dw_1.setFechafin(UFechaHora.obtenerFechaHoraFinDia(fecha));
        this.eliminarHorariosFueraRango(1);
        this.wf_poner_fecha_fin();
        if ("OMIS".equals(this.dw_1.getCategoriaautorizacion()) && CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
            this.dw_1.setDesde1((Date)null);
        }
        this.diferenciaDia = new StringBuilder(String.valueOf(UFechaHora.obtenerDiasTranscurridos(this.dw_1.getFechafin(), this.dw_1.getFecha()) + 1)).toString();
        if (this.flgDiaSiguiente) {
            this.dw_1.setFechafin(UFechaHora.obtenerFechaHoraFinDia(UFechaHora.anadirDiasAFechas(fecha, 1)));
        }
    }
    
    public void valuechangeFechaFin(SelectEvent event) throws Exception {
        if (UValidador.esNulo((Object)event)) {
            return;
        }
        Date fecha = (Date)event.getObject();
        this.dw_1.setFechafin(UFechaHora.obtenerFechaHoraFinDia(fecha));
        this.eliminarHorariosFueraRango(2);
        this.wf_poner_fecha_fin();
        if ("VACA".equals(this.dw_1.getConceptoacceso()) || "ADEL".equals(this.dw_1.getConceptoacceso()) || "FRAD".equals(this.dw_1.getConceptoacceso())) {
            this.diferenciaDia = new StringBuilder(String.valueOf(UFechaHora.obtenerDiasTranscurridos(this.dw_1.getFechafin(), this.dw_1.getFecha()) + 1)).toString();
        }
        else {
            this.diferenciaDia = new StringBuilder().append(this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(this.dw_1.getFecha(), this.dw_1.getFechafin())).toString();
        }
    }
    
    public void valuechangeFechaRecupera(SelectEvent event) throws Exception {
        if (UValidador.esNulo((Object)event)) {
            return;
        }
        Date fecha = (Date)event.getObject();
        this.dw_1.setDesderecupera(fecha);
        this.dw_1.setHastarecupera(UFechaHora.obtenerFechaMasdias(this.dw_1.getDesderecupera(), Integer.valueOf(this.diasLicPer - 1)));
    }
    
    public void keyfechainicioRecupera() throws Exception {
        this.dw_1.setHastarecupera(UFechaHora.obtenerFechaMasdias(this.dw_1.getDesderecupera(), Integer.valueOf(this.diasLicPer - 1)));
    }
    
    public void valuechangeTipoAutorizacion(ValueChangeEvent event) throws Exception {
        if (UValidador.esNulo((Object)event)) {
            return;
        }
        String tipo = (String)event.getNewValue();
        this.dw_1.setTipoautorizacion(tipo);
        this.validateTipoAutorizacion(tipo);
    }
    
    private void validateTipoAutorizacion(String tipo) throws Exception {
        if (UValidador.estaVacio(tipo)) {
            return;
        }
    }
    
    public void keyfechainicio() throws Exception {
        this.dw_1.setFechafin(this.dw_1.getFecha());
        this.eliminarHorariosFueraRango(1);
        this.wf_poner_fecha_fin();
        if ("OMIS".equals(this.dw_1.getCategoriaautorizacion()) && CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Add")) {
            this.dw_1.setDesde1((Date)null);
        }
        this.diferenciaDia = new StringBuilder(String.valueOf(UFechaHora.obtenerDiasTranscurridos(this.dw_1.getFechafin(), this.dw_1.getFecha()) + 1)).toString();
    }
    
    public void keyfechafin() throws Exception {
        if ("VACA".equals(this.dw_1.getConceptoacceso()) || "ADEL".equals(this.dw_1.getConceptoacceso()) || "FRAD".equals(this.dw_1.getConceptoacceso())) {
            this.diferenciaDia = new StringBuilder(String.valueOf(UFechaHora.obtenerDiasTranscurridos(this.dw_1.getFechafin(), this.dw_1.getFecha()) + 1)).toString();
        }
        else {
            this.diferenciaDia = new StringBuilder().append(this.getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(this.dw_1.getFecha(), this.dw_1.getFechafin())).toString();
        }
    }
    
    public void keyhorainicio() throws Exception {
        if ("OMIS".equals(this.dw_1.getConceptoacceso())) {
            return;
        }
        double horas = UFechaHora.obtenerDiferenciaSegundos(this.dw_1.getDesde1(), this.dw_1.getHasta1()) / 3600.0;
        if (horas < 0.0) {
            horas = 0.0;
        }
        horas = new BigDecimal(horas).subtract(this.obtenerHorasRefrigerio()).doubleValue();
        this.diferenciaHora = this.obtenerHorasAcumuladas(BigDecimal.valueOf(horas));
    }
    
    public void keyhorafin() throws Exception {
        double horas = UFechaHora.obtenerDiferenciaSegundos(this.dw_1.getDesde1(), this.dw_1.getHasta1()) / 3600.0;
        if (horas < 0.0) {
            horas = 0.0;
        }
        horas = new BigDecimal(horas).subtract(this.obtenerHorasRefrigerio()).doubleValue();
        this.diferenciaHora = this.obtenerHorasAcumuladas(BigDecimal.valueOf(horas));
    }
    
    public void validarfechainicio(FacesContext context, UIComponent component, Object value) {
        if (UValidador.esNulo(value)) {
            FacesMessage message = new FacesMessage("El campo fecha del es requerida");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
        try {
            this.dw_1.setFecha((Date)value);
        }
        catch (Exception e) {}
    }
    
    public void validarfechafin(FacesContext context, UIComponent component, Object value) {
        if (UValidador.esNulo(value)) {
            FacesMessage message = new FacesMessage("El campo fecha al es requerida");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
        try {
            this.dw_1.setFechafin((Date)value);
        }
        catch (Exception e) {}
    }
    
    private void wf_Refrescar_Visibilidad_Hora() throws Exception {
        if (this.dw_1.getCategoriaautorizacion().equals("COMP") || this.dw_1.getCategoriaautorizacion().equals("OTRO") || this.dw_1.getCategoriaautorizacion().equals("VACA") || this.dw_1.getCategoriaautorizacion().equals("SOBR") || this.dw_1.getCategoriaautorizacion().equals("ADFR")) {
            this.dwc_ConceptoAccesoFiltrado.clear();
            this.dwc_ConceptoAccesoFiltrado.addAll(this.dwc_ConceptoAcceso);
            if (this.dw_1.getCategoriaautorizacion().equals("COMP")) {
                this.dwc_ConceptoAccesoFiltrado.clear();
                for (DtoDddwAsConceptoaccesoSelectPre obj : this.dwc_ConceptoAcceso) {
                    if (obj.getFlagcompensa().equals("S")) {
                        this.dwc_ConceptoAccesoFiltrado.add(obj);
                    }
                }
            }
            if (this.dw_1.getCategoriaautorizacion().equals("OTRO")) {
                this.dwc_ConceptoAccesoFiltrado.clear();
                for (DtoDddwAsConceptoaccesoSelectPre obj : this.dwc_ConceptoAcceso) {
                    if (obj.getFlagotrospermisos().equals("S")) {
                        this.dwc_ConceptoAccesoFiltrado.add(obj);
                    }
                }
            }
            if (this.dw_1.getCategoriaautorizacion().equals("ADFR")) {
                this.dwc_ConceptoAccesoFiltrado.clear();
                for (DtoDddwAsConceptoaccesoSelectPre obj : this.dwc_ConceptoAcceso) {
                    if (obj.getFlagvacaciones().equals("S")) {
                        this.dwc_ConceptoAccesoFiltrado.add(obj);
                    }
                }
            }
            if (!UValidador.esListaVacia((List)this.dwc_ConceptoAccesoFiltrado)) {
                Integer ll_find = null;
                String ls_conceptoacceso = this.dw_1.getConceptoacceso();
                for (int i = 0; i < this.dwc_ConceptoAccesoFiltrado.size(); ++i) {
                    DtoDddwAsConceptoaccesoSelectPre obj2 = this.dwc_ConceptoAccesoFiltrado.get(i);
                    if (obj2.getConceptoacceso().equals(ls_conceptoacceso)) {
                        ll_find = i;
                    }
                }
                if (!UValidador.esNulo((Object)ll_find)) {
                    if (this.dwc_ConceptoAccesoFiltrado.get(ll_find).getExpresadoen().equals("D") && this.iscambioonceptoevento) {
                        this.opciones.setIsmostrartextohora1(Boolean.valueOf(false));
                        this.opciones.setIsmostrartextohora2(Boolean.valueOf(false));
                        this.opciones.setIsmostrartde(Boolean.valueOf(false));
                        this.opciones.setIsmostrarta(Boolean.valueOf(false));
                        this.opciones.setIsmostrardesde1(Boolean.valueOf(false));
                        this.opciones.setIsmostrarhasta1(Boolean.valueOf(false));
                        Date ldt_desde = null;
                        Date ldt_hasta = null;
                        Integer ll_empleado = this.dw_1.getEmpleado();
                        Date ldt_fecha = this.dw_1.getFecha();
                        List data = this.getFacAsistencia().getAS().getAsrepusFuncion().FAsAutorizacionPreprocesoTipodia2(ll_empleado, ldt_fecha);
                        if (!UValidador.esListaVacia(data)) {
                            ldt_desde = (Date) data.get(0);
                            ldt_hasta = (Date) data.get(1);
                        }
                        if (!UValidador.esNulo((Object)ldt_desde)) {
                            this.dw_1.setDesde1(ldt_desde);
                        }
                        if (!UValidador.esNulo((Object)ldt_hasta)) {
                            this.dw_1.setHasta1(ldt_hasta);
                        }
                        this.keyhorainicio();
                        this.iscambioonceptoevento = false;
                    }
                    else {
                        this.opciones.setIsmostrartextohora1(Boolean.valueOf(true));
                        this.opciones.setIsmostrartextohora2(Boolean.valueOf(true));
                        this.opciones.setIsmostrartde(Boolean.valueOf(true));
                        this.opciones.setIsmostrarta(Boolean.valueOf(true));
                        this.opciones.setIsmostrardesde1(Boolean.valueOf(false));
                        this.opciones.setIsmostrarhasta1(Boolean.valueOf(false));
                        if (!this.dw_1.getCategoriaautorizacion().equals("VACA") && !this.dwc_ConceptoAccesoFiltrado.get(ll_find).getExpresadoen().equals("D")) {
                            this.opciones.setIsmostrardesde1(Boolean.valueOf(true));
                            this.opciones.setIsmostrarhasta1(Boolean.valueOf(true));
                        }
                    }
                }
                else if (this.dw_1.getCategoriaautorizacion().equals("VACA")) {
                    this.opciones.setIsmostrartextohora1(Boolean.valueOf(false));
                    this.opciones.setIsmostrartextohora2(Boolean.valueOf(false));
                    this.opciones.setIsmostrartde(Boolean.valueOf(false));
                    this.opciones.setIsmostrarta(Boolean.valueOf(false));
                    this.opciones.setIsmostrardesde1(Boolean.valueOf(false));
                    this.opciones.setIsmostrarhasta1(Boolean.valueOf(false));
                }
                else if (this.dw_1.getCategoriaautorizacion().equals("SOBR") || this.dw_1.getCategoriaautorizacion().equals("COMP")) {
                    this.opciones.setIsmostrartextohora1(Boolean.valueOf(true));
                    this.opciones.setIsmostrartextohora2(Boolean.valueOf(true));
                    this.opciones.setIsmostrartde(Boolean.valueOf(true));
                    this.opciones.setIsmostrarta(Boolean.valueOf(true));
                    this.opciones.setIsmostrardesde1(Boolean.valueOf(true));
                    this.opciones.setIsmostrarhasta1(Boolean.valueOf(true));
                }
            }
        }
        else if (this.dw_1.getCategoriaautorizacion().equals("OMIS")) {
            this.opciones.setIsmostrartextohora1(Boolean.valueOf(true));
            this.opciones.setIsmostrartextohora2(Boolean.valueOf(true));
            this.opciones.setIsmostrartde(Boolean.valueOf(true));
            this.opciones.setIsmostrarta(Boolean.valueOf(false));
            this.opciones.setIsmostrardesde1(Boolean.valueOf(true));
            this.opciones.setIsmostrarhasta1(Boolean.valueOf(false));
        }
        else if (this.dw_1.getCategoriaautorizacion().equals("PSIG")) {
            this.opciones.setIsmostrartextohora1(Boolean.valueOf(false));
            this.opciones.setIsmostrartextohora2(Boolean.valueOf(false));
            this.opciones.setIsmostrartde(Boolean.valueOf(false));
            this.opciones.setIsmostrarta(Boolean.valueOf(false));
            this.opciones.setIsmostrardesde1(Boolean.valueOf(false));
            this.opciones.setIsmostrarhasta1(Boolean.valueOf(false));
        }
        else {
            this.opciones.setIsmostrartextohora1(Boolean.valueOf(true));
            this.opciones.setIsmostrartextohora2(Boolean.valueOf(true));
            this.opciones.setIsmostrartde(Boolean.valueOf(true));
            this.opciones.setIsmostrarta(Boolean.valueOf(true));
            this.opciones.setIsmostrardesde1(Boolean.valueOf(true));
            this.opciones.setIsmostrarhasta1(Boolean.valueOf(true));
        }
    }
    
    private void eliminarHorariosFueraRango(Integer maxmin) {
        if (this.dw_1.getConceptoacceso().equals("CHOR") && !UValidador.esListaVacia((List)this.dw_horario)) {
            for (int i = 0; i < this.dw_horario.size(); ++i) {
                DtoDwCambioHorarioExcepcion obj = this.dw_horario.get(i);
                obj.setFechasolicitud(this.dw_1.getFecha());
                if (maxmin.equals(1) && (obj.getFecha().before(this.dw_1.getFecha()) || obj.getFecha().after(this.dw_1.getFechafin()))) {
                    this.dw_horario.remove(i);
                    --i;
                }
                if (maxmin.equals(2) && obj.getFecha().after(this.dw_1.getFechafin())) {
                    this.dw_horario.remove(i);
                    --i;
                }
            }
        }
    }
    
    public void validarEmpleado(FacesContext context, UIComponent component, Object value) {
        if (UValidador.esNulo(value) || UValidador.esCero((Integer)value)) {
            FacesMessage message = new FacesMessage("Debe seleccionar al Empleado antes de asignar el evento");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
    
    public void limpiarEmpleado() {
        this.dw_1.setEmpleado((Integer)null);
        this.dw_1.setEmpleadonombre((String)null);
        this.dw_1.setPuesto((String)null);
        this.dw_1.setCentrocosto((String)null);
    }
    
    public String nuevoHorario() throws Exception {
        this.setAccionPantalla(UIMantenimientoController.accion_solicitada.NUEVO);
        this.dw_horarioregistro = new DtoDwCambioHorarioExcepcion();
        Integer secuencia = 0;
        for (int k = 0; k < this.dw_horario.size(); ++k) {
            if (this.dw_horario.get(k).getSecuencia() > secuencia) {
                secuencia = this.dw_horario.get(k).getSecuencia();
            }
        }
        ++secuencia;
        this.dw_horarioregistro.setSecuencia(secuencia);
        this.dw_horarioregistro.setFecha(this.dw_1.getFecha());
        this.dw_horarioregistro.setTipodia((BigDecimal)null);
        this.dw_horarioregistro.setHoras(BigDecimal.valueOf(0.0));
        this.dw_horarioregistro.setDescripcion((String)null);
        this.dw_horarioregistro.setEmpleado(this.dw_1.getEmpleado());
        this.dw_horarioregistro.setFechasolicitud(this.dw_1.getFecha());
        this.dw_horarioregistro.setFechahasta(UFechaHora.obtenerFechaHoraFinDia(this.dw_1.getFecha()));
        this.dw_horarioregistro.setIntervaloacceso("TRAB");
        this.dw_horarioregistro.setEstado("A");
        this.dw_horarioregistro.setUltimousuario(this.getUsuarioActual().getLoginUsuario().toUpperCase());
        this.dw_horarioregistro.setUltimafecha(new Date());
        this.getWebControlContext().actualizar("dgHorarioMantenimiento");
        this.getWebControlContext().ejecutar("PF('popHorarioMantenimiento').show()");
        return null;
    }
    
    public void valuechangeHora(SelectEvent event) throws Exception {
        if (UValidador.esNulo((Object)event)) {
            return;
        }
        Date fecha = (Date)event.getObject();
        this.dw_1.setDesde1(fecha);
        double horas = UFechaHora.obtenerDiferenciaSegundos(this.dw_1.getDesde1(), this.dw_1.getHasta1()) / 3600.0;
        if (horas < 0.0) {
            horas = 0.0;
        }
        horas = new BigDecimal(horas).subtract(this.obtenerHorasRefrigerio()).doubleValue();
        this.diferenciaHora = this.obtenerHorasAcumuladas(BigDecimal.valueOf(horas));
    }
    
    public void valuechangeHoraFin(SelectEvent event) throws Exception {
        if (UValidador.esNulo((Object)event)) {
            return;
        }
        Date fecha = (Date)event.getObject();
        this.dw_1.setHasta1(fecha);
        double horas = UFechaHora.obtenerDiferenciaSegundos(this.dw_1.getDesde1(), this.dw_1.getHasta1()) / 3600.0;
        if (horas < 0.0) {
            horas = 0.0;
        }
        horas = new BigDecimal(horas).subtract(this.obtenerHorasRefrigerio()).doubleValue();
        this.diferenciaHora = this.obtenerHorasAcumuladas(BigDecimal.valueOf(horas));
    }
    
    public String editarHorario() {
        this.setAccionPantalla(UIMantenimientoController.accion_solicitada.EDITAR);
        this.getWebControlContext().actualizar("dgHorarioMantenimiento");
        this.getWebControlContext().ejecutar("PF('popHorarioMantenimiento').show()");
        return null;
    }
    
    public String copiarHorario() {
        if (!UValidador.esListaVacia((List)this.dw_horario)) {
            this.dw_horarioregistro = this.dw_horario.get(this.dw_horario.size() - 1);
            Date maxfecha = this.dw_horarioregistro.getFecha();
            for (DtoDwCambioHorarioExcepcion hor : this.dw_horario) {
                if (hor.getFecha().after(maxfecha)) {
                    this.dw_horarioregistro = hor;
                }
            }
            Integer secuencia = 0;
            for (int k = 0; k < this.dw_horario.size(); ++k) {
                if (this.dw_horario.get(k).getSecuencia() > secuencia) {
                    secuencia = this.dw_horario.get(k).getSecuencia();
                }
            }
            ++secuencia;
            DtoDwCambioHorarioExcepcion objcopia = new DtoDwCambioHorarioExcepcion();
            objcopia.setSecuencia(secuencia);
            objcopia.setDescripcion(this.dw_horarioregistro.getDescripcion());
            objcopia.setEmpleado(this.dw_horarioregistro.getEmpleado());
            objcopia.setEstado(this.dw_horarioregistro.getEstado());
            objcopia.setFechahasta(this.dw_horarioregistro.getFechahasta());
            objcopia.setFechasolicitud(this.dw_horarioregistro.getFechasolicitud());
            objcopia.setFecha(this.dw_horarioregistro.getFecha());
            objcopia.setHoras(this.dw_horarioregistro.getHoras());
            objcopia.setHorasdescripcion(this.dw_horarioregistro.getHorasdescripcion());
            objcopia.setHorasrefrigerio(this.dw_horarioregistro.getHorasrefrigerio());
            objcopia.setHorasrefrigeriodescripcion(this.dw_horarioregistro.getHorasrefrigeriodescripcion());
            objcopia.setIntervaloacceso(this.dw_horarioregistro.getIntervaloacceso());
            objcopia.setTipodia(this.dw_horarioregistro.getTipodia());
            objcopia.setFecha(UFechaHora.obtenerFechaMasdias(objcopia.getFecha(), Integer.valueOf(1)));
            if (objcopia.getFecha().after(this.dw_1.getFechafin())) {
                this.setMessageError("No puede copiar la fecha, sobrepasar\u00eda la fecha fin de la Autorizaci\u00f3n");
                return null;
            }
            Integer diasemana = UFechaHora.obtenerNumeroDiaSemana(objcopia.getFecha());
            String nombre = UFechaHora.obtenerDiaEnCadena((int)diasemana);
            objcopia.setDianombre(nombre);
            this.dw_horario.add(objcopia);
            this.calcularTotalHorasHorario();
        }
        return null;
    }
    
    public String insertarHorario() {
        for (int i = 0; i < this.dw_horario.size(); ++i) {
            if (!this.dw_horario.get(i).getSecuencia().equals(this.dw_horarioregistro.getSecuencia()) && UValidador.esCero(UFechaHora.obtenerDiasTranscurridos(this.dw_horario.get(i).getFecha(), this.dw_horarioregistro.getFecha()))) {
                this.setMessageError("Ya existe una fecha igual, verifique por favor.");
                return null;
            }
        }
        Integer diasemana = UFechaHora.obtenerNumeroDiaSemana(this.dw_horarioregistro.getFecha());
        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("diasemana " + diasemana));
        String nombre = UFechaHora.obtenerDiaEnCadena((int)diasemana);
        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("nombre " + nombre));
        this.dw_horarioregistro.setDianombre(nombre);
        this.dw_horarioregistro.setFechahasta(this.dw_horarioregistro.getFecha());
        if (this.getAccionPantalla().equals((Object)UIMantenimientoController.accion_solicitada.NUEVO)) {
            this.dw_horario.add(this.dw_horarioregistro);
        }
        if (this.getAccionPantalla().equals((Object)UIMantenimientoController.accion_solicitada.EDITAR)) {
            for (DtoDwCambioHorarioExcepcion obj : this.dw_horario) {
                if (obj.getSecuencia().equals(this.dw_horarioregistro.getSecuencia())) {
                    obj = this.dw_horarioregistro;
                    break;
                }
            }
        }
        this.calcularTotalHorasHorario();
        this.getWebControlContext().actualizar("wasautorizacionpreprocesohextraedit:tblHorario");
        this.getWebControlContext().ejecutar("PF('popHorarioMantenimiento').hide()");
        return null;
    }
    
    public String eliminarHorario() {
        for (int i = 0; i < this.dw_horario.size(); ++i) {
            DtoDwCambioHorarioExcepcion obj = this.dw_horario.get(i);
            if (obj.getSecuencia().equals(this.dw_horarioregistro.getSecuencia())) {
                this.dw_horario.remove(i);
                --i;
            }
        }
        this.calcularTotalHorasHorario();
        return null;
    }
    
    private void calcularTotalHorasHorario() {
        this.totalhorashorario = new BigDecimal(0.0);
        this.totalhorastrabajo = new BigDecimal(0.0);
        this.totalhorasrefrigerio = new BigDecimal(0.0);
        for (DtoDwCambioHorarioExcepcion obj : this.dw_horario) {
            this.totalhorastrabajo = this.totalhorastrabajo.add(obj.getHoras());
            this.totalhorasrefrigerio = this.totalhorasrefrigerio.add(obj.getHorasrefrigerio());
        }
        this.totalhorashorario = this.totalhorashorario.add(this.totalhorastrabajo).add(this.totalhorasrefrigerio);
        this.totalhorashorariodescripcion = this.obtenerHorasAcumuladas(this.totalhorashorario);
        this.totalhorastrabajodescripcion = this.obtenerHorasAcumuladas(this.totalhorastrabajo);
        this.totalhorasrefrigeriodescripcion = this.obtenerHorasAcumuladas(this.totalhorasrefrigerio);
    }
    
    public void verDocumento() throws Exception {
        String archivo = this.dw_1.getRutadocumento();
        archivo = UFile.remplazarTildes(archivo);
        if (!UValidador.esNulo((Object)this.dw_1.getUuidalfresco())) {
            String obtenerParametroModoArchivo;
            switch (obtenerParametroModoArchivo = this.obtenerParametroModoArchivo()) {
                case "AL": {
                    if (UValidador.estaVacio(this.key) || UValidador.estaVacio(this.ws)) {
                        this.setMessageError("No se encontraron los parametros key o ws");
                        return;
                    }
                    try {
                        ContenidoECMBean respuestaconsulta = UOefaAlfresco.obtenerDocumento(this.dw_1.getUuidalfresco(), this.key);
                        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)respuestaconsulta);
                        if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
                            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)"Se encontro el archivo");
                            UFile.descargarArchivo(respuestaconsulta.getContenidoFile(), archivo);
                            System.gc();
                        }
                    }
                    catch (Exception e) {
                        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)e.getMessage());
                        this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
                        return;
                    }
                    break;
                }
                default:
                    break;
            }
        }
        else if (UValidador.esNulo((Object)this.dw_1.getRutadocumento())) {
            this.setMessageError("No ha seleccionado ning\u00fan archivo");
        }
    }
    
    public void verDocumentoDj() throws Exception {
        String archivo = this.dw_1.getNombrearchivodj();
        archivo = UFile.remplazarTildes(archivo);
        if (!UValidador.esNulo((Object)this.dw_1.getUuiddj())) {
            String obtenerParametroModoArchivo;
            switch (obtenerParametroModoArchivo = this.obtenerParametroModoArchivo()) {
                case "AL": {
                    if (UValidador.estaVacio(this.key) || UValidador.estaVacio(this.ws)) {
                        this.setMessageError("No se encontraron los parametros key o ws");
                        return;
                    }
                    try {
                        ContenidoECMBean respuestaconsulta = UOefaAlfresco.obtenerDocumento(this.dw_1.getUuiddj(), this.key);
                        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)respuestaconsulta);
                        if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
                            CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)"Se encontro el archivo");
                            UFile.descargarArchivo(respuestaconsulta.getContenidoFile(), archivo);
                            System.gc();
                        }
                    }
                    catch (Exception e) {
                        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)e.getMessage());
                        this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
                        return;
                    }
                    break;
                }
                default:
                    break;
            }
        }
        else if (UValidador.esNulo((Object)this.dw_1.getNombrearchivodj())) {
            this.setMessageError("No ha seleccionado ning\u00fan archivo");
        }
    }
    
    public String obtenerLicenciaRangoTexto(Integer empleado, Date fechaini, Date fechafin) throws Exception {
        String mensaje = "";
        List<DtoAsAutorizacion> dt = (List<DtoAsAutorizacion>)this.getFacAsistencia().getAsAutorizacionServicio().obtenerlicenciasempleadoPorFecha(empleado, fechaini, fechafin);
        if (dt != null && dt.size() > 0) {
            String desde = UFechaHora.convertirFechaCadena(dt.get(0).getDesde(), "dd/MM/yyyy");
            String hasta = UFechaHora.convertirFechaCadena(dt.get(0).getHasta(), "dd/MM/yyyy");
            mensaje = "Licencia del " + desde + " al " + hasta;
        }
        return mensaje;
    }
    
    public String obtenerVacacionesRangoTexto(Integer empleado, Date fechaini, Date fechafin, Integer periodomax) throws Exception {
        String mensaje = "";
        List<DtoAsAutorizacion> dt = (List<DtoAsAutorizacion>)this.getFacAsistencia().getAsAutorizacionServicio().obtenervacacionesempleadoPorFecha(empleado, fechaini, fechafin, periodomax);
        if (dt != null && dt.size() > 0) {
            String desde = UFechaHora.convertirFechaCadena(dt.get(0).getDesde(), "dd/MM/yyyy");
            String hasta = UFechaHora.convertirFechaCadena(dt.get(0).getHasta(), "dd/MM/yyyy");
            mensaje = "Vacaciones del " + desde + " al " + hasta;
        }
        return mensaje;
    }
    
    public String empleadoKeyEvent() throws Exception {
        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("dw_1.getEmpleado() " + this.dw_1.getEmpleado()));
        if (UValidador.esNulo((Object)this.dw_1.getEmpleado())) {
            return null;
        }
        Integer w_sid = this.getUsuarioActual().getUniqueIdInteger();
        CwAsAutorizacionPreprocesoHextraEditSIGED.LOGGER.debug((Object)("w_sid == " + w_sid));
        List empleados = this.getFacAsistencia().getAS().getAsoracleDatawindow().DwAsEmpleadoSelectMultiple(w_sid, this.dw_1.getEmpleado().toString(), (String)null);
        if (UValidador.esListaVacia(empleados)) {
            this.setMessageError("El empleado esta cesado o no existe.");
            this.limpiarEmpleado();
            return null;
        }
    	DtoDwAsEmpleadoSelectMultiple emp = (DtoDwAsEmpleadoSelectMultiple) empleados.get(0);

        if (UValidador.estaVacio(emp.getEstado())) {
            emp.setEstado("");
        }
        if (!emp.getEstado().equals("A")) {
            this.setMessageError("El empleado esta cesado o no existe.");
        }
        PersonamastPk pkfindp = new PersonamastPk();
        pkfindp.setPersona(Integer.valueOf(emp.getPersona().intValue()));
        Personamast objfindp = (Personamast)this.getFacCore().getPersonamastServicio().obtenerPorId((Serializable)pkfindp, false);
        this.cargarInfoEmpleado(emp.getPersona().intValue(), objfindp.getNombrecompleto());
        if (!UValidador.estaVacio(this.dw_1.getCategoriaautorizacion())) {
            this.cargarEvento(this.dw_1.getCategoriaautorizacion());
            this.cargarConceptoAcceso(this.dw_1.getConceptoacceso());
        }
        return null;
    }
    
    public String obtenerNombreUsuario(String usuario) {
        String nombre = null;
        if (!UValidador.estaVacio(usuario)) {
            Usuario user = (Usuario)this.getFacSeguridad().getUsuarioServicio().obtenerPorId((Serializable)new UsuarioPk(usuario.toUpperCase()));
            if (!UValidador.esNulo((Object)user)) {
                nombre = String.valueOf(user.getNombre()) + " " + user.getPk().getUsuario();
            }
        }
        return nombre;
    }
    
    public String guardardesdelicencia() throws Exception {
        if (!CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equalsIgnoreCase("Delete")) {
            if ("A".equals(this.dw_1.getEstado())) {
                this.setMessageSuccess("Se registr\u00f3 la autorizaci\u00f3n correctamente", Boolean.valueOf(true));
            }
            if ("S".equals(this.dw_1.getEstado())) {
                this.setMessageSuccess("Se registr\u00f3 la solicitud correctamente", Boolean.valueOf(true));
            }
        }
        CwAsAutorizacionPreprocesoAprobacionSIGED.getInstance().iniciarControladora();
        return "wasautorizacionpreprocesoaprobacionSIGED";
    }
    
    private DtoPermisosEnCompensacion obtenerPermisosCompensacion(Integer empleado, Date finpermiso, Integer diasCopensa) throws Exception {
        Integer anio = UFechaHora.obtenerAnio();
        DtoPermisosEnCompensacion obj = new DtoPermisosEnCompensacion();
        List<DtoPermisosEnCompensacion> datos = (List<DtoPermisosEnCompensacion>)this.getFacAsistencia().getAsAutorizacionServicio().listarPermisosCompensacion(empleado, anio);
        if (!UValidador.esListaVacia((List)datos)) {
            for (DtoPermisosEnCompensacion row : datos) {
                if (this.wf_diftiempo(row.getDesde(), row.getHasta()).subtract(this.obtenerHorasViernesVerano(empleado, row.getDesderecupera(), row.getHastarecupera())).compareTo(row.getHorascompensadas()) == 1) {
                    obj.setDesderecupera(UFechaHora.anadirDiasAFechas(row.getHastarecupera(), 1));
                    if (obj.getDesderecupera().getTime() < new Date().getTime()) {
                        obj.setDesderecupera(new Date());
                    }
                    obj.setHastarecupera(UFechaHora.anadirDiasAFechas(obj.getDesderecupera(), (int)diasCopensa));
                }
                else {
                    obj.setDesderecupera(UFechaHora.anadirDiasAFechas(finpermiso, 1));
                    if (obj.getDesderecupera().getTime() < new Date().getTime()) {
                        obj.setDesderecupera(new Date());
                    }
                    obj.setHastarecupera(UFechaHora.anadirDiasAFechas(obj.getDesderecupera(), (int)diasCopensa));
                }
            }
        }
        else {
            obj.setDesderecupera(UFechaHora.anadirDiasAFechas(finpermiso, 1));
            if (obj.getDesderecupera().getTime() < new Date().getTime()) {
                obj.setDesderecupera(new Date());
            }
            obj.setHastarecupera(UFechaHora.anadirDiasAFechas(obj.getDesderecupera(), (int)diasCopensa));
        }
        return obj;
    }
    
    private BigDecimal obtenerHorasViernesVerano(Integer empleado, Date desde, Date hasta) throws Exception {
        BigDecimal retorno = BigDecimal.ZERO;
        List<DtoPermisosEnCompensacion> lista = (List<DtoPermisosEnCompensacion>)this.getFacAsistencia().getAsAutorizacionServicio().listarPermisosViernesVerano(empleado, desde, hasta);
        if (!UValidador.esListaVacia((List)lista)) {
            for (DtoPermisosEnCompensacion obj : lista) {
                if (obj.getDesderecupera().getTime() >= desde.getTime() && obj.getHastarecupera().getTime() <= hasta.getTime()) {
                    retorno = retorno.add(new BigDecimal(UFechaHora.obtenerDiasTranscurridos(obj.getHastarecupera(), obj.getDesderecupera()) + 1));
                }
                else if (obj.getDesderecupera().getTime() >= desde.getTime() && obj.getHastarecupera().getTime() > hasta.getTime()) {
                    retorno = retorno.add(new BigDecimal(UFechaHora.obtenerDiasTranscurridos(hasta, obj.getDesderecupera()) + 1));
                }
                else {
                    if (obj.getDesderecupera().getTime() >= desde.getTime() || obj.getHastarecupera().getTime() > hasta.getTime()) {
                        continue;
                    }
                    retorno = retorno.add(new BigDecimal(UFechaHora.obtenerDiasTranscurridos(obj.getHastarecupera(), desde) + 1));
                }
            }
        }
        return retorno;
    }
    
    private void eliminarPorErrorEnArchivo() {
        this.getFacAsistencia().getAsAutorizacionServicio().eliminarAutorizacion(this.dw_1.getEmpleado(), this.dw_1.getFecha(), this.dw_1.getConceptoacceso(), this.dw_1.getDesde1());
        this.eliminarSIGED(this.dw_1.getFecha(), ((boolean)this.opciones.getIsmostrarfechafin()) ? this.dw_1.getFechafin() : this.dw_1.getFecha(), this.dw_1.getConceptoacceso());
    }
    
    public void mostrarEmpleadosRolAsistenteSiged() throws Exception {
        CwAsEmpleadoSelect.getInstance().setiMantenimientoReferencia((UIMantenimientoController)this);
        CwAsEmpleadoSelect.getInstance().setFlgTodos("N");
        CwAsEmpleadoSelect.getInstance().iniciarControladora();
    }
    
    public void seleccionarEmpleadoJefeSiged(BigDecimal empleado) throws Exception {
        if (this.empleadoNuevaBandeja.getBandejas() != null) {
            for (DtoBandejaSIGED obj : this.empleadoNuevaBandeja.getBandejas()) {
                if (obj.getBlJefe()) {
                    if (obj.getIdPersonaSIA().intValue() != empleado.intValue()) {
                        break;
                    }
                    Empleadomast emp = this.getFacCore().getEmpleadomastServicio().obtenerEmpleadoMast(Integer.valueOf(obj.getIdPersonaSIA().intValue()));
                    if (UValidador.esNulo((Object)emp)) {
                        break;
                    }
                    DtoEmpleadoSIGED dtoEmpleadoSIGED = this.obtenerDetallePorEmpleadoSIA(emp.getCodigousuario());
                    if (UValidador.esNulo((Object)dtoEmpleadoSIGED) || UValidador.esNulo((Object)dtoEmpleadoSIGED.getBandejas())) {
                        break;
                    }
                    List<DtoBandejaSIGED> list = new ArrayList<DtoBandejaSIGED>();
                    for (DtoBandejaSIGED objdet : dtoEmpleadoSIGED.getBandejas()) {
                        if ("A".equals(objdet.getEstado()) && objdet.getIdArea() == (int)obj.getIdArea()) {
                            list.add(objdet);
                        }
                    }
                    if (list.size() == 0) {
                        this.setMessageError("El colaborador no tiene cargos en el area Siged seleccionada");
                        obj.setIdCargoaux((BigDecimal)null);
                    }
                    if (list.size() == 1) {
                        obj.setIdCargoaux(new BigDecimal(list.get(0).getIdCargo()));
                        obj.setCargonombreaux(list.get(0).getCargo());
                    }
                    if (list.size() > 1) {
                        this.idAreaSigedaux = new BigDecimal(obj.getIdArea());
                        this.idCargoSigedaux = new BigDecimal(obj.getIdCargo());
                        this.cargosSiged = list;
                        this.getWebControlContext().actualizar("dgCargosSiged3");
                        this.getWebControlContext().ejecutar("PF('popCargosSiged3').show()");
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    public void seleccionarEmpleadosistenteSiged(BigDecimal empleado) throws Exception {
        List<DtoDwAsEmpleadoSelectMultiple> lstEmpleados = (List<DtoDwAsEmpleadoSelectMultiple>)CwAsEmpleadoSelect.getInstance().getDw_list();
        if (!UValidador.esListaVacia((List)lstEmpleados)) {
            for (DtoDwAsEmpleadoSelectMultiple obj : lstEmpleados) {
                if (UValidador.esCero(Integer.valueOf(obj.getPersona().compareTo(empleado)))) {
                    obj.setBlasistentesiged(Boolean.valueOf(true));
                }
                else {
                    obj.setBlasistentesiged(Boolean.valueOf(false));
                }
            }
        }
        DtoDwAsEmpleadoSelectMultiple asEmpleadoSelectMultiple = this.obtenerEmpleadoRolAsistenteSiged();
        DtoEmpleadoSIGED dtoEmpleadoSIGED = this.obtenerDetallePorEmpleadoSIA(asEmpleadoSelectMultiple.getCodigoUsuarioEmpleado());
        if (!UValidador.esNulo((Object)dtoEmpleadoSIGED) && !UValidador.esNulo((Object)dtoEmpleadoSIGED.getBandejas())) {
            List<DtoBandejaSIGED> list = new ArrayList<DtoBandejaSIGED>();
            for (DtoBandejaSIGED objdet : dtoEmpleadoSIGED.getBandejas()) {
                if ("A".equals(objdet.getEstado()) && objdet.getIdArea() == this.nuevaBandeja.getIdAreaSIGED().intValue()) {
                    list.add(objdet);
                }
            }
            if (list.size() == 0) {
                this.setMessageError("El colaborador no tiene cargos en el area Siged seleecionada");
                this.idCargoSiged = null;
            }
            if (list.size() == 1) {
                this.idCargoSiged = new BigDecimal(list.get(0).getIdCargo());
                this.cargoaaSel = list.get(0).getCargo();
                this.getWebControlContext().actualizar("wasautorizacionpreprocesohextraedit:grdEmpleadoAsignacionAsistente");
            }
            if (list.size() > 1) {
                this.cargosSiged = list;
                this.getWebControlContext().actualizar("dgCargosSiged");
                this.getWebControlContext().ejecutar("PF('popCargosSiged').show()");
            }
        }
    }
    
    public void seleccionarEmpleadosistentePermSiged(BigDecimal empleado) throws Exception {
        List<DtoDwAsEmpleadoSelectMultiple> lstEmpleados = (List<DtoDwAsEmpleadoSelectMultiple>)CwAsEmpleadoSelect.getInstance().getDw_list();
        if (!UValidador.esListaVacia((List)lstEmpleados)) {
            for (DtoDwAsEmpleadoSelectMultiple obj : lstEmpleados) {
                if (UValidador.esCero(Integer.valueOf(obj.getPersona().compareTo(empleado)))) {
                    obj.setBlasistentepermsiged(Boolean.valueOf(true));
                }
                else {
                    obj.setBlasistentepermsiged(Boolean.valueOf(false));
                }
            }
        }
        DtoDwAsEmpleadoSelectMultiple asEmpleadoSelectMultiple = this.obtenerEmpleadoRolAsistentePermanenteSiged();
        DtoEmpleadoSIGED dtoEmpleadoSIGED = this.obtenerDetallePorEmpleadoSIA(asEmpleadoSelectMultiple.getCodigoUsuarioEmpleado());
        if (!UValidador.esNulo((Object)dtoEmpleadoSIGED) && !UValidador.esNulo((Object)dtoEmpleadoSIGED.getBandejas())) {
            List<DtoBandejaSIGED> list = new ArrayList<DtoBandejaSIGED>();
            for (DtoBandejaSIGED objdet : dtoEmpleadoSIGED.getBandejas()) {
                if ("A".equals(objdet.getEstado()) && objdet.getIdArea() == this.nuevaBandeja.getIdAreaSIGED().intValue()) {
                    list.add(objdet);
                }
            }
            if (list.size() == 0) {
                this.setMessageError("El colaborador no tiene cargos en el area Siged seleecionada");
                this.idCargoSiged2 = null;
            }
            if (list.size() == 1) {
                this.idCargoSiged2 = new BigDecimal(list.get(0).getIdCargo());
                this.cargoaaPermSel = list.get(0).getCargo();
                this.getWebControlContext().actualizar("wasautorizacionpreprocesohextraedit:grdEmpleadoAsignacionAsistente");
            }
            if (list.size() > 1) {
                this.cargosSiged = list;
                this.getWebControlContext().actualizar("dgCargosSiged2");
                this.getWebControlContext().ejecutar("PF('popCargosSiged2').show()");
            }
        }
    }
    
    public DtoDwAsEmpleadoSelectMultiple obtenerEmpleadoRolAsistenteSiged() throws Exception {
        DtoDwAsEmpleadoSelectMultiple retorno = new DtoDwAsEmpleadoSelectMultiple();
        List<DtoDwAsEmpleadoSelectMultiple> lstEmpleados = (List<DtoDwAsEmpleadoSelectMultiple>)CwAsEmpleadoSelect.getInstance().getDw_list();
        if (!UValidador.esListaVacia((List)lstEmpleados)) {
            for (DtoDwAsEmpleadoSelectMultiple obj : lstEmpleados) {
                if (obj.getBlasistentesiged()) {
                    retorno = obj;
                    break;
                }
            }
        }
        return retorno;
    }
    
    public DtoDwAsEmpleadoSelectMultiple obtenerEmpleadoRolAsistentePermanenteSiged() throws Exception {
        DtoDwAsEmpleadoSelectMultiple retorno = new DtoDwAsEmpleadoSelectMultiple();
        List<DtoDwAsEmpleadoSelectMultiple> lstEmpleados = (List<DtoDwAsEmpleadoSelectMultiple>)CwAsEmpleadoSelect.getInstance().getDw_list();
        if (!UValidador.esListaVacia((List)lstEmpleados)) {
            for (DtoDwAsEmpleadoSelectMultiple obj : lstEmpleados) {
                if (obj.getBlasistentepermsiged()) {
                    retorno = obj;
                    break;
                }
            }
        }
        return retorno;
    }
    
    public String seleccionarCargo() {
        if (this.cargosSiged != null) {
            for (DtoBandejaSIGED obj : this.cargosSiged) {
                if (obj.getIdCargo() == this.idCargoSiged.intValue()) {
                    this.cargoaaSel = obj.getCargo();
                    break;
                }
            }
        }
        this.getWebControlContext().actualizar("wasautorizacionpreprocesohextraedit:grdEmpleadoAsignacionAsistente");
        this.getWebControlContext().ejecutar("PF('popCargosSiged').hide()");
        return null;
    }
    
    public String seleccionarCargo2() {
        if (this.cargosSiged != null) {
            for (DtoBandejaSIGED obj : this.cargosSiged) {
                if (obj.getIdCargo() == this.idCargoSiged.intValue()) {
                    this.cargoaaPermSel = obj.getCargo();
                    break;
                }
            }
        }
        this.getWebControlContext().actualizar("wasautorizacionpreprocesohextraedit:grdEmpleadoAsignacionAsistente");
        this.getWebControlContext().ejecutar("PF('popCargosSiged2').hide()");
        return null;
    }
    
    public String seleccionarCargo3() {
        if (this.cargosSiged != null) {
            for (DtoBandejaSIGED obj : this.cargosSiged) {
                if (obj.getIdCargo() == this.idCargoSiged2.intValue()) {
                    this.cargojaSel = obj.getCargo();
                    break;
                }
            }
        }
        if (this.empleadoNuevaBandeja.getBandejas() != null) {
            for (DtoBandejaSIGED obj : this.empleadoNuevaBandeja.getBandejas()) {
                if (obj.getIdArea() == this.idAreaSigedaux.intValue() && obj.getIdCargo() == this.idCargoSigedaux.intValue()) {
                    obj.setIdCargoaux(this.idCargoSiged2);
                    obj.setCargonombreaux(this.cargojaSel);
                }
            }
        }
        this.getWebControlContext().actualizar("wasautorizacionpreprocesohextraedit:asignaFuncion");
        this.getWebControlContext().ejecutar("PF('popCargosSiged3').hide()");
        return null;
    }
    
    public DtoDwAsAutorizacionPreprocesoHextraeditV2 getDw_1() {
        return this.dw_1;
    }
    
    public void setDw_1(DtoDwAsAutorizacionPreprocesoHextraeditV2 dw_1) {
        this.dw_1 = dw_1;
    }
    
    public List<DtoDddwAsEmpleadosmastSelectCarnets> getDddw_as_empleadosmast_select_carnets() {
        return this.dddw_as_empleadosmast_select_carnets;
    }
    
    public void setDddw_as_empleadosmast_select_carnets(List<DtoDddwAsEmpleadosmastSelectCarnets> dddw_as_empleadosmast_select_carnets) {
        this.dddw_as_empleadosmast_select_carnets = dddw_as_empleadosmast_select_carnets;
    }
    
    public DtoDwFiltroTerminal getDw_filtraterminal() {
        return this.dw_filtraterminal;
    }
    
    public void setDw_filtraterminal(DtoDwFiltroTerminal dw_filtraterminal) {
        this.dw_filtraterminal = dw_filtraterminal;
    }
    
    public OwAsAutorizacionPreprocesoHextraEdit getOpciones() {
        return this.opciones;
    }
    
    public void setOpciones(OwAsAutorizacionPreprocesoHextraEdit opciones) {
        this.opciones = opciones;
    }
    
    public List<DtoDwAsMarcasEmpleado> getDw_2() {
        return this.dw_2;
    }
    
    public void setDw_2(List<DtoDwAsMarcasEmpleado> dw_2) {
        this.dw_2 = dw_2;
    }
    
    public Boolean getValidarfechas() {
        return this.validarfechas;
    }
    
    public void setValidarfechas(Boolean validarfechas) {
        this.validarfechas = validarfechas;
    }
    
    public List<DtoDddwAsConceptoaccesoSelectPre> getDwc_ConceptoAcceso() {
        return this.dwc_ConceptoAcceso;
    }
    
    public void setDwc_ConceptoAcceso(List<DtoDddwAsConceptoaccesoSelectPre> dwc_ConceptoAcceso) {
        this.dwc_ConceptoAcceso = dwc_ConceptoAcceso;
    }
    
    public List<DtoDddwAsTipohorarioSelect> getDwc_tipohorario() {
        return this.dwc_tipohorario;
    }
    
    public void setDwc_tipohorario(List<DtoDddwAsTipohorarioSelect> dwc_tipohorario) {
        this.dwc_tipohorario = dwc_tipohorario;
    }
    
    public List<DtoDddwAsTempusTerminal> getAn_terminal() {
        return this.an_terminal;
    }
    
    public void setAn_terminal(List<DtoDddwAsTempusTerminal> an_terminal) {
        this.an_terminal = an_terminal;
    }
    
    public List<DtoDddwAsConceptoaccesoSelectPre> getDwc_ConceptoAccesoFiltrado() {
        return this.dwc_ConceptoAccesoFiltrado;
    }
    
    public void setDwc_ConceptoAccesoFiltrado(List<DtoDddwAsConceptoaccesoSelectPre> dwc_ConceptoAccesoFiltrado) {
        this.dwc_ConceptoAccesoFiltrado = dwc_ConceptoAccesoFiltrado;
    }
    
    public DtoWAsAutorizacionHorasDisponibles getDw_horas() {
        return this.dw_horas;
    }
    
    public void setDw_horas(DtoWAsAutorizacionHorasDisponibles dw_horas) {
        this.dw_horas = dw_horas;
    }
    
    public List<DtoDwCambioHorarioExcepcion> getDw_horario() {
        return this.dw_horario;
    }
    
    public void setDw_horario(List<DtoDwCambioHorarioExcepcion> dw_horario) {
        this.dw_horario = dw_horario;
    }
    
    public DtoDwCambioHorarioExcepcion getDw_horarioregistro() {
        return this.dw_horarioregistro;
    }
    
    public void setDw_horarioregistro(DtoDwCambioHorarioExcepcion dw_horarioregistro) {
        this.dw_horarioregistro = dw_horarioregistro;
    }
    
    public List<DtoDddwAsTipodiaasistenciaSelect> getLstTipoDia() {
        return this.lstTipoDia;
    }
    
    public void setLstTipoDia(List<DtoDddwAsTipodiaasistenciaSelect> lstTipoDia) {
        this.lstTipoDia = lstTipoDia;
    }
    
    public BigDecimal getTotalhorashorario() {
        return this.totalhorashorario;
    }
    
    public void setTotalhorashorario(BigDecimal totalhorashorario) {
        this.totalhorashorario = totalhorashorario;
    }
    
    public List<DtoDwAsAsistenciaCompensacionEdit> getDw_compensacion() {
        return this.dw_compensacion;
    }
    
    public void setDw_compensacion(List<DtoDwAsAsistenciaCompensacionEdit> dw_compensacion) {
        this.dw_compensacion = dw_compensacion;
    }
    
    public Boolean getIb_elimina() {
        return this.ib_elimina;
    }
    
    public void setIb_elimina(Boolean ib_elimina) {
        this.ib_elimina = ib_elimina;
    }
    
    public String getTotalhorashorariodescripcion() {
        return this.totalhorashorariodescripcion;
    }
    
    public void setTotalhorashorariodescripcion(String totalhorashorariodescripcion) {
        this.totalhorashorariodescripcion = totalhorashorariodescripcion;
    }
    
    public BigDecimal getTotalhorastrabajo() {
        return this.totalhorastrabajo;
    }
    
    public void setTotalhorastrabajo(BigDecimal totalhorastrabajo) {
        this.totalhorastrabajo = totalhorastrabajo;
    }
    
    public BigDecimal getTotalhorasrefrigerio() {
        return this.totalhorasrefrigerio;
    }
    
    public void setTotalhorasrefrigerio(BigDecimal totalhorasrefrigerio) {
        this.totalhorasrefrigerio = totalhorasrefrigerio;
    }
    
    public String getTotalhorastrabajodescripcion() {
        return this.totalhorastrabajodescripcion;
    }
    
    public void setTotalhorastrabajodescripcion(String totalhorastrabajodescripcion) {
        this.totalhorastrabajodescripcion = totalhorastrabajodescripcion;
    }
    
    public String getTotalhorasrefrigeriodescripcion() {
        return this.totalhorasrefrigeriodescripcion;
    }
    
    public void setTotalhorasrefrigeriodescripcion(String totalhorasrefrigeriodescripcion) {
        this.totalhorasrefrigeriodescripcion = totalhorasrefrigeriodescripcion;
    }
    
    public List<DtoDwAsEventoUseridActivo> getDw_eventos() {
        return this.dw_eventos;
    }
    
    public void setDw_eventos(List<DtoDwAsEventoUseridActivo> dw_eventos) {
        this.dw_eventos = dw_eventos;
    }
    
    public List<DtoDwAsAsistenciaHextraEdit> getDw_diascompensados() {
        return this.dw_diascompensados;
    }
    
    public void setDw_diascompensados(List<DtoDwAsAsistenciaHextraEdit> dw_diascompensados) {
        this.dw_diascompensados = dw_diascompensados;
    }
    
    public String getAccion() {
        return this.accion;
    }
    
    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    public String getMensajelicencia() {
        return this.mensajelicencia;
    }
    
    public void setMensajelicencia(String mensajelicencia) {
        this.mensajelicencia = mensajelicencia;
    }
    
    public BigDecimal getTotalsaldoactual() {
        return this.totalsaldoactual;
    }
    
    public void setTotalsaldoactual(BigDecimal totalsaldoactual) {
        this.totalsaldoactual = totalsaldoactual;
    }
    
    public String getTotalsaldoactualhor() {
        return this.totalsaldoactualhor;
    }
    
    public void setTotalsaldoactualhor(String totalsaldoactualhor) {
        this.totalsaldoactualhor = totalsaldoactualhor;
    }
    
    public List<DtoAsAutorizacion> getLicencias() {
        return this.licencias;
    }
    
    public void setLicencias(List<DtoAsAutorizacion> licencias) {
        this.licencias = licencias;
    }
    
    public String getHorasSumadas() {
        return this.horasSumadas;
    }
    
    public void setHorasSumadas(String horasSumadas) {
        this.horasSumadas = horasSumadas;
    }
    
    public Boolean getVerHistorialVacaciones() {
        return this.verHistorialVacaciones;
    }
    
    public void setVerHistorialVacaciones(Boolean verHistorialVacaciones) {
        this.verHistorialVacaciones = verHistorialVacaciones;
    }
    
    public List<PrProcesoperiodo> getLstPeriodosPlanilla() {
        return this.lstPeriodosPlanilla;
    }
    
    public void setLstPeriodosPlanilla(List<PrProcesoperiodo> lstPeriodosPlanilla) {
        this.lstPeriodosPlanilla = lstPeriodosPlanilla;
    }
    
    public String getDiferenciaDia() {
        return this.diferenciaDia;
    }
    
    public void setDiferenciaDia(String diferenciaDia) {
        this.diferenciaDia = diferenciaDia;
    }
    
    public String getDiferenciaHora() {
        return this.diferenciaHora;
    }
    
    public void setDiferenciaHora(String diferenciaHora) {
        this.diferenciaHora = diferenciaHora;
    }
    
    public Boolean getFlgDiaSiguiente() {
        return this.flgDiaSiguiente;
    }
    
    public void setFlgDiaSiguiente(Boolean flgDiaSiguiente) {
        this.flgDiaSiguiente = flgDiaSiguiente;
    }
    
    public Boolean getIscambioonceptoevento() {
        return this.iscambioonceptoevento;
    }
    
    public void setIscambioonceptoevento(Boolean iscambioonceptoevento) {
        this.iscambioonceptoevento = iscambioonceptoevento;
    }
    
    public boolean isBlDeclaracionjurada() {
        return this.blDeclaracionjurada;
    }
    
    public void setBlDeclaracionjurada(boolean blDeclaracionjurada) {
        this.blDeclaracionjurada = blDeclaracionjurada;
    }
    
    public boolean isBlVerDeclaracionjurada() {
        return this.blVerDeclaracionjurada;
    }
    
    public void setBlVerDeclaracionjurada(boolean blVerDeclaracionjurada) {
        this.blVerDeclaracionjurada = blVerDeclaracionjurada;
    }
    
    public Boolean getVerAsignacionFuncion() {
        return this.verAsignacionFuncion;
    }
    
    public void setVerAsignacionFuncion(Boolean verAsignacionFuncion) {
        this.verAsignacionFuncion = verAsignacionFuncion;
    }
    
    public Boolean getVerAsignacionRol() {
        return this.verAsignacionRol;
    }
    
    public void setVerAsignacionRol(Boolean verAsignacionRol) {
        this.verAsignacionRol = verAsignacionRol;
    }
    
    public Boolean getVerNuevaBandeja() {
        return this.verNuevaBandeja;
    }
    
    public void setVerNuevaBandeja(Boolean verNuevaBandeja) {
        this.verNuevaBandeja = verNuevaBandeja;
    }
    
    public Boolean getVerActivacionTemporal() {
        return this.verActivacionTemporal;
    }
    
    public void setVerActivacionTemporal(Boolean verActivacionTemporal) {
        this.verActivacionTemporal = verActivacionTemporal;
    }
    
    public Boolean getVerConfigurarPerfil() {
        return this.verConfigurarPerfil;
    }
    
    public void setVerConfigurarPerfil(Boolean verConfigurarPerfil) {
        this.verConfigurarPerfil = verConfigurarPerfil;
    }
    
    public Integer getIdEmpleadoTemporal() {
        return this.idEmpleadoTemporal;
    }
    
    public void setIdEmpleadoTemporal(Integer idEmpleadoTemporal) {
        this.idEmpleadoTemporal = idEmpleadoTemporal;
    }
    
    public String getEmpleadoTemporalNombre() {
        return this.empleadoTemporalNombre;
    }
    
    public void setEmpleadoTemporalNombre(String empleadoTemporalNombre) {
        this.empleadoTemporalNombre = empleadoTemporalNombre;
    }
    
    public Boolean getVerDatosactivacionTemporal() {
        return this.verDatosactivacionTemporal;
    }
    
    public void setVerDatosactivacionTemporal(Boolean verDatosactivacionTemporal) {
        this.verDatosactivacionTemporal = verDatosactivacionTemporal;
    }
    
    public String getUsuarioRed() {
        return this.usuarioRed;
    }
    
    public void setUsuarioRed(String usuarioRed) {
        this.usuarioRed = usuarioRed;
    }
    
    public List<DtoAreaDetalleSIGED> getListaAreasSIGED() {
        return this.listaAreasSIGED;
    }
    
    public void setListaAreasSIGED(List<DtoAreaDetalleSIGED> listaAreasSIGED) {
        this.listaAreasSIGED = listaAreasSIGED;
    }
    
    public List<DtoCargoDetalleSIGED> getListaCargosSIGED() {
        return this.listaCargosSIGED;
    }
    
    public void setListaCargosSIGED(List<DtoCargoDetalleSIGED> listaCargosSIGED) {
        this.listaCargosSIGED = listaCargosSIGED;
    }
    
    public String getCargoUsuarioSeleccionado() {
        return this.cargoUsuarioSeleccionado;
    }
    
    public void setCargoUsuarioSeleccionado(String cargoUsuarioSeleccionado) {
        this.cargoUsuarioSeleccionado = cargoUsuarioSeleccionado;
    }
    
    public String getEstadoEmpleado() {
        return this.estadoEmpleado;
    }
    
    public void setEstadoEmpleado(String estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }
    
    public DtoTablaNuevaBandeja getNuevaBandeja() {
        return this.nuevaBandeja;
    }
    
    public void setNuevaBandeja(DtoTablaNuevaBandeja nuevaBandeja) {
        this.nuevaBandeja = nuevaBandeja;
    }
    
    public DtoEmpleadoSIGED getEmpleadoNuevaBandeja() {
        return this.empleadoNuevaBandeja;
    }
    
    public void setEmpleadoNuevaBandeja(DtoEmpleadoSIGED empleadoNuevaBandeja) {
        this.empleadoNuevaBandeja = empleadoNuevaBandeja;
    }
    
    public List<DtoPerfilSIGED> getListaPerfilesSIGED() {
        return this.listaPerfilesSIGED;
    }
    
    public void setListaPerfilesSIGED(List<DtoPerfilSIGED> listaPerfilesSIGED) {
        this.listaPerfilesSIGED = listaPerfilesSIGED;
    }
    
    public Boolean getMostarEtiquetaCesado() {
        return this.mostarEtiquetaCesado;
    }
    
    public void setMostarEtiquetaCesado(Boolean mostarEtiquetaCesado) {
        this.mostarEtiquetaCesado = mostarEtiquetaCesado;
    }
    
    public Boolean getPuedeEditarPermisosSIGED() {
        return this.puedeEditarPermisosSIGED;
    }
    
    public void setPuedeEditarPermisosSIGED(Boolean puedeEditarPermisosSIGED) {
        this.puedeEditarPermisosSIGED = puedeEditarPermisosSIGED;
    }
    
    public Boolean getVerFechas() {
        return this.verFechas;
    }
    
    public void setVerFechas(Boolean verFechas) {
        this.verFechas = verFechas;
    }
    
    public String getFlgAllEmpleado() {
        return this.flgAllEmpleado;
    }
    
    public void setFlgAllEmpleado(String flgAllEmpleado) {
        this.flgAllEmpleado = flgAllEmpleado;
    }
    
    public String getInfoLicenciaVacaciones() {
        return this.infoLicenciaVacaciones;
    }
    
    public void setInfoLicenciaVacaciones(String infoLicenciaVacaciones) {
        this.infoLicenciaVacaciones = infoLicenciaVacaciones;
    }
    
    public Boolean getVerAsignacionRolJefe() {
        return this.verAsignacionRolJefe;
    }
    
    public void setVerAsignacionRolJefe(Boolean verAsignacionRolJefe) {
        this.verAsignacionRolJefe = verAsignacionRolJefe;
    }
    
    public Boolean getVerAsignacionRolAsistente() {
        return this.verAsignacionRolAsistente;
    }
    
    public void setVerAsignacionRolAsistente(Boolean verAsignacionRolAsistente) {
        this.verAsignacionRolAsistente = verAsignacionRolAsistente;
    }
    
    public DtoEmpleadoSIGED getEmpleadoAsistenteArea() {
        return this.empleadoAsistenteArea;
    }
    
    public void setEmpleadoAsistenteArea(DtoEmpleadoSIGED empleadoAsistenteArea) {
        this.empleadoAsistenteArea = empleadoAsistenteArea;
    }
    
    public DtoEmpleadoSIGED getEmpleadoJefeArea() {
        return this.empleadoJefeArea;
    }
    
    public void setEmpleadoJefeArea(DtoEmpleadoSIGED empleadoJefeArea) {
        this.empleadoJefeArea = empleadoJefeArea;
    }
    
    public BigDecimal getEmpleadoSeleccion() {
        return this.empleadoSeleccion;
    }
    
    public void setEmpleadoSeleccion(BigDecimal empleadoSeleccion) {
        this.empleadoSeleccion = empleadoSeleccion;
    }
    
    public BigDecimal getEmpleadoSeleccionPerm() {
        return this.empleadoSeleccionPerm;
    }
    
    public void setEmpleadoSeleccionPerm(BigDecimal empleadoSeleccionPerm) {
        this.empleadoSeleccionPerm = empleadoSeleccionPerm;
    }
    
    public BigDecimal getIdCargoSiged() {
        return this.idCargoSiged;
    }
    
    public void setIdCargoSiged(BigDecimal idCargoSiged) {
        this.idCargoSiged = idCargoSiged;
    }
    
    public List<DtoBandejaSIGED> getCargosSiged() {
        return this.cargosSiged;
    }
    
    public void setCargosSiged(List<DtoBandejaSIGED> cargosSiged) {
        this.cargosSiged = cargosSiged;
    }
    
    public BigDecimal getIdCargoSiged2() {
        return this.idCargoSiged2;
    }
    
    public void setIdCargoSiged2(BigDecimal idCargoSiged2) {
        this.idCargoSiged2 = idCargoSiged2;
    }
    
    public BigDecimal getIdAreaSigedaux() {
        return this.idAreaSigedaux;
    }
    
    public void setIdAreaSigedaux(BigDecimal idAreaSigedaux) {
        this.idAreaSigedaux = idAreaSigedaux;
    }
    
    public BigDecimal getIdCargoSigedaux() {
        return this.idCargoSigedaux;
    }
    
    public void setIdCargoSigedaux(BigDecimal idCargoSigedaux) {
        this.idCargoSigedaux = idCargoSigedaux;
    }
    
    public String getCargoaaSel() {
        return this.cargoaaSel;
    }
    
    public void setCargoaaSel(String cargoaaSel) {
        this.cargoaaSel = cargoaaSel;
    }
    
    public String getCargoaaPermSel() {
        return this.cargoaaPermSel;
    }
    
    public void setCargoaaPermSel(String cargoaaPermSel) {
        this.cargoaaPermSel = cargoaaPermSel;
    }
}
