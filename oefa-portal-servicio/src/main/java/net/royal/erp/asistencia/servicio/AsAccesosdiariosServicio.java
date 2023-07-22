package net.royal.erp.asistencia.servicio;

import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.dominio.AsAccesosdiarios;
import net.royal.erp.asistencia.dominio.dto.DtoDwAsRep001MarcaEmpleado;
import net.royal.framework.web.servicio.GenericoServicio;

public interface AsAccesosdiariosServicio extends GenericoServicio {

	public Integer obtenerTerminal(Integer empleado, Date fecha);

	public void eliminarAccesosDiarios(Integer empleado, Date fecha, String conceptoacceso, Date fechadesde);

	public Integer obtenerMaximoSecuencia(Integer empleado, Date fecha);

	public void insertarAccesosDiarios(String carnet, Date fecha, Integer secuencia, Integer empleado,
			String observacion, Integer anio, Integer mes, Integer dia, String userid);

	public List<AsAccesosdiarios> listarAsMarcar(String w_carnet, Date fechadesde, Date fechahasta);

	public Integer obtenerEmpleado(String w_carnet, Date w_fecha);

	public void eliminarPorEmpleadoFecha(Integer empleado, Date fecha);

	public List<AsAccesosdiarios> listarAccesosdiariosxparam(Integer empleado, Date fechaA, Date fechaB);

	public List<DtoDwAsRep001MarcaEmpleado> listarmarcacionXemplado(Integer user, String empleado, Date fechaini,
			Date fechafin, String flgadmin, Integer sid, String codigousuario) throws Exception;

	public void eliminarmarcacionsobretiempo(Integer empleado, Date fecha, String conceptoacceso);
}
