package net.royal.asistencia.vista.controladora;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.asistencia.asoracle.dominio.dto.DtoDwAsEmpleadoSelectMultiple;
import net.royal.erp.asistencia.dominio.dto.DtoAsTipodiamovimiento;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001MarcaEmpleado;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001MarcaNew;
import net.royal.erp.asistencia.dominio.dto.DtoFiltrosGenericos;
import net.royal.erp.core.dominio.Companiamast;
import net.royal.erp.core.dominio.Companyowner;
import net.royal.erp.core.dominio.Personamast;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CwAsRep001ReporteMarcaEmpleado extends CBaseBean implements UIMantenimientoController {

	private StreamedContent reporte;

	private DtoFiltrosGenericos datosgenerico;
	private List<DtoDwAsRep001MarcaEmpleado> prueba;
	private List<DtoDwAsRep001MarcaNew> listaCabecera;

	private String ruc;
	private Boolean verSeleccionados;
	private Boolean isadmin;

	public static CwAsRep001ReporteMarcaEmpleado getInstance() {
		return UFaces.evaluateExpressionGet("#{cwAsRep001ReporteMarcaEmpleado}", CwAsRep001ReporteMarcaEmpleado.class);
	}

	public CwAsRep001ReporteMarcaEmpleado() {
		this.PANTALLA_LISTADO = "w_as_rep_001_marcarempleado";
	}

	@Override
	public String iniciarControladora() throws Exception {
		inicializarFiltrosListado();
		buscar();
		return this.PANTALLA_LISTADO;
	}

	public String imprimir() throws Exception {

		String pathPrincipal;
		byte[] nombreArchivoPDF;
		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
				.getRealPath("/");

		Map<String, Object> parametrosReport = new HashMap<String, Object>();

		File archivo = new File(pathPrincipal + File.separator + "erp" + File.separator + "asistencia" + File.separator
				+ "recursos" + File.separator + File.separator + "reportes" + File.separator + "reporte_marca"
				+ File.separator + "w_as_rep_001_marcarempleado.jasper");

		String rutaLogo = pathPrincipal + "/comun/recursos/imagenes/sistema/oefa-logo-header.png";

		parametrosReport.put("DETALLE", prueba);
		parametrosReport.put("fechadesde", UFechaHora.obtenerFechaHoraInicioDia(datosgenerico.getFechadesde()));
		parametrosReport.put("fechahasta", UFechaHora.obtenerFechaHoraFinDia(datosgenerico.getFechahasta()));
		parametrosReport.put("companianombre", datosgenerico.getDesCompania());
		parametrosReport.put("companiaruc", ruc);
		parametrosReport.put("p_sid", getUsuarioActual().getUniqueIdInteger());
		parametrosReport.put("Logo", rutaLogo);

		String queryemp1 = " (ca.empleado = " + getUsuarioActual().getIdPersona() + " OR " + (isadmin ? "'S'" : "'N'")
				+ " = 'S') AND ";
		String queryemp2 = " (de.empleado = " + getUsuarioActual().getIdPersona() + " OR " + (isadmin ? "'S'" : "'N'")
				+ " = 'S') AND ";
		if (!UValidador.estaVacio(datosgenerico.getCodEmpleado())) {
			queryemp1 = " ca.empleado in (" + datosgenerico.getCodEmpleado() + ") AND ";
			queryemp2 = " de.empleado in (" + datosgenerico.getCodEmpleado() + ") AND ";
		}

		parametrosReport.put("p_queryempleado1", queryemp1);
		parametrosReport.put("p_queryempleado2", queryemp2);
		parametrosReport.put("p_fechainicio", UFechaHora.obtenerFechaHoraInicioDia(datosgenerico.getFechadesde()));
		parametrosReport.put("p_fechafin", UFechaHora.obtenerFechaHoraFinDia(datosgenerico.getFechahasta()));
		parametrosReport.put("p_admin", isadmin ? "S" : "N");
		parametrosReport.put("p_usuario", getUsuarioActual().getCodigoUsuario());

		nombreArchivoPDF = getFacSeguridad().getPersonamastServicio().ejecutarReporteComoPDF(archivo.getPath(),
				parametrosReport);

		LOGGER.debug("FECHA DESDE::" + UFechaHora.obtenerFechaHoraInicioDia(datosgenerico.getFechadesde()));
		LOGGER.debug("FECHA HASTA::" + UFechaHora.obtenerFechaHoraFinDia(datosgenerico.getFechahasta()));

		LOGGER.debug(nombreArchivoPDF);

		reporte = new DefaultStreamedContent(new ByteArrayInputStream(nombreArchivoPDF), "application/pdf");

		LOGGER.debug(reporte);

		if (UValidador.esListaVacia(prueba)) {
			setMessageError("No existen registros que mostrar.");
			return null;
		}
		return null;
	}

	@Override
	public String buscar() throws Exception {

		getFacAsistencia().getAS().getAsmainFuncion()
				.FAsGeneraEmpleadosAutorizados(getUsuarioActual().getUniqueIdInteger(),
						getUsuarioActual().getLoginUsuario().toUpperCase(), getUsuarioActual().getIdPersona(),
						getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
								getUsuarioActual().getAplicacionCodigo(),
								getUsuarioActual().getLoginUsuario().toUpperCase()));

		isadmin = getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
				getUsuarioActual().getAplicacionCodigo(), getUsuarioActual().getLoginUsuario().toUpperCase());

		LOGGER.debug("inicio1");

		prueba = this.getFacAsistencia().getAsAccesosdiariosServicio().listarmarcacionXemplado(
				getUsuarioActual().getIdPersona(), datosgenerico.getCodEmpleado(), datosgenerico.getFechadesde(),
				datosgenerico.getFechahasta(), isadmin ? "S" : "N", getUsuarioActual().getUniqueIdInteger(),
				getUsuarioActual().getCodigoUsuario());

		LOGGER.debug("inicio2");

		// String descripcion = null;
		// Integer tipodia = null;
		// Date desde = null;
		// Date hasta = null;

		if (!UValidador.esListaVacia(prueba)) {

			for (DtoDwAsRep001MarcaEmpleado obj : prueba) {
				// descripcion = getFacAsistencia()
				// .getAS()
				// .getAsrepusFuncion()
				// .FSqlDevuelveHorarioReporteMarca(
				// obj.getEmpleado().intValue(),
				// UFechaHora.convertirCadenaFecha(UFechaHora
				// .convertirFechaCadena(obj.getFecha()),
				// "dd/MM/yyyy"));
				//
				// // tiene reprogramacion
				// if (UValidador.estaVacio(descripcion)) {
				// tipodia = getFacAsistencia()
				// .getAS()
				// .getAsrepusFuncion()
				// .FSqlDevuelveHorario(
				// obj.getEmpleado().intValue(),
				// UFechaHora.convertirCadenaFecha(UFechaHora
				// .convertirFechaCadena(obj
				// .getFecha()), "dd/MM/yyyy"));
				// List data2 = getFacAsistencia()
				// .getAsTipodiamovimientoServicio()
				// .obtenerMaxHoraInicioMaxHoraFin(tipodia);
				//
				// if (!UValidador.esListaVacia(data2)) {
				// desde = ((DtoAsTipodiamovimiento) data2.get(0))
				// .getHorainicio();
				// hasta = ((DtoAsTipodiamovimiento) data2.get(0))
				// .getHorafin();
				// }
				// String del = UFechaHora
				// .convertirFechaCadena(desde, "HH:mm");
				// String al = UFechaHora.convertirFechaCadena(hasta, "HH:mm");
				//
				// if (UValidador.estaVacio(del) && UValidador.estaVacio(al)) {
				// obj.setHora("Ninguno");
				// } else {
				// obj.setHora((UValidador.esNulo(del) ? " " : del)
				// + " - " + (UValidador.esNulo(al) ? " " : al));
				// }
				// } else {
				// obj.setHora(descripcion);
				// }
				obj.setDia(UFechaHora.obtenerDiaEnCadena(UFechaHora.obtenerNumeroDiaSemana(obj.getFecha())));
			}

		}

		LOGGER.debug("inicio3");

		imprimir();
		return null;
	}

	public void limpiezaEmpleado() {

		verSeleccionados = true;
		datosgenerico.setEmpleado(null);
		datosgenerico.setCodEmpleado(null);
		datosgenerico.setNombreCompleto(null);
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
		boolean validacion = true;

		if (datosgenerico.getFechadesde() == null || datosgenerico.getFechahasta() == null) {
			validacion = false;
		}

		return validacion;
	}

	public void limpiar() {
		datosgenerico.setFechadesde(null);
		datosgenerico.setFechahasta(null);
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
		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarEmpleado")) {

			List<DtoDwAsEmpleadoSelectMultiple> dtoEmpleado = (List<DtoDwAsEmpleadoSelectMultiple>) mensajeControllerGenerico
					.getParametros().get("empleado");

			if (dtoEmpleado.size() == 1) {
				datosgenerico.setCodEmpleado(dtoEmpleado.get(0).getPersona() + "");
				datosgenerico.setNombreCompleto(dtoEmpleado.get(0).getNombrecompleto());
				verSeleccionados = true;
			} else if (dtoEmpleado.size() > 1) {
				for (DtoDwAsEmpleadoSelectMultiple obj : dtoEmpleado) {
					if (UValidador.estaVacio(datosgenerico.getCodEmpleado())) {
						datosgenerico.setCodEmpleado(obj.getPersona().intValue() + "");
					} else {
						datosgenerico
								.setCodEmpleado(datosgenerico.getCodEmpleado() + "," + obj.getPersona().intValue());
					}
				}
				verSeleccionados = false;
			}
		}
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {

		isadmin = false;

		isadmin = getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
				getUsuarioActual().getAplicacionCodigo(), getUsuarioActual().getLoginUsuario().toUpperCase());

		verSeleccionados = true;
		prueba = new ArrayList<DtoDwAsRep001MarcaEmpleado>();
		datosgenerico = new DtoFiltrosGenericos();
		// Date[] fechas = this.getFacAsistencia().getAsPeriodoServicio()
		// .obtenerFechasActivas(isadmin ? "S" : "N");
		// datosgenerico.setFechadesde(fechas[0]);
		// datosgenerico.setFechahasta(fechas[1]);

		datosgenerico.setFechadesde(UFechaHora.obtenerPrimerDiaMesFecha(new Date()));
		datosgenerico.setFechahasta(UFechaHora.obtenerUltimoDiaMesFecha(new Date()));

		datosgenerico.setCodCompania(this.getUsuarioActual().getCompaniaSocioCodigo());
		datosgenerico.setDesCompania(getUsuarioActual().getCompaniaSocioNombre());

		datosgenerico.setCodCentroCosto(getUsuarioActual().getCentroCostosCodigo());
		datosgenerico.setDesCentroCosto(getUsuarioActual().getCentroCostosNombre());

		// obtenemos el ruc
		Companyowner companyow = new Companyowner();
		companyow.getPk().setCompanyowner(getUsuarioActual().getCompaniaSocioCodigo());
		companyow = (Companyowner) getFacCore().getCompanyownerServicio().obtenerPorId(companyow.getPk());

		if (!UValidador.esNulo(companyow)) {
			Companiamast company = new Companiamast();
			company.getPk().setCompaniacodigo(companyow.getCompany());
			company = (Companiamast) getFacCore().getCompaniamastServicio().obtenerPorId(company.getPk());
			if (!UValidador.esNulo(company)) {
				ruc = company.getDocumentofiscal();
			}
		}

		// seteamos el empleado logueado por defecto

		Personamast persona = new Personamast();
		persona.getPk().setPersona(getUsuarioActual().getIdPersona());

		persona = (Personamast) getFacCore().getPersonamastServicio().obtenerPorId(persona.getPk());

		datosgenerico.setCodEmpleado(getUsuarioActual().getIdPersona().toString());
		if (!UValidador.esNulo(persona)) {
			datosgenerico.setNombreCompleto(persona.getNombrecompleto());
		}

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		return null;
	}

	public StreamedContent getReporte() {
		return reporte;
	}

	public void setReporte(StreamedContent reporte) {
		this.reporte = reporte;
	}

	public List<DtoDwAsRep001MarcaEmpleado> getPrueba() {
		return prueba;
	}

	public void setPrueba(List<DtoDwAsRep001MarcaEmpleado> prueba) {
		this.prueba = prueba;
	}

	public DtoFiltrosGenericos getDatosgenerico() {
		return datosgenerico;
	}

	public void setDatosgenerico(DtoFiltrosGenericos datosgenerico) {
		this.datosgenerico = datosgenerico;
	}

	public List<DtoDwAsRep001MarcaNew> getListaCabecera() {
		return listaCabecera;
	}

	public void setListaCabecera(List<DtoDwAsRep001MarcaNew> listaCabecera) {
		this.listaCabecera = listaCabecera;
	}

	/**
	 * @return the verSeleccionados
	 */
	public Boolean getVerSeleccionados() {
		return verSeleccionados;
	}

	/**
	 * @param verSeleccionados
	 *            the verSeleccionados to set
	 */
	public void setVerSeleccionados(Boolean verSeleccionados) {
		this.verSeleccionados = verSeleccionados;
	}

}
