package net.royal.seguridad.dao;

import java.util.List;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.seguridad.dominio.Seguridadautorizaciones;
import net.royal.seguridad.dominio.SeguridadautorizacionesPk;
import net.royal.seguridad.dominio.Seguridadperfilusuario;

public interface SeguridadautorizacionesDao extends GenericoDao<Seguridadautorizaciones, SeguridadautorizacionesPk> {

	public Seguridadautorizaciones obtenerSeguridadUsuarioporConcepto(String usuario, String grupo, String concepto,
			String aplicacioncodigo);

	/**
	 * f_sql_read_user_autorizacion
	 */
	public Integer leerAutorizaciones(String par_aplicacion, String par_grupo, String par_concepto, String par_user);

	public List<Seguridadautorizaciones> listarActivosXPerfilesUsuario(String codigoAplicacion, String usuario,
			List<Seguridadperfilusuario> listaPerfiles);

	/**
	 * f_sql_read_user_autorizacion02
	 */
	public Seguridadautorizaciones leerAutorizacionesPerfil(String par_aplicacion, String par_grupo,
			String par_concepto, String par_user);

	public List<Seguridadautorizaciones> leerAutorizacionesPerfil2(String par_aplicacion, String par_grupo,
			String par_concepto, String par_user);
}
