package net.royal.erp.rrhh.hrothers.dominio.dto;

import java.io.Serializable;

import net.royal.erp.asistencia.dominio.AsArea;
import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.rrhh.dominio.HrCargosmast;

public class DtoDwHrEmpleadoSelectCcosto implements Serializable {

	private boolean allcosto;
	private boolean allcargo;
	private boolean all_areaoperativa;

	private AcCostcentermst ccosto;
	private HrCargosmast cargo;
	private AsArea areaoperativa;

	public DtoDwHrEmpleadoSelectCcosto() {
		ccosto = new AcCostcentermst();
		cargo = new HrCargosmast();
		areaoperativa = new AsArea();
	}

	private String iobusqueda;

	public AcCostcentermst getCcosto() {
		return ccosto;
	}

	public void setCcosto(AcCostcentermst ccosto) {
		this.ccosto = ccosto;
	}

	public HrCargosmast getCargo() {
		return cargo;
	}

	public void setCargo(HrCargosmast cargo) {
		this.cargo = cargo;
	}

	public AsArea getAreaoperativa() {
		return areaoperativa;
	}

	public void setAreaoperativa(AsArea areaoperativa) {
		this.areaoperativa = areaoperativa;
	}

	public boolean isAllcosto() {
		return allcosto;
	}

	public void setAllcosto(boolean allcosto) {
		if(allcosto==true){
			ccosto = null;
		}
		this.allcosto = allcosto;
	}

	public boolean isAllcargo() {
		return allcargo;
	}

	public void setAllcargo(boolean allcargo) {
		if(allcargo==true){
			cargo = null;
		}
		
		this.allcargo = allcargo;
	}

	public boolean isAll_areaoperativa() {
		return all_areaoperativa;
	}

	public void setAll_areaoperativa(boolean all_areaoperativa) {
		if(all_areaoperativa==true){
			areaoperativa = null;
		}
		this.all_areaoperativa = all_areaoperativa;
	}

	public String getIobusqueda() {
		return iobusqueda;
	}

	public void setIobusqueda(String iobusqueda) {
		this.iobusqueda = iobusqueda;
	}

}
