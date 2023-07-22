package net.royal.erp.sistema.factory;

import net.royal.erp.sistema.servicio.SyCampocalculadoServicio;
import net.royal.erp.sistema.servicio.SySeguridadautorizacionesServicio;
import net.royal.erp.sistema.servicio.SySeguridadrangoServicio;
import net.royal.erp.sistema.servicio.SyUnidadreplicacionServicio;

public interface FactoryErpSistema {

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sistema.SY
	 */
	public FactoryErpSy getSY();

	public void setSY(FactoryErpSy FactoryErpSy);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sistema.SyCampocalculado
	 */
	public SyCampocalculadoServicio getSyCampocalculadoServicio();

	public void setSyCampocalculadoServicio(
			SyCampocalculadoServicio syCampocalculadoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sistema.SySeguridadautorizaciones
	 */
	public SySeguridadautorizacionesServicio getSySeguridadautorizacionesServicio();

	public void setSySeguridadautorizacionesServicio(
			SySeguridadautorizacionesServicio sySeguridadautorizacionesServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sistema.SyUnidadreplicacion
	 */
	public SyUnidadreplicacionServicio getSyUnidadreplicacionServicio();

	public void setSyUnidadreplicacionServicio(
			SyUnidadreplicacionServicio syUnidadreplicacionServicio);
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sistema.SySeguridadrango
	 */
	public SySeguridadrangoServicio getSySeguridadrangoServicio();

	public void setSySeguridadrangoServicio(
			SySeguridadrangoServicio sySeguridadrangoServicio);
}
