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
import net.royal.erp.core.dao.MaPersonagrupoDao;
import net.royal.erp.core.dominio.MaPersonagrupo;
import net.royal.erp.core.dominio.MaPersonagrupoPk;

@Repository
public class MaPersonagrupoDaoImpl extends GenericoDaoImpl<MaPersonagrupo, MaPersonagrupoPk> implements MaPersonagrupoDao {

	private static Log LOGGER = LogFactory.getLog(MaPersonagrupo.class);

	public MaPersonagrupoDaoImpl() {
		super("mapersonagrupo");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
