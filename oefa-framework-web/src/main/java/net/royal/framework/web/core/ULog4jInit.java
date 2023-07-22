/*
 *
 */
package net.royal.framework.web.core;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

public class ULog4jInit extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = -7841825116604192766L;

	public void init() {
		String prefix = UAplicacion.getRealPath();		
		String file = getInitParameter("log4j-init-file");
		if (file != null) {
			PropertyConfigurator.configure(prefix + UFile.getSeparador()
					+ "WEB-INF" + UFile.getSeparador() + file);
		}
	}
}
