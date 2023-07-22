package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Tipodocumentocxp
*/
public class TipodocumentocxpPk implements java.io.Serializable{

	private String tipodocumento;
	
	public TipodocumentocxpPk(){}
	public TipodocumentocxpPk(String tipodocumento){
		this.tipodocumento=tipodocumento;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

}
