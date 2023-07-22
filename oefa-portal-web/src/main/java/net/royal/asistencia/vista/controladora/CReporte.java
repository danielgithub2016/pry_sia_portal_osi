package net.royal.asistencia.vista.controladora;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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
import net.royal.erp.asistencia.dominio.dto.DtoFiltrosGenericos;
import net.royal.erp.core.dominio.dto.DtoPersonamast;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CReporte extends CBaseBean implements UIMantenimientoController {

	private StreamedContent reporte;

	private DtoFiltrosGenericos datos;
	private List<DtoPersonamast> prueba;

	public static CReporte getInstance() {
		return UFaces.evaluateExpressionGet("#{cReporte}", CReporte.class);
	}

	public CReporte() {
		this.PANTALLA_LISTADO = "probandoreporte";
	}

	@Override
	public String iniciarControladora() throws Exception {
		inicializarFiltrosListado();
		return this.PANTALLA_LISTADO;
	}

	public String imprimir() throws Exception {

		String pathPrincipal;
		byte[] nombreArchivoPDF;
		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext()).getRealPath("/");

		Map<String, Object> parametrosReport = new HashMap<String, Object>();

		File archivo = new File(pathPrincipal + File.separator + "erp"
				+ File.separator + "asistencia" + File.separator + "recursos"
				+ File.separator + File.separator + "reportes" + File.separator
				+ "reporte_asistencia" + File.separator + "reporte1.jasper");

		parametrosReport.put("DETALLE", prueba);
		parametrosReport.put("fechadesde", datos.getFechadesde());
		parametrosReport.put("fechahasta", datos.getFechahasta());
		parametrosReport.put("usuario", this.getUsuarioActual()
				.getCodigoUsuario());
		parametrosReport.put("ip", this.getUsuarioActual().getIpAddressLogin());
		parametrosReport.put("ambiente", "");


		nombreArchivoPDF = getFacSeguridad().getPersonamastServicio()
				.ejecutarReporteComoPDFDesdeLista(archivo.getPath(),
						parametrosReport, prueba);


		reporte = new DefaultStreamedContent(new ByteArrayInputStream(
				nombreArchivoPDF), "application/pdf");

		// LOGGER.debug(reporte);
		return null;
	}

	@Override
	public String buscar() throws Exception {

		if (!validar()) {
			prueba = this.getFacCore().getPersonamastServicio().filtroTodo();
		} else {
			prueba = this.getFacCore().getPersonamastServicio()
					.filtrofecha(datos.getFechadesde(), datos.getFechahasta());
		}

		// LOGGER.debug(prueba);

		imprimir();
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
		boolean validacion = true;

		if (datos.getFechadesde() == null || datos.getFechahasta() == null) {
			validacion = false;
		}

		return validacion;
	}

	public void limpiar() {
		datos.setFechadesde(null);
		datos.setFechahasta(null);
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
		prueba = new ArrayList<DtoPersonamast>();
		datos = new DtoFiltrosGenericos();
		Boolean isadmin = getFacSeguridad()
				.getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
						getUsuarioActual().getAplicacionCodigo(),
						getUsuarioActual().getLoginUsuario().toUpperCase());

		Date[] fechas = this.getFacAsistencia().getAsPeriodoServicio()
				.obtenerFechasActivas(isadmin ? "S" : "N");
		datos.setFechadesde(fechas[0]);
		datos.setFechahasta(fechas[1]);
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		return null;
	}

	public StreamedContent getReporte() {
		return reporte;
	}

	public void setReporte(StreamedContent reporte) {
		this.reporte = reporte;
	}

	public DtoFiltrosGenericos getDatos() {
		return datos;
	}

	public void setDatos(DtoFiltrosGenericos datos) {
		this.datos = datos;
	}

	public List<DtoPersonamast> getPrueba() {
		return prueba;
	}

	public void setPrueba(List<DtoPersonamast> prueba) {
		this.prueba = prueba;
	}

}
