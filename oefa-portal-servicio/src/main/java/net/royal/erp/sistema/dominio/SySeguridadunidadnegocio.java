package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SySeguridadunidadnegocio
*/
public class SySeguridadunidadnegocio extends DominioGenerico implements java.io.Serializable{

	private SySeguridadunidadnegocioPk pk;
	private String codigo01;
	private String codigo02;
	private String codigo03;


	public SySeguridadunidadnegocio() {
		pk = new SySeguridadunidadnegocioPk();
	}

	public SySeguridadunidadnegocioPk getPk() {
		return pk;
	}

	public void setPk(SySeguridadunidadnegocioPk pk) {
		this.pk = pk;
	}
	public String getCodigo01() {
		return codigo01;
	}

	public void setCodigo01(String codigo01) {
		this.codigo01 = codigo01;
	}
	public String getCodigo02() {
		return codigo02;
	}

	public void setCodigo02(String codigo02) {
		this.codigo02 = codigo02;
	}
	public String getCodigo03() {
		return codigo03;
	}

	public void setCodigo03(String codigo03) {
		this.codigo03 = codigo03;
	}

}
