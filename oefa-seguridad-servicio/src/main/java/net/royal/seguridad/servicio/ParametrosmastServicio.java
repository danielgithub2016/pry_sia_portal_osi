package net.royal.seguridad.servicio;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.seguridad.dominio.ParametrosmastPk;

public interface ParametrosmastServicio extends GenericoServicio {

	public String obtenerValorCadena(String companiacodigo,
			String aplicacioncodigo, String parametroclave);

	public String obtenerValorCadena(String parametroclave);
	
	public String obtenerValorExplicacion(ParametrosmastPk pk);
}
