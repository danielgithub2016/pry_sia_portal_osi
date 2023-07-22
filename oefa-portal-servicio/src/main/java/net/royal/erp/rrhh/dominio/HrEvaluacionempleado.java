package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEvaluacionempleado
*/
public class HrEvaluacionempleado extends DominioGenerico implements java.io.Serializable{

	
	
	private HrEvaluacionempleadoPk pk;
	private java.util.Date fechaevaluacion;
	private String periodo;
	private java.math.BigDecimal totalpuntos;
	private String unidadreplicacion;
	private String unidadnegocio;
	private String centrocostos;
	private String comentario;
	private Integer codigopuesto;
	private java.util.Date fechadesde;
	private java.util.Date fechahasta;
	private String tiempopuesto;
	private String gradosalario;
	private String comentarioevaluado;
	private String deptoorganizacion;
	private String estado;
	private BigDecimal empleadogerente;
	private BigDecimal totalpuntosfuncion;
	private BigDecimal totalpuntospotencial;
	private BigDecimal empleadosupervisor;
	
	
	private Integer datoevaluacionintegral;
	private java.math.BigDecimal totalpuntosmetas;
	private String relacionempleadoevaluador;
	
	private String comentariosupervisor;
	private String flagpresento;
	private String tipoevaluador;
	private String evaluado;
	private String evaluador;
	private String jefeOrgano;
	private String comentariorevisor;


	public HrEvaluacionempleado() {
		pk = new HrEvaluacionempleadoPk();
	}

	public HrEvaluacionempleadoPk getPk() {
		return pk;
	}

	public void setPk(HrEvaluacionempleadoPk pk) {
		this.pk = pk;
	}
	public java.util.Date getFechaevaluacion() {
		return fechaevaluacion;
	}

	public void setFechaevaluacion(java.util.Date fechaevaluacion) {
		this.fechaevaluacion = fechaevaluacion;
	}
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public java.math.BigDecimal getTotalpuntos() {
		return totalpuntos;
	}

	public void setTotalpuntos(java.math.BigDecimal totalpuntos) {
		this.totalpuntos = totalpuntos;
	}
	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}
	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	public String getCentrocostos() {
		return centrocostos;
	}

	public void setCentrocostos(String centrocostos) {
		this.centrocostos = centrocostos;
	}
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}
	public java.util.Date getFechadesde() {
		return fechadesde;
	}

	public void setFechadesde(java.util.Date fechadesde) {
		this.fechadesde = fechadesde;
	}
	public java.util.Date getFechahasta() {
		return fechahasta;
	}

	public void setFechahasta(java.util.Date fechahasta) {
		this.fechahasta = fechahasta;
	}
	public String getTiempopuesto() {
		return tiempopuesto;
	}

	public void setTiempopuesto(String tiempopuesto) {
		this.tiempopuesto = tiempopuesto;
	}
	public String getGradosalario() {
		return gradosalario;
	}

	public void setGradosalario(String gradosalario) {
		this.gradosalario = gradosalario;
	}
	public String getComentarioevaluado() {
		return comentarioevaluado;
	}

	public void setComentarioevaluado(String comentarioevaluado) {
		this.comentarioevaluado = comentarioevaluado;
	}
	public String getDeptoorganizacion() {
		return deptoorganizacion;
	}

	public void setDeptoorganizacion(String deptoorganizacion) {
		this.deptoorganizacion = deptoorganizacion;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getEmpleadogerente() {
		return empleadogerente;
	}

	public void setEmpleadogerente(BigDecimal empleadogerente) {
		this.empleadogerente = empleadogerente;
	}

	public BigDecimal getTotalpuntosfuncion() {
		return totalpuntosfuncion;
	}

	public void setTotalpuntosfuncion(BigDecimal totalpuntosfuncion) {
		this.totalpuntosfuncion = totalpuntosfuncion;
	}

	public BigDecimal getTotalpuntospotencial() {
		return totalpuntospotencial;
	}

	public void setTotalpuntospotencial(BigDecimal totalpuntospotencial) {
		this.totalpuntospotencial = totalpuntospotencial;
	}

	public BigDecimal getEmpleadosupervisor() {
		return empleadosupervisor;
	}

	public void setEmpleadosupervisor(BigDecimal empleadosupervisor) {
		this.empleadosupervisor = empleadosupervisor;
	}

	public Integer getDatoevaluacionintegral() {
		return datoevaluacionintegral;
	}

	public void setDatoevaluacionintegral(Integer datoevaluacionintegral) {
		this.datoevaluacionintegral = datoevaluacionintegral;
	}

	public java.math.BigDecimal getTotalpuntosmetas() {
		return totalpuntosmetas;
	}

	public void setTotalpuntosmetas(java.math.BigDecimal totalpuntosmetas) {
		this.totalpuntosmetas = totalpuntosmetas;
	}

	public String getRelacionempleadoevaluador() {
		return relacionempleadoevaluador;
	}

	public void setRelacionempleadoevaluador(String relacionempleadoevaluador) {
		this.relacionempleadoevaluador = relacionempleadoevaluador;
	}

	public String getComentariosupervisor() {
		return comentariosupervisor;
	}

	public void setComentariosupervisor(String comentariosupervisor) {
		this.comentariosupervisor = comentariosupervisor;
	}

	public String getFlagpresento() {
		return flagpresento;
	}

	public void setFlagpresento(String flagpresento) {
		this.flagpresento = flagpresento;
	}

	public String getTipoevaluador() {
		return tipoevaluador;
	}

	public void setTipoevaluador(String tipoevaluador) {
		this.tipoevaluador = tipoevaluador;
	}

	public String getEvaluado() {
		return evaluado;
	}

	public void setEvaluado(String evaluado) {
		this.evaluado = evaluado;
	}

	public String getEvaluador() {
		return evaluador;
	}

	public void setEvaluador(String evaluador) {
		this.evaluador = evaluador;
	}

	public String getJefeOrgano() {
		return jefeOrgano;
	}

	public void setJefeOrgano(String jefeOrgano) {
		this.jefeOrgano = jefeOrgano;
	}

	public String getComentariorevisor() {
		return comentariorevisor;
	}

	public void setComentariorevisor(String comentariorevisor) {
		this.comentariorevisor = comentariorevisor;
	}
	
}
