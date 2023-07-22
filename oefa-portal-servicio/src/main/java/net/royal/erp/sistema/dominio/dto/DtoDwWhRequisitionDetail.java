package net.royal.erp.sistema.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_wh_requisition_detail
 */
public class DtoDwWhRequisitionDetail implements java.io.Serializable {

	private String companiasocio;
	private String requisicionnumero;
	private Integer secuencia;
	private String item;
	private String commodity;
	private String unidadcodigo;
	private String unidadnombre;
	private String descripcion;
	private String comprasalmacenflag;
	private String redefinidoflag;
	private Integer cantidadpedida;
	private Integer cantidadordencompra;
	private Integer cantidadrecibida;
	private BigDecimal preciounitario;
	private BigDecimal precioxcantidad;
	private Integer cotizacionsecuencia;
	private Integer cotizacioncantidad;
	private BigDecimal cotizacionpreciounitario;
	private BigDecimal cotizacionpreciounitarioconigv;
	private Integer cotizacionproveedor;
	private String cotizacionmoneda;
	private Integer cotizacionregistros;
	private String cotizacionformadepago;
	private Date cotizacionfechaasignacion;
	private String controlpresupuestalflag;
	private String partidapresupuestal;
	private String comentario;
	private String razonrechazo;
	private String centrocosto;
	private String centrocostonombre;
	private String estado;
	private String ultimousuario;
	private Date ultimafechamodif;
	private String igvexoneradoflag;
	private String generarcontratoflag;
	private String comentarioadicional;
	private String licitacionasignadaflag;
	private String condicion;

	// estados de transaccion
	private String estadoAccion; // I=insertar, A=Actualizar, E=Eliminar
	private String estadoOrigen; // B=Base Datos, T=Temporal

	private Boolean isigvexoneradoflag;
	private Boolean isgenerarcontratoflag;

	private String lote;

	// nuevo campo para el flujo de logistica
	private String instruccion;
	private Boolean tieneinstruccion;

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
	 * @return the secuencia
	 */
	public Integer getSecuencia() {
		return secuencia;
	}

	/**
	 * @param secuencia
	 *            the secuencia to set
	 */
	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}

	/**
	 * @param item
	 *            the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}

	/**
	 * @return the commodity
	 */
	public String getCommodity() {
		return commodity;
	}

	/**
	 * @param commodity
	 *            the commodity to set
	 */
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	/**
	 * @return the unidadcodigo
	 */
	public String getUnidadcodigo() {
		return unidadcodigo;
	}

	/**
	 * @param unidadcodigo
	 *            the unidadcodigo to set
	 */
	public void setUnidadcodigo(String unidadcodigo) {
		this.unidadcodigo = unidadcodigo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * @return the redefinidoflag
	 */
	public String getRedefinidoflag() {
		return redefinidoflag;
	}

	/**
	 * @param redefinidoflag
	 *            the redefinidoflag to set
	 */
	public void setRedefinidoflag(String redefinidoflag) {
		this.redefinidoflag = redefinidoflag;
	}

	/**
	 * @return the cantidadpedida
	 */
	public Integer getCantidadpedida() {
		if (UValidador.esNulo(cantidadpedida)) {
			cantidadpedida = 0;
		}
		return cantidadpedida;
	}

	/**
	 * @param cantidadpedida
	 *            the cantidadpedida to set
	 */
	public void setCantidadpedida(Integer cantidadpedida) {
		this.cantidadpedida = cantidadpedida;
	}

	/**
	 * @return the cantidadordencompra
	 */
	public Integer getCantidadordencompra() {
		if (UValidador.esNulo(cantidadordencompra)) {
			cantidadordencompra = 0;
		}
		return cantidadordencompra;
	}

	/**
	 * @param cantidadordencompra
	 *            the cantidadordencompra to set
	 */
	public void setCantidadordencompra(Integer cantidadordencompra) {
		this.cantidadordencompra = cantidadordencompra;
	}

	/**
	 * @return the cantidadrecibida
	 */
	public Integer getCantidadrecibida() {
		return cantidadrecibida;
	}

	/**
	 * @param cantidadrecibida
	 *            the cantidadrecibida to set
	 */
	public void setCantidadrecibida(Integer cantidadrecibida) {
		this.cantidadrecibida = cantidadrecibida;
	}

	/**
	 * @return the preciounitario
	 */
	public BigDecimal getPreciounitario() {
		if (UValidador.esNulo(preciounitario)) {
			preciounitario = BigDecimal.ZERO;
		}
		return preciounitario;
	}

	/**
	 * @param preciounitario
	 *            the preciounitario to set
	 */
	public void setPreciounitario(BigDecimal preciounitario) {
		this.preciounitario = preciounitario;
	}

	/**
	 * @return the precioxcantidad
	 */
	public BigDecimal getPrecioxcantidad() {
		if (UValidador.esNulo(precioxcantidad)) {
			precioxcantidad = BigDecimal.ZERO;
		}
		return precioxcantidad;
	}

	/**
	 * @param precioxcantidad
	 *            the precioxcantidad to set
	 */
	public void setPrecioxcantidad(BigDecimal precioxcantidad) {
		this.precioxcantidad = precioxcantidad;
	}

	/**
	 * @return the cotizacionsecuencia
	 */
	public Integer getCotizacionsecuencia() {
		if (UValidador.esNulo(cotizacionsecuencia)) {
			cotizacionsecuencia = 0;
		}
		return cotizacionsecuencia;
	}

	/**
	 * @param cotizacionsecuencia
	 *            the cotizacionsecuencia to set
	 */
	public void setCotizacionsecuencia(Integer cotizacionsecuencia) {
		this.cotizacionsecuencia = cotizacionsecuencia;
	}

	/**
	 * @return the cotizacioncantidad
	 */
	public Integer getCotizacioncantidad() {
		if (UValidador.esNulo(cotizacioncantidad)) {
			cotizacioncantidad = 0;
		}
		return cotizacioncantidad;
	}

	/**
	 * @param cotizacioncantidad
	 *            the cotizacioncantidad to set
	 */
	public void setCotizacioncantidad(Integer cotizacioncantidad) {
		this.cotizacioncantidad = cotizacioncantidad;
	}

	/**
	 * @return the cotizacionpreciounitario
	 */
	public BigDecimal getCotizacionpreciounitario() {
		return cotizacionpreciounitario;
	}

	/**
	 * @param cotizacionpreciounitario
	 *            the cotizacionpreciounitario to set
	 */
	public void setCotizacionpreciounitario(BigDecimal cotizacionpreciounitario) {
		this.cotizacionpreciounitario = cotizacionpreciounitario;
	}

	/**
	 * @return the cotizacionpreciounitarioconigv
	 */
	public BigDecimal getCotizacionpreciounitarioconigv() {
		return cotizacionpreciounitarioconigv;
	}

	/**
	 * @param cotizacionpreciounitarioconigv
	 *            the cotizacionpreciounitarioconigv to set
	 */
	public void setCotizacionpreciounitarioconigv(
			BigDecimal cotizacionpreciounitarioconigv) {
		this.cotizacionpreciounitarioconigv = cotizacionpreciounitarioconigv;
	}

	/**
	 * @return the cotizacionproveedor
	 */
	public Integer getCotizacionproveedor() {
		return cotizacionproveedor;
	}

	/**
	 * @param cotizacionproveedor
	 *            the cotizacionproveedor to set
	 */
	public void setCotizacionproveedor(Integer cotizacionproveedor) {
		this.cotizacionproveedor = cotizacionproveedor;
	}

	/**
	 * @return the cotizacionmoneda
	 */
	public String getCotizacionmoneda() {
		return cotizacionmoneda;
	}

	/**
	 * @param cotizacionmoneda
	 *            the cotizacionmoneda to set
	 */
	public void setCotizacionmoneda(String cotizacionmoneda) {
		this.cotizacionmoneda = cotizacionmoneda;
	}

	/**
	 * @return the cotizacionregistros
	 */
	public Integer getCotizacionregistros() {
		return cotizacionregistros;
	}

	/**
	 * @param cotizacionregistros
	 *            the cotizacionregistros to set
	 */
	public void setCotizacionregistros(Integer cotizacionregistros) {
		this.cotizacionregistros = cotizacionregistros;
	}

	/**
	 * @return the cotizacionformadepago
	 */
	public String getCotizacionformadepago() {
		return cotizacionformadepago;
	}

	/**
	 * @param cotizacionformadepago
	 *            the cotizacionformadepago to set
	 */
	public void setCotizacionformadepago(String cotizacionformadepago) {
		this.cotizacionformadepago = cotizacionformadepago;
	}

	/**
	 * @return the cotizacionfechaasignacion
	 */
	public Date getCotizacionfechaasignacion() {
		return cotizacionfechaasignacion;
	}

	/**
	 * @param cotizacionfechaasignacion
	 *            the cotizacionfechaasignacion to set
	 */
	public void setCotizacionfechaasignacion(Date cotizacionfechaasignacion) {
		this.cotizacionfechaasignacion = cotizacionfechaasignacion;
	}

	/**
	 * @return the controlpresupuestalflag
	 */
	public String getControlpresupuestalflag() {
		return controlpresupuestalflag;
	}

	/**
	 * @param controlpresupuestalflag
	 *            the controlpresupuestalflag to set
	 */
	public void setControlpresupuestalflag(String controlpresupuestalflag) {
		this.controlpresupuestalflag = controlpresupuestalflag;
	}

	/**
	 * @return the partidapresupuestal
	 */
	public String getPartidapresupuestal() {
		return partidapresupuestal;
	}

	/**
	 * @param partidapresupuestal
	 *            the partidapresupuestal to set
	 */
	public void setPartidapresupuestal(String partidapresupuestal) {
		this.partidapresupuestal = partidapresupuestal;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario
	 *            the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
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
	 * @return the centrocosto
	 */
	public String getCentrocosto() {
		return centrocosto;
	}

	/**
	 * @param centrocosto
	 *            the centrocosto to set
	 */
	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
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
	 * @return the igvexoneradoflag
	 */
	public String getIgvexoneradoflag() {
		return igvexoneradoflag;
	}

	/**
	 * @param igvexoneradoflag
	 *            the igvexoneradoflag to set
	 */
	public void setIgvexoneradoflag(String igvexoneradoflag) {
		this.igvexoneradoflag = igvexoneradoflag;
	}

	/**
	 * @return the generarcontratoflag
	 */
	public String getGenerarcontratoflag() {
		return generarcontratoflag;
	}

	/**
	 * @param generarcontratoflag
	 *            the generarcontratoflag to set
	 */
	public void setGenerarcontratoflag(String generarcontratoflag) {
		this.generarcontratoflag = generarcontratoflag;
	}

	/**
	 * @return the comentarioadicional
	 */
	public String getComentarioadicional() {
		return comentarioadicional;
	}

	/**
	 * @param comentarioadicional
	 *            the comentarioadicional to set
	 */
	public void setComentarioadicional(String comentarioadicional) {
		this.comentarioadicional = comentarioadicional;
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
	 * @return the condicion
	 */
	public String getCondicion() {
		return condicion;
	}

	/**
	 * @param condicion
	 *            the condicion to set
	 */
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	/**
	 * @return the estadoAccion
	 */
	public String getEstadoAccion() {
		return estadoAccion;
	}

	/**
	 * @param estadoAccion
	 *            the estadoAccion to set
	 */
	public void setEstadoAccion(String estadoAccion) {
		this.estadoAccion = estadoAccion;
	}

	/**
	 * @return the estadoOrigen
	 */
	public String getEstadoOrigen() {
		return estadoOrigen;
	}

	/**
	 * @param estadoOrigen
	 *            the estadoOrigen to set
	 */
	public void setEstadoOrigen(String estadoOrigen) {
		this.estadoOrigen = estadoOrigen;
	}

	/**
	 * @return the isigvexoneradoflag
	 */
	public Boolean getIsigvexoneradoflag() {
		isigvexoneradoflag = obtenerBooleano(igvexoneradoflag);
		return isigvexoneradoflag;
	}

	/**
	 * @param isigvexoneradoflag
	 *            the isigvexoneradoflag to set
	 */
	public void setIsigvexoneradoflag(Boolean isigvexoneradoflag) {
		this.isigvexoneradoflag = isigvexoneradoflag;
	}

	/**
	 * @return the isgenerarcontratoflag
	 */
	public Boolean getIsgenerarcontratoflag() {
		isgenerarcontratoflag = obtenerBooleano(generarcontratoflag);
		return isgenerarcontratoflag;
	}

	/**
	 * @param isgenerarcontratoflag
	 *            the isgenerarcontratoflag to set
	 */
	public void setIsgenerarcontratoflag(Boolean isgenerarcontratoflag) {
		this.isgenerarcontratoflag = isgenerarcontratoflag;
	}

	/**
	 * @return the lote
	 */
	public String getLote() {
		return lote;
	}

	/**
	 * @param lote
	 *            the lote to set
	 */
	public void setLote(String lote) {
		this.lote = lote;
	}

	/**
	 * @return the unidadnombre
	 */
	public String getUnidadnombre() {
		return unidadnombre;
	}

	/**
	 * @param unidadnombre
	 *            the unidadnombre to set
	 */
	public void setUnidadnombre(String unidadnombre) {
		this.unidadnombre = unidadnombre;
	}

	/**
	 * @return the centrocostonombre
	 */
	public String getCentrocostonombre() {
		return centrocostonombre;
	}

	/**
	 * @param centrocostonombre
	 *            the centrocostonombre to set
	 */
	public void setCentrocostonombre(String centrocostonombre) {
		this.centrocostonombre = centrocostonombre;
	}

	/**
	 * @return the instruccion
	 */
	public String getInstruccion() {
		return instruccion;
	}

	/**
	 * @param instruccion
	 *            the instruccion to set
	 */
	public void setInstruccion(String instruccion) {
		this.instruccion = instruccion;
	}

	/**
	 * @return the tieneinstruccion
	 */
	public Boolean getTieneinstruccion() {
		tieneinstruccion = false;
		if (!UValidador.estaVacio(getInstruccion())) {
			tieneinstruccion = true;
		}
		return tieneinstruccion;
	}

	/**
	 * @param tieneinstruccion
	 *            the tieneinstruccion to set
	 */
	public void setTieneinstruccion(Boolean tieneinstruccion) {
		this.tieneinstruccion = tieneinstruccion;
	}

	private Boolean obtenerBooleano(String valor) {
		if (UValidador.estaVacio(valor)) {
			return false;
		}

		if (valor.equals("S")) {
			return true;
		}

		return false;
	}

}
