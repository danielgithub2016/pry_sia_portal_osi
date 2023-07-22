package net.royal.erp.planilla.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.erp.rrhh.dominio.dto.DtoTipoPlanilla;
import net.royal.erp.sistema.dominio.dto.DtoDwMaCompanyownerSelect;

public class DtoDwPrCtsPosition {

	private String numero;
	private Date fechadesde;
	private Date fechahasta;
	private String estado;	
	private boolean all_numero;
	private boolean all_fecha;
	private boolean all_estado;
	private boolean all_area;
	private boolean all_unidadnegocio;
	private boolean all_companyowner;
	private boolean all_centrocosto;
	private boolean all_tipoplanilla;
	private boolean all_cesados;
	private boolean all_tipo;
	private DtoDwMaCompanyownerSelect companyowner;
	private String compania;
	private String centrocosto;	
	private String unidadnegocio;
	private String area;
	private String documento;
	private String filtro;
	private String tipoplanilla;
	private String tipo;
	private String moneda;
	private BigDecimal periodoinicio;
	private BigDecimal periodofin;
	

	public DtoDwPrCtsPosition() {
		companyowner = new DtoDwMaCompanyownerSelect();
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

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
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

	public boolean isAll_companyowner() {
		return all_companyowner;
	}

	public void setAll_companyowner(boolean all_companyowner) {
		companyowner = new DtoDwMaCompanyownerSelect();
		this.all_companyowner = all_companyowner;
	}

	public DtoDwMaCompanyownerSelect getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(DtoDwMaCompanyownerSelect companyowner) {
		this.companyowner = companyowner;
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

	public boolean isAll_centrocosto() {
		return all_centrocosto;
	}

	public void setAll_centrocosto(boolean all_centrocosto) {
		centrocosto=null;
		this.all_centrocosto = all_centrocosto;
	}

	public String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}

	public boolean isAll_unidadnegocio() {
		return all_unidadnegocio;
	}

	public void setAll_unidadnegocio(boolean all_unidadnegocio) {
		unidadnegocio=null;
		this.all_unidadnegocio = all_unidadnegocio;
	}


	public boolean isAll_tipoplanilla() {
		return all_tipoplanilla;
	}

	public void setAll_tipoplanilla(boolean all_tipoplanilla) {
		tipoplanilla=null;
		this.all_tipoplanilla = all_tipoplanilla;
	}

	public boolean isAll_cesados() {
		return all_cesados;
	}

	public void setAll_cesados(boolean all_cesados) {
		this.all_cesados = all_cesados;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getPeriodoinicio() {
		return periodoinicio;
	}

	public void setPeriodoinicio(BigDecimal periodoinicio) {
		this.periodoinicio = periodoinicio;
	}

	public BigDecimal getPeriodofin() {
		return periodofin;
	}

	public void setPeriodofin(BigDecimal periodofin) {
		this.periodofin = periodofin;
	}

	public boolean isAll_tipo() {
		return all_tipo;
	}

	public void setAll_tipo(boolean all_tipo) {
		this.all_tipo = all_tipo;
	}
	
	

}
