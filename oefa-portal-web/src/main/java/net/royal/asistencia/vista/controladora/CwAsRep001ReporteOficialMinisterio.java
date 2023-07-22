package net.royal.asistencia.vista.controladora;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDddwAsConceptoaccesoSelectPre;
import net.royal.erp.asistencia.asoracle.dominio.dto.DtoDwAsEmpleadoSelectMultiple;
import net.royal.erp.asistencia.dominio.dto.DtoAsPeriodo;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001Empleado;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001ReporteOficialMinisterio;
import net.royal.erp.asistencia.dominio.dto.DtoFiltrosGenericos;
import net.royal.erp.core.dominio.Companiamast;
import net.royal.erp.core.dominio.CompaniamastPk;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CwAsRep001ReporteOficialMinisterio extends CBaseBean implements UIMantenimientoController {
	private DtoFiltrosGenericos datosgenerico;
	private String tipo;
	private boolean verSeleccionados;
	private List<DtoDddwAsConceptoaccesoSelectPre> dw_conceptoaccesofiltro;
	private DtoFiltrosGenericos registroSeleccionadoExterno;
	private List<DtoDwAsRep001Empleado> listaCabecera;
	private StreamedContent reporte;
	private Companiamast compania;

	private List<DtoDwAsRep001ReporteOficialMinisterio> listaReporte;
	private List<DtoDwAsRep001ReporteOficialMinisterio> listaReporteCopia;

	private boolean versobretiempo;
	private boolean vertardanza;
	private boolean verfaltaporhora;
	private boolean verconceptofalta;

	public static CwAsRep001ReporteOficialMinisterio getInstance() {
		return UFaces.evaluateExpressionGet("#{cwAsRep001ReporteOficialMinisterio}",
				CwAsRep001ReporteOficialMinisterio.class);
	}

	public CwAsRep001ReporteOficialMinisterio() {
		this.PANTALLA_LISTADO = "w_as_rep_001_reporteoficialministerio";
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
				+ "recursos" + File.separator + File.separator + "reportes" + File.separator + "reporte_asistencia"
				+ File.separator + "w_as_rep_001_reporteoficialministerio.jasper");

		String rutaLogo = pathPrincipal + "/comun/recursos/imagenes/sistema/oefa-logo-header.png";

		parametrosReport.put("DETALLE", listaReporte);
		parametrosReport.put("fechadesde", datosgenerico.getFechadesde());
		parametrosReport.put("fechahasta", datosgenerico.getFechahasta());
		parametrosReport.put("usuario", this.getUsuarioActual().getCodigoUsuario());
		parametrosReport.put("ip", this.getUsuarioActual().getIpAddressLogin());
		parametrosReport.put("ambiente", "");
		parametrosReport.put("companianombre", compania.getDescripcioncorta());
		parametrosReport.put("companiaruc", compania.getDocumentofiscal());

		if (!UValidador.esNulo(datosgenerico.getConceptoacceso())) {
			if (datosgenerico.getConceptoacceso().equals("HE")) {
				verconceptofalta = false;
				verfaltaporhora = false;
				versobretiempo = true;
				vertardanza = false;
			} else if (datosgenerico.getConceptoacceso().equals("TA")) {
				verconceptofalta = false;
				verfaltaporhora = false;
				versobretiempo = false;
				vertardanza = true;
			} else if (datosgenerico.getConceptoacceso().equals("FH")) {
				verconceptofalta = false;
				verfaltaporhora = true;
				versobretiempo = false;
				vertardanza = false;
			} else if (datosgenerico.getConceptoacceso().equals("FA")) {
				verconceptofalta = true;
				verfaltaporhora = false;
				versobretiempo = false;
				vertardanza = false;
			}
		}
		parametrosReport.put("verconceptofalta", verconceptofalta);
		parametrosReport.put("verfaltaporhora", verfaltaporhora);
		parametrosReport.put("versobretiempo", versobretiempo);
		parametrosReport.put("vertardanza", vertardanza);
		parametrosReport.put("Logo", rutaLogo);

		nombreArchivoPDF = getFacAsistencia().getAsAutorizacionServicio()
				.ejecutarReporteComoPDFDesdeLista(archivo.getPath(), parametrosReport, listaCabecera);
		reporte = new DefaultStreamedContent(new ByteArrayInputStream(nombreArchivoPDF), "application/pdf");

		if (UValidador.esListaVacia(listaReporte)) {
			setMessageError("No existen registros que mostrar.");
			return null;
		}

		return null;
	}

	@Override
	public String buscar() throws Exception {

		LOGGER.debug("USUARIOS AUTORIZADOS - INICIO");
		getFacAsistencia().getAS().getAsmainFuncion()
				.FAsGeneraEmpleadosAutorizados(getUsuarioActual().getUniqueIdInteger(),
						getUsuarioActual().getLoginUsuario().toUpperCase(), getUsuarioActual().getIdPersona(),
						getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
								getUsuarioActual().getAplicacionCodigo(),
								getUsuarioActual().getLoginUsuario().toUpperCase()));
		LOGGER.debug("USUARIOS AUTORIZADOS - FIN");

		LOGGER.debug("ASISTENCIA - INICIO");
		listaReporte = this.getFacCore().getEmpleadomastServicio()
				.obtenerListaReporteAsistencia(this.getUsuarioActual(), datosgenerico);
		LOGGER.debug("ASISTENCIA - FIN");
		
		// Copiamos la consulta principal para no perder la informacion al
		// filtrar;
		listaReporteCopia = new ArrayList<>();
		listaReporteCopia.addAll(listaReporte);

		if (!UValidador.esListaVacia(listaReporte)) {
			LOGGER.debug("Lista reporte");
			LOGGER.debug(listaReporte.size());
		}

		// List<Integer> empleados = new ArrayList<Integer>();
		// for (DtoDwAsRep001ReporteOficialMinisterio e : listaReporte) {
		// if (!empleados.contains(e.getEmpleado())) {
		// empleados.add(e.getEmpleado());
		// }
		// }
		// LOGGER.debug("EMPLEADOS EN EL REPORTE : " + empleados.size());
		//
		// String efiltrado = "";
		//
		// for (Integer e : empleados) {
		// efiltrado = UValidador.estaVacio(efiltrado) ? efiltrado + e
		// : efiltrado + "," + e;
		// }

		// filtramos los que generan y no generan asistencia

		listaCabecera = new ArrayList<>();
		if (!UValidador.esListaVacia(listaReporte)) {
			LOGGER.debug("LISTAR CABECERA - INICIO");
			listaCabecera = this.getFacCore().getEmpleadomastServicio().listarEmpleadosReporteAsistencia(
					(UValidador.estaVacio(datosgenerico.getCodEmpleado()) ? "S" : "N"), datosgenerico.getCodEmpleado(),
					this.getUsuarioActual().getUniqueIdInteger(),
					this.getUsuarioActual().getLoginUsuario().toUpperCase(), datosgenerico.getCodCompania(),
					datosgenerico.getCodCentroCosto(), datosgenerico.getCodSucursal(), datosgenerico.getCodCategoria(),
					datosgenerico.getCodPlantilla(),
					(UValidador.estaVacio(datosgenerico.getCodAreaOperativa()) ? null
							: Integer.parseInt(datosgenerico.getCodAreaOperativa())),
					(UValidador.estaVacio(datosgenerico.getCodPuesto()) ? null
							: Integer.parseInt(datosgenerico.getCodPuesto())));
			LOGGER.debug("LISTAR CABECERA - FIN");

			if (!UValidador.esListaVacia(listaCabecera)) {
				for (int i = 0; i < listaCabecera.size(); i++) {
					if (!datosgenerico.isCesados()) {
						if ("2".equals(listaCabecera.get(i).getEstadoempleado())) {
							listaCabecera.remove(i);
							i--;
							continue;
						}
					}
					// if
					// (!empleados.contains(listaCabecera.get(i).getEmpleado().intValue()))
					// {
					// listaCabecera.remove(i);
					// i--;
					// }
				}
			}

			listaReporte = new ArrayList<DtoDwAsRep001ReporteOficialMinisterio>();

			// filtramos los que generan y no generan asistencia
			if (!UValidador.esListaVacia(listaCabecera)) {
				for (int i = 0; i < listaCabecera.size(); i++) {
					DtoDwAsRep001Empleado obj = listaCabecera.get(i);
					List<DtoAsPeriodo> listasinasistencia = getFacCore().getEmpleadomastServicio()
							.obtenerInasistencias(obj.getEmpleado().intValue());
					List<DtoDwAsRep001ReporteOficialMinisterio> datos = filtrarPorEmpleado(
							obj.getEmpleado().intValue());
					Integer cantemp = datos.size();
					Integer sinreg = 0;
					if (!UValidador.esListaVacia(listasinasistencia)) {
						for (DtoAsPeriodo ina : listasinasistencia) {
							for (int j = 0; j < datos.size(); j++) {
								DtoDwAsRep001ReporteOficialMinisterio dato = datos.get(j);
								if (!ina.getFechadesde().after(dato.getFecha())
										&& !ina.getFechahasta().before(dato.getFecha())) {
									if (!datosgenerico.isNogeneraasistencia()) {
										sinreg++;
										datos.remove(j);
										j--;
									} else {
										// cambiamos la descripcion
										dato.setConceptofaltadescripcion("No Genera Asistencia");
									}
								}
							}
						}
					}

					// si todos los registros del empleado no generar asistencia
					// borramos la cabecera para que no muestre vacio.
					if (sinreg.equals(cantemp)) {
						listaCabecera.remove(i);
						i--;
					}

					listaReporte.addAll(datos);
				}
			}

		}

		// Sortear :)
		Collections.sort(listaReporte, new Comparator<DtoDwAsRep001ReporteOficialMinisterio>() {
			@Override
			public int compare(DtoDwAsRep001ReporteOficialMinisterio a, DtoDwAsRep001ReporteOficialMinisterio b) {
				Date x = a.getFecha();
				Date y = b.getFecha();

				if (x.after(y))
					return 1;
				else if (x.before(y))
					return -1;
				else
					return 0;
			}
		});
		
		//borrar duplicados
//		if(!UValidador.esListaVacia(listaReporte)){
//			for(int i = 0; i<listaReporte.size(); i++){
//				DtoDwAsRep001ReporteOficialMinisterio obj = listaReporte.get(i);
//				if(i>0){
//					if(UFechaHora.convertirFechaCadena(obj.getFecha(),"DD/MM/YYYY").equals(UFechaHora.convertirFechaCadena(listaReporte.get(i-1).getFecha(),"DD/MM/YYYY"))){
//						listaReporte.get(i-1)
//					}
//				}
//			}
//		}

		LOGGER.debug("IMPRIMIR - INICIO");
		imprimir();
		LOGGER.debug("IMPRIMIR - FIN");

		return null;
	}

	private List<DtoDwAsRep001ReporteOficialMinisterio> filtrarPorEmpleado(Integer empleado) {
		// TODO Auto-generated method stub
		List<DtoDwAsRep001ReporteOficialMinisterio> resultado = new ArrayList<DtoDwAsRep001ReporteOficialMinisterio>();

		if (!UValidador.esListaVacia(listaReporteCopia)) {
			for (DtoDwAsRep001ReporteOficialMinisterio obj : listaReporteCopia) {
				if (obj.getEmpleado().equals(empleado)) {
					resultado.add(obj);
				}
			}
		}

		return resultado;
	}

	public String listarPopGenericos() throws Exception {
		LOGGER.debug("Entrando a listarPopGenericos");
		CUFiltros.getInstance().setTipo(tipo);
		return CUFiltros.getInstance().iniciarControladora();

	}

	public void limpiezaEmpleado() {

		verSeleccionados = true;
		datosgenerico.setEmpleado(null);
		datosgenerico.setCodEmpleado(null);
		datosgenerico.setNombreCompleto(null);
	}

	public void limpieza() {

		switch (tipo) {
		case "compania":

			datosgenerico.setCodCompania(" ");
			datosgenerico.setDesCompania(" ");

			break;
		case "costos":

			datosgenerico.setCodCentroCosto(" ");
			datosgenerico.setDesCentroCosto(" ");

			break;
		case "sucursal":

			datosgenerico.setCodSucursal(" ");
			datosgenerico.setDesSucursal(" ");

			break;
		case "categoria":

			datosgenerico.setCodCategoria(" ");
			datosgenerico.setDesCategoria(" ");

			break;
		case "planilla":

			datosgenerico.setCodPlantilla(" ");
			datosgenerico.setDesPlantilla(" ");

			break;
		case "operaria":

			datosgenerico.setCodAreaOperativa(" ");
			datosgenerico.setDesAreaOperativa(" ");

			break;
		case "inactivos":

			datosgenerico.setCodInactivos(" ");
			datosgenerico.setDesInactivos(" ");

			break;
		case "puestos":

			datosgenerico.setCodPuesto(" ");
			datosgenerico.setDesPuesto(" ");

			break;

		default:
			break;
		}

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
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {
		LOGGER.debug("Entrando al mensaje");
		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarCompania")) {

			registroSeleccionadoExterno = (DtoFiltrosGenericos) (mensajeControllerGenerico.getParametros()
					.get("compania"));

			datosgenerico.setCodCompania(registroSeleccionadoExterno.getCodigo());
			datosgenerico.setDesCompania(registroSeleccionadoExterno.getDescripcion());

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarCostos")) {

			registroSeleccionadoExterno = (DtoFiltrosGenericos) (mensajeControllerGenerico.getParametros()
					.get("costos"));

			datosgenerico.setCodCentroCosto(registroSeleccionadoExterno.getCodigo());
			datosgenerico.setDesCentroCosto(registroSeleccionadoExterno.getDescripcion());

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarSucursal")) {

			registroSeleccionadoExterno = (DtoFiltrosGenericos) (mensajeControllerGenerico.getParametros()
					.get("sucursal"));

			datosgenerico.setCodSucursal(registroSeleccionadoExterno.getCodigo());
			datosgenerico.setDesSucursal(registroSeleccionadoExterno.getDescripcion());
		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarCategoria")) {

			registroSeleccionadoExterno = (DtoFiltrosGenericos) (mensajeControllerGenerico.getParametros()
					.get("categoria"));

			datosgenerico.setCodCategoria(registroSeleccionadoExterno.getCodigo());
			datosgenerico.setDesCategoria(registroSeleccionadoExterno.getDescripcion());

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarPlanilla")) {

			registroSeleccionadoExterno = (DtoFiltrosGenericos) (mensajeControllerGenerico.getParametros()
					.get("planilla"));

			datosgenerico.setCodPlantilla(registroSeleccionadoExterno.getCodigo());
			datosgenerico.setDesPlantilla(registroSeleccionadoExterno.getDescripcion());

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarOperaria")) {

			registroSeleccionadoExterno = (DtoFiltrosGenericos) (mensajeControllerGenerico.getParametros()
					.get("operaria"));

			datosgenerico.setCodAreaOperativa(registroSeleccionadoExterno.getCodigo());
			datosgenerico.setDesAreaOperativa(registroSeleccionadoExterno.getDescripcion());

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarInactivos")) {

			registroSeleccionadoExterno = (DtoFiltrosGenericos) (mensajeControllerGenerico.getParametros()
					.get("inactivos"));

			datosgenerico.setCodInactivos(registroSeleccionadoExterno.getCodigo());
			datosgenerico.setDesInactivos(registroSeleccionadoExterno.getDescripcion());

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarPuestos")) {

			registroSeleccionadoExterno = (DtoFiltrosGenericos) (mensajeControllerGenerico.getParametros()
					.get("puestos"));

			datosgenerico.setCodPuesto(registroSeleccionadoExterno.getCodigo());
			datosgenerico.setDesPuesto(registroSeleccionadoExterno.getDescripcion());

		}

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
		datosgenerico = new DtoFiltrosGenericos();
		datosgenerico.setCodEmpleado(getUsuarioActual().getIdPersona().toString());
		datosgenerico.setNombreCompleto(getUsuarioActual().getNombreCompleto());
		verSeleccionados = true;

		datosgenerico.setFechadesde(UFechaHora.obtenerPrimerDiaMesFecha(new Date()));
		datosgenerico.setFechahasta(UFechaHora.obtenerUltimoDiaMesFecha(new Date()));

		datosgenerico.setFechadesde(UFechaHora
				.convertirCadenaFecha(UFechaHora.convertirFechaCadena(datosgenerico.getFechadesde()), "dd/MM/yyyy"));

		// Boolean isadmin =
		// getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
		// getUsuarioActual().getAplicacionCodigo(),
		// getUsuarioActual().getLoginUsuario().toUpperCase());

		// Date[] fechas =
		// this.getFacAsistencia().getAsPeriodoServicio().obtenerFechasActivas(isadmin
		// ? "S" : "N");
		//
		// if (!UValidador.esNulo(fechas)) {
		// datosgenerico.setFechadesde(fechas[0]);
		// datosgenerico.setFechahasta(fechas[1]);
		// }

		String comp = "";

		if (!UValidador.esNulo(this.getUsuarioActual().getCompaniaSocioCodigo())) {
			if (this.getUsuarioActual().getCompaniaSocioCodigo().length() > 6) {
				comp = this.getUsuarioActual().getCompaniaSocioCodigo().substring(0, 6);
			}
		}

		compania = (Companiamast) this.getFacCore().getCompaniamastServicio().obtenerPorId(new CompaniamastPk(comp));

		if (UValidador.esNulo(compania)) {
			compania = new Companiamast();
		}

		datosgenerico.setCodCompania(this.getUsuarioActual().getCompaniaSocioCodigo());
		datosgenerico.setDesCompania(compania.getDescripcioncorta());
		verconceptofalta = true;
		verfaltaporhora = true;
		versobretiempo = true;
		vertardanza = true;

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {

		return null;
	}

	public DtoFiltrosGenericos getDatosgenerico() {
		return datosgenerico;
	}

	public void setDatosgenerico(DtoFiltrosGenericos datosgenerico) {
		this.datosgenerico = datosgenerico;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isVerSeleccionados() {
		return verSeleccionados;
	}

	public void setVerSeleccionados(boolean verSeleccionados) {
		this.verSeleccionados = verSeleccionados;
	}

	public List<DtoDddwAsConceptoaccesoSelectPre> getDw_conceptoaccesofiltro() {
		return dw_conceptoaccesofiltro;
	}

	public void setDw_conceptoaccesofiltro(List<DtoDddwAsConceptoaccesoSelectPre> dw_conceptoaccesofiltro) {
		this.dw_conceptoaccesofiltro = dw_conceptoaccesofiltro;
	}

	public StreamedContent getReporte() throws IOException {
		return reporte;
	}

	public void setReporte(StreamedContent reporte) {
		this.reporte = reporte;
	}

}
