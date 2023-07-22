package net.royal.erp.asistencia.servicio;

import java.util.Date;
import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

public interface AsAsistenciadiariaServicio extends GenericoServicio {
	
	public List obtenerEmpleadosSeleccionados(Date p_fecha_desde,Date p_fecha_hasta,String p_flag_periodo,Integer p_sid,String p_seleccionadosAdicionados);

}
