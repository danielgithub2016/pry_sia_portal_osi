package net.royal.erp.sistema.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_wh_requisition_header
 */
public class DtoDwWhRequisitionHeader implements java.io.Serializable {

	private String companiasocio;
	private String requisicionnumero;
	private String clasificacion;
	private String comprasalmacenflag;
	private String almacencodigo;
	private String monedacodigo;
	private Date fecharequerida;
	private Date fechapreparacion;
	private Date fecharevision;
	private Date fechaaprobacion;
	private Integer preparadapor;
	private Integer revisadapor;
	private Integer aprobadapor;
	private String responsable;
	private String departamento;
	private BigDecimal preciototal;
	private String prioridadcodigo;
	private String defaultprime1;
	private String defaultprime;
	private String defaultafe_1;
	private String defaultafe;
	private String cuantiamonetariapendienteflag;
	private String ordentrabajo;
	private String unidadnegocio;
	private String unidadreplicacion;
	private String localforeignflag;
	private String direcciondestino;
	private String comentarios;
	private String razonrechazo;
	private String estado;
	private String ultimousuario;
	private Date ultimafechamodif;
	private Integer ultimousuarionumero;
	private String transaccionoperacion;
	private String licitacionasignadaflag;
	private String revisionflujocodigo;
	private String revisiontecnicapendienteflag;
	private String defaultcamporeferencia;
	private Date fecharevisiontecnica;
	private Integer revisiontecnicapor;
	private String numeroorden;
	private Integer cliente;
	private String clientenumeropedido;
	private Integer proveedor;
	private String proveedordocumentoreferencia;
	private String anio;
	private Integer paac;
	private Integer nivelservicio;
	private String almacentraslado;
	private String unidadnegociocompra;
	private String cotizadoflag;
	private Integer revisionflujonivel;
	private String sucursal;
	private String certificacionnumero;
	private Boolean iscotizado;
	private String compute2;
	private String revisadapornombre;
	private String aprobadapornombre;

	// Obtiene el aumeta que reeplazará la meta
	// de la distribución
	private String auxmeta;
	private String auxmetanombre;
	private BigDecimal auxcodigometa;

	/**
	 * @return the companiasocio
	 */
	public String getCompaniasocio() {
		return companiasocio;
	}

	/**
	 * @param companiasocio
	 *            the companiasocio to set
	 */
	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

	/**
	 * @return the requisicionnumero
	 */
	public String getRequisicionnumero() {
		return requisicionnumero;
	}

	/**
	 * @param requisicionnumero
	 *            the requisicionnumero to set
	 */
	public void setRequisicionnumero(String requisicionnumero) {
		this.requisicionnumero = requisicionnumero;
	}

	/**
	 * @return the clasificacion
	 */
	public String getClasificacion() {
		return clasificacion;
	}

	/**
	 * @param clasificacion
	 *            the clasificacion to set
	 */
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	/**
	 * @return the comprasalmacenflag
	 */
	public String getComprasalmacenflag() {
		return comprasalmacenflag;
	}

	/**
	 * @param comprasalmacenflag
	 *            the comprasalmacenflag to set
	 */
	public void setComprasalmacenflag(String comprasalmacenflag) {
		this.comprasalmacenflag = comprasalmacenflag;
	}

	/**
	 * @return the almacencodigo
	 */
	public String getAlmacencodigo() {
		return almacencodigo;
	}

	/**
	 * @param almacencodigo
	 *            the almacencodigo to set
	 */
	public void setAlmacencodigo(String almacencodigo) {
		this.almacencodigo = almacencodigo;
	}

	/**
	 * @return the monedacodigo
	 */
	public String getMonedacodigo() {
		return monedacodigo;
	}

	/**
	 * @param monedacodigo
	 *            the monedacodigo to set
	 */
	public void setMonedacodigo(String monedacodigo) {
		this.monedacodigo = monedacodigo;
	}

	/**
	 * @return the fecharequerida
	 */
	public Date getFecharequerida() {
		return fecharequerida;
	}

	/**
	 * @param fecharequerida
	 *            the fecharequerida to set
	 */
	public void setFecharequerida(Date fecharequerida) {
		this.fecharequerida = fecharequerida;
	}

	/**
	 * @return the fechapreparacion
	 */
	public Date getFechapreparacion() {
		return fechapreparacion;
	}

	/**
	 * @param fechapreparacion
	 *            the fechapreparacion to set
	 */
	public void setFechapreparacion(Date fechapreparacion) {
		this.fechapreparacion = fechapreparacion;
	}

	/**
	 * @return the fecharevision
	 */
	public Date getFecharevision() {
		return fecharevision;
	}

	/**
	 * @param fecharevision
	 *            the fecharevision to set
	 */
	public void setFecharevision(Date fecharevision) {
		this.fecharevision = fecharevision;
	}

	/**
	 * @return the fechaaprobacion
	 */
	public Date getFechaaprobacion() {
		return fechaaprobacion;
	}

	/**
	 * @param fechaaprobacion
	 *            the fechaaprobacion to set
	 */
	public void setFechaaprobacion(Date fechaaprobacion) {
		this.fechaaprobacion = fechaaprobacion;
	}

	/**
	 * @return the preparadapor
	 */
	public Integer getPreparadapor() {
		return preparadapor;
	}

	/**
	 * @param preparadapor
	 *            the preparadapor to set
	 */
	public void setPreparadapor(Integer preparadapor) {
		this.preparadapor = preparadapor;
	}

	/**
	 * @return the revisadapor
	 */
	public Integer getRevisadapor() {
		return revisadapor;
	}

	/**
	 * @param revisadapor
	 *            the revisadapor to set
	 */
	public void setRevisadapor(Integer revisadapor) {
		this.revisadapor = revisadapor;
	}

	/**
	 * @return the aprobadapor
	 */
	public Integer getAprobadapor() {
		return aprobadapor;
	}

	/**
	 * @param aprobadapor
	 *            the aprobadapor to set
	 */
	public void setAprobadapor(Integer aprobadapor) {
		this.aprobadapor = aprobadapor;
	}

	/**
	 * @return the responsable
	 */
	public String getResponsable() {
		return responsable;
	}

	/**
	 * @param responsable
	 *            the responsable to set
	 */
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	/**
	 * @return the departamento
	 */
	public String getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento
	 *            the departamento to set
	 */
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	/**
	 * @return the preciototal
	 */
	public BigDecimal getPreciototal() {
		if (UValidador.esNulo(preciototal)) {
			preciototal = BigDecimal.valueOf(0.0);
		}
		return preciototal;
	}

	/**
	 * @param preciototal
	 *            the preciototal to set
	 */
	public void setPreciototal(BigDecimal preciototal) {
		this.preciototal = preciototal;
	}

	/**
	 * @return the prioridadcodigo
	 */
	public String getPrioridadcodigo() {
		return prioridadcodigo;
	}

	/**
	 * @param prioridadcodigo
	 *            the prioridadcodigo to set
	 */
	public void setPrioridadcodigo(String prioridadcodigo) {
		this.prioridadcodigo = prioridadcodigo;
	}

	/**
	 * @return the defaultprime
	 */
	public String getDefaultprime() {
		return defaultprime;
	}

	/**
	 * @param defaultprime
	 *            the defaultprime to set
	 */
	public void setDefaultprime(String defaultprime) {
		this.defaultprime = defaultprime;
	}

	/**
	 * @return the defaultafe
	 */
	public String getDefaultafe() {
		return defaultafe;
	}

	/**
	 * @param defaultafe
	 *            the defaultafe to set
	 */
	public void setDefaultafe(String defaultafe) {
		this.defaultafe = defaultafe;
	}

	/**
	 * @return the cuantiamonetariapendienteflag
	 */
	public String getCuantiamonetariapendienteflag() {
		return cuantiamonetariapendienteflag;
	}

	/**
	 * @param cuantiamonetariapendienteflag
	 *            the cuantiamonetariapendienteflag to set
	 */
	public void setCuantiamonetariapendienteflag(
			String cuantiamonetariapendienteflag) {
		this.cuantiamonetariapendienteflag = cuantiamonetariapendienteflag;
	}

	/**
	 * @return the ordentrabajo
	 */
	public String getOrdentrabajo() {
		return ordentrabajo;
	}

	/**
	 * @param ordentrabajo
	 *            the ordentrabajo to set
	 */
	public void setOrdentrabajo(String ordentrabajo) {
		this.ordentrabajo = ordentrabajo;
	}

	/**
	 * @return the unidadnegocio
	 */
	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	/**
	 * @param unidadnegocio
	 *            the unidadnegocio to set
	 */
	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	/**
	 * @return the unidadreplicacion
	 */
	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	/**
	 * @param unidadreplicacion
	 *            the unidadreplicacion to set
	 */
	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}

	/**
	 * @return the localforeignflag
	 */
	public String getLocalforeignflag() {
		return localforeignflag;
	}

	/**
	 * @param localforeignflag
	 *            the localforeignflag to set
	 */
	public void setLocalforeignflag(String localforeignflag) {
		this.localforeignflag = localforeignflag;
	}

	/**
	 * @return the direcciondestino
	 */
	public String getDirecciondestino() {
		return direcciondestino;
	}

	/**
	 * @param direcciondestino
	 *            the direcciondestino to set
	 */
	public void setDirecciondestino(String direcciondestino) {
		this.direcciondestino = direcciondestino;
	}

	/**
	 * @return the comentarios
	 */
	public String getComentarios() {
		return comentarios;
	}

	/**
	 * @param comentarios
	 *            the comentarios to set
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	/**
	 * @return the razonrechazo
	 */
	public String getRazonrechazo() {
		return razonrechazo;
	}

	/**
	 * @param razonrechazo
	 *            the razonrechazo to set
	 */
	public void setRazonrechazo(String razonrechazo) {
		this.razonrechazo = razonrechazo;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the ultimousuario
	 */
	public String getUltimousuario() {
		return ultimousuario;
	}

	/**
	 * @param ultimousuario
	 *            the ultimousuario to set
	 */
	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	/**
	 * @return the ultimafechamodif
	 */
	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	/**
	 * @param ultimafechamodif
	 *            the ultimafechamodif to set
	 */
	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

	/**
	 * @return the ultimousuarionumero
	 */
	public Integer getUltimousuarionumero() {
		return ultimousuarionumero;
	}

	/**
	 * @param ultimousuarionumero
	 *            the ultimousuarionumero to set
	 */
	public void setUltimousuarionumero(Integer ultimousuarionumero) {
		this.ultimousuarionumero = ultimousuarionumero;
	}

	/**
	 * @return the transaccionoperacion
	 */
	public String getTransaccionoperacion() {
		return transaccionoperacion;
	}

	/**
	 * @param transaccionoperacion
	 *            the transaccionoperacion to set
	 */
	public void setTransaccionoperacion(String transaccionoperacion) {
		this.transaccionoperacion = transaccionoperacion;
	}

	/**
	 * @return the licitacionasignadaflag
	 */
	public String getLicitacionasignadaflag() {
		return licitacionasignadaflag;
	}

	/**
	 * @param licitacionasignadaflag
	 *            the licitacionasignadaflag to set
	 */
	public void setLicitacionasignadaflag(String licitacionasignadaflag) {
		this.licitacionasignadaflag = licitacionasignadaflag;
	}

	/**
	 * @return the revisionflujocodigo
	 */
	public String getRevisionflujocodigo() {
		return revisionflujocodigo;
	}

	/**
	 * @param revisionflujocodigo
	 *            the revisionflujocodigo to set
	 */
	public void setRevisionflujocodigo(String revisionflujocodigo) {
		this.revisionflujocodigo = revisionflujocodigo;
	}

	/**
	 * @return the revisiontecnicapendienteflag
	 */
	public String getRevisiontecnicapendienteflag() {
		return revisiontecnicapendienteflag;
	}

	/**
	 * @param revisiontecnicapendienteflag
	 *            the revisiontecnicapendienteflag to set
	 */
	public void setRevisiontecnicapendienteflag(
			String revisiontecnicapendienteflag) {
		this.revisiontecnicapendienteflag = revisiontecnicapendienteflag;
	}

	/**
	 * @return the defaultcamporeferencia
	 */
	public String getDefaultcamporeferencia() {
		return defaultcamporeferencia;
	}

	/**
	 * @param defaultcamporeferencia
	 *            the defaultcamporeferencia to set
	 */
	public void setDefaultcamporeferencia(String defaultcamporeferencia) {
		this.defaultcamporeferencia = defaultcamporeferencia;
	}

	/**
	 * @return the fecharevisiontecnica
	 */
	public Date getFecharevisiontecnica() {
		return fecharevisiontecnica;
	}

	/**
	 * @param fecharevisiontecnica
	 *            the fecharevisiontecnica to set
	 */
	public void setFecharevisiontecnica(Date fecharevisiontecnica) {
		this.fecharevisiontecnica = fecharevisiontecnica;
	}

	/**
	 * @return the revisiontecnicapor
	 */
	public Integer getRevisiontecnicapor() {
		return revisiontecnicapor;
	}

	/**
	 * @param revisiontecnicapor
	 *            the revisiontecnicapor to set
	 */
	public void setRevisiontecnicapor(Integer revisiontecnicapor) {
		this.revisiontecnicapor = revisiontecnicapor;
	}

	/**
	 * @return the numeroorden
	 */
	public String getNumeroorden() {
		return numeroorden;
	}

	/**
	 * @param numeroorden
	 *            the numeroorden to set
	 */
	public void setNumeroorden(String numeroorden) {
		this.numeroorden = numeroorden;
	}

	/**
	 * @return the cliente
	 */
	public Integer getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the clientenumeropedido
	 */
	public String getClientenumeropedido() {
		return clientenumeropedido;
	}

	/**
	 * @param clientenumeropedido
	 *            the clientenumeropedido to set
	 */
	public void setClientenumeropedido(String clientenumeropedido) {
		this.clientenumeropedido = clientenumeropedido;
	}

	/**
	 * @return the proveedor
	 */
	public Integer getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor
	 *            the proveedor to set
	 */
	public void setProveedor(Integer proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * @return the proveedordocumentoreferencia
	 */
	public String getProveedordocumentoreferencia() {
		return proveedordocumentoreferencia;
	}

	/**
	 * @param proveedordocumentoreferencia
	 *            the proveedordocumentoreferencia to set
	 */
	public void setProveedordocumentoreferencia(
			String proveedordocumentoreferencia) {
		this.proveedordocumentoreferencia = proveedordocumentoreferencia;
	}

	/**
	 * @return the anio
	 */
	public String getAnio() {
		return anio;
	}

	/**
	 * @param anio
	 *            the anio to set
	 */
	public void setAnio(String anio) {
		this.anio = anio;
	}

	/**
	 * @return the paac
	 */
	public Integer getPaac() {
		return paac;
	}

	/**
	 * @param paac
	 *            the paac to set
	 */
	public void setPaac(Integer paac) {
		this.paac = paac;
	}

	/**
	 * @return the nivelservicio
	 */
	public Integer getNivelservicio() {
		return nivelservicio;
	}

	/**
	 * @param nivelservicio
	 *            the nivelservicio to set
	 */
	public void setNivelservicio(Integer nivelservicio) {
		this.nivelservicio = nivelservicio;
	}

	/**
	 * @return the almacentraslado
	 */
	public String getAlmacentraslado() {
		return almacentraslado;
	}

	/**
	 * @param almacentraslado
	 *            the almacentraslado to set
	 */
	public void setAlmacentraslado(String almacentraslado) {
		this.almacentraslado = almacentraslado;
	}

	/**
	 * @return the unidadnegociocompra
	 */
	public String getUnidadnegociocompra() {
		return unidadnegociocompra;
	}

	/**
	 * @param unidadnegociocompra
	 *            the unidadnegociocompra to set
	 */
	public void setUnidadnegociocompra(String unidadnegociocompra) {
		this.unidadnegociocompra = unidadnegociocompra;
	}

	/**
	 * @return the cotizadoflag
	 */
	public String getCotizadoflag() {
		return cotizadoflag;
	}

	/**
	 * @param cotizadoflag
	 *            the cotizadoflag to set
	 */
	public void setCotizadoflag(String cotizadoflag) {
		this.cotizadoflag = cotizadoflag;
	}

	/**
	 * @return the revisionflujonivel
	 */
	public Integer getRevisionflujonivel() {
		return revisionflujonivel;
	}

	/**
	 * @param revisionflujonivel
	 *            the revisionflujonivel to set
	 */
	public void setRevisionflujonivel(Integer revisionflujonivel) {
		this.revisionflujonivel = revisionflujonivel;
	}

	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal
	 *            the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the certificacionnumero
	 */
	public String getCertificacionnumero() {
		return certificacionnumero;
	}

	/**
	 * @param certificacionnumero
	 *            the certificacionnumero to set
	 */
	public void setCertificacionnumero(String certificacionnumero) {
		this.certificacionnumero = certificacionnumero;
	}

	/**
	 * @return the iscotizado
	 */
	public Boolean getIscotizado() {
		iscotizado = obtenerBooleano(cotizadoflag);
		return iscotizado;
	}

	/**
	 * @param iscotizado
	 *            the iscotizado to set
	 */
	public void setIscotizado(Boolean iscotizado) {
		this.iscotizado = iscotizado;
	}

	/**
	 * @return the compute2
	 */
	public String getCompute2() {
		return compute2;
	}

	/**
	 * @param compute2
	 *            the compute2 to set
	 */
	public void setCompute2(String compute2) {
		this.compute2 = compute2;
	}

	/**
	 * @return the defaultprime1
	 */
	public String getDefaultprime1() {
		return defaultprime1;
	}

	/**
	 * @param defaultprime1
	 *            the defaultprime1 to set
	 */
	public void setDefaultprime1(String defaultprime1) {
		this.defaultprime1 = defaultprime1;
	}

	private Boolean obtenerBooleano(String valor) {
		if (UValidador.esNulo(valor)) {
			return false;
		}

		if (valor.equals("S")) {
			return true;
		}

		return false;
	}

	public String getDefaultafe_1() {
		return defaultafe_1;
	}

	public void setDefaultafe_1(String defaultafe_1) {
		this.defaultafe_1 = defaultafe_1;
	}

	/**
	 * @return the revisadapornombre
	 */
	public String getRevisadapornombre() {
		return revisadapornombre;
	}

	/**
	 * @param revisadapornombre
	 *            the revisadapornombre to set
	 */
	public void setRevisadapornombre(String revisadapornombre) {
		this.revisadapornombre = revisadapornombre;
	}

	/**
	 * @return the aprobadapornombre
	 */
	public String getAprobadapornombre() {
		return aprobadapornombre;
	}

	/**
	 * @param aprobadapornombre
	 *            the aprobadapornombre to set
	 */
	public void setAprobadapornombre(String aprobadapornombre) {
		this.aprobadapornombre = aprobadapornombre;
	}

	/**
	 * @return the auxmeta
	 */
	public String getAuxmeta() {
		return auxmeta;
	}

	/**
	 * @param auxmeta
	 *            the auxmeta to set
	 */
	public void setAuxmeta(String auxmeta) {
		this.auxmeta = auxmeta;
	}

	/**
	 * @return the auxmetanombre
	 */
	public String getAuxmetanombre() {
		return auxmetanombre;
	}

	/**
	 * @param auxmetanombre
	 *            the auxmetanombre to set
	 */
	public void setAuxmetanombre(String auxmetanombre) {
		this.auxmetanombre = auxmetanombre;
	}

	/**
	 * @return the auxcodigometa
	 */
	public BigDecimal getAuxcodigometa() {
		return auxcodigometa;
	}

	/**
	 * @param auxcodigometa the auxcodigometa to set
	 */
	public void setAuxcodigometa(BigDecimal auxcodigometa) {
		this.auxcodigometa = auxcodigometa;
	}

}
