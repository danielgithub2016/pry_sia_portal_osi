package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEvaluacionRequerimiento;
import net.royal.erp.rrhh.dominio.HrEvaluacionRequerimientoPk;
import net.royal.erp.rrhh.dominio.dto.DtoHrEvaluacionRequirimiento;
import net.royal.framework.web.dao.GenericoDao;

public interface HrEvaluacionRequerimientoDao extends GenericoDao<HrEvaluacionRequerimiento, HrEvaluacionRequerimientoPk> {
	
	public List<DtoHrEvaluacionRequirimiento> listarDescripcion();

}
