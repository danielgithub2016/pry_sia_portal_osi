package net.royal.erp.sistema.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

import net.royal.erp.sistema.dominio.SyUnidadreplicacion;
import net.royal.erp.sistema.dominio.SyUnidadreplicacionPk;

public interface SyUnidadreplicacionServicio extends GenericoServicio {

	public List listaUnidadReplicacion();
}
