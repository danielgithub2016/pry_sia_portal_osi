package net.royal.rrhh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CComunGlobal;
import net.royal.erp.core.dominio.Parametrosmast;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.presupuesto.dominio.BuNivelserviciomst;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.requerimientos.paginacion.PwPrNivelServicioSelect;

import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class CwPrNivelServicioSelect extends CBaseBean implements
		UIMantenimientoController {
	private List<BuNivelserviciomst> dw_1;
	private ListDataModel<BuNivelserviciomst> dw_1list;
	private Integer Object[];
	private BuNivelserviciomst registroSeleccionado;

	public static CwPrNivelServicioSelect getInstance() {
		return UFaces.evaluateExpressionGet("#{cwPrNivelServicioSelect}",
				CwPrNivelServicioSelect.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		inicializarFiltrosListado();
		dw_1list = null;

		buscar();

		getWebControlContext().ejecutar(
				"PF('popSelectorNivelServicioSelect').show();");
		getWebControlContext().actualizar("dgSelectorNivelServicioSelect");
		return null;
	}

	@Override
	public String buscar() throws Exception {

		Integer i = 0;
		Object = new Integer[100];

		ParametrosmastPk pk = new ParametrosmastPk();
		pk.setAplicacioncodigo("HR");
		pk.setCompaniacodigo("999999");
		pk.setParametroclave("NIVSERVREQ");

		Parametrosmast registro = (Parametrosmast) this.getFacCore()
				.getParametrosmastServicio().obtenerPorId(pk);

		LOGGER.debug(registro.getExplicacion());

		String str = registro.getExplicacion();
		StringTokenizer st2 = new StringTokenizer(str, ",");
		while (st2.hasMoreElements()) {
			i = i + 1;
			String token = st2.nextToken();
			Integer Max = token.length();
			Object[i] = Integer.parseInt(token.substring(1, Max - 1));
		}

		dw_1 = CComunGlobal.getInstance().getFacPresupuesto()
				.getBuNivelserviciomstServicio()
				.listarNivelporFiltos("01000000", Object);

		LOGGER.debug(dw_1.size());

		dw_1list = new PwPrNivelServicioSelect(dw_1);

		return null;
	}

	public String seleccionar() throws Exception {
		LOGGER.debug("Entra a la seleccion");
		Map<String, Object> param = new HashMap<String, Object>();

		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
				"agregarNivelServicio");
		param.put("nivel", registroSeleccionado);

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
		registroSeleccionado = (BuNivelserviciomst) event.getObject();
		seleccionar();
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
		List<Parametrosmast> lista = null;

		dw_1 = new ArrayList<BuNivelserviciomst>();
		dw_1list = null;

		return null;

	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BuNivelserviciomst> getDw_1() {
		return dw_1;
	}

	public void setDw_1(List<BuNivelserviciomst> dw_1) {
		this.dw_1 = dw_1;
	}

	public Integer[] getObject() {
		return Object;
	}

	public void setObject(Integer[] object) {
		Object = object;
	}

	public ListDataModel<BuNivelserviciomst> getDw_1list() {
		return dw_1list;
	}

	public void setDw_1list(ListDataModel<BuNivelserviciomst> dw_1list) {
		this.dw_1list = dw_1list;
	}

	public BuNivelserviciomst getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(BuNivelserviciomst registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

}
