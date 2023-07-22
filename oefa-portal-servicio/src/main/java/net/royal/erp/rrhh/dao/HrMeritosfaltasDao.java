package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrMeritosfaltas;
import net.royal.erp.rrhh.dominio.HrMeritosfaltasPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrIncidentecriticoList;
import net.royal.framework.web.dao.GenericoDao;

public interface HrMeritosfaltasDao extends
		GenericoDao<HrMeritosfaltas, HrMeritosfaltasPk> {

	/**
	 * @powerbuilder w_hr_evaluacionempleado_edit TAB INCIDENTES CRITICOS
	 *               cb_agregaincidente
	 * @param empleado
	 * @return
	 */

	public Integer ObtenerMaximaSecuenciaxEmp(Integer empleado);
	public void grabardw3(List<DtoDwHrIncidentecriticoList> dw3);


}
