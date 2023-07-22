package net.royal.erp.asistencia.servicio;

import java.util.List;

import net.royal.erp.asistencia.dominio.AsArea;
import net.royal.framework.web.servicio.GenericoServicio;

public interface AsAreaServicio extends GenericoServicio {

	public List<AsArea> listaComboAreaServicio();

	public Integer obtenerEmpleadoResponsable(Integer empleado);

	public String obtenerAreaOperativa(Integer par_empleado, String par_compania);

	public AsArea obtenerArea(Integer par_empleado, String par_compania);

	public AsArea obtenerAreaEmpleadoResponsable(Integer empleado);

	public Integer contarResponsablesArea(Integer empleado, String compania);
}
