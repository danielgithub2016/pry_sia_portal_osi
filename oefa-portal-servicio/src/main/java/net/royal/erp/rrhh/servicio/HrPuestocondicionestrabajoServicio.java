package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrPuestocondicionestrabajo;
import net.royal.erp.rrhh.dominio.HrPuestocondicionestrabajoPk;

public interface HrPuestocondicionestrabajoServicio extends GenericoServicio {

	public List<HrPuestocondicionestrabajo> listarCondicionesTrabajo(Integer codigopuesto);
}
