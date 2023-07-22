package net.royal.erp.asistencia.servicio;

import net.royal.erp.asistencia.dominio.AsEvento;
import net.royal.framework.web.servicio.GenericoServicio;

public interface AsEventoServicio extends GenericoServicio {

	public AsEvento listarPorConceptoAcceso(String conceptoacceso);

}
