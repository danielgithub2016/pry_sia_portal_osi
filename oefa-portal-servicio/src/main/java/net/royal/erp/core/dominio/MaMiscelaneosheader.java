package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.MaMiscelaneosheader
*/
public class MaMiscelaneosheader extends DominioGenerico implements java.io.Serializable{

	private MaMiscelaneosheaderPk pk;
	private String descripcionlocal;
	private String descripcionextranjera;
	private String estado;


	public MaMiscelaneosheader() {
		pk = new MaMiscelaneosheaderPk();
	}

	public MaMiscelaneosheaderPk getPk() {
		return pk;
	}

	public void setPk(MaMiscelaneosheaderPk pk) {
		this.pk = pk;
	}
	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}
	public String getDescripcionextranjera() {
		return descripcionextranjera;
	}

	public void setDescripcionextranjera(String descripcionextranjera) {
		this.descripcionextranjera = descripcionextranjera;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
