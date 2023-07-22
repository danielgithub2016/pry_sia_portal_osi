package net.royal.planilla.vista.conversion;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.core.dominio.MaUnidadnegocio;
import net.royal.erp.core.dominio.dto.DtoMaUnidadnegocio;
import net.royal.framework.web.core.UValidador;

@ManagedBean
@FacesConverter("CtvCentroCostos")
public class CVDtoCentroCostos implements Converter{
	Logger logger = Logger.getLogger(CVDtoCentroCostos.class);

	public static List<AcCostcentermst> lista = new ArrayList<AcCostcentermst>();
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (UValidador.estaVacio(arg2)) {
			return null;
		} else {
			String almCodigo = arg2;
			logger.debug(lista.size());
			for (AcCostcentermst al : lista) {
				if (!UValidador.esNulo(al.getPk().getCostcenter())) {
					if (al.getPk().getCostcenter().equals(almCodigo)) {
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
			AcCostcentermst actual = (AcCostcentermst) arg2;
			if (UValidador.esNulo(actual.getPk().getCostcenter())) {
				return "";
			} else {
				return actual.getPk().getCostcenter();
			}
		}
	}

}
