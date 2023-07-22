package net.royal.seguridad.servicio;

import net.royal.framework.web.dominio.SeguridadOperaciones;
import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.seguridad.dominio.Seguridadautorizaciones;

public interface SeguridadautorizacionesServicio extends GenericoServicio {

	/**
	 * hrcommon.f_sql_get_seguridad_usuario_x_concepto
	 * 
	 * @param codigoUsuario
	 * @return
	 **/

	public Seguridadautorizaciones obtenerSeguridadUsuarioporConcepto(
			String usuario, String grupo, String concepto,
			String aplicacioncodigo);

	/**
	 * valida primero SYSADM, si es admin devuelve TRUE, si es falso pasa a la
	 * siguiente evaluacion en segundo lugar SECADM, si es TRUE sale, si es
	 * falso pasa a el siguiente evaluacion valida por el componente
	 * 
	 * @powerbuilder f_sql_get_seguridad_usuario_x_concepto
	 * @param aplicacioncodigo
	 * @param grupo
	 * @param concepto
	 * @param usuario
	 * @return
	 */
	public Boolean tieneAcceso(String aplicacioncodigo, String grupo,
			String concepto, String usuario);

	public Boolean tieneAccesoSysAdm(String aplicacioncodigo, String usuario);

	public Boolean tieneAccesoSecAdm(String aplicacioncodigo, String usuario);

	/**
	 * f_sql_read_user_autorizacion
	 */
	public Integer leerAutorizaciones(String par_aplicacion, String par_grupo,
			String par_concepto, String par_user);

	public SeguridadOperaciones leerOpciones(String aplicacion, String grupo,
			String concepto, String usuario);

}
