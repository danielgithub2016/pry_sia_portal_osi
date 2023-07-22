package net.royal.erp.core.dominio.dto;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Usuario
 */
public class DtoUsuario implements java.io.Serializable {

	private String usuario;
	private String usuarioperfil;
	private String nombre;
	private String clave;
	private String expirarpasswordflag;
	private java.util.Date fechaexpiracion;
	private java.util.Date ultimologin;
	private Integer numerologinsdisponible;
	private Integer numerologinsusados;
	private String sqllogin;
	private String sqlpassword;
	private String estado;
	private String usuariored;
	private String horainicio;
	private String horafin;
	private String horainicioap;
	private String horafinap;
	private Integer empleado;
	private String correointerno;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuarioperfil() {
		return usuarioperfil;
	}

	public void setUsuarioperfil(String usuarioperfil) {
		this.usuarioperfil = usuarioperfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getExpirarpasswordflag() {
		return expirarpasswordflag;
	}

	public void setExpirarpasswordflag(String expirarpasswordflag) {
		this.expirarpasswordflag = expirarpasswordflag;
	}

	public java.util.Date getFechaexpiracion() {
		return fechaexpiracion;
	}

	public void setFechaexpiracion(java.util.Date fechaexpiracion) {
		this.fechaexpiracion = fechaexpiracion;
	}

	public java.util.Date getUltimologin() {
		return ultimologin;
	}

	public void setUltimologin(java.util.Date ultimologin) {
		this.ultimologin = ultimologin;
	}

	public Integer getNumerologinsdisponible() {
		return numerologinsdisponible;
	}

	public void setNumerologinsdisponible(Integer numerologinsdisponible) {
		this.numerologinsdisponible = numerologinsdisponible;
	}

	public Integer getNumerologinsusados() {
		return numerologinsusados;
	}

	public void setNumerologinsusados(Integer numerologinsusados) {
		this.numerologinsusados = numerologinsusados;
	}

	public String getSqllogin() {
		return sqllogin;
	}

	public void setSqllogin(String sqllogin) {
		this.sqllogin = sqllogin;
	}

	public String getSqlpassword() {
		return sqlpassword;
	}

	public void setSqlpassword(String sqlpassword) {
		this.sqlpassword = sqlpassword;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUsuariored() {
		return usuariored;
	}

	public void setUsuariored(String usuariored) {
		this.usuariored = usuariored;
	}

	public String getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(String horainicio) {
		this.horainicio = horainicio;
	}

	public String getHorafin() {
		return horafin;
	}

	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}

	public String getHorainicioap() {
		return horainicioap;
	}

	public void setHorainicioap(String horainicioap) {
		this.horainicioap = horainicioap;
	}

	public String getHorafinap() {
		return horafinap;
	}

	public void setHorafinap(String horafinap) {
		this.horafinap = horafinap;
	}

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public String getCorreointerno() {
		return correointerno;
	}

	public void setCorreointerno(String correointerno) {
		this.correointerno = correointerno;
	}

}
