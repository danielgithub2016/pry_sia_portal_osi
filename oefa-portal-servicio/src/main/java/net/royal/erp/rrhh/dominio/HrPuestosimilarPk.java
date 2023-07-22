package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestosimilar
*/
public class HrPuestosimilarPk implements java.io.Serializable{

	private Integer codigopuesto;
	private Integer codigopuestosimilar;
	private Integer secuencia;

	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}
	public Integer getCodigopuestosimilar() {
		return codigopuestosimilar;
	}

	public void setCodigopuestosimilar(Integer codigopuestosimilar) {
		this.codigopuestosimilar = codigopuestosimilar;
	}
	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

}
