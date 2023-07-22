package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrMetaspuesto;
import net.royal.erp.rrhh.dominio.HrPuestoformacion;
import net.royal.erp.rrhh.dominio.HrPuestoformacionPk;

import java.util.List;

public interface HrPuestoformacionDao extends GenericoDao<HrPuestoformacion, HrPuestoformacionPk> {

	/**
	 * @powerbuilder dw_hr_puestoformacion_edit - TAB FORMACION
	 * @param codigopuesto
	 * @return
	 */
	public List<HrPuestoformacion> listarPuestoFormacion(Integer codigopuesto);
	
}
