package net.royal.erp.core.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.core.dominio.Accountmst;
import net.royal.erp.core.dominio.AccountmstPk;

import java.util.List;

public interface AccountmstDao extends GenericoDao<Accountmst, AccountmstPk> {

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder syfinan.f_budget_affected
	 */
	public Integer esAfecto(String account);
	
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sycommon.f_sql_validate_account_char8
	 */
	public Accountmst validarCuenta(String account,String planContable);
	
	/**
	 * @obteneraccountmst
	 * @param w_account
	 * @param str_plancontable
	 * @return
	 */
	public List listarAccount(String w_account, String str_plancontable);
	
	public String leerCuentaContable(String par_account);
	
}
