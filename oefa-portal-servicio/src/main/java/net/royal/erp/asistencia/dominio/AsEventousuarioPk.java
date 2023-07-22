package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsEventousuario
 */
public class AsEventousuarioPk implements java.io.Serializable {

	private Integer idevento;
	private String userid;

	public Integer getIdevento() {
		return idevento;
	}

	public void setIdevento(Integer idevento) {
		this.idevento = idevento;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
