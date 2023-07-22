package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrPlantillaevapotencial;
import net.royal.erp.rrhh.dominio.HrPlantillaevapotencialPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrPlantillaevapotencialDao extends GenericoDao<HrPlantillaevapotencial, HrPlantillaevapotencialPk> {

	/**
	 * @powerbuilder dw_hr_plantillaevalua_potencial_edit
	 * @param par_plantilla
	 * @return
	 */
	public List<HrPlantillaevapotencial> listarPlantillaPotencial(String par_plantilla);
	
}
