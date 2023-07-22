package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsCarnetidentificacion
 */
public class AsCarnetidentificacion extends DominioGenerico implements
		java.io.Serializable {

	private AsCarnetidentificacionPk pk;
	private String site;
	private String secuencia;
	private String nivelacceso;
	private String apellidopaterno;
	private String apellidomaterno;
	private String nombres;
	private String tipodocumento;
	private String nrodocumento;
	private String estado;
	private Integer area;
	private String suspendido;
	private String nogeneraasistencia;
	private String tipohorario;
	private String flaghorasextras;
	private String diadescanso;
	private Integer visador;
	private String comportamientosobretiempo;
	private Integer solicitantealternativo;
	private String flagunamarca;
	private String flagnoimpresion;
	private java.util.Date fecemision;
	private java.util.Date feccaducidad;
	private String flagconfianza;
	private String flagtodocompensa;
	private String flagtodopaga;
	private String flgexonerasobr;

	public AsCarnetidentificacion() {
		pk = new AsCarnetidentificacionPk();
	}

	public AsCarnetidentificacionPk getPk() {
		return pk;
	}

	public void setPk(AsCarnetidentificacionPk pk) {
		this.pk = pk;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}

	public String getNivelacceso() {
		return nivelacceso;
	}

	public void setNivelacceso(String nivelacceso) {
		this.nivelacceso = nivelacceso;
	}

	public String getApellidopaterno() {
		return apellidopaterno;
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}

	public String getApellidomaterno() {
		return apellidomaterno;
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getNrodocumento() {
		return nrodocumento;
	}

	public void setNrodocumento(String nrodocumento) {
		this.nrodocumento = nrodocumento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public String getSuspendido() {
		return suspendido;
	}

	public void setSuspendido(String suspendido) {
		this.suspendido = suspendido;
	}

	public String getNogeneraasistencia() {
		return nogeneraasistencia;
	}

	public void setNogeneraasistencia(String nogeneraasistencia) {
		this.nogeneraasistencia = nogeneraasistencia;
	}

	public String getTipohorario() {
		return tipohorario;
	}

	public void setTipohorario(String tipohorario) {
		this.tipohorario = tipohorario;
	}

	public String getFlaghorasextras() {
		return flaghorasextras;
	}

	public void setFlaghorasextras(String flaghorasextras) {
		this.flaghorasextras = flaghorasextras;
	}

	public String getDiadescanso() {
		return diadescanso;
	}

	public void setDiadescanso(String diadescanso) {
		this.diadescanso = diadescanso;
	}

	public Integer getVisador() {
		return visador;
	}

	public void setVisador(Integer visador) {
		this.visador = visador;
	}

	public String getComportamientosobretiempo() {
		return comportamientosobretiempo;
	}

	public void setComportamientosobretiempo(String comportamientosobretiempo) {
		this.comportamientosobretiempo = comportamientosobretiempo;
	}

	public Integer getSolicitantealternativo() {
		return solicitantealternativo;
	}

	public void setSolicitantealternativo(Integer solicitantealternativo) {
		this.solicitantealternativo = solicitantealternativo;
	}

	public String getFlagunamarca() {
		return flagunamarca;
	}

	public void setFlagunamarca(String flagunamarca) {
		this.flagunamarca = flagunamarca;
	}

	public String getFlagnoimpresion() {
		return flagnoimpresion;
	}

	public void setFlagnoimpresion(String flagnoimpresion) {
		this.flagnoimpresion = flagnoimpresion;
	}

	public java.util.Date getFecemision() {
		return fecemision;
	}

	public void setFecemision(java.util.Date fecemision) {
		this.fecemision = fecemision;
	}

	public java.util.Date getFeccaducidad() {
		return feccaducidad;
	}

	public void setFeccaducidad(java.util.Date feccaducidad) {
		this.feccaducidad = feccaducidad;
	}

	public String getFlagconfianza() {
		return flagconfianza;
	}

	public void setFlagconfianza(String flagconfianza) {
		this.flagconfianza = flagconfianza;
	}

	public String getFlagtodocompensa() {
		return flagtodocompensa;
	}

	public void setFlagtodocompensa(String flagtodocompensa) {
		this.flagtodocompensa = flagtodocompensa;
	}

	public String getFlagtodopaga() {
		return flagtodopaga;
	}

	public void setFlagtodopaga(String flagtodopaga) {
		this.flagtodopaga = flagtodopaga;
	}

	public String getFlgexonerasobr() {
		return flgexonerasobr;
	}

	public void setFlgexonerasobr(String flgexonerasobr) {
		this.flgexonerasobr = flgexonerasobr;
	}
	
}
