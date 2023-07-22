package net.royal.erp.rrhh.servicio.impl;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.rrhh.dao.HrFactorvalorcapacDao;
import net.royal.erp.rrhh.servicio.HrFactorvalorcapacServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service (value = "BeanServicioHrFactorvalorcapac")
public class HrFactorvalorcapacServicioImpl extends GenericoServicioImpl implements HrFactorvalorcapacServicio {

	private HrFactorvalorcapacDao dao;

	private static Log LOGGER = LogFactory.getLog(HrFactorvalorcapacServicioImpl.class);

	@Autowired
	public void setDao(HrFactorvalorcapacDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public List listarFactor(Integer p_factor){
		return dao.listarFactor(p_factor);
	}
	
	public String f_sql_factorvalorcapac_rango(Integer p_factor,
			BigDecimal p_respuesta){
		return dao.f_sql_factorvalorcapac_rango(p_factor, p_respuesta);
	}
	
}
