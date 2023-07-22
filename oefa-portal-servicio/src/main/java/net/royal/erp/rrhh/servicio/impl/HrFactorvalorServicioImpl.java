package net.royal.erp.rrhh.servicio.impl;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.rrhh.dao.HrFactorvalorDao;
import net.royal.erp.rrhh.dominio.HrFactorvalor;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrFactorvalorSelCore;
import net.royal.erp.rrhh.servicio.HrFactorvalorServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service (value = "BeanServicioHrFactorvalor")
public class HrFactorvalorServicioImpl extends GenericoServicioImpl implements HrFactorvalorServicio {

	private HrFactorvalorDao dao;

	private static Log LOGGER = LogFactory.getLog(HrFactorvalorServicioImpl.class);

	@Autowired
	public void setDao(HrFactorvalorDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public List<HrFactorvalor> obtenerLista(Integer factor){
		return dao.obtenerLista(factor);
	}

	@Override
	public Integer obtenerMax(Integer factor) {
		return dao.obtenerMax(factor);
	}

	@Override
	public Integer obtenerMim(Integer factor) {
		return dao.obtenerMim(factor);
	}
	
	public List<DtoDwHrFactorvalorSelCore> listarDw1(Integer par_factor){
		return dao.listarDw1(par_factor);
	}
	
}
