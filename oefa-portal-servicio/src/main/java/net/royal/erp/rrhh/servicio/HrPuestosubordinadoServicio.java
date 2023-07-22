package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrPuestosubordinado;
import net.royal.erp.rrhh.dominio.HrPuestosubordinadoPk;

public interface HrPuestosubordinadoServicio extends GenericoServicio {

	public List<HrPuestosubordinado> listarTabPuestosSubordinados(Integer codigopuesto);
}
