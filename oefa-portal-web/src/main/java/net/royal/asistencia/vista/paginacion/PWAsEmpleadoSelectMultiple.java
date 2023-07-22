package net.royal.asistencia.vista.paginacion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.model.ListDataModel;

import net.royal.erp.asistencia.asoracle.dominio.dto.DtoDwAsEmpleadoSelectMultiple;
import net.royal.framework.web.core.UValidador;

import org.primefaces.model.SelectableDataModel;


	public class PWAsEmpleadoSelectMultiple extends ListDataModel<DtoDwAsEmpleadoSelectMultiple> 
	implements SelectableDataModel<DtoDwAsEmpleadoSelectMultiple>, Serializable {

		
		public PWAsEmpleadoSelectMultiple(List<DtoDwAsEmpleadoSelectMultiple> data) {
	     super(data);
	 }
		
		
		@Override
		public DtoDwAsEmpleadoSelectMultiple getRowData(String rowKey) {
			List<DtoDwAsEmpleadoSelectMultiple> lstObjetos = (List<DtoDwAsEmpleadoSelectMultiple>) getWrappedData();
			DtoDwAsEmpleadoSelectMultiple dtoObjetoDevolver = new DtoDwAsEmpleadoSelectMultiple();
			BigDecimal row= new BigDecimal(rowKey);
			   int res;
			if (!UValidador.esListaVacia(lstObjetos)) {
				for (DtoDwAsEmpleadoSelectMultiple x : lstObjetos) {
				    res = row.compareTo(x.getPersona()); 
	               if(res==0)
	             	  return x;
				}
			}
			
			return dtoObjetoDevolver;
		}

		@Override
		public Object getRowKey(DtoDwAsEmpleadoSelectMultiple dtoObjetoDevolver) {
			if (!UValidador.esNulo(dtoObjetoDevolver.getPersona())) {
				return dtoObjetoDevolver.getPersona().toString();
			}
			return 0;
		}

	}

	
	
	
