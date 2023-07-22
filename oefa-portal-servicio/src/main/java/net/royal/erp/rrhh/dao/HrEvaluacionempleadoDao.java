package net.royal.erp.rrhh.dao;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.erp.rrhh.dominio.HrEvaluacionempleado;
import net.royal.erp.rrhh.dominio.HrEvaluacionempleadoPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacionEdit;
import net.royal.framework.web.dao.GenericoDao;

public interface HrEvaluacionempleadoDao extends
		GenericoDao<HrEvaluacionempleado, HrEvaluacionempleadoPk> {

	public void actualizaEvaluacionEmpleado(Integer empleado,
			Integer secuenciaeval);

	public HrEvaluacionempleado obtenerPorPkEvaluadorDiferente(
			HrEvaluacionempleadoPk pk);
	
	public void grabarEvaluacionEmpleado(String estado, Date wFecha,
			BigDecimal wPuntaje, Integer ivEmpleado, Integer ivSecuencia,
			String tipoEvaluador, String companyowner, Integer empleadoevaluador);
	
	public void grabarEvaluacionCompleta(
			DtoDwHrEmpleadoevaluacionEdit evaluacion);
}
