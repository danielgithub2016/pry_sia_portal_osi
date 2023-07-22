package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Primemst
*/
public class PrimemstPk implements java.io.Serializable{

	private String prime;
	private String plancontable;

	public String getPrime() {
		return prime;
	}

	public void setPrime(String prime) {
		this.prime = prime;
	}
	
	public String getPlancontable() {
		return plancontable;
	}

	public void setPlancontable(String plancontable) {
		this.plancontable = plancontable;
	}

}
