package net.royal.erp.asistencia.servicio;

import java.util.List;

import net.royal.erp.asistencia.dominio.AsTipohorario;
import net.royal.framework.web.servicio.GenericoServicio;

public interface AsTipohorarioServicio extends GenericoServicio {

	public String obtenerDescripcionLocal(Integer tipohorario);
	
	public List<AsTipohorario> listarTipoHorarioOrden();
}
