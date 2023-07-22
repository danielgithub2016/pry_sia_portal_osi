package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

import net.royal.erp.rrhh.dominio.HrFactoresevaluacionplantilla;
import net.royal.erp.rrhh.dominio.HrFactoresevaluacionplantillaPk;

public interface HrFactoresevaluacionplantillaServicio extends GenericoServicio {
	
	public String obtenerPlantillaEmpleado(String as_companyowner,
			Integer al_secuenciaeval, String as_tipoplantilla,
			Integer al_empleado);

}
