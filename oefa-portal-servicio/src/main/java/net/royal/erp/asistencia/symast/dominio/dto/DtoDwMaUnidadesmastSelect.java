package net.royal.erp.asistencia.symast.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder symast.dw_ma_unidadesmast_select
 */
public class DtoDwMaUnidadesmastSelect implements java.io.Serializable {
	private String unidadcodigo;
	private String descripcioncorta;
	private String unidadtipo;
	private String descripcionextranjera;

	public String getUnidadcodigo() {
		return unidadcodigo;
	}

	public void setUnidadcodigo(String unidadcodigo) {
		this.unidadcodigo = unidadcodigo;
	}

	public String getDescripcioncorta() {
		return descripcioncorta;
	}

	public void setDescripcioncorta(String descripcioncorta) {
		this.descripcioncorta = descripcioncorta;
	}

	public String getUnidadtipo() {
		return unidadtipo;
	}

	public void setUnidadtipo(String unidadtipo) {
		this.unidadtipo = unidadtipo;
	}

	public String getDescripcionextranjera() {
		return descripcionextranjera;
	}

	public void setDescripcionextranjera(String descripcionextranjera) {
		this.descripcionextranjera = descripcionextranjera;
	}


}
