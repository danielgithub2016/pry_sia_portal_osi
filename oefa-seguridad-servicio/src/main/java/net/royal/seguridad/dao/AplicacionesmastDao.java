package net.royal.seguridad.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.seguridad.dominio.Aplicacionesmast;
import net.royal.seguridad.dominio.AplicacionesmastPk;

public interface AplicacionesmastDao extends
		GenericoDao<Aplicacionesmast, AplicacionesmastPk>  {

	public String obtenerPeriodoContable(String aplicacioncodigo);

	/**
	 * se lee de la tabla de parametros "SY","999999","SECURITY"
	 * 
	 * los tipos posibles
	 * 
	 * P:Seguridad Propia W:Seguridad x Ventana M:Seguridad x Menu
	 * 
	 * @return
	 */
	public String obtenerTipoSeguridad();
}
