package net.royal.erp.planilla.servicio;

import java.util.List;

import net.royal.erp.planilla.dominio.dto.DtoVacacionBoleta;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.GenericoServicio;

public interface PrPlanillaEmpleadoServicio extends GenericoServicio {
	
	@SuppressWarnings("rawtypes")
	public List listarBoletasEmpleado(List<ParametroPersistenciaGenerico> filtros);
	@SuppressWarnings("rawtypes")
	public List listarDetalleBoleta(List<ParametroPersistenciaGenerico> filtros);
	@SuppressWarnings("rawtypes")
	public List listarDetalleBoletaEncabezado(List<ParametroPersistenciaGenerico> filtros);
	@SuppressWarnings("rawtypes")
	public List listarEmpleadosCertificado(StringBuilder SQL);
	@SuppressWarnings("rawtypes")
	public List obtenerResponsable(StringBuilder SQL);
	@SuppressWarnings("rawtypes")
	public List obtenerNumResponsable(StringBuilder SQL);
	@SuppressWarnings("rawtypes")
	public List obtenerDeduccion(StringBuilder SQL);
	public String obtenerAcumuladoRetencionLetras(String compania, String planilla, String ejerciciofiscal, String empleado);
	public String obtenerTituloAnio(String anio);
	public String obtenerTotalNetoLetras(String compania, String empleado, String periodo, String planilla, String proceso);
	public List<DtoVacacionBoleta> obtenerFechasVacacionBoleta(String periodo, Integer empleado);
	public String obtenerMonedaLocal();
}
