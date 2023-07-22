package net.royal.erp.asistencia.asuser.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsuserFuncion")
public class AsuserFuncion {

	private static Log LOGGER = LogFactory.getLog(AsuserFuncion.class);

	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	/**
	 *
	 * @author desarrollo
	 * @throws Exception
	 * @powerbuilder asuser.f_get_hr_licencia_empleado_fecha
	 */
	public Integer FGetHrLicenciaEmpleadoFecha(Integer par_empleado, Date par_desde, Date par_hasta) throws Exception {
		LOGGER.debug("test de asuser.f_get_hr_licencia_empleado_fecha");
		Integer ll_return;
		par_desde = UFechaHora.obtenerFechaHoraInicioDia(par_desde);
		par_hasta = UFechaHora.obtenerFechaHoraInicioDia(par_hasta);

		List<ParametroPersistenciaGenerico> filtro = new ArrayList<ParametroPersistenciaGenerico>();
		filtro.add(new ParametroPersistenciaGenerico("par_empleado", Integer.class, par_empleado));
		filtro.add(new ParametroPersistenciaGenerico("par_desde", Date.class, par_desde));
		filtro.add(new ParametroPersistenciaGenerico("par_hasta", Date.class, par_hasta));
		LOGGER.debug("par_empleado ==  w_empleado == " + par_empleado);
		LOGGER.debug("par_desde == w_fecha == " + par_desde);
		LOGGER.debug("par_hasta == w_fecha == " + par_hasta);
		ll_return = dao.contar("asuser.obtenerContadorLicencias", filtro);
		if (UValidador.esNulo(ll_return)) {
			ll_return = 0;
		}
		return ll_return;
	}

	/**
	 *
	 * @author desarrollo
	 * @throws Exception
	 * @powerbuilder asuser.f_get_vacacion_empleado_fecha
	 */
	public Integer FGetVacacionEmpleadoFecha(Integer par_empleado, Date par_desde, Date par_hasta) throws Exception {
		LOGGER.debug("test de asuser.f_get_vacacion_empleado_fecha");

		Integer ll_return;
		par_desde = UFechaHora.obtenerFechaHoraInicioDia(par_desde);
		par_hasta = UFechaHora.obtenerFechaHoraInicioDia(par_hasta);

		List<ParametroPersistenciaGenerico> filtro = new ArrayList<ParametroPersistenciaGenerico>();
		filtro.add(new ParametroPersistenciaGenerico("par_empleado", Integer.class, par_empleado));
		filtro.add(new ParametroPersistenciaGenerico("par_desde", String.class,
				UFechaHora.convertirFechaCadena(par_desde, "dd/MM/yyyy")));
		filtro.add(new ParametroPersistenciaGenerico("par_hasta", String.class,
				UFechaHora.convertirFechaCadena(par_hasta, "dd/MM/yyyy")));

		ll_return = dao.contar("asuser.obtenerContador", filtro);
		if (UValidador.esNulo(ll_return)) {
			ll_return = 0;
		}
		return ll_return;
	}

}
