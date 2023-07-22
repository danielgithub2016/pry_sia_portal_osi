package net.royal.erp.core.dao;

import java.util.List;

import net.royal.erp.core.dominio.MaMiscelaneosdetalle;
import net.royal.erp.core.dominio.MaMiscelaneosdetallePk;
import net.royal.framework.web.dao.GenericoDao;

public interface MaMiscelaneosdetalleDao extends
		GenericoDao<MaMiscelaneosdetalle, MaMiscelaneosdetallePk> {
	
	public String obtenerValorCodigo2(String aplicacionCodigo, String compania,
			String codigoTabla, String descripcionlocal);

	/**
	 * @powerbuilder w_hr_evaluacionempleado_edit
	 *               dw_hr_miscelaneosdetail_potencial_select
	 * @return
	 */
	public List<MaMiscelaneosdetalle> ListarMiscelaneosdetalle();

	/**
	 * @powerbuilder f_nombre_miscelaneo_detalle_varios
	 * @param par_aplicacion
	 * @param par_compania
	 * @param par_miscelaneo
	 * @param par_valores
	 *            []
	 * @return
	 */
	public String obtenerNombreMiscelaneo(String par_aplicacion,
			String par_compania, String par_miscelaneo, String[] par_valores);

	/**
	 * @powerbuilder dw_hr_miscelaneos_selector_varios
	 * @param par_aplicacion
	 * @param par_compania
	 * @param par_miscelaneo
	 * 
	 * @return
	 */
	public List<MaMiscelaneosdetalle> listarSelectorVariosMiscelaneos(
			String par_aplicacion, String par_compania, String par_tabla);

	public List<MaMiscelaneosdetalle> listarBusquedaMiscelaneos(
			String par_aplicacion, String par_compania, String par_tabla,
			String codigoelemento, String descripcionlocal);

	public List<MaMiscelaneosdetalle> listarVerMiscelaneos(
			String par_aplicacion, String par_compania, String par_tabla,
			String codigoelemento, String descripcionlocal, String[] areas,
			Integer iv_objetos, String actionButton);

	public String obtenerValorCodigo(String aplicacionCodigo,
			String compania, String codigoTabla, String descripcionlocal);

}
