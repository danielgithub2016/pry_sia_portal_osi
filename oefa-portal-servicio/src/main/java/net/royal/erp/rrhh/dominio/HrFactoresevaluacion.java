package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrFactoresevaluacion
*/
public class HrFactoresevaluacion extends DominioGenerico implements java.io.Serializable{

	private HrFactoresevaluacionPk pk;
	private String plantilla;
	private String area;
	private String descripcion;
	private String descripcioningles;
	private String flagconcepto;
	private String tipovalor;
	private Integer valorminimo;
	private Integer valormaximo;
	private String estado;
	private String unidadnegocio;
	private String flagplantilla;
	private Integer ordenplantilla;
	private String flagdesempenio;
	private String flagcapacitacion;
	private String flagreclutamiento;
	private String flagpuntajegeneral;
	private String explicacion;
	private String flagpotencial;
	private String tipocompetencia;
	private String nivelcompetencia;
	private Integer valorrequerido;
	private Integer valorminimoesperado;
	private String flagentrevista;
	private String flagcompetencia;
	private String flagcalificacion;
	private String companyowner;
	private String tipo;
	private String familiapuestoeval;
	private Integer factorant;

	public HrFactoresevaluacion() {
		pk = new HrFactoresevaluacionPk();
	}

	public HrFactoresevaluacionPk getPk() {
		return pk;
	}

	public void setPk(HrFactoresevaluacionPk pk) {
		this.pk = pk;
	}
	public String getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(String plantilla) {
		this.plantilla = plantilla;
	}
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcioningles() {
		return descripcioningles;
	}

	public void setDescripcioningles(String descripcioningles) {
		this.descripcioningles = descripcioningles;
	}
	public String getFlagconcepto() {
		return flagconcepto;
	}

	public void setFlagconcepto(String flagconcepto) {
		this.flagconcepto = flagconcepto;
	}
	public String getTipovalor() {
		return tipovalor;
	}

	public void setTipovalor(String tipovalor) {
		this.tipovalor = tipovalor;
	}
	public Integer getValorminimo() {
		return valorminimo;
	}

	public void setValorminimo(Integer valorminimo) {
		this.valorminimo = valorminimo;
	}
	public Integer getValormaximo() {
		return valormaximo;
	}

	public void setValormaximo(Integer valormaximo) {
		this.valormaximo = valormaximo;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	public String getFlagplantilla() {
		return flagplantilla;
	}

	public void setFlagplantilla(String flagplantilla) {
		this.flagplantilla = flagplantilla;
	}
	public Integer getOrdenplantilla() {
		return ordenplantilla;
	}

	public void setOrdenplantilla(Integer ordenplantilla) {
		this.ordenplantilla = ordenplantilla;
	}
	public String getFlagdesempenio() {
		return flagdesempenio;
	}

	public void setFlagdesempenio(String flagdesempenio) {
		this.flagdesempenio = flagdesempenio;
	}
	public String getFlagcapacitacion() {
		return flagcapacitacion;
	}

	public void setFlagcapacitacion(String flagcapacitacion) {
		this.flagcapacitacion = flagcapacitacion;
	}
	public String getFlagreclutamiento() {
		return flagreclutamiento;
	}

	public void setFlagreclutamiento(String flagreclutamiento) {
		this.flagreclutamiento = flagreclutamiento;
	}
	public String getFlagpuntajegeneral() {
		return flagpuntajegeneral;
	}

	public void setFlagpuntajegeneral(String flagpuntajegeneral) {
		this.flagpuntajegeneral = flagpuntajegeneral;
	}
	public String getExplicacion() {
		return explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}
	public String getFlagpotencial() {
		return flagpotencial;
	}

	public void setFlagpotencial(String flagpotencial) {
		this.flagpotencial = flagpotencial;
	}
	public String getTipocompetencia() {
		return tipocompetencia;
	}

	public void setTipocompetencia(String tipocompetencia) {
		this.tipocompetencia = tipocompetencia;
	}
	public String getNivelcompetencia() {
		return nivelcompetencia;
	}

	public void setNivelcompetencia(String nivelcompetencia) {
		this.nivelcompetencia = nivelcompetencia;
	}
	public Integer getValorrequerido() {
		return valorrequerido;
	}

	public void setValorrequerido(Integer valorrequerido) {
		this.valorrequerido = valorrequerido;
	}
	public Integer getValorminimoesperado() {
		return valorminimoesperado;
	}

	public void setValorminimoesperado(Integer valorminimoesperado) {
		this.valorminimoesperado = valorminimoesperado;
	}
	public String getFlagentrevista() {
		return flagentrevista;
	}

	public void setFlagentrevista(String flagentrevista) {
		this.flagentrevista = flagentrevista;
	}
	public String getFlagcompetencia() {
		return flagcompetencia;
	}

	public void setFlagcompetencia(String flagcompetencia) {
		this.flagcompetencia = flagcompetencia;
	}
	public String getFlagcalificacion() {
		return flagcalificacion;
	}

	public void setFlagcalificacion(String flagcalificacion) {
		this.flagcalificacion = flagcalificacion;
	}
	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFamiliapuestoeval() {
		return familiapuestoeval;
	}

	public void setFamiliapuestoeval(String familiapuestoeval) {
		this.familiapuestoeval = familiapuestoeval;
	}

	public Integer getFactorant() {
		return factorant;
	}

	public void setFactorant(Integer factorant) {
		this.factorant = factorant;
	}

}
