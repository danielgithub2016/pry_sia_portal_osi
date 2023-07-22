package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrCursocomprobantes;
import net.royal.erp.rrhh.dominio.HrCursocomprobantesPk;

import java.util.List;

public interface HrCursocomprobantesDao extends GenericoDao<HrCursocomprobantes, HrCursocomprobantesPk> {

	/**
	 * @powerbuilder  - dw_hr_capacitaciongastos_edit
	 * @param capacitacion
	 * @return
	 */
	public List<HrCursocomprobantes> ListarCursosComprobantes(String capacitacion);
}
