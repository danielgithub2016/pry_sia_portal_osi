package net.royal.erp.core.servicio.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.asistencia.dao.AsConceptoaccesoDao;
import net.royal.erp.asistencia.dao.AsEmpleadoexcepcionDao;
import net.royal.erp.asistencia.dao.AsTipodiaasistenciaDao;
import net.royal.erp.asistencia.dao.AsTipohorarioDao;
import net.royal.erp.asistencia.dominio.AsConceptoacceso;
import net.royal.erp.asistencia.dominio.AsTipodiaasistencia;
import net.royal.erp.asistencia.dominio.AsTipohorario;
import net.royal.erp.asistencia.dominio.dto.DtoAsPeriodo;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsAsistenciadiariaRpt;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001Empleado;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001Faltadia;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001Licencias;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001MarcaNew;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001ReporteOficialMinisterio;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001Sobretiempo;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001Vacacion;
import net.royal.erp.core.dao.EmpleadomastDao;
import net.royal.erp.core.dao.ParametrosmastDao;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.core.dominio.dto.DtoEmpleadomast;
import net.royal.erp.core.dominio.dto.DtoPersonamast;
import net.royal.erp.core.servicio.EmpleadomastServicio;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioEmpleadomast")
public class EmpleadomastServicioImpl extends GenericoServicioImpl implements EmpleadomastServicio {

	private EmpleadomastDao dao;
	private AsEmpleadoexcepcionDao daoEmpleadoExcepcion;
	private AsTipohorarioDao daoTipoHorario;
	private ParametrosmastDao daoParametros;
	private AsTipodiaasistenciaDao daoTipoDia;
	private AsConceptoaccesoDao daoConceptoAcceso;

	private static Log LOGGER = LogFactory.getLog(EmpleadomastServicioImpl.class);

	@Autowired
	public void setDaoConceptoAcceso(AsConceptoaccesoDao daoConceptoAcceso) {
		this.daoConceptoAcceso = daoConceptoAcceso;
	}

	@Autowired
	public void setDaoTipoDia(AsTipodiaasistenciaDao daoTipoDia) {
		this.daoTipoDia = daoTipoDia;
	}

	@Autowired
	public void setDaoParametros(ParametrosmastDao daoParametros) {
		this.daoParametros = daoParametros;
	}

	@Autowired
	public void setDaoTipoHorario(AsTipohorarioDao daoTipoHorario) {
		this.daoTipoHorario = daoTipoHorario;
	}

	@Autowired
	public void setDaoEmpleadoExcepcion(AsEmpleadoexcepcionDao daoEmpleadoExcepcion) {
		this.daoEmpleadoExcepcion = daoEmpleadoExcepcion;
	}

	@Autowired
	public void setDao(EmpleadomastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Integer obtenerMaximoEmpleado(String userid) {
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_userid", String.class, userid));
		return dao.contar("empleadomast.obtenerMaximoEmpleado", filtros);
	}

	@Override
	public Integer obtenerSolicitadoPor(String userid) {
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_userid", String.class, userid));
		return dao.contar("empleadomast.obtenerSolicitadoPor", filtros);
	}

	@Override
	public String obtenerSucursal(Integer empleado) {
		String retorno = null;
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));

		List data = dao.listarPorQuery(DtoEmpleadomast.class, "empleadomast.obtenerSucursal", filtros);

		if (!UValidador.esListaVacia(data)) {
			retorno = ((DtoEmpleadomast) data.get(0)).getSucursal();
		}

		return retorno;
	}

	@Override
	public Integer obtenerUsuarioMaximo(String codigoUsuario) {
		return dao.obtenerMaximoEmpleado(codigoUsuario);
	}

	public Empleadomast obtenerEmpleadoMast(Integer p_empleado) {
		return dao.obtenerEmpleadoMast(p_empleado);
	}

	@Override
	public String obtenerTipoContrato(Integer empleado) {
		String retorno = null;
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));

		List data = dao.listarPorQuery(DtoEmpleadomast.class, "empleadomast.obtenerTipoContrato", filtros);

		if (!UValidador.esListaVacia(data)) {
			retorno = ((DtoEmpleadomast) data.get(0)).getTipocontrato();
		}

		return retorno;
	}

	@Override
	public Empleadomast obtenerPorCodigoUsuario(String codigoUsuario) {
		return dao.obtenerPorCodigoUsuario(codigoUsuario);
	}

	@Override
	public String obtenerNombreCargoEmpleado(Integer par_empleado, String par_compania) {
		return dao.obtenerNombreCargoEmpleado(par_empleado, par_compania);
	}

	public List listardwList(String sb) {
		return dao.listardwList(sb);
	}

	public List listarEmpleadoEval(String sb) {
		return dao.listarEmpleadoEval(sb);
	}

	@Override
	public BigDecimal obtenerCodigoCargo(Integer empleado) {
		// TODO Auto-generated method stub
		return dao.obtenerCodigoCargo(empleado);
	}

	@Override
	public List<DtoDwAsRep001Empleado> listarEmpleadosReporteAsistencia(String todos, String empleado, Integer sid,
			String user, String compania, String centrocosto, String sucursal, String categoria, String tipoplanilla,
			Integer area, Integer cargo) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();

		if (UValidador.estaVacio(compania))
			compania = null;
		if (UValidador.estaVacio(centrocosto))
			centrocosto = null;
		if (UValidador.estaVacio(sucursal))
			sucursal = null;
		if (UValidador.estaVacio(categoria))
			categoria = null;
		if (UValidador.estaVacio(tipoplanilla))
			tipoplanilla = null;
		if (UValidador.estaVacio(area))
			area = null;
		if (UValidador.estaVacio(cargo))
			cargo = null;

		parametros.add(new ParametroPersistenciaGenerico("todos", String.class, todos));
		parametros.add(new ParametroPersistenciaGenerico("user", String.class, user));
		parametros.add(new ParametroPersistenciaGenerico("sid", Integer.class, sid));
		parametros.add(new ParametroPersistenciaGenerico("compania", String.class, compania));
		parametros.add(new ParametroPersistenciaGenerico("centrocosto", String.class, centrocosto));
		parametros.add(new ParametroPersistenciaGenerico("sucursal", String.class, sucursal));
		parametros.add(new ParametroPersistenciaGenerico("categoria", String.class, categoria));
		parametros.add(new ParametroPersistenciaGenerico("tipoplanilla", String.class, tipoplanilla));
		parametros.add(new ParametroPersistenciaGenerico("area", Integer.class, area));
		parametros.add(new ParametroPersistenciaGenerico("cargo", Integer.class, cargo));

		StringBuilder sb = new StringBuilder(
				dao.getSesionActual().getNamedQuery("empleadomast.ListarEmpleadoReporteAsistencia").getQueryString());
		sb.append(System.lineSeparator() + "AND  ( EmpleadoMast.Empleado in ("
				+ (UValidador.estaVacio(empleado) ? "''" : empleado) + ") or  :todos = 'S') ");

		sb.append(" ORDER BY EmpleadoMast.Empleado ");

		return (List) dao.listarPorSentenciaSQL(DtoDwAsRep001Empleado.class, sb, parametros);
	}

	@Override
	public List<DtoDwAsRep001MarcaNew> listarEmpleadosReporteAsistenciaMarca(String todos, String empleado, Integer sid,
			String user, Date fechadesde, Date fechahasta) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("todos", String.class, todos));
		parametros.add(new ParametroPersistenciaGenerico("sid", Integer.class, sid));
		parametros.add(new ParametroPersistenciaGenerico("user", String.class, user));
		parametros.add(new ParametroPersistenciaGenerico("fechadesde", Date.class, fechadesde));
		parametros.add(new ParametroPersistenciaGenerico("fechahasta", Date.class, fechahasta));

		StringBuilder sb = new StringBuilder(dao.getSesionActual()
				.getNamedQuery("empleadomast.ListarEmpleadoReporteAsistenciaMarca").getQueryString());
		sb.append(System.lineSeparator() + "AND  ( EmpleadoMast.Empleado in ("
				+ (UValidador.estaVacio(empleado) ? "''" : empleado) + ") or  :todos = 'S') " + System.lineSeparator()
				+ " UNION ALL " + System.lineSeparator());

		sb.append(dao.getSesionActual().getNamedQuery("empleadomast.ListarEmpleadoReporteAsistenciaMarca2")
				.getQueryString());

		sb.append(System.lineSeparator() + "AND  ( EmpleadoMast.Empleado in ("
				+ (UValidador.estaVacio(empleado) ? "''" : empleado) + ") or  :todos = 'S') ");

		return (List) dao.listarPorSentenciaSQL(DtoDwAsRep001MarcaNew.class, sb, parametros);
	}

	@Override
	public List<DtoDwAsRep001Sobretiempo> listarEmpleadosReporteAsistenciaSobretiempo(String todos, String empleado,
			Integer sid, String user, Date fechadesde, Date fechahasta) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("todos", String.class, todos));
		parametros.add(new ParametroPersistenciaGenerico("sid", Integer.class, sid));
		parametros.add(new ParametroPersistenciaGenerico("user", String.class, user));
		parametros.add(new ParametroPersistenciaGenerico("fechadesde", Date.class, fechadesde));
		parametros.add(new ParametroPersistenciaGenerico("fechahasta", Date.class, fechahasta));

		parametros.add(new ParametroPersistenciaGenerico("empleado", String.class, empleado));

		List data = dao.listarPorQuery(DtoDwAsRep001Sobretiempo.class, "empleadomast.ListarSobreTiempo", parametros);
		return data;

		// String group = " group by EmpleadoMast.Empleado, " +
		// "PersonaMast.TipoDocumento, PersonaMast.Documento,"
		// + "PersonaMast.NombreCompleto," + "EmpleadoMast.CompaniaSocio,
		// EmpleadoMast.TipoPlanilla,"
		// + "EmpleadoMast.LocaciondePago, "
		// + "EmpleadoMast.CentroCostos,
		// EmpleadoMast.Sucursal,EmpleadoMast.TipoHorario,"
		// + "AS_CarnetIdentificacion.Area," +
		// "as_asistenciadiaria.conceptoacceso," + "AS_AsistenciaDiaria.Fecha,"
		// + "EmpleadoMast.EstadoEmpleado";
		//
		// StringBuilder sb = new StringBuilder(dao.getSesionActual()
		// .getNamedQuery("empleadomast.ListarEmpleadoReporteAsistenciaSobretiempo").getQueryString());
		// sb.append(System.lineSeparator() + "AND ( EmpleadoMast.Empleado in ("
		// + (UValidador.estaVacio(empleado) ? "''" : empleado) + ") or :todos =
		// 'S') " + System.lineSeparator()
		// + group + System.lineSeparator() + " UNION " +
		// System.lineSeparator());
		//
		// sb.append(dao.getSesionActual().getNamedQuery("empleadomast.ListarEmpleadoReporteAsistenciaSobretiempo2")
		// .getQueryString());
		//
		// sb.append(System.lineSeparator() + "AND ( EmpleadoMast.Empleado in ("
		// + (UValidador.estaVacio(empleado) ? "''" : empleado) + ") or :todos =
		// 'S') " + System.lineSeparator()
		// + group);
		//
		// LOGGER.debug("querys::" + sb);
		// return (List)
		// dao.listarPorSentenciaSQL(DtoDwAsRep001Sobretiempo.class, sb,
		// parametros);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<DtoDwAsRep001Faltadia> listarEmpleadosReporteAsistenciaFaltadia(String todos, String empleado,
			Integer sid, String user, Date fechadesde, Date fechahasta) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("todos", String.class, todos));
		parametros.add(new ParametroPersistenciaGenerico("sid", Integer.class, sid));
		parametros.add(new ParametroPersistenciaGenerico("user", String.class, user));
		parametros.add(new ParametroPersistenciaGenerico("fechadesde", Date.class, fechadesde));
		parametros.add(new ParametroPersistenciaGenerico("fechahasta", Date.class, fechahasta));

		parametros.add(new ParametroPersistenciaGenerico("empleado", String.class, empleado));

		// String group = "GROUP BY EmpleadoMast.Empleado, " +
		// "PersonaMast.TipoDocumento,PersonaMast.Documento,"
		// + "PersonaMast.NombreCompleto,EmpleadoMast.CompaniaSocio,"
		// +
		// "EmpleadoMast.TipoPlanilla,EmpleadoMast.LocaciondePago,EmpleadoMast.EstadoEmpleado,EmpleadoMast.TipoHorario,"
		// + "EmpleadoMast.CentroCostos,EmpleadoMast.Sucursal," +
		// "AS_CarnetIdentificacion.Area,"
		// + "as_asistenciadiaria.conceptoacceso," +
		// "AS_AsistenciaDiaria.Fecha";
		//
		// StringBuilder sb = new StringBuilder(dao.getSesionActual()
		// .getNamedQuery("empleadomast.ListarEmpleadoReporteAsistenciaFaltadia").getQueryString());
		// sb.append(System.lineSeparator() + "AND ( EmpleadoMast.Empleado in ("
		// + (UValidador.estaVacio(empleado) ? "''" : empleado) + ") or :todos =
		// 'S') " + System.lineSeparator()
		// + group);

		// return (List) dao.listarPorSentenciaSQL(DtoDwAsRep001Faltadia.class,
		// sb, parametros);

		List data = dao.listarPorQuery(DtoDwAsRep001Faltadia.class, "empleadomast.ListarEmpleadoFaltas", parametros);
		return data;

	}

	@Override
	public List<DtoDwAsRep001Vacacion> listarEmpleadosReporteAsistenciaVacacion(String todos, String empleado,
			Integer sid, String user, Date fechadesde, Date fechahasta) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("todos", String.class, todos));
		parametros.add(new ParametroPersistenciaGenerico("sid", Integer.class, sid));
		parametros.add(new ParametroPersistenciaGenerico("user", String.class, user));
		parametros.add(new ParametroPersistenciaGenerico("p_fechadesde", Date.class, fechadesde));
		parametros.add(new ParametroPersistenciaGenerico("p_fechahasta", Date.class, fechahasta));

		StringBuilder sb = new StringBuilder(dao.getSesionActual()
				.getNamedQuery("empleadomast.ListarEmpleadoReporteAsistenciaVacacion").getQueryString());
		sb.append(System.lineSeparator() + " AND  ( EmpleadoMast.Empleado in ("
				+ (UValidador.estaVacio(empleado) ? "''" : empleado) + ") or  :todos = 'S') ");

		return (List) dao.listarPorSentenciaSQL(DtoDwAsRep001Vacacion.class, sb, parametros);
	}

	@Override
	public List<DtoDwAsRep001Licencias> listarEmpleadosReporteAsistenciaLicencias(String todos, String empleado,
			Integer sid, String user) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("todos", String.class, todos));
		parametros.add(new ParametroPersistenciaGenerico("sid", Integer.class, sid));
		parametros.add(new ParametroPersistenciaGenerico("user", String.class, user));

		StringBuilder sb = new StringBuilder(dao.getSesionActual()
				.getNamedQuery("empleadomast.ListarEmpleadoReporteAsistenciaLicencias").getQueryString());
		sb.append(System.lineSeparator() + "AND  ( EmpleadoMast.Empleado in ("
				+ (UValidador.estaVacio(empleado) ? "''" : empleado) + ") or  :todos = 'S') ");

		return (List) dao.listarPorSentenciaSQL(DtoDwAsRep001Licencias.class, sb, parametros);
	}

	@Override
	public List<DtoDwAsRep001ReporteOficialMinisterio> obtenerListaReporteAsistencia(UsuarioActual usuario,
			net.royal.erp.asistencia.dominio.dto.DtoFiltrosGenericos filtro) throws Exception {
		Date wFechaOld;
		BigDecimal wCantidadReal2 = null;
		List<DtoDwAsRep001ReporteOficialMinisterio> dw1 = new ArrayList<DtoDwAsRep001ReporteOficialMinisterio>();
		List<AsTipohorario> dwtipohorario = daoTipoHorario.listarTipoHorarioOrden();
		SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
		List<DtoDwAsRep001Empleado> dwempleado;
		List<DtoDwAsRep001MarcaNew> dwmarca;
		List<DtoDwAsRep001Sobretiempo> dwsobretiempo;
		List<DtoDwAsRep001Faltadia> dwfalta;
		List<DtoDwAsRep001Vacacion> dwvacacion;
		List<DtoDwAsRep001Licencias> dwlicencia;

		List<AsTipodiaasistencia> tipodias = daoTipoDia.listarTipoDiaAsistencia();
		List<AsConceptoacceso> conceptos = daoConceptoAcceso.listarActivos();

		// Parametro de maximo minutos de tolerancia para las tardanzas
		// Integer maxtolerancia = daoParametros.obtenerValorInteger(new
		// ParametrosmastPk("AS", "999999", "MAXTOLERAN"));
		// Integer topetarmes = daoParametros.obtenerValorInteger(new
		// ParametrosmastPk("AS", "999999", "TOPETARMES"));

		// if (UValidador.esNulo(maxtolerancia)) {
		// maxtolerancia = 0;
		// }
		//
		// if (UValidador.esNulo(topetarmes)) {
		// topetarmes = 0;
		// }

		// Conceptos Inasistencia
		String justSubsEnferm = daoParametros.obtenerValorCadena(new ParametrosmastPk("AS", "999999", "CONCDESENF"));
		String justSubsMater = daoParametros.obtenerValorCadena(new ParametrosmastPk("AS", "999999", "CONCDESMAT"));
		String justLicSinGoce = daoParametros.obtenerValorCadena(new ParametrosmastPk("AS", "999999", "CONCDESSGO"));

		dwempleado = listarEmpleadosReporteAsistencia((UValidador.estaVacio(filtro.getCodEmpleado()) ? "S" : "N"),
				filtro.getCodEmpleado(), usuario.getUniqueIdInteger(), usuario.getLoginUsuario().toUpperCase(),
				filtro.getCodCompania(), filtro.getCodCentroCosto(), filtro.getCodSucursal(), filtro.getCodCategoria(),
				filtro.getCodPlantilla(),
				(UValidador.estaVacio(filtro.getCodAreaOperativa()) ? null
						: Integer.parseInt(filtro.getCodAreaOperativa())),
				(UValidador.estaVacio(filtro.getCodPuesto()) ? null : Integer.parseInt(filtro.getCodPuesto())));

		if (!filtro.isCesados()) {
			if (!UValidador.esListaVacia(dwempleado)) {
				for (int i = 0; i < dwempleado.size(); i++) {
					if ("2".equals(dwempleado.get(i).getEstadoempleado())) {
						dwempleado.remove(i);
						i--;
					}
				}
			}
		}

		dwmarca = listarEmpleadosReporteAsistenciaMarca((UValidador.estaVacio(filtro.getCodEmpleado()) ? "S" : "N"),
				filtro.getCodEmpleado(), usuario.getUniqueIdInteger(), usuario.getLoginUsuario().toUpperCase(),
				filtro.getFechadesde(), filtro.getFechahasta());

		dwsobretiempo = listarEmpleadosReporteAsistenciaSobretiempo(
				(UValidador.estaVacio(filtro.getCodEmpleado()) ? "S" : "N"), filtro.getCodEmpleado(),
				usuario.getUniqueIdInteger(), usuario.getLoginUsuario().toUpperCase(), filtro.getFechadesde(),
				filtro.getFechahasta());

		dwfalta = listarEmpleadosReporteAsistenciaFaltadia((UValidador.estaVacio(filtro.getCodEmpleado()) ? "S" : "N"),
				filtro.getCodEmpleado(), usuario.getUniqueIdInteger(), usuario.getLoginUsuario().toUpperCase(),
				filtro.getFechadesde(), filtro.getFechahasta());

		dwvacacion = listarEmpleadosReporteAsistenciaVacacion(
				(UValidador.estaVacio(filtro.getCodEmpleado()) ? "S" : "N"), filtro.getCodEmpleado(),
				usuario.getUniqueIdInteger(), usuario.getLoginUsuario().toUpperCase(),
				UFechaHora.obtenerFechaHoraInicioDiaDate(filtro.getFechadesde()),
				UFechaHora.obtenerFechaHoraFinDia(filtro.getFechahasta()));

		dwlicencia = listarEmpleadosReporteAsistenciaLicencias(
				(UValidador.estaVacio(filtro.getCodEmpleado()) ? "S" : "N"), filtro.getCodEmpleado(),
				usuario.getUniqueIdInteger(), usuario.getLoginUsuario().toUpperCase());

		// Sortear :)
		Collections.sort(dwmarca, new Comparator<DtoDwAsRep001MarcaNew>() {
			@Override
			public int compare(DtoDwAsRep001MarcaNew a, DtoDwAsRep001MarcaNew b) {
				Date x = a.getFecha();
				Date y = b.getFecha();

				if (x.after(y))
					return 1;
				else if (x.before(y))
					return -1;
				else
					return 0;
			}
		});
		// Sortear :)
		Collections.sort(dwsobretiempo, new Comparator<DtoDwAsRep001Sobretiempo>() {
			@Override
			public int compare(DtoDwAsRep001Sobretiempo a, DtoDwAsRep001Sobretiempo b) {
				Date x = a.getFecha();
				Date y = b.getFecha();

				if (x.after(y))
					return 1;
				else if (x.before(y))
					return -1;
				else
					return 0;
			}
		});
		// Sortear :)
		Collections.sort(dwfalta, new Comparator<DtoDwAsRep001Faltadia>() {
			@Override
			public int compare(DtoDwAsRep001Faltadia a, DtoDwAsRep001Faltadia b) {
				Date x = a.getFecha();
				Date y = b.getFecha();

				if (x.after(y))
					return 1;
				else if (x.before(y))
					return -1;
				else
					return 0;
			}
		});

		for (DtoDwAsRep001Empleado dw_empleado : dwempleado) {

			// Marcas
			wFechaOld = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1900");

			for (DtoDwAsRep001MarcaNew dw_marca : dwmarca) {
				if (dw_marca.getEmpleado().equals(dw_empleado.getEmpleado())) {
					if (!UFechaHora.convertirFechaCadena(wFechaOld, "dd/MM/yyyy")
							.equals(UFechaHora.convertirFechaCadena(dw_marca.getFecha(), "dd/MM/yyyy"))) {
						DtoDwAsRep001ReporteOficialMinisterio row = new DtoDwAsRep001ReporteOficialMinisterio();
						row.setEmpleado(dw_empleado.getEmpleado().intValue());
						row.setTipodocumento(dw_empleado.getTipodocumento());
						row.setDocumento(dw_empleado.getDocumento());
						row.setNombrecompleto(dw_empleado.getNombrecompleto());
						row.setEstadoempleado(dw_empleado.getEstadoempleado());
						row.setCompaniasocio(dw_empleado.getCompaniasocio());
						row.setTipoplanilla(dw_empleado.getTipoplanilla());
						row.setLocaciondepago(dw_empleado.getLocaciondepago());
						row.setCentrocostos(dw_empleado.getCentrocostos());
						row.setSucursal(dw_empleado.getSucursal());
						row.setArea(UValidador.esNulo(dw_empleado.getArea()) ? null : dw_empleado.getArea().intValue());
						row.setFecha(dw_marca.getFecha());

						switch (UValidador.esNulo(dw_marca.getSecuencia()) ? 0 : dw_marca.getSecuencia().intValue()) {
						case 1:
							row.setHora1(dw_marca.getHora());
							break;
						case 2:
							row.setHora2(dw_marca.getHora());
							break;
						case 3:
							row.setHora3(dw_marca.getHora());
							break;
						case 4:
							row.setHora4(dw_marca.getHora());
							break;
						case 5:
							row.setHora5(dw_marca.getHora());
							break;
						case 6:
							row.setHora6(dw_marca.getHora());
							break;
						}

						row.setTipohorario(0);
						if (!dw_marca.getTipohorario().equals(BigDecimal.ZERO)) {
							row.setTipohorario(dw_marca.getTipohorario().intValue());
						} else {
							if (!UValidador.esNulo(dw_empleado.getTipohorario())) {
								if (!dw_empleado.getTipohorario().equals(BigDecimal.ZERO)) {
									row.setTipohorario(dw_empleado.getTipohorario().intValue());
								}
							}
						}
						// es reemplazo por el de arriba
						// row.setTipohorario((UValidador.esCero(dw_marca.getTipohorario().intValue())
						// ? dw_empleado.getTipohorario().intValue() :
						// dw_marca.getTipohorario().intValue()));

						row.setTipodia(obtenerTipoDia(row.getEmpleado(), dw_marca.getFecha(), dwtipohorario,
								dw_marca.getTipodia().intValue(), row.getTipohorario().intValue()));

						if (row.getTipodia() == 0) {
							row.setConceptofalta("20");
						}
						dw1.add(row);
						wFechaOld = dw_marca.getFecha();
					} else {// Seteo de hora
						switch (UValidador.esNulo(dw_marca.getSecuencia()) ? 0 : dw_marca.getSecuencia().intValue()) {
						case 1:
							dw1.get(dw1.size() - 1).setHora1(dw_marca.getHora());
							break;
						case 2:
							dw1.get(dw1.size() - 1).setHora2(dw_marca.getHora());
							break;
						case 3:
							dw1.get(dw1.size() - 1).setHora3(dw_marca.getHora());
							break;
						case 4:
							dw1.get(dw1.size() - 1).setHora4(dw_marca.getHora());
							break;
						case 5:
							dw1.get(dw1.size() - 1).setHora5(dw_marca.getHora());
							break;
						case 6:
							dw1.get(dw1.size() - 1).setHora6(dw_marca.getHora());
							break;
						}
						if (dw1.get(dw1.size() - 1).getTipodia() == 0) {
							dw1.get(dw1.size() - 1).setConceptofalta("20");
						}
					}
				}
			}
		}

		// Sobretiempo y tardanzas
		for (DtoDwAsRep001Sobretiempo dw_sobretiempo : dwsobretiempo) {

			// Bloque de Codigo: Act 09-ene2013 LBL
			if (!UValidador.esNulo(dw_sobretiempo.getEmpleado()) && !UValidador.esNulo(dw_sobretiempo.getCantidadreal())
					&& !UValidador.esNulo(dw_sobretiempo.getConceptoacceso())) {

				// for (DtoDwAsRep001Empleado dw_empleado : dwempleado) {
				boolean existe = false;
				for (DtoDwAsRep001ReporteOficialMinisterio dw_1 : dw1) {
					if (dw_1.getEmpleado().equals(dw_sobretiempo.getEmpleado().intValue())
							&& df.format(dw_1.getFecha()).equals(df.format(dw_sobretiempo.getFecha()))) {
						existe = true;
					}
				}
				if (!existe) {
					DtoDwAsRep001ReporteOficialMinisterio row = new DtoDwAsRep001ReporteOficialMinisterio();
					row.setEmpleado(dw_sobretiempo.getEmpleado().intValue());
					row.setTipodocumento(dw_sobretiempo.getTipodocumento());
					row.setDocumento(dw_sobretiempo.getDocumento());
					row.setNombrecompleto(dw_sobretiempo.getNombrecompleto());
					row.setEstadoempleado(dw_sobretiempo.getEstadoempleado());
					row.setCompaniasocio(dw_sobretiempo.getCompaniasocio());
					row.setTipoplanilla(dw_sobretiempo.getTipoplanilla());
					row.setLocaciondepago(dw_sobretiempo.getLocaciondepago());
					row.setCentrocostos(dw_sobretiempo.getCentrocostos());
					row.setSucursal(dw_sobretiempo.getSucursal());
					row.setArea(
							UValidador.esNulo(dw_sobretiempo.getArea()) ? null : dw_sobretiempo.getArea().intValue());
					row.setFecha(dw_sobretiempo.getFecha());
					row.setTipohorario((UValidador.esCero(dw_sobretiempo.getTipohorario().intValue())
							? dw_sobretiempo.getTipohorarioempleado().intValue()
							: dw_sobretiempo.getTipohorario().intValue()));
					row.setTipodia(obtenerTipoDia(row.getEmpleado(), dw_sobretiempo.getFecha(), dwtipohorario,
							dw_sobretiempo.getTipodia().intValue(), row.getTipohorario().intValue()));
					if (row.getTipodia() == 0) {
						row.setConceptofalta("20");
					}
					dw1.add(row);
				}
				// }

			} //
				// saque for

		}

		BigDecimal tempTotalTrdTole = BigDecimal.ZERO;

		for (DtoDwAsRep001ReporteOficialMinisterio dw_1 : dw1) {
			wCantidadReal2 = BigDecimal.ZERO;
			for (DtoDwAsRep001Sobretiempo sob : dwsobretiempo) {
				if (dw_1.getEmpleado().equals(sob.getEmpleado().intValue())
						&& df.format(sob.getFecha()).equals(df.format(dw_1.getFecha()))) {

					if (// sob.getConceptoacceso().equals("HSOB") ||//
					// sob.getConceptoacceso().equals("HAUT")
					// ||
					sob.getConceptoacceso().equals("HNAU")
					// || sob.getConceptoacceso().equals("40")
					) {

						wCantidadReal2 = (UValidador.esNulo(wCantidadReal2) ? BigDecimal.ZERO : wCantidadReal2)
								.add(sob.getCantidadreal());
					}
					LOGGER.debug("CONCEPTO TARDANZA " + sob.getConceptoacceso());
					if (sob.getConceptoacceso().equals("TARD")) {
						dw_1.setTardanza(sob.getCantidadreal().setScale(4, BigDecimal.ROUND_FLOOR));
					}
					if (sob.getConceptoacceso().equals("TART")) {
						dw_1.setTardanzaConTolerancia(sob.getCantidadreal().setScale(4, BigDecimal.ROUND_FLOOR));
					}

					// if (sob.getConceptoacceso().equals("TARD") ||
					// sob.getConceptoacceso().equals("TART")) {
					//
					// if (obtenerMinutos(sob.getCantidadreal()) >
					// maxtolerancia) {
					// dw_1.setTardanza(sob.getCantidadreal());
					// } else {
					// tempTotalTrdTole =
					// tempTotalTrdTole.add(sob.getCantidadreal());
					// // Si pasamos el máximo de la tolerancia mensual
					// // los
					// // minutos restantes se considreran como tardanza
					// if (obtenerMinutos(tempTotalTrdTole) > topetarmes) {
					// Integer min1 = obtenerMinutos(sob.getCantidadreal());
					// Integer min2 = obtenerMinutos(tempTotalTrdTole);
					// BigDecimal difer = convertirMinutosToHora(min1 - (min2 -
					// topetarmes));
					//
					// // en tardanza colocamos
					// // obtenerMinutos(tempTotalTrdTole) - topetarmes
					// dw_1.setTardanzaConTolerancia(difer);
					// dw_1.setTardanza(
					// sob.getCantidadreal().subtract(difer).setScale(2,
					// RoundingMode.HALF_UP));
					// } else {
					// dw_1.setTardanzaConTolerancia(sob.getCantidadreal());
					// }
					// }
					// }
				}

			}
			dw_1.setSobretiempo(wCantidadReal2);
		}

		// Faltas
		for (DtoDwAsRep001Faltadia dw_falta : dwfalta) {
			// Bloque de Codigo: Act 09-ene2013 LBL
			if (!UValidador.esNulo(dw_falta.getEmpleado()) && !UValidador.esNulo(dw_falta.getFecha())
					&& !UValidador.esNulo(dw_falta.getConceptoacceso())) {
				// for (DtoDwAsRep001Empleado dw_empleado : dwempleado) {
				// if (dw_empleado.getEmpleado().equals(dw_falta.getEmpleado()))
				// {
				boolean existe = false;
				for (DtoDwAsRep001ReporteOficialMinisterio dw_1 : dw1) {
					if (dw_1.getEmpleado().equals(dw_falta.getEmpleado().intValue())
							&& df.format(dw_1.getFecha()).equals(df.format(dw_falta.getFecha()))) {
						existe = true;
					}
				}

				if (!existe) {
					DtoDwAsRep001ReporteOficialMinisterio row = new DtoDwAsRep001ReporteOficialMinisterio();
					row.setEmpleado(dw_falta.getEmpleado().intValue());
					row.setTipodocumento(dw_falta.getTipodocumento());
					row.setDocumento(dw_falta.getDocumento());
					row.setNombrecompleto(dw_falta.getNombrecompleto());
					row.setEstadoempleado(dw_falta.getEstadoempleado());
					row.setCompaniasocio(dw_falta.getCompaniasocio());
					row.setTipoplanilla(dw_falta.getTipoplanilla());
					row.setLocaciondepago(dw_falta.getLocaciondepago());
					row.setCentrocostos(dw_falta.getCentrocostos());
					row.setSucursal(dw_falta.getSucursal());
					row.setArea(UValidador.esNulo(dw_falta.getArea()) ? null : dw_falta.getArea().intValue());
					row.setFecha(dw_falta.getFecha());
					row.setTipohorario((UValidador.esCero(dw_falta.getTipohorario().intValue())
							? dw_falta.getTipohorarioempleado().intValue() : dw_falta.getTipohorario().intValue()));
					row.setTipodia(obtenerTipoDia(row.getEmpleado(), dw_falta.getFecha(), dwtipohorario,
							dw_falta.getTipodia().intValue(), row.getTipohorario().intValue()));
					if (row.getTipodia() == 0) {
						row.setConceptofalta("20");
					}
					dw1.add(row);
				}

				// break;
				// }
				// }
			}
			//
			for (DtoDwAsRep001ReporteOficialMinisterio dw_1 : dw1) {
				if (dw_1.getEmpleado().equals(dw_falta.getEmpleado().intValue())
						&& df.format(dw_1.getFecha()).equals(df.format(dw_falta.getFecha()))) {
					dw_1.setCantidadconceptofalta(1);
					if (dw_falta.getConceptoacceso().equals("INAS") && !dw_1.getConceptofalta().equals("MAIM")) {
						dw_1.setHora1(null);
						dw_1.setConceptofalta(dw_falta.getConceptoacceso());
					} else if (dw_falta.getConceptoacceso().equals("15")) {
						dw_1.setFaltaporhora(dw_falta.getCantidadreal());
						dw_1.setConceptofalta(dw_falta.getConceptoacceso());
					} else if (dw_falta.getConceptoacceso().equals("22")) {
						dw_1.setPermisopersonaldias(dw_falta.getCantidadreal());
					} else if (dw_falta.getConceptoacceso().equals("55")) {
						dw_1.setPermisopersonalhoras(dw_falta.getCantidadreal());
					} else { // No mostrar cantidad, Si mostrar descripcion
						dw_1.setConceptofalta(dw_falta.getConceptoacceso());
						if (dw_falta.getConceptoacceso().equals("INAS")) {
							dw_1.setHora1(null);
						}
					}
					break;
				}
			}
		}

		// Vacaciones
		for (DtoDwAsRep001Vacacion dw_vacacion : dwvacacion) {
			int diasTrans = UFechaHora.obtenerDiasTranscurridos(dw_vacacion.getFechafin(), dw_vacacion.getFechainicio())
					+ 1;

			for (int i = 0; i < diasTrans; i++) {
				Date wFecha = UFechaHora.anadirDiasAFechas(dw_vacacion.getFechainicio(), i);

				// Bloque de Codigo: Act 09-ene2013 LBL
				if (!UValidador.esNulo(dw_vacacion.getEmpleado()) && !UValidador.esNulo(wFecha)
						&& ((wFecha.after(filtro.getFechadesde()) || wFecha.equals(filtro.getFechadesde()))
								&& (wFecha.before(filtro.getFechahasta()) || wFecha.equals(filtro.getFechahasta())))) {
					// for (DtoDwAsRep001Empleado dw_empleado : dwempleado) {
					// if
					// (dw_empleado.getEmpleado().equals(dw_vacacion.getEmpleado()))
					// {
					boolean existe = false;
					for (DtoDwAsRep001ReporteOficialMinisterio dw_1 : dw1) {
						if (dw_1.getEmpleado().equals(dw_vacacion.getEmpleado().intValue())
								&& df.format(dw_1.getFecha()).equals(df.format(wFecha))) {
							existe = true;
						}
					}

					if (!existe) {
						DtoDwAsRep001ReporteOficialMinisterio row = new DtoDwAsRep001ReporteOficialMinisterio();
						row.setEmpleado(dw_vacacion.getEmpleado().intValue());
						row.setTipodocumento(dw_vacacion.getTipodocumento());
						row.setDocumento(dw_vacacion.getDocumento());
						row.setNombrecompleto(dw_vacacion.getNombrecompleto());
						row.setEstadoempleado(dw_vacacion.getEstadoempleado());
						row.setCompaniasocio(dw_vacacion.getCompaniasocio());
						row.setTipoplanilla(dw_vacacion.getTipoplanilla());
						row.setLocaciondepago(dw_vacacion.getLocaciondepago());
						row.setCentrocostos(dw_vacacion.getCentrocostos());
						row.setSucursal(dw_vacacion.getSucursal());
						row.setArea(UValidador.esNulo(dw_vacacion.getArea()) ? null : dw_vacacion.getArea().intValue());
						row.setFecha(wFecha);
						row.setTipohorario((UValidador.esNulo(dw_vacacion.getTipohorario()) ? null
								: dw_vacacion.getTipohorario().intValue()));
						row.setTipodia(obtenerTipoDia(row.getEmpleado(), wFecha, dwtipohorario));
						if (row.getTipodia() == 0) {
							row.setConceptofalta("20");
						}
						dw1.add(row);
					}

					// break;
					// }
					// }
				}
				//
				for (DtoDwAsRep001ReporteOficialMinisterio dw_1 : dw1) {
					if (dw_1.getEmpleado().equals(dw_vacacion.getEmpleado().intValue())
							&& df.format(dw_1.getFecha()).equals(df.format(wFecha))) {
						dw_1.setConceptofalta("VACA");
						break;
					}
				}
			}
		}

		// Licencias
		for (DtoDwAsRep001Licencias dw_licencia : dwlicencia) {
			int diasTrans = UFechaHora.obtenerDiasTranscurridos(dw_licencia.getFechafinal(),
					dw_licencia.getFechainicio()) + 1;

			for (int i = 0; i < diasTrans; i++) {
				Date wFecha = UFechaHora.anadirDiasAFechas(dw_licencia.getFechainicio(), i);

				// Bloque de Codigo: Act 09-ene2013 LBL
				if (!UValidador.esNulo(dw_licencia.getEmpleado()) && !UValidador.esNulo(wFecha)
						&& !UValidador.esNulo(dw_licencia.getTipolicencia())
						&& ((wFecha.after(filtro.getFechadesde()) || wFecha.equals(filtro.getFechadesde()))
								&& (wFecha.before(filtro.getFechahasta()) || wFecha.equals(filtro.getFechahasta())))) {
					// for (DtoDwAsRep001Empleado dw_empleado : dwempleado) {
					// if
					// (dw_empleado.getEmpleado().equals(dw_licencia.getEmpleado()))
					// {
					boolean existe = false;
					for (DtoDwAsRep001ReporteOficialMinisterio dw_1 : dw1) {
						if (dw_1.getEmpleado().equals(dw_licencia.getEmpleado().intValue())
								&& df.format(dw_1.getFecha()).equals(df.format(wFecha))) {
							existe = true;
						}
					}

					if (!existe) {
						DtoDwAsRep001ReporteOficialMinisterio row = new DtoDwAsRep001ReporteOficialMinisterio();
						row.setEmpleado(dw_licencia.getEmpleado().intValue());
						row.setTipodocumento(dw_licencia.getTipodocumento());
						row.setDocumento(dw_licencia.getDocumento());
						row.setNombrecompleto(dw_licencia.getNombrecompleto());
						row.setEstadoempleado(dw_licencia.getEstadoempleado());
						row.setCompaniasocio(dw_licencia.getCompaniasocio());
						row.setTipoplanilla(dw_licencia.getTipoplanilla());
						row.setLocaciondepago(dw_licencia.getLocaciondepago());
						row.setCentrocostos(dw_licencia.getCentrocostos());
						row.setSucursal(dw_licencia.getSucursal());
						row.setArea(UValidador.esNulo(dw_licencia.getArea()) ? null : dw_licencia.getArea().intValue());
						row.setFecha(wFecha);
						row.setTipohorario((UValidador.esNulo(dw_licencia.getTipohorario()) ? null
								: dw_licencia.getTipohorario().intValue()));
						row.setTipodia(obtenerTipoDia(row.getEmpleado(), wFecha, dwtipohorario));
						if (row.getTipodia() == 0) {
							row.setConceptofalta("20");
						}
						dw1.add(row);
					}

					// break;
					// }
					// }
				}
				//

				for (DtoDwAsRep001ReporteOficialMinisterio dw_1 : dw1) {
					if (dw_1.getEmpleado().equals(dw_licencia.getEmpleado().intValue())
							&& df.format(dw_1.getFecha()).equals(df.format(wFecha))) {
						switch (dw_licencia.getTipolicencia()) {
						case "07":
							dw_1.setConceptofalta(justSubsEnferm);
							break;
						case "08":
							dw_1.setConceptofalta(justSubsMater);
							break;
						case "09":
							dw_1.setConceptofalta(justLicSinGoce);
							break;
						}
						break;
					}
				}
			}
		}

		// Filters
		LOGGER.debug("FILTER CONCEPTO ACCESO " + filtro.getConceptoacceso());
		for (int i = 0; i < dw1.size(); i++) {
			if (!UValidador.esNulo(filtro.getConceptoacceso())) {
				if (filtro.getConceptoacceso().equals("HE")) {
					if (!((UValidador.esNulo(dw1.get(i).getSobretiempo()) ? BigDecimal.ZERO
							: dw1.get(i).getSobretiempo()).compareTo(BigDecimal.ZERO) == 1)) {
						dw1.remove(i);
						i--;
					}
				} else if (filtro.getConceptoacceso().equals("TA")) {
					if (!((UValidador.esNulo(dw1.get(i).getTardanza()) ? BigDecimal.ZERO : dw1.get(i).getTardanza())
							.compareTo(BigDecimal.ZERO) == 1)) {
						dw1.remove(i);
						i--;
					}
				} else if (filtro.getConceptoacceso().equals("FH")) {
					if (!((UValidador.esNulo(dw1.get(i).getFaltaporhora()) ? BigDecimal.ZERO
							: dw1.get(i).getFaltaporhora()).compareTo(BigDecimal.ZERO) == 1)) {
						dw1.remove(i);
						i--;
					}
				} else if (filtro.getConceptoacceso().equals("FA")) {
					if (UValidador.estaVacio(dw1.get(i).getConceptofalta())) {
						dw1.remove(i);
						i--;
					}
				}
			}
		}
		// Fin FIlters

		List<Integer> empleados = new ArrayList<Integer>();

		for (DtoDwAsRep001ReporteOficialMinisterio dw : dw1) {

			if (!empleados.contains(dw.getEmpleado())) {
				empleados.add(dw.getEmpleado());
			}

			for (AsTipodiaasistencia tda : tipodias) {
				if (tda.getPk().getTipodia().equals(dw.getTipodia())) {
					dw.setTipodiadescripcion(tda.getDescripcionlocal());
					break;
				}
			}
			for (AsConceptoacceso con : conceptos) {
				if (con.getPk().getConceptoacceso().equals(dw.getConceptofalta())) {
					dw.setConceptofaltadescripcion(con.getDescripcionlocal());
					break;
				}
			}

			if (!UValidador.esNulo(dw.getSobretiempo())) {
				if (!dw.getSobretiempo().equals(BigDecimal.ZERO)) {
					dw.setSobretiempodescripcion(obtenerHorasAcumuladas(dw.getSobretiempo()));
				}
			}

			if (!UValidador.esNulo(dw.getTardanza())) {
				LOGGER.debug("dw.getTardanza() " + dw.getTardanza());
				if (!dw.getTardanza().equals(BigDecimal.ZERO)) {
					dw.setTardanzadescripcion(obtenerHorasAcumuladas(dw.getTardanza()));
				}

				if (!UValidador.esNulo(dw.getTardanzaConTolerancia())) {
					LOGGER.debug("dw.getTardanza() " + dw.getTardanzaConTolerancia());
					if (!dw.getTardanzaConTolerancia().equals(BigDecimal.ZERO)) {
						dw.setTardanzatoleranciadescripcion(obtenerHorasAcumuladas(dw.getTardanzaConTolerancia()));
					}
				}

			}

			if (!UValidador.esNulo(dw.getFaltaporhora())) {
				if (!dw.getFaltaporhora().equals(BigDecimal.ZERO)) {
					dw.setFaltaporhoradescripcion(obtenerHorasAcumuladas(dw.getFaltaporhora()));
				}
			}

			if (!UValidador.esNulo(dw.getPermisopersonalhoras())) {
				if (!dw.getPermisopersonalhoras().equals(BigDecimal.ZERO)) {
					dw.setPermisopersonalhorasdescripcion(obtenerHorasAcumuladas(dw.getPermisopersonalhoras()));
				}
			}

			// el 24 y 31 de diciembre debe salir en blanco
			if ("08".equals(dw.getConceptofalta())) {
				if (UFechaHora.convertirFechaCadena(dw.getFecha(), "dd/MM/yyyy").equals("24/12/2019")
						|| UFechaHora.convertirFechaCadena(dw.getFecha(), "dd/MM/yyyy").equals("31/12/2019")) {
					dw.setConceptofaltadescripcion("");
				}
			}
		}

		for (Integer e : empleados) {
			BigDecimal totalPermanencia = BigDecimal.ZERO;
			BigDecimal totalTardanza = BigDecimal.ZERO;
			BigDecimal totalToleranciaTardanza = BigDecimal.ZERO;
			BigDecimal totalTotalPermisos = BigDecimal.ZERO;

			BigDecimal totalGanadas = BigDecimal.ZERO;
			BigDecimal totalComp = BigDecimal.ZERO;
			BigDecimal totalFeriaRecu = BigDecimal.ZERO;

			BigDecimal totalPermisoPerDia = BigDecimal.ZERO;
			BigDecimal totalPermisoPerHor = BigDecimal.ZERO;

			// reporte detallado
			List<DtoDwAsAsistenciadiariaRpt> detallado = listarReporteAsistenciaCasiDetallada(e, filtro.getFechadesde(),
					filtro.getFechahasta(), usuario.getUniqueIdInteger(), usuario.getCodigoUsuario());
			// fin detallado

			for (DtoDwAsRep001ReporteOficialMinisterio dw : dw1) {
				if (e.equals(dw.getEmpleado())) {
					totalPermanencia = totalPermanencia
							.add(UValidador.esNulo(dw.getSobretiempo()) ? BigDecimal.ZERO : dw.getSobretiempo());

					// if (obtenerMinutos(dw.getTardanza()) > maxtolerancia) {
					totalTardanza = totalTardanza
							.add(UValidador.esNulo(dw.getTardanza()) ? BigDecimal.ZERO : dw.getTardanza());
					// } else {
					totalToleranciaTardanza = totalToleranciaTardanza
							.add(UValidador.esNulo(dw.getTardanzaConTolerancia()) ? BigDecimal.ZERO
									: dw.getTardanzaConTolerancia());
					// }

					totalTotalPermisos = totalTotalPermisos
							.add(UValidador.esNulo(dw.getFaltaporhora()) ? BigDecimal.ZERO : dw.getFaltaporhora());

					totalPermisoPerDia = totalPermisoPerDia.add(UValidador.esNulo(dw.getPermisopersonaldias())
							? BigDecimal.ZERO : dw.getPermisopersonaldias());

					totalPermisoPerHor = totalPermisoPerHor.add(UValidador.esNulo(dw.getPermisopersonalhoras())
							? BigDecimal.ZERO : dw.getPermisopersonalhoras());

					// Detallado
					for (DtoDwAsAsistenciadiariaRpt det : detallado) {

						if (df.format(det.getFecha()).equals(df.format(dw.getFecha()))
								&& dw.getEmpleado().equals(det.getEmpleado().intValue())) {

							if ("HAUT".equals(det.getConceptoacceso()) && "+".equals(det.getFlagcompensacion())) {

								// dw.setGanadas(det.getCantidadreal().setScale(4,
								// BigDecimal.ROUND_HALF_UP));
								// dw.setGanadasdescripcion(obtenerHorasAcumuladas(det.getCantidadreal()));
								if (dw.getGanadas() == null) {
									dw.setGanadas(BigDecimal.ZERO);
								}
								dw.setGanadas(dw.getGanadas().add(det.getCantidadreal()).setScale(4,
										BigDecimal.ROUND_HALF_UP));
								dw.setGanadasdescripcion(obtenerHorasAcumuladas(dw.getGanadas()));
							}

							/*
							 * if ("HNAU".equals(det.getConceptoacceso())) {
							 * dw.setSobretiempodescripcion(
							 * obtenerHorasAcumuladas(det.getCantidadreal()));
							 * dw.setSobretiempo(det.getCantidadreal().setScale(
							 * 4, BigDecimal.ROUND_HALF_UP)); }
							 */

							if ("05".equals(det.getConceptoacceso())) {
								if ("S".equals(det.getFlagcompensa()) && "-".equals(det.getFlagcompensacion())) {

									if (dw.getComp() == null) {
										dw.setComp(BigDecimal.ZERO);
									}

									dw.setComp(dw.getComp().add(det.getCantidadreal()).setScale(4,
											BigDecimal.ROUND_HALF_UP));
									dw.setCompdescripcion(obtenerHorasAcumuladas(dw.getComp()));
								}
							}

							if ("33".equals(det.getConceptoacceso())) {

								if (dw.getFeriarecu() == null) {
									dw.setFeriarecu(BigDecimal.ZERO);
								}
								dw.setFeriarecu(dw.getFeriarecu().add(det.getCantidadreal()).setScale(4,
										BigDecimal.ROUND_HALF_UP));
								dw.setFeriarecudescripcion(obtenerHorasAcumuladas(dw.getFeriarecu()));
							}

						}
					}
					// Fin detallado
				}
			}

			// Para calcular los totales del detallado
			for (DtoDwAsRep001ReporteOficialMinisterio dw : dw1) {
				if (e.equals(dw.getEmpleado())) {
					totalGanadas = totalGanadas.add(UValidador.esNulo(dw.getGanadas()) ? BigDecimal.ZERO
							: dw.getGanadas().setScale(4, BigDecimal.ROUND_HALF_UP));
					totalComp = totalComp.add(UValidador.esNulo(dw.getComp()) ? BigDecimal.ZERO
							: dw.getComp().setScale(4, BigDecimal.ROUND_HALF_UP));
					totalFeriaRecu = totalFeriaRecu.add(UValidador.esNulo(dw.getFeriarecu()) ? BigDecimal.ZERO
							: dw.getFeriarecu().setScale(4, BigDecimal.ROUND_HALF_UP));
				}
			}

			for (DtoDwAsRep001ReporteOficialMinisterio dw : dw1) {
				if (e.equals(dw.getEmpleado())) {
					if (!totalPermanencia.equals(BigDecimal.ZERO)) {
						dw.setTotalpermanenciadescripcion(obtenerHorasAcumuladas(totalPermanencia));
					}
					if (!totalTardanza.equals(BigDecimal.ZERO)) {
						dw.setTotaltardanzadescripcion(obtenerHorasAcumuladas(totalTardanza));
					}
					if (!totalToleranciaTardanza.equals(BigDecimal.ZERO)) {
						dw.setTotaltardanzatoleranciadescripcion(obtenerHorasAcumuladas(totalToleranciaTardanza));
					}
					if (!totalTotalPermisos.equals(BigDecimal.ZERO)) {
						dw.setTotalpermisosdescripcion(obtenerHorasAcumuladas(totalTotalPermisos));
					}

					if (!totalGanadas.equals(BigDecimal.ZERO)) {
						dw.setTotalganadasdescripcion(obtenerHorasAcumuladas(totalGanadas));
					}
					if (!totalComp.equals(BigDecimal.ZERO)) {
						dw.setTotalcompdescripcion(obtenerHorasAcumuladas(totalComp));
					}
					if (!totalFeriaRecu.equals(BigDecimal.ZERO)) {
						dw.setTotalferiarecudescripcion(obtenerHorasAcumuladas(totalFeriaRecu));
					}
					if (!totalPermisoPerDia.equals(BigDecimal.ZERO)) {
						dw.setTotalpermisopersonaldias(totalPermisoPerDia);
					}
					if (!totalPermisoPerHor.equals(BigDecimal.ZERO)) {
						dw.setTotalpermisopersonalhorasdescripcion(obtenerHorasAcumuladas(totalPermisoPerHor));
					}
				}
			}

		}

		return dw1;
	}

	private BigDecimal convertirMinutosToHora(int minutos) {
		// TODO Auto-generated method stub

		BigDecimal saldo;
		Integer horas = minutos / 60;
		Integer min = minutos % 60;
		BigDecimal decimales;

		decimales = BigDecimal.valueOf(min).divide(new BigDecimal(60), 2, BigDecimal.ROUND_HALF_UP);

		saldo = BigDecimal.valueOf(horas).add(decimales);

		return saldo;
	}

	private Integer obtenerTipoDia(Integer empleado, Date fecha, List<AsTipohorario> dwtipohorario, Integer ivTipodia,
			Integer wTipohorario) throws Exception {

		if (UValidador.esNulo(ivTipodia)) {
			ivTipodia = 0;
		}

		if (UValidador.esCero(ivTipodia)) {

			if (!UValidador.esNulo(wTipohorario)) {
				for (AsTipohorario th : dwtipohorario) {
					if (th.getPk().getTipohorario().equals(wTipohorario)) {
						switch (UFechaHora.obtenerNumeroDiaSemana(fecha)) {
						case 1:
							ivTipodia = th.getDomingo();
							break;
						case 2:
							ivTipodia = th.getLunes();
							break;
						case 3:
							ivTipodia = th.getMartes();
							break;
						case 4:
							ivTipodia = th.getMiercoles();
							break;
						case 5:
							ivTipodia = th.getJueves();
							break;
						case 6:
							ivTipodia = th.getViernes();
							break;
						case 7:
							ivTipodia = th.getSabado();
							break;
						}
						break;
					}
				}
			}
		}
		return ivTipodia;
	}

	private Integer obtenerTipoDia(Integer empleado, Date fecha, List<AsTipohorario> dwtipohorario) {
		Integer ivTipodia, wTipohorario = null;

		ivTipodia = daoEmpleadoExcepcion.obtenerTieneProgramacion(empleado, fecha);

		if (UValidador.esNulo(ivTipodia)) {
			ivTipodia = 0;
		}

		if (ivTipodia == 0) {
			Empleadomast emp = dao.obtenerEmpleadoMast(empleado);
			if (!UValidador.esNulo(emp))
				wTipohorario = emp.getTipohorario();

			if (!UValidador.esNulo(wTipohorario)) {
				for (AsTipohorario th : dwtipohorario) {
					if (th.getPk().getTipohorario().equals(wTipohorario)) {
						switch (UFechaHora.obtenerNumeroDiaSemana(fecha)) {
						case 1:
							ivTipodia = th.getDomingo();
							break;
						case 2:
							ivTipodia = th.getLunes();
							break;
						case 3:
							ivTipodia = th.getMartes();
							break;
						case 4:
							ivTipodia = th.getMiercoles();
							break;
						case 5:
							ivTipodia = th.getJueves();
							break;
						case 6:
							ivTipodia = th.getViernes();
							break;
						case 7:
							ivTipodia = th.getSabado();
							break;
						}
						break;
					}
				}
			}
		}
		return ivTipodia;
	}

	@Override
	public List<DtoDwAsAsistenciadiariaRpt> listarReporteAsistenciaCasiDetallada(Integer empleado, Date desde,
			Date hasta, Integer sid, String user) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("empleado", Integer.class, empleado));
		parametros.add(new ParametroPersistenciaGenerico("desde", Date.class, desde));
		parametros.add(new ParametroPersistenciaGenerico("hasta", Date.class, hasta));
		parametros.add(new ParametroPersistenciaGenerico("sid", Integer.class, sid));
		parametros.add(new ParametroPersistenciaGenerico("user", Integer.class, user));
		return (List) dao.listarPorQuery(DtoDwAsAsistenciadiariaRpt.class,
				"empleadomast.ListarEmpleadoReporteAsistenciaCasiDetallada", parametros);
	}

	@Override
	public List<DtoAsPeriodo> obtenerInasistencias(Integer empleado) {
		// TODO Auto-generated method stub
		List<DtoAsPeriodo> resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));

		List data = dao.listarPorQuery(DtoAsPeriodo.class, "empleadomast.obtenerInasistencias", filtros);

		if (!UValidador.esListaVacia(data)) {
			resultado = data;
		}

		return resultado;
	}

	@Override
	public List<DtoPersonamast> obtenerPersonaReclutamiento() {
		List datos = dao.listarPorQuery(DtoPersonamast.class, "empleadomast.obtenerEmpleadoReclutamiento");
		return datos;
	}

	private String obtenerHorasAcumuladas(BigDecimal saldoinicial) {
		// TODO Auto-generated method stub
		BigDecimal sexagesimal, decimales;
		Integer enteros;

		sexagesimal = f_cent2sex(saldoinicial);
		BigDecimal cal1 = sexagesimal.subtract(BigDecimal.valueOf(sexagesimal.intValue())).setScale(2,
				RoundingMode.HALF_EVEN);

		decimales = cal1.multiply(BigDecimal.valueOf(100));

		enteros = sexagesimal.intValue();

		if (UValidador.esCero(decimales.compareTo(BigDecimal.valueOf(60)))) {
			enteros = enteros + 1;
			decimales = BigDecimal.valueOf(0.0);
		}

		if (UValidador.esNulo(enteros) && UValidador.esNulo(decimales)) {
			return "";
		} else if (UValidador.esCero(enteros) && UValidador.esCero(decimales.intValue())) {
			return "00:00";
		} else {
			String signo = enteros >= 0 ? "" : "-";
			return signo + ((enteros < 10 && enteros > -10) ? ("0" + Math.abs(enteros)) : Math.abs(enteros)) + ":"
					+ ((decimales.intValue() < 10) ? ("0" + decimales.intValue()) : decimales.intValue());
		}
	}

	private BigDecimal f_cent2sex(BigDecimal par_cent) {
		BigDecimal decimales;
		BigDecimal valor;
		valor = par_cent;
		decimales = valor.subtract(BigDecimal.valueOf(valor.intValue()));

		BigDecimal cal1 = decimales.divide(BigDecimal.valueOf(10)).multiply(BigDecimal.valueOf(6)).setScale(2,
				RoundingMode.HALF_UP);

		return BigDecimal.valueOf(valor.intValue()).add(cal1);
	}

	private Integer obtenerMinutos(BigDecimal saldoinicial) {
		// TODO Auto-generated method stub
		BigDecimal sexagesimal, decimales;
		Integer enteros;

		sexagesimal = f_cent2sex(saldoinicial);
		BigDecimal cal1 = sexagesimal.subtract(BigDecimal.valueOf(sexagesimal.intValue())).setScale(2,
				RoundingMode.HALF_DOWN);

		decimales = cal1.multiply(BigDecimal.valueOf(100));

		enteros = sexagesimal.intValue();

		if (UValidador.esCero(decimales.compareTo(BigDecimal.valueOf(60)))) {
			enteros = enteros + 1;
			decimales = BigDecimal.valueOf(0.0);
		}

		if (UValidador.esNulo(enteros) && UValidador.esNulo(decimales)) {
			return 0;
		} else if (UValidador.esCero(enteros) && UValidador.esCero(decimales.intValue())) {
			return 0;
		} else {
			return Math.abs(enteros * 60) + decimales.intValue();
		}
	}

	@Override
	public ParametroPaginacion listarActivosArea(ParametroPaginacion paginacion) {
		// TODO Auto-generated method stub

		StringBuilder query = new StringBuilder();
		StringBuilder queryContar = new StringBuilder();

		// query.append(dao.obtenerSentenciaSqlPorQuery("empleadomast.listarActivosArea"));
		queryContar.append(dao.obtenerSentenciaSqlPorQuery("empleadomast.contarActivosArea"));

		if (!UValidador.estaVacio(paginacion.getParametro("p_area"))) {
			query.append(" and a.area in ( " + paginacion.getParametro("p_area").getValue() + ")");
			queryContar.append(" and a.area in ( " + paginacion.getParametro("p_area").getValue() + ")");
		}
		if (!UValidador.estaVacio(paginacion.getParametro("p_empleado"))) {
			query.append(" and e.empleado in ( " + paginacion.getParametro("p_empleado").getValue() + ")");
			queryContar.append(" and e.empleado in ( " + paginacion.getParametro("p_empleado").getValue() + ")");
		}

		BigDecimal registrosEncontrados;
		List lstResultado;

		registrosEncontrados = dao.contarPorSentenciaSQL(queryContar);
		lstResultado = dao.listarConPaginacion(paginacion.getRegistroInicio(), paginacion.getRegistrosPorPagina(),
				paginacion.getCampoOrden(), paginacion.getDireccionOrden(), null, "empleadomast.listarActivosArea",
				paginacion.getClazz(), query.toString());

		paginacion.setRegistroEncontrados(registrosEncontrados.intValue());
		paginacion.setListaResultado(lstResultado);

		return paginacion;

	}

	@Override
	public List listarActivosArea(HashMap<String, Object> whereparam) {
		// TODO Auto-generated method stub

		StringBuilder query = new StringBuilder();
		query.append(dao.obtenerSentenciaSqlPorQuery("empleadomast.listarActivosArea"));

		if (whereparam.containsKey("p_area")) {
			query.append(" and a.area in ( " + whereparam.get("p_area") + ")");
		}
		if (whereparam.containsKey("p_empleado")) {
			query.append(" and e.empleado in ( " + whereparam.get("p_empleado") + ")");
		}

		query.append(" order by p.nombrecompleto ");

		return dao.listarPorSentenciaSQL(DtoEmpleadomast.class, query, null);

	}

}
