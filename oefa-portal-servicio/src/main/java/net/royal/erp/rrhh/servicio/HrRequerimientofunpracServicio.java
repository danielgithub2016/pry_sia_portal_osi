package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrRequerimientofunprac;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrRequerimientofunpracServicio extends GenericoServicio {

	public List<HrRequerimientofunprac> listarRequerimientoFunPrac(
			String companyowner, String requerimiento);

}
