package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrRequerimientoreemplazoDao;
import net.royal.erp.rrhh.dominio.HrRequerimientoreemplazo;
import net.royal.erp.rrhh.dominio.HrRequerimientoreemplazoPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrRequerimientoreemplazoDaoImpl extends
		GenericoDaoImpl<HrRequerimientoreemplazo, HrRequerimientoreemplazoPk>
		implements HrRequerimientoreemplazoDao {

	private static Log LOGGER = LogFactory
			.getLog(HrRequerimientoreemplazo.class);

	public HrRequerimientoreemplazoDaoImpl() {
		super("hrrequerimientoreemplazo");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HrRequerimientoreemplazo> listarReuqerimientoReemplazo(
			String companyOwner, String requerimiento) {
		// TODO Auto-generated method stub
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companyowner", companyOwner));
		cri.add(Restrictions.eq("pk.requerimiento", requerimiento));
		return cri.list();
	}

	@Override
	public void eliminarRequerimientoReemplazo(String companyOwner,
			String requerimiento) {
		List<HrRequerimientoreemplazo> lstDatos = listarReuqerimientoReemplazo(
				companyOwner, requerimiento);

		for (HrRequerimientoreemplazo obj : lstDatos) {
			eliminar(obj);
		}
	}

}
