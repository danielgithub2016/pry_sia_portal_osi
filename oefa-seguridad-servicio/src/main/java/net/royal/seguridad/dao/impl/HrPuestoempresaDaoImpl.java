package net.royal.seguridad.dao.impl;

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
import net.royal.seguridad.dao.HrPuestoempresaDao;
import net.royal.seguridad.dominio.HrPuestoempresa;
import net.royal.seguridad.dominio.HrPuestoempresaPk;

@Repository("hrPuestoempresaDaoImplSeguridad")
public class HrPuestoempresaDaoImpl extends GenericoDaoImpl<HrPuestoempresa, HrPuestoempresaPk> implements HrPuestoempresaDao {

	private static Log LOGGER = LogFactory.getLog(HrPuestoempresa.class);

	public HrPuestoempresaDaoImpl() {
		super("seguridad.hrpuestoempresa");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
