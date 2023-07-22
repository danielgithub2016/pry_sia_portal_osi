package net.royal.erp.asistencia.servicio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.erp.asistencia.dao.AsAccesosdiariosDao;
import net.royal.erp.asistencia.dominio.AsAccesosdiarios;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001MarcaEmpleado;
import net.royal.erp.asistencia.servicio.AsAccesosdiariosServicio;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioAsAccesosdiarios")
public class AsAccesosdiariosServicioImpl extends GenericoServicioImpl implements AsAccesosdiariosServicio {

	private AsAccesosdiariosDao dao;

	private static Log LOGGER = LogFactory.getLog(AsAccesosdiariosServicioImpl.class);

	@Autowired
	public void setDao(AsAccesosdiariosDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Integer obtenerTerminal(Integer empleado, Date fecha) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));
		return dao.contar("asaccesosdiarios.obtenerTerminal", filtros);
	}

	@Override
	@Transactional
	public void eliminarAccesosDiarios(Integer empleado, Date fecha, String conceptoacceso, Date fechadesde) {
		// TODO Auto-generated method stub
		Criteria cri = dao.getCriteria();
		cri.add(Restrictions.eq("pk.empleado", empleado));
		cri.add(Restrictions.eq("fechaA", fecha));
		cri.add(Restrictions.eq("conceptoaccesoA", conceptoacceso));
		cri.add(Restrictions.eq("desdeA", fechadesde));

		List<AsAccesosdiarios> lista = dao.listarPorCriterios(cri);

		if (!UValidador.esListaVacia(lista)) {
			for (AsAccesosdiarios obj : lista) {
				dao.eliminar(obj);
			}
		}

	}

	@Override
	public Integer obtenerMaximoSecuencia(Integer empleado, Date fecha) {
		return dao.incrementarPorEmpleadoFecha(empleado, fecha);
	}

	@Override
	public void insertarAccesosDiarios(String carnet, Date fecha, Integer secuencia, Integer empleado,
			String observacion, Integer anio, Integer mes, Integer dia, String userid) {

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_carnet", String.class, carnet));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));
		filtros.add(new ParametroPersistenciaGenerico("p_secuencia", Date.class, secuencia));
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_observacion", String.class, observacion));
		filtros.add(new ParametroPersistenciaGenerico("p_anio", Integer.class, anio));
		filtros.add(new ParametroPersistenciaGenerico("p_mes", Integer.class, mes));
		filtros.add(new ParametroPersistenciaGenerico("p_dia", Integer.class, dia));
		filtros.add(new ParametroPersistenciaGenerico("p_userid", String.class, "SISTEMA"));
		dao.ejecutarPorQuery("asaccesosdiarios.insertarAccesosDiarios", filtros);

	}

	@Override
	public List<AsAccesosdiarios> listarAsMarcar(String w_carnet, Date fechadesde, Date fechahasta) {
		return dao.listarAsMarcar(w_carnet, fechadesde, fechahasta);
	}

	@Override
	public Integer obtenerEmpleado(String w_carnet, Date w_fecha) {
		return dao.obtenerEmpleado(w_carnet, w_fecha);
	}

	@Override
	public void eliminarPorEmpleadoFecha(Integer empleado, Date fecha) {
		dao.eliminarPorEmpleadoFecha(empleado, fecha);

	}

	@Override
	public List<AsAccesosdiarios> listarAccesosdiariosxparam(Integer empleado, Date fechaA, Date fechaB) {
		return dao.listarAccesosdiariosxparam(empleado, fechaA, fechaB);
	}

	@Override
	public List<DtoDwAsRep001MarcaEmpleado> listarmarcacionXemplado(Integer user, String empleado, Date fechaini,
			Date fechafin, String flgisadmin, Integer sid, String coduser) throws Exception {

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();

		String query = new String(dao.obtenerSentenciaSqlPorQuery("asaccesosdiarios.marcacionempleadodetalle"));

		if (!UValidador.estaVacio(empleado)) {
			query = query.replace("[EMPLEADO_1]", " ca.empleado in (" + empleado + ") AND ");
			query = query.replace("[EMPLEADO_2]", " de.empleado in (" + empleado + ") AND ");
		} else {
			query = query.replace("[EMPLEADO_1]", " (ca.empleado = " + user + " OR '" + flgisadmin + "' = 'S') AND ");
			query = query.replace("[EMPLEADO_2]", " (de.empleado = " + user + " OR '" + flgisadmin + "' = 'S') AND ");
		}

		filtros.add(new ParametroPersistenciaGenerico("p_fechainicio", Date.class, fechaini));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class,
				UFechaHora.obtenerFechaHoraFinDia(fechafin)));
		filtros.add(new ParametroPersistenciaGenerico("p_sid", Integer.class, sid));
		filtros.add(new ParametroPersistenciaGenerico("p_admin", String.class, flgisadmin));
		filtros.add(new ParametroPersistenciaGenerico("user", String.class, coduser));

		List datos = dao.listarPorSentenciaSQL(new StringBuilder(query), filtros, DtoDwAsRep001MarcaEmpleado.class);

		return datos;
	}

	@Override
	@Transactional
	public void eliminarmarcacionsobretiempo(Integer empleado, Date fecha, String conceptoacceso) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();

		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));
		filtros.add(new ParametroPersistenciaGenerico("p_conceptoacceso", String.class, conceptoacceso));

		dao.ejecutarPorQuery("asaccesosdiarios.eliminarmarcacionsobretiempo", filtros);
	}
}
