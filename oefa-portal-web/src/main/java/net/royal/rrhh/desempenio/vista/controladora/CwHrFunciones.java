package net.royal.rrhh.desempenio.vista.controladora;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.erp.rrhh.dominio.HrEmpleadofuncion;
import net.royal.erp.rrhh.dominio.HrEmpleadometas;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

/**
 * The Class CwHrFunciones.
 * 
 * @author nunezh
 * @powerbuilder TAB en <strong>w_hr_evaluacionempleado_edit : p11 | dw_11
 *               </strong>
 */
@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CwHrFunciones extends CwHrEvaluacionempleadoEditMaestra implements
		UIMantenimientoController {

	private HrEmpleadofuncion registroSelecionado;
	private String companyowner;
	private Integer empleado, secuenciaeval, empleadoevaluador;
	private BigDecimal compute1;
	private BigDecimal dw11totalsuma;

	public static CwHrFunciones getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrFunciones}",
				CwHrFunciones.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		this.inicializarFiltrosListado();
		this.buscar();
		return null;
	}

	@Override
	public String buscar() throws Exception {

		this.setDw11(this
				.getFacRrhh()
				.getHrEmpleadofuncionServicio()
				.ObtenerEmpleadoFuncionporParametros(companyowner, empleado,
						secuenciaeval, empleadoevaluador));

		if (UValidador.esNulo(this.getDw11()))
			this.setDw11(new ArrayList<HrEmpleadofuncion>());
		
		calcularTotales();

		return null;
	}
	
	public String calificar() throws Exception {
		StrPass lvPass;

		if (UValidador.esNulo(registroSelecionado)) {
			this.setMessageError("Señale una fila para la calificación");
			return null;
		}

		lvPass = new StrPass();

		LOGGER.debug(this.getDw_evaluacion().getSecuenciaeval().intValue());

		lvPass.getD()[1] = this.getDw_evaluacion().getSecuenciaeval().intValue();
		lvPass.getD()[2] = 1;

		CwHrFactoresvalorListXperiodo.getInstance().setStr_pass(lvPass);
		CwHrFactoresvalorListXperiodo.getInstance().iniciarControladora();
		this.getWebControlContext().ejecutar("PF('popCalificativos').show();");

		return null;
	}
	
	private void calcularTotales() {
		BigDecimal calXfac = BigDecimal.ZERO;
		BigDecimal sumFac = BigDecimal.ZERO;
		for (HrEmpleadofuncion ef : this.getDw11()) {
			calXfac = calXfac
					.add((UValidador.esNulo(ef.getCalificacion()) ? BigDecimal.ZERO
							: ef.getCalificacion()).multiply((UValidador
							.esNulo(ef.getFactorparticipacion()) ? BigDecimal.ZERO
							: ef.getFactorparticipacion())));
			sumFac = sumFac
					.add(UValidador.esNulo(ef.getFactorparticipacion()) ? BigDecimal.ZERO
							: ef.getFactorparticipacion());
		}

		this.setDw11totalcalificacion(calXfac.divide(sumFac
				.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ONE : sumFac,2, RoundingMode.HALF_EVEN));
		
		dw11totalsuma=sumFac;

	}

	@Override
	public String nuevo() throws Exception {

		
		calcularTotales();
		return null;
	}

	@Override
	public String editar() throws Exception {

		return null;
	}

	@Override
	public String ver() throws Exception {

		return null;
	}

	@Override
	public String eliminar() throws Exception {

		return null;
	}

	@Override
	public String inactivar() throws Exception {

		return null;
	}

	@Override
	public String ejecutar(String accion) throws Exception {

		return null;
	}

	@Override
	public String guardar() throws Exception {
		
		for (HrEmpleadofuncion em : this.getDw11()) {
			if (em.getPk().getSecuencia() == registroSelecionado.getPk()
					.getSecuencia()) {
				em.setFuncion(registroSelecionado.getFuncion());
				em.setCalificacion(registroSelecionado.getCalificacion());
				em.setFactorparticipacion(registroSelecionado.getFactorparticipacion());
				em.setComentarios(registroSelecionado.getComentarios());
				
				break;
			}
		}
		this.getWebControlContext().actualizar(
				"frmEvaluacionEmpleado:tvDatos:dtFunciones");

		return null;

	}

	@Override
	public String salir() throws Exception {

		return null;
	}

	@Override
	public Boolean validar() throws Exception {

		return null;
	}

	@Override
	public String prepararDatosMantenimiento() throws Exception {

		return null;
	}

	@Override
	public String prepararDatosListado() throws Exception {

		return null;
	}

	@Override
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico)
			throws Exception {
		
		if (mensajeControllerGenerico.getParametros()
				.get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("popFactorValorListXperiodo")) {
			StrPass lvPass;
			lvPass = (StrPass) mensajeControllerGenerico.getParametros().get(
					"lv_pass");

			if (lvPass.getD().length > 0) {

				registroSelecionado.setCalificacion(UValidador.esNulo(lvPass
						.getD()[1]) ? BigDecimal.ZERO : new BigDecimal(lvPass
						.getD()[1]));
				registroSelecionado.setFactorsecuencia(lvPass.getD()[2]);

				calcularTotales();
			}

		}


		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {

		return null;
	}

	public HrEmpleadofuncion getRegistroSelecionado() {
		return registroSelecionado;
	}

	public void setRegistroSelecionado(HrEmpleadofuncion registroSelecionado) {
		this.registroSelecionado = registroSelecionado;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public Integer getSecuenciaeval() {
		return secuenciaeval;
	}

	public void setSecuenciaeval(Integer secuenciaeval) {
		this.secuenciaeval = secuenciaeval;
	}

	public Integer getEmpleadoevaluador() {
		return empleadoevaluador;
	}

	public void setEmpleadoevaluador(Integer empleadoevaluador) {
		this.empleadoevaluador = empleadoevaluador;
	}

	public BigDecimal getCompute1() {
		return compute1;
	}

	public void setCompute1(BigDecimal compute1) {
		this.compute1 = compute1;
	}

	public BigDecimal getDw11totalsuma() {
		return dw11totalsuma;
	}

	public void setDw11totalsuma(BigDecimal dw11totalsuma) {
		this.dw11totalsuma = dw11totalsuma;
	}

}
