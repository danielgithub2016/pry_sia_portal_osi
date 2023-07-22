package net.royal.erp.contabilidad.servicio;

import java.util.List;

import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.contabilidad.dominio.dto.DtoAcCostcentermst;
import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.servicio.GenericoServicio;

// TODO: Auto-generated Javadoc
/**
 * The Interface AcCostcentermstServicio.
 */
public interface AcCostcentermstServicio extends GenericoServicio {

	/**
	 * Lista combo centro costo.
	 *
	 * @return the list
	 */
	public List<AcCostcentermst> listaComboCentroCosto();
	
	/**
	 * f_sql_read_costcenter_name.
	 *
	 * @param par_costcenter the par_costcenter
	 * @return the string
	 */
	public String obtenerCentroCosto(String par_costcenter);
	
	/**
	 * Obtener list centro costo.
	 *
	 * @param par_costcenter the par_costcenter
	 * @return the ac costcentermst
	 */
	public AcCostcentermst obtenerListCentroCosto(String par_costcenter);
	
	/**
	 * Dw ma ac costcenter select valida.
	 *
	 * @param tabActivo the tab activo
	 * @return the list
	 */
	public List DwMaAcCostcenterSelectValida(Integer tabActivo);
	
	/**
	 * Dw ma ac costcenter select master.
	 *
	 * @param paginacion the paginacion
	 * @param tabActivo the tab activo
	 * @param w_supervisorflag the w_supervisorflag
	 * @param w_buscarflag the w_buscarflag
	 * @param str_global_gv_value_selected the str_global_gv_value_selected
	 * @return the parametro paginacion
	 */
	public ParametroPaginacion DwMaAcCostcenterSelectMaster(
			ParametroPaginacion paginacion, Integer tabActivo,
			String w_supervisorflag, String w_buscarflag,
			String str_global_gv_value_selected);
	
	/**
	 * Dw ma ac costcenter select xpersona.
	 *
	 * @param paginacion the paginacion
	 * @return the parametro paginacion
	 */
	public ParametroPaginacion DwMaAcCostcenterSelectXpersona(
			ParametroPaginacion paginacion);
	
	/**
	 * Dw ma ac costcenter select supervisor.
	 *
	 * @param paginacion the paginacion
	 * @return the parametro paginacion
	 */
	public ParametroPaginacion DwMaAcCostcenterSelectSupervisor(
			ParametroPaginacion paginacion);
	
	/**
	 * Lista por planilla tipo.
	 * @powerbuilder dw_pr_centrocosto_select
	 * @param tipo the tipo
	 * @return the list
	 */
	public List<DtoAcCostcentermst> listaPorPlanillaTipo(String tipo);
	
}
