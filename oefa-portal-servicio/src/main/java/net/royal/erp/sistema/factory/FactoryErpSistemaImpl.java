package net.royal.erp.sistema.factory;

import net.royal.erp.sistema.servicio.SyCampocalculadoServicio;
import net.royal.erp.sistema.servicio.SySeguridadautorizacionesServicio;
import net.royal.erp.sistema.servicio.SySeguridadrangoServicio;
import net.royal.erp.sistema.servicio.SyUnidadreplicacionServicio;

public class FactoryErpSistemaImpl implements FactoryErpSistema {

	private SyCampocalculadoServicio syCampocalculadoServicio;

	@Override
	public SyCampocalculadoServicio getSyCampocalculadoServicio() {
		return syCampocalculadoServicio;
	}

	@Override
	public void setSyCampocalculadoServicio(
			SyCampocalculadoServicio syCampocalculadoServicio) {
		this.syCampocalculadoServicio = syCampocalculadoServicio;
	}

	private SySeguridadautorizacionesServicio sySeguridadautorizacionesServicio;

	@Override
	public SySeguridadautorizacionesServicio getSySeguridadautorizacionesServicio() {
		return sySeguridadautorizacionesServicio;
	}

	@Override
	public void setSySeguridadautorizacionesServicio(
			SySeguridadautorizacionesServicio sySeguridadautorizacionesServicio) {
		this.sySeguridadautorizacionesServicio = sySeguridadautorizacionesServicio;
	}

	

	private SyUnidadreplicacionServicio syUnidadreplicacionServicio;

	@Override
	public SyUnidadreplicacionServicio getSyUnidadreplicacionServicio() {
		return syUnidadreplicacionServicio;
	}

	@Override
	public void setSyUnidadreplicacionServicio(
			SyUnidadreplicacionServicio syUnidadreplicacionServicio) {
		this.syUnidadreplicacionServicio = syUnidadreplicacionServicio;
	}

	private FactoryErpSy FactoryErpSy;

	@Override
	public FactoryErpSy getSY() {
		return FactoryErpSy;
	}

	@Override
	public void setSY(FactoryErpSy FactoryErpSy) {
		this.FactoryErpSy = FactoryErpSy;
	}

	private SySeguridadrangoServicio sySeguridadrangoServicio;

	@Override
	public SySeguridadrangoServicio getSySeguridadrangoServicio() {
		return sySeguridadrangoServicio;
	}

	@Override
	public void setSySeguridadrangoServicio(
			SySeguridadrangoServicio sySeguridadrangoServicio) {
		this.sySeguridadrangoServicio = sySeguridadrangoServicio;
	}
}
