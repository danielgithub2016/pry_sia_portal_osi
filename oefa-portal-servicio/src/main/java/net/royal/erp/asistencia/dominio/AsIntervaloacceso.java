package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsIntervaloacceso
 */
public class AsIntervaloacceso extends DominioGenerico implements
		java.io.Serializable {

	private AsIntervaloaccesoPk pk;
	private String descripcion;
	private String abreviatura;
	private java.util.Date duracion;
	private String estado;

	public AsIntervaloacceso() {
		pk = new AsIntervaloaccesoPk();
	}

	public AsIntervaloaccesoPk getPk() {
		return pk;
	}

	public void setPk(AsIntervaloaccesoPk pk) {
		this.pk = pk;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public java.util.Date getDuracion() {
		return duracion;
	}

	public void setDuracion(java.util.Date duracion) {
		this.duracion = duracion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
