package net.royal.erp.asistencia.asmast.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

/**
 *
 * @author desarrollo
 * @powerbuilder asmast.dddw_as_tipodiaasistencia_select
 */
public class DtoDddwAsTipodiaasistenciaSelect implements java.io.Serializable {

	private BigDecimal tipodia;
	private String descripcionlocal;
	private BigDecimal suma;
	private BigDecimal sumarefrigerio;
	private Date horainicio;
	private Date horafin;

	/**
	 * @return the tipodia
	 */
	public BigDecimal getTipodia() {
		return tipodia;
	}

	/**
	 * @param tipodia
	 *            the tipodia to set
	 */
	public void setTipodia(BigDecimal tipodia) {
		this.tipodia = tipodia;
	}

	/**
	 * @return the descripcionlocal
	 */
	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	/**
	 * @param descripcionlocal
	 *            the descripcionlocal to set
	 */
	public void setDescripcionlocal(String descripcionlocal) {
		if (UValidador.estaVacio(descripcionlocal)) {
			descripcionlocal = "";
		}
		this.descripcionlocal = descripcionlocal;
	}

	/**
	 * @return the suma
	 */
	public BigDecimal getSuma() {
		return suma;
	}

	/**
	 * @param suma
	 *            the suma to set
	 */
	public void setSuma(BigDecimal suma) {
		this.suma = suma;
	}

	/**
	 * @return the sumarefrigerio
	 */
	public BigDecimal getSumarefrigerio() {
		return sumarefrigerio;
	}

	/**
	 * @param sumarefrigerio the sumarefrigerio to set
	 */
	public void setSumarefrigerio(BigDecimal sumarefrigerio) {
		this.sumarefrigerio = sumarefrigerio;
	}

	/**
	 * @return the horainicio
	 */
	public Date getHorainicio() {
		return horainicio;
	}

	/**
	 * @param horainicio the horainicio to set
	 */
	public void setHorainicio(Date horainicio) {
		this.horainicio = horainicio;
	}

	/**
	 * @return the horafin
	 */
	public Date getHorafin() {
		return horafin;
	}

	/**
	 * @param horafin the horafin to set
	 */
	public void setHorafin(Date horafin) {
		this.horafin = horafin;
	}

}
