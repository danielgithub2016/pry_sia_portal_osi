package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuestaplantilla
*/
public class HrEncuestaplantilla extends DominioGenerico implements java.io.Serializable{

	private HrEncuestaplantillaPk pk;
	private String descripcion;
	private String estado;
	private String tipoencuesta;


	public HrEncuestaplantilla() {
		pk = new HrEncuestaplantillaPk();
	}

	public HrEncuestaplantillaPk getPk() {
		return pk;
	}

	public void setPk(HrEncuestaplantillaPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTipoencuesta() {
		return tipoencuesta;
	}

	public void setTipoencuesta(String tipoencuesta) {
		this.tipoencuesta = tipoencuesta;
	}

}
