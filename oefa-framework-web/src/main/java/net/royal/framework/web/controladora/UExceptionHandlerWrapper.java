package net.royal.framework.web.controladora;

import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import net.royal.framework.web.core.UConstante;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.context.RequestContext;

public class UExceptionHandlerWrapper extends ExceptionHandlerWrapper {

	private static Log LOGGER = LogFactory
			.getLog(UExceptionHandlerWrapper.class);
	private ExceptionHandler handler;

	public UExceptionHandlerWrapper(ExceptionHandler handler) {
		this.handler = handler;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return handler;
	}

	@Override
	public void handle() throws FacesException {
		//LOGGER.debug("UExceptionHandlerWrapper.handle");

		for (Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents()
				.iterator(); i.hasNext();) {
			// The ExeceptionQueuedEvent is a SystemEvent from which we can get
			// the actual ViewExpiredException
			ExceptionQueuedEvent queuedEvent = i.next();
			ExceptionQueuedEventContext queuedEventContext = (ExceptionQueuedEventContext) queuedEvent
					.getSource();
			Throwable throwable = queuedEventContext.getException();
			if (throwable instanceof ViewExpiredException) {
				ViewExpiredException viewExpiredException = (ViewExpiredException) throwable;
				FacesContext facesContext = FacesContext.getCurrentInstance();
				// for ultimately showing a JSF page we want to extract some
				// information from the exception and place it in request scope,
				// so we can access it via EL in the page
				Map<String, Object> map = facesContext.getExternalContext()
						.getRequestMap();
				NavigationHandler navigationHandler = facesContext
						.getApplication().getNavigationHandler();
				try {
					LOGGER.debug("redireccionando a la pantalla de login por la perdida de session");
					// we put the current view, where ViewExpiredException
					// occurrs, in "currentViewId" variable
					map.put(UConstante.SESION_NAVIGATIONCASE_ACTUAL,
							viewExpiredException.getViewId());
					// leverage the JSF implicit navigation system and cause the
					// server to navigate to the "viewExpired" page
					// we will show viewExpired page with meaningful message.
					// the view or page name is viewExpired.xhtml
					// viewExpired.xhtml is put on the root path as index.xhtml
					// file
					navigationHandler.handleNavigation(facesContext, null,
							UConstante.NAVIGATIONCASE_VISTAEXPIRADA);
					// render the response

//					RequestContext.getCurrentInstance().execute(
//							"PF('popTimeOut').show()");
					facesContext.renderResponse();
				} finally {
					// we call remove() on the iterator. This is an important
					// part of the ExceptionHandler usage contract.
					// If you handle an exception, you have to remove it from
					// the list of unhandled exceptions
					i.remove();
				}
			}
		}
		getWrapped().handle();
	}
}
