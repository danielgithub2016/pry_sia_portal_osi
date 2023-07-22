package net.royal.erp.rrhh.dao;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.rrhh.dominio.HrFactorvalor;
import net.royal.erp.rrhh.dominio.HrFactorvalorPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrFactorvalorSelCore;
import net.royal.framework.web.dao.GenericoDao;

public interface HrFactorvalorDao extends GenericoDao<HrFactorvalor, HrFactorvalorPk> {

	/**
	 * @powerbuilder dw_factores_competencia_calificar
	 * @param factor	
	 * @return
	 */
	public List<HrFactorvalor> obtenerLista(Integer factor);
	public Integer obtenerMax(Integer factor);
	public Integer obtenerMim(Integer factor);
	
	/**
	 * @powerbuilder dw_hr_factorvalor_sel_core
	 * @return
	 */
	public List<DtoDwHrFactorvalorSelCore> listarDw1(Integer par_factor);
}
