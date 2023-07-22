package net.royal.erp.core.servicio.impl;

import java.util.List;

import net.royal.erp.core.dao.PrimemstDao;
import net.royal.erp.core.dominio.Primemst;
import net.royal.erp.core.servicio.PrimemstServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service (value = "BeanServicioPrimemst")
public class PrimemstServicioImpl extends GenericoServicioImpl implements PrimemstServicio {

	private PrimemstDao dao;

	private static Log LOGGER = LogFactory.getLog(PrimemstServicioImpl.class);

	@Autowired
	public void setDao(PrimemstDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<Primemst> listarCombo(Integer DigitsNumber) {
		// TODO Auto-generated method stub
		return dao.listarCombo(DigitsNumber);
	}

}
