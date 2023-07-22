/**
 * Resumen
 * Objeto                  :ErrorHandler.java
 * Descripcion             :Clase utilitaria que obtendra la excepcion 
 * 							generada por cualquier clase del sistema
 * Fecha de Creacion       :14/09/2011
 * PE de Creación 		   :SIGA-WORKFLOW
 * Autor                   :Roger Panayfo
 */
package net.royal.framework.web.dominio;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Clase utilitaria que obtendra la excepcion generada por cualquier clase del
 * sistema
 * 
 * @author Roger Panayfo
 * 
 */
public class ExceptionGenerico {

	/**
	 * Exception generada por el sistema y capturada para en la pantalla de
	 * error
	 */
	private Exception exception;

	/** Mensaje principal de la excepcion */
	private String message;

	/**
	 * StackTrace de la excepcion representada como texto. Cada componente de la
	 * traza esta separada por un salto de linea
	 */
	private String stackTrace;

	/**
	 * Mensaje que se muestra al usuario final debe ser un mensaje natural y que
	 * no tenga ninguna referencia al error generado
	 */
	private String messageUser;

	public ExceptionGenerico() {
	}

	public ExceptionGenerico(Exception exception) {
		this.exception = exception;
		this.message = exception.getMessage();
		this.createStackTrace(exception);
	}

	public String getMessageUser() {
		return messageUser;
	}

	public void setMessageUser(String messageUser) {
		this.messageUser = messageUser;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
		this.message = exception.getMessage();
		createStackTrace(exception);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	/**
	 * Genera el string de la traza de error de la excepcion enviada como
	 * parametro
	 * 
	 * @param exception
	 *            excepcion sobre la cual se generarara la traza de error como
	 *            string, tipo Exception
	 */
	public void createStackTrace(Exception exception) {
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		exception.printStackTrace(printWriter);
		this.stackTrace = result.toString();
	}

	/**
	 * Genera el texto completo de la traza de error; es decir, genera la
	 * siguiente extructura como texto:<br/>
	 * - Message <br/>
	 * - Traza de error separada por saltos de linea <br/>
	 * 
	 * @return traza de error, tipo String
	 */
	public String toString() {
		StringBuffer str = new StringBuffer();
		if (this.exception != null) {
			str.append(this.exception.getMessage());
			for (int i = 0; i < this.exception.getStackTrace().length; i++) {
				str.append(this.exception.getStackTrace()[i]);
			}
			return str.toString();
		}
		return null;
	}

}
