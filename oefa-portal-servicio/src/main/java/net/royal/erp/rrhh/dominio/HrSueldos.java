package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrSueldos
*/
public class HrSueldos extends DominioGenerico implements java.io.Serializable{

	private HrSueldosPk pk;
	private String monedapago;
	private String monedapagoant;
	private Integer sueldoant;
	private Integer sueldo;
	private String gradosalario;
	private String gradosalarioanterior;
	private Integer codigopuesto;
	private Integer codigopuestoanterior;
	private Integer responsable;
	private String descripcion;
	private String numerodocumento;
	private java.util.Date fecha;
	private String unidadnegocio;
	private String tipoplanilla;
	private String centrocostosanterior;
	private String companiasocio;
	private String companiasocioanterior;
	private Integer posicionorganigrama;
	private Integer posicionorganigramaanterior;
	private String tipoaccion;
	private String centrocostos;
	private String locacion;
	private String locacionanterior;
	private String tipoplanillaanterior;
	private Integer tipocambio;
	private String documentofiscal;
	private String flagporcentaje;
	private String flagporcentajeanterior;
	private Integer porcentaje;
	private Integer porcentajeanterior;
	private String flagjefedepartamento;
	private Integer jefedepartamento;
	private String flagjefedepartamentoanterior;
	private Integer jefedepartamentoanterior;
	private String sucursal;
	private String sucursalanterior;
	private String centrocostotexto;
	private String puestotexto;
	private String estado;
	private String documentointerno;
	private java.util.Date fecharesolucion;
	private Integer resolucion;
	private String costcenterclasification;
	private String cargoant;
	private String afe;
	private String afeanterior;
	private java.util.Date fechacategorizacion;
	private String departamentooperacionalant;
	private String departamentooperacional;
	private String cargo;
	private String nivelremunerativo;
	private String nivelremunerativoant;
	private String tipocargo;
	private String tipocargoant;
	private Integer cliente;
	private Integer clienteant;
	private java.util.Date fechafin;
	private Integer dptoareaoperativa;
	private Integer dptoareaoperativaant;
	private String periodomov;
	private java.util.Date fechafincontratoanterior;
	private Integer nivel1Ant;
	private Integer nivel2Ant;
	private Integer nivel3Ant;
	private Integer nivel1;
	private Integer nivel2;
	private Integer nivel3;
	private String codigoproceso;
	private Integer numeroproceso;
	private String motivoRechazo;
	private Integer nivelaprobacion;


	public HrSueldos() {
		pk = new HrSueldosPk();
	}

	public HrSueldosPk getPk() {
		return pk;
	}

	public void setPk(HrSueldosPk pk) {
		this.pk = pk;
	}
	public String getMonedapago() {
		return monedapago;
	}

	public void setMonedapago(String monedapago) {
		this.monedapago = monedapago;
	}
	public String getMonedapagoant() {
		return monedapagoant;
	}

	public void setMonedapagoant(String monedapagoant) {
		this.monedapagoant = monedapagoant;
	}
	public Integer getSueldoant() {
		return sueldoant;
	}

	public void setSueldoant(Integer sueldoant) {
		this.sueldoant = sueldoant;
	}
	public Integer getSueldo() {
		return sueldo;
	}

	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}
	public String getGradosalario() {
		return gradosalario;
	}

	public void setGradosalario(String gradosalario) {
		this.gradosalario = gradosalario;
	}
	public String getGradosalarioanterior() {
		return gradosalarioanterior;
	}

	public void setGradosalarioanterior(String gradosalarioanterior) {
		this.gradosalarioanterior = gradosalarioanterior;
	}
	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}
	public Integer getCodigopuestoanterior() {
		return codigopuestoanterior;
	}

	public void setCodigopuestoanterior(Integer codigopuestoanterior) {
		this.codigopuestoanterior = codigopuestoanterior;
	}
	public Integer getResponsable() {
		return responsable;
	}

	public void setResponsable(Integer responsable) {
		this.responsable = responsable;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}
	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}
	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	public String getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}
	public String getCentrocostosanterior() {
		return centrocostosanterior;
	}

	public void setCentrocostosanterior(String centrocostosanterior) {
		this.centrocostosanterior = centrocostosanterior;
	}
	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}
	public String getCompaniasocioanterior() {
		return companiasocioanterior;
	}

	public void setCompaniasocioanterior(String companiasocioanterior) {
		this.companiasocioanterior = companiasocioanterior;
	}
	public Integer getPosicionorganigrama() {
		return posicionorganigrama;
	}

	public void setPosicionorganigrama(Integer posicionorganigrama) {
		this.posicionorganigrama = posicionorganigrama;
	}
	public Integer getPosicionorganigramaanterior() {
		return posicionorganigramaanterior;
	}

	public void setPosicionorganigramaanterior(Integer posicionorganigramaanterior) {
		this.posicionorganigramaanterior = posicionorganigramaanterior;
	}
	public String getTipoaccion() {
		return tipoaccion;
	}

	public void setTipoaccion(String tipoaccion) {
		this.tipoaccion = tipoaccion;
	}
	public String getCentrocostos() {
		return centrocostos;
	}

	public void setCentrocostos(String centrocostos) {
		this.centrocostos = centrocostos;
	}
	public String getLocacion() {
		return locacion;
	}

	public void setLocacion(String locacion) {
		this.locacion = locacion;
	}
	public String getLocacionanterior() {
		return locacionanterior;
	}

	public void setLocacionanterior(String locacionanterior) {
		this.locacionanterior = locacionanterior;
	}
	public String getTipoplanillaanterior() {
		return tipoplanillaanterior;
	}

	public void setTipoplanillaanterior(String tipoplanillaanterior) {
		this.tipoplanillaanterior = tipoplanillaanterior;
	}
	public Integer getTipocambio() {
		return tipocambio;
	}

	public void setTipocambio(Integer tipocambio) {
		this.tipocambio = tipocambio;
	}
	public String getDocumentofiscal() {
		return documentofiscal;
	}

	public void setDocumentofiscal(String documentofiscal) {
		this.documentofiscal = documentofiscal;
	}
	public String getFlagporcentaje() {
		return flagporcentaje;
	}

	public void setFlagporcentaje(String flagporcentaje) {
		this.flagporcentaje = flagporcentaje;
	}
	public String getFlagporcentajeanterior() {
		return flagporcentajeanterior;
	}

	public void setFlagporcentajeanterior(String flagporcentajeanterior) {
		this.flagporcentajeanterior = flagporcentajeanterior;
	}
	public Integer getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Integer porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Integer getPorcentajeanterior() {
		return porcentajeanterior;
	}

	public void setPorcentajeanterior(Integer porcentajeanterior) {
		this.porcentajeanterior = porcentajeanterior;
	}
	public String getFlagjefedepartamento() {
		return flagjefedepartamento;
	}

	public void setFlagjefedepartamento(String flagjefedepartamento) {
		this.flagjefedepartamento = flagjefedepartamento;
	}
	public Integer getJefedepartamento() {
		return jefedepartamento;
	}

	public void setJefedepartamento(Integer jefedepartamento) {
		this.jefedepartamento = jefedepartamento;
	}
	public String getFlagjefedepartamentoanterior() {
		return flagjefedepartamentoanterior;
	}

	public void setFlagjefedepartamentoanterior(String flagjefedepartamentoanterior) {
		this.flagjefedepartamentoanterior = flagjefedepartamentoanterior;
	}
	public Integer getJefedepartamentoanterior() {
		return jefedepartamentoanterior;
	}

	public void setJefedepartamentoanterior(Integer jefedepartamentoanterior) {
		this.jefedepartamentoanterior = jefedepartamentoanterior;
	}
	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public String getSucursalanterior() {
		return sucursalanterior;
	}

	public void setSucursalanterior(String sucursalanterior) {
		this.sucursalanterior = sucursalanterior;
	}
	public String getCentrocostotexto() {
		return centrocostotexto;
	}

	public void setCentrocostotexto(String centrocostotexto) {
		this.centrocostotexto = centrocostotexto;
	}
	public String getPuestotexto() {
		return puestotexto;
	}

	public void setPuestotexto(String puestotexto) {
		this.puestotexto = puestotexto;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDocumentointerno() {
		return documentointerno;
	}

	public void setDocumentointerno(String documentointerno) {
		this.documentointerno = documentointerno;
	}
	public java.util.Date getFecharesolucion() {
		return fecharesolucion;
	}

	public void setFecharesolucion(java.util.Date fecharesolucion) {
		this.fecharesolucion = fecharesolucion;
	}
	public Integer getResolucion() {
		return resolucion;
	}

	public void setResolucion(Integer resolucion) {
		this.resolucion = resolucion;
	}
	public String getCostcenterclasification() {
		return costcenterclasification;
	}

	public void setCostcenterclasification(String costcenterclasification) {
		this.costcenterclasification = costcenterclasification;
	}
	public String getCargoant() {
		return cargoant;
	}

	public void setCargoant(String cargoant) {
		this.cargoant = cargoant;
	}
	public String getAfe() {
		return afe;
	}

	public void setAfe(String afe) {
		this.afe = afe;
	}
	public String getAfeanterior() {
		return afeanterior;
	}

	public void setAfeanterior(String afeanterior) {
		this.afeanterior = afeanterior;
	}
	public java.util.Date getFechacategorizacion() {
		return fechacategorizacion;
	}

	public void setFechacategorizacion(java.util.Date fechacategorizacion) {
		this.fechacategorizacion = fechacategorizacion;
	}
	public String getDepartamentooperacionalant() {
		return departamentooperacionalant;
	}

	public void setDepartamentooperacionalant(String departamentooperacionalant) {
		this.departamentooperacionalant = departamentooperacionalant;
	}
	public String getDepartamentooperacional() {
		return departamentooperacional;
	}

	public void setDepartamentooperacional(String departamentooperacional) {
		this.departamentooperacional = departamentooperacional;
	}
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getNivelremunerativo() {
		return nivelremunerativo;
	}

	public void setNivelremunerativo(String nivelremunerativo) {
		this.nivelremunerativo = nivelremunerativo;
	}
	public String getNivelremunerativoant() {
		return nivelremunerativoant;
	}

	public void setNivelremunerativoant(String nivelremunerativoant) {
		this.nivelremunerativoant = nivelremunerativoant;
	}
	public String getTipocargo() {
		return tipocargo;
	}

	public void setTipocargo(String tipocargo) {
		this.tipocargo = tipocargo;
	}
	public String getTipocargoant() {
		return tipocargoant;
	}

	public void setTipocargoant(String tipocargoant) {
		this.tipocargoant = tipocargoant;
	}
	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}
	public Integer getClienteant() {
		return clienteant;
	}

	public void setClienteant(Integer clienteant) {
		this.clienteant = clienteant;
	}
	public java.util.Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(java.util.Date fechafin) {
		this.fechafin = fechafin;
	}
	public Integer getDptoareaoperativa() {
		return dptoareaoperativa;
	}

	public void setDptoareaoperativa(Integer dptoareaoperativa) {
		this.dptoareaoperativa = dptoareaoperativa;
	}
	public Integer getDptoareaoperativaant() {
		return dptoareaoperativaant;
	}

	public void setDptoareaoperativaant(Integer dptoareaoperativaant) {
		this.dptoareaoperativaant = dptoareaoperativaant;
	}
	public String getPeriodomov() {
		return periodomov;
	}

	public void setPeriodomov(String periodomov) {
		this.periodomov = periodomov;
	}
	public java.util.Date getFechafincontratoanterior() {
		return fechafincontratoanterior;
	}

	public void setFechafincontratoanterior(java.util.Date fechafincontratoanterior) {
		this.fechafincontratoanterior = fechafincontratoanterior;
	}
	public Integer getNivel1Ant() {
		return nivel1Ant;
	}

	public void setNivel1Ant(Integer nivel1Ant) {
		this.nivel1Ant = nivel1Ant;
	}
	public Integer getNivel2Ant() {
		return nivel2Ant;
	}

	public void setNivel2Ant(Integer nivel2Ant) {
		this.nivel2Ant = nivel2Ant;
	}
	public Integer getNivel3Ant() {
		return nivel3Ant;
	}

	public void setNivel3Ant(Integer nivel3Ant) {
		this.nivel3Ant = nivel3Ant;
	}
	public Integer getNivel1() {
		return nivel1;
	}

	public void setNivel1(Integer nivel1) {
		this.nivel1 = nivel1;
	}
	public Integer getNivel2() {
		return nivel2;
	}

	public void setNivel2(Integer nivel2) {
		this.nivel2 = nivel2;
	}
	public Integer getNivel3() {
		return nivel3;
	}

	public void setNivel3(Integer nivel3) {
		this.nivel3 = nivel3;
	}
	public String getCodigoproceso() {
		return codigoproceso;
	}

	public void setCodigoproceso(String codigoproceso) {
		this.codigoproceso = codigoproceso;
	}
	public Integer getNumeroproceso() {
		return numeroproceso;
	}

	public void setNumeroproceso(Integer numeroproceso) {
		this.numeroproceso = numeroproceso;
	}
	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}
	public Integer getNivelaprobacion() {
		return nivelaprobacion;
	}

	public void setNivelaprobacion(Integer nivelaprobacion) {
		this.nivelaprobacion = nivelaprobacion;
	}

}
