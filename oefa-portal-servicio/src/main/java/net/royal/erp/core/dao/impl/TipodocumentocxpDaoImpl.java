package net.royal.erp.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.core.dao.TipodocumentocxpDao;
import net.royal.erp.core.dominio.Personamast;
import net.royal.erp.core.dominio.Tipodocumentocxp;
import net.royal.erp.core.dominio.TipodocumentocxpPk;

@Repository
public class TipodocumentocxpDaoImpl extends
		GenericoDaoImpl<Tipodocumentocxp, TipodocumentocxpPk> implements
		TipodocumentocxpDao {

	private static Log LOGGER = LogFactory.getLog(Tipodocumentocxp.class);

	public TipodocumentocxpDaoImpl() {
		super("tipodocumentocxp");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public List listarDocCxp(){
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));

		Disjunction or = Restrictions.disjunction();
		or.add(Restrictions.eq("clasificacion","FE"));
		or.add(Restrictions.eq("clasificacion","OB"));
		cri.add(or);
		cri.addOrder(Order.asc("pk.tipodocumento"));
		
		List datos = this.listarPorCriterios(cri);
		if(UValidador.esListaVacia(datos)){
			return null;
		}
		return datos;
	}

	@Override
	public String obtenertipomascara(String par_tipodocumento) {
		
		String mascara="";
		List<Tipodocumentocxp> lista = this.listarPorCriterios(this.getCriteria()
				.add(Restrictions.eq("pk.tipodocumento", par_tipodocumento)));

		if (!UValidador.esListaVacia(lista))
			mascara= lista.get(0).getFormatoedicion();
		
		
		return mascara;
	}

	@Override
	public Tipodocumentocxp obtenerTipoDocumento(String par_tipodocumento) {
		List<Tipodocumentocxp> lista = this.listarPorCriterios(this.getCriteria()
				.add(Restrictions.eq("pk.tipodocumento", par_tipodocumento)));

		if (!UValidador.esListaVacia(lista))
			return lista.get(0);
		
		return null;
	}
}
