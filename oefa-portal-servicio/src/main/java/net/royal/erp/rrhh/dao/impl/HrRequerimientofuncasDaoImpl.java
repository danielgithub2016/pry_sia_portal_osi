package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrRequerimientofuncasDao;
import net.royal.erp.rrhh.dominio.HrRequerimientofuncas;
import net.royal.erp.rrhh.dominio.HrRequerimientofuncasPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrRequerimientofuncasDaoImpl extends
		GenericoDaoImpl<HrRequerimientofuncas, HrRequerimientofuncasPk>
		implements HrRequerimientofuncasDao {

	private static Log LOGGER = LogFactory.getLog(HrRequerimientofuncas.class);

	public HrRequerimientofuncasDaoImpl() {
		super("hrrequerimientofuncas");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HrRequerimientofuncas> listarRequerimientoFuncas(
			String companyowner, String requerimiento) {
		// TODO Auto-generated method stub
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companyowner", companyowner));
		cri.add(Restrictions.eq("pk.requerimiento", requerimiento));

		return cri.list();
	}

	@Override
	public void eliminarporCampos(String companyowner, String requerimiento) {
		// TODO Auto-generated method stub
		List<HrRequerimientofuncas> lista = this.listarPorCriterios(this
				.getCriteria().add(
						Restrictions.and(Restrictions.eq("pk.companyowner",
								companyowner), Restrictions.eq(
								"pk.requerimiento", requerimiento))));

		if (!UValidador.esListaVacia(lista)) {
			for (HrRequerimientofuncas obj : lista) {
				this.eliminar(obj);
			}

		}
	}

}
