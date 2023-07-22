package net.royal.seguridad.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.seguridad.dao.AcSucursalDao;
import net.royal.seguridad.dominio.AcSucursal;
import net.royal.seguridad.dominio.AcSucursalPk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("acSucursalDaoImplSeguridad")
public class AcSucursalDaoImpl extends
		GenericoDaoImpl<AcSucursal, AcSucursalPk> implements AcSucursalDao {

	private static Log LOGGER = LogFactory.getLog(AcSucursalDaoImpl.class);

	public AcSucursalDaoImpl() {
		super("seguridad.acsucursal");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
