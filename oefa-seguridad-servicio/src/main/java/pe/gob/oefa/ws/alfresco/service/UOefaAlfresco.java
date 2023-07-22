package pe.gob.oefa.ws.alfresco.service;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import net.royal.alfresco.ws.ContenidoECMBean;
import net.royal.alfresco.ws.RptaWsBean;
import net.royal.alfresco.ws.WsCmsService;

@SuppressWarnings("serial")
public class UOefaAlfresco implements Serializable {
	
	/**
	 * Variable para tomar milisegundos del día
	 */
	private static final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;

	protected static Logger LOGGER = Logger.getLogger(UOefaAlfresco.class);

	public static final String RUTA_MATERIALES = "WEB/MATERIAL_CAPACITACION/";
	public static final String RUTA_POSTULANTES = "WEB/POSTULANTES/FOTOS";
	public static final String RUTA_POSTULANTES_CV = "WEB/POSTULANTES/CV";
	public static final String RUTA_DOCUMENTO_CAPACITACION = "WEB/DOCUMENTOS_CAPACITACION/";
	public static final String RUTA_REQUERIMIENTO = "WEB/REQUERIMIENTOS_PERSONAL/";
	public static final String RUTA_ASISTENCIA = "WEB/SOLICITUD_ASISTENCIA/";
	public static final String RUTA_EMPLEADO_FOLIOS = "WEB/EMPLEADO_FOLIOS/";
	public static final String RUTA_WEB = "WEB/";
	private static final String FORMATO_TIMESTAMP_ARCHIVOS = "ddMMyyyyHHmmss";

	public static ContenidoECMBean obtenerDocumento(String uuid, String key) {
		return new WsCmsService().getWsCmsPort().leerDocumento(key, uuid);
	}

	public static RptaWsBean registrarDocumento(String nomFile, String ruta, byte[] file, String key)
			throws RemoteException {
		LOGGER.debug(String.format("UOefaAlfresco.registrarDocumento(%s,%s,%s)", nomFile, ruta, key));
		nomFile = generarNombreArchivoMarcaTiempo(nomFile);
		System.out.println("ruta " + ruta);
		return new WsCmsService().getWsCmsPort().registrarDocumento(key, nomFile, ruta, file);
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