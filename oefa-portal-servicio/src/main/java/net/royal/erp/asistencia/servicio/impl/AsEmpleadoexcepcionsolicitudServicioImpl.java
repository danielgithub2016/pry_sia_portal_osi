package net.royal.erp.asistencia.servicio.impl;

import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.dao.AsEmpleadoexcepcionsolicitudDao;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcionsolicitud;
import net.royal.erp.asistencia.servicio.AsEmpleadoexcepcionsolicitudServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsEmpleadoexcepcionsolicitud")
public class AsEmpleadoexcepcionsolicitudServicioImpl extends
		GenericoServicioImpl implements AsEmpleadoexcepcionsolicitudServicio {

	private AsEmpleadoexcepcionsolicitudDao dao;

	private static Log LOGGER = LogFactory
			.getLog(AsEmpleadoexcepcionsolicitudServicioImpl.class);

	@Autowired
	public void setDao(AsEmpleadoexcepcionsolicitudDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<AsEmpleadoexcepcionsolicitud> listarEmpleadoExcepcionSolicitud(Integer p_empleado,
			Date p_fechasolicitud) {
		return dao.listarEmpleadoExcepcionSolicitud(p_empleado,
				p_fechasolicitud);
	}

}
