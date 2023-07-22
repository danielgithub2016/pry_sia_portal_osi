package net.royal.planilla.vista.controladora;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.planilla.dominio.PrProcesoperiodo;
import net.royal.erp.planilla.dominio.PrTipoplanilla;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

/**
 * 
 * @author CruzadoJ
 * 
 * */
@ManagedBean
@SessionScoped
@SuppressWarnings("serial")
public class CConsultaRenta5taCategoriaAnualizado extends CBaseBean implements UIMantenimientoController {

	//Filters
	private String planilla;
	private String periodo;
	
	//Lists
	private List<PrTipoplanilla> listaTipoPlanilla;
	private List<PrProcesoperiodo> listaPeriodos;
	
	//Report
	private StreamedContent reporte;
	
	public CConsultaRenta5taCategoriaAnualizado() {
		this.PANTALLA_LISTADO = "ConsultaRenta5taCategoriaAnualizado";
	}
	
	public void listarPeriodoXPlanilla() {
		listaPeriodos = getFacPlanilla().getPrProcesoperiodoServicio().
				listarPeriodosXPlanilla(planilla);
	}
	
	@Override
	public String iniciarControladora() throws Exception {
		setListaTipoPlanilla(getFacPlanilla().getPrTipoplanillaServicio().ListarTipoPlanilla());
		listaPeriodos = getFacPlanilla().getPrProcesoperiodoServicio().
							listarPeriodosXPlanilla(listaTipoPlanilla.get(0).getPk().getTipoplanilla());
		planilla = "";
		periodo = "";
		return this.PANTALLA_LISTADO;
	}

	@Override
	public String buscar() throws Exception {

		if (planilla != null && periodo != null) {
			String periodo = this.periodo.substring(0, 6);
			
			String pathPrincipal;
			byte[] nombreArchivoPDF;
			
			pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance()
					.getExternalContext().getContext()).getRealPath("/");

			File archivo = new File(pathPrincipal + 
					"/erp/planilla/recursos/reportes/renta-5ta-categoria/Renta5taCategoriaAnualizado.jasper");
			
			Map<String, Object> parametrosReport = new HashMap<String, Object>();
			parametrosReport.put("TIPO_PLANILLA", planilla);
			parametrosReport.put("PERIODO_FISCAL", periodo);
			
			nombreArchivoPDF = getFacPlanilla().getPlanillaEmpleadoServicio()
					.ejecutarReporteComoPDF(archivo.getPath(), parametrosReport);
				
			reporte = new DefaultStreamedContent(new ByteArrayInputStream(
					nombreArchivoPDF), "application/pdf");
		}
		
		return null;
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
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
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

	public StreamedContent getReporte() {
		return reporte;
	}

	public void setReporte(StreamedContent reporte) {
		this.reporte = reporte;
	}

}
