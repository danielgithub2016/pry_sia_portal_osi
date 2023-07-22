package net.royal.erp.contabilidad.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.royal.erp.contabilidad.dao.AcCostcentermstDao;
import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.contabilidad.dominio.AcCostcentermstPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@Repository
public class AcCostcentermstDaoImpl extends GenericoDaoImpl<AcCostcentermst, AcCostcentermstPk> implements AcCostcentermstDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComunDao dao;
	
	public AcCostcentermstDaoImpl() {
		super("accostcentermst");
	}

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}
	
	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<AcCostcentermst> listaComboCentroCosto() {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("status", "A"));
		cri.addOrder(Order.asc("pk.costcenter"));
		
		List<AcCostcentermst> datos = this.listarPorCriterios(cri);
		if(UValidador.esListaVacia(datos))
			return null;
		
		return datos;
	}

	@Override
	public String obtenerCentroCosto(String par_costcenter) {
		
		String centroCostos = par_costcenter;
		if (!UValidador.estaVacio(centroCostos)) {
			Integer codigoEntero = Integer.parseInt(par_costcenter);
			par_costcenter = String.format("%03d", codigoEntero);
			
			Criteria cri = this.getCriteria();
			cri.add(Restrictions.eq("status", "A"));
			cri.add(Restrictions.eq("pk.costcenter", par_costcenter));
			
			List<AcCostcentermst> datos = this.listarPorCriterios(cri);
			if(!UValidador.esListaVacia(datos)){
				centroCostos=datos.get(0).getLocalname();
			}
		}
		return centroCostos;
	}

	@Override
	public AcCostcentermst obtenerListCentroCosto(String par_costcenter) {
		return this.obtenerPorId(new AcCostcentermstPk(par_costcenter));
	}


	

}
