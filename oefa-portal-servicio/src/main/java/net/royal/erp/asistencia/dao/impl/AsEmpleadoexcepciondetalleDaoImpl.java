package net.royal.erp.asistencia.dao.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.royal.erp.asistencia.dao.AsEmpleadoexcepciondetalleDao;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepciondetalle;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepciondetallePk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@Repository
public class AsEmpleadoexcepciondetalleDaoImpl
		extends
		GenericoDaoImpl<AsEmpleadoexcepciondetalle, AsEmpleadoexcepciondetallePk>
		implements AsEmpleadoexcepciondetalleDao {

	private static Log LOGGER = LogFactory
			.getLog(AsEmpleadoexcepciondetalle.class);

	public AsEmpleadoexcepciondetalleDaoImpl() {
		super("asempleadoexcepciondetalle");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}
	
	
}
