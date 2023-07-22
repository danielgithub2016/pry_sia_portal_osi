package net.royal.rrhh.vista.controladora;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import org.primefaces.event.SelectEvent;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwFactoresCompetenciaHistorial;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.vista.paginacion.PwFactoresCompetenciaHistorial;

@ManagedBean
@SessionScoped
@SuppressWarnings({ "serial", "rawtypes" })
public class CwFactoresCompetenciaHistorial extends CBaseBean implements
		UIMantenimientoController {

	private ListDataModel<DtoDwFactoresCompetenciaHistorial> dw1 = new ListDataModel<DtoDwFactoresCompetenciaHistorial>();
	private DtoDwFactoresCompetenciaHistorial registroSeleccionado;
	private StrPass ls_str_pass = new StrPass();
	private String is_flagcalificacion;

	public void onRowSelectList(SelectEvent event) throws Exception {
		registroSeleccionado = (DtoDwFactoresCompetenciaHistorial) event
				.getObject();

		if (is_flagcalificacion.equals(ConstanteRrhh.TIPO_CALIFICACION_TRES)
				|| is_flagcalificacion
						.equals(ConstanteRrhh.TIPO_CALIFICACION_CUATRO)) {

			seleccionar();
		}
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

	public DtoDwFactoresCompetenciaHistorial getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(
			DtoDwFactoresCompetenciaHistorial registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public String open() {
		List data = this
				.getFacRrhh()
				.getHr()
				.getHrprocDatawindow()
				.listarDw1(ls_str_pass.getS()[1], ls_str_pass.getLo()[1],
						ls_str_pass.getLo()[2], ls_str_pass.getLo()[3]);

		dw1 = new PwFactoresCompetenciaHistorial(data);
		return null;
	}

	public ListDataModel<DtoDwFactoresCompetenciaHistorial> getDw1() {
		return dw1;
	}

	public void setDw1(ListDataModel<DtoDwFactoresCompetenciaHistorial> dw1) {
		this.dw1 = dw1;
	}

	public StrPass getLs_str_pass() {
		return ls_str_pass;
	}

	public void setLs_str_pass(StrPass ls_str_pass) {
		this.ls_str_pass = ls_str_pass;
	}

	public static CwFactoresCompetenciaHistorial getInstance() {
		return UFaces.evaluateExpressionGet(
				"#{cwFactoresCompetenciaHistorial}",
				CwFactoresCompetenciaHistorial.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		open();

		getWebControlContext().ejecutar(
				"PF('popCompetenciasHistorial').show();");
		getWebControlContext().actualizar("dgCompetenciasHistorial");
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

	public String getIs_flagcalificacion() {
		return is_flagcalificacion;
	}

	public void setIs_flagcalificacion(String is_flagcalificacion) {
		this.is_flagcalificacion = is_flagcalificacion;
	}

}
