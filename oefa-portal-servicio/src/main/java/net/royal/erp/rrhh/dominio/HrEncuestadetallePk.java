package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuestadetalle
*/
public class HrEncuestadetallePk implements java.io.Serializable{

	private Integer secuencia;
	private Integer pregunta;

	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}
	public Integer getPregunta() {
		return pregunta;
	}

	public void setPregunta(Integer pregunta) {
		this.pregunta = pregunta;
	}

}
