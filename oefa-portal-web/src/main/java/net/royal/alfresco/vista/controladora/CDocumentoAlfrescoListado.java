package net.royal.alfresco.vista.controladora;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.alfresco.dominio.dto.DtoDocumentoAlfresco;
import net.royal.erp.alfresco.dominio.dto.DtoParametros;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.framework.web.dominio.MensajeUsuario;
import net.royal.seguridad.constante.ConstanteSeguridad;
import pe.gob.oefa.ws.alfresco.service.UOefaAlfresco;

@javax.faces.bean.ViewScoped
@ManagedBean
public class CDocumentoAlfrescoListado extends CBaseBean implements UIMantenimientoController {

	private List<DtoDocumentoAlfresco> documentos;
	private DtoParametros paramurl;
	private DtoDocumentoAlfresco documento;

	private String key;
	private String ws;

	private String tonta;

	public CDocumentoAlfrescoListado() {
		PANTALLA_LISTADO = "documentos_alfresco_listado";
	}

	public static CDocumentoAlfrescoListado getInstance() {
		return UFaces.evaluateExpressionGet("#{cDocumentoAlfrescoListado}", CDocumentoAlfrescoListado.class);
	}

	@PostConstruct
	public void init() {
		LOGGER.debug("====INIT LISTADO");
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
		paramurl.setUsuario(new String(
				UValidador.estaVacio((String) params.get("p_usuario")) ? "" : (String) params.get("p_usuario")));
		paramurl.setAccion(new String(
				UValidador.estaVacio((String) params.get("p_accion")) ? "" : (String) params.get("p_accion")));
		paramurl.setCarpeta(new String(
				UValidador.estaVacio((String) params.get("p_carpeta")) ? "" : (String) params.get("p_carpeta")));

		LOGGER.debug("p_session_usuario" + paramurl.getSession_usuario());
		LOGGER.debug("p_proceso" + paramurl.getProceso());
		LOGGER.debug("p_idproceso" + paramurl.getIdproceso());
		LOGGER.debug("p_usuario" + paramurl.getUsuario());
		LOGGER.debug("p_accion" + paramurl.getAccion());
		LOGGER.debug("p_carpeta" + paramurl.getCarpeta());

		try {
			iniciarControladora();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String iniciarControladora() throws Exception {
		// TODO Auto-generated method stub

		// Inicializamos los filtros locales
		inicializarFiltrosListado();

		// Traemos los documentos según los parametros externos
		buscar();

		return PANTALLA_LISTADO;
	}

	@Override
	public String buscar() throws Exception {
		// TODO Auto-generated method stub

		documentos = getFacAlfresco().getGestionAlfrescoServicio().listar(this.paramurl.getSession_usuario(),
				this.paramurl.getProceso(), this.paramurl.getIdproceso());

		LOGGER.debug("documentos " + documentos.size());

		getWebControlContext().actualizar("frmDocumentosAlfrescoListado:dtArchivos");

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

		LOGGER.debug("eliminar()");

		switch (obtenerParametroModoArchivo()) {
		case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

			if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
				this.setMessageError("No se encontraron los parametros key o ws");
				return null;
			}

			if (!UValidador.estaVacio(documento.getUuidalfresco())) {
				//UOefaAlfresco.eliminarDocumento(documento.getUuidalfresco(),  key);
				LOGGER.debug("Se elimino el archivo");
				List<MensajeUsuario> mensajes = getFacAlfresco().getGestionAlfrescoServicio().eliminar(
						this.paramurl.getSession_usuario(), this.paramurl.getProceso(), this.paramurl.getIdproceso(),
						documento.getSecuencia().intValue() + "", documento.getUuidalfresco(),
						this.paramurl.getUsuario());
			}
		}

		getWebControlContext().actualizar("frmDocumentosAlfrescoListado:dtArchivos");
		getWebControlContext().actualizar("frmDocumentosAlfrescoListado");
		buscar();

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

	public List<DtoDocumentoAlfresco> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<DtoDocumentoAlfresco> documentos) {
		this.documentos = documentos;
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWs() {
		return ws;
	}

	public void setWs(String ws) {
		this.ws = ws;
	}

	public String getTonta() {
		LOGGER.debug("====INIT MANTENIMIENT : LA TONTA");

		CDocumentoAlfrescoMantenimiento.getInstance().setParamurl(this.paramurl);

		return tonta;
	}

	public void setTonta(String tonta) {
		this.tonta = tonta;
	}

}
