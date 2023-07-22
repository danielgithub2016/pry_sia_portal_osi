package net.royal.erp.presupuesto.factory;

import net.royal.erp.presupuesto.servicio.BuNivelserviciomstServicio;

public class FactoryErpPresupuestoImpl implements FactoryErpPresupuesto {

	private BuNivelserviciomstServicio buNivelserviciomstServicio;

	@Override
	public BuNivelserviciomstServicio getBuNivelserviciomstServicio() {
		return buNivelserviciomstServicio;
	}

	@Override
	public void setBuNivelserviciomstServicio(
			BuNivelserviciomstServicio buNivelserviciomstServicio) {
		this.buNivelserviciomstServicio = buNivelserviciomstServicio;
	}

}
