package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrSeguridad
*/
public class HrSeguridadPk implements java.io.Serializable{

	private String usuario;
	private String conceptoseguridad;
	private Integer secuencia;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getConceptoseguridad() {
		return conceptoseguridad;
	}

	public void setConceptoseguridad(String conceptoseguridad) {
		this.conceptoseguridad = conceptoseguridad;
	}
	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

}
