package net.royal.rrhh.requerimientos.converter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import net.royal.erp.asistencia.symast.dominio.dto.DtoDwMaMiscelaneosdetalleSelect;
import net.royal.framework.web.core.UValidador;

import org.apache.log4j.Logger;



@ManagedBean
@FacesConverter("Miscelaneosdetalle")
public class CVTMiscelaneosdetalleSelect implements Converter{
	Logger logger = Logger.getLogger(CVTMiscelaneosdetalleSelect.class);
	
	public static List<DtoDwMaMiscelaneosdetalleSelect> lista = new ArrayList<DtoDwMaMiscelaneosdetalleSelect>();
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (UValidador.estaVacio(arg2)) {
			return null;
		} else {
			String almCodigo = arg2;
			logger.debug(lista.size());
			for (DtoDwMaMiscelaneosdetalleSelect al : lista) {
				if (!UValidador.esNulo(al.getCodigoelemento())) {
					if (al.getCodigoelemento().equals(almCodigo)) {
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
			DtoDwMaMiscelaneosdetalleSelect actual =  (DtoDwMaMiscelaneosdetalleSelect) arg2;
			if (UValidador.esNulo(actual.getCodigoelemento())) {
				return "";
			} else {
				return actual.getCodigoelemento();
			}
		}
	}

}
