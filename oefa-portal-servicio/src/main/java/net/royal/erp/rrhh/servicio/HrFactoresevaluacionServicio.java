package net.royal.erp.rrhh.servicio;

import java.math.BigDecimal;
import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrFactoresevaluacion;
import net.royal.erp.rrhh.dominio.HrFactoresevaluacionPk;

public interface HrFactoresevaluacionServicio extends GenericoServicio {
	public List obtenerFactoresEvaluacion(String par_plantilla);

	public List obtenerValoresEvaluacion(String par_plantilla);

	public BigDecimal obtenerPromedioCategoriaDesempeno(Integer factor,
			Integer empleado, String compania, Integer secuenciaeval);
}
