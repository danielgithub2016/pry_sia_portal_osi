package pe.gob.oefa.ws.alfresco.service;

import java.io.File;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import net.royal.alfresco.ws.ContenidoECMBean;
import net.royal.alfresco.ws.RptaWsBean;
import net.royal.alfresco.ws.WsCmsService;
import net.royal.framework.web.core.PropertiesUtil;
import net.royal.framework.web.core.UArchivoPropiedades;
import net.royal.seguridad.constante.ConstanteSeguridad;
import pe.gob.osinergmin.apirest.alfresco.AlfrescoConnector;
import pe.gob.osinergmin.apirest.body.response.NodeResponse;
import pe.gob.osinergmin.apirest.exception.AlfrescoConnectorException;

@SuppressWarnings("serial")
public class UOsinergminAlfresco implements Serializable {

	/**
	 * Variable para tomar milisegundos del día
	 */
	protected static Logger LOGGER = Logger.getLogger(UOsinergminAlfresco.class);

	public static final String RUTA_MATERIALES = "MATERIAL_CAPACITACION/";
	public static final String RUTA_POSTULANTES = "POSTULANTES/FOTOS";
	public static final String RUTA_POSTULANTES_CV = "POSTULANTES/CV";
	public static final String RUTA_DOCUMENTO_CAPACITACION = "DOCUMENTOS_CAPACITACION/";
	public static final String RUTA_REQUERIMIENTO = "REQUERIMIENTOS_PERSONAL/";
	public static final String RUTA_ASISTENCIA = "SOLICITUD_ASISTENCIA/";
	public static final String RUTA_EMPLEADO_FOLIOS = "EMPLEADO_FOLIOS/";
	public static final String RUTA_WEB = "WEB/";
	public static final String ALFRESCO_WS_HOST = "alfresco.host";
	public static final String ALFRESCO_WS_USER = "alfresco.user";
	public static final String ALFRESCO_WS_PASS = "alfresco.pass";
	public static final String ALFRESCO_WS_CARPETA_BASE = "alfresco.carpeta.base";

	private static final String FORMATO_TIMESTAMP_ARCHIVOS = "ddMMyyyyHHmmss";

	private AlfrescoConnector alfConnector;
	private String user;
	private String pass;
	private String rutaBase;

	public UOsinergminAlfresco() {
		alfConnector = new AlfrescoConnector(UArchivoPropiedades.getProperty(ALFRESCO_WS_HOST));
		user = UArchivoPropiedades.getProperty(ALFRESCO_WS_USER);
		pass = UArchivoPropiedades.getProperty(ALFRESCO_WS_PASS);
		rutaBase = UArchivoPropiedades.getProperty(ALFRESCO_WS_CARPETA_BASE);
		
//		alfConnector = new AlfrescoConnector(PropertiesUtil.getProp(ALFRESCO_WS_HOST));
//		user = PropertiesUtil.getProp(ALFRESCO_WS_USER);
//		pass = PropertiesUtil.getProp(ALFRESCO_WS_PASS);
//		rutaBase = PropertiesUtil.getProp(ALFRESCO_WS_CARPETA_BASE);
	}

	public ContenidoECMBean obtenerDocumento(String uuid) {

		ContenidoECMBean retorno = new ContenidoECMBean();

		String ticket;
		byte[] data;

		ticket = alfConnector.getTicket(user, pass);

		try {
			data = alfConnector.getBytesNode(uuid, ticket);
			retorno.setCodMsg("ok");
			retorno.setContenidoFile(data);
		} catch (Exception e) {
			throw new AlfrescoConnectorException("No se puede descargar el archivo", Integer.valueOf(20003));
		}

		return retorno;
	}

	public RptaWsBean registrarDocumento(String nomFile, String ruta, File file) throws RemoteException {

		RptaWsBean retorno = new RptaWsBean();
		NodeResponse node = null;
		ruta = this.rutaBase + "/" + ruta;
		String filePath = ruta + "/" + nomFile;

		// nomFile = generarNombreArchivoMarcaTiempo(nomFile);

		try {
			if (alfConnector.isNodeExists(user, pass, filePath)) {
				node = alfConnector.modifyBinaryContent(user, pass, filePath, "file", file);
				retorno.setCodMsg("OK");
				retorno.setUuid(node.getEntry().getId());
			} else {

				node = alfConnector.createCustomNode(user, pass, ruta, nomFile, "file", new HashMap());

				if (!node.hasError()) {
					node = alfConnector.modifyBinaryContent(user, pass, filePath, "file", file);

					if (node != null && !(node.getEntry() != null)) {
						alfConnector.deleteNode(user, pass, filePath);
					} else {
						alfConnector.addAspect(user, pass, filePath, "cm:versionable");
					}

					retorno.setCodMsg("OK");
					retorno.setUuid(node.getEntry().getId());
				}
			}
		} catch (Exception e) {
			retorno.setCodMsg("ERROR");
			retorno.setCadMsg(e.getMessage());
		}

		return retorno;
	}

	private static String generarNombreArchivoMarcaTiempo(String nombreArchivo) {
		String marcaFecha;
		SimpleDateFormat formatoMarca;
		String nombreBase;
		String extension;

		nombreBase = FilenameUtils.getBaseName(nombreArchivo);
		extension = FilenameUtils.getExtension(nombreArchivo);
		formatoMarca = new SimpleDateFormat(FORMATO_TIMESTAMP_ARCHIVOS);
		marcaFecha = formatoMarca.format(new Date());
		return String.format("%s_%s.%s", nombreBase, marcaFecha, extension);
	}

	public static RptaWsBean eliminarDocumento(String uuid, String key) {
		return new WsCmsService().getWsCmsPort().eliminarDocumento(key, uuid);
	}

}