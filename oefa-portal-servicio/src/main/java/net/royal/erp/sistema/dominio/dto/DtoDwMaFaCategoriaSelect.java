package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_ma_fa_categoria_select
 */
public class DtoDwMaFaCategoriaSelect implements java.io.Serializable {
	private String descripcionlocal;
	private String cuentadepreciacion;
	private String categoria;
	private String manejo;
	private String cuentahistorica;
	private String intangibleflag;

	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}

	public String getCuentadepreciacion() {
		return cuentadepreciacion;
	}

	public void setCuentadepreciacion(String cuentadepreciacion) {
		this.cuentadepreciacion = cuentadepreciacion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getManejo() {
		return manejo;
	}

	public void setManejo(String manejo) {
		this.manejo = manejo;
	}

	public String getCuentahistorica() {
		return cuentahistorica;
	}

	public void setCuentahistorica(String cuentahistorica) {
		this.cuentahistorica = cuentahistorica;
	}

	public String getIntangibleflag() {
		return intangibleflag;
	}

	public void setIntangibleflag(String intangibleflag) {
		this.intangibleflag = intangibleflag;
	}



}
