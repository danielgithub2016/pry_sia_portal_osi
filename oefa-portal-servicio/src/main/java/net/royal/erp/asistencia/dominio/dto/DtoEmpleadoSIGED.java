package net.royal.erp.asistencia.dominio.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.royal.framework.web.core.UValidador;

public class DtoEmpleadoSIGED {

	public DtoEmpleadoSIGED() {
		bandejas = new ArrayList<>();
		perfiles = new ArrayList<>();
		administrativo = new ArrayList<>();
	}

	private Integer idPersona;
	private String apellidos;
	private String correo;
	private String estado;
	private Date fechaCreacion;
	private String nombres;
	private String username;
	private String numeroIdentificacion;
	private List<DtoBandejaSIGED> bandejas;
	private List<DtoPerfilSIGED> perfiles;
	private List<DtoAdministrativoSIGED> administrativo;
	private Boolean bljefe;
	private Boolean blasistente;

	// auxiliar
	private String nombrecompleto;

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public List<DtoBandejaSIGED> getBandejas() {
		return bandejas;
	}

	public void setBandejas(List<DtoBandejaSIGED> bandejas) {
		this.bandejas = bandejas;
	}

	public List<DtoPerfilSIGED> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<DtoPerfilSIGED> perfiles) {
		this.perfiles = perfiles;
	}

	public List<DtoAdministrativoSIGED> getAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(List<DtoAdministrativoSIGED> administrativo) {
		this.administrativo = administrativo;
	}

	public String getNombrecompleto() {
		nombrecompleto = "";
		if (!UValidador.estaVacio(apellidos) && !UValidador.estaVacio(nombres)) {
			nombrecompleto = apellidos + ", " + nombres;
		}
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public Boolean getBljefe() {
		if (UValidador.esNulo(bljefe)) {
			bljefe = false;
		}
		return bljefe;
	}

	public void setBljefe(Boolean bljefe) {
		this.bljefe = bljefe;
	}

	public Boolean getBlasistente() {
		if (UValidador.esNulo(blasistente)) {
			blasistente = false;
		}
		return blasistente;
	}

	public void setBlasistente(Boolean blasistente) {
		this.blasistente = blasistente;
	}

}
