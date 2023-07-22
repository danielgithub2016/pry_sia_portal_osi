package net.royal.erp.contabilidad.servicio;

import java.util.List;

import net.royal.erp.contabilidad.dominio.AcSucursal;
import net.royal.framework.web.servicio.GenericoServicio;

public interface AcSucursalServicio extends GenericoServicio {

	/**
	 * Obtener lista.
	 *
	 * @param tipo the tipo
	 * @param valor the valor
	 * @return the list
	 */
	public List<AcSucursal> obtenerLista(String tipo, String valor);
	
	/**
	 * f_sql_read_sucursal_name.
	 *
	 * @param par_sucursal the par_sucursal
	 * @return the string
	 */
	public String obtenerNombreSucursal(String par_sucursal);
	
	/**
	 * Dw ma ac sucursal select.
	 *
	 * @param par_sucursal the par_sucursal
	 * @return the list
	 */
	public List DwMaAcSucursalSelect(String par_sucursal);
	
	/**
	 * Listar sucursales activas.
	 *
	 * @return the list
	 */
	public List<AcSucursal> listarSucursalesActivas();
	
	/**
	 * Listar sucursal seguridad.
	 *
	 * @param todo the todo
	 * @param sucursales the sucursales
	 * @return the list
	 */
	public List<AcSucursal> listarSucursalSeguridad(String todo, String... sucursales);
	
}
