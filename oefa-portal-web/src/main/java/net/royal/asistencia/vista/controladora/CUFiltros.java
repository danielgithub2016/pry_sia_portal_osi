package net.royal.asistencia.vista.controladora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CComunGlobal;
import net.royal.erp.asistencia.dominio.dto.DtoFiltrosGenericos;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class CUFiltros extends CBaseBean implements UIMantenimientoController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipo;
	private String tablatitulo;
	private List<DtoFiltrosGenericos> lstFiltro;
	private List<DtoFiltrosGenericos> backup;
	private DtoFiltrosGenericos dw_filtro;
	private List<DtoFiltrosGenericos> registroSeleccionado;
	private DtoFiltrosGenericos objetoSeleccionado;
	private Integer cantRegistros;
	private Boolean isseleccionmultiple;
	private Boolean isselectorpuesto;

	private String conjunto;
	private String pantallaReferencia;

	@Override
	public String iniciarControladora() throws Exception {
		lstFiltro = null;
		isselectorpuesto = false;
		backup = new ArrayList<DtoFiltrosGenericos>();
		tablatitulo = " ";
		inicializarFiltrosListado();

		buscar();

		return getNombreVentanaEmergente();
	}

	public void obtenerCantidadSeleccionados() {

		cantRegistros = 0;
		for (DtoFiltrosGenericos obj : lstFiltro) {
			if (obj.getIsseleccionados()) {
				if (!UValidador.esListaVacia(backup)) {
					Integer cantbac = 0;
					for (DtoFiltrosGenericos bac : backup) {
						if (obj.getCodigo().equals(bac.getCodigo())) {
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
						DtoFiltrosGenericos bac = backup.get(i);
						if (obj.getCodigo().equals(bac.getCodigo())) {
							backup.remove(i);
							i--;
						}
					}
				}
			}
		}

		cantRegistros = backup.size();
		getWebControlContext().actualizar("wascompaniaselect:tbcompania");
	}

	public static CUFiltros getInstance() {
		return UFaces.evaluateExpressionGet("#{cUFiltros}", CUFiltros.class);
	}

	public void onRowSelect(SelectEvent event) throws Exception {
		objetoSeleccionado = (DtoFiltrosGenericos) event.getObject();
		seleccionar();
	}

	// me quede aqui
	public String seleccionar() throws Exception {

		if (isseleccionmultiple) {
			registroSeleccionado = new ArrayList();
			for (DtoFiltrosGenericos obj : backup) {
				if (obj.getIsseleccionados()) {
					registroSeleccionado.add(obj);
				}
			}

			if (UValidador.esListaVacia(registroSeleccionado)) {
				setMessageError("Debe de seleccionar al menos un registro");
				return null;
			}
		}

		Map<String, Object> param = new HashMap<String, Object>();

		switch (tipo) {
		case "compania":

			param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
					"agregarCompania");
			param.put("compania", isseleccionmultiple ? registroSeleccionado
					: objetoSeleccionado);

			break;

		case "costos":

			param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
					"agregarCostos");
			param.put("costos", isseleccionmultiple ? registroSeleccionado
					: objetoSeleccionado);

			break;

		case "sucursal":

			param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
					"agregarSucursal");
			param.put("sucursal", isseleccionmultiple ? registroSeleccionado
					: objetoSeleccionado);

			break;

		case "categoria":

			param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
					"agregarCategoria");
			param.put("categoria", isseleccionmultiple ? registroSeleccionado
					: objetoSeleccionado);

			break;

		case "planilla":

			param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
					"agregarPlanilla");
			param.put("planilla", isseleccionmultiple ? registroSeleccionado
					: objetoSeleccionado);

			break;

		case "operaria":

			param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
					"agregarOperaria");
			param.put("operaria", isseleccionmultiple ? registroSeleccionado
					: objetoSeleccionado);

			break;

		case "inactivos":

			param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
					"agregarInactivos");
			param.put("inactivos", isseleccionmultiple ? registroSeleccionado
					: objetoSeleccionado);

			break;

		case "puestos":

			param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
					"agregarPuestos");
			param.put("puestos", isseleccionmultiple ? registroSeleccionado
					: objetoSeleccionado);

			break;
		default:
			break;
		}

		if (!UValidador.esNulo(nombreContenedorRefrescar))
			this.getWebControlContext().actualizar(nombreContenedorRefrescar);

		if (!UValidador.esNulo(getNombreVentanaEmergente())) {
		}

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);

		return this.getiMantenimientoReferencia().mensaje(mensajeGenerico);
	}


	@Override
	public String buscar() throws Exception {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();

		Boolean isadmin = getFacSeguridad()
				.getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
						getUsuarioActual().getAplicacionCodigo(),
						getUsuarioActual().getLoginUsuario().toUpperCase());

		// filtros de busqueda
		switch (tipo) {
		case "compania":

			parametros.add(new ParametroPersistenciaGenerico("p_admin",
					String.class, isadmin ? "S" : "N"));
			parametros.add(new ParametroPersistenciaGenerico("p_usuario",
					String.class, getUsuarioActual().getLoginUsuario()
							.toUpperCase()));

			if (UValidador.estaVacio(dw_filtro.getCodigodescripciontext())
					|| UValidador.esNulo(dw_filtro.getCodigodescripciontext())) {
				dw_filtro.setCodigodescripciontext("");
			}

			if (dw_filtro.getCodigodescripcionflag().equals("N")) {

				dw_filtro.setCodigodescripciontext("%"
						+ dw_filtro.getCodigodescripciontext().toUpperCase()
						+ "%");

				parametros.add(new ParametroPersistenciaGenerico("Descompania",
						String.class, dw_filtro.getCodigodescripciontext()));

				parametros.add(new ParametroPersistenciaGenerico("Ncompania",
						String.class, "DESCRIPTION"));

			} else {

				dw_filtro.setCodigodescripciontext(dw_filtro
						.getCodigodescripciontext() + "%");

				parametros.add(new ParametroPersistenciaGenerico("Codcompania",
						String.class, dw_filtro.getCodigodescripciontext()));

				parametros.add(new ParametroPersistenciaGenerico("Ccompania",
						String.class, "COMPANYOWNER"));

			}

			// Ordenando por valor del Codigodescripcionflag

			break;

		case "costos":

			if (UValidador.estaVacio(dw_filtro.getCodigodescripciontext())
					|| UValidador.esNulo(dw_filtro.getCodigodescripciontext())) {
				dw_filtro.setCodigodescripciontext("");

			}

			if (dw_filtro.getCodigodescripcionflag().equals("N")) {

				dw_filtro.setCodigodescripciontext("%"
						+ dw_filtro.getCodigodescripciontext().toUpperCase()
						+ "%");

				parametros.add(new ParametroPersistenciaGenerico("Descostos",
						String.class, dw_filtro.getCodigodescripciontext()));

				parametros.add(new ParametroPersistenciaGenerico("Ncostos",
						String.class, "LOCALNAME"));

			} else {
				dw_filtro.setCodigodescripciontext(dw_filtro
						.getCodigodescripciontext().toUpperCase() + "%");

				parametros.add(new ParametroPersistenciaGenerico("Codcostos",
						String.class, dw_filtro.getCodigodescripciontext()));

				parametros.add(new ParametroPersistenciaGenerico("Ccostos",
						String.class, "COSTCENTER"));

			}

			break;

		case "sucursal":

			parametros.add(new ParametroPersistenciaGenerico("p_admin",
					String.class, isadmin ? "S" : "N"));
			parametros.add(new ParametroPersistenciaGenerico("p_usuario",
					String.class, getUsuarioActual().getLoginUsuario()
							.toUpperCase()));

			if (UValidador.estaVacio(dw_filtro.getCodigodescripciontext())
					|| UValidador.esNulo(dw_filtro.getCodigodescripciontext())) {
				dw_filtro.setCodigodescripciontext("");

			}

			if (dw_filtro.getCodigodescripcionflag().equals("N")) {

				dw_filtro.setCodigodescripciontext("%"
						+ dw_filtro.getCodigodescripciontext().toUpperCase()
						+ "%");

				parametros.add(new ParametroPersistenciaGenerico("Desoficina",
						String.class, dw_filtro.getCodigodescripciontext()));

				parametros.add(new ParametroPersistenciaGenerico("Noficina",
						String.class, "DESCRIPCIONLOCAL"));

			} else {
				dw_filtro.setCodigodescripciontext(dw_filtro
						.getCodigodescripciontext().toUpperCase() + "%");

				parametros.add(new ParametroPersistenciaGenerico("Codoficina",
						String.class, dw_filtro.getCodigodescripciontext()));

				parametros.add(new ParametroPersistenciaGenerico("Coficina",
						String.class, "SUCURSAL"));

			}

			break;

		case "categoria":
			if (UValidador.estaVacio(dw_filtro.getCodigodescripciontext())
					|| UValidador.esNulo(dw_filtro.getCodigodescripciontext())) {
				dw_filtro.setCodigodescripciontext("");

			}

			if (dw_filtro.getCodigodescripcionflag().equals("N")) {

				dw_filtro.setCodigodescripciontext("%"
						+ dw_filtro.getCodigodescripciontext().toUpperCase()
						+ "%");

				parametros.add(new ParametroPersistenciaGenerico(
						"Descategoria", String.class, dw_filtro
								.getCodigodescripciontext()));
				parametros.add(new ParametroPersistenciaGenerico("Ncategoria",
						String.class, "DESCRIPCIONLOCAL"));

			} else {

				dw_filtro.setCodigodescripciontext(dw_filtro
						.getCodigodescripciontext().toUpperCase() + "%");

				parametros.add(new ParametroPersistenciaGenerico(
						"Codcategoria", String.class, dw_filtro
								.getCodigodescripciontext()));

				parametros.add(new ParametroPersistenciaGenerico("Ccategoria",
						String.class, "CARGO"));
			}

			break;
		case "planilla":

			if (UValidador.estaVacio(dw_filtro.getCodigodescripciontext())
					|| UValidador.esNulo(dw_filtro.getCodigodescripciontext())) {
				dw_filtro.setCodigodescripciontext("");
			}

			if (dw_filtro.getCodigodescripcionflag().equals("N")) {
				dw_filtro.setCodigodescripciontext("%"
						+ dw_filtro.getCodigodescripciontext().toUpperCase()
						+ "%");

				parametros.add(new ParametroPersistenciaGenerico("Desplanilla",
						String.class, dw_filtro.getCodigodescripciontext()));

				parametros.add(new ParametroPersistenciaGenerico("Nplanilla",
						String.class, "DESCRIPCION"));

			} else {
				dw_filtro.setCodigodescripciontext(dw_filtro
						.getCodigodescripciontext().toUpperCase() + "%");

				parametros.add(new ParametroPersistenciaGenerico("Codplanilla",
						String.class, dw_filtro.getCodigodescripciontext()));

				parametros.add(new ParametroPersistenciaGenerico("Cplanilla",
						String.class, "TIPOPLANILLA"));

			}
			break;
		case "operaria":

			parametros.add(new ParametroPersistenciaGenerico("p_administrador",
					String.class, isadmin ? "S" : "N"));
			parametros.add(new ParametroPersistenciaGenerico("p_usuario",
					String.class, getUsuarioActual().getLoginUsuario()
							.toUpperCase()));
			parametros.add(new ParametroPersistenciaGenerico("p_vendor",
					String.class, getUsuarioActual().getIdPersona()));

			if (UValidador.estaVacio(dw_filtro.getCodigodescripciontext())
					|| UValidador.esNulo(dw_filtro.getCodigodescripciontext())) {
				dw_filtro.setCodigodescripciontext("");

			}

			if (dw_filtro.getCodigodescripcionflag().equals("N")) {

				dw_filtro.setCodigodescripciontext("%"
						+ dw_filtro.getCodigodescripciontext().toUpperCase()
						+ "%");

				parametros.add(new ParametroPersistenciaGenerico("Desoperaria",
						String.class, dw_filtro.getCodigodescripciontext()));
				parametros.add(new ParametroPersistenciaGenerico("Noperaria",
						String.class, "NOMBRE"));

			} else {
				dw_filtro.setCodigodescripciontext(dw_filtro
						.getCodigodescripciontext().toUpperCase() + "%");

				parametros.add(new ParametroPersistenciaGenerico("Codoperaria",
						String.class, dw_filtro.getCodigodescripciontext()));

				parametros.add(new ParametroPersistenciaGenerico("Coperaria",
						String.class, "AREA"));

			}

			break;

		case "inactivos":

			if (UValidador.estaVacio(dw_filtro.getCodigodescripciontext())
					|| UValidador.esNulo(dw_filtro.getCodigodescripciontext())) {
				dw_filtro.setCodigodescripciontext("");

			}

			String dato7 = dw_filtro.getCodigodescripciontext();
			String[] obj7 = new String[dato7.length()];
			for (int i = 0; i < dato7.length(); i++) {
				obj7[i] = dato7.substring(i, i + 1);
				if (obj7[i].equals("'")) {
					dw_filtro.setCodigodescripciontext("");
				}
			}

			if (dw_filtro.getCodigodescripcionflag().equals("N")) {

				dw_filtro.setCodigodescripciontext(dw_filtro
						.getCodigodescripciontext().toUpperCase() + "%");

				parametros.add(new ParametroPersistenciaGenerico(
						"Desinactivos", String.class, dw_filtro
								.getCodigodescripciontext()));

				parametros.add(new ParametroPersistenciaGenerico("Ninactivos",
						String.class, "LOCALNAME"));

			} else {
				dw_filtro.setCodigodescripciontext(dw_filtro
						.getCodigodescripciontext().toUpperCase() + "%");

				parametros.add(new ParametroPersistenciaGenerico(
						"Codinactivos", String.class, dw_filtro
								.getCodigodescripciontext()));

				parametros.add(new ParametroPersistenciaGenerico("Cinactivos",
						String.class, "COSTCENTER"));

			}

			break;
		case "puestos":

			if (UValidador.estaVacio(dw_filtro.getCodigodescripciontext())
					|| UValidador.esNulo(dw_filtro.getCodigodescripciontext())) {
				dw_filtro.setCodigodescripciontext("");

			}

			if (dw_filtro.getCodigodescripcionflag().equals("N")) {

				dw_filtro.setCodigodescripciontext("%"
						+ dw_filtro.getCodigodescripciontext().toUpperCase()
						+ "%");
				parametros.add(new ParametroPersistenciaGenerico("Npuestos",
						String.class, "CODIGOPUESTO"));

				parametros.add(new ParametroPersistenciaGenerico("Despuestos",
						String.class, dw_filtro.getCodigodescripciontext()));
			} else {

				dw_filtro.setCodigodescripciontext(dw_filtro
						.getCodigodescripciontext().toUpperCase() + "%");

				parametros.add(new ParametroPersistenciaGenerico("Cpuestos",
						String.class, "CODIGOPUESTO"));

				parametros.add(new ParametroPersistenciaGenerico("Codpuestos",
						String.class, dw_filtro.getCodigodescripciontext()));
			}

			break;
		default:
			break;
		}

		lstFiltro = CComunGlobal.getInstance().getFacAsistencia().getAS()
				.getAscommonDatawindow().DwFiltrosGenericos(parametros, tipo);

		registroSeleccionado = new ArrayList<>();

		dw_filtro.setCodigodescripciontext(null);

		// MANTENER LA SELECCION

		// si ya hay filtros en la solcitud debemos matener seleccion
		// al abrir el selector
		if (!UValidador.estaVacio(conjunto)) {
			String[] lista = conjunto.split(",");
			if (!UValidador.esNulo(lista)) {
				for (String id : lista) {
					DtoFiltrosGenericos bac = new DtoFiltrosGenericos();
					bac.setCodigo(id);
					bac.setIsseleccionados(true);
					backup.add(bac);
				}
			}

		}

		for (DtoFiltrosGenericos obje : lstFiltro) {
			for (DtoFiltrosGenericos bac : backup) {
				if (obje.getCodigo().equalsIgnoreCase(bac.getCodigo())) {
					bac.setDescripcion(obje.getDescripcion());
					obje.setIsseleccionados(true);
				}
			}
		}

		conjunto = null;

		return null;
	}

	public void filtrosBusqueda() {

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
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico)
			throws Exception {

		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		// La variable lstFiltro llama al servicio DwFiltrosGenericos(tipo)
		// cuyo parametro de entrada es el tipo el cual ya ha sido llenado desde
		// la pagina

		if (UValidador.esNulo(isseleccionmultiple)) {
			isseleccionmultiple = false;
		}

		LOGGER.debug("INICIANDO FILTROS");
		dw_filtro = new DtoFiltrosGenericos();

		dw_filtro.setCodigodescripcionflag("N");

		switch (tipo) {
		case "compania":

			this.setPantallaTituloReferente("Seleccione una Entidad");
			tablatitulo = "Entidad";

			break;

		case "costos":

			this.setPantallaTituloReferente("Seleccione un Centro de Costo");
			tablatitulo = "Centro Costo";

			break;

		case "sucursal":
			this.setPantallaTituloReferente("Seleccione una Sucursal");
			tablatitulo = "Sucursal";

			break;

		case "categoria":

			this.setPantallaTituloReferente("Seleccione una Categoría");
			tablatitulo = "Categoría";

			break;

		case "planilla":

			this.setPantallaTituloReferente("Seleccione un Tipo de Planilla");
			tablatitulo = "Tipo de Planilla";

			break;

		case "operaria":

			this.setPantallaTituloReferente("Seleccione una Área Operativa");
			tablatitulo = "Área Operativa";

			break;

		case "inactivos":

			this.setPantallaTituloReferente("Seleccione un C.C. Inactivos");
			tablatitulo = "C.C. Inactivos";

			break;

		case "puestos":

			this.setPantallaTituloReferente("Seleccione un Puesto");
			tablatitulo = "Puestos";
			isselectorpuesto = true;

			break;
		default:
			break;
		}

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		return null;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the lstFiltro
	 */
	public List<DtoFiltrosGenericos> getLstFiltro() {
		return lstFiltro;
	}

	/**
	 * @param lstFiltro
	 *            the lstFiltro to set
	 */
	public void setLstFiltro(List<DtoFiltrosGenericos> lstFiltro) {
		this.lstFiltro = lstFiltro;
	}

	/**
	 * @return the registroSeleccionado
	 */
	public List<DtoFiltrosGenericos> getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	/**
	 * @param registroSeleccionado
	 *            the registroSeleccionado to set
	 */
	public void setRegistroSeleccionado(
			List<DtoFiltrosGenericos> registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public String getTablatitulo() {
		return tablatitulo;
	}

	public void setTablatitulo(String tablatitulo) {
		this.tablatitulo = tablatitulo;
	}

	public DtoFiltrosGenericos getDw_filtro() {
		return dw_filtro;
	}

	public void setDw_filtro(DtoFiltrosGenericos dw_filtro) {
		this.dw_filtro = dw_filtro;
	}

	/**
	 * @return the backup
	 */
	public List<DtoFiltrosGenericos> getBackup() {
		return backup;
	}

	/**
	 * @param backup
	 *            the backup to set
	 */
	public void setBackup(List<DtoFiltrosGenericos> backup) {
		this.backup = backup;
	}
	
	public String getPantallaReferencia() {
		return pantallaReferencia;
	}

	public void setPantallaReferencia(String pantallaReferencia) {
		this.pantallaReferencia = pantallaReferencia;
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
	 * @return the isseleccionmultiple
	 */
	public Boolean getIsseleccionmultiple() {
		return isseleccionmultiple;
	}

	/**
	 * @param isseleccionmultiple
	 *            the isseleccionmultiple to set
	 */
	public void setIsseleccionmultiple(Boolean isseleccionmultiple) {
		this.isseleccionmultiple = isseleccionmultiple;
	}

	/**
	 * @return the objetoSeleccionado
	 */
	public DtoFiltrosGenericos getObjetoSeleccionado() {
		return objetoSeleccionado;
	}

	/**
	 * @param objetoSeleccionado
	 *            the objetoSeleccionado to set
	 */
	public void setObjetoSeleccionado(DtoFiltrosGenericos objetoSeleccionado) {
		this.objetoSeleccionado = objetoSeleccionado;
	}

	/**
	 * @return the isselectorpuesto
	 */
	public Boolean getIsselectorpuesto() {
		return isselectorpuesto;
	}

	/**
	 * @param isselectorpuesto
	 *            the isselectorpuesto to set
	 */
	public void setIsselectorpuesto(Boolean isselectorpuesto) {
		this.isselectorpuesto = isselectorpuesto;
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

}
