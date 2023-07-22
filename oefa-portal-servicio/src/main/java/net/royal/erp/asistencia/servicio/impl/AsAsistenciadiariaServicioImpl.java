package net.royal.erp.asistencia.servicio.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.asistencia.dao.AsAsistenciadiariaDao;
import net.royal.erp.asistencia.servicio.AsAsistenciadiariaServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service (value = "BeanServicioAsAsistenciadiaria")
public class AsAsistenciadiariaServicioImpl extends GenericoServicioImpl implements AsAsistenciadiariaServicio {

	private AsAsistenciadiariaDao dao;

	private static Log LOGGER = LogFactory.getLog(AsAsistenciadiariaServicioImpl.class);

	@Autowired
	public void setDao(AsAsistenciadiariaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List obtenerEmpleadosSeleccionados(Date p_fecha_desde, Date p_fecha_hasta, String p_flag_periodo,
			Integer p_sid,String p_seleccionadosAdicionados) {
		
		return dao.obtenerEmpleadosSeleccionados(p_fecha_desde, p_fecha_hasta, p_flag_periodo, p_sid, p_seleccionadosAdicionados);
	}

}
