package net.royal.framework.web.controladora;

import java.util.Map;

import net.royal.framework.web.dominio.MensajeControllerGenerico;

/**
 * The Interface UIMantenimientoController. implementa los metodos genericos que
 * deben tener todas las controladoras del sistema
 * 
 * @version 1.0
 */
@SuppressWarnings("unused")
public abstract interface UIMantenimientoController {

	/** The Constant serialVersionUID. */
	static final long serialVersionUID = 7476386902466212568L;

	public enum accion_solicitada {
		NUEVO, REGISTRAR, ACTUALIZAR, ELIMINAR, INACTIVAR, EJECUTAR, BUSCAR, EDITAR, VER, SALIR, LISTAR, CONFIGURABLE, IMPRIMIR,OTROS
	};

	/**
	 * Iniciar controladora. indica que es el primer metodo utilizado cuando se
	 * requiere cargar una pantalla en especifico o ventana emergente
	 * 
	 * @return una cadena que representa la regla de navegacion (JSF
	 *         navigation-case) de la pagina que se mostrara al finalizar la
	 *         llamada al metodo
	 * @throws Exception
	 *             the exception
	 */
	public abstract String iniciarControladora() throws Exception;

	/**
	 * Buscar. se usa para las pantallas que hacen consultas o listados obtiene
	 * los resultados de la capa de negocio
	 * 
	 * @return una cadena que representa la regla de navegacion (JSF
	 *         navigation-case) de la pagina que se mostrara al finalizar la
	 *         llamada al metodo
	 * @throws Exception
	 *             the exception
	 */
	public abstract String buscar() throws Exception;

	/**
	 * Nuevo. metodo que es utilizado para preparar un formulario para un nuevo
	 * ingreso de datos
	 * 
	 * @return una cadena que representa la regla de navegacion (JSF
	 *         navigation-case) de la pagina que se mostrara al finalizar la
	 *         llamada al metodo
	 * @throws Exception
	 *             the exception
	 */
	public abstract String nuevo() throws Exception;
	
	//public abstract String nuevoPreparar() throws Exception;

	/**
	 * Editar. metodo que es utilizado para mostrar la informacion de un
	 * registro seleccionado y que se muestre en un formalario para su edicion
	 * 
	 * @return una cadena que representa la regla de navegacion (JSF
	 *         navigation-case) de la pagina que se mostrara al finalizar la
	 *         llamada al metodo
	 * @throws Exception
	 *             the exception
	 */
	public abstract String editar() throws Exception;

	//public abstract String editarPreparar() throws Exception;
	
	/**
	 * Ver. metodo que es utilizado para mostrar la informacion de un registro
	 * seleccionado y que se muestre en un formalario para que se visualize (no
	 * se puede editar o actualizar la informacion).
	 * 
	 * @return una cadena que representa la regla de navegacion (JSF
	 *         navigation-case) de la pagina que se mostrara al finalizar la
	 *         llamada al metodo
	 * @throws Exception
	 *             the exception
	 */
	public abstract String ver() throws Exception;

	/**
	 * Eliminar. metodo que en base a un ID o identificador unico elimina
	 * fisicamente un Objeto
	 * 
	 * @return una cadena que representa la regla de navegacion (JSF
	 *         navigation-case) de la pagina que se mostrara al finalizar la
	 *         llamada al metodo
	 * @throws Exception
	 *             the exception
	 */
	public abstract String eliminar() throws Exception;

	/**
	 * Inactivar. actualiza un atributo del objeto seleccionado que da a
	 * entender que este ya no se usara o pasara a un estado diferente del
	 * actual (ejempl. Activo Inactivo)
	 * 
	 * @return una cadena que representa la regla de navegacion (JSF
	 *         navigation-case) de la pagina que se mostrara al finalizar la
	 *         llamada al metodo
	 * @throws Exception
	 *             the exception
	 */
	public abstract String inactivar() throws Exception;

	/**
	 * Ejecutar. indica a la controladora que se debe ejecutar bloques de codigo
	 * adicionales a los especificados como basicos CRUD * Ejem. si es una
	 * pantalla que requiere enviar el resultado mostrado a otro proveso o un
	 * web service
	 * 
	 * @param accion
	 *            . Especifica como una constante que accion se debe ejecutar
	 * @return una cadena que representa la regla de navegacion (JSF
	 *         navigation-case) de la pagina que se mostrara al finalizar la
	 *         llamada al metodo
	 * @throws Exception
	 *             the exception
	 */
	public abstract String ejecutar(String accion) throws Exception;

	/**
	 * Guardar. recolecta la informacion mostrada en una pantalla o proceso y la
	 * guarda o almacena
	 * 
	 * @return una cadena que representa la regla de navegacion (JSF
	 *         navigation-case) de la pagina que se mostrara al finalizar la
	 *         llamada al metodo
	 * @throws Exception
	 *             the exception
	 */
	public abstract String guardar() throws Exception;

	/**
	 * Salir. sale de la pantalla actual y la redirige a una pantalla anterior o
	 * a la principal dependiendo sea el caso y la pantalla
	 * 
	 * @return una cadena que representa la regla de navegacion (JSF
	 *         navigation-case) de la pagina que se mostrara al finalizar la
	 *         llamada al metodo
	 * @throws Exception
	 *             the exception
	 */
	public abstract String salir() throws Exception;

	/**
	 * validar. metodo auxiliar utilizada para determinar que la informacion
	 * ingresada o mostrada es consistente con lo requerido por la funcionalidad
	 * de la pantalla o proceso solicitado.Se puede llamar desde un Guardar
	 * Eliminar Inactivar Ejecutar dependiendo sea el caso.
	 * 
	 * @return the boolean. TRUE si la informacion esta correctamente ingresada
	 *         y se puede proseguir con el proceso normal. FALSE si la
	 *         informacion ingresada o a procesar tiene una validacion
	 *         pendiente.
	 * @throws Exception
	 *             the exception
	 */
	public abstract Boolean validar() throws Exception;

	/**
	 * Preparar datos mantenimiento.carga los datos de listas u combos que se
	 * usan en las pantallas de mantenimiento los cuales se usan como
	 * informacion de entrada.
	 * 
	 * @return una cadena que representa la regla de navegacion (JSF
	 *         navigation-case) de la pagina que se mostrara al finalizar la
	 *         llamada al metodo
	 * @throws Exception
	 *             the exception
	 */
	public abstract String prepararDatosMantenimiento() throws Exception;

	/**
	 * Preparar datos listado. carga los datos de listas u combos que se usan en
	 * las pantallas de busqueda los cuales se usan como filtros.
	 * 
	 * @return una cadena que representa la regla de navegacion (JSF
	 *         navigation-case) de la pagina que se mostrara al finalizar la
	 *         llamada al metodo
	 * @throws Exception
	 *             the exception
	 */

	public abstract String prepararDatosListado() throws Exception;

	/**
	 * Mensaje. metodo generico para enviar un mensaje a la controladoras y este
	 * realize alguna operacion o proceso
	 * 
	 * @param mensajeGenerico
	 *            the mensaje generico
	 * @return una cadena que representa la regla de navegacion (JSF
	 *         navigation-case) de la pagina que se mostrara al finalizar la
	 *         llamada al metodo
	 */
	public abstract String mensaje(
			MensajeControllerGenerico mensajeControllerGenerico)
			throws Exception;

	/**
	 * Inicializar Filtros Listado. <strong>inicializa los filtros por
	 * defecto</strong> de busqueda del listado o de la busqueda a realizar esta
	 * funcionalidad se usa dentro del inicializar controladora o como una
	 * opcion aparte cuando se requiere poner los filtros por defecto. se
	 * recomienda usar despues de <strong>prepararDatosListado</strong>
	 * 
	 * @return una cadena que representa la regla de navegacion (JSF
	 *         navigation-case) de la pagina que se mostrara al finalizar la
	 *         llamada al metodo
	 * @throws Exception
	 *             the exception
	 */
	public abstract String inicializarFiltrosListado() throws Exception;

	/**
	 * Inicializar Datos Mantenimiento. limpia los objetos o variables
	 * utilizados en un pantalla de registro o de procesamiento, se usa tambien
	 * para inicializar algunas variables por defecto.
	 * 
	 * @return una cadena que representa la regla de navegacion (JSF
	 *         navigation-case) de la pagina que se mostrara al finalizar la
	 *         llamada al metodo
	 * @throws Exception
	 *             the exception
	 */
	public abstract String inicializarDatosMantenimiento() throws Exception;
}
