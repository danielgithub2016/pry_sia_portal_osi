package net.royal.erp.sistema.dominio.dto;

import net.royal.erp.core.dominio.MaUnidadnegocio;

/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ac_cashflow_select_position
 */
public class DtoDwAcCashflowSelectPosition implements java.io.Serializable {
	private String tiporegistro;
	private String tiporegistro_all;
	private String tipooperacion_all;
	private String tipooperacion;
	private String grupoflujo_all;
	private String descripcion;
	private String orden;
	private String unidadnegocio_all;

	private boolean boolTipoTransaccion;
	private boolean boolFlujoEfectivo;
	private boolean boolGrupoMayor = true;
	private boolean boolUnidadNegocio;
	
	

	private MaUnidadnegocio unidadnegocio;

	public DtoDwAcCashflowSelectPosition() {
		unidadnegocio = new MaUnidadnegocio();
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTiporegistro() {
		return tiporegistro;
	}

	public String getTipooperacion() {
		return tipooperacion;
	}

	public void setTiporegistro(String tiporegistro) {
		this.tiporegistro = tiporegistro;
	}

	public void setTipooperacion(String tipooperacion) {
		this.tipooperacion = tipooperacion;
	}

	public String getTiporegistro_all() {
		return tiporegistro_all;
	}

	public void setTiporegistro_all(String tiporegistro_all) {
		this.tiporegistro_all = tiporegistro_all;
	}

	public String getTipooperacion_all() {
		return tipooperacion_all;
	}

	public void setTipooperacion_all(String tipooperacion_all) {
		this.tipooperacion_all = tipooperacion_all;
	}

	public String getGrupoflujo_all() {
		return grupoflujo_all;
	}

	public void setGrupoflujo_all(String grupoflujo_all) {
		this.grupoflujo_all = grupoflujo_all;
	}

	public String getUnidadnegocio_all() {
		return unidadnegocio_all;
	}

	public void setUnidadnegocio_all(String unidadnegocio_all) {
		this.unidadnegocio_all = unidadnegocio_all;
	}

	public MaUnidadnegocio getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(MaUnidadnegocio unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public boolean isBoolTipoTransaccion() {
		return boolTipoTransaccion;
	}

	public void setBoolTipoTransaccion(boolean boolTipoTransaccion) {
		if(boolTipoTransaccion==true){
			tiporegistro=null;
		}
		this.boolTipoTransaccion = boolTipoTransaccion;
	}

	public boolean isBoolFlujoEfectivo() {
		return boolFlujoEfectivo;
	}

	public void setBoolFlujoEfectivo(boolean boolFlujoEfectivo) {
		if(boolFlujoEfectivo==true){
			tipooperacion=null;
		}
		this.boolFlujoEfectivo = boolFlujoEfectivo;
	}

	public boolean isBoolGrupoMayor() {
		return boolGrupoMayor;
	}

	public void setBoolGrupoMayor(boolean boolGrupoMayor) {
		if(boolGrupoMayor==true){
		}
		this.boolGrupoMayor = boolGrupoMayor;
	}

	public boolean isBoolUnidadNegocio() {
		return boolUnidadNegocio;
	}

	public void setBoolUnidadNegocio(boolean boolUnidadNegocio) {
		if(boolUnidadNegocio==true){
			unidadnegocio=null;
		}
		this.boolUnidadNegocio = boolUnidadNegocio;
	}

}
