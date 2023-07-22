package net.royal.erp.mantenimiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.mantenimiento.dao.MeTipomantenimientoDao;
import net.royal.erp.mantenimiento.dominio.MeTipomantenimiento;
import net.royal.erp.mantenimiento.dominio.MeTipomantenimientoPk;

@Repository
public class MeTipomantenimientoDaoImpl extends GenericoDaoImpl<MeTipomantenimiento, MeTipomantenimientoPk> implements MeTipomantenimientoDao {

	private static Log LOGGER = LogFactory.getLog(MeTipomantenimiento.class);

	public MeTipomantenimientoDaoImpl() {
		super("metipomantenimiento");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
