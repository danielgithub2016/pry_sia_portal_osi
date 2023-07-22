package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEvaluacionarea
*/
public class HrEvaluacion extends DominioGenerico implements java.io.Serializable{

	private HrEvaluacionPk pk;
	private String descripcion;
	private String unidadnegocio;
	private String unidadreplicacion;
	private Integer puntajeminimo;
	private Integer puntajemaximo;
	private String estado;
	private String ultimousuario;
	private Date ultimafechamodif;
	private String plantillaevaluacion;
	private String flagempleadomast;
	private String flagperfil;
	private String tipoeval;
	
	public HrEvaluacion() {
		pk = new HrEvaluacionPk();
	}

	public HrEvaluacionPk getPk() {
		return pk;
	}

	public void setPk(HrEvaluacionPk pk) {
		this.pk = pk;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}

	public Integer getPuntajeminimo() {
		return puntajeminimo;
	}

	public void setPuntajeminimo(Integer puntajeminimo) {
		this.puntajeminimo = puntajeminimo;
	}

	public Integer getPuntajemaximo() {
		return puntajemaximo;
	}

	public void setPuntajemaximo(Integer puntajemaximo) {
		this.puntajemaximo = puntajemaximo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

	public String getPlantillaevaluacion() {
		return plantillaevaluacion;
	}

	public void setPlantillaevaluacion(String plantillaevaluacion) {
		this.plantillaevaluacion = plantillaevaluacion;
	}

	public String getFlagempleadomast() {
		return flagempleadomast;
	}

	public void setFlagempleadomast(String flagempleadomast) {
		this.flagempleadomast = flagempleadomast;
	}

	public String getFlagperfil() {
		return flagperfil;
	}

	public void setFlagperfil(String flagperfil) {
		this.flagperfil = flagperfil;
	}

	public String getTipoeval() {
		return tipoeval;
	}

	public void setTipoeval(String tipoeval) {
		this.tipoeval = tipoeval;
	}
	
	


}
