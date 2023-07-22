package net.royal.seguridad.servicio;

import java.util.List;

import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.seguridad.dominio.Usuario;
import net.royal.seguridad.dominio.dto.DtoMenu;

public interface UsuarioServicio extends GenericoServicio {
	
	public List<DtoMenu> listarMenuPorUsuarioRoyal(String codigoAplicacion,List<DtoMenu> lstMenuPortal,
			String usuario);
	
	public List<DtoMenu> listarMenuPorUsuario(String codigoAplicacion,
			String usuario);
	
	/*public List<DtoMenu> listarMenuPorUsuario2(String codigoAplicacion,
			String usuario);*/
	
	public UsuarioActual traerDatosEmpleadoLogin(String usuario);

	public UsuarioActual traerDatosEmpleadoDocumentoPersona(String nroDocumento);
	
	public List<Usuario> listarOracleCursor(String usuario);
	
	public Boolean listarUsuarioIguales(String usuario,
            String nombrAccion);
	
	public Integer contarPerfilAdministradorFicha(String usuario);
	
	public Integer contarPerfilAdministradorEmpleados(String usuario);
	
	public List<Usuario> ListarUsuariosxPerfil(String usuarioperfil);
	
	public List<Usuario> listarCierreDiario(String usuario);

	public UsuarioActual traerDatosOtroLogin(String upperCase);
}
