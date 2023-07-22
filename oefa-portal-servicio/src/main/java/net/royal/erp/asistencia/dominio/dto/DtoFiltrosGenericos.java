package net.royal.erp.asistencia.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

public class DtoFiltrosGenericos {
	private String CodAreaOperativa;
	private String codCategoria;
	private String codCentroCosto;
	private String codCompania;
	private String codPlantilla;
	private String codInactivos;
	private String codPuesto;
	private String codOficina;
	private String codigo;
	private String estado;
	private String codigodescripciontext;
	private String codigodescripcionflag;
	private String descripcion;
	private Date fecha;
	private String ano;
	private BigDecimal idrow;
	private String desCompania;
	private String desInactivos;
	private String desOficina;
	private String desPlantilla;
	private String desPuesto;
	private String desCategoria;
	private String desAreaOperativa;
	private BigDecimal empleado;
	private String nombreCompleto;
	private String desCentroCosto;
	private String codEmpleado;
	private String codSucursal;
	private String desSucursal;
	private String conceptoacceso;
	private String centroCosto;
	private boolean cesados;
	private Integer version;
	private Boolean isseleccionados;

	private Boolean isvarioscompania;
	private Boolean isvarioscentrocosto;
	private Boolean isvariostipoplanilla;
	private Boolean isvariosareaoperativa;
	private Boolean isvariossucursal;
	private Boolean isvariospuesto;

	private String centroCostoMultiple;
	private String codEmpleadoMUltiple;

	private String mes;
	private boolean nogeneraasistencia;

	public String getDesCentroCosto() {
		return desCentroCosto;
	}

	public void setDesCentroCosto(String desCentroCosto) {
		this.desCentroCosto = desCentroCosto;
	}

	public String getDesPuesto() {
		return desPuesto;
	}

	public void setDesPuesto(String desPuesto) {
		this.desPuesto = desPuesto;
	}

	public String getDesCategoria() {
		return desCategoria;
	}

	public void setDesCategoria(String desCategoria) {
		this.desCategoria = desCategoria;
	}

	public String getDesAreaOperativa() {
		return desAreaOperativa;
	}

	public void setDesAreaOperativa(String desAreaOperativa) {
		this.desAreaOperativa = desAreaOperativa;
	}

	public BigDecimal getEmpleado() {
		if(UValidador.esNulo(empleado)){
			empleado = BigDecimal.ZERO;
		}
		return empleado;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public void setEmpleado(BigDecimal empleado) {
		this.empleado = empleado;
	}

	public BigDecimal getIdrow() {
		return idrow;
	}

	public void setIdrow(BigDecimal idrow) {
		this.idrow = idrow;
	}

	public String getDesCompania() {
		return desCompania;
	}

	public void setDesCompania(String desCompania) {
		this.desCompania = desCompania;
	}

	public String getDesInactivos() {
		return desInactivos;
	}

	public void setDesInactivos(String desInactivos) {
		this.desInactivos = desInactivos;
	}

	public String getDesOficina() {
		return desOficina;
	}

	public void setDesOficina(String desOficina) {
		this.desOficina = desOficina;
	}

	public String getDesPlantilla() {
		return desPlantilla;
	}

	public void setDesPlantilla(String desPlantilla) {
		this.desPlantilla = desPlantilla;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	private Date fechadesde;
	private Date fechahasta;

	public String getCodigodescripciontext() {
		return codigodescripciontext;
	}

	public void setCodigodescripciontext(String codigodescripciontext) {
		this.codigodescripciontext = codigodescripciontext;
	}

	public String getCodigodescripcionflag() {
		return codigodescripcionflag;
	}

	public void setCodigodescripcionflag(String codigodescripcionflag) {
		this.codigodescripcionflag = codigodescripcionflag;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodCompania() {
		return codCompania;
	}

	public void setCodCompania(String codCompania) {
		this.codCompania = codCompania;
	}

	public String getCodPlantilla() {
		return codPlantilla;
	}

	public void setCodPlantilla(String codPlantilla) {
		this.codPlantilla = codPlantilla;
	}

	public String getCodInactivos() {
		return codInactivos;
	}

	public void setCodInactivos(String codInactivos) {
		this.codInactivos = codInactivos;
	}

	public String getCodPuesto() {
		return codPuesto;
	}

	public void setCodPuesto(String codPuesto) {
		this.codPuesto = codPuesto;
	}

	public String getCodOficina() {
		return codOficina;
	}

	public void setCodOficina(String codOficina) {
		this.codOficina = codOficina;
	}

	public String getCodCentroCosto() {
		return codCentroCosto;
	}

	public void setCodCentroCosto(String codCentroCosto) {
		this.codCentroCosto = codCentroCosto;
	}

	public String getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(String codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getCodAreaOperativa() {
		return CodAreaOperativa;
	}

	public void setCodAreaOperativa(String codAreaOperativa) {
		CodAreaOperativa = codAreaOperativa;
	}

	/**
	 * @return the codEmpleado
	 */
	public String getCodEmpleado() {
		return codEmpleado;
	}

	/**
	 * @param codEmpleado
	 *            the codEmpleado to set
	 */
	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	/**
	 * @return the codSucursal
	 */
	public String getCodSucursal() {
		return codSucursal;
	}

	/**
	 * @param codSucursal
	 *            the codSucursal to set
	 */
	public void setCodSucursal(String codSucursal) {
		this.codSucursal = codSucursal;
	}

	/**
	 * @return the desSucursal
	 */
	public String getDesSucursal() {
		return desSucursal;
	}

	/**
	 * @param desSucursal
	 *            the desSucursal to set
	 */
	public void setDesSucursal(String desSucursal) {
		this.desSucursal = desSucursal;
	}

	/**
	 * @return the conceptoacceso
	 */
	public String getConceptoacceso() {
		return conceptoacceso;
	}

	/**
	 * @param conceptoacceso
	 *            the conceptoacceso to set
	 */
	public void setConceptoacceso(String conceptoacceso) {
		this.conceptoacceso = conceptoacceso;
	}

	public boolean isCesados() {
		return cesados;
	}

	public void setCesados(boolean cesados) {
		this.cesados = cesados;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the isseleccionados
	 */
	public Boolean getIsseleccionados() {
		if (UValidador.esNulo(isseleccionados)) {
			isseleccionados = false;
		}
		return isseleccionados;
	}

	/**
	 * @param isseleccionados
	 *            the isseleccionados to set
	 */
	public void setIsseleccionados(Boolean isseleccionados) {
		this.isseleccionados = isseleccionados;
	}

	/**
	 * @return the isvarioscentrocosto
	 */
	public Boolean getIsvarioscentrocosto() {
		return isvarioscentrocosto;
	}

	/**
	 * @param isvarioscentrocosto
	 *            the isvarioscentrocosto to set
	 */
	public void setIsvarioscentrocosto(Boolean isvarioscentrocosto) {
		this.isvarioscentrocosto = isvarioscentrocosto;
	}

	/**
	 * @return the isvariostipoplanilla
	 */
	public Boolean getIsvariostipoplanilla() {
		return isvariostipoplanilla;
	}

	/**
	 * @param isvariostipoplanilla
	 *            the isvariostipoplanilla to set
	 */
	public void setIsvariostipoplanilla(Boolean isvariostipoplanilla) {
		this.isvariostipoplanilla = isvariostipoplanilla;
	}

	/**
	 * @return the isvariosareaoperativa
	 */
	public Boolean getIsvariosareaoperativa() {
		return isvariosareaoperativa;
	}

	/**
	 * @param isvariosareaoperativa
	 *            the isvariosareaoperativa to set
	 */
	public void setIsvariosareaoperativa(Boolean isvariosareaoperativa) {
		this.isvariosareaoperativa = isvariosareaoperativa;
	}

	/**
	 * @return the isvariossucursal
	 */
	public Boolean getIsvariossucursal() {
		return isvariossucursal;
	}

	/**
	 * @param isvariossucursal
	 *            the isvariossucursal to set
	 */
	public void setIsvariossucursal(Boolean isvariossucursal) {
		this.isvariossucursal = isvariossucursal;
	}

	/**
	 * @return the isvariospuesto
	 */
	public Boolean getIsvariospuesto() {
		return isvariospuesto;
	}

	/**
	 * @param isvariospuesto
	 *            the isvariospuesto to set
	 */
	public void setIsvariospuesto(Boolean isvariospuesto) {
		this.isvariospuesto = isvariospuesto;
	}

	/**
	 * @return the isvarioscompania
	 */
	public Boolean getIsvarioscompania() {
		return isvarioscompania;
	}

	/**
	 * @param isvarioscompania
	 *            the isvarioscompania to set
	 */
	public void setIsvarioscompania(Boolean isvarioscompania) {
		this.isvarioscompania = isvarioscompania;
	}

	public String getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(String centroCosto) {
		this.centroCosto = centroCosto;
	}

	public String getCentroCostoMultiple() {
		return centroCostoMultiple;
	}

	public void setCentroCostoMultiple(String centroCostoMultiple) {
		this.centroCostoMultiple = centroCostoMultiple;
	}

	public String getCodEmpleadoMUltiple() {
		return codEmpleadoMUltiple;
	}

	public void setCodEmpleadoMUltiple(String codEmpleadoMUltiple) {
		this.codEmpleadoMUltiple = codEmpleadoMUltiple;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public boolean isNogeneraasistencia() {
		return nogeneraasistencia;
	}

	public void setNogeneraasistencia(boolean nogeneraasistencia) {
		this.nogeneraasistencia = nogeneraasistencia;
	}

}
