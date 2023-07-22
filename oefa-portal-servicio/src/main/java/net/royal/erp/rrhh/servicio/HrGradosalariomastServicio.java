package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrGradosalariomast;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrGradosalariomastServicio extends GenericoServicio {

	public List<HrGradosalariomast> listarGradoSalario();

	public HrGradosalariomast obtenerGradoSalarioxParam(String gradosalario);

	public HrGradosalariomast obtenerGradoSalarioxCargo(String cargo);
	
	public List listarGradoSalario(String ls_familia);
}
