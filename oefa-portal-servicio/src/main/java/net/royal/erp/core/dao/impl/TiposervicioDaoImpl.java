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
import net.royal.erp.core.dao.TiposervicioDao;
import net.royal.erp.core.dominio.Tiposervicio;
import net.royal.erp.core.dominio.TiposervicioPk;

@Repository
public class TiposervicioDaoImpl extends
		GenericoDaoImpl<Tiposervicio, TiposervicioPk> implements
		TiposervicioDao {

	private static Log LOGGER = LogFactory.getLog(Tiposervicio.class);

	public TiposervicioDaoImpl() {
		super("tiposervicio");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<Tiposervicio> listarTipoServicio(String par_tipo) {
		Criteria cri =this.getCriteria();
		cri.add(Restrictions.eq("pk.tiposervicio", par_tipo));
		cri.add(Restrictions.eq("estado", "A"));
		
		List<Tiposervicio>list =this.listarPorCriterios(cri);
		
		if(!UValidador.esListaVacia(list))
			return list;
		
		
		return null;
	}

}
