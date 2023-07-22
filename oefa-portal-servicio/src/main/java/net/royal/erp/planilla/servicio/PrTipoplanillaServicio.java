package net.royal.erp.planilla.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

import net.royal.erp.planilla.dominio.PrTipoplanilla;
import net.royal.erp.planilla.dominio.PrTipoplanillaPk;

public interface PrTipoplanillaServicio extends GenericoServicio {

	/**
	 * Listar tipo planilla.
	 *
	 * @return the list
	 */
	public List<PrTipoplanilla> ListarTipoPlanilla();
	
	/**
	 * Lista tipo planilla seguridad.
	 *
	 * @param todos the todos
	 * @param tiposplanilla the tiposplanilla
	 * @return the list
	 */
	public List<PrTipoplanilla> listaTipoPlanillaSeguridad(String todos,String ...tiposplanilla);
}
