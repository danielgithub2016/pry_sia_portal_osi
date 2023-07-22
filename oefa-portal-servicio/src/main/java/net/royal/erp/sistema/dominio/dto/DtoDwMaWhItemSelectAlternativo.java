package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_ma_wh_item_select_alternativo
 */
public class DtoDwMaWhItemSelectAlternativo implements java.io.Serializable {
	private String secuencia;
	private String itemalternativo;
	private String descripcionlocal;
	
	
	public String getSecuencia() {
		return secuencia;
	}
	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}
	public String getItemalternativo() {
		return itemalternativo;
	}
	public void setItemalternativo(String itemalternativo) {
		this.itemalternativo = itemalternativo;
	}
	public String getDescripcionlocal() {
		return descripcionlocal;
	}
	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}


}
