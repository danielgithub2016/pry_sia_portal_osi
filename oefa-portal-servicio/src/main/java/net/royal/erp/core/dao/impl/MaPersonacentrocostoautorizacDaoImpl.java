package net.royal.erp.core.dao.impl;

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
import net.royal.erp.core.dao.MaPersonacentrocostoautorizacDao;
import net.royal.erp.core.dominio.MaPersonacentrocostoautorizac;
import net.royal.erp.core.dominio.MaPersonacentrocostoautorizacPk;

@Repository
public class MaPersonacentrocostoautorizacDaoImpl
		extends
		GenericoDaoImpl<MaPersonacentrocostoautorizac, MaPersonacentrocostoautorizacPk>
		implements MaPersonacentrocostoautorizacDao {

	private static Log LOGGER = LogFactory
			.getLog(MaPersonacentrocostoautorizac.class);

	public MaPersonacentrocostoautorizacDaoImpl() {
		super("mapersonacentrocostoautorizac");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
