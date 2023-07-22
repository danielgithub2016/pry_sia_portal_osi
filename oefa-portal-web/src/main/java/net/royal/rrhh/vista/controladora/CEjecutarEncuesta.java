package net.royal.rrhh.vista.controladora;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.asistencia.dominio.AsArea;
import net.royal.erp.asistencia.dominio.dto.DtoFiltrosGenericos;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrActividad;
import net.royal.erp.rrhh.dominio.HrActividadPk;
import net.royal.erp.rrhh.dominio.HrCapacitacion;
import net.royal.erp.rrhh.dominio.HrCapacitacionPk;
import net.royal.erp.rrhh.dominio.HrCargosmast;
import net.royal.erp.rrhh.dominio.HrEncuestasujeto;
import net.royal.erp.rrhh.dominio.HrEncuestasujetoPk;
import net.royal.erp.rrhh.dominio.HrGradoinstruccion;
import net.royal.erp.rrhh.dominio.dto.DtoHrEncuesta;
import net.royal.erp.rrhh.dominio.dto.DtoHrEncuestadetalle;
import net.royal.erp.rrhh.dominio.dto.DtoHrEncuestapreguntavalores;
import net.royal.erp.rrhh.dominio.dto.DtoTipoPlanilla;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CEjecutarEncuesta extends CBaseBean implements UIMantenimientoController {

	private DtoHrEncuesta encuesta;
	private List<DtoHrEncuestadetalle> detalle;
	private List<DtoHrEncuestapreguntavalores> valores;

	private List<DtoHrEncuestapreguntavalores> cabecera;
	private List<AsArea> lstAsArea;
	private Integer areaOperariva;

	private List<DtoTipoPlanilla> lstTipoPlanilla;
	private List<HrCargosmast> listarCargosmast;
	private List<HrGradoinstruccion> listarGradoInstruccion;

	private String tableOpen = "<table border>", tableClose = "</table>", rowOpen = "<tr>", rowClose = "</tr>",
			cellOpen = "<td>", cellClose = "</td>";

	private String edad, tipoplanilla, sexo, areanombre;
	private Integer tiemposevicio, area;
	private String errormen, gradoInstruccion, cargo;

	private List<String> areas;
	private String titulo2;

	public static CEjecutarEncuesta getInstance() {
		return UFaces.evaluateExpressionGet("#{cEjecutarEncuesta}", CEjecutarEncuesta.class);
	}

	public CEjecutarEncuesta() {
		this.PANTALLA_LISTADO = "encuesta_ejecucion";
	}

	@Override
	public String iniciarControladora() throws Exception {

		if (!validar()) {
			return CHrEncuesta.getInstance().iniciarControladora();
		}

		inicializarDatosMantenimiento();
		return this.PANTALLA_LISTADO;
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

		List<HrEncuestasujeto> sujeto = new ArrayList<HrEncuestasujeto>();

		for (DtoHrEncuestadetalle d : detalle) {
			HrEncuestasujetoPk pk = new HrEncuestasujetoPk();
			pk.setPregunta(d.getPregunta().intValue());
			pk.setSecuencia(d.getSecuencia().intValue());
			pk.setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());

			// CAMBIO: Secuencia de paginador
			pk.setSujeto(
					this.getFacRrhh().getHrEncuestasujetoServicio().obtenerNuevoSujeto(d.getSecuencia().intValue()));

			HrEncuestasujeto suj = new HrEncuestasujeto();
			suj.setPk(pk);
			suj.setValor(d.getValor() == null ? null : d.getValor().intValue());
			suj.setObservacion(d.getObservacion());
			suj.setTipoplanilla(tipoplanilla);
			suj.setSexo(sexo);
			suj.setTiempodetrabajo(tiemposevicio.toString());
			suj.setEdad(edad);
			suj.setEncuestado(this.getUsuarioActual().getIdPersona());

			suj.setDptoareaoperativa(areaOperariva);
			suj.setCategoria(cargo);
			suj.setGradoinstruccion(gradoInstruccion);

			sujeto.add(suj);
		}

		this.getFacRrhh().getHrEncuestasujetoServicio().registrarSujeto(encuesta, sujeto);

		this.setMessageSuccess("Gracias por completar la encuesta!");
		return salir();
	}

	@Override
	public String salir() throws Exception {
		CHrEncuesta.getInstance().iniciarControladora();
		return CHrEncuesta.getInstance().PANTALLA_LISTADO;
	}

	@Override
	public Boolean validar() throws Exception {
		Date fechaActual = new Date();
		if (encuesta.getFechainicio() == null) {
			return false;
		}
		if (encuesta.getFechafin() == null) {
			return false;
		}

		Date fechaInicio = UFechaHora.obtenerFechaHoraInicioDia(encuesta.getFechainicio());
		Date fechaFin = UFechaHora.obtenerFechaHoraFinDia(encuesta.getFechafin());

		if (fechaActual.before(fechaInicio)) {
			setMessageError("Estas fuera del rango de fechas indicadas");
			return false;
		}

		if (fechaActual.after(fechaFin)) {
			setMessageError("Estas fuera del rango de fechas indicadas");
			return false;
		}

		return true;
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
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {
		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarOperaria")) {

			DtoFiltrosGenericos obj = (DtoFiltrosGenericos) (mensajeControllerGenerico.getParametros().get("operaria"));

			area = Integer.parseInt(obj.getCodigo());
			areanombre = obj.getDescripcion();

		}
		return null;
	}

	public String limpiarArea() {
		area = null;
		areanombre = null;
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		edad = null;
		tipoplanilla = null;
		sexo = null;
		areanombre = null;
		tiemposevicio = null;
		area = null;
		cargo = null;
		areaOperariva = null;
		gradoInstruccion = null;

		lstTipoPlanilla = this.getFacRrhh().getHrEncuestaServicio().listaTipoPlanilla();

		if (!UValidador.estaVacio(encuesta.getActividad())) {
			HrActividadPk pkact = new HrActividadPk();
			pkact.setActividad(encuesta.getActividad());
			pkact.setCompanyowner(encuesta.getCompanyowner());

			HrActividad act = (HrActividad) this.getFacRrhh().getHrActividadServicio().obtenerPorId(pkact, false);
			if (!UValidador.esNulo(act))
				titulo2 = "Actividad: " + act.getNombre();

		} else if (!UValidador.estaVacio(encuesta.getCapacitacion())) {
			HrCapacitacionPk pkcapa = new HrCapacitacionPk();
			pkcapa.setCapacitacion(encuesta.getCapacitacion());
			pkcapa.setCompanyowner(encuesta.getCompanyowner());

			HrCapacitacion capa = (HrCapacitacion) this.getFacRrhh().getHrCapacitacionServicio().obtenerPorId(pkcapa,
					false);
			if (!UValidador.esNulo(capa))
				titulo2 = "Capacitación: " + capa.getCursodescripcion();
		}

		cabecera = new ArrayList<DtoHrEncuestapreguntavalores>();
		this.cargarDetalle();
		this.cargarValores();

		return null;

	}

	private void cargarDetalle() {
		LOGGER.debug(encuesta.getSecuencia());
		LOGGER.debug(encuesta.getTipoencuesta());
		detalle = this.getFacRrhh().getHrEncuestadetalleServicio().listarDetalle(encuesta.getSecuencia().intValue(),
				encuesta.getTipoencuesta());
		LOGGER.debug(detalle.size());
		areaOperariva = null;

		if (encuesta.getTipoencuesta().equals(ConstanteRrhh.ENCUESTA_TIPO_CLIMA)) {
			lstAsArea = getFacAsistencia().getAsAreaServicio().listaComboAreaServicio();
		} else {
			lstAsArea = getFacAsistencia().getAsAreaServicio().listaComboAreaServicio();
			for (AsArea obj : lstAsArea) {
				if (obj.getPk().getArea().equals(Integer.valueOf(this.getUsuarioActual().getAreaCodigo()))) {
					areaOperariva = obj.getPk().getArea();
				}
			}
		}

		listarCargosmast = this.getFacRrhh().getHrCargosmastServicio().ListarCargosmast();
		listarGradoInstruccion = this.getFacRrhh().getHrGradoinstruccionServicio().listarGradoInstruccion();

		areas = new ArrayList<String>();
		if (!UValidador.esListaVacia(detalle)) {
			for (DtoHrEncuestadetalle d : detalle) {
				if (!areas.contains(d.getAreadescripcion()))
					areas.add(d.getAreadescripcion());
			}
		}

	}

	private void cargarValores() {
		LOGGER.debug(encuesta.getSecuencia());
		LOGGER.debug(encuesta.getTipoencuesta());
		valores = this.getFacRrhh().getHrEncuestapreguntavaloresServicio()
				.listarValores(encuesta.getSecuencia().intValue(), encuesta.getTipoencuesta());

		for (DtoHrEncuestadetalle d : detalle) {
			List<DtoHrEncuestapreguntavalores> values = new ArrayList<DtoHrEncuestapreguntavalores>();
			for (DtoHrEncuestapreguntavalores v : valores) {
				if (v.getPregunta().compareTo(d.getPregunta()) == 0) {
					values.add(v);
				}
				d.setValores(values);
				cabecera = values;
			}
		}

		LOGGER.debug(valores.size());
	}

	public DtoHrEncuesta getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(DtoHrEncuesta encuesta) {
		this.encuesta = encuesta;
	}

	public List<DtoHrEncuestadetalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DtoHrEncuestadetalle> detalle) {
		this.detalle = detalle;
	}

	public List<DtoHrEncuestapreguntavalores> getValores() {
		return valores;
	}

	public void setValores(List<DtoHrEncuestapreguntavalores> valores) {
		this.valores = valores;
	}

	public String getTableOpen() {
		return tableOpen;
	}

	public void setTableOpen(String tableOpen) {
		this.tableOpen = tableOpen;
	}

	public String getTableClose() {
		return tableClose;
	}

	public void setTableClose(String tableClose) {
		this.tableClose = tableClose;
	}

	public String getRowOpen() {
		return rowOpen;
	}

	public void setRowOpen(String rowOpen) {
		this.rowOpen = rowOpen;
	}

	public String getRowClose() {
		return rowClose;
	}

	public void setRowClose(String rowClose) {
		this.rowClose = rowClose;
	}

	public String getCellOpen() {
		return cellOpen;
	}

	public void setCellOpen(String cellOpen) {
		this.cellOpen = cellOpen;
	}

	public String getCellClose() {
		return cellClose;
	}

	public void setCellClose(String cellClose) {
		this.cellClose = cellClose;
	}

	public List<DtoHrEncuestapreguntavalores> getCabecera() {
		return cabecera;
	}

	public void setCabecera(List<DtoHrEncuestapreguntavalores> cabecera) {
		this.cabecera = cabecera;
	}

	public List<DtoTipoPlanilla> getLstTipoPlanilla() {
		return lstTipoPlanilla;
	}

	public void setLstTipoPlanilla(List<DtoTipoPlanilla> lstTipoPlanilla) {
		this.lstTipoPlanilla = lstTipoPlanilla;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getTiemposevicio() {
		return tiemposevicio;
	}

	public void setTiemposevicio(Integer tiemposevicio) {
		this.tiemposevicio = tiemposevicio;
	}

	public String getAreanombre() {
		return areanombre;
	}

	public void setAreanombre(String areanombre) {
		this.areanombre = areanombre;
	}

	public String getErrormen() {
		return errormen;
	}

	public void setErrormen(String errormen) {
		this.errormen = errormen;
	}

	/**
	 * @return the lstAsArea
	 */
	public List<AsArea> getLstAsArea() {
		return lstAsArea;
	}

	/**
	 * @param lstAsArea
	 *            the lstAsArea to set
	 */
	public void setLstAsArea(List<AsArea> lstAsArea) {
		this.lstAsArea = lstAsArea;
	}

	/**
	 * @return the areaOperariva
	 */
	public Integer getAreaOperariva() {
		return areaOperariva;
	}

	/**
	 * @param areaOperariva
	 *            the areaOperariva to set
	 */
	public void setAreaOperariva(Integer areaOperariva) {
		this.areaOperariva = areaOperariva;
	}

	/**
	 * @return the listarGradoInstruccion
	 */
	public List<HrGradoinstruccion> getListarGradoInstruccion() {
		return listarGradoInstruccion;
	}

	/**
	 * @param listarGradoInstruccion
	 *            the listarGradoInstruccion to set
	 */
	public void setListarGradoInstruccion(List<HrGradoinstruccion> listarGradoInstruccion) {
		this.listarGradoInstruccion = listarGradoInstruccion;
	}

	/**
	 * @return the gradoInstruccion
	 */
	public String getGradoInstruccion() {
		return gradoInstruccion;
	}

	/**
	 * @param gradoInstruccion
	 *            the gradoInstruccion to set
	 */
	public void setGradoInstruccion(String gradoInstruccion) {
		this.gradoInstruccion = gradoInstruccion;
	}

	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 *            the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the listarCargosmast
	 */
	public List<HrCargosmast> getListarCargosmast() {
		return listarCargosmast;
	}

	/**
	 * @param listarCargosmast
	 *            the listarCargosmast to set
	 */
	public void setListarCargosmast(List<HrCargosmast> listarCargosmast) {
		this.listarCargosmast = listarCargosmast;
	}

	/**
	 * @return the areas
	 */
	public List<String> getAreas() {
		return areas;
	}

	/**
	 * @param areas
	 *            the areas to set
	 */
	public void setAreas(List<String> areas) {
		this.areas = areas;
	}

	/**
	 * @return the titulo2
	 */
	public String getTitulo2() {
		return titulo2;
	}

	/**
	 * @param titulo2
	 *            the titulo2 to set
	 */
	public void setTitulo2(String titulo2) {
		this.titulo2 = titulo2;
	}

}
