package net.royal.erp.mantenimiento.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder mantenimiento.MeTipomantenimientogrupo
*/
public class DtoMeTipomantenimientogrupo implements java.io.Serializable{

	private String tipomantenimientogrupo;
	private String descripcionlocal;
	private String descripcioningles;
	private String estado;

	public String getTipomantenimientogrupo() {
		return tipomantenimientogrupo;
	}

	public void setTipomantenimientogrupo(String tipomantenimientogrupo) {
		this.tipomantenimientogrupo = tipomantenimientogrupo;
	}
	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}
	public String getDescripcioningles() {
		return descripcioningles;
	}

	public void setDescripcioningles(String descripcioningles) {
		this.descripcioningles = descripcioningles;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
