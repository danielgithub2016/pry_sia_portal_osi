package net.royal.rrhh.desempenio.vista.controladora;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrFactorvalorSelCore;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.vista.paginacion.PDtoDwHrFactorValorSelCore;

import org.primefaces.event.SelectEvent;

/**
 * The Class CwHrFactoresvalorListXperiodo.
 * 
 * @powerbuilder w_hr_factoresvalor_list_x_periodo
 */
@ManagedBean
@SessionScoped
@SuppressWarnings({ "serial" })
public class CwHrFactoresvalorListXperiodo extends CBaseBean implements
		UIMantenimientoController {

	private StrPass str_pass;
	private Integer iv_factor;
	private Integer w_tipo;
	private DtoDwHrFactorvalorSelCore registroSeleccionado;
	private ListDataModel<DtoDwHrFactorvalorSelCore> dw_1;

	private String mle_1;

	public static CwHrFactoresvalorListXperiodo getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrFactoresvalorListXperiodo}",
				CwHrFactoresvalorListXperiodo.class);
	}

	public void onRowSelectList(SelectEvent event) throws Exception {
		registroSeleccionado = (DtoDwHrFactorvalorSelCore) event.getObject();
		RowFocusChanged();
		wf_set_calificativo();
	}

	public String actualizaEstado(SelectEvent event){
		registroSeleccionado = (DtoDwHrFactorvalorSelCore) event.getObject();
		RowFocusChanged();
		return null;
	}
	
	public String RowFocusChanged() {
		String w_explicacion = "", w_explicacion2 = "";
		w_explicacion = registroSeleccionado.getExplicacion();
		if (UValidador.estaVacio(w_explicacion)) {
			w_explicacion = "";
		}
		if (w_tipo != 0) {
			w_explicacion2 = registroSeleccionado.getExplicacion2();
			if (UValidador.estaVacio(w_explicacion2)) {
				w_explicacion2 = "";
			}
		}
		mle_1 = w_explicacion + w_explicacion2;

		this.getWebControlContext().actualizar("frmCalificativos:idTextArea");
		return null;
	}

	public String open() throws Exception {

		iv_factor = str_pass.getD()[1];
		w_tipo = str_pass.getD()[2];
		if (w_tipo == 0) {

			List datos = this.getFacRrhh().getHrFactorvalorServicio()
					.listarDw1(iv_factor);
			LOGGER.debug("datos == " + datos.size());
			dw_1 = new PDtoDwHrFactorValorSelCore(datos);
		} else {

			List datos1 = this
					.getFacRrhh()
					.getHrEvaluacionperiodovalorServicio()
					.listarEvaluacionPeriodoEvaluar(
							BigDecimal.valueOf(iv_factor));
			LOGGER.debug("datos == " + datos1.size());
			dw_1 = new PDtoDwHrFactorValorSelCore(datos1);
		}

		return null;
	}

	public String wf_set_calificativo() throws Exception {
		Integer lv_fila;
		StrPass lv_pass;

		if (UValidador.esNulo(registroSeleccionado)) {
			setMessageError("Seleccione un calificativo");
			return null;
		}
		HashMap<String, Object> parametro = new HashMap<>();
		MensajeControllerGenerico mensajeControllerGenerico = new MensajeControllerGenerico();

		parametro.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
				"popFactorValorListXperiodo");

		lv_pass = new StrPass();
		lv_pass.getD()[1] = registroSeleccionado.getValor().intValue();
		lv_pass.getD()[2] = registroSeleccionado.getSecuencia().intValue();
		lv_pass.getS()[1] = registroSeleccionado.getDescripcion();

		if (registroSeleccionado.getDescripcion().equals(ConstanteRrhh.TIPO_CALIFICACION_CINCO)) {
			lv_pass.getS()[1] = "Mucho más que aceptable";
		} else if (registroSeleccionado.getDescripcion().equals(ConstanteRrhh.TIPO_CALIFICACION_CUATRO)) {
			lv_pass.getS()[1] = "Mas que aceptable";
		} else if (registroSeleccionado.getDescripcion().equals(ConstanteRrhh.TIPO_CALIFICACION_TRES)) {
			lv_pass.getS()[1] = "Aceptable";
		} else if (registroSeleccionado.getDescripcion().equals(ConstanteRrhh.TIPO_CALIFICACION_DOS)) {
			lv_pass.getS()[1] = "Menos que aceptable";
		} else {
			lv_pass.getS()[1] = "Mucho menos que aceptable";
		}

		parametro.put("lv_pass", lv_pass);

		if (!UValidador.esNulo(nombreContenedorRefrescar))
			this.getWebControlContext().actualizar(nombreContenedorRefrescar);

		if (!UValidador.esNulo(getNombreVentanaEmergente())) {
			String accionEmergente;
			accionEmergente = "PF('" + getNombreVentanaEmergente()
					+ "').hide()";
			getWebControlContext().ejecutar(accionEmergente);
		}

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(parametro);

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

	public StrPass getStr_pass() {
		return str_pass;
	}

	public void setStr_pass(StrPass str_pass) {
		this.str_pass = str_pass;
	}

	public Integer getIv_factor() {
		return iv_factor;
	}

	public void setIv_factor(Integer iv_factor) {
		this.iv_factor = iv_factor;
	}

	public Integer getW_tipo() {
		return w_tipo;
	}

	public void setW_tipo(Integer w_tipo) {
		this.w_tipo = w_tipo;
	}

	public DtoDwHrFactorvalorSelCore getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(
			DtoDwHrFactorvalorSelCore registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public ListDataModel<DtoDwHrFactorvalorSelCore> getDw_1() {
		return dw_1;
	}

	public void setDw_1(ListDataModel<DtoDwHrFactorvalorSelCore> dw_1) {
		this.dw_1 = dw_1;
	}

	public String getMle_1() {
		return mle_1;
	}

	public void setMle_1(String mle_1) {
		this.mle_1 = mle_1;
	}
}
