package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrPuestocursos;
import net.royal.erp.rrhh.dominio.HrPuestocursosPk;

public interface HrPuestocursosServicio extends GenericoServicio {

	public List<HrPuestocursos> listarTabOtrosEstudios(Integer codigopuesto);
}
