package net.royal.rrhh.vista.paginacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoSelectMultipleSincia;
import net.royal.framework.web.core.UValidador;

import org.primefaces.model.SelectableDataModel;

public class PwHrEmpleadoSelectMultipleSincia extends
		ListDataModel<DtoDwHrEmpleadoSelectMultipleSincia> implements
		SelectableDataModel<DtoDwHrEmpleadoSelectMultipleSincia>, Serializable {

	public PwHrEmpleadoSelectMultipleSincia(List<DtoDwHrEmpleadoSelectMultipleSincia> data) {
		super(data);
	}

	@Override
	public DtoDwHrEmpleadoSelectMultipleSincia getRowData(String rowKey) {
		// TODO Auto-generated method stub
		List<DtoDwHrEmpleadoSelectMultipleSincia> lstObjetos = (List<DtoDwHrEmpleadoSelectMultipleSincia>) getWrappedData();
		DtoDwHrEmpleadoSelectMultipleSincia dtoObjetoDevolver = new DtoDwHrEmpleadoSelectMultipleSincia();

		if (!UValidador.esListaVacia(lstObjetos)) {
			for (DtoDwHrEmpleadoSelectMultipleSincia x : lstObjetos) {
				if (x.getTotal().equals(rowKey)) {
					return x;
				}
			}
		}

		return dtoObjetoDevolver;
	}

	@Override
	public Object getRowKey(DtoDwHrEmpleadoSelectMultipleSincia dtoObjetoDevolver) {
		// TODO Auto-generated method stub
		if (!UValidador.esNulo(dtoObjetoDevolver.getTotal())) {
			return "" + dtoObjetoDevolver.getTotal();
		}
		return 0;
	}

}
