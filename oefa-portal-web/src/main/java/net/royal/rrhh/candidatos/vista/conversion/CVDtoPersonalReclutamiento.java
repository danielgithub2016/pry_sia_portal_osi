package net.royal.rrhh.candidatos.vista.conversion;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import net.royal.erp.core.dominio.dto.DtoPersonamast;
import net.royal.erp.planilla.dominio.PrTipoplanilla;
import net.royal.erp.rrhh.dominio.dto.DtoTipoPlanilla;
import net.royal.framework.web.core.UValidador;

import org.apache.log4j.Logger;

@ManagedBean
@FacesConverter("CtvPersonaRecluta")
public class CVDtoPersonalReclutamiento implements Converter{
	Logger logger = Logger.getLogger(CVDtoPersonalReclutamiento.class);

	public static List<DtoPersonamast> lista = new ArrayList<DtoPersonamast>();
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (UValidador.estaVacio(arg2)) {
			return null;
		} else {
			String almCodigo = arg2;
			logger.debug(lista.size());
			for (DtoPersonamast al : lista) {
				if (!UValidador.esNulo(al.getPersona())) {
					if (al.getPersona().toString().equals(almCodigo)) {
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
			DtoPersonamast actual = (DtoPersonamast) arg2;
			if (UValidador.esNulo(actual.getPersona())) {
				return "";
			} else {
				return actual.getPersona().toString();
			}
		}
	}

}
