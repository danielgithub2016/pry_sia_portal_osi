package net.royal.erp.rrhh.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import net.royal.framework.web.core.UValidador;

/**
 * @author nunezh
 * @powerbuilder hrmast.dddw_ma_hr_gradosalairalmast_select
 * */
@SuppressWarnings("serial")
public class DtoDddWMaHrGradoSalairalMastSelect implements Serializable {
	private String gradosalario;
	private String descripcionlocal;
	private String cargo;
	private BigDecimal salariomaximo;
	private BigDecimal salariominimo;

	private BigDecimal monto;
	private BigDecimal montolocal;

	public String getGradosalario() {
		return gradosalario;
	}

	public void setGradosalario(String gradosalario) {
		this.gradosalario = gradosalario;
	}

	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalariomaximo() {
		return salariomaximo;
	}

	public void setSalariomaximo(BigDecimal salariomaximo) {
		this.salariomaximo = salariomaximo;
	}

	public BigDecimal getSalariominimo() {
		return salariominimo;
	}

	public void setSalariominimo(BigDecimal salariominimo) {
		this.salariominimo = salariominimo;
	}

	/**
	 * @return the monto
	 */
	public BigDecimal getMonto() {
		if (UValidador.esNulo(monto)) {
			monto = BigDecimal.ZERO;
		}
		return monto.setScale(2, RoundingMode.HALF_DOWN);
	}

	/**
	 * @param monto
	 *            the monto to set
	 */
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	/**
	 * @return the montolocal
	 */
	public BigDecimal getMontolocal() {
		if (UValidador.esNulo(montolocal)) {
			montolocal = BigDecimal.ZERO;
		}
		return montolocal.setScale(2, RoundingMode.HALF_DOWN);
	}

	/**
	 * @param montolocal
	 *            the montolocal to set
	 */
	public void setMontolocal(BigDecimal montolocal) {
		this.montolocal = montolocal;
	}

}
