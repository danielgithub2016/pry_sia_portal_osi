package net.royal.erp.rrhh.servicio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.royal.erp.rrhh.dominio.dto.DtoHrEncuesta;
import net.royal.erp.rrhh.dominio.dto.DtoHrEntrCas;
import net.royal.erp.rrhh.dominio.dto.DtoHrEntrCasPost;
import net.royal.erp.rrhh.dominio.dto.DtoHrEntrCasPostEval;
import net.royal.erp.rrhh.dominio.dto.DtoHrEvalCas;
import net.royal.erp.rrhh.dominio.dto.DtoTipoPlanilla;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrEncuestaServicio extends GenericoServicio {
	public List<DtoHrEncuesta> listarHrEncuesta(String estado, Date fecha, Integer sujeto);

	public List<DtoTipoPlanilla> listaTipoPlanilla();

	public List<DtoHrEvalCas> listarHrEvalCas();

	public List<DtoHrEvalCas> listarHrEvalCas2(String convocatoria, String despuesto);

	public List<DtoHrEvalCas> listarHrEvalFIFA(Integer empleado);

	public List<DtoHrEvalCas> listarHrEvalFIFA2(String convocatoria, String despuesto, Integer empleado);

	public List<DtoHrEvalCas> valCierreHrEvalCas(String evalcas);

	public List<DtoHrEvalCas> valInicioHrEvalCas(String evalcas);

	public void editarHrEvalCas(String requerimiento, String evalcas);

	public void finalizarHrEvalCas(String requerimiento, String evalcas);

	public List<DtoHrEntrCasPost> verPostulantesHrEvalCas(String id_evalcas, Boolean incluirFoto, Integer cantidad);

	public List<DtoHrEntrCasPost> verPostulantesHrEvalCas2(String id_evalcas, Boolean incluirFoto, Integer cantidad);

	public List<DtoHrEntrCasPost> obtenerFotosPostulantes(List<DtoHrEntrCasPost> lista, Integer inicio, Integer fin);

	public List<DtoHrEntrCasPostEval> datosProceso(String requerimiento);

	public List<DtoHrEntrCas> listarHrEntrCas(Integer sujeto);

	public List<DtoHrEntrCasPost> ingresarHrEntrCas(String requerimiento, String usuario);

	public List<DtoHrEntrCasPostEval> listarPuntaje(String flagtipopuesto, String requerimiento);

	public List<DtoHrEntrCasPostEval> listarPuntajeEscala(String flagtipopuesto, String requerimiento);

	public List<DtoHrEvalCas> listarAsistencia();

	public List<DtoHrEntrCasPostEval> listarAptitud(String requerimiento, String usuario, String postulante,
			String flagtipopuesto);

	public List<DtoHrEntrCasPostEval> validaPuntos(String requerimiento, String usuario);

	public List<DtoHrEntrCas> validaCierreProceso(String requerimiento);

	public List<DtoHrEntrCasPostEval> validarIngreso(String requerimiento);

	public void enviarPuntaje(String requerimiento, String usuario);

	public void cerrarHrEntrCas(String requerimiento);

	public void nspHrEntrCasPost(String requerimiento, String postulante);

	public void nspHrEntrCasPost2(String requerimiento, String postulante);

	public List<DtoHrEntrCasPostEval> verBotones(String requerimiento, String usuario, String postulante);

	public List<DtoHrEntrCasPostEval> verDatosReportePost(String requerimiento, String postulante);

	public List<DtoHrEntrCasPostEval> verPuntosReportePost(String requerimiento, String postulante, String tipopuesto);

	public List<DtoHrEntrCasPostEval> verSumPuntosReportePost(String requerimiento, String postulante);

	public List<DtoHrEntrCasPostEval> verEntrevistadores(String requerimiento, Integer secuencia);

	public List<DtoHrEntrCasPostEval> verDatosReporteProc(String requerimiento);

	public List<DtoHrEntrCasPostEval> verPuntosReporteProc(String requerimiento);

	public void registrarPunto(String requerimiento, String usuario, String postulante, String aptitud, String punto);

	public void registrarPuntoConducta(String requerimiento, String usuario, String postulante, String aptitud,
			String conducta, String punto);

	public void registrarAsistencia(String requerimiento, String postulante, String asistencia);

	public void registrarAsistencia2(String requerimiento, String idevalcas);

	public List<DtoHrEntrCas> validarClose(String requerimiento);

	public List<DtoHrEvalCas> listarHrEvalCeu(Integer empleado);

	public List<DtoHrEvalCas> listarHrEvalCeu2(String convocatoria, String despuesto, Integer empleado);

	public List<DtoHrEvalCas> valInicioHrEvalCeu(DtoHrEvalCas dtoHrEvalCas);

	public List<DtoHrEvalCas> valCierreHrEvalCeu(String evalcas);

	public void editarHrEvalCeu(DtoHrEvalCas dtoHrEvalCas);

	public void finalizarHrEvalCeu(String requerimiento, String evalcas);

	public List<DtoHrEntrCasPost> verPostulantesHrEvalCeu(DtoHrEvalCas id_evalcas);

	public List<DtoHrEntrCasPost> verPostulantesHrEvalCeu2(DtoHrEvalCas id_evalcas);

	public List<DtoHrEntrCasPostEval> datosProcesoCeu(DtoHrEvalCas obj);

	public void registrarAsistenciaCeu(String requerimiento, String postulante, String asistencia);

	public void registrarAsistencia2Ceu(String requerimiento, String idevalcas);

	public void actualizarMinutos(String requerimiento, String postulante, Integer minutos);

	public void actualizarSession(String aplicacioncodigo, String codigo1, String codigo2, String ultimousuario,
			String estado);

	public Integer obtenerDurExamen(String parflgTipoPuesto);

	public DtoHrEntrCasPost datosPostulanteExamen(String id_evalcas, String postulante);

	public void actualizarMinutosCEU(String requerimiento, String postulante, Integer minutos);

	public DtoHrEntrCasPost datosPostulanteExamenCEU(String id_evalcas, String postulante);

	public void actualizarIntentosEvaluacionPostulanteCeu(String idpostulante, String idevalcas, BigDecimal intentos);

	public List<DtoHrEvalCas> listarSalaPorPersonaCeu(Integer idPersona, String id_evalcas);

	public List<DtoHrEntrCasPost> verPostulantesSalaHrEvalCeu(DtoHrEvalCas dtoHrEvalCas, Boolean incluirFoto,
			Integer cantidad, String documento);

	public List<DtoHrEntrCasPost> verPostulantesSalaHrEvalCeu2(DtoHrEvalCas dtoHrEvalCas, Boolean incluirFoto,
			Integer cantidad, String documento);

	public List<DtoHrEvalCas> listarHrEvalSalaCeu(String convocatoria, String despuesto, Integer empleado);

	public List<DtoHrEvalCas> listarHrEvalSalaFIFA(String convocatoria, String despuesto, Integer empleado);

	public List<DtoHrEvalCas> valInicioHrEvalFIFA(DtoHrEvalCas dtoHrEvalCas);

	public void editarHrEvalFIFA(DtoHrEvalCas dtoHrEvalCas);

	public void finalizarHrEvalFIFA(String requerimiento, String evalcas);

	public List<DtoHrEntrCasPost> verPostulantesHrEvalFIFA(DtoHrEvalCas id_evalcas);

	public List<DtoHrEntrCasPost> verPostulantesHrEvalFIFA2(DtoHrEvalCas obj);

	public List<DtoHrEntrCasPost> verPostulantesSalaHrEvalFIFA(DtoHrEvalCas dtoHrEvalCas, Boolean incluirFoto,
			Integer cantidad, String documento);

	public List<DtoHrEntrCasPost> verPostulantesSalaHrEvalFIFA2(DtoHrEvalCas dtoHrEvalCas, Boolean incluirFoto,
			Integer cantidad, String documento);

	public List<DtoHrEntrCasPostEval> listarSession(String aplicacioncodigo, String codigo1, String codigo2,
			String proceso);
}