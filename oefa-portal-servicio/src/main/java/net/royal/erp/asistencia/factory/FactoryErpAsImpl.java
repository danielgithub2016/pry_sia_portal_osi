package net.royal.erp.asistencia.factory;

import net.royal.erp.asistencia.accommon.servicio.AccommonDatawindow;
import net.royal.erp.asistencia.ascommon.servicio.AscommonDatawindow;
import net.royal.erp.asistencia.ascommon.servicio.AscommonFuncion;
import net.royal.erp.asistencia.asmain.servicio.AsmainDatawindow;
import net.royal.erp.asistencia.asmain.servicio.AsmainFuncion;
import net.royal.erp.asistencia.asmast.servicio.AsmastDatawindow;
import net.royal.erp.asistencia.asoracle.servicio.AsoracleDatawindow;
import net.royal.erp.asistencia.asrepus.servicio.AsrepusFuncion;
import net.royal.erp.asistencia.asuser.servicio.AsuserFuncion;
import net.royal.erp.asistencia.hrcommon.servicio.HrcommonFuncion;
import net.royal.erp.asistencia.syclass.servicio.SyclassFuncion;
import net.royal.erp.asistencia.sycomm.servicio.SycommFuncion;
import net.royal.erp.asistencia.sylock.servicio.SylockDatawindow;
import net.royal.erp.asistencia.sylock.servicio.SylockFuncion;
import net.royal.erp.asistencia.symast.servicio.SymastDatawindow;

public class FactoryErpAsImpl implements FactoryErpAs {

	private AccommonDatawindow accommonDatawindow;

	@Override
	public AccommonDatawindow getAccommonDatawindow() {
		return accommonDatawindow;
	}

	@Override
	public void setAccommonDatawindow(AccommonDatawindow accommonDatawindow) {
		this.accommonDatawindow = accommonDatawindow;
	}

	

	

	private AscommonDatawindow ascommonDatawindow;

	@Override
	public AscommonDatawindow getAscommonDatawindow() {
		return ascommonDatawindow;
	}

	@Override
	public void setAscommonDatawindow(AscommonDatawindow ascommonDatawindow) {
		this.ascommonDatawindow = ascommonDatawindow;
	} 

	private AscommonFuncion ascommonFuncion;

	@Override
	public AscommonFuncion getAscommonFuncion() {
		return ascommonFuncion;
	}

	@Override
	public void setAscommonFuncion(AscommonFuncion ascommonFuncion) {
		this.ascommonFuncion = ascommonFuncion;
	}

	private AsmainDatawindow asmainDatawindow;

	@Override
	public AsmainDatawindow getAsmainDatawindow() {
		return asmainDatawindow;
	}

	@Override
	public void setAsmainDatawindow(AsmainDatawindow asmainDatawindow) {
		this.asmainDatawindow = asmainDatawindow;
	}

	private AsmainFuncion asmainFuncion;

	@Override
	public AsmainFuncion getAsmainFuncion() {
		return asmainFuncion;
	}

	@Override
	public void setAsmainFuncion(AsmainFuncion asmainFuncion) {
		this.asmainFuncion = asmainFuncion;
	}

	private AsmastDatawindow asmastDatawindow;

	@Override
	public AsmastDatawindow getAsmastDatawindow() {
		return asmastDatawindow;
	}

	@Override
	public void setAsmastDatawindow(AsmastDatawindow asmastDatawindow) {
		this.asmastDatawindow = asmastDatawindow;
	}

	
	private AsoracleDatawindow asoracleDatawindow;

	@Override
	public AsoracleDatawindow getAsoracleDatawindow() {
		return asoracleDatawindow;
	}

	@Override
	public void setAsoracleDatawindow(AsoracleDatawindow asoracleDatawindow) {
		this.asoracleDatawindow = asoracleDatawindow;
	}

	

	private AsrepusFuncion asrepusFuncion;

	@Override
	public AsrepusFuncion getAsrepusFuncion() {
		return asrepusFuncion;
	}

	@Override
	public void setAsrepusFuncion(AsrepusFuncion asrepusFuncion) {
		this.asrepusFuncion = asrepusFuncion;
	}

	

	private AsuserFuncion asuserFuncion;

	@Override
	public AsuserFuncion getAsuserFuncion() {
		return asuserFuncion;
	}

	@Override
	public void setAsuserFuncion(AsuserFuncion asuserFuncion) {
		this.asuserFuncion = asuserFuncion;
	}

	

	private HrcommonFuncion hrcommonFuncion;

	@Override
	public HrcommonFuncion getHrcommonFuncion() {
		return hrcommonFuncion;
	}

	@Override
	public void setHrcommonFuncion(HrcommonFuncion hrcommonFuncion) {
		this.hrcommonFuncion = hrcommonFuncion;
	}


	
	
	private SyclassFuncion syclassFuncion;

	@Override
	public SyclassFuncion getSyclassFuncion() {
		return syclassFuncion;
	}

	@Override
	public void setSyclassFuncion(SyclassFuncion syclassFuncion) {
		this.syclassFuncion = syclassFuncion;
	}

	
	private SycommFuncion cycommFuncion;

	@Override
	public SycommFuncion getSycommFuncion() {
		return cycommFuncion;
	}

	@Override
	public void setSycommFuncion(SycommFuncion cycommFuncion) {
		this.cycommFuncion = cycommFuncion;
	}

	private SylockDatawindow sylockDatawindow;

	@Override
	public SylockDatawindow getSylockDatawindow() {
		return sylockDatawindow;
	}

	@Override
	public void setSylockDatawindow(SylockDatawindow sylockDatawindow) {
		this.sylockDatawindow = sylockDatawindow;
	}

	private SylockFuncion sylockFuncion;

	@Override
	public SylockFuncion getSylockFuncion() {
		return sylockFuncion;
	}

	@Override
	public void setSylockFuncion(SylockFuncion sylockFuncion) {
		this.sylockFuncion = sylockFuncion;
	}

	private SymastDatawindow symastDatawindow;

	@Override
	public SymastDatawindow getSymastDatawindow() {
		return symastDatawindow;
	}

	@Override
	public void setSymastDatawindow(SymastDatawindow symastDatawindow) {
		this.symastDatawindow = symastDatawindow;
	}

	

}
