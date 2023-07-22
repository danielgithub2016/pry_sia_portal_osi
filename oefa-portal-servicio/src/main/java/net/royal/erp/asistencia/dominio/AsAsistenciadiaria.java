package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsAsistenciadiaria
*/
public class AsAsistenciadiaria extends DominioGenerico implements java.io.Serializable{

	private AsAsistenciadiariaPk pk;
	private java.util.Date desde;
	private java.util.Date hasta;
	private String periodo;
	private java.util.Date hora;
	private String conceptoacceso;
	private String conjustificacion;
	private String conceptojustificacion;
	private String tipojustificacion;
	private java.math.BigDecimal cantidadhoras;
	private java.util.Date horaoficial;
	private String observaciones;
	private String estado;
	private java.math.BigDecimal cantidad;
	private String conceptoaccesosistema;
	private String justificacion;
	private String conceptosistema;
	private java.util.Date horainiciodia;
	private java.util.Date horafindia;
	private Integer tipodia;
	private java.math.BigDecimal cantidadreal;
	private String origen;
	private String flagcompensacion;
	private java.util.Date horariohasta;
	private java.util.Date horariodesde;
	private String flaganteshorario;


	public AsAsistenciadiaria() {
		pk = new AsAsistenciadiariaPk();
	}

	public AsAsistenciadiariaPk getPk() {
		return pk;
	}

	public void setPk(AsAsistenciadiariaPk pk) {
		this.pk = pk;
	}
	public java.util.Date getDesde() {
		return desde;
	}

	public void setDesde(java.util.Date desde) {
		this.desde = desde;
	}
	public java.util.Date getHasta() {
		return hasta;
	}

	public void setHasta(java.util.Date hasta) {
		this.hasta = hasta;
	}
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public java.util.Date getHora() {
		return hora;
	}

	public void setHora(java.util.Date hora) {
		this.hora = hora;
	}
	public String getConceptoacceso() {
		return conceptoacceso;
	}

	public void setConceptoacceso(String conceptoacceso) {
		this.conceptoacceso = conceptoacceso;
	}
	public String getConjustificacion() {
		return conjustificacion;
	}

	public void setConjustificacion(String conjustificacion) {
		this.conjustificacion = conjustificacion;
	}
	public String getConceptojustificacion() {
		return conceptojustificacion;
	}

	public void setConceptojustificacion(String conceptojustificacion) {
		this.conceptojustificacion = conceptojustificacion;
	}
	public String getTipojustificacion() {
		return tipojustificacion;
	}

	public void setTipojustificacion(String tipojustificacion) {
		this.tipojustificacion = tipojustificacion;
	}
	public java.math.BigDecimal getCantidadhoras() {
		return cantidadhoras;
	}

	public void setCantidadhoras(java.math.BigDecimal cantidadhoras) {
		this.cantidadhoras = cantidadhoras;
	}
	public java.util.Date getHoraoficial() {
		return horaoficial;
	}

	public void setHoraoficial(java.util.Date horaoficial) {
		this.horaoficial = horaoficial;
	}
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public java.math.BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(java.math.BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public String getConceptoaccesosistema() {
		return conceptoaccesosistema;
	}

	public void setConceptoaccesosistema(String conceptoaccesosistema) {
		this.conceptoaccesosistema = conceptoaccesosistema;
	}
	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	public String getConceptosistema() {
		return conceptosistema;
	}

	public void setConceptosistema(String conceptosistema) {
		this.conceptosistema = conceptosistema;
	}
	public java.util.Date getHorainiciodia() {
		return horainiciodia;
	}

	public void setHorainiciodia(java.util.Date horainiciodia) {
		this.horainiciodia = horainiciodia;
	}
	public java.util.Date getHorafindia() {
		return horafindia;
	}

	public void setHorafindia(java.util.Date horafindia) {
		this.horafindia = horafindia;
	}
	public Integer getTipodia() {
		return tipodia;
	}

	public void setTipodia(Integer tipodia) {
		this.tipodia = tipodia;
	}
	public java.math.BigDecimal getCantidadreal() {
		return cantidadreal;
	}

	public void setCantidadreal(java.math.BigDecimal cantidadreal) {
		this.cantidadreal = cantidadreal;
	}
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getFlagcompensacion() {
		return flagcompensacion;
	}

	public void setFlagcompensacion(String flagcompensacion) {
		this.flagcompensacion = flagcompensacion;
	}
	public java.util.Date getHorariohasta() {
		return horariohasta;
	}

	public void setHorariohasta(java.util.Date horariohasta) {
		this.horariohasta = horariohasta;
	}
	public java.util.Date getHorariodesde() {
		return horariodesde;
	}

	public void setHorariodesde(java.util.Date horariodesde) {
		this.horariodesde = horariodesde;
	}
	public String getFlaganteshorario() {
		return flaganteshorario;
	}

	public void setFlaganteshorario(String flaganteshorario) {
		this.flaganteshorario = flaganteshorario;
	}

}
