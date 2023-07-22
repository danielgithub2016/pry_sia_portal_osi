package net.royal.erp.core.servicio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.dominio.dto.DtoTablaNuevaBandeja;
import net.royal.erp.core.dominio.Personamast;
import net.royal.erp.core.dominio.dto.DtoPersonamast;
import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.servicio.GenericoServicio;

public interface PersonamastServicio extends GenericoServicio {
	
	public Personamast obtenerporPersona(Integer persona);
	
	public Personamast obtenerporPersonaAnt(String personaAnt);
	/**
	 * f_sql_read_persona_name
	 */
	public String obtenerNombrePersona(BigDecimal codigoPersona);
	/**
	 * dw_ma_cp_empleadoautorizado_select
	 */
	public List obtenerEmpleadosAutorizados();
	public Integer obtenerPersonaxRUC(String  par_documentoFiscal);
	public Integer FSqlValidatePersonaUnidadnegocio(Integer par_persona,String par_unidadnegocio);
	
	public ParametroPaginacion DwMaPersonaSelectByBusquedaPaginacion(
			ParametroPaginacion paginacion);

	public List<DtoPersonamast> filtrofecha(Date fecha,Date fecha2);
	
	public List<DtoPersonamast> filtroTodo();
	
	public List DwWhImportacionSelect(String companiasocio);
	
	public List DwWhImportacionSelectBlDetail(String companiasocio,
			String blnumero);
	
	public DtoTablaNuevaBandeja obtenerDatosParaNuevaBandeja(String usuarioRed);
		
}
