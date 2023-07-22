package net.royal.framework.web.controladora;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UBasePhaseListener implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7664890112971758054L;
	@SuppressWarnings("unused")
	private static Log LOGGER = LogFactory.getLog(UBasePhaseListener.class);

	@Override
	public void afterPhase(PhaseEvent event) {
		//LOGGER.debug("AfterPhase: " + event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		//LOGGER.debug("beforePhase: " + event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
