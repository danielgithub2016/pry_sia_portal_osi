package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.TipodocumentocxpDao;
import net.royal.erp.core.servicio.TipodocumentocxpServicio;
import net.royal.erp.core.dominio.Tipodocumentocxp;
import net.royal.erp.core.dominio.TipodocumentocxpPk;

@Service(value = "BeanServicioTipodocumentocxp")
public class TipodocumentocxpServicioImpl extends GenericoServicioImpl
		implements TipodocumentocxpServicio {

	private TipodocumentocxpDao dao;

	private static Log LOGGER = LogFactory
			.getLog(TipodocumentocxpServicioImpl.class);

	@Autowired
	public void setDao(TipodocumentocxpDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public List listarDocCxp() {
		return dao.listarDocCxp();
	}

	@Override
	public String obtenertipomascara(String par_tipodocumento) {
		return dao.obtenertipomascara(par_tipodocumento);
	}

	@Override
	public Tipodocumentocxp obtenerTipoDocumento(String par_tipodocumento) {
		return dao.obtenerTipoDocumento(par_tipodocumento);
	}

	
}
