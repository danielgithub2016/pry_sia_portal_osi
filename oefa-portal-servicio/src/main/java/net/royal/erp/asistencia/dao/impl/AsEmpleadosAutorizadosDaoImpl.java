package net.royal.erp.asistencia.dao.impl;

import javax.annotation.Resource;

import net.royal.erp.asistencia.dao.AsEmpleadosAutorizadosDao;
import net.royal.erp.asistencia.dominio.AsEmpleadosAutorizados;
import net.royal.erp.asistencia.dominio.AsEmpleadosAutorizadosPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AsEmpleadosAutorizadosDaoImpl extends
		GenericoDaoImpl<AsEmpleadosAutorizados, AsEmpleadosAutorizadosPk>
		implements AsEmpleadosAutorizadosDao {

	private static Log LOGGER = LogFactory.getLog(AsEmpleadosAutorizados.class);
	

	public AsEmpleadosAutorizadosDaoImpl() {
		super("asempleadosautorizados");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}


	
}
