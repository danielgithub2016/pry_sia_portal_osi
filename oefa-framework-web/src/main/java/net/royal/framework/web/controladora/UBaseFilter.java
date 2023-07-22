package net.royal.framework.web.controladora;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.dominio.ExceptionGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UBaseFilter implements Filter {

	private static Log LOGGER = LogFactory.getLog(UBaseFilter.class);

	private ServletContext servletContext;
	/**
	 * Valor Inicio
	 */
	private boolean no_init;
	/**
	 * Objetos a excluir
	 */
	private String excluded;
	/**
	 * Valor a incluir
	 */
	private static final String EXCLUDE = "exclude";
	/**
	 * Valor de Error
	 */
	private boolean isError;
	/**
	 * Lista de Errores
	 */
	private List listaErrores;
	/**
	 * Lista de palabras reservadas
	 */
	private List listaPalabrasReservadas;
	/**
	 * Lista de expresiones regulares a filtrar
	 */
	private Set regExps = null;
	/**
	 * Metodo genérico que se ejecuta
	 */

	/**
	 * verifica si es palabra reservada
	 */
	private boolean isPalabraReservada;

	/**
	 * espresion regular
	 */
	private String palabraReservadaExpReg;

	public UBaseFilter() {
		LOGGER.debug("constructor");
		no_init = true;

		listaPalabrasReservadas = new ArrayList();

		listaPalabrasReservadas.add("insert");
		listaPalabrasReservadas.add("select");
		listaPalabrasReservadas.add("drop");
		listaPalabrasReservadas.add("update");
		listaPalabrasReservadas.add("alter");
		listaPalabrasReservadas.add("delete");
		listaPalabrasReservadas.add("commit");
		listaPalabrasReservadas.add("rollback");
		listaPalabrasReservadas.add("grant");
		listaPalabrasReservadas.add("revoke");
		listaPalabrasReservadas.add("--");

		listaPalabrasReservadas.add("alert(");
		listaPalabrasReservadas.add("onkeyup");
		listaPalabrasReservadas.add("fromCharCode");
		listaPalabrasReservadas.add("script");
		listaPalabrasReservadas.add("javascript");
		listaPalabrasReservadas.add("vbscript");
		listaPalabrasReservadas.add("http-equiv");
		listaPalabrasReservadas.add(">");
		listaPalabrasReservadas.add("expression");
		listaPalabrasReservadas.add("innerHTML");
		listaPalabrasReservadas.add("document.body");
		listaPalabrasReservadas.add("document.cookie");
		listaPalabrasReservadas.add("document.location");
		listaPalabrasReservadas.add("document.write");
		listaPalabrasReservadas.add("style");
		listaPalabrasReservadas.add("dynsrc");
		listaPalabrasReservadas.add("jsessionid");
		listaPalabrasReservadas.add("phpsessid");
		listaPalabrasReservadas.add("<");
	}

	/**
	 * Metodo que se ejecuta al inicio del Servlet
	 * 
	 * @param paramFilterConfig
	 *            , tipo FilterConfig
	 * @throws javax.servlet.ServletException
	 */
	public void init(FilterConfig paramFilterConfig) throws ServletException {
		LOGGER.debug("init");
		servletContext = paramFilterConfig.getServletContext();
		no_init = false;
		if ((excluded = paramFilterConfig.getInitParameter(EXCLUDE)) != null) {
			excluded += ",";
		}

		regExps = new HashSet();

		BufferedReader lector = null;

		try {
			String path = paramFilterConfig.getServletContext().getRealPath(
					File.separator + "recursos" + File.separator + "filtros"
							+ File.separator + "re_Filtro.txt");// BUSCAR
																// ARCHIVO

			lector = new BufferedReader(new FileReader(path));
			while (lector.ready()) {
				String regExp = lector.readLine().trim();
				if (regExp.length() > 0 && regExp.indexOf("#") != 0) {
					regExps.add(regExp);
					if (this.excluded == null)
						this.excluded = regExp + ",";
					else
						this.excluded = this.excluded + regExp + ",";
				}
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			LOGGER.debug(e.getStackTrace().toString());
		} finally {
			if (lector != null) {
				try {
					lector.close();
				} catch (Exception ex) {
					LOGGER.error(ex.getMessage());
					LOGGER.error(ex.getStackTrace().toString());
				}
			}
		}

	}

	/**
	 * Método que guarda las configuraciones del filtro
	 * 
	 * @param filterConfig
	 *            , tipo FilterConfig
	 */
	public void setFilterConfig(FilterConfig filterConfig) {
		if (no_init) {
			no_init = false;
			if ((excluded = filterConfig.getInitParameter(EXCLUDE)) != null)
				excluded += ",";
		}
	}

	private boolean excluded(String s) {
		if (s == null || excluded == null) {
			return false;
		} else {
			return excluded.indexOf(s + ",") >= 0;
		}
	}

	public static String getStackTraceStr(Throwable aThrowable) {
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		aThrowable.printStackTrace(printWriter);
		return result.toString();
	}

	public void destroy() {
	}

	private String getNameForm(ServletRequest request) {
		String nameForm = null;

		Enumeration enNombreParametros = request.getParameterNames();

		while (enNombreParametros.hasMoreElements()) {
			String strNombreParametro = (String) enNombreParametros
					.nextElement();

			String[] strValoresParametro = request
					.getParameterValues(strNombreParametro);

			if (strValoresParametro.length == 1) {
				String strValor = strValoresParametro[0];
				strValor = strValor + "   ";
				if (strValor.substring(0, 3).equals("frm")
						&& strValor.indexOf(":") > -1) {
					int pos = 0;
					pos = strValor.indexOf(":");
					strValor = strValor.substring(0, pos).trim();
					return strValor;
				}
			}

		}

		return null;
	}

	public boolean validacionParametros(ServletRequest request) {
		boolean isFlag = false;

		if (this.listaErrores == null)
			this.listaErrores = new ArrayList();
		this.listaErrores.clear();

		Enumeration enNombreParametros = request.getParameterNames();

		while (enNombreParametros.hasMoreElements()) {
			String strNombreParametro = (String) enNombreParametros
					.nextElement();
			String[] strValoresParametro = request
					.getParameterValues(strNombreParametro);

			if (strValoresParametro.length == 1) {
				String strValor = strValoresParametro[0];
				if (strValor.length() != 0) {
					if (isValidoCampo(strValor)) {
						request.setAttribute(strNombreParametro,
								strValoresParametro);
					} else {
						isFlag = true;
					}
				}
			} else {
				request.setAttribute(strNombreParametro, strValoresParametro);
			}
		}
		return isFlag;
	}

	/**
	 * Método de validación de los campos enviados, Modificado por wcarrasco
	 * 06-09-2012 de acuerdo a la reunion 03-03-2012 con Oficial Seguridad ONP,
	 * recomienda usar Expresiones regulares.
	 * 
	 * @param strValor
	 *            , tipo String
	 * @return isFlag, tipo boolean
	 */
	private boolean isValidoCampo(String strValor) {
		boolean isFlag = true;

		validarExpresionRegular(strValor);

		if (isPalabraReservada) {
			mensajeExcepcion(palabraReservadaExpReg);
			palabraReservadaExpReg = "";
			isPalabraReservada = false;
			return false;
		}
		return isFlag;
	}

	private void mensajeExcepcion(String palabraReservada) {
		String str_Palabra = "La palabra " + palabraReservada.toUpperCase()
				+ " es reservada y no se permite su ingreso";
		ExceptionGenerico excepcion = new ExceptionGenerico();
		excepcion.setMessageUser(str_Palabra);
		this.listaErrores.add(excepcion);
	}

	/**
	 * Método de exclusion
	 */

	private void validarExpresionRegular(String valor) {
		UBaseFilterValidador validador = new UBaseFilterValidador();
		valor = valor.toLowerCase();
		isPalabraReservada = false;

		if (validador.isAlert(valor)) {
			palabraReservadaExpReg = "alert";
			isPalabraReservada = true;
		} else if (validador.isAlter(valor)) {
			palabraReservadaExpReg = "alter";
			isPalabraReservada = true;
		} else if (validador.isApostrofe(valor)) {
			palabraReservadaExpReg = "'";
			isPalabraReservada = true;
		} else if (validador.isCaracteres(valor)) {
			palabraReservadaExpReg = "caracter";
			isPalabraReservada = true;
		} else if (validador.isCaracterMayor(valor)) {
			palabraReservadaExpReg = ">";
			isPalabraReservada = true;
		} else if (validador.isCommit(valor)) {
			palabraReservadaExpReg = "commit";
			isPalabraReservada = true;
		} else if (validador.isDelete(valor)) {
			palabraReservadaExpReg = "delete";
			isPalabraReservada = true;
		} else if (validador.isDocumentBody(valor)) {
			palabraReservadaExpReg = "document.boby";
			isPalabraReservada = true;
		} else if (validador.isDocumentCookie(valor)) {
			palabraReservadaExpReg = "document.cookie";
			isPalabraReservada = true;
		} else if (validador.isDocumentLocation(valor)) {
			palabraReservadaExpReg = "document.location";
			isPalabraReservada = true;
		} else if (validador.isDocumentWrite(valor)) {
			palabraReservadaExpReg = "document.write";
			isPalabraReservada = true;
		} else if (validador.isDrop(valor)) {
			palabraReservadaExpReg = "drop";
			isPalabraReservada = true;
		} else if (validador.isDynsrc(valor)) {
			palabraReservadaExpReg = "dynsrc";
			isPalabraReservada = true;
		} else if (validador.isEval(valor)) {
			palabraReservadaExpReg = "eval (";
			isPalabraReservada = true;
		} else if (validador.isExpression(valor)) {
			palabraReservadaExpReg = "expression";
			isPalabraReservada = true;
		} else if (validador.isFromCharCode(valor)) {
			palabraReservadaExpReg = "fromcharcode";
			isPalabraReservada = true;
		} else if (validador.isGrant(valor)) {
			palabraReservadaExpReg = "grant";
			isPalabraReservada = true;
		} else if (validador.isGroupBy(valor)) {
			palabraReservadaExpReg = "group by";
			isPalabraReservada = true;
		} else if (validador.isHttpEquiv(valor)) {
			palabraReservadaExpReg = "http-equiv";
			isPalabraReservada = true;
		} else if (validador.isIgual(valor)) {
			palabraReservadaExpReg = "=";
			isPalabraReservada = true;
		} else if (validador.isInnerHTML(valor)) {
			palabraReservadaExpReg = "innerHTML";
			isPalabraReservada = true;
		} else if (validador.isInsert(valor)) {
			palabraReservadaExpReg = "insert";
			isPalabraReservada = true;
		} else if (validador.isJavaScript(valor)) {
			palabraReservadaExpReg = "javascript";
			isPalabraReservada = true;
		} else if (validador.isJsessionid(valor)) {
			palabraReservadaExpReg = "jsessionid";
			isPalabraReservada = true;
		} else if (validador.isMenorMayor(valor)) {
			palabraReservadaExpReg = "<>";
			isPalabraReservada = true;
		} else if (validador.isMenorMayorMedio(valor)) {
			palabraReservadaExpReg = "<palabra>";
			isPalabraReservada = true;
		} else if (validador.isMenorMayorMedioSlash(valor)) {
			palabraReservadaExpReg = "</>";
			isPalabraReservada = true;
		} else if (validador.isOnKeyUp(valor)) {
			palabraReservadaExpReg = "onkeyup";
			isPalabraReservada = true;
		} else if (validador.isPhpsessid(valor)) {
			palabraReservadaExpReg = "phpsessid";
			isPalabraReservada = true;
		} else if (validador.isPuntoComa(valor)) {
			palabraReservadaExpReg = ";";
			isPalabraReservada = true;
		} else if (validador.isRayaRaya(valor)) {
			palabraReservadaExpReg = "--";
			isPalabraReservada = true;
		} else if (validador.isRevoke(valor)) {
			palabraReservadaExpReg = "revoke";
			isPalabraReservada = true;
		} else if (validador.isRoollback(valor)) {
			palabraReservadaExpReg = "roollback";
			isPalabraReservada = true;
		} else if (validador.isSelect(valor)) {
			palabraReservadaExpReg = "select";
			isPalabraReservada = true;
		} else if (validador.isStyle(valor)) {
			palabraReservadaExpReg = "style";
			isPalabraReservada = true;
		} else if (validador.isUpdate(valor)) {
			palabraReservadaExpReg = "update";
			isPalabraReservada = true;
		} else if (validador.isVbScript(valor)) {
			palabraReservadaExpReg = "vbscript";
			isPalabraReservada = true;
		}
	}

	/**
	 * Método que hace filtro
	 * 
	 * @param paramServletRequest
	 *            , tipo ServletRequest
	 * @param paramServletResponse
	 *            , tipo ServletResponse
	 * @param paramFilterChain
	 *            , tipo FilterChain
	 * @throws javax.io.IOException
	 * @throws javax.servletx.ServletException
	 */
	public void doFilter(ServletRequest paramServletRequest,
			ServletResponse paramServletResponse, FilterChain paramFilterChain)
			throws IOException, ServletException {
		
		LOGGER.debug("METODO doFilter");
		
		HttpServletRequest req = (HttpServletRequest) paramServletRequest;
		String pageRequested = req.getRequestURL().toString();
		String[] cadenaSeparada = pageRequested.split("/");
		LOGGER.debug(cadenaSeparada.length);
		if (cadenaSeparada.length != 0) {
			String extension = cadenaSeparada[cadenaSeparada.length - 1];
			String extension1 = null;
			try {
				Integer encontrado = extension.indexOf(".");
								
				extension1 = extension.substring(encontrado+1);
				LOGGER.debug(extension1);
			} catch (Exception e) {
				LOGGER.debug(e.getMessage());
				extension1 = "";
			}
			LOGGER.debug(extension);
			LOGGER.debug(extension1);
			if (extension.equals("receive-updates")) {
				LOGGER.debug("receive-updates : ");
			} else if (extension.equals("send-updates") || extension1.equals("xhtml")) {
				LOGGER.debug("send-updates OR xhtml");
				HttpServletRequest httpreq = (HttpServletRequest) paramServletRequest;
				HttpSession session = httpreq.getSession();
				Object _valSession = null;

				boolean formExcluido = false;

				String src = httpreq.getHeader("Referer");
				String s = ((HttpServletRequest) paramServletRequest)
						.getServletPath();

				String nameForm = getNameForm(paramServletRequest);
				if (nameForm==null)
					nameForm="";
				
				// verificar si el formulario esta excludio
				formExcluido = excluded(nameForm);

				// Si el formulario esta excludido
				if (formExcluido == true) {
					paramFilterChain.doFilter(paramServletRequest,
							paramServletResponse);
					return;
				}

				// si es la pantalla login cuntinuar con la ejecucion
				// de los contrario validar que exista la variable de session
				_valSession = session.getAttribute("usuario");
				if ((!nameForm.equals("frmLogin")) && (_valSession == null)) {
					LOGGER.debug("SESSION INAACTIVA");
					if (!nameForm.equals("frmError")) {
						LOGGER.debug("PERDIDA DE SESSION 1");
						UILoginController login;
						login = (UILoginController) session
								.getAttribute(UConstante.SESION_BEAN_LOGINCONTROLLER);
						if (login!=null)
							login.salir();

						/*session.setAttribute(UConstante.keyControlError, "3");
						UNavigationHandlerBean navigationHandlerBean = (UNavigationHandlerBean) session
								.getAttribute(UConstante.KeyNavigationHandlerBean);
						if (navigationHandlerBean == null)
							navigationHandlerBean = new UNavigationHandlerBean();
						navigationHandlerBean
								.addSingleError(new UExceptionBean(
										new Exception(
												"Se perdio la sessión del sistema")));
						session.setAttribute(
								UConstante.KeyNavigationHandlerBean,
								navigationHandlerBean);*/
						
						paramFilterChain.doFilter(paramServletRequest,
								paramServletResponse);
						return;
					}
				} else {
					LOGGER.debug("CONTINUA CON LA SESSION ACTIVA 1");
				}

				if (validacionParametros(paramServletRequest)) {
					LOGGER.debug("validacionParametros = con errorres ");
					// asignando control de errores nivel 2 para que se pare la
					// ejecución
					
					/*session.setAttribute(UConstante.keyControlError, "2");
					UNavigationHandlerBean navigationHandlerBean = (UNavigationHandlerBean) session
							.getAttribute(UConstante.KeyNavigationHandlerBean);
					if (navigationHandlerBean == null)
						navigationHandlerBean = new UNavigationHandlerBean();
					navigationHandlerBean.addNewlistErrors(listaErrores);
					session.setAttribute(UConstante.KeyNavigationHandlerBean,
							navigationHandlerBean);*/
					
					paramFilterChain.doFilter(paramServletRequest,
							paramServletResponse);
					return;
				} else {
					LOGGER.debug("validacionParametros = sin errorres ");
					// si la pantalla no tiene ningun error continuar con el
					// requuest
					paramFilterChain.doFilter(paramServletRequest,
							paramServletResponse);
					return;
				}
			}
		}

		try {

			paramFilterChain
					.doFilter(paramServletRequest, paramServletResponse);

		} catch (Exception ex) {

			LOGGER.debug("Exception - paramFilterChain.doFilter(,)");
			String error = getStackTraceStr(ex);

			int nErrorCode = 0;
			nErrorCode = error.indexOf("_index._jspService");
			LOGGER.debug("nErrorCode::" + nErrorCode);
			try {
				if (nErrorCode < 0) {
					LOGGER.debug("UBaseFilter - Deja pasar error ");
					throw ex;
				} else {
					LOGGER.debug("ERROR renderResponse - Acceso Externo:_index._jspService");
				}
			} catch (Exception e) {
				// e.printStackTrace();
			}

		}
	}

}
