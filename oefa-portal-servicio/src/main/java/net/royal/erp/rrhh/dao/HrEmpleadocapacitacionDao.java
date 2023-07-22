package net.royal.erp.rrhh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import net.royal.erp.rrhh.dominio.HrEmpleadocapacitacion;
import net.royal.erp.rrhh.dominio.HrEmpleadocapacitacionPk;
import net.royal.erp.rrhh.hrrep.dominio.dto.DtoDwHrEvaluacionCapacitacionDetail;
import net.royal.framework.web.dao.GenericoDao;

public interface HrEmpleadocapacitacionDao extends
		GenericoDao<HrEmpleadocapacitacion, HrEmpleadocapacitacionPk> {
	
	public List<DtoDwHrEvaluacionCapacitacionDetail> dwHrEvaluacionCapacitacionDetail(
			Integer par_anioplan);
	
	public List<HrEmpleadocapacitacion> obtenerPorCapacitacion(String capacitacion);
	
}
