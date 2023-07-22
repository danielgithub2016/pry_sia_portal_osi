package net.royal.rrhh.desempenio.vista.controladora;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.erp.rrhh.dominio.HrEmpleadometas;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

/**
 * The Class CwHrRevisionMetas.
 * 
 * @author nunezh
 * @powerbuilder TAB en <strong>w_hr_evaluacionempleado_edit : p8 | dw_8
 *               </strong>
 */
@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CwHrRevisionMetas extends CwHrEvaluacionempleadoEditMaestra
		implements UIMantenimientoController {
	
	private String companyowner;
	private Integer empleado, secuenciaeval, empleadoevaluador;
	private HrEmpleadometas registroSeleccionado;

	public static CwHrRevisionMetas getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrRevisionMetas}",
				CwHrRevisionMetas.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		this.inicializarFiltrosListado();
		this.buscar();
		return null;
	}

	@Override
	public String buscar() throws Exception {
		this.setDw8(new ArrayList<HrEmpleadometas>());
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

	public HrEmpleadometas getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(HrEmpleadometas registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
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

}
