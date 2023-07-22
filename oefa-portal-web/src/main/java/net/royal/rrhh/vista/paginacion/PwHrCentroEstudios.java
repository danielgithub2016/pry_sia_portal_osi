package net.royal.rrhh.vista.paginacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.rrhh.hrothers.dominio.dto.DtoHrCentroEstudios;
import net.royal.framework.web.core.UValidador;

import org.primefaces.model.SelectableDataModel;

public class PwHrCentroEstudios extends
		ListDataModel<DtoHrCentroEstudios> implements
		SelectableDataModel<DtoHrCentroEstudios>, Serializable {

	public PwHrCentroEstudios(List<DtoHrCentroEstudios> data) {
		super(data);
	}

	@Override
	public DtoHrCentroEstudios getRowData(String rowKey) {
		// TODO Auto-generated method stub
		List<DtoHrCentroEstudios> lstObjetos = (List<DtoHrCentroEstudios>) getWrappedData();
		DtoHrCentroEstudios dtoObjetoDevolver = new DtoHrCentroEstudios();

		if (!UValidador.esListaVacia(lstObjetos)) {
			for (DtoHrCentroEstudios x : lstObjetos) {
				if (x.getCentro().equals(rowKey)) {
					return x;
				}
			}
		}

		return dtoObjetoDevolver;
	}

	@Override
	public Object getRowKey(DtoHrCentroEstudios dtoObjetoDevolver) {
		// TODO Auto-generated method stub
		if (!UValidador.esNulo(dtoObjetoDevolver.getCentro())) {
			return "" + dtoObjetoDevolver.getCentro();
		}
		return 0;
	}

}
