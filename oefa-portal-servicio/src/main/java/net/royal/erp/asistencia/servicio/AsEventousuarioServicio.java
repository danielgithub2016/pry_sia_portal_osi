package net.royal.erp.asistencia.servicio;

import net.royal.framework.web.servicio.GenericoServicio;

public interface AsEventousuarioServicio extends GenericoServicio {

	public Integer obtenerMaximoIdEvento(String userid);
}
