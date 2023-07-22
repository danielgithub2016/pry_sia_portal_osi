package net.royal.rrhh.desempenio.vista.controladora;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrEmpleadometas;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadonecesidadcapacitaEdit;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrIncidentecriticoList;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.controladora.UIMantenimientoController.accion_solicitada;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

/**
 * The Class CwHrIncidentesCriticos.
 * 
 * @author nunezh
 * @powerbuilder TAB en <strong>w_hr_evaluacionempleado_edit : p3 | dw_3
 *               </strong>
 */
@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CwHrIncidentesCriticos extends CwHrEvaluacionempleadoEditMaestra
		implements UIMantenimientoController {

	private String companyowner;
	private Integer empleado, secuenciaeval, empleadoevaluador;
	private DtoDwHrIncidentecriticoList registroSeleccionado;
	private Boolean mostraEliminar;
	private Date fechaInicio;
	private Date fechaevalfin;

	public static CwHrIncidentesCriticos getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrIncidentesCriticos}",
				CwHrIncidentesCriticos.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		this.inicializarFiltrosListado();
		mostraEliminar = false;
		this.buscar();
		return null;
	}

	@Override
	public String buscar() throws Exception {
		this.setDw3(this
				.getFacRrhh()
				.getHr()
				.getHrothersDatawindow()
				.dwHrIncidentecriticoList(companyowner, empleado, secuenciaeval,fechaevalfin));

		if (UValidador.esNulo(this.getDw3()))
			this.setDw3(new ArrayList<DtoDwHrIncidentecriticoList>());

		for (DtoDwHrIncidentecriticoList icl : this.getDw3()) {
			icl.setEliminado(ConstanteRrhh.TIPO_NO);
			icl.setMostrarEditar(false);
		}

		LOGGER.debug(companyowner + "\t" + empleado + "\t" + secuenciaeval);
		LOGGER.debug(this.getDw3().size());

		return null;
	}

	@Override
	public String nuevo() throws Exception {
		
		this.setAccionPantalla(accion_solicitada.NUEVO);
		Integer llSecuencia, lvFila;

		llSecuencia = this.getFacRrhh().getHrMeritosfaltasServicio()
				.ObtenerMaximaSecuenciaxEmp(empleado);

		lvFila = this.getDw3().size() - 1;

		if (lvFila >= llSecuencia)
			llSecuencia = lvFila + 1;
		
		llSecuencia=obtenerUltimoSecuencia(this.getDw3(), llSecuencia);

		registroSeleccionado = new DtoDwHrIncidentecriticoList();
		registroSeleccionado.setCompanyowner(companyowner);
		registroSeleccionado.setEmpleado(new BigDecimal(empleado));
		registroSeleccionado.setSecuencia(new BigDecimal(llSecuencia));
		registroSeleccionado.setFlagsoloenevaluacion(ConstanteRrhh.TIPO_SI);
		registroSeleccionado.setEliminado(ConstanteRrhh.TIPO_NO);
		registroSeleccionado.setMostrarEditar(true);
	

		Map<String, Object> param = new HashMap<String, Object>();
		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
				"agregarIncidentes");
		param.put("registroSeleccionado", registroSeleccionado);

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);

		CwHrIncidentesCriticosSelector.getInstance().setFechaInicio(fechaInicio);
		CwHrIncidentesCriticosSelector.getInstance().mensaje(mensajeGenerico);

		return null;
	}
	
	private Integer obtenerUltimoSecuencia(List<DtoDwHrIncidentecriticoList> dw3,Integer secuencia) {
		int num, max = 0, min = 0;
		Integer llSecuencia=secuencia;
		
		List<DtoDwHrIncidentecriticoList> lstdw3= new ArrayList<DtoDwHrIncidentecriticoList>();
		for(DtoDwHrIncidentecriticoList objt: dw3){
			if(objt.getEliminado().equals(ConstanteRrhh.TIPO_NO)){
				lstdw3.add(objt);
			}
		}
		
		for (int i = 0; i < lstdw3.size(); i++) {
			num = lstdw3.get(i).getSecuencia().intValue();
			if (min != 0 && max != 0) {
				if (num > max) {
					max = num;
				}
				if (num < min) {
					min = num;
				}
			} else {
				min = num;
				max = num;
			}
		}

		if (max >=llSecuencia) {
			llSecuencia = max+1;
		}
		return llSecuencia;
	}


	@Override
	public String editar() throws Exception {
		this.setAccionPantalla(accion_solicitada.EDITAR);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
				"editarIncidentes");
		registroSeleccionado.setFecha(new Date());
		param.put("registroSeleccionado", registroSeleccionado);

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);

		CwHrIncidentesCriticosSelector.getInstance().mensaje(mensajeGenerico);

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

		for (DtoDwHrIncidentecriticoList icl : this.getDw3()) {
			if (icl.getSecuencia().compareTo(
					registroSeleccionado.getSecuencia()) == 0) {
				icl.setEliminado(ConstanteRrhh.TIPO_SI);
			}
		}

		for (int i = 0; i < this.getDw3().size(); i++) {
			if (this.getDw3().get(i).getEliminado().equals(ConstanteRrhh.TIPO_NO)) {
				registroSeleccionado = this.getDw3().get(i);
			}
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

	public void cargarRegistro() {
		if (registroSeleccionado.getMostrarEditar().equals(false)) {
			mostraEliminar = true;
		} else {
			mostraEliminar = false;
		}
		
		this.getWebControlContext().actualizar("frmEvaluacionEmpleado:tvDatos:idEliminar");
		
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
				.equals("insertIncidentes")) {

			registroSeleccionado =  (DtoDwHrIncidentecriticoList) mensajeControllerGenerico
					.getParametros().get("registroSeleccionado");
			
			if (this.getAccionPantalla().equals(accion_solicitada.NUEVO)) {
				this.getDw3().add(registroSeleccionado);
			}
		}
		
		this.getWebControlContext().actualizar(
				"frmEvaluacionEmpleado:tvDatos:dtIncidentes");
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

	public DtoDwHrIncidentecriticoList getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(
			DtoDwHrIncidentecriticoList registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public Boolean getMostraEliminar() {
		return mostraEliminar;
	}

	public void setMostraEliminar(Boolean mostraEliminar) {
		this.mostraEliminar = mostraEliminar;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaevalfin() {
		return fechaevalfin;
	}

	public void setFechaevalfin(Date fechaevalfin) {
		this.fechaevalfin = fechaevalfin;
	}
}
