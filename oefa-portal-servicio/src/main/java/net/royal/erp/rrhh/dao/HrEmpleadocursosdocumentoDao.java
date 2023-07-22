package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEmpleadocursosdocumento;
import net.royal.erp.rrhh.dominio.HrEmpleadocursosdocumentoPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrEmpleadocursosdocumentoDao extends
		GenericoDao<HrEmpleadocursosdocumento, HrEmpleadocursosdocumentoPk> {
	public List<HrEmpleadocursosdocumento> listarPorEmpleadoSecuencia(
			Integer empleado, String capacitacion,String flgMaterial);
	
	public Integer incrementarDocumenoSecuencia(Integer empleado, String capacitacion);

	public Integer incrementarDocumento(Integer empleado, Integer secuencia,String capacitacion);

	public Integer contarNombreIgual(Integer empleado, String nombre,String capacitacion);
}
