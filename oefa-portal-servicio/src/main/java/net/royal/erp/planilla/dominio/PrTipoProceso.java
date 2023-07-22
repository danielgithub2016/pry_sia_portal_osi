package net.royal.erp.planilla.dominio;

import java.io.Serializable;
import java.util.Date;

import net.royal.framework.web.dominio.DominioGenerico;

@SuppressWarnings("serial")
public class PrTipoProceso extends DominioGenerico implements Serializable {

	private PrTipoProcesoPk pk;
	private String descripcion;
	private String estado;
	private String ultimousuario;
	private Date ultimafechamodif;
	private String descripcionextranjera;
	private String flagadelanto;
	private Date fechapago;
	private Date fechaproceso;
	private String piedeboleta;
	private String subtitulodeboleta;
	private String titulodeboleta;
	private String flagrequierecierre;
	private String flagcheque;

	public PrTipoProcesoPk getPk() {
		return pk;
	}

	public void setPk(PrTipoProcesoPk pk) {
		this.pk = pk;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public String getDescripcionextranjera() {
		return descripcionextranjera;
	}

	public void setDescripcionextranjera(String descripcionextranjera) {
		this.descripcionextranjera = descripcionextranjera;
	}

	public String getFlagadelanto() {
		return flagadelanto;
	}

	public void setFlagadelanto(String flagadelanto) {
		this.flagadelanto = flagadelanto;
	}

	public Date getFechapago() {
		return fechapago;
	}

	public void setFechapago(Date fechapago) {
		this.fechapago = fechapago;
	}

	public Date getFechaproceso() {
		return fechaproceso;
	}

	public void setFechaproceso(Date fechaproceso) {
		this.fechaproceso = fechaproceso;
	}

	public String getPiedeboleta() {
		return piedeboleta;
	}

	public void setPiedeboleta(String piedeboleta) {
		this.piedeboleta = piedeboleta;
	}

	public String getSubtitulodeboleta() {
		return subtitulodeboleta;
	}

	public void setSubtitulodeboleta(String subtitulodeboleta) {
		this.subtitulodeboleta = subtitulodeboleta;
	}

	public String getTitulodeboleta() {
		return titulodeboleta;
	}

	public void setTitulodeboleta(String titulodeboleta) {
		this.titulodeboleta = titulodeboleta;
	}

	public String getFlagrequierecierre() {
		return flagrequierecierre;
	}

	public void setFlagrequierecierre(String flagrequierecierre) {
		this.flagrequierecierre = flagrequierecierre;
	}

	public String getFlagcheque() {
		return flagcheque;
	}

	public void setFlagcheque(String flagcheque) {
		this.flagcheque = flagcheque;
	}

}
