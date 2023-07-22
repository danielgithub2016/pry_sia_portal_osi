package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEmpleadocursosdocumento
 */
public class HrEmpleadocursosdocumento extends DominioGenerico implements java.io.Serializable {

	private HrEmpleadocursosdocumentoPk pk;
	private String nombrearchivo;
	private String extension;
	//private byte[] archivo;
	private String estado;
	private String uuidalfresco;
	
	private String flagcompartirmaterial;
	private String flgAdjuntoInformFinal;
	
	
	private String rutaArchivo;


	public String getFlagcompartirmaterial() {
		return flagcompartirmaterial;
	}

	public void setFlagcompartirmaterial(String flagcompartirmaterial) {
		this.flagcompartirmaterial = flagcompartirmaterial;
	}

	public HrEmpleadocursosdocumento() {
		pk = new HrEmpleadocursosdocumentoPk();
	}

	public HrEmpleadocursosdocumentoPk getPk() {
		return pk;
	}

	public void setPk(HrEmpleadocursosdocumentoPk pk) {
		this.pk = pk;
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

	public String getFlgAdjuntoInformFinal() {
		return flgAdjuntoInformFinal;
	}

	public void setFlgAdjuntoInformFinal(String flgAdjuntoInformFinal) {
		this.flgAdjuntoInformFinal = flgAdjuntoInformFinal;
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

}
