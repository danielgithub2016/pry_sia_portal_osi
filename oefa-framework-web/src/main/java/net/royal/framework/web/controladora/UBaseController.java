package net.royal.framework.web.controladora;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.dominio.MensajeUsuario;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.dominio.UsuarioActual;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UBaseController implements Serializable {

	private static final Log LOGGER = LogFactory.getLog(UBaseController.class);

	/**
	 * Lista de mensajes de validacion, que se emiten en las validaciones o que
	 * se dan desde la capa de negocio
	 */
	private List<MensajeUsuario> listaMensajeUsuario;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8200656699654599471L;

	/**
	 * The pantalla listado. tiene valores del faces-config.xml
	 * (navigation-case).
	 */
	public String PANTALLA_LISTADO = null;

	/**
	 * The pantalla mantenimiento. tiene valores del faces-config.xml
	 * (navigation-case).
	 */
	public String PANTALLA_MANTENIMIENTO = null;

	/**
	 * The pantalla mensaje final del evalcas. tiene valores del
	 * faces-config.xml (navigation-case).
	 */
	public String PANTALLA_MENSAJE = null;

	/**
	 * The pantalla reporte examen en blanco. tiene valores del faces-config.xml
	 * (navigation-case).
	 */
	public String PANTALLA_REPORTE_01 = null;

	/**
	 * The pantalla reporte examen del postulante. tiene valores del
	 * faces-config.xml (navigation-case).
	 */
	public String PANTALLA_REPORTE_02 = null;

	/**
	 * The pantalla reporte examen en blanco. tiene valores del faces-config.xml
	 * (navigation-case).
	 */
	public String PANTALLA_REPORTE_03 = null;

	/**
	 * The pantalla reporte examen del postulante. tiene valores del
	 * faces-config.xml (navigation-case).
	 */
	public String PANTALLA_REPORTE_04 = null;

	/**
	 * Pantalla con el listado de los postulantes a ser entrevistados. tiene
	 * valores del faces-config.xml (navigation-case).
	 */
	public String PANTALLA_POSTULANTES = null;

	/**
	 * Pantalla con el listado de las aptitudes a ser evaluadas. tiene valores
	 * del faces-config.xml (navigation-case).
	 */
	public String PANTALLA_EVALUACION = null;

	public String PANTALLA_POSTULANTES_SALA = null;

	public String PANTALLA_LISTADO_SALA = null;

	private Integer indiceActivoTabMantenimiento;

	/**
	 * valor entero que identifica cual es el tab actual que se debe de mostrar
	 * en la pagina de mantenimiento
	 **/
	public Integer getIndiceActivoTabMantenimiento() {
		return indiceActivoTabMantenimiento;
	}

	/**
	 * valor entero que identifica cual es el tab actual que se debe de mostrar
	 * en la pagina de mantenimiento
	 **/
	public void setIndiceActivoTabMantenimiento(Integer indiceActivoTabMantenimiento) {
		this.indiceActivoTabMantenimiento = indiceActivoTabMantenimiento;
	}

	public UBaseController() {
		parametros = new ArrayList<ParametroPersistenciaGenerico>();
		iWebControlContext = new UWebControlContextPrimefaces();
	}

	public void mostrarMensajesUsuario() {
		mostrarMensajesUsuario(listaMensajeUsuario);
	}

	public void mostrarMensajesUsuario(List<MensajeUsuario> lista) {
		if (lista == null)
			return;

		for (MensajeUsuario msg : lista) {
			if (msg.getTipoMensaje() == null)
				msg.setTipoMensaje(MensajeUsuario.tipo_mensaje.INFORMACION);
			if (msg.getTipoMensaje().equals(MensajeUsuario.tipo_mensaje.EXITO))
				this.setMessageSuccess(msg.getMensaje());
			if (msg.getTipoMensaje().equals(MensajeUsuario.tipo_mensaje.ERROR))
				this.setMessageError(msg.getMensaje());
			if (msg.getTipoMensaje().equals(MensajeUsuario.tipo_mensaje.ADVERTENCIA))
				this.setMessageWarn(msg.getMensaje());
			if (msg.getTipoMensaje().equals(MensajeUsuario.tipo_mensaje.INFORMACION))
				this.setMessageInfo(msg.getMensaje());
		}
	}

	public void setMessageError(String error) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, error, error));
	}

	/**
	 * Recibe un mensaje y se lo pasa a FaceMessage para que lo muestre en
	 * pantalla como error.
	 *
	 * @param error
	 *            mensaje de error a mostrar en la pagina, tipo String
	 */
	public void setMessageError(String titulo, String error) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, error));
	}

	/**
	 * Recibe un mensaje y se lo pasa a FaceMessage para que lo muestre en
	 * pantalla como mensaje de exito.
	 *
	 * @param msg
	 *            mensaje de exito a mostrar en la pagina, tipo String
	 */
	public void setMessageSuccess(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage(msg, msg));
	}

	public void setMessageSuccess(String msg, Boolean mantener) {
		if (mantener) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage(msg));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
		}
	}

	public void setMessageInfo(String info) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, info, info));
	}

	public void setMessageInfo(String titulo, String info) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, info));
	}

	public void setMessageWarn(String warn) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, warn, warn));
	}

	public void setMessageWarn(String titulo, String info) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, info));
	}

	/**
	 * Retorna el valor de la propiedad inscrita en messages.properties.
	 *
	 * @param propertyId
	 *            id de la propiedad, tipo String
	 * @return valor de la propiedad en el archivo properties, tipo String
	 */
	public static String getMessageProperty(String nombreArchivoMensajes, String propertyId) {
		if (nombreArchivoMensajes == null)
			nombreArchivoMensajes = "comun.messages";
		return UAplicacion.getMessageResourceString(nombreArchivoMensajes, propertyId, null,
				FacesContext.getCurrentInstance().getViewRoot().getLocale());

	}

	public static String getMessageProperty(String propertyId) {
		return UAplicacion.getMessageResourceString(
				FacesContext.getCurrentInstance().getApplication().getMessageBundle(), propertyId, null,
				FacesContext.getCurrentInstance().getViewRoot().getLocale());
	}

	/**
	 * Agrega al requestMap de JSF un objeto cuyo key es el primera parametro.
	 *
	 * @param key
	 *            id para identificar el objeto en el request, tipo String
	 * @param value
	 *            valor del objeto en el request, tipo Object
	 */
	public void setRequestParameter(String key, String value) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().put(key, value);
	}

	/**
	 * Obtiene el Request.
	 *
	 * @return request del contexto de JSF, tipo HttpServletRequest
	 */
	protected HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	/**
	 * Retorna el valor de un parametro del request.
	 *
	 * @param name
	 *            nombre del parametro que viaja en el request, tipo String
	 * @return valor del parametro que viaja en el request, tipo String
	 */
	protected String getRequestParameter(String name) {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
	}

	/**
	 * Obtiene el Response.
	 *
	 * @return request del contexto de JSF, tipo HttpServletResponse
	 */
	protected HttpServletResponse getResponse() {
		return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	}

	/**
	 * Retorna el servletContext.
	 *
	 * @return servletContext, tipo ServletContext
	 */
	protected ServletContext getServletContext() {
		return (ServletContext) getExternalContext().getContext();
	}

	/**
	 * Gets the external context.
	 *
	 * @return the external context
	 */
	protected ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}

	/**
	 * interface de contexto controles. metedos basicos de la suite de controles
	 * ajax
	 *
	 * @return the context del conjunto de librarias graficas que se utilizan en
	 *         las pantallas
	 * 
	 *         ejemplo: org.primefaces.context.RequestContext.getCurrentInstance
	 */
	private UIWebControlContext iWebControlContext;

	/**
	 * interface de contexto controles. metedos basicos de la suite de controles
	 * ajax
	 *
	 * @return the context del conjunto de librarias graficas que se utilizan en
	 *         las pantallas
	 * 
	 *         ejemplo: org.primefaces.context.RequestContext.getCurrentInstance
	 */
	public UIWebControlContext getWebControlContext() {
		return iWebControlContext;
	}

	/**
	 * Agrega al sessionMap de JSF el objecto enviado como parametro. La llave
	 * sera el texto enviado como primer parametro
	 *
	 * @param key
	 *            id para identificar el objeto en sesion, tipo String
	 * @param value
	 *            valor que se podra en sesion, tipo Object
	 */
	protected void setSessionValue(String key, Object value) {
		UAplicacion.setSessionValue(key, value);
	}

	/**
	 * Retorna el objeto (identificado con la llave enviada como parametro) que
	 * se encuentra en el sessionMap de JSF.
	 *
	 * @param key
	 *            id que identifica al objeto en sesion, tipo String
	 * @return objeto en sesion, tipo Object
	 */
	protected Object getSessionValue(String key) {
		return UAplicacion.getSessionMap().get(key);
	}

	/**
	 * Retira un objecto del sessionMap de JSF. Sera identificado segun la llave
	 * enviada como parametro
	 *
	 * @param key
	 *            id del objeto en sesion, tipo String
	 */
	protected void removeSessionValue(String key) {
		UAplicacion.removeSessionValue(key);
	}

	public UsuarioActual getUsuarioActual() {
		return (UsuarioActual) UAplicacion.getSessionMap().get(UConstante.SESION_USUARIOACTUALDOMINIO);
	}

	/**
	 * es el nombre de la accion que se realizara en la pantalla activa que se
	 * este mostrando actualmente, cada controladora debe tener su propia accion
	 * ya que se podria utilizar en una ventana emergente y cada una manejar su
	 * propio titulo ejemplo
	 * 
	 * Personas > Nuevo
	 */
	private String pantallaTituloAccion;

	/**
	 * es el nombre de la accion que se realizara en la pantalla activa que se
	 * este mostrando actualmente, cada controladora debe tener su propia accion
	 * ya que se podria utilizar en una ventana emergente y cada una manejar su
	 * propio titulo ejemplo
	 * 
	 * Personas > Nuevo
	 */
	public String getPantallaTituloAccion() {
		return pantallaTituloAccion;
	}

	/**
	 * es el nombre de la accion que se realizara en la pantalla activa que se
	 * este mostrando actualmente, cada controladora debe tener su propia accion
	 * ya que se podria utilizar en una ventana emergente y cada una manejar su
	 * propio titulo ejemplo
	 * 
	 * Personas > Nuevo
	 */
	public void setPantallaTituloAccion(String pantallaTituloAccion) {
		this.pantallaTituloAccion = pantallaTituloAccion;
	}

	/**
	 * Define el nombre con la que se conoce a la busqueda realizada este nombre
	 * se define en el boton que llamar a la ventana emergente
	 */
	private String nombreTipoBusqueda;

	/**
	 * Define el nombre con la que se conoce a la busqueda realizada este nombre
	 * se define en el boton que llamar a la ventana emergente
	 */
	public String getNombreTipoBusqueda() {
		return nombreTipoBusqueda;
	}

	/**
	 * Define el nombre con la que se conoce a la busqueda realizada este nombre
	 * se define en el boton que llamar a la ventana emergente
	 */
	public void setNombreTipoBusqueda(String nombreTipoBusqueda) {
		this.nombreTipoBusqueda = nombreTipoBusqueda;
	}

	protected List<ParametroPersistenciaGenerico> parametros;

	public List<ParametroPersistenciaGenerico> getParametros() {
		if (parametros == null)
			parametros = new ArrayList<ParametroPersistenciaGenerico>();
		return parametros;
	}

	public void setParametros(List<ParametroPersistenciaGenerico> parametros) {
		this.parametros = parametros;
	}

	/**
	 * especifica el nombre del control html que se debe refrescar despues de
	 * realizar una actualizacion o proceso ejemplo :
	 * frmEjemploLista:pnlPersonaIperPanelGrid dentro de un formulacion se toma
	 * el ID para hacer el refresco
	 */
	protected String nombreContenedorRefrescar;

	/**
	 * especifica el nombre del control html que se debe refrescar despues de
	 * realizar una actualizacion o proceso ejemplo :
	 * frmEjemploLista:pnlPersonaIperPanelGrid dentro de un formulacion se toma
	 * el ID para hacer el refresco
	 */
	public String getNombreContenedorRefrescar() {
		return nombreContenedorRefrescar;
	}

	/**
	 * especifica el nombre del control html que se debe refrescar despues de
	 * realizar una actualizacion o proceso ejemplo :
	 * frmEjemploLista:pnlPersonaIperPanelGrid dentro de un formulacion se toma
	 * el ID para hacer el refresco
	 */
	public void setNombreContenedorRefrescar(String nombreContenedorRefrescar) {
		this.nombreContenedorRefrescar = nombreContenedorRefrescar;
	}

	private UIMantenimientoController iMantenimientoReferencia;

	public UIMantenimientoController getiMantenimientoReferencia() {
		return iMantenimientoReferencia;
	}

	public void setiMantenimientoReferencia(UIMantenimientoController iMantenimientoReferencia) {
		this.iMantenimientoReferencia = iMantenimientoReferencia;
	}

	/**
	 * especifica mediante validaciones del lado del servidor si un proceso o
	 * accion debe continunar o no ejemplo: en una ventana emergente si se
	 * registra una persona se validara en el modulo de RRHH si es una persona
	 * sin deudas
	 */
	private boolean pantallaValida;

	/**
	 * especifica mediante validaciones del lado del servidor si un proceso o
	 * accion debe continunar o no ejemplo: en una ventana emergente si se
	 * registra una persona se validara en el modulo de RRHH si es una persona
	 * sin deudas
	 */
	public boolean isPantallaValida() {
		return pantallaValida;
	}

	/**
	 * especifica mediante validaciones del lado del servidor si un proceso o
	 * accion debe continunar o no ejemplo: en una ventana emergente si se
	 * registra una persona se validara en el modulo de RRHH si es una persona
	 * sin deudas
	 */
	public void setPantallaValida(boolean pantallaValida) {
		this.pantallaValida = pantallaValida;
	}

	/**
	 * especifica el nombre de la ventana emergente que se debe ocultar o
	 * trabajar esta ventana tiene un valor por defecto asignado por
	 * controladora pero se puede cambiar como propiedad
	 */
	private String nombreVentanaEmergente;

	/**
	 * especifica el nombre de la ventana emergente que se debe ocultar o
	 * trabajar esta ventana tiene un valor por defecto asignado por
	 * controladora pero se puede cambiar como propiedad
	 */
	public String getNombreVentanaEmergente() {
		return nombreVentanaEmergente;
	}

	/**
	 * especifica el nombre de la ventana emergente que se debe ocultar o
	 * trabajar esta ventana tiene un valor por defecto asignado por
	 * controladora pero se puede cambiar como propiedad
	 */
	public void setNombreVentanaEmergente(String nombreVentanaEmergente) {
		this.nombreVentanaEmergente = nombreVentanaEmergente;
	}

	/**
	 * cuando en una misma pantalla se define utilizar la misma busqueda mas de
	 * una vez se debe diferenciar que proceo o segmento lo esta utilizando o
	 * llamando en base a un TAG
	 */
	private String nombreTipoBusquedaTag;

	/**
	 * cuando en una misma pantalla se define utilizar la misma busqueda mas de
	 * una vez se debe diferenciar que proceo o segmento lo esta utilizando o
	 * llamando en base a un TAG
	 */
	public String getNombreTipoBusquedaTag() {
		if (nombreTipoBusquedaTag == null)
			return "";
		return nombreTipoBusquedaTag;
	}

	/**
	 * cuando en una misma pantalla se define utilizar la misma busqueda mas de
	 * una vez se debe diferenciar que proceo o segmento lo esta utilizando o
	 * llamando en base a un TAG
	 */
	public void setNombreTipoBusquedaTag(String nombreTipoBusquedaTag) {
		this.nombreTipoBusquedaTag = nombreTipoBusquedaTag;
	}

	/**
	 * <br>
	 * pantallaOrigenLlamada</br>
	 * , este valor esta en NULL, si tiene algun valor se usa como comando para
	 * redireccionar en lugar de las clasicas LISTADO y MANTENIMIENTO. este es
	 * un valor auxiliar que tiene valores del faces-config.xml
	 * (navigation-case)
	 */
	public String pantallaOrigenLlamada = null;

	/**
	 * <br>
	 * pantallaOrigenLlamada</br>
	 * , este valor esta en NULL, si tiene algun valor se usa como comando para
	 * redireccionar en lugar de las clasicas LISTADO y MANTENIMIENTO. este es
	 * un valor auxiliar que tiene valores del faces-config.xml
	 * (navigation-case)
	 */
	public String getPantallaOrigenLlamada() {
		return pantallaOrigenLlamada;
	}

	/**
	 * <br>
	 * pantallaOrigenLlamada</br>
	 * , este valor esta en NULL, si tiene algun valor se usa como comando para
	 * redireccionar en lugar de las clasicas LISTADO y MANTENIMIENTO. este es
	 * un valor auxiliar que tiene valores del faces-config.xml
	 * (navigation-case)
	 */
	public void setPantallaOrigenLlamada(String pantallaOrigenLlamada) {
		this.pantallaOrigenLlamada = pantallaOrigenLlamada;
	}

	/**
	 * es el nombre temporal de que otra pantalla o proceso lo ha llamado debe
	 * ir la informacion consisa ejemplo. Busqueda de Puestos ( IPER 203 )
	 */
	private String pantallaTituloReferente;

	/**
	 * es el nombre temporal de que otra pantalla o proceso lo ha llamado debe
	 * ir la informacion consisa ejemplo. Busqueda de Puestos ( IPER 203 )
	 */
	public String getPantallaTituloReferente() {
		String retorno = pantallaTituloReferente;
		if (retorno != null)
			retorno = " ( " + retorno + " ) ";
		return retorno;
	}

	/**
	 * es el nombre temporal de que otra pantalla o proceso lo ha llamado debe
	 * ir la informacion consisa ejemplo. Busqueda de Puestos ( IPER 203 )
	 */
	public void setPantallaTituloReferente(String pantallaTituloReferente) {
		this.pantallaTituloReferente = pantallaTituloReferente;
	}

	public void setPantallaTituloReferenteAsignar(String descripionReferencia, String pantallaTituloReferente) {
		if (pantallaTituloReferente == null) {
			this.pantallaTituloReferente = null;
			return;
		}
		this.setPantallaTituloReferente(descripionReferencia + pantallaTituloReferente);
	}

	public List<MensajeUsuario> getListaMensajeUsuario() {
		return listaMensajeUsuario;
	}

	public void setListaMensajeUsuario(List<MensajeUsuario> listaMensajeUsuario) {
		this.listaMensajeUsuario = listaMensajeUsuario;
	}

}