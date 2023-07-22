package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrEmpleadonecesidadcapacita;
import net.royal.erp.rrhh.dominio.HrEmpleadonecesidadcapacitaPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadonecesidadcapacitaEdit;

import java.util.List;

public interface HrEmpleadonecesidadcapacitaDao extends
		GenericoDao<HrEmpleadonecesidadcapacita, HrEmpleadonecesidadcapacitaPk> {

	/**
	 * @powerbuilder w_hr_evaluacionempleado_edit
	 *               dw_hr_empleadonecesidadcapacita_edit
	 * @param companyowner
	 * @param empleado
	 * @param secuenciaeval
	 * @return
	 */

	public List<HrEmpleadonecesidadcapacita> ListarEmpleadoNecesidadCapacitaxParam(
			String companyowner, Integer empleado, Integer secuenciaeval);

	/**
	 * @powerbuilder w_hr_evaluacionempleado_edit TAB NECESIDADES DE
	 *               CAPACITACION cb_agregacapacita
	 * @param empleado
	 * @param secuenciaeval
	 * @return
	 */

	public Integer ObtenerMaximaSecuencia(Integer empleado,
			Integer secuenciaeval);

	public void grabarEmpleadoNecesidad(
			List<DtoDwHrEmpleadonecesidadcapacitaEdit> dw7);

}
