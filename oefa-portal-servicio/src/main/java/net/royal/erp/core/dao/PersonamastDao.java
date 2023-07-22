package net.royal.erp.core.dao;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.core.dominio.Personamast;
import net.royal.erp.core.dominio.PersonamastPk;
import net.royal.framework.web.dao.GenericoDao;

public interface PersonamastDao extends GenericoDao<Personamast, PersonamastPk> {

	public Personamast obtenerporPersona(Integer persona);
	
	/**
	 * @powerbuilder selectSueltoItemChanged 
	 * @param personaAnt
	 * @return
	 */
	public Personamast obtenerporPersonaAnt(String personaAnt);
	
	/**
	 * f_sql_read_persona_name
	 */
	public String obtenerNombrePersona(BigDecimal codigoPersona);
	
	
	public Integer obtenerPersonaxRUC(String  par_documentoFiscal);
	
	/**
	 * dw_ma_cp_empleadoautorizado_select
	 */
	public List obtenerEmpleadosAutorizados();
	
	public Personamast obtenerPersonaxUnidadNegocio();
	
}
