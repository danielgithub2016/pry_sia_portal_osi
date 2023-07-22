package net.royal.erp.presupuesto.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuEjercicio
*/
public class DtoBuEjercicio implements java.io.Serializable{

	private String ano;
	private String ejercicio;
	private String descripcionlocal;
	private String descripcioningles;
	private String tipoejercicio;
	private String tipopresupuesto;
	private java.util.Date fechapreparacion;
	private java.util.Date fechaaprobacion;
	private Integer preparadapor;
	private Integer aprobadapor;
	private String ejerciciorealasociado;
	private String ejerciciocommitmentasociado;
	private String documentoreferencia;
	private String periododesde;
	private String periodohasta;
	private String estado;
	private String presupuestoteoricoflag;
	private String itemcodigogrupo;
	private String ejercicioprincipalasociado;
	private String unidadestipoejercicio;
	private String nomenclatura;
	private String centrocostoflag;
	private String aplicacionorigen;

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
	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}
	public String getDescripcioningles() {
		return descripcioningles;
	}

	public void setDescripcioningles(String descripcioningles) {
		this.descripcioningles = descripcioningles;
	}
	public String getTipoejercicio() {
		return tipoejercicio;
	}

	public void setTipoejercicio(String tipoejercicio) {
		this.tipoejercicio = tipoejercicio;
	}
	public String getTipopresupuesto() {
		return tipopresupuesto;
	}

	public void setTipopresupuesto(String tipopresupuesto) {
		this.tipopresupuesto = tipopresupuesto;
	}
	public java.util.Date getFechapreparacion() {
		return fechapreparacion;
	}

	public void setFechapreparacion(java.util.Date fechapreparacion) {
		this.fechapreparacion = fechapreparacion;
	}
	public java.util.Date getFechaaprobacion() {
		return fechaaprobacion;
	}

	public void setFechaaprobacion(java.util.Date fechaaprobacion) {
		this.fechaaprobacion = fechaaprobacion;
	}
	public Integer getPreparadapor() {
		return preparadapor;
	}

	public void setPreparadapor(Integer preparadapor) {
		this.preparadapor = preparadapor;
	}
	public Integer getAprobadapor() {
		return aprobadapor;
	}

	public void setAprobadapor(Integer aprobadapor) {
		this.aprobadapor = aprobadapor;
	}
	public String getEjerciciorealasociado() {
		return ejerciciorealasociado;
	}

	public void setEjerciciorealasociado(String ejerciciorealasociado) {
		this.ejerciciorealasociado = ejerciciorealasociado;
	}
	public String getEjerciciocommitmentasociado() {
		return ejerciciocommitmentasociado;
	}

	public void setEjerciciocommitmentasociado(String ejerciciocommitmentasociado) {
		this.ejerciciocommitmentasociado = ejerciciocommitmentasociado;
	}
	public String getDocumentoreferencia() {
		return documentoreferencia;
	}

	public void setDocumentoreferencia(String documentoreferencia) {
		this.documentoreferencia = documentoreferencia;
	}
	public String getPeriododesde() {
		return periododesde;
	}

	public void setPeriododesde(String periododesde) {
		this.periododesde = periododesde;
	}
	public String getPeriodohasta() {
		return periodohasta;
	}

	public void setPeriodohasta(String periodohasta) {
		this.periodohasta = periodohasta;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPresupuestoteoricoflag() {
		return presupuestoteoricoflag;
	}

	public void setPresupuestoteoricoflag(String presupuestoteoricoflag) {
		this.presupuestoteoricoflag = presupuestoteoricoflag;
	}
	public String getItemcodigogrupo() {
		return itemcodigogrupo;
	}

	public void setItemcodigogrupo(String itemcodigogrupo) {
		this.itemcodigogrupo = itemcodigogrupo;
	}
	public String getEjercicioprincipalasociado() {
		return ejercicioprincipalasociado;
	}

	public void setEjercicioprincipalasociado(String ejercicioprincipalasociado) {
		this.ejercicioprincipalasociado = ejercicioprincipalasociado;
	}
	public String getUnidadestipoejercicio() {
		return unidadestipoejercicio;
	}

	public void setUnidadestipoejercicio(String unidadestipoejercicio) {
		this.unidadestipoejercicio = unidadestipoejercicio;
	}
	public String getNomenclatura() {
		return nomenclatura;
	}

	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}
	public String getCentrocostoflag() {
		return centrocostoflag;
	}

	public void setCentrocostoflag(String centrocostoflag) {
		this.centrocostoflag = centrocostoflag;
	}
	public String getAplicacionorigen() {
		return aplicacionorigen;
	}

	public void setAplicacionorigen(String aplicacionorigen) {
		this.aplicacionorigen = aplicacionorigen;
	}

}
