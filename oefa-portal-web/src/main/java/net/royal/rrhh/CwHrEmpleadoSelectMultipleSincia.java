package net.royal.rrhh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CComunSession;
import net.royal.erp.asistencia.dominio.AsArea;
import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.rrhh.dominio.HrCargosmast;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoSelectCcosto;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoSelectMultipleSincia;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.requerimientos.converter.CVTAcCostcenter;
import net.royal.rrhh.requerimientos.converter.CVTAsArea;
import net.royal.rrhh.requerimientos.converter.CVTHrCargos;
import net.royal.rrhh.vista.paginacion.PwHrEmpleadoSelectMultipleSincia;

import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
@SuppressWarnings({ "serial" })
public class CwHrEmpleadoSelectMultipleSincia extends CBaseBean implements
		UIMantenimientoController {

	private StrPass str_pass = new StrPass();

	private List<HrCargosmast> dwc_cargo = new ArrayList<HrCargosmast>();
	private List<AcCostcentermst> w_child = new ArrayList<AcCostcentermst>();
	private List<AsArea> dwc_areaoperativa = new ArrayList<AsArea>();
	private DtoDwHrEmpleadoSelectCcosto dw_ccosto = new DtoDwHrEmpleadoSelectCcosto();
	private boolean cbx_cesados;
	private String txtbusqueda;
	private String iobusqueda;
	private ListDataModel<DtoDwHrEmpleadoSelectMultipleSincia> dw_list = new ListDataModel<DtoDwHrEmpleadoSelectMultipleSincia>();
	private DtoDwHrEmpleadoSelectMultipleSincia[] registroSeleccionado;
	private List<DtoDwHrEmpleadoSelectMultipleSincia> listaRegistro;
	private Integer[] iv_empleados;
	private String[] iv_nombres;
	private String iv_selectcost;
	private StrPass str_resultado = new StrPass();

	public void onRowSelectList(SelectEvent event) throws Exception {
		this.getWebControlContext().actualizar("whrempleadoselectmultiplesincia:idEmpleadoSelect");
	}

	public String cerrar() throws Exception {
		iv_selectcost = "";
		wf_cerrar();
		return null;
	}

	public void wf_cerrar() throws Exception {
		str_resultado.setD(iv_empleados);
		str_resultado.setS(iv_nombres);

	}

	public String seleccionar() throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, "traerEmpleado");
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

	public String wf_armardata() throws Exception {
		Integer w_filas, w_contador = 0;
		String w_select = "";
		
		if (!UValidador.esNulo(registroSeleccionado)) {

			for (int i = 0; i < registroSeleccionado.length; i++) {
				listaRegistro.add(registroSeleccionado[i]);
			}
			iv_empleados = new Integer[listaRegistro.size()];
			iv_nombres = new String[listaRegistro.size()];
			for (int i = 0; i < registroSeleccionado.length; i++) {
				
				w_select = w_select + listaRegistro.get(i).getPersona();

				iv_empleados[w_contador] = listaRegistro.get(i).getPersona()
						.intValue();
				iv_nombres[w_contador] = listaRegistro.get(i)
						.getNombrecompleto();
				w_contador++;
			}

			w_select = " in ( " + w_select.substring(0, w_select.length())
					+ " ) ";
			iv_selectcost = w_select;

			if (UValidador.estaVacio(w_contador)) {
				iv_selectcost = "";
			}
		} else {
			setMessageError("Debe seleccionar un registro.");
			return null;
		}

		wf_cerrar();
		return null;
	}

	public void wf_marcar() {

		for (int i = 0; i < listaRegistro.size(); i++) {
			if (listaRegistro.get(i).getSeleccionado().equals("N")) {
				listaRegistro.get(i).setSeleccionado("S");
			} else {
				listaRegistro.get(i).setSeleccionado("N");
			}
		}

	}

	public String open() {
		String w_companiasocio;
		w_companiasocio = str_pass.getS()[1];
		wf_inicializar();
		return null;
	}

	@SuppressWarnings("unchecked")
	public String wf_inicializar() {
		Integer w_areaoperativa, prueba;
		String aplication, usuario;

		dwc_cargo = this.getFacRrhh().getHrCargosmastServicio()
				.ListarCargosmast();
		CVTHrCargos.lista = dwc_cargo;
		w_child = this.getFacContabilidad().getAcCostcentermstServicio()
				.listaComboCentroCosto();
		CVTAcCostcenter.lista = w_child;
		dwc_areaoperativa = (List<AsArea>) this.getFacAsistencia()
				.getAsAreaServicio().listarTodos();
		CVTAsArea.lista = dwc_areaoperativa;


		aplication =getUsuarioActual().getAplicacionCodigo();
		usuario = getUsuarioActual().getLoginUsuario().toUpperCase();

		prueba = this.getFacSeguridad().getSeguridadautorizacionesServicio().leerAutorizaciones(aplication, "SYSTEM", "VERAOP",
						usuario);

		if (prueba != 0) {
			dw_ccosto.setAll_areaoperativa(true);
			this.getWebControlContext().actualizar(
					"whrempleadoselectmultiplesincia:idCboAreaOperativa");
			this.getWebControlContext().actualizar(
					"whrempleadoselectmultiplesincia:idEmpleadoSelect");
		}

		wf_filtro();
		return null;
	}

	public String wf_filtro() {

		Integer w_row, ll_area = null;
		String w_filtro, w_ccosto = null, ls_cargo = null;
		boolean ls_allcargo = true, w_allccosto = true, w_area = true;

		if (cbx_cesados == true) {
			w_filtro = " AND estadoempleado in('0','2') ";
		} else {
			w_filtro = " AND estadoempleado = '0' ";
		}

		// ... filtro para Centro de costos:
		if (!UValidador.esNulo(dw_ccosto)) {
			if (!UValidador.esNulo(dw_ccosto.getCcosto())) {
				w_ccosto = dw_ccosto.getCcosto().getPk().getCostcenter();
			}
			if (!UValidador.esNulo(dw_ccosto.getCargo())) {
				ls_cargo = dw_ccosto.getCargo().getPk().getCargo();
			}
			if (!UValidador.esNulo(dw_ccosto.getAreaoperativa())) {
				ll_area = dw_ccosto.getAreaoperativa().getPk().getArea();
			}
			w_allccosto = dw_ccosto.isAllcosto();

			ls_allcargo = dw_ccosto.isAllcargo();

			w_area = dw_ccosto.isAll_areaoperativa();

			// *¨*¨*¨*¨*¨*¨*¨*¨ Filtro por Centro Costo
			if (!w_allccosto) {
				if (!UValidador.estaVacio(w_ccosto)) {
					w_filtro = w_filtro + " and centrocostos = " + w_ccosto;
				}
			}

			// *¨*¨*¨*¨*¨*¨*¨*¨ Filtro por Cargo Estructural
			if (!ls_allcargo) {
				if (!UValidador.estaVacio(ls_cargo)) {
					w_filtro = w_filtro + " and cargo  = " + ls_cargo;
				}
			}

			if (!w_area) {
				if (!UValidador.estaVacio(ll_area)) {
					w_filtro = w_filtro + " and dptoareaoperativa = " + ll_area;
				}
			}
		}

		w_filtro = w_filtro + " and tipoplanilla <> 'PR'";

		if (!UValidador.estaVacio(txtbusqueda)) {
			if (iobusqueda.equals("N")) {
				w_filtro = w_filtro + " and nombrecompleto like '%"
						+ txtbusqueda.toUpperCase() + "%'";
			} else {
				w_filtro = w_filtro + " and persona like '%" + txtbusqueda.toUpperCase()
						+ "%'";
			}
		}

		List datos = this.getFacCore().getEmpleadomastServicio()
				.listardwList(w_filtro);

		dw_list = new PwHrEmpleadoSelectMultipleSincia(datos);

		return null;

	}

	public static CwHrEmpleadoSelectMultipleSincia getInstance() {
		return UFaces.evaluateExpressionGet(
				"#{cwHrEmpleadoSelectMultipleSincia}",
				CwHrEmpleadoSelectMultipleSincia.class);
	}

	@Override
	public String iniciarControladora() throws Exception {

		dw_ccosto.setAll_areaoperativa(true);
		dw_ccosto.setAllcargo(true);
		dw_ccosto.setAllcosto(true);
		txtbusqueda = null;
		listaRegistro = new ArrayList<DtoDwHrEmpleadoSelectMultipleSincia>();
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

	public List<HrCargosmast> getDwc_cargo() {
		return dwc_cargo;
	}

	public void setDwc_cargo(List<HrCargosmast> dwc_cargo) {
		this.dwc_cargo = dwc_cargo;
	}

	public List<AcCostcentermst> getW_child() {
		return w_child;
	}

	public void setW_child(List<AcCostcentermst> w_child) {
		this.w_child = w_child;
	}

	public List<AsArea> getDwc_areaoperativa() {
		return dwc_areaoperativa;
	}

	public void setDwc_areaoperativa(List<AsArea> dwc_areaoperativa) {
		this.dwc_areaoperativa = dwc_areaoperativa;
	}

	public DtoDwHrEmpleadoSelectCcosto getDw_ccosto() {
		return dw_ccosto;
	}

	public void setDw_ccosto(DtoDwHrEmpleadoSelectCcosto dw_ccosto) {
		this.dw_ccosto = dw_ccosto;
	}

	public boolean isCbx_cesados() {
		return cbx_cesados;
	}

	public void setCbx_cesados(boolean cbx_cesados) {
		this.cbx_cesados = cbx_cesados;
	}

	public String getTxtbusqueda() {
		return txtbusqueda;
	}

	public void setTxtbusqueda(String txtbusqueda) {
		this.txtbusqueda = txtbusqueda;
	}

	public ListDataModel<DtoDwHrEmpleadoSelectMultipleSincia> getDw_list() {
		return dw_list;
	}

	public void setDw_list(
			ListDataModel<DtoDwHrEmpleadoSelectMultipleSincia> dw_list) {
		this.dw_list = dw_list;
	}

	public String getIobusqueda() {
		return iobusqueda;
	}

	public void setIobusqueda(String iobusqueda) {
		this.iobusqueda = iobusqueda;
	}

	public List<DtoDwHrEmpleadoSelectMultipleSincia> getListaRegistro() {
		return listaRegistro;
	}

	public void setListaRegistro(
			List<DtoDwHrEmpleadoSelectMultipleSincia> listaRegistro) {
		this.listaRegistro = listaRegistro;
	}

	public String getIv_selectcost() {
		return iv_selectcost;
	}

	public void setIv_selectcost(String iv_selectcost) {
		this.iv_selectcost = iv_selectcost;
	}

	public Integer[] getIv_empleados() {
		return iv_empleados;
	}

	public void setIv_empleados(Integer[] iv_empleados) {
		this.iv_empleados = iv_empleados;
	}

	public String[] getIv_nombres() {
		return iv_nombres;
	}

	public void setIv_nombres(String[] iv_nombres) {
		this.iv_nombres = iv_nombres;
	}

	public StrPass getStr_resultado() {
		return str_resultado;
	}

	public void setStr_resultado(StrPass str_resultado) {
		this.str_resultado = str_resultado;
	}

	public DtoDwHrEmpleadoSelectMultipleSincia[] getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(
			DtoDwHrEmpleadoSelectMultipleSincia[] registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}


}
