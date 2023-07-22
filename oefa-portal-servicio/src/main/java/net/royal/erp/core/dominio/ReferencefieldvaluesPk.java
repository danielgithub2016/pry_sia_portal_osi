package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Referencefieldvalues
*/
public class ReferencefieldvaluesPk implements java.io.Serializable{

	private String referencefield;
	private String referencevalue;

	public String getReferencefield() {
		return referencefield;
	}

	public void setReferencefield(String referencefield) {
		this.referencefield = referencefield;
	}
	public String getReferencevalue() {
		return referencevalue;
	}

	public void setReferencevalue(String referencevalue) {
		this.referencevalue = referencevalue;
	}

}
