package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrPuestorelaciones;
import net.royal.erp.rrhh.dominio.HrPuestorelacionesPk;

public interface HrPuestorelacionesServicio extends GenericoServicio {

	public List<HrPuestorelaciones> listarTabPuestoRelacion(Integer codigopuesto);
}
