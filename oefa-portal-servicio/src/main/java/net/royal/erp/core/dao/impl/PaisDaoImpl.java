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
import net.royal.erp.core.dao.PaisDao;
import net.royal.erp.core.dominio.Pais;
import net.royal.erp.core.dominio.PaisPk;

@Repository
public class PaisDaoImpl extends GenericoDaoImpl<Pais, PaisPk> implements PaisDao {

	private static Log LOGGER = LogFactory.getLog(Pais.class);

	public PaisDaoImpl() {
		super("pais");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<Pais> ListarPaisesxEstado() {
		Criteria cri = this.getCriteria();

		cri.add(Restrictions.eq("estado", "A"));
		
		List datos = this.listarPorCriterios(cri);
		
		if(UValidador.esListaVacia(datos))
			return null;
		
		return datos;
	}
	
	

}
