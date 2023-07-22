package net.royal.erp.planilla.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder planilla.PrTipoplanilla
*/
public class PrTipoplanilla extends DominioGenerico implements java.io.Serializable{

	private PrTipoplanillaPk pk;
	private Integer funcion;
	private String descripcion;
	private String titulodeboleta;
	private String descripcionextranjera;
	private java.math.BigDecimal tipodecambio;
	private String clasepago;
	private String estado;
	private String mensaje;
	private Integer planillaperfil;
	private String periodicidad;
	private String categoriatrabajador;
	private String tipotrabajador;
	private String cuentacontable;
	private String flujocaja;


	public PrTipoplanilla() {
		pk = new PrTipoplanillaPk();
	}

	public PrTipoplanillaPk getPk() {
		return pk;
	}

	public void setPk(PrTipoplanillaPk pk) {
		this.pk = pk;
	}
	public Integer getFuncion() {
		return funcion;
	}

	public void setFuncion(Integer funcion) {
		this.funcion = funcion;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTitulodeboleta() {
		return titulodeboleta;
	}

	public void setTitulodeboleta(String titulodeboleta) {
		this.titulodeboleta = titulodeboleta;
	}
	public String getDescripcionextranjera() {
		return descripcionextranjera;
	}

	public void setDescripcionextranjera(String descripcionextranjera) {
		this.descripcionextranjera = descripcionextranjera;
	}
	public java.math.BigDecimal getTipodecambio() {
		return tipodecambio;
	}

	public void setTipodecambio(java.math.BigDecimal tipodecambio) {
		this.tipodecambio = tipodecambio;
	}
	public String getClasepago() {
		return clasepago;
	}

	public void setClasepago(String clasepago) {
		this.clasepago = clasepago;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Integer getPlanillaperfil() {
		return planillaperfil;
	}

	public void setPlanillaperfil(Integer planillaperfil) {
		this.planillaperfil = planillaperfil;
	}
	public String getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}
	public String getCategoriatrabajador() {
		return categoriatrabajador;
	}

	public void setCategoriatrabajador(String categoriatrabajador) {
		this.categoriatrabajador = categoriatrabajador;
	}
	public String getTipotrabajador() {
		return tipotrabajador;
	}

	public void setTipotrabajador(String tipotrabajador) {
		this.tipotrabajador = tipotrabajador;
	}
	public String getCuentacontable() {
		return cuentacontable;
	}

	public void setCuentacontable(String cuentacontable) {
		this.cuentacontable = cuentacontable;
	}
	public String getFlujocaja() {
		return flujocaja;
	}

	public void setFlujocaja(String flujocaja) {
		this.flujocaja = flujocaja;
	}

}
