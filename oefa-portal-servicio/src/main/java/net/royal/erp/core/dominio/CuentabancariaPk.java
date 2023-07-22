package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Cuentabancaria
*/
public class CuentabancariaPk implements java.io.Serializable{

	private String cuentabancaria;
	private String banco;

	public String getCuentabancaria() {
		return cuentabancaria;
	}

	public void setCuentabancaria(String cuentabancaria) {
		this.cuentabancaria = cuentabancaria;
	}
	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

}
