package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Companiamast
*/
public class CompaniamastPk implements java.io.Serializable{

	private String companiacodigo;
	
	public CompaniamastPk(){}
	public CompaniamastPk(String companiacodigo){
		this.companiacodigo=companiacodigo;
	}

	public String getCompaniacodigo() {
		return companiacodigo;
	}

	public void setCompaniacodigo(String companiacodigo) {
		this.companiacodigo = companiacodigo;
	}

}
