package net.royal.erp.contabilidad.dao;

import java.util.List;

import net.royal.erp.contabilidad.dominio.AcSucursal;
import net.royal.erp.contabilidad.dominio.AcSucursalPk;
import net.royal.framework.web.dao.GenericoDao;

public interface AcSucursalDao extends GenericoDao<AcSucursal, AcSucursalPk>{

	public List<AcSucursal> obtenerLista(String tipo, String valor);
	
	/**
	 * f_sql_read_sucursal_name.
	 *
	 * @param par_sucursal the par_sucursal
	 * @return the string
	 */
	public String obtenerNombreSucursal(String par_sucursal);
	
	/**
	 * Listar sucursales activas.
	 *
	 * @powerbuilder dw_ma_ac_sucursal_select
	 * @return the list
	 */
	public List<AcSucursal> listarSucursalesActivas();
	
	
	/**
	 * Listar sucursal seguridad.
	 * @powerbuilder dw_ma_pr_sucursal_select_seguridad
	 * @param todo the todo
	 * @param sucursales the sucursales
	 * @return the list
	 */
	public List<AcSucursal> listarSucursalSeguridad(String todo,String...sucursales);
}
