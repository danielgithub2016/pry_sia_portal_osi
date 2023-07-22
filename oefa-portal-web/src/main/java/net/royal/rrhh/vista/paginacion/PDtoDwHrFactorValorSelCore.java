package net.royal.rrhh.vista.paginacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrFactorvalorSelCore;
import net.royal.framework.web.core.UValidador;

import org.primefaces.model.SelectableDataModel;

public class PDtoDwHrFactorValorSelCore extends
		ListDataModel<DtoDwHrFactorvalorSelCore> implements
		SelectableDataModel<DtoDwHrFactorvalorSelCore>, Serializable {

	public PDtoDwHrFactorValorSelCore(List<DtoDwHrFactorvalorSelCore> data) {
		super(data);
	}

	@Override
	public DtoDwHrFactorvalorSelCore getRowData(String rowKey) {
		// TODO Auto-generated method stub
		List<DtoDwHrFactorvalorSelCore> lstObjetos = (List<DtoDwHrFactorvalorSelCore>) getWrappedData();
		DtoDwHrFactorvalorSelCore dtoObjetoDevolver = new DtoDwHrFactorvalorSelCore();

		if (!UValidador.esListaVacia(lstObjetos)) {
			for (DtoDwHrFactorvalorSelCore x : lstObjetos) {
				if (x.getTotal().equals(rowKey)) {
					return x;
				}
			}
		}

		return dtoObjetoDevolver;
	}

	@Override
	public Object getRowKey(DtoDwHrFactorvalorSelCore dtoObjetoDevolver) {
		// TODO Auto-generated method stub
		if (!UValidador.esNulo(dtoObjetoDevolver.getTotal())) {
			return "" + dtoObjetoDevolver.getTotal();
		}
		return 0;
	}

}
