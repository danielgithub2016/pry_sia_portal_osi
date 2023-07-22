package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.core.dominio.Servicioximpuesto;
import net.royal.erp.core.dominio.ServicioximpuestoPk;

public interface ServicioximpuestoServicio extends GenericoServicio {
	public List DwCpTiposervicioFactor(String tiposervicio);
}
