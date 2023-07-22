package net.royal.erp.documento.dominio.dto;

import java.util.List;

public class DtoFirmaContenedor {
	private String urlAplicacion;
	private String urlArchivo;
	private String proceso;
	private String rutaArchivo;
	private List<DtoFirmaElemento> listaElementosFirmar;

	/**
	 * @return the urlAplicacion
	 */
	public String getUrlAplicacion() {
		return urlAplicacion;
	}

	/**
	 * @param urlAplicacion
	 *            the urlAplicacion to set
	 */
	public void setUrlAplicacion(String urlAplicacion) {
		this.urlAplicacion = urlAplicacion;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	public List<DtoFirmaElemento> getListaElementosFirmar() {
		return listaElementosFirmar;
	}

	public void setListaElementosFirmar(List<DtoFirmaElemento> listaElementosFirmar) {
		this.listaElementosFirmar = listaElementosFirmar;
	}

	/**
	 * @return the urlArchivo
	 */
	public String getUrlArchivo() {
		return urlArchivo;
	}

	/**
	 * @param urlArchivo
	 *            the urlArchivo to set
	 */
	public void setUrlArchivo(String urlArchivo) {
		this.urlArchivo = urlArchivo;
	}

}
