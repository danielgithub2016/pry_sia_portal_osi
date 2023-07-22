package net.royal.erp.rrhh.dao.impl;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrMotivoceseDao;
import net.royal.erp.rrhh.dominio.HrMotivocese;
import net.royal.erp.rrhh.dominio.HrMotivocesePk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class HrMotivoceseDaoImpl extends
		GenericoDaoImpl<HrMotivocese, HrMotivocesePk> implements
		HrMotivoceseDao {

	private static Log LOGGER = LogFactory.getLog(HrMotivocese.class);

	public HrMotivoceseDaoImpl() {
		super("hrmotivocese");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
