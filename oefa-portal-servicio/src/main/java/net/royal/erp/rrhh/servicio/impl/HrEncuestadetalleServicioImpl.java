package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.rrhh.dao.HrEncuestadetalleDao;
import net.royal.erp.rrhh.dominio.dto.DtoHrEncuestadetalle;
import net.royal.erp.rrhh.servicio.HrEncuestadetalleServicio;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrEncuestadetalle")
public class HrEncuestadetalleServicioImpl extends GenericoServicioImpl
		implements HrEncuestadetalleServicio {

	private HrEncuestadetalleDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrEncuestadetalleServicioImpl.class);

	@Autowired
	public void setDao(HrEncuestadetalleDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEncuestadetalle> listarDetalle(Integer secuencia,
			String tipoEncuesta) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("secuencia",
				Integer.class, secuencia));
		parametros.add(new ParametroPersistenciaGenerico("tipo_encuesta",
				String.class, tipoEncuesta));
		List lista = dao.listarPorQuery(DtoHrEncuestadetalle.class,
				"hrencuestadetalle.listarDetalle", parametros);
		return lista;
	}

}
