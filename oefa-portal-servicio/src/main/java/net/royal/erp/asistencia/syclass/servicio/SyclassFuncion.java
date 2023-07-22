package net.royal.erp.asistencia.syclass.servicio;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.core.dominio.dto.DtoEmpleadomast;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioSyclassFuncion")
public class SyclassFuncion {

	private static Log LOGGER = LogFactory.getLog(SyclassFuncion.class);

	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder syclass.f_sql_centrocosto_empleado
	 */
	public String FSqlCentrocostoEmpleado(Integer par_empleado) {
		LOGGER.debug("test de syclass.f_sql_centrocosto_empleado");
		String centrocosto = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado",
				Integer.class, par_empleado));

		List data = dao.listarPorQuery(DtoEmpleadomast.class,
				"empleadomast.obtenerCentroCosto", filtros);

		if (!UValidador.esListaVacia(data)) {
			centrocosto = ((DtoEmpleadomast) data.get(0)).getCentrocostos();
		}

		return centrocosto;
	}

	

}
