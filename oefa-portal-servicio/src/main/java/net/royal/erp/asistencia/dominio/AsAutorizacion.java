package net.royal.erp.asistencia.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.DominioGenerico;

@SuppressWarnings("serial")
public class AsAutorizacion extends DominioGenerico implements Serializable {

	private AsAutorizacionPk pk;
	private String tipoautorizacion;
	private Date fechafin;
	private Date hasta;
	private String autorizadopor;
	private Date fechaautorizacion;
	private String estado;
	private String refrigerio;
	private String periodo;
	private String mandatorio;
	private String observacion;
	private String comportamientosobretiempo;
	private String sobretiempoposicion;
	private String solicitadopor;
	private String visadopor;
	private Date fechavisado;
	private Date fechasolicitud;
	private String categoriaautorizacion;
	private BigDecimal tipohorario;
	private String motivorechazo;
	private String flagcorrido;
	private BigDecimal terminal;
	private String rutadocumento;
	// private byte[] ruta;
	private String nroresolucion;
	private Date fecharesolucion;
	private String rechazadopor;
	private Date fecharechazo;
	private String uuidalfresco;
	private String flagreprogramado;

	private Date desdeanterior;
	private Date fechaanterior;

	private Date desderecupera;
	private Date hastarecupera;
	private String periodoplanilla;

	// campos para la aprobacion de jefe
	private String flagAprobadoJefe;
	private String aprobadoJefePor;
	private Date fechaAprobadoJefe;

	private String flgdj;
	private String uuiddj;
	private String nombrearchivodj;

	public AsAutorizacion() {
		pk = new AsAutorizacionPk();
	}

	public String getTipoautorizacion() {
		return tipoautorizacion;
	}

	public void setTipoautorizacion(String tipoautorizacion) {
		this.tipoautorizacion = tipoautorizacion;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	public String getAutorizadopor() {
		return autorizadopor;
	}

	public void setAutorizadopor(String autorizadopor) {
		this.autorizadopor = autorizadopor;
	}

	public Date getFechaautorizacion() {
		return fechaautorizacion;
	}

	public void setFechaautorizacion(Date fechaautorizacion) {
		this.fechaautorizacion = fechaautorizacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRefrigerio() {
		return refrigerio;
	}

	public void setRefrigerio(String refrigerio) {
		this.refrigerio = refrigerio;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getMandatorio() {
		return mandatorio;
	}

	public void setMandatorio(String mandatorio) {
		this.mandatorio = mandatorio;
	}

	public String getObservacion() {
		if (UValidador.estaVacio(observacion)) {
			observacion = "";
		}
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getComportamientosobretiempo() {
		return comportamientosobretiempo;
	}

	public void setComportamientosobretiempo(String comportamientosobretiempo) {
		this.comportamientosobretiempo = comportamientosobretiempo;
	}

	public String getSobretiempoposicion() {
		return sobretiempoposicion;
	}

	public void setSobretiempoposicion(String sobretiempoposicion) {
		this.sobretiempoposicion = sobretiempoposicion;
	}

	public String getSolicitadopor() {
		return solicitadopor;
	}

	public void setSolicitadopor(String solicitadopor) {
		this.solicitadopor = solicitadopor;
	}

	public String getVisadopor() {
		return visadopor;
	}

	public void setVisadopor(String visadopor) {
		this.visadopor = visadopor;
	}

	public Date getFechavisado() {
		return fechavisado;
	}

	public void setFechavisado(Date fechavisado) {
		this.fechavisado = fechavisado;
	}

	public Date getFechasolicitud() {
		return fechasolicitud;
	}

	public void setFechasolicitud(Date fechasolicitud) {
		this.fechasolicitud = fechasolicitud;
	}

	public String getCategoriaautorizacion() {
		return categoriaautorizacion;
	}

	public void setCategoriaautorizacion(String categoriaautorizacion) {
		this.categoriaautorizacion = categoriaautorizacion;
	}

	public BigDecimal getTipohorario() {
		if (UValidador.esNulo(tipohorario)) {
			tipohorario = BigDecimal.valueOf(0.0);
		}
		return tipohorario;
	}

	public void setTipohorario(BigDecimal tipohorario) {
		this.tipohorario = tipohorario;
	}

	public String getMotivorechazo() {
		return motivorechazo;
	}

	public void setMotivorechazo(String motivorechazo) {
		this.motivorechazo = motivorechazo;
	}

	public String getFlagcorrido() {
		return flagcorrido;
	}

	public void setFlagcorrido(String flagcorrido) {
		this.flagcorrido = flagcorrido;
	}

	public BigDecimal getTerminal() {
		if (UValidador.esNulo(terminal)) {
			terminal = BigDecimal.valueOf(0.0);
		}
		return terminal;
	}

	public void setTerminal(BigDecimal terminal) {
		this.terminal = terminal;
	}

	public String getRutadocumento() {
		return rutadocumento;
	}

	public void setRutadocumento(String rutadocumento) {
		this.rutadocumento = rutadocumento;
	}

	// public byte[] getRuta() {
	// return ruta;
	// }
	//
	// public void setRuta(byte[] ruta) {
	// this.ruta = ruta;
	// }

	public String getNroresolucion() {
		return nroresolucion;
	}

	public void setNroresolucion(String nroresolucion) {
		this.nroresolucion = nroresolucion;
	}

	public AsAutorizacionPk getPk() {
		return pk;
	}

	public void setPk(AsAutorizacionPk pk) {
		this.pk = pk;
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

	public String getRechazadopor() {
		return rechazadopor;
	}

	public void setRechazadopor(String rechazadopor) {
		this.rechazadopor = rechazadopor;
	}

	public Date getFecharechazo() {
		return fecharechazo;
	}

	public void setFecharechazo(Date fecharechazo) {
		this.fecharechazo = fecharechazo;
	}

	public String getUuidalfresco() {
		return uuidalfresco;
	}

	public void setUuidalfresco(String uuidalfresco) {
		this.uuidalfresco = uuidalfresco;
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
		return flagAprobadoJefe;
	}

	public void setFlagAprobadoJefe(String flagAprobadoJefe) {
		this.flagAprobadoJefe = flagAprobadoJefe;
	}

	public String getAprobadoJefePor() {
		return aprobadoJefePor;
	}

	public void setAprobadoJefePor(String aprobadoJefePor) {
		this.aprobadoJefePor = aprobadoJefePor;
	}

	public Date getFechaAprobadoJefe() {
		return fechaAprobadoJefe;
	}

	public void setFechaAprobadoJefe(Date fechaAprobadoJefe) {
		this.fechaAprobadoJefe = fechaAprobadoJefe;
	}

	public String getFlgdj() {
		return flgdj;
	}

	public void setFlgdj(String flgdj) {
		this.flgdj = flgdj;
	}

	public String getUuiddj() {
		return uuiddj;
	}

	public void setUuiddj(String uuiddj) {
		this.uuiddj = uuiddj;
	}

	public String getNombrearchivodj() {
		return nombrearchivodj;
	}

	public void setNombrearchivodj(String nombrearchivodj) {
		this.nombrearchivodj = nombrearchivodj;
	}

}
