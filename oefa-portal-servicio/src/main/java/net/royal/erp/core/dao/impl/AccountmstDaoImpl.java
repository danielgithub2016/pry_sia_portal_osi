package net.royal.erp.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.core.dao.AccountmstDao;
import net.royal.erp.core.dao.PrimemstDao;
import net.royal.erp.core.dominio.Accountmst;
import net.royal.erp.core.dominio.AccountmstPk;
import net.royal.erp.core.dominio.Primemst;
import net.royal.erp.core.dominio.dto.DtoAccountmst;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class AccountmstDaoImpl extends
		GenericoDaoImpl<Accountmst, AccountmstPk> implements AccountmstDao {

	private static Log LOGGER = LogFactory.getLog(Accountmst.class);
	private PrimemstDao daoPrimemst;

	public AccountmstDaoImpl() {
		super("accountmst");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Integer esAfecto(String account) {
		String w_excluir_flag = null;
		Accountmst acc = null;
		Primemst pri = null;

		// esto esta porque es asi como esta en el codigo
		if (w_excluir_flag == null)
			return 0;

		acc = this.obtenerPorId(new AccountmstPk(account));

		w_excluir_flag = acc.getBudgetexcluirflag();

		if (UValidador.validarEsNuloVacio(w_excluir_flag))
			w_excluir_flag = "";

		if (w_excluir_flag.equals("S"))
			return -1;

		pri = daoPrimemst.obtenerPorId(acc.getPrime());
		if (pri != null) {
			String w_budgetflag = pri.getCostcenterflag();
			if (UValidador.validarEsNuloVacio(w_budgetflag))
				w_budgetflag = "";
			if (w_budgetflag.equals("Y"))
				return 0;
		}

		return -1;
	}

	@Override
	public Accountmst validarCuenta(String account, String planContable) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.account", account));
		cri.add(Restrictions.eq("plancontable", planContable));
		cri.add(Restrictions.eq("status", "A"));
		List result = this.listarPorCriterios(cri);
		if (result.size() != 1)
			return null;
		return (Accountmst) result.get(0);
	}

	public List listarAccount(String w_account, String str_plancontable) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.account", w_account));
		cri.add(Restrictions.eq("plancontable", str_plancontable));

		List<Accountmst> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos)) {
			return null;
		}
		return datos;

	}

	@Override
	public String leerCuentaContable(String par_account) {
		
			LOGGER.debug("test de apmain.f_sql_read_account_commitment");
			String w_commitmentvalidation = "N";
			
			Criteria cri = this.getCriteria();
			cri.add(Restrictions.eq("pk.account", par_account));

			List<Accountmst> datos = this.listarPorCriterios(cri);
			if (!UValidador.esListaVacia(datos)) {
				w_commitmentvalidation=datos.get(0).getCommitmentvalidation();
			}
			
			return w_commitmentvalidation;
	}

}
