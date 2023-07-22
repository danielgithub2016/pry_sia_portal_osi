package net.royal.rrhh.candidatos.vista.controladora;

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

import org.primefaces.event.SelectEvent;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CBindingController;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrEvalrequerimiento;
import net.royal.erp.rrhh.dominio.HrEvalrequerimientoPk;
import net.royal.erp.rrhh.dominio.HrEvaluacion;
import net.royal.erp.rrhh.dominio.HrEvaluacionPk;
import net.royal.erp.rrhh.dominio.HrPosRequer;
import net.royal.erp.rrhh.dominio.HrPosRequerPk;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoList;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoevalentrevistaEditB;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoevalpostEdit2;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientopostEdit;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwRequerimientoevaletapasEdit;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.candidatos.vista.opciones.OwHrRequerimientoCandidatosEdit;

/**
 * 
 * @author nunezh
 * @codigoapliacion HR
 * @powerbuilder hrproc.pbl w_hr_requerimiento_edit
 */
@SessionScoped
@ManagedBean
public class CwHrRequerimientoCandidatosEdit extends CBaseBean implements UIMantenimientoController {

	private DtoDwHrRequerimientoList requerimiento;
	private List<DtoDwHrRequerimientopostEdit> dwpostulantes;
	private DtoDwHrRequerimientopostEdit dwpostulantesSeleccion;
	private List<DtoDwRequerimientoevaletapasEdit> dwevaluacionpostulanteetapa;
	private List<DtoDwHrRequerimientoevalentrevistaEditB> dwevaluacionpostulante;
	private List<DtoDwHrRequerimientoevalpostEdit2> dwevaluacionpostulante3;

	private accion_solicitada accionLista;
	private OwHrRequerimientoCandidatosEdit opciones;
	private String titulo;
	private boolean ibevaluar;
	private int ilsecuencia, ilsecuencia2;
	private List<Integer> ddlbresultados;
	private Integer etapaSeleccion;
	private String nombreArchivoPDF;
	
	public static CwHrRequerimientoCandidatosEdit getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrRequerimientoCandidatosEdit}",
				CwHrRequerimientoCandidatosEdit.class);
	}

	public CwHrRequerimientoCandidatosEdit() {
		this.PANTALLA_LISTADO = "evaluacion_candidatos_list";
		this.PANTALLA_MANTENIMIENTO = "evaluacion_candidatos_edit";
	}

	@Override
	public String iniciarControladora() throws Exception {
		LOGGER.debug("INICIAR CONTROLADORA - " + accionLista);
		this.inicializarFiltrosListado();
		String inicio = this.inicializarDatosMantenimiento();
		return inicio;
	}

	public String verInforme() throws Exception {
		
		LOGGER.debug("VER INFORME");
		String pathPrincipal;
		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext()).getRealPath("/");
		Map<String, Object> parametrosReport = new HashMap<String, Object>();
		
		
		LOGGER.debug("COMPANIA--->"+requerimiento.getCompanyowner());
		LOGGER.debug("REQUERIMIENTO--->"+dwpostulantesSeleccion.getRequerimiento());
		LOGGER.debug("POSTULANTE--->"+dwpostulantesSeleccion.getPostulante());
		LOGGER.debug("SECUENCIA--->"+dwpostulantesSeleccion.getSecuencia());
		LOGGER.debug("SECUENCIA2--->"+dwpostulantesSeleccion.getSecuencia2());
		
		parametrosReport.put("par_companyowner",requerimiento.getCompanyowner());
		parametrosReport.put("par_requerimiento",dwpostulantesSeleccion.getRequerimiento());
		parametrosReport.put("par_Postulante",dwpostulantesSeleccion.getPostulante());
		parametrosReport.put("par_Etapa",dwpostulantesSeleccion.getSecuencia());
		parametrosReport.put("par_Cargo",dwpostulantesSeleccion.getSecuencia2());
		File archivo = new File(pathPrincipal + File.separator + "erp"
				+ File.separator + "rrhh" + File.separator + File.separator
				+ "recursos" + File.separator + File.separator + "reportes"
				+ File.separator + File.separator + "EvaluacionCandidato"
				+ File.separator + File.separator + "VerInforme"
				+ File.separator + File.separator 
				+ "w_hr_requerimiento_rep01.jasper");
		
		nombreArchivoPDF = getFacPlanilla().getPrCtsServicio()
			.ejecutarReporteIReport(archivo.getPath(), parametrosReport);
		
		CBindingController.getInstance().setNombreArchivoTemporal(nombreArchivoPDF);
		
		return "pantallaReporteVistaExterna";
	}	
	
	public String imprimirFormato() throws Exception {
		
		LOGGER.debug("IMPRIMIR FORMATO");
			
		if(!validar()) {
			setMessageError("Debe seleccionar un Candidato");
			return null;
		}
	
		String pathPrincipal;
		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext()).getRealPath("/");
		Map<String, Object> parametrosReport = new HashMap<String, Object>();
			
		LOGGER.debug("REQUERIMIENTO--->"+dwpostulantesSeleccion.getRequerimiento());
		LOGGER.debug("POSTULANTE--->"+dwpostulantesSeleccion.getPostulante());
		LOGGER.debug("COMPANIA--->"+requerimiento.getCompanyowner());
		LOGGER.debug("SECUENCIA--->"+dwpostulantesSeleccion.getSecuencia());
				
		parametrosReport.put("requerimiento",dwpostulantesSeleccion.getRequerimiento());
		parametrosReport.put("postulante",dwpostulantesSeleccion.getPostulante());
		parametrosReport.put("compania",requerimiento.getCompanyowner());
		parametrosReport.put("secuencia",dwpostulantesSeleccion.getSecuencia());
		File archivo = new File(pathPrincipal + File.separator + "erp"
				+ File.separator + "rrhh" + File.separator + File.separator
				+ "recursos" + File.separator + File.separator + "reportes"
				+ File.separator + File.separator + "EvaluacionCandidato"
				+ File.separator + File.separator + "FormatoEvaluacion"
				+ File.separator + File.separator 
				+ "w_hr_ficha_evaluacion.jasper");
		
		nombreArchivoPDF = getFacPlanilla().getPrCtsServicio()
			.ejecutarReporteIReport(archivo.getPath(), parametrosReport);
		
		CBindingController.getInstance().setNombreArchivoTemporal(nombreArchivoPDF);
		
		return "pantallaReporteVistaExterna";
	}	
	
	public String verFinalistas() throws Exception {
		
		LOGGER.debug("VER FINALISTAS");
		String pathPrincipal;
		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext()).getRealPath("/");
		Map<String, Object> parametrosReport = new HashMap<String, Object>();
		

		LOGGER.debug("SECUENCIA--->"+dwpostulantesSeleccion.getSecuencia());
		LOGGER.debug("SECUENCIA2--->"+dwpostulantesSeleccion.getSecuencia2());
		LOGGER.debug("REQUERIMIENTO--->"+dwpostulantesSeleccion.getRequerimiento());
				
		parametrosReport.put("secuencia",dwpostulantesSeleccion.getSecuencia());
		parametrosReport.put("secuencia2",dwpostulantesSeleccion.getSecuencia2());
		parametrosReport.put("requerimiento",dwpostulantesSeleccion.getRequerimiento());
		File archivo = new File(pathPrincipal + File.separator + "erp"
				+ File.separator + "rrhh" + File.separator + File.separator
				+ "recursos" + File.separator + File.separator + "reportes"
				+ File.separator + File.separator + "EvaluacionCandidato"
				+ File.separator + File.separator + "Finalistas"
				+ File.separator + File.separator 
				+ "w_hr_presentacion_finalistas.jasper");
		
		nombreArchivoPDF = getFacPlanilla().getPrCtsServicio()
			.ejecutarReporteIReport(archivo.getPath(), parametrosReport);
		
		CBindingController.getInstance().setNombreArchivoTemporal(nombreArchivoPDF);
		
		return "pantallaReporteVistaExterna";
	}	
	
	public String verReporteIntegral() throws Exception {
		
		LOGGER.debug("VER REPORTE INTEGRAL");
		
		String pathPrincipal;
		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext()).getRealPath("/");
		Map<String, Object> parametrosReport = new HashMap<String, Object>();
		
		LOGGER.debug("REQUERIMIENTO--->"+dwpostulantesSeleccion.getRequerimiento());
		LOGGER.debug("POSTULANTE--->"+dwpostulantesSeleccion.getPostulante());
		LOGGER.debug("COMPANIA--->"+dwpostulantesSeleccion.getCompanyowner());
		LOGGER.debug("NOMBRECOMPANIA--->"+requerimiento.getDescription());
		LOGGER.debug("NOMBREPOSTULANTE--->"+dwpostulantesSeleccion.getNombre());	
		LOGGER.debug("PUESTO--->"+requerimiento.getDescripcion());
	
		parametrosReport.put("par_requerimiento",dwpostulantesSeleccion.getRequerimiento());
		parametrosReport.put("par_postulante",dwpostulantesSeleccion.getPostulante());
		parametrosReport.put("par_compania",dwpostulantesSeleccion.getCompanyowner());
		parametrosReport.put("par_compania_nombre",requerimiento.getDescription());
		parametrosReport.put("par_postulante_nombre",dwpostulantesSeleccion.getNombre());
		parametrosReport.put("par_puesto_postula",requerimiento.getDescripcion());
		File archivo = new File(pathPrincipal + File.separator + "erp"
				+ File.separator + "rrhh" + File.separator + File.separator
				+ "recursos" + File.separator + File.separator + "reportes"
				+ File.separator + File.separator + "EvaluacionCandidato"
				+ File.separator + File.separator + "reporteIntegral"
				+ File.separator + File.separator 
				+ "dw_hr_requerimiento_integral_evaluacion.jasper");
		
		nombreArchivoPDF = getFacPlanilla().getPrCtsServicio()
			.ejecutarReporteIReport(archivo.getPath(), parametrosReport);
		
		CBindingController.getInstance().setNombreArchivoTemporal(nombreArchivoPDF);
		
		return "pantallaReporteVistaExterna";
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
		
		boolean validacion=true;		
		
		if (UValidador.esNulo(dwpostulantesSeleccion)) {
			LOGGER.debug("VALIDACION");
			validacion = false;
		}
		
		return validacion;
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
		opciones = new OwHrRequerimientoCandidatosEdit();
		ddlbresultados = new ArrayList<Integer>();
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {

		if (configurarInformacionEvaluacion() != 0)
			return this.PANTALLA_LISTADO;

		return this.PANTALLA_MANTENIMIENTO;
	}

	/**
	 * Configurar informacion evaluacion.
	 *
	 * @return the int
	 */
	private int configurarInformacionEvaluacion() {
		if (this.getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm("HR",
				this.getUsuarioActual().getCodigoUsuario())) {
			opciones.setTabcandidatos_cbver1_disable(false);
			opciones.setTabcandidatos_cbver2_disable(false);
		} else {
			opciones.setTabcandidatos_cbver1_disable(true);
			opciones.setTabcandidatos_cbver2_disable(true);
		}

		this.titulo = "Enviar Convocatoria al Portal  " + this.titulo;

		switch (accionLista) {

		}



		/**
		 * Post wf_tipocontratofechas(w$_tipoplanilla) No influye.
		 */

		return 0;
	}

	/**
	 * Cargar informacion evaluacion.
	 *
	 * @powerbuilder wf_open_retrieve
	 * @return the int
	 */
	private int cargarInformacionEvaluacion() {
		String validacion1 = ConstanteRrhh.TIPO_NO;
		String validacion3 = ConstanteRrhh.TIPO_NO;
		boolean essisadm = this.getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm("HR",
				this.getUsuarioActual().getCodigoUsuario());

		dwevaluacionpostulanteetapa = this.getFacRrhh().getHrEvaluacionetapaServicio()
				.listarEtapaPorEvaluacion(requerimiento.getRequerimiento(), requerimiento.getCompanyowner());
		dwevaluacionpostulante = this.getFacRrhh().getHrEvaluacionpostulanteServicio()
				.listaEtapasPorEvaluacion(requerimiento.getCompanyowner(), requerimiento.getRequerimiento());
		dwevaluacionpostulante3 = this.getFacRrhh().getHrEvaluacionpostulanteServicio()
				.listaResumenEtapaPorEvaluacion(requerimiento.getCompanyowner(), requerimiento.getRequerimiento());

		// Se ha omitido el código que tiene que ver con los otros tabs

		dwpostulantes = this.getFacRrhh().getHrPosRequerServicio().listaPostulantesCandidatos(
				requerimiento.getCompanyowner(), requerimiento.getRequerimiento(),
				this.getUsuarioActual().getIdPersona(), validacion1);

		if (accionLista.equals(accion_solicitada.VER)) {
			if (!UValidador.esListaVacia(dwpostulantes))
				filtrarCandidatos(dwpostulantes.get(0));
		}
		
		
		opciones.setDwpostulantes_flagganador_protect(true);

		if (!UValidador.esListaVacia(dwpostulantes)) {
			for (DtoDwHrRequerimientopostEdit pos : dwpostulantes) {
				pos.setNombre(
						this.getFacRrhh().getHrPostulantesServicio().obtenerNombrePostulante(pos.getPostulante()));
				String expela = this.getFacRrhh().getHrPostulanteexperienciaServicio()
						.obtenerTiempoExperienciaPostulante("P", pos.getPostulante(), pos.getPuesto());
				String expepr = this.getFacRrhh().getHrPostulanteexperienciaServicio()
						.obtenerTiempoExperienciaPostulante("L", pos.getPostulante(), pos.getPuesto());
				pos.setAuxexperiencialaboral(expela.substring(0, 2) + " a " + expela.substring(2, 4) + " m "
						+ expela.substring(4, 6) + " d");
				pos.setAuxexperienciaprofesional(expepr.substring(0, 2) + " a " + expepr.substring(2, 4) + " m "
						+ expepr.substring(4, 6) + " d");
			}
		}

		if (!essisadm) {
			Integer wparam = this.getFacSeguridad().getSeguridadautorizacionesServicio().leerAutorizaciones("HR",
					"GRUP04", "CON101", this.getUsuarioActual().getCodigoUsuario());
			if (wparam == 0)
				opciones.setTabcandidatos_cbimprimirficha_disable(false);
			else
				opciones.setTabcandidatos_cbimprimirficha_disable(true);

			wparam = this.getFacSeguridad().getSeguridadautorizacionesServicio().leerAutorizaciones("HR", "GRUP04",
					"CON102", this.getUsuarioActual().getCodigoUsuario());
			if (wparam == 0)
				opciones.setTabcandidatos_cbfinalistas_disable(false);
			else
				opciones.setTabcandidatos_cbfinalistas_disable(true);

			wparam = this.getFacSeguridad().getSeguridadautorizacionesServicio().leerAutorizaciones("HR", "GRUP04",
					"CON103", this.getUsuarioActual().getCodigoUsuario());
			if (wparam == 0)
				opciones.setTabcandidatos_cbrepintegral_disable(false);
			else
				opciones.setTabcandidatos_cbrepintegral_disable(true);
		} else {
			opciones.setTabcandidatos_cbimprimirficha_disable(false);
			opciones.setTabcandidatos_cbfinalistas_disable(false);
			opciones.setTabcandidatos_cbrepintegral_disable(false);
		}


		if (ConstanteRrhh.TIPO_ESTADO_PREPARACION.equals(requerimiento.getEstado())
				|| ConstanteRrhh.TIPO_ESTADO_RE.equals(requerimiento.getEstado())
				|| ConstanteRrhh.TIPO_ESTADO_REVISADO.equals(requerimiento.getEstado())) {
			opciones.setDwevaluacionpostulante_render(false);
			opciones.setTabcandidatos_disable(true);
			opciones.setDwpostulantes_protect(true);
			opciones.setDwevaluacionpostulante_protect(true);
			opciones.setDwevaluacionpostulanteetapa_protect(true);
			ibevaluar = false;
		}
		return 0;
	}

	private void seleccionarCandidatoClick(DtoDwHrRequerimientopostEdit pos) {
		if (!UValidador.esNulo(pos) ){//   && accionLista.equals(accion_solicitada.EVALUAR)) {
			HrEvalrequerimientoPk pkevalreq = new HrEvalrequerimientoPk();
			pkevalreq.setCompanyowner(requerimiento.getCompanyowner());
			pkevalreq.setRequerimiento(requerimiento.getRequerimiento());
			pkevalreq.setSecuencia(pos.getSecuencia());

			HrEvalrequerimiento evalreq = (HrEvalrequerimiento) this.getFacRrhh().getHrEvalrequerimientoServicio()
					.obtenerPorId(pkevalreq);

			if (!UValidador.esNulo(evalreq)) {
				HrEvaluacionPk pkeva = new HrEvaluacionPk();
				pkeva.setEvaluacion(evalreq.getEvaluacion());

				HrEvaluacion eva = (HrEvaluacion) this.getFacRrhh().getHrEvaluacionServicio().obtenerPorId(pkeva);

				if (!UValidador.esNulo(eva)) {

					if ("3".equals(eva.getTipoeval()) && !"E".equals(pos.getEstado())) {
						opciones.setTabcandidatos_cbporocesar_visible(true);
						opciones.setTabcandidatos_cbporocesar_disable(false);

						opciones.setDwevaluacionpostulante_protect(true);
						opciones.setDwevaluacionpostulante_protect(true);
					} else {
						opciones.setTabcandidatos_cbporocesar_visible(false);
						opciones.setTabcandidatos_cbporocesar_disable(true);
						opciones.setTabcandidatos_cbeliminar_disable(false);

						opciones.setDwevaluacionpostulante_protect(false);
						opciones.setDwevaluacionpostulante_protect(false);
					}

					if ("3".equals(eva.getTipoeval())) {
						opciones.setDwevaluacionpostulante_protect(true);
						// dw_evaluacionpostulante.enabled = false
					} else {
						HrPosRequerPk pkposre = new HrPosRequerPk();
						pkposre.setCompanyowner(requerimiento.getCompanyowner());
						pkposre.setRequerimiento(requerimiento.getRequerimiento());
						pkposre.setPostulante(pos.getPostulante());

						HrPosRequer posre = (HrPosRequer) this.getFacRrhh().getHrPosRequerServicio()
								.obtenerPorId(pkposre);

						// [...No se utiliza]
						/** ============================================ */

						filtrarCandidatos(pos);

						if ("E".equals(pos.getEstado())) {
							opciones.setTabcandidatos_cbver1_disable(true);
							opciones.setTabcandidatos_cbver2_disable(true);
						} else {
							opciones.setTabcandidatos_cbver1_disable(false);
							opciones.setTabcandidatos_cbver2_disable(false);
							opciones.setTabcandidatos_cbeliminar_disable(false);
							opciones.setTabcandidatos_cb2_disable(false);
						}

					}

				}
			}
		}

	}

	private Integer filtrarCandidatos(DtoDwHrRequerimientopostEdit pos) {

		if (!UValidador.esNulo(pos)) {
			if (!UValidador.esNulo(pos.getPostulante()) && !UValidador.esNulo(pos.getSecuencia())) {
				for (DtoDwRequerimientoevaletapasEdit f : dwevaluacionpostulanteetapa) {
					if (!(f.getSecuencia() == pos.getSecuencia() && f.getPostulante().equals(pos.getPostulante()))) {
						f.setOcultar(true);
					}
				}
				for (DtoDwHrRequerimientoevalentrevistaEditB f : dwevaluacionpostulante) {
					if (!(f.getSecuencia() == pos.getSecuencia() && f.getPostulante().equals(pos.getPostulante()))) {
						f.setOcultar(true);
					}
				}

				// tab_1.tabpage_candidatos.dw_evaluacionpostulante_3.Filter()
				for (DtoDwHrRequerimientoevalpostEdit2 f : dwevaluacionpostulante3) {
					if (!(f.getPostulante().equals(pos.getPostulante()))) {
						f.setOcultar(true);
					}
				}

				Integer secuencia = null;
				for (DtoDwRequerimientoevaletapasEdit f : dwevaluacionpostulanteetapa) {
					if (!f.isOcultar()) {
						secuencia = f.getSecuencia();
						break;
					}
				}

				if (!UValidador.esNulo(secuencia)) {
					for (DtoDwHrRequerimientoevalpostEdit2 f : dwevaluacionpostulante3) {
						if (f.getSecuencia() == secuencia) {

						}
					}
				}

				ilsecuencia = pos.getSecuencia();
				ilsecuencia2 = pos.getSecuencia2();

			}
		}

		return 0;
	}

	public void onRowSelect(SelectEvent event) {
		LOGGER.debug("onRowSelect");
		dwpostulantesSeleccion = (DtoDwHrRequerimientopostEdit) event.getObject();
	}

	public List<DtoDwHrRequerimientopostEdit> getDwpostulantes() {
		return dwpostulantes;
	}

	public void setDwpostulantes(List<DtoDwHrRequerimientopostEdit> dwpostulantes) {
		this.dwpostulantes = dwpostulantes;
	}

	public accion_solicitada getAccionLista() {
		return accionLista;
	}

	public void setAccionLista(accion_solicitada accionLista) {
		this.accionLista = accionLista;
	}

	public OwHrRequerimientoCandidatosEdit getOpciones() {
		return opciones;
	}

	public void setOpciones(OwHrRequerimientoCandidatosEdit opciones) {
		this.opciones = opciones;
	}

	public DtoDwHrRequerimientoList getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(DtoDwHrRequerimientoList requerimiento) {
		this.requerimiento = requerimiento;
	}

	public List<DtoDwRequerimientoevaletapasEdit> getDwevaluacionpostulanteetapa() {
		return dwevaluacionpostulanteetapa;
	}

	public void setDwevaluacionpostulanteetapa(List<DtoDwRequerimientoevaletapasEdit> dwevaluacionpostulanteetapa) {
		this.dwevaluacionpostulanteetapa = dwevaluacionpostulanteetapa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<DtoDwHrRequerimientoevalentrevistaEditB> getDwevaluacionpostulante() {
		return dwevaluacionpostulante;
	}

	public void setDwevaluacionpostulante(List<DtoDwHrRequerimientoevalentrevistaEditB> dwevaluacionpostulante) {
		this.dwevaluacionpostulante = dwevaluacionpostulante;
	}

	public List<DtoDwHrRequerimientoevalpostEdit2> getDwevaluacionpostulante3() {
		return dwevaluacionpostulante3;
	}

	public void setDwevaluacionpostulante3(List<DtoDwHrRequerimientoevalpostEdit2> dwevaluacionpostulante3) {
		this.dwevaluacionpostulante3 = dwevaluacionpostulante3;
	}

	public DtoDwHrRequerimientopostEdit getDwpostulantesSeleccion() {
		return dwpostulantesSeleccion;
	}

	public void setDwpostulantesSeleccion(DtoDwHrRequerimientopostEdit dwpostulantesSeleccion) {
		this.dwpostulantesSeleccion = dwpostulantesSeleccion;
	}

	public boolean isIbevaluar() {
		return ibevaluar;
	}

	public void setIbevaluar(boolean ibevaluar) {
		this.ibevaluar = ibevaluar;
	}

	public int getIlsecuencia() {
		return ilsecuencia;
	}

	public void setIlsecuencia(int ilsecuencia) {
		this.ilsecuencia = ilsecuencia;
	}

	public int getIlsecuencia2() {
		return ilsecuencia2;
	}

	public void setIlsecuencia2(int ilsecuencia2) {
		this.ilsecuencia2 = ilsecuencia2;
	}

	public List<Integer> getDdlbresultados() {
		return ddlbresultados;
	}

	public void setDdlbresultados(List<Integer> ddlbresultados) {
		this.ddlbresultados = ddlbresultados;
	}

	public Integer getEtapaSeleccion() {
		return etapaSeleccion;
	}

	public void setEtapaSeleccion(Integer etapaSeleccion) {
		this.etapaSeleccion = etapaSeleccion;
	}

	public String getNombreArchivoPDF() {
		return nombreArchivoPDF;
	}

	public void setNombreArchivoPDF(String nombreArchivoPDF) {
		this.nombreArchivoPDF = nombreArchivoPDF;
	}

}
