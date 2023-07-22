package net.royal.rrhh.vista.paginacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.contabilidad.dominio.AcSucursal;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwFactoresCompetenciaHistorial;
import net.royal.framework.web.core.UValidador;

import org.primefaces.model.SelectableDataModel;

public class PwFactoresCompetenciaHistorial extends
		ListDataModel<DtoDwFactoresCompetenciaHistorial> implements
		SelectableDataModel<DtoDwFactoresCompetenciaHistorial>, Serializable {

	public PwFactoresCompetenciaHistorial(List<DtoDwFactoresCompetenciaHistorial> data) {
		super(data);
	}

	@Override
	public DtoDwFactoresCompetenciaHistorial getRowData(String rowKey) {
		// TODO Auto-generated method stub
		List<DtoDwFactoresCompetenciaHistorial> lstObjetos = (List<DtoDwFactoresCompetenciaHistorial>) getWrappedData();
		DtoDwFactoresCompetenciaHistorial dtoObjetoDevolver = new DtoDwFactoresCompetenciaHistorial();

		if (!UValidador.esListaVacia(lstObjetos)) {
			for (DtoDwFactoresCompetenciaHistorial x : lstObjetos) {
				if (x.getTotal().equals(rowKey)) {
					return x;
				}
			}
		}

		return dtoObjetoDevolver;
	}

	@Override
	public Object getRowKey(DtoDwFactoresCompetenciaHistorial dtoObjetoDevolver) {
		// TODO Auto-generated method stub
		if (!UValidador.esNulo(dtoObjetoDevolver.getTotal())) {
			return "" + dtoObjetoDevolver.getTotal();
		}
		return 0;
	}

}
