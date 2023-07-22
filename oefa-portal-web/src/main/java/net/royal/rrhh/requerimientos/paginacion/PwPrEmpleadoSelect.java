package net.royal.rrhh.requerimientos.paginacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.asistencia.asmast.dominio.dto.DtoDwPrEmpleadoSelect;
import net.royal.framework.web.core.UValidador;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.model.SelectableDataModel;

public class PwPrEmpleadoSelect extends ListDataModel<DtoDwPrEmpleadoSelect>
implements SelectableDataModel<DtoDwPrEmpleadoSelect>, Serializable {

	private static Log LOGGER = LogFactory
			.getLog(PwPrEmpleadoSelect.class);
	private List<DtoDwPrEmpleadoSelect> lstResultado;
	
	public PwPrEmpleadoSelect(List<DtoDwPrEmpleadoSelect> lstResultado) {
		super(lstResultado);
	}

	@Override
	public Object getRowKey(DtoDwPrEmpleadoSelect object) {
		
		return null;
	}

	@Override
	public DtoDwPrEmpleadoSelect getRowData(String rowKey) {
		if (!UValidador.esListaVacia(lstResultado)) {
			for (DtoDwPrEmpleadoSelect x : lstResultado) {
				if (x.getPersona().equals(rowKey))
					return x;
			}
		}

		return null;
	}

}
