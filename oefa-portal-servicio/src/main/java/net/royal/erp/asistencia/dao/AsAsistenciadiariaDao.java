package net.royal.erp.asistencia.dao;

import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.dominio.AsAsistenciadiaria;
import net.royal.erp.asistencia.dominio.AsAsistenciadiariaPk;
import net.royal.framework.web.dao.GenericoDao;

public interface AsAsistenciadiariaDao extends GenericoDao<AsAsistenciadiaria, AsAsistenciadiariaPk> {
	public List obtenerEmpleadosSeleccionados(Date p_fecha_desde,Date p_fecha_hasta,String p_flag_periodo,Integer p_sid,String p_seleccionadosAdicionados);

}
