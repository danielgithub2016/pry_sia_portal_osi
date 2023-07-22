package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPuestoexperienciaDao;
import net.royal.erp.rrhh.servicio.HrPuestoexperienciaServicio;
import net.royal.erp.rrhh.dominio.HrPuestoexperiencia;
import net.royal.erp.rrhh.dominio.HrPuestoexperienciaPk;

@Service (value = "BeanServicioHrPuestoexperiencia")
public class HrPuestoexperienciaServicioImpl extends GenericoServicioImpl implements HrPuestoexperienciaServicio {

	private HrPuestoexperienciaDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestoexperienciaServicioImpl.class);

	@Autowired
	public void setDao(HrPuestoexperienciaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrPuestoexperiencia> listarPuestoExperienciaporCodigo(
			Integer codigopuesto) {
		return dao.listarPuestoExperienciaporCodigo(codigopuesto);
	}

}
