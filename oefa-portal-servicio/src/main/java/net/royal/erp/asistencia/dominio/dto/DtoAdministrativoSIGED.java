package net.royal.erp.asistencia.dominio.dto;

public class DtoAdministrativoSIGED {
	
	private String nombre;
	private Integer  idArea;
	private Integer esAsistente;
	private Integer esJefe;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getIdArea() {
		return idArea;
	}
	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}
	public Integer getEsAsistente() {
		return esAsistente;
	}
	public void setEsAsistente(Integer esAsistente) {
		this.esAsistente = esAsistente;
	}
	public Integer getEsJefe() {
		return esJefe;
	}
	public void setEsJefe(Integer esJefe) {
		this.esJefe = esJefe;
	}
	
	
	
}
