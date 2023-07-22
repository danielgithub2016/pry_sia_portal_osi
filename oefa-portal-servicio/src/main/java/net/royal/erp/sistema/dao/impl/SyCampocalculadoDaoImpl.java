package net.royal.erp.sistema.dao.impl;

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
import net.royal.erp.sistema.dao.SyCampocalculadoDao;
import net.royal.erp.sistema.dominio.SyCampocalculado;
import net.royal.erp.sistema.dominio.SyCampocalculadoPk;

@Repository
public class SyCampocalculadoDaoImpl extends
		GenericoDaoImpl<SyCampocalculado, SyCampocalculadoPk> implements
		SyCampocalculadoDao {

	private static Log LOGGER = LogFactory.getLog(SyCampocalculado.class);

	public SyCampocalculadoDaoImpl() {
		super("sycampocalculado");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
