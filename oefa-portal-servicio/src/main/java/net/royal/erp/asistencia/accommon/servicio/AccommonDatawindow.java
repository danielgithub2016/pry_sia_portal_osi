package net.royal.erp.asistencia.accommon.servicio;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.asistencia.accommon.dominio.dto.DtoDwAcAfeSelectAfemstElement;
import net.royal.erp.asistencia.accommon.dominio.dto.DtoDwMaAcCostcenterSelect;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

@Service(value = "BeanServicioAccommonDatawindow")
public class AccommonDatawindow {

	private static Log LOGGER = LogFactory.getLog(AccommonDatawindow.class);

	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder accommon.dw_ac_afe_select_afemst_element
	 */
	public ParametroPaginacion DwAcAfeSelectAfemstElement(ParametroPaginacion paginacion) {
		LOGGER.debug("test de accommon.dw_ac_afe_select_afemst_element");
		LOGGER.debug(" usar el siguiente dto :  DtoDwAcAfeSelectAfemstElement");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  accommon.DwAcAfeSelectAfemstElement");
		
		Integer registros;
		List lstResultado;

		paginacion = new ParametroPaginacion();

		List datos = dao.listarPorQuery(
				DtoDwAcAfeSelectAfemstElement.class,
				"accommon.DwAcAfeSelectAfemstElement");

		registros = dao.contar(
				"accommon.DwAcAfeSelectAfemstElementConteo");

		LOGGER.debug("ESTOS SON LOS REGISTROS: " + registros);

		paginacion.setRegistroEncontrados(registros.intValue());
		paginacion.setListaResultado(datos);
		return paginacion;
	
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder accommon.dw_ma_ac_costcenter_select
	 */
	public List DwMaAcCostcenterSelect(String requisicionnumero) {
		LOGGER.debug("test de accommon.dw_ma_ac_costcenter_select");
		LOGGER.debug(" usar el siguiente dto :  DtoDwMaAcCostcenterSelect");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  accommon.DwMaAcCostcenterSelect");

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();

		return dao.listarPorQuery(DtoDwMaAcCostcenterSelect.class,
				"accommon.DwMaAcCostcenterSelect", filtros);

	}
	
	


}
