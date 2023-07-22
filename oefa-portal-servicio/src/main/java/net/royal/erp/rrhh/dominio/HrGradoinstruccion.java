package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrGradoinstruccion
*/
public class HrGradoinstruccion extends DominioGenerico implements java.io.Serializable{

	private HrGradoinstruccionPk pk;
	private String descripcion;
	private String flagcentroestudios;
	private String estado;
	private java.util.Date uitimafechamodif;
	private String flagtienecarrera;
	private Integer jerarquia;
	private String gradocuantitativo;
	private Integer puntosgrado;
	private Integer porcentajegrado;
	private String niveleducativortps;


	public HrGradoinstruccion() {
		pk = new HrGradoinstruccionPk();
	}

	public HrGradoinstruccionPk getPk() {
		return pk;
	}

	public void setPk(HrGradoinstruccionPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFlagcentroestudios() {
		return flagcentroestudios;
	}

	public void setFlagcentroestudios(String flagcentroestudios) {
		this.flagcentroestudios = flagcentroestudios;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public java.util.Date getUitimafechamodif() {
		return uitimafechamodif;
	}

	public void setUitimafechamodif(java.util.Date uitimafechamodif) {
		this.uitimafechamodif = uitimafechamodif;
	}
	public String getFlagtienecarrera() {
		return flagtienecarrera;
	}

	public void setFlagtienecarrera(String flagtienecarrera) {
		this.flagtienecarrera = flagtienecarrera;
	}
	public Integer getJerarquia() {
		return jerarquia;
	}

	public void setJerarquia(Integer jerarquia) {
		this.jerarquia = jerarquia;
	}
	public String getGradocuantitativo() {
		return gradocuantitativo;
	}

	public void setGradocuantitativo(String gradocuantitativo) {
		this.gradocuantitativo = gradocuantitativo;
	}
	public Integer getPuntosgrado() {
		return puntosgrado;
	}

	public void setPuntosgrado(Integer puntosgrado) {
		this.puntosgrado = puntosgrado;
	}
	public Integer getPorcentajegrado() {
		return porcentajegrado;
	}

	public void setPorcentajegrado(Integer porcentajegrado) {
		this.porcentajegrado = porcentajegrado;
	}
	public String getNiveleducativortps() {
		return niveleducativortps;
	}

	public void setNiveleducativortps(String niveleducativortps) {
		this.niveleducativortps = niveleducativortps;
	}

}
