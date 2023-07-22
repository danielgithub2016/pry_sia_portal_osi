package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestosubordinado
*/
public class HrPuestosubordinado extends DominioGenerico implements java.io.Serializable{

	private HrPuestosubordinadoPk pk;
	private String estado;
	private Integer cantidad;
	
	private String auxPuestoDescripcion;

	public HrPuestosubordinado() {
		pk = new HrPuestosubordinadoPk();
	}

	public HrPuestosubordinadoPk getPk() {
		return pk;
	}

	public void setPk(HrPuestosubordinadoPk pk) {
		this.pk = pk;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getAuxPuestoDescripcion() {
		return auxPuestoDescripcion;
	}

	public void setAuxPuestoDescripcion(String auxPuestoDescripcion) {
		this.auxPuestoDescripcion = auxPuestoDescripcion;
	}

}
