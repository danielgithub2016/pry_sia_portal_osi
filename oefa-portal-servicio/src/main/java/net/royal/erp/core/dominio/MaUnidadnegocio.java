package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.MaUnidadnegocio
*/
public class MaUnidadnegocio extends DominioGenerico implements java.io.Serializable{

	private MaUnidadnegocioPk pk;
	private String zona;
	private String descripcionlocal;
	private String descripcioningles;
	private String direccion;
	private String telefonos;
	private String registropatronalplanilla;
	private String estado;
	private String representante;
	private String representantedocumento;
	private String representantecargo;
	private String representante2;
	private String representantedocumento2;
	private String representantecargo2;
	private String representante3;
	private String representantedocumento3;
	private String representantecargo3;
	private String companiasocio;
	private String ledger;
	private Integer persona;


	public MaUnidadnegocio() {
		pk = new MaUnidadnegocioPk();
	}

	public MaUnidadnegocioPk getPk() {
		return pk;
	}

	public void setPk(MaUnidadnegocioPk pk) {
		this.pk = pk;
	}
	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
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
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}
	public String getRegistropatronalplanilla() {
		return registropatronalplanilla;
	}

	public void setRegistropatronalplanilla(String registropatronalplanilla) {
		this.registropatronalplanilla = registropatronalplanilla;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}
	public String getRepresentantedocumento() {
		return representantedocumento;
	}

	public void setRepresentantedocumento(String representantedocumento) {
		this.representantedocumento = representantedocumento;
	}
	public String getRepresentantecargo() {
		return representantecargo;
	}

	public void setRepresentantecargo(String representantecargo) {
		this.representantecargo = representantecargo;
	}
	public String getRepresentante2() {
		return representante2;
	}

	public void setRepresentante2(String representante2) {
		this.representante2 = representante2;
	}
	public String getRepresentantedocumento2() {
		return representantedocumento2;
	}

	public void setRepresentantedocumento2(String representantedocumento2) {
		this.representantedocumento2 = representantedocumento2;
	}
	public String getRepresentantecargo2() {
		return representantecargo2;
	}

	public void setRepresentantecargo2(String representantecargo2) {
		this.representantecargo2 = representantecargo2;
	}
	public String getRepresentante3() {
		return representante3;
	}

	public void setRepresentante3(String representante3) {
		this.representante3 = representante3;
	}
	public String getRepresentantedocumento3() {
		return representantedocumento3;
	}

	public void setRepresentantedocumento3(String representantedocumento3) {
		this.representantedocumento3 = representantedocumento3;
	}
	public String getRepresentantecargo3() {
		return representantecargo3;
	}

	public void setRepresentantecargo3(String representantecargo3) {
		this.representantecargo3 = representantecargo3;
	}
	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}
	public String getLedger() {
		return ledger;
	}

	public void setLedger(String ledger) {
		this.ledger = ledger;
	}
	public Integer getPersona() {
		return persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}

}
