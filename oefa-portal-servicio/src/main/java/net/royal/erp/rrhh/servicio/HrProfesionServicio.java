package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrProfesion;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrProfesionServicio extends GenericoServicio {

	public HrProfesion obtenerProfesion(String par_profesion);
	public List<HrProfesion> listarProfesion();
}
