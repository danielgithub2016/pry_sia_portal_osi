package net.royal.erp.planilla.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder planilla.PrProcesoperiodo
*/
public class PrProcesoperiodo extends DominioGenerico implements java.io.Serializable{

	private PrProcesoperiodoPk pk;
	private String flagprocesado;
	private String flagperiodomensual;
	private Integer generador;
	private java.util.Date fechadesde;
	private java.util.Date fechahasta;
	private java.util.Date fechaproceso;
	private java.util.Date fechapago;
	private Integer diasdelmesanterior;
	private String estado;
	private String flagaprobado;
	private java.util.Date fechaaprobacion;
	private Integer aprobadopor;
	private String nrovoucher;
	private java.util.Date fechacierre;
	private Integer cerradopor;
	private Integer numerosemana;
	private String numerodocumentoprovision;
	private Integer feriados;
	private Integer finesdesemana;
	private Integer diferencia;
	private java.util.Date fechainiciodm;
	private java.util.Date fechafindm;


	public PrProcesoperiodo() {
		pk = new PrProcesoperiodoPk();
	}

	public PrProcesoperiodoPk getPk() {
		return pk;
	}

	public void setPk(PrProcesoperiodoPk pk) {
		this.pk = pk;
	}
	public String getFlagprocesado() {
		return flagprocesado;
	}

	public void setFlagprocesado(String flagprocesado) {
		this.flagprocesado = flagprocesado;
	}
	public String getFlagperiodomensual() {
		return flagperiodomensual;
	}

	public void setFlagperiodomensual(String flagperiodomensual) {
		this.flagperiodomensual = flagperiodomensual;
	}
	public Integer getGenerador() {
		return generador;
	}

	public void setGenerador(Integer generador) {
		this.generador = generador;
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
	public java.util.Date getFechaproceso() {
		return fechaproceso;
	}

	public void setFechaproceso(java.util.Date fechaproceso) {
		this.fechaproceso = fechaproceso;
	}
	public java.util.Date getFechapago() {
		return fechapago;
	}

	public void setFechapago(java.util.Date fechapago) {
		this.fechapago = fechapago;
	}
	public Integer getDiasdelmesanterior() {
		return diasdelmesanterior;
	}

	public void setDiasdelmesanterior(Integer diasdelmesanterior) {
		this.diasdelmesanterior = diasdelmesanterior;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFlagaprobado() {
		return flagaprobado;
	}

	public void setFlagaprobado(String flagaprobado) {
		this.flagaprobado = flagaprobado;
	}
	public java.util.Date getFechaaprobacion() {
		return fechaaprobacion;
	}

	public void setFechaaprobacion(java.util.Date fechaaprobacion) {
		this.fechaaprobacion = fechaaprobacion;
	}
	public Integer getAprobadopor() {
		return aprobadopor;
	}

	public void setAprobadopor(Integer aprobadopor) {
		this.aprobadopor = aprobadopor;
	}
	public String getNrovoucher() {
		return nrovoucher;
	}

	public void setNrovoucher(String nrovoucher) {
		this.nrovoucher = nrovoucher;
	}
	public java.util.Date getFechacierre() {
		return fechacierre;
	}

	public void setFechacierre(java.util.Date fechacierre) {
		this.fechacierre = fechacierre;
	}
	public Integer getCerradopor() {
		return cerradopor;
	}

	public void setCerradopor(Integer cerradopor) {
		this.cerradopor = cerradopor;
	}
	public Integer getNumerosemana() {
		return numerosemana;
	}

	public void setNumerosemana(Integer numerosemana) {
		this.numerosemana = numerosemana;
	}
	public String getNumerodocumentoprovision() {
		return numerodocumentoprovision;
	}

	public void setNumerodocumentoprovision(String numerodocumentoprovision) {
		this.numerodocumentoprovision = numerodocumentoprovision;
	}
	public Integer getFeriados() {
		return feriados;
	}

	public void setFeriados(Integer feriados) {
		this.feriados = feriados;
	}
	public Integer getFinesdesemana() {
		return finesdesemana;
	}

	public void setFinesdesemana(Integer finesdesemana) {
		this.finesdesemana = finesdesemana;
	}
	public Integer getDiferencia() {
		return diferencia;
	}

	public void setDiferencia(Integer diferencia) {
		this.diferencia = diferencia;
	}
	public java.util.Date getFechainiciodm() {
		return fechainiciodm;
	}

	public void setFechainiciodm(java.util.Date fechainiciodm) {
		this.fechainiciodm = fechainiciodm;
	}
	public java.util.Date getFechafindm() {
		return fechafindm;
	}

	public void setFechafindm(java.util.Date fechafindm) {
		this.fechafindm = fechafindm;
	}

}
