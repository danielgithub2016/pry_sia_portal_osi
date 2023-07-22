package net.royal.planilla.vista.controladora;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDwPrEmpleadoSelect;
import net.royal.erp.asistencia.dominio.dto.DtoFiltrosGenericos;
import net.royal.erp.asistencia.sylock.dominio.dto.DtoDwMaCompanyownerSelect;
import net.royal.erp.contabilidad.dominio.AcSucursal;
import net.royal.erp.contabilidad.dominio.dto.DtoAcCostcentermst;
import net.royal.erp.core.dominio.Companyowner;
import net.royal.erp.core.dominio.dto.DtoCompaniamast;
import net.royal.erp.planilla.dominio.PrTipoplanilla;
import net.royal.erp.planilla.dominio.dto.DtoDwPrVacacionesProgramadas;
import net.royal.erp.planilla.dominio.dto.DtoDwPrVacacionesProgramadasExt;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

/**
 * The Class CwPrVacacionesReporte.
 */
@SessionScoped
@ManagedBean
public class CwPrVacacionesReporte extends CBaseBean implements
		UIMantenimientoController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DtoFiltrosGenericos filtro;
	private List<DtoDwMaCompanyownerSelect> filtrocompanias;
	private List<PrTipoplanilla> filtrotipoplanillas;
	private List<DtoAcCostcentermst> filtrocentrocostos;
	private List<AcSucursal> filtrosucursales;

	// reportes
	private List<DtoDwPrVacacionesProgramadas> dwprogramadas;
	private List<DtoDwPrVacacionesProgramadasExt> dwprogramadas2;
	private StreamedContent reporteStreamProgramada;
	private StreamedContent reporteStreamUtilizacion;
	private StreamedContent reporteStreamResumen;
	private StreamedContent reporteStreamPendiente;

	private String tiporeporte;

	public CwPrVacacionesReporte() {
		this.PANTALLA_LISTADO = "wprvacacionesreporte";
	}

	public static CwPrVacacionesReporte getInstance() {
		return UFaces.evaluateExpressionGet("#{cwPrVacacionesReporte}",
				CwPrVacacionesReporte.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		this.inicializarFiltrosListado();
		return this.PANTALLA_LISTADO;
	}

	@Override
	public String buscar() throws Exception {
		if (UValidador.estaVacio(filtro.getCodCentroCosto()))
			filtro.setCodCentroCosto(null);
		if (UValidador.estaVacio(filtro.getCodCompania()))
			filtro.setCodCompania(null);
		if (UValidador.estaVacio(filtro.getEmpleado()))
			filtro.setEmpleado(null);
		if (UValidador.estaVacio(filtro.getCodSucursal()))
			filtro.setCodSucursal(null);
		if (UValidador.estaVacio(filtro.getCodPlantilla()))
			filtro.setCodPlantilla(null);
		
		if ("RES".equals(tiporeporte)) {

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("centrocosto", filtro.getCodCentroCosto());
			param.put("compania", filtro.getCodCompania());
			param.put("empleado",
					UValidador.esNulo(filtro.getEmpleado()) ? null : filtro
							.getEmpleado().intValue());
			param.put("sucursal", filtro.getCodSucursal());
			param.put("tipoplanilla", filtro.getCodPlantilla());
			param.put("afe", null);

			cargarReporteLista(param,
					"dw_pr_vacaciones_resumen_reporte.jasper", null);
				
		} else if ("PEN".equals(tiporeporte)) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("centrocosto", filtro.getCodCentroCosto());
			param.put("compania", filtro.getCodCompania());
			param.put("empleado",
					UValidador.esNulo(filtro.getEmpleado()) ? null : filtro
							.getEmpleado().intValue());
			param.put("sucursal", filtro.getCodSucursal());
			param.put("tipoplanilla", filtro.getCodPlantilla());
			param.put("afe", null);
			cargarReporteLista(param,
					"dw_pr_vacaciones_resumenxperiodo_reporte.jasper", null);
			
		}	else if ("UTI".equals(tiporeporte)) {
			
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("fechadesde", filtro.getFechadesde());
				param.put("fechahasta", filtro.getFechahasta());
				param.put("centrocosto", filtro.getCodCentroCosto());
				param.put("compania", filtro.getCodCompania());
				param.put("empleado",
						UValidador.esNulo(filtro.getEmpleado()) ? null : filtro
								.getEmpleado().intValue());
				param.put("sucursal", filtro.getCodSucursal());
				param.put("tipoplanilla", filtro.getCodPlantilla());
				param.put("afe", null);

				cargarReporteLista(param,
						"dw_pr_vacaciones_utilizacion.jasper", null);

		}
		return null;
	}

	/**
	 * Preparar reporte programadas.
	 * 
	 * @throws Exception
	 *
	 * @powerbuilder wf_prepare_reporte2
	 * 
	 */
	private void prepararReporteProgramadas() throws Exception {
		dwprogramadas = this
				.getFacPlanilla()
				.getPrVacacionesprogramadasServicio()
				.listarReporteProgramadas(
						filtro.getEstado(),
						filtro.getAno(),
						UValidador.esNulo(filtro.getEmpleado()) ? null : filtro
								.getEmpleado().intValue(),
						filtro.getCodCompania(), filtro.getCodPlantilla());
		dwprogramadas2 = new ArrayList<DtoDwPrVacacionesProgramadasExt>();

		for (DtoDwPrVacacionesProgramadas p : dwprogramadas) {
			if ("N".equals(p.getTipoutilizacion())) {
				DtoDwPrVacacionesProgramadasExt p2 = new DtoDwPrVacacionesProgramadasExt();
				p2.setEmpleado(p.getEmpleado());
				p2.setNombrecompleto(p.getNombre());
				p2.setCargo(p.getCargo());
				p2.setFechaingreso(p.getFechaingreso());
				p2.setFecharecalculada(p.getFecharecalculada());
				p2.setNrocarga(p.getNrocarga());
				p2.setFechainicio(p.getFechainicio());
				p2.setFechafin(p.getFechafin());
				p2.setTipoplanilla(p.getTipoplanilla());
				dwprogramadas2.add(p2);
			}
		}

		for (DtoDwPrVacacionesProgramadas p : dwprogramadas) {
			boolean encontroempleado = false;
			if ("P".equals(p.getTipoutilizacion())) {

				for (DtoDwPrVacacionesProgramadasExt p2 : dwprogramadas2) {
					if (p.getEmpleado() == p2.getEmpleado()) {
						encontroempleado = true;
						p2.setEmpleado(p.getEmpleado());
						p2.setNombrecompleto(p.getNombre());
						p2.setCargo(p.getCargo());
						p2.setFechaingreso(p.getFechaingreso());
						p2.setFecharecalculada(p.getFecharecalculada());
						p2.setNrocarga(p.getNrocarga());
						p2.setFechainicio(p.getFechainicio());
						p2.setFechafin(p.getFechafin());
						p2.setTipoplanilla(p.getTipoplanilla());
						break;
					}
				}

				if (!encontroempleado) {
					DtoDwPrVacacionesProgramadasExt p2 = new DtoDwPrVacacionesProgramadasExt();
					p2.setEmpleado(p.getEmpleado());
					p2.setNombrecompleto(p.getNombre());
					p2.setCargo(p.getCargo());
					p2.setFechaingreso(p.getFechaingreso());
					p2.setFecharecalculada(p.getFecharecalculada());
					p2.setNrocarga(p.getNrocarga());
					p2.setFechainicio(p.getFechainicio());
					p2.setFechafin(p.getFechafin());
					p2.setTipoplanilla(p.getTipoplanilla());
					dwprogramadas2.add(p2);
				}

			}
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("USUARIO", this.getUsuarioActual().getCodigoUsuario());
		param.put("IP", this.getUsuarioActual().getIpAddressLogin());
		cargarReporteLista(param, "dw_pr_vacaciones_programadas_ext.jasper",
				dwprogramadas2);

		LOGGER.debug(dwprogramadas2);
	}

	/**
	 * Cargar reporte lista.
	 *
	 * @param <T>
	 *            the generic type
	 * @param parametros
	 *            the parametros
	 * @param nombrereporte
	 *            the nombrereporte
	 * @param lista
	 *            the lista
	 * @throws Exception
	 *             the exception
	 */
	private <T> void cargarReporteLista(Map<String, Object> parametros,
			String nombrereporte, List<T> lista) throws Exception {
		byte[] pdf = null;

		LOGGER.debug(parametros);

		String pathPrincipal = ((ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext())
				.getRealPath("/");
		File archivo = new File(pathPrincipal + File.separator + "erp"
				+ File.separator + "planilla" + File.separator + "recursos"
				+ File.separator + File.separator + "reportes" + File.separator
				+ "reporte_vacaciones" + File.separator + nombrereporte);

		if (!UValidador.esNulo(lista)) {
			pdf = getFacAsistencia().getAsAutorizacionServicio()
					.ejecutarReporteComoPDFDesdeLista(archivo.getPath(),
							parametros, lista);
		} else {
			pdf = getFacAsistencia().getAsAutorizacionServicio()
					.ejecutarReporteComoPDF(archivo.getPath(), parametros);
		}

		if ("RES".equals(tiporeporte)) {
			reporteStreamResumen = new DefaultStreamedContent(
					new ByteArrayInputStream(pdf), "application/pdf");
		} else if ("UTI".equals(tiporeporte)) {
			reporteStreamUtilizacion = new DefaultStreamedContent(
					new ByteArrayInputStream(pdf), "application/pdf");
		} else if ("PEN".equals(tiporeporte)) {
			reporteStreamPendiente = new DefaultStreamedContent(
					new ByteArrayInputStream(pdf), "application/pdf");
		}

	}

	/**
	 * On tab change.
	 *
	 * @param event
	 *            the event
	 */
	public void onTabChange(TabChangeEvent event) {
		LOGGER.debug(event.getTab().getId());
		tiporeporte = event.getTab().getId();
	}

	@Override
	public String nuevo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editar() throws Exception {
		// TODO Auto-generated method stub
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

	@Override
	public String guardar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean validar() throws Exception {
		boolean valida = false;
		
		if(UValidador.estaVacio(filtro.getFechadesde())){
			valida=true;
			this.setMessageError("Fecha Desde");
		}		
		if(UValidador.estaVacio(filtro.getFechahasta())){
			valida=true;
			this.setMessageError("Fecha Hasta");
		}		
		
		
		return valida;
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
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico)
			throws Exception {
		LOGGER.debug("Mensaje");
		if (mensajeControllerGenerico.getParametros()
				.get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarPrEmpleado")) {
			DtoDwPrEmpleadoSelect obj = (DtoDwPrEmpleadoSelect) mensajeControllerGenerico
					.getParametros().get("prempleado");
			LOGGER.debug(obj);
			filtro.setEmpleado(obj.getEmpleado());
			filtro.setNombreCompleto(obj.getNombrecompleto());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String inicializarFiltrosListado() throws Exception {
		filtro = new DtoFiltrosGenericos();

		LOGGER.debug(this.getUsuarioActual().getCompaniaSocioCodigo());
						
		filtrocompanias = this.getFacCore().
				getCompanyownerServicio().DwMaCompanyownerSelect(this.getUsuarioActual().getCompaniaSocioCodigo());

		filtrotipoplanillas = this
				.getFacPlanilla()
				.getPrTipoplanillaServicio()
				.listaTipoPlanillaSeguridad(UValidador.validarFlagLogico(true),
						new String[] {});

		filtrocentrocostos = this.getFacContabilidad()
				.getAcCostcentermstServicio().listaPorPlanillaTipo("C");

		filtrosucursales = this
				.getFacContabilidad()
				.getAcSucursalServicio()
				.listarSucursalSeguridad(UValidador.validarFlagLogico(true),
						new String[] {});

		tiporeporte = "RES";
		filtro.setEmpleado(new BigDecimal(this.getUsuarioActual().getIdPersona()));
		filtro.setNombreCompleto(this.getUsuarioActual().getNombreCompleto());
		filtro.setFechadesde(new Date());
		filtro.setFechahasta(new Date());
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public DtoFiltrosGenericos getFiltro() {
		return filtro;
	}

	public void setFiltro(DtoFiltrosGenericos filtro) {
		this.filtro = filtro;
	}

	public List<DtoDwMaCompanyownerSelect> getFiltrocompanias() {
		return filtrocompanias;
	}

	public void setFiltrocompanias(List<DtoDwMaCompanyownerSelect> filtrocompanias) {
		this.filtrocompanias = filtrocompanias;
	}

	public List<PrTipoplanilla> getFiltrotipoplanillas() {
		return filtrotipoplanillas;
	}

	public void setFiltrotipoplanillas(List<PrTipoplanilla> filtrotipoplanillas) {
		this.filtrotipoplanillas = filtrotipoplanillas;
	}

	public List<DtoAcCostcentermst> getFiltrocentrocostos() {
		return filtrocentrocostos;
	}

	public void setFiltrocentrocostos(
			List<DtoAcCostcentermst> filtrocentrocostos) {
		this.filtrocentrocostos = filtrocentrocostos;
	}

	public List<AcSucursal> getFiltrosucursales() {
		return filtrosucursales;
	}

	public void setFiltrosucursales(List<AcSucursal> filtrosucursales) {
		this.filtrosucursales = filtrosucursales;
	}

	public StreamedContent getReporteStreamProgramada() {
		return reporteStreamProgramada;
	}

	public void setReporteStreamProgramada(
			StreamedContent reporteStreamProgramada) {
		this.reporteStreamProgramada = reporteStreamProgramada;
	}

	public StreamedContent getReporteStreamResumen() {
		return reporteStreamResumen;
	}

	public void setReporteStreamResumen(StreamedContent reporteStreamResumen) {
		this.reporteStreamResumen = reporteStreamResumen;
	}

	public StreamedContent getReporteStreamPendiente() {
		return reporteStreamPendiente;
	}

	public void setReporteStreamPendiente(StreamedContent reporteStreamPendiente) {
		this.reporteStreamPendiente = reporteStreamPendiente;
	}

	public StreamedContent getReporteStreamUtilizacion() {
		return reporteStreamUtilizacion;
	}

	public void setReporteStreamUtilizacion(StreamedContent reporteStreamUtilizacion) {
		this.reporteStreamUtilizacion = reporteStreamUtilizacion;
	}
	
	

}
