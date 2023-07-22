package net.royal.rrhh.vista.conversion;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import net.royal.erp.rrhh.dominio.dto.DtoDWHrTipoContratoSelect;
import net.royal.framework.web.core.UValidador;

@ManagedBean
@FacesConverter("tipoContrato")
public class CVTDtoTipoContrato implements Converter {

	public static List<DtoDWHrTipoContratoSelect> lista = new ArrayList<DtoDWHrTipoContratoSelect>();

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (UValidador.estaVacio(arg2)) {
			return null;
		} else {
			String almCodigo = arg2;
			for (DtoDWHrTipoContratoSelect al : lista) {
				if (!UValidador.esNulo(al.getTipocontrato())) {
					if (al.getTipocontrato().equals(almCodigo)) {
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
			DtoDWHrTipoContratoSelect actual = (DtoDWHrTipoContratoSelect) arg2;
			if (UValidador.esNulo(actual.getTipocontrato())) {
				return "";
			} else {
				return actual.getTipocontrato();
			}
		}
	}

}
