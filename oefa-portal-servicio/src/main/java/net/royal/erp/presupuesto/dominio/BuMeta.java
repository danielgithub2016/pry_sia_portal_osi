package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuMeta
*/
public class BuMeta extends DominioGenerico implements java.io.Serializable{

	private BuMetaPk pk;
	private String metaaux;
	private String descripcion;
	private String estado;
	private String ubicacion;
	private String flgdecimal;


	public BuMeta() {
		pk = new BuMetaPk();
	}

	public BuMetaPk getPk() {
		return pk;
	}

	public void setPk(BuMetaPk pk) {
		this.pk = pk;
	}
	public String getMetaaux() {
		return metaaux;
	}

	public void setMetaaux(String metaaux) {
		this.metaaux = metaaux;
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
	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getFlgdecimal() {
		return flgdecimal;
	}

	public void setFlgdecimal(String flgdecimal) {
		this.flgdecimal = flgdecimal;
	}

}
