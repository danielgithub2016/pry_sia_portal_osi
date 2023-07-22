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
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDwHrGeneralEmpleadoPosition;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDwPrEmpleadoSelect;
import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.planilla.dominio.PrTipoplanilla;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.requerimientos.converter.CVTAcCostcenter;
import net.royal.rrhh.requerimientos.converter.CVTPrTipoplanilla;
import net.royal.rrhh.requerimientos.paginacion.PwPrEmpleadoSelect;

import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class CwPrEmpleadoSelect extends CBaseBean implements UIMantenimientoController {

	private List<DtoDwPrEmpleadoSelect> dw_1;
	private DtoDwHrGeneralEmpleadoPosition dw_position;
	private ListDataModel<DtoDwPrEmpleadoSelect> dw_1List;
	private DtoDwPrEmpleadoSelect registroSeleccionado;
	private PrTipoplanilla tipoplanilla;
	private List<PrTipoplanilla> lsttipoplanilla;
	private AcCostcentermst costcenter;
	private List<AcCostcentermst> lstcostcenter;
	private String str_global_gv_userid, str_hhrr_gv_usarpersonaant;
	private String pantallaReferencia;
	private String incluirNegativos;

	public static CwPrEmpleadoSelect getInstance() {
		return UFaces.evaluateExpressionGet("#{cwPrEmpleadoSelect}", CwPrEmpleadoSelect.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		inicializarFiltrosListado();
		return "w_pr_empleado_select";
	}

	public String seleccionar() throws Exception {
		LOGGER.debug("Entra a la seleccion");
		Map<String, Object> param = new HashMap<String, Object>();

		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, "agregarPrEmpleado");
		param.put("prempleado", registroSeleccionado);

		if (!UValidador.esNulo(nombreContenedorRefrescar))
			this.getWebControlContext().actualizar(nombreContenedorRefrescar);

		if (!UValidador.esNulo(getNombreVentanaEmergente())) {
		}

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);

		this.getiMantenimientoReferencia().mensaje(mensajeGenerico);
		return this.pantallaReferencia;
	}

	public void onRowSelect(SelectEvent event) throws Exception {
		LOGGER.debug("Entra a al onRowSelect");
		registroSeleccionado = (DtoDwPrEmpleadoSelect) event.getObject();
		seleccionar();
	}

	@Override
	public String buscar() throws Exception {

		LOGGER.debug("BUSQUEDA POR FILTROS");
		// Busqueda por filtros
		String w_filtroCod = "%";
		String w_filtroDes = "%";
		String w_centrocosto = "%";
		String w_tipoplanilla = "%";
		String w_cesados = "%";
		String w_inactivos = "%";

		if (UValidador.estaVacio(dw_position.getSle_buscar())) {
			dw_position.setSle_buscar("");
		}

		String dato = dw_position.getSle_buscar();
		String[] obj = new String[dato.length()];
		for (int i = 0; i < dato.length(); i++) {
			obj[i] = dato.substring(i, i + 1);
			if (obj[i].equals("'")) {
				dw_position.setSle_buscar("");
			}
		}

		if (dw_position.getTipobusqueda().equals("A")) {

			w_filtroDes = dw_position.getSle_buscar().toUpperCase() + "%";

		} else {

			w_filtroCod = dw_position.getSle_buscar() + "%";

		}
		if (!UValidador.esNulo(dw_position.getCentroCosto())) {
			LOGGER.debug("entrada");
			w_centrocosto = dw_position.getCentroCosto().getPk().getCostcenter().toString();

		}
		if (!UValidador.esNulo(dw_position.getTipoplanilla())) {
			LOGGER.debug("entrada");
			w_tipoplanilla = dw_position.getTipoplanilla().getPk().getTipoplanilla();

		}

		if (dw_position.getBoolCesados().equals(false)) {
			w_cesados = "2";
		}
		if (dw_position.getBoolInactivos().equals(false)) {
			w_inactivos = "A";
		}

		LOGGER.debug(w_filtroCod);
		LOGGER.debug(w_filtroDes);
		LOGGER.debug(w_centrocosto);
		LOGGER.debug(w_tipoplanilla);
		LOGGER.debug(w_cesados);
		LOGGER.debug(w_inactivos);

		// str_hhrr_gv_usarpersonaant =
		// this.getFacCore().getParametrosmastServicio()
		// .obtenerValorCadena(new ParametrosmastPk("HR", "999999",
		// "PERSONAANT"));
		//
		// LOGGER.debug(str_global_gv_userid);
		// LOGGER.debug(str_hhrr_gv_usarpersonaant);

		dw_1 = getFacAsistencia().getAS().getAsmastDatawindow().DwPrEmpleadoSelect(w_centrocosto, w_tipoplanilla,
				w_filtroDes, w_filtroCod, w_cesados, w_inactivos, incluirNegativos);
		dw_1List = new PwPrEmpleadoSelect(dw_1);

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

		dw_1List = null;
		dw_1 = new ArrayList<DtoDwPrEmpleadoSelect>();
		dw_position = new DtoDwHrGeneralEmpleadoPosition();
		LOGGER.debug("INICIANDO LOS CONVERTS");
		dw_position.setTipobusqueda("A");
		dw_position.setBoolTipoplanilla(true);
		dw_position.setBoolCentrocosto(true);
		if ("S".equals(incluirNegativos)) {
			dw_position.setBoolCesados(true);
		}

		lstcostcenter = getFacContabilidad().getAcCostcentermstServicio().listaComboCentroCosto();
		CVTAcCostcenter.lista = lstcostcenter;

		LOGGER.debug("lstcostcenter == " + lstcostcenter.size());

		lsttipoplanilla = getFacPlanilla().getPrTipoplanillaServicio().ListarTipoPlanilla();
		CVTPrTipoplanilla.lista = lsttipoplanilla;

		LOGGER.debug("lsttipoplanilla == " + lsttipoplanilla.size());

		str_global_gv_userid = getUsuarioActual().getLoginUsuario().toUpperCase();

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		return null;
	}

	public List<DtoDwPrEmpleadoSelect> getDw_1() {
		return dw_1;
	}

	public AcCostcentermst getCostcenter() {
		return costcenter;
	}

	public List<AcCostcentermst> getLstcostcenter() {
		return lstcostcenter;
	}

	public void setDw_1(List<DtoDwPrEmpleadoSelect> dw_1) {
		this.dw_1 = dw_1;
	}

	public void setCostcenter(AcCostcentermst costcenter) {
		this.costcenter = costcenter;
	}

	public void setLstcostcenter(List<AcCostcentermst> lstcostcenter) {
		this.lstcostcenter = lstcostcenter;
	}

	public PrTipoplanilla getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(PrTipoplanilla tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

	public List<PrTipoplanilla> getLsttipoplanilla() {
		return lsttipoplanilla;
	}

	public void setLsttipoplanilla(List<PrTipoplanilla> lsttipoplanilla) {
		this.lsttipoplanilla = lsttipoplanilla;
	}

	public DtoDwHrGeneralEmpleadoPosition getDw_position() {
		return dw_position;
	}

	public void setDw_position(DtoDwHrGeneralEmpleadoPosition dw_position) {
		this.dw_position = dw_position;
	}

	public String getStr_global_gv_userid() {
		return str_global_gv_userid;
	}

	public String getStr_hhrr_gv_usarpersonaant() {
		return str_hhrr_gv_usarpersonaant;
	}

	public void setStr_global_gv_userid(String str_global_gv_userid) {
		this.str_global_gv_userid = str_global_gv_userid;
	}

	public void setStr_hhrr_gv_usarpersonaant(String str_hhrr_gv_usarpersonaant) {
		this.str_hhrr_gv_usarpersonaant = str_hhrr_gv_usarpersonaant;
	}

	public ListDataModel<DtoDwPrEmpleadoSelect> getDw_1List() {
		return dw_1List;
	}

	public void setDw_1List(ListDataModel<DtoDwPrEmpleadoSelect> dw_1List) {
		this.dw_1List = dw_1List;
	}

	public DtoDwPrEmpleadoSelect getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(DtoDwPrEmpleadoSelect registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public String getPantallaReferencia() {
		return pantallaReferencia;
	}

	public void setPantallaReferencia(String pantallaReferencia) {
		this.pantallaReferencia = pantallaReferencia;
	}

	public String getIncluirNegativos() {
		return incluirNegativos;
	}

	public void setIncluirNegativos(String incluirNegativos) {
		this.incluirNegativos = incluirNegativos;
	}

}
