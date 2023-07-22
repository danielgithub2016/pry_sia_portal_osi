package net.royal.framework.web.dominio;

import java.util.ArrayList;

import net.royal.framework.web.controladora.UIMantenimientoController.accion_solicitada;

public class ParametroPersistenciaLista extends ArrayList {

	private static final long serialVersionUID = -4612932741323122484L;
	
	@SuppressWarnings("unchecked")
	public void parametroAgregar(String pfield, Class pclazz, Object pvalue) {
		this.parametroRemover(pfield);
		ParametroPersistenciaGenerico e = null;
		e = new ParametroPersistenciaGenerico(pfield, pclazz, pvalue);
		this.add(e);
	}
	
	public Object get(String parametro) {
		Object retorno = null;
		
		if (this.size() == 0)
			return null;

		for (int index = 0; index < this.size(); index++) {
			ParametroPersistenciaGenerico bean;
			bean = (ParametroPersistenciaGenerico) this.get(index);
			if (bean != null) {
				if (bean.getField().equals(parametro))
					return bean.getValue();
			}
		}
		return retorno;
	}
	
	public ParametroPersistenciaGenerico parametroObtener(String parametro) {
		ParametroPersistenciaGenerico retorno = null;
		
		if (this.size() == 0)
			return null;

		for (int index = 0; index < this.size(); index++) {
			ParametroPersistenciaGenerico bean;
			bean = (ParametroPersistenciaGenerico) this.get(index);
			if (bean != null) {
				if (bean.getField().equals(parametro))
					return bean;
			}
		}
		return retorno;
	}
	
	public Integer parametroObtenerInteger(String parametro) {
		Integer retorno = null;
		
		if (this.size() == 0)
			return null;

		for (int index = 0; index < this.size(); index++) {
			ParametroPersistenciaGenerico bean;
			bean = (ParametroPersistenciaGenerico) this.get(index);
			if (bean != null) {
				if (bean.getField().equals(parametro))
					return (Integer) bean.getValue();
			}
		}
		return retorno;
	}
	
	public Object parametroObtenerObject(String parametro) {
		Object retorno = null;
		
		if (this.size() == 0)
			return null;

		for (int index = 0; index < this.size(); index++) {
			ParametroPersistenciaGenerico bean;
			bean = (ParametroPersistenciaGenerico) this.get(index);
			if (bean != null) {
				if (bean.getField().equals(parametro))
					return bean.getValue();
			}
		}
		return retorno;
	}
	
	public String parametroObtenerString(String parametro) {
		String retorno = null;
		
		if (this.size() == 0)
			return null;

		for (int index = 0; index < this.size(); index++) {
			ParametroPersistenciaGenerico bean;
			bean = (ParametroPersistenciaGenerico) this.get(index);
			if (bean != null) {
				if (bean.getField().equals(parametro))
					return (String) bean.getValue();
			}
		}
		return retorno;
	}
	
	public accion_solicitada parametroObtenerAccionSolicitada(String parametro) {
		accion_solicitada retorno = null;
		
		if (this.size() == 0)
			return null;

		for (int index = 0; index < this.size(); index++) {
			ParametroPersistenciaGenerico bean;
			bean = (ParametroPersistenciaGenerico) this.get(index);
			if (bean != null) {
				if (bean.getField().equals(parametro))
					return (accion_solicitada) bean.getValue();
			}
		}
		return retorno;
	}
	
	public void parametroRemover(String parametro) {
		
		if (this.size() == 0)
			return;

		for (int index = 0; index < this.size(); index++) {
			ParametroPersistenciaGenerico bean;
			bean = (ParametroPersistenciaGenerico) this.get(index);
			if (bean != null) {
				if (bean.getField().equals(parametro))
					this.remove(index);
			}
		}
	}
	
	public void parametroImprimirValores(){
		if (this.size() == 0)
			return;

		for (int index = 0; index < this.size(); index++) {
			ParametroPersistenciaGenerico bean;
			bean = (ParametroPersistenciaGenerico) this.get(index);
			if (bean != null) {
			}
		}
	}

}