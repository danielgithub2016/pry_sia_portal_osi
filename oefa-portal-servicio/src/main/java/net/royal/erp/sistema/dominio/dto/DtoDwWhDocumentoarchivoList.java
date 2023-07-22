package net.royal.erp.sistema.dominio.dto;

import java.math.BigDecimal;


/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_wh_documentoarchivo_list
 */
public class DtoDwWhDocumentoarchivoList implements java.io.Serializable {

	private String companiasocio;
	private String tipodocumento;
	private String numerodocumento;
	private BigDecimal linea;
	private BigDecimal secuencia;
	private String archivo;
	private String comentario;
	private byte[] archivodata;
	private String extension;
	
	private String ruta;
	private Boolean esInformeFinal;
	
	/**
	 * @return the companiasocio
	 */
	public String getCompaniasocio() {
		return companiasocio;
	}
	/**
	 * @param companiasocio the companiasocio to set
	 */
	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}
	/**
	 * @return the tipodocumento
	 */
	public String getTipodocumento() {
		return tipodocumento;
	}
	/**
	 * @param tipodocumento the tipodocumento to set
	 */
	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	/**
	 * @return the numerodocumento
	 */
	public String getNumerodocumento() {
		return numerodocumento;
	}
	/**
	 * @param numerodocumento the numerodocumento to set
	 */
	public void setNumerodocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}
	/**
	 * @return the linea
	 */
	public BigDecimal getLinea() {
		return linea;
	}
	/**
	 * @param linea the linea to set
	 */
	public void setLinea(BigDecimal linea) {
		this.linea = linea;
	}
	/**
	 * @return the secuencia
	 */
	public BigDecimal getSecuencia() {
		return secuencia;
	}
	/**
	 * @param secuencia the secuencia to set
	 */
	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}
	/**
	 * @return the archivo
	 */
	public String getArchivo() {
		return archivo;
	}
	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}
	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}
	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public byte[] getArchivodata() {
		return archivodata;
	}
	public void setArchivodata(byte[] archivodata) {
		this.archivodata = archivodata;
	}
	public Boolean getEsInformeFinal() {
		return esInformeFinal;
	}
	public void setEsInformeFinal(Boolean esInformeFinal) {
		this.esInformeFinal = esInformeFinal;
	}
	
}
