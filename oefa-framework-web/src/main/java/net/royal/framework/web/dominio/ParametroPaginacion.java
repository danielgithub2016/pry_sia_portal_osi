package net.royal.framework.web.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.royal.framework.web.dao.impl.GenericoDaoImpl.SORT_ORDER;

public class ParametroPaginacion {
	List<ParametroPersistenciaGenerico> parametros;
	String campoOrden;
	SORT_ORDER direccionOrden;
	Integer registroInicio;
	Integer registrosPorPagina;
	Class clazz;
	Integer registroEncontrados;
	List listaResultado;

	public ParametroPaginacion() {
		parametros = new ArrayList<ParametroPersistenciaGenerico>();
	}

	public ParametroPersistenciaGenerico getParametro(String parametro) {
		ParametroPersistenciaGenerico retorno = null;
		if (parametro==null)
			return null;
		if (parametros==null)
			return null;
		
		for (ParametroPersistenciaGenerico para : parametros) {
			if (para.getField().equals(parametro))
				return para;
		}
		
		return retorno;
	}
	
	public List<ParametroPersistenciaGenerico> getParametros() {
		return parametros;
	}

	public void setParametros(List<ParametroPersistenciaGenerico> parametros) {
		this.parametros = parametros;
	}

	public String getCampoOrden() {
		return campoOrden;
	}

	public void setCampoOrden(String campoOrden) {
		this.campoOrden = campoOrden;
	}

	public SORT_ORDER getDireccionOrden() {
		return direccionOrden;
	}

	public void setDireccionOrden(SORT_ORDER direccionOrden) {
		this.direccionOrden = direccionOrden;
	}

	public Integer getRegistroInicio() {
		return registroInicio;
	}

	public void setRegistroInicio(Integer registroInicio) {
		this.registroInicio = registroInicio;
	}

	public Integer getRegistrosPorPagina() {
		return registrosPorPagina;
	}

	public void setRegistrosPorPagina(Integer registrosPorPagina) {
		this.registrosPorPagina = registrosPorPagina;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public Integer getRegistroEncontrados() {
		return registroEncontrados;
	}

	public void setRegistroEncontrados(Integer registroEncontrados) {
		this.registroEncontrados = registroEncontrados;
	}

	public List getListaResultado() {
		return listaResultado;
	}

	public void setListaResultado(List listaResultado) {
		this.listaResultado = listaResultado;
	}

}
