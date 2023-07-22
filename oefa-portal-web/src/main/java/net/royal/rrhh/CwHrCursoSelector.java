package net.royal.rrhh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.asistencia.symast.dominio.dto.DtoDwMaMiscelaneosdetalleSelect;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrCursoPositionSelector;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrCursoSelector;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.requerimientos.converter.CVTMiscelaneosdetalleSelect;
import net.royal.rrhh.requerimientos.paginacion.PWHrCursoSelector;

import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class CwHrCursoSelector extends CBaseBean implements
		UIMantenimientoController {

	private List<DtoDwHrCursoSelector> dw_1;
	private ListDataModel<DtoDwHrCursoSelector> dw_1List;
	private DtoDwMaMiscelaneosdetalleSelect dwc_area;
	private List<DtoDwMaMiscelaneosdetalleSelect> dwc_arealst;
	private DtoDwHrCursoPositionSelector dw_position = new DtoDwHrCursoPositionSelector();
	private DtoDwHrCursoSelector registroSeleccionado;
	private String order;

	public static CwHrCursoSelector getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrCursoSelector}",
				CwHrCursoSelector.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		inicializarFiltrosListado();
		getWebControlContext().ejecutar(
				"PF('" + getNombreVentanaEmergente() + "').show();");
		return null;
	}

	@Override
	public String buscar() throws Exception {

		LOGGER.debug(dw_position.getSle_buscar());
		LOGGER.debug(dw_position.getArea());
		LOGGER.debug(dw_position.getTipobusqueda());

		// Busqueda por filtros
		String w_filtroCod = "%";
		String w_filtroDes = "%";
		String w_Area = "%";

		if (UValidador.estaVacio(dw_position.getSle_buscar())) {
			dw_position.setSle_buscar("");
		}

		if (dw_position.getTipobusqueda().equals("A")) {

			w_filtroDes = dw_position.getSle_buscar() + "%";

			order = "#{d.descripcion}";

		} else {

			w_filtroCod = dw_position.getSle_buscar() + "%";
			order = "#{d.curso}";
		}
		if (!UValidador.esNulo(dw_position.getArea())) {
			LOGGER.debug("entrada");
			w_Area = dw_position.getArea();

		}

		LOGGER.debug(w_filtroCod);
		LOGGER.debug(w_filtroDes);
		LOGGER.debug(w_Area);

		dw_1 = this.getFacRrhh().getHr().getHrothersDatawindow()
				.DwHrCursoSelector(w_filtroDes, w_filtroCod, w_Area);

		List<DtoDwHrCursoSelector> dw1Cabezra = this.getFacRrhh().getHr()
				.getHrothersDatawindow()
				.DwHrCursoSelectorCabezera(w_filtroDes, w_filtroCod, w_Area);

		for (DtoDwHrCursoSelector dw_1Cabezera : dw1Cabezra) {
			for (DtoDwHrCursoSelector dw1Detalle : dw_1) {
				if (dw_1Cabezera.getArea().equals(dw1Detalle.getArea())) {
					if (UValidador.esNulo(dw_1Cabezera.getDw1Detalle())) {
						dw_1Cabezera
								.setDw1Detalle(new ArrayList<DtoDwHrCursoSelector>());
						dw_1Cabezera.getDw1Detalle().add(dw1Detalle);
					} else {
						dw_1Cabezera.getDw1Detalle().add(dw1Detalle);
					}
				}
			}
		}

		dw_1List = new PWHrCursoSelector(dw1Cabezra);

		return null;
	}

	public String seleccionar() throws Exception {
		LOGGER.debug("Entra a la seleccion");
		Map<String, Object> param = new HashMap<String, Object>();

		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
				"agregarCursoSelector");
		param.put("curso", registroSeleccionado);

		if (!UValidador.esNulo(nombreContenedorRefrescar))
			this.getWebControlContext().actualizar(nombreContenedorRefrescar);
		
		if(!UValidador.estaVacio(pantallaOrigenLlamada)){
			getWebControlContext().actualizar(pantallaOrigenLlamada);
		}

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

	public void onRowSelect(SelectEvent event) throws Exception {
		LOGGER.debug("Entra a al onRowSelect");
		registroSeleccionado = (DtoDwHrCursoSelector) event.getObject();
		seleccionar();
	}

	
	public void seleccionRegistro() throws Exception{
		seleccionar();
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

		dw_1 = new ArrayList<DtoDwHrCursoSelector>();
		dw_1List = null;
		dwc_arealst = new ArrayList<DtoDwMaMiscelaneosdetalleSelect>();

		dw_position = new DtoDwHrCursoPositionSelector();
		dw_position.setTipobusqueda("A");
		dw_position.setAreaBool(true);

		LOGGER.debug("Creando los convert");

		dwc_arealst = this.getFacAsistencia().getAS().getSymastDatawindow()
				.DwMaMiscelaneosdetalleSelect("HR", "AREACURSO", "999999");

		CVTMiscelaneosdetalleSelect.lista = dwc_arealst;

		LOGGER.debug("Miscelaneosdetalle == " + dwc_arealst.size());

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		return null;
	}

	public List<DtoDwHrCursoSelector> getDw_1() {
		return dw_1;
	}

	public ListDataModel<DtoDwHrCursoSelector> getDw_1List() {
		return dw_1List;
	}

	public DtoDwMaMiscelaneosdetalleSelect getDwc_area() {
		return dwc_area;
	}

	public List<DtoDwMaMiscelaneosdetalleSelect> getDwc_arealst() {
		return dwc_arealst;
	}

	public DtoDwHrCursoPositionSelector getDw_position() {
		return dw_position;
	}

	public DtoDwHrCursoSelector getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setDw_1(List<DtoDwHrCursoSelector> dw_1) {
		this.dw_1 = dw_1;
	}

	public void setDw_1List(ListDataModel<DtoDwHrCursoSelector> dw_1List) {
		this.dw_1List = dw_1List;
	}

	public void setDwc_area(DtoDwMaMiscelaneosdetalleSelect dwc_area) {
		this.dwc_area = dwc_area;
	}

	public void setDwc_arealst(List<DtoDwMaMiscelaneosdetalleSelect> dwc_arealst) {
		this.dwc_arealst = dwc_arealst;
	}

	public void setDw_position(DtoDwHrCursoPositionSelector dw_position) {
		this.dw_position = dw_position;
	}

	public void setRegistroSeleccionado(
			DtoDwHrCursoSelector registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
