package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientoobservacion
*/
public class HrRequerimientoobservacion extends DominioGenerico implements java.io.Serializable{

	private HrRequerimientoobservacionPk pk;
	private String adjuntainformes;
	private String adjuntadocpersonales;
	private String necesidad;
	private String inicioplazo;
	private String finplazo;
	private String funcionespecifica;
	private String resultadoesperado;
	private String educacionexperiencia;
	private String condiciones;
	private java.util.Date iniciovigencia;
	private java.util.Date finvigencia;


	public HrRequerimientoobservacion() {
		pk = new HrRequerimientoobservacionPk();
	}

	public HrRequerimientoobservacionPk getPk() {
		return pk;
	}

	public void setPk(HrRequerimientoobservacionPk pk) {
		this.pk = pk;
	}
	public String getAdjuntainformes() {
		return adjuntainformes;
	}

	public void setAdjuntainformes(String adjuntainformes) {
		this.adjuntainformes = adjuntainformes;
	}
	public String getAdjuntadocpersonales() {
		return adjuntadocpersonales;
	}

	public void setAdjuntadocpersonales(String adjuntadocpersonales) {
		this.adjuntadocpersonales = adjuntadocpersonales;
	}
	public String getNecesidad() {
		return necesidad;
	}

	public void setNecesidad(String necesidad) {
		this.necesidad = necesidad;
	}
	public String getInicioplazo() {
		return inicioplazo;
	}

	public void setInicioplazo(String inicioplazo) {
		this.inicioplazo = inicioplazo;
	}
	public String getFinplazo() {
		return finplazo;
	}

	public void setFinplazo(String finplazo) {
		this.finplazo = finplazo;
	}
	public String getFuncionespecifica() {
		return funcionespecifica;
	}

	public void setFuncionespecifica(String funcionespecifica) {
		this.funcionespecifica = funcionespecifica;
	}
	public String getResultadoesperado() {
		return resultadoesperado;
	}

	public void setResultadoesperado(String resultadoesperado) {
		this.resultadoesperado = resultadoesperado;
	}
	public String getEducacionexperiencia() {
		return educacionexperiencia;
	}

	public void setEducacionexperiencia(String educacionexperiencia) {
		this.educacionexperiencia = educacionexperiencia;
	}
	public String getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}
	public java.util.Date getIniciovigencia() {
		return iniciovigencia;
	}

	public void setIniciovigencia(java.util.Date iniciovigencia) {
		this.iniciovigencia = iniciovigencia;
	}
	public java.util.Date getFinvigencia() {
		return finvigencia;
	}

	public void setFinvigencia(java.util.Date finvigencia) {
		this.finvigencia = finvigencia;
	}

}
