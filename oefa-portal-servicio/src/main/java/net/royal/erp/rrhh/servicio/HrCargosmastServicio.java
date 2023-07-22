package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

import net.royal.erp.rrhh.dominio.HrCargosmast;
import net.royal.erp.rrhh.dominio.HrCargosmastPk;

public interface HrCargosmastServicio extends GenericoServicio {
	
	public List<HrCargosmast> ListarCargosmast();
	
	public HrCargosmast obtenerCargosmastxparam(String cargo);
	
}
