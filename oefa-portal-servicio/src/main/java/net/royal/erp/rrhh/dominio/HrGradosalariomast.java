package net.royal.erp.rrhh.dominio;

import java.math.BigDecimal;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrGradosalariomast
 */
public class HrGradosalariomast extends DominioGenerico implements
		java.io.Serializable {

	private HrGradosalariomastPk pk;
	private String descripcionlocal;
	private String descripcionextranjera;
	private BigDecimal salariominimo;
	private BigDecimal salariomaximo;
	private BigDecimal salariopromedio;
	private String estado;
	private String cargo;
	private String categoria;
	private String catsigla;
	private String catcodigo;
	private Integer catnivel;

	public HrGradosalariomast() {
		pk = new HrGradosalariomastPk();
	}

	public HrGradosalariomastPk getPk() {
		return pk;
	}

	public void setPk(HrGradosalariomastPk pk) {
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

	public BigDecimal getSalariominimo() {
		return salariominimo;
	}

	public void setSalariominimo(BigDecimal salariominimo) {
		this.salariominimo = salariominimo;
	}

	public BigDecimal getSalariomaximo() {
		return salariomaximo;
	}

	public void setSalariomaximo(BigDecimal salariomaximo) {
		this.salariomaximo = salariomaximo;
	}

	public BigDecimal getSalariopromedio() {
		return salariopromedio;
	}

	public void setSalariopromedio(BigDecimal salariopromedio) {
		this.salariopromedio = salariopromedio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCatsigla() {
		return catsigla;
	}

	public void setCatsigla(String catsigla) {
		this.catsigla = catsigla;
	}

	public String getCatcodigo() {
		return catcodigo;
	}

	public void setCatcodigo(String catcodigo) {
		this.catcodigo = catcodigo;
	}

	public Integer getCatnivel() {
		return catnivel;
	}

	public void setCatnivel(Integer catnivel) {
		this.catnivel = catnivel;
	}

}
