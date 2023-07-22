package net.royal.framework.web.controladora;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UExceptionHandlerFactory extends ExceptionHandlerFactory{
	
	private static Log LOGGER = LogFactory
			.getLog(UExceptionHandlerFactory.class);
	 private ExceptionHandlerFactory factory;
	 
	 public UExceptionHandlerFactory(ExceptionHandlerFactory factory) {
	        this.factory = factory;
	    }
	 
	@Override
	public ExceptionHandler getExceptionHandler() {
		//LOGGER.debug("UExceptionHandlerFactory.getExceptionHandler");
        ExceptionHandler handler = factory.getExceptionHandler();
        handler = new UExceptionHandlerWrapper(handler);
        return handler;
	}

}
