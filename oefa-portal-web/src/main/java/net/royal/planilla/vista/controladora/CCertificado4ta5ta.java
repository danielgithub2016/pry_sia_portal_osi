package net.royal.planilla.vista.controladora;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CComunSession;
import net.royal.erp.asistencia.dominio.AsArea;
import net.royal.erp.core.dominio.Companiamast;
import net.royal.erp.core.dominio.CompaniamastPk;
import net.royal.erp.planilla.dominio.PrProcesoperiodo;
import net.royal.erp.planilla.dominio.PrTipoplanilla;
import net.royal.erp.planilla.dominio.dto.DtoDeduccion;
import net.royal.erp.planilla.dominio.dto.DtoListaCertificado;
import net.royal.erp.planilla.dominio.dto.DtoNumResponsable;
import net.royal.erp.planilla.dominio.dto.DtoResponsable;
import net.royal.erp.sistema.dominio.dto.DtoDwMaCompanyownerSelect;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

/**
 * 
 * @author CruzadoJ
 * 
 */
@ManagedBean
@SessionScoped
@SuppressWarnings(value = "serial")
public class CCertificado4ta5ta extends CBaseBean implements UIMantenimientoController {

	// Filters
	private Boolean all_compania;
	private Boolean all_planilla;
	private Boolean all_periodo;
	private Boolean all_areaoperacion;
	private Boolean cesados;
	private String certificado;
	private String tipo;

	// Attributes
	private String compania;
	private String planilla;
	private String periodo;
	private String areaoperacion;
	private String deduccion;

	// Lists
	private List<DtoDwMaCompanyownerSelect> listaCompanias;
	private List<AsArea> listaAreas;
	private List<PrTipoplanilla> listaTipoPlanilla;
	private List<PrProcesoperiodo> listaPeriodos;
	private List<DtoListaCertificado> listaEmpleados;

	// SQL
	private StringBuilder sentenciaSQL;
	
	// Selection
	private DtoListaCertificado empleadoSeleccionado;
	
	// Report
	private StreamedContent reporte;
	
	public static CCertificado4ta5ta getInstance() {
		return UFaces.evaluateExpressionGet("#{cCertificado4ta5ta}",
				CCertificado4ta5ta.class);
	}

	public CCertificado4ta5ta() {
		this.PANTALLA_LISTADO = "Certificado4ta5ta";
	}

	@Override
	public String iniciarControladora() throws Exception {
		inicializarDatosMantenimiento();
		inicializarFiltros();
		return this.PANTALLA_LISTADO;
	}

	public void listarPeriodoXPlanilla() {
		listaPeriodos = getFacPlanilla().getPrProcesoperiodoServicio().listarPeriodosXPlanilla(planilla);
	}

	@Override
	public String buscar() throws Exception {
		//prepararSQL();
		imprimir();
		return null;
	}

	@SuppressWarnings("unchecked")
	private void prepararSQL() {
		
		sentenciaSQL = new StringBuilder();

		// SQL Base
		if (certificado.equalsIgnoreCase("5ta")) {
			sentenciaSQL.append(
					  "SELECT PR_ImpuestoRenta.CompaniaSocio, "
					+ "EmpleadoMast.Empleado, "
				    + "PersonaMast.NombreCompleto, "
				    + "EmpleadoMast.EstadoEmpleado,EmpleadoMast.FechaCese "
		            + "FROM sgcoresys.EmpleadoMast, "
				    + "sgcoresys.PersonaMast, "
				    + "sgcoresys.PR_ImpuestoRenta "
				    + "WHERE ( EmpleadoMast.Empleado = PersonaMast.Persona ) and "
				    + "( EmpleadoMast.Empleado = PR_ImpuestoRenta.Empleado ) ");
		} else {
			sentenciaSQL.append(
					  "SELECT EmpleadoMast.CompaniaSocio as CompaniaSocio, "
					+ "EmpleadoMast.Empleado, "
					+ "PersonaMast.NombreCompleto, "
					+ "EmpleadoMast.EstadoEmpleado,EmpleadoMast.FechaCese "
					+ "FROM sgcoresys.EmpleadoMast INNER JOIN sgcoresys.PersonaMast "
					+ "ON (EmpleadoMast.Empleado = PersonaMast.Persona) ");
		}

		
		// Filtro Cesados
		if (cesados == false) {
			sentenciaSQL.append("and (EmpleadoMast.EstadoEmpleado <> '2' ) ");
		}
		
		
		
		// Filtro Compania
		if (certificado.equalsIgnoreCase("5ta")) {
			if (all_compania == false) {
				if (!UValidador.esNulo(compania)) {
					sentenciaSQL.append("and (PR_ImpuestoRenta.CompaniaSocio = '" + compania  + "' ) ");
				}
			} else {
				sentenciaSQL.append("and (PR_ImpuestoRenta.CompaniaSocio in (" + getCompanias()  + ") ) ");
			}
		} else {
			if (all_compania == false) {
				if (!UValidador.esNulo(compania)) {
					sentenciaSQL.append("and (EmpleadoMast.CompaniaSocio = '" + compania  + "' ) ");
				}
			} else {
				sentenciaSQL.append("and (EmpleadoMast.CompaniaSocio in (" + getCompanias()  + ") ) ");
			}
		}
		
		
		// Filtro Planilla
		if (all_planilla == false) {
			if (!UValidador.esNulo(planilla)) {
				sentenciaSQL.append("and (EmpleadoMast.TipoPlanilla = '" + planilla + "' ) ");
			}
		} else {
			sentenciaSQL.append("and (EmpleadoMast.TipoPlanilla in (" + getPlanillas() + ") ) ");
		}
		
		
		
		// Filtro periodo
		if (certificado.equalsIgnoreCase("5ta")) {
			if (all_periodo == false) {
				if (!UValidador.esNulo(periodo)) {
					sentenciaSQL.append("and (PR_ImpuestoRenta.EjercicioFiscal = '" + periodo.substring(0,6) + "' ) ");
				}
			}
		} else {
			if (all_periodo == false) {
				if (!UValidador.esNulo(periodo)) {
					sentenciaSQL.append("and (PERSONAMAST.PERSONA IN (SELECT X.EMPLEADO FROM  PR_PLANILLAEMPLEADO X WHERE SUBSTR(X.PERIODO,1,4) ='" + periodo.substring(0,4) + "' and substr(x.tipoproceso,1,2)='NO')) ");
				}
			}
		}
		
		
		
		// Filtro AreaOperacion
		if (all_areaoperacion == false) {
			if (!UValidador.esNulo(areaoperacion)) {
				sentenciaSQL.append("and (EmpleadoMast.DptoAreaOperativa = " + areaoperacion + " ) ");
			}
		}
		
		// Order
		sentenciaSQL.append("ORDER BY NOMBRECOMPLETO ");
		
		listaEmpleados = getFacPlanilla().getPlanillaEmpleadoServicio().listarEmpleadosCertificado(sentenciaSQL);		
		
	}
	
	private String getPlanillas() {
		StringBuilder planillas = new StringBuilder();
		
		for (int i = 0; i < listaTipoPlanilla.size(); i++) {
			if (i == listaTipoPlanilla.size() - 1) {
				planillas.append("'"+listaTipoPlanilla.get(i).getPk().getTipoplanilla()+"'");
			} else {
				planillas.append("'"+listaTipoPlanilla.get(i).getPk().getTipoplanilla()+"'" + ",");
			}
		}
		
		return planillas.toString();
	}
	
	private String getCompanias() {
		StringBuilder companias = new StringBuilder();
		
		for (int i = 0; i < listaCompanias.size(); i++) {
			if (i == (listaCompanias.size() - 1)) {
				companias.append("'"+listaCompanias.get(i).getCompanyowner()+"'");
			} else {
				companias.append("'"+listaCompanias.get(i).getCompanyowner()+"'" + ",");
			}
		}
		
		return companias.toString();
	}
	
	public void imprimir2() {
		
	}
	
	@SuppressWarnings("unchecked")
	public void imprimir() throws Exception {
		
		DtoResponsable responsable = obtenerResponsable();
		CompaniamastPk pk = new CompaniamastPk();
		pk.setCompaniacodigo(compania.substring(0, 6));
		Companiamast compania =  (Companiamast)
	 			getFacCore().getCompaniamastServicio().obtenerPorId(pk);
		
		StringBuilder sb;
		try {
			sb = new StringBuilder(
					  "select 7*MONTO DEDUCCION "
					+ "From SGCORESYS.PR_VALORESMISCELANEOS "
					+ "WHERE CODIGO='UITANU' and periodo= '"+periodo.substring(0,6)+"'");
			
			List<DtoDeduccion> lstDeduc = getFacPlanilla().getPlanillaEmpleadoServicio().obtenerDeduccion(sb);
			if (!lstDeduc.isEmpty()) {
				deduccion = lstDeduc.get(0).getDEDUCCION().toString();
			} else {
				deduccion = null;
			}
			
		} catch (Exception e) {
			LOGGER.debug("No hay periodo");
			return;
		}	
		
		String pathPrincipal;
		byte[] nombreArchivoPDF;
		
		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext()).getRealPath("/");
		
		String path4taAnual = pathPrincipal + "/erp/planilla/recursos/reportes/certificado/certificado_4ta_anual.jasper";
		String path4taMensual = pathPrincipal + "/erp/planilla/recursos/reportes/certificado/certificado_4ta_mensual.jasper";
		String path5taAnual = pathPrincipal + "/erp/planilla/recursos/reportes/certificado/certificado_5ta_anual.jasper";
		String path5taMensual = pathPrincipal + "/erp/planilla/recursos/reportes/certificado/certificado_5ta_mensual.jasper";
		
		String pathImagen = pathPrincipal + "/erp/planilla/imagenes/LOGO_OEFA.png";
		String pathMarcaDeAgua = pathPrincipal + "/erp/planilla/imagenes/marca-de-agua.jpg";

		File archivo = null;
		
		if (certificado.equalsIgnoreCase("5ta")) {
			if (tipo.equalsIgnoreCase("ANUAL")) {
				archivo = new File(path5taAnual);
			} else {
				archivo = new File(path5taMensual);
			}
		} else {
			if (tipo.equalsIgnoreCase("ANUAL")) {
				archivo = new File(path4taAnual);
			} else {
				archivo = new File(path4taMensual);
			}
		}
		
		String acumuladoLetras = getFacPlanilla().getPlanillaEmpleadoServicio()
				.obtenerAcumuladoRetencionLetras
					(this.compania, planilla, periodo.substring(0,6), getUsuarioActual().getIdPersona().toString());
		
		String tituloAnio = getFacPlanilla().getPlanillaEmpleadoServicio().obtenerTituloAnio(periodo.substring(0,4));
		
		SimpleDateFormat formateador = new SimpleDateFormat(
				   "dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
				   Date fechaDate = new Date();
				   String fecha = formateador.format(fechaDate);

		Map<String, Object> parametrosReport = new HashMap<String, Object>();
		parametrosReport.put("PATH_IMAGEN", pathImagen);
		parametrosReport.put("PATH_MARCA_DE_AGUA", pathMarcaDeAgua);
		parametrosReport.put("TITULO_ANIO", tituloAnio);
		parametrosReport.put("FECHA", fecha);
		parametrosReport.put("EMPLEADOR", compania.getDescripcionlarga());
		parametrosReport.put("RESPONSABLE", (responsable != null ? responsable.getNOMBRESCOMPLETOS() : "XXXXXXXXXXXXXXXX" ));
		parametrosReport.put("RESPONSABLE_PUESTO", (responsable != null ? responsable.getPUESTO() : "XXXXXXXXXXXXXXXX" ));
		if (certificado.equalsIgnoreCase("5ta")) {
			parametrosReport.put("DOCUMENTO_RESPONSABLE", (responsable != null ? responsable.getDOCUMENTO() : "" ));
			parametrosReport.put("ACUMULADORETENCION_LETRAS", acumuladoLetras);	
			parametrosReport.put("MONEDA", "Soles");
		}
		parametrosReport.put("RUC", compania.getDocumentofiscal());
		parametrosReport.put("DIRECCION", compania.getDireccioncomun());
		parametrosReport.put("DEDUCCIONES", deduccion);
		parametrosReport.put("CODIGO_EMPLEADOR", 1);
		parametrosReport.put("TIPO_PLANILLA", planilla); 
		parametrosReport.put("EJERCICIO_FISCAL", periodo.substring(0, 6)); 
		parametrosReport.put("COMPANIA", this.compania);
		parametrosReport.put("EMPLEADO", getUsuarioActual().getIdPersona());
		parametrosReport.put("CESADOS", 1);
		
		
		LOGGER.debug("User : " + getUsuarioActual().getIdPersona());
		
		nombreArchivoPDF = getFacPlanilla().getPlanillaEmpleadoServicio()
				.ejecutarReporteComoPDF(archivo.getPath(),
						parametrosReport);
			
		reporte = new DefaultStreamedContent(new ByteArrayInputStream(
				nombreArchivoPDF), "application/pdf");
	}
	
	@SuppressWarnings("unchecked")
	private DtoResponsable obtenerResponsable() {
		
		DtoResponsable responsable = null;
		
		StringBuilder sb1 = new StringBuilder(
				  " SELECT ParametrosMast.Numero  "
				+ " FROM sgcoresys.ParametrosMast  "
				+ " WHERE ( ParametrosMast.CompaniaCodigo = '" + compania.substring(0, 6) +  "' ) AND  "
				+ " ( ParametrosMast.AplicacionCodigo = 'PR' ) AND  "
				+ " ( ParametrosMast.ParametroClave = 'RESPONSIR' )"
				);
		
		StringBuilder sb2 = new StringBuilder(
				  " SELECT ParametrosMast.Numero  "
				+ " FROM sgcoresys.ParametrosMast  "
				+ " WHERE ( ParametrosMast.CompaniaCodigo = '999999' ) AND  "
				+ " ( ParametrosMast.AplicacionCodigo = 'PR' ) AND  "
				+ " ( ParametrosMast.ParametroClave = 'RESPONSIR' )"
				);
		
		List<DtoNumResponsable> numResponsable = getFacPlanilla().getPlanillaEmpleadoServicio().obtenerNumResponsable(sb1);
		
		if (numResponsable.isEmpty()) {
			numResponsable = getFacPlanilla().getPlanillaEmpleadoServicio().obtenerNumResponsable(sb2);
		}
		
		String numero = numResponsable.get(0).getNUMERO().toString();
		
		StringBuilder SQL = new StringBuilder(
				  " SELECT	Nombres ,ApellidoPaterno ,ApellidoMaterno ,"
				+ " cast(m.descripcionlocal as varchar(10)) TipoDocumento,"
				+ " Documento, nvl(h.descripcion,'') PUESTO"
				+ "	FROM sgcoresys.PersonaMast a "
				+ "	inner join sgcoresys.empleadomast e ON (a.persona = e.empleado)"
				+ "	left join sgcoresys.hr_puestoempresa h on (e.codigocargo = h.codigopuesto)"
				+ " inner join sgcoresys.ma_miscelaneosdetalle m on (m.codigoelemento = a.tipodocumento)"
				+ "	WHERE	a.Persona = '" + numero + "' and a.TIPODOCUMENTO = m.CODIGOELEMENTO and m.CodigoTabla = 'TIPODOCI'"
				);
		
	 	List<DtoResponsable> responsableList =  getFacPlanilla().getPlanillaEmpleadoServicio().obtenerResponsable(SQL);
	 	if (!responsableList.isEmpty()) {
			responsable = responsableList.get(0);
	 		 	LOGGER.debug(responsable.getNOMBRESCOMPLETOS());
		}
	 	
	 	return responsable;
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

	private void inicializarFiltros() {
		all_compania = false;
		all_planilla = false;
		all_periodo = false;
		all_areaoperacion = false;
		cesados = false;
		certificado = null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		listaCompanias = getFacCore().getCompanyownerServicio()
				.DwMaCompanyownerSelect(CComunSession.syroyal().StrGlobal().getGv_companyowner());
		listaAreas = (List<AsArea>) getFacAsistencia().getAsAreaServicio().listarTodos();
		listaTipoPlanilla = getFacPlanilla().getPrTipoplanillaServicio().ListarTipoPlanilla();
		listaPeriodos = getFacPlanilla().getPrProcesoperiodoServicio()
				.listarPeriodosXPlanilla(listaTipoPlanilla.get(0).getPk().getTipoplanilla());
		
		sentenciaSQL = new StringBuilder();
		
		compania = getUsuarioActual().getCompaniaSocioCodigo();
		
		if (!listaTipoPlanilla.isEmpty()) {
			planilla = listaTipoPlanilla.get(0).getPk().getTipoplanilla();
		}
		
		if (!listaPeriodos.isEmpty()) {
			periodo = listaPeriodos.get(0).getPk().getPeriodo();
		}
		
		
		areaoperacion = getUsuarioActual().getAreaCodigo();
		
		certificado = "4ta";
		tipo = "Anual";
		
		return null;
	}
	
	public void limpiarLista() {
		listaEmpleados.clear();
	}

	public Boolean getAll_compania() {
		return all_compania;
	}

	public void setAll_compania(Boolean all_compania) {
		this.all_compania = all_compania;
	}

	public Boolean getAll_planilla() {
		return all_planilla;
	}

	public void setAll_planilla(Boolean all_planilla) {
		this.all_planilla = all_planilla;
	}

	public Boolean getAll_periodo() {
		return all_periodo;
	}

	public void setAll_periodo(Boolean all_periodo) {
		this.all_periodo = all_periodo;
	}

	public Boolean getAll_areaoperacion() {
		return all_areaoperacion;
	}

	public void setAll_areaoperacion(Boolean all_areaoperacion) {
		this.all_areaoperacion = all_areaoperacion;
	}

	public Boolean getCesados() {
		return cesados;
	}

	public void setCesados(Boolean cesados) {
		this.cesados = cesados;
	}

	public String getCertificado() {
		return certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getAreaoperacion() {
		return areaoperacion;
	}

	public void setAreaoperacion(String areaoperacion) {
		this.areaoperacion = areaoperacion;
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

	public List<DtoDwMaCompanyownerSelect> getListaCompanias() {
		return listaCompanias;
	}

	public void setListaCompanias(List<DtoDwMaCompanyownerSelect> listaCompanias) {
		this.listaCompanias = listaCompanias;
	}

	public List<AsArea> getListaAreas() {
		return listaAreas;
	}

	public void setListaAreas(List<AsArea> listaAreas) {
		this.listaAreas = listaAreas;
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

	public StringBuilder getSb() {
		return sentenciaSQL;
	}

	public void setSb(StringBuilder sb) {
		this.sentenciaSQL = sb;
	}

	public List<DtoListaCertificado> getListaEmplados() {
		return listaEmpleados;
	}

	public void setListaEmplados(List<DtoListaCertificado> listaEmplados) {
		this.listaEmpleados = listaEmplados;
	}

	public StringBuilder getSentenciaSQL() {
		return sentenciaSQL;
	}

	public void setSentenciaSQL(StringBuilder sentenciaSQL) {
		this.sentenciaSQL = sentenciaSQL;
	}

	public List<DtoListaCertificado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<DtoListaCertificado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public DtoListaCertificado getEmpleado() {
		return empleadoSeleccionado;
	}

	public void setEmpleado(DtoListaCertificado empleado) {
		this.empleadoSeleccionado = empleado;
	}

	public DtoListaCertificado getEmpleadoSeleccionado() {
		return empleadoSeleccionado;
	}

	public void setEmpleadoSeleccionado(DtoListaCertificado empleadoSeleccionado) {
		this.empleadoSeleccionado = empleadoSeleccionado;
	}

	public StreamedContent getReporte() {
		return reporte;
	}

	public void setReporte(StreamedContent reporte) {
		this.reporte = reporte;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDeduccion() {
		return deduccion;
	}

	public void setDeduccion(String deduccion) {
		this.deduccion = deduccion;
	}

}
