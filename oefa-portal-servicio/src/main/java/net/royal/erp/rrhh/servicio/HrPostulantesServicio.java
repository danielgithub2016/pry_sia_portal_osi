package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrPostulantes;
import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrPostulantesServicio extends GenericoServicio {
	/**
	 * Obtener nombre postulante.
	 *
	 * @powerbuilder f_get_nombre_postulante
	 * @param postulante
	 *            the postulante
	 * @return the string
	 */
	public String obtenerNombrePostulante(String postulante);

	public HrPostulantes obtenerInformacionReniec(HrPostulantes hrPostulantes);

	public HrPostulantes obtenerFotoReniec(String dniConsulta, String dniUsuario);

	public List<HrPostulantes> listar(HrPostulantes hrPostulantes);
	
	public ParametroPaginacion listarPaginacion(ParametroPaginacion paginacion);
}
