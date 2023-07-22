package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Correlativosmast
*/
public class Correlativosmast extends DominioGenerico implements java.io.Serializable{

	private CorrelativosmastPk pk;
	private String descripcion;
	private Integer correlativonumero;
	private Integer correlativodesde;
	private Integer correlativohasta;
	private String almacencodigo;
	private String estado;
	private String datawindowobjeto;
	private String controlfisicoflag;
	private String impresoraflag;
	private String impresora;
	private Integer ancho;
	private Integer alto;


	public Correlativosmast() {
		pk = new CorrelativosmastPk();
	}

	public CorrelativosmastPk getPk() {
		return pk;
	}

	public void setPk(CorrelativosmastPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getCorrelativonumero() {
		return correlativonumero;
	}

	public void setCorrelativonumero(Integer correlativonumero) {
		this.correlativonumero = correlativonumero;
	}
	public Integer getCorrelativodesde() {
		return correlativodesde;
	}

	public void setCorrelativodesde(Integer correlativodesde) {
		this.correlativodesde = correlativodesde;
	}
	public Integer getCorrelativohasta() {
		return correlativohasta;
	}

	public void setCorrelativohasta(Integer correlativohasta) {
		this.correlativohasta = correlativohasta;
	}
	public String getAlmacencodigo() {
		return almacencodigo;
	}

	public void setAlmacencodigo(String almacencodigo) {
		this.almacencodigo = almacencodigo;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDatawindowobjeto() {
		return datawindowobjeto;
	}

	public void setDatawindowobjeto(String datawindowobjeto) {
		this.datawindowobjeto = datawindowobjeto;
	}
	public String getControlfisicoflag() {
		return controlfisicoflag;
	}

	public void setControlfisicoflag(String controlfisicoflag) {
		this.controlfisicoflag = controlfisicoflag;
	}
	public String getImpresoraflag() {
		return impresoraflag;
	}

	public void setImpresoraflag(String impresoraflag) {
		this.impresoraflag = impresoraflag;
	}
	public String getImpresora() {
		return impresora;
	}

	public void setImpresora(String impresora) {
		this.impresora = impresora;
	}
	public Integer getAncho() {
		return ancho;
	}

	public void setAncho(Integer ancho) {
		this.ancho = ancho;
	}
	public Integer getAlto() {
		return alto;
	}

	public void setAlto(Integer alto) {
		this.alto = alto;
	}

}
