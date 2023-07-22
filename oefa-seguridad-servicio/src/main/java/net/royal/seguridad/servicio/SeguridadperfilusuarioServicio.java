package net.royal.seguridad.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.seguridad.dominio.Seguridadperfilusuario;
import net.royal.seguridad.dominio.Usuario;

public interface SeguridadperfilusuarioServicio extends GenericoServicio {

	/**
	 * Obtener lista perfiles usuario.
	 *@author nunezh
	 * @param userid el código de usuario
	 * @return el  usuario
	 * @powerbuilder f_sql_get_usuarioxperfil
	 */
	public Usuario obtenerUsuarioPorPerfil(String userid);
	
	public List<Seguridadperfilusuario> listarPerfilActivoXUsuario(
			String usuario) ;
	
	public List<Usuario> fSqlGetUsuarioxPerfil(String userid);
	
}
