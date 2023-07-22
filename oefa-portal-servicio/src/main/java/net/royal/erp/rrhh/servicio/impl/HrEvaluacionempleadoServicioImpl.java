package net.royal.erp.rrhh.servicio.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.erp.core.dao.EmpleadomastDao;
import net.royal.erp.core.dao.MaMiscelaneosdetalleDao;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dao.HrDetalleevaluacionDao;
import net.royal.erp.rrhh.dao.HrDetalleevaluacionmejoraDao;
import net.royal.erp.rrhh.dao.HrDncSolicitanteDao;
import net.royal.erp.rrhh.dao.HrEmpleadocomentariosDao;
import net.royal.erp.rrhh.dao.HrEmpleadoconsiderapotencialDao;
import net.royal.erp.rrhh.dao.HrEmpleadodesempenoDao;
import net.royal.erp.rrhh.dao.HrEmpleadofuncionDao;
import net.royal.erp.rrhh.dao.HrEmpleadometasDao;
import net.royal.erp.rrhh.dao.HrEmpleadonecesidadcapacitaDao;
import net.royal.erp.rrhh.dao.HrEmpleadorevisionDao;
import net.royal.erp.rrhh.dao.HrEvaluacioncandidatohistDao;
import net.royal.erp.rrhh.dao.HrEvaluacionempleadoDao;
import net.royal.erp.rrhh.dao.HrMeritosfaltasDao;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacion;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacionmejora;
import net.royal.erp.rrhh.dominio.HrDncSolicitante;
import net.royal.erp.rrhh.dominio.HrDncSolicitantePk;
import net.royal.erp.rrhh.dominio.HrEmpleadocomentarios;
import net.royal.erp.rrhh.dominio.HrEmpleadoconsiderapotencial;
import net.royal.erp.rrhh.dominio.HrEmpleadodesempeno;
import net.royal.erp.rrhh.dominio.HrEmpleadofuncion;
import net.royal.erp.rrhh.dominio.HrEmpleadometas;
import net.royal.erp.rrhh.dominio.HrEmpleadonecesidadcapacita;
import net.royal.erp.rrhh.dominio.HrEmpleadorevision;
import net.royal.erp.rrhh.dominio.HrEvaluacionempleado;
import net.royal.erp.rrhh.dominio.HrEvaluacionempleadoPk;
import net.royal.erp.rrhh.dominio.dto.DtoHrDetalleEvaluacion;
import net.royal.erp.rrhh.dominio.dto.DtoPuestoCapacitacion;
import net.royal.erp.rrhh.dominio.dto.OwHrEvaluacionempleadoEdit;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacionDetailP;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacionEdit;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadonecesidadcapacitaEdit;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrIncidentecriticoList;
import net.royal.erp.rrhh.servicio.HrEvaluacionempleadoServicio;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeUsuario;
import net.royal.framework.web.dominio.MensajeUsuario.tipo_mensaje;
import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioHrEvaluacionempleado")
public class HrEvaluacionempleadoServicioImpl extends GenericoServicioImpl implements HrEvaluacionempleadoServicio {

	private HrEvaluacionempleadoDao dao;
	private HrDetalleevaluacionDao daoHrDetalleevaluacion;
	private HrMeritosfaltasDao daoHrMeritosfaltas;
	private HrEmpleadodesempenoDao daoHrEmpleadodesempeno;
	private HrEmpleadometasDao daoHrEmpleadometas;
	private HrEmpleadonecesidadcapacitaDao daoHrEmpleadonecesidadcapacita;
	private HrEmpleadoconsiderapotencialDao daoHrEmpleadoconsiderapotencial;
	private HrEmpleadofuncionDao daoHrEmpleadofuncion;
	private HrEmpleadorevisionDao daoHrEmpleadorevision;
	private HrEmpleadocomentariosDao daoHrEmpleadocomentarios;
	private HrDetalleevaluacionmejoraDao daoHrDetalleevaluacionmejora;
	private EmpleadomastDao daoEmpleadomast;
	private HrDncSolicitanteDao daoHrDncSolicitante;
	private HrEvaluacioncandidatohistDao daoHrEvaluacioncandidatohist;
	private MaMiscelaneosdetalleDao daoMaMiscelaneosDetalle;

	private static Log LOGGER = LogFactory.getLog(HrEvaluacionempleadoServicioImpl.class);

	@Autowired
	public void setDao(HrEvaluacionempleadoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public void actualizaEvaluacionEmpleado(Integer empleado, Integer secuenciaeval) {
		dao.actualizaEvaluacionEmpleado(empleado, secuenciaeval);
	}

	@Override
	public HrEvaluacionempleado obtenerPorPkEvaluadorDiferente(HrEvaluacionempleadoPk pk) {
		return dao.obtenerPorPkEvaluadorDiferente(pk);
	}

	@Override
	@Transactional
	public void grabarTodaEvaluacion(DtoDwHrEmpleadoevaluacionEdit dw_evaluacion, StrPass strpass,
			List<DtoHrDetalleEvaluacion> dw1, List<DtoDwHrIncidentecriticoList> dw3, List<HrEmpleadodesempeno> dw5,
			List<HrEmpleadometas> dw6, List<DtoDwHrEmpleadonecesidadcapacitaEdit> dw7,
			List<DtoDwHrEmpleadoevaluacionDetailP> dw9, List<HrEmpleadoconsiderapotencial> dw10,
			List<HrEmpleadofuncion> dw11, List<HrDetalleevaluacion> dwCampo, List<HrEmpleadorevision> dwrevision,
			List<HrEmpleadocomentarios> dwComentario, List<HrDetalleevaluacionmejora> dwCompromisomejora,
			UsuarioActual usuario) {

		Integer ivEmpleado = strpass.getLo()[1];
		Integer ivSecuencia = strpass.getLo()[2];
		Integer ivEmpleadoevaluador = strpass.getLo()[3];
		String ivCompania = strpass.getS()[1];
		String estadoDefault = strpass.getS()[2];

		if (estadoDefault.equals(ConstanteRrhh.TIPO_ESTADO_TERMINADO)
				|| estadoDefault.equals(ConstanteRrhh.TIPO_ESTADO_REVISADO)) {
			Date w_fecha;
			BigDecimal w_puntaje;

			w_fecha = dw_evaluacion.getFechaevaluacion();
			w_puntaje = dw_evaluacion.getTotalpuntos();

			dao.grabarEvaluacionEmpleado(ConstanteRrhh.TIPO_ESTADO_TERMINADO, w_fecha, w_puntaje, ivEmpleado,
					ivSecuencia, ConstanteRrhh.TIPO_ESTADO_REVISADO, ivCompania, ivEmpleadoevaluador);

		}

		if (!UValidador.esNulo(dw_evaluacion))
			grabarEvaluacionCompleta(dw_evaluacion);

		if (!UValidador.esNulo(dw1))
			daoHrDetalleevaluacion.grabarDetalleEvaluacion(dw1);

		if (!UValidador.esNulo(dw3))
			daoHrMeritosfaltas.grabardw3(dw3);

		if (!UValidador.esNulo(dw5))
			daoHrEmpleadodesempeno.grabardw5(dw5);

		if (!UValidador.esNulo(dw6))
			daoHrEmpleadometas.guardarHrEmpleadoMetas(dw6);

		// RichardG 2008-11-11
		if (!UValidador.esNulo(dw7))
			wfUpdateCapacitacion(ivCompania, usuario, ivEmpleado, dw7);

		if (!UValidador.esNulo(dw7))
			daoHrEmpleadonecesidadcapacita.grabarEmpleadoNecesidad(dw7);

		if (!UValidador.esNulo(dw9))
			daoHrDetalleevaluacion.grabarEvaluacionDetalleP(dw9);

		if (!UValidador.esNulo(dw10))
			daoHrEmpleadoconsiderapotencial.grabarPotencial(dw10);

		if (!UValidador.esNulo(dw11))
			daoHrEmpleadofuncion.grabarEmpleadoFuncion(dw11);

		// RichardG 2008-11-07
		if (!UValidador.esNulo(dwCampo))
			daoHrDetalleevaluacion.grabardwCampo(dwCampo);

		if (!UValidador.esNulo(dwrevision))
			daoHrEmpleadorevision.grabarEmpleadoRevision(dwrevision);

		if (!UValidador.esNulo(dwComentario))
			daoHrEmpleadocomentarios.grabardwComentario(dwComentario);

		if (!UValidador.esNulo(dwCompromisomejora))
			daoHrDetalleevaluacionmejora.grabarDetalleMejora(dwCompromisomejora);

		daoHrDetalleevaluacionmejora.eliminarDetalleEvaluacionMejora(ivCompania, ivEmpleado, ivSecuencia,
				ivEmpleadoevaluador);

		if (!UValidador.esNulo(dw_evaluacion))
			dao.grabarEvaluacionCompleta(dw_evaluacion);

		// ...
		// wfUpdateHist();
		daoHrEvaluacioncandidatohist.grabarHistoriaEvaluacion(ivCompania, ivSecuencia, ivEmpleado, ivEmpleadoevaluador);
		// ...
	}

	private void wfUpdateCapacitacion(String ivCompania, UsuarioActual usuario, Integer ivEmpleado,
			List<DtoDwHrEmpleadonecesidadcapacitaEdit> dw7) {
		@SuppressWarnings("unused")
		String wsPuesto, wsArea, wsbuscar1, wsbuscar2, wsbuscar3, wsbuscar4, wsflagpuesto = "", wsflagarea = "",
				w$_error;
		@SuppressWarnings("unused")
		Integer wiFila, wiNumero = 0, wiCurso = 0, wiSecuencia = 0, wiEmpleadousuario, wiPuesto = 0, wiArea = 0,
				wiExiste = 0;
		Date wdFecha, wdHoy;

		Empleadomast dtoEmpleado = daoEmpleadomast.obtenerPorCodigoUsuario(usuario.getCodigoUsuario());

		wiEmpleadousuario = dtoEmpleado.getPk().getEmpleado();

		wdHoy = new Date();
		wdFecha = new Date();

		Empleadomast empleadoMast = daoEmpleadomast.obtenerEmpleadoMast(ivEmpleado);
		wiPuesto = empleadoMast.getCodigocargo();
		wiArea = empleadoMast.getDptoareaoperativa();

		wsbuscar1 = wiPuesto.toString();
		wsbuscar2 = wiPuesto.toString() + ",%";
		wsbuscar3 = "%," + wiPuesto.toString();
		wsbuscar4 = "%," + wiPuesto.toString() + ",%";

		wiExiste = daoHrDncSolicitante.cantHrDncSolicitantePuesto(wsbuscar1, wsbuscar2, wsbuscar3, wsbuscar4);

		if (UValidador.esNulo(wiExiste))
			wiExiste = 0;

		if (wiExiste > 0) {
			wsflagpuesto = "S";
		}

		wsbuscar1 = wiArea.toString();
		wsbuscar2 = wiArea.toString() + ",%";
		wsbuscar3 = "%," + wiArea.toString();
		wsbuscar4 = "%," + wiArea.toString() + ",%";

		wiExiste = 0;

		wiExiste = daoHrDncSolicitante.cantHrDncSolicitanteArea(wsbuscar1, wsbuscar2, wsbuscar3, wsbuscar4);

		if (UValidador.esNulo(wiExiste))
			wiExiste = 0;

		if (wiExiste > 0) {
			wsflagarea = "S";
		}

		wiNumero = daoHrDncSolicitante.obtenerMaximoSolicitante(ivCompania);

		if (UValidador.esNulo(wiNumero)) {
			wiNumero = 1;
		}

		for (DtoDwHrEmpleadonecesidadcapacitaEdit dw_7 : dw7) {
			wiCurso = dw_7.getBean().getCurso();
			wiSecuencia = daoHrDncSolicitante.obtenerSecuencia(ivCompania, "S", wiCurso);

			if (UValidador.esNulo(wiSecuencia))
				wiSecuencia = 0;

			if (wiSecuencia > 0) {
				wsPuesto = ',' + wiPuesto.toString();
				wsArea = ',' + wiArea.toString();

				daoHrDncSolicitante.grabarDncSolicitanteArea(wsflagpuesto, wsPuesto, wsflagarea, wsArea, ivCompania,
						wiSecuencia);

				// crear una lista con los puestos ya ingresados
				List<DtoPuestoCapacitacion> lstPuestos = daoHrDncSolicitante.obtenerPuestoCapacitacion(ivCompania,
						wiSecuencia);

				// se encuentra en la lista si no se encuentra ingresarlo
				ArrayList<Integer> codigoPuesto = new ArrayList<Integer>();

				for (DtoPuestoCapacitacion obj : lstPuestos) {
					codigoPuesto.add(obj.getPuesto().intValue());
				}
				// SI EL PUESTO NO ESTA EN LA LISTA INGRESARLO
				if (!codigoPuesto.contains(wiPuesto)) {
					daoHrDncSolicitante.insertarHrPuestoNecesidadCapacita(ivCompania, wiSecuencia, wiPuesto);
				}

				dw_7.getBean().getPk().setSecuencia(wiSecuencia);
			} else {
				wiNumero++;
				wsPuesto = wiPuesto.toString();
				wsArea = wiArea.toString();

				HrDncSolicitante HrDncSolicitante = new HrDncSolicitante();
				HrDncSolicitantePk pk = new HrDncSolicitantePk();

				pk.setCompanyowner(ivCompania);
				pk.setSecuencia(wiNumero);

				HrDncSolicitante.setPk(pk);
				HrDncSolicitante.setFechasolicitada(wdFecha);
				HrDncSolicitante.setEmpleadosolicitante(wiEmpleadousuario);
				HrDncSolicitante.setCurso(wiCurso);
				HrDncSolicitante.setPuesto(wsPuesto);
				HrDncSolicitante.setArea(wsArea);
				HrDncSolicitante.setNumeroParticipante(1);
				HrDncSolicitante.setEstado("S");
				HrDncSolicitante.setUltimoUsuario(usuario.getCodigoUsuario());
				HrDncSolicitante.setUltimaFechaModif(wdHoy);

				daoHrDncSolicitante.insertarDncSolicitante(HrDncSolicitante);

				dw_7.getBean().getPk().setSecuencia(wiNumero);

				// INSERTAR LOS PUESTOS EN LA TABLA HR_PUESTONECESIDADCAPACITA
				// crear una lista con los puestos ya ingresados
				List<DtoPuestoCapacitacion> lstPuestos = daoHrDncSolicitante.obtenerPuestoCapacitacion(ivCompania,
						wiSecuencia);

				// se encuentra en la lista si no se encuentra ingresarlo
				ArrayList<Integer> codigoPuesto = new ArrayList<Integer>();

				for (DtoPuestoCapacitacion obj : lstPuestos) {
					codigoPuesto.add(obj.getPuesto().intValue());
				}
				// SI EL PUESTO NO ESTA EN LA LISTA INGRESARLO
				if (!codigoPuesto.contains(wiPuesto)) {
					daoHrDncSolicitante.insertarHrPuestoNecesidadCapacita(ivCompania, wiSecuencia, wiPuesto);
				}

			}
		}
	}

	@Override
	public Integer obtenerCantEmpleado(BigDecimal iv_empleado, BigDecimal lv_Secuencia) {
		Criteria cri = dao.getCriteria();
		cri.add(Restrictions.le("pk.empleado", iv_empleado));
		cri.add(Restrictions.ge("pk.secuenciaeval", lv_Secuencia));

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.rowCount());

		cri.setProjection(proj);

		List lista = cri.list();

		if (UValidador.esListaVacia(lista))
			return 0;

		return (Integer) lista.get(0);
	}

	@Override
	@Transactional
	public void grabarEvaluacionEmpleado(String estado, Date wFecha, BigDecimal wPuntaje, Integer ivEmpleado,
			Integer ivSecuencia, String tipoEvaluador, String companyowner, Integer empleadoevaluador) {

		dao.grabarEvaluacionEmpleado(estado, wFecha, wPuntaje, ivEmpleado, ivSecuencia, tipoEvaluador, companyowner,
				empleadoevaluador);
	}

	@Override
	@Transactional
	public void grabarEvaluacionCompleta(DtoDwHrEmpleadoevaluacionEdit evaluacion) {
		dao.grabarEvaluacionCompleta(evaluacion);
	}

	@Override
	public List<MensajeUsuario> validarTodaEvaluacion(DtoDwHrEmpleadoevaluacionEdit dw_evaluacion,
			OwHrEvaluacionempleadoEdit opciones, StrPass strpass, String ivAction, List<DtoHrDetalleEvaluacion> dw1,
			List<DtoDwHrEmpleadoevaluacionDetailP> dw9, List<DtoDwHrIncidentecriticoList> dw3,
			List<HrEmpleadodesempeno> dw5, List<HrEmpleadoconsiderapotencial> dw10, List<HrEmpleadometas> dw6,
			List<DtoDwHrEmpleadonecesidadcapacitaEdit> dw7, Integer tipoGrabacion) {
		Integer ivEmpleado, ivSecuencia;
		String ivCompania;
		List<MensajeUsuario> msj = new ArrayList<MensajeUsuario>();

		long lv_cont = 0;
		String ls_permiteconformidad = "";

		if (UValidador.esNulo(dw_evaluacion.getEmpleado())) {
			msj.add(new MensajeUsuario(tipo_mensaje.ERROR, "Error, Debe especificar al empleado evaluado"));
			return msj;
		}

		ivEmpleado = dw_evaluacion.getEmpleado().intValue();
		ivCompania = dw_evaluacion.getCompanyowner();
		ivSecuencia = dw_evaluacion.getSecuenciaeval().intValue();

		if (UValidador.esNulo(dw_evaluacion.getEmpleadoevaluador())) {
			msj.add(new MensajeUsuario(tipo_mensaje.ERROR, "Mensaje, Debe especificar el empleado evaluador"));
			return msj;
		}

		if (!opciones.getIsEstadoDefault().equals(ConstanteRrhh.TIPO_ESTADO_EN_EVALUACION)) {
			if (opciones.isP3_visible()) {
				ls_permiteconformidad = daoMaMiscelaneosDetalle.obtenerValorCodigo("HR", "999999", "CODCRITEVA",
						"Incidentes Críticos%");
			} else if (opciones.isP1_visible()) {
				ls_permiteconformidad = daoMaMiscelaneosDetalle.obtenerValorCodigo("HR", "999999", "CODCRITEVA",
						"Competencias%");
			} else if (opciones.isP11_visible()) {
				ls_permiteconformidad = daoMaMiscelaneosDetalle.obtenerValorCodigo("HR", "999999", "CODCRITEVA",
						"Funciones%");
			} else if (opciones.isP5_visible()) {
				ls_permiteconformidad = daoMaMiscelaneosDetalle.obtenerValorCodigo("HR", "999999", "CODCRITEVA",
						"Fortalezas y Debilidades%");
			} else if (opciones.isP6_visible()) {
				ls_permiteconformidad = daoMaMiscelaneosDetalle.obtenerValorCodigo("HR", "999999", "CODCRITEVA",
						"Revisión de Metas y Objetivos%");
			} else if (opciones.isP7_visible()) {
				ls_permiteconformidad = daoMaMiscelaneosDetalle.obtenerValorCodigo("HR", "999999", "CODCRITEVA",
						"Necesidades de Capacitación%");
			} else if (opciones.isP16_visible()) {
				ls_permiteconformidad = daoMaMiscelaneosDetalle.obtenerValorCodigo("HR", "999999", "CODCRITEVA",
						"Revisión del Avance Compromiso%");
			}

			if (ls_permiteconformidad.equals(ConstanteRrhh.TIPO_SI)) {
				if (UValidador.esNulo(dw_evaluacion.getEvaluado())
						|| dw_evaluacion.getEvaluado().equals(ConstanteRrhh.TIPO_NO)) {
					msj.add(new MensajeUsuario(tipo_mensaje.ERROR, "Datos Obligatorios : Dar conformidad evaluador"));
					return msj;
				}
			}

		}

		if (ivAction.equals("AGREGAR")) {
			if (UValidador.esNulo(lv_cont))
				lv_cont = 0;

			if (lv_cont > 0) {
				msj.add(new MensajeUsuario(tipo_mensaje.ERROR,
						"Error, Ya existe otra evaluación para el empleado en el periodo especificado"));
				return msj;
			}
		}

		if (ivAction.equals("AGREGAR")) {
			dw_evaluacion.setSecuenciaeval(new BigDecimal(ivSecuencia));
		}

		// validar que se haya llenado cada linea de los detalles de evaluacion:

		Integer w_factor, w_factor_ant, w_secuencia;

		w_factor_ant = null;
		w_secuencia = 1;

		if (!opciones.getIsEstadoDefault().equals(ConstanteRrhh.TIPO_ESTADO_EN_EVALUACION)) {
			for (DtoHrDetalleEvaluacion dw_1 : dw1) {
				if (UValidador.esNulo(dw_1.getCalificacion())) {
					msj.add(new MensajeUsuario(tipo_mensaje.ERROR, "Aviso, Falta calificar competencia"));
					return msj;
				}
			}

		}

		if (!UValidador.esNulo(dw9)) {
			for (DtoDwHrEmpleadoevaluacionDetailP dw_9 : dw9) {
				if (UValidador.esNulo(dw_9.getSecuenciaeval())) {
					dw_9.setSecuenciaeval(new BigDecimal(ivSecuencia));
				}

				// ...
				w_factor = dw_9.getFactor().intValue();
				if (UValidador.esNulo(w_factor_ant)) {
					dw_9.setSecuencia(new BigDecimal(w_secuencia));
					w_secuencia = w_secuencia + 1;
					w_factor_ant = w_factor;
				} else {
					if (!w_factor_ant.equals(w_factor)) {
						dw_9.setSecuencia(new BigDecimal(w_secuencia));
						w_secuencia = w_secuencia + 1;
						w_factor_ant = w_factor;
					} else {
						// dw_9.setitemstatus (i,0, primary!, notmodified!)
					}
				}
				// ...

				if (UValidador.esNulo(dw_9.getEmpleado())) {
					dw_9.setEmpleado(new BigDecimal(ivEmpleado));
				}

				if (UValidador.esNulo(dw_9.getCompanyowner())) {
					dw_9.setCompanyowner(ivCompania);
				}

			}
		}

		if (!UValidador.esNulo(dw3)) {
			for (DtoDwHrIncidentecriticoList dw_3 : dw3) {
				if (UValidador.esNulo(dw_3.getFecha())) {
					msj.add(new MensajeUsuario(tipo_mensaje.ERROR,
							"Mensaje, La fecha del incidente debe ser especificada"));
					return msj;
				}
			}

		}

		if (!UValidador.esNulo(dw5)) {
			for (HrEmpleadodesempeno dw_5 : dw5) {
				if (UValidador.esNulo(dw_5.getPk().getEmpleado())) {
					dw_5.getPk().setEmpleado(ivEmpleado);
				}

				if (UValidador.esNulo(dw_5.getTipo())) {
					msj.add(new MensajeUsuario(tipo_mensaje.ERROR, "Mensaje, El tipo de desempeño es requerido"));
					return msj;
				}

				if (UValidador.esNulo(dw_5.getDescripcion())) {
					msj.add(new MensajeUsuario(tipo_mensaje.ERROR, "Mensaje, La descripcion es requerida"));
					return msj;
				}

			}
		}

		if (!UValidador.esNulo(dw10)) {
			for (HrEmpleadoconsiderapotencial dw_10 : dw10) {
				if (UValidador.esNulo(dw_10.getPk().getEmpleado())) {
					dw_10.getPk().setEmpleado(ivEmpleado);
				}

				if (UValidador.esNulo(dw_10.getFlagconclusion())) {
					msj.add(new MensajeUsuario(tipo_mensaje.ERROR, "Mensaje, La respuesta es requerida"));
					return msj;
				}

			}
		}

		if (!UValidador.esNulo(dw6)) {
			for (HrEmpleadometas dw_6 : dw6) {
				if (UValidador.esNulo(dw_6.getPk().getEmpleado())) {
					dw_6.getPk().setEmpleado(ivEmpleado);
				}

				if (UValidador.esNulo(dw_6.getDescripcion()) && dw_6.getEliminado().equals("N")) {
					msj.add(new MensajeUsuario(tipo_mensaje.ERROR,
							"Objetivos y/o Metas, La meta debe ser especificada"));
					return msj;
				}

				if (opciones.isP6_visible()) {
					if (UValidador.esNulo(dw_6.getPeriodo())) {
						msj.add(new MensajeUsuario(tipo_mensaje.ERROR, "Objetivos y/o Metas, El periodo es requerido"));
						return msj;
					}
				}

			}
		}

		if (!UValidador.esNulo(dw7)) {
			for (DtoDwHrEmpleadonecesidadcapacitaEdit dw_7 : dw7) {

				if (UValidador.esNulo(dw_7.getBean().getPk().getEmpleado())) {
					dw_7.getBean().getPk().setEmpleado(ivEmpleado);
				}

				if (UValidador.esNulo(dw_7.getBean().getNecesidad())) {
					msj.add(new MensajeUsuario(tipo_mensaje.ERROR,
							"Mensaje, La necesidad de capacitación debe ser especificada"));
					return msj;
				}

				if (UValidador.esNulo(dw_7.getBean().getPrioridad())) {
					msj.add(new MensajeUsuario(tipo_mensaje.ERROR, "Mensaje, La prioridad es requerida"));
					return msj;
				}

				if (UValidador.esNulo(dw_7.getBean().getCurso())) {
					msj.add(new MensajeUsuario(tipo_mensaje.ERROR, "Mensaje, El curso es requerido"));
					return msj;
				}

				if (UValidador.esNulo(dw_7.getBean().getObjetivo())) {
					msj.add(new MensajeUsuario(tipo_mensaje.ERROR,
							"Mensaje, El objetivo de mejora debe ser especificado en la necesidad de mejora"));
					return msj;
				}

				Integer li_prioridad, li_error;
				li_prioridad = dw_7.getBean().getPrioridad();

				List<HrEmpleadonecesidadcapacita> ds_necesidades = new ArrayList<HrEmpleadonecesidadcapacita>();
				for (DtoDwHrEmpleadonecesidadcapacitaEdit dtodw_7 : dw7) {
					HrEmpleadonecesidadcapacita dto7 = new HrEmpleadonecesidadcapacita();
					dto7.setCapacitacion(dtodw_7.getBean().getCapacitacion());
					dto7.setCurso(dtodw_7.getBean().getCurso());
					dto7.setNecesidad(dtodw_7.getBean().getNecesidad());
					dto7.setObjetivo(dtodw_7.getBean().getObjetivo());
					dto7.getPk().setCompanyowner(dtodw_7.getBean().getPk().getCompanyowner());
					dto7.getPk().setEmpleado(dtodw_7.getBean().getPk().getEmpleado());
					dto7.getPk().setEmpleadoevaluador(dtodw_7.getBean().getPk().getEmpleadoevaluador());
					dto7.getPk().setSecuencia(dtodw_7.getBean().getPk().getSecuencia());
					dto7.getPk().setSecuenciaeval(dtodw_7.getBean().getPk().getSecuenciaeval());
					dto7.setPrioridad(dtodw_7.getBean().getPrioridad());
					dto7.setUltimaFechaModif(dtodw_7.getBean().getUltimaFechaModif());
					dto7.setUltimoUsuario(dtodw_7.getBean().getUltimoUsuario());

					ds_necesidades.add(dto7);
				}

				li_error = 0;
			}
		}

		if (UValidador.esNulo(dw_evaluacion.getEvaluador())
				|| dw_evaluacion.getEvaluador().equals(ConstanteRrhh.TIPO_NO)) {
			msj.add(new MensajeUsuario(tipo_mensaje.ERROR, "La conformidad del evaluador es requerida."));
			return msj;
		}

		return msj;
	}

	@Autowired
	public void setDaoHrDetalleevaluacion(HrDetalleevaluacionDao daoHrDetalleevaluacion) {
		this.daoHrDetalleevaluacion = daoHrDetalleevaluacion;
	}

	@Autowired
	public void setDaoHrMeritosfaltas(HrMeritosfaltasDao daoHrMeritosfaltas) {
		this.daoHrMeritosfaltas = daoHrMeritosfaltas;
	}

	@Autowired
	public void setDaoHrEmpleadodesempeno(HrEmpleadodesempenoDao daoHrEmpleadodesempeno) {
		this.daoHrEmpleadodesempeno = daoHrEmpleadodesempeno;
	}

	@Autowired
	public void setDaoHrEmpleadometas(HrEmpleadometasDao daoHrEmpleadometas) {
		this.daoHrEmpleadometas = daoHrEmpleadometas;
	}

	@Autowired
	public void setDaoHrEmpleadonecesidadcapacita(HrEmpleadonecesidadcapacitaDao daoHrEmpleadonecesidadcapacita) {
		this.daoHrEmpleadonecesidadcapacita = daoHrEmpleadonecesidadcapacita;
	}

	@Autowired
	public void setDaoHrEmpleadoconsiderapotencial(HrEmpleadoconsiderapotencialDao daoHrEmpleadoconsiderapotencial) {
		this.daoHrEmpleadoconsiderapotencial = daoHrEmpleadoconsiderapotencial;
	}

	@Autowired
	public void setDaoHrEmpleadorevision(HrEmpleadorevisionDao daoHrEmpleadorevision) {
		this.daoHrEmpleadorevision = daoHrEmpleadorevision;
	}

	@Autowired
	public void setDaoHrEmpleadocomentarios(HrEmpleadocomentariosDao daoHrEmpleadocomentarios) {
		this.daoHrEmpleadocomentarios = daoHrEmpleadocomentarios;
	}

	@Autowired
	public void setDaoHrDetalleevaluacionmejora(HrDetalleevaluacionmejoraDao daoHrDetalleevaluacionmejora) {
		this.daoHrDetalleevaluacionmejora = daoHrDetalleevaluacionmejora;
	}

	@Autowired
	public void setDaoEmpleadomast(EmpleadomastDao daoEmpleadomast) {
		this.daoEmpleadomast = daoEmpleadomast;
	}

	@Autowired
	public void setDaoHrDncSolicitante(HrDncSolicitanteDao daoHrDncSolicitante) {
		this.daoHrDncSolicitante = daoHrDncSolicitante;
	}

	@Autowired
	public void setDaoHrEmpleadofuncion(HrEmpleadofuncionDao daoHrEmpleadofuncion) {
		this.daoHrEmpleadofuncion = daoHrEmpleadofuncion;
	}

	@Autowired
	public void setDaoHrEvaluacioncandidatohist(HrEvaluacioncandidatohistDao daoHrEvaluacioncandidatohist) {
		this.daoHrEvaluacioncandidatohist = daoHrEvaluacioncandidatohist;
	}

	@Autowired
	public void setDaoMaMiscelaneosDetalle(MaMiscelaneosdetalleDao daoMaMiscelaneosDetalle) {
		this.daoMaMiscelaneosDetalle = daoMaMiscelaneosDetalle;
	}

}
