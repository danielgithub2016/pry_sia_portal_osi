package net.royal.planilla.vista.controladora;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
import javax.servlet.ServletContext;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.core.dominio.Personamast;
import net.royal.erp.planilla.dominio.PrProcesoperiodo;
import net.royal.erp.planilla.dominio.PrTipoplanilla;
import net.royal.erp.planilla.dominio.dto.DtoConsultaBoletasEmpleado;
import net.royal.erp.planilla.dominio.dto.DtoConsultaBoletasEmpleadoEncabezado;
import net.royal.erp.planilla.dominio.dto.DtoDetalleBoleta;
import net.royal.erp.planilla.dominio.dto.DtoProcesoXPlanillaPeriodo;
import net.royal.erp.planilla.dominio.dto.DtoVacacionBoleta;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.sf.jasperreports.engine.JRParameter;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 * 
 * @author CruzadoJ
 * 
 * */
@ManagedBean
@SessionScoped
@SuppressWarnings("serial")
public class CConsultaBoletasEmpleado extends CBaseBean implements
		UIMantenimientoController {

	// Filters
	private String companiasocio;
	private Integer empleado;
	private String planilla;
	private String periodo;
	private String proceso;

	// Components
	private StreamedContent reporte;

	// Utilities Variables
	private Double totalIngresos;
	private Double totalEgresos;
	private Double totalNeto;
	private Double totalPatronales;

	// Selection
	private DtoConsultaBoletasEmpleado boletaSeleccionada;

	// Lists
	private List<DtoConsultaBoletasEmpleado> listaBoletasEmpleado;
	private List<DtoConsultaBoletasEmpleadoEncabezado> listaBoletaEmpleadoEncabezado;
	private List<DtoDetalleBoleta> listaDetalleBoleta;
	private List<DtoDetalleBoleta> listaDetalleRemuneraciones;
	private List<DtoDetalleBoleta> listaDetalleDescuentos;
	private List<DtoDetalleBoleta> listaDetalleAportes;
	private List<Personamast> listaEmpleados;

	private List<PrTipoplanilla> listaTipoPlanilla;
	private List<PrProcesoperiodo> listaPeriodos;
	private List<DtoProcesoXPlanillaPeriodo> listaProcesos;

	//
	private DecimalFormatSymbols symbol;
	private DecimalFormat df;
	private String nombreEmpleado;

	public static CConsultaBoletasEmpleado getInstance() {
		return UFaces.evaluateExpressionGet("#{cConsultaBoletasEmpleado}",
				CConsultaBoletasEmpleado.class);
	}

	public CConsultaBoletasEmpleado() {
		this.PANTALLA_LISTADO = "consulta_boletas_empleado";
	}

	@Override
	public String iniciarControladora() throws Exception {
		inicializarDatosMantenimiento();
		return this.PANTALLA_LISTADO;
	}

	public void listarPeriodoXPlanilla() {
		listaPeriodos = getFacPlanilla().getPrProcesoperiodoServicio()
				.listarPeriodosXPlanilla(planilla);
		if (!listaPeriodos.isEmpty()) {
			periodo = listaPeriodos.get(0).getPk().getPeriodo();
		} else {
			periodo = null;
		}
	}

	@SuppressWarnings("unchecked")
	public void listarProcesosXPlanillaPeriodo() {
		listaProcesos = getFacPlanilla().getPrProcesoperiodoServicio()
				.listarProcesoXPlanillaPeriodo(planilla, periodo);
		if (!listaProcesos.isEmpty()) {
			proceso = listaProcesos.get(0).getTIPOPROCESO();
		} else {
			proceso = null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public String buscar() throws Exception {

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();

		filtros.add(new ParametroPersistenciaGenerico("p_companiasocio",
				String.class, companiasocio));

		filtros.add(new ParametroPersistenciaGenerico("p_idempleado",
				Integer.class, empleado));

		listaBoletasEmpleado = getFacPlanilla().getPlanillaEmpleadoServicio()
				.listarBoletasEmpleado(filtros);
		listaBoletaEmpleadoEncabezado = getFacPlanilla()
				.getPlanillaEmpleadoServicio().listarDetalleBoletaEncabezado(
						filtros);

		if (!listaBoletaEmpleadoEncabezado.isEmpty())
			nombreEmpleado = listaBoletaEmpleadoEncabezado.get(0)
					.getNOMBRECOMPLETO();
		else
			nombreEmpleado = "";

		calcularTotales();

		return null;
	}

	private void calcularTotales() {
		symbol = new DecimalFormatSymbols();
		symbol.setDecimalSeparator('.');
		df = new DecimalFormat("#.##", symbol);

		totalIngresos = 0.0;
		totalEgresos = 0.0;
		totalNeto = 0.0;
		totalPatronales = 0.0;

		for (DtoConsultaBoletasEmpleado dtoConsultaBoletasEmpleado : listaBoletasEmpleado) {

			if (dtoConsultaBoletasEmpleado.getINGRESOS() != null
					&& dtoConsultaBoletasEmpleado.getEGRESOS() != null
					&& dtoConsultaBoletasEmpleado.getNETO() != null
					&& dtoConsultaBoletasEmpleado.getPATRONALES() != null) {
				totalIngresos += Double.parseDouble(dtoConsultaBoletasEmpleado
						.getINGRESOS().toString());
				totalEgresos += Double.parseDouble(dtoConsultaBoletasEmpleado
						.getEGRESOS().toString());
				totalNeto += Double.parseDouble(dtoConsultaBoletasEmpleado
						.getNETO().toString());
				totalPatronales += Double
						.parseDouble(dtoConsultaBoletasEmpleado.getPATRONALES()
								.toString());
			} else {
			}

		}

		totalIngresos = Double.parseDouble(df.format(totalIngresos));
		totalEgresos = Double.parseDouble(df.format(totalEgresos));
		totalNeto = Double.parseDouble(df.format(totalNeto));
		totalPatronales = Double.parseDouble(df.format(totalPatronales));

	}

	public void onRowSelect(SelectEvent event) throws Exception {
		boletaSeleccionada = (DtoConsultaBoletasEmpleado) event.getObject();
		clasificarDetalle();
		imprimir();
	}

	@SuppressWarnings("unchecked")
	private void clasificarDetalle() {
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();

		filtros.add(new ParametroPersistenciaGenerico("p_companiasocio",
				String.class, companiasocio));

		filtros.add(new ParametroPersistenciaGenerico("p_idempleado",
				Integer.class, empleado));

		filtros.add(new ParametroPersistenciaGenerico("p_periodo",
				String.class, boletaSeleccionada.getPERIODO()));

		filtros.add(new ParametroPersistenciaGenerico("p_planilla",
				String.class, boletaSeleccionada.getTIPOPLANILLA()));

		filtros.add(new ParametroPersistenciaGenerico("p_proceso",
				String.class, boletaSeleccionada.getTIPOPROCESO()));

		listaDetalleBoleta = getFacPlanilla().getPlanillaEmpleadoServicio()
				.listarDetalleBoleta(filtros);

		listaDetalleRemuneraciones = new ArrayList<>();
		listaDetalleDescuentos = new ArrayList<>();
		listaDetalleAportes = new ArrayList<>();

		for (DtoDetalleBoleta dtoDetalleBoleta : listaDetalleBoleta) {
			switch (dtoDetalleBoleta.getTIPOCONCEPTO()) {
			case "IN":
				listaDetalleRemuneraciones.add(dtoDetalleBoleta);
				break;
			case "DE":
				listaDetalleDescuentos.add(dtoDetalleBoleta);
				break;
			case "PA":
				listaDetalleAportes.add(dtoDetalleBoleta);
				break;
			}
		}

	}

	public void imprimir() throws Exception {
		Date fechaPago = getFacPlanilla().getPrProcesoperiodoServicio()
				.obtenerFechaPagoBoleta(periodo, planilla, proceso);
		Date fechaActual = UFechaHora.obtenerFechaHoraActual();

		LOGGER.debug("Fecha Actual : " + fechaActual);
		LOGGER.debug("Fecha Pago   : " + fechaPago);

		try {
			if (!fechaActual.after(fechaPago)) {
				LOGGER.debug("Fecha actual es menor que fecha pago");
				return;
			}
		} catch (Exception e) {
			LOGGER.debug("No existe fecha de pago");
		}

		String pathPrincipal;
		byte[] nombreArchivoPDF;

		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext()).getRealPath("/");

		String pathImagen = pathPrincipal
				+ "/comun/recursos/imagenes/sistema/oefa-logo-header.png";
		String pathMarcaDeAgua = pathPrincipal
				+ "/erp/planilla/imagenes/marca-de-agua.jpg";

		String totalNetoLetras = getFacPlanilla().getPlanillaEmpleadoServicio()
				.obtenerTotalNetoLetras(this.companiasocio, this.empleado + "",
						periodo, planilla, proceso);

		List<DtoVacacionBoleta> listaVacaciones = getFacPlanilla()
				.getPlanillaEmpleadoServicio().obtenerFechasVacacionBoleta(
						periodo, empleado);

		if (!listaVacaciones.isEmpty()) {
			LOGGER.debug(listaVacaciones.get(0).getFechainicio());
			LOGGER.debug(listaVacaciones.get(0).getFechafin());
		}

		File archivo = new File(
				pathPrincipal
						+ "/erp/planilla/recursos/reportes/boleta/w_pr_boleta_pago_print_libre_user.jasper");

		Map<String, Object> parametrosReport = new HashMap<String, Object>();
		parametrosReport.put("path_imagen", pathImagen);
		parametrosReport.put("PATH_MARCA_DE_AGUA", pathMarcaDeAgua);
		parametrosReport.put(JRParameter.REPORT_LOCALE, Locale.US);  
		parametrosReport.put("compania", this.companiasocio);
		parametrosReport.put("empleado", this.empleado);
		parametrosReport.put("periodo", periodo);
		parametrosReport.put("proceso", proceso);
		parametrosReport.put("planilla", planilla);
		
		Date vacdesde = null;
		Date vachasta = null;

		if (!UValidador.esListaVacia(listaVacaciones)) {
			vacdesde = listaVacaciones.get(0).getFechainicio();
			vachasta = listaVacaciones.get(0).getFechafin();
		}

		parametrosReport.put("VACACIONDESDE",
				(!UValidador.esNulo(vacdesde) ? new SimpleDateFormat(
						"dd/MM/yyyy").format(vacdesde) : null));
		parametrosReport.put("VACACIONHASTA",
				(!UValidador.esNulo(vachasta) ? new SimpleDateFormat(
						"dd/MM/yyyy").format(vachasta) : null));
		parametrosReport.put("totalNetoLetras", totalNetoLetras);

		nombreArchivoPDF = getFacPlanilla().getPlanillaEmpleadoServicio()
				.ejecutarReporteComoPDF(archivo.getPath(), parametrosReport);

		reporte = new DefaultStreamedContent(new ByteArrayInputStream(
				nombreArchivoPDF), "application/pdf");

	}

	private String getMesAnio(String periodo) {
		String mes = getMes(periodo.substring(4, 6));
		String anio = periodo.substring(0, 4);
		return mes + " - " + anio;
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
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		totalIngresos = 0.0;
		totalEgresos = 0.0;
		totalNeto = 0.0;
		totalPatronales = 0.0;

		empleado = getUsuarioActual().getIdPersona();
		companiasocio = getUsuarioActual().getCompaniaSocioCodigo();

		listaBoletasEmpleado = new ArrayList<>();
		listaBoletasEmpleado.clear();

		listaTipoPlanilla = getFacPlanilla().getPrTipoplanillaServicio()
				.ListarTipoPlanilla();
		if (!listaTipoPlanilla.isEmpty()) {
			listaPeriodos = getFacPlanilla().getPrProcesoperiodoServicio()
					.listarPeriodosXPlanilla(
							listaTipoPlanilla.get(0).getPk().getTipoplanilla());

			if (!listaPeriodos.isEmpty()) {
				listaProcesos = getFacPlanilla().getPrProcesoperiodoServicio()
						.listarProcesoXPlanillaPeriodo(
								listaTipoPlanilla.get(0).getPk()
										.getTipoplanilla(),
								listaPeriodos.get(0).getPk().getPeriodo());
			}
		}

		if (!listaTipoPlanilla.isEmpty()) {
			planilla = listaTipoPlanilla.get(0).getPk().getTipoplanilla();
		} else {
			planilla = null;
		}

		if (!listaPeriodos.isEmpty()) {
			periodo = listaPeriodos.get(0).getPk().getPeriodo();
		} else {
			periodo = null;
		}

		if (!listaProcesos.isEmpty()) {
			proceso = listaProcesos.get(0).getTIPOPROCESO();
		} else {
			proceso = null;
		}

		return null;
	}

	private String getMes(String numero) {
		String mes = "";
		switch (numero) {
		case "01":
			mes = "ENERO";
			break;
		case "02":
			mes = "FEBRERO";
			break;
		case "03":
			mes = "MARZO";
			break;
		case "04":
			mes = "ABRIL";
			break;
		case "05":
			mes = "MAYO";
			break;
		case "06":
			mes = "JUNIO";
			break;
		case "07":
			mes = "JULIO";
			break;
		case "08":
			mes = "AGOSTO";
			break;
		case "09":
			mes = "SETIEMBRE";
			break;
		case "10":
			mes = "OCTUBRE";
			break;
		case "11":
			mes = "NOVIEMBRE";
			break;
		case "12":
			mes = "DICIEMBRE";
			break;
		}

		return mes;
	}

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public StreamedContent getReporte() {
		return reporte;
	}

	public void setReporte(StreamedContent reporte) {
		this.reporte = reporte;
	}

	public List<DtoConsultaBoletasEmpleado> getListaBoletasEmpleado() {
		return listaBoletasEmpleado;
	}

	public void setListaBoletasEmpleado(
			List<DtoConsultaBoletasEmpleado> listaBoletasEmpleado) {
		this.listaBoletasEmpleado = listaBoletasEmpleado;
	}

	public Double getTotalIngresos() {
		return totalIngresos;
	}

	public void setTotalIngresos(Double totalIngresos) {
		this.totalIngresos = totalIngresos;
	}

	public Double getTotalEgresos() {
		return totalEgresos;
	}

	public void setTotalEgresos(Double totalEgresos) {
		this.totalEgresos = totalEgresos;
	}

	public Double getTotalNeto() {
		return totalNeto;
	}

	public void setTotalNeto(Double totalNeto) {
		this.totalNeto = totalNeto;
	}

	public Double getTotalPatronales() {
		return totalPatronales;
	}

	public void setTotalPatronales(Double totalPatronales) {
		this.totalPatronales = totalPatronales;
	}

	public DtoConsultaBoletasEmpleado getBoletaSeleccionada() {
		return boletaSeleccionada;
	}

	public void setBoletaSeleccionada(
			DtoConsultaBoletasEmpleado boletaSeleccionada) {
		this.boletaSeleccionada = boletaSeleccionada;
	}

	public List<DtoDetalleBoleta> getListaDetalleBoleta() {
		return listaDetalleBoleta;
	}

	public void setListaDetalleBoleta(List<DtoDetalleBoleta> listaDetalleBoleta) {
		this.listaDetalleBoleta = listaDetalleBoleta;
	}

	public List<DtoDetalleBoleta> getListaDetalleRemuneraciones() {
		return listaDetalleRemuneraciones;
	}

	public void setListaDetalleRemuneraciones(
			List<DtoDetalleBoleta> listaDetalleRemuneraciones) {
		this.listaDetalleRemuneraciones = listaDetalleRemuneraciones;
	}

	public List<DtoDetalleBoleta> getListaDetalleDescuentos() {
		return listaDetalleDescuentos;
	}

	public void setListaDetalleDescuentos(
			List<DtoDetalleBoleta> listaDetalleDescuentos) {
		this.listaDetalleDescuentos = listaDetalleDescuentos;
	}

	public List<DtoDetalleBoleta> getListaDetalleAportes() {
		return listaDetalleAportes;
	}

	public void setListaDetalleAportes(
			List<DtoDetalleBoleta> listaDetalleAportes) {
		this.listaDetalleAportes = listaDetalleAportes;
	}

	public List<DtoConsultaBoletasEmpleadoEncabezado> getListaBoletaEmpleadoEncabezado() {
		return listaBoletaEmpleadoEncabezado;
	}

	public void setListaBoletaEmpleadoEncabezado(
			List<DtoConsultaBoletasEmpleadoEncabezado> listaBoletaEmpleadoEncabezado) {
		this.listaBoletaEmpleadoEncabezado = listaBoletaEmpleadoEncabezado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public List<Personamast> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Personamast> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public String getPlanilla() {
		return planilla;
	}

	public void setPlanilla(String planilla) {
		this.planilla = planilla;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public List<PrTipoplanilla> getListaTipoPlanilla() {
		return listaTipoPlanilla;
	}

	public void setListaTipoPlanilla(List<PrTipoplanilla> listaTipoPlanilla) {
		this.listaTipoPlanilla = listaTipoPlanilla;
	}

	public List<PrProcesoperiodo> getListaPeriodos() {
		return listaPeriodos;
	}

	public void setListaPeriodos(List<PrProcesoperiodo> listaPeriodos) {
		this.listaPeriodos = listaPeriodos;
	}

	public DecimalFormatSymbols getSymbol() {
		return symbol;
	}

	public void setSymbol(DecimalFormatSymbols symbol) {
		this.symbol = symbol;
	}

	public DecimalFormat getDf() {
		return df;
	}

	public void setDf(DecimalFormat df) {
		this.df = df;
	}

	public List<DtoProcesoXPlanillaPeriodo> getListaProcesos() {
		return listaProcesos;
	}

	public void setListaProcesos(List<DtoProcesoXPlanillaPeriodo> listaProcesos) {
		this.listaProcesos = listaProcesos;
	}

}
