package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_ma_cp_regimenfiscal_select
 */
public class DtoDwMaCpRegimenfiscalSelect implements java.io.Serializable {
	private String regimenfiscal;
	private String descripcionlocal;

	public String getRegimenfiscal() {
		return regimenfiscal;
	}

	public void setRegimenfiscal(String regimenfiscal) {
		this.regimenfiscal = regimenfiscal;
	}

	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}


}
