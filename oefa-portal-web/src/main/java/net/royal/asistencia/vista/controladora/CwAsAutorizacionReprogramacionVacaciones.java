package net.royal.asistencia.vista.controladora;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
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

import org.primefaces.event.SelectEvent;

import net.royal.asistencia.vista.filtros.FwAsAutorizacionPreprocesoAprobacion;
import net.royal.asistencia.vista.opciones.OwAsAutorizacionPreprocesoAprobacion;
import net.royal.asistencia.vista.paginacion.PDwAsAutorizacionPreprocesoHextra;
import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CBindingController;
import net.royal.comun.vista.controladora.CComunSession;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAutorizacionPreprocesoHextra;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDddwAsConceptoaccesoSelectPre;
import net.royal.erp.asistencia.asoracle.dominio.dto.DtoDwAsEmpleadoSelectMultiple;
import net.royal.erp.asistencia.dominio.AsAccesosdiarios;
import net.royal.erp.asistencia.dominio.AsArea;
import net.royal.erp.asistencia.dominio.AsAutorizacion;
import net.royal.erp.asistencia.dominio.AsAutorizacionPk;
import net.royal.erp.asistencia.dominio.AsCarnetidentificacion;
import net.royal.erp.asistencia.dominio.AsConceptoacceso;
import net.royal.erp.asistencia.dominio.AsConceptoaccesoPk;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcion;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcionPk;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepciondetalle;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepciondetallePk;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcionsolicitud;
import net.royal.erp.asistencia.dominio.dto.DtoAsPeriodo;
import net.royal.erp.asistencia.dominio.dto.DtoFiltrosGenericos;
import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.contabilidad.dominio.AcSucursal;
import net.royal.erp.core.dominio.Companiamast;
import net.royal.erp.core.dominio.CompaniamastPk;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.core.dominio.Personamast;
import net.royal.erp.planilla.dominio.PrTipoplanilla;
import net.royal.erp.planilla.dominio.PrVacacionesprogramadas;
import net.royal.erp.rrhh.dominio.HrPuestoempresa;
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

@ManagedBean
@SessionScoped
public class CwAsAutorizacionReprogramacionVacaciones extends CBaseBean implements UIMantenimientoController {

	private Boolean visibleNuevo;
	private Boolean visibleModificar;
	private Boolean visibleEliminar;
	private Boolean visibleImprimir;
	private FwAsAutorizacionPreprocesoAprobacion dwFiltros;
	private List<DtoDwAsAutorizacionPreprocesoHextra> dw_2;
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

	private String motivoRechazo;
	private String empleadoNombre;
	private Integer secuencia;

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

	@Override
	public String iniciarControladora() throws Exception {

		isadmin = false;
		empleado = getUsuarioActual().getIdPersona();

		// Si es administrador puede aprobar sus propias papeletas
		if (getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm("AS",
				this.getUsuarioActual().getCodigoUsuario().toUpperCase())) {
			isadmin = true;
			empleado = 0;
		} else {
			Empleadomast emp = new Empleadomast();
			emp.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
			emp.getPk().setEmpleado(getUsuarioActual().getIdPersona());

			emp = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(emp.getPk());
			if (!UValidador.esNulo(emp)) {
				// verificamos si su area no tiene area superior
				AsArea area = new AsArea();
				area.getPk().setArea(emp.getDptoareaoperativa());

				area = (AsArea) getFacAsistencia().getAsAreaServicio().obtenerPorId(area.getPk());

				if (!UValidador.esNulo(area)) {
					// 1. si el empleado pertence a una area que no tiene
					// superior
					// puede procesar papeletas propias
					if (UValidador.esCero(area.getAreapadre()) && (empleado.equals(area.getEmpleadoresponsable())
							|| empleado.equals(area.getEmpleadoresponsable2())
							|| empleado.equals(area.getEmpleadoresponsable3())
							|| empleado.equals(area.getEmpleadoresponsable4()))) {
						empleado = 0; // codigo no valido
					}

					// 2. Si el empleado es aprobador o responsable puede
					// aprobar sus propias papeletas
					if (empleado.equals(area.getEmpleadoresponsable())
							|| empleado.equals(area.getEmpleadoresponsable2())
							|| empleado.equals(area.getEmpleadoresponsable3())
							|| empleado.equals(area.getEmpleadoresponsable4())
							|| empleado.equals(area.getEmpleadoaprobador())
							|| empleado.equals(area.getEmpleadoaprobador2())
							|| empleado.equals(area.getEmpleadoaprobador3())
							|| empleado.equals(area.getEmpleadoaprobador4())) {
						empleado = 0; // codigo no valido
					}
				}
			}

		}

		ismostrarDatosResponsable = false;

		indicerechazo = 0;

		verSeleccionados = true;
		datosgenerico = new DtoFiltrosGenericos();
		datosgenerico.setIsvarioscompania(false);
		datosgenerico.setIsvarioscentrocosto(false);
		datosgenerico.setIsvariosareaoperativa(false);
		datosgenerico.setIsvariospuesto(false);
		datosgenerico.setIsvariossucursal(false);
		datosgenerico.setIsvariostipoplanilla(false);

		opciones = new OwAsAutorizacionPreprocesoAprobacion();

		inicializarFiltrosListado();

		buscar();

		getWebControlContext().actualizar("frmAutorizaciones");

		opciones = new OwAsAutorizacionPreprocesoAprobacion();
		opciones.setIshabilitarnuevo(true);
		opciones.setIshabilitarmodificar(true);
		opciones.setIshabilitareliminar(true);

		// if (flagOrigenSolicitud.equals("A") && !isadmin) {
		//
		// // obtenemos las seguridad por opciones
		// SeguridadOperaciones seguridad =
		// leerSeguridadOperaciones(getUsuarioActual().getAplicacionCodigo(),
		// "GRUP02", "CON004", getUsuarioActual().getLoginUsuario());
		// opciones.setIshabilitarnuevo(seguridad.getIspuedeagregar());
		// opciones.setIshabilitarmodificar(seguridad.getIspuedemodificar());
		// opciones.setIshabilitareliminar(seguridad.getIspuedeeliminar());
		// }

		return "wasreprogramacionvacaciones";
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

		visibleNuevo = false;
		visibleEliminar = false;
		visibleModificar = true;
		visibleImprimir = false;

		String locacion;
		String flagfiltroperiodo = null;
		Integer sid;

		flagfiltroperiodo = dwFiltros.getIsperiodo() ? "S" : "F";
		dwFiltros.setEstado("A");

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

		List data = getFacAsistencia().getAS().getAsmainDatawindow().DwAsAutorizacionPreprocesoHextra(
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
						if (!(obj.getEstado().equals(dwFiltros.getEstado())
								&& !obj.getFlagreprogramado().equals("S"))) {
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

		getWebControlContext().actualizar("frmAutorizaciones:tblAutorizaciones");
		getWebControlContext().actualizar("frmAutorizaciones:grdBotones");

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
		return "w_as_autorizacion_preproceso_hextra_edit";
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
		CwAsAutorizacionReprogramacionVacacionesEdit.getInstance().mensaje(mensajeGenerico);

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
		Integer w_count = 0;
		CComunSession.getInstance().getSyroyal().StrGlobal().setGv_coming_from("Update");
		if (UValidador.esNulo(registroSeleccionado)) {
			setMessageError("Debe seleccionar un registro");
			return null;
		}

		w_count = getFacPlanilla().getPrVacacionesprogramadasServicio().contarVacacionesUtilizacion(
				registroSeleccionado.getEmpleado().intValue(), registroSeleccionado.getFecha(),
				registroSeleccionado.getFechafin());

		if (w_count > 0) {
			setMessageError(
					"No puede reprogramar la papeleta de vacaciones porque se encuentra ejecutada en el aplicativo de Planillas");
			return null;
		}

		long fecha1 = UFechaHora.obtenerTime(registroSeleccionado.getFecha(), "dd/MM/yyyy");
		long fecha2 = UFechaHora.obtenerTime(UFechaHora.obtenerPrimerDiaMesFecha(new Date()), "dd/MM/yyyy");
		long fecha3 = UFechaHora.obtenerTime(new Date(), "dd/MM/yyyy");

		if ("S".equals(getFacCore().getParametrosmastServicio()
				.obtenerValorCadena(new ParametrosmastPk("AS", "999999", "PROGMESACT")))) {
			if ("S".equals(getFacCore().getParametrosmastServicio()
					.obtenerValorCadena(new ParametrosmastPk("AS", "999999", "PROGTODMES")))) {

				if (fecha1 < fecha2) {
					setMessageError("La fecha de inicio de reprogramación debe ser apartir del mes actual");
					return null;
				}
			} else {
				if (fecha1 < fecha3) {
					setMessageError("La fecha de inicio de reprogramación debe ser mayor a la fecha actual.");
					return null;
				}
			}
		} else {
			if (registroSeleccionado.getFecha().before(new Date())
					|| ((registroSeleccionado.getFecha().getYear() <= new Date().getYear()
							&& registroSeleccionado.getFecha().getMonth() <= new Date().getMonth())
							|| (registroSeleccionado.getFecha().getYear() < new Date().getYear()
									&& registroSeleccionado.getFecha().getMonth() > new Date().getMonth()))) {
				setMessageError("La fecha de inicio de reprogramación debe ser posterior al mes actual.");
				return null;
			}
		}

		edicionAutorizacion();

		return "wasreprogramacionvacacionesedit";
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

		CComunSession.getInstance().getSyroyal().StrGlobal().setGv_coming_from("Delete");
		if (UValidador.esNulo(registroSeleccionado)) {
			setMessageError("Debe seleccionar un registro");
			return null;
		}
		edicionAutorizacion();
		return "w_as_autorizacion_preproceso_hextra_edit";
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

		if (UValidador.esCero(w_sel)) {
			setMessageError("Seleccionar autorización para Reprogramar");
			return null;
		}

		w_sel = 0;
		for (DtoDwAsAutorizacionPreprocesoHextra obj : lstAutorizacionPreProcesoAprobacion) {
			if (obj.getIsseleccionaprobado() || obj.getIsseleccionrechazado()) {
				w_sel += 1;
			}
		}

		if (UValidador.esCero(w_sel)) {
			setMessageError("Seleccionar autorización para Reprogramar");
			return null;
		}

		// cargamos el concepto acceso
		dw_conceptoacceso = getFacAsistencia().getAS().getAsmastDatawindow().DddwAsConceptoaccesoSelectPre("S",
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
					for (int i = 0; i < dw_conceptoacceso.size(); i++) {
						DtoDddwAsConceptoaccesoSelectPre objcon = dw_conceptoacceso.get(i);
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
		}

		Integer indicelocal = 0;
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
			indicelocal++;
		}

		LOGGER.debug("termino....");
		empleadoNombre = null;
		motivoRechazo = null;

		indicerechazo = 0;

		procesoAprobacion();

		getWebControlContext().ejecutar("PF('popMotivoRechazo').hide()");
		getWebControlContext().ejecutar("PF('popProcesarSeleccion').hide()");

		return null;
	}

	public void procesoAprobacion() throws Exception {
		Boolean w_resultado = false, w_aprobadorigualvisador;
		String w_estadosiguiente;
		String w_usuarioactual, ls_periodo, w_estado, w_periodoA;
		String w_Aprobar, w_Rechazar, w_usuarioseleccionado;
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
			if (w_Aprobar.equals("N") && w_Rechazar.equals("N")) {
				continue;
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

				if (w_Aprobar.equals("S") || w_Rechazar.equals("S")) {
					w_estado = obj.getEstado();

					if (w_estado.equals("S")) {
						if (w_Aprobar.equals("S")) {

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

									if (find.getFlagarchivo().equals("S")) {

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

							if (!UValidador.esNulo(objupd)) {
								objupd.setEstado(w_estadosiguiente);
								objupd.setAutorizadopor(w_usuarioactual);
								objupd.setFechaautorizacion(new Date());
								if (!w_aprobadorigualvisador) {
									objupd.setVisadopor(w_usuarioactual);
									objupd.setFechavisado(new Date());
								}
								objupd.setUltimoUsuario(w_usuarioactual);
								objupd.setUltimaFechaModif(new Date());

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
								objins.setTipoutilizacion("N");
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

							enviarCorreo("R", obj);

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
												getFacPlanilla().getPrVacacionesprogramadasServicio()
														.eliminar(vacprodel);
											}
										} else {
											setMessageError(
													"No puede rechazar la papeleta de vacaciones porque se encuentra ejecutada en el aplicativo de Planillas");
											iserror = true;
											continue;
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
					setMessageSuccess("Se procesó correctamente", true);
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

			if (tipodia.equals(14)) { /* Si es Día de Descanso */
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
			}

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

		if (getFacSeguridad().getSeguridadautorizacionesServicio()
				.tieneAccesoSysAdm(getUsuarioActual().getAplicacionCodigo(), getUsuarioActual().getCodigoUsuario())) {
			return null;
		}

		String jefe = null;
		String rol = null;
		String resultado = null;
		String proceso = null;
		String concepto = null;
		String mensajefecha = null;
		String mensaje = null;
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
		String mensajehoras = null;

		fechaini = UFechaHora.convertirFechaCadena(obj.getFecha(), "dd/MM/yyyy");
		fechater = UFechaHora.convertirFechaCadena(obj.getFechafin(), "dd/MM/yyyy");

		diasresta = UFechaHora.obtenerDiferenciaDias(obj.getFecha(), obj.getFechafin());

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
		concepto = obj.getConceptoaccesonombre();

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
					horarios.get(horarios.size() - 1).getPk().getFecha());
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

		if (UValidador.esCero(diasresta)) {
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

		// RECHAZO
		if (accion.equals("R")) {
			proceso = "Rechazo";
			resultado = "rechazó";
		}

		rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//proceso_asistencia.html");
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
		mensaje = mensaje.replace("[DIFERENCIA_DIAS]", UString
				.cambiarCaracteresEspecialesHTML(UValidador.esCero(diasresta) ? "" : " Días: " + (diasresta + 1)));

		// ENVIO
		Boolean isconfiguradocorreo = getFacSeguridad().getCorreoServicio().configurarCorreo();

		if (isconfiguradocorreo) {
			CorreoCore correo = new CorreoCore();
			correo.setListaCorreoDestino(destinos);
			correo.setAsunto(proceso + " de Asistencia");
			correo.setCuerpoCorreo(mensaje.getBytes());

			// getFacSeguridad().getCorreoServicio().enviarCorreo(correo);
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
		return "wasautorizacionpreprocesoaprobacion";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String inicializarFiltrosListado() throws Exception {
		// TODO Auto-generated method stub
		dwFiltros = new FwAsAutorizacionPreprocesoAprobacion();
		dwFiltros.setAlllocation("S");
		dwFiltros.setFechas(3); // Mostrar opcion Fecha

		dwFiltros.setIscesados(false);
		dwFiltros.setIsinactivos(false);
		dwFiltros.setFechadesde(UFechaHora.obtenerFechaHoraInicioDia(new Date()));
		dwFiltros.setFechaHasta(UFechaHora.obtenerFechaHoraFinDia(new Date()));
		dwFiltros.setPeriodo("" + UFechaHora.obtenerFechaParte(new Date(), "YY") + ""
				+ ((UFechaHora.obtenerFechaParte(new Date(), "MM")) < 10
						? "0" + UFechaHora.obtenerFechaParte(new Date(), "MM")
						: UFechaHora.obtenerFechaParte(new Date(), "MM")));
		dwFiltros.setEstado("A");

		Integer periodo = getFacAsistencia().getAsPeriodoServicio().obtenerMaximoPeriodoPlanilla();

		if (!UValidador.esNulo(periodo) && !UValidador.esCero(periodo)) {
			dwFiltros.setPeriodo(periodo.toString().substring(0, 6));
		}

		// Boolean isadmin =
		// getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
		// getUsuarioActual().getAplicacionCodigo(),
		// getUsuarioActual().getLoginUsuario().toUpperCase());
		// // Boolean isadmin = false;
		// List data =
		// getFacAsistencia().getAS().getAsmainFuncion().FAsFechasactivasPeriodo(periodo.toString(),
		// isadmin ? "S" : "N");
		//
		// if (!UValidador.esListaVacia(data)) {
		// dwFiltros.setFechadesde((Date) data.get(0));
		// dwFiltros.setFechaHasta((Date) data.get(1));
		// }

		dwFiltros.setIstodos(true);
		dwFiltros.setIsperiodo(false);
		dwFiltros.setIsfecha(false);

		dwFiltros.setAlltipoplanilla("S");
		dwFiltros.setEstado("T");

		// conceptos accesos
		dw_conceptoaccesofiltro = getFacAsistencia().getAsConceptoaccesoServicio()
				.obtenerConceptosAccesos(getUsuarioActual().getCodigoUsuario(), isadmin ? "S" : "N");
		datosgenerico.setConceptoacceso("VACA");

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

		if (!isadmin && !isaprobador) {
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

	public static CwAsAutorizacionReprogramacionVacaciones getInstance() {
		return UFaces.evaluateExpressionGet("#{cwAsAutorizacionReprogramacionVacaciones}",
				CwAsAutorizacionReprogramacionVacaciones.class);
	}

	public void limpiezaEmpleado() {

		verSeleccionados = true;
		datosgenerico.setEmpleado(null);
		datosgenerico.setCodEmpleado(null);
		datosgenerico.setNombreCompleto(null);
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

}
