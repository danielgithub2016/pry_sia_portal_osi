package net.royal.alfresco.vista.controladora;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FileUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import net.royal.alfresco.ws.RptaWsBean;
import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.alfresco.dominio.dto.DtoDocumentoAlfresco;
import net.royal.erp.alfresco.dominio.dto.DtoParametros;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.framework.web.dominio.MensajeUsuario;
import net.royal.seguridad.constante.ConstanteSeguridad;
import pe.gob.oefa.ws.alfresco.service.UOefaAlfresco;

@ManagedBean
@javax.faces.bean.ViewScoped
public class CDocumentoAlfrescoMantenimiento extends CBaseBean implements UIMantenimientoController {

	private static final long serialVersionUID = 1L;

	// Objeto pra la carga de documentos en memoria.
	private UploadedFile fileUpload;

	// Objeto que contiene los parametros externos a la aplicación.
	private DtoParametros paramurl;

	// Objeto principal que realiza la transacción.
	private DtoDocumentoAlfresco documento;

	private String key;

	private String ws;

	private String tamanioArchivo = "";

	private Integer tamanioBytes;

	private String novalida;

	// Booleano que permite mostrar el boton cancelar
	// Cuando es llamado de una aplicación externa = false.
	private Boolean ismostrarbtncancelar;

	// Permite obtne la utima uuid genrada y eliminarla en caso se genere una
	// nueva.
	private String uuidant;

	private String uidRespuesta;
	private String codRespuesta;

	public CDocumentoAlfrescoMantenimiento() {
		PANTALLA_LISTADO = "documentos_alfresco_listado";
		PANTALLA_MANTENIMIENTO = "documentos_alfresco_mantenimiento";
	}

	@PostConstruct
	public void init() {
		LOGGER.debug("====INIT MANTENIMIENT");
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Map params = externalContext.getRequestParameterMap();

		paramurl = new DtoParametros();
		paramurl.setSession_usuario(new String(UValidador.estaVacio((String) params.get("p_session_usuario")) ? ""
				: (String) params.get("p_session_usuario")));
		paramurl.setProceso(new String(
				UValidador.estaVacio((String) params.get("p_proceso")) ? "" : (String) params.get("p_proceso")));
		paramurl.setIdproceso(new String(
				UValidador.estaVacio((String) params.get("p_idproceso")) ? "" : (String) params.get("p_idproceso")));
		paramurl.setUuid(new String(UValidador.estaVacio(params.get("p_uuid")) ? "" : (String) params.get("p_uuid")));
		paramurl.setUsuario(new String(
				UValidador.estaVacio((String) params.get("p_usuario")) ? "" : (String) params.get("p_usuario")));
		paramurl.setAccion(new String(
				UValidador.estaVacio((String) params.get("p_accion")) ? "" : (String) params.get("p_accion")));

		LOGGER.debug("p_session_usuario" + paramurl.getSession_usuario());
		LOGGER.debug("p_proceso" + paramurl.getProceso());
		LOGGER.debug("p_idproceso" + paramurl.getIdproceso());
		LOGGER.debug("p_uuis" + paramurl.getUuid());
		LOGGER.debug("p_usuario" + paramurl.getUsuario());
		LOGGER.debug("p_accion" + paramurl.getAccion());

		try {
			iniciarControladora();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static CDocumentoAlfrescoMantenimiento getInstance() {
		return UFaces.evaluateExpressionGet("#{cDocumentoAlfrescoMantenimiento}",
				CDocumentoAlfrescoMantenimiento.class);
	}

	@Override
	public String iniciarControladora() throws Exception {

		if (UValidador.esNulo(documento)) {
			documento = new DtoDocumentoAlfresco();
		}

		documento.setError("");

		uuidant = this.paramurl.getUuid();
		ismostrarbtncancelar = false;
		return null;
	}

	@Override
	public String buscar() throws Exception {
		return null;
	}

	@Override
	public String nuevo() throws Exception {

		LOGGER.debug("nuevo() ");

		ismostrarbtncancelar = true;
		inicializarDatosMantenimiento();

		if (UValidador.esListaVacia(CDocumentoAlfrescoListado.getInstance().getDocumentos())) {
			uuidant = null;
		}

		documento = new DtoDocumentoAlfresco();
		fileUpload = null;

		getWebControlContext().ejecutar("PF('popDocumentoMantenimiento').show()");
		getWebControlContext().actualizar("dgDocumentoMantenimiento");

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

	public void guardarDesdeJS() {
		LOGGER.debug("------------------------------------------------------------------------------");
		LOGGER.debug(uidRespuesta);
		LOGGER.debug(codRespuesta);
		getWebControlContext().ejecutar("PF('popDocumentoMantenimiento').hide()");
		getWebControlContext().ejecutar("window.location.reload(true);");
	}

	@Override
	public String guardar() throws Exception {

		if (UValidador.esNulo(fileUpload)) {
			setMessageError("Debe seleccionar un archivo.");
			mostrarError(new Exception("Debe seleccionar un archivo."));
			return null;
		}

		switch (obtenerParametroModoArchivo()) {
		case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

			if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
				this.setMessageError("No se encontraron los parametros key o ws");
				mostrarError(new Exception("No se encontraron los parametros key o ws"));
				return null;
			}

			// si cambio de documento y ya existe en alfresco
			// if (!UValidador.estaVacio(uuidant)) {
			// try {
			// UOefaAlfresco.eliminarDocumento(uuidant, key);
			// LOGGER.debug(String.format("Se elimino el archivo uid:%s nombre
			// %s", documento.getUuidalfresco(),
			// documento.getNombre()));
			// } catch (Exception e) {
			// LOGGER.debug(e.getMessage());
			//
			// mostrarError(e);
			//
			// this.setMessageError("Ocurrio un error al comunicarse con el ws\n
			// no se pudo cambiar el archivo");
			// return null;
			// }
			// }

			if (!UValidador.estaVacio(documento.getNombre())) {
				try {
					LOGGER.debug("Archivo a guardar " + documento.getNombre());

					// if (!UValidador.estaVacio(documento.getUuidalfresco())) {
					// RptaWsBean respuestawsEliminando =
					// getuOsinergminAlfresco().eliminarDocumento(documento.getUuidalfresco(),
					// key);
					// }

					File file = new File(UAplicacion.getRealPath() + File.separator + "temporaloefa" + File.separator
							+ UFile.archivoUnico() + fileUpload.getFileName());
					FileUtils.writeByteArrayToFile(file, fileUpload.getContents());

					RptaWsBean respuestaws = getuOsinergminAlfresco().registrarDocumento(documento.getNombre(),
							this.paramurl.getCarpeta() + "/", file);

					LOGGER.error(respuestaws);

					System.gc();

					if (respuestaws.getCodMsg().equalsIgnoreCase("ok")) {
						documento.setUuidalfresco(respuestaws.getUuid());
						if (this.paramurl.getAccion().equals(accion_solicitada.NUEVO.toString())) {
							List<MensajeUsuario> mensajes = getFacAlfresco().getGestionAlfrescoServicio().registrar(
									this.paramurl.getSession_usuario(), this.paramurl.getProceso(),
									this.paramurl.getIdproceso(), documento.getNombre(), documento.getUuidalfresco(),
									this.paramurl.getUsuario());
						}
						if (this.paramurl.getAccion().equals(accion_solicitada.EDITAR.toString())) {
							List<MensajeUsuario> mensajes = getFacAlfresco().getGestionAlfrescoServicio().actualizar(
									this.paramurl.getSession_usuario(), this.paramurl.getProceso(),
									this.paramurl.getIdproceso(), null, documento.getNombre(),
									documento.getUuidalfresco(), this.paramurl.getUsuario());
						}

						uuidant = respuestaws.getUuid();

						LOGGER.error("registro correctamente");
						getWebControlContext().ejecutar("PF('popDocumentoMantenimiento').hide()");
						CDocumentoAlfrescoListado.getInstance().iniciarControladora();
						setMessageSuccess("Se guardó correctamente");

						return null;

					} else {
						LOGGER.error("ERROR DEL WS");

						mostrarError(new Exception("WEB SERVICES : " + respuestaws.getCadMsg()));

						this.setMessageError(respuestaws.getCadMsg());
						return null;
					}
				} catch (Exception e) {
					LOGGER.error(e.getMessage());

					mostrarError(e);

					this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
					return null;
				}
			}
		}
		return null;
	}

	private void mostrarError(Exception e) {
		if (documento == null)
			documento = new DtoDocumentoAlfresco();
		documento.setError(e.getMessage());
		getWebControlContext().actualizar("frmDocumentosAlfrescoMantenimiento");
	}

	private String obtenerEstructuraDefecto(String proceso) {
		// TODO Auto-generated method stub
		String retorno = null;

		retorno = getFacCore().getParametrosmastServicio()
				.obtenerValorExplicacion(new ParametrosmastPk("SP", "999999", proceso));

		LOGGER.debug("retorno " + retorno);

		if (UValidador.estaVacio(retorno)) {
			retorno = UOefaAlfresco.RUTA_WEB;
		}

		return retorno;
	}

	@Override
	public String salir() throws Exception {
		getWebControlContext().ejecutar("PF('popCargaCorrecta').hide()");
		getWebControlContext().ejecutar("PF('popdocumento').hide()");

		return CDocumentoAlfrescoListado.getInstance().iniciarControladora();
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

		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		BigDecimal tamArchivo = new BigDecimal(2);

		ParametrosmastPk pk = new ParametrosmastPk("HR", "999999", "TAMAARCH");
		Integer tamanioMB = this.getFacCore().getParametrosmastServicio().obtenerValorInteger(pk);

		if (UValidador.esNulo(tamanioMB)) {
			tamanioMB = 2;
		}

		tamArchivo = new BigDecimal(tamanioMB).multiply(new BigDecimal(1024));
		tamArchivo = tamArchivo.multiply(new BigDecimal(1024));

		tamanioBytes = tamArchivo.intValue();
		tamanioArchivo = tamanioMB.toString() + " MB";

		return null;
	}

	private String obtenerParametroModoArchivo() {
		String modo = ConstanteSeguridad.PARAMETRO_MODOARCHIVO_BD;
		ParametrosmastPk pk = new ParametrosmastPk("HR", "999999", "MODOARCHIV");
		String param = this.getFacCore().getParametrosmastServicio().obtenerValorCadena(pk);
		if (!UValidador.estaVacio(param)) {
			modo = param;
		} else {
			this.setMessageInfo("No se encontró el parámetro MODOARCHIV. Se tomó valor por defecto");
		}

		key = this.getFacCore().getParametrosmastServicio()
				.obtenerValorExplicacion(new ParametrosmastPk("SP", "999999", "KEYALFRESC"));
		ws = this.getFacCore().getParametrosmastServicio()
				.obtenerValorExplicacion(new ParametrosmastPk("SP", "999999", "WSALFRESCO"));
		return modo;
	}

	public void handleFileUpload(FileUploadEvent event) {
		fileUpload = event.getFile();
		documento.setNombre(fileUpload.getFileName());
		getWebControlContext().actualizar("frmDocumentosAlfrescoMantenimiento");
	}

	public UploadedFile getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(UploadedFile fileUpload) {
		this.fileUpload = fileUpload;
	}

	public DtoDocumentoAlfresco getDocumento() {
		return documento;
	}

	public void setDocumento(DtoDocumentoAlfresco documento) {
		this.documento = documento;
	}

	public DtoParametros getParamurl() {
		return paramurl;
	}

	public void setParamurl(DtoParametros paramurl) {
		this.paramurl = paramurl;
	}

	public String getTamanioArchivo() {
		return tamanioArchivo;
	}

	public void setTamanioArchivo(String tamanioArchivo) {
		this.tamanioArchivo = tamanioArchivo;
	}

	public Integer getTamanioBytes() {
		return tamanioBytes;
	}

	public void setTamanioBytes(Integer tamanioBytes) {
		this.tamanioBytes = tamanioBytes;
	}

	public Boolean getIsmostrarbtncancelar() {
		return ismostrarbtncancelar;
	}

	public void setIsmostrarbtncancelar(Boolean ismostrarbtncancelar) {
		this.ismostrarbtncancelar = ismostrarbtncancelar;
	}

	public String getNovalida() {
		return novalida;
	}

	public void setNovalida(String novalida) {
		this.novalida = novalida;
	}

	public String getUidRespuesta() {
		return uidRespuesta;
	}

	public void setUidRespuesta(String uidRespuesta) {
		this.uidRespuesta = uidRespuesta;
	}

	public String getCodRespuesta() {
		return codRespuesta;
	}

	public void setCodRespuesta(String codRespuesta) {
		this.codRespuesta = codRespuesta;
	}

}
