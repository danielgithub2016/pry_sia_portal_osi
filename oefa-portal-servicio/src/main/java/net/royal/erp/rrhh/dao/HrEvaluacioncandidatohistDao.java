package net.royal.erp.rrhh.dao;

import java.util.Date;
import java.util.List;

import net.royal.erp.rrhh.dominio.HrEvaluacioncandidatohist;
import net.royal.erp.rrhh.dominio.HrEvaluacioncandidatohistPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrEvaluacioncandidatohistDao extends GenericoDao<HrEvaluacioncandidatohist, HrEvaluacioncandidatohistPk> {

	/**
	 * @powerbuilder dw_hr_competencias_list
	 * @param str_companyowner
	 * @param empleado
	 * @return
	 */
	public List <HrEvaluacioncandidatohist> listarCompetenciasxparam(String str_companyowner, Integer empleado);
	
	public void eliminarEvaluacionHistoria(String parCompany,
			Integer parSecuenciaEval, Integer parEmpleado,
			Integer parEvaluador, String parTipo);
	
	public void insertarCandidatosHistoria(String parCompany,
			Integer parSecuenciaEval, Integer parEmpleado,
			Integer parEvaluador, String parTipo,Date wGetDate);
		
	public void grabarHistoriaEvaluacion(String parCompany,
			Integer parSecuenciaEval, Integer parEmpleado, Integer parEvaluador);
}
