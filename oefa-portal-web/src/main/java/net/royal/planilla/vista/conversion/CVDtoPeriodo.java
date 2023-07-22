package net.royal.planilla.vista.conversion;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import net.royal.erp.core.dominio.MaCts;
import net.royal.erp.planilla.dominio.dto.DtoPeriodos;
import net.royal.framework.web.core.UValidador;

@ManagedBean
@FacesConverter("CtvPeriodo")
public class CVDtoPeriodo implements Converter{
	Logger logger = Logger.getLogger(CVDtoPeriodo.class);

	public static List<DtoPeriodos> lista = new ArrayList<DtoPeriodos>();
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (UValidador.estaVacio(arg2)) {
			return null;
		} else {
			String almCodigo = arg2;
//			logger.debug(lista.size());
			for (DtoPeriodos al : lista) {
				if (!UValidador.esNulo(al.getNumerocts())) {
					if (al.getNumerocts().equals(almCodigo)) {
						return al;
					}
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (UValidador.estaVacio(arg2)) {
			return "";
		} else {
			DtoPeriodos actual = (DtoPeriodos) arg2;
			if (UValidador.esNulo(actual.getNumerocts())) {
				return "";
			} else {
				return actual.getNumerocts().toString();
			}
		}
	}

}
