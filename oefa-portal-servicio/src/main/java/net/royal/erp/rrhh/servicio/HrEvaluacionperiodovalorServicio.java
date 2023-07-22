package net.royal.erp.rrhh.servicio;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrFactorvalorSelCore;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrEvaluacionperiodovalorServicio extends GenericoServicio {

	public List<DtoDwHrFactorvalorSelCore> listarEvaluacionPeriodoEvaluar(
			BigDecimal psecuenciaeval);
}
