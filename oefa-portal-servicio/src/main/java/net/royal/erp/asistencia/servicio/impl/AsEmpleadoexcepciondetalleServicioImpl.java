package net.royal.erp.asistencia.servicio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.asistencia.dao.AsEmpleadoexcepciondetalleDao;
import net.royal.erp.asistencia.servicio.AsEmpleadoexcepciondetalleServicio;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioAsEmpleadoexcepciondetalle")
public class AsEmpleadoexcepciondetalleServicioImpl extends GenericoServicioImpl
		implements AsEmpleadoexcepciondetalleServicio {

	private AsEmpleadoexcepciondetalleDao dao;

	private static Log LOGGER = LogFactory.getLog(AsEmpleadoexcepciondetalleServicioImpl.class);

	@Autowired
	public void setDao(AsEmpleadoexcepciondetalleDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Integer obtenertipodiadescanso(Integer empleado, Date fecha) {
		// TODO Auto-generated method stub
		Integer resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));

		resultado = dao.contar("asempleadoexcepciondetalle.obtenertipodiadescanso", filtros);

		return resultado;
	}
	
	

}
