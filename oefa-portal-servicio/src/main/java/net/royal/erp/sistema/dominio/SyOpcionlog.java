package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SyOpcionlog
*/
public class SyOpcionlog extends DominioGenerico implements java.io.Serializable{

	private SyOpcionlogPk pk;
	private String objetoventana;
	private String descripcionventana;
	private String descripcionlocal;
	private String objetotipo;
	private String visibleflag;
	private String enabledflag;
	private String grupo01;
	private String grupo02;
	private String grupo03;
	private String grupo04;
	private String grupo05;
	private String estado;


	public SyOpcionlog() {
		pk = new SyOpcionlogPk();
	}

	public SyOpcionlogPk getPk() {
		return pk;
	}

	public void setPk(SyOpcionlogPk pk) {
		this.pk = pk;
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
	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}
	public String getObjetotipo() {
		return objetotipo;
	}

	public void setObjetotipo(String objetotipo) {
		this.objetotipo = objetotipo;
	}
	public String getVisibleflag() {
		return visibleflag;
	}

	public void setVisibleflag(String visibleflag) {
		this.visibleflag = visibleflag;
	}
	public String getEnabledflag() {
		return enabledflag;
	}

	public void setEnabledflag(String enabledflag) {
		this.enabledflag = enabledflag;
	}
	public String getGrupo01() {
		return grupo01;
	}

	public void setGrupo01(String grupo01) {
		this.grupo01 = grupo01;
	}
	public String getGrupo02() {
		return grupo02;
	}

	public void setGrupo02(String grupo02) {
		this.grupo02 = grupo02;
	}
	public String getGrupo03() {
		return grupo03;
	}

	public void setGrupo03(String grupo03) {
		this.grupo03 = grupo03;
	}
	public String getGrupo04() {
		return grupo04;
	}

	public void setGrupo04(String grupo04) {
		this.grupo04 = grupo04;
	}
	public String getGrupo05() {
		return grupo05;
	}

	public void setGrupo05(String grupo05) {
		this.grupo05 = grupo05;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
