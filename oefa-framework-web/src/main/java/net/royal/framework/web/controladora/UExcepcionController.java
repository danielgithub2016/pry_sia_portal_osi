package net.royal.framework.web.controladora;

import javax.annotation.PostConstruct;

import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UArchivoPropiedades;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.dominio.ExceptionGenerico;

public class UExcepcionController {
	private String message;
	private String stackTrace;
	private boolean visibleStackTrace;

	@PostConstruct
	public void postContruct() {
		getMessage();
	}

	public String iniciarControladora() throws Exception {
		ExceptionGenerico excepcion = (ExceptionGenerico) UAplicacion
				.getSessionValue(UConstante.SESION_EXCEPCIONACTUAL);

		try {
			message = null;
			stackTrace = null;
			visibleStackTrace = false;

			message = excepcion.getMessage();
			stackTrace = excepcion.getStackTrace();

			String mostrarMensaje = UArchivoPropiedades
					.getProperty(UConstante.ARCHIVOPROPIEDADES_PANTALLAERROR_MOSTRARMENSAJE);
			String mostrarStackTrace = UArchivoPropiedades
					.getProperty(UConstante.ARCHIVOPROPIEDADES_PANTALLAERROR_MOSTRARSTACKTRACE);

			if (mostrarMensaje == null)
				mostrarMensaje = "N";
			if (mostrarStackTrace == null)
				mostrarStackTrace = "N";

			if (mostrarMensaje.equals("N"))
				message = "A ocurrido un error en el sistema";

			visibleStackTrace = true;
			if (mostrarStackTrace.equals("N")) {
				visibleStackTrace = false;
				stackTrace = "";
			}

		} catch (Exception e) {
			if (message == null) {
				message = e.getMessage();
				stackTrace = e.getStackTrace().toString();
				visibleStackTrace = true;
			} else {
				message = "getMensajeError(Exception):" + message + "|"
						+ e.getMessage();
				stackTrace = "getMensajeError(Exception):" + stackTrace + "|"
						+ e.getStackTrace().toString();
				visibleStackTrace = true;
			}

		}

		return UConstante.NAVIGATIONCASE_ERROR;
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

	public boolean isVisibleStackTrace() {
		return visibleStackTrace;
	}

	public void setVisibleStackTrace(boolean visibleStackTrace) {
		this.visibleStackTrace = visibleStackTrace;
	}
}
