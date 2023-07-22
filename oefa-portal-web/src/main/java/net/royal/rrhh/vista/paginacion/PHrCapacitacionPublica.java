package net.royal.rrhh.vista.paginacion;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import net.royal.comun.vista.controladora.CComunGlobal;
import net.royal.erp.rrhh.dominio.HrCapacitacion;
import net.royal.framework.web.dao.impl.GenericoDaoImpl.SORT_ORDER;
import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

public class PHrCapacitacionPublica extends LazyDataModel<HrCapacitacion> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ParametroPersistenciaGenerico> parametros;

	public PHrCapacitacionPublica(List<ParametroPersistenciaGenerico> parametros) {
		this.parametros = parametros;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<HrCapacitacion> load(int registroInicio, int registrosPorPagina, String campoOrden, SortOrder sortOrder,
			Map<String, Object> filters) {

		// inicializando parametros
		List lstResultado;
		ParametroPaginacion paginacion = new ParametroPaginacion();

		// seteando los valores de la paginacion para la consulta
		paginacion.setRegistroInicio(registroInicio);
		paginacion.setRegistrosPorPagina(registrosPorPagina);
		paginacion.setParametros(parametros);
		paginacion.setClazz(HrCapacitacion.class);
		paginacion.setCampoOrden(campoOrden);
		paginacion.setDireccionOrden(sortOrder == SortOrder.DESCENDING ? SORT_ORDER.DESC : SORT_ORDER.ASC);

		// llamando al negocio para devolver los datos
		paginacion = CComunGlobal.getInstance().getFacRrhh().getHrCapacitacionServicio()
				.listarCapacitacionPublicada(paginacion);

		// devolviendo los valores obtenidos
		setRowCount(paginacion.getRegistroEncontrados());
		lstResultado = paginacion.getListaResultado();

		return lstResultado;
	}
}
