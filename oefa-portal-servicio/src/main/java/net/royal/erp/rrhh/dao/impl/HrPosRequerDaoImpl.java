package net.royal.erp.rrhh.dao.impl;

import javax.annotation.Resource;

import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.erp.rrhh.dao.HrPosRequerDao;
import net.royal.erp.rrhh.dominio.HrPosRequer;
import net.royal.erp.rrhh.dominio.HrPosRequerPk;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@SuppressWarnings("serial")
@Repository("hrPosRequerDaoImpl")
public class HrPosRequerDaoImpl extends GenericoDaoImpl<HrPosRequer, HrPosRequerPk> implements HrPosRequerDao {
	public HrPosRequerDaoImpl() {
		super("hrposrequer");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Integer obtenerEtapaActual(String requerimiento, String commpanyowner) {
		Criteria cri = this.getCriteria()
				.add(Restrictions.and(Restrictions.eq("pk.requerimiento", requerimiento),
						Restrictions.eq("pk.companyowner", commpanyowner)))
				.setProjection(Projections.projectionList().add(Projections.max("secuencia")));
		Integer etapa = this.incrementarInteger(cri);
		etapa--;
		return etapa;
	}
}
