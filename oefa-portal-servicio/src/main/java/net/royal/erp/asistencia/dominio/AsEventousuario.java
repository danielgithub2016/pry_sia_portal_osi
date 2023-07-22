package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsEventousuario
 */
public class AsEventousuario extends DominioGenerico implements
		java.io.Serializable {

	private AsEventousuarioPk pk;
	private String autorizadopor;
	private java.util.Date fechaautorizacion;
	private String estado;

	public AsEventousuario() {
		pk = new AsEventousuarioPk();
	}

	public AsEventousuarioPk getPk() {
		return pk;
	}

	public void setPk(AsEventousuarioPk pk) {
		this.pk = pk;
	}

	public String getAutorizadopor() {
		return autorizadopor;
	}

	public void setAutorizadopor(String autorizadopor) {
		this.autorizadopor = autorizadopor;
	}

	public java.util.Date getFechaautorizacion() {
		return fechaautorizacion;
	}

	public void setFechaautorizacion(java.util.Date fechaautorizacion) {
		this.fechaautorizacion = fechaautorizacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
