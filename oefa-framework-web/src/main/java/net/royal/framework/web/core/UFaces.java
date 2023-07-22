package net.royal.framework.web.core;

import javax.el.ELException;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UFaces {

	private static FacesContext context;
	private static Application application;

	private static final Log LOGGER = LogFactory.getLog(UFaces.class);

	public static FacesContext getContext() {
		if (context != null)
			return context;
		context = FacesContext.getCurrentInstance();
		return context;
	}

	public static Application getApplication() {
		if (application != null)
			return application;
		application = FacesContext.getCurrentInstance().getApplication();
		return application;
	}

	public static Object getBean(String key) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRequestMap().get(key);
	}

	public static void setBean(String key, Object value) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap()
				.put(key, value);
	}

	/**
	 * 
	 * @param nombreControladoraSession
	 * @param tipoClase
	 * @return
	 * @throws ELException
	 */
	public static <T> T getControladora(String nombreControladoraSession,
			Class<? extends T> tipoClase) throws ELException {

		String controladora = null;
		controladora = "#{" + nombreControladoraSession + "}";
		FacesContext context = FacesContext.getCurrentInstance();

		if (context == null) {
			LOGGER.error("el context esta en nulo");
		}

		if (context.getApplication() != null) {
			return context.getApplication().evaluateExpressionGet(context,
					controladora, tipoClase);
		}
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param expression
	 *            expresion que se desea evaluar, en el caso de que se requiera
	 *            una controladora se debe especificar #{NOMBRE_CONTROLADORA}
	 * @param expectedType
	 *            clase que se desea obtener del faces
	 * @return
	 * @throws ELException
	 */
	public static <T> T evaluateExpressionGet(String expression,
			Class<? extends T> expectedType) throws ELException {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context == null) {
			LOGGER.error("el context esta en nulo");
		}

		if (context.getApplication() != null) {
			return context.getApplication().evaluateExpressionGet(context,
					expression, expectedType);
		}
		throw new UnsupportedOperationException();
	}
}
