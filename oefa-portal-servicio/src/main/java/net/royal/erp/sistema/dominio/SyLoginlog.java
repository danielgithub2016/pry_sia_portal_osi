package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SyLoginlog
*/
public class SyLoginlog extends DominioGenerico implements java.io.Serializable{

	private SyLoginlogPk pk;
	private String aplicacioncodigo;
	private String estacion;
	private String estado;


	public SyLoginlog() {
		pk = new SyLoginlogPk();
	}

	public SyLoginlogPk getPk() {
		return pk;
	}

	public void setPk(SyLoginlogPk pk) {
		this.pk = pk;
	}
	public String getAplicacioncodigo() {
		return aplicacioncodigo;
	}

	public void setAplicacioncodigo(String aplicacioncodigo) {
		this.aplicacioncodigo = aplicacioncodigo;
	}
	public String getEstacion() {
		return estacion;
	}

	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
