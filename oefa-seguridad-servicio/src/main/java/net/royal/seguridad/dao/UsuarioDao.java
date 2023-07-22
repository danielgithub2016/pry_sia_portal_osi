package net.royal.seguridad.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.seguridad.dominio.Usuario;
import net.royal.seguridad.dominio.UsuarioPk;

import java.util.List;

public interface UsuarioDao extends GenericoDao<Usuario, UsuarioPk> {

	/**
	 * @powerbuilder dw_ma_seguridadperfilusuario_select
	 * @param usuarioperfil
	 * @return Lista
	 */
	public List<Usuario> ListarUsuariosxPerfil(String usuarioperfil);
	
	/**
	 * 
	 * @param usuario
	 * @return
	 */
	public List<Usuario> listarCierreDiario(String usuario);
}
