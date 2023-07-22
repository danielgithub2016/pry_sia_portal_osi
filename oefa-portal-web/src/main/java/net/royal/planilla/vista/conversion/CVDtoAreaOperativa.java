package net.royal.planilla.vista.conversion;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import net.royal.erp.asistencia.dominio.AsArea;
import net.royal.framework.web.core.UValidador;

@ManagedBean
@FacesConverter("CtvAreaOperativa")
public class CVDtoAreaOperativa implements Converter{
	Logger logger = Logger.getLogger(CVDtoAreaOperativa.class);

	public static List<AsArea> lista = new ArrayList<AsArea>();
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (UValidador.estaVacio(arg2)) {
			return null;
		} else {
			String almCodigo = arg2;
			logger.debug(lista.size());
			for (AsArea al : lista) {
				if (!UValidador.esNulo(al.getPk().getArea())) {
					if (al.getPk().getArea().equals(almCodigo)) {
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
			AsArea actual = (AsArea) arg2;
			if (UValidador.esNulo(actual.getPk().getArea())) {
				return "";
			} else {
				return actual.getPk().getArea().toString();
			}
		}
	}

}
