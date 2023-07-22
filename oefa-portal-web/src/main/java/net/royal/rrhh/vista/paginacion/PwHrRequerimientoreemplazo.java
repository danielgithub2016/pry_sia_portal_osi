package net.royal.rrhh.vista.paginacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.rrhh.dominio.HrRequerimientoreemplazo;
import net.royal.framework.web.core.UValidador;

import org.primefaces.model.SelectableDataModel;

public class PwHrRequerimientoreemplazo extends
		ListDataModel<HrRequerimientoreemplazo> implements
		SelectableDataModel<HrRequerimientoreemplazo>, Serializable {

	public PwHrRequerimientoreemplazo(List<HrRequerimientoreemplazo> data) {
		super(data);
	}

	@Override
	public HrRequerimientoreemplazo getRowData(String rowKey) {
		// TODO Auto-generated method stub
		List<HrRequerimientoreemplazo> lstObjetos = (List<HrRequerimientoreemplazo>) getWrappedData();
		HrRequerimientoreemplazo dtoObjetoDevolver = new HrRequerimientoreemplazo();

		if (!UValidador.esListaVacia(lstObjetos)) {
			for (HrRequerimientoreemplazo x : lstObjetos) {
				if (x.getPk().getEmpleado().toString().equals(rowKey)) {
					return x;
				}
			}
		}

		return dtoObjetoDevolver;
	}

	@Override
	public Object getRowKey(HrRequerimientoreemplazo dtoObjetoDevolver) {
		// TODO Auto-generated method stub
		if (!UValidador.esNulo(dtoObjetoDevolver.getPk().getEmpleado())) {
			return "" + dtoObjetoDevolver.getPk().getEmpleado();
		}
		return 0;
	}

}
