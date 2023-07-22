package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrClasificadorcargoDao;
import net.royal.erp.rrhh.dominio.HrClasificadorcargo;
import net.royal.erp.rrhh.dominio.HrClasificadorcargoPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrClasificadorcargoDaoImpl extends GenericoDaoImpl<HrClasificadorcargo, HrClasificadorcargoPk> implements HrClasificadorcargoDao {

	private static Log LOGGER = LogFactory.getLog(HrClasificadorcargo.class);

	public HrClasificadorcargoDaoImpl() {
		super("hrclasificadorcargo");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public HrClasificadorcargo obtenerClasificadorCargoparam(
			String clasificadorcargo) {
		
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.clasificadorcargo", clasificadorcargo));

		List<HrClasificadorcargo> datos = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(datos))
			return null;

		return datos.get(0);
	}

}
