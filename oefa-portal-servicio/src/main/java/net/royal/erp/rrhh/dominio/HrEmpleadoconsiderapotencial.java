package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEmpleadoconsiderapotencial
*/
public class HrEmpleadoconsiderapotencial extends DominioGenerico implements java.io.Serializable{

	private HrEmpleadoconsiderapotencialPk pk;
	private String consideracion;
	private String flagconclusion;
	private String comentario;


	public HrEmpleadoconsiderapotencial() {
		pk = new HrEmpleadoconsiderapotencialPk();
	}

	public HrEmpleadoconsiderapotencialPk getPk() {
		return pk;
	}

	public void setPk(HrEmpleadoconsiderapotencialPk pk) {
		this.pk = pk;
	}
	public String getConsideracion() {
		return consideracion;
	}

	public void setConsideracion(String consideracion) {
		this.consideracion = consideracion;
	}
	public String getFlagconclusion() {
		return flagconclusion;
	}

	public void setFlagconclusion(String flagconclusion) {
		this.flagconclusion = flagconclusion;
	}
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
