package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEvaluacioncandidatohist;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrEvaluacioncandidatohistServicio extends GenericoServicio {

	public List<HrEvaluacioncandidatohist> listarCompetenciasxparam(String str_companyowner, Integer empleado);
	public void eliminarEvaluacionHistoria(String parCompany,
			Integer parSecuenciaEval, Integer parEmpleado,
			Integer parEvaluador, String parTipo);
	
	
	public void grabarHistoriaEvaluacion(String parCompany, Integer parSecuenciaEval,
			Integer parEmpleado, Integer parEvaluador);
	
}
