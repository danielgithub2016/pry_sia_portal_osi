package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.rrhh.dao.HrEncuestapreguntavaloresDao;
import net.royal.erp.rrhh.dominio.dto.DtoHrEncuestapreguntavalores;
import net.royal.erp.rrhh.servicio.HrEncuestapreguntavaloresServicio;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrEncuestapreguntavalores")
public class HrEncuestapreguntavaloresServicioImpl extends GenericoServicioImpl
		implements HrEncuestapreguntavaloresServicio {

	private HrEncuestapreguntavaloresDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrEncuestapreguntavaloresServicioImpl.class);

	@Autowired
	public void setDao(HrEncuestapreguntavaloresDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEncuestapreguntavalores> listarValores(Integer secuencia,
			String tipoEncuesta) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("secuencia",
				Integer.class, secuencia));
		parametros.add(new ParametroPersistenciaGenerico("tipo_encuesta",
				String.class, tipoEncuesta));

		List lista = dao.listarPorQuery(DtoHrEncuestapreguntavalores.class,
				"hrencuestapreguntavalores.listarValores", parametros);
		return lista;
	}

}
