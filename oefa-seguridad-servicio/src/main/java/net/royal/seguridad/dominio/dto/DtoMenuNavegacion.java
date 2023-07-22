package net.royal.seguridad.dominio.dto;

public class DtoMenuNavegacion implements java.io.Serializable {
	private String tipo;
	private String nombre;

	public DtoMenuNavegacion() {
	}

	public DtoMenuNavegacion(String tipo, String nombre) {
		this.tipo = tipo;
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
