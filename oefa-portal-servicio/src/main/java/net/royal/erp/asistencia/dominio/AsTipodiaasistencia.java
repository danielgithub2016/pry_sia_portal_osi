package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsTipodiaasistencia
 */
public class AsTipodiaasistencia extends DominioGenerico implements
		java.io.Serializable {

	private AsTipodiaasistenciaPk pk;
	private String descripcionlocal;
	private java.math.BigDecimal cantidadhoras;
	private String descripcionextranjera;
	private String estado;
	private String tipodiaanterior;
	private java.util.Date horacortemixto;
	private Integer minsobrett;
	private Integer maxtempran;
	private String flgTeletrabajo;

	public AsTipodiaasistencia() {
		pk = new AsTipodiaasistenciaPk();
	}

	public AsTipodiaasistenciaPk getPk() {
		return pk;
	}

	public void setPk(AsTipodiaasistenciaPk pk) {
		this.pk = pk;
	}

	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}

	public java.math.BigDecimal getCantidadhoras() {
		return cantidadhoras;
	}

	public void setCantidadhoras(java.math.BigDecimal cantidadhoras) {
		this.cantidadhoras = cantidadhoras;
	}

	public String getDescripcionextranjera() {
		return descripcionextranjera;
	}

	public void setDescripcionextranjera(String descripcionextranjera) {
		this.descripcionextranjera = descripcionextranjera;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipodiaanterior() {
		return tipodiaanterior;
	}

	public void setTipodiaanterior(String tipodiaanterior) {
		this.tipodiaanterior = tipodiaanterior;
	}

	public java.util.Date getHoracortemixto() {
		return horacortemixto;
	}

	public void setHoracortemixto(java.util.Date horacortemixto) {
		this.horacortemixto = horacortemixto;
	}

	public Integer getMinsobrett() {
		return minsobrett;
	}

	public void setMinsobrett(Integer minsobrett) {
		this.minsobrett = minsobrett;
	}

	public Integer getMaxtempran() {
		return maxtempran;
	}

	public void setMaxtempran(Integer maxtempran) {
		this.maxtempran = maxtempran;
	}

	public String getFlgTeletrabajo() {
		return flgTeletrabajo;
	}

	public void setFlgTeletrabajo(String flgTeletrabajo) {
		this.flgTeletrabajo = flgTeletrabajo;
	}

}
