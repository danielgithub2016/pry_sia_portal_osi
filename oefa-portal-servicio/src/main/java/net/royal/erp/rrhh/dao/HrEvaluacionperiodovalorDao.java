package net.royal.erp.rrhh.dao;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.rrhh.dominio.HrEvaluacionperiodovalor;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodovalorPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrFactorvalorSelCore;
import net.royal.framework.web.dao.GenericoDao;

public interface HrEvaluacionperiodovalorDao extends GenericoDao<HrEvaluacionperiodovalor, HrEvaluacionperiodovalorPk> {

	public List<DtoDwHrFactorvalorSelCore> listarEvaluacionPeriodoEvaluar(BigDecimal psecuenciaeval);
}
