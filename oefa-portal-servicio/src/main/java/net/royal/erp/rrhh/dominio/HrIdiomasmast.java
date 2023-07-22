package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrIdiomasmast
*/
public class HrIdiomasmast extends DominioGenerico implements java.io.Serializable{

	private HrIdiomasmastPk pk;
	private String descripcionlocal;
	private String descripcionextranjera;
	private String estado;


	public HrIdiomasmast() {
		pk = new HrIdiomasmastPk();
	}

	public HrIdiomasmastPk getPk() {
		return pk;
	}

	public void setPk(HrIdiomasmastPk pk) {
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

}
