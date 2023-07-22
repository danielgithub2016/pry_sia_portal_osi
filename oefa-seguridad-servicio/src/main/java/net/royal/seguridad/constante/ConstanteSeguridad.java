package net.royal.seguridad.constante;

public class ConstanteSeguridad {
	public static final String VERSION = "1.3";
	public static final String ACTIVE_DIRECTORY_DOMAIN = "ldap.domain";
	public static final String ACTIVE_DIRECTORY_HOST = "ldap.host";
	public static final String ACTIVE_DIRECTORY_PORT = "ldap.port";
	public static final String ACTIVE_DIRECTORY_DATABASE = "ldap.database";
	public static final String ACTIVE_DIRECTORY_MASTERUSER = "ldap.masteruser";
	public static final String ACTIVE_DIRECTORY_MASTERPASSWORD = "ldap.masterpassword";
	public static final String ACTIVE_DIRECTORY_USER = "ldap.user";
	public static final String ACTIVE_DIRECTORY_PASSWORD = "ldap.password";
	public static final String ACTIVE_DIRECTORY_MSJ_MSJ = "ldap.mensaje";
	public static final String ACTIVE_DIRECTORY_MSJ_LOGINVALIDO = "ldap.flgLoginValido";

	public static final String APLICACION_CODIGO_APLICACION = "APLICACION.CODIGO_APLICACION";

	public static final String PREFERENCIAS_DATABASE = "PREFERENCIAS.DATABASE";

	public static final String PREFERENCIAS_UNIDAD_REPLICACION = "PREFERENCIAS.UNIDAD_REPLICACION";

	public static final String PREFERENCIAS_EMPRESA = "PREFERENCIAS.EMPRESA";

	public static final String PREFERENCIAS_ALMACEN = "PREFERENCIAS.ALMACEN";

	public static final String CODIGO_APP_HR = "HR";

	public static final String COMPANIA_CODIGO_DEFAULT = "999999";

	public static final String PARAMETRO_CLAVE_URL_POSTULANTE = "URLPOSTULA";
	public static final String PARAMETRO_CLAVE_URL_POSTULANTE_ADM = "URLPOSTADM";
	public static final String PARAMETRO_CLAVE_PRIVATECK_CONVOCATORIA = "PRICKCONVO";
	public static final String PARAMETRO_CLAVE_PUBLICCK_CONVOCATORIA = "PUBCKCONVO";

	public static final String PARAMETRO_MODOARCHIVO_BD = "BD";
	public static final String PARAMETRO_MODOARCHIVO_ALFRESCO = "AL";

	public static final String PREFERENCIAS_URL_ALFRESCO = "PREFERENCIAS.URL_ALFRESCO";
	
	public static final String PREFERENCIAS_CONTACTO_SIA = "PREFERENCIAS.CONTACTO_SIA";

	// Codigos de cuponeras para el acceso directo
	public static final String CUPONERA_CUMPLE_HIJOS = "CUP001";
	public static final String CUPONERA_ALMUERZO_FAMILIA = "CUP002";
	public static final String CUPONERA_DIA_PADRE = "CUP003";
	public static final String CUPONERA_DIA_MADRE = "CUP004";
	public static final String CUPONERA_TARDE_LIBRE = "CUP005";
	public static final String CUPONERA_RECIEN_CASADOS = "CUP006";
	public static final String CUPONERA_ANIVERSARIO_BODAS = "CUP007";
	public static final String CUPONERA_GESTION_PERSONAL = "CUP008";
	public static final String CUPONERA_TIEMPO_FAMILIA = "CUP009";
	public static final String CUPONERA_CONTROL_NINO = "CUP010";
	public static final String CUPONERA_AMOR_SALUD = "CUP011";
	public static final String CUPONERA_VIERNES_VERANO = "CUP012";
	
	/**
	 * Tiempo en segundo de duración del token
	 */
	public static final long TOKEN_EXPIRATION_TIME = 3600000l;
	
	public static final String PROCESO_MARCACION_FROM_OEFA = "PMPOEFA";
	
	/**
	 * LLave para el token
	 */
	public static final String TOKEN_KEY = "SIARRHH_LlaveTokenAdmPostulanteSERVIR";
}
