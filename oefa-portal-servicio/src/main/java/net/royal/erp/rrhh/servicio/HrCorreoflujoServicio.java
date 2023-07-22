package net.royal.erp.rrhh.servicio;

import java.util.HashMap;

import net.royal.framework.web.servicio.GenericoServicio;

public interface HrCorreoflujoServicio extends GenericoServicio {

	public HashMap<String, Object> flujoProcesoCorreoNuevo(Integer proceso,
			Integer accion, Integer usuario, String flagmotivo, String motivo,
			Integer solicitante, String compania);
}
