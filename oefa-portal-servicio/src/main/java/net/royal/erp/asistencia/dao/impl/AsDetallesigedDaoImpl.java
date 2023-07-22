package net.royal.erp.asistencia.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.royal.erp.asistencia.dao.AsDetallesigedDao;
import net.royal.erp.asistencia.dominio.AsDetallesiged;
import net.royal.erp.asistencia.dominio.AsDetallesigedPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@Repository
public class AsDetallesigedDaoImpl extends GenericoDaoImpl<AsDetallesiged, AsDetallesigedPk>
		implements AsDetallesigedDao {
	
	public AsDetallesigedDaoImpl() {
		super("asdetallesiged");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}
	
	

}
