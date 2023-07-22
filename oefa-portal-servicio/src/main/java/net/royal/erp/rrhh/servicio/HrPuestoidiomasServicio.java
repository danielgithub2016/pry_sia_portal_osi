package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrPuestoidiomas;
import net.royal.erp.rrhh.dominio.HrPuestoidiomasPk;

public interface HrPuestoidiomasServicio extends GenericoServicio {

	public List<HrPuestoidiomas> listarPuestoidiomas(Integer codigopuesto);
	
}
