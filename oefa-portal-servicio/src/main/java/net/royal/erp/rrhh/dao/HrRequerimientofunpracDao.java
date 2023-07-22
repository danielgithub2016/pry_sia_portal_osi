package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrRequerimientofunprac;
import net.royal.erp.rrhh.dominio.HrRequerimientofunpracPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrRequerimientofunpracDao extends
		GenericoDao<HrRequerimientofunprac, HrRequerimientofunpracPk> {

	public List<HrRequerimientofunprac> listarRequerimientoFunPrac(
			String companyowner, String requerimiento);
}
