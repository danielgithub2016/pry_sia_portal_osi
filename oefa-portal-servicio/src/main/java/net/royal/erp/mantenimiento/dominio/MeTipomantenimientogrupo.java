package net.royal.erp.mantenimiento.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder mantenimiento.MeTipomantenimientogrupo
*/
public class MeTipomantenimientogrupo extends DominioGenerico implements java.io.Serializable{

	private MeTipomantenimientogrupoPk pk;
	private String descripcionlocal;
	private String descripcioningles;
	private String estado;


	public MeTipomantenimientogrupo() {
		pk = new MeTipomantenimientogrupoPk();
	}

	public MeTipomantenimientogrupoPk getPk() {
		return pk;
	}

	public void setPk(MeTipomantenimientogrupoPk pk) {
		this.pk = pk;
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
