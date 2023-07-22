package net.royal.erp.mantenimiento.factory;

import net.royal.erp.mantenimiento.servicio.MeTipomantenimientoServicio;
import net.royal.erp.mantenimiento.servicio.MeTipomantenimientogrupoServicio;
import net.royal.marcainterna.pcoefa.servicio.MapPcOefaServicio;
import net.royal.marcainterna.pcoefa.servicio.MvcPcOefaTokenServicio;

public class FactoryErpMantenimientoImpl implements FactoryErpMantenimiento {
	private MeTipomantenimientogrupoServicio meTipomantenimientogrupoServicio;

	@Override
	public MeTipomantenimientogrupoServicio getMeTipomantenimientogrupoServicio() {
		return meTipomantenimientogrupoServicio;
	}

	@Override
	public void setMeTipomantenimientogrupoServicio(MeTipomantenimientogrupoServicio meTipomantenimientogrupoServicio) {
		this.meTipomantenimientogrupoServicio = meTipomantenimientogrupoServicio;
	}

	private MeTipomantenimientoServicio meTipomantenimientoServicio;

	@Override
	public MeTipomantenimientoServicio getMeTipomantenimientoServicio() {
		return meTipomantenimientoServicio;
	}

	@Override
	public void setMeTipomantenimientoServicio(MeTipomantenimientoServicio meTipomantenimientoServicio) {
		this.meTipomantenimientoServicio = meTipomantenimientoServicio;
	}

	private MvcPcOefaTokenServicio mvcPcOefaTokenServicio;

	@Override
	public MvcPcOefaTokenServicio getMvcPcOefaTokenServicio() {
		// TODO Auto-generated method stub
		return mvcPcOefaTokenServicio;
	}

	@Override
	public void setMvcPcOefaTokenServicio(MvcPcOefaTokenServicio mvcPcOefaTokenServicio) {
		// TODO Auto-generated method stub
		this.mvcPcOefaTokenServicio = mvcPcOefaTokenServicio;
	}

	private MapPcOefaServicio mapPcOefaServicio;

	@Override
	public MapPcOefaServicio getMapPcOefaServicio() {
		// TODO Auto-generated method stub
		return mapPcOefaServicio;
	}

	@Override
	public void setMapPcOefaServicio(MapPcOefaServicio mapPcOefaServicio) {
		// TODO Auto-generated method stub
		this.mapPcOefaServicio = mapPcOefaServicio;
	}

}
