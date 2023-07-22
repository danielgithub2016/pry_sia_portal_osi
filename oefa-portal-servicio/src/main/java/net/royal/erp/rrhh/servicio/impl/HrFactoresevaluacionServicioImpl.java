package net.royal.erp.rrhh.servicio.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrFactoresevaluacionDao;
import net.royal.erp.rrhh.servicio.HrFactoresevaluacionServicio;
import net.royal.erp.rrhh.dominio.HrFactoresevaluacion;
import net.royal.erp.rrhh.dominio.HrFactoresevaluacionPk;
import net.royal.erp.rrhh.dominio.dto.DtoHRFactoresEvaluacion;

@Service(value = "BeanServicioHrFactoresevaluacion")
public class HrFactoresevaluacionServicioImpl extends GenericoServicioImpl
		implements HrFactoresevaluacionServicio {

	private HrFactoresevaluacionDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrFactoresevaluacionServicioImpl.class);

	@Autowired
	public void setDao(HrFactoresevaluacionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List obtenerFactoresEvaluacion(String par_plantilla) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_plantilla",
				String.class, par_plantilla));

		List datos = dao.listarPorQuery(DtoHRFactoresEvaluacion.class,
				"hrfactoresevaluacion.obtenerFactores", parametros);

		return datos;
	}

	@Override
	public List obtenerValoresEvaluacion(String par_plantilla) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_plantilla",
				String.class, par_plantilla));

		List datos = dao.listarPorQuery(DtoHRFactoresEvaluacion.class,
				"hrfactoresevaluacion.obtenerValores", parametros);

		return datos;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BigDecimal obtenerPromedioCategoriaDesempeno(Integer factor,
			Integer empleado, String compania, Integer secuenciaeval) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("factor",
				Integer.class, factor));
		parametros.add(new ParametroPersistenciaGenerico("empleado",
				Integer.class, empleado));
		parametros.add(new ParametroPersistenciaGenerico("compania",
				String.class, compania));
		parametros.add(new ParametroPersistenciaGenerico("secuenciaeval",
				Integer.class, secuenciaeval));

		List<DtoHRFactoresEvaluacion> lista = (List) dao.listarPorQuery(
				DtoHRFactoresEvaluacion.class,
				"hrfactoresevaluacion.obtenerPromedioCategoriaDesempeno",
				parametros);

		if (!UValidador.esListaVacia(lista)) {
			return UValidador.esNulo(lista.get(0).getPromedio()) ? BigDecimal.ZERO
					: lista.get(0).getPromedio();
		}

		return null;
	}

}
