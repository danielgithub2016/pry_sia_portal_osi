package net.royal.framework.correo.constante;

public class ConstanteCorreo {
	public enum tipo_configuracion {
		ARCHIVO, PARAMETROS, FUNCIONES
	};
	public enum tipo_destino {
		TO, CC, BCC
	};
	public static final String CORREO_TIPO_CONFIGURACION = "CORREO.TIPO_CONFIGURACION";
	public static final String CORREO_TIPO_CONFIGURACION_ARCHIVO = "ARCHIVO";
	public static final String CORREO_TIPO_CONFIGURACION_BDPARAMETROS = "BDPARAMETROS";
	public static final String CORREO_TIPO_CONFIGURACION_BDFUNCION = "BDFUNCION";
	public static final String CORREO_TIPO_CONFIGURACION_CLASE = "CLASE";
}
