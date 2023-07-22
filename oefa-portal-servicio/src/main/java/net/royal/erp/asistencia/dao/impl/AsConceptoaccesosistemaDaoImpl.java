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
import net.royal.erp.asistencia.dao.AsConceptoaccesosistemaDao;
import net.royal.erp.asistencia.dominio.AsConceptoaccesosistema;
import net.royal.erp.asistencia.dominio.AsConceptoaccesosistemaPk;

@Repository
public class AsConceptoaccesosistemaDaoImpl extends
		GenericoDaoImpl<AsConceptoaccesosistema, AsConceptoaccesosistemaPk>
		implements AsConceptoaccesosistemaDao {

	private static Log LOGGER = LogFactory
			.getLog(AsConceptoaccesosistema.class);

	public AsConceptoaccesosistemaDaoImpl() {
		super("asconceptoaccesosistema");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
