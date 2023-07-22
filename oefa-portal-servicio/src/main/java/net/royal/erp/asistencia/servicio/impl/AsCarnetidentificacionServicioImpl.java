package net.royal.erp.asistencia.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.asistencia.dao.AsCarnetidentificacionDao;
import net.royal.erp.asistencia.dominio.AsCarnetidentificacion;
import net.royal.erp.asistencia.dominio.dto.DtoAsCarnetidentificacion;
import net.royal.erp.asistencia.servicio.AsCarnetidentificacionServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsCarnetidentificacion")
public class AsCarnetidentificacionServicioImpl extends GenericoServicioImpl
		implements AsCarnetidentificacionServicio {

	private AsCarnetidentificacionDao dao;

	private static Log LOGGER = LogFactory
			.getLog(AsCarnetidentificacionServicioImpl.class);

	@Autowired
	public void setDao(AsCarnetidentificacionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public String obtenerMaximoComportamientoSobretiempo(Integer empleado) {
		// TODO Auto-generated method stub
		String resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado",
				Integer.class, empleado));
		List data = dao
				.listarPorQuery(
						DtoAsCarnetidentificacion.class,
						"ascarnetidentificacion.obtenerMaximoComportamientoSobretiempo",
						filtros);
		if (!UValidador.esListaVacia(data)) {
			resultado = ((DtoAsCarnetidentificacion) data.get(0))
					.getComportamientosobretiempo();
		}

		return resultado;
	}

	@Override
	public String obtenerMaximoCodigoCarnet(Integer empleado) {
		// TODO Auto-generated method stub
		String resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado",
				Integer.class, empleado));
		List data = dao.listarPorQuery(DtoAsCarnetidentificacion.class,
				"ascarnetidentificacion.obtenerMaximoCodigoCarnet", filtros);
		if (!UValidador.esListaVacia(data)) {
			resultado = ((DtoAsCarnetidentificacion) data.get(0))
					.getCodigocarnet();
		}

		return resultado;
	}

	@Override
	public String obtenerCodigoCarnet(Integer w_empleado) {
		// TODO Auto-generated method stub
		return dao.obtenerMaximoCodigoCarnet(w_empleado);
	}

	@Override
	public Integer obtenerMaximoEmpleadoXCarnet(String w_carnet) {
		// TODO Auto-generated method stub
		return dao.obtenerMaximoEmpleadoXCarnet(w_carnet);
	}

	@Override
	public String obtenerMaximoCodigoCarnetActivo(Integer empleado) {
		// TODO Auto-generated method stub
		return dao.obtenerMaximoCodigoCarnetActivo(empleado);
	}

	@Override
	public AsCarnetidentificacion obtenerPorEmplado(Integer empleado) {
		// TODO Auto-generated method stub
		AsCarnetidentificacion resultado = null;

		Criteria cri = dao.getCriteria();
		cri.add(Restrictions.eq("pk.empleado", empleado));

		List<AsCarnetidentificacion> data = dao.listarPorCriterios(cri);
		if (!UValidador.esListaVacia(data)) {
			resultado = data.get(0);
		}

		return resultado;
	}

}
