package net.royal.rrhh.requerimientos.paginacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.presupuesto.dominio.BuCertificacion;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrCursoSelector;
import net.royal.framework.web.core.UValidador;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.model.SelectableDataModel;

public class PwBuCertificacionList extends ListDataModel<BuCertificacion>
		implements SelectableDataModel<BuCertificacion>, Serializable {

	private static Log LOGGER = LogFactory.getLog(PwBuCertificacionList.class);
	private List<BuCertificacion> lstResultado;
	
	public PwBuCertificacionList(List<BuCertificacion> lstResultado) {
		super(lstResultado);
	}

	@Override
	public Object getRowKey(BuCertificacion object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuCertificacion getRowData(String rowKey) {
		if (!UValidador.esListaVacia(lstResultado)) {
			for (BuCertificacion x : lstResultado) {
				if (x.getPk().equals(rowKey))
					return x;
			}
		}
		return null;
	}

}
