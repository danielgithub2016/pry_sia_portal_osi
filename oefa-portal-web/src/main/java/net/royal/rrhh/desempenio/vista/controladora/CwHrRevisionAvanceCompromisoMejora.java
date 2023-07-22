package net.royal.rrhh.desempenio.vista.controladora;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrEmpleadorevision;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodo;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrIncidentecriticoList;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.controladora.UIMantenimientoController.accion_solicitada;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

/**
 * The Class CwHrRevisionAvanceCompromisoMejora.
 * 
 * @author nunezh
 * @powerbuilder p16 (dw_revision)
 */
@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CwHrRevisionAvanceCompromisoMejora extends
		CwHrEvaluacionempleadoEditMaestra implements UIMantenimientoController {

	private String companyowner;
	private Integer empleado, secuenciaeval, empleadoevaluador;
	private HrEmpleadorevision registroSeleccionado;

	public static CwHrRevisionAvanceCompromisoMejora getInstance() {
		return UFaces.evaluateExpressionGet(
				"#{cwHrRevisionAvanceCompromisoMejora}",
				CwHrRevisionAvanceCompromisoMejora.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		this.inicializarFiltrosListado();
		this.buscar();
		return null;
	}

	@Override
	public String buscar() throws Exception {
		this.setDwrevision(this
				.getFacRrhh()
				.getHrEmpleadorevisionServicio()
				.obtenerListaRevision(companyowner, empleado, secuenciaeval,
						empleadoevaluador));

		if (UValidador.esNulo(this.getDwrevision()))
			this.setDwrevision(new ArrayList<HrEmpleadorevision>());

		for (HrEmpleadorevision er : this.getDwrevision()) {
			er.setEliminado(ConstanteRrhh.TIPO_NO);
		}

		return null;
	}

	@Override
	public String nuevo() throws Exception {
		this.setAccionPantalla(accion_solicitada.NUEVO);
		Integer llMaximaSecuencia;
		String wsPeriodo;

		llMaximaSecuencia = 0;
		for (HrEmpleadorevision er : this.getDwrevision()) {
			if (er.getPk().getSecuencia() > llMaximaSecuencia)
				llMaximaSecuencia = er.getPk().getSecuencia();
		}

		if (!UValidador.esNulo(this.getDwrevision())) {
			HrEvaluacionperiodo evaped = this.getFacRrhh()
					.getHrEvaluacionperiodoServicio()
					.obtenerXSecuenciaEvalCompania(secuenciaeval, companyowner);
			wsPeriodo = evaped.getPeriodo();

			HrEmpleadorevision bean = new HrEmpleadorevision();
			bean.getPk().setCompanyowner(companyowner);
			bean.setDescripcion("");
			bean.setPeriodo(wsPeriodo);
			bean.getPk().setEmpleado(empleado);
			bean.getPk().setSecuenciaeval(secuenciaeval);
			bean.getPk().setSecuencia(llMaximaSecuencia + 1);
			bean.getPk().setEmpleadoevaluador(empleadoevaluador);
			bean.setEliminado(ConstanteRrhh.TIPO_NO);

			registroSeleccionado = bean;
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
					"agregarAvances");
			param.put("registroSeleccionado", registroSeleccionado);

			MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
			mensajeGenerico.setParametros(param);

			CwHrRevisionAvanceSelector.getInstance().mensaje(mensajeGenerico);
		}
		return null;
	}

	
	public void insertarRegistro(){
		Integer llMaximaSecuencia;
		String wsPeriodo;

		llMaximaSecuencia = 0;
		for (HrEmpleadorevision er : this.getDwrevision()) {
			if (er.getPk().getSecuencia() > llMaximaSecuencia)
				llMaximaSecuencia = er.getPk().getSecuencia();
		}

		if (!UValidador.esNulo(this.getDwrevision())) {
			HrEvaluacionperiodo evaped = this.getFacRrhh()
					.getHrEvaluacionperiodoServicio()
					.obtenerXSecuenciaEvalCompania(secuenciaeval, companyowner);
			wsPeriodo = evaped.getPeriodo();

			HrEmpleadorevision bean = new HrEmpleadorevision();
			bean.getPk().setCompanyowner(companyowner);
			bean.setDescripcion("");
			bean.setPeriodo(wsPeriodo);
			bean.getPk().setEmpleado(empleado);
			bean.getPk().setSecuenciaeval(secuenciaeval);
			bean.getPk().setSecuencia(llMaximaSecuencia + 1);
			bean.getPk().setEmpleadoevaluador(empleadoevaluador);
			bean.setEliminado(ConstanteRrhh.TIPO_NO);

			this.getDwrevision().add(bean);
			registroSeleccionado = bean;
			
		}
			
	}
	
	@Override
	public String editar() throws Exception {
		this.setAccionPantalla(accion_solicitada.EDITAR);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
				"editarAvances");
		param.put("registroSeleccionado", registroSeleccionado);

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);

		CwHrRevisionAvanceSelector.getInstance().mensaje(mensajeGenerico);
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

		for (HrEmpleadorevision er : this.getDwrevision()) {
			if (er.getPk().getSecuencia() == registroSeleccionado.getPk()
					.getSecuencia()) {
				er.setEliminado(ConstanteRrhh.TIPO_SI);
			}
		}

		for (int i = 0; i < this.getDwrevision().size(); i++) {
			if (this.getDwrevision().get(i).getEliminado().equals(ConstanteRrhh.TIPO_NO))
				registroSeleccionado = this.getDwrevision().get(i);
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
				.equals("insertAvances")) {

			registroSeleccionado =  (HrEmpleadorevision) mensajeControllerGenerico
					.getParametros().get("registroSeleccionado");
			
			if (this.getAccionPantalla().equals(accion_solicitada.NUEVO)) {
				this.getDwrevision().add(registroSeleccionado);
			}
		}
		
		this.getWebControlContext().actualizar(
				"frmEvaluacionEmpleado:tvDatos:dtRevisionAvanceCompromisoMejora");

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

	public HrEmpleadorevision getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(HrEmpleadorevision registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

}
