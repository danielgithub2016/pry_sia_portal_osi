package net.royal.erp.asistencia.dao.impl;

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
import net.royal.erp.asistencia.dao.AsIntervaloaccesoDao;
import net.royal.erp.asistencia.dominio.AsIntervaloacceso;
import net.royal.erp.asistencia.dominio.AsIntervaloaccesoPk;

@Repository
public class AsIntervaloaccesoDaoImpl extends
		GenericoDaoImpl<AsIntervaloacceso, AsIntervaloaccesoPk> implements
		AsIntervaloaccesoDao {

	private static Log LOGGER = LogFactory.getLog(AsIntervaloacceso.class);

	public AsIntervaloaccesoDaoImpl() {
		super("asintervaloacceso");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
