package net.royal.rrhh.vista.controladora;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.event.data.PageEvent;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.dominio.HrPostulantes;
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
public class CHrEvaluacionesCAS extends CBaseBean implements UIMantenimientoController {

	private DtoHrEvalCas registroSeleccionado;
	private List<DtoHrEvalCas> lstDatos;
	private List<DtoHrEvalCas> listaAsistencia;
	private List<DtoHrEntrCasPost> lstPost;
	private String proceso;
	private String puesto;
	private String convocatoria;
	private String despuesto;
	private DtoHrEntrCasPost postulanteSeleccionado;
	private String fotoPostulante;
	private Integer page;
	private Integer itemPorPage;
	private Boolean blFoto;
	private Integer durExamen;

	public String verDetallesEvaluacion() {

		postulanteSeleccionado = getFacRrhh().getHrEncuestaServicio()
				.datosPostulanteExamen(registroSeleccionado.getId_evalcas(), postulanteSeleccionado.getIdpostulante());
		getWebControlContext().actualizar("dgDatosEvaluacion");
		getWebControlContext().ejecutar("PF('popDatosEvaluacion').show()");
		return null;
	}

	public void getPage(PageEvent event) {
		page = event.getPage();
		int inicio = page * itemPorPage + 1;
		int fin = inicio + itemPorPage - 1;

		if (!UValidador.esListaVacia(lstPost)) {
			lstPost = getFacRrhh().getHrEncuestaServicio().obtenerFotosPostulantes(lstPost, inicio, fin);
		}
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

	public CHrEvaluacionesCAS() {
		this.PANTALLA_LISTADO = "evaluacionLista";
		this.PANTALLA_POSTULANTES = "postulantesListaEval";
		this.PANTALLA_MANTENIMIENTO = "encuesta_ejecucion";
	}

	public static CHrEvaluacionesCAS getInstance() {
		return UFaces.evaluateExpressionGet("#{cHrEvaluacionesCAS}", CHrEvaluacionesCAS.class);
	}

	public String verFotoPotulante() {

		fotoPostulante = "";

		HrPostulantes filtro = new HrPostulantes();
		filtro.setDocumento(postulanteSeleccionado.getDocumento());

		HrPostulantes hrPostulantes = getFacRrhh().getHrPostulantesServicio().obtenerInformacionReniec(filtro);

		if (!UValidador.esNulo(hrPostulantes)) {
			if (!hrPostulantes.getAuxerrorreniec()) {
				if (!UValidador.esNulo(hrPostulantes.getFoto())) {
					fotoPostulante = "data:image/png;base64," + hrPostulantes.getImagenBase64();
				}
			}
		}

		return null;
	}

	@Override
	public String iniciarControladora() throws Exception {
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
		fotoPostulante = "";
		page = 0;
		itemPorPage = 10;
		blFoto = false;

		this.setAccionPantalla(accion_solicitada.LISTAR);
		// this.inicializarFiltrosListado();
		this.buscar();
		return this.PANTALLA_LISTADO;
	}

	@Override
	public String buscar() throws Exception {
		convocatoria = "";
		despuesto = "";
		lstDatos = new ArrayList<DtoHrEvalCas>();
		LOGGER.debug(this.getUsuarioActual().getIdPersona());
		List<DtoHrEvalCas> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio().listarHrEvalCas();
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
		List<DtoHrEvalCas> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio().listarHrEvalCas2(convocatoria,
				despuesto);
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
				.datosProceso(registroSeleccionado.getRequerimiento());
		if (!UValidador.esListaVacia(lstDatosFull3)) {
			proceso = lstDatosFull3.get(0).getConvocatoria();
			puesto = lstDatosFull3.get(0).getPuesto();
		}

		listarPostulantes();
		return this.PANTALLA_POSTULANTES;
	}

	public String verPost2() throws Exception {
		this.setAccionPantalla(accion_solicitada.EDITAR);

		List<DtoHrEntrCasPostEval> lstDatosFull3 = this.getFacRrhh().getHrEncuestaServicio()
				.datosProceso(registroSeleccionado.getRequerimiento());
		if (!UValidador.esListaVacia(lstDatosFull3)) {
			proceso = lstDatosFull3.get(0).getConvocatoria();
			puesto = lstDatosFull3.get(0).getPuesto();
		}
		listarPostulantes2();

		return this.PANTALLA_POSTULANTES;
	}

	public void listarPostulantes() {
		lstPost = this.getFacRrhh().getHrEncuestaServicio()
				.verPostulantesHrEvalCas(registroSeleccionado.getId_evalcas(), blFoto, null);
	}

	public void listarPostulantes2() {
		lstPost = this.getFacRrhh().getHrEncuestaServicio()
				.verPostulantesHrEvalCas2(registroSeleccionado.getId_evalcas(), blFoto, null);
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
				.valInicioHrEvalCas(registroSeleccionado.getId_evalcas());
		String val = "";
		for (int i = 0; i < lstDatosFull.size(); i++) {
			val = lstDatosFull.get(i).getEstado();
		}
		if (val.equals("0")) {
			this.setMessageSuccess("No existe la cantidad mínima de preguntas en el balotario");
		} else {
			this.getFacRrhh().getHrEncuestaServicio().editarHrEvalCas(registroSeleccionado.getRequerimiento(),
					registroSeleccionado.getId_evalcas());
			this.buscar();
			this.setMessageSuccess("Ya los postulantes pueden ingresar a la evaluación!");
		}
		return this.PANTALLA_LISTADO;
	}

	public String finalizar() throws Exception {

		this.setAccionPantalla(accion_solicitada.EDITAR);
		this.getFacRrhh().getHrEncuestaServicio().finalizarHrEvalCas(registroSeleccionado.getRequerimiento(),
				registroSeleccionado.getId_evalcas());
		String val = "";
		System.out.println("Codigo Empleado " + registroSeleccionado.getId_evalcas());
		List<DtoHrEvalCas> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio()
				.valCierreHrEvalCas(registroSeleccionado.getId_evalcas());
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
		this.getFacRrhh().getHrEncuestaServicio().registrarAsistencia(registroSeleccionado.getRequerimiento(),
				idpostulante, asistencia);
	}

	public String retornar() throws Exception {
		this.getFacRrhh().getHrEncuestaServicio().registrarAsistencia2(registroSeleccionado.getRequerimiento(),
				registroSeleccionado.getId_evalcas());
		this.setAccionPantalla(accion_solicitada.LISTAR);
		this.buscar();
		fotoPostulante = "";
		return this.PANTALLA_LISTADO;
	}

	public String actualizarDetalleExamen() throws Exception {

		boolean blactualiza = false;

		// actualizamos los minutos
		if (!UValidador.esCero(postulanteSeleccionado.getMinadicionalesexamen().intValue())) {
			this.getFacRrhh().getHrEncuestaServicio().actualizarMinutos(registroSeleccionado.getId_evalcas(),
					postulanteSeleccionado.getIdpostulante(),
					postulanteSeleccionado.getMinadicionalesexamen().intValue());
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

	public DtoHrEntrCasPost getPostulanteSeleccionado() {
		return postulanteSeleccionado;
	}

	public void setPostulanteSeleccionado(DtoHrEntrCasPost postulanteSeleccionado) {
		this.postulanteSeleccionado = postulanteSeleccionado;
	}

	public String getFotoPostulante() {
		return fotoPostulante;
	}

	public void setFotoPostulante(String fotoPostulante) {
		this.fotoPostulante = fotoPostulante;
	}

	public Boolean getBlFoto() {
		return blFoto;
	}

	public void setBlFoto(Boolean blFoto) {
		this.blFoto = blFoto;
	}

	public Integer getDurExamen() {
		if (UValidador.esNulo(durExamen)) {
			durExamen = this.getFacRrhh().getHrEncuestaServicio()
					.obtenerDurExamen(registroSeleccionado.getFlgtipopuesto());
		}
		return durExamen;
	}
}
