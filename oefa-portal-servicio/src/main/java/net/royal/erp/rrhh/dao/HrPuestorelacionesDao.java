package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrMetaspuesto;
import net.royal.erp.rrhh.dominio.HrPuestorelaciones;
import net.royal.erp.rrhh.dominio.HrPuestorelacionesPk;

import java.util.List;

public interface HrPuestorelacionesDao extends GenericoDao<HrPuestorelaciones, HrPuestorelacionesPk> {

	/**
	 * @powerbuilder dw_hr_puestorelacion_edit - TAB RELACION
	 * @param codigopuesto
	 * @return
	 */
	public List<HrPuestorelaciones> listarTabPuestoRelacion(Integer codigopuesto);
}
