package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuCertificacion
*/
public class BuCertificacionPk implements java.io.Serializable{

	private String companiasocio;
	private String ano;
	private String numerodocumento;
	private String secuencia;
	private Integer movimiento;

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}
	public String getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}
	public Integer getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Integer movimiento) {
		this.movimiento = movimiento;
	}

}
