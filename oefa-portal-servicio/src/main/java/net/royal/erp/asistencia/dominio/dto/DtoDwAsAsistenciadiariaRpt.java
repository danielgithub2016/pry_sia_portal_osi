package net.royal.erp.asistencia.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

/**
 * @author nunezh
 *
 */
@SuppressWarnings("serial")
public class DtoDwAsAsistenciadiariaRpt implements Serializable {

	private String centrocostos;
	private String nombrecentro;
	private BigDecimal empleado;
	private String nombrecompleto;
	private BigDecimal tipohorario;
	private Date fecha;
	private Date desde;
	private Date hasta;
	private BigDecimal cantidad;
	private String conceptosistema;
	private BigDecimal tipodia;
	private Date horainiciodia;
	private Date horafindia;
	private String personaant;
	private String conceptoacceso;
	private String documento;
	private String areanombre;
	private String descripcionconceptosistema;
	private BigDecimal cantidadreal;
	private String justificacion;
	private String companiasocio;
	private BigDecimal semana;
	private String flagcompensacion;
	private String estadoempleado;
	private String flagcompensa;
	private String flagotrospermisos;
	public String getCentrocostos() {
		return centrocostos;
	}
	public void setCentrocostos(String centrocostos) {
		this.centrocostos = centrocostos;
	}
	public String getNombrecentro() {
		return nombrecentro;
	}
	public void setNombrecentro(String nombrecentro) {
		this.nombrecentro = nombrecentro;
	}
	public BigDecimal getEmpleado() {
		return empleado;
	}
	public void setEmpleado(BigDecimal empleado) {
		this.empleado = empleado;
	}
	public String getNombrecompleto() {
		return nombrecompleto;
	}
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	public BigDecimal getTipohorario() {
		return tipohorario;
	}
	public void setTipohorario(BigDecimal tipohorario) {
		this.tipohorario = tipohorario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getDesde() {
		return desde;
	}
	public void setDesde(Date desde) {
		this.desde = desde;
	}
	public Date getHasta() {
		return hasta;
	}
	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public String getConceptosistema() {
		return conceptosistema;
	}
	public void setConceptosistema(String conceptosistema) {
		this.conceptosistema = conceptosistema;
	}
	public BigDecimal getTipodia() {
		return tipodia;
	}
	public void setTipodia(BigDecimal tipodia) {
		this.tipodia = tipodia;
	}
	public Date getHorainiciodia() {
		return horainiciodia;
	}
	public void setHorainiciodia(Date horainiciodia) {
		this.horainiciodia = horainiciodia;
	}
	public Date getHorafindia() {
		return horafindia;
	}
	public void setHorafindia(Date horafindia) {
		this.horafindia = horafindia;
	}
	public String getPersonaant() {
		return personaant;
	}
	public void setPersonaant(String personaant) {
		this.personaant = personaant;
	}
	public String getConceptoacceso() {
		return conceptoacceso;
	}
	public void setConceptoacceso(String conceptoacceso) {
		this.conceptoacceso = conceptoacceso;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getAreanombre() {
		return areanombre;
	}
	public void setAreanombre(String areanombre) {
		this.areanombre = areanombre;
	}
	public String getDescripcionconceptosistema() {
		return descripcionconceptosistema;
	}
	public void setDescripcionconceptosistema(String descripcionconceptosistema) {
		this.descripcionconceptosistema = descripcionconceptosistema;
	}
	public BigDecimal getCantidadreal() {
		if(UValidador.esNulo(cantidadreal)){
			cantidadreal = BigDecimal.ZERO;
		}
		return cantidadreal;
	}
	public void setCantidadreal(BigDecimal cantidadreal) {
		this.cantidadreal = cantidadreal;
	}
	public String getJustificacion() {
		return justificacion;
	}
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	public String getCompaniasocio() {
		return companiasocio;
	}
	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}
	public BigDecimal getSemana() {
		return semana;
	}
	public void setSemana(BigDecimal semana) {
		this.semana = semana;
	}
	public String getFlagcompensacion() {
		return flagcompensacion;
	}
	public void setFlagcompensacion(String flagcompensacion) {
		this.flagcompensacion = flagcompensacion;
	}
	public String getEstadoempleado() {
		return estadoempleado;
	}
	public void setEstadoempleado(String estadoempleado) {
		this.estadoempleado = estadoempleado;
	}
	public String getFlagcompensa() {
		return flagcompensa;
	}
	public void setFlagcompensa(String flagcompensa) {
		this.flagcompensa = flagcompensa;
	}
	public String getFlagotrospermisos() {
		return flagotrospermisos;
	}
	public void setFlagotrospermisos(String flagotrospermisos) {
		this.flagotrospermisos = flagotrospermisos;
	}
	
}
