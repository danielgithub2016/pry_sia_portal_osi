package net.royal.erp.rrhh.dominio;

import java.math.BigDecimal;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrActividadparticipante
*/
public class HrActividadparticipante extends DominioGenerico implements java.io.Serializable{

	private HrActividadparticipantePk pk;
	private Integer secuencia;
	private String flagparticipo;
	private String flagbeneficio;
	private String flagasistencia;
	private BigDecimal monto;


	public HrActividadparticipante() {
		pk = new HrActividadparticipantePk();
	}

	public HrActividadparticipantePk getPk() {
		return pk;
	}

	public void setPk(HrActividadparticipantePk pk) {
		this.pk = pk;
	}
	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}
	public String getFlagparticipo() {
		return flagparticipo;
	}

	public void setFlagparticipo(String flagparticipo) {
		this.flagparticipo = flagparticipo;
	}
	public String getFlagbeneficio() {
		return flagbeneficio;
	}

	public void setFlagbeneficio(String flagbeneficio) {
		this.flagbeneficio = flagbeneficio;
	}
	public String getFlagasistencia() {
		return flagasistencia;
	}

	public void setFlagasistencia(String flagasistencia) {
		this.flagasistencia = flagasistencia;
	}
	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

}
