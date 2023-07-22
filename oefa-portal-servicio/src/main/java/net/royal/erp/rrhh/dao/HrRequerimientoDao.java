package net.royal.erp.rrhh.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.royal.erp.rrhh.dominio.HrRequerimiento;
import net.royal.erp.rrhh.dominio.HrRequerimientoPk;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoList;
import net.royal.framework.web.dao.GenericoDao;
import net.royal.framework.web.dominio.UsuarioActual;

public interface HrRequerimientoDao extends
		GenericoDao<HrRequerimiento, HrRequerimientoPk> {

	public Integer obtenerMaximoRequerimiento(String companyowner,
			String unidadreplicacion);
	
	public List<DtoDwHrRequerimientoList> listarRequerimientos(Integer par_codigopuesto, Integer p_codigoPuesto,
			String p_convocatoria, String p_tiporequerimiento, String p_compania, BigDecimal p_concurso,
			String p_tipoplanilla, Integer p_empleadoresponsable,BigDecimal p_codigoPosicionSolicitante,
			String p_fechas,String p_estado,String p_desierto,String p_numero,Date p_fini,Date p_ffin,
			Integer par_empleado,String	par_validacion1,String	par_validacion2);


}
