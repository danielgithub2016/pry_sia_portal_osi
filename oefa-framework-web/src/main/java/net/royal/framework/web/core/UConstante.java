package net.royal.framework.web.core;

/**
 * la clase constante almacena la informacion de las constantes publicas
 * generales de todas las aplicaciones
 *
 * @version 1.0
 */
public class UConstante {
	/**
	 * indica el tipo de aplicacion que se esta ejecutando, WEB con archivo externo de propiedades
	 */
	public static final String CONSTANTE_TIPOAPLICACION_WEB_EXT = "WEB_EXT";
	
	/**
	 * indica el tipo de aplicacion que se esta ejecutando, WEB
	 */
	public static final String CONSTANTE_TIPOAPLICACION_WEB = "WEB";

	/**
	 * indica el tipo de aplicacion que se esta ejecutando, WIN
	 */
	public static final String CONSTANTE_TIPOAPLICACION_WIN = "WIN";

	/**
	 * constante que indica si es SI
	 */
	public static final String CONSTANTE_OPCION_SI = "S";

	/**
	 * constante que indica si es NO
	 */
	public static final String CONSTANTE_OPCION_NO = "N";

	/**
	 * constante para indicar cual es el valor del estado Activo
	 */
	public static final String CONSTANTE_ESTADO_ACTIVO = "A";

	/**
	 * constante para indicar cual es el valor del estado Inactivo
	 */
	public static final String CONSTANTE_ESTADO_INACTIVO = "I";

	public static final String APLICACION_CODIGO_APLICACION = "APLICACION.CODIGO_APLICACION";
	public static final String APLICACION_IMAGEN_LOGIN_PRINCIPAL = "APLICACION.IMAGEN_LOGIN_PRINCIPAL";
	public static final String APLICACION_IMAGEN_LOGIN_FONDO = "APLICACION.IMAGEN_LOGIN_FONDO";
	public static final String APLICACION_IMAGEN_LOGIN_BANDA1 = "APLICACION.IMAGEN_LOGIN_BANDA1";
	public static final String APLICACION_VER_LISTA_COMPANIAS = "APLICACION.VER_LISTA_COMPANIAS";
	public static final String APLICACION_VER_LISTA_CLIENTES = "APLICACION.VER_LISTA_CLIENTES";
	public static final String APLICACION_VER_LISTA_PERIODOS = "APLICACION.VER_LISTA_PERIODOS";
	public static final String APLICACION_NAVEGACION_LOGIN = "APLICACION.NAVEGACION_LOGIN";
	public static final String APLICACION_NAVEGACION_BIENVENIDA = "APLICACION.NAVEGACION_BIENVENIDA";
	public static final String APLICACION_NAVEGACION_ERROR = "APLICACION.NAVEGACION_ERROR";
	public static final String APLICACION_NAVEGACION_VISTAEXPIRADA = "APLICACION.NAVEGACION_VISTAEXPIRADA";

	// Indica cual es la clave publica de session para el control de errores
	// 0 - sin errores
	// 1 - excepcion controlada por el ActionListenerImpl
	// 2 - excepcion por los filtros de seguridad UFilter
	// 3 - control de session de Usuario, si no existe se redirige a login
	public static final String SESION_CONTROL_ERROR = "keyControlError";
	public static final String SESION_CONTROL_ERROR_SINERROR = "0";
	public static final String SESION_CONTROL_ERROR_ACTIONLI = "1";
	public static final String SESION_CONTROL_ERROR_FILTROS = "2";
	public static final String SESION_CONTROL_ERROR_SESSION = "3";

	// public static final String SESION_BEAN_NAVIGATION_HANDLER =
	// "keyNavigationHandlerBean";

	/**
	 * Devuelve el nombre del bean en la session de Faces
	 */
	public static final String SESION_BEAN_BINDINGCONTROLLER = "cBindingController";

	/**
	 * Devuelve el nombre del bean en la session de Faces
	 */
	public static final String SESION_BEAN_COMUNSESSIONCONTROLLER = "cComunSession";

	/**
	 * Devuelve el nombre del bean en la session de Faces
	 */
	public static final String SESION_BEAN_GLOBALSESSIONCONTROLLER = "cComunGlobal";

	public static final String SESION_BEAN_LOGINCONTROLLER = "cComunGlobal";

	/**
	 * Devuelve el listado de navegacion de donde se encuentra la aplicacion
	 */
	public static final String SESION_FORMULARIO_LISTA_PARAMETROS = "formularioListaParametros";

	/**
	 * Devuelve el listado de navegacion de donde se encuentra la aplicacion
	 */
	public static final String SESION_FORMULARIO_ACCION_SOLICITADA = "formularioAccionSolicitada";

	/**
	 * Devuelve el listado de navegacion de donde se encuentra la aplicacion
	 */
	public static final String SESION_FORMULARIO_OBJETO_ENVIADO = "formularioObjetoEnviado";

	/**
	 * Devuelve el listado de modelos encontrados por usuario
	 */
	public static final String SESION_MENU_MODELO_POR_USUARIO = "menuPorUsuario";

	/**
	 * Devuelve el listado de navegacion de donde se encuentra la aplicacion
	 */
	public static final String SESION_MENU_NAVEGACION = "keyCurrentMenuNavegacion";

	/**
	 * Devuelve el listado de navegacion de donde se encuentra la aplicacion
	 */
	public static final String SESION_MENU_PANTALLA_TITULO_ACCION = "keyCurrentMenuPantallaTituloAccion";

	/**
	 * objeto del tipo usuario actual que tiene todos los atributos del usuario
	 * que se encuentra en el sistema
	 */
	public static final String SESION_EXCEPCIONACTUAL = "excepcionactual";

	/**
	 * objeto del tipo usuario actual que tiene todos los atributos del usuario
	 * que se encuentra en el sistema
	 */
	public static final String SESION_USUARIOACTUALDOMINIO = "usuario";

	/**
	 * objeto del tipo usuario actual que tiene todos los atributos del usuario
	 * que se encuentra en el sistema
	 */
	public static final String SESION_USUARIOREMOTODOMINIO = "usuario.remoto";

	/**
	 * Devuelve el tipo de aplicacion actual de la session
	 */
	public static final String SESION_TIPOAPLICACION = "keyCurrentTipoApplication";

	/**
	 * Devuelve el codigo de aplicacion actual de la session
	 */
	public static final String SESION_CODIGOAPLICACION = "keyCurrentCodApplication";

	/**
	 * indica el nombre generico del archivo que contiene la llave o semilla
	 * para los metodos de desencriptacion
	 */
	public static final String SESION_NOMBREARCHIVOLLAVESEGURIDAD = "ayuda.help";

	public static final String SESION_NAVIGATIONCASE_ACTUAL = "sessionVistaActual";

	/**
	 * Indica cual es la clave publica para identificar cual es la clave para ir
	 * a la primera pagina de la aplicacion o de bienvenida
	 */
	public static final String NAVIGATIONCASE_BIENVENIDA = "pantallaBienvenida";

	/**
	 * Indica cual es la clave publica para identificar cual es la clave para ir
	 * a la pagina para mostrar los errores del sistema
	 */
	public static final String NAVIGATIONCASE_ERROR = "pantallaError";

	/**
	 * Indica cual es la clave publica para identificar cual es la clave para ir
	 * a la pagina para mostrar los errores del sistema
	 */
	public static final String NAVIGATIONCASE_VISTAEXPIRADA = "pantallaVistaExpirada";

	/**
	 * Indica cual es la clave publica para identificar el controller que maneja
	 * el login
	 */
	public static final String NAVIGATIONCASE_LOGIN = "pantallaLogin";

	/**
	 * indica el nombre generico del archivo de configuracion del sistema actual
	 */
	public static final String ARCHIVOPROPIEDADES_NOMBRE = "propiedadesAplicacionWeb.properties";

	/**
	 * Archivo de propiedades donde almacena los variables publicas
	 */
	public static final String ARCHIVOPROPIEDADES_SESSION = "keyPropiedadesAplicacionWeb";

	/**
	 * Indica cual es el modo de autentificacion que tendra el modulo de
	 * seguridad
	 */
	public static final String ARCHIVOPROPIEDADES_AUTENTIFICACION_MODO = "autentificacion.authentication";

	/**
	 * constante para indicar que la autentificacion debe ser por Active
	 * Directory
	 */
	public static final String ARCHIVOPROPIEDADES_AUTENTIFICACION_MODO_ACTIVEDIRECTORY = "A";

	/**
	 * constante para indicar que la autentificacion debe ser por Base de datos
	 */
	public static final String ARCHIVOPROPIEDADES_AUTENTIFICACION_MODO_USERDATABASE = "B";

	/**
	 * Indica cual es el modo de autentificacion que tendra el modulo de
	 * seguridad
	 */
	public static final String ARCHIVOPROPIEDADES_AUTENTIFICACION_VALIDARCLAVEBLANCO = "autentificacion.validarclaveblanco";

	public static final String ARCHIVOPROPIEDADES_AUTENTIFICACION_TIPOVALIDACION = "autentificacion.tipovalidacion";
	/**
	 * indica el tipo de validacion que se hara al momento ed validar el login
	 */
	public static final String ARCHIVOPROPIEDADES_AUTENTIFICACION_TIPOVALIDACION_CODIGOUSUARIO = "CODIGOUSUARIO";

	/**
	 * indica el tipo de validacion que se hara al momento ed validar el login
	 */
	public static final String ARCHIVOPROPIEDADES_AUTENTIFICACION_TIPOVALIDACION_DOCUMENTOPERSONA = "DOCUMENTOPERSONA";

	/**
	 * mostrar el mensaje de error
	 */
	public static final String ARCHIVOPROPIEDADES_PANTALLAERROR_MOSTRARMENSAJE = "system.err.showmessage";

	/**
	 * mostrar el detalle de error
	 */
	public static final String ARCHIVOPROPIEDADES_PANTALLAERROR_MOSTRARSTACKTRACE = "system.err.showstackTrace";

	/**
	 * constante para indicar la llave con la que se pasa parametros para el
	 * nombre del tipo de busqueda de una ventana emergente
	 */
	public static final String CONSTANTE_KEY_NOMBRETIPOBUSQUEDA = "busqueda_nombreTipoBusqueda";

	/**
	 * constante para indicar la llave con la que se pasa parametros para el
	 * nombre del tipo de busqueda de una ventana emergente
	 */
	public static final String CONSTANTE_KEY_NOMBRETIPOBUSQUEDA_TAG = "busqueda_nombreTipoBusqueda_tag";

	public static final String FORMATO_FECHA = "dd/MM/yyyy";
	public static final String FORMATO_FECHA_HORA24 = "dd/MM/yyyy HH:mm:ss";

	/**
	 * constante para indicar la ruta de los documentos firmados, en caso no se
	 * encuentre en ParametrosMast, para la Firma Digital Web
	 */
	public static final String CONSTANTE_KEY_PARAM_URL_FIRMA_DIGITAL_1 = "URLFIRWEB1";
	public static final String CONSTANTE_KEY_PARAM_URL_FIRMA_DIGITAL_2 = "URLFIRWEB2";
	public static final String CONSTANTE_KEY_PARAM_RUTA_BASE = "URLFIRWEB3";

	public static final String CONSTANTE_KEY_PARAM_CORREO = "CORREOALER";
	public static final String CONSTANTE_KEY_CORREO_DEFAUT = "sia@oefa.gob.pe";

	public static final String CONSTANTE_KEY_URL_FIRMA_DIGITAL_DEFAULT_1 = "http://app4.oefa.gob.pe/oefa-portal-web/documentos/";
	public static final String CONSTANTE_KEY_URL_FIRMA_DIGITAL_DEFAULT_2 = "http://app4.oefa.gob.pe/oefa-portal-web/";
	public static final String CONSTANTE_KEY_URL_FIRMA_DIGITAL_RUTA_BASE = "/directorio_aplicacion/sia/temporales";

	/**
	 * constante para indicar la carpeta donde se generaran los documentos
	 * temporales en la vista previa del gestor de documentos de alfresco.
	 */
	public static final String CONSTANTE_CARPETA_TEMPORAL_ALFRESCO = "temporalalfresco";

	/**
	 * constante para indicar el código del perfil encargado de la aprobación de
	 * papeletas que tengan como concepto Permiso Resolución-0044-2018-OEFA/GEG.
	 */
	public static final String CONSTANTE_PERFIL_APROB_RESOLUCION_0044 = "AS09";

	/**
	 * constante para indicar el código del perfil de teletrabajo para la
	 * marcación directa sin necesidad de aprobación del jefe
	 */
	public static final String CONSTANTE_PERFIL_TELETRABAJO = "AS11";

	public static final String CONSTANTE_PERFIL_MARCACION_WEB = "AS13";

	/**
	 * constante para indicar el código del concepto para Permiso
	 * Resolución-0044-2018-OEFA/GEG.
	 */
	public static final String CONSTANTE_CONCEPTO_RESOLUCION_0044 = "34";

	/**
	 * constante que indica si es SI
	 */
	public static final String CONSTANTE_SEXO_MASCULINO = "M";

	/**
	 * constante que indica si es NO
	 */
	public static final String CONSTANTE_SEXO_FEMENINO = "F";

	public static final String CONSTANTE_CONCEPTO_GESTION_PERSOSNAL = "75";
	public static final String CONSTANTE_CONCEPTO_RECIEN_CASADOS = "76";
	public static final String CONSTANTE_CONCEPTO_MEJOR_PAPA = "06";
	public static final String CONSTANTE_CONCEPTO_MEJOR_MAMA = "19";
	public static final String CONSTANTE_CONCEPTO_TIEMPO_FAMILIA = "83";
	public static final String CONSTANTE_CONCEPTO_CONTROL_NINO = "84";
	public static final String CONSTANTE_CONCEPTO_AMOR_SALUD = "85";
	public static final String CONSTANTE_CONCEPTO_VIERNES_VERANO = "86";

	// CONSTANTES SIGED
	public static final String URL_OBTENER_TOKEN = "URL_OBTENER_TOKEN";
	public static final String URL_OBTENER_BANDEJAS = "URL_OBTENER_BANDEJAS";
	public static final String URL_OBTENER_DETALLE = "URL_OBTENER_DETALLE";
	public static final String URL_OBTENER_AREAS = "URL_OBTENER_AREAS";
	public static final String URL_OBTENER_CARGOS = "URL_OBTENER_CARGOS";
	public static final String URL_OBTENER_PERFILES = "URL_OBTENER_PERFILES";
	public static final String URL_GESTIONAR_USUARIO = "URL_GESTIONAR_USUARIO";
	public static final String URL_GESTIONAR_USUARIO_PERFIL = "URL_GESTIONAR_USUARIO_PERFIL";
	public static final String URL_GESTIONAR_BANDEJA = "URL_GESTIONAR_BANDEJA";
	public static final String URL_GESTIONAR_PERSONA_ACTUALIZAR = "URL_GESTIONAR_PERSONA_ACTUALIZAR";
	
	public static final String ES_JEFE = "01";
	public static final String ES_ASISTENTE = "02";
	public static final String ES_AMBOS = "03";
	public static final String ES_NINGUNO = "00";

	public static final String CONSTANTE_CONCEPTO_ASIG_FUNCIONES = "94";
	public static final String CONSTANTE_CONCEPTO_ASIG_ROLES = "95";
	public static final String CONSTANTE_CONCEPTO_NUEVA_BANDEJA = "96";
	public static final String CONSTANTE_CONCEPTO_ACTIVACION_TEMPORAL = "97";
	public static final String CONSTANTE_CONCEPTO_CONFIG_PERFILES = "98";
	public static final String CONSTANTE_CONCEPTO_ASIG_ROL_JEFE = "xx";
	public static final String CONSTANTE_CONCEPTO_ASIG_ROL_ASISTENTE = "99";
	public static final String CONSTANTE_CONCEPTO_LICENCIA_EXAMEN_ONCO = "101";

	//
	public static final String USUARIO_TOKEN = "USUARIO_TOKEN";
	public static final String CLAVE_TOKEN = "CLAVE_TOKEN";

	public static final String CONSTANTE_DEPARTAMENTO_LIMA = "14";
	public static final String ID_PERFIL_USUARIO_FINAL = "ID_PERFIL_USUARIO_FINAL";

}
