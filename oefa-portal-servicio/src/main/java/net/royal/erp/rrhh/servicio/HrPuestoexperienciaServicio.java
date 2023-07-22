package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrPuestoexperiencia;
import net.royal.erp.rrhh.dominio.HrPuestoexperienciaPk;

public interface HrPuestoexperienciaServicio extends GenericoServicio {

	public List<HrPuestoexperiencia> listarPuestoExperienciaporCodigo(Integer codigopuesto);
}
