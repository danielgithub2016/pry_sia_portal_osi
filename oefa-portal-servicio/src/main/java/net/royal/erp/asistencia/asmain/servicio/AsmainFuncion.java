package net.royal.erp.asistencia.asmain.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwMaPrCalendarioferiadosProcesoSarg;
import net.royal.erp.asistencia.dominio.dto.DtoAsPeriodo;
import net.royal.erp.core.dominio.dto.DtoEmpleadomast;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsmainFuncion")
public class AsmainFuncion {

	private static Log LOGGER = LogFactory.getLog(AsmainFuncion.class);

	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	/**
	 *
	 * @author desarrollo
	 * @throws Exception
	 * @powerbuilder asmain.f_as_fechasactivas_periodo
	 */
	@SuppressWarnings("unchecked")
	public List FAsFechasactivasPeriodo(String periodo, String flgadmin)
			throws Exception {
		LOGGER.debug("test de asmain.f_as_fechasactivas_periodo");
		List respuesta = null;
		Date fechadesde = null;
		Date fechahasta = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();

		List data = new ArrayList<>();
		if (flgadmin.equals("S")) {
			data = dao.listarPorQuery(DtoAsPeriodo.class,
					"asmain.FAsFechasactivasPeriodo", null);
		} else {
			data = dao.listarPorQuery(DtoAsPeriodo.class,
					"asmain.FAsFechasactivasPeriodoNoAdmin", null);
		}
		if (!UValidador.esListaVacia(data)) {
			respuesta = new ArrayList();
			fechadesde = ((DtoAsPeriodo) data.get(0)).getFechadesde();
			fechahasta = ((DtoAsPeriodo) data.get(0)).getFechahasta();

			fechadesde = UFechaHora.obtenerFechaHoraInicioDia(fechadesde);
			fechahasta = UFechaHora.obtenerFechaHoraFinDia(fechahasta);

			respuesta.add(fechadesde);
			respuesta.add(fechahasta);
		}

		return respuesta;

	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asmain.f_as_genera_empleados_autorizados
	 */
	public void FAsGeneraEmpleadosAutorizados(Integer str_global_gv_sid,
			String str_global_gv_userid, Integer str_global_gv_vendor,
			Boolean isadmin) {
		LOGGER.debug("test de asmain.f_as_genera_empleados_autorizados");
		String w_administrador = "";

		// Es SYSADM
		if (!isadmin) { // uo_navigator.EsSisAdm
			w_administrador = "N";
		} else {
			w_administrador = "S";
		}

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();

		LOGGER.debug("PARAMETROS: " + str_global_gv_sid + " " + w_administrador
				+ " " + str_global_gv_vendor + " " + str_global_gv_userid);
		filtros.add(new ParametroPersistenciaGenerico("str_global_gv_sid",
				Integer.class, str_global_gv_sid));
		dao.ejecutarPorQuery("asmain.DwQuery1EmpleadosAutorizados", filtros);

		filtros.add(new ParametroPersistenciaGenerico("str_global_gv_userid",
				String.class, str_global_gv_userid));
		filtros.add(new ParametroPersistenciaGenerico("str_global_gv_vendor",
				Integer.class, str_global_gv_vendor));
		
		filtros.add(new ParametroPersistenciaGenerico("w_administrador",
				String.class, w_administrador));

		dao.ejecutarPorQuery("asmain.DwQuery2EmpleadosAutorizados", filtros);

		filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("str_global_gv_sid",
				Integer.class, str_global_gv_sid));
		filtros.add(new ParametroPersistenciaGenerico("str_global_gv_userid",
				String.class, str_global_gv_userid));
		filtros.add(new ParametroPersistenciaGenerico("str_global_gv_vendor",
				Integer.class, str_global_gv_vendor));

		dao.ejecutarPorQuery("asmain.DwQuery3EmpleadosAutorizados", filtros);
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asmain.f_as_periodo_activo
	 */
	public List FAsPeriodoActivo(Integer par_empleado, Date par_fechadesde,
			Date par_fechahasta) throws Exception {
		LOGGER.debug("test de asmain.f_as_periodo_activo");
		List<Object> resultado = new ArrayList<Object>();

		String ls_nombre = null, ls_tipoplanilla = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado",
				Integer.class, par_empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fechadesde",
				Integer.class, par_fechadesde));
		filtros.add(new ParametroPersistenciaGenerico("p_fechahasta",
				Integer.class, par_fechahasta));

		List data = dao.listarPorQuery(DtoAsPeriodo.class,
				"asperiodo.fasperiodoactivo", filtros);

		if (!UValidador.esListaVacia(data)) {
			resultado.add(-1);// Periodo Cerrado
			resultado.add("El periodo se encuentra cerrado en la fecha "
					+ UFechaHora.convertirFechaCadena(par_fechadesde,
							"dd/MM/yyyy")
					+ " hasta "
					+ UFechaHora.convertirFechaCadena(par_fechahasta,
							"dd/MM/yyyy") + " para el trabajador "
					+ par_empleado + " " + ls_nombre + " de tipo de planilla "
					+ ls_tipoplanilla + " este proceso será interrumpido.");
		} else {
			resultado.add(1);
			resultado.add(null);
		}

		return resultado;

	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asmain.f_as_periodoactivo
	 */
	public String FAsPeriodoactivo(Integer as_empleado) {
		LOGGER.debug("test de asmain.f_as_periodoactivo");
		String periodo = null;
		String tipoplanilla = null;

		if (as_empleado > 0) {
			List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
			filtros.add(new ParametroPersistenciaGenerico("p_empleado",
					Integer.class, as_empleado));

			List data1 = dao.listarPorQuery(DtoEmpleadomast.class,
					"empleadomast.obtenerTipoPlanilla", filtros);
			if (!UValidador.esListaVacia(data1)) {
				tipoplanilla = ((DtoEmpleadomast) data1.get(0))
						.getTipoplanilla();
			}
		}

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_tipoplanilla",
				String.class, tipoplanilla));

		List data2 = dao.listarPorQuery(DtoAsPeriodo.class,
				"asperiodo.obtenerPeriodoActivo", filtros);
		if (!UValidador.esListaVacia(data2)) {
			periodo = ((DtoAsPeriodo) data2.get(0)).getPeriodoplanilla();
		}

		return periodo;

	}

	/**
	 *
	 * @author desarrollo
	 * @throws Exception
	 * @powerbuilder asmain.f_as_validar_rango_activo
	 */
	@SuppressWarnings("unchecked")
	public List FAsValidarRangoActivo(Date par_fechadesde, Date par_fechahasta,
			Boolean isadmin, Boolean par_mensaje) throws Exception {
		LOGGER.debug("test de asmain.f_as_validar_rango_activo");

		List lstRespuesta = new ArrayList();

		Integer registrosEncontrados = null;

		par_fechadesde = UFechaHora.obtenerFechaHoraInicioDia(par_fechadesde);
		par_fechahasta = UFechaHora.obtenerFechaHoraInicioDia(par_fechahasta);

		// ----------------// Act LBL 2012.12.10

		if (isadmin) {
			lstRespuesta.add(true);
			lstRespuesta.add(null);
			return lstRespuesta;
		}
		// ----------------//

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_fechadesde",
				Date.class, par_fechadesde));
		filtros.add(new ParametroPersistenciaGenerico("p_fechahasta",
				Date.class, par_fechahasta));

		registrosEncontrados = dao.contar("asperiodo.obtenerCantidad", filtros);

		if (UValidador.esCero(registrosEncontrados)) {
			if (par_mensaje) {
				lstRespuesta.add(false);
				lstRespuesta
						.add("El rango de fechas elegido no pertenece a un periodo activo..");
			} else {
				lstRespuesta.add(false);
			}
		} else {
			lstRespuesta.add(true);
			lstRespuesta.add(null);
		}

		return lstRespuesta;
	}

	/**
	 *
	 * @author desarrollo
	 * @throws Exception
	 * @powerbuilder asmain.f_dias_habiles
	 */
	public Integer FDiasHabiles(Date fechainicio, Date fechafin)
			throws Exception {
		Integer w_count, w_dias = 0, filaencontrada;
		Integer diasemana;
		Date w_fecha;

		List<DtoDwMaPrCalendarioferiadosProcesoSarg> ds_feriado = new ArrayList<DtoDwMaPrCalendarioferiadosProcesoSarg>();

		List data = dao.listarPorQuery(
				DtoDwMaPrCalendarioferiadosProcesoSarg.class,
				"asmain.DwMaPrCalendarioferiadosProcesoSarg");

		if (!UValidador.esListaVacia(data)) {
			ds_feriado = data;
		}

		w_fecha = fechainicio;
		w_count = UFechaHora.obtenerDiasTranscurridos(fechafin, fechainicio) + 1;
		LOGGER.debug("DIAS TRANS " + w_count);

		for (int i = 0; i < w_count; i++) {

			diasemana = UFechaHora.obtenerNumeroDiaSemana(w_fecha);

			if (!(diasemana.equals(1) || diasemana.equals(7))) { // dferente de
																	// sabado y
																	// domingo
				filaencontrada = null;
				for (int j = 0; j < ds_feriado.size(); j++) {
					DtoDwMaPrCalendarioferiadosProcesoSarg obj = ds_feriado
							.get(j);
					if (obj.getFechamesdia().equals(
							UFechaHora
									.convertirFechaCadena(w_fecha, "ddmmyyyy"))) {
						filaencontrada = j;
					}
				}
				if (UValidador.esNulo(filaencontrada)) {
					w_dias = w_dias + 1;
				}
			} else {

			}

			w_fecha = UFechaHora.obtenerFechaMasdias(w_fecha, 1);
		}

		return w_dias;

	}
}
