package net.royal.erp.sistema.dominio.dto;

import java.math.BigDecimal;

/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ma_hr_puestoempresa_select
 */
@SuppressWarnings("serial")
public class DtoDwMaHrPuestoempresaSelect implements java.io.Serializable {
	private  String categoriafuncional;
	private String lineacarrera;

	public String getCategoriafuncional() {
		return categoriafuncional;
	}

	public void setCategoriafuncional(String categoriafuncional) {
		this.categoriafuncional = categoriafuncional;
	}

	public String getLineacarrera() {
		return lineacarrera;
	}

	public void setLineacarrera(String lineacarrera) {
		this.lineacarrera = lineacarrera;
	}

}
