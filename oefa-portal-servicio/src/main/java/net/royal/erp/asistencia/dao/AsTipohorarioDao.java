package net.royal.erp.asistencia.dao;

import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.dominio.AsTipohorario;
import net.royal.erp.asistencia.dominio.AsTipohorarioPk;
import net.royal.framework.web.dao.GenericoDao;

public interface AsTipohorarioDao extends
		GenericoDao<AsTipohorario, AsTipohorarioPk> {

	public Integer devuelveHorario(Integer parEmpleado, Date parFecha);

	public String obtenerDescripcionLocal(Integer tipohorario);
	
	/**
	 * @powerbuilder dddw_as_tipohorario_select
	 * @return lista
	 */
	public List<AsTipohorario> listarTipoHorarioOrden();

}
