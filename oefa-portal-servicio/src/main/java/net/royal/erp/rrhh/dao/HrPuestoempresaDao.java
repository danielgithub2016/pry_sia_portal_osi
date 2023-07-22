package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.erp.rrhh.dominio.HrPuestoempresaPk;
import net.royal.erp.rrhh.dominio.HrPuestoriesgotrabajo;
import net.royal.framework.web.dao.GenericoDao;

public interface HrPuestoempresaDao extends
		GenericoDao<HrPuestoempresa, HrPuestoempresaPk> {

	public List<HrPuestoempresa> listarPuestoEmpresa();

	/**
	 * @powerbuilder w_hr_puestos_select
	 * @param descripcion
	 * @param flagpuestopracticante
	 * @return
	 */
	public List<HrPuestoempresa> listarPuestoEmpresaporFiltros(
			String codigopuesto, String flagpuestopracticante);

	public List<HrPuestoempresa> listarComboPuestos();
	
	/**
	 * @powerbuilder dw_hr_puestos_edit - TAB PUESTO
	 * @param codigopuesto
	 * @return
	 */
	public HrPuestoempresa obtenerPuestoEmpresaporCodigo(Integer codigopuesto);
	
}
