package net.royal.seguridad.correo.dominio;

public class CorreoAdjunto {
	
	private String nombreArchivo;
	
	private byte[] archivoAdjunto;

	public CorreoAdjunto() {
	}
	public CorreoAdjunto(byte[] archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}
	public CorreoAdjunto(String nombreArchivo, byte[] archivoAdjunto) {
		this.nombreArchivo=nombreArchivo;
		this.archivoAdjunto = archivoAdjunto;
	}

	public byte[] getArchivoAdjunto() {
		return archivoAdjunto;
	}

	public void setArchivoAdjunto(byte[] archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
}
