package net.royal.seguridad.vista.controladora;

import java.io.Serializable;

import net.royal.framework.web.controladora.UIMantenimientoController.accion_solicitada;
import net.royal.framework.web.dominio.DominioGenerico;
import net.royal.seguridad.dominio.Seguridadconcepto;

public interface UIBindingController extends Serializable {
	
	public void setAccionPantalla(accion_solicitada accionPantalla);
	
	public void limpiarHerramientasLista();

	public void iniciarHerramientasLista(Seguridadconcepto seguridadConcepto);

	public String getPantallaTituloAccion();

	public void setPantallaTituloAccion(String pantallaTituloAccion);
	
	public void setAuditoriaModificar(DominioGenerico dominio);
	
	public Object getAuditoriaModificar(Object dominio);
	
	public void iniciarHeaderNavegacion();
	
	public void setAuditoriaNuevo();
	
	public Object getAuditoriaNuevo(Object dominio);
	
	public void setAuditoriaNuevoClasico();
	
	public void setAuditoriaModificarClasico(DominioGenerico dominio);
	
	public Object getAuditoriaModificarClasico(Object dominio);
	
	public Object getAuditoriaNuevoClasico(Object dominio);
}
