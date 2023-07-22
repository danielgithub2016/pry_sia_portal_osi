package net.royal.erp.planilla.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.royal.erp.planilla.dominio.PrVacacionesprogramadas;
import net.royal.erp.planilla.dominio.PrVacacionesprogramadasPk;
import net.royal.framework.web.dao.GenericoDao;

public interface PrVacacionesprogramadasDao extends
		GenericoDao<PrVacacionesprogramadas, PrVacacionesprogramadasPk> {

	public BigDecimal obtenerMaximoVacacionesProgramadas(Integer empleado,
			String periodo);

	public List<PrVacacionesprogramadas> listarVacacionesProgramadas(Integer empleado, String periodoasistencia,
			Date fechainicio, Date fechafin);
	
	public List<PrVacacionesprogramadas> listarVacacionesEjecutadas(
			Integer empleado, String periodoasistencia, Date fechainicio,
			Date fechafin);

}
