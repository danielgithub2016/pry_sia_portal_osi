package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.erp.core.dominio.Accountmst;
import net.royal.framework.web.servicio.GenericoServicio;

public interface AccountmstServicio extends GenericoServicio {

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
	public Accountmst validarCuenta(String account, String planContable);

	public List listarAccount(String w_account, String str_plancontable);
	
	public String leerCuentaContable(String par_account);
	
	public List DwMaAccountSelectList(String w_prime, String w_element,
			String w_plancontable, String w_buscar,
			String codigoDescripcionFlag, String status);
	
	public List listaCabecera(String w_prime, String w_element,
			String w_plancontable, String w_buscar,
			String codigoDescripcionFlag, String status);
	
}
