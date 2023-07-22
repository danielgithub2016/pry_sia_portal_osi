package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrClasificadorcargo
*/
public class HrClasificadorcargo extends DominioGenerico implements java.io.Serializable{

	private HrClasificadorcargoPk pk;
	private String descripcionlocal;
	private String descripcionextranjera;
	private String estado;
	private Integer orden;


	public HrClasificadorcargo() {
		pk = new HrClasificadorcargoPk();
	}

	public HrClasificadorcargoPk getPk() {
		return pk;
	}

	public void setPk(HrClasificadorcargoPk pk) {
		this.pk = pk;
	}
	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}
	public String getDescripcionextranjera() {
		return descripcionextranjera;
	}

	public void setDescripcionextranjera(String descripcionextranjera) {
		this.descripcionextranjera = descripcionextranjera;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

}
