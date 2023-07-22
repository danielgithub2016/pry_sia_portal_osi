package net.royal.erp.rrhh.dao.impl;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrTipocontratoDao;
import net.royal.erp.rrhh.dominio.HrTipocontrato;
import net.royal.erp.rrhh.dominio.HrTipocontratoPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class HrTipocontratoDaoImpl extends GenericoDaoImpl<HrTipocontrato, HrTipocontratoPk> implements HrTipocontratoDao {

	private static Log LOGGER = LogFactory.getLog(HrTipocontrato.class);

	public HrTipocontratoDaoImpl() {
		super("hrtipocontrato");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
