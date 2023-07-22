package net.royal.rrhh.vista.controladora;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoHrCentroEstudios;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.vista.paginacion.PwHrCentroEstudios;

import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
@SuppressWarnings({ "serial" })
public class CwHrCentroEstudiosSelect extends CBaseBean implements
		UIMantenimientoController {

	private StrPass str_pass = new StrPass();
	private ListDataModel<DtoHrCentroEstudios> dw_1 = new ListDataModel<DtoHrCentroEstudios>();
	private DtoHrCentroEstudios registroSeleccionado;
	private String criterio, sle_buscar;
	private Integer cantidad;

	public String aceptar() throws Exception {
		if (UValidador.esNulo(registroSeleccionado)) {
			setMessageError("Debe Seleccionar un Registro");
			return null;
		} else {
			seleccionar();
			return null;
		}
	}

	public void onRowSelectList(SelectEvent event) throws Exception {
		registroSeleccionado = (DtoHrCentroEstudios) event.getObject();

		seleccionar();
	}

	public String open() {
		Integer w_row;
		String w_sql = "";

		if (0 > str_pass.getS().length) {
			w_sql = w_sql + str_pass.getS()[1];
			List datos = this
					.getFacRrhh()
					.getHrCentroestudiosServicio()
					.listarCentroEstudios(w_sql,
							ConstanteRrhh.ACTIVIDAD_ESTADO_APROBADO);
			dw_1 = new PwHrCentroEstudios(datos);
			cantidad = datos.size();
		} else {
			List datos = this.getFacRrhh().getHrCentroestudiosServicio()
					.listarCentroEstudios(w_sql, null);
			dw_1 = new PwHrCentroEstudios(datos);
			cantidad = datos.size();
		}
		return null;
	}

	public String wf_filter(String estado) {

		return null;
	}

	public String seleccionar() throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
				"traerFactoresCompetencia");
		param.put("factoresCompetencia", registroSeleccionado);

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

	public static CwHrCentroEstudiosSelect getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrCentroEstudiosSelect}",
				CwHrCentroEstudiosSelect.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		open();
		return null;
	}

	@Override
	public String buscar() throws Exception {

		if (!criterio.equals(ConstanteRrhh.ACTIVIDAD_ESTADO_APROBADO)) {
			String p_where = " where A.CENTRO = " + sle_buscar + " ";

			List datos = this.getFacRrhh().getHrCentroestudiosServicio()
					.listarCentroEstudios(p_where, criterio);
			dw_1 = new PwHrCentroEstudios(datos);
			cantidad = datos.size();
		} else {
			String p_where = " where A.DESCRIPCION LIKE '%" + sle_buscar + "%'";

			List datos = this.getFacRrhh().getHrCentroestudiosServicio()
					.listarCentroEstudios(p_where, criterio);
			dw_1 = new PwHrCentroEstudios(datos);
			cantidad = datos.size();
		}

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

	public String getCriterio() {
		return criterio;
	}

	public void setCriterio(String criterio) {
		this.criterio = criterio;
	}

	public String getSle_buscar() {
		return sle_buscar;
	}

	public void setSle_buscar(String sle_buscar) {
		this.sle_buscar = sle_buscar;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public ListDataModel<DtoHrCentroEstudios> getDw_1() {
		return dw_1;
	}

	public void setDw_1(ListDataModel<DtoHrCentroEstudios> dw_1) {
		this.dw_1 = dw_1;
	}

	public DtoHrCentroEstudios getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(DtoHrCentroEstudios registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

}
