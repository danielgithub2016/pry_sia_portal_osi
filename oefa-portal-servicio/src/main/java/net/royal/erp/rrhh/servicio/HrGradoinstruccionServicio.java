package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrGradoinstruccion;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrGradoinstruccionServicio extends GenericoServicio {
	public List<HrGradoinstruccion> listarGradoInstruccion();
}
