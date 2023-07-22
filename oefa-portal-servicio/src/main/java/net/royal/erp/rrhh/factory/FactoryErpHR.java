package net.royal.erp.rrhh.factory;

import net.royal.erp.rrhh.commodity.servicio.CommodityFuncion;
import net.royal.erp.rrhh.hrcommon.servicio.HrcommonDatawindow;
import net.royal.erp.rrhh.hrmast.servicio.HrmastDatawindow;
import net.royal.erp.rrhh.hroracle.servicio.HrOracleDatawindows;
import net.royal.erp.rrhh.hrothers.servicio.HrothersDatawindow;
import net.royal.erp.rrhh.hrproc.servicio.HrprocDatawindow;
import net.royal.erp.rrhh.hrrep.servicio.HrrepDatawindow;
import net.royal.erp.rrhh.hrrepus.servicio.HrrepusFuncion;
import net.royal.erp.rrhh.prmast.servicio.PrmastDatawindow;

public interface FactoryErpHR {

	public HrprocDatawindow getHrprocDatawindow();

	public void setHrprocDatawindow(HrprocDatawindow hrprocDatawindow);

	public HrrepDatawindow getHrrepDatawindow();

	public void setHrrepDatawindow(HrrepDatawindow hrrepDatawindow);

	public PrmastDatawindow getPrmastDatawindow();

	public void setPrmastDatawindow(PrmastDatawindow prmastDatawindow);

	public CommodityFuncion getCommodityFuncion();

	public void setCommodityFuncion(CommodityFuncion commodityFuncion);

	public HrrepusFuncion getHrrepusFuncion();

	public void setHrrepusFuncion(HrrepusFuncion hrrepusFuncion);

	public HrcommonDatawindow getHrcommonDatawindow();

	public void setHrcommonDatawindow(HrcommonDatawindow hrcommonDatawindow);

	public HrmastDatawindow getHrmastDatawindow();

	public void setHrmastDatawindow(HrmastDatawindow hrmastDatawindow);

	public HrothersDatawindow getHrothersDatawindow();

	public void setHrothersDatawindow(HrothersDatawindow hrothersDatawindow);

	public HrOracleDatawindows getHrOracleDatawindows();

	public void setHrOracleDatawindows(HrOracleDatawindows hrOracleDatawindows);

}
