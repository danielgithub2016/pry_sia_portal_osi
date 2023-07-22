package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestoempresaDoc
*/
public class HrPuestoempresaDoc extends DominioGenerico implements java.io.Serializable{

	private HrPuestoempresaDocPk pk;
	private String tipodocumento;
	private String rutadocumento;
	private byte[] ruta;


	public HrPuestoempresaDoc() {
		pk = new HrPuestoempresaDocPk();
	}

	public HrPuestoempresaDocPk getPk() {
		return pk;
	}

	public void setPk(HrPuestoempresaDocPk pk) {
		this.pk = pk;
	}
	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	public String getRutadocumento() {
		return rutadocumento;
	}

	public void setRutadocumento(String rutadocumento) {
		this.rutadocumento = rutadocumento;
	}
	public byte[] getRuta() {
		return ruta;
	}

	public void setRuta(byte[] ruta) {
		this.ruta = ruta;
	}

}
