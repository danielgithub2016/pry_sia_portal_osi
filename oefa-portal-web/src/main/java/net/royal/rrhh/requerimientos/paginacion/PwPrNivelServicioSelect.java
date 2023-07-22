package net.royal.rrhh.requerimientos.paginacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.presupuesto.dominio.BuNivelserviciomst;
import net.royal.erp.sistema.dominio.dto.DtoDwWhImportacionSelect;
import net.royal.framework.web.core.UValidador;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.model.SelectableDataModel;

public class PwPrNivelServicioSelect extends
		ListDataModel<BuNivelserviciomst> implements
		SelectableDataModel<BuNivelserviciomst>, Serializable {

	private static Log LOGGER = LogFactory.getLog(PwPrNivelServicioSelect.class);
	private List<BuNivelserviciomst> lstResultado;

	public PwPrNivelServicioSelect(
			List<BuNivelserviciomst> lstResultado) {
		super(lstResultado);
	}

	
	@Override
	public Object getRowKey(BuNivelserviciomst object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuNivelserviciomst getRowData(String rowKey) {
		if (!UValidador.esListaVacia(lstResultado)) {
			for (BuNivelserviciomst x : lstResultado) {
				if (x.getPk().equals(rowKey))
					return x;
			}
		}

		return null;
	}

}
