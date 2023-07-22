package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrPlantillaevapotencialDao;
import net.royal.erp.rrhh.dominio.HrPlantillaevapotencial;
import net.royal.erp.rrhh.servicio.HrPlantillaevapotencialServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service (value = "BeanServicioHrPlantillaevapotencial")
public class HrPlantillaevapotencialServicioImpl extends GenericoServicioImpl implements HrPlantillaevapotencialServicio {

	private HrPlantillaevapotencialDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPlantillaevapotencialServicioImpl.class);

	@Autowired
	public void setDao(HrPlantillaevapotencialDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}
	
	public List<HrPlantillaevapotencial> listarPlantillaPotencial(String par_plantilla){
		return dao.listarPlantillaPotencial(par_plantilla);
	}

}
