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

public interface FactoryErpAs {

	public AccommonDatawindow getAccommonDatawindow();

	public void setAccommonDatawindow(AccommonDatawindow accommonDatawindow);

	public AscommonDatawindow getAscommonDatawindow();

	public void setAscommonDatawindow(AscommonDatawindow ascommonDatawindow);

	public AscommonFuncion getAscommonFuncion();

	public void setAscommonFuncion(AscommonFuncion ascommonFuncion);

	public AsmainDatawindow getAsmainDatawindow();

	public void setAsmainDatawindow(AsmainDatawindow asmainDatawindow);

	public AsmainFuncion getAsmainFuncion();

	public void setAsmainFuncion(AsmainFuncion asmainFuncion);

	public AsmastDatawindow getAsmastDatawindow();

	public void setAsmastDatawindow(AsmastDatawindow asmastDatawindow);

	

	public AsoracleDatawindow getAsoracleDatawindow();

	public void setAsoracleDatawindow(AsoracleDatawindow asoracleDatawindow);



	

	public AsrepusFuncion getAsrepusFuncion();

	public void setAsrepusFuncion(AsrepusFuncion asrepusFuncion);

	

	public AsuserFuncion getAsuserFuncion();

	public void setAsuserFuncion(AsuserFuncion asuserFuncion);

	
	public HrcommonFuncion getHrcommonFuncion();

	public void setHrcommonFuncion(HrcommonFuncion hrcommonFuncion);

	
	public SyclassFuncion getSyclassFuncion();

	public void setSyclassFuncion(SyclassFuncion syclassFuncion);
	
	public SycommFuncion getSycommFuncion();

	public void setSycommFuncion(SycommFuncion cycommFuncion);

	public SylockDatawindow getSylockDatawindow();

	public void setSylockDatawindow(SylockDatawindow sylockDatawindow);

	public SylockFuncion getSylockFuncion();

	public void setSylockFuncion(SylockFuncion sylockFuncion);

	public SymastDatawindow getSymastDatawindow();

	public void setSymastDatawindow(SymastDatawindow symastDatawindow);
	
}