package net.royal.erp.asistencia.asmain.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder asmain.dw_as_marcar
 */
public class DtoDwAsMarcar implements java.io.Serializable {

	private String carnetid;
	private Date fecha;
	private BigDecimal secuencia;
	private BigDecimal empleado;
	private String codigotransaccion;
	private String clasificacion;
	private String tipovalidacion;
	private String carnetsupervisor;
	private BigDecimal empleadosupervisor;
	private Date hora;
	private String observacion;
	private String unidadreplicacion;
	private Integer ano;
	private Integer mes;
	private Integer dia;
	private Date ultimafechamodif;
	private String ultimousuario;
	private String lugarrecoleccion;
	private String lectora;
	private BigDecimal empleado_a;
	private Date fecha_a;
	private String conceptoacceso_a;
	private Date desde_a;
	private BigDecimal terminal;

	private String codigocarnet;
	private String nombreEmpleado;
	private Date sysdate;
	private String tx_token;

	public String getCarnetid() {
		return carnetid;
	}

	public void setCarnetid(String carnetid) {
		this.carnetid = carnetid;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	public BigDecimal getEmpleado() {
		return empleado;
	}

	public void setEmpleado(BigDecimal empleado) {
		this.empleado = empleado;
	}

	public String getCodigotransaccion() {
		return codigotransaccion;
	}

	public void setCodigotransaccion(String codigotransaccion) {
		this.codigotransaccion = codigotransaccion;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getTipovalidacion() {
		return tipovalidacion;
	}

	public void setTipovalidacion(String tipovalidacion) {
		this.tipovalidacion = tipovalidacion;
	}

	public String getCarnetsupervisor() {
		return carnetsupervisor;
	}

	public void setCarnetsupervisor(String carnetsupervisor) {
		this.carnetsupervisor = carnetsupervisor;
	}

	public BigDecimal getEmpleadosupervisor() {
		return empleadosupervisor;
	}

	public void setEmpleadosupervisor(BigDecimal empleadosupervisor) {
		this.empleadosupervisor = empleadosupervisor;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}

	public String getLectora() {
		return lectora;
	}

	public void setLectora(String lectora) {
		this.lectora = lectora;
	}

	public BigDecimal getEmpleado_a() {
		return empleado_a;
	}

	public void setEmpleado_a(BigDecimal empleado_a) {
		this.empleado_a = empleado_a;
	}

	public Date getFecha_a() {
		return fecha_a;
	}

	public void setFecha_a(Date fecha_a) {
		this.fecha_a = fecha_a;
	}

	public String getConceptoacceso_a() {
		return conceptoacceso_a;
	}

	public void setConceptoacceso_a(String conceptoacceso_a) {
		this.conceptoacceso_a = conceptoacceso_a;
	}

	public Date getDesde_a() {
		return desde_a;
	}

	public void setDesde_a(Date desde_a) {
		this.desde_a = desde_a;
	}

	public BigDecimal getTerminal() {
		return terminal;
	}

	public void setTerminal(BigDecimal terminal) {
		this.terminal = terminal;
	}

	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	public String getLugarrecoleccion() {
		return lugarrecoleccion;
	}

	public void setLugarrecoleccion(String lugarrecoleccion) {
		this.lugarrecoleccion = lugarrecoleccion;
	}

	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

	public String getCodigocarnet() {
		return codigocarnet;
	}

	public void setCodigocarnet(String codigocarnet) {
		this.codigocarnet = codigocarnet;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Date getSysdate() {
		return sysdate;
	}

	public void setSysdate(Date sysdate) {
		this.sysdate = sysdate;
	}

	public String getTx_token() {
		return tx_token;
	}

	public void setTx_token(String tx_token) {
		this.tx_token = tx_token;
	}

}
