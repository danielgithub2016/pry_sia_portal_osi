package net.royal.rrhh.desempenio.vista.controladora;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacion;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

/**
 * The Class <strong>CwHrEvaluacionCampo</strong>.
 * 
 * @author nunezh
 * @powerbuilder TAB en <strong>w_hr_evaluacionempleado_edit : p12 (dw_campo)
 *               </strong>
 */
@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CwHrEvaluacionCampo extends CwHrEvaluacionempleadoEditMaestra
		implements UIMantenimientoController {

	private String companyowner;
	private Integer empleado, secuenciaeval, empleadoevaluador;
	private HrDetalleevaluacion registroSeleccionado;

	public static CwHrEvaluacionCampo getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrEvaluacionCampo}",
				CwHrEvaluacionCampo.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		this.inicializarFiltrosListado();
		this.buscar();
		return null;
	}

	@Override
	public String buscar() throws Exception {
		 this.setDwcampo(this
				.getFacRrhh()
				.getHrDetalleevaluacionServicio()
				.obtenerLista(companyowner, secuenciaeval, empleado,
						empleadoevaluador,ConstanteRrhh.TIPO_DETALLEEVALUACION_O));

		if (UValidador.esNulo(this.getDwcampo()))
			 this.setDwcampo(new ArrayList<HrDetalleevaluacion>());

		for (HrDetalleevaluacion de : this.getDwcampo()) {
			de.setEliminado(ConstanteRrhh.TIPO_NO);
		}

		return null;
	}

	@Override
	public String nuevo() throws Exception {
		Integer llSecuencia, lvFila;

		llSecuencia = this.getFacRrhh().getHrDetalleevaluacionServicio()
				.obtenerMaximoDetalleEvaluacion(empleado, secuenciaeval);

	this.setDwcampo_child(this.getFacAsistencia().getAS().getSymastDatawindow()
				.DwMaMiscelaneosdetalleSelect("HR", "EVACAMPO", "999999"));

		if (UValidador.esListaVacia(this.getDwcampo_child()))
			this.setMessageError("Falta misceláneo EVACAMPO [Cía.: 999999] para el Tipo Evaluación de campo");

		 this.getDwcampo().add(new HrDetalleevaluacion());
		lvFila = this.getDwcampo().size() - 1;
		llSecuencia += lvFila;

		this.getDwcampo().get(lvFila).getPk().setCompanyowner(companyowner);
		this.getDwcampo().get(lvFila).getPk().setEmpleado(empleado);
		this.getDwcampo().get(lvFila).getPk().setSecuenciaeval(secuenciaeval);
		this.getDwcampo().get(lvFila).getPk().setSecuencia(llSecuencia);
		this.getDwcampo().get(lvFila).getPk().setEmpleadoevaluador(empleadoevaluador);
		this.getDwcampo().get(lvFila).getPk().setTipo(ConstanteRrhh.TIPO_DETALLEEVALUACION_O);
		this.getDwcampo().get(lvFila).setEliminado(ConstanteRrhh.TIPO_NO);

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

		if (UValidador.esNulo(registroSeleccionado))
			return null;

		for (HrDetalleevaluacion de : this.getDwcampo()) {
			if (de.getPk().getSecuencia() == registroSeleccionado.getPk()
					.getSecuencia())
				de.setEliminado("S");
		}

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
		for (HrDetalleevaluacion de : this.getDwcampo()) {
			if (de.getPk().getSecuencia() == registroSeleccionado.getPk()
					.getSecuencia()) {
				de.getPk().setTipo(registroSeleccionado.getPk().getTipo());
				de.setDescripcion(registroSeleccionado.getDescripcion());
			}
		}
		
		this.getWebControlContext().actualizar("");

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

	public HrDetalleevaluacion getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(HrDetalleevaluacion registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

}
