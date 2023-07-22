package net.royal.asistencia.vista.paginacion;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import net.royal.comun.vista.controladora.CComunGlobal;
import net.royal.erp.asistencia.dominio.dto.DtoFiltrosGenericos;
import net.royal.erp.rrhh.dominio.HrPostulantes;
import net.royal.erp.rrhh.dominio.dto.DtoHrPostulantes;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl.SORT_ORDER;
import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

public class PHrPostulantes extends LazyDataModel<DtoHrPostulantes> implements Serializable {

	private static Log LOGGER = LogFactory.getLog(PWAsAutorizacionPreprocesoAprobacion.class);

	private List<DtoHrPostulantes> lstResultado;
	private List<ParametroPersistenciaGenerico> parametros;

	public PHrPostulantes(List<ParametroPersistenciaGenerico> parametros) {
		this.parametros = parametros;
	}

	@Override
	public DtoHrPostulantes getRowData(String rowKey) {
		if (!UValidador.esListaVacia(lstResultado)) {
			for (DtoHrPostulantes x : lstResultado) {
				if (rowKey.equalsIgnoreCase(x.getPostulante())) {
					return x;
				}
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(DtoHrPostulantes dtoIdrow) {
		return dtoIdrow.getPostulante();
	}

	@Override
	public List<DtoHrPostulantes> load(int registroInicio, int registrosPorPagina, String campoOrden, SortOrder sortOrder,
			Map<String, Object> filters) {

		// inicializando parametros
		// List lstResultado;
		ParametroPaginacion paginacion = new ParametroPaginacion();

		// seteando los valores de la paginacion para la consulta
		paginacion.setRegistroInicio(registroInicio);
		paginacion.setRegistrosPorPagina(registrosPorPagina);
		paginacion.setParametros(parametros);
		paginacion.setClazz(DtoHrPostulantes.class);
		paginacion.setCampoOrden(campoOrden);
		paginacion.setDireccionOrden(sortOrder == SortOrder.DESCENDING ? SORT_ORDER.DESC : SORT_ORDER.ASC);

		// llamando al negocio para devolver los datos
		paginacion = CComunGlobal.getInstance().getFacRrhh().getHrPostulantesServicio().listarPaginacion(paginacion);
		setRowCount(paginacion.getRegistroEncontrados());
		lstResultado = paginacion.getListaResultado();

		return lstResultado;
	}

	public List<DtoHrPostulantes> getLstResultado() {
		return lstResultado;
	}

	public void setLstResultado(List<DtoHrPostulantes> lstResultado) {
		this.lstResultado = lstResultado;
	}

	public List<ParametroPersistenciaGenerico> getParametros() {
		return parametros;
	}

	public void setParametros(List<ParametroPersistenciaGenerico> parametros) {
		this.parametros = parametros;
	}

}
