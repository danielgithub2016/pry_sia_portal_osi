package net.royal.seguridad.servicio.impl;

import java.util.List;

import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.PersonamastDao;
import net.royal.seguridad.servicio.PersonamastServicio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service (value = "BeanServicioPersonamastSeguridad")
public class PersonamastServicioImpl extends GenericoServicioImpl implements PersonamastServicio {

	private PersonamastDao dao;

	private static Log LOGGER = LogFactory.getLog(PersonamastServicioImpl.class);

	@Autowired
	@Qualifier("personamastDaoImplSeguridad")
	public void setDao(PersonamastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}
	
	@Override
	public List listarTipoPersona(Class clazz) {
		return dao.listarPorQuery(clazz, "seguridad.personamast.tipoPersona");
	}

	@Override
	public List listarSexoPersona(Class clazz) {
		return dao.listarPorQuery(clazz, "seguridad.personamast.sexo");
	}

	@Override
	public List listarTipoDocumento(Class clazz) {
		return dao.listarPorQuery(clazz, "seguridad.personamast.tipoDocumento");
	}
	
	@Override
	public List listarPais(Class clazz,
			List<ParametroPersistenciaGenerico> parametros) {
		return dao.listarPorQuery(clazz, "seguridad.personamast.pais", parametros);
	}
	
	@Override
	public ParametroPaginacion listarPaginacion(ParametroPaginacion paginacion) {
		Integer registrosEncontrados;
		List lstResultado;

		registrosEncontrados = dao.contar(
				"seguridad.personamast.paginacionContara", paginacion.getParametros());
		lstResultado = dao.listarConPaginacion(
				paginacion.getRegistroInicio(),
				paginacion.getRegistrosPorPagina(), paginacion.getCampoOrden(),
				paginacion.getDireccionOrden(), paginacion.getParametros(),
				"seguridad.personamast.listarPersona", paginacion.getClazz());

		paginacion.setRegistroEncontrados(registrosEncontrados);
		paginacion.setListaResultado(lstResultado);

		return paginacion;
	}

	@Override
	public List listarDepartamento(Class clazz,
			List<ParametroPersistenciaGenerico> parametros) {
		return dao.listarPorQuery(clazz,
				"seguridad.personamast.Departamento", parametros);
	}
	
	@Override
	public List listarProvincia(Class clazz,
			List<ParametroPersistenciaGenerico> parametros) {
		return dao.listarPorQuery(clazz, "seguridad.personamast.provincia",
				parametros);
	}
	
	@Override
	public List listarZonaPostal(Class clazz,
			List<ParametroPersistenciaGenerico> parametros) {
		return dao.listarPorQuery(clazz, "seguridad.personamast.zonapostal",
				parametros);
	}
	
	@Override
	public Integer nuevoCodigo() {
		return dao.contar("seguridad.personamast.obtenerCodigoMaximo")
				.intValue();
	}
	
	@Override
	public List buscarIguales(Class clazz,
			List<ParametroPersistenciaGenerico> parametros) {
		return dao.listarPorQuery(clazz,
				"seguridad.personamast.buscarIguales", parametros);
	}

	@Override
	public List tipoContrato(Class clazz) {
		return dao.listarPorQuery(clazz, "seguridad.personamast.tipoContrato");
	}

}
