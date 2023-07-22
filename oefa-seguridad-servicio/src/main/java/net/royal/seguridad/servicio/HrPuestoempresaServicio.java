package net.royal.seguridad.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.seguridad.dominio.HrPuestoempresa;
import net.royal.seguridad.dominio.HrPuestoempresaPk;

public interface HrPuestoempresaServicio extends GenericoServicio {
	public List<HrPuestoempresa> listarActivos();
	
}
