package net.royal.erp.rrhh.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.dominio.DominioGenerico;

@SuppressWarnings("serial")
public class HrEmpleadocapacitacion extends DominioGenerico implements
		Serializable {
	private HrEmpleadocapacitacionPk pk;
	private String companyowner;
	private String solicitudcapacitacion;
	private String centroresponsabilidad;
	private String numeroconstancia;
	private Integer numeroasistencias;
	private Integer horasasistencia;
	private String calificacion;
	private BigDecimal costoindividual;
	private Integer numeroperiodos;
	private String unidadnegocio;
	private String interfaceinstruccion;
	private BigDecimal nota;
	private Integer diasasistidos;
	private BigDecimal importegastoemp;
	private String comentario;
	private String deptoorganizacion;
	private String horario;
	private Date horainicio;
	private Date horafin;
	private BigDecimal viaticos;
	private Date fecha;
	private BigDecimal saldoinstitucional;
	private String cartacompromiso;
	private String flagnodescuentacapacitacion;
	private String nivelcolaborador;
	private Integer funcion;
	private String tipoaprueba;
	private String observacionempleado;
	private String flgadjuntosolicitud;
	private String flgadjuntoinformfinal;
	private String capacitacion;
	private BigDecimal empleado;

	public HrEmpleadocapacitacion() {
		pk = new HrEmpleadocapacitacionPk();
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public String getSolicitudcapacitacion() {
		return solicitudcapacitacion;
	}

	public void setSolicitudcapacitacion(String solicitudcapacitacion) {
		this.solicitudcapacitacion = solicitudcapacitacion;
	}

	public String getCentroresponsabilidad() {
		return centroresponsabilidad;
	}

	public void setCentroresponsabilidad(String centroresponsabilidad) {
		this.centroresponsabilidad = centroresponsabilidad;
	}

	public String getNumeroconstancia() {
		return numeroconstancia;
	}

	public void setNumeroconstancia(String numeroconstancia) {
		this.numeroconstancia = numeroconstancia;
	}

	public Integer getNumeroasistencias() {
		return numeroasistencias;
	}

	public void setNumeroasistencias(Integer numeroasistencias) {
		this.numeroasistencias = numeroasistencias;
	}

	public Integer getHorasasistencia() {
		return horasasistencia;
	}

	public void setHorasasistencia(Integer horasasistencia) {
		this.horasasistencia = horasasistencia;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public BigDecimal getCostoindividual() {
		return costoindividual;
	}

	public void setCostoindividual(BigDecimal costoindividual) {
		this.costoindividual = costoindividual;
	}

	public Integer getNumeroperiodos() {
		return numeroperiodos;
	}

	public void setNumeroperiodos(Integer numeroperiodos) {
		this.numeroperiodos = numeroperiodos;
	}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public String getInterfaceinstruccion() {
		return interfaceinstruccion;
	}

	public void setInterfaceinstruccion(String interfaceinstruccion) {
		this.interfaceinstruccion = interfaceinstruccion;
	}

	public BigDecimal getNota() {
		return nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}

	public Integer getDiasasistidos() {
		return diasasistidos;
	}

	public void setDiasasistidos(Integer diasasistidos) {
		this.diasasistidos = diasasistidos;
	}

	public BigDecimal getImportegastoemp() {
		return importegastoemp;
	}

	public void setImportegastoemp(BigDecimal importegastoemp) {
		this.importegastoemp = importegastoemp;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getDeptoorganizacion() {
		return deptoorganizacion;
	}

	public void setDeptoorganizacion(String deptoorganizacion) {
		this.deptoorganizacion = deptoorganizacion;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Date getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(Date horainicio) {
		this.horainicio = horainicio;
	}

	public Date getHorafin() {
		return horafin;
	}

	public void setHorafin(Date horafin) {
		this.horafin = horafin;
	}

	public BigDecimal getViaticos() {
		return viaticos;
	}

	public void setViaticos(BigDecimal viaticos) {
		this.viaticos = viaticos;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getSaldoinstitucional() {
		return saldoinstitucional;
	}

	public void setSaldoinstitucional(BigDecimal saldoinstitucional) {
		this.saldoinstitucional = saldoinstitucional;
	}

	public String getCartacompromiso() {
		return cartacompromiso;
	}

	public void setCartacompromiso(String cartacompromiso) {
		this.cartacompromiso = cartacompromiso;
	}

	public HrEmpleadocapacitacionPk getPk() {
		return pk;
	}

	public void setPk(HrEmpleadocapacitacionPk pk) {
		this.pk = pk;
	}

	public String getFlagnodescuentacapacitacion() {
		return flagnodescuentacapacitacion;
	}

	public void setFlagnodescuentacapacitacion(
			String flagnodescuentacapacitacion) {
		this.flagnodescuentacapacitacion = flagnodescuentacapacitacion;
	}

	public String getNivelcolaborador() {
		return nivelcolaborador;
	}

	public void setNivelcolaborador(String nivelcolaborador) {
		this.nivelcolaborador = nivelcolaborador;
	}

	public Integer getFuncion() {
		return funcion;
	}

	public void setFuncion(Integer funcion) {
		this.funcion = funcion;
	}

	public String getTipoaprueba() {
		return tipoaprueba;
	}

	public void setTipoaprueba(String tipoaprueba) {
		this.tipoaprueba = tipoaprueba;
	}

	public String getObservacionempleado() {
		return observacionempleado;
	}

	public void setObservacionempleado(String observacionempleado) {
		this.observacionempleado = observacionempleado;
	}

	public String getFlgadjuntosolicitud() {
		return flgadjuntosolicitud;
	}

	public void setFlgadjuntosolicitud(String flgadjuntosolicitud) {
		this.flgadjuntosolicitud = flgadjuntosolicitud;
	}

	public String getFlgadjuntoinformfinal() {
		return flgadjuntoinformfinal;
	}

	public void setFlgadjuntoinformfinal(String flgadjuntoinformfinal) {
		this.flgadjuntoinformfinal = flgadjuntoinformfinal;
	}

	public String getCapacitacion() {
		return capacitacion;
	}

	public void setCapacitacion(String capacitacion) {
		this.capacitacion = capacitacion;
	}

	public BigDecimal getEmpleado() {
		return empleado;
	}

	public void setEmpleado(BigDecimal empleado) {
		this.empleado = empleado;
	}

	

}
