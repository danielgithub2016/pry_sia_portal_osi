package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPuestoempresaDocDao;
import net.royal.erp.rrhh.servicio.HrPuestoempresaDocServicio;
import net.royal.erp.rrhh.dominio.HrPuestoempresaDoc;
import net.royal.erp.rrhh.dominio.HrPuestoempresaDocPk;

@Service (value = "BeanServicioHrPuestoempresaDoc")
public class HrPuestoempresaDocServicioImpl extends GenericoServicioImpl implements HrPuestoempresaDocServicio {

	private HrPuestoempresaDocDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestoempresaDocServicioImpl.class);

	@Autowired
	public void setDao(HrPuestoempresaDocDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrPuestoempresaDoc> listarTabFormatosEvaluacion(
			Integer codigopuesto) {
		return dao.listarTabFormatosEvaluacion(codigopuesto);
	}

}
