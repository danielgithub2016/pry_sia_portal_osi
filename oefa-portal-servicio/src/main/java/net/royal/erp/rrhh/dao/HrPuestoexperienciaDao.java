package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrMetaspuesto;
import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.erp.rrhh.dominio.HrPuestoexperiencia;
import net.royal.erp.rrhh.dominio.HrPuestoexperienciaPk;

import java.util.List;

public interface HrPuestoexperienciaDao extends GenericoDao<HrPuestoexperiencia, HrPuestoexperienciaPk> {

	/**
	 * @powerbuilder dw_experiencia_exterior dw_experiencia_local - TAB PUESTO
	 * @param codigopuesto
	 * @return
	 */
	public List<HrPuestoexperiencia> listarPuestoExperienciaporCodigo(Integer codigopuesto);
}
