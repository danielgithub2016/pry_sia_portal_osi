package net.royal.seguridad.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.seguridad.dao.AcCostcentermstDao;
import net.royal.seguridad.dominio.AcCostcentermst;
import net.royal.seguridad.dominio.AcCostcentermstPk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("acCostcentermstDaoImplSeguridad")
public class AcCostcentermstDaoImpl extends GenericoDaoImpl<AcCostcentermst, AcCostcentermstPk> implements AcCostcentermstDao {

	private static Log LOGGER = LogFactory.getLog(AcCostcentermst.class);
	private ComunDao dao;
	
	public AcCostcentermstDaoImpl() {
		super("seguridad.accostcentermst");
	}

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}
	
	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}


}
