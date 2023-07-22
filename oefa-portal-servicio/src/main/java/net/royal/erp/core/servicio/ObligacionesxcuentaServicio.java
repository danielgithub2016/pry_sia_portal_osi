package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

public interface ObligacionesxcuentaServicio extends GenericoServicio {
	public List obtenerObligacionxCuenta(Integer Proveedor,
			String TipoDocumento, String NumeroDocumento);

}
