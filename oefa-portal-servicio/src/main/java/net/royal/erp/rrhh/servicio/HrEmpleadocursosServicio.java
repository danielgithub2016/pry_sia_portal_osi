package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEmpleadocursos;
import net.royal.framework.web.controladora.UIMantenimientoController.accion_solicitada;
import net.royal.framework.web.dominio.MensajeUsuario;
import net.royal.framework.web.servicio.GenericoServicio;

/**
 * @author nunezh
 *
 */
public interface HrEmpleadocursosServicio extends GenericoServicio {
	public List<MensajeUsuario> validar(accion_solicitada accionPantalla, HrEmpleadocursos bean);

	public List<HrEmpleadocursos> listarPorEmpleado(Integer empleado,String curso,String capacitaciones);
	public List<HrEmpleadocursos> listarPorEmpleadoMateriales(String curso);

}