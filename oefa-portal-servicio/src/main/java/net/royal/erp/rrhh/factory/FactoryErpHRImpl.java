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

public class FactoryErpHRImpl implements FactoryErpHR {

	private HrprocDatawindow hrprocDatawindow;
	private HrOracleDatawindows hrOracleDatawindows;

	private HrrepDatawindow hrrepDatawindow;

	private PrmastDatawindow prmastDatawindow;

	private CommodityFuncion commodityFuncion;

	private HrrepusFuncion hrrepusFuncion;

	private HrcommonDatawindow hrcommonDatawindow;

	private HrmastDatawindow hrmastDatawindow;

	private HrothersDatawindow hrothersDatawindow;


	@Override
	public HrprocDatawindow getHrprocDatawindow() {
		return hrprocDatawindow;
	}

	@Override
	public void setHrprocDatawindow(HrprocDatawindow hrprocDatawindow) {
		this.hrprocDatawindow = hrprocDatawindow;
	}

	@Override
	public HrrepDatawindow getHrrepDatawindow() {
		return hrrepDatawindow;
	}

	@Override
	public void setHrrepDatawindow(HrrepDatawindow hrrepDatawindow) {
		this.hrrepDatawindow = hrrepDatawindow;
	}

	@Override
	public PrmastDatawindow getPrmastDatawindow() {
		return prmastDatawindow;
	}

	@Override
	public void setPrmastDatawindow(PrmastDatawindow prmastDatawindow) {
		this.prmastDatawindow = prmastDatawindow;
	}

	@Override
	public CommodityFuncion getCommodityFuncion() {
		return commodityFuncion;
	}

	@Override
	public void setCommodityFuncion(CommodityFuncion commodityFuncion) {
		this.commodityFuncion = commodityFuncion;
	}

	@Override
	public HrrepusFuncion getHrrepusFuncion() {
		return hrrepusFuncion;
	}

	@Override
	public void setHrrepusFuncion(HrrepusFuncion hrrepusFuncion) {
		this.hrrepusFuncion = hrrepusFuncion;
	}

	@Override
	public HrcommonDatawindow getHrcommonDatawindow() {
		return hrcommonDatawindow;
	}

	@Override
	public void setHrcommonDatawindow(HrcommonDatawindow hrcommonDatawindow) {
		this.hrcommonDatawindow = hrcommonDatawindow;
	}

	@Override
	public HrmastDatawindow getHrmastDatawindow() {
		return hrmastDatawindow;
	}

	@Override
	public void setHrmastDatawindow(HrmastDatawindow hrmastDatawindow) {
		this.hrmastDatawindow = hrmastDatawindow;
	}

	@Override
	public HrothersDatawindow getHrothersDatawindow() {
		return hrothersDatawindow;
	}

	@Override
	public void setHrothersDatawindow(HrothersDatawindow hrothersDatawindow) {
		this.hrothersDatawindow = hrothersDatawindow;
	}

	@Override
	public HrOracleDatawindows getHrOracleDatawindows() {
		return hrOracleDatawindows;
	}

	public void setHrOracleDatawindows(HrOracleDatawindows hrOracleDatawindows) {
		this.hrOracleDatawindows = hrOracleDatawindows;
	}
}
