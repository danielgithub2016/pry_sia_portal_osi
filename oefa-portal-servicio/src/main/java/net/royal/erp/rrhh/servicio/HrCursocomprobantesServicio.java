package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrCursocomprobantes;
import net.royal.erp.rrhh.dominio.HrCursocomprobantesPk;

public interface HrCursocomprobantesServicio extends GenericoServicio {

	public List<HrCursocomprobantes> ListarCursosComprobantes(String capacitacion);
}
