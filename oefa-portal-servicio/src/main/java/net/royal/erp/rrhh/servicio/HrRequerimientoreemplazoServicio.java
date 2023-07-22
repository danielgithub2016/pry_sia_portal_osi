package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrRequerimientoreemplazo;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrRequerimientoreemplazoServicio extends GenericoServicio {

	public List<HrRequerimientoreemplazo> listarReuqerimientoReemplazo(
			String companyOwner, String requerimiento);
	
	public void eliminarRequerimientoReemplazo(String companyOwner,
			String requerimiento);

}
