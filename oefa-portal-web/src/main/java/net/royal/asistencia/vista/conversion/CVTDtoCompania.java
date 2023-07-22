package net.royal.asistencia.vista.conversion;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import net.royal.erp.sistema.dominio.dto.DtoDwMaCompanyownerSelect;
import net.royal.framework.web.core.UValidador;

import org.apache.log4j.Logger;

@ManagedBean
@FacesConverter("compania")
public class CVTDtoCompania implements Converter{
	Logger logger = Logger.getLogger(CVTDtoCompania.class);

	public static List<DtoDwMaCompanyownerSelect> lista = new ArrayList<DtoDwMaCompanyownerSelect>();

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (UValidador.estaVacio(arg2)) {
			return null;
		} else {
			String almCodigo = arg2;
			logger.debug(lista.size());
			for (DtoDwMaCompanyownerSelect al : lista) {
				if (!UValidador.esNulo(al.getCompanyowner())) {
					if (al.getCompanyowner().equals(almCodigo)) {
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
			DtoDwMaCompanyownerSelect actual = (DtoDwMaCompanyownerSelect) arg2;
			if (UValidador.esNulo(actual.getCompanyowner())) {
				return "";
			} else {
				return actual.getCompanyowner();
			}
		}
	}

}
