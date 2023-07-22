package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrPuestoriesgotrabajo;
import net.royal.erp.rrhh.dominio.HrPuestoriesgotrabajoPk;

public interface HrPuestoriesgotrabajoServicio extends GenericoServicio {

	public List<HrPuestoriesgotrabajo> listarRiesgosTrabajo(Integer codigopuesto);
}
