package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrCtrlentregasplantilla
*/
public class HrCtrlentregasplantilla extends DominioGenerico implements java.io.Serializable{

	private HrCtrlentregasplantillaPk pk;
	private String descripcion;
	private String estado;


	public HrCtrlentregasplantilla() {
		pk = new HrCtrlentregasplantillaPk();
	}

	public HrCtrlentregasplantillaPk getPk() {
		return pk;
	}

	public void setPk(HrCtrlentregasplantillaPk pk) {
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

}
