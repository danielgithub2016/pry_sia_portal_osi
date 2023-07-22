package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.core.dominio.Tiposervicio;
import net.royal.erp.core.dominio.TiposervicioPk;

public interface TiposervicioServicio extends GenericoServicio {
	public List<Tiposervicio>listarTipoServicio(String par_tipo);

}
