/**
 * Resumen
 * Objeto                  :SeguridadHelper.java
 * Descripcion             :Clase para encriptrar y/o desencriptar, asi como
 * 							para acciones que involucren la seguridad del
 * 							sistema
 * Fecha de Creacion       :27/09/2011
 * PE de Creación		   :SIGA-WORKFLOW
 * Autor                   :Roger Panayfo
 */
package net.royal.framework.web.seguridad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.core.UUtil;
import net.royal.framework.web.core.UValidador;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Clase para encriptrar y/o desencriptar, asi como para acciones que involucren
 * la seguridad del sistema
 *
 * @author
 *
 */
public class SeguridadHelper {

	private static final Log LOGGER = LogFactory.getLog(SeguridadHelper.class);

	public static String obtenerLlavePublicaByPropertiesPath(
			String propertiesPath) throws Exception {

		BufferedReader lectorPublicKey = null;
		String rutaPublicKey = propertiesPath;

		rutaPublicKey = rutaPublicKey + UFile.getSeparador()
				+ UConstante.SESION_NOMBREARCHIVOLLAVESEGURIDAD;

		LOGGER.debug("Se busca la llave en "
				+ UConstante.SESION_NOMBREARCHIVOLLAVESEGURIDAD + " en ruta: "
				+ rutaPublicKey);

		// Primero, se lee el archivo public.key.
		File archivoPublicKey = new File(rutaPublicKey);
		lectorPublicKey = new BufferedReader(new FileReader(archivoPublicKey));

		String llaveDesencriptadaBF = null;
		String publicKey = "";

		boolean flagMasDeUnaLinea = false;
		while (lectorPublicKey.ready()) {
			if (flagMasDeUnaLinea) {
				publicKey = publicKey + "\r";
			}

			publicKey = publicKey + lectorPublicKey.readLine();

			if (!flagMasDeUnaLinea)
				flagMasDeUnaLinea = true;
		}

		if (UValidador.estaVacio(publicKey)) {
			throw new Exception("El archivo "
					+ UConstante.SESION_NOMBREARCHIVOLLAVESEGURIDAD
					+ " esta vacio");
		}

		LOGGER.debug("> Se desencripta " + publicKey);

		llaveDesencriptadaBF = AesEncryption.desEncriptar(
				AesEncryption.getSecurityInternalKey(), publicKey);

		if (lectorPublicKey != null)
			lectorPublicKey.close();

		return llaveDesencriptadaBF;
	}

	public static String obtenerLlavePublica(String codigoAplicacion)
			throws Exception {
		String rutaArchivo = UAplicacion
				.getGenericPropertiesPath(codigoAplicacion);
		return obtenerLlavePublicaByPropertiesPath(rutaArchivo);
	}

	public static String encriptar(String codigoAplicacion, String texto)
			throws Exception {
		String llave = "llave";
		return AesEncryption.encriptar(llave, texto);
	}

	public static String desencriptar(String codigoAplicacion, String texto)
			throws Exception {
		String llave = "llave";
		return AesEncryption.desEncriptar(llave, texto);
	}

	/**
	 * Encripta el texto enviad como parametro
	 *
	 * @param texto
	 *            cadena de texto que se encriptada, tipo String
	 * @return texto encriptado, tipo String
	 */
	public static String encriptar(String texto) {

		String desencriptado = null;

		if (texto != null && !texto.equals("")) {

			desencriptado = "";
			// Contador que sirve para agregar valor al ascii generado
			// por cada caracter del texto
			int plus = 1;

			for (int i = 0; i < texto.length(); i++) {
				char caracter = texto.charAt(i);

				int ascii = UUtil.convertChar2Ascii(caracter) + plus;

				desencriptado = desencriptado + UUtil.convertAscii2Char(ascii);

				plus++;
			}

			return desencriptado;
		}
		return null;
	}

	/**
	 * Desencripta el password enviado como parametro
	 *
	 * @param password
	 *            texto encriptado, tipo String
	 * @return texto desencriptado, tipo String
	 */
	public static String desencriptar(String password) {

		String encriptado = null;

		if (password != null && !password.equals("")) {

			encriptado = "";
			// Contador que sirve para restar valor al ascii generado
			// por cada caracter del texto
			int minus = 1;

			for (int i = 0; i < password.length(); i++) {
				char caracter = password.charAt(i);

				int ascii = UUtil.convertChar2Ascii(caracter) - minus;
				LOGGER.debug(caracter+" "+ascii+" "+UUtil.convertAscii2Char(ascii));
				encriptado = encriptado + UUtil.convertAscii2Char(ascii);

				minus++;
			}

			return encriptado;
		}
		return null;
	}
	
public static void main(String[] args) {
}
}
