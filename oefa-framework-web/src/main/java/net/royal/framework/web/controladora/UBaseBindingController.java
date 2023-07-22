package net.royal.framework.web.controladora;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.dominio.DominioGenerico;
import net.royal.framework.web.dominio.UsuarioActual;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.model.StreamedContent;

public class UBaseBindingController implements Serializable {

	private static final Log LOGGER = LogFactory
			.getLog(UBaseBindingController.class);

	private UsuarioActual usuarioActual;

	private String pantallaTituloAccion;

	/** The modificacionUsuario. */
	private String modificacionUsuario;

	/** The modificacionFecha. */
	private Date modificacionFecha;

	/** The modificacionTerminal. */
	private String modificacionTerminal;

	/** The creacionUsuario. */
	private String creacionUsuario;

	/** The creacionFecha. */
	private Date creacionFecha;

	/** The creacionTerminal. */
	private String creacionTerminal;

	private String usuarioModificacion;
	private Date fechaModificacion;

	private String usuarioCreacion;
	private Date fechaCreacion;
	
	private String ultimoUsuario;
	private Date ultimaFechaModif;

	private UIMantenimientoController uIMantenimientoController;

	private String idSeguridadConceptoActual;
	private String nombreSeguridadConceptoActual;
	private String idCodigoAplicacion;
	private String idCodigoConcepto;
	private String idCodigoGrupo;
	private Boolean verAyuda;
	private Boolean verProceso;
	private Integer idProcesoActual;
	private String nombreProcesoActual;
	private List<DominioGenerico> listaMenuNavegacion;

	/**
	 * indica cual es la llave del parámetro no encontrado para mostrar mensaje
	 * de error
	 */
	private String parametroNoEncontrado;

	/**
	 * define un nombre de archivo temporal que podra ser usado en forma
	 * generica en un punto especifico de la aplicacion ejemplo:
	 * 
	 * generacion de un archivo de reporte para visualizarlo
	 */
	private String nombreArchivoTemporal;
	
	private StreamedContent reporte;

	public static UBaseBindingController getInstance() {
		return UBaseBindingController.getInstance(null);
	}

	public static UBaseBindingController getInstance(
			UIMantenimientoController uIMantenimientoController) {
		FacesContext context = FacesContext.getCurrentInstance();
		UBaseBindingController obj2 = context.getApplication()
				.evaluateExpressionGet(context, "#{uBaseBindingController}",
						UBaseBindingController.class);
		if (!(uIMantenimientoController == null)) {
			try {
				obj2.setBindingAccion(uIMantenimientoController);
			} catch (Exception e) {
				LOGGER.error(e);
			}
		}
		return obj2;
	}

	public void setBindingAccion(
			UIMantenimientoController uIMantenimientoController)
			throws Exception {
		this.uIMantenimientoController = uIMantenimientoController;
		LOGGER.debug("la conroladora es : " + uIMantenimientoController);
	}

	/**
	 * retorno un objeto de tipo dominio que hereda de <br>
	 * DominioGenerico</br>. con la informacion de auditoria NUEVO
	 * (CreacionFecha,CreacionTerminal,CreacionUsuario) asignada, usado
	 * comunmente en los metodos guardar,insertar,registrar, etc
	 * 
	 * @param dominio
	 *            dominio que hereda de <br>
	 *            DominioGenerico</br> al que se le asignara las variables de
	 *            auditoria NUEVO
	 * @return el objeto dominio modificado
	 */
	public Object getAuditoriaNuevo(Object dominio) {
		this.usuarioActual = this.getUsuarioActual();

		Date fechaHoy = new Date();
		((DominioGenerico) dominio).setCreacionFecha(fechaHoy);
		((DominioGenerico) dominio).setFechaCreacion(fechaHoy);
		
		/*
		 * esto se usa para el caso de un nuevo usuario que no tiene login
		 * o que esta intentando crear una nueva cuenta
		 */
		if (this.usuarioActual!=null){
			((DominioGenerico) dominio).setCreacionTerminal(this.usuarioActual
					.getIpAddressLogin());
			((DominioGenerico) dominio).setCreacionUsuario(this.usuarioActual
					.getLoginUsuario());		
			((DominioGenerico) dominio).setUsuarioCreacion(this.usuarioActual
					.getLoginUsuario());	
		}
				
		return dominio;
	}

	/**
	 * retorno un objeto de tipo dominio que hereda de <br>
	 * DominioGenerico</br>. con la informacion de auditoria NUEVO
	 * (CreacionFecha,CreacionTerminal,CreacionUsuario) asignada, usado
	 * comunmente en los metodos guardar,insertar,registrar, etc
	 * 
	 * @param dominio
	 *            dominio que hereda de <br>
	 *            DominioGenerico</br> al que se le asignara las variables de
	 *            auditoria NUEVO
	 * @return el objeto dominio modificado
	 */
	public Object getAuditoriaNuevoClasico(Object dominio) {
		this.usuarioActual = this.getUsuarioActual();

		Date fechaHoy = new Date();
		((DominioGenerico) dominio).setModificacionFecha(fechaHoy);
		((DominioGenerico) dominio).setModificacionTerminal(null);
		((DominioGenerico) dominio).setModificacionUsuario(this.usuarioActual
				.getLoginUsuario());
		return dominio;
	}

	/**
	 * retorno un objeto de tipo dominio que hereda de <br>
	 * DominioGenerico</br>. con la informacion de auditoria MODIFICAR
	 * (ModificacionFecha, ModificacionTerminal, ModificacionUsuario) asignada,
	 * usado comunmente en los metodos guardar, actualizar, etc
	 * 
	 * @param dominio
	 *            dominio que hereda de <br>
	 *            DominioGenerico</br> al que se le asignara las variables de
	 *            auditoria MODIFICAR
	 * @return el objeto dominio modificado
	 */
	public Object getAuditoriaModificar(Object dominio) // para modificar
	{
		// LOGGER.debug("generando la auditoria del objeto dominio");

		this.usuarioActual = this.getUsuarioActual();

		Date fechaHoy = new Date();
		((DominioGenerico) dominio).setModificacionFecha(fechaHoy);

		((DominioGenerico) dominio).setModificacionTerminal(this.usuarioActual
				.getIpAddressLogin());
		((DominioGenerico) dominio).setModificacionUsuario(this.usuarioActual
				.getLoginUsuario());

		((DominioGenerico) dominio).setFechaModificacion(fechaHoy);

		((DominioGenerico) dominio).setUsuarioModificacion(this.usuarioActual
				.getLoginUsuario());
		
		((DominioGenerico) dominio).setUltimoUsuario(this.usuarioActual
				.getLoginUsuario());
		((DominioGenerico) dominio).setUltimaFechaModif(fechaHoy);

		return dominio;
	}

	/**
	 * retorno un objeto de tipo dominio que hereda de <br>
	 * DominioGenerico</br>. con la informacion de auditoria MODIFICAR
	 * (ModificacionFecha, ModificacionTerminal, ModificacionUsuario) asignada,
	 * usado comunmente en los metodos guardar, actualizar, etc
	 * 
	 * @param dominio
	 *            dominio que hereda de <br>
	 *            DominioGenerico</br> al que se le asignara las variables de
	 *            auditoria MODIFICAR
	 * @return el objeto dominio modificado
	 */
	public Object getAuditoriaModificarClasico(Object dominio) // para modificar
	{
		this.usuarioActual = this.getUsuarioActual();

		Date fechaHoy = new Date();
		((DominioGenerico) dominio).setModificacionFecha(fechaHoy);
		((DominioGenerico) dominio).setModificacionTerminal(null);
		((DominioGenerico) dominio).setModificacionUsuario(this.usuarioActual
				.getLoginUsuario());

		return dominio;
	}

	/**
	 * se utiliza para mostrar la informacion de auditoria en base a un objeto
	 * que hereda de <br>
	 * DominioGenerico</br>
	 * 
	 * 
	 * @param dominio
	 *            dominio que hereda de <br>
	 *            DominioGenerico</br> del cual se toma la informacion para
	 *            mostrar en la auditoria
	 */
	public void setAuditoriaModificar(DominioGenerico dominio) {
		if (dominio == null)
			return;

		creacionFecha = dominio.getCreacionFecha();
		creacionTerminal = dominio.getCreacionTerminal();
		creacionUsuario = dominio.getCreacionUsuario();

		modificacionFecha = dominio.getModificacionFecha();
		modificacionTerminal = dominio.getModificacionTerminal();
		modificacionUsuario = dominio.getModificacionUsuario();

		usuarioModificacion = dominio.getUsuarioModificacion();
		fechaModificacion = dominio.getFechaModificacion();

		usuarioCreacion = dominio.getUsuarioCreacion();
		fechaCreacion = dominio.getFechaCreacion();
		
		ultimoUsuario = dominio.getUltimoUsuario();
		ultimaFechaModif = dominio.getUltimaFechaModif();
	}

	/**
	 * se utiliza para mostrar la informacion de auditoria en base a un objeto
	 * que hereda de <br>
	 * DominioGenerico</br>
	 * 
	 * 
	 * @param dominio
	 *            dominio que hereda de <br>
	 *            DominioGenerico</br> del cual se toma la informacion para
	 *            mostrar en la auditoria
	 */
	public void setAuditoriaModificarClasico(DominioGenerico dominio) {
		if (dominio == null)
			return;
		creacionFecha = null;
		creacionTerminal = "";
		creacionUsuario = "";

		modificacionFecha = dominio.getModificacionFecha();
		modificacionTerminal = "";
		modificacionUsuario = dominio.getModificacionUsuario();
	}

	/**
	 * Inicializa las variables de auditoria para cuando se solicita agregar un
	 * nuevo registro
	 */
	public void setAuditoriaNuevo() // inicializar
	{
		this.usuarioActual = this.getUsuarioActual();

		Date fechaHoy = new Date();
		creacionFecha = fechaHoy;
		
		/*
		 * esto se usa para el caso de un nuevo usuario que no tiene login
		 * o que esta intentando crear una nueva cuenta
		 */
		if (this.usuarioActual!=null){
			creacionTerminal = this.usuarioActual.getIpAddressLogin();
			creacionUsuario = this.usuarioActual.getLoginUsuario();		
			ultimoUsuario =this.usuarioActual.getLoginUsuario() ;	
		}
		
		
		ultimaFechaModif =fechaHoy ;

		modificacionFecha = null;
		modificacionTerminal = "";
		modificacionUsuario = "";
	}

	/**
	 * Inicializa las variables de auditoria para cuando se solicita agregar un
	 * nuevo registro
	 */
	public void setAuditoriaNuevoClasico() // inicializar
	{
		this.usuarioActual = this.getUsuarioActual();

		Date fechaHoy = new Date();
		modificacionFecha = fechaHoy;
		modificacionTerminal = this.usuarioActual.getIpAddressLogin();
		modificacionUsuario = this.usuarioActual.getLoginUsuario();

		LOGGER.debug("setAuditoriaNuevoClasico");
		LOGGER.debug(modificacionTerminal);
		LOGGER.debug(modificacionUsuario);
	}

	public void limpiarHerramientasLista() {
		this.nombreSeguridadConceptoActual = null;
		this.nombreProcesoActual = null;
		idCodigoAplicacion = null;
		idCodigoGrupo = null;
		idCodigoConcepto = null;

		verAyuda = false;
		verProceso = false;
		this.setPantallaTituloAccion(null);
		this.setListaMenuNavegacion(new ArrayList<DominioGenerico>());

	}

	public UsuarioActual getUsuarioActual() {
		usuarioActual = (UsuarioActual) UAplicacion
				.getSessionValue(UConstante.SESION_USUARIOACTUALDOMINIO);
		return usuarioActual;
	}

	public void setUsuarioActual(UsuarioActual usuarioActual) {
		UAplicacion.setSessionValue(UConstante.SESION_USUARIOACTUALDOMINIO,
				usuarioActual);
		this.usuarioActual = usuarioActual;
	}

	public String getModificacionUsuario() {
		return modificacionUsuario;
	}

	public void setModificacionUsuario(String modificacionUsuario) {
		this.modificacionUsuario = modificacionUsuario;
	}

	public Date getModificacionFecha() {
		return modificacionFecha;
	}

	public void setModificacionFecha(Date modificacionFecha) {
		this.modificacionFecha = modificacionFecha;
	}

	public String getModificacionTerminal() {
		return modificacionTerminal;
	}

	public void setModificacionTerminal(String modificacionTerminal) {
		this.modificacionTerminal = modificacionTerminal;
	}

	public String getCreacionUsuario() {
		return creacionUsuario;
	}

	public void setCreacionUsuario(String creacionUsuario) {
		this.creacionUsuario = creacionUsuario;
	}

	public Date getCreacionFecha() {
		return creacionFecha;
	}

	public void setCreacionFecha(Date creacionFecha) {
		this.creacionFecha = creacionFecha;
	}

	public String getCreacionTerminal() {
		return creacionTerminal;
	}

	public void setCreacionTerminal(String creacionTerminal) {
		this.creacionTerminal = creacionTerminal;
	}

	public String getPantallaTituloAccion() {
		return (String) UAplicacion
				.getSessionValue(UConstante.SESION_MENU_PANTALLA_TITULO_ACCION);
	}

	public void setPantallaTituloAccion(String pantallaTituloAccion) {
		UAplicacion.setSessionValue(
				UConstante.SESION_MENU_PANTALLA_TITULO_ACCION,
				pantallaTituloAccion);
		this.pantallaTituloAccion = pantallaTituloAccion;
	}

	public void setIdCodigoAplicacion(String idCodigoAplicacion) {
		this.idCodigoAplicacion = idCodigoAplicacion;
	}

	public Boolean getVerAyuda() {
		return verAyuda;
	}

	public void setVerAyuda(Boolean verAyuda) {
		this.verAyuda = verAyuda;
	}

	public Boolean getVerProceso() {
		return verProceso;
	}

	public void setVerProceso(Boolean verProceso) {
		this.verProceso = verProceso;
	}

	public String getNombreProcesoActual() {
		return nombreProcesoActual;
	}

	public void setNombreProcesoActual(String nombreProcesoActual) {
		this.nombreProcesoActual = nombreProcesoActual;
	}

	public Integer getIdProcesoActual() {
		return idProcesoActual;
	}

	public void setIdProcesoActual(Integer idProcesoActual) {
		this.idProcesoActual = idProcesoActual;
	}

	public String getIdSeguridadConceptoActual() {
		return idSeguridadConceptoActual;
	}

	public void setIdSeguridadConceptoActual(String idSeguridadConceptoActual) {
		this.idSeguridadConceptoActual = idSeguridadConceptoActual;
		if (this.idSeguridadConceptoActual != null) {
			try {
				this.idCodigoAplicacion = this.idSeguridadConceptoActual
						.substring(0, 2);
				this.idCodigoGrupo = this.idSeguridadConceptoActual.substring(
						2, 8);
				this.idCodigoConcepto = this.idSeguridadConceptoActual
						.substring(8);
			} catch (Exception e) {
			}
		}
	}

	public String getNombreSeguridadConceptoActual() {
		return nombreSeguridadConceptoActual;
	}

	public void setNombreSeguridadConceptoActual(
			String nombreSeguridadConceptoActual) {
		this.nombreSeguridadConceptoActual = nombreSeguridadConceptoActual;
	}

	public String getIdCodigoConcepto() {
		return idCodigoConcepto;
	}

	public void setIdCodigoConcepto(String idCodigoConcepto) {
		this.idCodigoConcepto = idCodigoConcepto;
	}

	public String getIdCodigoGrupo() {
		return idCodigoGrupo;
	}

	public void setIdCodigoGrupo(String idCodigoGrupo) {
		this.idCodigoGrupo = idCodigoGrupo;
	}

	public String getIdCodigoAplicacion() {
		return idCodigoAplicacion;
	}

	public List<DominioGenerico> getListaMenuNavegacion() {
		return listaMenuNavegacion;
	}

	public void setListaMenuNavegacion(List<DominioGenerico> listaMenuNavegacion) {
		this.listaMenuNavegacion = listaMenuNavegacion;
		UAplicacion.setSessionValue(UConstante.SESION_MENU_NAVEGACION,
				listaMenuNavegacion);
	}

	/**
	 * define un nombre de archivo temporal que podra ser usado en forma
	 * generica en un punto especifico de la aplicacion ejemplo:
	 * 
	 * generacion de un archivo de reporte para visualizarlo
	 */
	public String getNombreArchivoTemporal() {
		return nombreArchivoTemporal;
	}

	/**
	 * define un nombre de archivo temporal que podra ser usado en forma
	 * generica en un punto especifico de la aplicacion ejemplo:
	 * 
	 * generacion de un archivo de reporte para visualizarlo
	 */
	public void setNombreArchivoTemporal(String nombreArchivoTemporal) {
		this.nombreArchivoTemporal = nombreArchivoTemporal;
	}

	public String getParametroNoEncontrado() {
		return parametroNoEncontrado;
	}

	public void setParametroNoEncontrado(String parametroNoEncontrado) {
		this.parametroNoEncontrado = parametroNoEncontrado;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUltimoUsuario() {
		return ultimoUsuario;
	}

	public void setUltimoUsuario(String ultimoUsuario) {
		this.ultimoUsuario = ultimoUsuario;
	}

	public Date getUltimaFechaModif() {
		return ultimaFechaModif;
	}

	public void setUltimaFechaModif(Date ultimaFechaModif) {
		this.ultimaFechaModif = ultimaFechaModif;
	}

	public StreamedContent getReporte() {
		return reporte;
	}

	public void setReporte(StreamedContent reporte) {
		this.reporte = reporte;
	}

}
