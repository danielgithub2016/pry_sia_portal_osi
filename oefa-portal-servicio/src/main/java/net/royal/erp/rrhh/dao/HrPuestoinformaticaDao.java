package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrMetaspuesto;
import net.royal.erp.rrhh.dominio.HrPuestoinformatica;
import net.royal.erp.rrhh.dominio.HrPuestoinformaticaPk;

import java.util.List;

public interface HrPuestoinformaticaDao extends GenericoDao<HrPuestoinformatica, HrPuestoinformaticaPk> {
	
	/**
	 * @powerbuilder dw_hr_puestoinformatica_edit - TAB FORMACION
	 * @param codigopuesto
	 * @return
	 */
	public List<HrPuestoinformatica> listarPuestosInformaticas(Integer codigopuesto);
}
