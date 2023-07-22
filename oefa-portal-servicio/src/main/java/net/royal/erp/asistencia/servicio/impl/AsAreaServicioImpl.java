package net.royal.erp.asistencia.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.asistencia.dao.AsAreaDao;
import net.royal.erp.asistencia.dominio.AsArea;
import net.royal.erp.asistencia.servicio.AsAreaServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsArea")
public class AsAreaServicioImpl extends GenericoServicioImpl implements
		AsAreaServicio {

	private AsAreaDao dao;

	private static Log LOGGER = LogFactory.getLog(AsAreaServicioImpl.class);

	@Autowired
	public void setDao(AsAreaDao dao) {
		this.dao = dao;
		this.setGenericoDao(this.dao);
	}

	@Override
	public Integer obtenerEmpleadoResponsable(Integer empleado) {
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado",
				Integer.class, empleado));

		return dao.contar("asarea.obtenerEmpleadoResponsable", filtros);
	}

	/**
	 * 
	 * f_sql_get_areaoperativa_des
	 */
	@Override
	public String obtenerAreaOperativa(Integer par_empleado, String par_compania) {
		return dao.obtenerAreaOperativa(par_empleado, par_compania);
	}

	@Override
	public AsArea obtenerArea(Integer par_empleado, String par_compania) {
		return dao.obtenerArea(par_empleado, par_compania);
	}

	@Override
	public List<AsArea> listaComboAreaServicio() {
		return dao.listaComboAreaServicio();
	}

	@Override
	public AsArea obtenerAreaEmpleadoResponsable(Integer empleado) {
		// TODO Auto-generated method stub
		return dao.obtenerAreaEmpleadoResponsable(empleado);
	}

	@Override
	public Integer contarResponsablesArea(Integer empleado, String compania) {
		// TODO Auto-generated method stub
		Integer resultado = 0;
		AsArea area = dao.obtenerArea(empleado, compania);

		if (!UValidador.esNulo(area.getEmpleadoresponsable())) {
			resultado = 1;
		}
		if (!UValidador.esNulo(area.getEmpleadoresponsable2())) {
			resultado = 1;
		}
		if (!UValidador.esNulo(area.getEmpleadoresponsable3())) {
			resultado = 1;
		}
		if (!UValidador.esNulo(area.getEmpleadoresponsable4())) {
			resultado = 1;
		}

		return resultado;
	}
}
