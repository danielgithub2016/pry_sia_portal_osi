package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.DominioGenerico;

import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEvaluacionperiodocriterio
 */
public class HrEvaluacionperiodocriterio extends DominioGenerico implements
		java.io.Serializable {

	private HrEvaluacionperiodocriterioPk pk;
	private String flagevaluacionintegral;
	private String flagdesempeno;
	private String flagmetas;
	private String flagnecesidadcapacita;
	private String flagrevisionmetas;
	private String flagpotencial;
	private String flagrevisionpotencial;
	private String flagconceptual;
	private String flagincidentescriticos;
	private String flagdesempenio;
	private String flagfunciones;
	private String flagdesempeno2;
	private String flagdespersonal;
	private String flagmedicion;
	private String flagnecesidadcapacita2;
	private String flagdecampo;
	private String flagrevision;
	private String flagcomentarios;
	private String flagmejora;
	private java.math.BigDecimal pesodesempeno2;
	private java.math.BigDecimal pesometas;

	public HrEvaluacionperiodocriterio() {
		pk = new HrEvaluacionperiodocriterioPk();
	}

	public HrEvaluacionperiodocriterioPk getPk() {
		return pk;
	}

	public void setPk(HrEvaluacionperiodocriterioPk pk) {
		this.pk = pk;
	}

	public String getFlagevaluacionintegral() {
		return flagevaluacionintegral;
	}

	public void setFlagevaluacionintegral(String flagevaluacionintegral) {
		this.flagevaluacionintegral = flagevaluacionintegral;
	}

	public String getFlagdesempeno() {
		if (UValidador.esNulo(flagdesempeno))
			flagdesempeno = "N";
		return flagdesempeno;
	}

	public void setFlagdesempeno(String flagdesempeno) {
		this.flagdesempeno = flagdesempeno;
	}

	public String getFlagmetas() {
		if (UValidador.esNulo(flagmetas))
			flagmetas = "N";
		return flagmetas;
	}

	public void setFlagmetas(String flagmetas) {
		this.flagmetas = flagmetas;
	}

	public String getFlagnecesidadcapacita() {
		if (UValidador.esNulo(flagnecesidadcapacita))
			flagnecesidadcapacita = "N";
		return flagnecesidadcapacita;
	}

	public void setFlagnecesidadcapacita(String flagnecesidadcapacita) {
		this.flagnecesidadcapacita = flagnecesidadcapacita;
	}

	public String getFlagrevisionmetas() {
		if (UValidador.esNulo(flagrevisionmetas))
			flagrevisionmetas = "N";
		return flagrevisionmetas;
	}

	public void setFlagrevisionmetas(String flagrevisionmetas) {
		this.flagrevisionmetas = flagrevisionmetas;
	}

	public String getFlagpotencial() {
		if (UValidador.esNulo(flagpotencial))
			flagpotencial = "N";
		return flagpotencial;
	}

	public void setFlagpotencial(String flagpotencial) {
		this.flagpotencial = flagpotencial;
	}

	public String getFlagrevisionpotencial() {
		if (UValidador.esNulo(flagrevisionpotencial))
			flagrevisionpotencial = "N";
		return flagrevisionpotencial;
	}

	public void setFlagrevisionpotencial(String flagrevisionpotencial) {
		this.flagrevisionpotencial = flagrevisionpotencial;
	}

	public String getFlagconceptual() {
		if (UValidador.esNulo(flagconceptual))
			flagconceptual = "N";
		return flagconceptual;
	}

	public void setFlagconceptual(String flagconceptual) {
		this.flagconceptual = flagconceptual;
	}

	public String getFlagincidentescriticos() {
		if (UValidador.esNulo(flagincidentescriticos))
			flagincidentescriticos = "N";
		return flagincidentescriticos;
	}

	public void setFlagincidentescriticos(String flagincidentescriticos) {
		this.flagincidentescriticos = flagincidentescriticos;
	}

	public String getFlagdesempenio() {
		if (UValidador.esNulo(flagdesempenio))
			flagdesempenio = "N";
		return flagdesempenio;
	}

	public void setFlagdesempenio(String flagdesempenio) {
		this.flagdesempenio = flagdesempenio;
	}

	public String getFlagfunciones() {
		if (UValidador.esNulo(flagfunciones))
			flagfunciones = "N";
		return flagfunciones;
	}

	public void setFlagfunciones(String flagfunciones) {
		this.flagfunciones = flagfunciones;
	}

	public String getFlagdesempeno2() {
		if (UValidador.esNulo(flagdesempeno2))
			flagdesempeno2 = "N";
		return flagdesempeno2;
	}

	public void setFlagdesempeno2(String flagdesempeno2) {
		this.flagdesempeno2 = flagdesempeno2;
	}

	public String getFlagdespersonal() {
		if (UValidador.esNulo(flagdespersonal))
			flagdespersonal = "N";
		return flagdespersonal;
	}

	public void setFlagdespersonal(String flagdespersonal) {
		this.flagdespersonal = flagdespersonal;
	}

	public String getFlagmedicion() {
		if (UValidador.esNulo(flagmedicion))
			flagmedicion = "N";
		return flagmedicion;
	}

	public void setFlagmedicion(String flagmedicion) {
		this.flagmedicion = flagmedicion;
	}

	public String getFlagnecesidadcapacita2() {
		if (UValidador.esNulo(flagnecesidadcapacita2))
			flagnecesidadcapacita2 = "N";
		return flagnecesidadcapacita2;
	}

	public void setFlagnecesidadcapacita2(String flagnecesidadcapacita2) {
		this.flagnecesidadcapacita2 = flagnecesidadcapacita2;
	}

	public String getFlagdecampo() {
		if (UValidador.esNulo(flagdecampo))
			flagdecampo = "N";
		return flagdecampo;
	}

	public void setFlagdecampo(String flagdecampo) {
		this.flagdecampo = flagdecampo;
	}

	public String getFlagrevision() {
		if (UValidador.esNulo(flagrevision))
			flagrevision = "N";
		return flagrevision;
	}

	public void setFlagrevision(String flagrevision) {
		this.flagrevision = flagrevision;
	}

	public String getFlagcomentarios() {
		if (UValidador.esNulo(flagcomentarios))
			flagcomentarios = "N";
		return flagcomentarios;
	}

	public void setFlagcomentarios(String flagcomentarios) {
		this.flagcomentarios = flagcomentarios;
	}

	public String getFlagmejora() {
		if (UValidador.esNulo(flagmejora))
			flagmejora = "N";
		return flagmejora;
	}

	public void setFlagmejora(String flagmejora) {
		this.flagmejora = flagmejora;
	}

	public java.math.BigDecimal getPesodesempeno2() {
		return pesodesempeno2;
	}

	public void setPesodesempeno2(java.math.BigDecimal pesodesempeno2) {
		this.pesodesempeno2 = pesodesempeno2;
	}

	public java.math.BigDecimal getPesometas() {
		return pesometas;
	}

	public void setPesometas(java.math.BigDecimal pesometas) {
		this.pesometas = pesometas;
	}

}
