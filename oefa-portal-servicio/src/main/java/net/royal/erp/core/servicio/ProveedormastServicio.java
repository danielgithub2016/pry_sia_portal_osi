package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.core.dominio.Proveedormast;
import net.royal.erp.core.dominio.ProveedormastPk;

public interface ProveedormastServicio extends GenericoServicio {
	public Proveedormast obtenerProveedor(Integer proveedor);
}
