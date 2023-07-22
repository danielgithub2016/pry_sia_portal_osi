package net.royal.seguridad.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.seguridad.dominio.Parametrosmast;
import net.royal.seguridad.dominio.ParametrosmastPk;

public interface ParametrosmastDao extends
		GenericoDao<Parametrosmast, ParametrosmastPk> {

	public String obtenerValorCadena(String companiacodigo,
			String aplicacioncodigo, String parametroclave);
	
	public String obtenerValorCadena(String parametroclave);
	
	public String obtenerValorExplicacion(ParametrosmastPk pk);
	
}
