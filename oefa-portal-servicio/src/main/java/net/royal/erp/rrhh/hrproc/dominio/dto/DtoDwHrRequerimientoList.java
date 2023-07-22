package net.royal.erp.rrhh.hrproc.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

public class DtoDwHrRequerimientoList implements Serializable {

	private String requerimiento;
	private BigDecimal empleadosolicitante;
	private BigDecimal codigoposicionsolicitante;
	private BigDecimal codigopuesto;
	private BigDecimal proceso;
	private Date fechasolicitud;
	private String unidadnegocio;
	private BigDecimal numerosolicitado;
	private BigDecimal numeropendiente;
	private String estado;
	private String companyowner;
	private Date fechalimite;
	private String descripcion;
	private String descripcionposicion;
	private Date iniciovigencia;
	private Date finvigencia;
	private BigDecimal cf_pendientes;
	private String numeroconcurso;
	private String convocatoria;
	private BigDecimal concurso;
	private Date fechaenvio;
	private Date fechaquiebre;
	private String flagdesierto;
	private String motivodesierto;
	private Date fecharesultado;
	private BigDecimal puesto_vacante;
	private String nombreEstado;
	private String description;
	private String nombrecompleto;
	private String numerosolicitud;
	private String estilo;
	private Date fechapublicacion;
	private String flagpublicado;
	private String tipotrabajador;
	private String temaevaluacionconocimiento;
	private String flagEnviado;
	private String descripcionpuestoinformativo;
	private Date fechaEnviado;

	public String getDescripcionpuestoinformativo() {
		return descripcionpuestoinformativo;
	}

	public void setDescripcionpuestoinformativo(String descripcionpuestoinformativo) {
		this.descripcionpuestoinformativo = descripcionpuestoinformativo;
	}

	public String getTemaevaluacionconocimiento() {
		return temaevaluacionconocimiento;
	}

	public void setTemaevaluacionconocimiento(String temaevaluacionconocimiento) {
		this.temaevaluacionconocimiento = temaevaluacionconocimiento;
	}

	public String getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}

	public BigDecimal getEmpleadosolicitante() {
		return empleadosolicitante;
	}

	public void setEmpleadosolicitante(BigDecimal empleadosolicitante) {
		this.empleadosolicitante = empleadosolicitante;
	}

	public BigDecimal getCodigoposicionsolicitante() {
		return codigoposicionsolicitante;
	}

	public void setCodigoposicionsolicitante(BigDecimal codigoposicionsolicitante) {
		this.codigoposicionsolicitante = codigoposicionsolicitante;
	}

	public BigDecimal getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(BigDecimal codigopuesto) {
		this.codigopuesto = codigopuesto;
	}

	public Date getFechasolicitud() {
		return fechasolicitud;
	}

	public void setFechasolicitud(Date fechasolicitud) {
		this.fechasolicitud = fechasolicitud;
	}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public BigDecimal getNumerosolicitado() {
		return numerosolicitado;
	}

	public void setNumerosolicitado(BigDecimal numerosolicitado) {
		this.numerosolicitado = numerosolicitado;
	}

	public BigDecimal getNumeropendiente() {
		return numeropendiente;
	}

	public void setNumeropendiente(BigDecimal numeropendiente) {
		this.numeropendiente = numeropendiente;
	}

	public String getEstado() {
		if (UValidador.esNulo(estado)) {
			estado = "";
		}
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public Date getFechalimite() {
		return fechalimite;
	}

	public void setFechalimite(Date fechalimite) {
		this.fechalimite = fechalimite;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcionposicion() {
		return descripcionposicion;
	}

	public void setDescripcionposicion(String descripcionposicion) {
		this.descripcionposicion = descripcionposicion;
	}

	public Date getIniciovigencia() {
		return iniciovigencia;
	}

	public void setIniciovigencia(Date iniciovigencia) {
		this.iniciovigencia = iniciovigencia;
	}

	public Date getFinvigencia() {
		return finvigencia;
	}

	public void setFinvigencia(Date finvigencia) {
		this.finvigencia = finvigencia;
	}

	public BigDecimal getCf_pendientes() {
		return cf_pendientes;
	}

	public void setCf_pendientes(BigDecimal cf_pendientes) {
		this.cf_pendientes = cf_pendientes;
	}

	public String getNumeroconcurso() {
		return numeroconcurso;
	}

	public void setNumeroconcurso(String numeroconcurso) {
		this.numeroconcurso = numeroconcurso;
	}

	public String getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(String convocatoria) {
		this.convocatoria = convocatoria;
	}

	public BigDecimal getConcurso() {
		return concurso;
	}

	public void setConcurso(BigDecimal concurso) {
		this.concurso = concurso;
	}

	public Date getFechaenvio() {
		return fechaenvio;
	}

	public void setFechaenvio(Date fechaenvio) {
		this.fechaenvio = fechaenvio;
	}

	public Date getFechaquiebre() {
		return fechaquiebre;
	}

	public void setFechaquiebre(Date fechaquiebre) {
		this.fechaquiebre = fechaquiebre;
	}

	public String getMotivodesierto() {
		return motivodesierto;
	}

	public void setMotivodesierto(String motivodesierto) {
		this.motivodesierto = motivodesierto;
	}

	public Date getFecharesultado() {
		return fecharesultado;
	}

	public void setFecharesultado(Date fecharesultado) {
		this.fecharesultado = fecharesultado;
	}

	public BigDecimal getPuesto_vacante() {
		return puesto_vacante;
	}

	public void setPuesto_vacante(BigDecimal puesto_vacante) {
		this.puesto_vacante = puesto_vacante;
	}

	public String getNombreEstado() {
		if (estado.equals("PR")) {
			nombreEstado = "En Preparación";
		} else if (estado.equals("AP")) {
			nombreEstado = "Aprobado";
		} else if (estado.equals("RV")) {
			nombreEstado = "En Revisión";
		} else if (estado.equals("RE")) {
			nombreEstado = "Rechazado";
		} else if (estado.equals("EV")) {
			nombreEstado = "En Evaluacion";
		} else if (estado.equals("TE")) {
			nombreEstado = "Terminado";
		} else if (estado.equals("CA")) {
			nombreEstado = "Cancelado";
		} else if (estado.equals("SG")) {
			nombreEstado = "En Preparación";
		} else if (estado.equals("AE")) {
			nombreEstado = "Aprobados + En evaluación";
		} else if (estado.equals("RP")) {
			nombreEstado = "En preparación + Rechazado";
		} else if (estado.equals("DE")) {
			nombreEstado = "Desierto";
		} else {
			nombreEstado = "Enviado";
		}

		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public String getFlagdesierto() {
		return flagdesierto;
	}

	public void setFlagdesierto(String flagdesierto) {
		this.flagdesierto = flagdesierto;
	}

	/**
	 * @return the numerosolicitud
	 */
	public String getNumerosolicitud() {
		return numerosolicitud;
	}

	/**
	 * @param numerosolicitud
	 *            the numerosolicitud to set
	 */
	public void setNumerosolicitud(String numerosolicitud) {
		this.numerosolicitud = numerosolicitud;
	}

	/**
	 * @return the estilo
	 */
	public String getEstilo() {
		if (!UValidador.esNulo(fechaquiebre)) {
			if (fechaquiebre.after(new Date()) && getEstado().equals("AP")) {
				estilo = "color:red";
			}
		}
		return estilo;
	}

	/**
	 * @param estilo
	 *            the estilo to set
	 */
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public Date getFechapublicacion() {
		return fechapublicacion;
	}

	public void setFechapublicacion(Date fechapublicacion) {
		this.fechapublicacion = fechapublicacion;
	}

	public String getFlagpublicado() {
		return flagpublicado;
	}

	public void setFlagpublicado(String flagpublicado) {
		this.flagpublicado = flagpublicado;
	}

	public String getTipotrabajador() {
		return tipotrabajador;
	}

	public void setTipotrabajador(String tipotrabajador) {
		this.tipotrabajador = tipotrabajador;
	}

	public BigDecimal getProceso() {
		return proceso;
	}

	public void setProceso(BigDecimal proceso) {
		this.proceso = proceso;
	}

	public String getFlagEnviado() {
		if (flagEnviado == null) {
			flagEnviado = "";
		}
		return flagEnviado;
	}

	public void setFlagEnviado(String flagEnviado) {
		this.flagEnviado = flagEnviado;
	}

	public Date getFechaEnviado() {
		return fechaEnviado;
	}

	public void setFechaEnviado(Date fechaEnviado) {
		this.fechaEnviado = fechaEnviado;
	}

	

}
