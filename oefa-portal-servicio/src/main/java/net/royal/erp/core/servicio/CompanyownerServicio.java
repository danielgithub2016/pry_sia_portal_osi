package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.erp.core.dominio.Companyowner;
import net.royal.erp.sistema.dominio.dto.DtoDwMaCompanyownerSelect;
import net.royal.framework.web.servicio.GenericoServicio;

public interface CompanyownerServicio extends GenericoServicio {
	public List DwMaCompanyownerSelect(String par_company);
	public List<DtoDwMaCompanyownerSelect> DwMaCompanyownerSelectSecurity(
			String par_usuario);
	public List<Companyowner> listarEjecutoras();
}
