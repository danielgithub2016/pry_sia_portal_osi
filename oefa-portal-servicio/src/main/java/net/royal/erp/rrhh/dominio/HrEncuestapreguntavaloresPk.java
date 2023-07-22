package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuestapreguntavalores
*/
public class HrEncuestapreguntavaloresPk implements java.io.Serializable{

	private Integer pregunta;
	private Integer valor;
	private String tipoencuesta;

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

	/**
	 * @return the tipoencuesta
	 */
	public String getTipoencuesta() {
		return tipoencuesta;
	}

	/**
	 * @param tipoencuesta the tipoencuesta to set
	 */
	public void setTipoencuesta(String tipoencuesta) {
		this.tipoencuesta = tipoencuesta;
	}

}
