package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SySeguridadmoduloopcion
*/
public class SySeguridadmoduloopcionPk implements java.io.Serializable{

	private String aplicacioncodigo;
	private String modulocodigo;
	private Integer secuencia;

	public String getAplicacioncodigo() {
		return aplicacioncodigo;
	}

	public void setAplicacioncodigo(String aplicacioncodigo) {
		this.aplicacioncodigo = aplicacioncodigo;
	}
	public String getModulocodigo() {
		return modulocodigo;
	}

	public void setModulocodigo(String modulocodigo) {
		this.modulocodigo = modulocodigo;
	}
	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

}
