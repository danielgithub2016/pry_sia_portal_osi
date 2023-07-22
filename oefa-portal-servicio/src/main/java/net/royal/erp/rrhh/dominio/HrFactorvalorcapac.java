package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrFactorvalorcapac
*/
public class HrFactorvalorcapac extends DominioGenerico implements java.io.Serializable{

	private HrFactorvalorcapacPk pk;
	private String plantilla;
	private String descripcion;
	private java.math.BigDecimal valor;
	private String estado;
	private String explicacion;
	private java.math.BigDecimal valorrequerido;
	private String flagaprobado;


	public HrFactorvalorcapac() {
		pk = new HrFactorvalorcapacPk();
	}

	public HrFactorvalorcapacPk getPk() {
		return pk;
	}

	public void setPk(HrFactorvalorcapacPk pk) {
		this.pk = pk;
	}
	public String getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(String plantilla) {
		this.plantilla = plantilla;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public java.math.BigDecimal getValor() {
		return valor;
	}

	public void setValor(java.math.BigDecimal valor) {
		this.valor = valor;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getExplicacion() {
		return explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}
	public java.math.BigDecimal getValorrequerido() {
		return valorrequerido;
	}

	public void setValorrequerido(java.math.BigDecimal valorrequerido) {
		this.valorrequerido = valorrequerido;
	}
	public String getFlagaprobado() {
		return flagaprobado;
	}

	public void setFlagaprobado(String flagaprobado) {
		this.flagaprobado = flagaprobado;
	}

}
