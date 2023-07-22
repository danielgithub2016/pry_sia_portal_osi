package net.royal.rrhh.vista.controladora;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.dominio.dto.DtoHrEntrCas;
import net.royal.erp.rrhh.dominio.dto.DtoHrEntrCasPost;
import net.royal.erp.rrhh.dominio.dto.DtoHrEntrCasPostEval;
import net.royal.erp.rrhh.dominio.dto.DtoHrRequerimientoSeguimiento;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFormula;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

/**
 * @author PEDRO LOPEZ
 *
 */
@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CHrEntrevistaCAS extends CBaseBean implements UIMantenimientoController {

	private List<DtoHrEntrCas> lstEntr;
	private List<DtoHrEntrCasPost> lstEntrPost;
	private List<DtoHrEntrCasPostEval> lstEntrPostEval;
	private List<DtoHrEntrCasPostEval> lstPuntos;
	private List<DtoHrEntrCasPostEval> lstPuntosEscala;
	private List<DtoHrEntrCasPostEval> listaPuntos;
	private DtoHrEntrCas registroSeleccionado;
	private DtoHrEntrCasPost registroSeleccionadopost;
	private String puntaje;
	private String valRegistro;
	private String enviado;
	private String nextPost;
	private String nspPost;
	private String proceso;
	private String puesto;
	private String flagtipopuesto;
	private String unidad;
	private String nompostulante;
	private String flg_estado;
	private String n_estado;
	private String tipo_sg;
	private String tipo_au;
	private String tipo_rh;
	private String tipo_pd;
	private String tipo_oa;
	private String nombre_tipo_sg;
	private String nombre_tipo_au;
	private String nombre_tipo_rh;
	private String nombre_tipo_pd;
	private String nombre_tipo_oa;
	private String fecha;
	private String hora;
	private String punto;
	public String idpostulante;
	public String idpst;
	public String idreq;
	private boolean visible;
	private String sumtipo_sg;
	private String sumtipo_au;
	private String sumtipo_rh;
	private String sumtipo_oa;
	private String sumtipo_pd;
	private String promedio;
	private Integer secuencia;

	public CHrEntrevistaCAS() {
		this.PANTALLA_LISTADO = "entrevistaLista";
		this.PANTALLA_POSTULANTES = "postulanteLista";
		this.PANTALLA_EVALUACION = "puntajeLista";
		this.PANTALLA_REPORTE_01 = "reporteProceso";
		this.PANTALLA_REPORTE_02 = "reportePostulante";
		this.PANTALLA_REPORTE_03 = "reporteProceso02";
		this.PANTALLA_REPORTE_04 = "reportePostulante02";
	}

	public static CHrEntrevistaCAS getInstance() {
		return UFaces.evaluateExpressionGet("#{cHrEntrevistaCAS}", CHrEntrevistaCAS.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		// TODO Auto-generated method stub
		this.setAccionPantalla(accion_solicitada.LISTAR);
		this.buscar();
		return this.PANTALLA_LISTADO;
	}

	@Override
	public String buscar() throws Exception {
		lstEntr = new ArrayList<DtoHrEntrCas>();
		LOGGER.debug(this.getUsuarioActual().getIdPersona());
		List<DtoHrEntrCas> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio()
				.listarHrEntrCas(getUsuarioActual().getIdPersona());
		if (UValidador.esNulo(lstDatosFull))
			lstDatosFull = new ArrayList<DtoHrEntrCas>();
		LOGGER.debug("LISTA DE ENCUESTA " + lstDatosFull.size());
		for (int i = 0; i < lstDatosFull.size(); i++) {
			lstEntr.add(lstDatosFull.get(i));
		}
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

	public List<DtoHrEntrCas> getLstEntr() {
		return lstEntr;
	}

	public void setLstEntr(List<DtoHrEntrCas> lstEntr) {
		this.lstEntr = lstEntr;
	}

	public DtoHrEntrCas getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(DtoHrEntrCas registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public List<DtoHrEntrCasPost> getLstEntrPost() {
		return lstEntrPost;
	}

	public void setLstEntrPost(List<DtoHrEntrCasPost> lstEntrPost) {
		this.lstEntrPost = lstEntrPost;
	}

	public DtoHrEntrCasPost getRegistroSeleccionadoPost() {
		return registroSeleccionadopost;
	}

	public void setRegistroSeleccionadopost(DtoHrEntrCasPost registroSeleccionadopost) {
		this.registroSeleccionadopost = registroSeleccionadopost;
	}

	public List<DtoHrEntrCasPostEval> getLstEntrPostEval() {
		return lstEntrPostEval;
	}

	public void setLstEntrPostEval(List<DtoHrEntrCasPostEval> lstEntrPostEval) {
		this.lstEntrPostEval = lstEntrPostEval;
	}

	public List<DtoHrEntrCasPostEval> getLstPuntos() {
		return lstPuntos;
	}

	public void setLstPuntos(List<DtoHrEntrCasPostEval> lstPuntos) {
		this.lstPuntos = lstPuntos;
	}

	public List<DtoHrEntrCasPostEval> getLstPuntosEscala() {
		return lstPuntosEscala;
	}

	public void setLstPuntosEscala(List<DtoHrEntrCasPostEval> lstPuntosEscala) {
		this.lstPuntosEscala = lstPuntosEscala;
	}

	public String ingresar() throws Exception {
		String pagina = "";
		String rpta = "";
		List<DtoHrEntrCasPostEval> lstDatos = this.getFacRrhh().getHrEncuestaServicio()
				.validarIngreso(registroSeleccionado.getRequerimiento());
		for (int i = 0; i < lstDatos.size(); i++) {
			rpta = lstDatos.get(i).getEstado();
		}

		if (rpta.equals("0")) {
			this.setMessageSuccess("Aún no inicia la primera entrevista del proceso");
			pagina = this.PANTALLA_LISTADO;
		} else {
			this.setAccionPantalla(accion_solicitada.EDITAR);
			lstEntrPost = new ArrayList<DtoHrEntrCasPost>();
			List<DtoHrEntrCasPost> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio()
					.ingresarHrEntrCas(registroSeleccionado.getRequerimiento(), getUsuarioActual().getCodigoUsuario());
			if (UValidador.esNulo(lstDatosFull))
				lstDatosFull = new ArrayList<DtoHrEntrCasPost>();
			LOGGER.debug("LISTA DE ENCUESTA " + lstDatosFull.size());
			for (int i = 0; i < lstDatosFull.size(); i++) {
				lstEntrPost.add(lstDatosFull.get(i));
			}
			List<DtoHrEntrCasPostEval> lstDatosFull3 = this.getFacRrhh().getHrEncuestaServicio()
					.validaPuntos(registroSeleccionado.getRequerimiento(), getUsuarioActual().getCodigoUsuario());
			for (int i = 0; i < lstDatosFull3.size(); i++) {
				valRegistro = lstDatosFull3.get(i).getN_estado();
				proceso = lstDatosFull3.get(i).getConvocatoria();
				puesto = lstDatosFull3.get(i).getPuesto();
				flagtipopuesto = lstDatosFull3.get(i).getFlagtipopuesto();
				flg_estado = lstDatosFull3.get(i).getEstado();
			}
			pagina = this.PANTALLA_POSTULANTES;
		}
		return pagina;
	}

	public String ingresarPost() throws Exception {
		this.setAccionPantalla(accion_solicitada.EDITAR);

		lstEntrPostEval = new ArrayList<DtoHrEntrCasPostEval>();
		System.out.println("Requ: " + registroSeleccionado.getRequerimiento());
		System.out.println("User: " + getUsuarioActual().getCodigoUsuario());
		System.out.println("PostIng: " + registroSeleccionadopost.getIdpostulante());
		idpostulante = registroSeleccionadopost.getIdpostulante();

		List<DtoHrEntrCasPostEval> lstDatosFull3 = this.getFacRrhh().getHrEncuestaServicio().verBotones(
				registroSeleccionado.getRequerimiento(), getUsuarioActual().getCodigoUsuario(),
				registroSeleccionadopost.getIdpostulante());
		for (int i = 0; i < lstDatosFull3.size(); i++) {
			valRegistro = lstDatosFull3.get(i).getN_estado();
			enviado = lstDatosFull3.get(i).getEstado();
			visible = lstDatosFull3.get(i).getVisible().equals("1") ? true : false;
			System.out.println("Dato1: " + valRegistro);
			System.out.println("Dato2: " + enviado);
			System.out.println("Dato3: " + visible);
			/*
			 * if (valRegistro.equals("0") || enviado.equals("0")) {
			 * System.out.println("Entro"); setVisible(true); }
			 */
			nextPost = lstDatosFull3.get(i).getNext_po();
			System.out.println("Dato2: " + nextPost);
			nspPost = lstDatosFull3.get(i).getFlg_nsp();
			proceso = lstDatosFull3.get(i).getConvocatoria();
			puesto = lstDatosFull3.get(i).getPuesto();
			flagtipopuesto = lstDatosFull3.get(i).getFlagtipopuesto();
			nompostulante = lstDatosFull3.get(i).getNompostulante();
			puntaje = lstDatosFull3.get(i).getPuntaje();
		}

		lstPuntos = new ArrayList<DtoHrEntrCasPostEval>();
		List<DtoHrEntrCasPostEval> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio()
				.listarPuntaje(flagtipopuesto, registroSeleccionado.getRequerimiento());
		if (UValidador.esNulo(lstDatosFull))
			lstDatosFull = new ArrayList<DtoHrEntrCasPostEval>();
		LOGGER.debug("LISTA DE ENCUESTA " + lstDatosFull.size());
		for (int i = 0; i < lstDatosFull.size(); i++) {
			lstPuntos.add(lstDatosFull.get(i));
		}

		lstPuntosEscala = new ArrayList<DtoHrEntrCasPostEval>();
		List<DtoHrEntrCasPostEval> lstDatosEscala = this.getFacRrhh().getHrEncuestaServicio()
				.listarPuntajeEscala(flagtipopuesto, registroSeleccionado.getRequerimiento());
		if (UValidador.esNulo(lstDatosEscala))
			lstDatosEscala = new ArrayList<DtoHrEntrCasPostEval>();
		LOGGER.debug("LISTA DE ENCUESTA " + lstDatosFull.size());
		for (int i = 0; i < lstDatosEscala.size(); i++) {
			lstPuntosEscala.add(lstDatosEscala.get(i));
		}

		List<DtoHrEntrCasPostEval> lstDatosFull2 = this.getFacRrhh().getHrEncuestaServicio().listarAptitud(
				registroSeleccionado.getRequerimiento(), getUsuarioActual().getCodigoUsuario(),
				registroSeleccionadopost.getIdpostulante(), flagtipopuesto);
		if (UValidador.esNulo(lstDatosFull2))
			lstDatosFull2 = new ArrayList<DtoHrEntrCasPostEval>();
		LOGGER.debug("LISTA DE ENCUESTA " + lstDatosFull2.size());
		for (int i = 0; i < lstDatosFull2.size(); i++) {
			lstEntrPostEval.add(lstDatosFull2.get(i));
		}

		listaPuntos = this.getFacRrhh().getHrEncuestaServicio().listarPuntaje(flagtipopuesto,
				registroSeleccionado.getRequerimiento());

		return this.PANTALLA_EVALUACION;
	}

	public String nextPst(String Postulante) throws Exception {
		this.setAccionPantalla(accion_solicitada.EDITAR);

		lstEntrPostEval = new ArrayList<DtoHrEntrCasPostEval>();
		System.out.println("Requ: " + registroSeleccionado.getRequerimiento());
		System.out.println("User: " + getUsuarioActual().getCodigoUsuario());
		System.out.println("Post: " + Postulante);

		idpostulante = Postulante;
		List<DtoHrEntrCasPostEval> lstDatosFull3 = this.getFacRrhh().getHrEncuestaServicio()
				.verBotones(registroSeleccionado.getRequerimiento(), getUsuarioActual().getCodigoUsuario(), Postulante);
		for (int i = 0; i < lstDatosFull3.size(); i++) {
			valRegistro = lstDatosFull3.get(i).getN_estado();
			enviado = lstDatosFull3.get(i).getEstado();
			visible = lstDatosFull3.get(i).getVisible().equals("1") ? true : false;
			System.out.println("Dato1: " + valRegistro);
			System.out.println("Dato2: " + enviado);
			System.out.println("Dato3: " + visible);
			/*
			 * if (valRegistro.equals("0") || enviado.equals("0")) {
			 * setVisible(true); }
			 */
			nextPost = lstDatosFull3.get(i).getNext_po();
			nspPost = lstDatosFull3.get(i).getFlg_nsp();
			proceso = lstDatosFull3.get(i).getConvocatoria();
			puesto = lstDatosFull3.get(i).getPuesto();
			flagtipopuesto = lstDatosFull3.get(i).getFlagtipopuesto();
			nompostulante = lstDatosFull3.get(i).getNompostulante();
			puntaje = lstDatosFull3.get(i).getPuntaje();
		}

		lstPuntos = new ArrayList<DtoHrEntrCasPostEval>();
		List<DtoHrEntrCasPostEval> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio()
				.listarPuntaje(flagtipopuesto, registroSeleccionado.getRequerimiento());
		if (UValidador.esNulo(lstDatosFull))
			lstDatosFull = new ArrayList<DtoHrEntrCasPostEval>();
		LOGGER.debug("LISTA DE ENCUESTA " + lstDatosFull.size());
		for (int i = 0; i < lstDatosFull.size(); i++) {
			lstPuntos.add(lstDatosFull.get(i));
		}

		List<DtoHrEntrCasPostEval> lstDatosFull2 = this.getFacRrhh().getHrEncuestaServicio().listarAptitud(
				registroSeleccionado.getRequerimiento(), getUsuarioActual().getCodigoUsuario(), Postulante,
				flagtipopuesto);
		if (UValidador.esNulo(lstDatosFull2))
			lstDatosFull2 = new ArrayList<DtoHrEntrCasPostEval>();
		LOGGER.debug("LISTA DE ENCUESTA " + lstDatosFull2.size());
		for (int i = 0; i < lstDatosFull2.size(); i++) {
			lstEntrPostEval.add(lstDatosFull2.get(i));
		}

		System.out.println("nspPost: " + nspPost);
		System.out.println("nextPost: " + nextPost);
		// if (nextPost.equals("0") || nspPost.equals("0")){
		// return this.ingresar();
		// }else{
		return this.PANTALLA_EVALUACION;
		// }
	}

	public String getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(String puntaje) {
		this.puntaje = puntaje;
	}

	public String getPunto() {
		return punto;
	}

	public void setPunto(String punto) {
		this.punto = punto;
	}

	public String getValRegistro() {
		return valRegistro;
	}

	public void setValRegistro(String valRegistro) {
		this.valRegistro = valRegistro;
	}

	public String getEnviado() {
		return enviado;
	}

	public void setEnviado(String enviado) {
		this.enviado = enviado;
	}

	public String getNextPost() {
		return nextPost;
	}

	public void setNextPost(String nextPost) {
		this.nextPost = nextPost;
	}

	public String getNspPost() {
		return nspPost;
	}

	public void setNspPost(String nspPost) {
		this.nspPost = nspPost;
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

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getNompostulante() {
		return nompostulante;
	}

	public void setNompostulante(String nompostulante) {
		this.nompostulante = nompostulante;
	}

	public String getFlg_estado() {
		return flg_estado;
	}

	public void setFlg_estado(String flg_estado) {
		this.flg_estado = flg_estado;
	}

	public String getN_estado() {
		return n_estado;
	}

	public void setN_estado(String n_estado) {
		this.n_estado = n_estado;
	}

	public String getTipo_sg() {
		return tipo_sg;
	}

	public void setTipo_sg(String tipo_sg) {
		this.tipo_sg = tipo_sg;
	}

	public String getTipo_au() {
		return tipo_au;
	}

	public void setTipo_au(String tipo_au) {
		this.tipo_au = tipo_au;
	}

	public String getTipo_rh() {
		return tipo_rh;
	}

	public void setTipo_rh(String tipo_rh) {
		this.tipo_rh = tipo_rh;
	}

	public String getTipo_oa() {
		return tipo_oa;
	}

	public void setTipo_oa(String tipo_oa) {
		this.tipo_oa = tipo_oa;
	}

	public String getTipo_pd() {
		return tipo_pd;
	}

	public void setTipo_pd(String tipo_pd) {
		this.tipo_rh = tipo_pd;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getIdpostulante() {
		return idpostulante;
	}

	public void setIdpostulante(String idpostulante) {
		this.idpostulante = idpostulante;
	}

	public String getIdreq() {
		return idreq;
	}

	public void setIdreq(String idreq) {
		this.idreq = idreq;
	}

	public String getIdpst() {
		return idpst;
	}

	public void setIdpst(String idpst) {
		this.idpst = idpst;
	}

	public boolean getVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getSumtipo_sg() {
		return sumtipo_sg;
	}

	public void setSumtipo_sg(String sumtipo_sg) {
		this.sumtipo_sg = sumtipo_sg;
	}

	public String getSumtipo_pd() {
		return sumtipo_pd;
	}

	public void setSumtipo_pd(String sumtipo_pd) {
		this.sumtipo_pd = sumtipo_pd;
	}

	public String getSumtipo_oa() {
		return sumtipo_oa;
	}

	public void setSumtipo_oa(String sumtipo_oa) {
		this.sumtipo_oa = sumtipo_oa;
	}

	public String getSumtipo_au() {
		return sumtipo_au;
	}

	public void setSumtipo_au(String sumtipo_au) {
		this.sumtipo_au = sumtipo_au;
	}

	public String getSumtipo_rh() {
		return sumtipo_rh;
	}

	public void setSumtipo_rh(String sumtipo_rh) {
		this.sumtipo_rh = sumtipo_rh;
	}

	public String getPromedio() {
		return promedio;
	}

	public void setPromedio(String promedio) {
		this.promedio = promedio;
	}

	public List<DtoHrEntrCasPostEval> getListaPuntos() {
		if (listaPuntos == null) {
			listaPuntos = this.getFacRrhh().getHrEncuestaServicio().listarPuntaje(flagtipopuesto,
					registroSeleccionado.getRequerimiento());
		}
		return listaPuntos;
	}

	public void setListaPuntos(List<DtoHrEntrCasPostEval> listaPuntos) {
		this.listaPuntos = listaPuntos;
	}

	public String registrarPuntaje() throws Exception {
		String mensaje = "";
		System.out.println("Requ: " + registroSeleccionado.getRequerimiento());
		System.out.println("User: " + getUsuarioActual().getCodigoUsuario());
		List<DtoHrEntrCasPostEval> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio()
				.validaPuntos(registroSeleccionado.getRequerimiento(), getUsuarioActual().getCodigoUsuario());
		for (int i = 0; i < lstDatosFull.size(); i++) {
			valRegistro = lstDatosFull.get(i).getN_estado();
		}

		System.out.println("User: " + valRegistro);
		if (valRegistro.equals("0") || valRegistro.equals("2")) {
			this.getFacRrhh().getHrEncuestaServicio().enviarPuntaje(registroSeleccionado.getRequerimiento(),
					getUsuarioActual().getCodigoUsuario());
			mensaje = "Se ha enviado la información!";
			List<DtoHrEntrCas> lstDatosFull2 = this.getFacRrhh().getHrEncuestaServicio()
					.validarClose(registroSeleccionado.getRequerimiento());
			for (int i = 0; i < lstDatosFull2.size(); i++) {
				n_estado = lstDatosFull2.get(i).getN_estado();
			}
			if (n_estado.equals("4")) {
				this.getFacRrhh().getHrEncuestaServicio().cerrarHrEntrCas(registroSeleccionado.getRequerimiento());
				mensaje = "Se ha cerrado el proceso de entrevista";
			}
		} else {
			mensaje = "No ha ingresado puntaje en todas las aptitudes!";
		}
		this.buscar();
		this.setMessageSuccess(mensaje);
		return this.PANTALLA_LISTADO;
	}

	public String cerrar() throws Exception {
		this.setAccionPantalla(accion_solicitada.EDITAR);
		List<DtoHrEntrCas> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio()
				.validaCierreProceso(registroSeleccionado.getRequerimiento());
		for (int i = 0; i < lstDatosFull.size(); i++) {
			valRegistro = lstDatosFull.get(i).getN_estado();
		}
		if (valRegistro.equals("0")) {
			this.getFacRrhh().getHrEncuestaServicio().cerrarHrEntrCas(registroSeleccionado.getRequerimiento());
			this.setMessageSuccess("Se ha cerrado el proceso de entrevista");
			this.buscar();
		} else if (valRegistro.equals("1")) {
			this.setMessageSuccess("No se ha calificado todos los criterios");
		} else if (valRegistro.equals("2")) {
			this.setMessageSuccess("No se ha enviado todas las puntuaciones");
		}
		return this.PANTALLA_LISTADO;
	}

	public String NSP() throws Exception {
		System.out.println("Req" + idpostulante);
		this.setAccionPantalla(accion_solicitada.EDITAR);
		this.getFacRrhh().getHrEncuestaServicio().nspHrEntrCasPost(registroSeleccionado.getRequerimiento(),
				idpostulante);
		this.setMessageSuccess("Se ha colocado a este Postulante No Se Presento");
		return this.ingresar();
	}

	public String resetNSP() throws Exception {
		this.setAccionPantalla(accion_solicitada.EDITAR);
		this.getFacRrhh().getHrEncuestaServicio().nspHrEntrCasPost2(registroSeleccionado.getRequerimiento(),
				registroSeleccionadopost.getIdpostulante());
		this.ingresar();
		this.setMessageSuccess("Se ha restaurado la presencia del Postulante");
		return this.PANTALLA_POSTULANTES;
	}

	public String reportexPost() throws Exception {
		System.out.println("Req" + registroSeleccionado.getRequerimiento());

		secuencia = 5;
		// OBTENEMOS EL TIPO DE PUESTO Y LA SECUENCIA
		List<DtoHrRequerimientoSeguimiento> res = getFacRrhh().getHrRequerimientoServicio()
				.listarFlagTipoSecuencia(registroSeleccionado.getRequerimiento(), 4);
		if (!UValidador.esListaVacia(res)) {
			secuencia = res.get(0).getSecuencia().intValue();
			flagtipopuesto = res.get(0).getFlagTipopuesto();
		}

		List<DtoHrEntrCasPostEval> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio()
				.verEntrevistadores(registroSeleccionado.getRequerimiento(), secuencia);
		for (int i = 0; i < lstDatosFull.size(); i++) {
			if (UValidador.estaVacio(tipo_sg) || "0".equals(tipo_sg)) {
				tipo_sg = lstDatosFull.get(i).getTipo_sg();
			}
			if (UValidador.estaVacio(tipo_au) || "0".equals(tipo_au)) {
				tipo_au = lstDatosFull.get(i).getTipo_au();
			}
			if (UValidador.estaVacio(tipo_rh) || "0".equals(tipo_rh)) {
				tipo_rh = lstDatosFull.get(i).getTipo_rh();
			}
			if (UValidador.estaVacio(tipo_oa) || "0".equals(tipo_oa)) {
				tipo_oa = lstDatosFull.get(i).getTipo_oa();
			}
			if (UValidador.estaVacio(tipo_pd) || "0".equals(tipo_pd)) {
				tipo_pd = lstDatosFull.get(i).getTipo_pd();
			}
			if ("1".equals(tipo_sg) && "1".equals(lstDatosFull.get(i).getTipo_sg())) {
				nombre_tipo_sg = lstDatosFull.get(i).getNombreevaluadores();
			}
			if ("1".equals(tipo_au) && "1".equals(lstDatosFull.get(i).getTipo_au())) {
				nombre_tipo_au = lstDatosFull.get(i).getNombreevaluadores();
			}
			if ("1".equals(tipo_rh) && "1".equals(lstDatosFull.get(i).getTipo_rh())) {
				nombre_tipo_rh = lstDatosFull.get(i).getNombreevaluadores();
			}
			if ("1".equals(tipo_oa) && "1".equals(lstDatosFull.get(i).getTipo_oa())) {
				nombre_tipo_oa = lstDatosFull.get(i).getNombreevaluadores();
			}
			if ("1".equals(tipo_pd) && "1".equals(lstDatosFull.get(i).getTipo_pd())) {
				nombre_tipo_pd = lstDatosFull.get(i).getNombreevaluadores();
			}
		}
		System.out.println("Pst" + registroSeleccionadopost.getIdpostulante());
		lstEntrPostEval = new ArrayList<DtoHrEntrCasPostEval>();
		List<DtoHrEntrCasPostEval> lstDatosFull2 = this.getFacRrhh().getHrEncuestaServicio().verPuntosReportePost(
				registroSeleccionado.getRequerimiento(), registroSeleccionadopost.getIdpostulante(), flagtipopuesto);
		for (int i = 0; i < lstDatosFull2.size(); i++) {
			lstEntrPostEval.add(lstDatosFull2.get(i));
		}
		System.out.println("Pst" + registroSeleccionadopost.getIdpostulante());
		List<DtoHrEntrCasPostEval> lstDatos = this.getFacRrhh().getHrEncuestaServicio().verSumPuntosReportePost(
				registroSeleccionado.getRequerimiento(), registroSeleccionadopost.getIdpostulante());
		for (int i = 0; i < lstDatos.size(); i++) {
			sumtipo_sg = lstDatos.get(i).getSumtipo_sg();
			sumtipo_pd = lstDatos.get(i).getSumtipo_pd();
			sumtipo_oa = lstDatos.get(i).getSumtipo_oa();
			sumtipo_au = lstDatos.get(i).getSumtipo_au();
			sumtipo_rh = lstDatos.get(i).getSumtipo_rh();
			promedio = lstDatos.get(i).getPromedio();
		}
		System.out.println("Prueba");
		List<DtoHrEntrCasPostEval> lstDatosFull3 = this.getFacRrhh().getHrEncuestaServicio().verDatosReportePost(
				registroSeleccionado.getRequerimiento(), registroSeleccionadopost.getIdpostulante());
		for (int i = 0; i < lstDatosFull3.size(); i++) {
			nompostulante = lstDatosFull3.get(i).getNompostulante();
			puesto = lstDatosFull3.get(i).getPuesto();
			unidad = lstDatosFull3.get(i).getUnidad();
			fecha = lstDatosFull3.get(i).getFecha();
			proceso = lstDatosFull3.get(i).getConvocatoria();
			hora = lstDatosFull3.get(i).getHora();
		}
		return this.PANTALLA_REPORTE_02;
	}

	public String reportexProc() throws Exception {
		System.out.println("Req" + registroSeleccionado.getRequerimiento());
		secuencia = 5;
		// OBTENEMOS EL TIPO DE PUESTO Y LA SECUENCIA
		List<DtoHrRequerimientoSeguimiento> res = getFacRrhh().getHrRequerimientoServicio()
				.listarFlagTipoSecuencia(registroSeleccionado.getRequerimiento(), 4);
		if (!UValidador.esListaVacia(res)) {
			secuencia = res.get(0).getSecuencia().intValue();
			flagtipopuesto = res.get(0).getFlagTipopuesto();
		}

		List<DtoHrEntrCasPostEval> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio()
				.verEntrevistadores(registroSeleccionado.getRequerimiento(), secuencia);
		for (int i = 0; i < lstDatosFull.size(); i++) {
			if (UValidador.estaVacio(tipo_sg) || "0".equals(tipo_sg)) {
				tipo_sg = lstDatosFull.get(i).getTipo_sg();
			}
			if (UValidador.estaVacio(tipo_au) || "0".equals(tipo_au)) {
				tipo_au = lstDatosFull.get(i).getTipo_au();
			}
			if (UValidador.estaVacio(tipo_rh) || "0".equals(tipo_rh)) {
				tipo_rh = lstDatosFull.get(i).getTipo_rh();
			}
			if (UValidador.estaVacio(tipo_oa) || "0".equals(tipo_oa)) {
				tipo_oa = lstDatosFull.get(i).getTipo_oa();
			}
			if (UValidador.estaVacio(tipo_pd) || "0".equals(tipo_pd)) {
				tipo_pd = lstDatosFull.get(i).getTipo_pd();
			}
			if ("1".equals(tipo_sg) && "1".equals(lstDatosFull.get(i).getTipo_sg())) {
				nombre_tipo_sg = lstDatosFull.get(i).getNombreevaluadores();
			}
			if ("1".equals(tipo_au) && "1".equals(lstDatosFull.get(i).getTipo_au())) {
				nombre_tipo_au = lstDatosFull.get(i).getNombreevaluadores();
			}
			if ("1".equals(tipo_rh) && "1".equals(lstDatosFull.get(i).getTipo_rh())) {
				nombre_tipo_rh = lstDatosFull.get(i).getNombreevaluadores();
			}
			if ("1".equals(tipo_oa) && "1".equals(lstDatosFull.get(i).getTipo_oa())) {
				nombre_tipo_oa = lstDatosFull.get(i).getNombreevaluadores();
			}
			if ("1".equals(tipo_pd) && "1".equals(lstDatosFull.get(i).getTipo_pd())) {
				nombre_tipo_pd = lstDatosFull.get(i).getNombreevaluadores();
			}
		}
		System.out.println("Uno");
		lstEntrPostEval = new ArrayList<DtoHrEntrCasPostEval>();
		List<DtoHrEntrCasPostEval> lstDatosFull2 = this.getFacRrhh().getHrEncuestaServicio()
				.verPuntosReporteProc(registroSeleccionado.getRequerimiento());
		for (int i = 0; i < lstDatosFull2.size(); i++) {
			lstEntrPostEval.add(lstDatosFull2.get(i));
		}
		System.out.println("Dos");
		List<DtoHrEntrCasPostEval> lstDatosFull3 = this.getFacRrhh().getHrEncuestaServicio()
				.verDatosReporteProc(registroSeleccionado.getRequerimiento());
		for (int i = 0; i < lstDatosFull3.size(); i++) {
			puesto = lstDatosFull3.get(i).getPuesto();
			unidad = lstDatosFull3.get(i).getUnidad();
			fecha = lstDatosFull3.get(i).getFecha();
			proceso = lstDatosFull3.get(i).getConvocatoria();
			hora = lstDatosFull3.get(i).getHora();
		}
		return this.PANTALLA_REPORTE_01;
	}

	public void valueChanged(ValueChangeEvent e) throws Exception {
		String dato = e.getNewValue().toString();
		String datos[] = dato.split("-");
		String punto = datos[0];
		String aptitud = datos[1];
		System.out.println(punto);
		System.out.println(idpostulante);
		this.getFacRrhh().getHrEncuestaServicio().registrarPunto(registroSeleccionado.getRequerimiento(),
				getUsuarioActual().getCodigoUsuario(), idpostulante, aptitud, punto);
	}

	public void valueChangedConducta(ValueChangeEvent e) throws Exception {
		String dato = e.getNewValue().toString();
		String datos[] = dato.split("-");
		String punto = datos[0];
		String aptitud = datos[1];
		String conducta = datos[2];
		System.out.println(punto);
		System.out.println(idpostulante);
		System.out.println(aptitud);
		System.out.println(conducta);

		// RGISTRAMOS LA CONDUTA
		this.getFacRrhh().getHrEncuestaServicio().registrarPuntoConducta(registroSeleccionado.getRequerimiento(),
				getUsuarioActual().getCodigoUsuario(), idpostulante, aptitud, conducta, punto);

		BigDecimal sumaConductas = BigDecimal.ZERO;
		BigDecimal puntoAptitud = BigDecimal.ZERO;
		for (DtoHrEntrCasPostEval obj : lstEntrPostEval) {
			if (obj.getIdaptitud().equals(aptitud)) {
				for (DtoHrEntrCasPostEval con : obj.getLstConductas()) {
					if (con.getIdconducta().equals(conducta)) {
						con.setPuntaje(dato);
					}
					sumaConductas = sumaConductas.add(new BigDecimal(
							UValidador.estaVacio(con.getPuntaje()) ? "0" : con.getPuntaje().split("-")[0]));
					puntoAptitud = UFormula.porcentajeSuma(sumaConductas, obj.getPeso(), obj.getPuntajemaximo());
					obj.setPuntaje(puntoAptitud.intValue() + "");
				}
			}
		}

		// RGISTRAMOS LA APTITUD
		this.getFacRrhh().getHrEncuestaServicio().registrarPunto(registroSeleccionado.getRequerimiento(),
				getUsuarioActual().getCodigoUsuario(), idpostulante, aptitud, puntoAptitud.intValue() + "");
	}

	public String ReporteBlanco_01(String idrequerimiento) throws Exception {
		System.out.println("Req" + idrequerimiento);
		secuencia = 5;
		// OBTENEMOS EL TIPO DE PUESTO Y LA SECUENCIA
		List<DtoHrRequerimientoSeguimiento> res = getFacRrhh().getHrRequerimientoServicio()
				.listarFlagTipoSecuencia(idrequerimiento, 4);
		if (!UValidador.esListaVacia(res)) {
			secuencia = res.get(0).getSecuencia().intValue();
			flagtipopuesto = res.get(0).getFlagTipopuesto();
		}

		List<DtoHrEntrCasPostEval> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio()
				.verEntrevistadores(idrequerimiento, secuencia);
		for (int i = 0; i < lstDatosFull.size(); i++) {
			if (UValidador.estaVacio(tipo_sg) || "0".equals(tipo_sg)) {
				tipo_sg = lstDatosFull.get(i).getTipo_sg();
			}
			if (UValidador.estaVacio(tipo_au) || "0".equals(tipo_au)) {
				tipo_au = lstDatosFull.get(i).getTipo_au();
			}
			if (UValidador.estaVacio(tipo_rh) || "0".equals(tipo_rh)) {
				tipo_rh = lstDatosFull.get(i).getTipo_rh();
			}
			if (UValidador.estaVacio(tipo_oa) || "0".equals(tipo_oa)) {
				tipo_oa = lstDatosFull.get(i).getTipo_oa();
			}
			if (UValidador.estaVacio(tipo_pd) || "0".equals(tipo_pd)) {
				tipo_pd = lstDatosFull.get(i).getTipo_pd();
			}
			if ("1".equals(tipo_sg) && "1".equals(lstDatosFull.get(i).getTipo_sg())) {
				nombre_tipo_sg = lstDatosFull.get(i).getNombreevaluadores();
			}
			if ("1".equals(tipo_au) && "1".equals(lstDatosFull.get(i).getTipo_au())) {
				nombre_tipo_au = lstDatosFull.get(i).getNombreevaluadores();
			}
			if ("1".equals(tipo_rh) && "1".equals(lstDatosFull.get(i).getTipo_rh())) {
				nombre_tipo_rh = lstDatosFull.get(i).getNombreevaluadores();
			}
			if ("1".equals(tipo_oa) && "1".equals(lstDatosFull.get(i).getTipo_oa())) {
				nombre_tipo_oa = lstDatosFull.get(i).getNombreevaluadores();
			}
			if ("1".equals(tipo_pd) && "1".equals(lstDatosFull.get(i).getTipo_pd())) {
				nombre_tipo_pd = lstDatosFull.get(i).getNombreevaluadores();
			}
		}
		System.out.println("Uno");
		lstEntrPostEval = new ArrayList<DtoHrEntrCasPostEval>();
		List<DtoHrEntrCasPostEval> lstDatosFull2 = this.getFacRrhh().getHrEncuestaServicio()
				.verPuntosReporteProc(idrequerimiento);
		for (int i = 0; i < lstDatosFull2.size(); i++) {
			lstEntrPostEval.add(lstDatosFull2.get(i));
		}
		System.out.println("Dos");
		List<DtoHrEntrCasPostEval> lstDatosFull3 = this.getFacRrhh().getHrEncuestaServicio()
				.verDatosReporteProc(idrequerimiento);
		for (int i = 0; i < lstDatosFull3.size(); i++) {
			puesto = lstDatosFull3.get(i).getPuesto();
			unidad = lstDatosFull3.get(i).getUnidad();
			fecha = lstDatosFull3.get(i).getFecha();
			proceso = lstDatosFull3.get(i).getConvocatoria();
			hora = lstDatosFull3.get(i).getHora();
		}
		return this.PANTALLA_REPORTE_03;
	}

	public String ReporteBlanco_02(String idrequerimiento, String idpostulante) throws Exception {
		System.out.println("Req " + idrequerimiento);

		secuencia = 5;
		// OBTENEMOS EL TIPO DE PUESTO Y LA SECUENCIA
		List<DtoHrRequerimientoSeguimiento> res = getFacRrhh().getHrRequerimientoServicio()
				.listarFlagTipoSecuencia(idrequerimiento, 4);
		if (!UValidador.esListaVacia(res)) {
			secuencia = res.get(0).getSecuencia().intValue();
			flagtipopuesto = res.get(0).getFlagTipopuesto();
		}

		List<DtoHrEntrCasPostEval> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio()
				.verEntrevistadores(idrequerimiento, secuencia);
		for (int i = 0; i < lstDatosFull.size(); i++) {
			if (UValidador.estaVacio(tipo_sg) || "0".equals(tipo_sg)) {
				tipo_sg = lstDatosFull.get(i).getTipo_sg();
			}
			if (UValidador.estaVacio(tipo_au) || "0".equals(tipo_au)) {
				tipo_au = lstDatosFull.get(i).getTipo_au();
			}
			if (UValidador.estaVacio(tipo_rh) || "0".equals(tipo_rh)) {
				tipo_rh = lstDatosFull.get(i).getTipo_rh();
			}
			if (UValidador.estaVacio(tipo_oa) || "0".equals(tipo_oa)) {
				tipo_oa = lstDatosFull.get(i).getTipo_oa();
			}
			if (UValidador.estaVacio(tipo_pd) || "0".equals(tipo_pd)) {
				tipo_pd = lstDatosFull.get(i).getTipo_pd();
			}
			if ("1".equals(tipo_sg) && "1".equals(lstDatosFull.get(i).getTipo_sg())) {
				nombre_tipo_sg = lstDatosFull.get(i).getNombreevaluadores();
			}
			if ("1".equals(tipo_au) && "1".equals(lstDatosFull.get(i).getTipo_au())) {
				nombre_tipo_au = lstDatosFull.get(i).getNombreevaluadores();
			}
			if ("1".equals(tipo_rh) && "1".equals(lstDatosFull.get(i).getTipo_rh())) {
				nombre_tipo_rh = lstDatosFull.get(i).getNombreevaluadores();
			}
			if ("1".equals(tipo_oa) && "1".equals(lstDatosFull.get(i).getTipo_oa())) {
				nombre_tipo_oa = lstDatosFull.get(i).getNombreevaluadores();
			}
			if ("1".equals(tipo_pd) && "1".equals(lstDatosFull.get(i).getTipo_pd())) {
				nombre_tipo_pd = lstDatosFull.get(i).getNombreevaluadores();
			}
		}
		System.out.println("Pst " + idpostulante);
		lstEntrPostEval = new ArrayList<DtoHrEntrCasPostEval>();
		List<DtoHrEntrCasPostEval> lstDatosFull2 = this.getFacRrhh().getHrEncuestaServicio()
				.verPuntosReportePost(idrequerimiento, idpostulante, flagtipopuesto);
		for (int i = 0; i < lstDatosFull2.size(); i++) {
			lstEntrPostEval.add(lstDatosFull2.get(i));
		}
		List<DtoHrEntrCasPostEval> lstDatos = this.getFacRrhh().getHrEncuestaServicio()
				.verSumPuntosReportePost(idrequerimiento, idpostulante);
		for (int i = 0; i < lstDatos.size(); i++) {
			sumtipo_sg = lstDatos.get(i).getSumtipo_sg();
			sumtipo_pd = lstDatos.get(i).getSumtipo_pd();
			sumtipo_oa = lstDatos.get(i).getSumtipo_oa();
			sumtipo_au = lstDatos.get(i).getSumtipo_au();
			sumtipo_rh = lstDatos.get(i).getSumtipo_rh();
			promedio = lstDatos.get(i).getPromedio();
		}
		List<DtoHrEntrCasPostEval> lstDatosFull3 = this.getFacRrhh().getHrEncuestaServicio()
				.verDatosReportePost(idrequerimiento, idpostulante);
		for (int i = 0; i < lstDatosFull3.size(); i++) {
			nompostulante = lstDatosFull3.get(i).getNompostulante();
			puesto = lstDatosFull3.get(i).getPuesto();
			unidad = lstDatosFull3.get(i).getUnidad();
			fecha = lstDatosFull3.get(i).getFecha();
			proceso = lstDatosFull3.get(i).getConvocatoria();
			hora = lstDatosFull3.get(i).getHora();
			puntaje = lstDatosFull3.get(i).getPuntaje();
		}
		return this.PANTALLA_REPORTE_04;
	}

	public String getFlagtipopuesto() {
		return flagtipopuesto;
	}

	public void setFlagtipopuesto(String flagtipopuesto) {
		this.flagtipopuesto = flagtipopuesto;
	}

	public String getNombre_tipo_sg() {
		return nombre_tipo_sg;
	}

	public void setNombre_tipo_sg(String nombre_tipo_sg) {
		this.nombre_tipo_sg = nombre_tipo_sg;
	}

	public String getNombre_tipo_au() {
		return nombre_tipo_au;
	}

	public void setNombre_tipo_au(String nombre_tipo_au) {
		this.nombre_tipo_au = nombre_tipo_au;
	}

	public String getNombre_tipo_rh() {
		return nombre_tipo_rh;
	}

	public void setNombre_tipo_rh(String nombre_tipo_rh) {
		this.nombre_tipo_rh = nombre_tipo_rh;
	}

	public String getNombre_tipo_pd() {
		return nombre_tipo_pd;
	}

	public void setNombre_tipo_pd(String nombre_tipo_pd) {
		this.nombre_tipo_pd = nombre_tipo_pd;
	}

	public String getNombre_tipo_oa() {
		return nombre_tipo_oa;
	}

	public void setNombre_tipo_oa(String nombre_tipo_oa) {
		this.nombre_tipo_oa = nombre_tipo_oa;
	}

}