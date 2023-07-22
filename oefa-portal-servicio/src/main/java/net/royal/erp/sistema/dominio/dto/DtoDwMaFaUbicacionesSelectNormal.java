package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_ma_fa_ubicaciones_select_normal
 */
public class DtoDwMaFaUbicacionesSelectNormal implements java.io.Serializable {
	private String descripcionlocal;
	private String ubicacion;
	private BigDecimal numerodigitos;
	private String unidadnegocio;
	private String tipo;
	private String descripcionCompleta;

	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public BigDecimal getNumerodigitos() {
		return numerodigitos;
	}

	public void setNumerodigitos(BigDecimal numerodigitos) {
		this.numerodigitos = numerodigitos;
	}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcionCompleta() {
		return descripcionCompleta;
	}

	public void setDescripcionCompleta(
			String descripcionlocal, String ubicacion) {
		descripcionCompleta = descripcionlocal + " " + ubicacion;
	}

}
