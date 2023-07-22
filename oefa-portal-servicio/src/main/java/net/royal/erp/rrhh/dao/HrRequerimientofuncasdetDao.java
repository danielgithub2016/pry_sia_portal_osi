package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrRequerimientofuncasdet;
import net.royal.erp.rrhh.dominio.HrRequerimientofuncasdetPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrRequerimientofuncasdetDao extends
		GenericoDao<HrRequerimientofuncasdet, HrRequerimientofuncasdetPk> {

	public List<HrRequerimientofuncasdet> listarRequerimientoFuncasDet(
			String compania, String requerimiento);

	public void eliminarporCampos(String companyowner, String requerimiento);

}
