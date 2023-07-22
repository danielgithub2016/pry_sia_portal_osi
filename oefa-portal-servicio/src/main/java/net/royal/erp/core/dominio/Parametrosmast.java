package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Parametrosmast
*/
public class Parametrosmast extends DominioGenerico implements java.io.Serializable{

	private ParametrosmastPk pk;
	private String descripcionparametro;
	private String explicacion;
	private String tipodedatoflag;
	private String texto;
	private Integer numero;
	private java.util.Date fecha;
	private String financecomunflag;
	private String estado;
	private String explicacionadicional;


	public Parametrosmast() {
		pk = new ParametrosmastPk();
	}

	public ParametrosmastPk getPk() {
		return pk;
	}

	public void setPk(ParametrosmastPk pk) {
		this.pk = pk;
	}
	public String getDescripcionparametro() {
		return descripcionparametro;
	}

	public void setDescripcionparametro(String descripcionparametro) {
		this.descripcionparametro = descripcionparametro;
	}
	public String getExplicacion() {
		return explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}
	public String getTipodedatoflag() {
		return tipodedatoflag;
	}

	public void setTipodedatoflag(String tipodedatoflag) {
		this.tipodedatoflag = tipodedatoflag;
	}
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}
	public String getFinancecomunflag() {
		return financecomunflag;
	}

	public void setFinancecomunflag(String financecomunflag) {
		this.financecomunflag = financecomunflag;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getExplicacionadicional() {
		return explicacionadicional;
	}

	public void setExplicacionadicional(String explicacionadicional) {
		this.explicacionadicional = explicacionadicional;
	}

}
