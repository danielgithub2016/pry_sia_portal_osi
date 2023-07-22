package net.royal.erp.rrhh.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuestasujeto
*/
public class DtoHrEncuestasujeto implements java.io.Serializable{

	private Integer secuencia;
	private Integer sujeto;
	private Integer pregunta;
	private Integer valor;
	private String observacion;
	private String companiasocio;
	private String departamentooperacional;
	private String tipoplanilla;
	private Integer personasacargo;
	private String sexo;
	private String tiempodetrabajo;
	private String tipocontrato;
	private Integer areaposicion;
	private String categoria;
	private String sindicato;
	private String edad;
	private Integer encuestado;
	private Integer dptoareaoperativa;

	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}
	public Integer getSujeto() {
		return sujeto;
	}

	public void setSujeto(Integer sujeto) {
		this.sujeto = sujeto;
	}
	public Integer getPregunta() {
		return pregunta;
	}

	public void setPregunta(Integer pregunta) {
		this.pregunta = pregunta;
	}
	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}
	public String getDepartamentooperacional() {
		return departamentooperacional;
	}

	public void setDepartamentooperacional(String departamentooperacional) {
		this.departamentooperacional = departamentooperacional;
	}
	public String getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}
	public Integer getPersonasacargo() {
		return personasacargo;
	}

	public void setPersonasacargo(Integer personasacargo) {
		this.personasacargo = personasacargo;
	}
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTiempodetrabajo() {
		return tiempodetrabajo;
	}

	public void setTiempodetrabajo(String tiempodetrabajo) {
		this.tiempodetrabajo = tiempodetrabajo;
	}
	public String getTipocontrato() {
		return tipocontrato;
	}

	public void setTipocontrato(String tipocontrato) {
		this.tipocontrato = tipocontrato;
	}
	public Integer getAreaposicion() {
		return areaposicion;
	}

	public void setAreaposicion(Integer areaposicion) {
		this.areaposicion = areaposicion;
	}
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getSindicato() {
		return sindicato;
	}

	public void setSindicato(String sindicato) {
		this.sindicato = sindicato;
	}
	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}
	public Integer getEncuestado() {
		return encuestado;
	}

	public void setEncuestado(Integer encuestado) {
		this.encuestado = encuestado;
	}
	public Integer getDptoareaoperativa() {
		return dptoareaoperativa;
	}

	public void setDptoareaoperativa(Integer dptoareaoperativa) {
		this.dptoareaoperativa = dptoareaoperativa;
	}

}
