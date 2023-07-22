package net.royal.erp.asistencia.asmain.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

/**
 *
 * @author desarrollo
 * @powerbuilder asmain.dw_as_autorizacion_preproceso_hextra
 */
public class DtoDwAsAutorizacionPreprocesoHextra implements java.io.Serializable {

	private BigDecimal secuencia;
	private String seleccionado;
	private String seleccionadoRechazo;
	private BigDecimal empleado;
	private Date fecha;
	private Date fechafin;
	private String conceptoacceso;
	private String conceptoaccesonombre;
	private BigDecimal tipohorario;
	private Date desde1;
	private Date hasta1;
	private Date desde2;
	private Date hasta2;
	private String autorizadoPor;
	private Date fechaAutorizado;
	private Date ultimafechaModif;
	private String ultimoUsuario;
	private String nombrecompleto;
	private String estadoempleado;
	private String estado;
	private String refrigerio;
	private String mandatorio;
	private String observacion;
	private String periodo;
	private String solicitadoPor;
	private Date fechaSolicitud;
	private String visadoPor;
	private Date fechaVisado;
	private String estadoautorizacion;
	private String categoriaAutorizacion;
	private String areaNombre;
	private String companiaSocio;
	private String departamentoOperacional;
	private String centrocostodes;
	private String oficinades;
	private String categoriades;
	private String tipoplanilla;
	private String tipoplanillades;
	private String divisiondes;
	private String puestodes;
	private String estadoai;
	private BigDecimal terminal;

	private Boolean isseleccionaprobado;
	private Boolean isseleccionrechazado;
	private String nroresolucion;
	private Date fecharesolucion;

	private String motivorechazo;
	private String flagtienearchivo;
	private String isadminapro;
	private String tipoautorizacion;

	private Boolean istrue;
	private Boolean isfalse;
	private String uuidalfresco;

	private String uuidalfrescoweb;
	private String rutadocumento;

	private String flagreprogramado;
	private String codigoUsuario;

	// campos para la recuperacion de permiso
	private String flgTieneRecuperacion;
	private Date desderecupera;
	private Date hastarecupera;
	private String periodoplanilla;
	private String flagAprobadoJefe;

	// auxiliar del maestro de conceptos
	private String flagAprobacionURH;
	private String flagaprobacionsst;
	private Date fechaAprobadoJefe;
	private String aprobadoJefePor;
	private Date desdeanterior;
	private Date fechaanterior;
	private BigDecimal diascompensa;
	
	private String documento;
	private String fechaingreso;

	/**
	 * @return the secuencia
	 */
	public BigDecimal getSecuencia() {
		return secuencia;
	}

	/**
	 * @param secuencia
	 *            the secuencia to set
	 */
	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	/**
	 * @return the seleccionado
	 */
	public String getSeleccionado() {
		return seleccionado;
	}

	/**
	 * @param seleccionado
	 *            the seleccionado to set
	 */
	public void setSeleccionado(String seleccionado) {
		this.seleccionado = seleccionado;
	}

	/**
	 * @return the seleccionadoRechazo
	 */
	public String getSeleccionadoRechazo() {
		return seleccionadoRechazo;
	}

	/**
	 * @param seleccionadoRechazo
	 *            the seleccionadoRechazo to set
	 */
	public void setSeleccionadoRechazo(String seleccionadoRechazo) {
		this.seleccionadoRechazo = seleccionadoRechazo;
	}

	/**
	 * @return the empleado
	 */
	public BigDecimal getEmpleado() {
		return empleado;
	}

	/**
	 * @param empleado
	 *            the empleado to set
	 */
	public void setEmpleado(BigDecimal empleado) {
		this.empleado = empleado;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the fechafin
	 */
	public Date getFechafin() {
		return fechafin;
	}

	/**
	 * @param fechafin
	 *            the fechafin to set
	 */
	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	/**
	 * @return the conceptoacceso
	 */
	public String getConceptoacceso() {
		return conceptoacceso;
	}

	/**
	 * @param conceptoacceso
	 *            the conceptoacceso to set
	 */
	public void setConceptoacceso(String conceptoacceso) {
		this.conceptoacceso = conceptoacceso;
	}

	/**
	 * @return the conceptoaccesonombre
	 */
	public String getConceptoaccesonombre() {
		return conceptoaccesonombre;
	}

	/**
	 * @param conceptoaccesonombre
	 *            the conceptoaccesonombre to set
	 */
	public void setConceptoaccesonombre(String conceptoaccesonombre) {
		this.conceptoaccesonombre = conceptoaccesonombre;
	}

	/**
	 * @return the tipohorario
	 */
	public BigDecimal getTipohorario() {
		if (UValidador.esNulo(tipohorario)) {
			tipohorario = BigDecimal.valueOf(0);
		}
		return tipohorario;
	}

	/**
	 * @param tipohorario
	 *            the tipohorario to set
	 */
	public void setTipohorario(BigDecimal tipohorario) {
		this.tipohorario = tipohorario;
	}

	/**
	 * @return the desde1
	 */
	public Date getDesde1() {
		return desde1;
	}

	/**
	 * @param desde1
	 *            the desde1 to set
	 */
	public void setDesde1(Date desde1) {
		this.desde1 = desde1;
	}

	/**
	 * @return the hasta1
	 */
	public Date getHasta1() {
		return hasta1;
	}

	/**
	 * @param hasta1
	 *            the hasta1 to set
	 */
	public void setHasta1(Date hasta1) {
		this.hasta1 = hasta1;
	}

	/**
	 * @return the desde2
	 */
	public Date getDesde2() {
		return desde2;
	}

	/**
	 * @param desde2
	 *            the desde2 to set
	 */
	public void setDesde2(Date desde2) {
		this.desde2 = desde2;
	}

	/**
	 * @return the hasta2
	 */
	public Date getHasta2() {
		return hasta2;
	}

	/**
	 * @param hasta2
	 *            the hasta2 to set
	 */
	public void setHasta2(Date hasta2) {
		this.hasta2 = hasta2;
	}

	/**
	 * @return the autorizadoPor
	 */
	public String getAutorizadoPor() {
		return autorizadoPor;
	}

	/**
	 * @param autorizadoPor
	 *            the autorizadoPor to set
	 */
	public void setAutorizadoPor(String autorizadoPor) {
		this.autorizadoPor = autorizadoPor;
	}

	/**
	 * @return the fechaAutorizado
	 */
	public Date getFechaAutorizado() {
		return fechaAutorizado;
	}

	/**
	 * @param fechaAutorizado
	 *            the fechaAutorizado to set
	 */
	public void setFechaAutorizado(Date fechaAutorizado) {
		this.fechaAutorizado = fechaAutorizado;
	}

	/**
	 * @return the ultimafechaModif
	 */
	public Date getUltimafechaModif() {
		return ultimafechaModif;
	}

	/**
	 * @param ultimafechaModif
	 *            the ultimafechaModif to set
	 */
	public void setUltimafechaModif(Date ultimafechaModif) {
		this.ultimafechaModif = ultimafechaModif;
	}

	/**
	 * @return the ultimoUsuario
	 */
	public String getUltimoUsuario() {
		return ultimoUsuario;
	}

	/**
	 * @param ultimoUsuario
	 *            the ultimoUsuario to set
	 */
	public void setUltimoUsuario(String ultimoUsuario) {
		this.ultimoUsuario = ultimoUsuario;
	}

	/**
	 * @return the nombrecompleto
	 */
	public String getNombrecompleto() {
		return nombrecompleto;
	}

	/**
	 * @param nombrecompleto
	 *            the nombrecompleto to set
	 */
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	/**
	 * @return the estadoempleado
	 */
	public String getEstadoempleado() {
		return estadoempleado;
	}

	/**
	 * @param estadoempleado
	 *            the estadoempleado to set
	 */
	public void setEstadoempleado(String estadoempleado) {
		this.estadoempleado = estadoempleado;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the refrigerio
	 */
	public String getRefrigerio() {
		return refrigerio;
	}

	/**
	 * @param refrigerio
	 *            the refrigerio to set
	 */
	public void setRefrigerio(String refrigerio) {
		this.refrigerio = refrigerio;
	}

	/**
	 * @return the mandatorio
	 */
	public String getMandatorio() {
		return mandatorio;
	}

	/**
	 * @param mandatorio
	 *            the mandatorio to set
	 */
	public void setMandatorio(String mandatorio) {
		this.mandatorio = mandatorio;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion
	 *            the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the solicitadoPor
	 */
	public String getSolicitadoPor() {
		return solicitadoPor;
	}

	/**
	 * @param solicitadoPor
	 *            the solicitadoPor to set
	 */
	public void setSolicitadoPor(String solicitadoPor) {
		this.solicitadoPor = solicitadoPor;
	}

	/**
	 * @return the fechaSolicitud
	 */
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * @param fechaSolicitud
	 *            the fechaSolicitud to set
	 */
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * @return the visadoPor
	 */
	public String getVisadoPor() {
		return visadoPor;
	}

	/**
	 * @param visadoPor
	 *            the visadoPor to set
	 */
	public void setVisadoPor(String visadoPor) {
		this.visadoPor = visadoPor;
	}

	/**
	 * @return the fechaVisado
	 */
	public Date getFechaVisado() {
		return fechaVisado;
	}

	/**
	 * @param fechaVisado
	 *            the fechaVisado to set
	 */
	public void setFechaVisado(Date fechaVisado) {
		this.fechaVisado = fechaVisado;
	}

	/**
	 * @return the categoriaAutorizacion
	 */
	public String getCategoriaAutorizacion() {
		return categoriaAutorizacion;
	}

	/**
	 * @param categoriaAutorizacion
	 *            the categoriaAutorizacion to set
	 */
	public void setCategoriaAutorizacion(String categoriaAutorizacion) {
		this.categoriaAutorizacion = categoriaAutorizacion;
	}

	/**
	 * @return the areaNombre
	 */
	public String getAreaNombre() {
		return areaNombre;
	}

	/**
	 * @param areaNombre
	 *            the areaNombre to set
	 */
	public void setAreaNombre(String areaNombre) {
		this.areaNombre = areaNombre;
	}

	/**
	 * @return the companiaSocio
	 */
	public String getCompaniaSocio() {
		return companiaSocio;
	}

	/**
	 * @param companiaSocio
	 *            the companiaSocio to set
	 */
	public void setCompaniaSocio(String companiaSocio) {
		this.companiaSocio = companiaSocio;
	}

	/**
	 * @return the departamentoOperacional
	 */
	public String getDepartamentoOperacional() {
		return departamentoOperacional;
	}

	/**
	 * @param departamentoOperacional
	 *            the departamentoOperacional to set
	 */
	public void setDepartamentoOperacional(String departamentoOperacional) {
		this.departamentoOperacional = departamentoOperacional;
	}

	/**
	 * @return the centrocostodes
	 */
	public String getCentrocostodes() {
		return centrocostodes;
	}

	/**
	 * @param centrocostodes
	 *            the centrocostodes to set
	 */
	public void setCentrocostodes(String centrocostodes) {
		this.centrocostodes = centrocostodes;
	}

	/**
	 * @return the oficinades
	 */
	public String getOficinades() {
		return oficinades;
	}

	/**
	 * @param oficinades
	 *            the oficinades to set
	 */
	public void setOficinades(String oficinades) {
		this.oficinades = oficinades;
	}

	/**
	 * @return the categoriades
	 */
	public String getCategoriades() {
		return categoriades;
	}

	/**
	 * @param categoriades
	 *            the categoriades to set
	 */
	public void setCategoriades(String categoriades) {
		this.categoriades = categoriades;
	}

	/**
	 * @return the tipoplanillades
	 */
	public String getTipoplanillades() {
		return tipoplanillades;
	}

	/**
	 * @param tipoplanillades
	 *            the tipoplanillades to set
	 */
	public void setTipoplanillades(String tipoplanillades) {
		this.tipoplanillades = tipoplanillades;
	}

	/**
	 * @return the divisiondes
	 */
	public String getDivisiondes() {
		return divisiondes;
	}

	/**
	 * @param divisiondes
	 *            the divisiondes to set
	 */
	public void setDivisiondes(String divisiondes) {
		this.divisiondes = divisiondes;
	}

	/**
	 * @return the puestodes
	 */
	public String getPuestodes() {
		return puestodes;
	}

	/**
	 * @param puestodes
	 *            the puestodes to set
	 */
	public void setPuestodes(String puestodes) {
		this.puestodes = puestodes;
	}

	/**
	 * @return the estadoai
	 */
	public String getEstadoai() {
		return estadoai;
	}

	/**
	 * @param estadoai
	 *            the estadoai to set
	 */
	public void setEstadoai(String estadoai) {
		this.estadoai = estadoai;
	}

	/**
	 * @return the terminal
	 */
	public BigDecimal getTerminal() {
		if (UValidador.esNulo(terminal)) {
			terminal = BigDecimal.valueOf(0.0);
		}
		return terminal;
	}

	/**
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(BigDecimal terminal) {
		this.terminal = terminal;
	}

	/**
	 * @return the periodo
	 */
	public String getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo
	 *            the periodo to set
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	/**
	 * @return the estadoautorizacion
	 */
	public String getEstadoautorizacion() {
		return estadoautorizacion;
	}

	/**
	 * @param estadoautorizacion
	 *            the estadoautorizacion to set
	 */
	public void setEstadoautorizacion(String estadoautorizacion) {
		this.estadoautorizacion = estadoautorizacion;
	}

	/**
	 * @return the isseleccionaprobado
	 */
	public Boolean getIsseleccionaprobado() {
		if (UValidador.esNulo(isseleccionaprobado)) {
			isseleccionaprobado = false;
		}
		return isseleccionaprobado;
	}

	/**
	 * @param isseleccionaprobado
	 *            the isseleccionaprobado to set
	 */
	public void setIsseleccionaprobado(Boolean isseleccionaprobado) {
		this.isseleccionaprobado = isseleccionaprobado;
	}

	/**
	 * @return the isseleccionrechazado
	 */
	public Boolean getIsseleccionrechazado() {
		if (UValidador.esNulo(isseleccionrechazado)) {
			isseleccionrechazado = false;
		}
		return isseleccionrechazado;
	}

	/**
	 * @param isseleccionrechazado
	 *            the isseleccionrechazado to set
	 */
	public void setIsseleccionrechazado(Boolean isseleccionrechazado) {
		this.isseleccionrechazado = isseleccionrechazado;
	}

	/**
	 * @return the nroresolucion
	 */
	public String getNroresolucion() {
		return nroresolucion;
	}

	/**
	 * @param nroresolucion
	 *            the nroresolucion to set
	 */
	public void setNroresolucion(String nroresolucion) {
		this.nroresolucion = nroresolucion;
	}

	/**
	 * @return the motivorechazo
	 */
	public String getMotivorechazo() {
		return motivorechazo;
	}

	/**
	 * @param motivorechazo
	 *            the motivorechazo to set
	 */
	public void setMotivorechazo(String motivorechazo) {
		this.motivorechazo = motivorechazo;
	}

	/**
	 * @return the fecharesolucion
	 */
	public Date getFecharesolucion() {
		return fecharesolucion;
	}

	/**
	 * @param fecharesolucion
	 *            the fecharesolucion to set
	 */
	public void setFecharesolucion(Date fecharesolucion) {
		this.fecharesolucion = fecharesolucion;
	}

	/**
	 * @return the flagtienearchivo
	 */
	public String getFlagtienearchivo() {
		flagtienearchivo = "";
		if (!UValidador.estaVacio(getRutadocumento()) || !UValidador.estaVacio(getUuidalfrescoweb())) {
			flagtienearchivo = "S";
		}
		return flagtienearchivo;
	}

	/**
	 * @param flagtienearchivo
	 *            the flagtienearchivo to set
	 */
	public void setFlagtienearchivo(String flagtienearchivo) {
		this.flagtienearchivo = flagtienearchivo;
	}

	public String getIsadminapro() {
		return isadminapro;
	}

	public void setIsadminapro(String isadminapro) {
		this.isadminapro = isadminapro;
	}

	public String getTipoautorizacion() {
		return tipoautorizacion;
	}

	public void setTipoautorizacion(String tipoautorizacion) {
		this.tipoautorizacion = tipoautorizacion;
	}

	public Boolean getIstrue() {
		return true;
	}

	public void setIstrue(Boolean istrue) {
		this.istrue = istrue;
	}

	public Boolean getIsfalse() {
		return false;
	}

	public void setIsfalse(Boolean isfalse) {
		this.isfalse = isfalse;
	}

	public String getUuidalfresco() {
		return uuidalfresco;
	}

	public void setUuidalfresco(String uuidalfresco) {
		this.uuidalfresco = uuidalfresco;
	}

	public String getUuidalfrescoweb() {
		return uuidalfrescoweb;
	}

	public void setUuidalfrescoweb(String uuidalfrescoweb) {
		this.uuidalfrescoweb = uuidalfrescoweb;
	}

	public String getRutadocumento() {
		return rutadocumento;
	}

	public void setRutadocumento(String rutadocumento) {
		this.rutadocumento = rutadocumento;
	}

	public String getFlagreprogramado() {
		if (UValidador.estaVacio(flagreprogramado)) {
			flagreprogramado = "";
		}
		return flagreprogramado;
	}

	public void setFlagreprogramado(String flagreprogramado) {
		this.flagreprogramado = flagreprogramado;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

	public String getFlgTieneRecuperacion() {
		return flgTieneRecuperacion;
	}

	public void setFlgTieneRecuperacion(String flgTieneRecuperacion) {
		this.flgTieneRecuperacion = flgTieneRecuperacion;
	}

	public Date getDesderecupera() {
		return desderecupera;
	}

	public void setDesderecupera(Date desderecupera) {
		this.desderecupera = desderecupera;
	}

	public Date getHastarecupera() {
		return hastarecupera;
	}

	public void setHastarecupera(Date hastarecupera) {
		this.hastarecupera = hastarecupera;
	}

	public String getPeriodoplanilla() {
		return periodoplanilla;
	}

	public void setPeriodoplanilla(String periodoplanilla) {
		this.periodoplanilla = periodoplanilla;
	}

	public String getFlagAprobadoJefe() {
		if (UValidador.estaVacio(flagAprobadoJefe)) {
			flagAprobadoJefe = "";
		}
		return flagAprobadoJefe;
	}

	public void setFlagAprobadoJefe(String flagAprobadoJefe) {
		this.flagAprobadoJefe = flagAprobadoJefe;
	}

	public String getFlagAprobacionURH() {
		return flagAprobacionURH;
	}

	public void setFlagAprobacionURH(String flagAprobacionURH) {
		this.flagAprobacionURH = flagAprobacionURH;
	}

	public Date getFechaAprobadoJefe() {
		return fechaAprobadoJefe;
	}

	public void setFechaAprobadoJefe(Date fechaAprobadoJefe) {
		this.fechaAprobadoJefe = fechaAprobadoJefe;
	}

	public String getAprobadoJefePor() {
		return aprobadoJefePor;
	}

	public void setAprobadoJefePor(String aprobadoJefePor) {
		this.aprobadoJefePor = aprobadoJefePor;
	}

	public Date getDesdeanterior() {
		return desdeanterior;
	}

	public void setDesdeanterior(Date desdeanterior) {
		this.desdeanterior = desdeanterior;
	}

	public Date getFechaanterior() {
		return fechaanterior;
	}

	public void setFechaanterior(Date fechaanterior) {
		this.fechaanterior = fechaanterior;
	}

	public BigDecimal getDiascompensa() {
		if(diascompensa==null){
			diascompensa = BigDecimal.ZERO;
		}
		return diascompensa;
	}

	public void setDiascompensa(BigDecimal diascompensa) {
		this.diascompensa = diascompensa;
	}

	public String getFlagaprobacionsst() {
		return flagaprobacionsst;
	}

	public void setFlagaprobacionsst(String flagaprobacionsst) {
		this.flagaprobacionsst = flagaprobacionsst;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(String fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

}
