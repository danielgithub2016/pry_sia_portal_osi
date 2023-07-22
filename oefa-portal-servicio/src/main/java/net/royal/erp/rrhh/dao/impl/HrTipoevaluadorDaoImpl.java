package net.royal.erp.rrhh.dao.impl;

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
import net.royal.erp.rrhh.dao.HrTipoevaluadorDao;
import net.royal.erp.rrhh.dominio.HrTipoevaluador;
import net.royal.erp.rrhh.dominio.HrTipoevaluadorPk;

@Repository
public class HrTipoevaluadorDaoImpl extends GenericoDaoImpl<HrTipoevaluador, HrTipoevaluadorPk> implements HrTipoevaluadorDao {

	private static Log LOGGER = LogFactory.getLog(HrTipoevaluador.class);

	public HrTipoevaluadorDaoImpl() {
		super("hrtipoevaluador");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
