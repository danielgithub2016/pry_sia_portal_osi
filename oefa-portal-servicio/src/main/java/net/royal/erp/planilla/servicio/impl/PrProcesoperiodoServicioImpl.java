package net.royal.erp.planilla.servicio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.planilla.dao.PrProcesoperiodoDao;
import net.royal.erp.planilla.servicio.PrProcesoperiodoServicio;

import net.royal.erp.planilla.dominio.PrProcesoperiodo;
import net.royal.erp.planilla.dominio.PrProcesoperiodoPk;
import net.royal.erp.planilla.dominio.dto.DtoFechaPago;
import net.royal.erp.planilla.dominio.dto.DtoProcesoXPlanillaPeriodo;
import net.royal.erp.planilla.dominio.dto.DtoTotalNeto;

@Service (value = "BeanServicioPrProcesoperiodo")
public class PrProcesoperiodoServicioImpl extends GenericoServicioImpl implements PrProcesoperiodoServicio {

	private PrProcesoperiodoDao dao;

	private static Log LOGGER = LogFactory.getLog(PrProcesoperiodoServicioImpl.class);

	@Autowired
	public void setDao(PrProcesoperiodoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<PrProcesoperiodo> listarPeriodosXPlanilla(String planilla) {
		
		Criteria criteria = dao.getCriteria();
		
		if (!UValidador.esNulo(planilla)) {
			criteria.add(Restrictions.eq("pk.tipoplanilla", planilla));
		}
		
		criteria.add(Restrictions.eq("pk.tipoproceso", "NO0"));
		criteria.addOrder(Order.desc("pk.periodo"));
		
		List<PrProcesoperiodo> lista = dao.listarPorCriterios(criteria);
		
		return lista;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List listarProcesoXPlanillaPeriodo(String planilla, String periodo) {
		
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		
		filtros.add(new ParametroPersistenciaGenerico("p_tipoplanilla",
				String.class, planilla));
		
		filtros.add(new ParametroPersistenciaGenerico("p_periodo",
				String.class, periodo));
		
		return dao.listarPorQuery(DtoProcesoXPlanillaPeriodo.class, "prprocesoperiodo.listarprocesoXPlanillaPeriodo", filtros);
		
	}

	@Override
	public Date obtenerFechaPagoBoleta(String periodo, String planilla, String proceso) {

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		
		filtros.add(new ParametroPersistenciaGenerico("p_tipoplanilla",
				String.class, planilla));
		
		filtros.add(new ParametroPersistenciaGenerico("p_periodo",
				String.class, periodo));
		
		filtros.add(new ParametroPersistenciaGenerico("p_tipoproceso",
				String.class, proceso));

		List lista =  dao.listarPorQuery(DtoFechaPago.class, "prprocesoperiodo.obtenerFechaPagoBoleta", filtros);
		
		List<DtoFechaPago> lst = lista;
		
		return lst.get(0).getFechaPago();
	}
	
	

}
