package net.royal.erp.rrhh.servicio;

import java.math.BigDecimal;
import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

public interface HrEvaluacioncapacvalorServicio extends GenericoServicio {

	public String f_sql_evaluacioncapacvalor_des(Integer par_evaluacion,
			BigDecimal par_valor);
	
	public List listarEvaluacion(Integer par_evaluacion);
}
