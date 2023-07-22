package net.royal.rrhh.desempenio.vista.controladora;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.erp.rrhh.dominio.dto.DtoDDesempenocomparativoP;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacionDetailP;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

/**
 * The Class CwHrPotencial.
 * 
 * @author nunezh
 * @powerbuilder TAB en <strong>w_hr_evaluacionempleado_edit : p9
 *               (dw_9,dw_15_p,dw16_p) </strong>
 */
@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CwHrPotencial extends CwHrEvaluacionempleadoEditMaestra implements
		UIMantenimientoController {

	private String companyowner;
	private Integer empleado, secuenciaeval, empleadoevaluador;

	public static CwHrPotencial getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrPotencial}",
				CwHrPotencial.class);
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

	@Override
	public String iniciarControladora() throws Exception {
		this.inicializarFiltrosListado();
		this.buscar();
		return null;
	}

	@Override
	public String buscar() throws Exception {
		this.setDw9(new ArrayList<DtoDwHrEmpleadoevaluacionDetailP>());
		this.setDw15p(new ArrayList<DtoDDesempenocomparativoP>());
		return null;
	}

	@Override
	public String nuevo() throws Exception {

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

}
