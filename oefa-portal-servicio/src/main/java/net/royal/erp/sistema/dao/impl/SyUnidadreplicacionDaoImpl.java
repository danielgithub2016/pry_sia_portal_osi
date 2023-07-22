package net.royal.erp.sistema.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.sistema.dao.SyUnidadreplicacionDao;
import net.royal.erp.sistema.dominio.SyUnidadreplicacion;
import net.royal.erp.sistema.dominio.SyUnidadreplicacionPk;

@Repository
public class SyUnidadreplicacionDaoImpl extends
		GenericoDaoImpl<SyUnidadreplicacion, SyUnidadreplicacionPk> implements
		SyUnidadreplicacionDao {

	private static Log LOGGER = LogFactory.getLog(SyUnidadreplicacion.class);

	public SyUnidadreplicacionDaoImpl() {
		super("syunidadreplicacion");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public List listaUnidadReplicacion(){
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));
		cri.addOrder(Order.asc("pk.unidadreplicacion"));
		List datos = this.listarPorCriterios(cri);
		
		if(UValidador.esListaVacia(datos)){
			return null;
		}
		return datos;
	}
}
