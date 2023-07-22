package net.royal.erp.rrhh.servicio;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import net.royal.erp.rrhh.dominio.HrCapacitacion;
import net.royal.erp.rrhh.dominio.HrEmpleadocapaDocumento;
import net.royal.erp.rrhh.dominio.HrEmpleadocapacitacion;
import net.royal.framework.web.dominio.MensajeUsuario;
import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrEmpleadocapacitacionServicio extends GenericoServicio {
	@Transactional
	public List<MensajeUsuario> ingresarInscripcion(HrCapacitacion capa, UsuarioActual usuario);

	@Transactional
	public List<MensajeUsuario> ingresarDocumentoPendiente(HrCapacitacion capa, UsuarioActual usuario, int tipo,
			HrEmpleadocapaDocumento doc);
	
	public List<HrEmpleadocapacitacion> contarCapacitacionDocumentoPendiente(Integer empleado, Integer dias_revision);
	
	public List<HrEmpleadocapacitacion> obtenerPorCapacitacion(String capacitacion);

}
