package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrRequerimientoreemplazo;
import net.royal.erp.rrhh.dominio.HrRequerimientoreemplazoPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrRequerimientoreemplazoDao extends
		GenericoDao<HrRequerimientoreemplazo, HrRequerimientoreemplazoPk> {

	public List<HrRequerimientoreemplazo> listarReuqerimientoReemplazo(
			String companyOwner, String requerimiento);

	public void eliminarRequerimientoReemplazo(String companyOwner,
			String requerimiento);
}
