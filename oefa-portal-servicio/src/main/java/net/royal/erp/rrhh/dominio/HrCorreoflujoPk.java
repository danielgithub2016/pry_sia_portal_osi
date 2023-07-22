package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrCorreoflujo
*/
public class HrCorreoflujoPk implements java.io.Serializable{

	private Integer proceso;
	private Integer accion;
	private Integer usuario;
	private String flagmotivo;
	private String flagaccion;

	public Integer getProceso() {
		return proceso;
	}

	public void setProceso(Integer proceso) {
		this.proceso = proceso;
	}
	public Integer getAccion() {
		return accion;
	}

	public void setAccion(Integer accion) {
		this.accion = accion;
	}
	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	public String getFlagmotivo() {
		return flagmotivo;
	}

	public void setFlagmotivo(String flagmotivo) {
		this.flagmotivo = flagmotivo;
	}
	public String getFlagaccion() {
		return flagaccion;
	}

	public void setFlagaccion(String flagaccion) {
		this.flagaccion = flagaccion;
	}

}
