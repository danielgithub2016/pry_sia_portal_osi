package net.royal.rrhh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.erp.rrhh.dominio.dto.DtoDwPuestosSelectPosition;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.desempenio.paginacion.PWHrPuestosSelect;

import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class CwHrPuestosSelect extends CBaseBean implements
		UIMantenimientoController {
	// variables
	private List<HrPuestoempresa> dw_2;
	private ListDataModel<HrPuestoempresa> dw_2list;
	private DtoDwPuestosSelectPosition dw_position;
	private HrPuestoempresa registroSeleccionado;

	public static CwHrPuestosSelect getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrPuestosSelect}",
				CwHrPuestosSelect.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		inicializarFiltrosListado();

		getWebControlContext().ejecutar("PF('popPuestosSelect').show();");
		getWebControlContext().actualizar("dgPuestosSelect");
		return null;
	}

	public String seleccionar() throws Exception {
		LOGGER.debug("Entra a la seleccion");

		Map<String, Object> param = new HashMap<String, Object>();

		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
				"agregarPuestosSelect");
		param.put("puestos", registroSeleccionado);

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

	public void onRowSelect(SelectEvent event) throws Exception {
		LOGGER.debug("Entra a al onRowSelect");
		registroSeleccionado = (HrPuestoempresa) event.getObject();
		seleccionar();
	}

	@Override
	public String buscar() throws Exception {

		LOGGER.debug("INICIO DE LOS FILTROS");

		String w_filtroCod = "";
		String w_btnradio = "%";

		if (!UValidador.estaVacio(dw_position.getSleBuscar())) {

			w_filtroCod = dw_position.getSleBuscar();
		}
		
		String dato = dw_position.getSleBuscar();
		String[] obj = new String[dato.length()];
		for (int i = 0; i < dato.length(); i++) {
			obj[i] = dato.substring(i, i + 1);
			if(obj[i].equals("'")){
				dw_position.setSleBuscar("");
			}
		}

		if (dw_position.getTipobusqueda().equals("C")) {
			w_btnradio = "C";

		} else if (dw_position.getTipobusqueda().equals("A")) {
			w_btnradio = "A";

		} else if (dw_position.getTipobusqueda().equals("P")) {
			w_btnradio = "P";

		}
		LOGGER.debug(w_filtroCod);
		LOGGER.debug(w_btnradio);
		LOGGER.debug("INICIO DEL LISTADO");

		dw_2 = this.getFacRrhh().getHrPuestoempresaServicio()
				.listarPuestoEmpresaporFiltros(w_filtroCod, w_btnradio);

		dw_2list = new PWHrPuestosSelect(dw_2);
		return null;
	}

	@Override
	public String nuevo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ver() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inactivar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ejecutar(String accion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean validar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String prepararDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String prepararDatosListado() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		dw_2 = new ArrayList<HrPuestoempresa>();
		dw_2list = null;
		dw_position = new DtoDwPuestosSelectPosition();

		dw_position.setTipobusqueda("T");

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HrPuestoempresa> getDw_2() {
		return dw_2;
	}

	public ListDataModel<HrPuestoempresa> getDw_2list() {
		return dw_2list;
	}

	public void setDw_2(List<HrPuestoempresa> dw_2) {
		this.dw_2 = dw_2;
	}

	public void setDw_2list(ListDataModel<HrPuestoempresa> dw_2list) {
		this.dw_2list = dw_2list;
	}

	public DtoDwPuestosSelectPosition getDw_position() {
		return dw_position;
	}

	public void setDw_position(DtoDwPuestosSelectPosition dw_position) {
		this.dw_position = dw_position;
	}

	public HrPuestoempresa getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(HrPuestoempresa registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

}