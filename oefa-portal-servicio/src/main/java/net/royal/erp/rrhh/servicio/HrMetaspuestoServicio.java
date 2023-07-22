package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrMetaspuesto;
import net.royal.erp.rrhh.dominio.HrMetaspuestoPk;

public interface HrMetaspuestoServicio extends GenericoServicio {

	public List<HrMetaspuesto> listarTabObjetivosMetas(Integer codigopuesto);
}
