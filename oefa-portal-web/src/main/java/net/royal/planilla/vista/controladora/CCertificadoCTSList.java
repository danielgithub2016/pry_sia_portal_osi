package net.royal.planilla.vista.controladora;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import net.royal.asistencia.vista.conversion.CVTDtoCompania;
import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CComunSession;
import net.royal.erp.asistencia.dominio.AsArea;
import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.core.dominio.MaUnidadnegocio;
import net.royal.erp.planilla.dominio.dto.DtoDwPrCtsList;
import net.royal.erp.planilla.dominio.dto.DtoDwPrCtsPosition;
import net.royal.erp.planilla.dominio.dto.DtoPeriodos;
import net.royal.erp.planilla.servicio.ObtenerTiempoLiquidado;
import net.royal.erp.rrhh.dominio.dto.DtoTipoPlanilla;
import net.royal.erp.sistema.dominio.dto.DtoDwMaCompanyownerSelect;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class CCertificadoCTSList extends CBaseBean implements UIMantenimientoController {
	
	private DtoDwPrCtsPosition dw_position;
	private DtoDwPrCtsList registroseleccionado;
	private DtoTipoPlanilla tipoplanilla;
	private List<DtoDwPrCtsList> lstEmpleadoCts;
	private List<DtoTipoPlanilla> lstTipoPlanilla;
	private List<DtoDwMaCompanyownerSelect> lst_entidad;
	private List<MaUnidadnegocio> lstUnidadNegocio;	
	private List<DtoPeriodos> lstPeriodoInicio;	
	private List<DtoPeriodos> lstPeriodoFin;	
	private List<AcCostcentermst> lstCentroCosto;
	private List<AsArea> lstAsArea;
	private MaUnidadnegocio unidadNegocio;
	private DtoPeriodos periodoInicio;
	private DtoPeriodos periodoFin;
	private AcCostcentermst centroCosto;
	private AsArea asArea;
	private boolean boolImprimir;
	private byte[] nombreArchivoPDF;
	private String desde="",hasta="";
	private String valor;
	private String empleado;
	private StreamedContent reporte;
	
	private String iv_sql = "";
	private List<DtoDwPrCtsList> dw_list;
	private String queryJasper = "";
	private String urlLogo="";
	
	public CCertificadoCTSList() {
		this.PANTALLA_LISTADO = "wprcertificadolist";
	}

	public static CCertificadoCTSList getInstance() {
		return UFaces.evaluateExpressionGet("#{cCertificadoCTSList}",
				CCertificadoCTSList.class);
	}
	
	@SuppressWarnings("unchecked")
	public String open() throws Exception {

		lst_entidad = getFacCore().getCompanyownerServicio().DwMaCompanyownerSelect(
				CComunSession.syroyal().StrGlobal()
				.getGv_companyowner());
 		CVTDtoCompania.lista = lst_entidad;
 				
		LOGGER.debug("lst_entidad == " + lst_entidad.size());
		wf_open();
		return null;
	}
	
	public String wf_open() throws Exception {
				
		dw_position.setAll_companyowner(false);
		dw_position.setCompania(lst_entidad.get(0).getCompanyowner());
		dw_position.setAll_centrocosto(true);
		dw_position.setAll_unidadnegocio(true);
		dw_position.setAll_tipoplanilla(false);
		dw_position.setAll_area(true);
		dw_position.setAll_cesados(false);
		iv_sql = this.getFacPlanilla().getPrCtsServicio().obtenerSentencia();
		
//		buscar();
		return null;
	}
	
	public String wf_imprimir() throws Exception {
		
		if(periodoInicio.getNumerocts().intValue()>periodoFin.getNumerocts().intValue()){
			setMessageError("El Periodo de Inicio no debe ser Mayor a Periodo Fin");
			return null;
		}
		else{
			imprimir();
		}
		return null;
	}	
	
	public String imprimir() throws Exception{
		
		String pathPrincipal;
		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext()).getRealPath("/");
		Map<String, Object> parametrosReport = new HashMap<String, Object>();
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();  	  
        Document document = new Document();  
        PdfWriter.getInstance(document, out);  
        document.open();  
            document.add(new Paragraph("No Se Encontraron Datos "));          
        document.close();  
		
		LOGGER.debug("CTS Inicio: "+periodoInicio.getNumerocts());
		LOGGER.debug("CTS Fin: "+periodoFin.getNumerocts());
		LOGGER.debug("Documento: "+dw_position.getDocumento());
		LOGGER.debug("Tipo: "+dw_position.getTipo());
		urlLogo=pathPrincipal + "/erp/planilla/imagenes/LOGO_OEFA.png";
		
		String pathMarcaDeAgua = pathPrincipal
				+ "/erp/planilla/imagenes/marca-de-agua.jpg";
		String montoLetras = getFacPlanilla().getPrCtsServicio()
				.obtenerMontoTotalLetras(empleado,periodoInicio.getNumerocts());
		String remuLetras = getFacPlanilla().getPrCtsServicio()
				.obtenerRemuneracionLetras(empleado,periodoInicio.getNumerocts());
		ArrayList<String> array= (ArrayList<String>) getFacPlanilla().getPrCtsServicio()
				.obtenerLiquidacion(empleado, periodoInicio.getNumerocts(), periodoFin.getNumerocts());
		
		String liquidacion = ObtenerTiempoLiquidado.TraeLiquidacion(array);
		LOGGER.debug(liquidacion);
		if(dw_position.getTipo().equals("C")){
			if(dw_position.getDocumento().equals("01")){
				LOGGER.debug("REPORTE CERTIFICADO DE DEPOSITO");
				parametrosReport.put("empleado", empleado);
				parametrosReport.put("cts",periodoInicio.getNumerocts());
				parametrosReport.put("Logo", urlLogo);
				parametrosReport.put("montoLetra", montoLetras);
				parametrosReport.put("PATH_MARCA_DE_AGUA", pathMarcaDeAgua);
				File archivo = new File(pathPrincipal + File.separator + "erp"
						+ File.separator + "planilla" + File.separator + File.separator
						+ "recursos" + File.separator + File.separator + "reportes"
						+ File.separator + File.separator + "cts"
						+ File.separator + File.separator
						+ "w_pr_cts_certificado_deposito.jasper");
				
				nombreArchivoPDF = getFacPlanilla().getPrCtsServicio()
					.ejecutarReporteComoPDF(archivo.getPath(), parametrosReport);
				
				
			}
			else if(dw_position.getDocumento().equals("02")){
				LOGGER.debug("REPORTE CARTA SOLICITA BANCO");
				parametrosReport.put("empleado", empleado);
				parametrosReport.put("cts", periodoInicio.getNumerocts());
				parametrosReport.put("Logo", urlLogo);
				File archivo = new File(pathPrincipal + File.separator + "erp"
						+ File.separator + "planilla" + File.separator + File.separator
						+ "recursos" + File.separator + File.separator + "reportes"
						+ File.separator + File.separator + "cts"
						+ File.separator + File.separator
						+ "w_pr_cts_carta_solicita.jasper");
				nombreArchivoPDF = getFacPlanilla().getPrCtsServicio()
						.ejecutarReporteComoPDF(archivo.getPath(), parametrosReport);
			}
			else if(dw_position.getDocumento().equals("03")){
				LOGGER.debug("REPORTE CARTA DE RETIRO");
				parametrosReport.put("empleado", empleado);
				parametrosReport.put("cts", periodoInicio.getNumerocts());
				parametrosReport.put("Logo", urlLogo);
				parametrosReport.put("remuLetra", remuLetras);
				File archivo = new File(pathPrincipal + File.separator + "erp"
						+ File.separator + "planilla" + File.separator + File.separator
						+ "recursos" + File.separator + File.separator + "reportes"
						+ File.separator + File.separator + "cts"
						+ File.separator + File.separator
						+ "w_pr_cts_carta_retiro.jasper");
				nombreArchivoPDF = getFacPlanilla().getPrCtsServicio()
						.ejecutarReporteComoPDF(archivo.getPath(), parametrosReport);
			}else{
				LOGGER.debug("REPORTE CARTA DE TRANSFERENCIA");
				parametrosReport.put("empleado", empleado);
				parametrosReport.put("cts", periodoInicio.getNumerocts());
				parametrosReport.put("Logo", urlLogo);
				File archivo = new File(pathPrincipal + File.separator + "erp"
						+ File.separator + "planilla" + File.separator + File.separator
						+ "recursos" + File.separator + File.separator + "reportes"
						+ File.separator + File.separator + "cts"
						+ File.separator + File.separator
						+ "w_pr_cts_carta_transferencia.jasper");
				nombreArchivoPDF = getFacPlanilla().getPrCtsServicio()
						.ejecutarReporteComoPDF(archivo.getPath(), parametrosReport);
			}
		}else{
			LOGGER.debug("CONSTANCIA DE DEPOSITO");
			
			parametrosReport.put("empleado", empleado);
			parametrosReport.put("ctsinicio", periodoInicio.getNumerocts());
			parametrosReport.put("ctsfinal", periodoFin.getNumerocts());
			parametrosReport.put("Logo", urlLogo);
			parametrosReport.put("Liquidacion", liquidacion);
			parametrosReport.put("PATH_MARCA_DE_AGUA", pathMarcaDeAgua);
			File archivo = new File(pathPrincipal + File.separator + "erp"
					+ File.separator + "planilla" + File.separator + File.separator
					+ "recursos" + File.separator + File.separator + "reportes"
					+ File.separator + File.separator + "cts"
					+ File.separator + File.separator
					+ "w_pr_constancia_depositomasiva.jasper");
			nombreArchivoPDF = getFacPlanilla().getPrCtsServicio()
					.ejecutarReporteComoPDF(archivo.getPath(), parametrosReport);
		}	
		
		reporte = new DefaultStreamedContent(new ByteArrayInputStream(
				nombreArchivoPDF), "application/pdf");

		LOGGER.debug(reporte);

		return null;
	}
	
	public String obtenerdesde(){
		desde = registroseleccionado.getEmpleado() +" - "+ registroseleccionado.getNombrecompleto();
		LOGGER.debug("DESDE :"+desde);
		return null;
	}
	
	public String obtenerhasta(){
		hasta = registroseleccionado.getEmpleado() +" - "+ registroseleccionado.getNombrecompleto();
		LOGGER.debug("DESDE :"+hasta);		
		return null;
	}
	
	@Override
	public String iniciarControladora() throws Exception {
		dw_position = new DtoDwPrCtsPosition();		
		empleado = this.getUsuarioActual().getLoginUsuario().toUpperCase();
		LOGGER.debug(empleado);
		inicializarFiltrosListado();		
		dw_position.setTipo("C");
		dw_position.setDocumento("01");
		open();
		return PANTALLA_LISTADO;
	}

	@Override
	public String buscar() throws Exception {		
		imprimir();
		return null;
	}
	
	
	public void filtrar() throws Exception {
		LOGGER.debug("Tipo: "+dw_position.getTipo());	
		if(dw_position.getTipo().equals("X")){
			dw_position.setAll_tipo(true);
		}
		else{
			dw_position.setAll_tipo(false);
		}
			
	}
		
	public void onRowSelect(SelectEvent event) throws Exception {
		registroseleccionado= (DtoDwPrCtsList) event.getObject();
		LOGGER.debug("registroseleccionado " + registroseleccionado);
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
		periodoInicio = new DtoPeriodos();
		periodoFin = new DtoPeriodos();
		lstEmpleadoCts = new ArrayList<>(); 		
		lstUnidadNegocio = this.getFacCore().getMaUnidadnegocioServicio().obtenerCombo();
		lstPeriodoInicio = this.getFacCore().getMaCtsServicio().obtenerPeriodos();
		lstPeriodoFin = this.getFacCore().getMaCtsServicio().obtenerPeriodos();
		lstTipoPlanilla = this.getFacRrhh().getHrRequerimientoServicio().listarTipoPlanilla(null);
		lstCentroCosto = this.getFacContabilidad().getAcCostcentermstServicio().listaComboCentroCosto();
		lstAsArea= this.getFacAsistencia().getAsAreaServicio().listaComboAreaServicio();
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		return null;
	}
	

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public StreamedContent getReporte() {
		return reporte;
	}

	public void setReporte(StreamedContent reporte) {
		this.reporte = reporte;
	}
	
	public DtoDwPrCtsList getRegistroseleccionado() {
		return registroseleccionado;
	}

	public void setRegistroseleccionado(DtoDwPrCtsList registroseleccionado) {
		this.registroseleccionado = registroseleccionado;
	}

	public List<DtoDwPrCtsList> getLstEmpleadoCts() {
		return lstEmpleadoCts;
	}

	public void setLstEmpleadoCts(List<DtoDwPrCtsList> lstEmpleadoCts) {
		this.lstEmpleadoCts = lstEmpleadoCts;
	}

	public boolean isBoolImprimir() {
		return boolImprimir;
	}

	public void setBoolImprimir(boolean boolImprimir) {
		this.boolImprimir = boolImprimir;
	}



	public byte[] getNombreArchivoPDF() {
		return nombreArchivoPDF;
	}

	public void setNombreArchivoPDF(byte[] nombreArchivoPDF) {
		this.nombreArchivoPDF = nombreArchivoPDF;
	}

	public String getDesde() {
		return desde;
	}

	public void setDesde(String desde) {
		this.desde = desde;
	}

	public String getHasta() {
		return hasta;
	}

	public void setHasta(String hasta) {
		this.hasta = hasta;
	}

	public MaUnidadnegocio getUnidadNegocio() {
		return unidadNegocio;
	}

	public void setUnidadNegocio(MaUnidadnegocio unidadNegocio) {
		this.unidadNegocio = unidadNegocio;
	}

	public List<MaUnidadnegocio> getLstUnidadNegocio() {
		return lstUnidadNegocio;
	}

	public void setLstUnidadNegocio(List<MaUnidadnegocio> lstUnidadNegocio) {
		this.lstUnidadNegocio = lstUnidadNegocio;
	}

	public DtoDwPrCtsPosition getDw_position() {
		return dw_position;
	}

	public void setDw_position(DtoDwPrCtsPosition dw_position) {
		this.dw_position = dw_position;
	}

	public List<DtoDwMaCompanyownerSelect> getLst_entidad() {
		return lst_entidad;
	}

	public void setLst_entidad(List<DtoDwMaCompanyownerSelect> lst_entidad) {
		this.lst_entidad = lst_entidad;
	}




	public List<DtoPeriodos> getLstPeriodoInicio() {
		return lstPeriodoInicio;
	}

	public void setLstPeriodoInicio(List<DtoPeriodos> lstPeriodoInicio) {
		this.lstPeriodoInicio = lstPeriodoInicio;
	}

	public List<DtoPeriodos> getLstPeriodoFin() {
		return lstPeriodoFin;
	}

	public void setLstPeriodoFin(List<DtoPeriodos> lstPeriodoFin) {
		this.lstPeriodoFin = lstPeriodoFin;
	}

	public DtoPeriodos getPeriodoInicio() {
		return periodoInicio;
	}

	public void setPeriodoInicio(DtoPeriodos periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	public DtoPeriodos getPeriodoFin() {
		return periodoFin;
	}

	public void setPeriodoFin(DtoPeriodos periodoFin) {
		this.periodoFin = periodoFin;
	}

	public List<DtoTipoPlanilla> getLstTipoPlanilla() {
		return lstTipoPlanilla;
	}

	public void setLstTipoPlanilla(List<DtoTipoPlanilla> lstTipoPlanilla) {
		this.lstTipoPlanilla = lstTipoPlanilla;
	}

	public DtoTipoPlanilla getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(DtoTipoPlanilla tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

	public List<AcCostcentermst> getLstCentroCosto() {
		return lstCentroCosto;
	}

	public void setLstCentroCosto(List<AcCostcentermst> lstCentroCosto) {
		this.lstCentroCosto = lstCentroCosto;
	}

	public AcCostcentermst getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(AcCostcentermst centroCosto) {
		this.centroCosto = centroCosto;
	}

	public List<AsArea> getLstAsArea() {
		return lstAsArea;
	}

	public void setLstAsArea(List<AsArea> lstAsArea) {
		this.lstAsArea = lstAsArea;
	}

	public AsArea getAsArea() {
		return asArea;
	}

	public void setAsArea(AsArea asArea) {
		this.asArea = asArea;
	}

	public String getIv_sql() {
		return iv_sql;
	}

	public void setIv_sql(String iv_sql) {
		this.iv_sql = iv_sql;
	}

	public List<DtoDwPrCtsList> getDw_list() {
		return dw_list;
	}

	public void setDw_list(List<DtoDwPrCtsList> dw_list) {
		this.dw_list = dw_list;
	}

	public String getQueryJasper() {
		return queryJasper;
	}

	public void setQueryJasper(String queryJasper) {
		this.queryJasper = queryJasper;
	}
	
	

}
