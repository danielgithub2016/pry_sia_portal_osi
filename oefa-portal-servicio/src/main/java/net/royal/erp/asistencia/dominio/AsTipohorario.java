package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsTipohorario
 */
public class AsTipohorario extends DominioGenerico implements
		java.io.Serializable {

	private AsTipohorarioPk pk;
	private String descripcionlocal;
	private String descripcionextranjera;
	private Integer tipoturno;
	private Integer lunes;
	private Integer martes;
	private Integer miercoles;
	private Integer jueves;
	private Integer viernes;
	private Integer sabado;
	private Integer domingo;
	private String estado;

	public AsTipohorario() {
		pk = new AsTipohorarioPk();
	}

	public AsTipohorarioPk getPk() {
		return pk;
	}

	public void setPk(AsTipohorarioPk pk) {
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

	public Integer getTipoturno() {
		return tipoturno;
	}

	public void setTipoturno(Integer tipoturno) {
		this.tipoturno = tipoturno;
	}

	public Integer getLunes() {
		return lunes;
	}

	public void setLunes(Integer lunes) {
		this.lunes = lunes;
	}

	public Integer getMartes() {
		return martes;
	}

	public void setMartes(Integer martes) {
		this.martes = martes;
	}

	public Integer getMiercoles() {
		return miercoles;
	}

	public void setMiercoles(Integer miercoles) {
		this.miercoles = miercoles;
	}

	public Integer getJueves() {
		return jueves;
	}

	public void setJueves(Integer jueves) {
		this.jueves = jueves;
	}

	public Integer getViernes() {
		return viernes;
	}

	public void setViernes(Integer viernes) {
		this.viernes = viernes;
	}

	public Integer getSabado() {
		return sabado;
	}

	public void setSabado(Integer sabado) {
		this.sabado = sabado;
	}

	public Integer getDomingo() {
		return domingo;
	}

	public void setDomingo(Integer domingo) {
		this.domingo = domingo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
