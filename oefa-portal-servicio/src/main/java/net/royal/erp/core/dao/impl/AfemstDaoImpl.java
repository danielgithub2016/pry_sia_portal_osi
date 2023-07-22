package net.royal.erp.core.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.core.dao.AfemstDao;
import net.royal.erp.core.dao.ParametrosmastDao;
import net.royal.erp.core.dominio.Afemst;
import net.royal.erp.core.dominio.AfemstPk;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AfemstDaoImpl extends GenericoDaoImpl<Afemst, AfemstPk> implements
		AfemstDao {

	private static Log LOGGER = LogFactory.getLog(Afemst.class);
	private ParametrosmastDao daoParametrosmast;

	public AfemstDaoImpl() {
		super("afemst");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Afemst validarAfe(String afe) {

		if (UValidador.validarEsNuloVacio(afe))
			return null;

		// Validate only truncated
		String validarTruncate = daoParametrosmast
				.obtenerValorCadena(new ParametrosmastPk("AC", "999999",
						"AFEELEMENT"));
		validarTruncate = UValidador.obtenerValorCadenaSinNulo(validarTruncate);

		if (validarTruncate.equals("S")) {
			Integer w_digit, w_afedigit;
			w_digit = daoParametrosmast
					.obtenerValorInteger(new ParametrosmastPk("AC", "999999",
							"ELEMDIGIT"));
			w_afedigit = daoParametrosmast
					.obtenerValorInteger(new ParametrosmastPk("AC", "999999",
							"AFEDIGITOS"));
			afe = afe.substring(0, w_afedigit - w_digit);
		}

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.afe", afe));
		cri.add(Restrictions.eq("status", "A"));			
		List result = this.listarPorCriterios(cri);
		if (result.size()!=1)
			return null;
		
		return (Afemst) result.get(0);
	}

	@Autowired
	public void setParametrosmastDao(ParametrosmastDao daoParametrosmast) {
		this.daoParametrosmast = daoParametrosmast;
	}

}
