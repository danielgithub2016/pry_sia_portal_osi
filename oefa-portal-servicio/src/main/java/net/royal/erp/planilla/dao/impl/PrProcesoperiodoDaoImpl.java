package net.royal.erp.planilla.dao.impl;

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
import net.royal.erp.planilla.dao.PrProcesoperiodoDao;
import net.royal.erp.planilla.dominio.PrProcesoperiodo;
import net.royal.erp.planilla.dominio.PrProcesoperiodoPk;

@Repository
public class PrProcesoperiodoDaoImpl extends GenericoDaoImpl<PrProcesoperiodo, PrProcesoperiodoPk> implements PrProcesoperiodoDao {

	private static Log LOGGER = LogFactory.getLog(PrProcesoperiodo.class);

	public PrProcesoperiodoDaoImpl() {
		super("prprocesoperiodo");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
