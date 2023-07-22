package net.royal.framework.web.controladora;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import net.royal.framework.web.core.UConstante;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.faces.application.ActionListenerImpl;

public class UBaseActionListiner extends ActionListenerImpl {

	private static final Log LOGGER = LogFactory
			.getLog(UBaseActionListiner.class);

	@Override
	public void processAction(ActionEvent event) {
		LOGGER.debug("UBaseActionListiner.processAction ==> custom");
		FacesContext fc = FacesContext.getCurrentInstance();
		Map sm = fc.getExternalContext().getSessionMap();

		String codigoError = (String) sm.get(UConstante.SESION_CONTROL_ERROR);
		if (codigoError == null)
			codigoError = UConstante.SESION_CONTROL_ERROR_SINERROR;
		sm.remove(UConstante.SESION_CONTROL_ERROR);

		if (codigoError.equals(UConstante.SESION_CONTROL_ERROR_SINERROR)) {
			super.processAction(event);
		} else if (codigoError.equals(UConstante.SESION_CONTROL_ERROR_SESSION)) {
			super.processAction(event);
		} else if (codigoError.equals(UConstante.SESION_CONTROL_ERROR_ACTIONLI)) {
			super.processAction(event);
		} else if (codigoError.equals(UConstante.SESION_CONTROL_ERROR_FILTROS)) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "este es error de filtros", null));
		}

	}
}
