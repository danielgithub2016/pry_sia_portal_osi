package net.royal.rrhh.requerimientos.converter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.framework.web.core.UValidador;

import org.apache.log4j.Logger;

@ManagedBean
@FacesConverter("cvtHrPuestoEmpresa")
public class CVTHrPuestoEmpresa implements Converter {
	Logger logger = Logger.getLogger(CVTHrPuestoEmpresa.class);

	public static List<HrPuestoempresa> lista = new ArrayList<HrPuestoempresa>();

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (UValidador.estaVacio(arg2)) {
			return null;
		} else {
			String almCodigo = arg2;
			logger.debug(lista.size());
			for (HrPuestoempresa al : lista) {
				if (!UValidador.esNulo(al.getPk())) {
					if (al.getPk().getCodigopuesto().toString().equals(almCodigo)) {
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
			HrPuestoempresa actual = (HrPuestoempresa) arg2;
			if (UValidador.esNulo(actual.getPk())) {
				return "";
			} else {

				return actual.getPk().getCodigopuesto().toString();
			}
		}
	}

}
