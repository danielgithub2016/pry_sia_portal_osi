package net.royal.erp.asistencia.asoracle.servicio;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.asistencia.asoracle.dominio.dto.DtoDddwAsTipohorarioSelect;
import net.royal.erp.asistencia.asoracle.dominio.dto.DtoDwAsEmpleadoSelectMultiple;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsoracleDatawindow")
public class AsoracleDatawindow {

	private static Log LOGGER = LogFactory.getLog(AsoracleDatawindow.class);
	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asoracle.dddw_as_tipohorario_select
	 */
	public List DddwAsTipohorarioSelect() {
		LOGGER.debug("test de asoracle.dddw_as_tipohorario_select");
		LOGGER.debug(" usar el siguiente dto :  DtoDddwAsTipohorarioSelect");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  asoracle.DddwAsTipohorarioSelect");

		return dao.listarPorQuery(DtoDddwAsTipohorarioSelect.class, "asoracle.DddwAsTipohorarioSelect");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asoracle.dw_as_empleado_select_multiple
	 */
	public List DwAsEmpleadoSelectMultiple(Integer an_sid, String w_filtroCod, String w_filtroNom) {
		LOGGER.debug("test de asoracle.dw_as_empleado_select_multiple");
		LOGGER.debug(" usar el siguiente dto :  DtoDwAsEmpleadoSelectMultiple");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  asoracle.DwAsEmpleadoSelectMultiple");

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		LOGGER.debug(" Parametro SID: " + an_sid);

		filtros.add(new ParametroPersistenciaGenerico("an_sid", Integer.class, an_sid));

		filtros.add(new ParametroPersistenciaGenerico("w_filtroNom", String.class,
				UValidador.estaVacio(w_filtroNom) ? "" : "%" + w_filtroNom + "%"));

		filtros.add(new ParametroPersistenciaGenerico("w_filtroCod", String.class, w_filtroCod));
		List lista = dao.listarPorQuery(DtoDwAsEmpleadoSelectMultiple.class, "asoracle.DwAsEmpleadoSelectMultiple",
				filtros);

		return lista;

	}

	/**
	 *
	 * @author desarrollo
	 */
	public List DwAsEmpleadoSelectAll(Integer an_sid, String w_filtroCod, String w_filtroNom) {
		LOGGER.debug("test de asoracle.dw_as_empleado_select_multiple");
		LOGGER.debug(" usar el siguiente dto :  DtoDwAsEmpleadoSelectAll");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  asoracle.DwAsEmpleadoAll");

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		LOGGER.debug(" Parametro SID: " + an_sid);

		filtros.add(new ParametroPersistenciaGenerico("p_userid", Integer.class, an_sid));

		filtros.add(new ParametroPersistenciaGenerico("w_filtroNom", String.class,
				UValidador.estaVacio(w_filtroNom) ? "" : "%" + w_filtroNom + "%"));

		filtros.add(new ParametroPersistenciaGenerico("w_filtroCod", String.class, w_filtroCod));
		List lista = dao.listarPorQuery(DtoDwAsEmpleadoSelectMultiple.class, "asoracle.DwAsEmpleadoSelectAll", filtros);

		return lista;

	}

	/**
	 *
	 * @author desarrollo
	 */
	public List DwAsEmpleadoConceptoReporte(String userid, String w_filtroCod, String w_filtroNom) {
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();

		filtros.add(new ParametroPersistenciaGenerico("p_userid", String.class, userid));
		filtros.add(new ParametroPersistenciaGenerico("w_filtroNom", String.class, w_filtroNom));

		filtros.add(new ParametroPersistenciaGenerico("w_filtroCod", String.class, w_filtroCod));
		List lista = dao.listarPorQuery(DtoDwAsEmpleadoSelectMultiple.class, "asoracle.DwAsEmpleadoConceptoReporte",
				filtros);

		return lista;

	}

}
