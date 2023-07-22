package net.royal.erp.planilla.factory;

import net.royal.erp.planilla.servicio.PrCalendarioferiadosServicio;
import net.royal.erp.planilla.servicio.PrCtsServicio;
import net.royal.erp.planilla.servicio.PrFuentefinanciamientoServicio;
import net.royal.erp.planilla.servicio.PrPlanillaEmpleadoServicio;
import net.royal.erp.planilla.servicio.PrProcesoperiodoServicio;
import net.royal.erp.planilla.servicio.PrTipoProcesoServicio;
import net.royal.erp.planilla.servicio.PrTipoplanillaServicio;
import net.royal.erp.planilla.servicio.PrVacacionesprogramadasServicio;

public class FactoryErpPlanillaImpl implements FactoryErpPlanilla {

	private PrTipoplanillaServicio prTipoplanillaServicio;

	@Override
	public PrTipoplanillaServicio getPrTipoplanillaServicio() {
		return prTipoplanillaServicio;
	}

	@Override
	public void setPrTipoplanillaServicio(PrTipoplanillaServicio prTipoplanillaServicio) {
		this.prTipoplanillaServicio = prTipoplanillaServicio;
	}

	private PrProcesoperiodoServicio prProcesoperiodoServicio;

	@Override
	public PrProcesoperiodoServicio getPrProcesoperiodoServicio() {
		return prProcesoperiodoServicio;
	}

	@Override
	public void setPrProcesoperiodoServicio(PrProcesoperiodoServicio prProcesoperiodoServicio) {
		this.prProcesoperiodoServicio = prProcesoperiodoServicio;
	}

	private PrVacacionesprogramadasServicio prVacacionesprogramadasServicio;

	@Override
	public PrVacacionesprogramadasServicio getPrVacacionesprogramadasServicio() {
		return prVacacionesprogramadasServicio;
	}

	@Override
	public void setPrVacacionesprogramadasServicio(PrVacacionesprogramadasServicio prVacacionesprogramadasServicio) {
		this.prVacacionesprogramadasServicio = prVacacionesprogramadasServicio;
	}

	private PrCalendarioferiadosServicio prCalendarioferiadosServicio;

	@Override
	public PrCalendarioferiadosServicio getPrCalendarioferiadosServicio() {
		return prCalendarioferiadosServicio;
	}

	@Override
	public void setPrCalendarioferiadosServicio(PrCalendarioferiadosServicio prCalendarioferiadosServicio) {
		this.prCalendarioferiadosServicio = prCalendarioferiadosServicio;
	}

	private PrPlanillaEmpleadoServicio prPlanillaEmpleadoServicio;

	@Override
	public PrPlanillaEmpleadoServicio getPlanillaEmpleadoServicio() {
		return prPlanillaEmpleadoServicio;
	}

	@Override
	public void setPrPlanillaEmpleadoServicio(PrPlanillaEmpleadoServicio prPlanillaEmpleadoServicio) {
		this.prPlanillaEmpleadoServicio = prPlanillaEmpleadoServicio;
	}

	private PrCtsServicio prCtsServicio;

	@Override
	public PrCtsServicio getPrCtsServicio() {
		return prCtsServicio;
	}

	@Override
	public void setPrCtsServicio(PrCtsServicio prCtsServicio) {
		this.prCtsServicio = prCtsServicio;

	}

	private PrTipoProcesoServicio prTipoProcesoServicio;

	@Override
	public PrTipoProcesoServicio getPrTipoProcesoServicio() {
		return prTipoProcesoServicio;
	}

	@Override
	public void setPrTipoProcesoServicio(PrTipoProcesoServicio prTipoProcesoServicio) {
		this.prTipoProcesoServicio = prTipoProcesoServicio;
	}

	private PrFuentefinanciamientoServicio prFuentefinanciamientoServicio;

	@Override
	public PrFuentefinanciamientoServicio getPrFuentefinanciamientoServicio() {
		return prFuentefinanciamientoServicio;
	}

	@Override
	public void setPrFuentefinanciamientoServicio(PrFuentefinanciamientoServicio prFuentefinanciamientoServicio) {
		this.prFuentefinanciamientoServicio = prFuentefinanciamientoServicio;
	}
}
