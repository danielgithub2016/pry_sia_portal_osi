package net.royal.erp.core.dao.impl;

import java.math.BigDecimal;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.core.dao.ObligacionesDao;
import net.royal.erp.core.dao.ObligacionesxcuentaDao;
import net.royal.erp.core.dao.ServicioximpuestoDao;
import net.royal.erp.core.dominio.Obligaciones;
import net.royal.erp.core.dominio.ObligacionesPk;
import net.royal.erp.core.dominio.Obligacionesxcuenta;
import net.royal.erp.core.dominio.ObligacionesxcuentaPk;

@Repository
public class ObligacionesxcuentaDaoImpl extends GenericoDaoImpl<Obligacionesxcuenta, ObligacionesxcuentaPk> implements ObligacionesxcuentaDao {

	private static Log LOGGER = LogFactory.getLog(Obligacionesxcuenta.class);
	private ObligacionesDao daoObligaciones;
	
	public ObligacionesxcuentaDaoImpl() {
		super("obligacionesxcuenta");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<Obligacionesxcuenta> listarPorObligaciones(BigDecimal proveedor,
			String tipodocumento, String numerodocumento) {
		
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.proveedor", proveedor));
		cri.add(Restrictions.eq("pk.tipodocumento", tipodocumento));
		cri.add(Restrictions.eq("pk.numerodocumento", numerodocumento));
		cri.addOrder(Order.asc("pk.linea"));			
		List listaObligaciones = this.listarPorCriterios(cri);
		
		List<Obligacionesxcuenta> result = listaObligaciones;
		
		Obligaciones obl = daoObligaciones.obtenerPorId(new ObligacionesPk(proveedor, tipodocumento, numerodocumento));
		
		for (int i = 0; i < result.size(); i++) {
			result.get(i).setObligaciones(obl);
		}
		
		return result;
	}

	@Autowired
	public void setObligacionesDao(ObligacionesDao daoObligaciones) {
		this.daoObligaciones =daoObligaciones;
	}
	
}
