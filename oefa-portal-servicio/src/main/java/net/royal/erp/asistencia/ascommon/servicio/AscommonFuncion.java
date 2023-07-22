package net.royal.erp.asistencia.ascommon.servicio;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.core.dominio.dto.DtoAcCostCenterMst;
import net.royal.erp.rrhh.dominio.dto.DtoHrPuestoEmpresa;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAscommonFuncion")
public class AscommonFuncion {

	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	private static Log LOGGER = LogFactory.getLog(AscommonFuncion.class);
	
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder ascommon.f_select_descripcionpuesto
	 */
	public String FSelectDescripcionPuesto(Integer par_empleado) {
		LOGGER.debug("test de ascommon.f_select_descripcionpuesto");
		String ls_descripcionpuesto = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado",
				Integer.class, par_empleado));

		List data = dao.listarPorQuery(DtoHrPuestoEmpresa.class,
				"hrpuestoempresa.obtenerDescripcion", filtros);

		if (!UValidador.esListaVacia(data)) {
			ls_descripcionpuesto = ((DtoHrPuestoEmpresa) data.get(0))
					.getDescripcion();
		}

		if (UValidador.estaVacio(ls_descripcionpuesto)) {
			ls_descripcionpuesto = "";
		}

		return ls_descripcionpuesto;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder ascommon.f_sql_centrocosto_empleado
	 */
	public String FSqlCentroCostoEmpleado(Integer par_empleado) {
		LOGGER.debug("test de ascommon.f_sql_centrocosto_empleado");
		String centrocosto = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado",
				Integer.class, par_empleado));

		List data = dao.listarPorQuery(DtoAcCostCenterMst.class,
				"accostcentermst.obtenerLocalName", filtros);

		if (!UValidador.esListaVacia(data)) {
			centrocosto = ((DtoAcCostCenterMst) data.get(0)).getLocalname();
		}

		if (UValidador.estaVacio(centrocosto)) {
			centrocosto = "";
		}

		return centrocosto;
	}

}
