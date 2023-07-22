package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuestasujeto
*/
public class HrEncuestasujetoPk implements java.io.Serializable{

	private Integer secuencia;
	private Integer sujeto;
	private Integer pregunta;
	private String companiasocio;
	
	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

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
}
