package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrCargosmast;
import net.royal.erp.rrhh.dominio.HrCargosmastPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrCargosmastDao extends GenericoDao<HrCargosmast, HrCargosmastPk> {

	/**
	 * @powerbuilder  - dddw_categoria_cargo
	 * dddw_ma_hr_cargosmast_select
	 * @return
	 */
	public List<HrCargosmast> ListarCargosmast();
	
	
	public HrCargosmast obtenerCargosmastxparam(String cargo);
}
