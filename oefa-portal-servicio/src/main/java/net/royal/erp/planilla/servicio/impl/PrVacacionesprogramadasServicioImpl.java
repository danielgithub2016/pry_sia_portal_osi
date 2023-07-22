package net.royal.erp.planilla.servicio.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import net.royal.erp.planilla.dao.PrVacacionesprogramadasDao;
import net.royal.erp.planilla.dominio.PrVacacionesprogramadas;
import net.royal.erp.planilla.dominio.dto.DtoDwPrVacacionesProgramadas;
import net.royal.erp.planilla.dominio.dto.DtoPrVacacionPeriodo;
import net.royal.erp.planilla.dominio.dto.DtoPrVacacionUtilizacion;
import net.royal.erp.planilla.dominio.dto.DtoPrVacacionesprogramadas;
import net.royal.erp.planilla.servicio.PrVacacionesprogramadasServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioPrVacacionesprogramadas")
public class PrVacacionesprogramadasServicioImpl extends GenericoServicioImpl
		implements PrVacacionesprogramadasServicio {

	private PrVacacionesprogramadasDao dao;

	private static Log LOGGER = LogFactory.getLog(PrVacacionesprogramadasServicioImpl.class);

	@Autowired
	public void setDao(PrVacacionesprogramadasDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public BigDecimal obtenerMaximoVacacionesProgramadas(Integer empleado, String periodo) {
		return dao.obtenerMaximoVacacionesProgramadas(empleado, periodo);
	}

	@Override
	public List<PrVacacionesprogramadas> listarVacacionesProgramadas(Integer empleado, String periodoasistencia,
			Date fechainicio, Date fechafin) {
		return dao.listarVacacionesProgramadas(empleado, periodoasistencia, fechainicio, fechafin);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<DtoDwPrVacacionesProgramadas> listarReporteProgramadas(String estado, String ano, Integer empleado,
			String compania, String tipoplanilla) {
		List<ParametroPersistenciaGenerico> parametros = Arrays.asList(
				new ParametroPersistenciaGenerico("estado", String.class, estado),
				new ParametroPersistenciaGenerico("ano", String.class, ano),
				new ParametroPersistenciaGenerico("empleado", Integer.class, empleado),
				new ParametroPersistenciaGenerico("compania", String.class, compania),
				new ParametroPersistenciaGenerico("tipoplanilla", String.class, tipoplanilla));

		return (List) dao.listarPorQuery(DtoDwPrVacacionesProgramadas.class,
				"prvacacionesprogramadas.dwprvacacionesprogramadas", parametros);
	}

	@Override
	public Integer contarVacacionesUtilizacion(Integer empleado, Date fechainicio, Date fechafin) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<>();
		parametros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		parametros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fechainicio));
		parametros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class, fechafin));

		return dao.contar("prvacacionesprogramadas.contarVacacionesUtilizacion", parametros);
	}

	@Override
	public List<DtoPrVacacionPeriodo> obtenerPendientesNroPeriodoPorEmpleado(Integer empleado, Date fecha,
			Date fechainiOriginal, Date fechafinOriginal, String accion, String concepto) {
		// TODO Auto-generated method stub
		List<DtoPrVacacionPeriodo> resultado = null;
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<>();
		parametros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		parametros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, fecha));
		parametros.add(new ParametroPersistenciaGenerico("p_fechainiorig", Date.class, fechainiOriginal));
		parametros.add(new ParametroPersistenciaGenerico("p_fechafinorig", Date.class, fechafinOriginal));
		parametros.add(new ParametroPersistenciaGenerico("p_accion", String.class, accion));
		parametros.add(new ParametroPersistenciaGenerico("p_concepto", String.class, concepto));

		dao.ejecutarPorQuery("prvacacionesprogramadas.generarSaldoEmpleado", parametros);

		parametros = new ArrayList<>();
		parametros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));

		List data = dao.listarPorQuery(DtoPrVacacionPeriodo.class,
				"prvacacionesprogramadas.obtenerPendientesNroPeriodoPorEmpleado", parametros);
		if (!UValidador.esListaVacia(data)) {
			resultado = data;
		}

		return resultado;

	}

	@Override
	public List<DtoPrVacacionesprogramadas> obtenerDiasUitlesPorEmpleado(Integer empleado) {
		// TODO Auto-generated method stub
		List<DtoPrVacacionesprogramadas> resultado = null;
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<>();
		parametros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		List data = dao.listarPorQuery(DtoPrVacacionesprogramadas.class,
				"prvacacionesprogramadas.obtenerDiasUitlesPorEmpleado", parametros);
		if (!UValidador.esListaVacia(data)) {
			resultado = data;
		}

		return resultado;
	}

	@Override
	public List<DtoPrVacacionPeriodo> obtenerDerechoPorEmpleado(Integer empleado, Integer periodo) {
		// TODO Auto-generated method stub
		List<DtoPrVacacionPeriodo> resultado = null;
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<>();
		parametros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		parametros.add(new ParametroPersistenciaGenerico("p_periodo", Integer.class, periodo));

		List data = dao.listarPorQuery(DtoPrVacacionPeriodo.class, "prvacacionesprogramadas.obtenerDerechoPorEmpleado",
				parametros);
		if (!UValidador.esListaVacia(data)) {
			resultado = data;
		}

		return resultado;

	}

	@Override
	public void eliminarVacacionPago(Integer empleado, Date fechainicio, Date fechafin) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<>();
		parametros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		parametros.add(new ParametroPersistenciaGenerico("p_fechainicio", Date.class, fechainicio));
		parametros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class, fechafin));

		dao.ejecutarPorQuery("prvacacionesprogramadas.eliminarVacacionPago", parametros);
	}

	@Override
	public void sinEfectoVacacionUtilizacion(Integer empleado, String compania, Date fechainicio, Date fechafin) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<>();
		parametros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		parametros.add(new ParametroPersistenciaGenerico("p_compania", Integer.class, compania));
		parametros.add(new ParametroPersistenciaGenerico("p_fechainicio", Date.class, fechainicio));
		parametros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class, fechafin));

		dao.ejecutarPorQuery("prvacacionesprogramadas.sinEfectoVacacionUtilizacion", parametros);
	}

	@Override
	public void sinEfectoVacacionProgramda(Integer empleado, String periodo, Date fechainicio, Date fechafin) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<>();
		parametros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		parametros.add(new ParametroPersistenciaGenerico("p_periodo", String.class, periodo));
		parametros.add(new ParametroPersistenciaGenerico("p_fechainicio", Date.class, fechainicio));
		parametros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class, fechafin));

		dao.ejecutarPorQuery("prvacacionesprogramadas.sinEfectoVacacionProgramda", parametros);
	}

	@Override
	public List<PrVacacionesprogramadas> listarVacacionesEjecutadas(Integer empleado, String periodoasistencia,
			Date fechainicio, Date fechafin) {
		// TODO Auto-generated method stub
		return dao.listarVacacionesEjecutadas(empleado, periodoasistencia, fechainicio, fechafin);
	}

	@Override
	public List<DtoPrVacacionPeriodo> listarVacacionPeriodo(Integer empleado) {
		// TODO Auto-generated method stub
		List<DtoPrVacacionPeriodo> resultado = null;
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<>();
		parametros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		List data = dao.listarPorQuery(DtoPrVacacionPeriodo.class, "prvacacionesprogramadas.listarVacacionPeriodo",
				parametros);
		if (!UValidador.esListaVacia(data)) {
			resultado = data;
		}

		return resultado;
	}

	@Override
	public List<DtoPrVacacionUtilizacion> listarVacacionUtilizacion(Integer empleado, Integer periodo) {
		// TODO Auto-generated method stub
		List<DtoPrVacacionUtilizacion> resultado = null;
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<>();
		parametros.add(new ParametroPersistenciaGenerico("p_empleado", Integer.class, empleado));
		parametros.add(new ParametroPersistenciaGenerico("p_periodo", Integer.class, periodo));
		List data = dao.listarPorQuery(DtoPrVacacionUtilizacion.class,
				"prvacacionesprogramadas.listarVacacionUtilizacion", parametros);
		if (!UValidador.esListaVacia(data)) {
			resultado = data;
		}

		return resultado;
	}

}
