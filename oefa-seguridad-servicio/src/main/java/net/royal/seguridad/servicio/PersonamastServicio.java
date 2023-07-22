package net.royal.seguridad.servicio;

import java.math.BigDecimal;
import java.util.List;

import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.GenericoServicio;

public interface PersonamastServicio extends GenericoServicio {
	public List listarTipoPersona(Class clazz);

	public List listarSexoPersona(Class clazz);

	public List listarTipoDocumento(Class clazz);

	public List listarPais(Class clazz,
			List<ParametroPersistenciaGenerico> parametros);

	public ParametroPaginacion listarPaginacion(ParametroPaginacion paginacion);
	
	public List listarDepartamento(Class clazz,
			List<ParametroPersistenciaGenerico> parametros) ;
	
	public List listarProvincia(Class clazz,
			List<ParametroPersistenciaGenerico> parametros);
	
	public List listarZonaPostal(Class clazz,
			List<ParametroPersistenciaGenerico> parametros);
	
	public Integer nuevoCodigo();
	
	public List buscarIguales(Class clazz,
			List<ParametroPersistenciaGenerico> parametros);
	
	public List tipoContrato(Class clazz);

}
