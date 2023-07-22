package net.royal.erp.rrhh.servicio;

import java.math.BigDecimal;
import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrEvaluacionesrango;
import net.royal.erp.rrhh.dominio.HrEvaluacionesrangoPk;

public interface HrEvaluacionesrangoServicio extends GenericoServicio {

	public String ObtenerEvaluacionesRango(BigDecimal desde, BigDecimal hasta);
}
