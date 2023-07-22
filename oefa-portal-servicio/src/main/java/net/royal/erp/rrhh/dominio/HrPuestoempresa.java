package net.royal.erp.rrhh.dominio;

import java.math.BigDecimal;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestoempresa
 */
@SuppressWarnings("serial")
public class HrPuestoempresa extends DominioGenerico implements java.io.Serializable {

	private HrPuestoempresaPk pk;
	private Integer numerovacantes;
	private String gradosalario;
	private String descripcion;
	private String descripcioningles;
	private String comentarios;
	private String estado;
	private String unidadnegocio;
	private String unidadreplicacion;
	private Integer tipopuesto;
	private String categoriafuncional;
	private Integer puestosuperior;
	private String plantillaevaluacion;
	private Integer plantilladocumento;
	private String codanterior;
	private String codigocap;
	private String descripcioncap;
	private Integer grupoocupacional;
	private String plantillapotencial;
	private String codigortps;
	private String plantillaentregas;
	private String lineacarrera;
	private String cflagesdirectivo;
	private String cflagesconfianza;
	private String clasificadorcargo;
	private String codigopuestoconfianza;
	private String profesional;
	private String codigoanterior;
	private String descripcionpuestoanterior;
	private String centrocosto;
	private BigDecimal cursominimo;
	private BigDecimal cursomaximo;
	private BigDecimal cursounitario;
	private BigDecimal experienciaminimo;
	private BigDecimal experienciamaximo;
	private BigDecimal experienciaunitario;
	private String familiapuesto;
	private String flagpuestopracticante;
	private Integer codigoposicion;
	private String rpt_formacion;
	private String rpt_experiencia;
	private String rpt_conocimientos;
	private String codigointerno;
	private String denominacion;
	private String flagddjj;
	private String xdigitalperpuestohrlsc;
	private String xdescperpuestohrlsc;

	public HrPuestoempresa() {
		pk = new HrPuestoempresaPk();
	}

	public HrPuestoempresaPk getPk() {
		return pk;
	}

	public void setPk(HrPuestoempresaPk pk) {
		this.pk = pk;
	}

	public Integer getNumerovacantes() {
		return numerovacantes;
	}

	public void setNumerovacantes(Integer numerovacantes) {
		this.numerovacantes = numerovacantes;
	}

	public String getGradosalario() {
		return gradosalario;
	}

	public void setGradosalario(String gradosalario) {
		this.gradosalario = gradosalario;
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

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
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

	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}

	public Integer getTipopuesto() {
		return tipopuesto;
	}

	public void setTipopuesto(Integer tipopuesto) {
		this.tipopuesto = tipopuesto;
	}

	public String getCategoriafuncional() {
		return categoriafuncional;
	}

	public void setCategoriafuncional(String categoriafuncional) {
		this.categoriafuncional = categoriafuncional;
	}

	public Integer getPuestosuperior() {
		return puestosuperior;
	}

	public void setPuestosuperior(Integer puestosuperior) {
		this.puestosuperior = puestosuperior;
	}

	public String getPlantillaevaluacion() {
		return plantillaevaluacion;
	}

	public void setPlantillaevaluacion(String plantillaevaluacion) {
		this.plantillaevaluacion = plantillaevaluacion;
	}

	public Integer getPlantilladocumento() {
		return plantilladocumento;
	}

	public void setPlantilladocumento(Integer plantilladocumento) {
		this.plantilladocumento = plantilladocumento;
	}

	public String getCodanterior() {
		return codanterior;
	}

	public void setCodanterior(String codanterior) {
		this.codanterior = codanterior;
	}

	public String getCodigocap() {
		return codigocap;
	}

	public void setCodigocap(String codigocap) {
		this.codigocap = codigocap;
	}

	public String getDescripcioncap() {
		return descripcioncap;
	}

	public void setDescripcioncap(String descripcioncap) {
		this.descripcioncap = descripcioncap;
	}

	public Integer getGrupoocupacional() {
		return grupoocupacional;
	}

	public void setGrupoocupacional(Integer grupoocupacional) {
		this.grupoocupacional = grupoocupacional;
	}

	public String getPlantillapotencial() {
		return plantillapotencial;
	}

	public void setPlantillapotencial(String plantillapotencial) {
		this.plantillapotencial = plantillapotencial;
	}

	public String getCodigortps() {
		return codigortps;
	}

	public void setCodigortps(String codigortps) {
		this.codigortps = codigortps;
	}

	public String getPlantillaentregas() {
		return plantillaentregas;
	}

	public void setPlantillaentregas(String plantillaentregas) {
		this.plantillaentregas = plantillaentregas;
	}

	public String getLineacarrera() {
		return lineacarrera;
	}

	public void setLineacarrera(String lineacarrera) {
		this.lineacarrera = lineacarrera;
	}

	public String getCflagesdirectivo() {
		return cflagesdirectivo;
	}

	public void setCflagesdirectivo(String cflagesdirectivo) {
		this.cflagesdirectivo = cflagesdirectivo;
	}

	public String getCflagesconfianza() {
		return cflagesconfianza;
	}

	public void setCflagesconfianza(String cflagesconfianza) {
		this.cflagesconfianza = cflagesconfianza;
	}

	public String getClasificadorcargo() {
		return clasificadorcargo;
	}

	public void setClasificadorcargo(String clasificadorcargo) {
		this.clasificadorcargo = clasificadorcargo;
	}

	public String getCodigopuestoconfianza() {
		return codigopuestoconfianza;
	}

	public void setCodigopuestoconfianza(String codigopuestoconfianza) {
		this.codigopuestoconfianza = codigopuestoconfianza;
	}

	public String getProfesional() {
		return profesional;
	}

	public void setProfesional(String profesional) {
		this.profesional = profesional;
	}

	public String getCodigoanterior() {
		return codigoanterior;
	}

	public void setCodigoanterior(String codigoanterior) {
		this.codigoanterior = codigoanterior;
	}

	public String getDescripcionpuestoanterior() {
		return descripcionpuestoanterior;
	}

	public void setDescripcionpuestoanterior(String descripcionpuestoanterior) {
		this.descripcionpuestoanterior = descripcionpuestoanterior;
	}

	public String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}

	public BigDecimal getCursominimo() {
		return cursominimo;
	}

	public void setCursominimo(BigDecimal cursominimo) {
		this.cursominimo = cursominimo;
	}

	public BigDecimal getCursomaximo() {
		return cursomaximo;
	}

	public void setCursomaximo(BigDecimal cursomaximo) {
		this.cursomaximo = cursomaximo;
	}

	public BigDecimal getCursounitario() {
		return cursounitario;
	}

	public void setCursounitario(BigDecimal cursounitario) {
		this.cursounitario = cursounitario;
	}

	public BigDecimal getExperienciaminimo() {
		return experienciaminimo;
	}

	public void setExperienciaminimo(BigDecimal experienciaminimo) {
		this.experienciaminimo = experienciaminimo;
	}

	public BigDecimal getExperienciamaximo() {
		return experienciamaximo;
	}

	public void setExperienciamaximo(BigDecimal experienciamaximo) {
		this.experienciamaximo = experienciamaximo;
	}

	public BigDecimal getExperienciaunitario() {
		return experienciaunitario;
	}

	public void setExperienciaunitario(BigDecimal experienciaunitario) {
		this.experienciaunitario = experienciaunitario;
	}

	public String getFamiliapuesto() {
		return familiapuesto;
	}

	public void setFamiliapuesto(String familiapuesto) {
		this.familiapuesto = familiapuesto;
	}

	public String getFlagpuestopracticante() {
		return flagpuestopracticante;
	}

	public void setFlagpuestopracticante(String flagpuestopracticante) {
		this.flagpuestopracticante = flagpuestopracticante;
	}

	public Integer getCodigoposicion() {
		return codigoposicion;
	}

	public void setCodigoposicion(Integer codigoposicion) {
		this.codigoposicion = codigoposicion;
	}

	public String getRpt_formacion() {
		return rpt_formacion;
	}

	public void setRpt_formacion(String rpt_formacion) {
		this.rpt_formacion = rpt_formacion;
	}

	public String getRpt_experiencia() {
		return rpt_experiencia;
	}

	public void setRpt_experiencia(String rpt_experiencia) {
		this.rpt_experiencia = rpt_experiencia;
	}

	public String getRpt_conocimientos() {
		return rpt_conocimientos;
	}

	public void setRpt_conocimientos(String rpt_conocimientos) {
		this.rpt_conocimientos = rpt_conocimientos;
	}

	public String getCodigointerno() {
		return codigointerno;
	}

	public void setCodigointerno(String codigointerno) {
		this.codigointerno = codigointerno;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getFlagddjj() {
		return flagddjj;
	}

	public void setFlagddjj(String flagddjj) {
		this.flagddjj = flagddjj;
	}

	public String getXdigitalperpuestohrlsc() {
		return xdigitalperpuestohrlsc;
	}

	public void setXdigitalperpuestohrlsc(String xdigitalperpuestohrlsc) {
		this.xdigitalperpuestohrlsc = xdigitalperpuestohrlsc;
	}

	public String getXdescperpuestohrlsc() {
		return xdescperpuestohrlsc;
	}

	public void setXdescperpuestohrlsc(String xdescperpuestohrlsc) {
		this.xdescperpuestohrlsc = xdescperpuestohrlsc;
	}
	
}
