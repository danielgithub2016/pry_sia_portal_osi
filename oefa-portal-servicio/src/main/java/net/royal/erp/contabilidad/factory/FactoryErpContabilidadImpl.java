package net.royal.erp.contabilidad.factory;

import net.royal.erp.contabilidad.servicio.AcCostcenterCompaniaServicio;
import net.royal.erp.contabilidad.servicio.AcCostcentermstServicio;
import net.royal.erp.contabilidad.servicio.AcSucursalServicio;

public class FactoryErpContabilidadImpl implements FactoryErpContabilidad {

	
	

	private AcCostcentermstServicio acCostcentermstServicio;

	@Override
	public AcCostcentermstServicio getAcCostcentermstServicio() {
		return acCostcentermstServicio;
	}

	@Override
	public void setAcCostcentermstServicio(
			AcCostcentermstServicio acCostcentermstServicio) {
		this.acCostcentermstServicio = acCostcentermstServicio;
	}

	

	private AcSucursalServicio acSucursalServicio;

	@Override
	public AcSucursalServicio getAcSucursalServicio() {
		return acSucursalServicio;
	}

	@Override
	public void setAcSucursalServicio(AcSucursalServicio acSucursalServicio) {
		this.acSucursalServicio = acSucursalServicio;
	}


	private AcCostcenterCompaniaServicio acCostcenterCompaniaServicio;

	@Override
	public AcCostcenterCompaniaServicio getAcCostcenterCompaniaServicio() {
		return acCostcenterCompaniaServicio;
	}

	@Override
	public void setAcCostcenterCompaniaServicio(
			AcCostcenterCompaniaServicio acCostcenterCompaniaServicio) {
		this.acCostcenterCompaniaServicio = acCostcenterCompaniaServicio;
	}
}
