package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SyUnidadreplicacion
*/
public class SyUnidadreplicacion extends DominioGenerico implements java.io.Serializable{

	private SyUnidadreplicacionPk pk;
	private String descripcionlocal;
	private String descripcionextranjera;
	private Integer rangopersonainicio;
	private Integer rangopersonafin;
	private Integer personaactual;
	private String estado;


	public SyUnidadreplicacion() {
		pk = new SyUnidadreplicacionPk();
	}

	public SyUnidadreplicacionPk getPk() {
		return pk;
	}

	public void setPk(SyUnidadreplicacionPk pk) {
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
	public Integer getRangopersonainicio() {
		return rangopersonainicio;
	}

	public void setRangopersonainicio(Integer rangopersonainicio) {
		this.rangopersonainicio = rangopersonainicio;
	}
	public Integer getRangopersonafin() {
		return rangopersonafin;
	}

	public void setRangopersonafin(Integer rangopersonafin) {
		this.rangopersonafin = rangopersonafin;
	}
	public Integer getPersonaactual() {
		return personaactual;
	}

	public void setPersonaactual(Integer personaactual) {
		this.personaactual = personaactual;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
