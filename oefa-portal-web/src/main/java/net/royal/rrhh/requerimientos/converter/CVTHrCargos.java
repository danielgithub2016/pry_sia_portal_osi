package net.royal.rrhh.requerimientos.converter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import net.royal.erp.rrhh.dominio.HrCargosmast;
import net.royal.framework.web.core.UValidador;

import org.apache.log4j.Logger;

@ManagedBean
@FacesConverter("HrCargosmast")
public class CVTHrCargos implements Converter {
	Logger logger = Logger.getLogger(CVTHrCargos.class);

	public static List<HrCargosmast> lista = new ArrayList<HrCargosmast>();

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (UValidador.estaVacio(arg2)) {
			return null;
		} else {
			String almCodigo = arg2;
			logger.debug(lista.size());
			for (HrCargosmast al : lista) {
				if (!UValidador.esNulo(al.getPk().getCargo())) {
					if (al.getPk().getCargo().equals(almCodigo)) {
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
			HrCargosmast actual = (HrCargosmast) arg2;
			if (UValidador.esNulo(actual.getPk().getCargo())) {
				return "";
			} else {
				return actual.getPk().getCargo();
			}
		}
	}

}
