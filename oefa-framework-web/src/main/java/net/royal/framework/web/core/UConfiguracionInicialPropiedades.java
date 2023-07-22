package net.royal.framework.web.core;

/**
 * Clase Bean generica que utiliza para inicializar variables globales por
 * defecto para la aplicacion web en particular.
 * 
 * ejm. indicar que archivo de propiedades de base de datos debe tomar
 * Spring-Hibernate
 * 
 * @version 1.0
 *
 */
public class UConfiguracionInicialPropiedades {

	/**
	 * nombre de archivo de configuracion de base de datos que debe tomar el
	 * Spring al momento de trabajar con Hibernate
	 */
	private String nombreArchivoConfiguracionBD;

	/**
	 * nombre de archivo de configuracion de base de datos que debe tomar el
	 * Spring al momento de trabajar con Hibernate
	 */
	public String getNombreArchivoConfiguracionBD() {
		return nombreArchivoConfiguracionBD;
	}

	/**
	 * nombre de archivo de configuracion de base de datos que debe tomar el
	 * Spring al momento de trabajar con Hibernate
	 */
	public void setNombreArchivoConfiguracionBD(
			String nombreArchivoConfiguracionBD) {
		this.nombreArchivoConfiguracionBD = nombreArchivoConfiguracionBD;
	}

}
