package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestoformacion
*/
public class HrPuestoformacion extends DominioGenerico implements java.io.Serializable{

	private HrPuestoformacionPk pk;
	private String nivelacademico;
	private String area;
	private String estado;
	private String profesion;

	private String auxNivelAcademico;
	private String auxFuncion;
	
	public HrPuestoformacion() {
		pk = new HrPuestoformacionPk();
	}

	public HrPuestoformacionPk getPk() {
		return pk;
	}

	public void setPk(HrPuestoformacionPk pk) {
		this.pk = pk;
	}
	public String getNivelacademico() {
		return nivelacademico;
	}

	public void setNivelacademico(String nivelacademico) {
		this.nivelacademico = nivelacademico;
	}
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getAuxNivelAcademico() {
		return auxNivelAcademico;
	}

	public void setAuxNivelAcademico(String auxNivelAcademico) {
		this.auxNivelAcademico = auxNivelAcademico;
	}

	public String getAuxFuncion() {
		return auxFuncion;
	}

	public void setAuxFuncion(String auxFuncion) {
		this.auxFuncion = auxFuncion;
	}

}
