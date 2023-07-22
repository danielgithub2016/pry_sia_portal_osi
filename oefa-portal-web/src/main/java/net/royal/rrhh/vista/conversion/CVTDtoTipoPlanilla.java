package net.royal.rrhh.vista.conversion;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import net.royal.erp.rrhh.prmast.dominio.dto.DtoDwMaPrTipoplantillaSelect;
import net.royal.framework.web.core.UValidador;

@ManagedBean
@FacesConverter("tipoPlanilla")
public class CVTDtoTipoPlanilla implements Converter {

	public static List<DtoDwMaPrTipoplantillaSelect> lista = new ArrayList<DtoDwMaPrTipoplantillaSelect>();
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (UValidador.estaVacio(arg2)) {
			return null;
		} else {
			String almCodigo = arg2;
			for (DtoDwMaPrTipoplantillaSelect al : lista) {
				if (!UValidador.esNulo(al.getTipoplanilla())) {
					if (al.getTipoplanilla().equals(almCodigo)) {
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
			DtoDwMaPrTipoplantillaSelect actual = (DtoDwMaPrTipoplantillaSelect) arg2;
			if (UValidador.esNulo(actual.getTipoplanilla())) {
				return "";
			} else {
				return actual.getTipoplanilla();
			}
		}
	}

}
