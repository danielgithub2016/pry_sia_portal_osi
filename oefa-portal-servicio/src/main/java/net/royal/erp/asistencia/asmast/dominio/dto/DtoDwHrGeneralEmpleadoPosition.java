package net.royal.erp.asistencia.asmast.dominio.dto;

import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.planilla.dominio.PrTipoplanilla;

/**
 *
 * @author desarrollo
 * @powerbuilder asmast.dw_hr_general_empleado_position
 */
public class DtoDwHrGeneralEmpleadoPosition implements java.io.Serializable {

	private String sle_buscar;
	private String tipobusqueda;

	private Boolean boolCentrocosto;
	private Boolean boolTipoplanilla;

	private Boolean boolInactivos;
	private Boolean boolCesados;
	
	private AcCostcentermst centroCosto;
	private PrTipoplanilla tipoplanilla;

	public String getSle_buscar() {
		return sle_buscar;
	}

	public String getTipobusqueda() {
		return tipobusqueda;
	}

	public AcCostcentermst getCentroCosto() {
		return centroCosto;
	}

	public PrTipoplanilla getTipoplanilla() {
		return tipoplanilla;
	}

	public void setSle_buscar(String sle_buscar) {
		this.sle_buscar = sle_buscar;
	}

	public void setTipobusqueda(String tipobusqueda) {
		this.tipobusqueda = tipobusqueda;
	}

	public void setCentroCosto(AcCostcentermst centroCosto) {
		this.centroCosto = centroCosto;
	}

	public void setTipoplanilla(PrTipoplanilla tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

	public Boolean getBoolCentrocosto() {
		return boolCentrocosto;
	}

	public Boolean getBoolTipoplanilla() {
		return boolTipoplanilla;
	}

	public void setBoolCentrocosto(Boolean boolCentrocosto) {
		if (boolCentrocosto.equals(true)) {
			centroCosto = null;
		}
		this.boolCentrocosto = boolCentrocosto;
	}

	public void setBoolTipoplanilla(Boolean boolTipoplanilla) {
		if (boolTipoplanilla.equals(true)) {
			tipoplanilla = null;
		}
		this.boolTipoplanilla = boolTipoplanilla;
	}

	public Boolean getBoolInactivos() {
		return boolInactivos;
	}

	public Boolean getBoolCesados() {
		return boolCesados;
	}

	public void setBoolInactivos(Boolean boolInactivos) {
		this.boolInactivos = boolInactivos;
	}

	public void setBoolCesados(Boolean boolCesados) {
		this.boolCesados = boolCesados;
	}

}
