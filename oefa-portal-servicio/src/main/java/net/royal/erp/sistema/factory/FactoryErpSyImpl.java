package net.royal.erp.sistema.factory;

import net.royal.erp.sistema.sycommon.servicio.SycommonFuncion;
import net.royal.erp.sistema.syfinan.servicio.SyfinanDatawindow;
import net.royal.erp.sistema.syfinan.servicio.SyfinanFuncion;
import net.royal.erp.sistema.symast01.servicio.Symast01Datawindow;

public class FactoryErpSyImpl implements FactoryErpSy {

	private SycommonFuncion sycommonFuncion;

	@Override
	public SycommonFuncion getSycommonFuncion() {
		return sycommonFuncion;
	}

	@Override
	public void setSycommonFuncion(SycommonFuncion sycommonFuncion) {
		this.sycommonFuncion = sycommonFuncion;
	}

	private SyfinanFuncion syfinanFuncion;

	@Override
	public SyfinanFuncion getSyfinanFuncion() {
		return syfinanFuncion;
	}

	@Override
	public void setSyfinanFuncion(SyfinanFuncion syfinanFuncion) {
		this.syfinanFuncion = syfinanFuncion;
	}

	private SyfinanDatawindow syfinanDatawindow;

	@Override
	public SyfinanDatawindow getSyfinanDatawindow() {
		return syfinanDatawindow;
	}

	@Override
	public void setSyfinanDatawindow(SyfinanDatawindow syfinanDatawindow) {
		this.syfinanDatawindow = syfinanDatawindow;
	}
	private Symast01Datawindow symast01Datawindow;

	@Override
	public Symast01Datawindow getSymast01Datawindow() {
		return symast01Datawindow;
	}

	@Override
	public void setSymast01Datawindow(Symast01Datawindow symast01Datawindow) {
		this.symast01Datawindow = symast01Datawindow;
	}
}
