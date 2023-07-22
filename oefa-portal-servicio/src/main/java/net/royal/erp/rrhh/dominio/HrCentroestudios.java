package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrCentroestudios
*/
public class HrCentroestudios extends DominioGenerico implements java.io.Serializable{

	private HrCentroestudiosPk pk;
	private String descripcion;
	private String unidadreplicacion;
	private String lugar;
	private String pais;
	private Integer codigopersona;
	private String ruc;
	private String telefono;
	private String correoelectronico;
	private String fax;
	private String titulorepresentantecentro;
	private String representantecentro;
	private String tipodocrepresentantecentro;
	private String documentorepresentantecentro;
	private String representante;
	private String representantedoc;
	private String cargorepresentantecentro;


	public HrCentroestudios() {
		pk = new HrCentroestudiosPk();
	}

	public HrCentroestudiosPk getPk() {
		return pk;
	}

	public void setPk(HrCentroestudiosPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}
	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	public Integer getCodigopersona() {
		return codigopersona;
	}

	public void setCodigopersona(Integer codigopersona) {
		this.codigopersona = codigopersona;
	}
	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreoelectronico() {
		return correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getTitulorepresentantecentro() {
		return titulorepresentantecentro;
	}

	public void setTitulorepresentantecentro(String titulorepresentantecentro) {
		this.titulorepresentantecentro = titulorepresentantecentro;
	}
	public String getRepresentantecentro() {
		return representantecentro;
	}

	public void setRepresentantecentro(String representantecentro) {
		this.representantecentro = representantecentro;
	}
	public String getTipodocrepresentantecentro() {
		return tipodocrepresentantecentro;
	}

	public void setTipodocrepresentantecentro(String tipodocrepresentantecentro) {
		this.tipodocrepresentantecentro = tipodocrepresentantecentro;
	}
	public String getDocumentorepresentantecentro() {
		return documentorepresentantecentro;
	}

	public void setDocumentorepresentantecentro(String documentorepresentantecentro) {
		this.documentorepresentantecentro = documentorepresentantecentro;
	}
	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}
	public String getRepresentantedoc() {
		return representantedoc;
	}

	public void setRepresentantedoc(String representantedoc) {
		this.representantedoc = representantedoc;
	}
	public String getCargorepresentantecentro() {
		return cargorepresentantecentro;
	}

	public void setCargorepresentantecentro(String cargorepresentantecentro) {
		this.cargorepresentantecentro = cargorepresentantecentro;
	}

}
