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
import net.royal.erp.rrhh.dao.HrBsMetaDao;
import net.royal.erp.rrhh.dominio.HrBsMeta;
import net.royal.erp.rrhh.dominio.HrBsMetaPk;

@Repository
public class HrBsMetaDaoImpl extends GenericoDaoImpl<HrBsMeta, HrBsMetaPk> implements HrBsMetaDao {

	private static Log LOGGER = LogFactory.getLog(HrBsMeta.class);

	public HrBsMetaDaoImpl() {
		super("hrbsmeta");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
