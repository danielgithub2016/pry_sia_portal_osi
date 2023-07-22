package net.royal.erp.asistencia.asmain.dominio.dto;

import java.util.Date;

import net.royal.framework.web.core.UValidador;

/**
 *
 * @author desarrollo
 * @powerbuilder asmain.dw_as_autorizacion_preproceso_hextraedit_v2
 */
public class DtoDwAsAutorizacionPreprocesoHextraeditV2 implements java.io.Serializable {

	private Integer empleado;
	private String empleadonombre;
	private String estado;
	private String estadoai; // estado autorizacion incial
	private String solicitadopor;
	private Date fechasolicitud;
	private Date fecha;
	private Date fechafin;
	private Date desde1;
	private Date hasta1;
	private String comportamientosobretiempo;
	private String conceptoacceso;
	private String autorizadopor;
	private Date fechaautorizacion;
	private String observacion;
	private String categoriaautorizacion;
	private Date desde2;
	private Date hasta2;
	private Integer tipohorario;
	private Integer terminal;
	private String periodo;
	private String mandatario;
	private String refrigerio;

	private String ultimousuario;
	private Date ultimafechamodif;
	private String corrido;

	private String puesto;
	private String centrocosto;
	private String rutadocumento;
	private String nroresolucion;
	private Date fecharesolucion;

	private byte[] archivodata;
	private boolean tienearchivo;
	private String tipoautorizacion;

	private Date fecharechazo;
	private String rechazadopor;

	private String solicitadopornombre;
	private String rechazadopornombre;
	private String autorizadopornombre;
	private String ultimousuarionombre;

	private String uuidalfresco;

	private String rutacompleta;
	private String rutacompletadj;
	private Date desderecupera;
	private Date hastarecupera;
	private String periodoplanilla;

	// campos para la aprobacion de jefe
	private String flagAprobadoJefe;
	private String aprobadoJefePor;
	private String aprobadoJefePorNombre;
	private Date fechaAprobadoJefe;
	
	private String nombrearchivodj;
	private String uuiddj;
	private String flagdj;
	/**
	 * @return the empleado
	 */
	public Integer getEmpleado() {
		return empleado;
	}

	/**
	 * @param empleado
	 *            the empleado to set
	 */
	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	/**
	 * @return the empleadonombre
	 */
	public String getEmpleadonombre() {
		return empleadonombre;
	}

	/**
	 * @param empleadonombre
	 *            the empleadonombre to set
	 */
	public void setEmpleadonombre(String empleadonombre) {
		this.empleadonombre = empleadonombre;
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
	 * @return the solicitadopor
	 */
	public String getSolicitadopor() {
		return solicitadopor;
	}

	/**
	 * @param solicitadopor
	 *            the solicitadopor to set
	 */
	public void setSolicitadopor(String solicitadopor) {
		this.solicitadopor = solicitadopor;
	}

	/**
	 * @return the fechasolicitud
	 */
	public Date getFechasolicitud() {
		return fechasolicitud;
	}

	/**
	 * @param fechasolicitud
	 *            the fechasolicitud to set
	 */
	public void setFechasolicitud(Date fechasolicitud) {
		this.fechasolicitud = fechasolicitud;
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
	 * @return the comportamientosobretiempo
	 */
	public String getComportamientosobretiempo() {
		return comportamientosobretiempo;
	}

	/**
	 * @param comportamientosobretiempo
	 *            the comportamientosobretiempo to set
	 */
	public void setComportamientosobretiempo(String comportamientosobretiempo) {
		this.comportamientosobretiempo = comportamientosobretiempo;
	}

	/**
	 * @return the conceptoacceso
	 */
	public String getConceptoacceso() {
		if (UValidador.esNulo(conceptoacceso)) {
			conceptoacceso = "";
		}
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
	 * @return the autorizadopor
	 */
	public String getAutorizadopor() {
		return autorizadopor;
	}

	/**
	 * @param autorizadopor
	 *            the autorizadopor to set
	 */
	public void setAutorizadopor(String autorizadopor) {
		this.autorizadopor = autorizadopor;
	}

	/**
	 * @return the fechaautorizacion
	 */
	public Date getFechaautorizacion() {
		return fechaautorizacion;
	}

	/**
	 * @param fechaautorizacion
	 *            the fechaautorizacion to set
	 */
	public void setFechaautorizacion(Date fechaautorizacion) {
		this.fechaautorizacion = fechaautorizacion;
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
	 * @return the categoriaautorizacion
	 */
	public String getCategoriaautorizacion() {
		if (UValidador.estaVacio(categoriaautorizacion)) {
			categoriaautorizacion = "";
		}
		return categoriaautorizacion;
	}

	/**
	 * @param categoriaautorizacion
	 *            the categoriaautorizacion to set
	 */
	public void setCategoriaautorizacion(String categoriaautorizacion) {
		this.categoriaautorizacion = categoriaautorizacion;
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
	 * @return the tipohorario
	 */
	public Integer getTipohorario() {
		return tipohorario;
	}

	/**
	 * @param tipohorario
	 *            the tipohorario to set
	 */
	public void setTipohorario(Integer tipohorario) {
		this.tipohorario = tipohorario;
	}

	/**
	 * @return the terminal
	 */
	public Integer getTerminal() {
		return terminal;
	}

	/**
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(Integer terminal) {
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
	 * @return the mandatario
	 */
	public String getMandatario() {
		return mandatario;
	}

	/**
	 * @param mandatario
	 *            the mandatario to set
	 */
	public void setMandatario(String mandatario) {
		this.mandatario = mandatario;
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
	 * @return the ultimousuario
	 */
	public String getUltimousuario() {
		return ultimousuario;
	}

	/**
	 * @param ultimousuario
	 *            the ultimousuario to set
	 */
	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	/**
	 * @return the ultimafechamodif
	 */
	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	/**
	 * @param ultimafechamodif
	 *            the ultimafechamodif to set
	 */
	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

	/**
	 * @return the corrido
	 */
	public String getCorrido() {
		return corrido;
	}

	/**
	 * @param corrido
	 *            the corrido to set
	 */
	public void setCorrido(String corrido) {
		this.corrido = corrido;
	}

	/**
	 * @return the puesto
	 */
	public String getPuesto() {
		return puesto;
	}

	/**
	 * @param puesto
	 *            the puesto to set
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	/**
	 * @return the centrocosto
	 */
	public String getCentrocosto() {
		return centrocosto;
	}

	/**
	 * @param centrocosto
	 *            the centrocosto to set
	 */
	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}

	/**
	 * @return the rutadocumento
	 */
	public String getRutadocumento() {
		return rutadocumento;
	}

	/**
	 * @param rutadocumento
	 *            the rutadocumento to set
	 */
	public void setRutadocumento(String rutadocumento) {
		this.rutadocumento = rutadocumento;
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

	public byte[] getArchivodata() {
		return archivodata;
	}

	public void setArchivodata(byte[] archivodata) {
		this.archivodata = archivodata;
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
	 * @return the tienearchivo
	 */
	public boolean isTienearchivo() {
		return tienearchivo;
	}

	/**
	 * @param tienearchivo
	 *            the tienearchivo to set
	 */
	public void setTienearchivo(boolean tienearchivo) {
		this.tienearchivo = tienearchivo;
	}

	public String getTipoautorizacion() {
		return tipoautorizacion;
	}

	public void setTipoautorizacion(String tipoautorizacion) {
		this.tipoautorizacion = tipoautorizacion;
	}

	public Date getFecharechazo() {
		return fecharechazo;
	}

	public void setFecharechazo(Date fecharechazo) {
		this.fecharechazo = fecharechazo;
	}

	public String getRechazadopor() {
		return rechazadopor;
	}

	public void setRechazadopor(String rechazadopor) {
		this.rechazadopor = rechazadopor;
	}

	public String getSolicitadopornombre() {
		return solicitadopornombre;
	}

	public void setSolicitadopornombre(String solicitadopornombre) {
		this.solicitadopornombre = solicitadopornombre;
	}

	public String getRechazadopornombre() {
		return rechazadopornombre;
	}

	public void setRechazadopornombre(String rechazadopornombre) {
		this.rechazadopornombre = rechazadopornombre;
	}

	public String getAutorizadopornombre() {
		return autorizadopornombre;
	}

	public void setAutorizadopornombre(String autorizadopornombre) {
		this.autorizadopornombre = autorizadopornombre;
	}

	public String getUltimousuarionombre() {
		return ultimousuarionombre;
	}

	public void setUltimousuarionombre(String ultimousuarionombre) {
		this.ultimousuarionombre = ultimousuarionombre;
	}

	public String getUuidalfresco() {
		return uuidalfresco;
	}

	public void setUuidalfresco(String uuidalfresco) {
		this.uuidalfresco = uuidalfresco;
	}

	public String getRutacompleta() {
		return rutacompleta;
	}

	public void setRutacompleta(String rutacompleta) {
		this.rutacompleta = rutacompleta;
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

	public String getAprobadoJefePorNombre() {
		return aprobadoJefePorNombre;
	}

	public void setAprobadoJefePorNombre(String aprobadoJefePorNombre) {
		this.aprobadoJefePorNombre = aprobadoJefePorNombre;
	}

	public String getNombrearchivodj() {
		return nombrearchivodj;
	}

	public void setNombrearchivodj(String nombrearchivodj) {
		this.nombrearchivodj = nombrearchivodj;
	}

	public String getUuiddj() {
		return uuiddj;
	}

	public void setUuiddj(String uuiddj) {
		this.uuiddj = uuiddj;
	}

	public String getFlagdj() {
		return flagdj;
	}

	public void setFlagdj(String flagdj) {
		this.flagdj = flagdj;
	}

	public String getRutacompletadj() {
		return rutacompletadj;
	}

	public void setRutacompletadj(String rutacompletadj) {
		this.rutacompletadj = rutacompletadj;
	}
	
}
