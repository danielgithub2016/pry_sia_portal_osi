package net.royal.seguridad.servicio;

import java.util.List;

import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.seguridad.dominio.dto.DtoCompaniamast;

public interface CompaniamastServicio extends GenericoServicio {
	public List<DtoCompaniamast> listarSelector();
	public Integer buscarCompaniaIgual(String companiaCodigo);
	public ParametroPaginacion listarPaginacion(ParametroPaginacion paginacion);
}
