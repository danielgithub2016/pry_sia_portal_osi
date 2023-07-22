package net.royal.asistencia.vista.controladora;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.ListDataModel;
import javax.servlet.ServletContext;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.primefaces.event.SelectEvent;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.royal.alfresco.ws.ContenidoECMBean;
import net.royal.asistencia.vista.filtros.FwAsAutorizacionPreprocesoAprobacion;
import net.royal.asistencia.vista.opciones.OwAsAutorizacionPreprocesoAprobacion;
import net.royal.asistencia.vista.paginacion.PDwAsAutorizacionPreprocesoHextra;
import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CBindingController;
import net.royal.comun.vista.controladora.CComunSession;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAutorizacionPreprocesoHextra;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDddwAsConceptoaccesoSelectPre;
import net.royal.erp.asistencia.asoracle.dominio.dto.DtoDwAsEmpleadoSelectMultiple;
import net.royal.erp.asistencia.constante.ConstanteAsistencia;
import net.royal.erp.asistencia.dominio.AsAccesosdiarios;
import net.royal.erp.asistencia.dominio.AsArea;
import net.royal.erp.asistencia.dominio.AsAutorizacion;
import net.royal.erp.asistencia.dominio.AsAutorizacionPk;
import net.royal.erp.asistencia.dominio.AsCarnetidentificacion;
import net.royal.erp.asistencia.dominio.AsConceptoacceso;
import net.royal.erp.asistencia.dominio.AsConceptoaccesoPk;
import net.royal.erp.asistencia.dominio.AsDetallesiged;
import net.royal.erp.asistencia.dominio.AsDetallesigedPk;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcion;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcionPk;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepciondetalle;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepciondetallePk;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcionsolicitud;
import net.royal.erp.asistencia.dominio.dto.DtoAreaDetalleSIGED;
import net.royal.erp.asistencia.dominio.dto.DtoAreaSIGED;
import net.royal.erp.asistencia.dominio.dto.DtoAsPeriodo;
import net.royal.erp.asistencia.dominio.dto.DtoAsTipodiamovimiento;
import net.royal.erp.asistencia.dominio.dto.DtoBandejaSIGED;
import net.royal.erp.asistencia.dominio.dto.DtoEmpleadoSIGED;
import net.royal.erp.asistencia.dominio.dto.DtoFiltrosGenericos;
import net.royal.erp.asistencia.dominio.dto.DtoPerfilSIGED;
import net.royal.erp.asistencia.dominio.dto.DtoPermisosEnCompensacion;
import net.royal.erp.asistencia.dominio.dto.DtoRespuestaSIGED;
import net.royal.erp.asistencia.dominio.dto.DtoTablaNuevaBandeja;
import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.contabilidad.dominio.AcSucursal;
import net.royal.erp.core.dominio.Companiamast;
import net.royal.erp.core.dominio.CompaniamastPk;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.EmpleadomastPk;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.core.dominio.Personamast;
import net.royal.erp.planilla.dominio.PrProcesoperiodo;
import net.royal.erp.planilla.dominio.PrTipoplanilla;
import net.royal.erp.planilla.dominio.PrVacacionesprogramadas;
import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.framework.correo.constante.ConstanteCorreo.tipo_destino;
import net.royal.framework.correo.dominio.CorreoCore;
import net.royal.framework.correo.dominio.CorreoDestinoCore;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.core.UString;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.framework.web.dominio.SeguridadOperaciones;
import net.royal.seguridad.constante.ConstanteSeguridad;
import net.royal.seguridad.dominio.Seguridadperfilusuario;
import pe.gob.oefa.ws.alfresco.service.UOefaAlfresco;

@ManagedBean
@SessionScoped
public class CwAsAutorizacionPreprocesoAprobacionSIGED extends CBaseBean implements UIMantenimientoController {

	private Boolean visibleNuevo;
	private Boolean visibleModificar;
	private Boolean visibleEliminar;
	private Boolean visibleImprimir;
	private FwAsAutorizacionPreprocesoAprobacion dwFiltros;
	private List<DtoDwAsAutorizacionPreprocesoHextra> dw_2;
	private List<DtoDwAsAutorizacionPreprocesoHextra> dtExportar;
	private ListDataModel<DtoDwAsAutorizacionPreprocesoHextra> lstAutorizacionPreProcesoAprobacion;
	private DtoDwAsAutorizacionPreprocesoHextra registroSeleccionado;
	private List<DtoFiltrosGenericos> registroSeleccionadoExterno;
	private DtoFiltrosGenericos datosgenerico;
	private Boolean verSeleccionados;
	private OwAsAutorizacionPreprocesoAprobacion opciones;
	private List<DtoDddwAsConceptoaccesoSelectPre> dw_conceptoacceso;
	private List<DtoDddwAsConceptoaccesoSelectPre> dw_conceptoaccesofiltro;
	private String nombreArchivoPDF;

	private static final long serialVersionUID = 1L;
	private String tipo;
	private String tablatitulo;

	private BigDecimal totalconcepto;

	private Integer w_sel;
	private String w_concepto;

	private Integer iv_empleado;
	private Date iv_Fecha;
	private Date iv_Desde;
	private String iv_ConceptoAcceso;

	private Integer indicerechazo;
	private Integer indicerecuperacion;

	private String motivoRechazo;
	private String empleadoNombre;
	private Integer secuencia;
	private Integer secuencia2;

	private BigDecimal secuenciaseleccion;
	private String valorseleccion;

	private String flagOrigenSolicitud;

	private Boolean ismostrarDatosResponsable;
	private Boolean isaprobador;

	// variable que sirve para validar la aprobacion o rechazo de papeletas
	// propias.
	// Se compara en la lista con cada codigo de empleado y si es igual no puede
	// aprobar o rechazar.
	private Integer empleado;
	private Boolean isadmin;
	private Boolean isperfilas09;
	private String flgperfilas09;

	private List<PrProcesoperiodo> lstPeriodosPlanilla;
	private Date fechaRecuperacionIni;
	private Date fechaRecuperacionFin;
	private String periodoDescontar;
	private String rutaDocumento;
	private String uuidAlfresco;

	private String key;
	private String ws;
	private int diasLicPer;

	private DtoEmpleadoSIGED empleadoNuevaBandeja;
	private List<DtoPerfilSIGED> listaPerfilesSIGED;
	private List<DtoAreaDetalleSIGED> listaAreasSIGED;
	private DtoEmpleadoSIGED empleadoAsistenteArea;
	private DtoEmpleadoSIGED empleadoJefeArea;
	private String empleadoAsistenteSeleccion;
	private String usuarioRed;
	private Integer sid;

	private DtoTablaNuevaBandeja nuevaBandeja;

	@Override
	public String iniciarControladora() throws Exception {

		nuevaBandeja = new DtoTablaNuevaBandeja();
		isadmin = false;
		isperfilas09 = false;
		flgperfilas09 = "";
		empleado = getUsuarioActual().getIdPersona();

		LOGGER.debug("Estamos en en inciarControladora");

		// Si es administrador puede aprobar sus propias papeletas
		if (getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm("AS",
				this.getUsuarioActual().getCodigoUsuario().toUpperCase())) {
			LOGGER.debug("Paso 1");
			isadmin = true;
			empleado = 0;
		}

		List<Seguridadperfilusuario> perfiles = getFacSeguridad().getSeguridadperfilusuarioServicio()
				.listarPerfilActivoXUsuario(getUsuarioActual().getCodigoUsuario());
		if (!UValidador.esListaVacia(perfiles)) {
			for (Seguridadperfilusuario per : perfiles) {
				if (UConstante.CONSTANTE_PERFIL_APROB_RESOLUCION_0044.equalsIgnoreCase(per.getPk().getPerfil())) {
					isperfilas09 = true;
					flgperfilas09 = "S";
				}
			}
		}

		LOGGER.debug("Paso 3");
		ismostrarDatosResponsable = false;

		indicerechazo = 0;
		indicerecuperacion = 0;

		verSeleccionados = true;
		datosgenerico = new DtoFiltrosGenericos();
		datosgenerico.setIsvarioscompania(false);
		datosgenerico.setIsvarioscentrocosto(false);
		datosgenerico.setIsvariosareaoperativa(false);
		datosgenerico.setIsvariospuesto(false);
		datosgenerico.setIsvariossucursal(false);
		datosgenerico.setIsvariostipoplanilla(false);

		opciones = new OwAsAutorizacionPreprocesoAprobacion();

		LOGGER.debug("Paso 4");
		inicializarFiltrosListado();
		LOGGER.debug("Paso 5");
		buscar();
		LOGGER.debug("Paso 6");
		getWebControlContext().actualizar("frmAutorizacionesSIGED");
		LOGGER.debug("Paso 7");
		opciones = new OwAsAutorizacionPreprocesoAprobacion();
		opciones.setIshabilitarnuevo(true);
		opciones.setIshabilitarmodificar(true);
		opciones.setIshabilitareliminar(true);
		LOGGER.debug("Paso 8");

		if (flagOrigenSolicitud.equals("A") && !isadmin) {
			LOGGER.debug("Paso 9");
			// obtenemos las seguridad por opciones
			SeguridadOperaciones seguridad = leerSeguridadOperaciones(getUsuarioActual().getAplicacionCodigo(),
					"GRUP02", "CON004", getUsuarioActual().getLoginUsuario().toUpperCase());
			opciones.setIshabilitarnuevo(seguridad.getIspuedeagregar());
			opciones.setIshabilitarmodificar(seguridad.getIspuedemodificar());
			opciones.setIshabilitareliminar(seguridad.getIspuedeeliminar());
		}

		LOGGER.debug("Paso 10:wasautorizacionpreprocesoaprobacionSIGED");

		return "wasautorizacionpreprocesoaprobacionSIGED";
	}

	/*
	 * En este metodo, se calcula el total de la columna concepto de la tabla
	 * dw_2
	 */
	public void calcularTotalConcepto() {

		totalconcepto = BigDecimal.valueOf(0.0);
		Integer diaspasados1 = 0;
		Integer diferenciahoras1 = 0;
		Integer diaspasados2 = 0;
		Double diferenciahoras2 = 0.0;
		Integer diferenciaminutos = 0;

		if (!UValidador.esListaVacia(dw_2)) {
			for (DtoDwAsAutorizacionPreprocesoHextra obj : dw_2) {
				diaspasados1 = UFechaHora.obtenerDiasTranscurridos(obj.getFechafin(), obj.getFecha()) + 1;

				LOGGER.debug("diaspasados1 " + diaspasados1);

				diferenciahoras1 = UValidador.esNulo(obj.getHasta1()) ? 0
						: UFechaHora.obtenerFechaParte(obj.getHasta1(), "HH")
								- UFechaHora.obtenerFechaParte(obj.getDesde1(), "HH");

				LOGGER.debug("diferenciahoras1 " + diferenciahoras1);

				diaspasados2 = UFechaHora.obtenerDiasTranscurridos(obj.getFechafin(), obj.getFecha()) + 1;

				LOGGER.debug("diaspasados2 " + diaspasados2);

				diferenciaminutos = UValidador.esNulo(obj.getHasta1()) ? 0
						: UFechaHora.obtenerFechaParte(obj.getHasta1(), "MI")
								- UFechaHora.obtenerFechaParte(obj.getDesde1(), "MI");

				LOGGER.debug("diferenciaminutos " + diferenciaminutos);

				diferenciahoras2 = 1.0 / 60 * 100 * diferenciaminutos;

				LOGGER.debug("diferenciahoras2 " + diferenciahoras2);

				totalconcepto = totalconcepto
						.add(BigDecimal
								.valueOf(diaspasados1 * diferenciahoras1 + (diaspasados2 * diferenciahoras2) / 100))
						.setScale(2, RoundingMode.HALF_DOWN);

				LOGGER.debug("totalconcepto " + totalconcepto);
			}
		}

	}

	/*
	 * En este metodo, se instanciara la iniciarControladora() de la
	 * controladora CUFiltros y el nombre del value de la pagina
	 * w_as_autorizacion_preproceso_aprobacion.xhtml. Esta ya ha sido enviado
	 * desde un target en la variable tipo
	 */

	public void MostrarEmpleados() throws Exception {
		CwAsEmpleadoSelectMultiple.getInstance().iniciarControladora();

	}

	public String listarPopGenericos() throws Exception {
		LOGGER.debug("Entrando a listarPopGenericos");
		CUFiltros.getInstance().setTipo(tipo);
		return CUFiltros.getInstance().iniciarControladora();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String buscar() throws Exception {

		visibleNuevo = true;
		visibleEliminar = true;
		visibleModificar = true;
		visibleImprimir = true;

		String locacion;
		String flagfiltroperiodo = null;

		if (UValidador.esNulo(dwFiltros)) {
			dwFiltros = new FwAsAutorizacionPreprocesoAprobacion();
		}
		if (UValidador.esNulo(dwFiltros.getIsperiodo())) {
			dwFiltros.setIsperiodo(true);
		}

		flagfiltroperiodo = dwFiltros.getIsperiodo() ? "S" : "F";

		LOGGER.debug("periodo " + dwFiltros.getPeriodo());

		if (flagfiltroperiodo.equals("S")) {
			List data = getFacAsistencia().getAsPeriodoServicio().obtenerRangoFechas(dwFiltros.getPeriodo());
			if (!UValidador.esListaVacia(data)) {
				dwFiltros.setFechadesde(
						UFechaHora.obtenerFechaHoraInicioDia(((DtoAsPeriodo) data.get(0)).getFechadesde()));
				dwFiltros
						.setFechaHasta(UFechaHora.obtenerFechaHoraFinDia(((DtoAsPeriodo) data.get(0)).getFechahasta()));
			}
		}

		if (dwFiltros.getAlllocation().equals("N")) {
			locacion = dwFiltros.getLocation();
		} else {
			locacion = "S";
		}

		if (UValidador.esNulo(opciones.getIsallconcepto())) {
			opciones.setIsallconcepto(false);
		}

		HashMap<String, Object> parametros = new HashMap<String, Object>();

		DtoFiltrosGenericos filtroPrep = obtenerFiltroPreparado(datosgenerico);

		if (!UValidador.estaVacio(filtroPrep.getCodCompania())) {
			parametros.put("p_compania", filtroPrep.getCodCompania());
		}

		if (!UValidador.estaVacio(filtroPrep.getCodPlantilla())) { // tipoplanilla
			parametros.put("p_planilla", filtroPrep.getCodPlantilla());
		}

		if (!UValidador.estaVacio(filtroPrep.getCodCentroCosto())) {
			parametros.put("p_centrocosto", filtroPrep.getCodCentroCosto());
		}

		if (!UValidador.estaVacio(filtroPrep.getCodInactivos())) {
			parametros.put("p_division", filtroPrep.getCodInactivos());
		}

		if (!UValidador.estaVacio(filtroPrep.getCodCategoria())) {
			parametros.put("p_categoria", filtroPrep.getCodCategoria());
		}

		if (!UValidador.estaVacio(filtroPrep.getCodPuesto())) {
			parametros.put("p_cargo", filtroPrep.getCodPuesto());
		}

		if (!UValidador.estaVacio(filtroPrep.getCodSucursal())) {
			parametros.put("p_oficina", filtroPrep.getCodSucursal());
		}

		if (!UValidador.estaVacio(filtroPrep.getCodAreaOperativa())) {
			parametros.put("p_area", filtroPrep.getCodAreaOperativa());
		}

		if (!UValidador.estaVacio(datosgenerico.getCodEmpleado())) {
			parametros.put("p_empleado", datosgenerico.getCodEmpleado());
		}

		if (!UValidador.estaVacio(datosgenerico.getConceptoacceso())) {
			parametros.put("p_concepto", datosgenerico.getConceptoacceso());
		}

		if ("A".equals(flagOrigenSolicitud)) {
			parametros.put("p_usuario", getUsuarioActual().getCodigoUsuario());
		}

		getFacAsistencia().getAS().getAsmainFuncion()
				.FAsGeneraEmpleadosAutorizados(getUsuarioActual().getUniqueIdInteger(),
						getUsuarioActual().getLoginUsuario().toUpperCase(), getUsuarioActual().getIdPersona(),
						getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
								getUsuarioActual().getAplicacionCodigo(),
								getUsuarioActual().getLoginUsuario().toUpperCase()));

		sid = getUsuarioActual().getUniqueIdInteger();

		if (dwFiltros.getFechas().equals(3)) { // TODOS
			flagfiltroperiodo = "N";// para que omita las fechas
		}

		LOGGER.debug("locacion " + locacion);
		LOGGER.debug("desde " + dwFiltros.getFechadesde());
		LOGGER.debug("hasta " + dwFiltros.getFechaHasta());
		LOGGER.debug("flagfiltroperiodo " + flagfiltroperiodo);
		LOGGER.debug("sid " + sid);
		LOGGER.debug("isadmin " + isadmin);

		List data = getFacAsistencia().getAS().getAsmainDatawindow().DwAsAutorizacionPreprocesoHextraSIGED(
				flagOrigenSolicitud.equals("A") ? "S" : "N", getUsuarioActual().getIdPersona(), isadmin ? "S" : "N",
				locacion, dwFiltros.getFechadesde(), dwFiltros.getFechaHasta(), flagfiltroperiodo, sid, parametros);

		if (!UValidador.esListaVacia(data)) {
			dw_2 = data;
			registroSeleccionado = dw_2.get(0);

			// filtramos por cesados o inactivo
			if (!dwFiltros.getIscesados() || !dwFiltros.getIsinactivos()) {
				Boolean elimino;
				for (int i = 0; i < dw_2.size(); i++) {
					elimino = false;
					DtoDwAsAutorizacionPreprocesoHextra obj = dw_2.get(i);
					if (!dwFiltros.getIscesados()) {
						if (obj.getEstadoempleado().equals("2")) {
							if (!elimino) {
								dw_2.remove(i);
								elimino = true;
							}
						}
					}
					if (!dwFiltros.getIsinactivos()) {
						if (obj.getEstadoai().equals("I")) {
							if (!elimino) {
								dw_2.remove(i);
								elimino = true;
							}
						}
					}

					// estado
					if (!(dwFiltros.getEstado().equals("T"))) {
						if (!(obj.getEstado().equals(dwFiltros.getEstado()))) {
							if (!elimino) {
								dw_2.remove(i);
								elimino = true;
							}
						}
					}

					if (elimino) {
						i--;
					}
				}
			} else {
				Boolean elimino;
				for (int i = 0; i < dw_2.size(); i++) {
					elimino = false;
					DtoDwAsAutorizacionPreprocesoHextra obj = dw_2.get(i);
					// estado
					if (!(dwFiltros.getEstado().equals("T"))) {
						if (!(obj.getEstado().equals(dwFiltros.getEstado()))) {
							if (!elimino) {
								dw_2.remove(i);
								elimino = true;
							}
						}
					}

					if (elimino) {
						i--;
					}
				}
			}

		} else {
			visibleEliminar = false;
			visibleModificar = false;
			visibleImprimir = false;
			dw_2 = new ArrayList<>();
		}

		lstAutorizacionPreProcesoAprobacion = new PDwAsAutorizacionPreprocesoHextra(dw_2);

		LOGGER.debug("dw_2 " + dw_2);

		// calcularTotalConcepto();

		getWebControlContext().actualizar("frmAutorizacionesSIGED:tblAutorizaciones");
		getWebControlContext().actualizar("frmAutorizacionesSIGED:grdBotones");

		return null;
	}

	private DtoFiltrosGenericos obtenerFiltroPreparado(DtoFiltrosGenericos datosgenerico) {
		// TODO Auto-generated method stub

		DtoFiltrosGenericos obj = new DtoFiltrosGenericos();
		obj.setCodCompania("");
		obj.setCodCentroCosto("");
		obj.setCodSucursal("");
		obj.setCodPlantilla("");
		obj.setCodAreaOperativa("");
		obj.setCodPuesto("");

		// COMPAÑIA
		if (!UValidador.estaVacio(datosgenerico.getCodCompania())) {
			String[] codigos = datosgenerico.getCodCompania().split(",");
			if (!UValidador.esNulo(codigos)) {
				for (int i = 0; i < codigos.length; i++) {
					obj.setCodCompania(obj.getCodCompania() + "'" + codigos[i] + "',");
				}
				obj.setCodCompania(obj.getCodCompania().substring(0, obj.getCodCompania().length() - 1));
			} else {
				obj.setCodCompania("'" + datosgenerico.getCodCompania() + "'");
			}
		}

		// CENTRO COSTO
		if (!UValidador.estaVacio(datosgenerico.getCodCentroCosto())) {
			String[] codigos = datosgenerico.getCodCentroCosto().split(",");
			if (!UValidador.esNulo(codigos)) {
				for (int i = 0; i < codigos.length; i++) {
					obj.setCodCentroCosto(obj.getCodCentroCosto() + "'" + codigos[i] + "',");
				}
				obj.setCodCentroCosto(obj.getCodCentroCosto().substring(0, obj.getCodCentroCosto().length() - 1));
			} else {
				obj.setCodCentroCosto("'" + datosgenerico.getCodCentroCosto() + "'");
			}
		}

		// SUCURSAL
		if (!UValidador.estaVacio(datosgenerico.getCodSucursal())) {
			String[] codigos = datosgenerico.getCodSucursal().split(",");
			if (!UValidador.esNulo(codigos)) {
				for (int i = 0; i < codigos.length; i++) {
					obj.setCodSucursal(obj.getCodSucursal() + "'" + codigos[i] + "',");
				}
				obj.setCodSucursal(obj.getCodSucursal().substring(0, obj.getCodSucursal().length() - 1));
			} else {
				obj.setCodSucursal("'" + datosgenerico.getCodSucursal() + "'");
			}
		}

		// TIPO PLANILLA
		if (!UValidador.estaVacio(datosgenerico.getCodPlantilla())) {
			String[] codigos = datosgenerico.getCodPlantilla().split(",");
			if (!UValidador.esNulo(codigos)) {
				for (int i = 0; i < codigos.length; i++) {
					obj.setCodPlantilla(obj.getCodPlantilla() + "'" + codigos[i] + "',");
				}
				obj.setCodPlantilla(obj.getCodPlantilla().substring(0, obj.getCodPlantilla().length() - 1));
			} else {
				obj.setCodPlantilla("'" + datosgenerico.getCodPlantilla() + "'");
			}
		}

		// AREA OPERATIVA
		if (!UValidador.estaVacio(datosgenerico.getCodAreaOperativa())) {
			String[] codigos = datosgenerico.getCodAreaOperativa().split(",");
			if (!UValidador.esNulo(codigos)) {
				for (int i = 0; i < codigos.length; i++) {
					obj.setCodAreaOperativa(obj.getCodAreaOperativa() + "'" + codigos[i] + "',");
				}
				obj.setCodAreaOperativa(obj.getCodAreaOperativa().substring(0, obj.getCodAreaOperativa().length() - 1));
			} else {
				obj.setCodAreaOperativa("'" + datosgenerico.getCodAreaOperativa() + "'");
			}
		}

		// PUESTO
		if (!UValidador.estaVacio(datosgenerico.getCodPuesto())) {
			String[] codigos = datosgenerico.getCodPuesto().split(",");
			if (!UValidador.esNulo(codigos)) {
				for (int i = 0; i < codigos.length; i++) {
					obj.setCodPuesto(obj.getCodPuesto() + "'" + codigos[i] + "',");
				}
				obj.setCodPuesto(obj.getCodPuesto().substring(0, obj.getCodPuesto().length() - 1));
			} else {
				obj.setCodPuesto("'" + datosgenerico.getCodPuesto() + "'");
			}
		}

		return obj;
	}

	public String filtrarPorResolucion() {
		registroSeleccionado = null;
		if (!UValidador.estaVacio(dwFiltros.getNroresolucion())) {
			for (DtoDwAsAutorizacionPreprocesoHextra obj : dw_2) {
				if (!UValidador.estaVacio(obj.getNroresolucion())) {
					if (obj.getNroresolucion().contains(dwFiltros.getNroresolucion())) {
						registroSeleccionado = obj;
						break;
					}
				}
			}
		}

		return null;
	}

	@Override
	public String nuevo() throws Exception {
		// TODO Auto-generated method stub
		CComunSession.getInstance().getSyroyal().StrGlobal().setGv_coming_from("Add");
		edicionAutorizacion();
		return "w_as_autorizacion_preproceso_hextra_edit_siged";
	}

	/*
	 * wf_open_window();
	 */
	@SuppressWarnings("rawtypes")
	private String edicionAutorizacion() throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, "edicionAutorizacion");

		param.put("autorizacion", registroSeleccionado);
		if (CComunSession.getInstance().getSyroyal().StrGlobal().getGv_coming_from().equals("Add")) {
			param.put("autorizacion", null);
		}

		if (CComunSession.syroyal().StrGlobal().getGv_coming_from().equals("Update")
				|| CComunSession.syroyal().StrGlobal().getGv_coming_from().equals("Delete")) {
		}

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);
		CwAsAutorizacionPreprocesoHextraEditSIGED.getInstance().mensaje(mensajeGenerico);

		return null;
	}

	public String imprimirAutorizacion() throws Exception {

		if (UValidador.esNulo(registroSeleccionado)) {
			setMessageError("Debe seleccionar un registro");
			return null;
		}

		if (UValidador.esNulo(registroSeleccionado.getEmpleado())) {
			setMessageError("Debe seleccionar un registro");
			return null;
		}

		String pathPrincipal;
		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
				.getRealPath("/");

		Map<String, Object> parametrosReport = new HashMap<String, Object>();

		parametrosReport.put("p_empleado", registroSeleccionado.getEmpleado().intValue());
		parametrosReport.put("p_conceptoacceso", registroSeleccionado.getConceptoacceso());
		parametrosReport.put("p_fecha", registroSeleccionado.getFecha());
		parametrosReport.put("p_desde", registroSeleccionado.getDesde1());

		File archivo = new File(pathPrincipal + File.separator + "comun" + File.separator + "recursos" + File.separator
				+ File.separator + "reportes" + File.separator + File.separator + "reporteAutorizacion.jasper");

		nombreArchivoPDF = getFacAsistencia().getAsAutorizacionServicio().ejecutarReporteIReport(archivo.getPath(),
				parametrosReport);

		CBindingController.getInstance().setNombreArchivoTemporal(nombreArchivoPDF);

		return "pantallaReporteVistaExterna";
	}

	public String buscarExportar() throws Exception {

		String locacion;
		String flagfiltroperiodo = null;

		if (UValidador.esNulo(dwFiltros)) {
			dwFiltros = new FwAsAutorizacionPreprocesoAprobacion();
		}
		if (UValidador.esNulo(dwFiltros.getIsperiodo())) {
			dwFiltros.setIsperiodo(true);
		}

		flagfiltroperiodo = dwFiltros.getIsperiodo() ? "S" : "F";

		LOGGER.debug("periodo " + dwFiltros.getPeriodo());

		if (flagfiltroperiodo.equals("S")) {
			List data = getFacAsistencia().getAsPeriodoServicio().obtenerRangoFechas(dwFiltros.getPeriodo());
			if (!UValidador.esListaVacia(data)) {
				dwFiltros.setFechadesde(
						UFechaHora.obtenerFechaHoraInicioDia(((DtoAsPeriodo) data.get(0)).getFechadesde()));
				dwFiltros
						.setFechaHasta(UFechaHora.obtenerFechaHoraFinDia(((DtoAsPeriodo) data.get(0)).getFechahasta()));
			}
		}

		if (dwFiltros.getAlllocation().equals("N")) {
			locacion = dwFiltros.getLocation();
		} else {
			locacion = "S";
		}

		if (UValidador.esNulo(opciones.getIsallconcepto())) {
			opciones.setIsallconcepto(false);
		}

		HashMap<String, Object> parametros = new HashMap<String, Object>();

		DtoFiltrosGenericos filtroPrep = obtenerFiltroPreparado(datosgenerico);

		if (!UValidador.estaVacio(filtroPrep.getCodCompania())) {
			parametros.put("p_compania", filtroPrep.getCodCompania());
		}

		if (!UValidador.estaVacio(filtroPrep.getCodPlantilla())) { // tipoplanilla
			parametros.put("p_planilla", filtroPrep.getCodPlantilla());
		}

		if (!UValidador.estaVacio(filtroPrep.getCodCentroCosto())) {
			parametros.put("p_centrocosto", filtroPrep.getCodCentroCosto());
		}

		if (!UValidador.estaVacio(filtroPrep.getCodInactivos())) {
			parametros.put("p_division", filtroPrep.getCodInactivos());
		}

		if (!UValidador.estaVacio(filtroPrep.getCodCategoria())) {
			parametros.put("p_categoria", filtroPrep.getCodCategoria());
		}

		if (!UValidador.estaVacio(filtroPrep.getCodPuesto())) {
			parametros.put("p_cargo", filtroPrep.getCodPuesto());
		}

		if (!UValidador.estaVacio(filtroPrep.getCodSucursal())) {
			parametros.put("p_oficina", filtroPrep.getCodSucursal());
		}

		if (!UValidador.estaVacio(filtroPrep.getCodAreaOperativa())) {
			parametros.put("p_area", filtroPrep.getCodAreaOperativa());
		}

		if (!UValidador.estaVacio(datosgenerico.getCodEmpleado())) {
			parametros.put("p_empleado", datosgenerico.getCodEmpleado());
		}

		if (!UValidador.estaVacio(datosgenerico.getConceptoacceso())) {
			parametros.put("p_concepto", datosgenerico.getConceptoacceso());
		}

		if ("A".equals(flagOrigenSolicitud)) {
			parametros.put("p_usuario", getUsuarioActual().getCodigoUsuario());
		}

		if (dwFiltros.getFechas().equals(3)) { // TODOS
			flagfiltroperiodo = "N";// para que omita las fechas
		}

		List data = getFacAsistencia().getAS().getAsmainDatawindow().DwAsAutorizacionPreprocesoHextraSIGED(
				flagOrigenSolicitud.equals("A") ? "S" : "N", getUsuarioActual().getIdPersona(), isadmin ? "S" : "N",
				locacion, dwFiltros.getFechadesde(), dwFiltros.getFechaHasta(), flagfiltroperiodo, sid, parametros);

		if (!UValidador.esListaVacia(data)) {
			dtExportar = data;

			// filtramos por cesados o inactivo
			if (!dwFiltros.getIscesados() || !dwFiltros.getIsinactivos()) {
				Boolean elimino;
				for (int i = 0; i < dtExportar.size(); i++) {
					elimino = false;
					DtoDwAsAutorizacionPreprocesoHextra obj = dtExportar.get(i);
					if (!dwFiltros.getIscesados()) {
						if (obj.getEstadoempleado().equals("2")) {
							if (!elimino) {
								dtExportar.remove(i);
								elimino = true;
							}
						}
					}
					if (!dwFiltros.getIsinactivos()) {
						if (obj.getEstadoai().equals("I")) {
							if (!elimino) {
								dtExportar.remove(i);
								elimino = true;
							}
						}
					}

					// estado
					if (!(dwFiltros.getEstado().equals("T"))) {
						if (!(obj.getEstado().equals(dwFiltros.getEstado()))) {
							if (!elimino) {
								dtExportar.remove(i);
								elimino = true;
							}
						}
					}

					if (elimino) {
						i--;
					}
				}
			}

		} else {
			dtExportar = new ArrayList<>();
		}

		return null;
	}

	public String exportar() throws Exception {

		buscarExportar();

		if (UValidador.esListaVacia(dtExportar)) {
			setMessageError("No se encontraron datos para exportar");
			return null;
		}

		String filename = UAplicacion.getRealPath() + File.separator + "temporaloefa" + File.separator
				+ UFile.archivoUnico() + "_Solicitudes.xls";

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("FirstSheet");

		HSSFRow rowhead = sheet.createRow((short) 0);
		rowhead.createCell(0).setCellValue("N°");
		rowhead.createCell(1).setCellValue("Nombre");
		rowhead.createCell(2).setCellValue("Concepto");
		rowhead.createCell(3).setCellValue("Inicio");
		rowhead.createCell(4).setCellValue("Fin");
		rowhead.createCell(5).setCellValue("Desde");
		rowhead.createCell(6).setCellValue("Hasta");
		rowhead.createCell(7).setCellValue("Solicitado por");
		rowhead.createCell(8).setCellValue("Fecha solicitud");
		rowhead.createCell(9).setCellValue("Autorizado por");
		rowhead.createCell(10).setCellValue("Fecha autorización");
		rowhead.createCell(11).setCellValue("Estado");
		rowhead.createCell(12).setCellValue("Comentario");

		int i = 1;
		for (DtoDwAsAutorizacionPreprocesoHextra obj : dtExportar) {
			HSSFRow row = sheet.createRow((short) i);
			sheet.autoSizeColumn(i);
			row.createCell(0).setCellValue(i);
			row.createCell(1).setCellValue(obj.getNombrecompleto());
			row.createCell(2).setCellValue(obj.getConceptoaccesonombre());
			row.createCell(3).setCellValue(UFechaHora.convertirFechaCadena(obj.getFecha(), "dd/MM/yyyy"));
			row.createCell(4).setCellValue(UFechaHora.convertirFechaCadena(obj.getFechafin(), "dd/MM/yyyy"));
			row.createCell(5).setCellValue(UFechaHora.obtenerFechaParte(obj.getDesde1(), "HH") + ":"
					+ UFechaHora.obtenerFechaParte(obj.getDesde1(), "MI"));
			row.createCell(6).setCellValue(UFechaHora.obtenerFechaParte(obj.getHasta1(), "HH") + ":"
					+ UFechaHora.obtenerFechaParte(obj.getHasta1(), "MI"));
			row.createCell(7).setCellValue(obj.getSolicitadoPor());
			row.createCell(8).setCellValue(UFechaHora.convertirFechaCadena(obj.getFechaSolicitud(), "dd/MM/yyyy"));
			row.createCell(9).setCellValue(obj.getAutorizadoPor());
			row.createCell(10).setCellValue(obj.getFechaAutorizado() == null ? ""
					: UFechaHora.convertirFechaCadena(obj.getFechaAutorizado(), "dd/MM/yyyy"));
			row.createCell(11)
					.setCellValue(obj.getEstado().equals(ConstanteAsistencia.ESTADO_APROBADO)
							? ConstanteAsistencia.ESTADO_APROBADO_NOMBRE
							: obj.getEstado().equals(ConstanteAsistencia.ESTADO_RECHAZADO)
									? ConstanteAsistencia.ESTADO_RECHAZADO_NOMBRE
									: obj.getEstado().equals(ConstanteAsistencia.ESTADO_SOLICITADO)
											? ConstanteAsistencia.ESTADO_SOLICITADO_NOMBRE : "");
			row.createCell(12).setCellValue(
					!UValidador.estaVacio(obj.getMotivorechazo()) ? obj.getMotivorechazo() : obj.getObservacion());
			i = i + 1;
		}

		FileOutputStream fileOut = new FileOutputStream(filename);
		workbook.write(fileOut);
		fileOut.close();

		byte[] bytes = Files.readAllBytes(Paths.get(filename));

		UFile.descargarArchivo(bytes, "Solicitudes.xls");

		return null;
	}

	public void limpieza() {

		switch (tipo) {
		case "compania":
			datosgenerico.setCodCompania(" ");
			datosgenerico.setDesCompania(" ");
			datosgenerico.setIsvarioscompania(false);
			break;
		case "costos":
			datosgenerico.setCodCentroCosto(" ");
			datosgenerico.setDesCentroCosto(" ");
			datosgenerico.setIsvarioscentrocosto(false);
			break;
		case "sucursal":
			datosgenerico.setCodSucursal(" ");
			datosgenerico.setDesSucursal(" ");
			datosgenerico.setIsvariossucursal(false);
			break;
		case "categoria":
			datosgenerico.setCodCategoria(" ");
			datosgenerico.setDesCategoria(" ");
			break;
		case "planilla":
			datosgenerico.setCodPlantilla(" ");
			datosgenerico.setDesPlantilla(" ");
			datosgenerico.setIsvariostipoplanilla(false);
			break;
		case "operaria":
			datosgenerico.setCodAreaOperativa(" ");
			datosgenerico.setDesAreaOperativa(" ");
			datosgenerico.setIsvariosareaoperativa(false);
			break;
		case "inactivos":
			datosgenerico.setCodInactivos(" ");
			datosgenerico.setDesInactivos(" ");
			break;
		case "puestos":
			datosgenerico.setCodPuesto(" ");
			datosgenerico.setDesPuesto(" ");
			datosgenerico.setIsvariospuesto(false);
			break;
		default:
			break;
		}

	}

	@Override
	public String editar() throws Exception {
		// TODO Auto-generated method stub
		if ("OMI2".equals(registroSeleccionado.getConceptoacceso())) {
			CComunSession.getInstance().getSyroyal().StrGlobal().setGv_coming_from("Browse");
		} else {
			CComunSession.getInstance().getSyroyal().StrGlobal().setGv_coming_from("Update");
			if (UValidador.esNulo(registroSeleccionado)) {
				setMessageError("Debe seleccionar un registro");
				return null;
			}

			// Validamos que no sea una prerogramación
			if (registroSeleccionado.getFlagreprogramado().equals("S")) {
				setMessageError("No puede modificar una solicitud de Reprogramación de Vacaciones");
				return null;
			}

			if (registroSeleccionado.getEstado().equals("S")
					&& registroSeleccionado.getFlagAprobadoJefe().equals("S")) {
				setMessageError("No puede modificar por que la solicitud ha sido aprobada en Nivel 1.");
				return null;
			}
		}

		edicionAutorizacion();
		return "w_as_autorizacion_preproceso_hextra_edit_siged";
	}

	@Override
	public String ver() throws Exception {
		// TODO Auto-generated method stub
		CComunSession.getInstance().getSyroyal().StrGlobal().setGv_coming_from("Browse");
		if (UValidador.esNulo(registroSeleccionado)) {
			setMessageError("Debe seleccionar un registro");
			return null;
		}

		edicionAutorizacion();

		return null;
	}

	@Override
	public String eliminar() throws Exception {
		// TODO Auto-generated method stub
		if (registroSeleccionado.getEstado().equals("A") || registroSeleccionado.getEstado().equals("P")) {
				setMessageError("No puede eliminar en estado Aprobado.");
				return null;
		}

		if (registroSeleccionado.getFlagAprobadoJefe().equals("S")) {
			setMessageError("No puede eliminar por que la solicitud ha sido aprobada en Nivel 1.");
			return null;
		}

		CComunSession.getInstance().getSyroyal().StrGlobal().setGv_coming_from("Delete");
		if (UValidador.esNulo(registroSeleccionado)) {
			setMessageError("Debe seleccionar un registro");
			return null;
		}

		// Validamos que no sea una prerogramación
		if (registroSeleccionado.getFlagreprogramado().equals("S") && registroSeleccionado.getEstado().equals("S")) {
			setMessageError("No puede eliminar una solicitud de Reprogramación de Vacaciones");
			return null;
		}

		edicionAutorizacion();
		return "w_as_autorizacion_preproceso_hextra_edit_siged";
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
	 * wf_proceso_aprobacion()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String guardar() throws Exception {
		// TODO Auto-generated method stub

		w_sel = dw_2.size();
		indicerecuperacion = 0;

		if (UValidador.esCero(w_sel)) {
			setMessageError("Seleccionar autorización para Aprobar o Rechazar");
			return null;
		}

		w_sel = 0;
		for (DtoDwAsAutorizacionPreprocesoHextra obj : lstAutorizacionPreProcesoAprobacion) {
			if (obj.getIsseleccionaprobado() || obj.getIsseleccionrechazado()) {
				w_sel += 1;
			}
		}

		if (UValidador.esCero(w_sel)) {
			setMessageError("Seleccionar autorización para Aprobar o Rechazar");
			return null;
		}

		// cargamos el concepto acceso
		dw_conceptoacceso = getFacAsistencia().getAS().getAsmastDatawindow().DddwAsConceptoaccesoSelectPreSiged("S",
				getUsuarioActual().getLoginUsuario().toUpperCase());

		// validamos que no se rechacen conceptos aprobados
		int n = 1;
		for (DtoDwAsAutorizacionPreprocesoHextra obj : lstAutorizacionPreProcesoAprobacion) {
			w_concepto = obj.getConceptoacceso();
			if (obj.getIsseleccionrechazado()) {
				// buscamos en la lista de coneptos
				for (int i = 0; i < dw_conceptoacceso.size(); i++) {
					DtoDddwAsConceptoaccesoSelectPre objcon = dw_conceptoacceso.get(i);
					if (objcon.getConceptoacceso().equals(w_concepto)) {
						if (objcon.getFlagnorechazaaprobado().equals("S") && obj.getEstado().equals("A")) {
							setMessageError(
									"El Concepto para esta solicitud no puede ser rechazado cuando está en estado Aprobado ");
							return null;
						}

					}
				}
			}

			if (obj.getIsseleccionaprobado()) {
				// REQ 3: Validar el máximo de días para la aprobación
				// de la papeleta
				// buscamos en la lista de coneptos
				if (!getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
						getUsuarioActual().getAplicacionCodigo(), getUsuarioActual().getCodigoUsuario())) {
					DtoDddwAsConceptoaccesoSelectPre objcon = null;
					for (int i = 0; i < dw_conceptoacceso.size(); i++) {
						objcon = dw_conceptoacceso.get(i);
						if (objcon.getConceptoacceso().equals(w_concepto)) {
							if (objcon.getFlagtienetopediasap().equals("S")) {
								// le restamos 1 día ya que no se debe tomar en
								// cuenta el día en que registro la papeleta.
								Integer w_count = getFacAsistencia().getAS().getAsmainFuncion()
										.FDiasHabiles(obj.getUltimafechaModif(), new Date()) - 1;
								if (w_count > objcon.getCantidadtopediasap().intValue()) {
									setMessageError("Línea " + n + ". El máximo para aprobar la papeleta es de "
											+ objcon.getCantidadtopediasap()
											+ " día(s) hábil(es) para la aprobación del concepto de "
											+ objcon.getDescripcionlocal());
									return null;
								}
							}
						}

					}

					if (!UValidador.esNulo(objcon)) {

						if ("S".equals(objcon.getFlagnumerosrestriccion())
								&& UValidador.esNulo(objcon.getFechainiciorestriccion())) {

							BigDecimal horas = objcon.getNumerohorasmesesrestriccion();

							BigDecimal horasConRes = getFacAsistencia().getAsAutorizacionServicio().sumarConRes(
									obj.getEmpleado().intValue(), obj.getConceptoacceso(), obj.getFecha(),
									obj.getFechafin(), obj.getFecha(), obj.getFechafin());

							BigDecimal w_diftiempo = wf_diftiempo(obj.getDesde1(), obj.getHasta1())
									.divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_DOWN);
							// no tomar en cuenta el refrigerio
							w_diftiempo = w_diftiempo.subtract(obtenerHorasRefrigerio(obj.getEmpleado().intValue(),
									obj.getFecha(), obj.getFechafin(), obj.getDesde1(), obj.getHasta1()));

							if ((horasConRes.add(w_diftiempo)).compareTo(horas) == 1) {
								setMessageError("Se está superando la cantidad máximas de horas permitidas (" + horas
										+ ") en el periodo: " + UFechaHora.convertirFechaCadena(obj.getFecha(), "MM")
										+ "-" + UFechaHora.convertirFechaCadena(obj.getFecha(), "yyyy"));
								return null;
							}
						}
					}

				}

			}

			// El concepto 34 solo puede ser aprobado por el perfil
			// AS06
			if (obj.getIsseleccionaprobado() || obj.getIsseleccionrechazado()) {

				AsConceptoacceso objconAux = (AsConceptoacceso) getFacAsistencia().getAsConceptoaccesoServicio()
						.obtenerPorId(new AsConceptoaccesoPk(w_concepto));

				// if
				// (UConstante.CONSTANTE_CONCEPTO_RESOLUCION_0044.equals(w_concepto))
				// {
				// if (!isperfilas09) {
				// Usuario objUsu = (Usuario)
				// getFacSeguridad().getUsuarioServicio()
				// .obtenerPorId(new
				// UsuarioPk(UConstante.CONSTANTE_PERFIL_APROB_RESOLUCION_0044));
				// setMessageError("Línea " + n + ". Para procesar las
				// solicitudes por concepto de "
				// + objconAux.getDescripcionlocal() + " debe tener asigando el
				// perfil "
				// + objUsu.getNombre());
				// retperfilesurn null;
				// }
				// } else {
				// Si el concepto requiere aprobación de URH se debería
				// poder aprobar en los niveles anteriores
				if (!getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
						getUsuarioActual().getAplicacionCodigo(), getUsuarioActual().getCodigoUsuario())) {
					if (!"S".equals(objconAux.getFlagAprobacionURH()) || "S".equals(obj.getFlagAprobadoJefe())) {
						Integer puedeAprobar = getFacAsistencia().getAS().getAsmainDatawindow()
								.contarPuedeAprobarConcepto(getUsuarioActual().getCodigoUsuario(), w_concepto,
										isadmin ? "S" : "N");

						// if (UValidador.esCero(puedeAprobar)) {
						// setMessageError("Línea " + n
						// + " Ud. no tiene permisos para procesar las
						// solicitudes por concepto de "
						// + objconAux.getDescripcionlocal());
						// return null;
						// }
					}

					// si es trabajador de ODE lo aprueba jefe, sino lo aprueba
					// CGD
					if (UConstante.CONSTANTE_CONCEPTO_CONFIG_PERFILES
							.equalsIgnoreCase(objconAux.getPk().getConceptoacceso())) {
						Empleadomast empleadomast = (Empleadomast) getFacCore().getEmpleadomastServicio()
								.obtenerPorId(new EmpleadomastPk(obj.getEmpleado().intValue(), "01000000"));

						if (!UValidador.esNulo(empleadomast)) {
							// AcSucursal acSucursal = (AcSucursal)
							// getFacContabilidad().getAcSucursalServicio()
							// .obtenerPorId(new
							// AcSucursalPk(empleadomast.getSucursal()));
							if (!UValidador.esNulo(empleadomast.getSucursal())) {
								String sucursales = getFacCore().getParametrosmastServicio()
										.obtenerValorCadena(new ParametrosmastPk("HR", "999999", "SUCUDEOLIM"));
								if (!UValidador.estaVacio(sucursales)) {
									String suc[] = sucursales.split(",");
									if (suc.length > 0) {
										for (int i = 0; i < suc.length; i++) {
											if (suc[i].equals(empleadomast.getSucursal())) {
												Integer puedeAprobar = getFacAsistencia().getAS().getAsmainDatawindow()
														.contarPuedeAprobarConcepto(
																getUsuarioActual().getCodigoUsuario(), w_concepto,
																isadmin ? "S" : "N");
												if (UValidador.esCero(puedeAprobar)) {
													setMessageError("Línea " + n
															+ " Ud. no tiene permisos para procesar las solicitudes por concepto de "
															+ objconAux.getDescripcionlocal());
													return null;
												}
											}
										}
									}
								}

							}
						}
					}

				}
			}

			n++;
		}

		getWebControlContext().ejecutar("PF('popProcesarSeleccion').show()");

		return null;
	}

	public String ingresoMotivoRechazo() throws Exception {

		getWebControlContext().ejecutar("PF('popProcesarSeleccion').hide();");

		for (DtoDwAsAutorizacionPreprocesoHextra objaut : lstAutorizacionPreProcesoAprobacion) {
			if (((Integer) objaut.getSecuencia().intValue()).equals(secuencia)) {
				objaut.setMotivorechazo(motivoRechazo);
				break;
			}
			if (((Integer) objaut.getSecuencia().intValue()).equals(secuencia2)) {
				objaut.setFlgTieneRecuperacion("S");
				objaut.setDesderecupera(fechaRecuperacionIni);
				objaut.setHastarecupera(fechaRecuperacionFin);
				objaut.setPeriodoplanilla(periodoDescontar);
				break;
			}
		}

		Integer indicelocal = 0;
		Integer indicelocal2 = 0;
		Integer indicelocal3 = 0;
		// por cada registro actualizamos en motivo rechazo
		for (DtoDwAsAutorizacionPreprocesoHextra objaut : lstAutorizacionPreProcesoAprobacion) {
			if (objaut.getIsseleccionrechazado() && !objaut.getEstado().equals("R")) {
				if (indicerechazo <= indicelocal) {
					secuencia = objaut.getSecuencia().intValue();
					empleadoNombre = objaut.getNombrecompleto();
					motivoRechazo = null;
					indicerechazo = secuencia;
					getWebControlContext().actualizar("dgMotivoRechazo");
					getWebControlContext().ejecutar("PF('popMotivoRechazo').show()");
					return null;
				}
			}

			if (objaut.getIsseleccionaprobado() && objaut.getEstado().equals("S")
					&& UConstante.CONSTANTE_CONCEPTO_RESOLUCION_0044.equalsIgnoreCase(objaut.getConceptoacceso())
					&& (("S".equals(objaut.getFlagAprobadoJefe()) && "S".equals(objaut.getFlagAprobacionURH()))
							|| !"S".equals(objaut.getFlagAprobacionURH()))) {
				if (indicerecuperacion <= indicelocal2) {
					secuencia2 = objaut.getSecuencia().intValue();
					empleadoNombre = objaut.getNombrecompleto();
					fechaRecuperacionIni = null;
					fechaRecuperacionFin = null;
					periodoDescontar = null;
					indicerecuperacion = secuencia2;
					uuidAlfresco = objaut.getUuidalfresco();
					rutaDocumento = objaut.getRutadocumento();
					lstPeriodosPlanilla = getFacPlanilla().getPrProcesoperiodoServicio()
							.listarPeriodosXPlanilla(objaut.getTipoplanilla());
					diasLicPer = getFacCore().getParametrosmastServicio()
							.obtenerValorInteger(new ParametrosmastPk("AS", "999999", "MAXDIARCLI")) + 1;
					getWebControlContext().actualizar("dgRecuperacionPermiso");
					getWebControlContext().ejecutar("PF('popRecuperacionPermiso').show()");
					return null;
				}
			}

			if (objaut.getIsseleccionaprobado() && objaut.getEstado().equals("S")
					&& UConstante.CONSTANTE_CONCEPTO_CONFIG_PERFILES.equalsIgnoreCase(objaut.getConceptoacceso())) {

				if (!UValidador.esListaVacia(listaPerfilesSIGED)) {
					Boolean puedePasar = false;
					for (DtoPerfilSIGED perfiles : listaPerfilesSIGED) {
						if (perfiles.getPerfilSeleccionado() && !perfiles.getPerfilSeleccionadoLectura()) {
							puedePasar = true;
							break;
						}
					}

					if (!puedePasar) {
						setMessageError("Debe Seleccionar al menos un Perfil");
						return null;
					}
				}

				if (indicerecuperacion <= indicelocal3) {
					secuencia2 = objaut.getSecuencia().intValue();
					indicerecuperacion = secuencia2;
					empleadoNombre = objaut.getNombrecompleto();
					Empleadomast empleado = this.getFacCore().getEmpleadomastServicio()
							.obtenerEmpleadoMast(objaut.getEmpleado().intValue());
					usuarioRed = empleado.getCodigousuario();

					obtenerBandejas();
					listaPerfilesSIGED = obtenerPerfilesSIGED();

					AsDetallesigedPk pk = new AsDetallesigedPk();
					pk.setConceptoacceso(objaut.getConceptoacceso());
					pk.setEmpleado(objaut.getEmpleado());
					pk.setFechadesde(objaut.getFecha());
					pk.setFechahasta(objaut.getFecha());

					List<AsDetallesiged> detalleRegistrado = this.getFacAsistencia().getAsDetallesigedServicio()
							.listaDetalleSiged(pk);

					for (AsDetallesiged detalleguardado : detalleRegistrado) {
						for (DtoPerfilSIGED perfiles : listaPerfilesSIGED) {
							if (detalleguardado.getIdperfil().intValue() == perfiles.getIdPerfil()) {
								perfiles.setPerfilSeleccionado(true);
								perfiles.setSecuencia(detalleguardado.getPk().getSecuencia());
							}
						}
					}

					getWebControlContext().actualizar("dgConfiguracionPerfiles");
					getWebControlContext().ejecutar("PF('popConfiguracionPerfiles').show()");
					return null;
				}

			}

			if (objaut.getIsseleccionaprobado() && objaut.getEstado().equals("S")
					&& UConstante.CONSTANTE_CONCEPTO_ASIG_ROL_JEFE.equalsIgnoreCase(objaut.getConceptoacceso())) {

				if (indicerecuperacion <= indicelocal3) {
					secuencia2 = objaut.getSecuencia().intValue();
					indicerecuperacion = secuencia2;
					empleadoNombre = objaut.getNombrecompleto();
					Empleadomast empleado = this.getFacCore().getEmpleadomastServicio()
							.obtenerEmpleadoMast(objaut.getEmpleado().intValue());
					usuarioRed = empleado.getCodigousuario();

					obtenerBandejas();
					obtenerAreasSIGED();

					AsDetallesigedPk pk = new AsDetallesigedPk();
					pk.setConceptoacceso(objaut.getConceptoacceso());
					pk.setEmpleado(objaut.getEmpleado());
					pk.setFechadesde(objaut.getFecha());
					pk.setFechahasta(objaut.getFechafin());

					List<AsDetallesiged> detalleRegistrado = this.getFacAsistencia().getAsDetallesigedServicio()
							.listaDetalleSiged(pk);

					if (!UValidador.esListaVacia(detalleRegistrado)) {
						AsDetallesiged asDetallesiged = detalleRegistrado.get(0);
						if (!UValidador.estaVacio(asDetallesiged.getFlgjefe())) {
							this.empleadoNuevaBandeja.setBljefe(asDetallesiged.getFlgjefe().equals("S") ? true : false);

						}
						if (!UValidador.estaVacio(asDetallesiged.getFlgasistente())) {
							this.empleadoNuevaBandeja
									.setBlasistente(asDetallesiged.getFlgasistente().equals("S") ? true : false);

						}

						DtoAreaDetalleSIGED dtoAreaDetalleSIGED = obtenerAreaSIGED(
								asDetallesiged.getIdarea().intValue());
						empleadoJefeArea = new DtoEmpleadoSIGED();
						empleadoAsistenteArea = new DtoEmpleadoSIGED();
						nuevaBandeja.setIdAreaSIGED(new BigDecimal(dtoAreaDetalleSIGED.getIdArea()));

						if (!UValidador.esNulo(dtoAreaDetalleSIGED)) {
							if (!UValidador.esNulo(dtoAreaDetalleSIGED.getIdPersonaJa())) {
								empleadoJefeArea = obtenerDetallePorEmpleadoSIGED(dtoAreaDetalleSIGED.getIdPersonaJa());
							}
							if (!UValidador.esNulo(dtoAreaDetalleSIGED.getIdPersonaAa())) {
								empleadoAsistenteArea = obtenerDetallePorEmpleadoSIGED(
										dtoAreaDetalleSIGED.getIdPersonaAa());
							}
						}
					}

					getWebControlContext().actualizar("dgAsignacionRolJefe");
					getWebControlContext().ejecutar("PF('popAsignacionRolJefe').show()");
					return null;
				} else {
					if (!empleadoNuevaBandeja.getBljefe() && !empleadoNuevaBandeja.getBlasistente()) {
						setMessageError("Debe Seleccionar al menos un rol");
						return null;
					}
				}

			}

			if (objaut.getIsseleccionaprobado() && objaut.getEstado().equals("S")
					&& UConstante.CONSTANTE_CONCEPTO_ASIG_ROL_ASISTENTE.equalsIgnoreCase(objaut.getConceptoacceso())) {

				if (indicerecuperacion <= indicelocal3) {
					secuencia2 = objaut.getSecuencia().intValue();
					indicerecuperacion = secuencia2;
					empleadoNombre = objaut.getNombrecompleto();

					AsDetallesigedPk pk = new AsDetallesigedPk();
					pk.setConceptoacceso(objaut.getConceptoacceso());
					pk.setEmpleado(objaut.getEmpleado());
					pk.setFechadesde(objaut.getFecha());
					pk.setFechahasta(objaut.getFechafin());

					List<AsDetallesiged> detalleRegistrado = this.getFacAsistencia().getAsDetallesigedServicio()
							.listaDetalleSiged(pk);

					if (!UValidador.esListaVacia(detalleRegistrado)) {
						AsDetallesiged asDetallesiged = detalleRegistrado.get(0);
						obtenerAreasSIGED();

						empleadoAsistenteArea = new DtoEmpleadoSIGED();
						empleadoAsistenteArea = obtenerDetallePorEmpleadoSIGED(
								obtenerAreaSIGED(asDetallesiged.getIdarea().intValue()).getIdPersonaAa());

						empleadoAsistenteSeleccion = this.getFacCore().getPersonamastServicio()
								.obtenerNombrePersona(asDetallesiged.getIdempleadosia());

						nuevaBandeja.setIdAreaSIGED(asDetallesiged.getIdarea());

					}

					getWebControlContext().actualizar("dgAsignacionRolAsistente");
					getWebControlContext().ejecutar("PF('popAsignacionRolAsistente').show()");
					return null;
				}

			}

			indicelocal++;
			indicelocal2++;
			indicelocal3++;
		}

		LOGGER.debug("termino....");
		empleadoNombre = null;
		motivoRechazo = null;

		indicerechazo = 0;
		indicerecuperacion = 0;

		procesoAprobacion();

		getWebControlContext().ejecutar("PF('popRecuperacionPermiso').hide()");
		getWebControlContext().ejecutar("PF('popRecuperacionPermisoCuponeras').hide()");
		getWebControlContext().ejecutar("PF('popProcesarSeleccion').hide()");
		getWebControlContext().ejecutar("PF('popMotivoRechazo').hide()");
		getWebControlContext().ejecutar("PF('popProcesarSeleccion').hide()");
		getWebControlContext().ejecutar("PF('popConfiguracionPerfiles').hide()");
		getWebControlContext().ejecutar("PF('popAsignacionRolJefe').hide()");
		getWebControlContext().ejecutar("PF('popAsignacionRolAsistente').hide()");
		return null;
	}

	private DtoEmpleadoSIGED obtenerDetallePorEmpleadoSIGED(Integer idPersona)
			throws JsonParseException, JsonMappingException, IOException {

		String token = obtenerToken();
		DtoEmpleadoSIGED empleadoSeleccionado = new DtoEmpleadoSIGED();

		// request url
		String url = UAplicacion.getServletContext().getInitParameter(UConstante.URL_OBTENER_DETALLE) + idPersona;

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
				empleadoSeleccionado = null;
			} else {
				System.out.println("Request Successful.");
				empleadoSeleccionado = new ObjectMapper().readValue(response.getBody(), DtoEmpleadoSIGED.class);
			}
		} else {
			System.out.println("Request Failed");
			System.out.println(response.getStatusCode());
		}

		return empleadoSeleccionado;
	}

	public DtoAreaDetalleSIGED obtenerAreaSIGED(Integer idArea) {
		DtoAreaDetalleSIGED retorno = null;
		if (!UValidador.esListaVacia(listaAreasSIGED)) {
			for (DtoAreaDetalleSIGED obj : listaAreasSIGED) {
				if (obj.getIdArea().toString().equals(idArea.toString())) {
					retorno = obj;
					break;
				}
			}
		}
		return retorno;
	}

	private void obtenerAreasSIGED() throws JsonParseException, JsonMappingException, IOException {
		listaAreasSIGED = new ArrayList<>();

		listaAreasSIGED.addAll(obtenerAreas());
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
			for (DtoPerfilSIGED perfilActual : empleadoNuevaBandeja.getPerfiles()) {
				for (DtoPerfilSIGED perfiles : perfilesSIGED) {
					perfiles.setPerfilSeleccionadoLectura(false);
					perfiles.setPerfilSeleccionado(false);
					if (perfilActual.getIdPerfil() == perfiles.getIdPerfil()) {
						perfiles.setPerfilSeleccionado(true);
						perfiles.setPerfilSeleccionadoLectura(true);
					}
				}
			}
		}

		return perfilesSIGED;
	}

	private String gestionarPersonaSIGED(String idBandeja, String pwd)
			throws JsonParseException, JsonMappingException, IOException {

		DtoRespuestaSIGED retornoArea = new DtoRespuestaSIGED();

		RestTemplate restTemplate = new RestTemplate();

		String token = obtenerToken();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", token);

		HttpEntity request = new HttpEntity(headers);

		Map<String, Object> map = new HashMap<>();
		map.put("idPersona", idBandeja);
		map.put("clave", pwd);

		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

		String url = UAplicacion.getServletContext().getInitParameter(UConstante.URL_GESTIONAR_PERSONA_ACTUALIZAR);

		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

		// check response
		if (response.getStatusCode() == HttpStatus.OK) {

			if (UValidador.esNulo(response.getBody())) {
				setMessageError("Hubo un error al invocar el servicio: Gestionar usuario Siged");
				return null;
			}

			retornoArea = new ObjectMapper().readValue(response.getBody(), DtoRespuestaSIGED.class);

			if (!"1".equals(retornoArea.getEstado())) {
				setMessageError("Hubo un error en la respuesta del servicio: Gestionar usuario Siged");
				return null;
			}

			System.out.println("Request Successful.");

		} else {
			System.out.println("Request Failed");
			System.out.println(response.getStatusCode());
		}

		return null;
	}

	private String gestionarUsuarioSIGED(String idBandeja, String estado)
			throws JsonParseException, JsonMappingException, IOException {

		DtoRespuestaSIGED retornoArea = new DtoRespuestaSIGED();

		RestTemplate restTemplate = new RestTemplate();

		String token = obtenerToken();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", token);

		HttpEntity request = new HttpEntity(headers);

		Map<String, Object> map = new HashMap<>();
		map.put("idBandeja", idBandeja);
		map.put("estado", estado);

		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

		String url = UAplicacion.getServletContext().getInitParameter(UConstante.URL_GESTIONAR_USUARIO);

		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

		// check response
		if (response.getStatusCode() == HttpStatus.OK) {

			if (UValidador.esNulo(response.getBody())) {
				setMessageError("Hubo un error al invocar el servicio: Gestionar usuario Siged");
				return null;
			}

			retornoArea = new ObjectMapper().readValue(response.getBody(), DtoRespuestaSIGED.class);

			if (!"1".equals(retornoArea.getEstado())) {
				setMessageError("Hubo un error en la respuesta del servicio: Gestionar usuario Siged");
				return null;
			}

			System.out.println("Request Successful.");

		} else {
			System.out.println("Request Failed");
			System.out.println(response.getStatusCode());
		}

		return null;
	}

	private String gestionarUsuarioPerfilSIGED(String idPersona, String idPerfil, String estado)
			throws JsonParseException, JsonMappingException, IOException {

		DtoRespuestaSIGED retornoArea = new DtoRespuestaSIGED();

		RestTemplate restTemplate = new RestTemplate();

		String token = obtenerToken();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", token);

		HttpEntity request = new HttpEntity(headers);

		Map<String, Object> map = new HashMap<>();
		map.put("idPersona", idPersona);
		map.put("idPerfil", idPerfil);
		map.put("estado", estado);

		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

		String url = UAplicacion.getServletContext().getInitParameter(UConstante.URL_GESTIONAR_USUARIO_PERFIL);

		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

		// check response
		if (response.getStatusCode() == HttpStatus.OK) {

			if (UValidador.esNulo(response.getBody())) {
				setMessageError("Hubo un error al invocar el servicio: Gestionar perfil Siged");
				return null;
			}

			retornoArea = new ObjectMapper().readValue(response.getBody(), DtoRespuestaSIGED.class);

			if (!"1".equals(retornoArea.getEstado())) {
				setMessageError("Hubo un error en la respuesta del servicio: Gestionar perfil Siged");
				return null;
			}

			System.out.println("Request Successful.");

		} else {
			System.out.println("Request Failed");
			System.out.println(response.getStatusCode());
		}

		return null;
	}

	private String gestionarBandejaSIGED(String idBandeja, String estado)
			throws JsonParseException, JsonMappingException, IOException {

		DtoRespuestaSIGED retornoArea = new DtoRespuestaSIGED();

		RestTemplate restTemplate = new RestTemplate();

		String token = obtenerToken();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", token);

		HttpEntity request = new HttpEntity(headers);

		Map<String, Object> map = new HashMap<>();
		map.put("idBandeja", idBandeja);
		map.put("estado", estado);

		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

		String url = UAplicacion.getServletContext().getInitParameter(UConstante.URL_GESTIONAR_BANDEJA);

		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

		// check response
		if (response.getStatusCode() == HttpStatus.OK) {

			if (UValidador.esNulo(response.getBody())) {
				setMessageError("Hubo un error al invocar el servicio: Gestionar bandejas Siged");
				return null;
			}

			retornoArea = new ObjectMapper().readValue(response.getBody(), DtoRespuestaSIGED.class);

			if (!"1".equals(retornoArea.getEstado())) {
				setMessageError("Hubo un error en la respuesta del servicio: Gestionar bandejas Siged");
				return null;
			}

			System.out.println("Request Successful.");

		} else {
			System.out.println("Request Failed");
			System.out.println(response.getStatusCode());
		}

		return null;
	}

	private List<DtoAreaDetalleSIGED> obtenerAreas() throws JsonParseException, JsonMappingException, IOException {
		RestTemplate restTemplate = new RestTemplate();

		DtoAreaSIGED retornoArea = new DtoAreaSIGED();

		String token = obtenerToken();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", token);

		HttpEntity request = new HttpEntity(headers);

		Map<String, Object> map = new HashMap<>();
		map.put("nombre", null);
		map.put("idArea", null);

		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

		String url = UAplicacion.getServletContext().getInitParameter(UConstante.URL_OBTENER_AREAS);

		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

		// check response
		if (response.getStatusCode() == HttpStatus.OK) {

			if (UValidador.esNulo(response.getBody())) {
				setMessageError("No se ha encontrado Areas para el usuario " + usuarioRed + " en el Servicio SIGED");
				return null;
			}

			System.out.println("Request Successful.");
			retornoArea = new ObjectMapper().readValue(response.getBody(), DtoAreaSIGED.class);

		} else {
			System.out.println("Request Failed");
			System.out.println(response.getStatusCode());
		}

		if (!UValidador.esNulo(retornoArea)) {
			return retornoArea.getAreas();
		}

		return null;
	}

	private String obtenerToken() throws JsonParseException, JsonMappingException, IOException {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		String username = UAplicacion.getServletContext().getInitParameter(UConstante.USUARIO_TOKEN);
		String clave = UAplicacion.getServletContext().getInitParameter(UConstante.CLAVE_TOKEN);

		Map<String, Object> map = new HashMap<>();
		map.put("username", username);
		map.put("password", clave);

		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

		String url = UAplicacion.getServletContext().getInitParameter(UConstante.URL_OBTENER_TOKEN);

		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

		JsonNode retorno = new ObjectMapper().readTree(response.getBody());
		String token = retorno.get("token").asText();

		return token;
	}

	private void obtenerBandejas() throws JsonParseException, JsonMappingException, IOException {

		String token = obtenerToken();

		// request url
		String url = UAplicacion.getServletContext().getInitParameter(UConstante.URL_OBTENER_BANDEJAS) + usuarioRed;

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
				setMessageError("No se ha encontrado Bandejas para el usuario " + usuarioRed + " en el Servicio SIGED");
				return;
			}

			System.out.println("Request Successful.");
			empleadoNuevaBandeja = new ObjectMapper().readValue(response.getBody(), DtoEmpleadoSIGED.class);

		} else {
			System.out.println("Request Failed");
			System.out.println(response.getStatusCode());
		}
	}

	// private DtoPermisosEnCompensacion obtenerPermisosCompensacion(Integer
	// empleado, Date finpermiso,
	// Integer diasCopensa) throws Exception {
	// // TODO Auto-generated method stub
	// Integer anio = UFechaHora.obtenerAnio();
	// DtoPermisosEnCompensacion obj = new DtoPermisosEnCompensacion();
	// List<DtoPermisosEnCompensacion> datos =
	// getFacAsistencia().getAsAutorizacionServicio()
	// .listarPermisosCompensacion(empleado, anio);
	//
	// if (!UValidador.esListaVacia(datos)) {
	// for (DtoPermisosEnCompensacion row : datos) {
	// if (wf_diftiempo(row.getDesde(), row.getHasta())
	// .subtract(obtenerHorasViernesVerano(empleado, row.getDesderecupera(),
	// row.getHastarecupera()))
	// .compareTo(row.getHorascompensadas()) == 1) {
	// obj.setDesderecupera(UFechaHora.anadirDiasAFechas(row.getHastarecupera(),
	// 1));
	// // si es menor a la fecha actual, el inicio es la fecha
	// // actual
	// if (obj.getDesderecupera().getTime() < new Date().getTime()) {
	// obj.setDesderecupera(new Date());
	// }
	// obj.setHastarecupera(UFechaHora.anadirDiasAFechas(obj.getDesderecupera(),
	// diasCopensa.intValue()));
	// } else {
	// obj.setDesderecupera(UFechaHora.anadirDiasAFechas(finpermiso, 1));
	// if (obj.getDesderecupera().getTime() < new Date().getTime()) {
	// obj.setDesderecupera(new Date());
	// }
	// obj.setHastarecupera(UFechaHora.anadirDiasAFechas(obj.getDesderecupera(),
	// diasCopensa));
	// }
	// }
	// } else {
	// obj.setDesderecupera(UFechaHora.anadirDiasAFechas(finpermiso, 1));
	// if (obj.getDesderecupera().getTime() < new Date().getTime()) {
	// obj.setDesderecupera(new Date());
	// }
	// obj.setHastarecupera(UFechaHora.anadirDiasAFechas(obj.getDesderecupera(),
	// diasCopensa));
	// }
	//
	// return obj;
	// }

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

	public String cancelarMotivoRechazo() {
		indicerechazo = 0;
		indicerecuperacion = 0;

		getWebControlContext().ejecutar("PF('popRecuperacionPermiso').hide()");
		return null;
	}

	public String cancelarMotivoRechazoCuponeras() {
		indicerechazo = 0;
		indicerecuperacion = 0;

		getWebControlContext().ejecutar("PF('popRecuperacionPermisoCuponeras').hide()");
		return null;
	}

	private void actualizarDatosSIGED(DtoDwAsAutorizacionPreprocesoHextra dw_1, String estado) {
		AsDetallesigedPk pk = new AsDetallesigedPk();
		pk.setConceptoacceso(dw_1.getConceptoacceso());
		pk.setEmpleado(dw_1.getEmpleado());
		pk.setFechadesde(dw_1.getFecha());
		pk.setFechahasta(dw_1.getFechafin());

		List<AsDetallesiged> detalleRegistrado = this.getFacAsistencia().getAsDetallesigedServicio()
				.listaDetalleSiged(pk);

		for (AsDetallesiged detalleguardado : detalleRegistrado) {
			detalleguardado.setEstado(estado);
			this.getFacAsistencia().getAsDetallesigedServicio().actualizar(detalleguardado);
		}
	}

	private void guadarActivacionTemporalSIGED(DtoDwAsAutorizacionPreprocesoHextra dw_1)
			throws JsonParseException, JsonMappingException, IOException {

		AsDetallesigedPk pk = new AsDetallesigedPk();
		pk.setConceptoacceso(dw_1.getConceptoacceso());
		pk.setEmpleado(dw_1.getEmpleado());
		pk.setFechadesde(dw_1.getFecha());
		pk.setFechahasta(dw_1.getFecha());

		List<AsDetallesiged> detalleRegistrado = this.getFacAsistencia().getAsDetallesigedServicio()
				.listaDetalleSiged(pk);

		Empleadomast empleado = this.getFacCore().getEmpleadomastServicio()
				.obtenerEmpleadoMast(dw_1.getEmpleado().intValue());
		usuarioRed = empleado.getCodigousuario();
		obtenerBandejas();

		gestionarUsuarioSIGED(empleadoNuevaBandeja.getIdPersona().toString(), "A");

		// consultmos si tiene perfil usuario final sino le registramos
		if (UValidador.esListaVacia(obtenerPerfilesSIGED())) {
			gestionarUsuarioPerfilSIGED(empleadoNuevaBandeja.getIdPersona().toString(),
					UAplicacion.getServletContext().getInitParameter(UConstante.ID_PERFIL_USUARIO_FINAL), "A");
		}

		// Integer linea = 1;
		for (AsDetallesiged bandeja : detalleRegistrado) {

			bandeja.setEstado("A");
			bandeja.setFlgestadosiged("S");
			bandeja.setUltimaFechaModif(new Date());
			bandeja.setUltimoUsuario(getUsuarioActual().getCodigoUsuario());
			bandeja.setUltimaFechaModifSiged(new Date());
			bandeja.setUltimoUsuarioSiged("SYSTEM");

			getFacAsistencia().getAsDetallesigedServicio().actualizar(bandeja);

			if (!UValidador.esListaVacia(empleadoNuevaBandeja.getBandejas())) {
				for (DtoBandejaSIGED obj : empleadoNuevaBandeja.getBandejas()) {
					if (obj.getIdArea().toString().equals(bandeja.getIdarea().toString())
							&& obj.getIdCargo().toString().equals(bandeja.getIdcargo().toString())) {
						gestionarBandejaSIGED(obj.getIdPersona().toString(), "A");
						break;
					}
				}
			}

			// linea++;
		}

		try {
			String pwd = UValidador.random(4);
			gestionarPersonaSIGED(empleadoNuevaBandeja.getIdPersona().toString(), pwd);
			enviarCorreoActivacionTemporal(dw_1, pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			setMessageError("Ocurrió un error al enviar el correo de activación temporal");
		}
	}

	private void guadarPerfilesSIGED(DtoDwAsAutorizacionPreprocesoHextra dw_1) {

		AsDetallesigedPk pk = new AsDetallesigedPk();
		pk.setConceptoacceso(dw_1.getConceptoacceso());
		pk.setEmpleado(dw_1.getEmpleado());
		pk.setFechadesde(dw_1.getFecha());
		pk.setFechahasta(dw_1.getFecha());

		List<AsDetallesiged> detalleRegistrado = this.getFacAsistencia().getAsDetallesigedServicio()
				.listaDetalleSiged(pk);

		if (!UValidador.esListaVacia(detalleRegistrado)) {
			for (AsDetallesiged asDetallesiged : detalleRegistrado) {
				this.getFacAsistencia().getAsDetallesigedServicio().eliminar(asDetallesiged);
			}
		}

		Integer linea = 1;
		for (DtoPerfilSIGED perfil : listaPerfilesSIGED) {
			if (perfil.getPerfilSeleccionado()) {
				if (!perfil.getPerfilSeleccionadoLectura()) {

					AsDetallesiged asDetallesigedModifi = new AsDetallesiged();
					asDetallesigedModifi.getPk().setConceptoacceso(dw_1.getConceptoacceso());
					asDetallesigedModifi.getPk().setEmpleado(dw_1.getEmpleado());
					asDetallesigedModifi.getPk().setFechadesde(dw_1.getFecha());
					asDetallesigedModifi.getPk().setFechahasta(dw_1.getFecha());
					asDetallesigedModifi.getPk().setSecuencia(new BigDecimal(linea));
					asDetallesigedModifi.setEstado("A");

					asDetallesigedModifi.setIdpersona(new BigDecimal(empleadoNuevaBandeja.getIdPersona()));

					asDetallesigedModifi.setIdperfil(new BigDecimal(perfil.getIdPerfil()));

					asDetallesigedModifi.setUltimaFechaModif(new Date());
					asDetallesigedModifi.setUltimoUsuario(getUsuarioActual().getCodigoUsuario());

					getFacAsistencia().getAsDetallesigedServicio().registrar(asDetallesigedModifi);

					linea++;
				}
			}
		}
	}

//	private void guadarAsignacionRolJefeSIGED(DtoDwAsAutorizacionPreprocesoHextra dw_1) {
//
//		AsDetallesigedPk pk = new AsDetallesigedPk();
//		pk.setConceptoacceso(dw_1.getConceptoacceso());
//		pk.setEmpleado(dw_1.getEmpleado());
//		pk.setFechadesde(dw_1.getFecha());
//		pk.setFechahasta(dw_1.getFechafin());
//
//		List<AsDetallesiged> detalleRegistrado = this.getFacAsistencia().getAsDetallesigedServicio()
//				.listaDetalleSiged(pk);
//
//		if (!UValidador.esListaVacia(detalleRegistrado)) {
//			for (AsDetallesiged asDetallesiged : detalleRegistrado) {
//				this.getFacAsistencia().getAsDetallesigedServicio().eliminar(asDetallesiged);
//			}
//		}
//
//		AsDetallesiged asDetallesiged = new AsDetallesiged();
//		asDetallesiged.getPk().setConceptoacceso(dw_1.getConceptoacceso());
//		asDetallesiged.getPk().setEmpleado(dw_1.getEmpleado());
//		asDetallesiged.getPk().setFechadesde(dw_1.getFecha());
//		asDetallesiged.getPk().setFechahasta(dw_1.getFechafin());
//		asDetallesiged.getPk().setSecuencia(new BigDecimal(1));
//		asDetallesiged.setEstado("S");
//		asDetallesiged.setIdcargo(nuevaBandeja.getIdCargoSIGED());
//		asDetallesiged.setIdarea(nuevaBandeja.getIdAreaSIGED());
//		asDetallesiged.setIdpersona(new BigDecimal(empleadoNuevaBandeja.getIdPersona()));
//		asDetallesiged.setFlgjefe(empleadoNuevaBandeja.getBljefe() ? "S" : null);
//		asDetallesiged.setFlgasistente(empleadoNuevaBandeja.getBlasistente() ? "S" : null);
//		asDetallesiged.setUltimaFechaModif(new Date());
//		asDetallesiged.setUltimoUsuario(getUsuarioActual().getCodigoUsuario());
//
//		getFacAsistencia().getAsDetallesigedServicio().registrar(asDetallesiged);
//
//	}

	private void guadarAsignacionRolAsistenteSIGED(DtoDwAsAutorizacionPreprocesoHextra dw_1) {

		AsDetallesiged asDetallesiged = null;
		AsDetallesigedPk pk = new AsDetallesigedPk();
		pk.setConceptoacceso(dw_1.getConceptoacceso());
		pk.setEmpleado(dw_1.getEmpleado());
		pk.setFechadesde(dw_1.getFecha());
		pk.setFechahasta(dw_1.getFechafin());

		List<AsDetallesiged> detalleRegistrado = this.getFacAsistencia().getAsDetallesigedServicio()
				.listaDetalleSiged(pk);

		if (!UValidador.esListaVacia(detalleRegistrado)) {
			asDetallesiged = detalleRegistrado.get(0);
			asDetallesiged.setEstado("S");
			asDetallesiged.setUltimaFechaModif(new Date());
			asDetallesiged.setUltimoUsuario(getUsuarioActual().getCodigoUsuario());

			getFacAsistencia().getAsDetallesigedServicio().actualizar(asDetallesiged);

		}

	}

	private void insertarAutorizacion(DtoDwAsAutorizacionPreprocesoHextra dw_1) {
		// INSERTAR AUTORIZACION
		// AsAutorizacion objins = new AsAutorizacion();
		// objins.getPk().setConceptoacceso(dw_1.getConceptoacceso());
		// objins.getPk().setDesde(w_desde1);
		// objins.getPk().setFecha(w_fecha);
		// objins.getPk().setEmpleado(BigDecimal.valueOf(w_empleado));
		// objins.setHasta(w_hasta1);
		// objins.setRefrigerio(w_refrigerio);
		// objins.setPeriodo(w_periodo);
		// objins.setMandatorio(w_mandatorio);
		// objins.setObservacion(w_observacion);
		// objins.setSolicitadopor(w_solicitadoPor);
		// objins.setFechasolicitud(w_fechaSolicitud);
		// objins.setUltimoUsuario(w_ultimousuario);
		// objins.setUltimaFechaModif(new Date());
		// objins.setSobretiempoposicion("1");
		// objins.setComportamientosobretiempo(w_comportamientoSobretiempo);
		// objins.setEstado(w_estado);
		// objins.setCategoriaautorizacion(w_categoriaAutorizacion);
		// objins.setTipohorario(BigDecimal.valueOf(w_TipoHorario));
		// objins.setFlagcorrido(w_Corrido);
		// objins.setRutadocumento(w_ruta);
		// objins.setTipoautorizacion(this.iv_tipoautorizacion);
		// objins.setNroresolucion(w_resolucion);
		// objins.setFecharesolucion(w_fecharesolucion);
		// objins.setDesderecupera(dw_1.getDesderecupera());
		// objins.setHastarecupera(dw_1.getHastarecupera());
		// objins.setPeriodoplanilla(dw_1.getPeriodoplanilla());
		// objins.setNombrearchivodj(dw_1.getNombrearchivodj());
		//
		// getFacAsistencia().getAsAutorizacionServicio().registrar(objins);

	}

	public void procesoAprobacion() throws Exception {
		Boolean w_resultado = false, w_aprobadorigualvisador;
		String w_estadosiguiente;
		String w_usuarioactual, ls_periodo, ls_periodoPago, w_estado, w_periodoA;
		String w_Aprobar, w_Rechazar, w_AprobarJefe = "", w_usuarioseleccionado;
		String w_ConceptoAcceso, w_ConceptoAcceso_ant = null, w_CategoriaAutorizacion;
		Integer w_enviosbuenos = 0, w_enviosmalos = 0, w_retorno, w_tipohorario, w_dias;
		BigDecimal w_secuencia;
		Integer w_Empleado_ant = null;
		Integer w_empleado;
		Date w_fecha, w_FechaHasta, w_Fecha_ant = null, w_Desde, w_Desde_ant = null, ldt_Fecha, ldt_Fechafin,
				w_ultimafechamodif;
		Integer ll_terminal = null;
		Integer cantjuntos;
		Boolean iserror = false;
		String mensajeaux = "";

		w_usuarioactual = getUsuarioActual().getLoginUsuario().toUpperCase();

		w_aprobadorigualvisador = true;

		cantjuntos = 0;
		Integer w_count_fuerarango = 0;
		Integer cantseleccionados = 0;
		for (DtoDwAsAutorizacionPreprocesoHextra obj : lstAutorizacionPreProcesoAprobacion) {
			w_fecha = obj.getFecha();
			w_FechaHasta = obj.getFechafin();
			w_Aprobar = obj.getIsseleccionaprobado() ? "S" : "N";
			w_Rechazar = obj.getIsseleccionrechazado() ? "S" : "N";
			w_AprobarJefe = "N";
			if (w_Aprobar.equals("S") || w_Rechazar.equals("S")) {
				cantseleccionados = cantseleccionados + 1;
				Integer cant = 0;
				if (getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
						getUsuarioActual().getAplicacionCodigo(), getUsuarioActual().getCodigoUsuario())) {
					// validamos el perodo activo
					cant = getFacAsistencia().getAsPeriodoServicio()
							.obtenerCantidadPorEmpleado(obj.getEmpleado().intValue(), w_fecha, w_FechaHasta);
				} else {
					cant = getFacAsistencia().getAsPeriodoServicio()
							.obtenerCantidadPorEmpleadoNoAdmin(obj.getEmpleado().intValue(), w_fecha, w_FechaHasta);
				}

				if (UValidador.esCero(cant)) {
					w_count_fuerarango = w_count_fuerarango + 1;
					obj.setIsseleccionaprobado(false);
					obj.setIsseleccionrechazado(false);
				}

			}
		}

		if (!UValidador.esCero(w_count_fuerarango)) {
			setMessageWarn("Existen Autorizaciones con fechas que no pertenece a un periodo activo", null);
		}

		for (DtoDwAsAutorizacionPreprocesoHextra obj : lstAutorizacionPreProcesoAprobacion) {
			w_Aprobar = obj.getIsseleccionaprobado() ? "S" : "N";
			w_Rechazar = obj.getIsseleccionrechazado() ? "S" : "N";
			w_AprobarJefe = "N";
			if (w_Aprobar.equals("N") && w_Rechazar.equals("N")) {
				continue;
			}

			// si el concepto requiere aprobación de URH
			AsConceptoaccesoPk conpk1 = new AsConceptoaccesoPk();
			conpk1.setConceptoacceso(obj.getConceptoacceso());
			AsConceptoacceso findobj = (AsConceptoacceso) getFacAsistencia().getAsConceptoaccesoServicio()
					.obtenerPorId(conpk1, false);

			if (!UValidador.esNulo(findobj)) {
				if ("S".equals(findobj.getFlagAprobacionURH()) && !"S".equals(obj.getFlagAprobadoJefe())
						&& "S".equals(w_Aprobar)) {
					w_AprobarJefe = "S";
					w_Aprobar = "N";
					w_Rechazar = "N";
				}
			}

			w_empleado = obj.getEmpleado().intValue();
			w_fecha = obj.getFecha();

			w_FechaHasta = obj.getFechafin();
			w_Desde = obj.getDesde1();

			w_ConceptoAcceso = obj.getConceptoacceso();
			w_CategoriaAutorizacion = obj.getCategoriaAutorizacion();
			w_tipohorario = obj.getTipohorario().intValue();

			if ((UValidador.esNulo(w_Empleado_ant) && UValidador.esNulo(w_Fecha_ant) && UValidador.esNulo(w_Desde_ant)
					&& UValidador.esNulo(w_ConceptoAcceso_ant))
					|| (w_empleado != w_Empleado_ant || w_fecha != w_Fecha_ant || w_Desde != w_Desde_ant
							|| w_ConceptoAcceso != w_ConceptoAcceso_ant)) {
				if (w_CategoriaAutorizacion.equals("OMIS")) {
				}

				w_usuarioseleccionado = obj.getSolicitadoPor();

				if (w_Aprobar.equals("S") || w_Rechazar.equals("S") || w_AprobarJefe.equals("S")) {
					w_estado = obj.getEstado();

					if (w_estado.equals("S")) {
						if (w_Aprobar.equals("S")) {

							if (UConstante.CONSTANTE_CONCEPTO_RESOLUCION_0044
									.equalsIgnoreCase(obj.getConceptoacceso())) {
								// Si no se grabó la recuperación no se debería
								// procesar
								if (UValidador.esNulo(obj.getDesderecupera())) {
									continue;
								}
							}

							if (UConstante.CONSTANTE_CONCEPTO_ASIG_FUNCIONES
									.equalsIgnoreCase(obj.getConceptoacceso())) {
								actualizarDatosSIGED(obj, "A");
							}

							if (UConstante.CONSTANTE_CONCEPTO_ASIG_ROLES.equalsIgnoreCase(obj.getConceptoacceso())) {
								actualizarDatosSIGED(obj, "A");
							}

							if (UConstante.CONSTANTE_CONCEPTO_NUEVA_BANDEJA.equalsIgnoreCase(obj.getConceptoacceso())) {
								actualizarDatosSIGED(obj, "A");
							}

							if (UConstante.CONSTANTE_CONCEPTO_CONFIG_PERFILES
									.equalsIgnoreCase(obj.getConceptoacceso())) {
								guadarPerfilesSIGED(obj);
							}

							if (UConstante.CONSTANTE_CONCEPTO_ACTIVACION_TEMPORAL
									.equalsIgnoreCase(obj.getConceptoacceso())) {
								// actualizarDatosSIGED(obj, "A");
								guadarActivacionTemporalSIGED(obj);
							}

//							if (UConstante.CONSTANTE_CONCEPTO_ASIG_ROL_JEFE.equalsIgnoreCase(obj.getConceptoacceso())) {
//								guadarAsignacionRolJefeSIGED(obj);
//							}

							if (UConstante.CONSTANTE_CONCEPTO_ASIG_ROL_ASISTENTE
									.equalsIgnoreCase(obj.getConceptoacceso())) {
								guadarAsignacionRolAsistenteSIGED(obj);
							}

							// validar que tenga archivo si no es administrador
							// y
							// validar los dias maximos que el jefe puede
							// aprobar la solicitud
							if (!(getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
									getUsuarioActual().getAplicacionCodigo(), getUsuarioActual().getCodigoUsuario()))) {

								// el concepto debe de requerir archivo
								AsConceptoaccesoPk conpk = new AsConceptoaccesoPk();
								conpk.setConceptoacceso(obj.getConceptoacceso());

								AsConceptoacceso find = (AsConceptoacceso) getFacAsistencia()
										.getAsConceptoaccesoServicio().obtenerPorId(conpk, false);

								if (!UValidador.esNulo(find)) {

									if (find.getFlagarchivo().equals("S") && !w_CategoriaAutorizacion.equals("ADFR")) {

										if (UValidador.estaVacio(obj.getFlagtienearchivo())) {
											cantjuntos++;
											continue;
										}
									}
								}

							}

							ll_terminal = obj.getTerminal().intValue();

							w_estadosiguiente = "A";

							// actualizamos la autorizacion
							AsAutorizacionPk pkfind = new AsAutorizacionPk();
							pkfind.setConceptoacceso(w_ConceptoAcceso);
							pkfind.setDesde(w_Desde);
							pkfind.setEmpleado(BigDecimal.valueOf(w_empleado));
							pkfind.setFecha(w_fecha);

							AsAutorizacion objupd = (AsAutorizacion) getFacAsistencia().getAsAutorizacionServicio()
									.obtenerPorId(pkfind);

							// Objeto soicitud anterior
							AsAutorizacion objdelete = new AsAutorizacion();

							if (!UValidador.esNulo(objupd)) {

								// Si es una reprogramacion se anula el
								// registro original
								if (objupd.getFlagreprogramado().equals("S")) {
									AsAutorizacionPk pkdelete = new AsAutorizacionPk();
									pkdelete.setConceptoacceso(w_ConceptoAcceso);
									pkdelete.setDesde(objupd.getDesdeanterior());
									pkdelete.setEmpleado(BigDecimal.valueOf(w_empleado));
									pkdelete.setFecha(objupd.getFechaanterior());
									objdelete = (AsAutorizacion) getFacAsistencia().getAsAutorizacionServicio()
											.obtenerPorId(pkdelete);
									if (objdelete != null) {
										objdelete.setEstado("R");
										objdelete.setRechazadopor(getUsuarioActual().getCodigoUsuario());
										objdelete.setFecharechazo(new Date());
										objdelete.setMotivorechazo("(Reprogramación de Vacaciones)");

										getFacAsistencia().getAsAutorizacionServicio().actualizar(objdelete);
									}
								}

								objupd.setEstado(w_estadosiguiente);
								objupd.setAutorizadopor(w_usuarioactual);
								objupd.setFechaautorizacion(new Date());
								if (!w_aprobadorigualvisador) {
									objupd.setVisadopor(w_usuarioactual);
									objupd.setFechavisado(new Date());
								}
								objupd.setUltimoUsuario(w_usuarioactual);
								objupd.setUltimaFechaModif(new Date());
								objupd.setFlagreprogramado("N");
								objupd.setFechaanterior(null);
								objupd.setDesdeanterior(null);
								// permiso recuperacion
								objupd.setDesderecupera(obj.getDesderecupera());
								objupd.setHastarecupera(obj.getHastarecupera());
								objupd.setPeriodoplanilla(obj.getPeriodoplanilla());

								getFacAsistencia().getAsAutorizacionServicio().actualizar(objupd);

							}

							if (w_resultado) {
								w_enviosbuenos += 1;
							} else {
								w_enviosmalos += 1;
							}

							if (w_CategoriaAutorizacion.equals("OMIS")) {
								iv_empleado = w_empleado;
								iv_Fecha = w_fecha;
								iv_Desde = w_Desde;
								iv_ConceptoAcceso = w_ConceptoAcceso;
								wf_Insertar_Marca(w_empleado, UFechaHora.obtenerFechaCompuesta(w_fecha, w_Desde), "",

										ll_terminal);
							}

							if (w_CategoriaAutorizacion.equals("CHOR")) {
								w_retorno = getFacAsistencia().getAsAutorizacionServicio().autorizarCambioHorario(
										getUsuarioActual(), w_empleado, w_fecha, w_FechaHasta, w_tipohorario);
								if (UValidador.esCero(w_retorno)) {
									return;
								}
							}

							if (w_ConceptoAcceso.equals("VACA")) {
								String w_periodo, w_anio;

								w_periodo = UFechaHora.obtenerFechaParte(w_fecha, "YY") + ""
										+ ((UFechaHora.obtenerFechaParte(w_fecha, "MM")) > 9
												? UFechaHora.obtenerFechaParte(w_fecha, "MM")
												: "0" + UFechaHora.obtenerFechaParte(w_fecha, "MM"));
								w_periodoA = obj.getPeriodo();
								w_anio = UFechaHora.obtenerFechaParte(w_fecha, "YY").toString();
								w_dias = UFechaHora.obtenerDiasTranscurridos(w_FechaHasta, w_fecha) + 1;

								w_secuencia = getFacPlanilla().getPrVacacionesprogramadasServicio()
										.obtenerMaximoVacacionesProgramadas(w_empleado, w_periodo);

								if (UValidador.esNulo(w_secuencia)) {
									w_secuencia = BigDecimal.ONE;
								}

								w_ultimafechamodif = new Date();

								// Si es una reprogramacion actualizamos el
								// registro original en sin efecto, luego
								// insertamos la nueva programacion
								if (obj.getFlagreprogramado().equals("S")) {

									if (objdelete != null) {
										List<PrVacacionesprogramadas> programadas = getFacPlanilla()
												.getPrVacacionesprogramadasServicio()
												.listarVacacionesProgramadas(objdelete.getPk().getEmpleado().intValue(),
														objdelete.getPeriodo(), objdelete.getPk().getFecha(),
														objdelete.getFechafin());

										if (!UValidador.esListaVacia(programadas)) {
											for (PrVacacionesprogramadas objpr : programadas) {
												objpr.setTipoutilizacion("S");
												objpr.setObservacionorigen("Sin efecto desde web");
												objpr.setUltimoUsuario(w_usuarioactual);
												objpr.setUltimaFechaModif(w_ultimafechamodif);
												getFacPlanilla().getPrVacacionesprogramadasServicio().actualizar(objpr);
											}
										}
									}

								}
								PrVacacionesprogramadas objins = new PrVacacionesprogramadas();
								objins.getPk().setEmpleado(BigDecimal.valueOf(w_empleado));
								objins.getPk().setNumeroperiodo(BigDecimal.valueOf(1));
								objins.getPk().setSecuencia(w_secuencia);
								objins.getPk().setEstadovacacion(BigDecimal.ZERO);
								objins.getPk().setPeriodo(w_periodo);
								objins.setDiaspago(w_dias);
								objins.setFechainicio(w_fecha);
								objins.setFechafin(w_FechaHasta);
								objins.setEstado("A");
								objins.setAnovacacion(Integer.parseInt(w_anio));
								objins.setPeriodoasistencia(w_periodoA);
								objins.setTipoutilizacion("R");
								objins.setObservacionorigen("Programado desde Web");
								objins.setUltimoUsuario(w_usuarioactual);
								objins.setUltimaFechaModif(w_ultimafechamodif);

								getFacPlanilla().getPrVacacionesprogramadasServicio().registrar(objins);

							}

							// REQUERIMIENTO
							// REGISTRAR EL CAMBIO DE HORARIO COMO UNA EXCEPCION
							// DEL EMPLEADO
							if (w_ConceptoAcceso.equals("CHOR")) {
								List<AsEmpleadoexcepcionsolicitud> horarios = getFacAsistencia()
										.getAsEmpleadoexcepcionsolicitudServicio()
										.listarEmpleadoExcepcionSolicitud(w_empleado, w_fecha);

								if (!UValidador.esListaVacia(horarios)) {

									// EN CASO SE REAPRUEBE UNA SOLICITUD
									// -ELIMINAR
									for (AsEmpleadoexcepcionsolicitud objhor : horarios) {
										AsEmpleadoexcepcionPk pkdel = new AsEmpleadoexcepcionPk();
										pkdel.setEmpleado(w_empleado);
										pkdel.setFecha(objhor.getPk().getFecha());
										pkdel.setFechahasta(objhor.getPk().getFecha());

										AsEmpleadoexcepcion objdel = (AsEmpleadoexcepcion) getFacAsistencia()
												.getAsEmpleadoexcepcionServicio().obtenerPorId(pkdel, false);

										if (!UValidador.esNulo(objdel)) {
											getFacAsistencia().getAsEmpleadoexcepcionServicio().eliminar(objdel);
										}

										AsEmpleadoexcepciondetallePk pkdetdel = new AsEmpleadoexcepciondetallePk();
										pkdetdel.setEmpleado(w_empleado);
										pkdetdel.setFecha(objhor.getPk().getFecha());
										pkdetdel.setIntervaloacceso(objhor.getIntervaloacceso());
										pkdetdel.setSecuencia(1);

										AsEmpleadoexcepciondetalle objdetdel = (AsEmpleadoexcepciondetalle) getFacAsistencia()
												.getAsEmpleadoexcepciondetalleServicio().obtenerPorId(pkdetdel, false);

										if (!UValidador.esNulo(objdetdel)) {
											getFacAsistencia().getAsEmpleadoexcepciondetalleServicio()
													.eliminar(objdetdel);
										}

									}

									for (AsEmpleadoexcepcionsolicitud objhor : horarios) {
										AsEmpleadoexcepcion objinsempex = new AsEmpleadoexcepcion();
										objinsempex.getPk().setEmpleado(w_empleado);
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
										objinsempex.setUltimoUsuario(w_usuarioactual);
										objinsempex.setUltimaFechaModif(new Date());

										getFacAsistencia().getAsEmpleadoexcepcionServicio().registrar(objinsempex);

										// REGISTRAMOS EL DETALLE

										AsEmpleadoexcepciondetalle objinsempexdet = new AsEmpleadoexcepciondetalle();
										objinsempexdet.getPk().setEmpleado(w_empleado);
										objinsempexdet.getPk().setFecha(objhor.getPk().getFecha());
										objinsempexdet.getPk().setIntervaloacceso(objhor.getIntervaloacceso());
										objinsempexdet.getPk().setSecuencia(1);
										objinsempexdet.setTipodia(objhor.getTipodia());

										getFacAsistencia().getAsEmpleadoexcepciondetalleServicio()
												.registrar(objinsempexdet);
									}
								}
							}

							if (obj.getCategoriaAutorizacion().equals("SOBR")
									&& obj.getTipoautorizacion().equals("F")) {
								iv_ConceptoAcceso = obj.getCategoriaAutorizacion();
								wf_evaluar_dia_descanso(obj.getEmpleado(), obj.getFecha(), obj.getFechafin(),
										obj.getDesde1(), obj.getHasta1(), ll_terminal, w_estadosiguiente,
										obj.getCategoriaAutorizacion());
							}

							enviarCorreo("A", obj);

						}

						if (w_Rechazar.equals("S")) {

							if (UConstante.CONSTANTE_CONCEPTO_ASIG_FUNCIONES
									.equalsIgnoreCase(obj.getConceptoacceso())) {
								actualizarDatosSIGED(obj, "R");
							}

							if (UConstante.CONSTANTE_CONCEPTO_ASIG_ROLES.equalsIgnoreCase(obj.getConceptoacceso())) {
								actualizarDatosSIGED(obj, "R");
							}

							if (UConstante.CONSTANTE_CONCEPTO_NUEVA_BANDEJA.equalsIgnoreCase(obj.getConceptoacceso())) {
								actualizarDatosSIGED(obj, "R");
							}

							if (UConstante.CONSTANTE_CONCEPTO_CONFIG_PERFILES
									.equalsIgnoreCase(obj.getConceptoacceso())) {
								actualizarDatosSIGED(obj, "R");
							}

							if (UConstante.CONSTANTE_CONCEPTO_ACTIVACION_TEMPORAL
									.equalsIgnoreCase(obj.getConceptoacceso())) {
								actualizarDatosSIGED(obj, "R");
							}

							if (!UValidador.esNulo(obj.getMotivorechazo())) {
								w_estadosiguiente = "R";

								// actualizamos la autorizacion
								AsAutorizacionPk pkfind = new AsAutorizacionPk();
								pkfind.setConceptoacceso(w_ConceptoAcceso);
								pkfind.setDesde(w_Desde);
								pkfind.setEmpleado(BigDecimal.valueOf(w_empleado));
								pkfind.setFecha(w_fecha);

								AsAutorizacion objupd = (AsAutorizacion) getFacAsistencia().getAsAutorizacionServicio()
										.obtenerPorId(pkfind, false);

								if (!UValidador.esNulo(objupd)) {
									objupd.setAutorizadopor(null);
									objupd.setFechaautorizacion(null);
									objupd.setEstado(w_estadosiguiente);
									objupd.setRechazadopor(w_usuarioactual);
									objupd.setFecharechazo(new Date());
									objupd.setMotivorechazo(obj.getMotivorechazo());
									objupd.setUltimoUsuario(w_usuarioactual);
									objupd.setUltimaFechaModif(new Date());

									getFacAsistencia().getAsAutorizacionServicio().actualizar(objupd);
								}
							}

							if (w_resultado) {
								w_enviosbuenos += 1;
							} else {
								w_enviosmalos += 1;
							}

							// si se rechaza una compensacion se debe de
							// actualizar el saldo.
							if (obj.getCategoriaAutorizacion().equals("COMP")) {
								wf_eliminar_hora_consumida(obj.getEmpleado(),
										UFechaHora.obtenerFechaCompuesta(obj.getFecha(), obj.getDesde1()));
							}

							if (obj.getConceptoacceso().equals("VACA")) {
								AsAutorizacion objdelete = new AsAutorizacion();
								AsAutorizacionPk pkdelete = new AsAutorizacionPk();
								pkdelete.setConceptoacceso(w_ConceptoAcceso);
								pkdelete.setDesde(obj.getDesdeanterior());
								pkdelete.setEmpleado(BigDecimal.valueOf(w_empleado));
								pkdelete.setFecha(obj.getFechaanterior());
								objdelete = (AsAutorizacion) getFacAsistencia().getAsAutorizacionServicio()
										.obtenerPorId(pkdelete);
								objdelete.setFlagreprogramado("N");
								getFacAsistencia().getAsAutorizacionServicio().actualizar(objdelete);
							}

							enviarCorreo("R", obj);

						}

						if (w_AprobarJefe.equals("S")) {

							// validar que tenga archivo si no es administrador
							// y
							// validar los dias maximos que el jefe puede
							// aprobar la solicitud
							if (!(getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
									getUsuarioActual().getAplicacionCodigo(), getUsuarioActual().getCodigoUsuario()))) {

								// el concepto debe de requerir archivo
								AsConceptoaccesoPk conpk = new AsConceptoaccesoPk();
								conpk.setConceptoacceso(obj.getConceptoacceso());

								AsConceptoacceso find = (AsConceptoacceso) getFacAsistencia()
										.getAsConceptoaccesoServicio().obtenerPorId(conpk, false);

								if (!UValidador.esNulo(find)) {

									if (find.getFlagarchivo().equals("S") && !w_CategoriaAutorizacion.equals("ADFR")) {

										if (UValidador.estaVacio(obj.getFlagtienearchivo())) {
											cantjuntos++;
											continue;
										}
									}
								}

							}

							ll_terminal = obj.getTerminal().intValue();

							w_estadosiguiente = "S";

							// actualizamos la autorizacion
							AsAutorizacionPk pkfind = new AsAutorizacionPk();
							pkfind.setConceptoacceso(w_ConceptoAcceso);
							pkfind.setDesde(w_Desde);
							pkfind.setEmpleado(BigDecimal.valueOf(w_empleado));
							pkfind.setFecha(w_fecha);

							AsAutorizacion objupd = (AsAutorizacion) getFacAsistencia().getAsAutorizacionServicio()
									.obtenerPorId(pkfind);

							if (!UValidador.esNulo(objupd)) {

								objupd.setEstado(w_estadosiguiente);
								objupd.setFlagAprobadoJefe("S");
								objupd.setAprobadoJefePor(getUsuarioActual().getCodigoUsuario());
								objupd.setFechaAprobadoJefe(new Date());
								objupd.setUltimoUsuario(w_usuarioactual);
								objupd.setUltimaFechaModif(new Date());
								getFacAsistencia().getAsAutorizacionServicio().actualizar(objupd);
							}

							if (w_resultado) {
								w_enviosbuenos += 1;
							} else {
								w_enviosmalos += 1;
							}

							mensajeaux = ", está pendiente la validación de URH.";

							enviarCorreo("J", obj);
						}

					}

					if (w_estado.equals("A")) {

						w_usuarioseleccionado = obj.getAutorizadoPor();

						if (!w_usuarioactual.equals(w_usuarioseleccionado) || w_aprobadorigualvisador
								|| getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
										getUsuarioActual().getAplicacionCodigo(),
										getUsuarioActual().getCodigoUsuario())) {
							if (w_Aprobar.equals("S")) {
								w_estadosiguiente = "A";

								AsAutorizacionPk pkfind = new AsAutorizacionPk();
								pkfind.setConceptoacceso(w_ConceptoAcceso);
								pkfind.setDesde(w_Desde);
								pkfind.setEmpleado(BigDecimal.valueOf(w_empleado));
								pkfind.setFecha(w_fecha);

								AsAutorizacion objupd = (AsAutorizacion) getFacAsistencia().getAsAutorizacionServicio()
										.obtenerPorId(pkfind, false);

								if (!UValidador.esNulo(objupd)) {
									objupd.setEstado(w_estadosiguiente);
									objupd.setVisadopor(w_usuarioactual);
									objupd.setFechavisado(new Date());
									objupd.setUltimoUsuario(w_usuarioactual);
									objupd.setUltimaFechaModif(new Date());

									getFacAsistencia().getAsAutorizacionServicio().actualizar(objupd);
								}

								if (w_resultado) {
									w_enviosbuenos += 1;
								} else {
									w_enviosmalos += 1;
								}

							}

							if (w_Rechazar.equals("S")) {
								if (!UValidador.esNulo(obj.getMotivorechazo())) {
									w_estadosiguiente = "R";
									if (w_CategoriaAutorizacion.equals("OMIS")) {
										wf_eliminar_Marca(w_empleado, w_Desde);
									}

									if (obj.getCategoriaAutorizacion().equals("SOBR")
											&& obj.getTipoautorizacion().equals("F")) {
										wf_evaluar_dia_descanso(obj.getEmpleado(), obj.getFecha(), obj.getFechafin(),
												obj.getDesde1(), obj.getHasta1(), ll_terminal, w_estadosiguiente,
												obj.getCategoriaAutorizacion());
									}

									if (w_ConceptoAcceso.equals("CHOR")) {
										List<AsEmpleadoexcepcionsolicitud> horarios = getFacAsistencia()
												.getAsEmpleadoexcepcionsolicitudServicio()
												.listarEmpleadoExcepcionSolicitud(w_empleado, w_fecha);

										if (!UValidador.esListaVacia(horarios)) {
											for (AsEmpleadoexcepcionsolicitud objhor : horarios) {
												AsEmpleadoexcepcionPk pkdel = new AsEmpleadoexcepcionPk();
												pkdel.setEmpleado(w_empleado);
												pkdel.setFecha(objhor.getPk().getFecha());
												pkdel.setFechahasta(objhor.getPk().getFecha());

												AsEmpleadoexcepcion objdel = (AsEmpleadoexcepcion) getFacAsistencia()
														.getAsEmpleadoexcepcionServicio().obtenerPorId(pkdel, false);

												if (!UValidador.esNulo(objdel)) {
													getFacAsistencia().getAsEmpleadoexcepcionServicio()
															.eliminar(objdel);
												}

												AsEmpleadoexcepciondetallePk pkdetdel = new AsEmpleadoexcepciondetallePk();
												pkdetdel.setEmpleado(w_empleado);
												pkdetdel.setFecha(objhor.getPk().getFecha());
												pkdetdel.setIntervaloacceso(objhor.getIntervaloacceso());
												pkdetdel.setSecuencia(1);

												AsEmpleadoexcepciondetalle objdetdel = (AsEmpleadoexcepciondetalle) getFacAsistencia()
														.getAsEmpleadoexcepciondetalleServicio()
														.obtenerPorId(pkdetdel, false);

												if (!UValidador.esNulo(objdetdel)) {
													getFacAsistencia().getAsEmpleadoexcepciondetalleServicio()
															.eliminar(objdetdel);
												}

											}
										}
									}

									// URA 14/08/2015 Eliminar en la tabla de
									// reprogramación de las vacaciones
									if (w_ConceptoAcceso.equals("VACA")) {

										ls_periodo = obj.getPeriodo();
										ls_periodoPago = ls_periodo + obj.getPeriodo().substring(4, 6);
										ldt_Fechafin = obj.getFechafin();

										// URA 08/03/2016 Validar si ya se
										// genero
										// las vacaciones del Empleado
										Integer w_count = 0;

										w_count = getFacPlanilla().getPrVacacionesprogramadasServicio()
												.contarVacacionesUtilizacion(w_empleado, w_fecha, ldt_Fechafin);

										if (UValidador.esCero(w_count)) {
											List<PrVacacionesprogramadas> lstDel = getFacPlanilla()
													.getPrVacacionesprogramadasServicio().listarVacacionesProgramadas(
															w_empleado, ls_periodo, w_fecha, ldt_Fechafin);

											for (PrVacacionesprogramadas vacprodel : lstDel) {
												vacprodel.setTipoutilizacion("S");
												vacprodel.setObservacionorigen("Sin efecto desde Web");
												vacprodel.setUltimoUsuario(getUsuarioActual().getCodigoUsuario());
												vacprodel.setUltimaFechaModif(new Date());
												getFacPlanilla().getPrVacacionesprogramadasServicio()
														.actualizar(vacprodel);
											}
										} else {
											List<PrVacacionesprogramadas> lstDel = getFacPlanilla()
													.getPrVacacionesprogramadasServicio().listarVacacionesEjecutadas(
															w_empleado, ls_periodo, w_fecha, ldt_Fechafin);

											for (PrVacacionesprogramadas vacprodel : lstDel) {
												vacprodel.setTipoutilizacion("S");
												vacprodel.setObservacionorigen("Sin efecto desde Web");
												vacprodel.setUltimoUsuario(getUsuarioActual().getCodigoUsuario());
												vacprodel.setUltimaFechaModif(new Date());
												getFacPlanilla().getPrVacacionesprogramadasServicio()
														.actualizar(vacprodel);
											}
											// // ST02: Eliminar Vacacion Pago
											getFacPlanilla().getPrVacacionesprogramadasServicio()
													.eliminarVacacionPago(w_empleado, w_fecha, ldt_Fechafin);

											// // ST02: Actualizar en vacación
											// // utilización estado "sin
											// efecto"
											getFacPlanilla().getPrVacacionesprogramadasServicio()
													.sinEfectoVacacionUtilizacion(w_empleado,
															getUsuarioActual().getCompaniaSocioCodigo(), w_fecha,
															ldt_Fechafin);
										}

									}

									// actualizamos la autorizacion pasadas las
									// validaciones
									AsAutorizacionPk pkfind = new AsAutorizacionPk();
									pkfind.setConceptoacceso(w_ConceptoAcceso);
									pkfind.setDesde(w_Desde);
									pkfind.setEmpleado(BigDecimal.valueOf(w_empleado));
									pkfind.setFecha(w_fecha);

									AsAutorizacion objupd = (AsAutorizacion) getFacAsistencia()
											.getAsAutorizacionServicio().obtenerPorId(pkfind, false);

									if (!UValidador.esNulo(objupd)) {
										objupd.setEstado(w_estadosiguiente);
										objupd.setRechazadopor(w_usuarioactual);
										objupd.setFecharechazo(new Date());
										objupd.setMotivorechazo(obj.getMotivorechazo());
										objupd.setUltimoUsuario(w_usuarioactual);
										objupd.setUltimaFechaModif(new Date());

										getFacAsistencia().getAsAutorizacionServicio().actualizar(objupd);
									}

									if (w_resultado) {
										w_enviosbuenos += 1;
									} else {
										w_enviosmalos += 1;
									}

									// si se rechaza una compensacion se debe de
									// actualizar el saldo.
									if (obj.getCategoriaAutorizacion().equals("COMP")) {
										wf_eliminar_hora_consumida(obj.getEmpleado(),
												UFechaHora.obtenerFechaCompuesta(obj.getFecha(), obj.getDesde1()));
									}

									enviarCorreo("R", obj);
								}
							}
						}
					}

					if (w_estado.equals("V")) {

						w_usuarioseleccionado = obj.getVisadoPor();

						if (w_usuarioactual.equals(w_usuarioseleccionado)
								|| getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
										getUsuarioActual().getAplicacionCodigo(),
										getUsuarioActual().getCodigoUsuario())) { // uo_navigator.EsSisAdm
							// TRUE
							if (w_Rechazar.equals("S")) {
								// FALTA COMPLTAR CUANDO ES UN RECHAZO
								if (!UValidador.estaVacio(obj.getMotivorechazo())) {
									w_estadosiguiente = "R";

									// ELIMINAMOS ACCESOS DIARIOS
									getFacAsistencia().getAsAccesosdiariosServicio()
											.eliminarPorEmpleadoFecha(w_empleado, w_Desde);

									// actualizamos la autorizacion
									AsAutorizacionPk pkfind = new AsAutorizacionPk();
									pkfind.setConceptoacceso(w_ConceptoAcceso);
									pkfind.setDesde(w_Desde);
									pkfind.setEmpleado(BigDecimal.valueOf(w_empleado));
									pkfind.setFecha(w_fecha);

									AsAutorizacion objupd = (AsAutorizacion) getFacAsistencia()
											.getAsAutorizacionServicio().obtenerPorId(pkfind, false);

									if (!UValidador.esNulo(objupd)) {
										objupd.setEstado(w_estadosiguiente);
										objupd.setMotivorechazo(obj.getMotivorechazo());
										objupd.setUltimoUsuario(w_usuarioactual);
										objupd.setUltimaFechaModif(new Date());

										getFacAsistencia().getAsAutorizacionServicio().actualizar(objupd);
									}
								}

								if (w_resultado) {
									w_enviosbuenos += 1;
								} else {
									w_enviosmalos += 1;
								}

							}
						}

					}

				}

			}

			w_Empleado_ant = w_empleado;
			w_Fecha_ant = w_fecha;
			w_Desde_ant = w_Desde;
			w_ConceptoAcceso_ant = w_ConceptoAcceso;
		}

		if (!UValidador.esListaVacia(dw_2)) {
			if (!UValidador.esCero(w_count_fuerarango) && w_count_fuerarango.equals(cantseleccionados)) {
				iserror = true;
			}
			if (UValidador.esCero(cantjuntos)) {
				if (!iserror) {
					setMessageSuccess("Se procesó correctamente" + mensajeaux, true);

					buscar();
				}
			} else {
				setMessageWarn("Los registros sin archivo adjunto requerido no se procesaron.");
				buscar();
			}
		}

	}

	private void wf_evaluar_dia_descanso(BigDecimal empleado, Date fecha, Date fechafin, Date desde1, Date hasta1,
			Integer ll_terminal, String w_estadosiguiente, String categoriaAutorizacion) {
		// TODO Auto-generated method stub

		Integer contadorfecha;
		Integer diferencia;
		Integer tipodia;

		diferencia = UFechaHora.obtenerDiasTranscurridos(fechafin, fecha) + 1;

		for (contadorfecha = 1; contadorfecha <= diferencia; contadorfecha++) {

			tipodia = getFacAsistencia().getAsEmpleadoexcepciondetalleServicio()
					.obtenertipodiadescanso(empleado.intValue(), fecha);
			if (UValidador.esNulo(tipodia)) {
				tipodia = 0;
			}

			// if (tipodia.equals(14)) { /* Si es Día de Descanso */
			if (w_estadosiguiente.equals("A")) {
				wf_Insertar_Marca(empleado.intValue(), UFechaHora.obtenerFechaCompuesta(fecha, desde1), "",
						ll_terminal);
				wf_Insertar_Marca(empleado.intValue(), UFechaHora.obtenerFechaCompuesta(fecha, hasta1), "",
						ll_terminal);
			}
			if (w_estadosiguiente.equals("R")) {
				getFacAsistencia().getAsAccesosdiariosServicio().eliminarmarcacionsobretiempo(empleado.intValue(),
						UFechaHora.obtenerFechaCompuesta(fecha, desde1), categoriaAutorizacion);
				getFacAsistencia().getAsAccesosdiariosServicio().eliminarmarcacionsobretiempo(empleado.intValue(),
						UFechaHora.obtenerFechaCompuesta(fecha, hasta1), categoriaAutorizacion);
			}
			// }

			// If w%_HoraFin > w%_HoraInicio Then
			// w%_segundos = w%_segundos +
			// Round(SecondsAfter(Time(w%_HoraInicio), Time(w%_HoraFin)),2)
			// End If

			fecha = UFechaHora.obtenerFechaMasdias(fecha, contadorfecha);
		}

	}

	private void wf_eliminar_hora_consumida(BigDecimal empleado, Date fecha) {
		// TODO Auto-generated method stub
		getFacAsistencia().getAsAutorizacionServicio().eliminarAutorizacionFecha(empleado.intValue(), fecha);

	}

	private String enviarCorreo(String accion, DtoDwAsAutorizacionPreprocesoHextra obj) throws Exception {

		// si es una reprogramacion debería enviar correo
		if (!"S".equals(obj.getFlagreprogramado())) {
			if (getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
					getUsuarioActual().getAplicacionCodigo(), getUsuarioActual().getCodigoUsuario())) {
				return null;
			}
		}

		String jefe = null;
		String rol = null;
		String resultado = null;
		String proceso = null;
		String concepto = null;
		String mensajefecha = "";
		String mensaje = "";
		String mensajeadicional = "";
		List<CorreoDestinoCore> destinos = new ArrayList<>();
		String destinatario1 = null;
		String destinatario2 = null;
		String destinatario3 = null;
		String destinatario4 = null;
		String destinatario5 = null;
		String fechaini = null;
		String fechater = null;
		String rutaCompleta = null;
		List<AsEmpleadoexcepcionsolicitud> horarios = null;
		Integer diasresta = 0;
		String mensajehoras = "";
		String mensajefechaprog = "";
		String mensajehorasprog = "";
		String mensajerazonrecupera = "";

		fechaini = UFechaHora.convertirFechaCadena(obj.getFecha(), "dd/MM/yyyy");
		fechater = UFechaHora.convertirFechaCadena(obj.getFechafin(), "dd/MM/yyyy");

		if ("VACA".equals(obj.getConceptoacceso())) {
			diasresta = UFechaHora.obtenerDiferenciaDias(obj.getFecha(), obj.getFechafin()) + 1;
		} else {
			diasresta = getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(obj.getFecha(), obj.getFechafin());
		}

		// OBTENEMOS EL AREA PARA OBTENER LOS DESTINTARIOS
		AsArea area = getFacAsistencia().getAsAreaServicio().obtenerArea(obj.getEmpleado().intValue(),
				getUsuarioActual().getCompaniaSocioCodigo());

		if (!UValidador.esNulo(area)) {

			// DESTINATARIO 1
			if (area.getFlagcorreoresponsable1().equals(UConstante.CONSTANTE_OPCION_SI)) {
				Empleadomast emple1 = new Empleadomast();
				emple1.getPk().setEmpleado(area.getEmpleadoresponsable());
				emple1.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
				emple1 = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(emple1.getPk());
				if (!UValidador.esNulo(emple1)) {
					destinatario1 = emple1.getCorreointerno();
					LOGGER.debug("destinatario1 " + destinatario1);
				}
			}

			// DESTINATARIO 2
			if (area.getFlagcorreoresponsable2().equals(UConstante.CONSTANTE_OPCION_SI)) {
				Empleadomast emple2 = new Empleadomast();
				emple2.getPk().setEmpleado(area.getEmpleadoresponsable2());
				emple2.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
				emple2 = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(emple2.getPk());
				if (!UValidador.esNulo(emple2)) {
					destinatario2 = emple2.getCorreointerno();
					LOGGER.debug("destinatario2 " + destinatario2);
				}
			}

			// DESTINATARIO 3
			if (area.getFlagcorreoresponsable3().equals(UConstante.CONSTANTE_OPCION_SI)) {
				Empleadomast emple3 = new Empleadomast();
				emple3.getPk().setEmpleado(area.getEmpleadoresponsable3());
				emple3.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
				emple3 = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(emple3.getPk());
				if (!UValidador.esNulo(emple3)) {
					destinatario3 = emple3.getCorreointerno();
					LOGGER.debug("destinatario3 " + destinatario3);
				}
			}

			// DESTINATARIO 4
			if (area.getFlagcorreoresponsable4().equals(UConstante.CONSTANTE_OPCION_SI)) {
				Empleadomast emple4 = new Empleadomast();
				emple4.getPk().setEmpleado(area.getEmpleadoresponsable4());
				emple4.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
				emple4 = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(emple4.getPk());
				if (!UValidador.esNulo(emple4)) {
					destinatario4 = emple4.getCorreointerno();
					LOGGER.debug("destinatario4 " + destinatario4);
				}
			}
		}

		// DESTINATARIO EMPLEADO
		Empleadomast empleado = new Empleadomast();
		empleado.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
		empleado.getPk().setEmpleado(obj.getEmpleado().intValue());
		empleado = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(empleado.getPk());
		if (!UValidador.esNulo(empleado)) {
			destinatario5 = empleado.getCorreointerno();
			LOGGER.debug("destinatario " + destinatario5);
		}

		if (!UValidador.estaVacio(destinatario1)) {
			destinos.add(new CorreoDestinoCore(destinatario1));
		}
		if (!UValidador.estaVacio(destinatario2)) {
			destinos.add(new CorreoDestinoCore(destinatario2));
		}
		if (!UValidador.estaVacio(destinatario3)) {
			destinos.add(new CorreoDestinoCore(destinatario3));
		}
		if (!UValidador.estaVacio(destinatario4)) {
			destinos.add(new CorreoDestinoCore(destinatario4));
		}

		if (!UValidador.estaVacio(destinatario5)) {
			destinos.add(new CorreoDestinoCore(destinatario5));
		}

		if (UValidador.esListaVacia(destinos)) {
			return null;
		}

		// JEFE
		jefe = getFacCore().getPersonamastServicio()
				.obtenerNombrePersona(BigDecimal.valueOf(getUsuarioActual().getIdPersona()));

		rol = isaprobador ? "Jefe" : "Jefe";

		// CONCEPTO
		// CONCEPTO
		AsConceptoacceso objcon = new AsConceptoacceso();
		objcon.getPk().setConceptoacceso(obj.getConceptoacceso());
		objcon = (AsConceptoacceso) getFacAsistencia().getAsConceptoaccesoServicio().obtenerPorId(objcon.getPk());
		if (!UValidador.esNulo(objcon)) {
			concepto = objcon.getDescripcionlocal();
			// si tiene correo copia para aprobación lo agregamos a la lista de
			// correos
			if ("S".equals(objcon.getFlagcorreocopiaaprob()) && !UValidador.estaVacio(objcon.getCorreocopiaaprob())) {
				destinos.add(new CorreoDestinoCore(objcon.getCorreocopiaaprob(), tipo_destino.CC));
			}

		}

		// MENSAJE FECHAS

		// SI ES CAMBIO DE HORARIO TOMAMOS LA PRIMERA Y ULTIMA FECHA
		if (obj.getConceptoacceso().equals("CHOR")) {
			horarios = getFacAsistencia().getAsEmpleadoexcepcionsolicitudServicio()
					.listarEmpleadoExcepcionSolicitud(obj.getEmpleado().intValue(), obj.getFecha());
		}

		if (!UValidador.esListaVacia(horarios)) {
			fechaini = UFechaHora.convertirFechaCadena(horarios.get(0).getPk().getFecha(), "dd/MM/yyyy");
			fechater = UFechaHora.convertirFechaCadena(horarios.get(horarios.size() - 1).getPk().getFecha(),
					"dd/MM/yyyy");
			diasresta = UFechaHora.obtenerDiferenciaDias(horarios.get(0).getPk().getFecha(),
					horarios.get(horarios.size() - 1).getPk().getFecha()) + 1;
		}

		mensajefecha = " desde el " + fechaini + " hasta el " + fechater;
		if (obj.getConceptoacceso().equals("OMIS")) {
			mensajefecha = " para el día " + fechaini;
		}

		if (!UValidador.esListaVacia(horarios)) {
			if (horarios.size() == 1) {
				mensajefecha = " para el día " + fechaini;
			}
		}

		if (UValidador.esCero(diasresta - 1)) {
			if (obj.getConceptoacceso().equals("OMIS")) {
				mensajehoras = ", a las " + UFechaHora.convertirFechaCadena(obj.getDesde1(), "HH:mm");
			} else {
				mensajehoras = ", de " + UFechaHora.convertirFechaCadena(obj.getDesde1(), "HH:mm") + " a "
						+ UFechaHora.convertirFechaCadena(obj.getHasta1(), "HH:mm");
			}

		} else {
			mensajehoras = "";
		}

		// APROBACION
		if (accion.equals("A")) {
			proceso = "Autorización";
			resultado = "autorizó";
			// SI ES VACACIONES ERQUIERE APROBACION DE URH
			if (obj.getConceptoacceso().equals("VACA")) {
				mensajeadicional = ", está pendiente la validación de URH";
			}
		}

		// APROBACION JEFE
		if (accion.equals("J")) {
			proceso = "Autorización Jefe";
			resultado = "autorizó";
			mensajeadicional = ", está pendiente la validación de URH";
		}

		// RECHAZO
		if (accion.equals("R")) {
			proceso = "Rechazo";
			resultado = "rechazó";
		}

		// Si es un concepto por resolucion 044 y la aprueba URH agregamos
		// mensaje adicional;
		if (obj.getConceptoacceso().equals("34") && accion.equals("A")) {
			rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//solicitud_resolucion044.html");
			mensajehoras = " máximo " + objcon.getNumerohorasmesesrestriccion() + " horas ";
			mensajefecha = " para el día " + UFechaHora.convertirFechaCadena(obj.getFecha(), "dd/MM/yyyy");
			mensajehorasprog = "" + objcon.getCantidadminutosminimo() + " minutos ";
			mensajefechaprog = UFechaHora.convertirFechaCadena(obj.getDesderecupera(), "dd/MM/yyyy") + " hasta el día "
					+ UFechaHora.convertirFechaCadena(obj.getHastarecupera(), "dd/MM/yyyy");
		} else if ((obj.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_GESTION_PERSOSNAL)
				|| obj.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_AMOR_SALUD)
				|| obj.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_CONTROL_NINO)
				|| obj.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_MEJOR_MAMA)
				|| obj.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_MEJOR_PAPA)
				|| obj.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_RECIEN_CASADOS)
				|| obj.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_VIERNES_VERANO))
				&& accion.equals("A")) {
			if (obj.getConceptoacceso().equals(UConstante.CONSTANTE_CONCEPTO_VIERNES_VERANO)) {
				mensajerazonrecupera = " a razón de 1 hora por día";
			}
			rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//autorizacion_compensables.html");
			mensajefechaprog = " asimismo se le indica que dichas horas serán compensadas desde el "
					+ UFechaHora.convertirFechaCadena(obj.getDesderecupera(), "dd/MM/yyyy") + " hasta el día "
					+ UFechaHora.convertirFechaCadena(obj.getHastarecupera(), "dd/MM/yyyy");
		} else {
			rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//proceso_asistencia.html");
		}

		LOGGER.debug(rutaCompleta);
		mensaje = UFile.obtenerContenidoFile(rutaCompleta);
		LOGGER.debug(mensaje);

		mensaje = mensaje.replace("[ROL]", UString.cambiarCaracteresEspecialesHTML(rol));
		mensaje = mensaje.replace("[JEFE]", UString.cambiarCaracteresEspecialesHTML(jefe));
		mensaje = mensaje.replace("[PROCESO]", UString.cambiarCaracteresEspecialesHTML(proceso));
		mensaje = mensaje.replace("[RESULTADO]", UString.cambiarCaracteresEspecialesHTML(resultado));
		mensaje = mensaje.replace("[CONCEPTO]", UString.cambiarCaracteresEspecialesHTML(concepto));
		mensaje = mensaje.replace("[MENSAJE_FECHA]", UString.cambiarCaracteresEspecialesHTML(mensajefecha));
		mensaje = mensaje.replace("[MENSAJE_HORA]", UString.cambiarCaracteresEspecialesHTML(mensajehoras));
		mensaje = mensaje.replace("[MENSAJE_ADICIONAL]", UString.cambiarCaracteresEspecialesHTML(mensajeadicional));
		mensaje = mensaje.replace("[DIFERENCIA_DIAS]",
				UString.cambiarCaracteresEspecialesHTML(UValidador.esCero(diasresta) ? "" : " Días: " + (diasresta)));
		mensaje = mensaje.replace("[MENSAJE_FECHA_PROG]", UString.cambiarCaracteresEspecialesHTML(mensajefechaprog));
		mensaje = mensaje.replace("[MENSAJE_HORA_PROG]", UString.cambiarCaracteresEspecialesHTML(mensajehorasprog));
		mensaje = mensaje.replace("[MENSAJE_1]",
				"Conforme a lo indicado en su carta y de acuerdo a la Resolución de Gerencia General N° 044-2018-OEFA/GEG, se aprueba su permiso de ");
		mensaje = mensaje.replace("[MENSAJE_2]",
				" asimismo se le indica que dichas horas serán compensadas desde el día ");
		mensaje = mensaje.replace("[MENSAJE_3]", " a razón de mínimo ");
		mensaje = mensaje.replace("[MENSAJE_4]", mensajerazonrecupera);
		// ENVIO
		Boolean isconfiguradocorreo = getFacSeguridad().getCorreoServicio().configurarCorreo();

		if (isconfiguradocorreo) {
			CorreoCore correo = new CorreoCore();
			correo.setListaCorreoDestino(destinos);
			correo.setAsunto(proceso + " de Asistencia");
			correo.setCuerpoCorreo(mensaje.getBytes());

			getFacSeguridad().getCorreoServicio().enviarCorreo(correo);
		}

		return null;

	}

	private String enviarCorreoActivacionTemporal(DtoDwAsAutorizacionPreprocesoHextra obj, String pwd)
			throws Exception {

		String jefe = null;
		String rol = null;
		String resultado = null;
		String proceso = null;
		String concepto = null;
		String mensajefecha = "";
		String mensaje = "";
		String mensajeadicional = "";
		List<CorreoDestinoCore> destinos = new ArrayList<>();
		String destinatario1 = null;
		String destinatario2 = null;
		String destinatario3 = null;
		String destinatario4 = null;
		String destinatario5 = null;
		String fechaini = null;
		String fechater = null;
		String rutaCompleta = null;
		List<AsEmpleadoexcepcionsolicitud> horarios = null;
		Integer diasresta = 0;
		String mensajehoras = "";
		String mensajefechaprog = "";
		String mensajehorasprog = "";
		String mensajerazonrecupera = "";

		fechaini = UFechaHora.convertirFechaCadena(obj.getFecha(), "dd/MM/yyyy");
		fechater = UFechaHora.convertirFechaCadena(obj.getFechafin(), "dd/MM/yyyy");

		if ("VACA".equals(obj.getConceptoacceso())) {
			diasresta = UFechaHora.obtenerDiferenciaDias(obj.getFecha(), obj.getFechafin()) + 1;
		} else {
			diasresta = getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(obj.getFecha(), obj.getFechafin());
		}

		// DESTINATARIO EMPLEADO
		Empleadomast empleado = new Empleadomast();
		empleado.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
		empleado.getPk().setEmpleado(obj.getEmpleado().intValue());
		empleado = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(empleado.getPk());
		if (!UValidador.esNulo(empleado)) {
			destinatario5 = empleado.getCorreointerno();
			LOGGER.debug("destinatario " + destinatario5);
		}

		Personamast persona = getFacCore().getPersonamastServicio().obtenerporPersona(obj.getEmpleado().intValue());

		if (!UValidador.estaVacio(destinatario5)) {
			destinos.add(new CorreoDestinoCore(destinatario5));
		}

		if (UValidador.esListaVacia(destinos)) {
			return null;
		}

		rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//activacion_temporal.html");

		LOGGER.debug(rutaCompleta);
		mensaje = UFile.obtenerContenidoFile(rutaCompleta);
		LOGGER.debug(mensaje);

		mensaje = mensaje.replace("[EMPLEADO]", UString.cambiarCaracteresEspecialesHTML(persona.getNombrecompleto()));
		mensaje = mensaje.replace("[USUARIO]", UString.cambiarCaracteresEspecialesHTML(empleado.getCodigousuario()));
		mensaje = mensaje.replace("[CLAVE]", UString.cambiarCaracteresEspecialesHTML(pwd));
		// ENVIO
		Boolean isconfiguradocorreo = getFacSeguridad().getCorreoServicio().configurarCorreo();

		if (isconfiguradocorreo) {
			CorreoCore correo = new CorreoCore();
			correo.setListaCorreoDestino(destinos);
			correo.setAsunto("SIARRHH/SIGED - COMUNICADO ACTIVACIÓN TEMPORAL");
			correo.setCuerpoCorreo(mensaje.getBytes());

			getFacSeguridad().getCorreoServicio().enviarCorreo(correo);
		}

		return null;

	}

	private void wf_eliminar_Marca(Integer empleado, Date fecha) {
		getFacAsistencia().getAsAccesosdiariosServicio().eliminarPorEmpleadoFecha(empleado, fecha);
	}

	private void wf_Insertar_Marca(Integer empleado, Date fecha, String aprobador, Integer terminal) {
		String w_carnet;
		Integer w_secuencia;
		Integer w_ano, w_mes, w_dia;
		String w_observacion;

		w_ano = UFechaHora.obtenerFechaParte(fecha, "YY");
		w_mes = UFechaHora.obtenerFechaParte(fecha, "MM");
		w_dia = UFechaHora.obtenerFechaParte(fecha, "DD");

		w_observacion = "Vía Autorización";

		w_secuencia = getFacAsistencia().getAsAccesosdiariosServicio().obtenerMaximoSecuencia(empleado, fecha);

		w_carnet = getFacAsistencia().getAsCarnetidentificacionServicio().obtenerMaximoCodigoCarnetActivo(empleado);

		AsAccesosdiarios objins = new AsAccesosdiarios();
		objins.getPk().setCarnetid(w_carnet);
		objins.getPk().setEmpleado(empleado);
		objins.getPk().setFecha(fecha);
		objins.getPk().setSecuencia(w_secuencia);
		objins.setHora(fecha);
		objins.setObservacion(w_observacion);
		objins.setLugarrecoleccion("MANUAL");
		objins.setAno(w_ano);
		objins.setMes(w_mes);
		objins.setDia(w_dia);
		objins.setLectora("SPRING");
		objins.setEmpleadoA(iv_empleado);
		objins.setFechaA(iv_Fecha);
		objins.setConceptoaccesoA(iv_ConceptoAcceso);
		objins.setDesdeA(iv_Desde);
		objins.setTerminal(terminal);
		objins.setUltimoUsuario(getUsuarioActual().getCodigoUsuario());
		objins.setUltimaFechaModif(new Date());

		getFacAsistencia().getAsAccesosdiariosServicio().registrar(objins);

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

	public String verDocumento() throws Exception {

		if (!UValidador.esNulo(uuidAlfresco)) {
			switch (obtenerParametroModoArchivo()) {
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

				if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
					this.setMessageError("No se encontraron los parametros key o ws");
					return null;
				}

				try {
					ContenidoECMBean respuestaconsulta = UOefaAlfresco.obtenerDocumento(uuidAlfresco, key);
					LOGGER.debug(respuestaconsulta);
					if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
						LOGGER.debug("Se encontro el archivo");
						UFile.descargarArchivo(respuestaconsulta.getContenidoFile(), rutaDocumento);
					}
				} catch (Exception e) {
					LOGGER.debug(e.getMessage());
					this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
					return null;
				}
			}
		}

		return null;
	}

	@Override
	public String salir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean validar() throws Exception {
		// TODO Auto-generated method stub
		return null;
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

		LOGGER.debug("Entrando al mensaje");
		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarCompania")) {

			registroSeleccionadoExterno = (List<DtoFiltrosGenericos>) (mensajeControllerGenerico.getParametros()
					.get("compania"));

			datosgenerico.setIsvarioscompania(true);
			if (!UValidador.esListaVacia(registroSeleccionadoExterno)) {
				if (registroSeleccionadoExterno.size() == 1) {
					datosgenerico.setCodCompania(registroSeleccionadoExterno.get(0).getCodigo());
					datosgenerico.setDesCompania(registroSeleccionadoExterno.get(0).getDescripcion());
					datosgenerico.setIsvarioscompania(false);

				} else {
					datosgenerico.setCodCompania("");
					for (DtoFiltrosGenericos obj : registroSeleccionadoExterno) {
						if (UValidador.estaVacio(datosgenerico.getCodCompania())) {
							datosgenerico.setCodCompania(obj.getCodigo());
						} else {
							datosgenerico.setCodCompania(datosgenerico.getCodCompania() + "," + obj.getCodigo());
						}
					}

				}
			}
		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarCostos")) {

			registroSeleccionadoExterno = (List<DtoFiltrosGenericos>) (mensajeControllerGenerico.getParametros()
					.get("costos"));

			datosgenerico.setIsvarioscentrocosto(true);
			if (!UValidador.esListaVacia(registroSeleccionadoExterno)) {
				if (registroSeleccionadoExterno.size() == 1) {

					datosgenerico.setIsvarioscentrocosto(false);
					datosgenerico.setCodCentroCosto(registroSeleccionadoExterno.get(0).getCodigo());
					datosgenerico.setDesCentroCosto(registroSeleccionadoExterno.get(0).getDescripcion());
				} else {
					datosgenerico.setCodCentroCosto("");
					for (DtoFiltrosGenericos obj : registroSeleccionadoExterno) {
						if (UValidador.estaVacio(datosgenerico.getCodCentroCosto())) {
							datosgenerico.setCodCentroCosto(obj.getCodigo());
						} else {
							datosgenerico.setCodCentroCosto(datosgenerico.getCodCentroCosto() + "," + obj.getCodigo());
						}
					}

				}
			}

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarSucursal")) {

			registroSeleccionadoExterno = (List<DtoFiltrosGenericos>) (mensajeControllerGenerico.getParametros()
					.get("sucursal"));

			datosgenerico.setIsvariossucursal(true);
			if (!UValidador.esListaVacia(registroSeleccionadoExterno)) {
				if (registroSeleccionadoExterno.size() == 1) {
					datosgenerico.setIsvariossucursal(false);
					datosgenerico.setCodSucursal(registroSeleccionadoExterno.get(0).getCodigo());
					datosgenerico.setDesSucursal(registroSeleccionadoExterno.get(0).getDescripcion());

				} else {
					datosgenerico.setCodSucursal("");
					for (DtoFiltrosGenericos obj : registroSeleccionadoExterno) {
						if (UValidador.estaVacio(datosgenerico.getCodSucursal())) {
							datosgenerico.setCodSucursal(obj.getCodigo());
						} else {
							datosgenerico.setCodSucursal(datosgenerico.getCodSucursal() + "," + obj.getCodigo());
						}
					}

				}
			}
		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarCategoria")) {

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarPlanilla")) {

			registroSeleccionadoExterno = (List<DtoFiltrosGenericos>) (mensajeControllerGenerico.getParametros()
					.get("planilla"));

			datosgenerico.setIsvariostipoplanilla(true);
			if (!UValidador.esListaVacia(registroSeleccionadoExterno)) {
				if (registroSeleccionadoExterno.size() == 1) {
					datosgenerico.setIsvariostipoplanilla(false);
					datosgenerico.setCodPlantilla(registroSeleccionadoExterno.get(0).getCodigo());
					datosgenerico.setDesPlantilla(registroSeleccionadoExterno.get(0).getDescripcion());
				} else {
					datosgenerico.setCodPlantilla("");
					for (DtoFiltrosGenericos obj : registroSeleccionadoExterno) {
						if (UValidador.estaVacio(datosgenerico.getCodPlantilla())) {
							datosgenerico.setCodPlantilla(obj.getCodigo());
						} else {
							datosgenerico.setCodPlantilla(datosgenerico.getCodPlantilla() + "," + obj.getCodigo());
						}
					}

				}
			}

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarOperaria")) {

			registroSeleccionadoExterno = (List<DtoFiltrosGenericos>) (mensajeControllerGenerico.getParametros()
					.get("operaria"));

			datosgenerico.setIsvariosareaoperativa(true);
			if (!UValidador.esListaVacia(registroSeleccionadoExterno)) {
				if (registroSeleccionadoExterno.size() == 1) {
					datosgenerico.setIsvariosareaoperativa(false);
					datosgenerico.setCodAreaOperativa(registroSeleccionadoExterno.get(0).getCodigo());
					datosgenerico.setDesAreaOperativa(registroSeleccionadoExterno.get(0).getDescripcion());
				} else {
					datosgenerico.setCodAreaOperativa("");
					for (DtoFiltrosGenericos obj : registroSeleccionadoExterno) {
						if (UValidador.estaVacio(datosgenerico.getCodAreaOperativa())) {
							datosgenerico.setCodAreaOperativa(obj.getCodigo());
						} else {
							datosgenerico
									.setCodAreaOperativa(datosgenerico.getCodAreaOperativa() + "," + obj.getCodigo());
						}
					}

				}
			}

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarInactivos")) {

			// registroSeleccionadoExterno = (DtoFiltrosGenericos)
			// (mensajeControllerGenerico
			// .getParametros().get("inactivos"));
			//
			// datosgenerico.setCodInactivos(registroSeleccionadoExterno
			// .getCodigo());
			// datosgenerico.setDesInactivos(registroSeleccionadoExterno
			// .getDescripcion());

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarPuestos")) {

			registroSeleccionadoExterno = (List<DtoFiltrosGenericos>) (mensajeControllerGenerico.getParametros()
					.get("puestos"));

			datosgenerico.setIsvariospuesto(true);
			if (!UValidador.esListaVacia(registroSeleccionadoExterno)) {
				if (registroSeleccionadoExterno.size() == 1) {
					datosgenerico.setIsvariospuesto(false);
					datosgenerico.setCodPuesto(registroSeleccionadoExterno.get(0).getCodigo());
					datosgenerico.setDesPuesto(registroSeleccionadoExterno.get(0).getDescripcion());
				} else {
					datosgenerico.setCodPuesto("");
					for (DtoFiltrosGenericos obj : registroSeleccionadoExterno) {
						if (UValidador.estaVacio(datosgenerico.getCodPuesto())) {
							datosgenerico.setCodPuesto(obj.getCodigo());
						} else {
							datosgenerico.setCodPuesto(datosgenerico.getCodPuesto() + "," + obj.getCodigo());
						}
					}

				}
			}

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarEmpleado")) {

			List<DtoDwAsEmpleadoSelectMultiple> dtoEmpleado = (List<DtoDwAsEmpleadoSelectMultiple>) mensajeControllerGenerico
					.getParametros().get("empleado");

			if (dtoEmpleado.size() == 1) {
				datosgenerico.setCodEmpleado(dtoEmpleado.get(0).getPersona() + "");
				datosgenerico.setNombreCompleto(dtoEmpleado.get(0).getNombrecompleto());
				verSeleccionados = true;
			} else if (dtoEmpleado.size() > 1) {
				datosgenerico.setCodEmpleado("");
				for (DtoDwAsEmpleadoSelectMultiple obj : dtoEmpleado) {
					if (UValidador.estaVacio(datosgenerico.getCodEmpleado())) {
						datosgenerico.setCodEmpleado(obj.getPersona().intValue() + "");
					} else {
						datosgenerico
								.setCodEmpleado(datosgenerico.getCodEmpleado() + "," + obj.getPersona().intValue());
					}
				}
				verSeleccionados = false;
			}
		}
		return "wasautorizacionpreprocesoaprobacionSIGED";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String inicializarFiltrosListado() throws Exception {
		// TODO Auto-generated method stub
		dwFiltros = new FwAsAutorizacionPreprocesoAprobacion();
		dwFiltros.setAlllocation("S");
		dwFiltros.setFechas(2); // Mostrar opcion Fecha
		dwFiltros.setIscesados(true);
		dwFiltros.setIsinactivos(true);
		dwFiltros.setFechadesde(UFechaHora.obtenerPrimerDiaMes());
		dwFiltros.setFechaHasta(UFechaHora.obtenerUltimoDiaMes());
		dwFiltros.setFechaHasta(UFechaHora.addMesesToDate(dwFiltros.getFechaHasta(), 24));

		dwFiltros.setPeriodo("" + UFechaHora.obtenerFechaParte(new Date(), "YY") + ""
				+ ((UFechaHora.obtenerFechaParte(new Date(), "MM")) < 10
						? "0" + UFechaHora.obtenerFechaParte(new Date(), "MM")
						: UFechaHora.obtenerFechaParte(new Date(), "MM")));

		Integer periodo = getFacAsistencia().getAsPeriodoServicio().obtenerMaximoPeriodoPlanilla();

		if (!UValidador.esNulo(periodo) && !UValidador.esCero(periodo)) {
			dwFiltros.setPeriodo(periodo.toString().substring(0, 6));
		}

		// Boolean isadmin =
		// getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
		// getUsuarioActual().getAplicacionCodigo(),
		// getUsuarioActual().getLoginUsuario().toUpperCase());
		// List data =
		// getFacAsistencia().getAS().getAsmainFuncion().FAsFechasactivasPeriodo(periodo.toString(),
		// isadmin ? "S" : "N");
		//
		// if (!UValidador.esListaVacia(data)) {
		// dwFiltros.setFechadesde((Date) data.get(0));
		// dwFiltros.setFechaHasta((Date) data.get(1));
		// }

		dwFiltros.setIstodos(false);
		dwFiltros.setIsperiodo(false);
		dwFiltros.setIsfecha(true);

		dwFiltros.setAlltipoplanilla("S");
		dwFiltros.setEstado("T");

		// conceptos accesos
		dw_conceptoaccesofiltro = getFacAsistencia().getAsConceptoaccesoServicio()
				.obtenerConceptosAccesosSIGED(getUsuarioActual().getCodigoUsuario(), isadmin ? "S" : "N");

		String comp = "";

		if (!UValidador.esNulo(this.getUsuarioActual().getCompaniaSocioCodigo())) {
			if (this.getUsuarioActual().getCompaniaSocioCodigo().length() > 6) {
				comp = this.getUsuarioActual().getCompaniaSocioCodigo().substring(0, 6);
			}
		}

		Companiamast compania = (Companiamast) this.getFacCore().getCompaniamastServicio()
				.obtenerPorId(new CompaniamastPk(comp));

		if (UValidador.esNulo(compania)) {
			compania = new Companiamast();
		}

		datosgenerico.setCodCompania(this.getUsuarioActual().getCompaniaSocioCodigo());
		datosgenerico.setDesCompania(compania.getDescripcioncorta());

		isaprobador = false;

		// Si el empleado es jefe de area o administrador cargamos sus datos por
		// separado y no como filtro.
		AsArea area = getFacAsistencia().getAsAreaServicio()
				.obtenerAreaEmpleadoResponsable(getUsuarioActual().getIdPersona());
		if (!UValidador.esNulo(area)) {
			isaprobador = true;
		}

		getUsuarioActual().setIsaprobador(isaprobador);

		Empleadomast empfiltro = new Empleadomast();
		empfiltro.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
		empfiltro.getPk().setEmpleado(getUsuarioActual().getIdPersona());

		empfiltro = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(empfiltro.getPk());

		if (!isadmin && !isaprobador && !isperfilas09) {
			ismostrarDatosResponsable = false;

			// TIPO DE PLANILLA
			if (!UValidador.esNulo(empfiltro)) {
				PrTipoplanilla objpla = new PrTipoplanilla();
				objpla.getPk().setTipoplanilla(empfiltro.getTipoplanilla());
				objpla = (PrTipoplanilla) getFacPlanilla().getPrTipoplanillaServicio().obtenerPorId(objpla.getPk());
				if (!UValidador.esNulo(objpla)) {
					datosgenerico.setCodPlantilla(objpla.getPk().getTipoplanilla());
					datosgenerico.setDesPlantilla(objpla.getDescripcion());
				}
			}

			// CENTRO DE COSTO
			if (!UValidador.esNulo(empfiltro)) {
				AcCostcentermst objcc = new AcCostcentermst();
				objcc.getPk().setCostcenter(empfiltro.getCentrocostos());
				objcc = (AcCostcentermst) getFacContabilidad().getAcCostcentermstServicio().obtenerPorId(objcc.getPk());
				if (!UValidador.esNulo(objcc)) {
					datosgenerico.setCodCentroCosto(objcc.getPk().getCostcenter());
					datosgenerico.setDesCentroCosto(objcc.getLocalname());
				}
			}

			// AREA OPERATIVA
			if (!UValidador.esNulo(empfiltro)) {
				AsCarnetidentificacion objcni = new AsCarnetidentificacion();
				objcni = getFacAsistencia().getAsCarnetidentificacionServicio()
						.obtenerPorEmplado(empfiltro.getPk().getEmpleado());
				if (!UValidador.esNulo(objcni)) {
					AsArea objaa = new AsArea();
					objaa.getPk().setArea(objcni.getArea());
					objaa = (AsArea) getFacAsistencia().getAsAreaServicio().obtenerPorId(objaa.getPk());
					if (!UValidador.esNulo(objaa)) {
						datosgenerico.setCodAreaOperativa(objaa.getPk().getArea().toString());
						datosgenerico.setDesAreaOperativa(objaa.getNombre());
					}
				}
			}

			// SUCURSAL
			if (!UValidador.esNulo(empfiltro)) {
				AcSucursal objsuc = new AcSucursal();
				objsuc.getPk().setSucursal(empfiltro.getSucursal());
				objsuc = (AcSucursal) getFacContabilidad().getAcSucursalServicio().obtenerPorId(objsuc.getPk());
				if (!UValidador.esNulo(objsuc)) {
					datosgenerico.setCodSucursal(objsuc.getPk().getSucursal());
					datosgenerico.setDesSucursal(objsuc.getDescripcionlocal());
				}
			}

			// PUESTO
			if (!UValidador.esNulo(empfiltro)) {
				HrPuestoempresa objpemp = new HrPuestoempresa();
				objpemp.getPk().setCodigopuesto(empfiltro.getCodigocargo());
				objpemp = (HrPuestoempresa) getFacRrhh().getHrPuestoempresaServicio().obtenerPorId(objpemp.getPk());
				if (!UValidador.esNulo(objpemp)) {
					datosgenerico.setCodPuesto(objpemp.getPk().getCodigopuesto().toString());
					datosgenerico.setDesPuesto(objpemp.getDescripcion());
				}
			}

			// PERSONA
			if (!UValidador.esNulo(empfiltro)) {
				Personamast objper = new Personamast();
				objper.getPk().setPersona(empfiltro.getPk().getEmpleado());
				objper = (Personamast) getFacCore().getPersonamastServicio().obtenerPorId(objper.getPk());
				if (!UValidador.esNulo(objper)) {
					datosgenerico.setCodEmpleado(objper.getPk().getPersona().toString());
					datosgenerico.setNombreCompleto(objper.getNombrecompleto());
				}
			}
		} else {
			// si es aprobador el estado por defecto deberia ser solicitud
			dwFiltros.setEstado("S");

			ismostrarDatosResponsable = true;
			// PUESTO
			if (!UValidador.esNulo(empfiltro)) {
				HrPuestoempresa objpemp = new HrPuestoempresa();
				objpemp.getPk().setCodigopuesto(empfiltro.getCodigocargo());
				objpemp = (HrPuestoempresa) getFacRrhh().getHrPuestoempresaServicio().obtenerPorId(objpemp.getPk());
				if (!UValidador.esNulo(objpemp)) {
					dwFiltros.setPuesto(objpemp.getDescripcion());
				}
			}
			// CENTRO DE COSTO
			if (!UValidador.esNulo(empfiltro)) {
				AcCostcentermst objcc = new AcCostcentermst();
				objcc.getPk().setCostcenter(empfiltro.getCentrocostos());
				objcc = (AcCostcentermst) getFacContabilidad().getAcCostcentermstServicio().obtenerPorId(objcc.getPk());
				if (!UValidador.esNulo(objcc)) {
					dwFiltros.setCentrocosto(objcc.getLocalname());
				}
			}

			// PERSONA
			if (!UValidador.esNulo(empfiltro)) {
				Personamast objper = new Personamast();
				objper.getPk().setPersona(empfiltro.getPk().getEmpleado());
				objper = (Personamast) getFacCore().getPersonamastServicio().obtenerPorId(objper.getPk());
				if (!UValidador.esNulo(objper)) {
					dwFiltros.setEmpleado(objper.getNombrecompleto());
				}
			}
		}

		return null;
	}

	public void seleccionarTodosAprobados(ValueChangeEvent event) {

		Boolean w_flag;

		Boolean valor = (Boolean) event.getNewValue();

		LOGGER.debug("valor " + valor);

		if (valor) {
			w_flag = true;
			dwFiltros.setIsseltodosrechazados(false);
		} else {
			w_flag = false;
		}

		for (DtoDwAsAutorizacionPreprocesoHextra obj : lstAutorizacionPreProcesoAprobacion) {
			if (!obj.getEstado().equals("R") && !empleado.equals(obj.getEmpleado().intValue())
					&& obj.getIsadminapro().equals("N")) {
				obj.setIsseleccionaprobado(w_flag);
			}

			if (w_flag) {
				obj.setIsseleccionrechazado(false);
			}
		}

	}

	public void seleccionarTodosRechazados(ValueChangeEvent event) {
		Boolean w_flag;

		Boolean valor = (Boolean) event.getNewValue();

		LOGGER.debug("valor " + valor);

		if (valor) {
			w_flag = true;
			dwFiltros.setIsseltodosaprobados(false);
		} else {
			w_flag = false;
		}

		for (DtoDwAsAutorizacionPreprocesoHextra obj : lstAutorizacionPreProcesoAprobacion) {

			if ((obj.getEstado().equals("S") || obj.getEstado().equals("A"))
					&& !empleado.equals(obj.getEmpleado().intValue()) && obj.getIsadminapro().equals("N")) {
				obj.setIsseleccionrechazado(w_flag);
			}

			if (w_flag) {
				obj.setIsseleccionaprobado(false);
			}

		}
	}

	public String cambiarSeleccion() {
		LOGGER.debug("cambiarSeleccion " + valorseleccion);
		for (DtoDwAsAutorizacionPreprocesoHextra objaut : lstAutorizacionPreProcesoAprobacion) {
			if (((Integer) objaut.getSecuencia().intValue()).equals(secuenciaseleccion.intValue())) {
				if (valorseleccion.equals("A")) {
					if (objaut.getIsseleccionrechazado()) {
						objaut.setIsseleccionrechazado(false);
					}
				}
				if (valorseleccion.equals("R")) {
					if (objaut.getIsseleccionaprobado()) {
						objaut.setIsseleccionaprobado(false);
					}
				}

				break;
			}
		}
		return null;
	}

	public void cambiaropcionFecha(ValueChangeEvent event) {
		dwFiltros.setFechas((Integer) event.getNewValue());
		LOGGER.debug(dwFiltros.getFechas());

		dwFiltros.setIsperiodo(false);
		dwFiltros.setIsfecha(false);

		if (dwFiltros.getFechas().equals(1)) {
			dwFiltros.setIsperiodo(true);
		}
		if (dwFiltros.getFechas().equals(2)) {
			dwFiltros.setIsfecha(true);
		}
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public static CwAsAutorizacionPreprocesoAprobacionSIGED getInstance() {
		return UFaces.evaluateExpressionGet("#{cwAsAutorizacionPreprocesoAprobacionSIGED}",
				CwAsAutorizacionPreprocesoAprobacionSIGED.class);
	}

	public void limpiezaEmpleado() {

		verSeleccionados = true;
		datosgenerico.setEmpleado(null);
		datosgenerico.setCodEmpleado(null);
		datosgenerico.setNombreCompleto(null);
	}

	private BigDecimal wf_diftiempo(Date par_fechainicio, Date par_fechafin) {
		Integer w_segundos, w_dias;

		w_segundos = UFechaHora.obtenerSegundosTranscurridos(par_fechafin, par_fechainicio);
		w_dias = UFechaHora.obtenerDiasTranscurridos(par_fechafin, par_fechainicio);

		w_segundos = w_segundos + w_dias * 3600 * 24;

		return BigDecimal.valueOf(w_segundos);
	}

	private BigDecimal obtenerHorasRefrigerio(int empleado, Date fechaini, Date fechafin, Date desde, Date hasta)
			throws Exception {
		// TODO Auto-generated method stub
		// no se considera el refrigerio en la diferencia.
		BigDecimal difref = BigDecimal.ZERO;

		Integer tipodia = getFacAsistencia().getAS().getAsrepusFuncion().FSqlDevuelveHorario(empleado,
				UFechaHora.obtenerFechaCompuesta(fechaini, desde));

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

		if (desde.before(UFechaHora.obtenerFechaCompuesta(desde, horaini))
				&& hasta.after(UFechaHora.obtenerFechaCompuesta(hasta, horafin))) {
			difref = wf_diftiempo(horaini, horafin).divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_DOWN);
		} else if (desde.before(UFechaHora.obtenerFechaCompuesta(desde, horaini))
				&& hasta.after(UFechaHora.obtenerFechaCompuesta(hasta, horaini))) {
			difref = wf_diftiempo(UFechaHora.obtenerFechaCompuesta(hasta, horaini), hasta)
					.divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_DOWN);
		} else if (desde.before(UFechaHora.obtenerFechaCompuesta(desde, horafin))
				&& hasta.after(UFechaHora.obtenerFechaCompuesta(hasta, horafin))) {
			difref = wf_diftiempo(desde, UFechaHora.obtenerFechaCompuesta(desde, horafin))
					.divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_DOWN);
		}

		return difref;
	}

	public void valuechangeFecha(SelectEvent event) throws Exception {

		if (UValidador.esNulo(event)) {
			return;
		}
		Date fecha = (Date) event.getObject();
		fechaRecuperacionIni = fecha;
		fechaRecuperacionFin = UFechaHora.obtenerFechaMasdias(fechaRecuperacionIni, diasLicPer - 1);

	}

	public void keyfechainicio() throws Exception {

		fechaRecuperacionFin = UFechaHora.obtenerFechaMasdias(fechaRecuperacionIni, diasLicPer - 1);

	}

	public void onRowSelect(SelectEvent event) {
		registroSeleccionado = (DtoDwAsAutorizacionPreprocesoHextra) event.getObject();
	}

	public void onRowDblSelect(SelectEvent event) throws Exception {
		registroSeleccionado = (DtoDwAsAutorizacionPreprocesoHextra) event.getObject();
		ver();
	}

	/**
	 * @return the visibleNuevo
	 */
	public Boolean getVisibleNuevo() {
		return visibleNuevo;
	}

	/**
	 * @param visibleNuevo
	 *            the visibleNuevo to set
	 */
	public void setVisibleNuevo(Boolean visibleNuevo) {
		this.visibleNuevo = visibleNuevo;
	}

	/**
	 * @return the visibleEliminar
	 */
	public Boolean getVisibleEliminar() {
		return visibleEliminar;
	}

	/**
	 * @param visibleEliminar
	 *            the visibleEliminar to set
	 */
	public void setVisibleEliminar(Boolean visibleEliminar) {
		this.visibleEliminar = visibleEliminar;
	}

	/**
	 * @return the dwFiltros
	 */
	public FwAsAutorizacionPreprocesoAprobacion getDwFiltros() {
		return dwFiltros;
	}

	/**
	 * @param dwFiltros
	 *            the dwFiltros to set
	 */
	public void setDwFiltros(FwAsAutorizacionPreprocesoAprobacion dwFiltros) {
		this.dwFiltros = dwFiltros;
	}

	/**
	 * @return the dw_2
	 */
	public List<DtoDwAsAutorizacionPreprocesoHextra> getDw_2() {
		return dw_2;
	}

	/**
	 * @param dw_2
	 *            the dw_2 to set
	 */
	public void setDw_2(List<DtoDwAsAutorizacionPreprocesoHextra> dw_2) {
		this.dw_2 = dw_2;
	}

	/**
	 * @return the registroSeleccionado
	 */
	public DtoDwAsAutorizacionPreprocesoHextra getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	/**
	 * @param registroSeleccionado
	 *            the registroSeleccionado to set
	 */
	public void setRegistroSeleccionado(DtoDwAsAutorizacionPreprocesoHextra registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the datosgenerico
	 */
	public DtoFiltrosGenericos getDatosgenerico() {
		return datosgenerico;
	}

	/**
	 * @param datosgenerico
	 *            the datosgenerico to set
	 */
	public void setDatosgenerico(DtoFiltrosGenericos datosgenerico) {
		this.datosgenerico = datosgenerico;
	}

	public Boolean getVerSeleccionados() {
		return verSeleccionados;
	}

	public void setVerSeleccionados(Boolean verSeleccionados) {
		this.verSeleccionados = verSeleccionados;
	}

	/**
	 * @return the opciones
	 */
	public OwAsAutorizacionPreprocesoAprobacion getOpciones() {
		return opciones;
	}

	/**
	 * @param opciones
	 *            the opciones to set
	 */
	public void setOpciones(OwAsAutorizacionPreprocesoAprobacion opciones) {
		this.opciones = opciones;
	}

	/**
	 * @return the dw_conceptoacceso
	 */
	public List<DtoDddwAsConceptoaccesoSelectPre> getDw_conceptoacceso() {
		return dw_conceptoacceso;
	}

	/**
	 * @param dw_conceptoacceso
	 *            the dw_conceptoacceso to set
	 */
	public void setDw_conceptoacceso(List<DtoDddwAsConceptoaccesoSelectPre> dw_conceptoacceso) {
		this.dw_conceptoacceso = dw_conceptoacceso;
	}

	/**
	 * @return the totalconcepto
	 */
	public BigDecimal getTotalconcepto() {
		return totalconcepto;
	}

	/**
	 * @param totalconcepto
	 *            the totalconcepto to set
	 */
	public void setTotalconcepto(BigDecimal totalconcepto) {
		this.totalconcepto = totalconcepto;
	}

	/**
	 * @return the lstAutorizacionPreProcesoAprobacion
	 */
	public ListDataModel<DtoDwAsAutorizacionPreprocesoHextra> getLstAutorizacionPreProcesoAprobacion() {
		return lstAutorizacionPreProcesoAprobacion;
	}

	/**
	 * @param lstAutorizacionPreProcesoAprobacion
	 *            the lstAutorizacionPreProcesoAprobacion to set
	 */
	public void setLstAutorizacionPreProcesoAprobacion(
			ListDataModel<DtoDwAsAutorizacionPreprocesoHextra> lstAutorizacionPreProcesoAprobacion) {
		this.lstAutorizacionPreProcesoAprobacion = lstAutorizacionPreProcesoAprobacion;
	}

	public String getTablatitulo() {
		return tablatitulo;
	}

	public void setTablatitulo(String tablatitulo) {
		this.tablatitulo = tablatitulo;
	}

	/**
	 * @return the visibleModificar
	 */
	public Boolean getVisibleModificar() {
		return visibleModificar;
	}

	/**
	 * @param visibleModificar
	 *            the visibleModificar to set
	 */
	public void setVisibleModificar(Boolean visibleModificar) {
		this.visibleModificar = visibleModificar;
	}

	/**
	 * @return the visibleImprimir
	 */
	public Boolean getVisibleImprimir() {
		return visibleImprimir;
	}

	/**
	 * @param visibleImprimir
	 *            the visibleImprimir to set
	 */
	public void setVisibleImprimir(Boolean visibleImprimir) {
		this.visibleImprimir = visibleImprimir;
	}

	/**
	 * @return the motivoRechazo
	 */
	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	/**
	 * @param motivoRechazo
	 *            the motivoRechazo to set
	 */
	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	/**
	 * @return the empleadoNombre
	 */
	public String getEmpleadoNombre() {
		return empleadoNombre;
	}

	/**
	 * @param empleadoNombre
	 *            the empleadoNombre to set
	 */
	public void setEmpleadoNombre(String empleadoNombre) {
		this.empleadoNombre = empleadoNombre;
	}

	/**
	 * @return the secuenciaseleccion
	 */
	public BigDecimal getSecuenciaseleccion() {
		return secuenciaseleccion;
	}

	/**
	 * @param secuenciaseleccion
	 *            the secuenciaseleccion to set
	 */
	public void setSecuenciaseleccion(BigDecimal secuenciaseleccion) {
		this.secuenciaseleccion = secuenciaseleccion;
	}

	/**
	 * @return the valorseleccion
	 */
	public String getValorseleccion() {
		return valorseleccion;
	}

	/**
	 * @param valorseleccion
	 *            the valorseleccion to set
	 */
	public void setValorseleccion(String valorseleccion) {
		this.valorseleccion = valorseleccion;
	}

	/**
	 * @return the flagOrigenSolicitud
	 */
	public String getFlagOrigenSolicitud() {
		return flagOrigenSolicitud;
	}

	/**
	 * @param flagOrigenSolicitud
	 *            the flagOrigenSolicitud to set
	 */
	public void setFlagOrigenSolicitud(String flagOrigenSolicitud) {
		this.flagOrigenSolicitud = flagOrigenSolicitud;
	}

	/**
	 * @return the dw_conceptoaccesofiltro
	 */
	public List<DtoDddwAsConceptoaccesoSelectPre> getDw_conceptoaccesofiltro() {
		return dw_conceptoaccesofiltro;
	}

	/**
	 * @param dw_conceptoaccesofiltro
	 *            the dw_conceptoaccesofiltro to set
	 */
	public void setDw_conceptoaccesofiltro(List<DtoDddwAsConceptoaccesoSelectPre> dw_conceptoaccesofiltro) {
		this.dw_conceptoaccesofiltro = dw_conceptoaccesofiltro;
	}

	/**
	 * @return the ismostrarDatosResponsable
	 */
	public Boolean getIsmostrarDatosResponsable() {
		return ismostrarDatosResponsable;
	}

	/**
	 * @param ismostrarDatosResponsable
	 *            the ismostrarDatosResponsable to set
	 */
	public void setIsmostrarDatosResponsable(Boolean ismostrarDatosResponsable) {
		this.ismostrarDatosResponsable = ismostrarDatosResponsable;
	}

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public List<PrProcesoperiodo> getLstPeriodosPlanilla() {
		return lstPeriodosPlanilla;
	}

	public void setLstPeriodosPlanilla(List<PrProcesoperiodo> lstPeriodosPlanilla) {
		this.lstPeriodosPlanilla = lstPeriodosPlanilla;
	}

	public Date getFechaRecuperacionIni() {
		return fechaRecuperacionIni;
	}

	public void setFechaRecuperacionIni(Date fechaRecuperacionIni) {
		this.fechaRecuperacionIni = fechaRecuperacionIni;
	}

	public Date getFechaRecuperacionFin() {
		return fechaRecuperacionFin;
	}

	public void setFechaRecuperacionFin(Date fechaRecuperacionFin) {
		this.fechaRecuperacionFin = fechaRecuperacionFin;
	}

	public String getPeriodoDescontar() {
		return periodoDescontar;
	}

	public void setPeriodoDescontar(String periodoDescontar) {
		this.periodoDescontar = periodoDescontar;
	}

	public String getRutaDocumento() {
		return rutaDocumento;
	}

	public void setRutaDocumento(String rutaDocumento) {
		this.rutaDocumento = rutaDocumento;
	}

	public String getUuidAlfresco() {
		return uuidAlfresco;
	}

	public void setUuidAlfresco(String uuidAlfresco) {
		this.uuidAlfresco = uuidAlfresco;
	}

	public String getFlgperfilas09() {
		return flgperfilas09;
	}

	public void setFlgperfilas09(String flgperfilas09) {
		this.flgperfilas09 = flgperfilas09;
	}

	public DtoEmpleadoSIGED getEmpleadoNuevaBandeja() {
		return empleadoNuevaBandeja;
	}

	public void setEmpleadoNuevaBandeja(DtoEmpleadoSIGED empleadoNuevaBandeja) {
		this.empleadoNuevaBandeja = empleadoNuevaBandeja;
	}

	public List<DtoPerfilSIGED> getListaPerfilesSIGED() {
		return listaPerfilesSIGED;
	}

	public void setListaPerfilesSIGED(List<DtoPerfilSIGED> listaPerfilesSIGED) {
		this.listaPerfilesSIGED = listaPerfilesSIGED;
	}

	public String getUsuarioRed() {
		return usuarioRed;
	}

	public void setUsuarioRed(String usuarioRed) {
		this.usuarioRed = usuarioRed;
	}

	public DtoTablaNuevaBandeja getNuevaBandeja() {
		return nuevaBandeja;
	}

	public void setNuevaBandeja(DtoTablaNuevaBandeja nuevaBandeja) {
		this.nuevaBandeja = nuevaBandeja;
	}

	public List<DtoAreaDetalleSIGED> getListaAreasSIGED() {
		return listaAreasSIGED;
	}

	public void setListaAreasSIGED(List<DtoAreaDetalleSIGED> listaAreasSIGED) {
		this.listaAreasSIGED = listaAreasSIGED;
	}

	public DtoEmpleadoSIGED getEmpleadoAsistenteArea() {
		return empleadoAsistenteArea;
	}

	public void setEmpleadoAsistenteArea(DtoEmpleadoSIGED empleadoAsistenteArea) {
		this.empleadoAsistenteArea = empleadoAsistenteArea;
	}

	public DtoEmpleadoSIGED getEmpleadoJefeArea() {
		return empleadoJefeArea;
	}

	public void setEmpleadoJefeArea(DtoEmpleadoSIGED empleadoJefeArea) {
		this.empleadoJefeArea = empleadoJefeArea;
	}

	public String getEmpleadoAsistenteSeleccion() {
		return empleadoAsistenteSeleccion;
	}

	public void setEmpleadoAsistenteSeleccion(String empleadoAsistenteSeleccion) {
		this.empleadoAsistenteSeleccion = empleadoAsistenteSeleccion;
	}

}
