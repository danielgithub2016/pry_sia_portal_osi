package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SyLabel
*/
public class SyLabelPk implements java.io.Serializable{

	private String application;
	private String id;

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
