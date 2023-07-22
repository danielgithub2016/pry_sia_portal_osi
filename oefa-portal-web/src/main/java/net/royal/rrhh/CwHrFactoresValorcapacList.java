package net.royal.rrhh;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.dominio.HrFactorvalorcapac;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.vista.paginacion.PwHrFactoresValorCapacList;

import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
@SuppressWarnings({ "serial" })
public class CwHrFactoresValorcapacList extends CBaseBean implements UIMantenimientoController{

	private HrFactorvalorcapac registroSeleccionado;
	private ListDataModel<HrFactorvalorcapac> dw_1 = new ListDataModel<HrFactorvalorcapac>();
	private Integer iv_evaluacion;
	private StrPass lv_pass = new StrPass();
	
	public void onRowSelectList(SelectEvent event) throws Exception {
		registroSeleccionado = (HrFactorvalorcapac) event.getObject();
		
		wf_set_calificativo();
		seleccionar();
		
	}
	
	private String open(){
		iv_evaluacion = lv_pass.getD()[1];
		List datos = this.getFacRrhh().getHrFactorvalorcapacServicio().listarFactor(iv_evaluacion);
		dw_1 = new PwHrFactoresValorCapacList(datos);
		if(datos.size()>0){
			registroSeleccionado = (HrFactorvalorcapac) datos.get(0);
		}
		return null;
	}
	
	public String aceptar() throws Exception{
		wf_set_calificativo();
		if(!UValidador.esNulo(registroSeleccionado)){
			seleccionar();
		}
		return null;
	}
	
	public String wf_set_calificativo(){
		
		if(UValidador.esNulo(registroSeleccionado)){
			setMessageError("Seleccione un calificativo");
			return null;
		}
		
		lv_pass.getD()[1] = registroSeleccionado.getValor().intValue();
		lv_pass.getD()[2] = registroSeleccionado.getPk().getSecuencia();
		lv_pass.getS()[1] = registroSeleccionado.getDescripcion();
		
		return null;
	}
	
	public static CwHrFactoresValorcapacList getInstance() {
		return UFaces.evaluateExpressionGet(
				"#{cwHrFactoresValorcapacList}",
				CwHrFactoresValorcapacList.class);
	}
	
	public String seleccionar() throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, "traerFactor");
		param.put("factor", registroSeleccionado);

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

	public HrFactorvalorcapac getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(HrFactorvalorcapac registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public ListDataModel<HrFactorvalorcapac> getDw_1() {
		return dw_1;
	}

	public void setDw_1(ListDataModel<HrFactorvalorcapac> dw_1) {
		this.dw_1 = dw_1;
	}

	public Integer getIv_evaluacion() {
		return iv_evaluacion;
	}

	public void setIv_evaluacion(Integer iv_evaluacion) {
		this.iv_evaluacion = iv_evaluacion;
	}

	public StrPass getLv_pass() {
		return lv_pass;
	}

	public void setLv_pass(StrPass lv_pass) {
		this.lv_pass = lv_pass;
	}

}
