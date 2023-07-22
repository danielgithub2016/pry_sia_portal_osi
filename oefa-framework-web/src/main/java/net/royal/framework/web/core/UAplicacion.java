package net.royal.framework.web.core;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class UAplicacion {

	private static final Log LOGGER = LogFactory.getLog(UAplicacion.class);
	private static ServletContextEvent servletContextEvent = null;
	private static ApplicationContext applicationContext = null;
	private static ServletContext servletContext;

	/**
	 * Retorna el servletContext de JSF
	 * 
	 * @return servletContext de JSF, tipo ServletContext
	 */
	public static ServletContext getServletContext() {
		if (servletContext != null)
			return servletContext;

		if (FacesContext.getCurrentInstance() != null) {
			servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
			return servletContext;
		}

		if (servletContextEvent != null) {
			servletContext = servletContextEvent.getServletContext();
			return (ServletContext) servletContextEvent.getServletContext();
		}

		return null;
	}

	public static ApplicationContext getSpringContext() {
		if (applicationContext != null)
			return applicationContext;

		UAplicacion.getServletContext();

		applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

		return applicationContext;
	}

	public static Object getSpringBean(String nombreBean) {
		try {
			UAplicacion.getSpringContext();
			applicationContext.getBean(nombreBean);
		} catch (Exception e) {
			LOGGER.error("getSpringBean");
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public static Object findBean(String springBean) {
		Object beanA = null;
		if (applicationContext != null && applicationContext.containsBean(springBean)) {
			beanA = (Object) applicationContext.getBean(springBean);
		}
		return beanA;
	}

	public static Object getBean(String springBean) {
		Object bean = null;
		bean = findBean(springBean);
		return bean;
	}

	/**
	 * Agrega al sessionMap de JSF el objecto enviado como parametro. La llave
	 * sera el texto enviado como primer parametro
	 * 
	 * @param key
	 *            id para identificar el objeto en sesion, tipo String
	 * @param value
	 *            valor que se podra en sesion, tipo Object
	 */
	public static void setSessionValue(String key, Object value) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
	}

	/**
	 * Retorna el objeto (identificado con la llave enviada como parametro) que
	 * se encuentra en el sessionMap de JSF
	 * 
	 * @param key
	 *            id que identifica al objeto en sesion, tipo String
	 * @return objeto en sesion, tipo Object
	 */
	public static Object getSessionValue(String key) {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
	}

	/*
	 * Retorno el listado de todos los parametros de la session
	 * 
	 * @return Map del tipo java.util.map
	 */
	public static Map getSessionMap() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	}

	/**
	 * Retira un objecto del sessionMap de JSF. Sera identificado segun la llave
	 * enviada como parametro
	 * 
	 * @param key
	 *            id del objeto en sesion, tipo String
	 */
	public static void removeSessionValue(String key) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(key);
	}

	public static String getMessageResourceString(String bundleName, String key, Object params[], Locale locale) {
		String text = null;

		try {
			ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale, getCurrentClassLoader(params));
			text = bundle.getString(key);
		} catch (Exception e) {
			e.printStackTrace();
			text = "?? key " + key + " not found ??";
		}
		if (params != null) {
			MessageFormat mf = new MessageFormat(text, locale);
			text = mf.format(params, new StringBuffer(), null).toString();
		}
		return text;
	}

	public static String getGenericPropertiesPath(ServletContextEvent event, String codigoAplicacion) {
		servletContextEvent = event;
		return getGenericPropertiesPath(codigoAplicacion);
	}

	public static String getGenericPropertiesPath() {
		return getGenericPropertiesPath(UConstante.CONSTANTE_TIPOAPLICACION_WEB);
	}

	public static String getGenericPropertiesPath(String tipoAplicacion) {
		String genericPropertiesPath = null;

		// LOGGER.debug(tipoAplicacion);
		if (tipoAplicacion == null)
			tipoAplicacion = UConstante.CONSTANTE_TIPOAPLICACION_WEB;

		// sistema que son del tipo escritorio
		if (tipoAplicacion.equals(UConstante.CONSTANTE_TIPOAPLICACION_WIN))
			genericPropertiesPath = UAplicacion.getRealPath(UFile.getSeparador() + "CONFIG");

		// sistema que son del tipo web
		if (tipoAplicacion.equals(UConstante.CONSTANTE_TIPOAPLICACION_WEB)) {
			genericPropertiesPath = UAplicacion.getRealPath(UFile.getSeparador() + "WEB-INF");
		}

		if (genericPropertiesPath == null)
			genericPropertiesPath = UAplicacion.getRealPath(UFile.getSeparador() + "WEB-INF");

		// LOGGER.debug(genericPropertiesPath);
		return genericPropertiesPath;
	}

	protected static ClassLoader getCurrentClassLoader(Object defaultObject) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if (loader == null) {
			loader = defaultObject.getClass().getClassLoader();
		}
		return loader;
	}

	public static String getRealPath() {
		String path = null;
		path = getServletContext().getRealPath(UFile.getSeparador());
		if (path == null) {
			path = getServletContext().getRealPath("/");
		}
		if (path == null) {
			path = getServletContext().getRealPath("\\");
		}
		return path;
	}

	public String getRealPath2() {
		String path = null;
		path = getServletContext().getRealPath(UFile.getSeparador());
		if (path == null) {
			path = getServletContext().getRealPath("/");
		}
		if (path == null) {
			path = getServletContext().getRealPath("\\");
		}
		return path;
	}

	public static String getRealUrl() {
		HttpServletRequest origRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String path = null;
		path = origRequest.getScheme() + "://" + origRequest.getServerName() + ":" + origRequest.getServerPort()
				+ origRequest.getContextPath();
		return path;
	}

	public static String getRealUrl(String ruta) {
		String path = getRealUrl();
		path = path + ruta;
		return path;
	}

	public static String getRealPath(String ruta) {
		String path = getRealPath();
		path = path + ruta;
		return path;
	}
}
