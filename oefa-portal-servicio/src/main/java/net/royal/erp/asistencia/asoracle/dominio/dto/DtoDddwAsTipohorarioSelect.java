package net.royal.erp.asistencia.asoracle.dominio.dto;

import java.math.BigDecimal;

/**
 *
 * @author desarrollo
 * @powerbuilder asoracle.dddw_as_tipohorario_select
 */
public class DtoDddwAsTipohorarioSelect implements java.io.Serializable {

	private BigDecimal tipohorario;
	private String descripcionlocal;
	private BigDecimal tipoturno;
	/**
	 * @return the tipohorario
	 */
	public BigDecimal getTipohorario() {
		return tipohorario;
	}
	/**
	 * @param tipohorario the tipohorario to set
	 */
	public void setTipohorario(BigDecimal tipohorario) {
		this.tipohorario = tipohorario;
	}
	/**
	 * @return the descripcionlocal
	 */
	public String getDescripcionlocal() {
		return descripcionlocal;
	}
	/**
	 * @param descripcionlocal the descripcionlocal to set
	 */
	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}
	/**
	 * @return the tipoturno
	 */
	public BigDecimal getTipoturno() {
		return tipoturno;
	}
	/**
	 * @param tipoturno the tipoturno to set
	 */
	public void setTipoturno(BigDecimal tipoturno) {
		this.tipoturno = tipoturno;
	}
	
}
