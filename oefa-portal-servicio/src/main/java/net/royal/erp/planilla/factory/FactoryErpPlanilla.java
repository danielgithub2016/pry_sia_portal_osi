package net.royal.erp.planilla.factory;

import net.royal.erp.planilla.servicio.PrCalendarioferiadosServicio;
import net.royal.erp.planilla.servicio.PrCtsServicio;
import net.royal.erp.planilla.servicio.PrFuentefinanciamientoServicio;
import net.royal.erp.planilla.servicio.PrPlanillaEmpleadoServicio;
import net.royal.erp.planilla.servicio.PrProcesoperiodoServicio;
import net.royal.erp.planilla.servicio.PrTipoProcesoServicio;
import net.royal.erp.planilla.servicio.PrTipoplanillaServicio;
import net.royal.erp.planilla.servicio.PrVacacionesprogramadasServicio;

public interface FactoryErpPlanilla {

	public PrTipoProcesoServicio getPrTipoProcesoServicio();

	public void setPrTipoProcesoServicio(PrTipoProcesoServicio prTipoProcesoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder planilla.PrTipoplanilla
	 */
	public PrTipoplanillaServicio getPrTipoplanillaServicio();

	public void setPrTipoplanillaServicio(PrTipoplanillaServicio prTipoplanillaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder planilla.PrProcesoperiodo
	 */
	public PrProcesoperiodoServicio getPrProcesoperiodoServicio();

	public void setPrProcesoperiodoServicio(PrProcesoperiodoServicio prProcesoperiodoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder planilla.PrVacacionesprogramadas
	 */
	public PrVacacionesprogramadasServicio getPrVacacionesprogramadasServicio();

	public void setPrVacacionesprogramadasServicio(PrVacacionesprogramadasServicio prVacacionesprogramadasServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder planilla.PrCalendarioferiados
	 */
	public PrCalendarioferiadosServicio getPrCalendarioferiadosServicio();

	public void setPrCalendarioferiadosServicio(PrCalendarioferiadosServicio prCalendarioferiadosServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder planilla.PrCalendarioferiados
	 */
	public PrPlanillaEmpleadoServicio getPlanillaEmpleadoServicio();

	public void setPrPlanillaEmpleadoServicio(PrPlanillaEmpleadoServicio prPlanillaEmpleadoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder planilla.PrCts
	 */
	public PrCtsServicio getPrCtsServicio();

	public void setPrCtsServicio(PrCtsServicio prCtsServicio);

	public PrFuentefinanciamientoServicio getPrFuentefinanciamientoServicio();

	public void setPrFuentefinanciamientoServicio(PrFuentefinanciamientoServicio prFuentefinanciamientoServicio);

}
