package net.royal.rrhh.desempenio.paginacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrCompetenciasList;
import net.royal.framework.web.core.UValidador;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.model.SelectableDataModel;

public class PWHrCompetenciasList extends
		ListDataModel<DtoDwHrCompetenciasList> implements
		SelectableDataModel<DtoDwHrCompetenciasList>, Serializable {

	
	private static Log LOGGER = LogFactory
			.getLog(PWHrCompetenciasList.class);
	private List<DtoDwHrCompetenciasList> lstResultado;
	public PWHrCompetenciasList(List<DtoDwHrCompetenciasList> lstResultado) {
		super(lstResultado);
	}
	
	@Override
	public Object getRowKey(DtoDwHrCompetenciasList object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DtoDwHrCompetenciasList getRowData(String rowKey) {
		if (!UValidador.esListaVacia(lstResultado)) {
			for (DtoDwHrCompetenciasList x : lstResultado) {
				if (x.getFecha().equals(rowKey))
					return x;
			}
		}

		return null;
	}

}
