package net.royal.erp.asistencia.dao;

import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.dominio.AsAccesosdiarios;
import net.royal.erp.asistencia.dominio.AsAccesosdiariosPk;
import net.royal.framework.web.dao.GenericoDao;

public interface AsAccesosdiariosDao extends
		GenericoDao<AsAccesosdiarios, AsAccesosdiariosPk> {

	public List<AsAccesosdiarios> listarAsMarcar(String w_carnet,
			Date fechadesde, Date fechahasta);

	public Integer obtenerEmpleado(String w_carnet, Date w_fecha);

	public Integer obtenerTerminal(Integer empleado, Date fecha);

	public void eliminarPorCamposA(Integer empleadoA, Date fechaA,
			String conceptoaccesoA, Date fechadesdeA);

	public Integer incrementarPorEmpleadoFecha(Integer empleado, Date fecha);

	public void eliminarPorEmpleadoFecha(Integer empleado, Date fecha);

	/**
	 * @powerbuilder dw_as_marcas_empleado
	 * @param Integer empleado
	 * @param Date fechaA
	 * @param Date fechaB
	 * @return
	 */
	public List<AsAccesosdiarios> listarAccesosdiariosxparam(Integer empleado,
			Date fechaA, Date fechaB);

}
