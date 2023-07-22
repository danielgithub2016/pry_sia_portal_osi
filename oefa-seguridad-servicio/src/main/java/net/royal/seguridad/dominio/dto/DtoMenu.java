package net.royal.seguridad.dominio.dto;

import java.io.Serializable;
import java.util.List;

import net.royal.framework.web.core.UValidador;

public class DtoMenu implements Serializable{

	private String aplicacionCodigo;
	private String grupo;
	private String concepto;
	private String codigoCompleto;

	private String descripcion;
	private String objeto;

	private String conceptoPadre;
	private String imagen;
	private String estilo;
	private String conceptoRelacion;
	

	private String webpage;

	public String getConceptoRelacion() {
		return conceptoRelacion;
	}

	public void setConceptoRelacion(String conceptoRelacion) {
		this.conceptoRelacion = conceptoRelacion;
	}

	List<DtoMenu> hijos;

	public String getAplicacionCodigo() {
		return aplicacionCodigo;
	}

	public void setAplicacionCodigo(String aplicacionCodigo) {
		this.aplicacionCodigo = aplicacionCodigo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObjeto() {
		return objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	public String getConceptoPadre() {
		return conceptoPadre;
	}

	public void setConceptoPadre(String conceptoPadre) {
		this.conceptoPadre = conceptoPadre;
	}

	public List<DtoMenu> getHijos() {
		return hijos;
	}

	public void setHijos(List<DtoMenu> hijos) {
		this.hijos = hijos;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public String getCodigoCompleto() {
		String retorno = "";
		if (!UValidador.estaVacio(this.aplicacionCodigo))
			retorno = this.aplicacionCodigo;
		if (!UValidador.estaVacio(this.grupo))
			retorno = retorno + this.grupo;
		if (!UValidador.estaVacio(this.concepto))
			retorno = retorno + this.concepto;
		return retorno;
	}

	public void setCodigoCompleto(String codigoCompleto) {
		this.codigoCompleto = codigoCompleto;
	}

	public String getWebpage() {
		return webpage;
	}

	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}
	
	

}
