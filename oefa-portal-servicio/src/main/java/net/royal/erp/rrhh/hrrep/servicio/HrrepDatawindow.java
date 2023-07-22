package net.royal.erp.rrhh.hrrep.servicio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.royal.erp.rrhh.dao.HrEmpleadocapacitacionDao;
import net.royal.erp.rrhh.hrrep.dominio.dto.DtoDWHrPosicionesHijosAllSelect;
import net.royal.erp.rrhh.hrrep.dominio.dto.DtoDwHrEvaluacionCapacitacionDetail;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrrepDatawindow")
public class HrrepDatawindow {

	private ComunDao dao;
	private HrEmpleadocapacitacionDao daoRmpleadocapacitacion;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	public List<DtoDWHrPosicionesHijosAllSelect> DWHrPosicionesHijosAllSelect(
			BigDecimal codigounidad) {
		return null;
	}

	/**
	 * Dw hr evaluacion capacitacion detail.
	 *
	 * @powerbuilder <strong>hrrep.dw_hr_evaluacion_capacitacion_detail</strong>
	 * @author nunezh
	 * @param par_anioplan
	 *            the par_anioplan
	 * @return the list
	 */
	public List<DtoDwHrEvaluacionCapacitacionDetail> dwHrEvaluacionCapacitacionDetail(
			Integer par_anioplan) {
		return daoRmpleadocapacitacion
				.dwHrEvaluacionCapacitacionDetail(par_anioplan);
	}

	@Autowired
	public void setDaoRmpleadocapacitacion(
			HrEmpleadocapacitacionDao daoRmpleadocapacitacion) {
		this.daoRmpleadocapacitacion = daoRmpleadocapacitacion;
	}
}
