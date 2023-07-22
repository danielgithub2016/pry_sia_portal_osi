package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEvaluacion;
import net.royal.erp.rrhh.dominio.HrEvaluacionPk;
import net.royal.erp.rrhh.dominio.dto.DtoHrEvaluacion;
import net.royal.framework.web.dao.GenericoDao;

public interface HrEvaluacionDao extends GenericoDao<HrEvaluacion, HrEvaluacionPk> {
	
	public List<DtoHrEvaluacion> listarDescripcion();

}
