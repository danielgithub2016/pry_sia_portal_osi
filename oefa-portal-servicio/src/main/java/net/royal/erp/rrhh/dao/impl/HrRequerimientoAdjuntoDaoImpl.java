package net.royal.erp.rrhh.dao.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import net.royal.erp.rrhh.dao.HrRequerimientoAdjuntoDao;
import net.royal.erp.rrhh.dominio.HrRequerimientoAdjunto;
import net.royal.erp.rrhh.dominio.HrRequerimientoAdjuntoPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@Repository
public class HrRequerimientoAdjuntoDaoImpl extends GenericoDaoImpl<HrRequerimientoAdjunto, HrRequerimientoAdjuntoPk>
		implements HrRequerimientoAdjuntoDao {

	private static Log LOGGER = LogFactory.getLog(HrRequerimientoAdjunto.class);

	public HrRequerimientoAdjuntoDaoImpl() {
		super("hrrequerimientoadjunto");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Integer obtenerMaxmimo(String requerimiento, String compania) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.requerimiento", requerimiento));
		cri.add(Restrictions.eq("pk.companyowner", compania));

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("pk.secuencia"));

		cri.setProjection(proj);

		return incrementarInteger(cri);

	}

}
