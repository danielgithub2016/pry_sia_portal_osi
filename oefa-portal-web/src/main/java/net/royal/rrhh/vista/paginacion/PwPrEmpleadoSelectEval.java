package net.royal.rrhh.vista.paginacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.asistencia.asmast.dominio.dto.DtoDwPrEmpleadoSelect;
import net.royal.framework.web.core.UValidador;

import org.primefaces.model.SelectableDataModel;

public class PwPrEmpleadoSelectEval extends
		ListDataModel<DtoDwPrEmpleadoSelect> implements
		SelectableDataModel<DtoDwPrEmpleadoSelect>, Serializable {

	public PwPrEmpleadoSelectEval(List<DtoDwPrEmpleadoSelect> data) {
		super(data);
	}

	@Override
	public DtoDwPrEmpleadoSelect getRowData(String rowKey) {
		// TODO Auto-generated method stub
		List<DtoDwPrEmpleadoSelect> lstObjetos = (List<DtoDwPrEmpleadoSelect>) getWrappedData();
		DtoDwPrEmpleadoSelect dtoObjetoDevolver = new DtoDwPrEmpleadoSelect();

		if (!UValidador.esListaVacia(lstObjetos)) {
			for (DtoDwPrEmpleadoSelect x : lstObjetos) {
				if (x.getTotal().equals(rowKey)) {
					return x;
				}
			}
		}

		return dtoObjetoDevolver;
	}

	@Override
	public Object getRowKey(DtoDwPrEmpleadoSelect dtoObjetoDevolver) {
		// TODO Auto-generated method stub
		if (!UValidador.esNulo(dtoObjetoDevolver.getTotal())) {
			return "" + dtoObjetoDevolver.getTotal();
		}
		return 0;
	}

}
