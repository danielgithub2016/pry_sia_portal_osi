package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.DominioGenerico;

import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrTipocontrato
 */
public class HrTipocontrato extends DominioGenerico implements
		java.io.Serializable {

	private HrTipocontratoPk pk;
	private String descripcion;
	private String flagplanillas;
	private String flagfechavencimiento;
	private String flagservice;
	private String estado;
	private String flagpracticas;
	private String tiempovencimiento;
	private String carta;
	private String tipocontratortps;
	private String codigoauxiliar;
	private String flagtiempoparcial;
	private String tipocontratoanterior;
	private String tieneperiodoprueba;

	public HrTipocontrato() {
		pk = new HrTipocontratoPk();
	}

	public HrTipocontratoPk getPk() {
		return pk;
	}

	public void setPk(HrTipocontratoPk pk) {
		this.pk = pk;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFlagplanillas() {
		return flagplanillas;
	}

	public void setFlagplanillas(String flagplanillas) {
		this.flagplanillas = flagplanillas;
	}

	public String getFlagfechavencimiento() {
		if (UValidador.estaVacio(flagfechavencimiento)) {
			flagfechavencimiento = "N";
		}
		return flagfechavencimiento;
	}

	public void setFlagfechavencimiento(String flagfechavencimiento) {
		this.flagfechavencimiento = flagfechavencimiento;
	}

	public String getFlagservice() {
		return flagservice;
	}

	public void setFlagservice(String flagservice) {
		this.flagservice = flagservice;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFlagpracticas() {
		return flagpracticas;
	}

	public void setFlagpracticas(String flagpracticas) {
		this.flagpracticas = flagpracticas;
	}

	public String getTiempovencimiento() {
		return tiempovencimiento;
	}

	public void setTiempovencimiento(String tiempovencimiento) {
		this.tiempovencimiento = tiempovencimiento;
	}

	public String getCarta() {
		return carta;
	}

	public void setCarta(String carta) {
		this.carta = carta;
	}

	public String getTipocontratortps() {
		return tipocontratortps;
	}

	public void setTipocontratortps(String tipocontratortps) {
		this.tipocontratortps = tipocontratortps;
	}

	public String getCodigoauxiliar() {
		return codigoauxiliar;
	}

	public void setCodigoauxiliar(String codigoauxiliar) {
		this.codigoauxiliar = codigoauxiliar;
	}

	public String getFlagtiempoparcial() {
		return flagtiempoparcial;
	}

	public void setFlagtiempoparcial(String flagtiempoparcial) {
		this.flagtiempoparcial = flagtiempoparcial;
	}

	public String getTipocontratoanterior() {
		return tipocontratoanterior;
	}

	public void setTipocontratoanterior(String tipocontratoanterior) {
		this.tipocontratoanterior = tipocontratoanterior;
	}

	public String getTieneperiodoprueba() {
		if (UValidador.estaVacio(tieneperiodoprueba)) {
			tieneperiodoprueba = "";
		}
		return tieneperiodoprueba;
	}

	public void setTieneperiodoprueba(String tieneperiodoprueba) {
		this.tieneperiodoprueba = tieneperiodoprueba;
	}

}
