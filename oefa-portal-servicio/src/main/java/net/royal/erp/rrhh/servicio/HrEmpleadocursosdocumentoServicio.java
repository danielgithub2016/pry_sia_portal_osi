package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEmpleadocursosdocumento;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrEmpleadocursosdocumentoServicio extends GenericoServicio {
	public List<HrEmpleadocursosdocumento> listarPorEmpleadoSecuencia(
			Integer empleado, String capacitacion,String flgMaterial);

	public Integer incrementarDocumento(Integer empleado, Integer secuencia,String capacitacion);
	public Integer incrementarDocumenoSecuencia(Integer empleado, String capacitacion);
	
	public Integer contarNombreIgual(Integer empleado, String nombre,String capacitacion);
	
	public Integer obtenerCantDocumentos(Integer empleado, String capacitacion,String informeFinal);
}
