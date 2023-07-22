package net.royal.asistencia.vista.controladora;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import net.royal.asistencia.vista.paginacion.PWAsEmpleadoSelectMultiple;
import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.asistencia.asoracle.dominio.dto.DtoDwAsEmpleadoSelectMultiple;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

@ManagedBean
@SessionScoped
@SuppressWarnings({ "unchecked", "unused" })
public class CwAsEmpleadoSelectMultiple extends CBaseBean implements UIMantenimientoController {

	private DtoDwAsEmpleadoSelectMultiple dw_position;
	private List<DtoDwAsEmpleadoSelectMultiple> dw_list;
	private ListDataModel<DtoDwAsEmpleadoSelectMultiple> lstdw_list;
	private List<DtoDwAsEmpleadoSelectMultiple> registroSeleccionado;
	private String iv_modo, eventname;
	private Boolean cbx_cesados, cbx_concarnet;
	private List<DtoDwAsEmpleadoSelectMultiple> empleados;
	private List<DtoDwAsEmpleadoSelectMultiple> backup;
	private List<DtoDwAsEmpleadoSelectMultiple> list;
	private List<DtoDwAsEmpleadoSelectMultiple> global = new ArrayList<DtoDwAsEmpleadoSelectMultiple>();
	private Integer cantRegistros;
	private Integer w_sid;
	private String conjunto;
	private String pantallaReferencia;
	private String flgTodos;

	// flag para verificar los permisos del empleado para que visualice todas su
	// área en caso de reporte de asistencia y de marcas
	private String flgReporteTodo;

	@Override
	public String iniciarControladora() throws Exception {
		inicializarFiltrosListado();
		cantRegistros = 0;
		backup = new ArrayList<DtoDwAsEmpleadoSelectMultiple>();

		getWebControlContext().ejecutar("PF('popSelectorEmpleadoMultiple').show();");
		getWebControlContext().actualizar("dgSelectorEmpleadoMultiple");

		cbx_cesados = false;
		cbx_concarnet = true;

		dw_list = new ArrayList<DtoDwAsEmpleadoSelectMultiple>();

		flgTodos = "N";

		buscar();

		return "w_as_empleado_select_multiple";
	}

	public String listarTodos() throws Exception {
		inicializarFiltrosListado();
		cantRegistros = 0;
		backup = new ArrayList<DtoDwAsEmpleadoSelectMultiple>();

		cbx_cesados = false;
		cbx_concarnet = true;

		dw_list = new ArrayList<DtoDwAsEmpleadoSelectMultiple>();

		buscar();

		return "w_as_empleado_select_multiple";
	}

	public void obtenerCantidadSeleccionados() {
		cantRegistros = 0;
		for (DtoDwAsEmpleadoSelectMultiple obj : empleados) {
			if (obj.getIsseleccionado()) {
				if (!UValidador.esListaVacia(backup)) {
					Integer cantbac = 0;
					for (DtoDwAsEmpleadoSelectMultiple bac : backup) {
						if (UValidador.esCero(obj.getPersona().compareTo(bac.getPersona()))) {
							cantbac = 1;
							break;
						}
					}
					if (UValidador.esCero(cantbac)) {
						backup.add(obj);
					}
				} else {
					backup.add(obj);
				}

			} else {
				if (!UValidador.esListaVacia(backup)) {
					for (int i = 0; i < backup.size(); i++) {
						DtoDwAsEmpleadoSelectMultiple bac = backup.get(i);
						if (UValidador.esCero(obj.getPersona().compareTo(bac.getPersona()))) {
							backup.remove(i);
							i--;
						}
					}
				}
			}
		}

		cantRegistros = backup.size();
		getWebControlContext().actualizar("wasempleadoselectMultiple:tblempleado");
	}

	public void filtrar() {
		if (!UValidador.esListaVacia(empleados)) {
			wfFilter(empleados);
			lstdw_list = null;
			lstdw_list = new PWAsEmpleadoSelectMultiple(dw_list);
		}
	}

	public static CwAsEmpleadoSelect getInstance() {
		return UFaces.evaluateExpressionGet("#{cwAsEmpleadoSelectMultiple}", CwAsEmpleadoSelect.class);
	}

	public String seleccionar() throws Exception {

		registroSeleccionado = new ArrayList();
		for (DtoDwAsEmpleadoSelectMultiple obj : backup) {
			if (obj.getIsseleccionado()) {
				registroSeleccionado.add(obj);
			}
		}

		Map<String, Object> param = new HashMap<String, Object>();
		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, "agregarEmpleado");
		param.put("empleado", registroSeleccionado);

		if (!UValidador.esNulo(nombreContenedorRefrescar))
			this.getWebControlContext().actualizar(nombreContenedorRefrescar);

		if (!UValidador.esNulo(getNombreVentanaEmergente())) {
		}

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);

		this.getiMantenimientoReferencia().mensaje(mensajeGenerico);

		return pantallaReferencia;
	}

	@Override
	public String buscar() throws Exception {
		String w_filtroCod = null;
		String w_filtroNom = null;
		String w_lstBoolean = null;

		w_filtroCod = "%";
		w_filtroNom = "%";
		w_lstBoolean = dw_position.getCodigodescripcionflag();
		/*
		 * f_as_genera_empleados_autorizados()
		 */
		String dato = dw_position.getCodigodescripciontext();
		String[] obj = new String[dato.length()];
		for (int i = 0; i < dato.length(); i++) {
			obj[i] = dato.substring(i, i + 1);
			if (obj[i].equals("'")) {
				dw_position.setCodigodescripciontext("");
			}
		}

		LOGGER.debug("BUSQUEDA POR FILTROS");
		if (w_lstBoolean.equals("N")) {

			w_filtroNom = dw_position.getCodigodescripciontext().toUpperCase() + "%";
		} else {
			w_filtroCod = dw_position.getCodigodescripciontext().toUpperCase() + "%";
		}

		getFacAsistencia().getAS().getAsmainFuncion()
				.FAsGeneraEmpleadosAutorizados(getUsuarioActual().getUniqueIdInteger(),
						getUsuarioActual().getLoginUsuario().toUpperCase(), getUsuarioActual().getIdPersona(),
						getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
								getUsuarioActual().getAplicacionCodigo(),
								getUsuarioActual().getLoginUsuario().toUpperCase()));

		w_sid = getUsuarioActual().getUniqueIdInteger();
		LOGGER.debug("w_sid == " + w_sid);
		/*
		 * w_rtc =
		 * dw_1.retrieve(str_payroll.gv_usarpersonaant,str_global.gv_userid,
		 * w$_companiasocio, w#_sid)
		 */
		if ("S".equals(flgTodos)) {
			empleados = getFacAsistencia().getAS().getAsoracleDatawindow().DwAsEmpleadoSelectAll(w_sid, w_filtroCod,
					w_filtroNom);
		} else {
			empleados = getFacAsistencia().getAS().getAsoracleDatawindow().DwAsEmpleadoSelectMultiple(w_sid,
					w_filtroCod, w_filtroNom);
		}

		List<DtoDwAsEmpleadoSelectMultiple> lstEmpleado = new ArrayList<>();
		if ("S".equals(flgReporteTodo)) {
			lstEmpleado = getFacAsistencia().getAS().getAsoracleDatawindow()
					.DwAsEmpleadoConceptoReporte(getUsuarioActual().getCodigoUsuario(), w_filtroCod, w_filtroNom);
		}
		if (!UValidador.esListaVacia(lstEmpleado)) {
			for (int i = 0; i < lstEmpleado.size(); i++) {
				DtoDwAsEmpleadoSelectMultiple objemp = lstEmpleado.get(i);
				for (DtoDwAsEmpleadoSelectMultiple objempbase : empleados) {
					if (objemp.getPersona().compareTo(objempbase.getPersona()) == 0) {
						lstEmpleado.remove(i);
						i--;
					}
				}
			}
			empleados.addAll(lstEmpleado);
		}

		wfFilter(empleados);

		// MANTENER LA SELECCION
		// si ya hay filtros en la solcitud debemos matener seleccion
		// al abrir el selector
		if (!UValidador.estaVacio(conjunto)) {
			String[] lista = conjunto.split(",");
			if (!UValidador.esNulo(lista)) {
				for (String id : lista) {
					DtoDwAsEmpleadoSelectMultiple bac = new DtoDwAsEmpleadoSelectMultiple();
					bac.setPersona(new BigDecimal(id));
					bac.setIsseleccionado(true);
					backup.add(bac);
				}
			}

		}

		for (DtoDwAsEmpleadoSelectMultiple obje : empleados) {
			for (DtoDwAsEmpleadoSelectMultiple bac : backup) {
				if (UValidador.esCero(obje.getPersona().compareTo(bac.getPersona()))) {
					bac.setNombrecompleto(obje.getNombrecompleto());
					obje.setIsseleccionado(true);
				}
			}
		}

		lstdw_list = new PWAsEmpleadoSelectMultiple(dw_list);

		w_filtroCod = null;
		w_filtroNom = null;
		return null;
	}

	/*
	 * wf_filter()
	 */
	private void wfFilter(List<DtoDwAsEmpleadoSelectMultiple> empleados) {

		dw_list.clear();
		for (DtoDwAsEmpleadoSelectMultiple obj : empleados) {
			DtoDwAsEmpleadoSelectMultiple dtoempleado = new DtoDwAsEmpleadoSelectMultiple();
			Integer a = obj.getCf_flagcarnet().intValue();

			if (!cbx_cesados && cbx_concarnet) {
				if (obj.getEstadoempleado().equals("0")) {
					dtoempleado = obj;
					dw_list.add(dtoempleado);
				}
			}

			if (!cbx_concarnet && cbx_cesados) {
				if (a.equals(1)) {
					dtoempleado = obj;
					dw_list.add(dtoempleado);
				}
			}

			if (!cbx_concarnet && !cbx_cesados) {
				if (obj.getEstadoempleado().equals("0") && a.equals(1)) {
					dtoempleado = obj;
					dw_list.add(dtoempleado);
				}
			}

			if (cbx_concarnet && cbx_cesados) {
				dtoempleado = obj;
				dw_list.add(dtoempleado);
			}
		}
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
		return pantallaReferencia;
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
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		dw_position = new DtoDwAsEmpleadoSelectMultiple();

		dw_position.setCodigodescripcionflag("N");

		list = getFacAsistencia().getAS().getAsoracleDatawindow()
				.DwAsEmpleadoSelectMultiple(getUsuarioActual().getUniqueIdInteger(), "%", "%");

		LOGGER.debug(list.size());

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DtoDwAsEmpleadoSelectMultiple> getDw_list() {
		return dw_list;
	}

	public void setDw_list(List<DtoDwAsEmpleadoSelectMultiple> dw_list) {
		this.dw_list = dw_list;
	}

	public ListDataModel<DtoDwAsEmpleadoSelectMultiple> getLstdw_list() {
		return lstdw_list;
	}

	public void setLstdw_list(ListDataModel<DtoDwAsEmpleadoSelectMultiple> lstdw_list) {
		this.lstdw_list = lstdw_list;
	}

	public String getIv_modo() {
		return iv_modo;
	}

	public void setIv_modo(String iv_modo) {
		this.iv_modo = iv_modo;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public Boolean getCbx_cesados() {
		return cbx_cesados;
	}

	public void setCbx_cesados(Boolean cbx_cesados) {
		this.cbx_cesados = cbx_cesados;
	}

	public Boolean getCbx_concarnet() {
		return cbx_concarnet;
	}

	public void setCbx_concarnet(Boolean cbx_concarnet) {
		this.cbx_concarnet = cbx_concarnet;
	}

	public DtoDwAsEmpleadoSelectMultiple getDw_position() {
		return dw_position;
	}

	public void setDw_position(DtoDwAsEmpleadoSelectMultiple dw_position) {
		this.dw_position = dw_position;
	}

	public List<DtoDwAsEmpleadoSelectMultiple> getList() {
		return list;
	}

	public void setList(List<DtoDwAsEmpleadoSelectMultiple> list) {
		this.list = list;
	}

	public List<DtoDwAsEmpleadoSelectMultiple> getGlobal() {
		return global;
	}

	public void setGlobal(List<DtoDwAsEmpleadoSelectMultiple> global) {
		this.global = global;
	}

	/**
	 * @return the cantRegistros
	 */
	public Integer getCantRegistros() {
		return cantRegistros;
	}

	/**
	 * @param cantRegistros
	 *            the cantRegistros to set
	 */
	public void setCantRegistros(Integer cantRegistros) {
		this.cantRegistros = cantRegistros;
	}

	/**
	 * @return the conjunto
	 */
	public String getConjunto() {
		return conjunto;
	}

	/**
	 * @param conjunto
	 *            the conjunto to set
	 */
	public void setConjunto(String conjunto) {
		this.conjunto = conjunto;
	}

	public String getPantallaReferencia() {
		return pantallaReferencia;
	}

	public void setPantallaReferencia(String pantallaReferencia) {
		this.pantallaReferencia = pantallaReferencia;
	}

	public String getFlgTodos() {
		return flgTodos;
	}

	public void setFlgTodos(String flgTodos) {
		this.flgTodos = flgTodos;
	}

	public String getFlgReporteTodo() {
		return flgReporteTodo;
	}

	public void setFlgReporteTodo(String flgReporteTodo) {
		this.flgReporteTodo = flgReporteTodo;
	}

}
