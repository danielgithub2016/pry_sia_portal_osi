package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestosubordinado
*/
public class HrPuestosubordinadoPk implements java.io.Serializable{

	private Integer codigopuesto;
	private Integer puestosubordinado;

	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}
	public Integer getPuestosubordinado() {
		return puestosubordinado;
	}

	public void setPuestosubordinado(Integer puestosubordinado) {
		this.puestosubordinado = puestosubordinado;
	}

}
