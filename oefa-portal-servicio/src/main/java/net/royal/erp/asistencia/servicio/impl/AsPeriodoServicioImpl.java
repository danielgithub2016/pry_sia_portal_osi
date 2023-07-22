package net.royal.erp.asistencia.servicio.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.dao.AsPeriodoDao;
import net.royal.erp.asistencia.dominio.dto.DtoAsPeriodo;
import net.royal.erp.asistencia.servicio.AsPeriodoServicio;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsPeriodo")
public class AsPeriodoServicioImpl extends GenericoServicioImpl implements
		AsPeriodoServicio {

	private AsPeriodoDao dao;

	private static Log LOGGER = LogFactory.getLog(AsPeriodoServicioImpl.class);

	@Autowired
	public void setDao(AsPeriodoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Integer obtenerMaximoPeriodoPlanilla() {
		// TODO Auto-generated method stub
		return dao.contar("asperiodo.obtenerMaximoPeriodoPlanilla");
	}

	@Override
	public Integer obtenerCantidad() {
		// TODO Auto-generated method stub
		return dao.contar("asperiodo.obtenerCantidad");
	}

	@Override
	public List obtenerRangoFechas(String periodo) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_periodo",
				String.class, periodo));
		return dao.listarPorQuery(DtoAsPeriodo.class,
				"asperiodo.obtenerRangoFechas", filtros);
	}

	@Override
	public Integer obtenerCantidadPorEmpleado(Integer empleado, Date fecha,
			Date fechafin) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado",
				Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class,
				fecha));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class,
				fechafin));

		return dao.contar("asperiodo.obtenerCantidadPorEmpleado", filtros);
	}

	/**
	 * f_calculate_period_first_and_last_day
	 */

	@Override
	public List calcularperiodoRango(String par_period) throws ParseException {
		LOGGER.debug("test de sycommon.f_calculate_period_first_and_last_day");
		List result = new ArrayList();

		String w_next;
		Date par_first_day, par_last_day;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		w_next = FCalculateNextPeriod(par_period, 1);

		String stringFecha1 = par_period.substring(0, 4) + "/"
				+ par_period.substring(4, 6) + "/" + "01";
		par_first_day = sdf.parse(stringFecha1);

		String stringFecha2 = w_next.substring(0, 4) + "/"
				+ w_next.substring(4, 6) + "/" + "01";
		par_last_day = sdf.parse(stringFecha2);

		par_last_day = UFechaHora.anadirDiasAFechas(par_last_day, -1);

		result.add(par_first_day);
		result.add(par_last_day);

		return result;

	}

	/**
	 * f_calculate_next_period
	 */
	public String FCalculateNextPeriod(String par_period, Integer par_number) {
		LOGGER.debug("test de sycomm.f_calculate_next_period");

		Integer w_year, w_month, w_inicio;
		w_year = Integer.parseInt(par_period.substring(0, 4));
		w_month = Integer.parseInt(par_period.substring(4, 6));
		w_month = w_month + par_number;

		if (w_month > 12) {
			w_year = w_year + (w_month / 12);
			w_month = w_month % 12;
		}

		if (UValidador.esCero(w_month)) {
			w_year = w_year - 1;
			w_month = 12;
		}

		if (w_month < 1) {
			w_month = Integer.parseInt(par_period.substring(4, 6));
			if (Math.abs(par_number) < w_month) {
				w_month = w_month + par_number;
			} else {
				if (Math.abs(par_number) == 12) {
					w_month = Integer.parseInt(par_period.substring(4, 6));
					w_year = w_year - 1;
				} else {
					w_inicio = 13;
					if (w_month > 1) {
						w_inicio = w_inicio + (w_month - 1);
					}
					w_month = w_inicio - Math.abs(par_number);
					w_year = w_year - 1;
				}
			}
		}

		String mes = String.format("%02d", w_month);

		return w_year.toString() + mes;

	}

	@Override
	public Integer obtenerCantidadPorEmpleadoNoAdmin(Integer empleado,
			Date fecha, Date fechafin) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado",
				Integer.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class,
				fecha));
		filtros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class,
				fechafin));

		return dao.contar("asperiodo.obtenerCantidadPorEmpleadoNoAdmin",
				filtros);
	}

	@Override
	public Date[] obtenerFechasActivas(String flgadmin) throws ParseException {
		return dao.obtenerFechasActivas(flgadmin);
	}

}
