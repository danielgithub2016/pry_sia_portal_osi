package net.royal.erp.asistencia.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.asistencia.dao.AsTipodiaasistenciaDao;
import net.royal.erp.asistencia.dominio.AsTipodiaasistencia;
import net.royal.erp.asistencia.dominio.AsTipodiaasistenciaPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

@Repository
public class AsTipodiaasistenciaDaoImpl extends
		GenericoDaoImpl<AsTipodiaasistencia, AsTipodiaasistenciaPk> implements
		AsTipodiaasistenciaDao {

	private static Log LOGGER = LogFactory.getLog(AsTipodiaasistencia.class);

	public AsTipodiaasistenciaDaoImpl() {
		super("astipodiaasistencia");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<AsTipodiaasistencia> listarTipoDiaAsistencia() {
		Criteria c = this.getCriteria();
		
		c.addOrder(Order.asc("descripcionlocal"));
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		List<AsTipodiaasistencia> lista = this.listarPorCriterios(c);
		
		if(UValidador.estaVacio(lista))
			return null;
		
		return lista;
	}
}
