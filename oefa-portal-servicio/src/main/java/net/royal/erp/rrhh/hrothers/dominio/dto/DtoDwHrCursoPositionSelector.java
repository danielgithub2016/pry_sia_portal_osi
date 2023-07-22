package net.royal.erp.rrhh.hrothers.dominio.dto;

import net.royal.erp.asistencia.symast.dominio.dto.DtoDwMaMiscelaneosdetalleSelect;

/**
 * @author desarrollo
 *
 */
public class DtoDwHrCursoPositionSelector implements java.io.Serializable {

	private String tipobusqueda;
	private String sle_buscar;
	private String Area;
	private Boolean AreaBool;

	public String getTipobusqueda() {
		return tipobusqueda;
	}

	public String getSle_buscar() {
		return sle_buscar;
	}

	public void setTipobusqueda(String tipobusqueda) {
		this.tipobusqueda = tipobusqueda;
	}

	public void setSle_buscar(String sle_buscar) {
		this.sle_buscar = sle_buscar;
	}

	public Boolean getAreaBool() {
		return AreaBool;
	}

	public void setAreaBool(Boolean areaBool) {
		if (areaBool.equals(true)) {
			Area = null;
		}
		AreaBool = areaBool;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

}
