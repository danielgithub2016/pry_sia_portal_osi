package net.royal.erp.sistema.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.sistema.dominio.SySeguridadautorizaciones;
import net.royal.erp.sistema.dominio.SySeguridadautorizacionesPk;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SySeguridadautorizacionesDao.
 */
public interface SySeguridadautorizacionesDao extends
		GenericoDao<SySeguridadautorizaciones, SySeguridadautorizacionesPk> {
	
	/**
	 * f_sql_read_security.
	 *
	 * @param par_grupo the par_grupo
	 * @param par_concepto the par_concepto
	 * @param gvUserid the gv userid
	 * @param gvApplication the gv application
	 * @return the integer
	 */
	public Integer leerSeguridad(String par_grupo, String par_concepto,
			String gvUserid, String gvApplication);
	
	/**
	 * f_security.
	 *
	 * @param par_option the par_option
	 * @param par_grupo the par_grupo
	 * @param par_concepto the par_concepto
	 * @param gvSeguridad the gv seguridad
	 * @param gvEmpresa the gv empresa
	 * @param gvUserid the gv userid
	 * @param gvApplication the gv application
	 * @return the list
	 */
	public List obtenerSeguridad (String par_option, String par_grupo,
			String par_concepto, String gvSeguridad, String gvEmpresa,
			String gvUserid, String gvApplication);
	
	

}
