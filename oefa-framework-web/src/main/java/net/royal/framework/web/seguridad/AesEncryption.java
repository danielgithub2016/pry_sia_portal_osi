/**
 * Resumen
 * Objeto                  :AES
 * Descripcion             :clase que encripta y desencripta
 * Fecha de Creacion       :30/01/2012-17:38:40 PM
 * PE de Creación		   :SIGA-LlaveEncriptacion
 * Autor                   :Cristhian Florian
 * ------------------------------------------------
 * Modificaciones
 * Motivo		Fecha		Nombre		Descripcion
 */
package net.royal.framework.web.seguridad;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/**
 * Esta clase encripta y desencripta usando la encriptación AES. La llave para
 * encriptar o desencriptar proviene como un parametro.
 * 
 * @author Roger Panayfo
 */

public class AesEncryption {
	/**
	 * Es el tipo de encriptación a emplear para la encriptación y
	 * desencriptación
	 */
	private static final String ENCRIPTACION = "AES";
	/**
	 * Es el charset que se usará para generar bytes
	 */
	private static final String CHARSET = "UTF8";

	private static final String SECURITY_INTERNAL_KEY = "tr@m|+ed@cumen+@999royal";

	/**
	 * Método que se empleará para encriptar una cadena
	 * 
	 * @param llave
	 *            : es la llave que se usa para encriptar
	 * @param cadena
	 *            : Cadena a encriptar y codificar, tipo String
	 * @return cadena codificada, tipo String
	 * @throws Exception
	 *             excepción general ante un error, tipo Exception
	 */
	public static String encriptar(String llave, String cadena) throws Exception {
		byte ipKey[] = new byte[16];
		for (int i = 0; i < llave.length(); i++) {
			if (i == ipKey.length)
				break;
			ipKey[i] = (byte) llave.charAt(i);
		}
		KeyGenerator kgen = KeyGenerator.getInstance(ENCRIPTACION);
		kgen.init(128);
		byte[] raw = { ipKey[0], ipKey[1], ipKey[2], ipKey[3], ipKey[4], ipKey[5], ipKey[6], ipKey[7], ipKey[8],
				ipKey[9], ipKey[10], ipKey[11], ipKey[12], ipKey[13], ipKey[14], ipKey[15] };
		SecretKeySpec skeySpec = new SecretKeySpec(raw, ENCRIPTACION);
		Cipher cipher = Cipher.getInstance(ENCRIPTACION);
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(cadena.getBytes(CHARSET));
		return new sun.misc.BASE64Encoder().encode(encrypted);
	}

	/**
	 * Método que desencripta una cadena
	 * 
	 * @param llave
	 *            : es la llave que se usa para desencriptar
	 * @param cadena
	 *            codificada a desencriptar, tipo String
	 * @return cadena desencriptada, tipo String
	 * @throws Exception
	 *             excepción general ante un error, tipo Exception
	 */
	public static String desEncriptar(String llave, String cadena) throws Exception {
		System.out.println("llave " + llave);
		System.out.println("cadena " + cadena);
		byte ipKey[] = new byte[16];
		for (int i = 0; i < llave.length(); i++) {
			if (i == ipKey.length)
				break;
			ipKey[i] = (byte) llave.charAt(i);
		}
		byte[] desc = new sun.misc.BASE64Decoder().decodeBuffer(cadena);
		// byte[] desc = null;
		KeyGenerator kgen = KeyGenerator.getInstance(ENCRIPTACION);
		kgen.init(128);
		byte[] raw = { ipKey[0], ipKey[1], ipKey[2], ipKey[3], ipKey[4], ipKey[5], ipKey[6], ipKey[7], ipKey[8],
				ipKey[9], ipKey[10], ipKey[11], ipKey[12], ipKey[13], ipKey[14], ipKey[15] };
		SecretKeySpec skeySpec = new SecretKeySpec(raw, ENCRIPTACION);
		Cipher cipher = Cipher.getInstance(ENCRIPTACION);
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] original = cipher.doFinal(desc);
		String originalString = new String(original, CHARSET);

		return originalString;
	}

	public static String getSecurityInternalKey() {
		return SECURITY_INTERNAL_KEY;
	}
}