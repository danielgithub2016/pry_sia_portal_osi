package net.royal.rrhh.vista.paginacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.rrhh.dominio.HrFactorvalorcapac;
import net.royal.framework.web.core.UValidador;

import org.primefaces.model.SelectableDataModel;

public class PwHrFactoresValorCapacList extends
		ListDataModel<HrFactorvalorcapac> implements
		SelectableDataModel<HrFactorvalorcapac>, Serializable {

	public PwHrFactoresValorCapacList(List<HrFactorvalorcapac> data) {
		super(data);
	}

	@Override
	public HrFactorvalorcapac getRowData(String rowKey) {
		// TODO Auto-generated method stub
		List<HrFactorvalorcapac> lstObjetos = (List<HrFactorvalorcapac>) getWrappedData();
		HrFactorvalorcapac dtoObjetoDevolver = new HrFactorvalorcapac();

		if (!UValidador.esListaVacia(lstObjetos)) {
			for (HrFactorvalorcapac x : lstObjetos) {
				if (x.getPk().equals(rowKey)) {
					return x;
				}
			}
		}

		return dtoObjetoDevolver;
	}

	@Override
	public Object getRowKey(HrFactorvalorcapac dtoObjetoDevolver) {
		// TODO Auto-generated method stub
		if (!UValidador.esNulo(dtoObjetoDevolver.getPk())) {
			return "" + dtoObjetoDevolver.getPk();
		}
		return 0;
	}

}
