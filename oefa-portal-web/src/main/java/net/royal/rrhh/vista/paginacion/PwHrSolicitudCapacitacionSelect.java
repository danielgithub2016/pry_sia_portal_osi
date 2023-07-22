package net.royal.rrhh.vista.paginacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.rrhh.hrothers.dominio.dto.DtoHrEvaluacionCapacValor;
import net.royal.framework.web.core.UValidador;

import org.primefaces.model.SelectableDataModel;

public class PwHrSolicitudCapacitacionSelect extends
		ListDataModel<DtoHrEvaluacionCapacValor> implements
		SelectableDataModel<DtoHrEvaluacionCapacValor>, Serializable {

	public PwHrSolicitudCapacitacionSelect(List<DtoHrEvaluacionCapacValor> data) {
		super(data);
	}

	@Override
	public DtoHrEvaluacionCapacValor getRowData(String rowKey) {
		// TODO Auto-generated method stub
		List<DtoHrEvaluacionCapacValor> lstObjetos = (List<DtoHrEvaluacionCapacValor>) getWrappedData();
		DtoHrEvaluacionCapacValor dtoObjetoDevolver = new DtoHrEvaluacionCapacValor();

		if (!UValidador.esListaVacia(lstObjetos)) {
			for (DtoHrEvaluacionCapacValor x : lstObjetos) {
				if (x.getTotal().equals(rowKey)) {
					return x;
				}
			}
		}

		return dtoObjetoDevolver;
	}

	@Override
	public Object getRowKey(DtoHrEvaluacionCapacValor dtoObjetoDevolver) {
		// TODO Auto-generated method stub
		if (!UValidador.esNulo(dtoObjetoDevolver.getTotal())) {
			return "" + dtoObjetoDevolver.getTotal();
		}
		return 0;
	}

}
