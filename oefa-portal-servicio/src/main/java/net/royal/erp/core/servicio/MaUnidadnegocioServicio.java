package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.erp.core.dominio.MaUnidadnegocio;
import net.royal.framework.web.servicio.GenericoServicio;

public interface MaUnidadnegocioServicio extends GenericoServicio {

	public List<MaUnidadnegocio> obtenerCombo();
	
	public List<MaUnidadnegocio> listarUnidadNegocio(String par_unidad);
	/**
	 * f_sql_read_unidadnegocio_name
	 */
	public String obtenerNombreUnidadNegocio(String par_unidad);
	
	public List DwMaUnidadnegocioSelectSecurity(String par_usuario);
}
