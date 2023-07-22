package net.royal.rrhh.desempenio.vista.controladora;

import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.erp.rrhh.dominio.HrDetalleevaluacionmejora;
import net.royal.erp.rrhh.dominio.dto.DtoHrDetalleEvaluacion;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

import org.primefaces.event.SelectEvent;

/**
 * 
 * @author nunezh
 * @powerbuilder p18 (dw_compromisomejora)
 *
 */
@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CwHrCompromisoMejora extends CwHrEvaluacionempleadoEditMaestra
		implements UIMantenimientoController {

	private HrDetalleevaluacionmejora registroSeleccionado;
	private String companyowner;

	private Integer empleadoevaluador, empleado, secuenciaeval;

	public static CwHrCompromisoMejora getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrCompromisoMejora}",
				CwHrCompromisoMejora.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		LOGGER.debug("CARGANDO COMPROMISO MEJORA");
		inicializarFiltrosListado();
		buscar();
		return null;
	}

	@Override
	public String buscar() throws Exception {
		
		this.setDwcompromisomejora(this
				.getFacRrhh()
				.getHrDetalleevaluacionmejoraServicio()
				.obtenerListaCompromisoMejora(companyowner, empleado,
						secuenciaeval, empleadoevaluador));
		return null;
	}

	/**
	 * Ver calificacion.
	 *
	 * @powerbuilder wf_calificar1
	 * @return the string
	 * @throws Exception
	 */
	public String verCalificacion() throws Exception {
		if (!CwHrEvaluacionempleadoEdit.getInstance().getOpciones()
				.isIb_evaluar()) {
			return null;
		}

		if (!UValidador.esNulo(registroSeleccionado)) {
			StrPass lsStrPass;
			lsStrPass = new StrPass();

			lsStrPass.getS()[1] = "1";
			lsStrPass.getS()[2] = "valorrequerido";
			lsStrPass.getS()[3] = companyowner;
			lsStrPass.getS()[4] = "";
			lsStrPass.getS()[5] = "";
			lsStrPass.getLo()[3] = empleado;
			lsStrPass.getLo()[4] = secuenciaeval;

			DtoHrDetalleEvaluacion dto = new DtoHrDetalleEvaluacion();
			dto.setFactor(new BigDecimal(registroSeleccionado.getFactor()));
			dto.setCalificacion(registroSeleccionado.getValorrequerido());

			CwFactoresCompetenciaCalificar.getInstance()
					.setRegistroSeleccionadoExterno(
							new DtoHrDetalleEvaluacion());
			CwFactoresCompetenciaCalificar.getInstance()
					.setRegistroSeleccionadoExterno(dto);
			CwFactoresCompetenciaCalificar.getInstance().setLs_str_pass(
					lsStrPass);
			CwFactoresCompetenciaCalificar.getInstance().setEventname("opened");
			CwFactoresCompetenciaCalificar.getInstance()
					.setNombreContenedorRefrescar(
							"frmCompromisoEdicion:itRequerido");
			CwFactoresCompetenciaCalificar.getInstance()
					.setiMantenimientoReferencia(this);
			CwFactoresCompetenciaCalificar.getInstance()
					.setNombreVentanaEmergente("popComptencias");
			CwFactoresCompetenciaCalificar.getInstance().iniciarControladora();
		}

		return null;
	}

	public void doubleclicked(SelectEvent e) throws Exception {
		LOGGER.debug("doubleclicked");
		registroSeleccionado = (HrDetalleevaluacionmejora) e.getObject();
		verCalificacion();
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
		for (HrDetalleevaluacionmejora cm : this.getDwcompromisomejora()) {
			if (cm.getPk().getSecuencia() == registroSeleccionado.getPk()
					.getSecuencia()) {
				cm.setComentarios(registroSeleccionado.getComentarios());
				cm.setValorrequerido(registroSeleccionado.getValorrequerido());
				this.getWebControlContext().actualizar(
						"frmEvaluacionEmpleado:tvDatos:dtCompromiso");
				break;
			}
		}
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
				.equals("insertarCalificacion")) {

			BigDecimal valorRetorno = (BigDecimal) mensajeControllerGenerico
					.getParametros().get("valor");
			
			registroSeleccionado.setValorrequerido(valorRetorno);
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

	public HrDetalleevaluacionmejora getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(
			HrDetalleevaluacionmejora registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public Integer getEmpleadoevaluador() {
		return empleadoevaluador;
	}

	public void setEmpleadoevaluador(Integer empleadoevaluador) {
		this.empleadoevaluador = empleadoevaluador;
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

}
