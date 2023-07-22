package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestoreporta
*/
public class HrPuestoreporta extends DominioGenerico implements java.io.Serializable{

	private HrPuestoreportaPk pk;
	private String estado;
	private String descripcionreporta;


	public HrPuestoreporta() {
		pk = new HrPuestoreportaPk();
	}

	public HrPuestoreportaPk getPk() {
		return pk;
	}

	public void setPk(HrPuestoreportaPk pk) {
		this.pk = pk;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcionreporta() {
		return descripcionreporta;
	}

	public void setDescripcionreporta(String descripcionreporta) {
		this.descripcionreporta = descripcionreporta;
	}

}
