package net.royal.erp.rrhh.hrproc.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.erp.rrhh.dominio.dto.DtoTipoPlanilla;
import net.royal.erp.sistema.dominio.dto.DtoDwMaCompanyownerSelect;

public class DtoDwHrRequerimientoPosition {

	private String numero;
	private Date fechadesde;
	private Date fechahasta;
	private String estado;
	private BigDecimal area;
	private boolean all_numero;
	private boolean all_fecha;
	private boolean all_estado;
	private boolean all_area;
	private HrPuestoempresa codigopuesto;
	private boolean all_codigopuesto;
	private DtoDwMaCompanyownerSelect companyowner;
	private String compania;
	private boolean all_companyowner;
	private boolean all_convocatoria;
	private String convocatoria;
	private boolean all_concurso;
	private BigDecimal concurso;
	private boolean all_desierto;
	private String desierto;
	private String nombreEstado;
	private String description;
	private String tipoplanilla;
	private String tiporequer;
	private Integer persona_reclu;
	

	public DtoDwHrRequerimientoPosition() {
		companyowner = new DtoDwMaCompanyownerSelect();
		codigopuesto = new HrPuestoempresa();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFechadesde() {
		return fechadesde;
	}

	public void setFechadesde(Date fechadesde) {
		this.fechadesde = fechadesde;
	}

	public Date getFechahasta() {
		return fechahasta;
	}

	public void setFechahasta(Date fechahasta) {
		this.fechahasta = fechahasta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public boolean isAll_numero() {
		return all_numero;
	}

	public void setAll_numero(boolean all_numero) {
		numero = null;
		this.all_numero = all_numero;
	}

	public boolean isAll_fecha() {
		return all_fecha;
	}

	public void setAll_fecha(boolean all_fecha) {
		fechadesde = new Date();
		fechahasta = new Date();
		this.all_fecha = all_fecha;
	}

	public boolean isAll_estado() {
		return all_estado;
	}

	public void setAll_estado(boolean all_estado) {
		estado = null;
		this.all_estado = all_estado;
	}

	public boolean isAll_area() {
		return all_area;
	}

	public void setAll_area(boolean all_area) {
		area = null;
		this.all_area = all_area;
	}

	public boolean isAll_codigopuesto() {
		return all_codigopuesto;
	}

	public void setAll_codigopuesto(boolean all_codigopuesto) {

		codigopuesto = new HrPuestoempresa();
		this.all_codigopuesto = all_codigopuesto;
	}

	public boolean isAll_companyowner() {
		return all_companyowner;
	}

	public void setAll_companyowner(boolean all_companyowner) {
		companyowner = new DtoDwMaCompanyownerSelect();
		this.all_companyowner = all_companyowner;
	}

	public boolean isAll_convocatoria() {
		return all_convocatoria;
	}

	public void setAll_convocatoria(boolean all_convocatoria) {
		convocatoria = null;
		this.all_convocatoria = all_convocatoria;
	}

	public String getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(String convocatoria) {
		this.convocatoria = convocatoria;
	}

	public boolean isAll_concurso() {
		return all_concurso;
	}

	public void setAll_concurso(boolean all_concurso) {
		concurso = BigDecimal.ZERO;
		this.all_concurso = all_concurso;
	}

	public BigDecimal getConcurso() {
		return concurso;
	}

	public void setConcurso(BigDecimal concurso) {
		this.concurso = concurso;
	}

	public boolean isAll_desierto() {
		return all_desierto;
	}

	public void setAll_desierto(boolean all_desierto) {
		desierto = null;
		this.all_desierto = all_desierto;
	}

	public String getDesierto() {
		return desierto;
	}

	public void setDesierto(String desierto) {
		this.desierto = desierto;
	}

	public DtoDwMaCompanyownerSelect getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(DtoDwMaCompanyownerSelect companyowner) {
		this.companyowner = companyowner;
	}

	public String getNombreEstado() {
		if (estado.equals("PR")) {
			nombreEstado = "En Preparación";
		} else if (estado.equals("AP")) {
			nombreEstado = "Aprobado";
		} else if (estado.equals("RV")) {
			nombreEstado = "En Revisión";
		} else if (estado.equals("RE")) {
			nombreEstado = "Rechazado";
		} else {
			nombreEstado = null;
		}

		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		estado = null;
		this.nombreEstado = nombreEstado;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HrPuestoempresa getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(HrPuestoempresa codigopuesto) {
		this.codigopuesto = codigopuesto;
	}

	/**
	 * @return the compania
	 */
	public String getCompania() {
		return compania;
	}

	/**
	 * @param compania the compania to set
	 */
	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

	public String getTiporequer() {
		return tiporequer;
	}

	public void setTiporequer(String tiporequer) {
		this.tiporequer = tiporequer;
	}

	public Integer getPersona_reclu() {
		return persona_reclu;
	}

	public void setPersona_reclu(Integer persona_reclu) {
		this.persona_reclu = persona_reclu;
	}
	
	

}
