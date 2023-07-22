package net.royal.alfresco.vista.controladora;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import net.royal.alfresco.ws.ContenidoECMBean;
import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.alfresco.dominio.dto.DtoParametros;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.seguridad.constante.ConstanteSeguridad;
import pe.gob.oefa.ws.alfresco.service.UOefaAlfresco;

@ManagedBean
@javax.faces.bean.ViewScoped
public class CDocumentoAlfrescoDescarga extends CBaseBean implements UIMantenimientoController {

	private static final long serialVersionUID = 1L;

	// Objeto que contiene los parametros externos a la aplicación.
	private DtoParametros paramurl;

	// Identificador uuid de alfresco
	private String uuid;

	// Nombre del archivo
	private String nombre;

	private String key;

	private String ws;

	// boolean para ejecutar solo una vez la vista previa
	private boolean isverejecutado;

	public CDocumentoAlfrescoDescarga() {
		PANTALLA_LISTADO = "documentos_alfresco_listado";
		PANTALLA_MANTENIMIENTO = "documentos_alfresco_mantenimiento";
	}

	@PostConstruct
	public void init() {

		isverejecutado = false;

		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Map params = externalContext.getRequestParameterMap();

		paramurl = new DtoParametros();
		paramurl.setProceso(new String(
				UValidador.estaVacio((String) params.get("p_proceso")) ? "" : (String) params.get("p_proceso")));
		paramurl.setUuid(
				new String(UValidador.estaVacio((String) params.get("p_uuid")) ? "" : (String) params.get("p_uuid")));

		LOGGER.debug("p_proceso" + paramurl.getProceso());
		LOGGER.debug("p_uuid" + paramurl.getUuid());

		uuid = paramurl.getUuid();
		nombre = "";
	}

	public static CDocumentoAlfrescoDescarga getInstance() {
		return UFaces.evaluateExpressionGet("#{cDocumentoAlfrescoMantenimiento}", CDocumentoAlfrescoDescarga.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
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

		if (isverejecutado) {
			// FacesContext.getCurrentInstance().responseComplete();
			return "documentos_alfresco_error";
		}
		LOGGER.debug("p_uuid" + uuid);

		if (!UValidador.estaVacio(uuid)) {
			switch (obtenerParametroModoArchivo()) {
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

				if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
					this.setMessageError("No se encontraron los parametros key o ws");
					return null;
				}

				try {
					// System.gc();
					ContenidoECMBean respuestaconsulta = getuOsinergminAlfresco().obtenerDocumento(uuid);
					nombre = respuestaconsulta.getNombreArchivo();
					if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
						LOGGER.debug("Se encontro el archivo");
						CAlfrescoUtil.view(respuestaconsulta.getContenidoFile(), respuestaconsulta.getNombreArchivo());
						// System.gc();
						return null;
					} else {
						setMessageError("No se encontró el documento en Alfresco");
						isverejecutado = true;
						return null;
					}
				} catch (Exception e) {
					e.printStackTrace();
					this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo obtener el archivo");
					return null;
				}
			}
		} else {
			if (!UValidador.estaVacio(nombre)) {
				new UFile().cargarArchivoXByte(UFile.obtenerArregloByte(nombre), nombre,
						UConstante.CONSTANTE_CARPETA_TEMPORAL_ALFRESCO);
			} else {
				setMessageError("No ha seleccionado ningún archivo");
				return null;
			}
		}

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
		return PANTALLA_LISTADO;
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

	public DtoParametros getParamurl() {
		return paramurl;
	}

	public void setParamurl(DtoParametros paramurl) {
		this.paramurl = paramurl;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
