package net.royal.erp.asistencia.dominio.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.royal.framework.web.core.UValidador;

public class DtoBandejaSIGED {
	private Integer idPersona;
	private Integer idArea;
	private Integer idCargo;
	private String area;
	private String cargo;
	private String username;
	private Integer idPerfil;
	private String estado;

	// auiliares para asignacion de rol jefe
	private Integer esJefe;
	private Boolean blJefe;

	private BigDecimal idCargoaux;
	private String cargonombreaux;
	private Integer idPersonaaux;

	@JsonIgnore
	private BigDecimal secuencia;

	@JsonIgnore
	private BigDecimal idPersonaSIA;

	@JsonIgnore
	private String nombrePersonaSIA;

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public Integer getIdCargo() {
		if (idCargo == null) {
			idCargo = 0;
		}
		return idCargo;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public BigDecimal getIdPersonaSIA() {
		return idPersonaSIA;
	}

	public void setIdPersonaSIA(BigDecimal idPersonaSIA) {
		this.idPersonaSIA = idPersonaSIA;
	}

	public String getNombrePersonaSIA() {
		return nombrePersonaSIA;
	}

	public void setNombrePersonaSIA(String nombrePersonaSIA) {
		this.nombrePersonaSIA = nombrePersonaSIA;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getEsJefe() {
		return esJefe;
	}

	public void setEsJefe(Integer esJefe) {
		this.esJefe = esJefe;
	}

	public Boolean getBlJefe() {
		if (UValidador.esNulo(blJefe)) {
			blJefe = false;
		}
		return blJefe;
	}

	public void setBlJefe(Boolean blJefe) {
		this.blJefe = blJefe;
	}

	public BigDecimal getIdCargoaux() {
		if (UValidador.esNulo(idCargoaux)) {
			idCargoaux = BigDecimal.ZERO;
		}
		return idCargoaux;
	}

	public void setIdCargoaux(BigDecimal idCargoaux) {
		this.idCargoaux = idCargoaux;
	}

	public Integer getIdPersonaaux() {
		return idPersonaaux;
	}

	public void setIdPersonaaux(Integer idPersonaaux) {
		this.idPersonaaux = idPersonaaux;
	}

	public String getCargonombreaux() {
		return cargonombreaux;
	}

	public void setCargonombreaux(String cargonombreaux) {
		this.cargonombreaux = cargonombreaux;
	}

	
}
