package net.royal.erp.rrhh.hrothers.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

@SuppressWarnings("serial")
public class DtoDwHrEmpleadoevaluacionEdit implements Serializable {

	private String companyowner;
	private BigDecimal secuenciaeval;
	private BigDecimal empleado;
	private String empleadonombre;
	private String evaluadornombre;
	private String puestonombre;
	private String puestoevalnombre;
	private BigDecimal empleadoevaluador;
	private Date fechaevaluacion;
	private BigDecimal totalpuntos;
	private BigDecimal totalpuntosfuncion;
	private BigDecimal totalpuntospotencial;
	private BigDecimal totalpuntosmetas;
	private String unidadreplicacion;
	private String unidadnegocio;
	private String ultimousuario;
	private Date ultimafechamodif;
	private String centrocostos;
	private String estado;
	private String comentario;
	private String comentarioevaluado;
	private BigDecimal empleadogerente;
	private BigDecimal empleadosupervisor;
	private String comentariosupervisor;
	private String flagpresento;
	private String tipoevaluador;
	private String evaluado;
	private String evaluador;
	private String jefe_organo;
	private String comentariorevisor;
	private String flagmetas;
	private String flagnecesidadcapacita;
	private String flagrevisionmetas;
	private String flagpotencial;
	private String flagrevisionpotencial;
	private String flagdesempeno;
	private String periodo;
	private Date fechainicio;
	private Date fechafin;
	private String flagevaluacionintegral;
	private String codigoempleado;
	private String codigoevaluador;
	private String codigosupervisor;
	private String codigogerente;
	private String descripcion;
	private String entidadnombre;
	private String tipoevaluadornombre;
	private boolean flagpresentoboolean;
	private boolean evaluadoboolean;
	private boolean evaluadorboolean;
	private boolean jefeorganoboolean;

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public BigDecimal getSecuenciaeval() {
		return secuenciaeval;
	}

	public void setSecuenciaeval(BigDecimal secuenciaeval) {
		this.secuenciaeval = secuenciaeval;
	}

	public BigDecimal getEmpleado() {
		return empleado;
	}

	public void setEmpleado(BigDecimal empleado) {
		this.empleado = empleado;
	}

	public BigDecimal getEmpleadoevaluador() {
		return empleadoevaluador;
	}

	public void setEmpleadoevaluador(BigDecimal empleadoevaluador) {
		this.empleadoevaluador = empleadoevaluador;
	}

	public Date getFechaevaluacion() {
		return fechaevaluacion;
	}

	public void setFechaevaluacion(Date fechaevaluacion) {
		this.fechaevaluacion = fechaevaluacion;
	}

	public BigDecimal getTotalpuntos() {
		return totalpuntos;
	}

	public void setTotalpuntos(BigDecimal totalpuntos) {
		this.totalpuntos = totalpuntos;
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

	public BigDecimal getTotalpuntosmetas() {
		return totalpuntosmetas;
	}

	public void setTotalpuntosmetas(BigDecimal totalpuntosmetas) {
		this.totalpuntosmetas = totalpuntosmetas;
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

	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

	public String getCentrocostos() {
		return centrocostos;
	}

	public void setCentrocostos(String centrocostos) {
		this.centrocostos = centrocostos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getComentarioevaluado() {
		return comentarioevaluado;
	}

	public void setComentarioevaluado(String comentarioevaluado) {
		this.comentarioevaluado = comentarioevaluado;
	}

	public BigDecimal getEmpleadogerente() {
		return empleadogerente;
	}

	public void setEmpleadogerente(BigDecimal empleadogerente) {
		this.empleadogerente = empleadogerente;
	}

	public BigDecimal getEmpleadosupervisor() {
		return empleadosupervisor;
	}

	public void setEmpleadosupervisor(BigDecimal empleadosupervisor) {
		this.empleadosupervisor = empleadosupervisor;
	}

	public String getComentariosupervisor() {
		return comentariosupervisor;
	}

	public void setComentariosupervisor(String comentariosupervisor) {
		this.comentariosupervisor = comentariosupervisor;
	}

	public String getFlagpresento() {

		if (flagpresentoboolean)
			flagpresento = "S";
		else
			flagpresento = "N";

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

		if (evaluadoboolean)
			evaluado = "S";
		else
			evaluado = "N";

		return evaluado;
	}

	public void setEvaluado(String evaluado) {
		this.evaluado = evaluado;
	}

	public String getEvaluador() {

		if (evaluadorboolean)
			evaluador = "S";
		else
			evaluador = "N";

		return evaluador;
	}

	public void setEvaluador(String evaluador) {
		this.evaluador = evaluador;
	}

	public String getJefe_organo() {

		if (jefeorganoboolean)
			jefe_organo = "S";
		else
			jefe_organo = "N";

		return jefe_organo;
	}

	public void setJefe_organo(String jefe_organo) {
		this.jefe_organo = jefe_organo;
	}

	public String getComentariorevisor() {
		return comentariorevisor;
	}

	public void setComentariorevisor(String comentariorevisor) {
		this.comentariorevisor = comentariorevisor;
	}

	public String getFlagmetas() {
		return flagmetas;
	}

	public void setFlagmetas(String flagmetas) {
		this.flagmetas = flagmetas;
	}

	public String getFlagnecesidadcapacita() {
		return flagnecesidadcapacita;
	}

	public void setFlagnecesidadcapacita(String flagnecesidadcapacita) {
		this.flagnecesidadcapacita = flagnecesidadcapacita;
	}

	public String getFlagrevisionmetas() {
		return flagrevisionmetas;
	}

	public void setFlagrevisionmetas(String flagrevisionmetas) {
		this.flagrevisionmetas = flagrevisionmetas;
	}

	public String getFlagpotencial() {
		return flagpotencial;
	}

	public void setFlagpotencial(String flagpotencial) {
		this.flagpotencial = flagpotencial;
	}

	public String getFlagrevisionpotencial() {
		return flagrevisionpotencial;
	}

	public void setFlagrevisionpotencial(String flagrevisionpotencial) {
		this.flagrevisionpotencial = flagrevisionpotencial;
	}

	public String getFlagdesempeno() {
		return flagdesempeno;
	}

	public void setFlagdesempeno(String flagdesempeno) {
		this.flagdesempeno = flagdesempeno;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public String getFlagevaluacionintegral() {
		return flagevaluacionintegral;
	}

	public void setFlagevaluacionintegral(String flagevaluacionintegral) {
		this.flagevaluacionintegral = flagevaluacionintegral;
	}

	public String getCodigoempleado() {
		return codigoempleado;
	}

	public void setCodigoempleado(String codigoempleado) {
		this.codigoempleado = codigoempleado;
	}

	public String getCodigoevaluador() {
		return codigoevaluador;
	}

	public void setCodigoevaluador(String codigoevaluador) {
		this.codigoevaluador = codigoevaluador;
	}

	public String getCodigosupervisor() {
		return codigosupervisor;
	}

	public void setCodigosupervisor(String codigosupervisor) {
		this.codigosupervisor = codigosupervisor;
	}

	public String getCodigogerente() {
		return codigogerente;
	}

	public void setCodigogerente(String codigogerente) {
		this.codigogerente = codigogerente;
	}

	public String getEmpleadonombre() {
		return empleadonombre;
	}

	public void setEmpleadonombre(String empleadonombre) {
		this.empleadonombre = empleadonombre;
	}

	public String getPuestonombre() {
		return puestonombre;
	}

	public void setPuestonombre(String puestonombre) {
		this.puestonombre = puestonombre;
	}

	public String getEvaluadornombre() {
		return evaluadornombre;
	}

	public void setEvaluadornombre(String evaluadornombre) {
		this.evaluadornombre = evaluadornombre;
	}

	public String getPuestoevalnombre() {
		return puestoevalnombre;
	}

	public void setPuestoevalnombre(String puestoevalnombre) {
		this.puestoevalnombre = puestoevalnombre;
	}

	public boolean isFlagpresentoboolean() {
		if (!UValidador.esNulo(flagpresento))
			if (flagpresento.equals("S"))
				flagpresentoboolean = true;
			else
				flagpresentoboolean = false;
		else
			flagpresentoboolean = false;

		return flagpresentoboolean;
	}

	public void setFlagpresentoboolean(boolean flagpresentoboolean) {
		this.flagpresentoboolean = flagpresentoboolean;
	}

	public boolean isEvaluadoboolean() {
		if (!UValidador.esNulo(evaluado))
			if (evaluado.equals("S"))
				evaluadoboolean = true;
			else
				evaluadoboolean = false;
		else
			evaluadoboolean = false;

		return evaluadoboolean;
	}

	public void setEvaluadoboolean(boolean evaluadoboolean) {
		this.evaluadoboolean = evaluadoboolean;
	}

	public boolean isEvaluadorboolean() {
		if (!UValidador.esNulo(evaluador))
			if (evaluador.equals("S"))
				evaluadorboolean = true;
			else
				evaluadorboolean = false;
		else
			evaluadorboolean = false;

		return evaluadorboolean;
	}

	public void setEvaluadorboolean(boolean evaluadorboolean) {
		this.evaluadorboolean = evaluadorboolean;
	}

	public boolean isJefeorganoboolean() {
		if (!UValidador.esNulo(jefe_organo))
			if (jefe_organo.equals("S"))
				jefeorganoboolean = true;
			else
				jefeorganoboolean = false;
		else
			jefeorganoboolean = false;

		return jefeorganoboolean;
	}

	public String getEntidadnombre() {
		return entidadnombre;
	}

	public void setEntidadnombre(String entidadnombre) {
		this.entidadnombre = entidadnombre;
	}

	public void setJefeorganoboolean(boolean jefeorganoboolean) {
		this.jefeorganoboolean = jefeorganoboolean;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoevaluadornombre() {
		return tipoevaluadornombre;
	}

	public void setTipoevaluadornombre(String tipoevaluadornombre) {
		this.tipoevaluadornombre = tipoevaluadornombre;
	}

}
