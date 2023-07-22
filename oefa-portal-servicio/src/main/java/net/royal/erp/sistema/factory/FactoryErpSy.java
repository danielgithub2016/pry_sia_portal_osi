package net.royal.erp.sistema.factory;

import net.royal.erp.sistema.sycommon.servicio.SycommonFuncion;
import net.royal.erp.sistema.syfinan.servicio.SyfinanDatawindow;
import net.royal.erp.sistema.syfinan.servicio.SyfinanFuncion;
import net.royal.erp.sistema.symast01.servicio.Symast01Datawindow;

public interface FactoryErpSy {

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sistema.symast01.datawindow
	 */
	public Symast01Datawindow getSymast01Datawindow();

	public void setSymast01Datawindow(Symast01Datawindow symast01Datawindow);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sistema.syfinan.funcion
	 */
	public SyfinanFuncion getSyfinanFuncion();

	public void setSyfinanFuncion(SyfinanFuncion syfinanFuncion);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sistema.syfinan.datawindow
	 */
	public SyfinanDatawindow getSyfinanDatawindow();

	public void setSyfinanDatawindow(SyfinanDatawindow syfinanDatawindow);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sistema.sycommon.funcion
	 */
	public SycommonFuncion getSycommonFuncion();

	public void setSycommonFuncion(SycommonFuncion sycommonFuncion);


}
