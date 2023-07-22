package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.MaPersonagrupo
*/
public class MaPersonagrupo extends DominioGenerico implements java.io.Serializable{

	private MaPersonagrupoPk pk;
	private String descripcionlocal;
	private String descripcioningles;
	private String estado;
	private String codigointerno;
	private String generarnumeracionflag;


	public MaPersonagrupo() {
		pk = new MaPersonagrupoPk();
	}

	public MaPersonagrupoPk getPk() {
		return pk;
	}

	public void setPk(MaPersonagrupoPk pk) {
		this.pk = pk;
	}
	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}
	public String getDescripcioningles() {
		return descripcioningles;
	}

	public void setDescripcioningles(String descripcioningles) {
		this.descripcioningles = descripcioningles;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCodigointerno() {
		return codigointerno;
	}

	public void setCodigointerno(String codigointerno) {
		this.codigointerno = codigointerno;
	}
	public String getGenerarnumeracionflag() {
		return generarnumeracionflag;
	}

	public void setGenerarnumeracionflag(String generarnumeracionflag) {
		this.generarnumeracionflag = generarnumeracionflag;
	}

}
