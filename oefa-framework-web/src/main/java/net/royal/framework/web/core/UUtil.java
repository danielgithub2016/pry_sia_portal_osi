package net.royal.framework.web.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UUtil {
	private static final Log LOGGER = LogFactory.getLog(UUtil.class);

	/**
	 * Convierte una char a ASCII
	 *
	 * @param caracter
	 *            , tipo char
	 * @return el valor en ASCII del char, tipo Integer
	 */
	public static int convertChar2Ascii(char caracter) {
		return (int) caracter;
	}

	/**
	 * Convierte un ASCII a char
	 *
	 * @param ascii
	 *            , tipo Integer
	 * @return el valor del ASCII en char, tipo char
	 */
	public static char convertAscii2Char(int ascii) {
		return (char) ascii;
	}

}