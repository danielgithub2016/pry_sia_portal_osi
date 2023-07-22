package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrPlantillaevapotencial;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrPlantillaevapotencialServicio extends GenericoServicio {

	public List<HrPlantillaevapotencial> listarPlantillaPotencial(String par_plantilla);
	
}
