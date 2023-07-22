package net.royal.erp.rrhh.dominio.dto;

import java.math.BigDecimal;

public class DtoHrEncuestapreguntavalores implements java.io.Serializable{

	private BigDecimal pregunta;
	private BigDecimal valor;
	private String descripcion;
	private String calificacion;
	private String tipoencuesta;

	public BigDecimal getPregunta() {
		return pregunta;
	}

	public void setPregunta(BigDecimal pregunta) {
		this.pregunta = pregunta;
	}
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	public String getTipoencuesta() {
		return tipoencuesta;
	}

	public void setTipoencuesta(String tipoencuesta) {
		this.tipoencuesta = tipoencuesta;
	}

}
