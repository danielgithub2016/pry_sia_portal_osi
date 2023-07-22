package net.royal.asistencia.vista.paginacion;

import java.io.Serializable;
import net.royal.erp.asistencia.dominio.dto.DtoFiltrosGenericos;
import org.primefaces.model.LazyDataModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.model.SortOrder;

import net.royal.comun.vista.controladora.CComunGlobal;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl.SORT_ORDER;
import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

public class PWAsAutorizacionPreprocesoAprobacion extends
		LazyDataModel<DtoFiltrosGenericos> implements Serializable {

	private static Log LOGGER = LogFactory
			.getLog(PWAsAutorizacionPreprocesoAprobacion.class);

	private List<DtoFiltrosGenericos> lstResultado;
	private List<ParametroPersistenciaGenerico> parametros;
	private String tipo;

	public PWAsAutorizacionPreprocesoAprobacion(
			List<ParametroPersistenciaGenerico> parametros,String tipo) {
		this.parametros = parametros;
		this.tipo= tipo;
	}

	@Override
	public DtoFiltrosGenericos getRowData(String rowKey) {
		BigDecimal row = new BigDecimal(rowKey);
		int res;
		if (!UValidador.esListaVacia(lstResultado)) {
			for (DtoFiltrosGenericos x : lstResultado) {
				res = row.compareTo(x.getIdrow());
				LOGGER.debug("CODIGO COLUMNA" + res);
				if (res == 0)
					return x;
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(DtoFiltrosGenericos dtoIdrow) {
		return dtoIdrow.getIdrow();
	}

	@Override
	public List<DtoFiltrosGenericos> load(int registroInicio,
			int registrosPorPagina, String campoOrden, SortOrder sortOrder,
			Map<String, Object> filters) {

		// inicializando parametros
		// List lstResultado;
		ParametroPaginacion paginacion = new ParametroPaginacion();

		// seteando los valores de la paginacion para la consulta
		paginacion.setRegistroInicio(registroInicio);
		paginacion.setRegistrosPorPagina(registrosPorPagina);
		paginacion.setParametros(parametros);
		paginacion.setClazz(DtoFiltrosGenericos.class);
		paginacion.setCampoOrden(campoOrden);
		paginacion
				.setDireccionOrden(sortOrder == SortOrder.DESCENDING ? SORT_ORDER.DESC
						: SORT_ORDER.ASC);

		// llamando al negocio para devolver los datos

		setRowCount(paginacion.getRegistroEncontrados());
		lstResultado = paginacion.getListaResultado();

		return lstResultado;
	}

	public List<DtoFiltrosGenericos> getLstResultado() {
		return lstResultado;
	}

	public void setLstResultado(List<DtoFiltrosGenericos> lstResultado) {
		this.lstResultado = lstResultado;
	}

	public List<ParametroPersistenciaGenerico> getParametros() {
		return parametros;
	}

	public void setParametros(List<ParametroPersistenciaGenerico> parametros) {
		this.parametros = parametros;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
