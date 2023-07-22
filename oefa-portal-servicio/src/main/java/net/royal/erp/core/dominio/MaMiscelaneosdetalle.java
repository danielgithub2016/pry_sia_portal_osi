package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder core.MaMiscelaneosdetalle
*/
public class MaMiscelaneosdetalle extends DominioGenerico implements java.io.Serializable{

	private MaMiscelaneosdetallePk pk;
	private String descripcionlocal;
	private String descripcionextranjera;
	private java.math.BigDecimal valornumerico;
	private String valorcodigo1;
	private String valorcodigo2;
	private String valorcodigo3;
	private String valorcodigo4;
	private String valorcodigo5;
	private java.util.Date valorfecha;
	private String estado;
	private String valorcodigo6;

	private String auxSeleccionado;

	public MaMiscelaneosdetalle() {
		pk = new MaMiscelaneosdetallePk();
	}

	public MaMiscelaneosdetallePk getPk() {
		return pk;
	}

	public void setPk(MaMiscelaneosdetallePk pk) {
		this.pk = pk;
	}
	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}
	public String getDescripcionextranjera() {
		return descripcionextranjera;
	}

	public void setDescripcionextranjera(String descripcionextranjera) {
		this.descripcionextranjera = descripcionextranjera;
	}
	public java.math.BigDecimal getValornumerico() {
		return valornumerico;
	}

	public void setValornumerico(java.math.BigDecimal valornumerico) {
		this.valornumerico = valornumerico;
	}
	public String getValorcodigo1() {
		return valorcodigo1;
	}

	public void setValorcodigo1(String valorcodigo1) {
		this.valorcodigo1 = valorcodigo1;
	}
	public String getValorcodigo2() {
		return valorcodigo2;
	}

	public void setValorcodigo2(String valorcodigo2) {
		this.valorcodigo2 = valorcodigo2;
	}
	public String getValorcodigo3() {
		return valorcodigo3;
	}

	public void setValorcodigo3(String valorcodigo3) {
		this.valorcodigo3 = valorcodigo3;
	}
	public String getValorcodigo4() {
		return valorcodigo4;
	}

	public void setValorcodigo4(String valorcodigo4) {
		this.valorcodigo4 = valorcodigo4;
	}
	public String getValorcodigo5() {
		return valorcodigo5;
	}

	public void setValorcodigo5(String valorcodigo5) {
		this.valorcodigo5 = valorcodigo5;
	}
	public java.util.Date getValorfecha() {
		return valorfecha;
	}

	public void setValorfecha(java.util.Date valorfecha) {
		this.valorfecha = valorfecha;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getValorcodigo6() {
		return valorcodigo6;
	}

	public void setValorcodigo6(String valorcodigo6) {
		this.valorcodigo6 = valorcodigo6;
	}

	public String getAuxSeleccionado() {
		return auxSeleccionado;
	}

	public void setAuxSeleccionado(String auxSeleccionado) {
		this.auxSeleccionado = auxSeleccionado;
	}

}
