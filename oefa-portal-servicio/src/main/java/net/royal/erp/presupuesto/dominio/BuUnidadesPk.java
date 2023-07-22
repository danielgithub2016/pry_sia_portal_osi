package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuUnidades
*/
public class BuUnidadesPk implements java.io.Serializable{

	private String companiasocio;
	private String ano;
	private String ejercicio;
	private String centrocosto;
	private String proyecto;
	private String sucursal;
	private String referencia01;
	private String referencia02;
	private String areacliente;
	private String cliente;
	private String itemcodigo;

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
	public String getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(String ejercicio) {
		this.ejercicio = ejercicio;
	}
	public String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}
	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public String getReferencia01() {
		return referencia01;
	}

	public void setReferencia01(String referencia01) {
		this.referencia01 = referencia01;
	}
	public String getReferencia02() {
		return referencia02;
	}

	public void setReferencia02(String referencia02) {
		this.referencia02 = referencia02;
	}
	public String getAreacliente() {
		return areacliente;
	}

	public void setAreacliente(String areacliente) {
		this.areacliente = areacliente;
	}
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getItemcodigo() {
		return itemcodigo;
	}

	public void setItemcodigo(String itemcodigo) {
		this.itemcodigo = itemcodigo;
	}

}
