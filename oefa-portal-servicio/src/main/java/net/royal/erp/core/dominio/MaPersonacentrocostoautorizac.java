package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.MaPersonacentrocostoautorizac
*/
public class MaPersonacentrocostoautorizac extends DominioGenerico implements java.io.Serializable{

	private MaPersonacentrocostoautorizacPk pk;
	private String preparacionflag;
	private String revisionflag;
	private String aprobacionflag;
	private String estado;


	public MaPersonacentrocostoautorizac() {
		pk = new MaPersonacentrocostoautorizacPk();
	}

	public MaPersonacentrocostoautorizacPk getPk() {
		return pk;
	}

	public void setPk(MaPersonacentrocostoautorizacPk pk) {
		this.pk = pk;
	}
	public String getPreparacionflag() {
		return preparacionflag;
	}

	public void setPreparacionflag(String preparacionflag) {
		this.preparacionflag = preparacionflag;
	}
	public String getRevisionflag() {
		return revisionflag;
	}

	public void setRevisionflag(String revisionflag) {
		this.revisionflag = revisionflag;
	}
	public String getAprobacionflag() {
		return aprobacionflag;
	}

	public void setAprobacionflag(String aprobacionflag) {
		this.aprobacionflag = aprobacionflag;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
