package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ma_ac_referenciafiscal_select_meta_x_ref01
 */
public class DtoDwMaAcReferenciafiscalSelectMetaXRef01 implements
		java.io.Serializable {
	
	private String metaaux;
	private String descripcion;
	private BigDecimal finalidad;

	public String getMetaaux() {
		return metaaux;
	}

	public void setMetaaux(String metaaux) {
		this.metaaux = metaaux;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getFinalidad() {
		return finalidad;
	}

	public void setFinalidad(BigDecimal finalidad) {
		this.finalidad = finalidad;
	}



}
