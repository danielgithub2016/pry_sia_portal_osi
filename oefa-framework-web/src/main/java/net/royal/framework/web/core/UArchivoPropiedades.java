/**
 * Resumen
 * Objeto                  :PropertiesReader.java
 * Descripcion             :Clase que archivos properties para obtener
 * 							parametros generales del sistema que podrian
 * 							ser cambiados en caliente como: nombre de
 * 							base de datos, puerto, etc. La intencion es no
 * 							tener codigo en duro que impida la flexibilidad
 * 							del cambio de datos segun ambiente de produccion
 * 							y/o desarrollo.
 * Fecha de Creacion       :28/10/2011
 * PE de Creación 		   :SIGA-WORKFLOW
 * Autor                   :Roger Panayfo
 */
package net.royal.framework.web.core;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Clase que archivos properties para obtener parametros generales del sistema
 * que podrian ser cambiados en caliente como: nombre de base de datos, puerto,
 * etc.
 * 
 * @version 1.0
 * 
 */
public class UArchivoPropiedades {

	private static final Log LOGGER = LogFactory
			.getLog(UArchivoPropiedades.class);

	/**
	 * Retorna el valor de la propiedad de leida desde el archivo
	 * <b>generic.properties</b> se requiere el valor de la aplicacion por
	 * defecto que esta instanciada o que esta utilizando la clase
	 * 
	 * @param key
	 *            id de la propiedad definida en el archivo properties, tipo
	 *            String
	 * @return valor de la propiedad definida en <b>generic.properties</b>, tipo
	 *         String
	 */
	public static String getProperty(String key) {
		String tipoAplicacion = null;
		FacesContext fc = FacesContext.getCurrentInstance();
		Map sm = fc.getExternalContext().getSessionMap();
		Properties propiedad;
		propiedad = (Properties) fc.getExternalContext().getSessionMap()
				.get(UConstante.ARCHIVOPROPIEDADES_SESSION);

		if (propiedad != null) {
			return propiedad.getProperty(key);
		}

		tipoAplicacion = (String) sm.get(UConstante.SESION_TIPOAPLICACION);

		return getProperty(tipoAplicacion, key);
	}

	/**
	 * Retorna el valor de la propiedad de leida desde el archivo
	 * <b>generic.properties</b>
	 * 
	 * @param tipoAplicacion
	 *            tipo de la aplicacion que nos servira para encontrar el
	 *            archivo de properties (WIN,WEB,WS)
	 * @param key
	 *            id de la propiedad definida en el archivo properties, tipo
	 *            String
	 * @return valor de la propiedad definida en <b>generic.properties</b>, tipo
	 *         String
	 */
	public static String getProperty(String tipoAplicacion, String key) {
		String genericPropertiesPath = null;

		genericPropertiesPath = UAplicacion
				.getGenericPropertiesPath(tipoAplicacion);

		genericPropertiesPath = genericPropertiesPath + UFile.getSeparador()
				+ UConstante.ARCHIVOPROPIEDADES_NOMBRE;

		try {
			// LOGGER.debug(genericPropertiesPath);
			Properties properties = new Properties();
			properties.load(new FileInputStream(genericPropertiesPath));

			if (properties.get(key) == null) {
				LOGGER.debug("No se ha encontrado la propiedad con llave "
						+ key + " en " + genericPropertiesPath);
				return null;
			}

			FacesContext fc = FacesContext.getCurrentInstance();
			fc.getExternalContext().getSessionMap()
					.put(UConstante.ARCHIVOPROPIEDADES_SESSION, properties);

			return (String) properties.getProperty(key);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	/**
	 * Retorna el valor de la propiedad de leida desde el archivo
	 * <b>generic.properties</b>
	 * 
	 * @param tipoAplicacion
	 *            tipo de la aplicacion que nos servira para encontrar el
	 *            archivo de properties (WIN,WEB,WS)
	 * @param key
	 *            id de la propiedad definida en el archivo properties, tipo
	 *            String
	 * @return valor de la propiedad definida en <b>generic.properties</b>, tipo
	 *         String
	 */
	public static void cargarArchivoPropiedades() {
		Properties properties = new Properties();
		String genericPropertiesPath = null;

		genericPropertiesPath = UAplicacion
				.getGenericPropertiesPath();

		genericPropertiesPath = genericPropertiesPath + UFile.getSeparador()
				+ UConstante.ARCHIVOPROPIEDADES_NOMBRE;

		try {
			// LOGGER.debug(genericPropertiesPath);			
			properties.load(new FileInputStream(genericPropertiesPath));
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.getExternalContext().getSessionMap()
					.put(UConstante.ARCHIVOPROPIEDADES_SESSION, properties);
		} catch (Exception e) {
			LOGGER.error(e);
			return;
		}
	}
}
