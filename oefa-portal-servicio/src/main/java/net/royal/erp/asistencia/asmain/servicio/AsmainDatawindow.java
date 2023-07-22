package net.royal.erp.asistencia.asmain.servicio;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.royal.erp.asistencia.ascommon.dominio.dto.DtoWAsAutorizacionHorasDisponibles;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAsistenciaHextraEdit;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAutorizacionPreprocesoHextra;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAutorizacionPreprocesoTipodia;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsMarcasEmpleado;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwMaPrCalendarioferiadosProcesoSarg;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001Empleado;
import net.royal.erp.core.dominio.dto.DtoUsuario;
import net.royal.erp.planilla.dominio.dto.DtoMontoTotalCts;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsmainDatawindow")
public class AsmainDatawindow {

	private static Log LOGGER = LogFactory.getLog(AsmainFuncion.class);

	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	public List DwAsAutorizacionPreprocesoHextraSIGED(String flagautoriza, Integer empleado, String isadmin,
			String location, Date fechadesde, Date fechahasta, String flagfiltroperiodo, Integer sid,
			HashMap<String, Object> whereparam) throws Exception {
		LOGGER.debug("test de asmain.dw_as_autorizacion_preproceso_hextra");
		LOGGER.debug(" usar el siguiente dto :  DtoDwAsAutorizacionPreprocesoHextra");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  asmain.DwAsAutorizacionPreprocesoHextra");

		StringBuilder query = new StringBuilder();
		query.append(dao.obtenerSentenciaSqlPorQuery("asmain.DwAsAutorizacionPreprocesoHextraSIGED"));

		if (whereparam.containsKey("p_compania")) {
			query.append(" and Empleadomast.companiasocio in ( " + whereparam.get("p_compania") + ")");
		}
		if (whereparam.containsKey("p_planilla")) {
			query.append("  and Empleadomast.tipoplanilla in ( " + whereparam.get("p_planilla") + ")");
		}
		if (whereparam.containsKey("p_centrocosto")) {
			query.append(" and Empleadomast.CentroCostos in ( " + whereparam.get("p_centrocosto") + ")");
		}
		if (whereparam.containsKey("p_division")) {
			query.append(" and Empleadomast.CentroCostos in ( " + whereparam.get("p_division") + ")");
		}

		if (whereparam.containsKey("p_categoria")) {
			query.append(" and Empleadomast.Cargo in ( " + whereparam.get("p_categoria") + ")");
		}
		if (whereparam.containsKey("p_cargo")) {
			query.append(" and Empleadomast.CodigoCargo in ( " + whereparam.get("p_cargo") + ")");
		}
		if (whereparam.containsKey("p_oficina")) {
			query.append(" and Empleadomast.sucursal in ( " + whereparam.get("p_oficina") + ")");
		}
		if (whereparam.containsKey("p_area")) {
			query.append(" and AS_CarnetIdentificacion.area in ( " + whereparam.get("p_area") + ")");
		}
		if (whereparam.containsKey("p_empleado")) {
			query.append(" and empleadomast.empleado in ( " + whereparam.get("p_empleado") + ")");
		}

		if (whereparam.containsKey("p_nroresolucion")) {
			query.append(" and  AS_Autorizacion.NroResolucion = '" + whereparam.get("p_nroresolucion") + "'");
		}

		if (whereparam.containsKey("p_concepto")) {
			query.append(" and  AS_Autorizacion.CONCEPTOACCESO = '" + whereparam.get("p_concepto") + "'");
		}

		query.append(" GROUP BY as_autorizacion.empleado, " + "as_autorizacion.fecha, " + "as_autorizacion.desde, "
				+ "as_autorizacion.fechafin, " + "as_autorizacion.conceptoacceso, " + "personamast.nombrecompleto, "
				+ "as_autorizacion.tipohorario, " + "empleadomast.tipoplanilla, " + "empleadomast.estadoempleado, "
				+ "as_autorizacion.estado, " + "as_autorizacion.refrigerio, " + "as_autorizacion.mandatorio, "
				+ "periodo, " + "categoriaautorizacion, " + "as_carnetidentificacion.area, "
				+ "empleadomast.companiasocio, " + "empleadomast.departamentooperacional, "
				+ "empleadomast.centrocostos, " + "empleadomast.sucursal, " + "empleadomast.cargo, "
				+ "empleadomast.codigousuario," + "empleadomast.tipoplanilla, " + "empleadomast.centrocostos, "
				+ "empleadomast.codigocargo, " + "empleadomast.estado, " + "as_autorizacion.terminal, "
				+ "as_autorizacion.NroResolucion, " + "as_autorizacion.FechaResolucion, "
				+ "as_autorizacion.TIPOAUTORIZACION," + "as_autorizacion.x_desc_orig_as_fp,"
				+ "as_autorizacion.X_DIGITAL_AS_FP, as_autorizacion.flagreprogramado, as_autorizacion.flagAprobadoJefe,"
				+ "as_autorizacion.fechaAprobadoJefe ,as_autorizacion.aprobadoJefePor,"
				+ "as_autorizacion.desdeanterior,as_autorizacion.fechaanterior, ca.diascompensa,"
				+ " as_autorizacion.DESDERECUPERA, as_autorizacion.HASTARECUPERA ");

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_locacion", String.class, location));
		filtros.add(new ParametroPersistenciaGenerico("p_fechadesde", String.class,
				UFechaHora.convertirFechaCadena(fechadesde, "dd/MM/yyyy")));
		filtros.add(new ParametroPersistenciaGenerico("p_fechahasta", String.class,
				UFechaHora.convertirFechaCadena(fechahasta, "dd/MM/yyyy")));
		filtros.add(new ParametroPersistenciaGenerico("p_flagfiltroperiodo", String.class, flagfiltroperiodo));
		filtros.add(new ParametroPersistenciaGenerico("p_an_sid", Integer.class, sid));
		filtros.add(new ParametroPersistenciaGenerico("p_admin", String.class, isadmin));
		filtros.add(new ParametroPersistenciaGenerico("p_empleadoaprobador", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_flagaprobacion", String.class, flagautoriza));
		filtros.add(new ParametroPersistenciaGenerico("p_usuario", String.class, whereparam.get("p_usuario")));

		LOGGER.debug("consulta test de dario");
		LOGGER.debug(UFechaHora.obtenerFechaHoraInicioDia(fechadesde));
		LOGGER.debug(fechahasta);

		LOGGER.debug("La query es:" + query);

		return dao.listarPorSentenciaSQL(DtoDwAsAutorizacionPreprocesoHextra.class, query, filtros);
	}

	/**
	 *
	 * @author desarrollo
	 * @throws Exception
	 * @powerbuilder asmain.dw_as_autorizacion_preproceso_hextra
	 */
	public List DwAsAutorizacionPreprocesoHextra(String flagautoriza, Integer empleado, String isadmin, String location,
			Date fechadesde, Date fechahasta, String flagfiltroperiodo, Integer sid, HashMap<String, Object> whereparam)
			throws Exception {
		LOGGER.debug("test de asmain.dw_as_autorizacion_preproceso_hextra");
		LOGGER.debug(" usar el siguiente dto :  DtoDwAsAutorizacionPreprocesoHextra");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  asmain.DwAsAutorizacionPreprocesoHextra");

		StringBuilder query = new StringBuilder();
		query.append(dao.obtenerSentenciaSqlPorQuery("asmain.DwAsAutorizacionPreprocesoHextra"));

		if (whereparam.containsKey("p_compania")) {
			query.append(" and Empleadomast.companiasocio in ( " + whereparam.get("p_compania") + ")");
		}
		if (whereparam.containsKey("p_planilla")) {
			query.append("  and Empleadomast.tipoplanilla in ( " + whereparam.get("p_planilla") + ")");
		}
		if (whereparam.containsKey("p_centrocosto")) {
			query.append(" and Empleadomast.CentroCostos in ( " + whereparam.get("p_centrocosto") + ")");
		}
		if (whereparam.containsKey("p_division")) {
			query.append(" and Empleadomast.CentroCostos in ( " + whereparam.get("p_division") + ")");
		}

		if (whereparam.containsKey("p_categoria")) {
			query.append(" and Empleadomast.Cargo in ( " + whereparam.get("p_categoria") + ")");
		}
		if (whereparam.containsKey("p_cargo")) {
			query.append(" and Empleadomast.CodigoCargo in ( " + whereparam.get("p_cargo") + ")");
		}
		if (whereparam.containsKey("p_oficina")) {
			query.append(" and Empleadomast.sucursal in ( " + whereparam.get("p_oficina") + ")");
		}
		if (whereparam.containsKey("p_area")) {
			query.append(" and AS_CarnetIdentificacion.area in ( " + whereparam.get("p_area") + ")");
		}
		if (whereparam.containsKey("p_empleado")) {
			query.append(" and empleadomast.empleado in ( " + whereparam.get("p_empleado") + ")");
		}

		if (whereparam.containsKey("p_nroresolucion")) {
			query.append(" and  AS_Autorizacion.NroResolucion = '" + whereparam.get("p_nroresolucion") + "'");
		}

		if (whereparam.containsKey("p_concepto")) {
			query.append(" and  AS_Autorizacion.CONCEPTOACCESO = '" + whereparam.get("p_concepto") + "'");
		}

		query.append(" GROUP BY as_autorizacion.empleado, " + "as_autorizacion.fecha, " + "as_autorizacion.desde, "
				+ "as_autorizacion.fechafin, " + "as_autorizacion.conceptoacceso, "
				+ "personamast.nombrecompleto, personamast.documento,  " + "as_autorizacion.tipohorario, "
				+ "empleadomast.tipoplanilla, " + "empleadomast.estadoempleado, " + "as_autorizacion.estado, "
				+ "as_autorizacion.refrigerio, " + "as_autorizacion.mandatorio, " + "periodo, "
				+ "categoriaautorizacion, " + "as_carnetidentificacion.area, " + "empleadomast.companiasocio, "
				+ "empleadomast.departamentooperacional, " + "empleadomast.centrocostos, " + "empleadomast.sucursal, "
				+ "empleadomast.cargo, empleadomast.fechaingreso, " + "empleadomast.codigousuario,"
				+ "empleadomast.tipoplanilla, " + "empleadomast.centrocostos, " + "empleadomast.codigocargo, "
				+ "empleadomast.estado, " + "as_autorizacion.terminal, " + "as_autorizacion.NroResolucion, "
				+ "as_autorizacion.FechaResolucion, " + "as_autorizacion.TIPOAUTORIZACION,"
				+ "as_autorizacion.x_desc_orig_as_fp,"
				+ "as_autorizacion.X_DIGITAL_AS_FP, as_autorizacion.flagreprogramado, as_autorizacion.flagAprobadoJefe,"
				+ "as_autorizacion.fechaAprobadoJefe ,as_autorizacion.aprobadoJefePor,"
				+ "as_autorizacion.desdeanterior,as_autorizacion.fechaanterior, ca.diascompensa,"
				+ " as_autorizacion.DESDERECUPERA, as_autorizacion.HASTARECUPERA, ca.flagaprobacionsst ");

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_locacion", String.class, location));
		filtros.add(new ParametroPersistenciaGenerico("p_fechadesde", String.class,
				UFechaHora.convertirFechaCadena(fechadesde, "dd/MM/yyyy")));
		filtros.add(new ParametroPersistenciaGenerico("p_fechahasta", String.class,
				UFechaHora.convertirFechaCadena(fechahasta, "dd/MM/yyyy")));
		filtros.add(new ParametroPersistenciaGenerico("p_flagfiltroperiodo", String.class, flagfiltroperiodo));
		filtros.add(new ParametroPersistenciaGenerico("p_an_sid", Integer.class, sid));
		filtros.add(new ParametroPersistenciaGenerico("p_admin", String.class, isadmin));
		filtros.add(new ParametroPersistenciaGenerico("p_empleadoaprobador", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_flagaprobacion", String.class, flagautoriza));
		filtros.add(new ParametroPersistenciaGenerico("p_usuario", String.class, whereparam.get("p_usuario")));

		LOGGER.debug("consulta test de dario");
		LOGGER.debug(UFechaHora.obtenerFechaHoraInicioDia(fechadesde));
		LOGGER.debug(fechahasta);

		LOGGER.debug("La query es:" + query);

		return dao.listarPorSentenciaSQL(DtoDwAsAutorizacionPreprocesoHextra.class, query, filtros);
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asmain.dw_as_autorizacion_preproceso_tipodia
	 */
	public List DwAsAutorizacionPreprocesoTipodia(Integer tipodia) {
		LOGGER.debug("test de asmain.dw_as_autorizacion_preproceso_tipodia");
		LOGGER.debug(" usar el siguiente dto :  DtoDwAsAutorizacionPreprocesoTipodia");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  asmain.DwAsAutorizacionPreprocesoTipodia");
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_tipodia", Integer.class, tipodia));

		return dao.listarPorQuery(DtoDwAsAutorizacionPreprocesoTipodia.class,
				"asmain.DwAsAutorizacionPreprocesoTipodia", filtros);
	}

	@SuppressWarnings("unchecked")
	public List obtenerResultadosFinales(String p_FlagFiltroPeriodo, Date p_fecha_desde, Date p_fecha_hasta,
			String p_empleados, String p_centro_costo) throws SQLException {

		if (UValidador.esNulo(p_empleados)) {
			return null;
		}

		String[] cadenaEmpleados = p_empleados.split(",");
		String[] cadenaCentro = p_centro_costo.split(",");
		BigDecimal positivos = new BigDecimal(0);
		BigDecimal negativos = new BigDecimal(0);
		BigDecimal sumaPositivos = new BigDecimal(0);
		BigDecimal sumaNegativos = new BigDecimal(0);
		List datos = new ArrayList<>();

		for (int x = 0; x < cadenaEmpleados.length; x++) {
			LOGGER.debug("EMPLEADO::" + cadenaEmpleados[0]);
			positivos = sumarHoras("+", p_FlagFiltroPeriodo, p_fecha_desde, p_fecha_hasta, cadenaEmpleados[x],
					cadenaCentro[x]);
			negativos = sumarHoras("-", p_FlagFiltroPeriodo, p_fecha_desde, p_fecha_hasta, cadenaEmpleados[x],
					cadenaCentro[x]);
			LOGGER.debug("POSTIVOS::" + positivos);
			LOGGER.debug("NEGATIVOS::" + negativos);

			sumaPositivos = sumaPositivos.add(positivos);
			sumaNegativos = sumaNegativos.add(negativos);
			LOGGER.debug("SUMAPOSTIVOS::" + sumaPositivos);
			LOGGER.debug("SUMANEGATIVOS::" + sumaNegativos);
		}

		// sumaPositivos = sumarHoras("+", p_FlagFiltroPeriodo, p_fecha_desde,
		// p_fecha_hasta, cadenaEmpleados[x],
		// cadenaCentro[x]);
		// sumaNegativos = sumarHoras("-", p_FlagFiltroPeriodo, p_fecha_desde,
		// p_fecha_hasta, cadenaEmpleados[x],
		// cadenaCentro[x]);

		// obtener la suma en formato Hora
		String StrhorasPositivas = retornaHoras(sumaPositivos);
		String StrhorasNegativas = retornaHoras(sumaNegativos);
		String StrhorasBalance = retornaHoras(sumaPositivos.subtract(sumaNegativos));

		datos.add(StrhorasPositivas);
		datos.add(StrhorasNegativas);
		datos.add(StrhorasBalance);

		LOGGER.debug("POSTIVOS::" + StrhorasPositivas);
		LOGGER.debug("NEGATIVOS::" + StrhorasNegativas);
		LOGGER.debug("BALAMCE::" + StrhorasBalance);

		return datos;
	}

	private String retornaHoras(BigDecimal horas) throws SQLException {
		Connection cnn = dao.getConnection();
		Double dbHoras = horas.doubleValue();

		// Se prepara el Statement
		CallableStatement call = cnn.prepareCall("{ ? =call SGCORESYS.f_cent2sex_texto (?) }");

		// Se registra el parametro de salida
		call.registerOutParameter(1, Types.VARCHAR);

		// Se pasa un parámetro en el segundo interrogante.
		call.setDouble(2, dbHoras);

		// Se hace la llamada a la función.
		call.execute();

		String res = (String) call.getObject(1);

		call.close();
		// Se recoge el resultado del primer interrogante.
		return res;
	}

	private BigDecimal sumarHoras(String p_acceso, String p_FlagFiltroPeriodo, Date p_fecha_desde, Date p_fecha_hasta,
			String p_empleados, String p_centro_costo) throws SQLException {

		BigDecimal resultado = BigDecimal.ZERO;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_flagCompensacion", String.class, p_acceso));
		filtros.add(new ParametroPersistenciaGenerico("p_tipo", String.class, "HNAU"));
		filtros.add(new ParametroPersistenciaGenerico("p_centro_costo", String.class, p_centro_costo));
		filtros.add(new ParametroPersistenciaGenerico("p_persona", String.class, p_empleados));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha_desde", Date.class, p_fecha_desde));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha_hasta", Date.class, p_fecha_hasta));
		filtros.add(new ParametroPersistenciaGenerico("p_FlagFiltroPeriodo", String.class, p_FlagFiltroPeriodo));

		List data = dao.listarPorQuery(DtoMontoTotalCts.class, "asmain.obtenerTotalFeriadoCompensado", filtros);

		if (!UValidador.esListaVacia(data)) {
			resultado = ((DtoMontoTotalCts) data.get(0)).getMONTOTOTAL();
		}

		return resultado;

	}

	// private BigDecimal sumarHoras(String p_acceso, String
	// p_FlagFiltroPeriodo, Date p_fecha_desde, Date p_fecha_hasta,
	// String p_empleados, String p_centro_costo) throws SQLException {
	//
	// Double resultado = new Double(0);
	// Integer intEmpleado = Integer.parseInt(p_empleados);
	//
	// java.sql.Date sqlDate_desde = new java.sql.Date(p_fecha_desde.getTime());
	// java.sql.Date sqlDate_hasta = new java.sql.Date(p_fecha_hasta.getTime());
	//
	// Connection cnn = dao.getConnection();
	//
	// // Se prepara el Statement
	// CallableStatement call = cnn.prepareCall("{ ? =call
	// SGCORESYS.fn_sumar_horas (?,?,?,?,?,?,?) }");
	//
	// // Se registra el parametro de salida
	// call.registerOutParameter(1, Types.FLOAT);
	//
	// // Se pasa un parámetro en el segundo interrogante.
	// call.setString(2, p_acceso);
	// call.setString(3, p_FlagFiltroPeriodo);
	// call.setDate(4, sqlDate_desde);
	// call.setDate(5, sqlDate_hasta);
	// call.setInt(6, intEmpleado);
	// call.setString(7, p_centro_costo);
	//
	// call.setString(8, "HNAU");
	//
	// // Se hace la llamada a la función.
	// call.execute();
	//
	// // Se recoge el resultado del primer interrogante.
	// resultado = (Double) call.getObject(1);
	//
	// BigDecimal valorRetorno = new BigDecimal(resultado);
	//
	// return valorRetorno;
	//
	// }

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asmain.dw_as_marcas_empleado
	 */
	public List DwAsMarcasEmpleado(Integer par_empleado, Date fechadesde, Date fechahasta) {
		LOGGER.debug("test de asmain.dw_as_marcas_empleado");
		LOGGER.debug(" usar el siguiente dto :  DtoDwAsMarcasEmpleado");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  asmain.DwAsMarcasEmpleado");

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, par_empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_desde", Date.class, fechadesde));
		filtros.add(new ParametroPersistenciaGenerico("p_hasta", Date.class, fechahasta));

		return dao.listarPorQuery(DtoDwAsMarcasEmpleado.class, "asmain.DwAsMarcasEmpleado", filtros);
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asmain.dw_ma_pr_calendarioferiados_proceso_sarg
	 */
	public List DwMaPrCalendarioferiadosProcesoSarg() {
		LOGGER.debug("test de asmain.dw_ma_pr_calendarioferiados_proceso_sarg");
		LOGGER.debug(" usar el siguiente dto :  DtoDwMaPrCalendarioferiadosProcesoSarg");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  asmain.DwMaPrCalendarioferiadosProcesoSarg");
		return dao.listarPorQuery(DtoDwMaPrCalendarioferiadosProcesoSarg.class,
				"asmain.DwMaPrCalendarioferiadosProcesoSarg");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asmain.w_as_autorizacion_horas_disponibles
	 */
	public List WAsAutorizacionHorasDisponibles(Integer par_empleado, Date par_fecha) {
		LOGGER.debug("test de asmain.w_as_autorizacion_horas_disponibles");
		LOGGER.debug(" usar el siguiente dto :  DtoWAsAutorizacionHorasDisponibles");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  asmain.WAsAutorizacionHorasDisponibles");

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, par_empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, par_fecha));

		return dao.listarPorQuery(DtoWAsAutorizacionHorasDisponibles.class, "asmain.WAsAutorizacionHorasDisponibles",
				filtros);

	}

	public List listarUsuariosAdministradores(String par_aplicacion) {
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_aplicacion", String.class, par_aplicacion));

		return dao.listarPorQuery(DtoUsuario.class, "asmain.listarUsuariosAdministradores", filtros);

	}

	public List DwAsAsistenciaHextraEdit(Integer empleado, Date fechainicio, Date fechafin, String concepto1,
			String concepto2, Integer w_dfs, Integer w_dlv) {
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("par_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("par_fechainicio", Date.class, fechainicio));
		filtros.add(new ParametroPersistenciaGenerico("par_fechafinal", Date.class, fechafin));
		filtros.add(new ParametroPersistenciaGenerico("par_concepto1", String.class, concepto1));
		filtros.add(new ParametroPersistenciaGenerico("par_concepto2", String.class, concepto2));
		filtros.add(new ParametroPersistenciaGenerico("par_dfs", Integer.class, w_dfs));
		filtros.add(new ParametroPersistenciaGenerico("par_dlv", Integer.class, w_dlv));

		List datos = dao.listarPorQuery(DtoDwAsAsistenciaHextraEdit.class, "asmain.DwAsAsistenciaHextraEdit", filtros);

		List<DtoDwAsAsistenciaHextraEdit> listaFinal = new ArrayList<DtoDwAsAsistenciaHextraEdit>();

		if (!UValidador.esListaVacia(datos)) {

			listaFinal.addAll(datos);

			Collections.sort(listaFinal, new Comparator<DtoDwAsAsistenciaHextraEdit>() {
				@Override
				public int compare(DtoDwAsAsistenciaHextraEdit o1, DtoDwAsAsistenciaHextraEdit o2) {
					return o1.getFecha().compareTo(o2.getFecha());
				}
			});

			return listaFinal;

		}

		return null;

	}

	public List DwAsAsistenciaHextraEditModif(Integer empleado, Date fecha) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));

		return dao.listarPorQuery(DtoDwAsAsistenciaHextraEdit.class, "asmain.DwAsAsistenciaHextraEditModif", filtros);

	}

	public Integer contarPuedeAprobarConcepto(String usuario, String concepto, String flgisAdmin) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_usuario", String.class, usuario));
		filtros.add(new ParametroPersistenciaGenerico("p_concepto", String.class, concepto));
		filtros.add(new ParametroPersistenciaGenerico("p_isadmin", String.class, flgisAdmin));

		return dao.contar("asmain.contarPuedeAprobarConcepto", filtros);

	}

}
