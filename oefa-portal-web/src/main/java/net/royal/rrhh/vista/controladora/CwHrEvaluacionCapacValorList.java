package net.royal.rrhh.vista.controladora;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoHrEvaluacionCapacValor;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.vista.paginacion.PwHrSolicitudCapacitacionSelect;

import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
@SuppressWarnings({ "serial" })
public class CwHrEvaluacionCapacValorList extends CBaseBean implements
UIMantenimientoController{

	private ListDataModel<DtoHrEvaluacionCapacValor> dw_1 = new ListDataModel<DtoHrEvaluacionCapacValor>();
	private DtoHrEvaluacionCapacValor registroSeleccionado;
	private Integer iv_evaluacion;

	private StrPass lv_pass = new StrPass();
	
	public String open(){

		LOGGER.debug("en open");
		iv_evaluacion = lv_pass.getD()[1];
		List data = this.getFacRrhh().getHrEvaluacioncapacvalorServicio().listarEvaluacion(iv_evaluacion);//iv_evaluacion
		dw_1 = new PwHrSolicitudCapacitacionSelect(data);
		if(data.size()>0){
			registroSeleccionado = (DtoHrEvaluacionCapacValor) data.get(0);
		}
		LOGGER.debug("data == "+data.size());
		return null;
	}
	
	public void onRowSelectList(SelectEvent event) throws Exception {
		registroSeleccionado = (DtoHrEvaluacionCapacValor) event.getObject();
		
		wf_set_calificativo();
		seleccionar();
		
	}
	public String aceptar() throws Exception{
		if(!UValidador.esNulo(registroSeleccionado)){
			wf_set_calificativo();
			seleccionar();
		}else {
			return null;
		}
		
		return null;		
	}
	
	public String seleccionar() throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, "traersucursal");
		param.put("sucursal", registroSeleccionado);

		if (!UValidador.esNulo(nombreContenedorRefrescar))
			this.getWebControlContext().actualizar(nombreContenedorRefrescar);

		if (!UValidador.esNulo(getNombreVentanaEmergente())) {
			String accionEmergente;
			accionEmergente = "PF('" + getNombreVentanaEmergente()
					+ "').hide()";
			getWebControlContext().ejecutar(accionEmergente);
		}

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);

		this.getiMantenimientoReferencia().mensaje(mensajeGenerico);

		return null;
	}

	
	public String wf_set_calificativo(){
		Integer lv_fila;
		if(UValidador.esNulo(registroSeleccionado)){
			setMessageError("Seleccione un calificativo.");
			return null;
		}
		
		lv_pass.getD()[1]=registroSeleccionado.getValor().intValue();
		return null;
	}
	
	public static CwHrEvaluacionCapacValorList getInstance() {
		return UFaces.evaluateExpressionGet(
				"#{cwHrEvaluacionCapacValorList}",
				CwHrEvaluacionCapacValorList.class);
	}
	
	@Override
	public String iniciarControladora() throws Exception {
		open();
		return null;
	}

	@Override
	public String buscar() throws Exception {
		 
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

	public Integer getIv_evaluacion() {
		return iv_evaluacion;
	}

	public void setIv_evaluacion(Integer iv_evaluacion) {
		this.iv_evaluacion = iv_evaluacion;
	}

	public ListDataModel<DtoHrEvaluacionCapacValor> getDw_1() {
		return dw_1;
	}

	public void setDw_1(ListDataModel<DtoHrEvaluacionCapacValor> dw_1) {
		this.dw_1 = dw_1;
	}

	public DtoHrEvaluacionCapacValor getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(
			DtoHrEvaluacionCapacValor registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

}
