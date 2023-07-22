package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrCentroestudios;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoHrCentroEstudios;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrCentroestudiosServicio extends GenericoServicio {

	public List<DtoHrCentroEstudios> listarCentroEstudios(String s, String criterio);
	public List<HrCentroestudios> listarCentroEstudios();
}
