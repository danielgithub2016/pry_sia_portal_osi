package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuPresupuesto
*/
public class BuPresupuestoPk implements java.io.Serializable{

	private String companiasocio;
	private String ano;
	private String ejercicio;
	private String cuentacontable;
	private String centrocosto;
	private String elementogasto;
	private String proyecto;
	private String sucursal;
	private String referencia01;
	private String referencia02;
	private String monedacodigo;
	private String efp;

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
	public String getCuentacontable() {
		return cuentacontable;
	}

	public void setCuentacontable(String cuentacontable) {
		this.cuentacontable = cuentacontable;
	}
	public String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}
	public String getElementogasto() {
		return elementogasto;
	}

	public void setElementogasto(String elementogasto) {
		this.elementogasto = elementogasto;
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
	public String getMonedacodigo() {
		return monedacodigo;
	}

	public void setMonedacodigo(String monedacodigo) {
		this.monedacodigo = monedacodigo;
	}
	public String getEfp() {
		return efp;
	}

	public void setEfp(String efp) {
		this.efp = efp;
	}

}
