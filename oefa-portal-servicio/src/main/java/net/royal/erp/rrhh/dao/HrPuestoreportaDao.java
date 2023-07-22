package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrMetaspuesto;
import net.royal.erp.rrhh.dominio.HrPuestoreporta;
import net.royal.erp.rrhh.dominio.HrPuestoreportaPk;

import java.util.List;

public interface HrPuestoreportaDao extends GenericoDao<HrPuestoreporta, HrPuestoreportaPk> {

	/**
	 * @powerbuilder dw_hr_puestoreporta_edit - TAB RELACIONES
	 * @param codigopuesto
	 * @return
	 */
	public List<HrPuestoreporta> listarTabRelaciones(Integer codigopuesto);
}
