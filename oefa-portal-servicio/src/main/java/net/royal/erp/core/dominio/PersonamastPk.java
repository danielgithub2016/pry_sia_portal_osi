package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Personamast
*/
public class PersonamastPk implements java.io.Serializable{

	private Integer persona;

	public PersonamastPk(){}
	public PersonamastPk(Integer persona){
		this.persona=persona;
	}
	
	public Integer getPersona() {
		return persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}

}
