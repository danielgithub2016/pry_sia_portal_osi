package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SyLabel
*/
public class SyLabel extends DominioGenerico implements java.io.Serializable{

	private SyLabelPk pk;
	private String label;


	public SyLabel() {
		pk = new SyLabelPk();
	}

	public SyLabelPk getPk() {
		return pk;
	}

	public void setPk(SyLabelPk pk) {
		this.pk = pk;
	}
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
