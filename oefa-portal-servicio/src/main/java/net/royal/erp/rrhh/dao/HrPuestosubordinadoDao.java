package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.presupuesto.dominio.BuCertificacion;
import net.royal.erp.rrhh.dominio.HrPuestosubordinado;
import net.royal.erp.rrhh.dominio.HrPuestosubordinadoPk;

import java.util.List;

public interface HrPuestosubordinadoDao extends GenericoDao<HrPuestosubordinado, HrPuestosubordinadoPk> {

	/**
	 * @powerbuilder dw_hr_puestosubordinado_edit - TAB PUESTOS SUBORDINADOS
	 * @param codigopuesto
	 * @return
	 */
	public List<HrPuestosubordinado> listarTabPuestosSubordinados(Integer codigopuesto);
}
