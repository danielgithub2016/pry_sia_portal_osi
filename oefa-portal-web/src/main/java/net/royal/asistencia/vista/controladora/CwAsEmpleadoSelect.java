package net.royal.asistencia.vista.controladora;

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

import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
@SuppressWarnings({ "unchecked", "unused" })
public class CwAsEmpleadoSelect extends CBaseBean implements UIMantenimientoController {
	private List<DtoDwAsEmpleadoSelectMultiple> dw_list;
	private DtoDwAsEmpleadoSelectMultiple dw_position;
	private ListDataModel<DtoDwAsEmpleadoSelectMultiple> lstdw_list;
	private String iv_modo, eventname;
	private Integer w_sid;
	private Boolean cbx_cesados, cbx_concarnet;
	private DtoDwAsEmpleadoSelectMultiple registroSeleccionado;
	private List<DtoDwAsEmpleadoSelectMultiple> empleados;
	private String pantallaReferencia;
	private String flgTodos;

	// TODO Nuevo datos SIGED
	private Integer indiceModificado;
	private Boolean asignarTodos;
	private Boolean mostraAsignarTodos;
	private Boolean esPermisoSIGED;
	private String usuarioRed;
	private Boolean error;

	@Override
	public String iniciarControladora() throws Exception {
		inicializarFiltrosListado();
		asignarTodos = false;
		error = false;
		cbx_cesados = false;
		cbx_concarnet = true;

		dw_list = new ArrayList<DtoDwAsEmpleadoSelectMultiple>();

		// flgTodos = "N";
		buscar();

		return getNombreVentanaEmergente();
	}

	public String listarTodos() throws Exception {
		inicializarFiltrosListado();
		cbx_cesados = false;
		cbx_concarnet = true;

		dw_list = new ArrayList<DtoDwAsEmpleadoSelectMultiple>();

		buscar();

		return getNombreVentanaEmergente();
	}

	public void filtrar() {
		if (!UValidador.esListaVacia(empleados)) {
			wfFilter(empleados);
			lstdw_list = null;
			lstdw_list = new PWAsEmpleadoSelectMultiple(dw_list);
		}
	}

	public static CwAsEmpleadoSelect getInstance() {
		return UFaces.evaluateExpressionGet("#{cwAsEmpleadoSelect}", CwAsEmpleadoSelect.class);
	}

	public void onRowSelect(SelectEvent event) throws Exception {
		registroSeleccionado = (DtoDwAsEmpleadoSelectMultiple) event.getObject();
		getWebControlContext().actualizar("wasempleadoselect");
		seleccionar();
	}

	public String seleccionar() throws Exception {

		if (UValidador.esNulo(esPermisoSIGED)) {
			esPermisoSIGED = false;
		}

		// TODO validacion solo cuando es permisos SIGED
		if (esPermisoSIGED) {
			if (usuarioRed.equals(registroSeleccionado.getCodigoUsuarioEmpleado())) {
				setMessageError("No se puede asignar este Usuario a su misma bandeja.");
				error = true;
				return null;
			}
		}

		Map<String, Object> param = new HashMap<String, Object>();

		if (UValidador.esNulo(this.getNombreTipoBusqueda())) {
			this.setNombreTipoBusqueda("agregarEmpleado");
		}

		registroSeleccionado.setIndiceModificado(indiceModificado);

		if (UValidador.esNulo(asignarTodos)) {
			asignarTodos = false;
		}

		registroSeleccionado.setAsignarTodos(asignarTodos);

		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, this.getNombreTipoBusqueda());
		param.put("empleado", registroSeleccionado);

		if (!UValidador.esNulo(nombreContenedorRefrescar))
			this.getWebControlContext().actualizar(nombreContenedorRefrescar);

		if (!UValidador.esNulo(getNombreVentanaEmergente())) {
		}

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);

		this.getiMantenimientoReferencia().mensaje(mensajeGenerico);

		return null;
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
		if (!UValidador.estaVacio(dato)) {
			String[] obj = new String[dato.length()];
			for (int i = 0; i < dato.length(); i++) {
				obj[i] = dato.substring(i, i + 1);
				if (obj[i].equals("'")) {
					dw_position.setCodigodescripciontext("");
				}
			}
		}
		LOGGER.debug("BUSQUEDA POR FILTROS");
		if (w_lstBoolean.equals("N")) {

			w_filtroNom = dw_position.getCodigodescripciontext().toUpperCase() + "%";

		} else {

			w_filtroCod = dw_position.getCodigodescripciontext().toUpperCase() + "%";
		}

		/*
		 * f_as_genera_empleados_autorizados()
		 */
		getFacAsistencia().getAS().getAsmainFuncion()
				.FAsGeneraEmpleadosAutorizados(getUsuarioActual().getUniqueIdInteger(),
						getUsuarioActual().getLoginUsuario().toUpperCase(), getUsuarioActual().getIdPersona(),
						getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
								getUsuarioActual().getAplicacionCodigo(),
								getUsuarioActual().getLoginUsuario().toUpperCase()));

		w_sid = getUsuarioActual().getUniqueIdInteger();

		/*
		 * w_rtc =
		 * dw_1.retrieve(str_payroll.gv_usarpersonaant,str_global.gv_userid,
		 * w$_companiasocio, w#_sid)
		 */
		if ("S".equals(flgTodos)) {
			empleados = getFacAsistencia().getAS().getAsoracleDatawindow()
					.DwAsEmpleadoSelectAll(getUsuarioActual().getUniqueIdInteger(), w_filtroCod, w_filtroNom);
		} else {
			empleados = getFacAsistencia().getAS().getAsoracleDatawindow()
					.DwAsEmpleadoSelectMultiple(getUsuarioActual().getUniqueIdInteger(), w_filtroCod, w_filtroNom);
		}

		wfFilter(empleados);

		// dw_list = empleados;

		w_filtroCod = null;
		w_filtroNom = null;
		return null;
	}

	/*
	 * wf_filter()
	 */
	private void wfFilter(List<DtoDwAsEmpleadoSelectMultiple> empleados) {

		dw_list = new ArrayList<DtoDwAsEmpleadoSelectMultiple>();
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

	public List<DtoDwAsEmpleadoSelectMultiple> obtenerListadoTodos() {
		return getFacAsistencia().getAS().getAsoracleDatawindow()
				.DwAsEmpleadoSelectAll(getUsuarioActual().getUniqueIdInteger(), "%", "%");

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
		if (error) {
			error = false;
			return null;
		}
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

	public DtoDwAsEmpleadoSelectMultiple getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(DtoDwAsEmpleadoSelectMultiple registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
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

	public Integer getIndiceModificado() {
		return indiceModificado;
	}

	public void setIndiceModificado(Integer indiceModificado) {
		this.indiceModificado = indiceModificado;
	}

	public Boolean getAsignarTodos() {
		return asignarTodos;
	}

	public void setAsignarTodos(Boolean asignarTodos) {
		this.asignarTodos = asignarTodos;
	}

	public Boolean getMostraAsignarTodos() {
		return mostraAsignarTodos;
	}

	public void setMostraAsignarTodos(Boolean mostraAsignarTodos) {
		this.mostraAsignarTodos = mostraAsignarTodos;
	}

	public Boolean getEsPermisoSIGED() {
		return esPermisoSIGED;
	}

	public void setEsPermisoSIGED(Boolean esPermisoSIGED) {
		this.esPermisoSIGED = esPermisoSIGED;
	}

	public String getUsuarioRed() {
		return usuarioRed;
	}

	public void setUsuarioRed(String usuarioRed) {
		this.usuarioRed = usuarioRed;
	}

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

}
