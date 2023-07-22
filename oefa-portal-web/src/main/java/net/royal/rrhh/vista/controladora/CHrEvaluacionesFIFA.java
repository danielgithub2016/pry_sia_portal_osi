package net.royal.rrhh.vista.controladora;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.dominio.dto.DtoHrEntrCasPost;
import net.royal.erp.rrhh.dominio.dto.DtoHrEntrCasPostEval;
import net.royal.erp.rrhh.dominio.dto.DtoHrEvalCas;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

/**
 * @author PEDRO LOPEZ
 *
 */
@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CHrEvaluacionesFIFA extends CBaseBean implements UIMantenimientoController {

	private DtoHrEvalCas registroSeleccionado;
	private DtoHrEvalCas registroSeleccionadoSala;
	private List<DtoHrEvalCas> lstDatos;
	private List<DtoHrEvalCas> listaAsistencia;
	private List<DtoHrEntrCasPost> lstPost;
	private List<DtoHrEvalCas> lstSala;
	private List<DtoHrEntrCasPost> lstPostSala;
	private String proceso;
	private String puesto;
	private String grupo;
	private String ciudad;
	// datos de la sala
	private String sala;
	private String supervisor;
	private String coordinador;
	private String evaluador;
	private String convocatoria;
	private String despuesto;
	private String especialidad;
	private DtoHrEntrCasPost postulanteSeleccionado;
	private Integer durExamen;
	private Boolean blFoto;
	private String documento;
	private Boolean blEvaluadorSala;

	public CHrEvaluacionesFIFA() {
		this.PANTALLA_LISTADO = "evaluacionListaFIFA";
		this.PANTALLA_LISTADO_SALA = "evaluacionSalaFIFA";
		this.PANTALLA_POSTULANTES = "postulantesListaEvalFIFA";
		this.PANTALLA_POSTULANTES_SALA = "postulantesSalaFIFA";
	}

	public String verDetallesEvaluacion() {
		postulanteSeleccionado = getFacRrhh().getHrEncuestaServicio().datosPostulanteExamenCEU(
				registroSeleccionado.getId_evalcas(), postulanteSeleccionado.getIdpostulante());
		getWebControlContext().actualizar("dgDatosEvaluacion");
		getWebControlContext().ejecutar("PF('popDatosEvaluacion').show()");
		return null;
	}

	public static CHrEvaluacionesFIFA getInstance() {
		return UFaces.evaluateExpressionGet("#{cHrEvaluacionesFIFA}", CHrEvaluacionesFIFA.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("-------------Evaluaciones FIFA------------");
		System.out.println("Codigo Empleado " + getUsuarioActual().getIdPersona());
		System.out.println("Codigo Usuario " + getUsuarioActual().getCodigoUsuario());
		System.out.println("Nombre Completo " + getUsuarioActual().getNombreCompleto());
		System.out.println("Código Área " + getUsuarioActual().getAreaCodigo());
		System.out.println("Nombre Área " + getUsuarioActual().getAreaNombre());
		System.out.println("Centro Costo Organica Código " + getUsuarioActual().getCentroCostosCodigo());
		System.out.println("Centro Costo Nombre " + getUsuarioActual().getCentroCostosNombre());
		System.out.println("-------------Evaluaciones CAS------------");

		this.setAccionPantalla(accion_solicitada.LISTAR);

		this.buscar();
		return this.PANTALLA_LISTADO;
	}

	// SALA
	public String iniciarControladoraSala() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("-------------Evaluaciones CAS------------");
		System.out.println("Codigo Empleado " + getUsuarioActual().getIdPersona());
		System.out.println("Codigo Usuario " + getUsuarioActual().getCodigoUsuario());
		System.out.println("Nombre Completo " + getUsuarioActual().getNombreCompleto());
		System.out.println("Código Área " + getUsuarioActual().getAreaCodigo());
		System.out.println("Nombre Área " + getUsuarioActual().getAreaNombre());
		System.out.println("Centro Costo Organica Código " + getUsuarioActual().getCentroCostosCodigo());
		System.out.println("Centro Costo Nombre " + getUsuarioActual().getCentroCostosNombre());
		System.out.println("-------------Evaluaciones CAS------------");

		this.setAccionPantalla(accion_solicitada.LISTAR);

		this.buscarSalas();
		return this.PANTALLA_LISTADO_SALA;
	}

	@Override
	public String buscar() throws Exception {
		convocatoria = "";
		despuesto = "";
		lstDatos = new ArrayList<DtoHrEvalCas>();
		LOGGER.debug(this.getUsuarioActual().getIdPersona());
		List<DtoHrEvalCas> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio()
				.listarHrEvalFIFA(getUsuarioActual().getIdPersona());
		if (UValidador.esNulo(lstDatosFull))
			lstDatosFull = new ArrayList<DtoHrEvalCas>();
		LOGGER.debug("LISTA DE ENCUESTA " + lstDatosFull.size());
		for (int i = 0; i < lstDatosFull.size(); i++) {
			lstDatos.add(lstDatosFull.get(i));
		}
		return null;
	}

	public String buscarSalas() throws Exception {
		lstDatos = new ArrayList<DtoHrEvalCas>();
		LOGGER.debug(this.getUsuarioActual().getIdPersona());
		List<DtoHrEvalCas> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio().listarHrEvalSalaFIFA(convocatoria,
				despuesto, getUsuarioActual().getIdPersona());
		if (UValidador.esNulo(lstDatosFull))
			lstDatosFull = new ArrayList<DtoHrEvalCas>();
		LOGGER.debug("LISTA DE ENCUESTA " + lstDatosFull.size());
		for (int i = 0; i < lstDatosFull.size(); i++) {
			lstDatos.add(lstDatosFull.get(i));
		}
		return null;
	}

	public String buscarParam() throws Exception {
		System.out.println("Convocatoria: " + convocatoria);
		System.out.println("Puesto: " + despuesto);

		lstDatos = new ArrayList<DtoHrEvalCas>();
		List<DtoHrEvalCas> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio().listarHrEvalFIFA2(convocatoria,
				despuesto, getUsuarioActual().getIdPersona());
		if (UValidador.esNulo(lstDatosFull))
			lstDatosFull = new ArrayList<DtoHrEvalCas>();
		LOGGER.debug("LISTA DE ENCUESTA " + lstDatosFull.size());
		for (int i = 0; i < lstDatosFull.size(); i++) {
			lstDatos.add(lstDatosFull.get(i));
		}
		return this.PANTALLA_LISTADO;
	}

	public String verPost() throws Exception {
		this.setAccionPantalla(accion_solicitada.EDITAR);
		List<DtoHrEntrCasPostEval> lstDatosFull3 = this.getFacRrhh().getHrEncuestaServicio()
				.datosProcesoCeu(registroSeleccionado);
		System.out.println("Req: " + registroSeleccionado.getRequerimiento());
		for (int i = 0; i < lstDatosFull3.size(); i++) {
			proceso = lstDatosFull3.get(i).getConvocatoria();
			puesto = lstDatosFull3.get(i).getPuesto();
		}

		ciudad = registroSeleccionado.getNombreciudad();
		grupo = registroSeleccionado.getNombregrupo();
		especialidad = registroSeleccionado.getNombreespecialidad();

		listarPostulantes();
		return this.PANTALLA_POSTULANTES;
	}

	public String verPostSala() throws Exception {
		blFoto = false;
		documento = null;
		lstSala = this.getFacRrhh().getHrEncuestaServicio().listarSalaPorPersonaCeu(getUsuarioActual().getIdPersona(),
				registroSeleccionado.getId_evalcas());

		if (!UValidador.esListaVacia(lstSala)) {
			this.setAccionPantalla(accion_solicitada.EDITAR);
			if (lstSala.size() == 1) {
				registroSeleccionadoSala = lstSala.get(0);
				listarPostulantesSala();
			} else {
				proceso = registroSeleccionado.getNro_requerimiento();
				puesto = registroSeleccionado.getPuesto();
				ciudad = registroSeleccionado.getNombreciudad();
				grupo = registroSeleccionado.getNombregrupo();
				especialidad = registroSeleccionado.getNombreespecialidad();
				// mostramos las salas para que el usuario seleccione
				getWebControlContext().actualizar("dgSalas");
				getWebControlContext().ejecutar("PF('popSalas').show()");
				return null;
			}
		} else {
			setMessageError("No está asignado a ninguna sala de este grupo");
			return null;
		}

		return this.PANTALLA_POSTULANTES_SALA;
	}

	public String verPost2() throws Exception {
		this.setAccionPantalla(accion_solicitada.EDITAR);

		List<DtoHrEntrCasPostEval> lstDatosFull3 = this.getFacRrhh().getHrEncuestaServicio()
				.datosProcesoCeu(registroSeleccionado);
		System.out.println("Req: " + registroSeleccionado.getRequerimiento());
		for (int i = 0; i < lstDatosFull3.size(); i++) {
			proceso = lstDatosFull3.get(i).getConvocatoria();
			puesto = lstDatosFull3.get(i).getPuesto();
		}

		ciudad = registroSeleccionado.getNombreciudad();
		grupo = registroSeleccionado.getNombregrupo();
		especialidad = registroSeleccionado.getNombreespecialidad();

		listarPostulantes2();

		return this.PANTALLA_POSTULANTES;
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
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	public String inicializarFiltrosListado() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(String convocatoria) {
		this.convocatoria = convocatoria;
	}

	public String getDespuesto() {
		return despuesto;
	}

	public void setDespuesto(String despuesto) {
		this.despuesto = despuesto;
	}

	public List<DtoHrEvalCas> getLstDatos() {
		return lstDatos;
	}

	public void setLstDatos(List<DtoHrEvalCas> lstDatos) {
		this.lstDatos = lstDatos;
	}

	public DtoHrEvalCas getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(DtoHrEvalCas registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public List<DtoHrEntrCasPost> getLstPost() {
		return lstPost;
	}

	public void setLstPost(List<DtoHrEntrCasPost> lstPost) {
		this.lstPost = lstPost;
	}

	public String iniciar() throws Exception {
		this.setAccionPantalla(accion_solicitada.EDITAR);
		List<DtoHrEvalCas> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio()
				.valInicioHrEvalFIFA(registroSeleccionado);
		String val = "";
		for (int i = 0; i < lstDatosFull.size(); i++) {
			val = lstDatosFull.get(i).getEstado();
		}
		if (val.equals("0")) {
			this.setMessageSuccess("No existe la cantidad mínima de preguntas en el balotario");
		} else {
			this.getFacRrhh().getHrEncuestaServicio().editarHrEvalFIFA(registroSeleccionado);
			this.buscar();
			this.setMessageSuccess("Ya los postulantes pueden ingresar a la evaluación!");
		}
		return this.PANTALLA_LISTADO;
	}

	public String finalizar() throws Exception {

		this.setAccionPantalla(accion_solicitada.EDITAR);
		this.getFacRrhh().getHrEncuestaServicio().finalizarHrEvalFIFA(registroSeleccionado.getRequerimiento(),
				registroSeleccionado.getId_evalcas());
		String val = "";
		System.out.println("Codigo Empleado " + registroSeleccionado.getId_evalcas());
		List<DtoHrEvalCas> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio()
				.valCierreHrEvalCeu(registroSeleccionado.getId_evalcas());
		for (int i = 0; i < lstDatosFull.size(); i++) {
			val = lstDatosFull.get(i).getEstado();
			System.out.println("Codigo Empleado " + val);
		}
		if (val.equals("0")) {
			this.buscar();
			this.setMessageSuccess("Se cerro el proceso de evaluación!");
		} else {
			this.buscar();
			this.setMessageSuccess("No se pudo finalizar el proceso, intentelo de nuevo");
		}
		return this.PANTALLA_LISTADO;
	}

	public String actualizarDetalleExamenSala() throws Exception {

		boolean blactualiza = false;

		// actualizamos los minutos
		if (!UValidador.esCero(postulanteSeleccionado.getMinadicionalesexamen().intValue())) {
			this.getFacRrhh().getHrEncuestaServicio().actualizarMinutosCEU(registroSeleccionado.getId_evalcas(),
					postulanteSeleccionado.getIdpostulante(),
					postulanteSeleccionado.getMinadicionalesexamen().intValue());

			// si le damos más minutos, también le reseteamos la cantidad de
			// intentos
			this.getFacRrhh().getHrEncuestaServicio().actualizarIntentosEvaluacionPostulanteCeu(
					postulanteSeleccionado.getIdpostulante(), registroSeleccionado.getId_evalcas(), BigDecimal.ZERO);

			blactualiza = true;
		}

		// actualizamos la session
		if (postulanteSeleccionado.getCantsession().intValue() < 2) {
			this.getFacRrhh().getHrEncuestaServicio().actualizarSession("EC", postulanteSeleccionado.getTipodocumento(),
					postulanteSeleccionado.getDocumento(), postulanteSeleccionado.getIdpostulante(),
					postulanteSeleccionado.getCantsession().toString());
			blactualiza = true;
		}

		if (blactualiza) {
			listarPostulantesSala();
		}

		getWebControlContext().ejecutar("PF('popDatosEvaluacion').hide()");
		getWebControlContext().actualizar("frmEvaluacion_lista:dtPostulante");

		return null;
	}

	public String actualizarDetalleExamen() throws Exception {

		boolean blactualiza = false;

		// actualizamos los minutos
		if (!UValidador.esCero(postulanteSeleccionado.getMinadicionalesexamen().intValue())) {
			this.getFacRrhh().getHrEncuestaServicio().actualizarMinutosCEU(registroSeleccionado.getId_evalcas(),
					postulanteSeleccionado.getIdpostulante(),
					postulanteSeleccionado.getMinadicionalesexamen().intValue());

			// si le damos más minutos, también le reseteamos la cantidad de
			// intentos
			this.getFacRrhh().getHrEncuestaServicio().actualizarIntentosEvaluacionPostulanteCeu(
					postulanteSeleccionado.getIdpostulante(), registroSeleccionado.getId_evalcas(), BigDecimal.ZERO);

			blactualiza = true;
		}

		// actualizamos la session
		if (postulanteSeleccionado.getCantsession().intValue() < 2) {
			this.getFacRrhh().getHrEncuestaServicio().actualizarSession("EC", postulanteSeleccionado.getTipodocumento(),
					postulanteSeleccionado.getDocumento(), postulanteSeleccionado.getIdpostulante(),
					postulanteSeleccionado.getCantsession().toString());
			blactualiza = true;
		}

		if (blactualiza) {
			buscarPostulante();
		}

		getWebControlContext().ejecutar("PF('popDatosEvaluacion').hide()");
		getWebControlContext().actualizar("frmEvaluacion_lista:dtPostulante");

		return null;
	}

	public String buscarPostulante() throws Exception {
		// blFoto = (Boolean) event.getNewValue();
		if ("1".equals(registroSeleccionado.getN_estado())) {
			listarPostulantes();
		}
		if ("2".equals(registroSeleccionado.getN_estado())) {
			listarPostulantes2();
		}

		return null;
	}

	public void listarPostulantes() {
		lstPost = this.getFacRrhh().getHrEncuestaServicio().verPostulantesHrEvalFIFA(registroSeleccionado);
	}

	public String listarPostulantesSala() {
		proceso = registroSeleccionadoSala.getConvocatoria();
		puesto = registroSeleccionadoSala.getPuesto();
		ciudad = registroSeleccionadoSala.getNombreciudad();
		grupo = registroSeleccionadoSala.getNombregrupo();
		especialidad = registroSeleccionadoSala.getNombreespecialidad();
		sala = registroSeleccionadoSala.getNombresala();
		supervisor = registroSeleccionadoSala.getNombresupervisor();
		coordinador = registroSeleccionadoSala.getNombrecoordinador();
		evaluador = registroSeleccionadoSala.getNombreevaluador();

		registroSeleccionadoSala.setCodigogrupo(registroSeleccionado.getCodigogrupo());
		registroSeleccionadoSala.setCiudad(registroSeleccionado.getCiudad());

		blEvaluadorSala = false;
		if (getUsuarioActual().getIdPersona() == registroSeleccionadoSala.getId_evaluador01().intValue()
				|| getUsuarioActual().getIdPersona() == registroSeleccionadoSala.getId_evaluador02().intValue()
				|| getUsuarioActual().getIdPersona() == registroSeleccionadoSala.getId_evaluador03().intValue()
				|| getUsuarioActual().getIdPersona() == registroSeleccionadoSala.getId_evaluador04().intValue()
				|| getUsuarioActual().getIdPersona() == registroSeleccionadoSala.getId_evaluador05().intValue()) {
			blEvaluadorSala = true;
		}

		if ("1".equals(registroSeleccionado.getN_estado())) {
			lstPostSala = this.getFacRrhh().getHrEncuestaServicio()
					.verPostulantesSalaHrEvalFIFA(registroSeleccionadoSala, blFoto, null, documento);
		}
		if ("2".equals(registroSeleccionado.getN_estado())) {
			lstPostSala = this.getFacRrhh().getHrEncuestaServicio()
					.verPostulantesSalaHrEvalFIFA2(registroSeleccionadoSala, blFoto, null, documento);
		}

		return this.PANTALLA_POSTULANTES_SALA;
	}

	public void listarPostulantes2() {
		lstPost = this.getFacRrhh().getHrEncuestaServicio().verPostulantesHrEvalFIFA2(registroSeleccionado);
	}

	public List<DtoHrEvalCas> getListaAsistencia() {
		if (listaAsistencia == null) {
			listaAsistencia = this.getFacRrhh().getHrEncuestaServicio().listarAsistencia();
		}
		return listaAsistencia;
	}

	public void setListaAsistencia(List<DtoHrEvalCas> listaAsistencia) {
		this.listaAsistencia = listaAsistencia;
	}

	public void valueChanged(ValueChangeEvent e) throws Exception {
		String dato = e.getNewValue().toString();
		String datos[] = dato.split("-");
		String asistencia = datos[0];
		String idpostulante = datos[1];
		System.out.println(asistencia);
		System.out.println(idpostulante);
		this.getFacRrhh().getHrEncuestaServicio().registrarAsistenciaCeu(registroSeleccionado.getRequerimiento(),
				idpostulante, asistencia);
	}

	public String retornar() throws Exception {
		// REQ CEU 2020: Todos tienen asistencia por defecto, no se usará la
		// opción
		// this.getFacRrhh().getHrEncuestaServicio().registrarAsistencia2Ceu(registroSeleccionado.getRequerimiento(),
		// registroSeleccionado.getId_evalcas());
		this.setAccionPantalla(accion_solicitada.LISTAR);
		this.buscar();
		return this.PANTALLA_LISTADO;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public DtoHrEntrCasPost getPostulanteSeleccionado() {
		return postulanteSeleccionado;
	}

	public void setPostulanteSeleccionado(DtoHrEntrCasPost postulanteSeleccionado) {
		this.postulanteSeleccionado = postulanteSeleccionado;
	}

	public Integer getDurExamen() {
		if (UValidador.esNulo(durExamen)) {
			durExamen = this.getFacRrhh().getHrEncuestaServicio()
					.obtenerDurExamen(registroSeleccionado.getFlgtipopuesto());
		}
		return durExamen;
	}

	public List<DtoHrEntrCasPost> getLstPostSala() {
		return lstPostSala;
	}

	public void setLstPostSala(List<DtoHrEntrCasPost> lstPostSala) {
		this.lstPostSala = lstPostSala;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public List<DtoHrEvalCas> getLstSala() {
		return lstSala;
	}

	public void setLstSala(List<DtoHrEvalCas> lstSala) {
		this.lstSala = lstSala;
	}

	public String getCoordinador() {
		return coordinador;
	}

	public void setCoordinador(String coordinador) {
		this.coordinador = coordinador;
	}

	public DtoHrEvalCas getRegistroSeleccionadoSala() {
		return registroSeleccionadoSala;
	}

	public void setRegistroSeleccionadoSala(DtoHrEvalCas registroSeleccionadoSala) {
		this.registroSeleccionadoSala = registroSeleccionadoSala;
	}

	public Boolean getBlFoto() {
		return blFoto;
	}

	public void setBlFoto(Boolean blFoto) {
		this.blFoto = blFoto;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Boolean getBlEvaluadorSala() {
		return blEvaluadorSala;
	}

	public void setBlEvaluadorSala(Boolean blEvaluadorSala) {
		this.blEvaluadorSala = blEvaluadorSala;
	}

	public String getEvaluador() {
		return evaluador;
	}

	public void setEvaluador(String evaluador) {
		this.evaluador = evaluador;
	}

}
