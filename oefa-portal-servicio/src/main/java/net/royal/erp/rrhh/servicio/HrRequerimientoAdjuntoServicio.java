package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrRequerimientoAdjunto;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrRequerimientoAdjuntoServicio extends GenericoServicio {
	
	public List<HrRequerimientoAdjunto>obtenerListadoArchivos(String requerimiento,String compania);
	public void eliminarArchivosAdjuntos(String requerimiento,String compania);

}
