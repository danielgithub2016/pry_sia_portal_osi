package net.royal.erp.asistencia.servicio.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.erp.asistencia.dao.AsAreaDao;
import net.royal.erp.asistencia.dao.AsAutorizacionDao;
import net.royal.erp.asistencia.dao.AsConceptoaccesoDao;
import net.royal.erp.asistencia.dao.AsEmpleadoexcepcionDao;
import net.royal.erp.asistencia.dao.AsEmpleadoexcepciondetalleDao;
import net.royal.erp.asistencia.dao.AsTipohorarioDao;
import net.royal.erp.asistencia.dominio.AsArea;
import net.royal.erp.asistencia.dominio.AsAutorizacion;
import net.royal.erp.asistencia.dominio.AsConceptoacceso;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcion;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepciondetalle;
import net.royal.erp.asistencia.dominio.dto.DtoAsAutorizacion;
import net.royal.erp.asistencia.dominio.dto.DtoPermisosEnCompensacion;
import net.royal.erp.asistencia.servicio.AsAutorizacionServicio;
import net.royal.erp.core.dao.EmpleadomastDao;
import net.royal.erp.core.dao.ParametrosmastDao;
import net.royal.erp.core.dao.PersonamastDao;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.servicio.CorreoServicio;
import net.royal.framework.correo.dominio.CorreoCore;
import net.royal.framework.correo.dominio.CorreoDestinoCore;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.core.UString;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioAsAutorizacion")
public class AsAutorizacionServicioImpl extends GenericoServicioImpl implements AsAutorizacionServicio {

	private AsAutorizacionDao dao;
	private AsEmpleadoexcepciondetalleDao daoAsEmpleadoexcepciondetalle;
	private AsEmpleadoexcepcionDao daoAsEmpleadoexcepcion;
	private AsTipohorarioDao daoAsTipohorario;
	private AsAreaDao daoAsArea;
	private AsConceptoaccesoDao daoAsConceptoAcceso;
	private PersonamastDao daoPersonamast;
	private ParametrosmastDao parametrosmastDao;
	private EmpleadomastDao daoEmpleadomast;
	@Autowired

	public ApplicationContext appContext;

	private static Log LOGGER = LogFactory.getLog(AsAutorizacionServicioImpl.class);

	@Autowired
	public void setDao(AsAutorizacionDao dao) {
		this.dao = dao;
		this.setGenericoDao(this.dao);
	}

	@Autowired
	public void setDaoAsArea(AsAreaDao daoAsArea) {
		this.daoAsArea = daoAsArea;
	}

	@Autowired
	public void setParametrosMastDao(ParametrosmastDao parametrosmastDao) {
		this.parametrosmastDao = parametrosmastDao;
	}

	@Autowired
	public void setDaoAsConceptoAcceso(AsConceptoaccesoDao daoAsConceptoAcceso) {
		this.daoAsConceptoAcceso = daoAsConceptoAcceso;
	}

	@Autowired
	public void setDaoPersonamast(PersonamastDao daoPersonamast) {
		this.daoPersonamast = daoPersonamast;
	}

	@Autowired
	public void setDaoEmpleadomast(EmpleadomastDao daoEmpleadomast) {
		this.daoEmpleadomast = daoEmpleadomast;
	}

	@Override
	public Integer obtenercantidad(Integer empleado, long ll_d_1, long ll_h_1, long ll_d_2, long ll_h_2,
			String conceptoacceso, String ls_similares_2, String ls_similares_3, String ls_similares_4,
			String ls_similares_5, String ls_similares_6, String ls_similares_7, String ls_similares_8,
			String ls_similares_2_all, String w_CategoriaAutorizacion, String ls_similares) {
		// TODO Auto-generated method stub

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_ll_d_1", long.class, ll_d_1));
		filtros.add(new ParametroPersistenciaGenerico("p_ll_h_1", long.class, ll_h_1));
		filtros.add(new ParametroPersistenciaGenerico("p_ll_d_2", long.class, ll_d_2));
		filtros.add(new ParametroPersistenciaGenerico("p_ll_h_2", long.class, ll_h_2));
		filtros.add(new ParametroPersistenciaGenerico("p_conceptoacceso", String.class, conceptoacceso));
		filtros.add(new ParametroPersistenciaGenerico("p_similares_2", String.class, ls_similares_2));
		filtros.add(new ParametroPersistenciaGenerico("p_similares_3", String.class, ls_similares_3));
		filtros.add(new ParametroPersistenciaGenerico("p_similares_4", String.class, ls_similares_4));
		filtros.add(new ParametroPersistenciaGenerico("p_similares_5", String.class, ls_similares_5));
		filtros.add(new ParametroPersistenciaGenerico("p_similares_6", String.class, ls_similares_6));
		filtros.add(new ParametroPersistenciaGenerico("p_similares_7", String.class, ls_similares_7));
		filtros.add(new ParametroPersistenciaGenerico("p_similares_8", String.class, ls_similares_8));
		filtros.add(new ParametroPersistenciaGenerico("p_similares_2_all", String.class, ls_similares_2_all));
		filtros.add(
				new ParametroPersistenciaGenerico("p_categoriaautorizacion", String.class, w_CategoriaAutorizacion));
		filtros.add(new ParametroPersistenciaGenerico("p_similares", String.class, ls_similares));

		return dao.contar("asautorizacion.obtenercantidad", filtros);
	}

	@Override
	public Integer obtenercantidad2(Integer empleado, Date fecha, String conceptoacceso, Date desde) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));
		filtros.add(new ParametroPersistenciaGenerico("p_conceptoacceso", String.class, conceptoacceso));
		filtros.add(new ParametroPersistenciaGenerico("p_desde", Date.class, desde));
		return dao.contar("asautorizacion.obtenercantidad2", filtros);
	}

	@Override
	public Integer obtenercantidad3(Integer empleado, Date fecha, String conceptoacceso, Date desde) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));
		filtros.add(new ParametroPersistenciaGenerico("p_conceptoacceso", String.class, conceptoacceso));
		filtros.add(new ParametroPersistenciaGenerico("p_desde", Date.class, desde));
		return dao.contar("asautorizacion.obtenercantidad3", filtros);
	}

	@Override
	public List obtenerFechaVeces(Integer empleado, Integer p_year, Date p_fecha) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_year", Integer.class, p_year));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, p_fecha));

		return dao.listarPorQuery(DtoAsAutorizacion.class, "asautorizacion.obtenerFechaVeces", filtros);
	}

	@Override
	@Transactional
	public void eliminarAutorizacion(Integer empleado, Date fecha, String conceptoacceso, Date fechadesde) {
		// TODO Auto-generated method stub

		LOGGER.debug("empleado " + empleado);
		LOGGER.debug("fecha " + fecha);
		LOGGER.debug("conceptoacceso" + conceptoacceso);
		LOGGER.debug("fechadesde " + fechadesde);

		Criteria cri = dao.getCriteria();
		cri.add(Restrictions.eq("pk.empleado", BigDecimal.valueOf(empleado)));
		cri.add(Restrictions.eq("pk.fecha", fecha));
		cri.add(Restrictions.eq("pk.conceptoacceso", conceptoacceso));
		cri.add(Restrictions.eq("pk.desde", UFechaHora.obtenerFechaCompuesta(fecha, fechadesde)));

		List<AsAutorizacion> lista = dao.listarPorCriterios(cri);

		LOGGER.debug("lista" + lista);

		for (AsAutorizacion obj : lista) {
			dao.eliminar(obj);
		}
	}

	@Override
	public Integer obtenerEmpleado(Integer empleado, Date desde1, Date fecha, String conceptoacceso) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_desde1", Date.class, desde1));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));
		filtros.add(new ParametroPersistenciaGenerico("p_conceptoacceso", String.class, conceptoacceso));

		return dao.contar("asautorizacion.obtenerEmpleado", filtros);
	}

	@Override
	public void eliminarAutorizacion2(Integer empleado, Date fechaoriginal, Date fechadesdeoriginal,
			String conceptoaccesooriginal) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();

		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fechaoriginal", Date.class, fechaoriginal));
		filtros.add(new ParametroPersistenciaGenerico("p_fechadesdeoriginal", Date.class, fechadesdeoriginal));
		filtros.add(
				new ParametroPersistenciaGenerico("p_conceptoaccesooriginal", String.class, conceptoaccesooriginal));

		dao.ejecutarPorQuery("asautorizacion.eliminarAutorizacion2", filtros);
	}

	@Override
	public void insertarAutorizacion(Integer empleado, Date fecha, String conceptoacceso, Date desde1, Date hasta1,
			String refrigerio, String periodo, String mandatario, String observacion, String solicitadopor,
			Date fechasolicitud, String ultimousuario, Date ultimafechamodificacion, Integer sobretiempo, String estado,
			String comportmientosobretiempo, String categoriaautorizacion, Integer tipohorario, String flagcorrido,
			String ruta, String tipoautorizacion, String resolucion) {
		// TODO Auto-generated method stub

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));
		filtros.add(new ParametroPersistenciaGenerico("p_conceptoacceso", String.class, conceptoacceso));
		filtros.add(new ParametroPersistenciaGenerico("p_desde1", Date.class, desde1));
		filtros.add(new ParametroPersistenciaGenerico("p_hasta1", Date.class, hasta1));
		filtros.add(new ParametroPersistenciaGenerico("p_refrigerio", String.class, refrigerio));
		filtros.add(new ParametroPersistenciaGenerico("p_periodo", String.class, periodo));
		filtros.add(new ParametroPersistenciaGenerico("p_mandatario", String.class, mandatario));
		filtros.add(new ParametroPersistenciaGenerico("p_observacion", String.class, observacion));
		filtros.add(new ParametroPersistenciaGenerico("p_solicitadopor", String.class, solicitadopor));
		filtros.add(new ParametroPersistenciaGenerico("p_fechasolicitud", Integer.class, fechasolicitud));
		filtros.add(new ParametroPersistenciaGenerico("p_ultimousuario", String.class, ultimousuario));
		filtros.add(new ParametroPersistenciaGenerico("p_ultimafechamodif", Date.class, ultimafechamodificacion));
		filtros.add(new ParametroPersistenciaGenerico("p_sobretiempo", Integer.class, sobretiempo));
		filtros.add(new ParametroPersistenciaGenerico("p_estado", Integer.class, estado));
		filtros.add(new ParametroPersistenciaGenerico("p_comportamientosobretiempo", String.class,
				comportmientosobretiempo));
		filtros.add(new ParametroPersistenciaGenerico("p_categoriaautorizacion", String.class, categoriaautorizacion));
		filtros.add(new ParametroPersistenciaGenerico("p_tipohorario", Integer.class, tipohorario));
		filtros.add(new ParametroPersistenciaGenerico("p_corrido", String.class, flagcorrido));
		filtros.add(new ParametroPersistenciaGenerico("p_ruta", String.class, ruta));
		filtros.add(new ParametroPersistenciaGenerico("p_tipoautorizacion", String.class, tipoautorizacion));
		filtros.add(new ParametroPersistenciaGenerico("p_resolucion", String.class, resolucion));

		dao.ejecutarPorQuery("asautorizacion.insertarAutorizacion", filtros);

	}

	@Override
	public void insertarAutorizacion2(Integer empleado, Date fecha, String conceptoacceso, Date desde, Date hasta,
			String refrigerio, String periodo, String mandatario, String observacion, String solicitadopor,
			Date fechasolicitud, String ultimousuario, Date ultimafechamodificacion, String estado,
			String comportmientosobretiempo, String categoriaautorizacion, Integer tipohorario, String flagcorrido,
			Integer terminal) {
		// TODO Auto-generated method stub

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));
		filtros.add(new ParametroPersistenciaGenerico("p_conceptoacceso", String.class, conceptoacceso));
		filtros.add(new ParametroPersistenciaGenerico("p_desde", Date.class, desde));
		filtros.add(new ParametroPersistenciaGenerico("p_hasta", Date.class, hasta));
		filtros.add(new ParametroPersistenciaGenerico("p_refrigerio", String.class, refrigerio));
		filtros.add(new ParametroPersistenciaGenerico("p_periodo", String.class, periodo));
		filtros.add(new ParametroPersistenciaGenerico("p_mandatario", String.class, mandatario));
		filtros.add(new ParametroPersistenciaGenerico("p_observacion", String.class, observacion));
		filtros.add(new ParametroPersistenciaGenerico("p_solicitadopor", String.class, solicitadopor));
		filtros.add(new ParametroPersistenciaGenerico("p_fechasolicitud", Integer.class, fechasolicitud));
		filtros.add(new ParametroPersistenciaGenerico("p_ultimousuario", String.class, ultimousuario));
		filtros.add(new ParametroPersistenciaGenerico("p_ultimafechamodif", Date.class, ultimafechamodificacion));
		filtros.add(new ParametroPersistenciaGenerico("p_estado", Integer.class, estado));
		filtros.add(new ParametroPersistenciaGenerico("p_comportamientosobretiempo", String.class,
				comportmientosobretiempo));
		filtros.add(new ParametroPersistenciaGenerico("p_categoriaautorizacion", String.class, categoriaautorizacion));
		filtros.add(new ParametroPersistenciaGenerico("p_tipohorario", Integer.class, tipohorario));
		filtros.add(new ParametroPersistenciaGenerico("p_corrido", String.class, flagcorrido));
		filtros.add(new ParametroPersistenciaGenerico("p_terminal", Integer.class, terminal));

		dao.ejecutarPorQuery("asautorizacion.insertarAutorizacion2", filtros);
	}

	@Override
	public void actualizarAutorizacion(Date fecha, Date fechafin, Date desde1, Date hasta1, String refrigerio,
			String periodo, String mandatario, Integer tipohorario, String observacion, String autorizadopor,
			String ultimousuario, Date ultimafechamodificacion, String ruta, String resolucion, Integer empleado,
			Date fecha2, Date fechadesde, String conceptoacceso) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class, fechafin));
		filtros.add(new ParametroPersistenciaGenerico("p_desde", Date.class, desde1));
		filtros.add(new ParametroPersistenciaGenerico("p_hasta", Date.class, hasta1));
		filtros.add(new ParametroPersistenciaGenerico("p_refrigerio", String.class, refrigerio));
		filtros.add(new ParametroPersistenciaGenerico("p_periodo", String.class, periodo));
		filtros.add(new ParametroPersistenciaGenerico("p_mandatario", String.class, mandatario));
		filtros.add(new ParametroPersistenciaGenerico("p_tipohorario", String.class, tipohorario));
		filtros.add(new ParametroPersistenciaGenerico("p_observacion", String.class, observacion));
		filtros.add(new ParametroPersistenciaGenerico("p_autorizadopor", String.class, autorizadopor));
		filtros.add(new ParametroPersistenciaGenerico("p_ultimousuario", String.class, ultimousuario));
		filtros.add(new ParametroPersistenciaGenerico("p_ultimafechamodif", Date.class, ultimafechamodificacion));
		filtros.add(new ParametroPersistenciaGenerico("p_ruta", String.class, ruta));
		filtros.add(new ParametroPersistenciaGenerico("p_resolucion", String.class, resolucion));

		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha2", Date.class, fecha2));
		filtros.add(new ParametroPersistenciaGenerico("p_fechadesde", Date.class, fechadesde));
		filtros.add(new ParametroPersistenciaGenerico("p_conceptoacceso", Integer.class, conceptoacceso));

		dao.ejecutarPorQuery("asautorizacion.actualizarAutorizacion", filtros);
	}

	@Override
	public Integer obtenerEmpleado2(Integer empleado, Date fecha, Date desde1, String conceptoacceso) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));
		filtros.add(new ParametroPersistenciaGenerico("p_desde1", Date.class, desde1));
		filtros.add(new ParametroPersistenciaGenerico("p_conceptoacceso", String.class, conceptoacceso));

		return dao.contar("asautorizacion.obtenerEmpleado2", filtros);
	}

	@Override
	public void eliminarAutorizacionFecha(Integer empleado, Date fecha) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));
		dao.ejecutarPorQuery("asautorizacion.eliminarAutorizacionFecha", filtros);
	}

	@Override
	@Transactional(readOnly = false)
	public Integer autorizarCambioHorario(UsuarioActual usuarioActual, Integer empleado, Date fecha, Date fechaFin,
			Integer tipoHorario) {

		String w_descripcion = null;
		List<AsEmpleadoexcepcion> lstEmpleadoExcepcion = new ArrayList<AsEmpleadoexcepcion>();
		List<AsEmpleadoexcepciondetalle> lstEmpleadoExcepcionDetalle = new ArrayList<AsEmpleadoexcepciondetalle>();

		w_descripcion = daoAsTipohorario.obtenerDescripcionLocal(tipoHorario);

		List<ParametroPersistenciaGenerico> parametros;
		parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		parametros.add(new ParametroPersistenciaGenerico("p_tipohorario", Integer.class, tipoHorario));
		parametros.add(new ParametroPersistenciaGenerico("p_fechainicio", Date.class, fecha));
		parametros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class, fechaFin));
		parametros.add(new ParametroPersistenciaGenerico("p_usuario", String.class, usuarioActual.getLoginUsuario()));
		parametros
				.add(new ParametroPersistenciaGenerico("p_terminal", String.class, usuarioActual.getIpAddressLogin()));
		dao.ejecutarPorQuery("asautorizacion.sp_as_autotizar_cambio_horario", parametros);

		return 1;

	}

	@Autowired
	public void setDaoAsEmpleadoexcepciondetalle(AsEmpleadoexcepciondetalleDao daoAsEmpleadoexcepciondetalle) {
		this.daoAsEmpleadoexcepciondetalle = daoAsEmpleadoexcepciondetalle;
	}

	@Autowired
	public void setDaoAsEmpleadoexcepcion(AsEmpleadoexcepcionDao daoAsEmpleadoexcepcion) {
		this.daoAsEmpleadoexcepcion = daoAsEmpleadoexcepcion;
	}

	@Autowired
	public void setDaoAsTipohorario(AsTipohorarioDao daoAsTipohorario) {
		this.daoAsTipohorario = daoAsTipohorario;
	}

	@Override
	public Integer obtenerCantidadPapeletaFechas(BigDecimal empleado, Date fecha, Date fechahasta, Date fechainiorig,
			Date fechafinorig) {
		// TODO Auto-generated method stub

		Integer resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fechainicio", Date.class, fecha));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class, fechahasta));
		filtros.add(new ParametroPersistenciaGenerico("p_fechainiorig", Date.class, fechainiorig));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafinorig", Date.class, fechafinorig));

		resultado = dao.contar("asautorizacion.contarPapeletasEnFechas", filtros);

		if (UValidador.esNulo(resultado)) {
			resultado = 0;
		}

		return resultado;
	}

	@Override
	public BigDecimal contarEmpleadosFeriadosHoras(Date fechadesde, Date fechahasta, String flgperiodo,
			String adicionales, Integer sid, String tipo) {
		// TODO Auto-generated method stub

		String query = null;

		if (tipo.equals("feriados")) {
			query = dao.obtenerSentenciaSqlPorQuery("asautorizacion.contarEmpleadosFeriadosGanados");
		} else {
			query = dao.obtenerSentenciaSqlPorQuery("asautorizacion.contarEmpleadosHorasGanadas");
		}

		query = query.replace("[P_ADICIONAL]", adicionales);

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_fecha_desde", Date.class, fechadesde));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha_hasta", Date.class, fechahasta));
		filtros.add(new ParametroPersistenciaGenerico("p_flagfiltroperiodo", String.class, flgperiodo));
		filtros.add(new ParametroPersistenciaGenerico("p_sid", Integer.class, sid));

		return dao.contarPorSentenciaSQL(new StringBuilder(query), filtros);
	}

	@Override
	public List listarLicenciasSinGoce(Integer empleado) {
		// TODO Auto-generated method stub
		Integer cantidad = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		return dao.listarPorQuery(DtoAsAutorizacion.class, "asautorizacion.listarlicenciassingoce", filtros);

	}

	@Override
	public Integer contarLicencias(Integer empleado, Date fecha, Date fechafin) {
		// TODO Auto-generated method stub
		Integer cantidad = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class, fechafin));
		cantidad = dao.contar("asautorizacion.contarlicencias", filtros);
		return cantidad;

	}

	@Override
	public Integer obtenercantidadedicion(Integer empleado, long ll_d_1, long ll_h_1, long ll_d_2, long ll_h_2,
			String conceptoacceso, String ls_similares_2, String ls_similares_3, String ls_similares_4,
			String ls_similares_5, String ls_similares_6, String ls_similares_7, String ls_similares_8,
			String ls_similares_2_all, String w_CategoriaAutorizacion, String ls_similares, Date fecha, String concepto,
			Date desde) {
		// TODO Auto-generated method stub

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_ll_d_1", long.class, ll_d_1));
		filtros.add(new ParametroPersistenciaGenerico("p_ll_h_1", long.class, ll_h_1));
		filtros.add(new ParametroPersistenciaGenerico("p_ll_d_2", long.class, ll_d_2));
		filtros.add(new ParametroPersistenciaGenerico("p_ll_h_2", long.class, ll_h_2));
		filtros.add(new ParametroPersistenciaGenerico("p_conceptoacceso", String.class, conceptoacceso));
		filtros.add(new ParametroPersistenciaGenerico("p_similares_2", String.class, ls_similares_2));
		filtros.add(new ParametroPersistenciaGenerico("p_similares_3", String.class, ls_similares_3));
		filtros.add(new ParametroPersistenciaGenerico("p_similares_4", String.class, ls_similares_4));
		filtros.add(new ParametroPersistenciaGenerico("p_similares_5", String.class, ls_similares_5));
		filtros.add(new ParametroPersistenciaGenerico("p_similares_6", String.class, ls_similares_6));
		filtros.add(new ParametroPersistenciaGenerico("p_similares_7", String.class, ls_similares_7));
		filtros.add(new ParametroPersistenciaGenerico("p_similares_8", String.class, ls_similares_8));
		filtros.add(new ParametroPersistenciaGenerico("p_similares_2_all", String.class, ls_similares_2_all));
		filtros.add(
				new ParametroPersistenciaGenerico("p_categoriaautorizacion", String.class, w_CategoriaAutorizacion));
		filtros.add(new ParametroPersistenciaGenerico("p_similares", String.class, ls_similares));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));
		filtros.add(new ParametroPersistenciaGenerico("p_conceptoacceso", String.class, concepto));
		filtros.add(new ParametroPersistenciaGenerico("p_desde", Date.class, desde));

		return dao.contar("asautorizacion.obtenercantidadedicion", filtros);
	}

	@Override
	public Date obtenermaximodesde(Integer empleado, Date fecha) {
		// TODO Auto-generated method stub
		Date resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));

		List data = dao.listarPorQuery(DtoAsAutorizacion.class, "asautorizacion.obtenermaximodesde", filtros);

		if (!UValidador.esListaVacia(data)) {
			if (!UValidador.esNulo(data.get(0))) {
				resultado = ((DtoAsAutorizacion) data.get(0)).getFecha();
			}
		}

		return resultado;
	}

	@Override
	public Integer contarvalidalicenciasempleado(Integer empleado, Date fechainicio, Date fechafin) {
		// TODO Auto-generated method stub
		Integer resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fechainicio", Date.class, fechainicio));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class, fechafin));

		resultado = dao.contar("asautorizacion.contarvalidalicenciasempleado", filtros);

		if (UValidador.esNulo(resultado)) {
			resultado = 0;
		}

		return resultado;
	}

	@Override
	public Integer contarPermisosSIGED(Integer empleado, String concepto) {
		// TODO Auto-generated method stub
		Integer resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_concepto", String.class, concepto));

		resultado = dao.contar("asautorizacion.contarPermisosSIGED", filtros);

		if (UValidador.esNulo(resultado)) {
			resultado = 0;
		}

		return resultado;
	}

	@Override
	public Integer contarvalidavacacionesempleado(Integer empleado, Date fechainicio, Date fechafin,
			Integer maxperiodo) {
		// TODO Auto-generated method stub
		Integer resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fechainicio", Date.class, fechainicio));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class, fechafin));
		filtros.add(new ParametroPersistenciaGenerico("p_numeroperiodo", Integer.class, maxperiodo));

		resultado = dao.contar("asautorizacion.contarvalidavacacionesempleado", filtros);

		if (UValidador.esNulo(resultado)) {
			resultado = 0;
		}

		return resultado;
	}

	@Override
	public Integer contarmaximoperiodovacaciones(Integer empleado) {
		// TODO Auto-generated method stub
		Integer resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));

		resultado = dao.contar("asautorizacion.contarmaximoperiodovacaciones", filtros);

		if (UValidador.esNulo(resultado)) {
			resultado = 0;
		}

		return resultado;
	}

	@Override
	@Transactional
	public void generarAsistenciaOnomastico() throws Exception {
		// TODO Auto-generated method stub
		String mensaje = "";
		String rutaCompleta = null;
		String colaborador = null;
		String concepto = null;
		List<CorreoDestinoCore> destinos = new ArrayList<>();
		String destinatarior1 = null;
		String destinatarior2 = null;
		String destinatarior3 = null;
		String destinatarior4 = null;
		String fechaini = null;
		String fechater = null;
		String mensajefecha = null;
		Integer diasresta = 0;
		String mensajehoras = null;
		String lugar = "";

		// List<DtoAsAutorizacion> solicitudes =
		// dao.generarAsistenciaOnomastico();

		List<DtoAsAutorizacion> solicitudes = new ArrayList<>();

		if (!UValidador.esListaVacia(solicitudes)) {
			// enviamos correo por cada solicitud
			for (DtoAsAutorizacion obj : solicitudes) {

				fechaini = UFechaHora.convertirFechaCadena(obj.getFecha(), "dd/MM/yyyy");
				fechater = UFechaHora.convertirFechaCadena(obj.getFechahasta(), "dd/MM/yyyy");

				diasresta = UFechaHora.obtenerDiferenciaDias(obj.getFecha(), obj.getFechahasta());

				mensajefecha = " desde el " + fechaini + " hasta el " + fechater;

				if (UValidador.esCero(diasresta)) {
					mensajehoras = ", de " + UFechaHora.convertirFechaCadena(obj.getDesde(), "HH:mm") + " a "
							+ UFechaHora.convertirFechaCadena(obj.getDesde(), "HH:mm");

				} else {
					mensajehoras = "";
				}

				// DESTINATARIO
				// VERIFICAMOS SI EL EMPLEADO ES APROBADOR
				AsArea area = daoAsArea.obtenerArea(obj.getEmpleado(), "01000000");

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
					if (obj.getEmpleado().equals(area.getEmpleadoresponsable())
							|| obj.getEmpleado().equals(area.getEmpleadoresponsable2())
							|| obj.getEmpleado().equals(area.getEmpleadoresponsable3())
							|| obj.getEmpleado().equals(area.getEmpleadoresponsable4())) {
						isresponsable = true;
					}

					if (isresponsable) {
						// le envia correo a su aprobador y a los
						// administradores
						if (obj.getEmpleado().equals(area.getEmpleadoresponsable())) {
							empleado1 = area.getEmpleadoaprobador();
							flgempleado1 = area.getFlagcorreoaprobador1();
						}
						if (obj.getEmpleado().equals(area.getEmpleadoresponsable2())) {
							empleado2 = area.getEmpleadoaprobador2();
							flgempleado2 = area.getFlagcorreoaprobador2();
						}
						if (obj.getEmpleado().equals(area.getEmpleadoresponsable3())) {
							empleado3 = area.getEmpleadoaprobador3();
							flgempleado3 = area.getFlagcorreoaprobador3();
						}
						if (obj.getEmpleado().equals(area.getEmpleadoresponsable4())) {
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
						emple1.getPk().setCompaniasocio("01000000");
						emple1 = (Empleadomast) daoEmpleadomast.obtenerPorId(emple1.getPk());
						if (!UValidador.esNulo(emple1)) {
							destinatarior1 = emple1.getCorreointerno();
							LOGGER.debug("destinatario1 " + destinatarior1);
						}
					}

					// DESTINATARIO 2
					if (flgempleado2.equals(UConstante.CONSTANTE_OPCION_SI)) {
						Empleadomast emple2 = new Empleadomast();
						emple2.getPk().setEmpleado(empleado2);
						emple2.getPk().setCompaniasocio("01000000");
						emple2 = (Empleadomast) daoEmpleadomast.obtenerPorId(emple2.getPk());
						if (!UValidador.esNulo(emple2)) {
							destinatarior2 = emple2.getCorreointerno();
							LOGGER.debug("destinatario2 " + destinatarior2);
						}
					}

					// DESTINATARIO 3
					if (flgempleado3.equals(UConstante.CONSTANTE_OPCION_SI)) {
						Empleadomast emple3 = new Empleadomast();
						emple3.getPk().setEmpleado(empleado3);
						emple3.getPk().setCompaniasocio("01000000");
						emple3 = (Empleadomast) daoEmpleadomast.obtenerPorId(emple3.getPk());
						if (!UValidador.esNulo(emple3)) {
							destinatarior3 = emple3.getCorreointerno();
							LOGGER.debug("destinatario3 " + destinatarior3);
						}
					}

					// DESTINATARIO 4
					if (flgempleado4.equals(UConstante.CONSTANTE_OPCION_SI)) {
						Empleadomast emple4 = new Empleadomast();
						emple4.getPk().setEmpleado(empleado4);
						emple4.getPk().setCompaniasocio("01000000");
						emple4 = (Empleadomast) daoEmpleadomast.obtenerPorId(emple4.getPk());
						if (!UValidador.esNulo(emple4)) {
							destinatarior4 = emple4.getCorreointerno();
							LOGGER.debug("destinatario4 " + destinatarior4);
						}
					}
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
				colaborador = daoPersonamast.obtenerNombrePersona(BigDecimal.valueOf(obj.getEmpleado()));

				// CONCEPTO
				AsConceptoacceso objCon = new AsConceptoacceso();
				objCon.getPk().setConceptoacceso(obj.getConcepto());
				objCon = (AsConceptoacceso) daoAsConceptoAcceso.obtenerPorId(objCon.getPk());
				if (!UValidador.esNulo(obj)) {
					concepto = objCon.getDescripcionlocal();
				}

				rutaCompleta = UFile.rutaWebCompleto("//comun//plantillas//oefa//correos//solicitud_asistencia.html");
				LOGGER.debug(rutaCompleta);
				mensaje = UFile.obtenerContenidoFile(rutaCompleta);
				LOGGER.debug(mensaje);
				mensaje = mensaje.replace("[EMPLEADO]", UString.cambiarCaracteresEspecialesHTML(colaborador));
				mensaje = mensaje.replace("[CONCEPTO]", UString.cambiarCaracteresEspecialesHTML(concepto));
				mensaje = mensaje.replace("[MENSAJE_FECHA]", UString.cambiarCaracteresEspecialesHTML(mensajefecha));
				mensaje = mensaje.replace("[MENSAJE_HORA]", UString.cambiarCaracteresEspecialesHTML(mensajehoras));
				mensaje = mensaje.replace("[LUGAR]", UString.cambiarCaracteresEspecialesHTML(lugar));
				mensaje = mensaje.replace("[DIFERENCIA_DIAS]", UString.cambiarCaracteresEspecialesHTML(
						UValidador.esCero(diasresta) ? "" : " Días: " + (diasresta + 1)));

				// ENVIO
				CorreoServicio correoServico = (CorreoServicio) appContext.getBean(CorreoServicio.SPRING_NOMBRE);
				Boolean isconfiguradocorreo = correoServico.configurarCorreo();

				if (isconfiguradocorreo) {
					CorreoCore correo = new CorreoCore();
					correo.setListaCorreoDestino(destinos);
					correo.setAsunto("Solicitud de Asistencia");
					correo.setCuerpoCorreo(mensaje.getBytes());

					if (!UValidador.esListaVacia(destinos)) {
						// correoServico.enviarCorreo(correo);
					}
				}

			}
		}
	}

	@Override
	public Integer contarOmisionxMes(Integer empleado, Date fecha) throws Exception {
		// TODO Auto-generated method stub
		Integer resultado = 0;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fechaomision", String.class,
				UFechaHora.convertirFechaCadena(fecha, "yyyyMM")));

		resultado = dao.contar("asautorizacion.contarOmisionxMes", filtros);

		if (UValidador.esNulo(resultado)) {
			resultado = 0;
		}

		return resultado;
	}

	@Override
	public BigDecimal obtenerHorasSobreTiempo(Integer empleado, Date fechainicio, Date fechafin) throws Exception {
		// TODO Auto-generated method stub
		BigDecimal resultado = BigDecimal.ZERO;
		List listado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fechaniciosemestre", Date.class, fechainicio));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafinsemestre", Date.class, fechafin));

		listado = dao.listarPorQuery(DtoAsAutorizacion.class, "asautorizacion.obtenerHorasSobreTiempo", filtros);

		if (!UValidador.esListaVacia(listado)) {
			resultado = ((DtoAsAutorizacion) listado.get(0)).getHorasSobretiempo1();
		}

		return resultado;
	}

	@Override
	public BigDecimal obtenerMinutosSobreTiempo(Integer empleado, Date fechainicio, Date fechafin) throws Exception {
		// TODO Auto-generated method stub
		BigDecimal resultado = BigDecimal.ZERO;
		List listado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fechaniciosemestre", Date.class, fechainicio));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafinsemestre", Date.class, fechafin));

		listado = dao.listarPorQuery(DtoAsAutorizacion.class, "asautorizacion.obtenerMinutosSobreTiempo", filtros);

		if (!UValidador.esListaVacia(listado)) {
			resultado = ((DtoAsAutorizacion) listado.get(0)).getMinutosSobretiempo1();
		}

		return resultado;
	}

	@Override
	public BigDecimal obtenerMinutosSobreTiempo2(Integer empleado, Date fechainicio) throws Exception {
		// TODO Auto-generated method stub
		BigDecimal resultado = null;
		List listado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_desde", Date.class, fechainicio));

		listado = dao.listarPorQuery(DtoAsAutorizacion.class, "asautorizacion.obtenerMinutosSobreTiempo2", filtros);

		if (!UValidador.esListaVacia(listado)) {
			resultado = ((DtoAsAutorizacion) listado.get(0)).getMinutosSobretiempo2();
		}

		return resultado;
	}

	@Override
	public BigDecimal obtenerHorasSobreTiempo2(Integer empleado, String desde) throws Exception {
		// TODO Auto-generated method stub
		BigDecimal resultado = null;
		List listado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_desderegistro", String.class, desde));

		listado = dao.listarPorQuery(DtoAsAutorizacion.class, "asautorizacion.obtenerHorasSobreTiempo2", filtros);

		if (!UValidador.esListaVacia(listado)) {
			resultado = ((DtoAsAutorizacion) listado.get(0)).getHorasSobretiempo2();
		}

		return resultado;
	}

	@Override
	public BigDecimal obtenerHorasSobreTiempoAutorizado(Integer empleado) throws Exception {
		// TODO Auto-generated method stub
		BigDecimal resultado = null;
		List listado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));

		listado = dao.listarPorQuery(DtoAsAutorizacion.class, "asautorizacion.obtenerSobreTiempoAutorizado", filtros);

		if (!UValidador.esListaVacia(listado)) {
			resultado = ((DtoAsAutorizacion) listado.get(0)).getHorasSobretiempo();
		}

		return resultado;
	}

	@Override
	public BigDecimal sumarConRes(Integer empleado, String concepto, Date fechaini, Date fechafin, Date fechainiOrig,
			Date fechafinOrig) throws Exception {
		// TODO Auto-generated method stub
		BigDecimal resultado = BigDecimal.ZERO;
		List<DtoAsAutorizacion> listado = new ArrayList<>();

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_concepto", String.class, concepto));
		filtros.add(new ParametroPersistenciaGenerico("p_aniomes", String.class,
				UFechaHora.convertirFechaCadena(fechaini, "MM/yyyy")));
		filtros.add(new ParametroPersistenciaGenerico("p_desde_orig", String.class,
				UFechaHora.convertirFechaCadena(fechainiOrig, "dd/MM/yyyy")));
		filtros.add(new ParametroPersistenciaGenerico("p_hasta_orig", String.class,
				UFechaHora.convertirFechaCadena(fechafinOrig, "dd/MM/yyyy")));

		List data = dao.listarPorQuery(DtoAsAutorizacion.class, "asautorizacion.sumarConRes", filtros);

		if (!UValidador.esListaVacia(data)) {
			// sumamos las horas
			listado.addAll(data);
			for (DtoAsAutorizacion obj : listado) {
				resultado = resultado.add(wf_diftiempo(obj.getDesde(), obj.getHasta()));
			}
		}

		return resultado;
	}

	private BigDecimal wf_diftiempo(Date par_fechainicio, Date par_fechafin) {
		Integer w_segundos, w_dias;

		w_segundos = UFechaHora.obtenerSegundosTranscurridos(par_fechafin, par_fechainicio);
		w_dias = UFechaHora.obtenerDiasTranscurridos(par_fechafin, par_fechainicio);

		w_segundos = w_segundos + w_dias * 3600 * 24;

		return BigDecimal.valueOf(w_segundos).divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_DOWN);
	}

	@Override
	public Integer contarHijos(Integer empleado) throws Exception {
		// TODO Auto-generated method stub
		Integer resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));

		resultado = dao.contar("asautorizacion.contarHijos", filtros);

		if (UValidador.esNulo(resultado)) {
			resultado = 0;
		}

		return resultado;
	}

	@Override
	public Integer contarHijosMeses(Integer empleado, Date fecha, Integer meses) throws Exception {
		// TODO Auto-generated method stub
		Integer resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", String.class,
				UFechaHora.convertirFechaCadena(fecha, "dd/MM/yyyy")));
		filtros.add(new ParametroPersistenciaGenerico("p_meses", Integer.class, meses));

		resultado = dao.contar("asautorizacion.contarHijosMeses", filtros);

		if (UValidador.esNulo(resultado)) {
			resultado = 0;
		}

		return resultado;
	}

	@Override
	public Integer contarCantidadEnfechasPorConcepto(Integer empleado, String concepto, Date fechaini, Date fechafin,
			Date fechaoriginal) throws Exception {
		// TODO Auto-generated method stub
		Integer resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_concepto", String.class, concepto));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fechaini));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class, fechafin));
		filtros.add(new ParametroPersistenciaGenerico("p_fechaorig", Date.class, fechaoriginal));

		resultado = dao.contar("asautorizacion.contarCantidadEnfechasPorConcepto", filtros);

		if (UValidador.esNulo(resultado)) {
			resultado = 0;
		}

		return resultado;
	}

	@Override
	public Integer contarCantidadDiasPorConcepto(Integer empleado, String concepto, Date fechaini, Date fechafin,
			Date fechaoriginal) throws Exception {
		// TODO Auto-generated method stub
		Integer resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_concepto", String.class, concepto));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fechaini));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class, fechafin));
		filtros.add(new ParametroPersistenciaGenerico("p_fechaorig", Date.class, fechaoriginal));

		resultado = dao.contar("asautorizacion.contarCantidadDiasPorConcepto", filtros);

		if (UValidador.esNulo(resultado)) {
			resultado = 0;
		}

		return resultado;
	}

	@Override
	public Integer contarHijosCumpleanios(Integer empleado, Date fecha) throws Exception {
		// TODO Auto-generated method stub
		Integer resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));

		resultado = dao.contar("asautorizacion.contarHijosCumpleanios", filtros);

		if (UValidador.esNulo(resultado)) {
			resultado = 0;
		}

		return resultado;
	}

	@Override
	public Integer contarHijosConyugueCumpleanios(Integer empleado, Date fecha) throws Exception {
		// TODO Auto-generated method stub
		Integer resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));

		resultado = dao.contar("asautorizacion.contarHijosConyugueCumpleanios", filtros);

		if (UValidador.esNulo(resultado)) {
			resultado = 0;
		}

		return resultado;
	}

	@Override
	public List listarSolicitudesPeriodo(Integer empleado, String concepto, Date fechainioriginal,
			Date fechafinoriginal, BigDecimal periodoactual) {

		List resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_concepto", String.class, concepto));
		filtros.add(new ParametroPersistenciaGenerico("p_desde_orig", Date.class, fechainioriginal));
		filtros.add(new ParametroPersistenciaGenerico("p_hasta_orig", Date.class, fechafinoriginal));
		filtros.add(new ParametroPersistenciaGenerico("p_periodo", String.class, periodoactual.toString()));

		resultado = dao.listarPorQuery(DtoAsAutorizacion.class, "asautorizacion.listarSolicitudesPeriodo", filtros);

		return resultado;
	}

	@Override
	public BigDecimal obtenerHoraGanadas(Integer empleado, Date fechainicio, Date fechafin) throws Exception {
		// TODO Auto-generated method stub
		BigDecimal resultado = BigDecimal.ZERO;
		List listado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fechainiciosemestre", Date.class, fechainicio));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafinsemestre", Date.class, fechafin));

		listado = dao.listarPorQuery(DtoAsAutorizacion.class, "asautorizacion.obtenerHoraGanadas", filtros);

		if (!UValidador.esListaVacia(listado)) {
			resultado = ((DtoAsAutorizacion) listado.get(0)).getHorasSobretiempo1();
		}

		return resultado;
	}

	@Override
	public BigDecimal obtenerHorasSobreTiempo3(Integer empleado, Date desde, Date hasta) throws Exception {
		// TODO Auto-generated method stub
		BigDecimal resultado = null;
		List listado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fechainiciosemestre", Date.class, desde));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafinsemestre", Date.class, hasta));

		listado = dao.listarPorQuery(DtoAsAutorizacion.class, "asautorizacion.obtenerHorasSobreTiempo3", filtros);

		if (!UValidador.esListaVacia(listado)) {
			resultado = ((DtoAsAutorizacion) listado.get(0)).getHorasSobretiempo2();
		}

		return resultado;
	}

	@Override
	public List<DtoPermisosEnCompensacion> listarPermisosCompensacion(Integer empleado, Integer anio) throws Exception {
		// TODO Auto-generated method stub
		BigDecimal resultado = null;
		List listado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_anio", Integer.class, anio));

		listado = dao.listarPorQuery(DtoPermisosEnCompensacion.class, "asautorizacion.listarPermisosCompensacion",
				filtros);

		return listado;
	}

	@Override
	public List<DtoPermisosEnCompensacion> listarPermisosViernesVerano(Integer empleado, Date desde, Date hasta)
			throws Exception {
		// TODO Auto-generated method stub
		BigDecimal resultado = null;
		List listado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_desde", Date.class, desde));
		filtros.add(new ParametroPersistenciaGenerico("p_hasta", Date.class, hasta));

		listado = dao.listarPorQuery(DtoPermisosEnCompensacion.class, "asautorizacion.listarPermisosViernesVerano",
				filtros);

		return listado;
	}

	@Override
	public Integer contarHorasEnfechasPorConcepto(Integer empleado, String concepto, Date fechaini, Date fechafin,
			Date fechaoriginal) throws Exception {
		// TODO Auto-generated method stub
		Integer resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_concepto", String.class, concepto));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fechaini));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class, fechafin));
		filtros.add(new ParametroPersistenciaGenerico("p_fechaorig", Date.class, fechaoriginal));

		resultado = dao.contar("asautorizacion.contarHorasEnfechasPorConcepto", filtros);

		if (UValidador.esNulo(resultado)) {
			resultado = 0;
		}

		return resultado;
	}

	@Override
	public Integer contarEnfechasPorTicket(Integer empleado, String concepto, Date fechaini, Date fechafin,
			Date fechaoriginal) throws Exception {
		// TODO Auto-generated method stub
		Integer resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_concepto", String.class, concepto));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fechaini));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class, fechafin));
		filtros.add(new ParametroPersistenciaGenerico("p_fechaorig", Date.class, fechaoriginal));

		resultado = dao.contar("asautorizacion.contarEnfechasPorTicket", filtros);

		if (UValidador.esNulo(resultado)) {
			resultado = 0;
		}

		return resultado;
	}

	@Override
	public Integer contarPadresAbuelos(Integer empleado) throws Exception {
		// TODO Auto-generated method stub
		Integer resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));

		resultado = dao.contar("asautorizacion.contarPadresAbuelos", filtros);

		if (UValidador.esNulo(resultado)) {
			resultado = 0;
		}

		return resultado;
	}

	@Override
	public Date obtenerHorarioEmpleado(Integer empleado, Date fecha, String tipo) throws Exception {
		// TODO Auto-generated method stub
		Date resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", String.class,
				UFechaHora.convertirFechaCadena(fecha, "dd/MM/yyyy")));
		filtros.add(new ParametroPersistenciaGenerico("p_tipo", String.class, tipo));

		List data = dao.listarPorQuery(DtoPermisosEnCompensacion.class, "asautorizacion.obtenerHorarioEmpleado",
				filtros);

		if (!UValidador.esNulo(data)) {
			if (!UValidador.esNulo(data.get(0))) {
				resultado = ((DtoPermisosEnCompensacion) data.get(0)).getDesde();
			}
		}

		return resultado;
	}

	@Override
	public List<DtoAsAutorizacion> obtenerlicenciasempleadoPorFecha(Integer empleado, Date fechainicio, Date fechafin) {
		// TODO Auto-generated method stub
		List<DtoAsAutorizacion> resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fechainicio", Date.class, fechainicio));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class, fechafin));

		List dt = dao.listarPorQuery(DtoAsAutorizacion.class, "asautorizacion.obtenerlicenciasempleadoPorFecha",
				filtros);

		if (!UValidador.esNulo(dt)) {
			resultado = dt;
		}

		return resultado;
	}

	@Override
	public List<DtoAsAutorizacion> obtenervacacionesempleadoPorFecha(Integer empleado, Date fechainicio, Date fechafin,
			Integer maxperiodo) {
		// TODO Auto-generated method stub
		List<DtoAsAutorizacion> resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fechainicio", Date.class, fechainicio));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class, fechafin));
		filtros.add(new ParametroPersistenciaGenerico("p_numeroperiodo", Integer.class, maxperiodo));

		List dt = dao.listarPorQuery(DtoAsAutorizacion.class, "asautorizacion.obtenervacacionesempleadoPorFecha",
				filtros);

		if (!UValidador.esNulo(dt)) {
			resultado = dt;
		}

		return resultado;
	}

	@Override
	public Integer contarPermisosFechasSIGED(Integer empleado, String concepto, Date fecha, Date fechafin,
			Date fechainioriginal, Date fechafinoriginal) throws Exception {
		// TODO Auto-generated method stub
		Integer resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_concepto", String.class, concepto));
		filtros.add(new ParametroPersistenciaGenerico("p_fechainicio", String.class,
				UFechaHora.convertirFechaCadena(fecha, "dd/MM/yyyy")));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafin", String.class,
				UFechaHora.convertirFechaCadena(fechafin, "dd/MM/yyyy")));
		filtros.add(new ParametroPersistenciaGenerico("p_fechainioriginal", String.class,
				UFechaHora.convertirFechaCadena(fechainioriginal, "dd/MM/yyyy")));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafinoriginal", String.class,
				UFechaHora.convertirFechaCadena(fechafinoriginal, "dd/MM/yyyy")));
		resultado = dao.contar("asautorizacion.contarPermisosFechasSIGED", filtros);

		if (UValidador.esNulo(resultado)) {
			resultado = 0;
		}

		return resultado;
	}

	@Override
	public Integer contarSolicitudIngressoSST(String codigousuario, Date fecha) throws Exception {
		// TODO Auto-generated method stub
		Integer resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_codigousuario", String.class, codigousuario));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));
		resultado = dao.contar("asautorizacion.contarSolicitudIngressoSST", filtros);

		if (UValidador.esNulo(resultado)) {
			resultado = 0;
		}

		return resultado;
	}

}
