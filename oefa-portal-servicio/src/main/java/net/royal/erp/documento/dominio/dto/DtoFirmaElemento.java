package net.royal.erp.documento.dominio.dto;

public class DtoFirmaElemento {

	private String idDocumento;

	/* si es nulo generar una ruta en automatico */

	private String nombreArchivo;
	private String nombreArchivoFirmado;
	private String flgFirmoElemento;

	private String idUnicoDocumento;

	// Booleano que permite mostrar el boton de guardar el archivo firmado.
	private Boolean isFirmoElemento;

	public String getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getNombreArchivoFirmado() {
		return nombreArchivoFirmado;
	}

	public void setNombreArchivoFirmado(String nombreArchivoFirmado) {
		this.nombreArchivoFirmado = nombreArchivoFirmado;
	}

	public String getFlgFirmoElemento() {
		return flgFirmoElemento;
	}

	public void setFlgFirmoElemento(String flgFirmoElemento) {
		this.flgFirmoElemento = flgFirmoElemento;
	}

	/**
	 * @return the isFirmoElemento
	 */
	public Boolean getIsFirmoElemento() {
		return isFirmoElemento;
	}

	/**
	 * @param isFirmoElemento
	 *            the isFirmoElemento to set
	 */
	public void setIsFirmoElemento(Boolean isFirmoElemento) {
		this.isFirmoElemento = isFirmoElemento;
	}

	/**
	 * @return the idUnicoDocumento
	 */
	public String getIdUnicoDocumento() {
		idUnicoDocumento = getIdDocumento() + "_" + getNombreArchivo().replace(" ", "");
		return idUnicoDocumento;
	}

	/**
	 * @param idUnicoDocumento
	 *            the idUnicoDocumento to set
	 */
	public void setIdUnicoDocumento(String idUnicoDocumento) {
		this.idUnicoDocumento = idUnicoDocumento;
	}

}
