package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Referencefieldvalues
*/
public class Referencefieldvalues extends DominioGenerico implements java.io.Serializable{

	private ReferencefieldvaluesPk pk;
	private String description;


	public Referencefieldvalues() {
		pk = new ReferencefieldvaluesPk();
	}

	public ReferencefieldvaluesPk getPk() {
		return pk;
	}

	public void setPk(ReferencefieldvaluesPk pk) {
		this.pk = pk;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
