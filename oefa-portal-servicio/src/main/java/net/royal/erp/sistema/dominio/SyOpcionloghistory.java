package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SyOpcionloghistory
*/
public class SyOpcionloghistory extends DominioGenerico implements java.io.Serializable{

	private SyOpcionloghistoryPk pk;
	private String aplicacioncodigo;
	private String objetocodigo;
	private String objetoventana;
	private String descripcionventana;
	private String direccionip;
	private String dispositivopc;


	public SyOpcionloghistory() {
		pk = new SyOpcionloghistoryPk();
	}

	public SyOpcionloghistoryPk getPk() {
		return pk;
	}

	public void setPk(SyOpcionloghistoryPk pk) {
		this.pk = pk;
	}
	public String getAplicacioncodigo() {
		return aplicacioncodigo;
	}

	public void setAplicacioncodigo(String aplicacioncodigo) {
		this.aplicacioncodigo = aplicacioncodigo;
	}
	public String getObjetocodigo() {
		return objetocodigo;
	}

	public void setObjetocodigo(String objetocodigo) {
		this.objetocodigo = objetocodigo;
	}
	public String getObjetoventana() {
		return objetoventana;
	}

	public void setObjetoventana(String objetoventana) {
		this.objetoventana = objetoventana;
	}
	public String getDescripcionventana() {
		return descripcionventana;
	}

	public void setDescripcionventana(String descripcionventana) {
		this.descripcionventana = descripcionventana;
	}
	public String getDireccionip() {
		return direccionip;
	}

	public void setDireccionip(String direccionip) {
		this.direccionip = direccionip;
	}
	public String getDispositivopc() {
		return dispositivopc;
	}

	public void setDispositivopc(String dispositivopc) {
		this.dispositivopc = dispositivopc;
	}

}
