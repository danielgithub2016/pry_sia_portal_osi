package net.royal.erp.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.asistencia.dominio.AsCarnetidentificacion;
import net.royal.erp.core.dao.ReferencefieldmstDao;
import net.royal.erp.core.dominio.Referencefieldmst;
import net.royal.erp.core.dominio.ReferencefieldmstPk;

@Repository
public class ReferencefieldmstDaoImpl extends
		GenericoDaoImpl<Referencefieldmst, ReferencefieldmstPk> implements
		ReferencefieldmstDao {

	private static Log LOGGER = LogFactory.getLog(Referencefieldmst.class);

	public ReferencefieldmstDaoImpl() {
		super("referencefieldmst");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	/**
	 * obtener titulo para popup
	 * controladora: CWMaAcReferencefield8Select
	 * wf_sql_read_title
	 */
	@Override
	public String obtenerTitulo(String ReferenceField) {
		Criteria cri = this.getCriteria();

		cri.add(Restrictions.eq("pk.referencefield", ReferenceField));
		
		List result = this.listarPorCriterios(cri);

		if (result.size() == 0)
			return null;

		Referencefieldmst reference = (Referencefieldmst) result
				.get(0);

		return reference.getLocalname();

	}

}
