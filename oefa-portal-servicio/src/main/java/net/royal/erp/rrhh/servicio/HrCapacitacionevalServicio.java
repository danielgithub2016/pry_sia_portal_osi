package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

public interface HrCapacitacionevalServicio extends GenericoServicio {

	public List listarCapacitacionEval(String par_companyowner,
			String capacitacion);
			
}
