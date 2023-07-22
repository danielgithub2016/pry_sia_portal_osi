package net.royal.erp.rrhh.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrGradosalariomast
*/
public class DtoHrGradosalariomast implements java.io.Serializable{

	private String gradosalario;
	private String descripcionlocal;
	private String descripcionextranjera;
	private Integer salariominimo;
	private Integer salariomaximo;
	private Integer salariopromedio;
	private String estado;
	private String cargo;
	private String categoria;
	private String catsigla;
	private String catcodigo;
	private Integer catnivel;

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
	public String getDescripcionextranjera() {
		return descripcionextranjera;
	}

	public void setDescripcionextranjera(String descripcionextranjera) {
		this.descripcionextranjera = descripcionextranjera;
	}
	public Integer getSalariominimo() {
		return salariominimo;
	}

	public void setSalariominimo(Integer salariominimo) {
		this.salariominimo = salariominimo;
	}
	public Integer getSalariomaximo() {
		return salariomaximo;
	}

	public void setSalariomaximo(Integer salariomaximo) {
		this.salariomaximo = salariomaximo;
	}
	public Integer getSalariopromedio() {
		return salariopromedio;
	}

	public void setSalariopromedio(Integer salariopromedio) {
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
