package net.royal.erp.rrhh.dominio;

import java.io.Serializable;
import java.util.Arrays;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 * The Class HrEmpleadocapaDocumento.
 * 
 * @author nunezh
 */
public class HrEmpleadocapaDocumento extends DominioGenerico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HrEmpleadocapaDocumentoPk pk;
	private String idtipodocumento;
	private String nombrearchivo;
	private String extension;
	//private byte[] archivo;
	private String estado;
	private String uuidalfresco;
	
	private String rutaArchivo;

	public HrEmpleadocapaDocumento() {
		pk = new HrEmpleadocapaDocumentoPk();
	}

	public HrEmpleadocapaDocumentoPk getPk() {
		return pk;
	}

	@Override
	public String toString() {
		return "HrEmpleadocapaDocumento [" + (pk != null ? "pk=" + pk + ", " : "")
				+ (idtipodocumento != null ? "idtipodocumento=" + idtipodocumento + ", " : "")
				+ (nombrearchivo != null ? "nombrearchivo=" + nombrearchivo + ", " : "")
				+ (extension != null ? "extension=" + extension + ", " : "")
				+ (estado != null ? "estado=" + estado : "") + "]";
	}

	public void setPk(HrEmpleadocapaDocumentoPk pk) {
		this.pk = pk;
	}

	public String getIdtipodocumento() {
		return idtipodocumento;
	}

	public void setIdtipodocumento(String idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}

	public String getNombrearchivo() {
		return nombrearchivo;
	}

	public void setNombrearchivo(String nombrearchivo) {
		this.nombrearchivo = nombrearchivo;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

//	public byte[] getArchivo() {
//		return archivo;
//	}
//
//	public void setArchivo(byte[] archivo) {
//		this.archivo = archivo;
//	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUuidalfresco() {
		return uuidalfresco;
	}

	public void setUuidalfresco(String uuidalfresco) {
		this.uuidalfresco = uuidalfresco;
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

}
