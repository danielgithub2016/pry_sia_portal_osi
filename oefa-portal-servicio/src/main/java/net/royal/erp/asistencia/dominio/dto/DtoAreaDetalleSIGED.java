package net.royal.erp.asistencia.dominio.dto;

public class DtoAreaDetalleSIGED {
	private Integer idArea;
	private Object fechaCreacion;
	private Object horaIngreso;
	private Object horaSalida;
	private String nombre;
	private Integer dependencia;
	private Integer idSede;
	private Integer idPersonaAa;
	private Integer idPersonaJa;
	private String idOrganoLinea;

	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public Object getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Object fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Object getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(Object horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public Object getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Object horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDependencia() {
		return dependencia;
	}

	public void setDependencia(Integer dependencia) {
		this.dependencia = dependencia;
	}

	public Integer getIdSede() {
		return idSede;
	}

	public void setIdSede(Integer idSede) {
		this.idSede = idSede;
	}

	public Integer getIdPersonaAa() {
		return idPersonaAa;
	}

	public void setIdPersonaAa(Integer idPersonaAa) {
		this.idPersonaAa = idPersonaAa;
	}

	public Integer getIdPersonaJa() {
		return idPersonaJa;
	}

	public void setIdPersonaJa(Integer idPersonaJa) {
		this.idPersonaJa = idPersonaJa;
	}

	public String getIdOrganoLinea() {
		return idOrganoLinea;
	}

	public void setIdOrganoLinea(String idOrganoLinea) {
		this.idOrganoLinea = idOrganoLinea;
	}
}
