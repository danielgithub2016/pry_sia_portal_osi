package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.TiposervicioDao;
import net.royal.erp.core.servicio.TiposervicioServicio;
import net.royal.erp.core.dominio.Tiposervicio;
import net.royal.erp.core.dominio.TiposervicioPk;

@Service(value = "BeanServicioTiposervicio")
public class TiposervicioServicioImpl extends GenericoServicioImpl implements
		TiposervicioServicio {

	private TiposervicioDao dao;

	private static Log LOGGER = LogFactory
			.getLog(TiposervicioServicioImpl.class);

	@Autowired
	public void setDao(TiposervicioDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<Tiposervicio> listarTipoServicio(String par_tipo) {
		return dao.listarTipoServicio(par_tipo);
	}

}
