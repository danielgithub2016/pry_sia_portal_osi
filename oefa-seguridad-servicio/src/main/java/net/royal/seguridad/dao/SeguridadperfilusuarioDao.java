package net.royal.seguridad.dao;

import java.util.List;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.seguridad.dominio.Seguridadperfilusuario;
import net.royal.seguridad.dominio.SeguridadperfilusuarioPk;
import net.royal.seguridad.dominio.Usuario;

public interface SeguridadperfilusuarioDao extends
		GenericoDao<Seguridadperfilusuario, SeguridadperfilusuarioPk> {

	public List<Seguridadperfilusuario> listarPerfilActivoXUsuario(String usuario);
	public Usuario obtenerUsuarioPorPerfil(String userid);
	
}
