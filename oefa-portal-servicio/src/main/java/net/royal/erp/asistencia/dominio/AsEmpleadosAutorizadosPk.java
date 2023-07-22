package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsEmpleadosAutorizados
 */
public class AsEmpleadosAutorizadosPk implements java.io.Serializable {

	private Integer sid;
	private String usuario;
	private Integer empleado;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

}
