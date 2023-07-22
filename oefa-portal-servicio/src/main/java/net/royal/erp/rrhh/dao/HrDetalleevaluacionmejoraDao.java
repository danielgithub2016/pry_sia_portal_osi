package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacionmejora;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacionmejoraPk;

import java.util.List;

public interface HrDetalleevaluacionmejoraDao extends
		GenericoDao<HrDetalleevaluacionmejora, HrDetalleevaluacionmejoraPk> {

	
	public List<HrDetalleevaluacionmejora> obtenerListaCompromisoMejora(
			String companyowner, Integer empleado, Integer secuenciaeval,
			Integer empleadoevaluador);
	
	public void grabarDetalleMejora(
			List<HrDetalleevaluacionmejora> dwCompromisomejora);
	public void eliminarDetalleEvaluacionMejora(String iv_compania,
			Integer iv_empleado, Integer iv_secuencia,
			Integer iv_empleadoevaluador);
}
