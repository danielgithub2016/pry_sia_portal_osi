package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrRequerimientofuncas;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrRequerimientofuncasServicio extends GenericoServicio {

	public List<HrRequerimientofuncas> listarRequerimientoFuncas(
			String companyowner, String requerimiento);

	public void eliminarporCampos(String companyowner, String requerimiento);
}
