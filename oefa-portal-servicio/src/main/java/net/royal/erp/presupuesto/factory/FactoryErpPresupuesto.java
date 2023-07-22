package net.royal.erp.presupuesto.factory;

import net.royal.erp.presupuesto.servicio.BuNivelserviciomstServicio;

public interface FactoryErpPresupuesto {

	
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder presupuesto.BuNivelserviciomst
	 */
	public BuNivelserviciomstServicio getBuNivelserviciomstServicio();

	public void setBuNivelserviciomstServicio(
			BuNivelserviciomstServicio buNivelserviciomstServicio);

}
