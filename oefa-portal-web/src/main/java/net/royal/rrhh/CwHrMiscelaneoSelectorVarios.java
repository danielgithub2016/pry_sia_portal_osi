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
import net.royal.erp.core.dominio.MaMiscelaneosdetalle;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrMiscelaneoPositionSelector;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.desempenio.paginacion.PWHrMiscelaneoSelectorVarios;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class CwHrMiscelaneoSelectorVarios extends CBaseBean implements
		UIMantenimientoController {

	private DtoDwHrMiscelaneoPositionSelector dw_position;
	private List<MaMiscelaneosdetalle> dw_1;
	private MaMiscelaneosdetalle[] registroSeleccionado;
	private ListDataModel<MaMiscelaneosdetalle> dw_1list;
	private String actionButton, i$_data, cadena_areas, iv_compania, iv_tabla,
			iv_aplicacion, iv_param, iv_cadena;
	private String[] areas = new String[1000];
	private Boolean inactivar;
	private Integer j = 0;
	private Integer i = 0;

	public static CwHrMiscelaneoSelectorVarios getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrMiscelaneoSelectorVarios}",
				CwHrMiscelaneoSelectorVarios.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		inicializarFiltrosListado();

		getWebControlContext().ejecutar(
				"PF('popSelectorMiscelaneoSelectorVarios').show();");
		getWebControlContext().actualizar("dgMiscelaneoSelectorVarios");
		return null;
	}

	public String seleccionar() throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
				"traerMiscelaneo");
		param.put("miscelaneo", cadena_areas);

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
	public String buscar() throws Exception {
		LOGGER.debug("LISTADO POR BUSQUEDA");

		String w_filtroCod = "%";
		String w_filtroDes = "%";

		if (!UValidador.estaVacio(dw_position.getSlebuscar())) {

			dw_1 = new ArrayList<MaMiscelaneosdetalle>();
		}

		String dato = dw_position.getSlebuscar();
		String[] o = new String[dato.length()];
		for (int i = 0; i < dato.length(); i++) {
			o[i] = dato.substring(i, i + 1);
			if(o[i].equals("'")){
				dw_position.setSlebuscar("");
			}
		}
		
		if (dw_position.getTipobusqueda().equals("A")) {
			w_filtroDes = dw_position.getSlebuscar();
		} else

		if (dw_position.getTipobusqueda().equals("C")) {
			w_filtroCod = dw_position.getSlebuscar();
		}

		if (dw_position.getBoolseleccionados().equals(true)) {
			actionButton = "VER";
		} else {
			actionButton = "SELECCION";
		}

		LOGGER.debug(w_filtroCod);
		LOGGER.debug(w_filtroDes);

		LOGGER.debug("INICIO DEL LISTADO");

		dw_1 = this
				.getFacCore()
				.getMaMiscelaneosdetalleServicio()
				.listarVerMiscelaneos("HR", "999999", "AREAEXPER", w_filtroCod,
						w_filtroDes, areas, i, actionButton);

		registroSeleccionado = new MaMiscelaneosdetalle[dw_1.size()];
		j = 0;
		for (MaMiscelaneosdetalle obj : dw_1) {
			if (obj.getAuxSeleccionado().equals("S")) {
				registroSeleccionado[j] = obj;
				j = j + 1;
			}
		}

		dw_1list = new PWHrMiscelaneoSelectorVarios(dw_1);

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

		cadena_areas = " ";

		for (MaMiscelaneosdetalle obj : registroSeleccionado) {
			if (!UValidador.estaVacio(obj.getPk().getCodigoelemento())) {
				LOGGER.debug(obj.getDescripcionlocal());

				obj.setAuxSeleccionado("S");
				areas[i] = obj.getPk().getCodigoelemento();
				i = i + 1;

				cadena_areas = cadena_areas + obj.getDescripcionlocal().trim()
						+ " - ";
			}
		}
		
		if (UValidador.estaVacio(cadena_areas)){
			setMessageError("Debe seleccionar uno o mas registros");
			return null;
		}
		cadena_areas = cadena_areas.substring(0, cadena_areas.length() - 3);

		LOGGER.debug(cadena_areas.trim());
		seleccionar();

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
		ver();
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

		if (mensajeControllerGenerico.getParametros()
				.get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("buscaMisc")) {

			if (!UValidador.estaVacio(mensajeControllerGenerico.getParametros()
					.get("w_str_pass2"))) {
				i$_data = mensajeControllerGenerico.getParametros()
						.get("w_str_pass2").toString();
			}
			if (!UValidador.estaVacio(mensajeControllerGenerico.getParametros()
					.get("w_str_pass3"))) {
				iv_aplicacion = mensajeControllerGenerico.getParametros()
						.get("w_str_pass3").toString();

			}
			if (!UValidador.estaVacio(mensajeControllerGenerico.getParametros()
					.get("w_str_pass4"))) {
				iv_compania = mensajeControllerGenerico.getParametros()
						.get("w_str_pass4").toString();

			}
			if (!UValidador.estaVacio(mensajeControllerGenerico.getParametros()
					.get("w_str_pass5"))) {
				iv_tabla = mensajeControllerGenerico.getParametros()
						.get("w_str_pass5").toString();

			}
			if (!UValidador.estaVacio(mensajeControllerGenerico.getParametros()
					.get("w_str_pass6"))) {
				iv_param = mensajeControllerGenerico.getParametros()
						.get("w_str_pass6").toString();

			}

			LOGGER.debug(iv_cadena);
			LOGGER.debug(i$_data);
			LOGGER.debug(iv_aplicacion);
			LOGGER.debug(iv_compania);
			LOGGER.debug(iv_tabla);
			LOGGER.debug(iv_param);

		}

		iniciarControladora();

		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		LOGGER.debug("INICIALIZANDO VARIABLES");

		actionButton = "SELECCION";
		dw_position = new DtoDwHrMiscelaneoPositionSelector();
		dw_1 = new ArrayList<MaMiscelaneosdetalle>();
		dw_1 = null;
		dw_1list = null;
		dw_position.setTipobusqueda("A");

		LOGGER.debug("DATOS QUE SON TRAIDOS DEL MENSAJEROS");
		LOGGER.debug(i$_data);

		// Convirtiendo i$_data en un arreglo de numeros
		String str = i$_data;
		i = 0;
		StringTokenizer st2 = new StringTokenizer(str, ",");
		while (st2.hasMoreElements()) {

			String token = st2.nextToken();
			Integer Max = token.length();
			areas[i] = token.substring(1, Max - 1);
			i = i + 1;

		}

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public DtoDwHrMiscelaneoPositionSelector getDw_position() {
		return dw_position;
	}

	public void setDw_position(DtoDwHrMiscelaneoPositionSelector dw_position) {
		this.dw_position = dw_position;
	}

	public List<MaMiscelaneosdetalle> getDw_1() {
		return dw_1;
	}

	public void setDw_1(List<MaMiscelaneosdetalle> dw_1) {
		this.dw_1 = dw_1;
	}

	public ListDataModel<MaMiscelaneosdetalle> getDw_1list() {
		return dw_1list;
	}

	public void setDw_1list(ListDataModel<MaMiscelaneosdetalle> dw_1list) {
		this.dw_1list = dw_1list;
	}

	public String getActionButton() {
		return actionButton;
	}

	public void setActionButton(String actionButton) {
		this.actionButton = actionButton;
	}

	public String getI$_data() {
		return i$_data;
	}

	public void setI$_data(String i$_data) {
		this.i$_data = i$_data;
	}

	public String[] getAreas() {
		return areas;
	}

	public void setAreas(String[] areas) {
		this.areas = areas;
	}

	public Boolean getInactivar() {
		return inactivar;
	}

	public void setInactivar(Boolean inactivar) {
		this.inactivar = inactivar;
	}

	public MaMiscelaneosdetalle[] getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(
			MaMiscelaneosdetalle[] registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public String getCadena_areas() {
		return cadena_areas;
	}

	public void setCadena_areas(String cadena_areas) {
		this.cadena_areas = cadena_areas;
	}

	public String getIv_compania() {
		return iv_compania;
	}

	public String getIv_tabla() {
		return iv_tabla;
	}

	public String getIv_aplicacion() {
		return iv_aplicacion;
	}

	public void setIv_compania(String iv_compania) {
		this.iv_compania = iv_compania;
	}

	public void setIv_tabla(String iv_tabla) {
		this.iv_tabla = iv_tabla;
	}

	public void setIv_aplicacion(String iv_aplicacion) {
		this.iv_aplicacion = iv_aplicacion;
	}

	public String getIv_param() {
		return iv_param;
	}

	public void setIv_param(String iv_param) {
		this.iv_param = iv_param;
	}

	public Integer getJ() {
		return j;
	}

	public void setJ(Integer j) {
		this.j = j;
	}

	public Integer getI() {
		return i;
	}

	public void setI(Integer i) {
		this.i = i;
	}

	public String getIv_cadena() {
		return iv_cadena;
	}

	public void setIv_cadena(String iv_cadena) {
		this.iv_cadena = iv_cadena;
	}

}
