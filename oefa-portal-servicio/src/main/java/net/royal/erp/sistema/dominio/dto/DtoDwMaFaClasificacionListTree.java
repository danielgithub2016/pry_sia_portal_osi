package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_ma_fa_clasificacion_list_tree
 */
public class DtoDwMaFaClasificacionListTree implements java.io.Serializable {
	private String clasificacion;
	private String descripcionlocal;
	private BigDecimal numerodigitos;
	private String descripcionCompleto;
	private String tipo;

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}

	public BigDecimal getNumerodigitos() {
		return numerodigitos;
	}

	public void setNumerodigitos(BigDecimal numerodigitos) {
		this.numerodigitos = numerodigitos;
	}

	public String getDescripcionCompleto() {
		return descripcionCompleto;
	}

	public void setDescripcionCompleto(String descripcionlocal,
			String clasificacion) {
		descripcionCompleto = descripcionlocal + " " + clasificacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
