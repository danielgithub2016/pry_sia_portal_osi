package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SySession
*/
public class SySessionPk implements java.io.Serializable{

	private String usuario;
	private Integer audsid;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Integer getAudsid() {
		return audsid;
	}

	public void setAudsid(Integer audsid) {
		this.audsid = audsid;
	}

}
