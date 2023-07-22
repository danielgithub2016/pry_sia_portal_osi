package net.royal.asistencia.vista.controladora;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.ServletContext;

import net.royal.asistencia.vista.filtros.FwAsAutorizacionPreprocesoAprobacion;
import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CBindingController;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAutorizacionPreprocesoHextra;
import net.royal.erp.asistencia.asoracle.dominio.dto.DtoDwAsEmpleadoSelectMultiple;
import net.royal.erp.asistencia.dominio.dto.DtoAsPeriodo;
import net.royal.erp.asistencia.dominio.dto.DtoFiltrosGenericos;
import net.royal.erp.core.dominio.Companiamast;
import net.royal.erp.core.dominio.CompaniamastPk;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

@SessionScoped
@ManagedBean
public class CwReporteSaldoFeriado extends CBaseBean implements UIMantenimientoController {

	private FwAsAutorizacionPreprocesoAprobacion dwFiltros;
	private List<DtoDwAsAutorizacionPreprocesoHextra> dw_2;
	private List<DtoFiltrosGenericos> registroSeleccionadoExterno;
	private DtoFiltrosGenericos datosgenerico;
	private DtoFiltrosGenericos datosgenericoMultple;
	private Boolean verSeleccionados;
	// private List<DtoDddwAsConceptoaccesoSelectPre> dw_conceptoaccesofiltro;

	private static final long serialVersionUID = 1L;
	private String tipo;
	private Boolean ismostrarDatosResponsable;
	private String nombreArchivoPDF;
	private String tipoReporte;

	private Companiamast compania;

	public CwReporteSaldoFeriado() {
		this.PANTALLA_LISTADO = "w_as_reporte_saldo_feriado";
	}

	@Override
	public String iniciarControladora() throws Exception {
		ismostrarDatosResponsable = false;

		String comp = "";

		if (!UValidador.esNulo(this.getUsuarioActual().getCompaniaSocioCodigo())) {
			if (this.getUsuarioActual().getCompaniaSocioCodigo().length() > 6) {
				comp = this.getUsuarioActual().getCompaniaSocioCodigo().substring(0, 6);
			}
		}

		compania = (Companiamast) this.getFacCore().getCompaniamastServicio().obtenerPorId(new CompaniamastPk(comp));

		verSeleccionados = true;
		datosgenerico = new DtoFiltrosGenericos();
		datosgenerico.setIsvarioscompania(false);
		datosgenerico.setIsvarioscentrocosto(false);

		datosgenerico.setCodEmpleado(getUsuarioActual().getIdPersona().toString());
		datosgenerico.setNombreCompleto(getUsuarioActual().getNombreCompleto());

		datosgenerico.setIsvariosareaoperativa(false);
		datosgenerico.setIsvariospuesto(false);
		datosgenerico.setIsvariossucursal(false);
		datosgenerico.setIsvariostipoplanilla(false);
		inicializarFiltrosListado();
		buscar();
		return this.PANTALLA_LISTADO;
	}

	public static CwReporteSaldoFeriado getInstance() {
		return UFaces.evaluateExpressionGet("#{cwReporteSaldoFeriado}", CwReporteSaldoFeriado.class);
	}

	public String listarPopGenericos() throws Exception {
		LOGGER.debug("Entrando a listarPopGenericos");
		CUFiltros.getInstance().setTipo(tipo);
		return CUFiltros.getInstance().iniciarControladora();
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

	public void limpiezaEmpleado() {

		verSeleccionados = true;
		datosgenerico.setEmpleado(null);
		datosgenerico.setCodEmpleado(null);
		datosgenerico.setNombreCompleto(null);
	}

	public void cambiaropcionFecha(ValueChangeEvent event) {
		dwFiltros.setFechas((Integer) event.getNewValue());
		LOGGER.debug(dwFiltros.getFechas());

		dwFiltros.setIsperiodo(false);
		dwFiltros.setIsfecha(false);

		if (dwFiltros.getFechas().equals(1)) {// periodo
			dwFiltros.setIsperiodo(true);
		}
		if (dwFiltros.getFechas().equals(2)) {// fechas
			dwFiltros.setIsfecha(true);
		}
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

	private void obtenerEmpleadosSeleccionados(Date p_fecha_desde, Date p_fecha_hasta, String p_flag_periodo,
			Integer p_sid, String p_seleccionadosAdicionados) {
		datosgenericoMultple = new DtoFiltrosGenericos();

		List<DtoFiltrosGenericos> dtoEmpleado = this.getFacAsistencia().getAsAsistenciadiariaServicio()
				.obtenerEmpleadosSeleccionados(p_fecha_desde, p_fecha_hasta, p_flag_periodo, p_sid,
						p_seleccionadosAdicionados);

		if (dtoEmpleado.size() == 1) {
			datosgenericoMultple.setCodEmpleadoMUltiple(dtoEmpleado.get(0).getEmpleado() + "");
			datosgenericoMultple.setCentroCostoMultiple(dtoEmpleado.get(0).getCodCentroCosto() + "");
		} else if (dtoEmpleado.size() > 1) {
			for (DtoFiltrosGenericos obj : dtoEmpleado) {
				if (UValidador.estaVacio(datosgenericoMultple.getCodEmpleadoMUltiple())) {
					datosgenericoMultple.setCodEmpleadoMUltiple(obj.getEmpleado().intValue() + "");
					datosgenericoMultple.setCentroCostoMultiple(obj.getCodCentroCosto() + "");
				} else {
					datosgenericoMultple.setCodEmpleadoMUltiple(
							datosgenericoMultple.getCodEmpleadoMUltiple() + "," + obj.getEmpleado().intValue());
					datosgenericoMultple.setCentroCostoMultiple(
							datosgenericoMultple.getCentroCostoMultiple() + "," + obj.getCodCentroCosto());
				}
			}
		}
	}

	@Override
	public String buscar() throws Exception {
		String flagfiltroperiodo = null;
		Integer sid;

		flagfiltroperiodo = dwFiltros.getIsperiodo() ? "S" : "N";

		HashMap<String, Object> parametros = new HashMap<String, Object>();

		DtoFiltrosGenericos filtroPrep = obtenerFiltroPreparado(datosgenerico);
		String parametrosAdicionales = "";
		String p_adicionalesFeriados = "";

		if (!UValidador.estaVacio(filtroPrep.getCodCompania())) {
			parametrosAdicionales = parametrosAdicionales + "  AND EmpleadoMast.CompaniaSocio IN  ("
					+ filtroPrep.getCodCompania() + ")";
		}

		if (!UValidador.estaVacio(filtroPrep.getCodPlantilla())) { // tipoplanilla
			parametrosAdicionales = parametrosAdicionales + " and EmpleadoMast.TIPOPLANILLA IN ("
					+ filtroPrep.getCodPlantilla() + ")";
		}

		if (!UValidador.estaVacio(filtroPrep.getCodPuesto())) {
			parametrosAdicionales = parametrosAdicionales + " AND EmpleadoMast.CodigoCargo IN("
					+ filtroPrep.getCodPuesto() + ")";
		}

		if (!UValidador.estaVacio(filtroPrep.getCodSucursal())) {
			parametrosAdicionales = parametrosAdicionales + " AND  EmpleadoMast.sucursal IN ("
					+ filtroPrep.getCodSucursal() + ")";
		}

		if (!UValidador.estaVacio(filtroPrep.getCodAreaOperativa())) {
			parametrosAdicionales = parametrosAdicionales + "  AND as_carnetidentificacion.area IN  ("
					+ filtroPrep.getCodAreaOperativa() + ")";
		}

		if (!UValidador.estaVacio(datosgenerico.getCodEmpleado())) {

			parametrosAdicionales = parametrosAdicionales + "  AND EmpleadoMast.empleado IN ("
					+ datosgenerico.getCodEmpleado() + ")";

		}

		if (!UValidador.estaVacio(datosgenerico.getCodCentroCosto())) {

			parametrosAdicionales = parametrosAdicionales + "  AND EmpleadoMast.CENTROCOSTOS IN ("
					+ datosgenerico.getCodCentroCosto() + ")";

		}

		if (!dwFiltros.getIscesados()) {
			parametrosAdicionales = parametrosAdicionales + "  AND EmpleadoMast.estadoempleado <> 2 ";
		}

		p_adicionalesFeriados = parametrosAdicionales;

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

		Date fechaReportes_desde = new SimpleDateFormat("yyyyMMdd").parse("19000101");
		Date fechaReportes_hasta = new SimpleDateFormat("yyyyMMdd").parse("19000101");

		flagfiltroperiodo = "N";

		if (dwFiltros.getFechas().equals(1)) {// periodo
			dwFiltros.setIsperiodo(true);
			flagfiltroperiodo = "P";
			List fechas = getFacAsistencia().getAsPeriodoServicio().obtenerRangoFechas(dwFiltros.getPeriodo());
			if (!UValidador.esListaVacia(fechas)) {
				dwFiltros.setFechadesde(
						UFechaHora.obtenerFechaHoraInicioDia(((DtoAsPeriodo) fechas.get(0)).getFechadesde()));
				dwFiltros.setFechaHasta(
						UFechaHora.obtenerFechaHoraFinDia(((DtoAsPeriodo) fechas.get(0)).getFechahasta()));

				if (!UValidador.esNulo(dwFiltros.getFechadesde()) && !UValidador.esNulo(dwFiltros.getFechaHasta())) {
					fechaReportes_desde = dwFiltros.getFechadesde();
					fechaReportes_hasta = dwFiltros.getFechaHasta();
				}
			}
		}
		if (dwFiltros.getFechas().equals(2)) {// fechas
			flagfiltroperiodo = "F";
			fechaReportes_desde = dwFiltros.getFechadesde();
			fechaReportes_hasta = dwFiltros.getFechaHasta();
		}

		// meses a compensar
		Integer mesescompensar = getFacCore().getParametrosmastServicio()
				.obtenerValorInteger(new ParametrosmastPk("AS", "999999", "NDIACOMPLV"));
		mesescompensar = mesescompensar * -1;

		String pathPrincipal;
		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
				.getRealPath("/");
		String rutaLogo = pathPrincipal + "/comun/recursos/imagenes/sistema/oefa-logo-header.png";

		Map<String, Object> parametrosReport = new HashMap<String, Object>();
		parametrosReport.put("p_fecha_desde", fechaReportes_desde);
		parametrosReport.put("p_fecha_hasta", fechaReportes_hasta);
		parametrosReport.put("p_sid", new BigDecimal(sid));
		parametrosReport.put("p_FlagFiltroPeriodo", flagfiltroperiodo);
		parametrosReport.put("p_mesesacompensar", mesescompensar);
		parametrosReport.put("Logo", rutaLogo);
		parametrosReport.put("p_companianombre", compania.getDescripcioncorta());
		parametrosReport.put("p_companiaruc", compania.getDocumentofiscal());

		java.util.Locale locale = new Locale("es", "ES");
		parametrosReport.put("REPORT_LOCALE", locale);

		File archivo = null;
		if (tipoReporte.equals("feriados")) {
			if (!UValidador.estaVacio(parametrosAdicionales)) {
				parametrosReport.put("p_adicionales", parametrosAdicionales);

				// OBTENER LOS TOTALES PARA ENVIARLOS AL IREPORT
				obtenerEmpleadosSeleccionados(dwFiltros.getFechadesde(), dwFiltros.getFechaHasta(), flagfiltroperiodo,
						sid, parametrosAdicionales);

				List datos = new ArrayList<>();
				datos = getFacAsistencia().getAS().getAsmainDatawindow().obtenerResultadosFinales(flagfiltroperiodo,
						dwFiltros.getFechadesde(), dwFiltros.getFechaHasta(),
						datosgenericoMultple.getCodEmpleadoMUltiple(), datosgenericoMultple.getCentroCostoMultiple());

				if (!UValidador.esNulo(datos)) {
					parametrosReport.put("p_postivos", UValidador.esNulo(datos.get(0)) ? "00:00" : datos.get(0));
					parametrosReport.put("p_negativos", UValidador.esNulo(datos.get(1)) ? "00:00" : datos.get(1));
					parametrosReport.put("p_balance", UValidador.esNulo(datos.get(2)) ? "00:00" : datos.get(2));
				}
			}

			archivo = new File(pathPrincipal + File.separator + "erp" + File.separator + "asistencia" + File.separator
					+ File.separator + "recursos" + File.separator + File.separator + "reportes" + File.separator
					+ File.separator + "reporte_asistencia" + File.separator + File.separator + "SaldoFeriado"
					+ File.separator + File.separator + "w_as_rep_saldo_feriado.jasper");

		} else {
			if (!UValidador.estaVacio(p_adicionalesFeriados)) {
				parametrosReport.put("p_adicionalesFeriados", p_adicionalesFeriados);
			}

			archivo = new File(pathPrincipal + File.separator + "erp" + File.separator + "asistencia" + File.separator
					+ File.separator + "recursos" + File.separator + File.separator + "reportes" + File.separator
					+ File.separator + "reporte_asistencia" + File.separator + File.separator + "BalanceCompensacion"
					+ File.separator + File.separator + "w_as_aistencia_balance_compensacion.jasper");
		}

		nombreArchivoPDF = getFacRrhh().getHrEmpleadoasistenciasServicio().ejecutarReporteIReport(archivo.getPath(),
				parametrosReport);

		CBindingController.getInstance().setNombreArchivoTemporal(nombreArchivoPDF);

		System.gc();
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

				datosgenerico.setCentroCosto(dtoEmpleado.get(0).getCentrocosto() + "");
				verSeleccionados = true;
			} else if (dtoEmpleado.size() > 1) {
				for (DtoDwAsEmpleadoSelectMultiple obj : dtoEmpleado) {
					if (UValidador.estaVacio(datosgenerico.getCodEmpleado())) {
						datosgenerico.setCodEmpleado(obj.getPersona().intValue() + "");
						datosgenerico.setCentroCosto(obj.getCentrocosto() + "");
					} else {
						datosgenerico
								.setCodEmpleado(datosgenerico.getCodEmpleado() + "," + obj.getPersona().intValue());
						datosgenerico.setCentroCosto(datosgenerico.getCentroCosto() + "," + obj.getCentrocosto());
					}
				}
				verSeleccionados = false;
			}
		}
		return "w_as_reporte_saldo_feriado";
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		dwFiltros = new FwAsAutorizacionPreprocesoAprobacion();
		dwFiltros.setAlllocation("S");
		dwFiltros.setFechas(2); // Mostrar opcion Fecha
		dwFiltros.setIscesados(false);
		dwFiltros.setIsinactivos(false);

		Integer mesescompensar = getFacCore().getParametrosmastServicio()
				.obtenerValorInteger(new ParametrosmastPk("AS", "999999", "NDIACOMPLV"));

		dwFiltros.setFechadesde(
				UFechaHora.obtenerFechaHoraInicioDia(UFechaHora.obtenerFechaMasMeses(new Date(), -mesescompensar)));
		dwFiltros.setFechaHasta(UFechaHora.obtenerFechaHoraFinDia(new Date()));

		Integer periodo = getFacAsistencia().getAsPeriodoServicio().obtenerMaximoPeriodoPlanilla();

		if (!UValidador.esNulo(periodo) && !UValidador.esCero(periodo)) {
			dwFiltros.setPeriodo(periodo.toString().substring(0, 6));
		}

		Boolean isadmin = getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
				getUsuarioActual().getAplicacionCodigo(), getUsuarioActual().getLoginUsuario().toUpperCase());
		List data = getFacAsistencia().getAS().getAsmainFuncion().FAsFechasactivasPeriodo(periodo.toString(),
				isadmin ? "S" : "N");

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
		// dw_conceptoaccesofiltro =
		// getFacAsistencia().getAsConceptoaccesoServicio()
		// .obtenerConceptosAccesos(getUsuarioActual().getCodigoUsuario(),
		// isadmin ? "S" : "N");

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

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		return null;
	}

	public FwAsAutorizacionPreprocesoAprobacion getDwFiltros() {
		return dwFiltros;
	}

	public void setDwFiltros(FwAsAutorizacionPreprocesoAprobacion dwFiltros) {
		this.dwFiltros = dwFiltros;
	}

	public DtoFiltrosGenericos getDatosgenerico() {
		return datosgenerico;
	}

	public void setDatosgenerico(DtoFiltrosGenericos datosgenerico) {
		this.datosgenerico = datosgenerico;
	}

	public Boolean getVerSeleccionados() {
		return verSeleccionados;
	}

	public void setVerSeleccionados(Boolean verSeleccionados) {
		this.verSeleccionados = verSeleccionados;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	// public List<DtoDddwAsConceptoaccesoSelectPre>
	// getDw_conceptoaccesofiltro() {
	// return dw_conceptoaccesofiltro;
	// }
	//
	// public void
	// setDw_conceptoaccesofiltro(List<DtoDddwAsConceptoaccesoSelectPre>
	// dw_conceptoaccesofiltro) {
	// this.dw_conceptoaccesofiltro = dw_conceptoaccesofiltro;
	// }

	public Boolean getIsmostrarDatosResponsable() {
		return ismostrarDatosResponsable;
	}

	public void setIsmostrarDatosResponsable(Boolean ismostrarDatosResponsable) {
		this.ismostrarDatosResponsable = ismostrarDatosResponsable;
	}

	public List<DtoFiltrosGenericos> getRegistroSeleccionadoExterno() {
		return registroSeleccionadoExterno;
	}

	public void setRegistroSeleccionadoExterno(List<DtoFiltrosGenericos> registroSeleccionadoExterno) {
		this.registroSeleccionadoExterno = registroSeleccionadoExterno;
	}

	public String getTipoReporte() {
		return tipoReporte;
	}

	public void setTipoReporte(String tipoReporte) {
		this.tipoReporte = tipoReporte;
	}

}
