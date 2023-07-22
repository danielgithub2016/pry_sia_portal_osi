package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrRequerimientofuncasdet;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrRequerimientofuncasdetServicio extends GenericoServicio {

	public List<HrRequerimientofuncasdet> listarRequerimientoFuncasDet(
			String compania, String requerimiento);

	public void eliminarporCampos(String companyowner, String requerimiento);
}
