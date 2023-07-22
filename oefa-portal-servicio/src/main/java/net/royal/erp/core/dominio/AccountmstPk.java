package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Accountmst
*/
public class AccountmstPk implements java.io.Serializable{

	private String account;

	public AccountmstPk(){		
	}
	public AccountmstPk(String account){	
		this.account=account;
	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
