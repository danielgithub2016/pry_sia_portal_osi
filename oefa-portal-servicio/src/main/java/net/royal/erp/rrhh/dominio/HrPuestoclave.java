package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestoclave
*/
public class HrPuestoclave extends DominioGenerico implements java.io.Serializable{

	private HrPuestoclavePk pk;
	private String estadopuestoclave;
	private String sustento;
	private String usuarioaprobador;
	private String usuariocreador;


	public HrPuestoclave() {
		pk = new HrPuestoclavePk();
	}

	public HrPuestoclavePk getPk() {
		return pk;
	}

	public void setPk(HrPuestoclavePk pk) {
		this.pk = pk;
	}
	public String getEstadopuestoclave() {
		return estadopuestoclave;
	}

	public void setEstadopuestoclave(String estadopuestoclave) {
		this.estadopuestoclave = estadopuestoclave;
	}
	public String getSustento() {
		return sustento;
	}

	public void setSustento(String sustento) {
		this.sustento = sustento;
	}
	public String getUsuarioaprobador() {
		return usuarioaprobador;
	}

	public void setUsuarioaprobador(String usuarioaprobador) {
		this.usuarioaprobador = usuarioaprobador;
	}
	public String getUsuariocreador() {
		return usuariocreador;
	}

	public void setUsuariocreador(String usuariocreador) {
		this.usuariocreador = usuariocreador;
	}

}
