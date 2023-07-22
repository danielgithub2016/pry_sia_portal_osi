package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrEmpleadoconsiderapotencial;
import net.royal.erp.rrhh.dominio.HrEmpleadoconsiderapotencialPk;

public interface HrEmpleadoconsiderapotencialServicio extends GenericoServicio {

	public List<HrEmpleadoconsiderapotencial> obtenerLista(
			String par_companyowner, Integer par_empleado,
			Integer par_secuenciaeval, Integer par_Evaluador);
	
	public void grabarPotencial(List<HrEmpleadoconsiderapotencial>dw10);
}
