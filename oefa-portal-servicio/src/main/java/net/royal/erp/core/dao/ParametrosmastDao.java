package net.royal.erp.core.dao;

import java.math.BigDecimal;

import net.royal.erp.core.dominio.Parametrosmast;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.framework.web.dao.GenericoDao;

public interface ParametrosmastDao extends
		GenericoDao<Parametrosmast, ParametrosmastPk> {
	
	public String obtenerValorCadena(String parametroclave);
	
	public String obtenerValorCadena(ParametrosmastPk pk);
	
	public Integer obtenerValorInteger(ParametrosmastPk pk);
	
	public String obtenerValorDescripcion(ParametrosmastPk pk);
	
	public BigDecimal obtenerValorDecimal(ParametrosmastPk pk);
	
	public String obtenerValorExplicacion(ParametrosmastPk pk);
	
	
	/**
	 * f_calculate_igv_difference
	 */
	public String calcularIGVDiferencia(BigDecimal par_montoafecto,
			BigDecimal par_montoigv, BigDecimal str_global_gvigv);
}
