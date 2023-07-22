package net.royal.erp.mantenimiento.factory;

import net.royal.erp.mantenimiento.servicio.MeTipomantenimientoServicio;
import net.royal.erp.mantenimiento.servicio.MeTipomantenimientogrupoServicio;
import net.royal.marcainterna.pcoefa.servicio.MapPcOefaServicio;
import net.royal.marcainterna.pcoefa.servicio.MvcPcOefaTokenServicio;

public interface FactoryErpMantenimiento {
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder mantenimiento.MeTipomantenimientogrupo
	 */
	public MeTipomantenimientogrupoServicio getMeTipomantenimientogrupoServicio();

	public void setMeTipomantenimientogrupoServicio(MeTipomantenimientogrupoServicio meTipomantenimientogrupoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder mantenimiento.MeTipomantenimiento
	 */
	public MeTipomantenimientoServicio getMeTipomantenimientoServicio();

	public void setMeTipomantenimientoServicio(MeTipomantenimientoServicio meTipomantenimientoServicio);

	public MvcPcOefaTokenServicio getMvcPcOefaTokenServicio();

	public void setMvcPcOefaTokenServicio(MvcPcOefaTokenServicio mvcPcOefaTokenServicio);

	public MapPcOefaServicio getMapPcOefaServicio();

	public void setMapPcOefaServicio(MapPcOefaServicio mapPcOefaServicio);

}
