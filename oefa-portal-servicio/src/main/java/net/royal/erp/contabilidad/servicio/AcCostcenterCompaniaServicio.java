package net.royal.erp.contabilidad.servicio;

import java.util.List;

import net.royal.erp.contabilidad.dominio.AcCostcenterCompania;
import net.royal.framework.web.servicio.GenericoServicio;

public interface AcCostcenterCompaniaServicio extends GenericoServicio {
	public List<AcCostcenterCompania> listarAreaCreaDemanda(String compania,
			String ano, Integer version,Integer tipo,String usuario);
}
