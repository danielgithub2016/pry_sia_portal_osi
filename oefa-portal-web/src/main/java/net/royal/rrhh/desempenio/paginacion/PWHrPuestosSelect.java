package net.royal.rrhh.desempenio.paginacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrCursoSelector;
import net.royal.framework.web.core.UValidador;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.model.SelectableDataModel;

public class PWHrPuestosSelect extends ListDataModel<HrPuestoempresa> implements
		SelectableDataModel<HrPuestoempresa>, Serializable {

	private static Log LOGGER = LogFactory.getLog(PWHrPuestosSelect.class);
	private List<HrPuestoempresa> lstResultado;

	public PWHrPuestosSelect(List<HrPuestoempresa> lstResultado) {
		super(lstResultado);
	}

	@Override
	public Object getRowKey(HrPuestoempresa object) {

		return null;
	}

	@Override
	public HrPuestoempresa getRowData(String rowKey) {
		if (!UValidador.esListaVacia(lstResultado)) {
			for (HrPuestoempresa x : lstResultado) {
				if (x.getPk().getCodigopuesto().equals(rowKey))
					return x;
			}
		}

		return null;
	}

}
