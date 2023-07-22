package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Afemst
 */
public class AfemstPk implements java.io.Serializable {

	private String afe;

	public AfemstPk() {

	}

	public AfemstPk(String afe) {
		this.afe = afe;

	}

	public String getAfe() {
		return afe;
	}

	public void setAfe(String afe) {
		this.afe = afe;
	}

}
