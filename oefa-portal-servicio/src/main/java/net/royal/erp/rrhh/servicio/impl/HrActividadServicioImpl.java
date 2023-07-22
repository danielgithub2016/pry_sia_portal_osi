package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.rrhh.dao.HrActividadDao;
import net.royal.erp.rrhh.dominio.dto.DtoHrActividad;
import net.royal.erp.rrhh.servicio.HrActividadServicio;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioHrActividad")
public class HrActividadServicioImpl extends GenericoServicioImpl implements
		HrActividadServicio {

	private HrActividadDao dao;

	@Autowired
	public void setDao(HrActividadDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrActividad> listarHrActividad(String flg_publicacion,
			Date fecha_actual, String estado, Integer empleado) {
		StringBuilder query = new StringBuilder(dao.getSesionActual()
				.getNamedQuery("hractividad.listarHrActividad")
				.getQueryString()
				+ System.lineSeparator());

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("flg_publicacion",
				String.class, flg_publicacion));
		parametros.add(new ParametroPersistenciaGenerico("empleado",
				Integer.class, empleado));

		fecha_actual = new Date();

		query.append("AND  SYSDATE  BETWEEN H.FECHADESDEPUBLICACION AND  H.FECHAHASTAPUBLICACION ");

		List lista = dao.listarPorSentenciaSQL(DtoHrActividad.class, query,
				parametros);
		
		return lista;
	}

}
