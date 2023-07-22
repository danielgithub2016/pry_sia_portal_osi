package net.royal.erp.asistencia.servicio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.dao.AsAutorizacionfechaDao;
import net.royal.erp.asistencia.dominio.AsAutorizacionfecha;
import net.royal.erp.asistencia.servicio.AsAutorizacionfechaServicio;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsAutorizacionfecha")
public class AsAutorizacionfechaServicioImpl extends GenericoServicioImpl implements AsAutorizacionfechaServicio {

	private AsAutorizacionfechaDao dao;

	private static Log LOGGER = LogFactory.getLog(AsAutorizacionfechaServicioImpl.class);

	@Autowired
	public void setDao(AsAutorizacionfechaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Integer obtenercantidadAutorizacionFecha(Integer empleado, Date desde) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_desde", Date.class, desde));

		return dao.contar("asautorizacionfecha.obtenercantidadAutorizacionFecha", filtros);
	}
}
