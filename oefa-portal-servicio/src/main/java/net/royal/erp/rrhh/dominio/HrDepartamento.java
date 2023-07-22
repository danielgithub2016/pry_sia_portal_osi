package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrDepartamento
*/
public class HrDepartamento extends DominioGenerico implements java.io.Serializable{

	private HrDepartamentoPk pk;
	private String descripcion;
	private String abreviacion;
	private Integer orden;
	private String flagriesgo;
	private String telefono1;
	private String telefono2;
	private String anexo1;
	private String anexo2;
	private String anexo3;
	private String estado;


	public HrDepartamento() {
		pk = new HrDepartamentoPk();
	}

	public HrDepartamentoPk getPk() {
		return pk;
	}

	public void setPk(HrDepartamentoPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAbreviacion() {
		return abreviacion;
	}

	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	public String getFlagriesgo() {
		return flagriesgo;
	}

	public void setFlagriesgo(String flagriesgo) {
		this.flagriesgo = flagriesgo;
	}
	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	public String getAnexo1() {
		return anexo1;
	}

	public void setAnexo1(String anexo1) {
		this.anexo1 = anexo1;
	}
	public String getAnexo2() {
		return anexo2;
	}

	public void setAnexo2(String anexo2) {
		this.anexo2 = anexo2;
	}
	public String getAnexo3() {
		return anexo3;
	}

	public void setAnexo3(String anexo3) {
		this.anexo3 = anexo3;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
