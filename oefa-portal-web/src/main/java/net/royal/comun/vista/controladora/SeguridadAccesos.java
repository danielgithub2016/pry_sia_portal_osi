package net.royal.comun.vista.controladora;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.UsuarioActual;

public class SeguridadAccesos implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		String pagina = "";

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		String loginURL = request.getRequestURL().toString();
		String loginURI = request.getRequestURI().toString();

		UsuarioActual usuario = null;

		if (!UValidador.esNulo(session)) {
			usuario = (UsuarioActual) session.getAttribute(UConstante.SESION_USUARIOACTUALDOMINIO);
		}

		boolean loginRequest = isRequestpermitido(request, usuario, loginURL);

		if (loginRequest) {
			try {
				chain.doFilter(request, response);
			} catch (Exception e) {
				pagina = "";
				pagina = request.getContextPath() + "/index.jsp";
				response.sendRedirect(pagina);
			}
		} else {
			if (loginURL.contains("bienvenida.jsf")) {
				chain.doFilter(request, response);
			} else {
				pagina = "";
				pagina = request.getContextPath() + "/index.jsp";
				response.sendRedirect(pagina);
			}
		}
	}

	

	private boolean isRequestpermitido(HttpServletRequest request, UsuarioActual usuario, String loginURL)
			throws IOException {
		boolean resultado = false;
		if (loginURL.contains("index.jsp")) {
			resultado = true;
		}

		if (loginURL.contains("login.jsf")) {
			resultado = true;
		}

		if (loginURL.contains("alfresco")) {
			resultado = true;
		}

		if (loginURL.contains("firmadigital")) {
			resultado = true;
		}

		if (loginURL.contains("javax.faces.resource")) {
			resultado = true;
		}

		if (loginURL.contains("reporte")) {
			resultado = true;
		}

		if (!UValidador.esNulo(usuario)) {
			resultado = true;
		}

		return resultado;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
