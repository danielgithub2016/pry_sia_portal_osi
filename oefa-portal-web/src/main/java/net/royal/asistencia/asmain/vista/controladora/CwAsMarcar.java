package net.royal.asistencia.asmain.vista.controladora;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsMarcar;
import net.royal.erp.asistencia.dominio.AsAccesosdiarios;
import net.royal.erp.asistencia.dominio.AsArea;
import net.royal.erp.asistencia.dominio.AsAutorizacion;
import net.royal.erp.asistencia.dominio.AsConceptoacceso;
import net.royal.erp.asistencia.dominio.dto.DtoAsTipodiamovimiento;
import net.royal.erp.asistencia.dominio.dto.DtoCoordenadas;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.Personamast;
import net.royal.erp.core.dominio.PersonamastPk;
import net.royal.framework.correo.dominio.CorreoCore;
import net.royal.framework.correo.dominio.CorreoDestinoCore;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.core.UString;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.marcainterna.pcoefa.dominio.MvcPcOefaToken;
import net.royal.seguridad.constante.ConstanteSeguridad;
import net.royal.seguridad.dominio.Seguridadperfilusuario;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CwAsMarcar extends CBaseBean implements UIMantenimientoController {

	private DtoDwAsMarcar dw_1;
	private List<AsAccesosdiarios> dw_2;
	private Date hoy = new Date();
	private String errorMsj;
	private boolean inicializar;
	private String mensaje;
	// variable para mostra la hora del servidor
	private String horaServidor;
	private Date fechahoraServidor;
	private List<DtoCoordenadas> coordenadasGPS;
	private String coordenadasGPSJson;
	private Boolean blPresencial;

	public CwAsMarcar() {
		this.PANTALLA_LISTADO = "w_as_marcar";
	}

	public String objectStartEvent(String eventname) throws Exception {
		switch (eventname) {
		case "opened":
			mensaje = "";
			inicializar = true;
			inicializarFiltrosListado();
			if (!wf_inicializar()) {
				inicializar = false;
			}
			break;
		case "cb_aceptar_clicked":
			if (wf_grabar() == true) {
				wf_inicializar();
				this.getWebControlContext().ejecutar("PF('popExito').show()");
				this.getWebControlContext().actualizar("dgExito");
			}

		case "cb_cancelar_clicked":
			this.getWebControlContext().ejecutar("");
			break;
		case "ue_close":
			this.getWebControlContext().ejecutar("");
			break;
		default:
			break;
		}
		return null;
	}

	public boolean wf_grabar2() throws Exception {
		LOGGER.debug("en wf_grabar");
		Date w_fecha = new Date();
		String w_carnet;
		Integer ll_retorno, ll_retorno2;
		dw_1.setUltimousuario(getUsuarioActual().getLoginUsuario().toUpperCase());
		LOGGER.debug("usuario :: " + getUsuarioActual().getLoginUsuario().toUpperCase());
		dw_1.setUltimafechamodif(new Date());
		dw_1.setLectora("99");

		w_carnet = dw_1.getCarnetid();

		w_fecha = new Date();

		LOGGER.debug("w_carnet == " + w_carnet);
		Integer w_empleado;
		w_empleado = this.getFacAsistencia().getAsCarnetidentificacionServicio().obtenerMaximoEmpleadoXCarnet(w_carnet);

		ll_retorno = this.getFacAsistencia().getAS().getAsuserFuncion().FGetVacacionEmpleadoFecha(w_empleado, w_fecha,
				w_fecha);
		if (ll_retorno > 0) {
			setMessageError("No puede marcar en vacaciones");
			return false;
		}
		ll_retorno2 = this.getFacAsistencia().getAS().getAsuserFuncion().FGetHrLicenciaEmpleadoFecha(w_empleado,
				w_fecha, w_fecha);
		if (ll_retorno2 > 0) {
			setMessageError("No puede marcar cuando esta con permiso");
			return false;
		}

		Integer ll_rowcount;
		String ls_lugarrecoleccion = "";
		Date par_fechainicio;
		ll_rowcount = dw_2.size();

		if (ll_rowcount > 0) {
			ls_lugarrecoleccion = dw_2.get(ll_rowcount - 1).getLugarrecoleccion();
			par_fechainicio = dw_2.get(ll_rowcount - 1).getPk().getFecha();

			Integer iv_intervalominimo;
			iv_intervalominimo = this.getFacAsistencia().getAS().getSycommFuncion().FSqlReadParametrosmastN("AS",
					"999999", "MIN2MARCAC") * 60;

			Date par_fechafin = new Date();
			Integer w_segundos, w_dias;

			w_segundos = (int) (par_fechafin.getTime() - par_fechainicio.getTime()) / 1000;

			w_dias = UFechaHora.obtenerDiferenciaDias(par_fechainicio, par_fechafin);
			w_segundos = w_segundos + w_dias * 3600 * 24;
			// iv_intervalominimo = 8000;

			if (!UValidador.esListaVacia(dw_2)) {
				for (AsAccesosdiarios d2 : dw_2) {
					if (dw_1.getLugarrecoleccion().equals(d2.getLugarrecoleccion())) {
						setMessageError("Ya se registro esta acción");
						return false;
					}
				}
			}

			if (w_segundos < iv_intervalominimo) {
				setMessageError("Debe marcar como mínimo " + iv_intervalominimo / 60 + " minutos después de "
						+ new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(par_fechainicio));
				return false;
			}
		}
		if (ls_lugarrecoleccion.equals("E")) {
			dw_1.setLugarrecoleccion("S");
		} else {
			dw_1.setLugarrecoleccion("E");
		}

		String anio = new SimpleDateFormat("yyyy").format(dw_1.getFecha());
		LOGGER.debug(anio);
		String mes = new SimpleDateFormat("MM").format(dw_1.getFecha());
		LOGGER.debug(mes);
		String dia = new SimpleDateFormat("dd").format(dw_1.getFecha());
		LOGGER.debug(dia);

		dw_1.setHora(dw_1.getFecha());
		dw_1.setSecuencia(BigDecimal.ZERO);
		dw_1.setAno(Integer.parseInt(anio));
		dw_1.setMes(Integer.parseInt(mes));
		dw_1.setDia(Integer.parseInt(dia));

		LOGGER.debug("w_carnet 51082  == " + w_carnet);
		LOGGER.debug("fecha actual === dd/MM/yyyy HH:mm:ss" + w_fecha);

		w_empleado = this.getFacAsistencia().getAsAccesosdiariosServicio().obtenerEmpleado(w_carnet, w_fecha);

		if (!UValidador.estaVacio(w_empleado)) {
			SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy hh:mm");
			setMessageError(
					"Ya existe una marcación del carnet : " + w_carnet + " y la fecha " + fecha.format(w_fecha));
			return false;
		} else {
			LOGGER.debug("Antes de update");
			AsAccesosdiarios obj = new AsAccesosdiarios();
			obj.getPk().setCarnetid(dw_1.getCarnetid());
			obj.getPk().setFecha(dw_1.getFecha());
			obj.getPk().setSecuencia((dw_1.getSecuencia()).intValue());
			obj.getPk().setEmpleado((dw_1.getEmpleado().intValue()));
			obj.setHora(dw_1.getHora());
			obj.setObservacion(dw_1.getObservacion());
			obj.setAno(dw_1.getAno());
			obj.setMes(dw_1.getMes());
			obj.setDia(dw_1.getDia());
			obj.setLugarrecoleccion(dw_1.getLugarrecoleccion());
			obj.setLectora(dw_1.getLectora());

			obj.setObservacion("Marcación Web");
			obj.setUltimaFechaModif(dw_1.getFecha());
			obj.setUltimoUsuario(this.getUsuarioActual().getCodigoUsuario());

			this.getFacAsistencia().getAsAccesosdiariosServicio().registrar(obj);

			SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat fecha1 = new SimpleDateFormat("hh:mm");
			mensaje = "Se registró la marcación el " + fecha.format(w_fecha) + " a las " + fecha1.format(w_fecha);

			AsAutorizacion registro = new AsAutorizacion();
			registro.getPk().setEmpleado(BigDecimal.valueOf(dw_1.getEmpleado().intValue()));
			registro.getPk().setFecha(
					UFechaHora.convertirCadenaFecha(UFechaHora.convertirFechaCadena(dw_1.getFecha()), "dd/MM/yyyy"));

			registro.getPk().setConceptoacceso("OMI2");
			registro.getPk().setDesde(UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), new Date()));
			registro.setFechafin(
					UFechaHora.convertirCadenaFecha(UFechaHora.convertirFechaCadena(dw_1.getFecha()), "dd/MM/yyyy"));
			registro.setHasta(UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), new Date()));
			registro.setRefrigerio("S");
			registro.setPeriodo(UFechaHora.convertirFechaCadena(dw_1.getFecha(), "YYYYMM"));
			registro.setMandatorio("N");
			registro.setSolicitadopor(getUsuarioActual().getLoginUsuario().toUpperCase());
			registro.setFechasolicitud(new Date());
			registro.setAutorizadopor(getUsuarioActual().getLoginUsuario().toUpperCase());
			registro.setFechaautorizacion(new Date());
			registro.setUltimoUsuario(getUsuarioActual().getLoginUsuario().toUpperCase());
			registro.setUltimaFechaModif(new Date());
			registro.setSobretiempoposicion("1");
			registro.setEstado("A");
			registro.setComportamientosobretiempo("C");
			registro.setCategoriaautorizacion("OMIS");
			registro.setFlagcorrido("N");

			getFacAsistencia().getAsAutorizacionServicio().registrar(registro);

			return true;
		}
		// }

	}

	public boolean wf_grabar() throws Exception {
		LOGGER.debug("en wf_grabar");
		Date w_fecha = new Date();
		String flgTeletrabajo = "";
		boolean isteletrabajo = false;
		String w_carnet;
		Integer ll_retorno, ll_retorno2;
		dw_1.setUltimousuario(getUsuarioActual().getLoginUsuario().toUpperCase());
		LOGGER.debug("usuario :: " + getUsuarioActual().getLoginUsuario().toUpperCase());
		dw_1.setUltimafechamodif(new Date());
		dw_1.setLectora("99");
		dw_1.setFecha(new Date());

		if (!validar()) {
			return false;
		}

		Integer maxtempran = this.getFacAsistencia().getAS().getSycommFuncion().FSqlReadParametrosmastN("AS", "999999",
				"MAXTEMPRAN");

		w_carnet = dw_1.getCarnetid();

		w_fecha = new Date();

		LOGGER.debug("w_carnet == " + w_carnet);
		Integer w_empleado = this.getFacAsistencia().getAsCarnetidentificacionServicio()
				.obtenerMaximoEmpleadoXCarnet(w_carnet);

		ll_retorno = this.getFacAsistencia().getAS().getAsuserFuncion().FGetVacacionEmpleadoFecha(w_empleado, w_fecha,
				w_fecha);
		if (ll_retorno > 0) {
			setMessageError("No puede marcar en vacaciones");
			return false;
		}
		ll_retorno2 = this.getFacAsistencia().getAS().getAsuserFuncion().FGetHrLicenciaEmpleadoFecha(w_empleado,
				w_fecha, w_fecha);
		if (ll_retorno2 > 0) {
			setMessageError("No puede marcar cuando esta con permiso");
			return false;
		}

		// REQ ANGELA
		// Cuando registramos una marcación se genera una papeleta de
		// omisión de marcado si es que el area del empleado no tiene
		// ningún responsable.

		// validamos que el area del empleado tenga aprobador
		Integer cantresp = getFacAsistencia().getAsAreaServicio().contarResponsablesArea(dw_1.getEmpleado().intValue(),
				getUsuarioActual().getCompaniaSocioCodigo());

		// si es pefil teletrabajo lo graba directo
		List<Seguridadperfilusuario> perfiles = getFacSeguridad().getSeguridadperfilusuarioServicio()
				.listarPerfilActivoXUsuario(getUsuarioActual().getCodigoUsuario());
		if (!UValidador.esListaVacia(perfiles)) {
			for (Seguridadperfilusuario per : perfiles) {
				if (UConstante.CONSTANTE_PERFIL_TELETRABAJO.equalsIgnoreCase(per.getPk().getPerfil())) {
					cantresp = 0;
					isteletrabajo = true;
					break;
				}
			}
			for (Seguridadperfilusuario per : perfiles) {
				if (UConstante.CONSTANTE_PERFIL_MARCACION_WEB.equalsIgnoreCase(per.getPk().getPerfil())) {
					cantresp = 0;
					break;
				}
			}
		}

		if (isteletrabajo) {

			Integer tipodia = getFacAsistencia().getAS().getAsrepusFuncion().FSqlDevuelveHorario(w_empleado,
					UFechaHora.convertirCadenaFecha(UFechaHora.convertirFechaCadena(w_fecha), "dd/MM/yyyy"));

			int cantteletrab = 0;

			if (UValidador.esNulo(tipodia)) {
				tipodia = 0;
			}

			if (!UValidador.esCero(tipodia)) {
				// validamos que tenga el flag en el horario respectivo
				List<DtoAsTipodiamovimiento> lstHorarios = getFacAsistencia().getAsTipodiamovimientoServicio()
						.listar(tipodia);
				if (!UValidador.esListaVacia(lstHorarios)) {

					for (DtoAsTipodiamovimiento obj : lstHorarios) {
						if ("S".equals(obj.getFlgteletrabajo())) {
							cantteletrab = cantteletrab + 1;
						}
					}

					Date horaint = new Date();
					Date fechaact = new Date();
					horaint = UFechaHora.addHorasToDate(horaint, maxtempran);

					if (lstHorarios.size() == cantteletrab) {
						flgTeletrabajo = "S";
					} else {
						for (DtoAsTipodiamovimiento obj : lstHorarios) {
							if ("S".equals(obj.getFlgteletrabajo()) && !horaint
									.before(UFechaHora.obtenerFechaCompuesta(fechaact, obj.getHorainicio()))) {
								flgTeletrabajo = "S";
							}
						}
					}

				}
				// AsTipodiaasistencia obj = new AsTipodiaasistencia();
				// obj.getPk().setTipodia(tipodia);
				//
				// obj = (AsTipodiaasistencia)
				// getFacAsistencia().getAsTipodiaasistenciaServicio()
				// .obtenerPorId(obj.getPk(), false);
				//
				// if (!UValidador.esNulo(obj)) {
				// flgTeletrabajo = obj.getFlgTeletrabajo();
				// }
			}

			if (!"S".equals(flgTeletrabajo)) {
				setMessageError("No le corresponde marcar por la web en el día u horario actual.");
				return false;
			}
		}

		if (UValidador.esCero(cantresp)) {

			Integer ll_rowcount;
			// String ls_lugarrecoleccion = "";
			Date par_fechainicio;

			ll_rowcount = dw_2.size();

			if (ll_rowcount > 0) {
				// ls_lugarrecoleccion = dw_2.get(ll_rowcount -
				// 1).getLugarrecoleccion();
				par_fechainicio = dw_2.get(ll_rowcount - 1).getPk().getFecha();

				Integer iv_intervalominimo;
				iv_intervalominimo = this.getFacAsistencia().getAS().getSycommFuncion().FSqlReadParametrosmastN("AS",
						"999999", "MIN2MARCAC") * 60;

				Date par_fechafin = new Date();
				Integer w_segundos, w_dias;

				w_segundos = (int) (par_fechafin.getTime() - par_fechainicio.getTime()) / 1000;

				w_dias = UFechaHora.obtenerDiferenciaDias(par_fechainicio, par_fechafin);
				w_segundos = w_segundos + w_dias * 3600 * 24;
				// iv_intervalominimo = 8000;

				// hasta 2 marcas del mismo tipo por fecha
				int cantrep = 0;
				if (!UValidador.esListaVacia(dw_2)) {
					for (AsAccesosdiarios d2 : dw_2) {
						if (UValidador.estaVacio(d2.getTerminal())
								&& dw_1.getLugarrecoleccion().equals(d2.getLugarrecoleccion())
								&& UFechaHora.convertirFechaCadena(d2.getPk().getFecha(), "dd/MM/yyyy")
										.equals(UFechaHora.convertirFechaCadena(new Date(), "dd/MM/yyyy"))) {
							cantrep = cantrep + 1;
						}

						if (cantrep == 4) {
							setMessageError("Ya se registro esta acción");
							return false;
						}
					}
				}

				// validamos que la hora de la marca sea mayor al ultimo
				// registro, ya que por autorización de sobretiempo
				// puede que ya existan marcas futuras
				if (par_fechafin.getTime() > par_fechainicio.getTime()) {
					if (w_segundos < iv_intervalominimo) {
						setMessageError("Debe marcar como mínimo " + iv_intervalominimo / 60 + " minutos después de "
								+ new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(par_fechainicio));
						return false;
					}
				}
			}
			// if (ls_lugarrecoleccion.equals("E")) {
			// dw_1.setLugarrecoleccion("S");
			// } else {
			// dw_1.setLugarrecoleccion("E");
			// }

			String anio = new SimpleDateFormat("yyyy").format(dw_1.getFecha());
			LOGGER.debug(anio);
			String mes = new SimpleDateFormat("MM").format(dw_1.getFecha());
			LOGGER.debug(mes);
			String dia = new SimpleDateFormat("dd").format(dw_1.getFecha());
			LOGGER.debug(dia);
			dw_1.setHora(dw_1.getFecha());
			dw_1.setSecuencia(BigDecimal.ZERO);
			dw_1.setAno(Integer.parseInt(anio));
			dw_1.setMes(Integer.parseInt(mes));
			dw_1.setDia(Integer.parseInt(dia));

			LOGGER.debug("w_carnet 51082  == " + w_carnet);
			LOGGER.debug("fecha actual === dd/MM/yyyy HH:mm:ss" + w_fecha);

			// w_empleado = getUsuarioActual().getIdPersona();
			w_empleado = this.getFacAsistencia().getAsAccesosdiariosServicio().obtenerEmpleado(w_carnet, w_fecha);

			if (!UValidador.estaVacio(w_empleado)) {
				SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy hh:mm");
				setMessageError(
						"Ya existe una marcación del carnet : " + w_carnet + " y la fecha " + fecha.format(w_fecha));
				return false;
			} else {
				LOGGER.debug("Antes de update");
				AsAccesosdiarios obj = new AsAccesosdiarios();
				obj.getPk().setCarnetid(dw_1.getCarnetid());
				obj.getPk().setFecha(dw_1.getFecha());
				obj.getPk().setSecuencia((dw_1.getSecuencia()).intValue());
				obj.getPk().setEmpleado((dw_1.getEmpleado().intValue()));
				obj.setHora(dw_1.getHora());
				obj.setObservacion(dw_1.getObservacion());
				obj.setAno(dw_1.getAno());
				obj.setMes(dw_1.getMes());
				obj.setDia(dw_1.getDia());
				obj.setLugarrecoleccion(dw_1.getLugarrecoleccion());
				obj.setLectora(dw_1.getLectora());

				// Cambios Heiner
				obj.setObservacion("Marcación Web");
				obj.setUltimaFechaModif(new Date());
				obj.setUltimoUsuario(this.getUsuarioActual().getCodigoUsuario());

				this.getFacAsistencia().getAsAccesosdiariosServicio().registrar(obj);

				if (UValidador.estaVacio(getSessionValue(ConstanteSeguridad.PROCESO_MARCACION_FROM_OEFA))) {
					removeSessionValue(ConstanteSeguridad.PROCESO_MARCACION_FROM_OEFA);
				}

				// después de generar la marca eliminamos el token asociado
				// if (blPresencial) {
				// MvcPcOefaToken mvcPcOefaToken =
				// getFacMantenimiento().getMvcPcOefaTokenServicio()
				// .obtenerPorUsuarioToken(getUsuarioActual().getCodigoUsuario(),
				// dw_1.getTx_token());
				//
				// if (!UValidador.esNulo(mvcPcOefaToken)) {
				// mvcPcOefaToken.setActivo("0");
				// getFacMantenimiento().getMvcPcOefaTokenServicio().actualizar(mvcPcOefaToken);
				// }
				// }

				SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat fecha1 = new SimpleDateFormat("hh:mm");
				mensaje = "Se registró la marcación el " + fecha.format(dw_1.getFecha()) + " a las "
						+ fecha1.format(dw_1.getFecha()) + " (fecha y hora del servidor)";

				// enviamos correo
				enviarCorreo("MARCA");

				return true;
			}
		} else {

			Integer iv_intervalominimo;
			iv_intervalominimo = this.getFacAsistencia().getAS().getSycommFuncion().FSqlReadParametrosmastN("AS",
					"999999", "MIN2MARCAC") * 60;

			Date par_fechafin = new Date();
			Date par_fechainicio = null;
			Integer w_segundos, w_dias;

			par_fechainicio = getFacAsistencia().getAsAutorizacionServicio().obtenermaximodesde(
					dw_1.getEmpleado().intValue(), UFechaHora.obtenerFechaHoraInicioDiaDate(dw_1.getFecha()));

			if (!UValidador.esNulo(par_fechainicio)) {

				w_segundos = (int) (par_fechafin.getTime() - par_fechainicio.getTime()) / 1000;
				w_dias = UFechaHora.obtenerDiferenciaDias(par_fechainicio, par_fechafin);
				w_segundos = w_segundos + w_dias * 3600 * 24;

				if (par_fechafin.getTime() > par_fechainicio.getTime()) {
					if (w_segundos < iv_intervalominimo) {
						setMessageError("Debe marcar como mínimo " + iv_intervalominimo / 60 + " minutos después de "
								+ new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(par_fechainicio));
						return false;
					}
				}
			}

			AsAutorizacion registro = new AsAutorizacion();
			registro.getPk().setEmpleado(BigDecimal.valueOf(dw_1.getEmpleado().intValue()));
			registro.getPk().setFecha(
					UFechaHora.convertirCadenaFecha(UFechaHora.convertirFechaCadena(dw_1.getFecha()), "dd/MM/yyyy"));

			registro.getPk().setConceptoacceso("OMI2");
			registro.getPk().setDesde(UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), new Date()));
			registro.setFechafin(
					UFechaHora.convertirCadenaFecha(UFechaHora.convertirFechaCadena(dw_1.getFecha()), "dd/MM/yyyy"));
			registro.setHasta(UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), new Date()));
			registro.setRefrigerio("S");
			registro.setPeriodo(UFechaHora.convertirFechaCadena(dw_1.getFecha(), "YYYYMM"));
			registro.setMandatorio("N");
			registro.setSolicitadopor(getUsuarioActual().getLoginUsuario().toUpperCase());
			registro.setFechasolicitud(new Date());
			registro.setUltimoUsuario(getUsuarioActual().getLoginUsuario().toUpperCase());
			registro.setUltimaFechaModif(new Date());
			registro.setSobretiempoposicion("1");
			registro.setObservacion("Solicitud de Marcación Web");
			registro.setEstado("S");
			registro.setComportamientosobretiempo("C");
			registro.setCategoriaautorizacion("OMIS");
			registro.setFlagcorrido("N");

			getFacAsistencia().getAsAutorizacionServicio().registrar(registro);

			// enviamos correo
			enviarCorreo("OMI2");

			AsConceptoacceso concepto = new AsConceptoacceso();
			concepto.getPk().setConceptoacceso("OMI2");
			concepto = (AsConceptoacceso) getFacAsistencia().getAsConceptoaccesoServicio()
					.obtenerPorId(concepto.getPk());

			mensaje = "Se Generó una papeleta de " + concepto.getDescripcionlocal() + " en estado Solicitado. ";

			return true;
		}

	}

	private String enviarCorreo(String concepto) throws Exception {

		// if (getFacSeguridad().getSeguridadautorizacionesServicio()
		// .tieneAccesoSysAdm(getUsuarioActual().getAplicacionCodigo(),
		// getUsuarioActual().getCodigoUsuario())) {
		// return null;
		// }

		String mensaje = "";
		String rutaCompleta = null;
		String colaborador = null;
		List<CorreoDestinoCore> destinos = new ArrayList<>();
		String destinatarior1 = null;
		String destinatarior2 = null;
		String destinatarior3 = null;
		String destinatarior4 = null;
		String destinatario5 = null;
		String fechaini = null;
		String mensajefecha = "";
		Integer diasresta = 0;
		String mensajehoras = "";
		String lugar = "";
		String saludo = "";

		fechaini = UFechaHora.convertirFechaCadena(dw_1.getFecha(), "dd/MM/yyyy");

		diasresta = getFacAsistencia().getAS().getAsmainFuncion().FDiasHabiles(dw_1.getFecha(), dw_1.getFecha());

		mensajefecha = " para el día " + fechaini;

		if (UValidador.esCero(diasresta - 1)) {
			mensajehoras = ", a las " + UFechaHora
					.convertirFechaCadena(UFechaHora.obtenerFechaCompuesta(dw_1.getFecha(), new Date()), "HH:mm");
		}

		if (!"MARCA".equals(concepto)) {
			// DESTINATARIO
			// VERIFICAMOS SI EL EMPLEADO ES APROBADOR
			AsArea area = getFacAsistencia().getAsAreaServicio().obtenerArea(dw_1.getEmpleado().intValue(),
					getUsuarioActual().getCompaniaSocioCodigo());

			Boolean isresponsable = false;
			Integer empleado1 = 0;
			String flgempleado1 = "N";
			Integer empleado2 = 0;
			String flgempleado2 = "N";
			Integer empleado3 = 0;
			String flgempleado3 = "N";
			Integer empleado4 = 0;
			String flgempleado4 = "N";

			if (!UValidador.esNulo(area)) {

				// Verificamos si la papeleta es para un responsable.
				if (dw_1.getEmpleado().equals(area.getEmpleadoresponsable())
						|| dw_1.getEmpleado().equals(area.getEmpleadoresponsable2())
						|| dw_1.getEmpleado().equals(area.getEmpleadoresponsable3())
						|| dw_1.getEmpleado().equals(area.getEmpleadoresponsable4())) {
					isresponsable = true;
				}

				if (isresponsable) {
					// le envia correo a su aprobador y a los administradores
					if (dw_1.getEmpleado().equals(area.getEmpleadoresponsable())) {
						empleado1 = area.getEmpleadoaprobador();
						flgempleado1 = area.getFlagcorreoaprobador1();
					}
					if (dw_1.getEmpleado().equals(area.getEmpleadoresponsable2())) {
						empleado2 = area.getEmpleadoaprobador2();
						flgempleado2 = area.getFlagcorreoaprobador2();
					}
					if (dw_1.getEmpleado().equals(area.getEmpleadoresponsable3())) {
						empleado3 = area.getEmpleadoaprobador3();
						flgempleado3 = area.getFlagcorreoaprobador3();
					}
					if (dw_1.getEmpleado().equals(area.getEmpleadoresponsable4())) {
						empleado4 = area.getEmpleadoaprobador4();
						flgempleado4 = area.getFlagcorreoaprobador4();
					}
				} else {
					// le envia correo a todos los responsables
					empleado1 = area.getEmpleadoresponsable();
					flgempleado1 = area.getFlagcorreoresponsable1();
					empleado2 = area.getEmpleadoresponsable2();
					flgempleado2 = area.getFlagcorreoresponsable2();
					empleado3 = area.getEmpleadoresponsable3();
					flgempleado3 = area.getFlagcorreoresponsable3();
					empleado4 = area.getEmpleadoresponsable4();
					flgempleado4 = area.getFlagcorreoresponsable4();

				}

				// DESTINATARIO 1
				if (flgempleado1.equals(UConstante.CONSTANTE_OPCION_SI)) {
					Empleadomast emple1 = new Empleadomast();
					emple1.getPk().setEmpleado(empleado1);
					emple1.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
					emple1 = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(emple1.getPk());
					if (!UValidador.esNulo(emple1)) {
						destinatarior1 = emple1.getCorreointerno();
						LOGGER.debug("destinatario1 " + destinatarior1);
					}
				}

				// DESTINATARIO 2
				if (flgempleado2.equals(UConstante.CONSTANTE_OPCION_SI)) {
					Empleadomast emple2 = new Empleadomast();
					emple2.getPk().setEmpleado(empleado2);
					emple2.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
					emple2 = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(emple2.getPk());
					if (!UValidador.esNulo(emple2)) {
						destinatarior2 = emple2.getCorreointerno();
						LOGGER.debug("destinatario2 " + destinatarior2);
					}
				}

				// DESTINATARIO 3
				if (flgempleado3.equals(UConstante.CONSTANTE_OPCION_SI)) {
					Empleadomast emple3 = new Empleadomast();
					emple3.getPk().setEmpleado(empleado3);
					emple3.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
					emple3 = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(emple3.getPk());
					if (!UValidador.esNulo(emple3)) {
						destinatarior3 = emple3.getCorreointerno();
						LOGGER.debug("destinatario3 " + destinatarior3);
					}
				}

				// DESTINATARIO 4
				if (flgempleado4.equals(UConstante.CONSTANTE_OPCION_SI)) {
					Empleadomast emple4 = new Empleadomast();
					emple4.getPk().setEmpleado(empleado4);
					emple4.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
					emple4 = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(emple4.getPk());
					if (!UValidador.esNulo(emple4)) {
						destinatarior4 = emple4.getCorreointerno();
						LOGGER.debug("destinatario4 " + destinatarior4);
					}
				}
			}
		}

		// DESTINATARIO EMPLEADO
		Empleadomast empleado = new Empleadomast();
		empleado.getPk().setCompaniasocio(getUsuarioActual().getCompaniaSocioCodigo());
		empleado.getPk().setEmpleado(dw_1.getEmpleado().intValue());
		empleado = (Empleadomast) getFacCore().getEmpleadomastServicio().obtenerPorId(empleado.getPk());
		if (!UValidador.esNulo(empleado)) {
			destinatario5 = empleado.getCorreointerno();
			LOGGER.debug("destinatario " + destinatario5);
		}

		if (!UValidador.estaVacio(destinatarior1)) {
			destinos.add(new CorreoDestinoCore(destinatarior1));
		}
		if (!UValidador.estaVacio(destinatarior2)) {
			destinos.add(new CorreoDestinoCore(destinatarior2));
		}
		if (!UValidador.estaVacio(destinatarior3)) {
			destinos.add(new CorreoDestinoCore(destinatarior3));
		}
		if (!UValidador.estaVacio(destinatarior4)) {
			destinos.add(new CorreoDestinoCore(destinatarior4));
		}

		// EMPLEADO
		Personamast persona = (Personamast) getFacCore().getPersonamastServicio()
				.obtenerPorId(new PersonamastPk(dw_1.getEmpleado().intValue()));

		if (!UValidador.esNulo(persona)) {
			colaborador = persona.getNombres() + " " + persona.getApellidopaterno() + " "
					+ persona.getApellidomaterno();
			saludo = "M".equals(persona.getSexo()) ? "Estimado" : "Estimada";
		}

		// CONCEPTO
		if (!concepto.equals("MARCA")) {
			AsConceptoacceso obj = new AsConceptoacceso();
			obj.getPk().setConceptoacceso(concepto);
			obj = (AsConceptoacceso) getFacAsistencia().getAsConceptoaccesoServicio().obtenerPorId(obj.getPk());
			if (!UValidador.esNulo(obj)) {
				concepto = obj.getDescripcionlocal();
			}
			rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//solicitud_asistencia.html");
		} else {
			if (!UValidador.estaVacio(destinatario5)) {
				destinos.add(new CorreoDestinoCore(destinatario5));
			}
			rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//marcacion.html");
		}
		LOGGER.debug(rutaCompleta);
		mensaje = UFile.obtenerContenidoFile(rutaCompleta);
		LOGGER.debug(mensaje);
		mensaje = mensaje.replace("[EMPLEADO]", UString.cambiarCaracteresEspecialesHTML(colaborador));
		mensaje = mensaje.replace("[CONCEPTO]", UString.cambiarCaracteresEspecialesHTML(concepto));
		mensaje = mensaje.replace("[MENSAJE_FECHA]", UString.cambiarCaracteresEspecialesHTML(mensajefecha));
		mensaje = mensaje.replace("[MENSAJE_HORA]", UString.cambiarCaracteresEspecialesHTML(mensajehoras));
		mensaje = mensaje.replace("[LUGAR]", UString.cambiarCaracteresEspecialesHTML(lugar));
		mensaje = mensaje.replace("[DIFERENCIA_DIAS]", "");
		mensaje = mensaje.replace("[SALUDO]", saludo);

		// ENVIO
		Boolean isconfiguradocorreo = getFacSeguridad().getCorreoServicio().configurarCorreo();

		if (isconfiguradocorreo) {
			CorreoCore correo = new CorreoCore();
			correo.setListaCorreoDestino(destinos);
			correo.setAsunto(concepto.equals("OMI2") ? "Solicitud de asistencia" : "Registro de marcación");
			correo.setCuerpoCorreo(mensaje.getBytes());

			if (!UValidador.esListaVacia(destinos)) {
				getFacSeguridad().getCorreoServicio().enviarCorreo(correo);
			}
		}
		return null;
	}

	public boolean wf_inicializar() throws Exception {
		String w_carnet = null, nombreCompleto;
		Integer w_empleado;

		LOGGER.debug("getGv_userid() == " + getUsuarioActual().getLoginUsuario().toUpperCase());

		w_empleado = this.getFacCore().getEmpleadomastServicio()
				.obtenerUsuarioMaximo(getUsuarioActual().getLoginUsuario().toUpperCase());
		LOGGER.debug("w_empleado ==== " + w_empleado);

		w_carnet = this.getFacAsistencia().getAsCarnetidentificacionServicio().obtenerCodigoCarnet(w_empleado);

		if (UValidador.estaVacio(w_carnet)) {
			errorMsj = "No existe carnet para el usuario (código : " + w_empleado + " )";
			return false;
		}

		// PARA TRAER EL NOMBRE DEL USUARIO

		nombreCompleto = this.getUsuarioActual().getNombreCompleto();
		LOGGER.debug("nombreCompleto == " + nombreCompleto);
		// FIN TRAER EL NOMBRE DEL USUARIO

		Date w_fechahasta, w_fechadesde;

		dw_1.setFecha(new Date());

		dw_1.setCarnetid(w_carnet);
		dw_1.setObservacion("");
		dw_1.setEmpleado(BigDecimal.valueOf(w_empleado));
		dw_1.setNombreEmpleado(nombreCompleto);

		w_fechadesde = new Date();
		w_fechahasta = UFechaHora.anadirDiasAFechas(w_fechadesde, 1);

		Date fecha1, fecha2;
		fecha1 = UFechaHora.obtenerFechaHoraInicioDia(w_fechadesde);
		fecha2 = UFechaHora.obtenerFechaHoraInicioDia(w_fechahasta);
		LOGGER.debug("fecha1 === " + fecha1);
		LOGGER.debug("fecha2 === " + fecha2);

		dw_2 = this.getFacAsistencia().getAsAccesosdiariosServicio().listarAsMarcar(w_carnet, fecha1, fecha2);

		LOGGER.debug("w_carnet == " + w_carnet);
		LOGGER.debug("w_fechadesde == " + w_fechadesde);
		LOGGER.debug("w_fechahasta == " + w_fechahasta);
		LOGGER.debug("dw_2 === " + dw_2.size());

		Integer ll_rowcount;
		String ls_lugarrecoleccion = "";

		ll_rowcount = dw_2.size();
		if (ll_rowcount > 0) {
			ls_lugarrecoleccion = dw_2.get(ll_rowcount - 1).getLugarrecoleccion();
		}

		if ("E".equals(ls_lugarrecoleccion)) {
			dw_1.setLugarrecoleccion("S");
		} else {
			dw_1.setLugarrecoleccion("E");
		}

		// cargarCoordenadas();

		return true;
	}

	private void cargarCoordenadas() {
		// TODO Auto-generated method stub
	}

	public static CwAsMarcar getInstance() {
		return UFaces.evaluateExpressionGet("#{cwAsMarcar}", CwAsMarcar.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		// fechahoraServidor =
		// getFacSeguridad().getSeguridadconceptoServicio().obtenerfechahora();
		objectStartEvent("opened");
		return this.PANTALLA_LISTADO;
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
		// TODO Auto-generated method stub
		Boolean retorno = true;

		if (!validarPC()) {
			return false;
		}

		return retorno;
	}

	// private boolean validarToken() throws Exception {
	// // TODO Auto-generated method stub
	// boolean retorno = getFacMantenimiento().getMvcPcOefaTokenServicio()
	// .validarToken(getUsuarioActual().getCodigoUsuario(), dw_1.getTx_token());
	//
	// if (!retorno) {
	// getWebControlContext().actualizar("dgMsgToken");
	// getWebControlContext().ejecutar("PF('popMsgToken').show()");
	// }
	//
	// return retorno;
	// }

	private boolean validarPC() throws Exception {
		boolean retorno = true;

		AsArea asArea = getFacAsistencia().getAsAreaServicio().obtenerArea(getUsuarioActual().getIdPersona(),
				getUsuarioActual().getCompaniaSocioCodigo());
		if (!UValidador.esNulo(asArea)) {
			if ("S".equals(asArea.getFlgmarcacionpresencial())) {
				int cant = getFacAsistencia().getAsAutorizacionServicio()
						.contarSolicitudIngressoSST(getUsuarioActual().getCodigoUsuario(), new Date());

				if (cant == 0) {
					return true;
				}

				if (UValidador.estaVacio(getSessionValue(ConstanteSeguridad.PROCESO_MARCACION_FROM_OEFA))) {
					getWebControlContext().actualizar("dgMsgIngresoIcono");
					getWebControlContext().ejecutar("PF('popMsgIngresoIcono').show()");
					return false;
				}

				String token = (String) getSessionValue(ConstanteSeguridad.PROCESO_MARCACION_FROM_OEFA);
				// token =
				// AesEncryption.desEncriptar(EncriptadorMarca.secretKey,
				// token);

				MvcPcOefaToken mvcPcOefaToken = getFacMantenimiento().getMvcPcOefaTokenServicio()
						.obtenerPorToken(token);

				if (UValidador.esNulo(mvcPcOefaToken)) {
					getWebControlContext().actualizar("dgMsgIngresoIcono");
					getWebControlContext().ejecutar("PF('popMsgIngresoIcono').show()");
					return false;
				}

				retorno = getFacMantenimiento().getMapPcOefaServicio()
						.existePcFisicamenteOefa(mvcPcOefaToken.getTx_pc());

				if (!retorno) {
					getWebControlContext().actualizar("dgMsgIngresoPCOefa");
					getWebControlContext().ejecutar("PF('popMsgIngresoPCOefa').show()");
					return false;
				}
			}
		}

		return retorno;
	}

	public String descargarGenerador() {
		String pathPrincipal;
		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
				.getRealPath("/");

		pathPrincipal = pathPrincipal + File.separator + "comun" + File.separator + "recursos" + File.separator + "jar";

		UFile.descargarArchivoFromFolder(pathPrincipal + File.separator + "tokenMarca.jar");

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

	@Override
	public String inicializarFiltrosListado() throws Exception {
		dw_1 = new DtoDwAsMarcar();
		dw_2 = new ArrayList<AsAccesosdiarios>();
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AsAccesosdiarios> getDw_2() {
		return dw_2;
	}

	public void setDw_2(List<AsAccesosdiarios> dw_2) {
		this.dw_2 = dw_2;
	}

	public Date getHoy() {
		return hoy;
	}

	public void setHoy(Date hoy) {
		this.hoy = hoy;
	}

	public DtoDwAsMarcar getDw_1() {
		return dw_1;
	}

	public void setDw_1(DtoDwAsMarcar dw_1) {
		this.dw_1 = dw_1;
	}

	public String getErrorMsj() {
		return errorMsj;
	}

	public void setErrorMsj(String errorMsj) {
		this.errorMsj = errorMsj;
	}

	public boolean isInicializar() {
		return inicializar;
	}

	public void setInicializar(boolean inicializar) {
		this.inicializar = inicializar;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getHoraServidor() {
		Date fechaActual = new Date();
		SimpleDateFormat d = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		horaServidor = d.format(fechaActual);
		return horaServidor;
	}

	public void setHoraServidor(String horaServidor) {
		this.horaServidor = horaServidor;
	}

	public Date getFechahoraServidor() {
		fechahoraServidor = UFechaHora.addSecondsToDate(fechahoraServidor, 1);
		return fechahoraServidor;
	}

	public void setFechahoraServidor(Date fechahoraServidor) {
		this.fechahoraServidor = fechahoraServidor;
	}

	public List<DtoCoordenadas> getCoordenadasGPS() {
		return coordenadasGPS;
	}

	public void setCoordenadasGPS(List<DtoCoordenadas> coordenadasGPS) {
		this.coordenadasGPS = coordenadasGPS;
	}

	public String getCoordenadasGPSJson() {
		return coordenadasGPSJson;
	}

	public void setCoordenadasGPSJson(String coordenadasGPSJson) {
		this.coordenadasGPSJson = coordenadasGPSJson;
	}

	public Boolean getBlPresencial() {
		return blPresencial;
	}

	public void setBlPresencial(Boolean blPresencial) {
		this.blPresencial = blPresencial;
	}

}
