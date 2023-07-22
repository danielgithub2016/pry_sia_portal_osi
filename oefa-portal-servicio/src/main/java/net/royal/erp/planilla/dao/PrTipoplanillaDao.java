package net.royal.erp.planilla.dao;

import java.util.List;

import net.royal.erp.planilla.dominio.PrTipoplanilla;
import net.royal.erp.planilla.dominio.PrTipoplanillaPk;
import net.royal.framework.web.dao.GenericoDao;

public interface PrTipoplanillaDao extends GenericoDao<PrTipoplanilla, PrTipoplanillaPk> {

	/**
	 * @powerbuilder  - dddw_ma_hr_tipoplanilla_select
	 * @return
	 */
	public List<PrTipoplanilla> ListarTipoPlanilla();
	
	/**
	 * Lista tipo planilla seguridad.
	 *
	 * @powerbuilder dw_ma_pr_tipoplanilla_select_seguridad
	 * @param todos the todos
	 * @param tiposplanilla the tiposplanilla
	 * @return the list
	 */
	public List<PrTipoplanilla> listaTipoPlanillaSeguridad(String todos,String ...tiposplanilla);
	
}
