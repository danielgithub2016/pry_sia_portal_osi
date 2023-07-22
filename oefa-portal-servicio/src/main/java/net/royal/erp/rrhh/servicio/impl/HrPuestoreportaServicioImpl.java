package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrPuestoreportaDao;
import net.royal.erp.rrhh.dominio.HrGradosalariomast;
import net.royal.erp.rrhh.dominio.HrPuestoreporta;
import net.royal.erp.rrhh.servicio.HrPuestoreportaServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service (value = "BeanServicioHrPuestoreporta")
public class HrPuestoreportaServicioImpl extends GenericoServicioImpl implements HrPuestoreportaServicio {

	private HrPuestoreportaDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestoreportaServicioImpl.class);

	@Autowired
	public void setDao(HrPuestoreportaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrPuestoreporta> listarTabRelaciones(Integer codigopuesto) {
		return dao.listarTabRelaciones(codigopuesto);
	}

	@Override
	public List<HrPuestoreporta> listarPuestoreporta() {
		Criteria cri = dao.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));
		return  dao.listarPorCriterios(cri);
	}
	

}
