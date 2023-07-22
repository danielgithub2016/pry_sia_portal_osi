package net.royal.rrhh.requerimientos.paginacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrCursoSelector;
import net.royal.framework.web.core.UValidador;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.model.SelectableDataModel;

public class PWHrCursoSelector extends ListDataModel<DtoDwHrCursoSelector>
		implements SelectableDataModel<DtoDwHrCursoSelector>, Serializable {

	private static Log LOGGER = LogFactory
			.getLog(PwPrNivelServicioSelect.class);
	private List<DtoDwHrCursoSelector> lstResultado;

	public PWHrCursoSelector(List<DtoDwHrCursoSelector> lstResultado) {
		super(lstResultado);
	}

	@Override
	public Object getRowKey(DtoDwHrCursoSelector object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DtoDwHrCursoSelector getRowData(String rowKey) {
		if (!UValidador.esListaVacia(lstResultado)) {
			for (DtoDwHrCursoSelector x : lstResultado) {
				if (x.getCurso().equals(rowKey))
					return x;
			}
		}

		return null;
	}

	public List<DtoDwHrCursoSelector> getLstResultado() {
		return lstResultado;
	}

	public void setLstResultado(List<DtoDwHrCursoSelector> lstResultado) {
		this.lstResultado = lstResultado;
	}

}
