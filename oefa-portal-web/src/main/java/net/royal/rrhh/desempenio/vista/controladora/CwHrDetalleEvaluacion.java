package net.royal.rrhh.desempenio.vista.controladora;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.comun.vista.controladora.CBindingController;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrFactorvalor;
import net.royal.erp.rrhh.dominio.dto.DtoHrDetalleEvaluacion;
import net.royal.erp.rrhh.dominio.dto.DtoHrDetalleEvaluacionGrafico;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.sf.jasperreports.engine.JRException;

/**
 * 
 * @author Jose Torres
 * @codigoapliacion HR
 * @libreria hroracle.pbl
 * @windows w_hr_evaluacionempleado_edit
 */
@ManagedBean
@SessionScoped
@SuppressWarnings({ "unchecked", "serial", "unused" })
public class CwHrDetalleEvaluacion extends CwHrEvaluacionempleadoEditMaestra
		implements UIMantenimientoController {

	private BigDecimal cantCalificacion, cantCalificacionGrafico,
			cantCalificacionReporte;
	private List<DtoHrDetalleEvaluacionGrafico> dwGrafico;
	private DtoHrDetalleEvaluacion registroSeleccionado;
	private StrPass strpass;
	private Date fechaingreso;
	private String ivCompania, nivel, descripcionEvaluacion, ivCentroCosto,
			nivelGrafico, nivelReporte;
	private Integer ivEmpleado, ivEmpleadoevaluador, ivSecuencia,
			cantEvaluaciones;

	private Empleadomast e;

	@Override
	public String iniciarControladora() throws Exception {
		
		buscar();
		e = new Empleadomast();
		return null;
	}

	public static CwHrDetalleEvaluacion getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrDetalleEvaluacion}",
				CwHrDetalleEvaluacion.class);
	}

	@Override
	public String buscar() throws Exception {
		ivCompania = strpass.getS()[2];
		ivEmpleado = strpass.getD()[1];
		ivEmpleadoevaluador = strpass.getD()[4];
		ivSecuencia = strpass.getD()[3];

		this.setDw1(getFacRrhh()
				.getHr()
				.getHrOracleDatawindows()
				.obtenerDetalleEvaluacion(ivCompania,
						new BigDecimal(ivSecuencia),
						new BigDecimal(ivEmpleado),
						new BigDecimal(ivEmpleadoevaluador)));

		for (DtoHrDetalleEvaluacion dtotemp : this.getDw1()) {
			dtotemp.setDetalle(new ArrayList<DtoHrDetalleEvaluacion>());
			dtotemp.getDetalle().add(dtotemp);
		}

		List<DtoHrDetalleEvaluacionGrafico> dwGraficoDetalle = getFacRrhh()
				.getHr()
				.getHrOracleDatawindows()
				.obtenerCantEvaluacionGrafico(ivCompania,
						new BigDecimal(ivSecuencia),
						new BigDecimal(ivEmpleado),
						new BigDecimal(ivEmpleadoevaluador));

		dwGrafico = getFacRrhh()
				.getHr()
				.getHrOracleDatawindows()
				.obtenerEvaluacionGraficoCabezera(ivCompania,
						new BigDecimal(ivSecuencia),
						new BigDecimal(ivEmpleado),
						new BigDecimal(ivEmpleadoevaluador));

		for (DtoHrDetalleEvaluacionGrafico dtoGraficocabezera : dwGrafico) {
			for (DtoHrDetalleEvaluacionGrafico dtoGraficoDetalle : dwGraficoDetalle) {
				if (dtoGraficocabezera.getArea().trim()
						.equals(dtoGraficoDetalle.getArea().trim())) {

					if (UValidador.esNulo(dtoGraficocabezera
							.getDetallegrafico())) {
						dtoGraficocabezera
								.setDetallegrafico(new ArrayList<DtoHrDetalleEvaluacionGrafico>());
						dtoGraficocabezera.getDetallegrafico().add(
								dtoGraficoDetalle);
					} else {
						dtoGraficocabezera.getDetallegrafico().add(
								dtoGraficoDetalle);
					}

					BigDecimal valor = dtoGraficoDetalle.getValorrequerido();
					BigDecimal total = new BigDecimal(100);
					total = total.divide(valor,
							ConstanteRrhh.TAMANO_DECIMAL_SEIS,
							RoundingMode.HALF_UP);
					if (!UValidador.esNulo(dtoGraficoDetalle.getCalificacion())) {
						total = total.multiply(dtoGraficoDetalle
								.getCalificacion());
					} else {
						total = null;
					}

					dtoGraficoDetalle.setCalificacioncolor(total);
					
					LOGGER.debug("CALIFICACION COLOR::"
							+ dtoGraficoDetalle.getCalificacioncolor());
					
					
					LOGGER.debug("CALCULAR PROMEDIO CAT");
					
					total = new BigDecimal(100);
					BigDecimal promedioCat = this
							.getFacRrhh()
							.getHrFactoresevaluacionServicio()
							.obtenerPromedioCategoriaDesempeno(
									dtoGraficoDetalle.getFactor().intValue(),
									ivEmpleado, ivCompania, ivSecuencia);
					
					dtoGraficoDetalle.setPromediocategoria(promedioCat);
					total = total.divide(valor,
							ConstanteRrhh.TAMANO_DECIMAL_SEIS,
							RoundingMode.HALF_UP);
					
					if (!UValidador.esNulo(promedioCat)) {
						total = total.multiply(promedioCat);
					} else {
						total = null;
					}
					dtoGraficoDetalle.setPromediocategoriacolor(total);
					
					LOGGER.debug("PROMEDIO CAT "+total);
				}
			}
		}

		LOGGER.debug(dwGrafico);

		obtenerCantEvaluaciones();
		obtenerCalificacion();
		obtenerCalificacionGrafico();


		return null;
	}

	public void llenarGrillas() {
		cantEvaluaciones = 0;
		for (DtoHrDetalleEvaluacion dtotemp : this.getDw1()) {
			dtotemp.setDetalle(new ArrayList<DtoHrDetalleEvaluacion>());
			dtotemp.getDetalle().add(dtotemp);
			cantEvaluaciones++;
		}

		/*
		 * obtener solo las cabezeras
		 */
		List<DtoHrDetalleEvaluacionGrafico> dtoGraficocabezera = new ArrayList<DtoHrDetalleEvaluacionGrafico>();
		List<DtoHrDetalleEvaluacionGrafico> dtoGraficoDetalle = new ArrayList<DtoHrDetalleEvaluacionGrafico>();
		int x = 0;
		boolean encontrado = false;
		for (DtoHrDetalleEvaluacionGrafico dtoGraficocabezera01 : dwGrafico) {
			if (x == 0) {
				dtoGraficocabezera.add(dtoGraficocabezera01);
			} else {
				LOGGER.debug("LISTA CABEZERA::"
						+ dtoGraficocabezera01.getArea());
				encontrado = false;
				for (DtoHrDetalleEvaluacionGrafico dtoGraficocabezerax : dtoGraficocabezera) {
					LOGGER.debug("LISTA DETALLE::"
							+ dtoGraficocabezerax.getArea());
					if (dtoGraficocabezerax.getArea().equals(
							dtoGraficocabezera01.getArea())) {
						encontrado = true;
					}
				}

				if (!encontrado) {
					dtoGraficocabezera.add(dtoGraficocabezera01);
				}
			}
			x++;
		}

		dtoGraficoDetalle.addAll(dwGrafico);
		dwGrafico.clear();
		dwGrafico.addAll(dtoGraficocabezera);

		LOGGER.debug("TAMAÑO:::" + dwGrafico.size());

		for (DtoHrDetalleEvaluacionGrafico dtoGraficocabezeraTemp : dwGrafico) {

			LOGGER.debug("dtoGraficocabezeraTemp:::"
					+ dtoGraficocabezeraTemp.getArea());
			LOGGER.debug("dtoGraficocabezeraTemp:::"
					+ dtoGraficocabezeraTemp.getDescripcion());
			LOGGER.debug("dtoGraficocabezeraTemp:::"
					+ dtoGraficocabezeraTemp.getDescripcion2());

			for (DtoHrDetalleEvaluacionGrafico dtoGraficoDetalleTemp : dtoGraficoDetalle) {
				if (dtoGraficocabezeraTemp.getArea().trim()
						.equals(dtoGraficoDetalleTemp.getArea().trim())) {

					LOGGER.debug("dtoGraficocabezeraTemp:::"
							+ dtoGraficocabezeraTemp.getArea());
					LOGGER.debug("dtoGraficoDetalleTemp:::"
							+ dtoGraficoDetalleTemp.getArea());

					if (UValidador.esNulo(dtoGraficocabezeraTemp
							.getDetallegrafico())) {
						LOGGER.debug("AGREGA NUEVO:::"
								+ dtoGraficoDetalleTemp.getDescripcion2());
						dtoGraficocabezeraTemp
								.setDetallegrafico(new ArrayList<DtoHrDetalleEvaluacionGrafico>());
						dtoGraficocabezeraTemp.getDetallegrafico().add(
								dtoGraficoDetalleTemp);

					} else {

						LOGGER.debug("ADICIONA OTRO:::"
								+ dtoGraficoDetalleTemp.getDescripcion2());
						dtoGraficocabezeraTemp.getDetallegrafico().add(
								dtoGraficoDetalleTemp);
					}

				}
			}
		}

		obtenerCalificacion();
		obtenerCalificacionGrafico();
	}

	public String obtenerPlantilla() throws Exception {
		CwHrEvaluacionempleadoEdit.getInstance().getOpciones()
				.setIv_eliminar(true);

		if (CwHrEvaluacionempleadoEdit.getInstance().getOpciones()
				.isP1_visible()) {
			String mensaje = CwHrEvaluacionempleadoEdit.getInstance()
					.wfCopyPlantilla();
			if (!UValidador.estaVacio(mensaje)) {
				setMessageError(mensaje);
				return null;
			}
		}
		CwHrEvaluacionempleadoEdit.getInstance().getOpciones()
				.setIv_eliminar(false);

		getWebControlContext().actualizar(
				"frmEvaluacionEmpleado:tvDatos:tblDetalle");
		getWebControlContext().actualizar(
				"frmEvaluacionEmpleado:tvDatos:tblGrafico");

		return null;
	}

	private void obtenerCantEvaluaciones() {
		cantEvaluaciones = getFacRrhh()
				.getHr()
				.getHrOracleDatawindows()
				.obtenerCantEvaluacion(ivCompania, new BigDecimal(ivSecuencia),
						new BigDecimal(ivEmpleado),
						new BigDecimal(ivEmpleadoevaluador)).intValue();
	}

	private void obtenerCalificacion() {
		Integer secuencia = 0;
		BigDecimal calificacion = new BigDecimal(0);

		for (DtoHrDetalleEvaluacion dtotemp : this.getDw1()) {
			if (!UValidador.esNulo(dtotemp.getCalificacion())) {
				calificacion = calificacion.add(dtotemp.getCalificacion());
			}
			secuencia++;
		}

		if (calificacion.compareTo(BigDecimal.ZERO) != 0) {
			cantCalificacion = calificacion.divide(new BigDecimal(secuencia),
					9, RoundingMode.HALF_UP);
			nivel = getFacRrhh().getHrEvaluacionesrangoServicio()
					.ObtenerEvaluacionesRango(cantCalificacion,
							cantCalificacion);

		} else {
			cantCalificacion = null;
			nivel = null;
		}
	}

	private void obtenerCalificacionGrafico() {
		Integer secuencia = 0;
		BigDecimal calificacion = new BigDecimal(0);
		cantCalificacionReporte = null;

		List<DtoHrDetalleEvaluacion> lstValores = getFacRrhh()
				.getHrDetalleevaluacionServicio().obtenerCantEvaluacionGrafico(
						ivCompania, ivSecuencia, ivEmpleado,
						ivEmpleadoevaluador);
		if (lstValores.size() > 0)
			fechaingreso = lstValores.get(0).getFechaingreso();

		for (DtoHrDetalleEvaluacion dtotemp : lstValores) {
			if (!UValidador.esNulo(dtotemp.getCalificacion())) {
				calificacion = calificacion.add(dtotemp.getCalificacion());
				secuencia++;
			}
		}

		if (calificacion.compareTo(BigDecimal.ZERO) != 0) {
			cantCalificacionGrafico = null;
			if (!UValidador.esNulo(calificacion)) {
				cantCalificacionGrafico = calificacion.divide(new BigDecimal(
						secuencia), 9, RoundingMode.HALF_UP);
			}

			cantCalificacionReporte = calificacion;
			nivelReporte = getFacRrhh().getHrEvaluacionesrangoServicio()
					.ObtenerEvaluacionesRango(cantCalificacionReporte,
							cantCalificacionReporte);

			nivelGrafico = getFacRrhh().getHrEvaluacionesrangoServicio()
					.ObtenerEvaluacionesRango(cantCalificacionGrafico,
							cantCalificacionGrafico);

		} else {
			cantCalificacionGrafico = null;
			nivelGrafico = null;
		}
	}

	/*
	 * wf_calificar
	 */
	public String verCalificacion() throws Exception {

		if (!CwHrEvaluacionempleadoEdit.getInstance().getIvAction()
				.equals("VER")) {

			if (!CwHrEvaluacionempleadoEdit.getInstance().getOpciones()
					.isIb_evaluar()) {
				return null;
			}
			StrPass ls_str_pass = new StrPass();
			ls_str_pass.getS()[1] = "1";
			ls_str_pass.getS()[2] = "calificacion";
			ls_str_pass.getS()[3] = ivCompania;
			ls_str_pass.getLo()[3] = ivEmpleado;
			ls_str_pass.getLo()[4] = ivSecuencia;
			ls_str_pass.getS()[9] = "FactorCompetencia";
			ls_str_pass.getS()[10] = "SecuenciaCompetencia";

			CwFactoresCompetenciaCalificar.getInstance()
					.setRegistroSeleccionadoExterno(
							new DtoHrDetalleEvaluacion());
			CwFactoresCompetenciaCalificar.getInstance()
					.setRegistroSeleccionadoExterno(registroSeleccionado);
			CwFactoresCompetenciaCalificar.getInstance().setLs_str_pass(
					ls_str_pass);
			CwFactoresCompetenciaCalificar.getInstance().setEventname("opened");
			CwFactoresCompetenciaCalificar.getInstance().iniciarControladora();
		} else {
			return null;
		}
		return null;
	}

	public String mostrarReporte() throws Exception {
		Map<String, Object> mapaReporte = new HashMap<String, Object>();

		String pathPrincipal = UAplicacion.getRealPath();
		try {
			obtenerCalificacionGrafico();
			String tiempoServicio = UFechaHora.obteneraniomesdias(fechaingreso,
					new Date());

			mapaReporte.put("areaOperativaEvaluado",
					getFacAsistencia().getAsAreaServicio()
							.obtenerAreaOperativa(ivEmpleado, ivCompania));
			mapaReporte
					.put("cargoEvaluado", getFacCore()
							.getEmpleadomastServicio()
							.obtenerNombreCargoEmpleado(ivEmpleado, ivCompania));
			mapaReporte.put(
					"cargoEvaluador",
					getFacCore().getEmpleadomastServicio()
							.obtenerNombreCargoEmpleado(ivEmpleadoevaluador,
									ivCompania));
			mapaReporte.put(
					"nombreEvaluado",
					getFacCore().getPersonamastServicio().obtenerNombrePersona(
							new BigDecimal(ivEmpleado)));
			mapaReporte.put(
					"nombreEvaluador",
					getFacCore().getPersonamastServicio().obtenerNombrePersona(
							new BigDecimal(ivEmpleadoevaluador)));
			mapaReporte.put("parEmpleado", new BigDecimal(ivEmpleado));
			mapaReporte
					.put("parEvaluador", new BigDecimal(ivEmpleadoevaluador));
			mapaReporte.put("parSecuencia", new BigDecimal(ivSecuencia));
			mapaReporte.put("nombreEvaluacion", descripcionEvaluacion);
			mapaReporte.put("resultadoEvaluacion", nivelGrafico);
			mapaReporte.put("par_tiempoServicio", tiempoServicio);
			mapaReporte.put("calificacion", cantCalificacionGrafico);

			File archivo = new File(pathPrincipal + File.separator + "erp"
					+ File.separator + "rrhh" + File.separator + File.separator
					+ "recursos" + File.separator + "reportes" + File.separator
					+ "dwHrEmpleadoPrint.jasper");

			String reporteArchivoPDF = getFacAsistencia()
					.getAsAutorizacionServicio().ejecutarReporteIReport(
							archivo.getPath(), mapaReporte);

			CBindingController.getInstance().setNombreArchivoTemporal(
					reporteArchivoPDF);
		} catch (JRException ex) {
			ex.printStackTrace();
		}

		return "pantallaReporteVistaExterna";

	}

	public String validarAntesImprimir() {
		Integer cant = getFacRrhh()
				.getHr()
				.getHrOracleDatawindows()
				.obtenerCantEvaluacion(ivCompania, new BigDecimal(ivSecuencia),
						new BigDecimal(ivEmpleado),
						new BigDecimal(ivEmpleadoevaluador)).intValue();

		if (cant > 0) {
			getWebControlContext()
					.ejecutar(
							"document.getElementById('frmEvaluacionEmpleado:tvDatos:detalle').click();");
		} else {
			setMessageError("No existen datos para mostrar este Reporte");
			return null;
		}
		return null;
	}

	public String mostrarReporteEva() throws Exception {
		Map<String, Object> mapaReporte = new HashMap<String, Object>();

		String pathPrincipal = UAplicacion.getRealPath();
		try {

			obtenerCalificacionGrafico();
			mapaReporte.put("evaluacion", descripcionEvaluacion);
			mapaReporte.put("centrocosto",
					getFacContabilidad().getAcCostcentermstServicio()
							.obtenerCentroCosto(ivCentroCosto));
			mapaReporte.put(
					"cargoestructural",
					getFacCore().getEmpleadomastServicio()
							.obtenerNombreCargoEmpleado(ivEmpleadoevaluador,
									ivCompania));
			mapaReporte.put("empleado", getFacCore().getPersonamastServicio()
					.obtenerNombrePersona(new BigDecimal(ivEmpleado)));
			mapaReporte.put("puesto", getFacCore().getEmpleadomastServicio()
					.obtenerNombreCargoEmpleado(ivEmpleado, ivCompania));

			mapaReporte.put("resultadoEvaluacion", nivelReporte);
			mapaReporte.put("numEvaluaciones", cantEvaluaciones);

			mapaReporte.put("parEmpleado", new BigDecimal(ivEmpleado));
			mapaReporte
					.put("parEvaluador", new BigDecimal(ivEmpleadoevaluador));
			mapaReporte.put("parSecuencia", new BigDecimal(ivSecuencia));
			mapaReporte.put("parCompany", ivCompania);
			mapaReporte.put("puntajeTotal", cantCalificacionReporte);

			File archivo = new File(pathPrincipal + File.separator + "erp"
					+ File.separator + "rrhh" + File.separator + File.separator
					+ "recursos" + File.separator + "reportes" + File.separator
					+ "ReporteEvaluacion" + File.separator
					+ "dwHrEvaluacionempleadoRep.jasper");

			String reporteArchivoPDF = getFacAsistencia()
					.getAsAutorizacionServicio().ejecutarReporteIReport(
							archivo.getPath(), mapaReporte);

			CBindingController.getInstance().setNombreArchivoTemporal(
					reporteArchivoPDF);
		} catch (JRException ex) {
			ex.printStackTrace();
		}

		return "pantallaReporteVistaExterna";

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

		if (mensajeControllerGenerico.getParametros()
				.get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("insertarCalificacion")) {

			BigDecimal valorRetorno = (BigDecimal) mensajeControllerGenerico
					.getParametros().get("valor");
			BigDecimal factorCompetenciaRetorno = (BigDecimal) mensajeControllerGenerico
					.getParametros().get("factorCompetencia");
			BigDecimal secuenciacompetenciaRetorno = (BigDecimal) mensajeControllerGenerico
					.getParametros().get("secuenciacompetencia");
			HrFactorvalor registroSeleccionadoFactor = (HrFactorvalor) mensajeControllerGenerico
					.getParametros().get("registroSeleccionado");

			/*
			 * inserto los valores en la tabla de calificaciones
			 */
			for (DtoHrDetalleEvaluacion objTemp : this.getDw1()) {
				// comparo por toda la PK
				if (objTemp.getCompanyowner().equals(
						registroSeleccionado.getCompanyowner())
						&& objTemp.getSecuenciaeval().intValue() == registroSeleccionado
								.getSecuenciaeval().intValue()
						&& objTemp.getEmpleado().intValue() == registroSeleccionado
								.getEmpleado().intValue()
						&& objTemp.getEmpleadoevaluador().intValue() == registroSeleccionado
								.getEmpleadoevaluador().intValue()
						&& objTemp.getSecuencia().intValue() == registroSeleccionado
								.getSecuencia().intValue()
						&& objTemp.getTipo().equals(
								registroSeleccionado.getTipo())) {

					objTemp.setCalificacion(valorRetorno);
					objTemp.setFactorcompetencia(factorCompetenciaRetorno);
					objTemp.setSecuenciacompetencia(secuenciacompetenciaRetorno);
					break;
				}
			}

			/*
			 * Inserto valores en el grafico
			 */
			for (DtoHrDetalleEvaluacionGrafico objGraficoTemp : dwGrafico) {
				if (objGraficoTemp.getArea().equals(
						registroSeleccionado.getArea())) {
					for (int r = 0; r < objGraficoTemp.getDetallegrafico()
							.size(); r++) {
						if (objGraficoTemp.getDetallegrafico().get(r)
								.getFactor().intValue() == registroSeleccionado
								.getFactor().intValue()) {

							BigDecimal valor = objGraficoTemp
									.getDetallegrafico().get(r)
									.getValorrequerido();
							BigDecimal total = new BigDecimal(100);
							total = total
									.divide(valor, 6, RoundingMode.HALF_UP);
							BigDecimal valorGrafico = total
									.multiply(valorRetorno);

							objGraficoTemp.getDetallegrafico().get(r)
									.setCalificacioncolor(valorGrafico);

							LOGGER.debug("CALIFICACION COLOR::"
									+ objGraficoTemp.getDetallegrafico().get(r)
											.getCalificacioncolor());

							objGraficoTemp
									.getDetallegrafico()
									.get(r)
									.setDesvalorregistrado(
											registroSeleccionadoFactor
													.getDescripcion());
							objGraficoTemp
									.getDetallegrafico()
									.get(r)
									.setCalificacion(
											registroSeleccionadoFactor
													.getValor());
						}
					}

				}
			}

			obtenerCalificacion();
			obtenerCalificacionGrafico();
		}
		getWebControlContext().actualizar(
				"frmEvaluacionEmpleado:tvDatos:tblGrafico");

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

	public BigDecimal getCantCalificacion() {
		return cantCalificacion;
	}

	public void setCantCalificacion(BigDecimal cantCalificacion) {
		this.cantCalificacion = cantCalificacion;
	}

	public List<DtoHrDetalleEvaluacionGrafico> getDwGrafico() {
		return dwGrafico;
	}

	public void setDwGrafico(List<DtoHrDetalleEvaluacionGrafico> dwGrafico) {
		this.dwGrafico = dwGrafico;
	}

	public StrPass getStrpass() {
		return strpass;
	}

	public void setStrpass(StrPass strpass) {
		this.strpass = strpass;
	}

	public DtoHrDetalleEvaluacion getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(
			DtoHrDetalleEvaluacion registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public Integer getCantEvaluaciones() {
		return cantEvaluaciones;
	}

	public void setCantEvaluaciones(Integer cantEvaluaciones) {
		this.cantEvaluaciones = cantEvaluaciones;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getDescripcionEvaluacion() {
		return descripcionEvaluacion;
	}

	public void setDescripcionEvaluacion(String descripcionEvaluacion) {
		this.descripcionEvaluacion = descripcionEvaluacion;
	}

	public String getIvCentroCosto() {
		return ivCentroCosto;
	}

	public void setIvCentroCosto(String ivCentroCosto) {
		this.ivCentroCosto = ivCentroCosto;
	}

	public BigDecimal getCantCalificacionGrafico() {
		return cantCalificacionGrafico;
	}

	public void setCantCalificacionGrafico(BigDecimal cantCalificacionGrafico) {
		this.cantCalificacionGrafico = cantCalificacionGrafico;
	}

	public String getNivelGrafico() {
		return nivelGrafico;
	}

	public void setNivelGrafico(String nivelGrafico) {
		this.nivelGrafico = nivelGrafico;
	}

	public BigDecimal getCantCalificacionReporte() {
		return cantCalificacionReporte;
	}

	public void setCantCalificacionReporte(BigDecimal cantCalificacionReporte) {
		this.cantCalificacionReporte = cantCalificacionReporte;
	}

	public String getNivelReporte() {
		return nivelReporte;
	}

	public void setNivelReporte(String nivelReporte) {
		this.nivelReporte = nivelReporte;
	}

}
