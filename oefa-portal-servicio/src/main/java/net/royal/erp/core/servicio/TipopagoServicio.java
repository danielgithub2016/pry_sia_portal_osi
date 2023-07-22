package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

import net.royal.erp.core.dominio.Tipopago;
import net.royal.erp.core.dominio.TipopagoPk;

public interface TipopagoServicio extends GenericoServicio {

	public List listarTipoPago();
}
