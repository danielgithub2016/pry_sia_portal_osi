package net.royal.erp.asistencia.dao;

import java.util.List;

import net.royal.erp.asistencia.dominio.AsArea;
import net.royal.erp.asistencia.dominio.AsAreaPk;
import net.royal.framework.web.dao.GenericoDao;

public interface AsAreaDao extends GenericoDao<AsArea, AsAreaPk> {

	public List<AsArea> listaComboAreaServicio();

	public String obtenerAreaOperativa(Integer par_empleado, String par_compania);

	public AsArea obtenerArea(Integer par_empleado, String par_compania);

	public AsArea obtenerAreaEmpleadoResponsable(Integer empleado);
}
