package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrPuestoinformatica;
import net.royal.erp.rrhh.dominio.HrPuestoinformaticaPk;

public interface HrPuestoinformaticaServicio extends GenericoServicio {

	public List<HrPuestoinformatica> listarPuestosInformaticas(Integer codigopuesto);
}
