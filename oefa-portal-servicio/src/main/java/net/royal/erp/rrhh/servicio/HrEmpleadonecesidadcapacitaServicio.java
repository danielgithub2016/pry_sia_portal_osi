package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEmpleadonecesidadcapacita;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadonecesidadcapacitaEdit;
import net.royal.framework.web.servicio.GenericoServicio;

import org.springframework.transaction.annotation.Transactional;

public interface HrEmpleadonecesidadcapacitaServicio extends GenericoServicio {

	public List<HrEmpleadonecesidadcapacita> ListarEmpleadoNecesidadCapacitaxParam(
			String companyowner, Integer empleado, Integer secuenciaeval);

	public Integer ObtenerMaximaSecuencia(Integer empleado,
			Integer secuenciaeval);

	@Transactional
	public List<DtoDwHrEmpleadonecesidadcapacitaEdit> eliminarNecesidad(
			List<DtoDwHrEmpleadonecesidadcapacitaEdit> lista,
			DtoDwHrEmpleadonecesidadcapacitaEdit seleccion, Integer empleado);
	
	public void grabarEmpleadoNecesidad(List<DtoDwHrEmpleadonecesidadcapacitaEdit> dw7);
		

}
