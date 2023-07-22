package net.royal.erp.rrhh.dominio.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuestadetalle
*/
@SuppressWarnings("serial")
public class DtoHrEncuestadetalle implements java.io.Serializable{

	private BigDecimal secuencia;
	private BigDecimal pregunta;
	private BigDecimal orden;
	private String descripcion;
	private String tipo;
	private String areadescripcion;
	private BigDecimal valor;
	private String observacion;
	private String estilocabecera;
	private List<DtoHrEncuestapreguntavalores> valores;
	

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}
	public BigDecimal getPregunta() {
		return pregunta;
	}

	public void setPregunta(BigDecimal pregunta) {
		this.pregunta = pregunta;
	}
	public BigDecimal getOrden() {
		return orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<DtoHrEncuestapreguntavalores> getValores() {
		return valores;
	}

	public void setValores(List<DtoHrEncuestapreguntavalores> valores) {
		this.valores = valores;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstilocabecera() {
		estilocabecera= (orden.compareTo(BigDecimal.ONE)==0?"":"display:none;");
		return estilocabecera;
	}

	public void setEstilocabecera(String estilocabecera) {
		this.estilocabecera = estilocabecera;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the areadescripcion
	 */
	public String getAreadescripcion() {
		return areadescripcion;
	}

	/**
	 * @param areadescripcion the areadescripcion to set
	 */
	public void setAreadescripcion(String areadescripcion) {
		this.areadescripcion = areadescripcion;
	}

}
