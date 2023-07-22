package net.royal.rrhh.candidatos.vista.conversion;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import net.royal.erp.planilla.dominio.PrTipoplanilla;
import net.royal.erp.rrhh.dominio.dto.DtoTipoPlanilla;
import net.royal.framework.web.core.UValidador;

import org.apache.log4j.Logger;

@ManagedBean
@FacesConverter("CtvTipoplanilla")
public class CVDtoTipoplanilla implements Converter{
	Logger logger = Logger.getLogger(CVDtoTipoplanilla.class);

	public static List<DtoTipoPlanilla> lista = new ArrayList<DtoTipoPlanilla>();
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (UValidador.estaVacio(arg2)) {
			return null;
		} else {
			String almCodigo = arg2;
//			logger.debug(lista.size());
			for (DtoTipoPlanilla al : lista) {
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
			DtoTipoPlanilla actual = (DtoTipoPlanilla) arg2;
			if (UValidador.esNulo(actual.getTipoplanilla())) {
				return "";
			} else {
				return actual.getTipoplanilla();
			}
		}
	}

}
