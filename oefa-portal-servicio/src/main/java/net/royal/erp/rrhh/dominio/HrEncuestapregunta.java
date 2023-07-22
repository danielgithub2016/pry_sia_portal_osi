package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuestapregunta
*/
public class HrEncuestapregunta extends DominioGenerico implements java.io.Serializable{

	private HrEncuestapreguntaPk pk;
	private String descripcion;
	private String area;
	private Integer valorminimo;
	private Integer valormaximo;
	private String estado;
	private String leyenda;
	private String tipo;
	private String flagpersonacargo;
	private Integer secuencia;
	private String tipoencuesta;


	public HrEncuestapregunta() {
		pk = new HrEncuestapreguntaPk();
	}

	public HrEncuestapreguntaPk getPk() {
		return pk;
	}

	public void setPk(HrEncuestapreguntaPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	public Integer getValorminimo() {
		return valorminimo;
	}

	public void setValorminimo(Integer valorminimo) {
		this.valorminimo = valorminimo;
	}
	public Integer getValormaximo() {
		return valormaximo;
	}

	public void setValormaximo(Integer valormaximo) {
		this.valormaximo = valormaximo;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getLeyenda() {
		return leyenda;
	}

	public void setLeyenda(String leyenda) {
		this.leyenda = leyenda;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFlagpersonacargo() {
		return flagpersonacargo;
	}

	public void setFlagpersonacargo(String flagpersonacargo) {
		this.flagpersonacargo = flagpersonacargo;
	}
	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}
	public String getTipoencuesta() {
		return tipoencuesta;
	}

	public void setTipoencuesta(String tipoencuesta) {
		this.tipoencuesta = tipoencuesta;
	}

}
