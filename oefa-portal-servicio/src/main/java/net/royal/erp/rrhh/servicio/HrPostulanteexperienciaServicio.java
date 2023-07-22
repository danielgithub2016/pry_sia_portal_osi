package net.royal.erp.rrhh.servicio;

import net.royal.framework.web.servicio.GenericoServicio;

public interface HrPostulanteexperienciaServicio extends GenericoServicio {
	
	/**
	 * Obtener tiempo experiencia postulante.
	 *
	 * @powerbuilder f_tiempoexperiencialaboral_postulante
	 * @param tipo the tipo
	 * @param postulante the postulante
	 * @param puesto the puesto
	 * @return the integer
	 */
	public String  obtenerTiempoExperienciaPostulante(String tipo, String postulante, Integer puesto);
}
