package net.royal.comun.vista.controladora;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.seguridad.vista.controladora.UBindingController;

@ManagedBean
@SessionScoped
public class CBindingController extends UBindingController implements Serializable {

	private static Logger LOGGER = Logger.getLogger(CBindingController.class);

	private static final long serialVersionUID = 3026261515666394582L;

	// identificador del tiempo de seccion inactiva en milisegundo;
	private Integer timeout;

	public static CBindingController getInstance() {
		return UFaces.getControladora(Constante.SESION_BEAN_BINDINGCONTROLLER, CBindingController.class);
	}

	public Integer getTimeout() {
		if (UValidador.esNulo(timeout)) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			timeout = facesContext.getExternalContext().getSessionMaxInactiveInterval();
			LOGGER.debug("timeout " + timeout);
			timeout = timeout * 1000; // Convertir de minutos a
											// milisegundos
		}
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

}
