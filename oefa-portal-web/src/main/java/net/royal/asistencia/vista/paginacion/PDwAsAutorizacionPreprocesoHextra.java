package net.royal.asistencia.vista.paginacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAutorizacionPreprocesoHextra;
import net.royal.framework.web.core.UValidador;

import org.primefaces.model.SelectableDataModel;

public class PDwAsAutorizacionPreprocesoHextra extends
		ListDataModel<DtoDwAsAutorizacionPreprocesoHextra> implements
		SelectableDataModel<DtoDwAsAutorizacionPreprocesoHextra>, Serializable {

	public PDwAsAutorizacionPreprocesoHextra(
			List<DtoDwAsAutorizacionPreprocesoHextra> data) {
		
		
		super(data);
		
		System.out.println("Valor 1PDwAsAutorizacionPreprocesoHextra");
	}

	@Override
	public DtoDwAsAutorizacionPreprocesoHextra getRowData(String rowKey) {
		System.out.println("Valor 2PDwAsAutorizacionPreprocesoHextra");
		// TODO Auto-generated method stub
		List<DtoDwAsAutorizacionPreprocesoHextra> lstObjetos = (List<DtoDwAsAutorizacionPreprocesoHextra>) getWrappedData();
		DtoDwAsAutorizacionPreprocesoHextra dtoObjetoDevolver = new DtoDwAsAutorizacionPreprocesoHextra();

		if (!UValidador.esListaVacia(lstObjetos)) {
			for (DtoDwAsAutorizacionPreprocesoHextra x : lstObjetos) {
				if ((x.getSecuencia().intValue() + "").equals(rowKey)) {
					return x;
				}
			}
		}

		return dtoObjetoDevolver;
	}

	@Override
	public Object getRowKey(
			DtoDwAsAutorizacionPreprocesoHextra dtoObjetoDevolver) {
		
		System.out.println("Valor 3PDwAsAutorizacionPreprocesoHextra");
		// TODO Auto-generated method stub
		if (!UValidador.esNulo(dtoObjetoDevolver.getSecuencia())) {
			return "" + dtoObjetoDevolver.getSecuencia().intValue();
		}
		return 0;
	}

}
