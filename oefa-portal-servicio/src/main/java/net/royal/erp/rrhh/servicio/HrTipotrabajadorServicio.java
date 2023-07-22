package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrTipotrabajador;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrTipotrabajadorServicio extends GenericoServicio {

	public List<HrTipotrabajador> listarTipoTrabajadorActivo();

}
