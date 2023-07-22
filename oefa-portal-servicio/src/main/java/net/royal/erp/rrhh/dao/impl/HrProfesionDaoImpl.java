package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrProfesionDao;
import net.royal.erp.rrhh.dominio.HrProfesion;
import net.royal.erp.rrhh.dominio.HrProfesionPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrProfesionDaoImpl extends
		GenericoDaoImpl<HrProfesion, HrProfesionPk> implements HrProfesionDao {

	private static Log LOGGER = LogFactory.getLog(HrProfesion.class);

	public HrProfesionDaoImpl() {
		super("hrprofesion");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public HrProfesion obtenerProfesion(String par_profesion) {
		
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.profesion", String.valueOf(par_profesion)));

		List<HrProfesion> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos)) {
			return null;
		}

		return datos.get(0);

	}

}
