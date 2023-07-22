package net.royal.erp.asistencia.dominio.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DtoPerfilSIGED {
	  private Integer idPerfil;
	  private String codigo;
	  private String descripcion;
	  private String estado;
	  private Object fechaCreacion;
	  private String nombre;
	  private BigDecimal secuencia;
	  
	  @JsonIgnore
	  private Boolean perfilSeleccionado;
	  
	  @JsonIgnore
	  private Boolean perfilSeleccionadoLectura;
	  
	public Integer getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public Object getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Object fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getPerfilSeleccionado() {
		return perfilSeleccionado;
	}
	public void setPerfilSeleccionado(Boolean perfilSeleccionado) {
		this.perfilSeleccionado = perfilSeleccionado;
	}
	public Boolean getPerfilSeleccionadoLectura() {
		return perfilSeleccionadoLectura;
	}
	public void setPerfilSeleccionadoLectura(Boolean perfilSeleccionadoLectura) {
		this.perfilSeleccionadoLectura = perfilSeleccionadoLectura;
	}
	public BigDecimal getSecuencia() {
		return secuencia;
	}
	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}
}
