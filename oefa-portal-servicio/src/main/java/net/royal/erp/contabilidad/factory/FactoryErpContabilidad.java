package net.royal.erp.contabilidad.factory;

import net.royal.erp.contabilidad.servicio.AcCostcenterCompaniaServicio;
import net.royal.erp.contabilidad.servicio.AcCostcentermstServicio;
import net.royal.erp.contabilidad.servicio.AcSucursalServicio;

public interface FactoryErpContabilidad {

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder contabilidad.AcCostcentermst
	 */
	public AcCostcentermstServicio getAcCostcentermstServicio();

	public void setAcCostcentermstServicio(
			AcCostcentermstServicio acCostcentermstServicio);


	/**
	 *
	 * @author desarrollo
	 * @powerbuilder contabilidad.AcSucursal
	 */
	public AcSucursalServicio getAcSucursalServicio();

	public void setAcSucursalServicio(AcSucursalServicio acSucursalServicio);


	
	public AcCostcenterCompaniaServicio getAcCostcenterCompaniaServicio();

	public void setAcCostcenterCompaniaServicio(
			AcCostcenterCompaniaServicio acCostcenterCompaniaServicio);
}
