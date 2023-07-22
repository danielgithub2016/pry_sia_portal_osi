package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrEmpleadoasistencias;
import net.royal.erp.rrhh.dominio.HrEmpleadoasistenciasPk;

public interface HrEmpleadoasistenciasServicio extends GenericoServicio {

	public List<HrEmpleadoasistencias> ListarEmpleadosAsistencias(String capacitacion);
}
