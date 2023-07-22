package net.royal.rrhh.desempenio.vista.controladora;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CComunSession;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDwPrEmpleadoSelect;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodo;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodoPk;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.vista.paginacion.PwPrEmpleadoSelectEval;

import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
@SuppressWarnings({ "serial" })
public class CwPrEmpleadoSelectEval extends CBaseBean implements
		UIMantenimientoController {

	private ListDataModel<DtoDwPrEmpleadoSelect> dw_1 = new ListDataModel<DtoDwPrEmpleadoSelect>();
	private DtoDwPrEmpleadoSelect registroSeleccionado;
	private Integer w_row, w_persona, iv_secuenciaeval;
	private String w_sql = "", ls_posicion, lv_compania;
	private StrPass w_param;
	private StrPass w_seguridad;
	private StrPass str_pass;
	private boolean ib_masivo = false;
	private boolean cbx_cesados = false;
	private boolean cbx_inactivo = false;
	private String cboCriterio;
	private String txtBusqueda;

	public String aceptar() throws Exception {
		if (!UValidador.esNulo(registroSeleccionado)) {
			seleccionar();
			return null;
		} else {
			setMessageError("Debe seleccionar un registro.");
			return null;
		}
	}

	public void onRowSelectList(SelectEvent event) throws Exception {
		registroSeleccionado = (DtoDwPrEmpleadoSelect) event.getObject();

		seleccionar();

	}

	public String seleccionar() throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, "traerempleado");
		param.put("empleado", registroSeleccionado);

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

	public String open() {

		if (w_param.getS().length > 0) {
			lv_compania = w_param.getS()[1];
		}
		if (w_param.getD().length > 0) {
			iv_secuenciaeval = w_param.getD()[1];
		}
		if (UValidador.esNulo(w_param.isB())) {
			ib_masivo = w_param.isB();
		}
		if (w_param.getPo().length > 0) {
		}

		// ...dw_1.rowscopy(1,dw_1.rowcount(),primary!,iv_datawindow_Dest,1,primary!)

		// ===========================================
		// ...Tomar los datos de la clase del periodo
		// ===========================================

		String ls_Plantilla;
		Integer ll_secuenciaeval;
		ll_secuenciaeval = iv_secuenciaeval;
		boolean acceso, verdad = false;

		HrEvaluacionperiodoPk pk = new HrEvaluacionperiodoPk(); // /////////////
		HrEvaluacionperiodo x = new HrEvaluacionperiodo(); // /////////////
		pk.setSecuenciaeval(2); // /////////////
		pk.setCompanyowner("01000000"); // /////////////
		x = (HrEvaluacionperiodo) this.getFacRrhh()
				.getHrEvaluacionperiodoServicio().obtenerPorId(pk);
		if (UValidador.estaVacio(x.getPlantillaeval())) {
			ls_Plantilla = "";
		} else {
			ls_Plantilla = x.getPlantillaeval();
		}

		if (this.getFacSeguridad()
				.getSeguridadautorizacionesServicio()
				.tieneAccesoSysAdm("0",
						getUsuarioActual().getLoginUsuario().toUpperCase())) {

		} else {
			acceso = this
					.getFacSeguridad()
					.getSeguridadautorizacionesServicio()
					.tieneAcceso("0", "GRUP02", "CON070",
							getUsuarioActual().getLoginUsuario().toUpperCase());
			if (acceso) {
				w_sql = w_sql
						+ " and exists (select HR_PlantillaEvaluado.Evaluado "
						+ " from SGCORESYS.HR_PlantillaEvaluado "
						+ " where HR_PlantillaEvaluado.Plantilla = '"
						+ ls_Plantilla
						+ "' and "
						+ " HR_PlantillaEvaluado.Evaluador = "
						+ getUsuarioActual().getIdPersona()
						+ " and "
						+ " HR_PlantillaEvaluado.Evaluado = EmpleadoMast.Empleado)";
			}
		}

		if (0 > str_pass.getS().length) {
			w_sql = w_sql + str_pass.getS()[1];
		}

		wf_filter();

		Integer w_null;
		w_null = null;
		str_pass.getD()[1] = null;
		str_pass.getS()[1] = "Cancelo";

		return null;
	}

	public String wf_filter() {
		if (cbx_cesados) {
			w_sql = w_sql + " and 1 = 1 ";
		} else {
			w_sql = w_sql + " and EmpleadoMast.	EstadoEmpleado <> 2 ";
		}

		if (cbx_inactivo) {
			w_sql = w_sql + " AND 1=1 ";
		} else {
			w_sql = w_sql + "  AND 	EmpleadoMast.Estado = 'A' ";
		}

		List datos = this.getFacCore().getEmpleadomastServicio()
				.listarEmpleadoEval(w_sql);
		LOGGER.debug("datos == " + datos);
		dw_1 = new PwPrEmpleadoSelectEval(datos);
		return null;
	}

	public static CwPrEmpleadoSelectEval getInstance() {
		return UFaces.evaluateExpressionGet("#{cwPrEmpleadoSelectEval}",
				CwPrEmpleadoSelectEval.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		str_pass = new StrPass();
		cboCriterio = ConstanteRrhh.TIPO_CRITERIO_C;
		registroSeleccionado = new DtoDwPrEmpleadoSelect();
		if (UValidador.esNulo(w_param)) {
			w_param = new StrPass();
		}
		if (UValidador.esNulo(w_seguridad)) {
			w_seguridad = new StrPass();
		}
		open();
		return null;
	}

	@Override
	public String buscar() throws Exception {
		w_sql = " ";
		if (cboCriterio.equals(ConstanteRrhh.TIPO_CRITERIO_C)) {
			if (!UValidador.estaVacio(txtBusqueda)) {
				w_sql = w_sql + " and empleado like '%" + txtBusqueda + "%' ";
			}
		} else {
			if (!UValidador.estaVacio(txtBusqueda)) {
				w_sql = w_sql + " and nombrecompleto like '%"
						+ txtBusqueda.toUpperCase() + "%'";
			}
		}
		wf_filter();
		return null;
	}

	public String cancelar() {
		str_pass.getS()[1] = "Cancelo";
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

	public ListDataModel<DtoDwPrEmpleadoSelect> getDw_1() {
		return dw_1;
	}

	public void setDw_1(ListDataModel<DtoDwPrEmpleadoSelect> dw_1) {
		this.dw_1 = dw_1;
	}

	public DtoDwPrEmpleadoSelect getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(
			DtoDwPrEmpleadoSelect registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public Integer getW_row() {
		return w_row;
	}

	public void setW_row(Integer w_row) {
		this.w_row = w_row;
	}

	public Integer getW_persona() {
		return w_persona;
	}

	public void setW_persona(Integer w_persona) {
		this.w_persona = w_persona;
	}

	public Integer getIv_secuenciaeval() {
		return iv_secuenciaeval;
	}

	public void setIv_secuenciaeval(Integer iv_secuenciaeval) {
		this.iv_secuenciaeval = iv_secuenciaeval;
	}

	public String getW_sql() {
		return w_sql;
	}

	public void setW_sql(String w_sql) {
		this.w_sql = w_sql;
	}

	public String getLs_posicion() {
		return ls_posicion;
	}

	public void setLs_posicion(String ls_posicion) {
		this.ls_posicion = ls_posicion;
	}

	public String getLv_compania() {
		return lv_compania;
	}

	public void setLv_compania(String lv_compania) {
		this.lv_compania = lv_compania;
	}

	public StrPass getW_param() {
		return w_param;
	}

	public void setW_param(StrPass w_param) {
		this.w_param = w_param;
	}

	public StrPass getW_seguridad() {
		return w_seguridad;
	}

	public void setW_seguridad(StrPass w_seguridad) {
		this.w_seguridad = w_seguridad;
	}

	public StrPass getStr_pass() {
		return str_pass;
	}

	public void setStr_pass(StrPass str_pass) {
		this.str_pass = str_pass;
	}

	public boolean isIb_masivo() {
		return ib_masivo;
	}

	public void setIb_masivo(boolean ib_masivo) {
		this.ib_masivo = ib_masivo;
	}

	public boolean isCbx_cesados() {
		return cbx_cesados;
	}

	public void setCbx_cesados(boolean cbx_cesados) {
		this.cbx_cesados = cbx_cesados;
	}

	public boolean isCbx_inactivo() {
		return cbx_inactivo;
	}

	public void setCbx_inactivo(boolean cbx_inactivo) {
		this.cbx_inactivo = cbx_inactivo;
	}

	public String getCboCriterio() {
		return cboCriterio;
	}

	public void setCboCriterio(String cboCriterio) {
		this.cboCriterio = cboCriterio;
	}

	public String getTxtBusqueda() {
		return txtBusqueda;
	}

	public void setTxtBusqueda(String txtBusqueda) {
		this.txtBusqueda = txtBusqueda;
	}

}
