package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEvaluacionperiodocriterio;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodocriterioPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrEvaluacionperiodocriterioDao extends
		GenericoDao<HrEvaluacionperiodocriterio, HrEvaluacionperiodocriterioPk> {

	public List<HrEvaluacionperiodocriterio> listarPorCompaniaSecuenciaTipoEval(
			String companiaSocio, Integer secuenciaEval, String tipoEval);
}
