package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrPuestoformacion;
import net.royal.erp.rrhh.dominio.HrPuestoformacionPk;

public interface HrPuestoformacionServicio extends GenericoServicio {

	public List<HrPuestoformacion> listarPuestoFormacion(Integer codigopuesto);
}
