package net.royal.erp.contabilidad.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.contabilidad.dao.AcCostcenterCompaniaDao;
import net.royal.erp.contabilidad.dominio.AcCostcenterCompania;
import net.royal.erp.contabilidad.dominio.AcCostcenterCompaniaPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class AcCostcenterCompaniaDaoImpl extends
		GenericoDaoImpl<AcCostcenterCompania, AcCostcenterCompaniaPk> implements
		AcCostcenterCompaniaDao {

	public AcCostcenterCompaniaDaoImpl() {
		super("accostcentercompania");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<AcCostcenterCompania> listarAreaCreaDemanda(String compania,
			String ano, Integer version) {

		return this.listarPorCriterios(this.getCriteria().add(
				Restrictions.and(Restrictions.eq("pk.companiasocio", compania),
						Restrictions.eq("pk.ano", ano), Restrictions.eq(
								"pk.version", version), Restrictions.eq(
								"estado", "A"), Restrictions.or(
								Restrictions.eq("flgingsrv", "S"),
								Restrictions.eq("flgingbie", "S"),
								Restrictions.eq("flgingsum", "S"),
								Restrictions.eq("flgingpas", "S"),
								Restrictions.eq("flgingvia", "S"),
								Restrictions.eq("flgingcaj", "S")))));
	}
}
