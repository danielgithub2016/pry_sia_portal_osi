package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.core.dominio.Afemst;
import net.royal.erp.core.dominio.AfemstPk;

public interface AfemstServicio extends GenericoServicio {
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sycommon.f_sql_validate_afe
	 */
	public Afemst validarAfe(String afe);
	
	public ParametroPaginacion DwAcAfeSelectList(
			ParametroPaginacion paginacion, String w_afe,
			String iv_companyowner, String w_afetype,
			String str_global_gv_userid, String w_numeroInterno,
			String iv_afesecurity, String w_orden, String w_descripcion);
	
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder symast01.dw_ac_afe_select_security_list
	 */
	// XTO
	public ParametroPaginacion DwAcAfeSelectSecurityList(
			ParametroPaginacion paginacion, String w_afe,
			String iv_companyowner, String w_afetype,
			String str_global_gv_userid, String w_numeroInterno,
			String iv_afesecurity, String w_orden, String w_descripcion);
}
