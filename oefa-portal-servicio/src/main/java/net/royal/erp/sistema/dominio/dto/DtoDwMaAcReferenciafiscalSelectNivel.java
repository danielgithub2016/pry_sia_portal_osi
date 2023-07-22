package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ma_ac_referenciafiscal_select_nivel
 */
public class DtoDwMaAcReferenciafiscalSelectNivel implements
		java.io.Serializable {
	private String nivel;
	private String referenciafiscal;
	private String descripcionlocal;
	private String tipo;

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getReferenciafiscal() {
		return referenciafiscal;
	}

	public void setReferenciafiscal(String referenciafiscal) {
		this.referenciafiscal = referenciafiscal;
	}

	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
