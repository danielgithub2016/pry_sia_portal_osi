package net.royal.erp.asistencia.dominio.dto;

public class DtoCoordenadas {

	private String latitud;
	private String longitud;

	public DtoCoordenadas() {

	}

	public DtoCoordenadas(String latitud, String longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

}
