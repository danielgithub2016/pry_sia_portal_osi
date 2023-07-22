package net.royal.framework.web.conversion;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UConvertPeriodoContable implements Converter {

	private static Log LOGGER = LogFactory
			.getLog(UConvertPeriodoContable.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		String periodocontable;

		LOGGER.debug("entro al converter : UConvertPeriodoContable");

		if (value == null)
			return null;
		periodocontable = value.trim();
		if (periodocontable.length() != 6)
			return periodocontable;

		periodocontable = periodocontable.substring(0, 4) + "-"
				+ periodocontable.substring(5, 2);

		return periodocontable;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return value.toString();
	}

}
