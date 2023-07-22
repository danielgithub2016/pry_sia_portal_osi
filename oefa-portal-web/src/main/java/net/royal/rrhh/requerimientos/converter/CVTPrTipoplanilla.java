package net.royal.rrhh.requerimientos.converter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import net.royal.erp.planilla.dominio.PrTipoplanilla;
import net.royal.framework.web.core.UValidador;

import org.apache.log4j.Logger;

@ManagedBean
@FacesConverter("PrTipoplanilla")
public class CVTPrTipoplanilla implements Converter{
	Logger logger = Logger.getLogger(CVTPrTipoplanilla.class);

	public static List<PrTipoplanilla> lista = new ArrayList<PrTipoplanilla>();
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (UValidador.estaVacio(arg2)) {
			return null;
		} else {
			String almCodigo = arg2;
			logger.debug(lista.size());
			for (PrTipoplanilla al : lista) {
				if (!UValidador.esNulo(al.getPk().getTipoplanilla())) {
					if (al.getPk().getTipoplanilla().equals(almCodigo)) {
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
			PrTipoplanilla actual = (PrTipoplanilla) arg2;
			if (UValidador.esNulo(actual.getPk().getTipoplanilla())) {
				return "";
			} else {
				return actual.getPk().getTipoplanilla();
			}
		}
	}

}
