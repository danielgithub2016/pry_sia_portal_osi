package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEncuestasujeto;
import net.royal.erp.rrhh.dominio.dto.DtoHrEncuesta;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrEncuestasujetoServicio extends GenericoServicio {

	/**
	 * Obtener nuevo sujeto <br/>
	 * Se usa para la paginacion en la vista de respuestas a una determinada
	 * encuesta<br/>
	 * en la aplicación de PB.
	 *
	 * @param secuencia
	 *            the secuencia
	 * @return the integer
	 */
	public Integer obtenerNuevoSujeto(Integer secuencia);

	public void registrarSujeto(DtoHrEncuesta encuestaDto, List<HrEncuestasujeto> sujeto);
}
