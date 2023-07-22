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
import net.royal.erp.core.dao.CompaniamastDao;
import net.royal.erp.core.dominio.Companiamast;
import net.royal.erp.core.dominio.CompaniamastPk;
import net.royal.erp.core.dominio.dto.DtoCompaniamast;

@Repository
public class CompaniamastDaoImpl extends
		GenericoDaoImpl<Companiamast, CompaniamastPk> implements
		CompaniamastDao {

	private static Log LOGGER = LogFactory.getLog(Companiamast.class);

	public CompaniamastDaoImpl() {
		super("companiamast");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Boolean afectoIgv(String companiacodigo) {
		Companiamast com = null;
		String w_afectoigvflag, w_creditofiscalfactorflag;
		
		com = this.obtenerPorId(new CompaniamastPk(companiacodigo), false);
		
		w_afectoigvflag = com.getAfectoigvflag();
		w_creditofiscalfactorflag = com.getCreditofiscalfactorflag();
		
		if (UValidador.validarEsNuloVacio(w_afectoigvflag))
			w_afectoigvflag="";
		if (UValidador.validarEsNuloVacio(w_creditofiscalfactorflag))
			w_creditofiscalfactorflag="";
		
		if (w_afectoigvflag.equals("N")|| w_creditofiscalfactorflag.equals("S"))
			return true;
		
		return false;
	}

	@Override
	public String obtenerNombreCompania(String par_company) {
			LOGGER.debug("test de sycommon.f_sql_read_company_name");

			String company = par_company;
			
			Criteria cri=this.getCriteria();
			cri.add(Restrictions.eq("estado", "A"));
			cri.add(Restrictions.eq("pk.companiacodigo", par_company));
			
			List<Companiamast>compania=this.listarPorCriterios(cri);
			
			if(!UValidador.esNulo(compania)){
				company=compania.get(0).getDescripcioncorta();
			}

			return company;

	}

}
