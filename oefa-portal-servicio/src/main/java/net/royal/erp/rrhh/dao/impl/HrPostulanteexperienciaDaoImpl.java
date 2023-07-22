package net.royal.erp.rrhh.dao.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.royal.erp.rrhh.dao.HrPostulanteexperienciaDao;
import net.royal.erp.rrhh.dominio.HrPostulanteexperiencia;
import net.royal.erp.rrhh.dominio.HrPostulanteexperienciaPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@SuppressWarnings("serial")
@Repository("hrPostulanteexperienciaDaoImpl")
public class HrPostulanteexperienciaDaoImpl extends GenericoDaoImpl<HrPostulanteexperiencia, HrPostulanteexperienciaPk>
		implements HrPostulanteexperienciaDao {

	@SuppressWarnings("unused")
	private static Log LOGGER = LogFactory.getLog(HrPostulanteexperiencia.class);

	public HrPostulanteexperienciaDaoImpl() {
		super("hrpostulanteexperiencia");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
