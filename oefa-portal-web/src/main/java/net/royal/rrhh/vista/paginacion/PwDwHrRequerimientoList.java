package net.royal.rrhh.vista.paginacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoList;
import net.royal.framework.web.core.UValidador;

import org.primefaces.model.SelectableDataModel;

public class PwDwHrRequerimientoList extends
		ListDataModel<DtoDwHrRequerimientoList> implements
		SelectableDataModel<DtoDwHrRequerimientoList>, Serializable {

	public PwDwHrRequerimientoList(List<DtoDwHrRequerimientoList> data) {
		super(data);
	}

	@Override
	public DtoDwHrRequerimientoList getRowData(String rowKey) {
		// TODO Auto-generated method stub
		List<DtoDwHrRequerimientoList> lstObjetos = (List<DtoDwHrRequerimientoList>) getWrappedData();
		DtoDwHrRequerimientoList dtoObjetoDevolver = new DtoDwHrRequerimientoList();

		if (!UValidador.esListaVacia(lstObjetos)) {
			for (DtoDwHrRequerimientoList x : lstObjetos) {
				if (x.getRequerimiento().equals(rowKey)) {
					return x;
				}
			}
		}

		return dtoObjetoDevolver;
	}

	@Override
	public Object getRowKey(DtoDwHrRequerimientoList dtoObjetoDevolver) {
		// TODO Auto-generated method stub
		if (!UValidador.estaVacio(dtoObjetoDevolver.getRequerimiento())) {
			return dtoObjetoDevolver.getRequerimiento();
		}
		return 0;
	}

}
