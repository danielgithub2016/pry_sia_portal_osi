package net.royal.seguridad.servicio;

import java.util.List;

import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.seguridad.dominio.Clientemast;
import net.royal.seguridad.dominio.ClientemastPk;
import net.royal.seguridad.dominio.dto.DtoClientemast;

public interface ClientemastServicio extends GenericoServicio {

	public List<DtoClientemast> listarClientesPorUsuarioActual(
			UsuarioActual usuarioActual);
	
}
