package net.royal.comun.vista.controladora;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.seguridad.vista.controladora.UComunSession;
import net.royal.erp.sistema.syroyal.estructura.Syroyal;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;

import org.apache.log4j.Logger;

@SessionScoped
@ManagedBean
public class CComunSession extends UComunSession {

	private static final long serialVersionUID = -9004843125421777945L;
	protected static Logger LOGGER = Logger.getLogger(CComunSession.class);
	private Syroyal syroyal;

	public CComunSession() {
		syroyal = new Syroyal();
	}

	public static CComunSession getInstance() {
		return UFaces.getControladora(
				UConstante.SESION_BEAN_COMUNSESSIONCONTROLLER,
				CComunSession.class);
	}

	public static Syroyal syroyal() {
		return CComunSession.getInstance().getSyroyal();
	}

	public Syroyal getSyroyal() {
		return syroyal;
	}

}
