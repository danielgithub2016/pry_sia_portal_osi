package net.royal.erp.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.core.dao.AfetypemstDao;
import net.royal.erp.core.dominio.Afetypemst;
import net.royal.erp.core.dominio.AfetypemstPk;

@Repository
public class AfetypemstDaoImpl extends
		GenericoDaoImpl<Afetypemst, AfetypemstPk> implements AfetypemstDao {

	private static Log LOGGER = LogFactory.getLog(Afetypemst.class);

	public AfetypemstDaoImpl() {
		super("afetypemst");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}
	
	public List<Afetypemst> listarTipoProyecto(){
		Criteria crit = this.getCriteria();
		crit.add(Restrictions.eq("status", "A"));
		
		List datos = this.listarPorCriterios(crit);
		if(UValidador.esListaVacia(datos)){
			return null;
		}
		return datos;
	}

}
