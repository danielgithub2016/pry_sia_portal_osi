package net.royal.framework.web.controladora;

import java.util.Map;

public interface UIWebControlContext {
	
	public Map<Object,Object> getAttributes();
	
	/**
	 * 
	 * Execute a javascript after current ajax request is completed.
	 *
	 * @param 
	 * 		script Javascript statement to execute.
	 * 	
	 */
	public void ejecutar(String script);
	
	/**
	 * 
	 * Reset an editableValueHolder.
	 *
	 * @param 
	 * 		expressions A string with one or multiple search expression to resolve the components.
	 * 	
	 */
	public void reinicializar(String expressions);
	
	/**
	 * 
	 * Update a component with ajax.
	 * 
	 * @param 
	 * 		name	Client side identifier of the component.
	 */
	public void actualizar(String name);
	
}
