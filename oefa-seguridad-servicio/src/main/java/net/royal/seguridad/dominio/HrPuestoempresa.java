package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestoempresa
*/
public class HrPuestoempresa extends DominioGenerico implements java.io.Serializable{

	private HrPuestoempresaPk pk;
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
	private Integer cursominimo;
	private Integer cursomaximo;
	private Integer cursounitario;
	private Integer experienciaminimo;
	private Integer experienciamaximo;
	private Integer experienciaunitario;
	private String familiapuesto;
	private String flagpuestopracticante;
	private String rptconocimientos;
	private String rptexperiencia;
	private String rptformacion;
	private String auxflgAceptadeclaracion;


	public HrPuestoempresa() {
		pk = new HrPuestoempresaPk();
	}

	public HrPuestoempresaPk getPk() {
		return pk;
	}

	public void setPk(HrPuestoempresaPk pk) {
		this.pk = pk;
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
	public Integer getCursominimo() {
		return cursominimo;
	}

	public void setCursominimo(Integer cursominimo) {
		this.cursominimo = cursominimo;
	}
	public Integer getCursomaximo() {
		return cursomaximo;
	}

	public void setCursomaximo(Integer cursomaximo) {
		this.cursomaximo = cursomaximo;
	}
	public Integer getCursounitario() {
		return cursounitario;
	}

	public void setCursounitario(Integer cursounitario) {
		this.cursounitario = cursounitario;
	}
	public Integer getExperienciaminimo() {
		return experienciaminimo;
	}

	public void setExperienciaminimo(Integer experienciaminimo) {
		this.experienciaminimo = experienciaminimo;
	}
	public Integer getExperienciamaximo() {
		return experienciamaximo;
	}

	public void setExperienciamaximo(Integer experienciamaximo) {
		this.experienciamaximo = experienciamaximo;
	}
	public Integer getExperienciaunitario() {
		return experienciaunitario;
	}

	public void setExperienciaunitario(Integer experienciaunitario) {
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

	public String getRptconocimientos() {
		return rptconocimientos;
	}

	public void setRptconocimientos(String rptconocimientos) {
		this.rptconocimientos = rptconocimientos;
	}

	public String getRptexperiencia() {
		return rptexperiencia;
	}

	public void setRptexperiencia(String rptexperiencia) {
		this.rptexperiencia = rptexperiencia;
	}

	public String getRptformacion() {
		return rptformacion;
	}

	public void setRptformacion(String rptformacion) {
		this.rptformacion = rptformacion;
	}

	public String getAuxflgAceptadeclaracion() {
		return auxflgAceptadeclaracion;
	}

	public void setAuxflgAceptadeclaracion(String auxflgAceptadeclaracion) {
		this.auxflgAceptadeclaracion = auxflgAceptadeclaracion;
	}
	
}
