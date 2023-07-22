package net.royal.rrhh.desempenio.paginacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.core.dominio.MaMiscelaneosdetalle;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrCompetenciasList;
import net.royal.framework.web.core.UValidador;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.model.SelectableDataModel;

public class PWHrMiscelaneoSelectorVarios extends
		ListDataModel<MaMiscelaneosdetalle> implements
		SelectableDataModel<MaMiscelaneosdetalle>, Serializable {

	private static Log LOGGER = LogFactory
			.getLog(PWHrMiscelaneoSelectorVarios.class);
	private List<MaMiscelaneosdetalle> lstResultado;
	public PWHrMiscelaneoSelectorVarios(List<MaMiscelaneosdetalle> lstResultado) {
		super(lstResultado);
	}
	
	@Override
	public Object getRowKey(MaMiscelaneosdetalle object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MaMiscelaneosdetalle getRowData(String rowKey) {
		if (!UValidador.esListaVacia(lstResultado)) {
			for (MaMiscelaneosdetalle x : lstResultado) {
				if (x.getPk().getCodigoelemento().equals(rowKey))
					return x;
			}
		}

		return null;
	}

}
