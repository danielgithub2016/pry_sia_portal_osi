package net.royal.framework.web.controladora;

import java.util.Map;

public class UWebControlContextPrimefaces implements UIWebControlContext,
		java.io.Serializable {

	@Override
	public void actualizar(String name) {
		org.primefaces.context.RequestContext.getCurrentInstance().update(name);
	}

	@Override
	public void ejecutar(String script) {
		org.primefaces.context.RequestContext.getCurrentInstance().execute(
				script);
	}

	@Override
	public void reinicializar(String expressions) {
		org.primefaces.context.RequestContext.getCurrentInstance().reset(
				expressions);
	}

	@Override
	public Map<Object, Object> getAttributes() {
		return org.primefaces.context.RequestContext.getCurrentInstance()
				.getAttributes();
	}

}
