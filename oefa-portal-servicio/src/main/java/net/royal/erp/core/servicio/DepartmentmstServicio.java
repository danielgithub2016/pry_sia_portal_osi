package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.erp.core.dominio.Departmentmst;
import net.royal.framework.web.servicio.GenericoServicio;

public interface DepartmentmstServicio extends GenericoServicio {

	public List<Departmentmst> listarWarehouseAvailable();
}
