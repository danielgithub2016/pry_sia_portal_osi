package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrPuestofunciones;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrPuestofuncionesServicio extends GenericoServicio {

	public List<HrPuestofunciones> listarFunciones(Integer par_codigopuesto);
	
}
