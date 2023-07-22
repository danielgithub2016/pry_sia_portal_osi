package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.DominioGenerico;

import java.math.RoundingMode;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrFactorvalor
*/
public class HrFactorvalor extends DominioGenerico implements java.io.Serializable{

	private HrFactorvalorPk pk;
	private String plantilla;
	private String descripcion;
	private java.math.BigDecimal valor;
	private String estado;
	private String explicacion;
	private java.math.BigDecimal valorrequerido;
	private java.math.BigDecimal valorhasta;
	private Integer curso;


	public HrFactorvalor() {
		pk = new HrFactorvalorPk();
	}

	public HrFactorvalorPk getPk() {
		return pk;
	}

	public void setPk(HrFactorvalorPk pk) {
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
		if(!UValidador.esNulo(valor)){
			valor=valor.setScale(2,RoundingMode.HALF_UP);
		}
		
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
	public java.math.BigDecimal getValorhasta() {
		if(!UValidador.esNulo(valorhasta)){
			valorhasta=valorhasta.setScale(2,RoundingMode.HALF_UP);
		}
		return valorhasta;
	}

	public void setValorhasta(java.math.BigDecimal valorhasta) {
		this.valorhasta = valorhasta;
	}
	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

}
