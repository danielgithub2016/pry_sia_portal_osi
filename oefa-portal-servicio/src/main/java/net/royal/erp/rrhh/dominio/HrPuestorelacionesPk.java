package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestorelaciones
*/
public class HrPuestorelacionesPk implements java.io.Serializable{

	private Integer codigopuesto;
	private Integer secuencia;
	private String tiporelacion;

	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}
	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}
	public String getTiporelacion() {
		return tiporelacion;
	}

	public void setTiporelacion(String tiporelacion) {
		this.tiporelacion = tiporelacion;
	}

}
