package net.royal.alfresco.vista.controladora;

import java.math.BigDecimal;
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
import net.royal.seguridad.constante.ConstanteSeguridad;

@ManagedBean
@javax.faces.bean.ViewScoped
public class CDocumentoAlfrescoApplet extends CBaseBean implements UIMantenimientoController {

	private static final long serialVersionUID = 1L;

	// Objeto que contiene los parametros externos a la aplicación.
	private DtoParametros paramurl;

	// Objeto principal que realiza la transacción.
	private DtoDocumentoAlfresco documento;

	private String key;

	private String ws;

	private String tamanioArchivo = "";

	private Integer tamanioBytes;

	public CDocumentoAlfrescoApplet() {
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
		paramurl.setCarpeta(new String(UValidador.estaVacio((String) params.get("p_carpeta")) ? "SISUD/2015"
				: (String) params.get("p_carpeta")));

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

	public static CDocumentoAlfrescoApplet getInstance() {
		return UFaces.evaluateExpressionGet("#{cDocumentoAlfrescoApplet}", CDocumentoAlfrescoApplet.class);
	}

	@Override
	public String iniciarControladora() throws Exception {

		if (UValidador.esNulo(documento)) {
			documento = new DtoDocumentoAlfresco();
		}

		obtenerParametroModoArchivo();

		return null;
	}

	@Override
	public String buscar() throws Exception {
		return null;
	}

	@Override
	public String nuevo() throws Exception {

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

	@Override
	public String guardar() throws Exception {
		return null;

	}

	@Override
	public String salir() throws Exception {
		return null;
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

}
