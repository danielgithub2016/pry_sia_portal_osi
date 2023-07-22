package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrCtrlentregasplantilla;
import net.royal.erp.rrhh.dominio.HrCtrlentregasplantillaPk;

public interface HrCtrlentregasplantillaServicio extends GenericoServicio {

	public HrCtrlentregasplantilla obtenerplantillaparam(String plantilla);
}
