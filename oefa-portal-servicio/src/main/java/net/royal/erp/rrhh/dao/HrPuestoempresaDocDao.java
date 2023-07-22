package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrMetaspuesto;
import net.royal.erp.rrhh.dominio.HrPuestoempresaDoc;
import net.royal.erp.rrhh.dominio.HrPuestoempresaDocPk;

import java.util.List;

public interface HrPuestoempresaDocDao extends GenericoDao<HrPuestoempresaDoc, HrPuestoempresaDocPk> {

	/**
	 * @powerbuilder dw_hr_puestodoc_edit - TAB FORMATOS EVALUACION
	 * @param codigopuesto
	 * @return
	 */
	public List<HrPuestoempresaDoc> listarTabFormatosEvaluacion(Integer codigopuesto);
}
