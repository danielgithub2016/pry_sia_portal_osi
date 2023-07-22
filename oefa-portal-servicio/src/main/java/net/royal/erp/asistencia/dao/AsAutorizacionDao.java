package net.royal.erp.asistencia.dao;

import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.dominio.AsAutorizacion;
import net.royal.erp.asistencia.dominio.AsAutorizacionPk;
import net.royal.erp.asistencia.dominio.dto.DtoAsAutorizacion;
import net.royal.framework.web.dao.GenericoDao;

public interface AsAutorizacionDao extends GenericoDao<AsAutorizacion, AsAutorizacionPk> {

	public Date obtenerMaxFecha(Integer empleado, Integer anio, Date fecha);

	public Integer obtenerVeces(Integer empleado, Integer anio, Date fecha);

	public List<DtoAsAutorizacion> generarAsistenciaOnomastico() throws Exception;

}
