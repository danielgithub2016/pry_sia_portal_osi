/**
 * 
 */
package net.royal.erp.rrhh.hrproc.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

/**
 * @author nunezh
 *
 */
public class DtoDwHrRequerimientopostEdit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String seleccion;
	private String requerimiento;
	private String postulante;
	private String companyowner;
	private String estado;
	private String etapa;
	private String ultimousuario;
	private Date ultimafechamodif;
	private String nombre;
	private String unidadnegocio;
	private String tipopostulante;
	private BigDecimal puntaje;
	private String observaciones;
	private Date fechapostulante;
	private BigDecimal variableremunerativa;
	private Integer secuencia;
	private Integer secuencia2;
	private String condvarrem;
	private Date fechaevaluacion;
	private String observacionesad;
	private String observacionesfinales;
	private String correo;
	private String flagformacion;
	private BigDecimal otrosestudios;
	private String flagotrosestudios;
	private BigDecimal experiencia;
	private String flagexperiencia;
	private Integer puesto;
	private String flagganador;
	private String flagrevisado;
	private String estadoseguimiento;

	// aux
	private String auxestadodescripcion;
	private String auxexperiencialaboral;
	private String auxexperienciaprofesional;
	private boolean flagrevisadobool;
	private boolean flagganadorbool;
	
	

	public String getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}

	public String getPostulante() {
		return postulante;
	}

	public void setPostulante(String postulante) {
		this.postulante = postulante;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public String getTipopostulante() {
		return tipopostulante;
	}

	public void setTipopostulante(String tipopostulante) {
		this.tipopostulante = tipopostulante;
	}

	public BigDecimal getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(BigDecimal puntaje) {
		this.puntaje = puntaje;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFechapostulante() {
		return fechapostulante;
	}

	public void setFechapostulante(Date fechapostulante) {
		this.fechapostulante = fechapostulante;
	}

	public BigDecimal getVariableremunerativa() {
		return variableremunerativa;
	}

	public void setVariableremunerativa(BigDecimal variableremunerativa) {
		this.variableremunerativa = variableremunerativa;
	}

	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Object secuencia) {
		if (!UValidador.esNulo(secuencia)) {
			if (secuencia instanceof BigDecimal)
				this.secuencia = new BigDecimal(secuencia.toString()).intValue();
			else if (secuencia instanceof Integer)
				this.secuencia = Integer.parseInt(secuencia.toString());
		}
	}

	public Integer getSecuencia2() {
		return secuencia2;
	}

	public void setSecuencia2(Object secuencia2) {
		if (!UValidador.esNulo(secuencia2)) {
			if (secuencia2 instanceof BigDecimal)
				this.secuencia2 = new BigDecimal(secuencia2.toString()).intValue();
			else if (secuencia2 instanceof Integer)
				this.secuencia2 = Integer.parseInt(secuencia2.toString());
		}
	}

	public String getCondvarrem() {
		return condvarrem;
	}

	public void setCondvarrem(String condvarrem) {
		this.condvarrem = condvarrem;
	}

	public Date getFechaevaluacion() {
		return fechaevaluacion;
	}

	public void setFechaevaluacion(Date fechaevaluacion) {
		this.fechaevaluacion = fechaevaluacion;
	}

	public String getObservacionesad() {
		return observacionesad;
	}

	public void setObservacionesad(String observacionesad) {
		this.observacionesad = observacionesad;
	}

	public String getObservacionesfinales() {
		return observacionesfinales;
	}

	public void setObservacionesfinales(String observacionesfinales) {
		this.observacionesfinales = observacionesfinales;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFlagformacion() {
		return flagformacion;
	}

	public void setFlagformacion(String flagformacion) {
		this.flagformacion = flagformacion;
	}

	public BigDecimal getOtrosestudios() {
		return otrosestudios;
	}

	public void setOtrosestudios(BigDecimal otrosestudios) {
		this.otrosestudios = otrosestudios;
	}

	public String getFlagotrosestudios() {
		return flagotrosestudios;
	}

	public void setFlagotrosestudios(String flagotrosestudios) {
		this.flagotrosestudios = flagotrosestudios;
	}

	public BigDecimal getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(BigDecimal experiencia) {
		this.experiencia = experiencia;
	}

	public String getFlagexperiencia() {
		return flagexperiencia;
	}

	public void setFlagexperiencia(String flagexperiencia) {
		this.flagexperiencia = flagexperiencia;
	}

	public Integer getPuesto() {
		return puesto;
	}

	public void setPuesto(Object puesto) {
		if (!UValidador.esNulo(puesto)) {
			if (puesto instanceof BigDecimal)
				this.puesto = new BigDecimal(puesto.toString()).intValue();
			else if (puesto instanceof Integer)
				this.puesto = Integer.parseInt(puesto.toString());
		}
	}

	public String getFlagganador() {
		return flagganador;
	}

	public void setFlagganador(String flagganador) {
		this.flagganador = flagganador;
	}

	public String getFlagrevisado() {
		return flagrevisado;
	}

	public void setFlagrevisado(String flagrevisado) {
		this.flagrevisado = flagrevisado;
	}

	public String getEstadoseguimiento() {
		return estadoseguimiento;
	}

	public void setEstadoseguimiento(String estadoseguimiento) {
		this.estadoseguimiento = estadoseguimiento;
	}

	public String getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}

	public String getAuxestadodescripcion() {
		if (!UValidador.esNulo(estado)) {
			switch (estado) {
			case "P":
				auxestadodescripcion = "En Proceso";
				break;
			case "E":
				auxestadodescripcion = "No Califica";
				break;
			case "A":
				auxestadodescripcion = "Califica";
				break;
			case "C":
				auxestadodescripcion = "Contratado";
				break;
			case "V":
				auxestadodescripcion = "Validación";
				break;
			}
		}
		return auxestadodescripcion;
	}

	public void setAuxestadodescripcion(String auxestadodescripcion) {
		this.auxestadodescripcion = auxestadodescripcion;
	}

	public String getAuxexperiencialaboral() {
		return auxexperiencialaboral;
	}

	public void setAuxexperiencialaboral(String auxexperiencialaboral) {
		this.auxexperiencialaboral = auxexperiencialaboral;
	}

	public String getAuxexperienciaprofesional() {
		return auxexperienciaprofesional;
	}

	public void setAuxexperienciaprofesional(String auxexperienciaprofesional) {
		this.auxexperienciaprofesional = auxexperienciaprofesional;
	}

	public boolean isFlagrevisadobool() {
		flagrevisadobool = UValidador.validarFlag(flagrevisado);
		return flagrevisadobool;
	}

	public void setFlagrevisadobool(boolean flagrevisadobool) {
		flagrevisado = UValidador.validarFlagLogico(flagrevisadobool);
		this.flagrevisadobool = flagrevisadobool;
	}

	public boolean isFlagganadorbool() {
		flagganadorbool = UValidador.validarFlag(flagganador);
		return flagganadorbool;
	}

	public void setFlagganadorbool(boolean flagganadorbool) {
		flagganador = UValidador.validarFlagLogico(flagganadorbool);
		this.flagganadorbool = flagganadorbool;
	}

}
