package net.royal.framework.web.core;

public class UString {
	/**
	 * Retorna FALSE cuando el texto es diferente de NULL y diferente de vacio.
	 * Caso contrario retorna TRUE;
	 * 
	 * @param valor
	 *            texto que se evaluara, tipo String
	 * @return TRUE o FALSE dependiendo de la condicion cumplida
	 */
	public static boolean estaVacio(String valor) {
		if (valor != null) {
			if (!valor.trim().equals("")) {
				return false;
			}
		}

		return true;
	}

	public static String[] split(String text, String delemeter) {
		java.util.List<String> parts = new java.util.ArrayList<String>();

		text += delemeter;

		for (int i = text.indexOf(delemeter), j = 0; i != -1;) {
			String temp = text.substring(j, i);
			if (temp.trim().length() != 0) {
				parts.add(temp);
			}
			j = i + delemeter.length();
			i = text.indexOf(delemeter, j);
		}

		return parts.toArray(new String[0]);
	}

	public static String split(String text, String delemeter, Integer indice) {
		java.util.List<String> parts = new java.util.ArrayList<String>();
		String retorno = "";

		if (text == null)
			return null;

		text += delemeter;

		for (int i = text.indexOf(delemeter), j = 0; i != -1;) {
			String temp = text.substring(j, i);
			if (temp.trim().length() != 0) {
				parts.add(temp);
			}
			j = i + delemeter.length();
			i = text.indexOf(delemeter, j);
		}

		if (text.equals(delemeter))
			return null;

		if (indice > parts.size())
			return null;

		try {
			retorno = parts.get(indice);
		} catch (Exception e) {
			retorno = "";
		}

		return retorno;
	}

	public static String upper(String text) {
		return UValidador.esNulo(text) ? "" : text.toUpperCase();
	}

	public static String cambiarCaracteresEspecialesHTML(String string) {
		if (UValidador.esNulo(string))
			return string;

		string = string.replace("á", "&aacute;");
		string = string.replace("é", "&eacute;");
		string = string.replace("í", "&iacute;");
		string = string.replace("ó", "&oacute;");
		string = string.replace("ú", "&uacute;");
		string = string.replace("ñ", "&ntilde;");
		string = string.replace("Á", "&Aacute;");
		string = string.replace("É", "&Eacute;");
		string = string.replace("Í", "&Iacute;");
		string = string.replace("Ó", "&Oacute;");
		string = string.replace("Ú", "&Uacute;");
		string = string.replace("Ñ", "&Ntilde;");

		string = string.replace("°", "&deg;");
		string = string.replace("“", "&ldquo;");
		string = string.replace("”", "&rdquo;");
		string = string.replace("&nbsp;", " ");

		return string;
	}
}
