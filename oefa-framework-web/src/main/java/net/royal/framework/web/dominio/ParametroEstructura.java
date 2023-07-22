package net.royal.framework.web.dominio;

import java.util.List;

public class ParametroEstructura {

	private String raizTipo;
	private String raizCodigo;
	private String raizNombre;
	private String raizDescripcion;

	private String nodoTipo;
	private String nodoCodigo;
	private String nodoNombre;
	private String nodoDescripcion;

	private List listaNodos;

	public String getRaizTipo() {
		return raizTipo;
	}

	public void setRaizTipo(String raizTipo) {
		this.raizTipo = raizTipo;
	}

	public String getRaizCodigo() {
		return raizCodigo;
	}

	public void setRaizCodigo(String raizCodigo) {
		this.raizCodigo = raizCodigo;
	}

	public String getRaizNombre() {
		return raizNombre;
	}

	public void setRaizNombre(String raizNombre) {
		this.raizNombre = raizNombre;
	}

	public String getRaizDescripcion() {
		return raizDescripcion;
	}

	public void setRaizDescripcion(String raizDescripcion) {
		this.raizDescripcion = raizDescripcion;
	}

	public String getNodoTipo() {
		return nodoTipo;
	}

	public void setNodoTipo(String nodoTipo) {
		this.nodoTipo = nodoTipo;
	}

	public String getNodoCodigo() {
		return nodoCodigo;
	}

	public void setNodoCodigo(String nodoCodigo) {
		this.nodoCodigo = nodoCodigo;
	}

	public String getNodoNombre() {
		return nodoNombre;
	}

	public void setNodoNombre(String nodoNombre) {
		this.nodoNombre = nodoNombre;
	}

	public String getNodoDescripcion() {
		return nodoDescripcion;
	}

	public void setNodoDescripcion(String nodoDescripcion) {
		this.nodoDescripcion = nodoDescripcion;
	}

	public List getListaNodos() {
		return listaNodos;
	}

	public void setListaNodos(List listaNodos) {
		this.listaNodos = listaNodos;
	}

}
