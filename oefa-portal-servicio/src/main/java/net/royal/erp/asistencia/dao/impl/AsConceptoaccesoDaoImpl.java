package net.royal.erp.asistencia.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.asistencia.dao.AsConceptoaccesoDao;
import net.royal.erp.asistencia.dominio.AsConceptoacceso;
import net.royal.erp.asistencia.dominio.AsConceptoaccesoPk;

@Repository
public class AsConceptoaccesoDaoImpl extends
		GenericoDaoImpl<AsConceptoacceso, AsConceptoaccesoPk> implements
		AsConceptoaccesoDao {

	private static Log LOGGER = LogFactory.getLog(AsConceptoacceso.class);

	public AsConceptoaccesoDaoImpl() {
		super("asconceptoacceso");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<AsConceptoacceso> listarActivos() {
		return this.listarPorCriterios(this.getCriteria().add(
				Restrictions.eq("estado", "A")));
	}

}
