package net.royal.erp.asistencia.servicio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.dao.AsEmpleadoexcepcionDao;
import net.royal.erp.asistencia.servicio.AsEmpleadoexcepcionServicio;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsEmpleadoexcepcion")
public class AsEmpleadoexcepcionServicioImpl extends GenericoServicioImpl
		implements AsEmpleadoexcepcionServicio {

	private AsEmpleadoexcepcionDao dao;

	private static Log LOGGER = LogFactory
			.getLog(AsEmpleadoexcepcionServicioImpl.class);

	@Autowired
	public void setDao(AsEmpleadoexcepcionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public void eliminarEmpleadoExcepcionSolicitud(Integer par_empleado,
			Date par_fecha) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado",
				Integer.class, par_empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class,
				par_fecha));
		dao.ejecutarPorQuery(
				"asempleadoexcepcion.eliminarEmpleadoExcepcionSolicitud",
				filtros);
	}

}
