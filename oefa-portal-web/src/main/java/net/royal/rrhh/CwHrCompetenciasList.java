package net.royal.rrhh;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CComunSession;
import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.contabilidad.dominio.AcCostcentermstPk;
import net.royal.erp.core.dominio.Companyowner;
import net.royal.erp.core.dominio.CompanyownerPk;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.core.dominio.Personamast;
import net.royal.erp.core.dominio.PersonamastPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrCompetenciasList;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrCompetenciasList2;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrDocumentosSolicitadosPositionFot;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.desempenio.paginacion.PWHrCompetenciasList;

import org.apache.axiom.om.util.Base64;
import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class CwHrCompetenciasList extends CBaseBean implements
		UIMantenimientoController {
	private List<DtoDwHrCompetenciasList> dw_list;
	private List<DtoDwHrCompetenciasList2> dw_list_2;
	private ListDataModel<DtoDwHrCompetenciasList> dw_listdata;
	private DtoDwHrCompetenciasList registroSeleccionado;
	private DtoDwHrDocumentosSolicitadosPositionFot dw_position;
	private String iv_foto, iv_centrocostos, iv_compania,
			f_sql_read_parametrosmast_$, lv_path, urlimage;
	private BigDecimal iv_empleado;

	public static CwHrCompetenciasList getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrCompetenciasList}",
				CwHrCompetenciasList.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		dw_listdata = null;
		inicializarFiltrosListado();
		getWebControlContext().ejecutar("PF('popHrCompetencias').show();");
		getWebControlContext().actualizar("dgHrCompetencias");
		return null;
	}

	public void onRowSelect(SelectEvent event) throws Exception {
		LOGGER.debug("Entra a al onRowSelect");
		registroSeleccionado = (DtoDwHrCompetenciasList) event.getObject();
		listarSegundaTabla();
	}

	public void listarSegundaTabla() {
		LOGGER.debug("INICIANDO EL SEGUNDO LISTADO");

		String par_compania = registroSeleccionado.getCompanyowner();
		BigDecimal par_empleado = registroSeleccionado.getEmpleado();
		BigDecimal par_secuencia = registroSeleccionado.getSecuencia();
		Date par_fecha = registroSeleccionado.getFecha();

		String pattern = "yyyy/MM/dd HH:mm:ss";
		String Nuevafecha = new SimpleDateFormat(pattern).format(par_fecha);

		LOGGER.debug(Nuevafecha);
		LOGGER.debug(par_compania);
		LOGGER.debug(par_empleado);
		LOGGER.debug(par_secuencia);

		dw_list_2 = this
				.getFacRrhh()
				.getHr()
				.getHrothersDatawindow()
				.DwHrCompetenciasList2(par_compania, par_empleado,
						par_secuencia, Nuevafecha);

		LOGGER.debug(dw_list_2.size());

	}

	@Override
	public String buscar() throws Exception {
		// TODO Auto-generated method stub
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
		dw_list = new ArrayList<DtoDwHrCompetenciasList>();
		dw_list_2 = new ArrayList<DtoDwHrCompetenciasList2>();
		dw_position = new DtoDwHrDocumentosSolicitadosPositionFot();
		LOGGER.debug("Datos que se trae del mensajero");

		// ESTOS NO SON LOS DATOS REALES
		iv_centrocostos =getUsuarioActual().getCentroCostosCodigo();  
		iv_compania = getUsuarioActual().getCompaniaSocioCodigo();
		iv_empleado = new BigDecimal(302);
		iv_foto = null;

		// OBTENIENDO LA FOTO
		recuperarFoto(iv_empleado);
		LOGGER.debug(iv_foto);

		CompanyownerPk pk = new CompanyownerPk();
		pk.setCompanyowner(iv_compania);
		Companyowner objCompania = (Companyowner) this.getFacCore()
				.getCompanyownerServicio().obtenerPorId(pk);
		dw_position.setCompania(objCompania.getDescription());
		LOGGER.debug(dw_position.getCompania());

		PersonamastPk pk2 = new PersonamastPk();
		pk2.setPersona(iv_empleado.intValue());
		Personamast objPersona = (Personamast) this.getFacCore()
				.getPersonamastServicio().obtenerPorId(pk2);
		dw_position.setEmpleado(objPersona.getNombrecompleto());
		LOGGER.debug(dw_position.getEmpleado());

		String Cargo = this
				.getFacCore()
				.getEmpleadomastServicio()
				.obtenerNombreCargoEmpleado(iv_empleado.intValue(), iv_compania);
		dw_position.setPuesto(Cargo);
		LOGGER.debug(dw_position.getPuesto());

		AcCostcentermstPk pk4 = new AcCostcentermstPk();
		pk4.setCostcenter(iv_centrocostos);
		AcCostcentermst objcosto = (AcCostcentermst) this.getFacContabilidad()
				.getAcCostcentermstServicio().obtenerPorId(pk4);
		dw_position.setCentrocostos(objcosto.getLocalname().trim());
		LOGGER.debug(dw_position.getCentrocostos());

		String f_sql_get_usarpersonaant = this
				.getFacCore()
				.getParametrosmastServicio()
				.obtenerValorCadena(
						new ParametrosmastPk("HR", "999999", "PERSONAANT"));

		if (f_sql_get_usarpersonaant.equals("S")) {

			PersonamastPk pk5 = new PersonamastPk();
			pk5.setPersona(iv_empleado.intValue());

			Personamast objper = (Personamast) this.getFacCore()
					.getPersonamastServicio().obtenerPorId(pk5);

			dw_position.setEmpleadootro(objper.getPersonaant());

		} else {
			dw_position.setEmpleadootro(String.valueOf(iv_empleado));
		}

		LOGGER.debug("INICIANDO EL PRIMER LISTADO");

		dw_list = this.getFacRrhh().getHr().getHrothersDatawindow()
				.DwHrCompetenciasList(iv_compania, iv_empleado);
		LOGGER.debug(dw_list.size());

		dw_listdata = new PWHrCompetenciasList(dw_list);

		return null;
	}

	private void recuperarFoto(BigDecimal empleado) {
		Empleadomast e = (Empleadomast) this.getFacCore()
				.getEmpleadomastServicio()
				.obtenerEmpleadoMast(iv_empleado.intValue());
		if (!UValidador.esNulo(e)) {
			if (!UValidador.esNulo(e.getFotografia()))
				iv_foto = Base64.encode(e.getFotografia());
		}
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public DtoDwHrDocumentosSolicitadosPositionFot getDw_position() {
		return dw_position;
	}

	public void setDw_position(
			DtoDwHrDocumentosSolicitadosPositionFot dw_position) {
		this.dw_position = dw_position;
	}

	public String getIv_foto() {
		return iv_foto;
	}

	public String getIv_centrocostos() {
		return iv_centrocostos;
	}

	public String getIv_compania() {
		return iv_compania;
	}

	public void setIv_foto(String iv_foto) {
		this.iv_foto = iv_foto;
	}

	public void setIv_centrocostos(String iv_centrocostos) {
		this.iv_centrocostos = iv_centrocostos;
	}

	public void setIv_compania(String iv_compania) {
		this.iv_compania = iv_compania;
	}

	public List<DtoDwHrCompetenciasList2> getDw_list_2() {
		return dw_list_2;
	}

	public void setDw_list_2(List<DtoDwHrCompetenciasList2> dw_list_2) {
		this.dw_list_2 = dw_list_2;
	}

	public String getF_sql_read_parametrosmast_$() {
		return f_sql_read_parametrosmast_$;
	}

	public String getLv_path() {
		return lv_path;
	}

	public String getUrlimage() {
		return urlimage;
	}

	public void setF_sql_read_parametrosmast_$(
			String f_sql_read_parametrosmast_$) {
		this.f_sql_read_parametrosmast_$ = f_sql_read_parametrosmast_$;
	}

	public void setLv_path(String lv_path) {
		this.lv_path = lv_path;
	}

	public void setUrlimage(String urlimage) {
		this.urlimage = urlimage;
	}

	public List<DtoDwHrCompetenciasList> getDw_list() {
		return dw_list;
	}

	public void setDw_list(List<DtoDwHrCompetenciasList> dw_list) {
		this.dw_list = dw_list;
	}

	public ListDataModel<DtoDwHrCompetenciasList> getDw_listdata() {
		return dw_listdata;
	}

	public void setDw_listdata(
			ListDataModel<DtoDwHrCompetenciasList> dw_listdata) {
		this.dw_listdata = dw_listdata;
	}

	public DtoDwHrCompetenciasList getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(
			DtoDwHrCompetenciasList registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public BigDecimal getIv_empleado() {
		return iv_empleado;
	}

	public void setIv_empleado(BigDecimal iv_empleado) {
		this.iv_empleado = iv_empleado;
	}

}
