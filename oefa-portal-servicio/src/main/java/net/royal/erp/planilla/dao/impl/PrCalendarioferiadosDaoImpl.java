package net.royal.erp.planilla.dao.impl;

import java.util.ArrayList;
import java.util.Date;
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

import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.planilla.dao.PrCalendarioferiadosDao;
import net.royal.erp.planilla.dominio.PrCalendarioferiados;
import net.royal.erp.planilla.dominio.PrCalendarioferiadosPk;

@Repository
public class PrCalendarioferiadosDaoImpl extends GenericoDaoImpl<PrCalendarioferiados, PrCalendarioferiadosPk> implements PrCalendarioferiadosDao {

	private static Log LOGGER = LogFactory.getLog(PrCalendarioferiados.class);

	public PrCalendarioferiadosDaoImpl() {
		super("prcalendarioferiados");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Boolean esFeriado(Date date) throws Exception {
		
		String diamesanio = UFechaHora.convertirFechaCadena(date, "ddMMyyyy");
		Criteria criteria = this.getCriteria();
		criteria.add(Restrictions.eq("pk.fechamesdia", diamesanio));
		criteria.add(Restrictions.eq("pk.allsucursal", "S"));
		criteria.add(Restrictions.eq("estado", "A"));
		
		List<PrCalendarioferiados> lst = this.listarPorCriterios(criteria);
		
		if (UValidador.esNulo(lst)) {
			return false;
		}
		
		if (lst.isEmpty()) {
			return false;
		}
		
		return true;
	}

	@Override
	public Date agregarFechasHabiles(Date date, Integer dias) throws Exception {
		int i = 0;
		while (i < dias) {
			date = UFechaHora.anadirDiasAFechas(date, 1);
			if (date.getDay() != 6 && date.getDay() != 0 && !esFeriado(date))
				i++;
		}
		
		return date;
	}

}
