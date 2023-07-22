package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrRequerimientofuncasdetDao;
import net.royal.erp.rrhh.dominio.HrRequerimientofuncasdet;
import net.royal.erp.rrhh.dominio.HrRequerimientofuncasdetPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrRequerimientofuncasdetDaoImpl extends
		GenericoDaoImpl<HrRequerimientofuncasdet, HrRequerimientofuncasdetPk>
		implements HrRequerimientofuncasdetDao {

	private static Log LOGGER = LogFactory
			.getLog(HrRequerimientofuncasdet.class);

	public HrRequerimientofuncasdetDaoImpl() {
		super("hrrequerimientofuncasdet");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HrRequerimientofuncasdet> listarRequerimientoFuncasDet(
			String compania, String requerimiento) {
		// TODO Auto-generated method stub
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companyowner", compania));
		cri.add(Restrictions.eq("pk.requerimiento", requerimiento));

		return cri.list();
	}

	@Override
	public void eliminarporCampos(String companyowner, String requerimiento) {
		// TODO Auto-generated method stub
		List<HrRequerimientofuncasdet> lista = this.listarPorCriterios(this
				.getCriteria().add(
						Restrictions.and(Restrictions.eq("pk.companyowner",
								companyowner), Restrictions.eq(
								"pk.requerimiento", requerimiento))));

		if (!UValidador.esListaVacia(lista)) {
			for (HrRequerimientofuncasdet obj : lista) {
				this.eliminar(obj);
			}

		}
	}

}
