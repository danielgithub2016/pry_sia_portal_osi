package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrRequerimientofuncas;
import net.royal.erp.rrhh.dominio.HrRequerimientofuncasPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrRequerimientofuncasDao extends
		GenericoDao<HrRequerimientofuncas, HrRequerimientofuncasPk> {

	public List<HrRequerimientofuncas> listarRequerimientoFuncas(
			String companyowner, String requerimiento);

	public void eliminarporCampos(String companyowner, String requerimiento);

}
