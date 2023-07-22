package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.erp.core.dominio.dto.DtoCompaniamast;
import net.royal.framework.web.servicio.GenericoServicio;

public interface CompaniamastServicio extends GenericoServicio {
	/**
	 * f_sql_read_company_name
	 */
	public String obtenerNombreCompania(String par_company);
	
	/**
	 * Lista compania seguridad por usuario.
	 *
	 * @param Usuario the usuario
	 * @return the list
	 * @powerbuilder dw_ma_companyowner_select_security
	 */
	public List<DtoCompaniamast> listaCompaniaSeguridadPorUsuario(String Usuario);
}
