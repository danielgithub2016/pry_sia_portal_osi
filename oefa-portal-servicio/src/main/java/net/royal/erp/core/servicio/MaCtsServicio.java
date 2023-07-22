package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

import net.royal.erp.core.dominio.MaCts;
import net.royal.erp.core.dominio.MaCtsPk;
import net.royal.erp.planilla.dominio.dto.DtoPeriodos;

public interface MaCtsServicio extends GenericoServicio {
	
	public List<MaCts> obtenerCombo();
	
	public List<DtoPeriodos> obtenerPeriodos();

}
