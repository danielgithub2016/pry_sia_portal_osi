package net.royal.erp.planilla.servicio.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.planilla.dao.PrTipoplanillaDao;
import net.royal.erp.planilla.dominio.PrTipoplanilla;
import net.royal.erp.planilla.servicio.PrTipoplanillaServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioPrTipoplanilla")
public class PrTipoplanillaServicioImpl extends GenericoServicioImpl implements PrTipoplanillaServicio {

	private PrTipoplanillaDao dao;

	private static Log LOGGER = LogFactory.getLog(PrTipoplanillaServicioImpl.class);

	@Autowired
	public void setDao(PrTipoplanillaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<PrTipoplanilla> ListarTipoPlanilla() {
		return dao.ListarTipoPlanilla();
	}

	@Override
	public List<PrTipoplanilla> listaTipoPlanillaSeguridad(String todos, String... tiposplanilla) {
		return dao.listaTipoPlanillaSeguridad(todos, tiposplanilla);
	}

}
