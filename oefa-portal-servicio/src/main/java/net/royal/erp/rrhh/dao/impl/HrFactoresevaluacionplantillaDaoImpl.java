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
import net.royal.erp.rrhh.dao.HrFactoresevaluacionplantillaDao;
import net.royal.erp.rrhh.dominio.HrFactoresevaluacionplantilla;
import net.royal.erp.rrhh.dominio.HrFactoresevaluacionplantillaPk;

@Repository
public class HrFactoresevaluacionplantillaDaoImpl extends GenericoDaoImpl<HrFactoresevaluacionplantilla, HrFactoresevaluacionplantillaPk> implements HrFactoresevaluacionplantillaDao {

	private static Log LOGGER = LogFactory.getLog(HrFactoresevaluacionplantilla.class);

	public HrFactoresevaluacionplantillaDaoImpl() {
		super("hrfactoresevaluacionplantilla");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
