package net.royal.seguridad.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DtoPersonaMast implements Serializable {
	private BigDecimal codigo;
	private String nombre;
	private String documento;
	private String tipoDocumentoNombre;
	private Integer edad;
	private Date fechanac;
	private Integer idArea;
	private Integer idpuesto;
	private String puesto;
	private String direccion;
	private String sexo;
	private String estado;
	private String EstadoNombre;
	private String antiguedad;
	private String turno;
	private String tipocontrato;
	private Integer tiempoexperiencia;
	private Integer nrohorastrabajas;
	private Integer idCargo;
	private String cargo;
	private String correoelectronico;
	private String correointerno;
	private String busqueda;

	private String idTipoIper;

	// CREGISTRO MANTENIMIENTO TAB-REGISTRO
	private Integer idTipoActividad;
	private Integer nroEmpleados;
	private Integer fechaInicioActividades;
	private String lineaProduccionServicios;
	private Integer nroEmpleadosConSCTR;
	private Integer nroEmpleadosSinSCTR;
	private Integer idAseguradora;
	private Integer idMedicoResponsable;
	private Integer idEntidadSalud;

	public BigDecimal getCodigo() {
		return codigo;
	}

	public void setCodigo(BigDecimal codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipoDocumentoNombre() {
		return tipoDocumentoNombre;
	}

	public void setTipoDocumentoNombre(String tipoDocumentoNombre) {
		this.tipoDocumentoNombre = tipoDocumentoNombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechanac() {
		return fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public Integer getIdpuesto() {
		return idpuesto;
	}

	public void setIdpuesto(Integer idpuesto) {
		this.idpuesto = idpuesto;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadoNombre() {
		return EstadoNombre;
	}

	public void setEstadoNombre(String estadoNombre) {
		EstadoNombre = estadoNombre;
	}

	public String getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getTipocontrato() {
		return tipocontrato;
	}

	public void setTipocontrato(String tipocontrato) {
		this.tipocontrato = tipocontrato;
	}

	public Integer getTiempoexperiencia() {
		return tiempoexperiencia;
	}

	public void setTiempoexperiencia(Integer tiempoexperiencia) {
		this.tiempoexperiencia = tiempoexperiencia;
	}

	public Integer getNrohorastrabajas() {
		return nrohorastrabajas;
	}

	public void setNrohorastrabajas(Integer nrohorastrabajas) {
		this.nrohorastrabajas = nrohorastrabajas;
	}

	public Integer getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getIdTipoIper() {
		return idTipoIper;
	}

	public void setIdTipoIper(String idTipoIper) {
		this.idTipoIper = idTipoIper;
	}

	public Integer getIdTipoActividad() {
		return idTipoActividad;
	}

	public void setIdTipoActividad(Integer idTipoActividad) {
		this.idTipoActividad = idTipoActividad;
	}

	public Integer getNroEmpleados() {
		return nroEmpleados;
	}

	public void setNroEmpleados(Integer nroEmpleados) {
		this.nroEmpleados = nroEmpleados;
	}

	public Integer getFechaInicioActividades() {
		return fechaInicioActividades;
	}

	public void setFechaInicioActividades(Integer fechaInicioActividades) {
		this.fechaInicioActividades = fechaInicioActividades;
	}

	public String getLineaProduccionServicios() {
		return lineaProduccionServicios;
	}

	public void setLineaProduccionServicios(String lineaProduccionServicios) {
		this.lineaProduccionServicios = lineaProduccionServicios;
	}

	public Integer getNroEmpleadosConSCTR() {
		return nroEmpleadosConSCTR;
	}

	public void setNroEmpleadosConSCTR(Integer nroEmpleadosConSCTR) {
		this.nroEmpleadosConSCTR = nroEmpleadosConSCTR;
	}

	public Integer getNroEmpleadosSinSCTR() {
		return nroEmpleadosSinSCTR;
	}

	public void setNroEmpleadosSinSCTR(Integer nroEmpleadosSinSCTR) {
		this.nroEmpleadosSinSCTR = nroEmpleadosSinSCTR;
	}

	public Integer getIdAseguradora() {
		return idAseguradora;
	}

	public void setIdAseguradora(Integer idAseguradora) {
		this.idAseguradora = idAseguradora;
	}

	public Integer getIdMedicoResponsable() {
		return idMedicoResponsable;
	}

	public void setIdMedicoResponsable(Integer idMedicoResponsable) {
		this.idMedicoResponsable = idMedicoResponsable;
	}

	public Integer getIdEntidadSalud() {
		return idEntidadSalud;
	}

	public void setIdEntidadSalud(Integer idEntidadSalud) {
		this.idEntidadSalud = idEntidadSalud;
	}

	public String getCorreoelectronico() {
		return correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}

	public String getCorreointerno() {
		return correointerno;
	}

	public void setCorreointerno(String correointerno) {
		this.correointerno = correointerno;
	}

	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}
}
