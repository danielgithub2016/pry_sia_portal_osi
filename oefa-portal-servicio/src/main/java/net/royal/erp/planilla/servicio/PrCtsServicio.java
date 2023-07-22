package net.royal.erp.planilla.servicio;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.planilla.dominio.dto.DtoDwPrCtsList;
import net.royal.framework.web.servicio.GenericoServicio;

public interface PrCtsServicio extends GenericoServicio {

	public List<DtoDwPrCtsList> listarCtsEmpleado(String compania,BigDecimal cts, BigDecimal ctsfinal,
			String moneda, String estadoempleado);
	
	public String obtenerSentencia();
	
	public String obtenerMontoTotalLetras(String empleado, BigDecimal cts); 
	
	public String obtenerRemuneracionLetras(String empleado, BigDecimal cts); 
	
	public List obtenerLiquidacion(String empleado, BigDecimal ctsinicio,BigDecimal ctsfinal); 
	
	public List listarRequerimientoWhere(String sb,Integer cts,Integer ctsfinal);
	
	public List listarRequerimientoWhere2(String sb,BigDecimal cts,BigDecimal ctsfinal);
}
