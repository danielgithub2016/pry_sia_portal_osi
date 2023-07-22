package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrMeritosfaltas;
import net.royal.erp.rrhh.dominio.HrMeritosfaltasPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrIncidentecriticoList;

public interface HrMeritosfaltasServicio extends GenericoServicio {
	public Integer ObtenerMaximaSecuenciaxEmp (Integer empleado);
	public void grabardw3(List<DtoDwHrIncidentecriticoList>dw3 );
	
}
